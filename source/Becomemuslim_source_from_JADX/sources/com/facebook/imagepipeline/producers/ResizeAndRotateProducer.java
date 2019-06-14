package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.TriState;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.nativecode.JpegTranscoder;
import com.facebook.imagepipeline.producers.JobScheduler.JobRunnable;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public class ResizeAndRotateProducer implements Producer<EncodedImage> {
    @VisibleForTesting
    static final int DEFAULT_JPEG_QUALITY = 85;
    private static final String DOWNSAMPLE_ENUMERATOR_KEY = "downsampleEnumerator";
    private static final String FRACTION_KEY = "Fraction";
    private static final int FULL_ROUND = 360;
    private static final ImmutableList<Integer> INVERTED_EXIF_ORIENTATIONS = ImmutableList.of(Integer.valueOf(2), Integer.valueOf(7), Integer.valueOf(4), Integer.valueOf(5));
    @VisibleForTesting
    static final int MAX_JPEG_SCALE_NUMERATOR = 8;
    @VisibleForTesting
    static final int MIN_TRANSFORM_INTERVAL_MS = 100;
    private static final String ORIGINAL_SIZE_KEY = "Original size";
    public static final String PRODUCER_NAME = "ResizeAndRotateProducer";
    private static final String REQUESTED_SIZE_KEY = "Requested size";
    private static final String ROTATION_ANGLE_KEY = "rotationAngle";
    private static final String SOFTWARE_ENUMERATOR_KEY = "softwareEnumerator";
    private final Executor mExecutor;
    private final Producer<EncodedImage> mInputProducer;
    private final PooledByteBufferFactory mPooledByteBufferFactory;
    private final boolean mResizingEnabled;
    private final boolean mUseDownsamplingRatio;

    private class TransformingConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        private boolean mIsCancelled = false;
        private final JobScheduler mJobScheduler;
        private final ProducerContext mProducerContext;

        public TransformingConsumer(final Consumer<EncodedImage> consumer, ProducerContext producerContext) {
            super(consumer);
            this.mProducerContext = producerContext;
            this.mJobScheduler = new JobScheduler(ResizeAndRotateProducer.this.mExecutor, new JobRunnable(ResizeAndRotateProducer.this) {
                public void run(EncodedImage encodedImage, int i) {
                    TransformingConsumer.this.doTransform(encodedImage, i);
                }
            }, 100);
            this.mProducerContext.addCallbacks(new BaseProducerContextCallbacks(ResizeAndRotateProducer.this) {
                public void onIsIntermediateResultExpectedChanged() {
                    if (TransformingConsumer.this.mProducerContext.isIntermediateResultExpected()) {
                        TransformingConsumer.this.mJobScheduler.scheduleJob();
                    }
                }

                public void onCancellationRequested() {
                    TransformingConsumer.this.mJobScheduler.clearJob();
                    TransformingConsumer.this.mIsCancelled = true;
                    consumer.onCancellation();
                }
            });
        }

        protected void onNewResultImpl(EncodedImage encodedImage, int i) {
            if (!this.mIsCancelled) {
                boolean isLast = BaseConsumer.isLast(i);
                if (encodedImage == null) {
                    if (isLast) {
                        getConsumer().onNewResult(0, 1);
                    }
                    return;
                }
                TriState access$600 = ResizeAndRotateProducer.shouldTransform(this.mProducerContext.getImageRequest(), encodedImage, ResizeAndRotateProducer.this.mResizingEnabled);
                if (!isLast && access$600 == TriState.UNSET) {
                    return;
                }
                if (access$600 != TriState.YES) {
                    if (!(this.mProducerContext.getImageRequest().getRotationOptions().canDeferUntilRendered() || encodedImage.getRotationAngle() == 0 || encodedImage.getRotationAngle() == -1)) {
                        encodedImage = moveImage(encodedImage);
                        encodedImage.setRotationAngle(0);
                    }
                    getConsumer().onNewResult(encodedImage, i);
                } else if (this.mJobScheduler.updateJob(encodedImage, i) != null) {
                    if (isLast || this.mProducerContext.isIntermediateResultExpected() != null) {
                        this.mJobScheduler.scheduleJob();
                    }
                }
            }
        }

        private EncodedImage moveImage(EncodedImage encodedImage) {
            EncodedImage cloneOrNull = EncodedImage.cloneOrNull(encodedImage);
            encodedImage.close();
            return cloneOrNull;
        }

        private void doTransform(EncodedImage encodedImage, int i) {
            InputStream inputStream;
            Map extraMap;
            Throwable e;
            int i2;
            EncodedImage encodedImage2 = encodedImage;
            this.mProducerContext.getListener().onProducerStart(this.mProducerContext.getId(), ResizeAndRotateProducer.PRODUCER_NAME);
            ImageRequest imageRequest = this.mProducerContext.getImageRequest();
            OutputStream newOutputStream = ResizeAndRotateProducer.this.mPooledByteBufferFactory.newOutputStream();
            Map map = null;
            try {
                int access$800 = ResizeAndRotateProducer.getSoftwareNumerator(imageRequest, encodedImage2, ResizeAndRotateProducer.this.mResizingEnabled);
                int determineSampleSize = DownsampleUtil.determineSampleSize(imageRequest, encodedImage2);
                int calculateDownsampleNumerator = ResizeAndRotateProducer.calculateDownsampleNumerator(determineSampleSize);
                int i3 = ResizeAndRotateProducer.this.mUseDownsamplingRatio ? calculateDownsampleNumerator : access$800;
                inputStream = encodedImage.getInputStream();
                try {
                    int access$1100;
                    if (ResizeAndRotateProducer.INVERTED_EXIF_ORIENTATIONS.contains(Integer.valueOf(encodedImage.getExifOrientation()))) {
                        access$1100 = ResizeAndRotateProducer.getForceRotatedInvertedExifOrientation(imageRequest.getRotationOptions(), encodedImage2);
                        extraMap = getExtraMap(encodedImage, imageRequest, i3, calculateDownsampleNumerator, access$800, 0);
                        try {
                            JpegTranscoder.transcodeJpegWithExifOrientation(inputStream, newOutputStream, access$1100, i3, 85);
                        } catch (Exception e2) {
                            e = e2;
                            i2 = i;
                            map = extraMap;
                            try {
                                r8.mProducerContext.getListener().onProducerFinishWithFailure(r8.mProducerContext.getId(), ResizeAndRotateProducer.PRODUCER_NAME, e, map);
                                if (BaseConsumer.isLast(i2)) {
                                    getConsumer().onFailure(e);
                                }
                                Closeables.closeQuietly(inputStream);
                                newOutputStream.close();
                            } catch (Throwable th) {
                                e = th;
                                Closeables.closeQuietly(inputStream);
                                newOutputStream.close();
                                throw e;
                            }
                        }
                    }
                    access$1100 = ResizeAndRotateProducer.getRotationAngle(imageRequest.getRotationOptions(), encodedImage2);
                    extraMap = getExtraMap(encodedImage, imageRequest, i3, calculateDownsampleNumerator, access$800, access$1100);
                    JpegTranscoder.transcodeJpeg(inputStream, newOutputStream, access$1100, i3, 85);
                    map = extraMap;
                    CloseableReference of = CloseableReference.of(newOutputStream.toByteBuffer());
                    try {
                        EncodedImage encodedImage3 = new EncodedImage(of);
                        encodedImage3.setImageFormat(DefaultImageFormats.JPEG);
                        try {
                            encodedImage3.parseMetaData();
                            r8.mProducerContext.getListener().onProducerFinishWithSuccess(r8.mProducerContext.getId(), ResizeAndRotateProducer.PRODUCER_NAME, map);
                            i2 = determineSampleSize != 1 ? i | 16 : i;
                            try {
                                getConsumer().onNewResult(encodedImage3, i2);
                            } catch (Throwable th2) {
                                e = th2;
                                EncodedImage.closeSafely(encodedImage3);
                                throw e;
                            }
                        } catch (Throwable th3) {
                            e = th3;
                            i2 = i;
                            EncodedImage.closeSafely(encodedImage3);
                            throw e;
                        }
                        try {
                            EncodedImage.closeSafely(encodedImage3);
                            try {
                                CloseableReference.closeSafely(of);
                                Closeables.closeQuietly(inputStream);
                                newOutputStream.close();
                            } catch (Exception e3) {
                                e = e3;
                                r8.mProducerContext.getListener().onProducerFinishWithFailure(r8.mProducerContext.getId(), ResizeAndRotateProducer.PRODUCER_NAME, e, map);
                                if (BaseConsumer.isLast(i2)) {
                                    getConsumer().onFailure(e);
                                }
                                Closeables.closeQuietly(inputStream);
                                newOutputStream.close();
                            }
                        } catch (Throwable th4) {
                            e = th4;
                            CloseableReference.closeSafely(of);
                            throw e;
                        }
                    } catch (Throwable th5) {
                        e = th5;
                        i2 = i;
                        CloseableReference.closeSafely(of);
                        throw e;
                    }
                } catch (Exception e4) {
                    e = e4;
                    i2 = i;
                    r8.mProducerContext.getListener().onProducerFinishWithFailure(r8.mProducerContext.getId(), ResizeAndRotateProducer.PRODUCER_NAME, e, map);
                    if (BaseConsumer.isLast(i2)) {
                        getConsumer().onFailure(e);
                    }
                    Closeables.closeQuietly(inputStream);
                    newOutputStream.close();
                }
            } catch (Exception e5) {
                e = e5;
                i2 = i;
                inputStream = null;
                r8.mProducerContext.getListener().onProducerFinishWithFailure(r8.mProducerContext.getId(), ResizeAndRotateProducer.PRODUCER_NAME, e, map);
                if (BaseConsumer.isLast(i2)) {
                    getConsumer().onFailure(e);
                }
                Closeables.closeQuietly(inputStream);
                newOutputStream.close();
            } catch (Throwable th6) {
                e = th6;
                inputStream = null;
                Closeables.closeQuietly(inputStream);
                newOutputStream.close();
                throw e;
            }
        }

        private Map<String, String> getExtraMap(EncodedImage encodedImage, ImageRequest imageRequest, int i, int i2, int i3, int i4) {
            if (!this.mProducerContext.getListener().requiresExtraMap(this.mProducerContext.getId())) {
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(encodedImage.getWidth());
            stringBuilder.append("x");
            stringBuilder.append(encodedImage.getHeight());
            encodedImage = stringBuilder.toString();
            if (imageRequest.getResizeOptions() != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(imageRequest.getResizeOptions().width);
                stringBuilder.append("x");
                stringBuilder.append(imageRequest.getResizeOptions().height);
                imageRequest = stringBuilder.toString();
            } else {
                imageRequest = "Unspecified";
            }
            if (i > 0) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(i);
                stringBuilder.append("/8");
                i = stringBuilder.toString();
            } else {
                i = "";
            }
            Map hashMap = new HashMap();
            hashMap.put(ResizeAndRotateProducer.ORIGINAL_SIZE_KEY, encodedImage);
            hashMap.put(ResizeAndRotateProducer.REQUESTED_SIZE_KEY, imageRequest);
            hashMap.put(ResizeAndRotateProducer.FRACTION_KEY, i);
            hashMap.put("queueTime", String.valueOf(this.mJobScheduler.getQueuedTime()));
            hashMap.put(ResizeAndRotateProducer.DOWNSAMPLE_ENUMERATOR_KEY, Integer.toString(i2));
            hashMap.put(ResizeAndRotateProducer.SOFTWARE_ENUMERATOR_KEY, Integer.toString(i3));
            hashMap.put(ResizeAndRotateProducer.ROTATION_ANGLE_KEY, Integer.toString(i4));
            return ImmutableMap.copyOf(hashMap);
        }
    }

    @VisibleForTesting
    static int roundNumerator(float f, float f2) {
        return (int) (f2 + (f * 8.0f));
    }

    private static boolean shouldResize(int i) {
        return i < 8;
    }

    public ResizeAndRotateProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, boolean z, Producer<EncodedImage> producer, boolean z2) {
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
        this.mPooledByteBufferFactory = (PooledByteBufferFactory) Preconditions.checkNotNull(pooledByteBufferFactory);
        this.mResizingEnabled = z;
        this.mInputProducer = (Producer) Preconditions.checkNotNull(producer);
        this.mUseDownsamplingRatio = z2;
    }

    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        this.mInputProducer.produceResults(new TransformingConsumer(consumer, producerContext), producerContext);
    }

    private static TriState shouldTransform(ImageRequest imageRequest, EncodedImage encodedImage, boolean z) {
        if (encodedImage != null) {
            if (encodedImage.getImageFormat() != ImageFormat.UNKNOWN) {
                if (encodedImage.getImageFormat() != DefaultImageFormats.JPEG) {
                    return TriState.NO;
                }
                boolean z2;
                if (!shouldRotate(imageRequest.getRotationOptions(), encodedImage)) {
                    if (shouldResize(getSoftwareNumerator(imageRequest, encodedImage, z)) == null) {
                        z2 = null;
                        return TriState.valueOf(z2);
                    }
                }
                z2 = true;
                return TriState.valueOf(z2);
            }
        }
        return TriState.UNSET;
    }

    @VisibleForTesting
    static float determineResizeRatio(ResizeOptions resizeOptions, int i, int i2) {
        if (resizeOptions == null) {
            return 1.0f;
        }
        i = (float) i;
        i2 = (float) i2;
        float max = Math.max(((float) resizeOptions.width) / i, ((float) resizeOptions.height) / i2);
        if (i * max > resizeOptions.maxBitmapSize) {
            max = resizeOptions.maxBitmapSize / i;
        }
        if (i2 * max > resizeOptions.maxBitmapSize) {
            max = resizeOptions.maxBitmapSize / i2;
        }
        return max;
    }

    private static int getSoftwareNumerator(ImageRequest imageRequest, EncodedImage encodedImage, boolean z) {
        if (!z) {
            return 8;
        }
        z = imageRequest.getResizeOptions();
        if (!z) {
            return 8;
        }
        int rotationAngle = getRotationAngle(imageRequest.getRotationOptions(), encodedImage);
        Object obj = null;
        imageRequest = INVERTED_EXIF_ORIENTATIONS.contains(Integer.valueOf(encodedImage.getExifOrientation())) ? getForceRotatedInvertedExifOrientation(imageRequest.getRotationOptions(), encodedImage) : null;
        if (rotationAngle == 90 || rotationAngle == RotationOptions.ROTATE_270 || imageRequest == 5 || imageRequest == 7) {
            obj = 1;
        }
        if (obj != null) {
            imageRequest = encodedImage.getHeight();
        } else {
            imageRequest = encodedImage.getWidth();
        }
        if (obj != null) {
            encodedImage = encodedImage.getWidth();
        } else {
            encodedImage = encodedImage.getHeight();
        }
        imageRequest = roundNumerator(determineResizeRatio(z, imageRequest, encodedImage), z.roundUpFraction);
        if (imageRequest > 8) {
            return 8;
        }
        if (imageRequest < 1) {
            imageRequest = true;
        }
        return imageRequest;
    }

    private static int getRotationAngle(RotationOptions rotationOptions, EncodedImage encodedImage) {
        if (!rotationOptions.rotationEnabled()) {
            return null;
        }
        encodedImage = extractOrientationFromMetadata(encodedImage);
        if (rotationOptions.useImageMetadata()) {
            return encodedImage;
        }
        return (encodedImage + rotationOptions.getForcedAngle()) % FULL_ROUND;
    }

    private static int getForceRotatedInvertedExifOrientation(RotationOptions rotationOptions, EncodedImage encodedImage) {
        encodedImage = INVERTED_EXIF_ORIENTATIONS.indexOf(Integer.valueOf(encodedImage.getExifOrientation()));
        if (encodedImage >= null) {
            int i = 0;
            if (!rotationOptions.useImageMetadata()) {
                i = rotationOptions.getForcedAngle();
            }
            return ((Integer) INVERTED_EXIF_ORIENTATIONS.get((encodedImage + (i / 90)) % INVERTED_EXIF_ORIENTATIONS.size())).intValue();
        }
        throw new IllegalArgumentException("Only accepts inverted exif orientations");
    }

    private static int extractOrientationFromMetadata(EncodedImage encodedImage) {
        int rotationAngle = encodedImage.getRotationAngle();
        if (rotationAngle == 90 || rotationAngle == RotationOptions.ROTATE_180 || rotationAngle == RotationOptions.ROTATE_270) {
            return encodedImage.getRotationAngle();
        }
        return null;
    }

    private static boolean shouldRotate(RotationOptions rotationOptions, EncodedImage encodedImage) {
        return (rotationOptions.canDeferUntilRendered() || (getRotationAngle(rotationOptions, encodedImage) == 0 && shouldRotateUsingExifOrientation(rotationOptions, encodedImage) == null)) ? null : true;
    }

    private static boolean shouldRotateUsingExifOrientation(RotationOptions rotationOptions, EncodedImage encodedImage) {
        if (rotationOptions.rotationEnabled()) {
            if (rotationOptions.canDeferUntilRendered() == null) {
                return INVERTED_EXIF_ORIENTATIONS.contains(Integer.valueOf(encodedImage.getExifOrientation()));
            }
        }
        encodedImage.setExifOrientation(0);
        return false;
    }

    @VisibleForTesting
    static int calculateDownsampleNumerator(int i) {
        return Math.max(1, 8 / i);
    }
}
