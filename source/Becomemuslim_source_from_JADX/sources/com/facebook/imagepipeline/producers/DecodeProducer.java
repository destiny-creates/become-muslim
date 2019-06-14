package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.ExceptionWithNoStacktrace;
import com.facebook.common.util.UriUtil;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.decoder.DecodeException;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegParser;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.producers.JobScheduler.JobRunnable;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public class DecodeProducer implements Producer<CloseableReference<CloseableImage>> {
    public static final String ENCODED_IMAGE_SIZE = "encodedImageSize";
    public static final String EXTRA_BITMAP_SIZE = "bitmapSize";
    public static final String EXTRA_HAS_GOOD_QUALITY = "hasGoodQuality";
    public static final String EXTRA_IMAGE_FORMAT_NAME = "imageFormat";
    public static final String EXTRA_IS_FINAL = "isFinal";
    public static final String PRODUCER_NAME = "DecodeProducer";
    public static final String REQUESTED_IMAGE_SIZE = "requestedImageSize";
    public static final String SAMPLE_SIZE = "sampleSize";
    private final ByteArrayPool mByteArrayPool;
    private final boolean mDecodeCancellationEnabled;
    private final boolean mDownsampleEnabled;
    private final boolean mDownsampleEnabledForNetwork;
    private final Executor mExecutor;
    private final ImageDecoder mImageDecoder;
    private final Producer<EncodedImage> mInputProducer;
    private final ProgressiveJpegConfig mProgressiveJpegConfig;

    private abstract class ProgressiveDecoder extends DelegatingConsumer<EncodedImage, CloseableReference<CloseableImage>> {
        private static final int DECODE_EXCEPTION_MESSAGE_NUM_HEADER_BYTES = 10;
        private final String TAG = "ProgressiveDecoder";
        private final ImageDecodeOptions mImageDecodeOptions;
        private boolean mIsFinished;
        private final JobScheduler mJobScheduler;
        private final ProducerContext mProducerContext;
        private final ProducerListener mProducerListener;

        protected abstract int getIntermediateImageEndOffset(EncodedImage encodedImage);

        protected abstract QualityInfo getQualityInfo();

        public ProgressiveDecoder(Consumer<CloseableReference<CloseableImage>> consumer, final ProducerContext producerContext, final boolean z) {
            super(consumer);
            this.mProducerContext = producerContext;
            this.mProducerListener = producerContext.getListener();
            this.mImageDecodeOptions = producerContext.getImageRequest().getImageDecodeOptions();
            this.mIsFinished = null;
            this.mJobScheduler = new JobScheduler(DecodeProducer.this.mExecutor, new JobRunnable(DecodeProducer.this) {
                public void run(EncodedImage encodedImage, int i) {
                    if (encodedImage != null) {
                        if (DecodeProducer.this.mDownsampleEnabled || !BaseConsumer.statusHasFlag(i, 16)) {
                            ImageRequest imageRequest = producerContext.getImageRequest();
                            if (DecodeProducer.this.mDownsampleEnabledForNetwork || !UriUtil.isNetworkUri(imageRequest.getSourceUri())) {
                                encodedImage.setSampleSize(DownsampleUtil.determineSampleSize(imageRequest, encodedImage));
                            }
                        }
                        ProgressiveDecoder.this.doDecode(encodedImage, i);
                    }
                }
            }, this.mImageDecodeOptions.minDecodeIntervalMs);
            this.mProducerContext.addCallbacks(new BaseProducerContextCallbacks(DecodeProducer.this) {
                public void onIsIntermediateResultExpectedChanged() {
                    if (ProgressiveDecoder.this.mProducerContext.isIntermediateResultExpected()) {
                        ProgressiveDecoder.this.mJobScheduler.scheduleJob();
                    }
                }

                public void onCancellationRequested() {
                    if (z) {
                        ProgressiveDecoder.this.handleCancellation();
                    }
                }
            });
        }

        public void onNewResultImpl(EncodedImage encodedImage, int i) {
            boolean isLast = BaseConsumer.isLast(i);
            if (isLast && !EncodedImage.isValid(encodedImage)) {
                handleError(new ExceptionWithNoStacktrace("Encoded image is not valid."));
            } else if (updateDecodeJob(encodedImage, i) != null) {
                encodedImage = BaseConsumer.statusHasFlag(i, 4);
                if (!(!isLast && encodedImage == null && this.mProducerContext.isIntermediateResultExpected() == null)) {
                    this.mJobScheduler.scheduleJob();
                }
            }
        }

        protected void onProgressUpdateImpl(float f) {
            super.onProgressUpdateImpl(f * 0.99f);
        }

        public void onFailureImpl(Throwable th) {
            handleError(th);
        }

        public void onCancellationImpl() {
            handleCancellation();
        }

        protected boolean updateDecodeJob(EncodedImage encodedImage, int i) {
            return this.mJobScheduler.updateJob(encodedImage, i);
        }

        private void doDecode(EncodedImage encodedImage, int i) {
            String stringBuilder;
            QualityInfo qualityInfo;
            CloseableImage decode;
            Throwable e;
            CloseableImage closeableImage;
            ProgressiveDecoder progressiveDecoder = this;
            int i2 = i;
            if ((encodedImage.getImageFormat() == DefaultImageFormats.JPEG || !BaseConsumer.isNotLast(i)) && !isFinished()) {
                if (EncodedImage.isValid(encodedImage)) {
                    ImageFormat imageFormat = encodedImage.getImageFormat();
                    String name = imageFormat != null ? imageFormat.getName() : "unknown";
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(encodedImage.getWidth());
                    stringBuilder2.append("x");
                    stringBuilder2.append(encodedImage.getHeight());
                    String stringBuilder3 = stringBuilder2.toString();
                    String valueOf = String.valueOf(encodedImage.getSampleSize());
                    boolean isLast = BaseConsumer.isLast(i);
                    Object obj = (!isLast || BaseConsumer.statusHasFlag(i2, 8)) ? null : 1;
                    boolean statusHasFlag = BaseConsumer.statusHasFlag(i2, 4);
                    ResizeOptions resizeOptions = progressiveDecoder.mProducerContext.getImageRequest().getResizeOptions();
                    if (resizeOptions != null) {
                        StringBuilder stringBuilder4 = new StringBuilder();
                        stringBuilder4.append(resizeOptions.width);
                        stringBuilder4.append("x");
                        stringBuilder4.append(resizeOptions.height);
                        stringBuilder = stringBuilder4.toString();
                    } else {
                        stringBuilder = "unknown";
                    }
                    try {
                        int intermediateImageEndOffset;
                        QualityInfo qualityInfo2;
                        long queuedTime = progressiveDecoder.mJobScheduler.getQueuedTime();
                        String valueOf2 = String.valueOf(progressiveDecoder.mProducerContext.getImageRequest().getSourceUri());
                        if (obj == null) {
                            if (!statusHasFlag) {
                                intermediateImageEndOffset = getIntermediateImageEndOffset(encodedImage);
                                if (obj == null) {
                                    if (statusHasFlag) {
                                        qualityInfo2 = getQualityInfo();
                                        qualityInfo = qualityInfo2;
                                        progressiveDecoder.mProducerListener.onProducerStart(progressiveDecoder.mProducerContext.getId(), DecodeProducer.PRODUCER_NAME);
                                        decode = DecodeProducer.this.mImageDecoder.decode(encodedImage, intermediateImageEndOffset, qualityInfo, progressiveDecoder.mImageDecodeOptions);
                                        if (encodedImage.getSampleSize() != 1) {
                                            i2 |= 16;
                                        }
                                        progressiveDecoder.mProducerListener.onProducerFinishWithSuccess(progressiveDecoder.mProducerContext.getId(), DecodeProducer.PRODUCER_NAME, getExtraMap(decode, queuedTime, qualityInfo, isLast, name, stringBuilder3, stringBuilder, valueOf));
                                        handleResult(decode, i2);
                                    }
                                }
                                qualityInfo2 = ImmutableQualityInfo.FULL_QUALITY;
                                qualityInfo = qualityInfo2;
                                progressiveDecoder.mProducerListener.onProducerStart(progressiveDecoder.mProducerContext.getId(), DecodeProducer.PRODUCER_NAME);
                                decode = DecodeProducer.this.mImageDecoder.decode(encodedImage, intermediateImageEndOffset, qualityInfo, progressiveDecoder.mImageDecodeOptions);
                                if (encodedImage.getSampleSize() != 1) {
                                    i2 |= 16;
                                }
                                progressiveDecoder.mProducerListener.onProducerFinishWithSuccess(progressiveDecoder.mProducerContext.getId(), DecodeProducer.PRODUCER_NAME, getExtraMap(decode, queuedTime, qualityInfo, isLast, name, stringBuilder3, stringBuilder, valueOf));
                                handleResult(decode, i2);
                            }
                        }
                        intermediateImageEndOffset = encodedImage.getSize();
                        if (obj == null) {
                            if (statusHasFlag) {
                                qualityInfo2 = getQualityInfo();
                                qualityInfo = qualityInfo2;
                                progressiveDecoder.mProducerListener.onProducerStart(progressiveDecoder.mProducerContext.getId(), DecodeProducer.PRODUCER_NAME);
                                decode = DecodeProducer.this.mImageDecoder.decode(encodedImage, intermediateImageEndOffset, qualityInfo, progressiveDecoder.mImageDecodeOptions);
                                if (encodedImage.getSampleSize() != 1) {
                                    i2 |= 16;
                                }
                                progressiveDecoder.mProducerListener.onProducerFinishWithSuccess(progressiveDecoder.mProducerContext.getId(), DecodeProducer.PRODUCER_NAME, getExtraMap(decode, queuedTime, qualityInfo, isLast, name, stringBuilder3, stringBuilder, valueOf));
                                handleResult(decode, i2);
                            }
                        }
                        qualityInfo2 = ImmutableQualityInfo.FULL_QUALITY;
                        qualityInfo = qualityInfo2;
                        progressiveDecoder.mProducerListener.onProducerStart(progressiveDecoder.mProducerContext.getId(), DecodeProducer.PRODUCER_NAME);
                        try {
                            decode = DecodeProducer.this.mImageDecoder.decode(encodedImage, intermediateImageEndOffset, qualityInfo, progressiveDecoder.mImageDecodeOptions);
                            try {
                                if (encodedImage.getSampleSize() != 1) {
                                    i2 |= 16;
                                }
                                progressiveDecoder.mProducerListener.onProducerFinishWithSuccess(progressiveDecoder.mProducerContext.getId(), DecodeProducer.PRODUCER_NAME, getExtraMap(decode, queuedTime, qualityInfo, isLast, name, stringBuilder3, stringBuilder, valueOf));
                                handleResult(decode, i2);
                            } catch (Exception e2) {
                                e = e2;
                                closeableImage = decode;
                                progressiveDecoder.mProducerListener.onProducerFinishWithFailure(progressiveDecoder.mProducerContext.getId(), DecodeProducer.PRODUCER_NAME, e, getExtraMap(closeableImage, queuedTime, qualityInfo, isLast, name, stringBuilder3, stringBuilder, valueOf));
                                handleError(e);
                                EncodedImage.closeSafely(encodedImage);
                            }
                        } catch (DecodeException e3) {
                            EncodedImage encodedImage2 = e3.getEncodedImage();
                            FLog.m5716w("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", e3.getMessage(), valueOf2, encodedImage2.getFirstBytesAsHexString(10), Integer.valueOf(encodedImage2.getSize()));
                            throw e3;
                        } catch (Exception e4) {
                            e = e4;
                            closeableImage = null;
                            progressiveDecoder.mProducerListener.onProducerFinishWithFailure(progressiveDecoder.mProducerContext.getId(), DecodeProducer.PRODUCER_NAME, e, getExtraMap(closeableImage, queuedTime, qualityInfo, isLast, name, stringBuilder3, stringBuilder, valueOf));
                            handleError(e);
                            EncodedImage.closeSafely(encodedImage);
                        }
                    } finally {
                        EncodedImage.closeSafely(encodedImage);
                    }
                }
            }
        }

        private Map<String, String> getExtraMap(CloseableImage closeableImage, long j, QualityInfo qualityInfo, boolean z, String str, String str2, String str3, String str4) {
            if (!this.mProducerListener.requiresExtraMap(this.mProducerContext.getId())) {
                return null;
            }
            j = String.valueOf(j);
            String valueOf = String.valueOf(qualityInfo.isOfGoodEnoughQuality());
            qualityInfo = String.valueOf(z);
            if (closeableImage instanceof CloseableStaticBitmap) {
                closeableImage = ((CloseableStaticBitmap) closeableImage).getUnderlyingBitmap();
                z = new StringBuilder();
                z.append(closeableImage.getWidth());
                z.append("x");
                z.append(closeableImage.getHeight());
                closeableImage = z.toString();
                z = new HashMap(8);
                z.put(DecodeProducer.EXTRA_BITMAP_SIZE, closeableImage);
                z.put("queueTime", j);
                z.put(DecodeProducer.EXTRA_HAS_GOOD_QUALITY, valueOf);
                z.put(DecodeProducer.EXTRA_IS_FINAL, qualityInfo);
                z.put("encodedImageSize", str2);
                z.put(DecodeProducer.EXTRA_IMAGE_FORMAT_NAME, str);
                z.put(DecodeProducer.REQUESTED_IMAGE_SIZE, str3);
                z.put(DecodeProducer.SAMPLE_SIZE, str4);
                return ImmutableMap.copyOf(z);
            }
            closeableImage = new HashMap(true);
            closeableImage.put("queueTime", j);
            closeableImage.put(DecodeProducer.EXTRA_HAS_GOOD_QUALITY, valueOf);
            closeableImage.put(DecodeProducer.EXTRA_IS_FINAL, qualityInfo);
            closeableImage.put("encodedImageSize", str2);
            closeableImage.put(DecodeProducer.EXTRA_IMAGE_FORMAT_NAME, str);
            closeableImage.put(DecodeProducer.REQUESTED_IMAGE_SIZE, str3);
            closeableImage.put(DecodeProducer.SAMPLE_SIZE, str4);
            return ImmutableMap.copyOf(closeableImage);
        }

        private synchronized boolean isFinished() {
            return this.mIsFinished;
        }

        private void maybeFinish(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.mIsFinished) {
                        getConsumer().onProgressUpdate(1.0f);
                        this.mIsFinished = true;
                        this.mJobScheduler.clearJob();
                        return;
                    }
                }
            }
        }

        private void handleResult(CloseableImage closeableImage, int i) {
            CloseableReference of = CloseableReference.of(closeableImage);
            try {
                maybeFinish(BaseConsumer.isLast(i));
                getConsumer().onNewResult(of, i);
            } finally {
                CloseableReference.closeSafely(of);
            }
        }

        private void handleError(Throwable th) {
            maybeFinish(true);
            getConsumer().onFailure(th);
        }

        private void handleCancellation() {
            maybeFinish(true);
            getConsumer().onCancellation();
        }
    }

    private class LocalImagesProgressiveDecoder extends ProgressiveDecoder {
        public LocalImagesProgressiveDecoder(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext, boolean z) {
            super(consumer, producerContext, z);
        }

        protected synchronized boolean updateDecodeJob(EncodedImage encodedImage, int i) {
            if (BaseConsumer.isNotLast(i)) {
                return null;
            }
            return super.updateDecodeJob(encodedImage, i);
        }

        protected int getIntermediateImageEndOffset(EncodedImage encodedImage) {
            return encodedImage.getSize();
        }

        protected QualityInfo getQualityInfo() {
            return ImmutableQualityInfo.of(0, false, false);
        }
    }

    private class NetworkImagesProgressiveDecoder extends ProgressiveDecoder {
        private int mLastScheduledScanNumber = null;
        private final ProgressiveJpegConfig mProgressiveJpegConfig;
        private final ProgressiveJpegParser mProgressiveJpegParser;

        public NetworkImagesProgressiveDecoder(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext, ProgressiveJpegParser progressiveJpegParser, ProgressiveJpegConfig progressiveJpegConfig, boolean z) {
            super(consumer, producerContext, z);
            this.mProgressiveJpegParser = (ProgressiveJpegParser) Preconditions.checkNotNull(progressiveJpegParser);
            this.mProgressiveJpegConfig = (ProgressiveJpegConfig) Preconditions.checkNotNull(progressiveJpegConfig);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected synchronized boolean updateDecodeJob(com.facebook.imagepipeline.image.EncodedImage r4, int r5) {
            /*
            r3 = this;
            monitor-enter(r3);
            r0 = super.updateDecodeJob(r4, r5);	 Catch:{ all -> 0x0057 }
            r1 = com.facebook.imagepipeline.producers.BaseConsumer.isNotLast(r5);	 Catch:{ all -> 0x0057 }
            if (r1 != 0) goto L_0x0013;
        L_0x000b:
            r1 = 8;
            r1 = com.facebook.imagepipeline.producers.BaseConsumer.statusHasFlag(r5, r1);	 Catch:{ all -> 0x0057 }
            if (r1 == 0) goto L_0x0055;
        L_0x0013:
            r1 = 4;
            r5 = com.facebook.imagepipeline.producers.BaseConsumer.statusHasFlag(r5, r1);	 Catch:{ all -> 0x0057 }
            if (r5 != 0) goto L_0x0055;
        L_0x001a:
            r5 = com.facebook.imagepipeline.image.EncodedImage.isValid(r4);	 Catch:{ all -> 0x0057 }
            if (r5 == 0) goto L_0x0055;
        L_0x0020:
            r5 = r4.getImageFormat();	 Catch:{ all -> 0x0057 }
            r1 = com.facebook.imageformat.DefaultImageFormats.JPEG;	 Catch:{ all -> 0x0057 }
            if (r5 != r1) goto L_0x0055;
        L_0x0028:
            r5 = r3.mProgressiveJpegParser;	 Catch:{ all -> 0x0057 }
            r4 = r5.parseMoreData(r4);	 Catch:{ all -> 0x0057 }
            r5 = 0;
            if (r4 != 0) goto L_0x0033;
        L_0x0031:
            monitor-exit(r3);
            return r5;
        L_0x0033:
            r4 = r3.mProgressiveJpegParser;	 Catch:{ all -> 0x0057 }
            r4 = r4.getBestScanNumber();	 Catch:{ all -> 0x0057 }
            r1 = r3.mLastScheduledScanNumber;	 Catch:{ all -> 0x0057 }
            if (r4 > r1) goto L_0x003f;
        L_0x003d:
            monitor-exit(r3);
            return r5;
        L_0x003f:
            r1 = r3.mProgressiveJpegConfig;	 Catch:{ all -> 0x0057 }
            r2 = r3.mLastScheduledScanNumber;	 Catch:{ all -> 0x0057 }
            r1 = r1.getNextScanNumberToDecode(r2);	 Catch:{ all -> 0x0057 }
            if (r4 >= r1) goto L_0x0053;
        L_0x0049:
            r1 = r3.mProgressiveJpegParser;	 Catch:{ all -> 0x0057 }
            r1 = r1.isEndMarkerRead();	 Catch:{ all -> 0x0057 }
            if (r1 != 0) goto L_0x0053;
        L_0x0051:
            monitor-exit(r3);
            return r5;
        L_0x0053:
            r3.mLastScheduledScanNumber = r4;	 Catch:{ all -> 0x0057 }
        L_0x0055:
            monitor-exit(r3);
            return r0;
        L_0x0057:
            r4 = move-exception;
            monitor-exit(r3);
            throw r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.DecodeProducer.NetworkImagesProgressiveDecoder.updateDecodeJob(com.facebook.imagepipeline.image.EncodedImage, int):boolean");
        }

        protected int getIntermediateImageEndOffset(EncodedImage encodedImage) {
            return this.mProgressiveJpegParser.getBestScanEndOffset();
        }

        protected QualityInfo getQualityInfo() {
            return this.mProgressiveJpegConfig.getQualityInfo(this.mProgressiveJpegParser.getBestScanNumber());
        }
    }

    public DecodeProducer(ByteArrayPool byteArrayPool, Executor executor, ImageDecoder imageDecoder, ProgressiveJpegConfig progressiveJpegConfig, boolean z, boolean z2, boolean z3, Producer<EncodedImage> producer) {
        this.mByteArrayPool = (ByteArrayPool) Preconditions.checkNotNull(byteArrayPool);
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
        this.mImageDecoder = (ImageDecoder) Preconditions.checkNotNull(imageDecoder);
        this.mProgressiveJpegConfig = (ProgressiveJpegConfig) Preconditions.checkNotNull(progressiveJpegConfig);
        this.mDownsampleEnabled = z;
        this.mDownsampleEnabledForNetwork = z2;
        this.mInputProducer = (Producer) Preconditions.checkNotNull(producer);
        this.mDecodeCancellationEnabled = z3;
    }

    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        Consumer localImagesProgressiveDecoder;
        if (UriUtil.isNetworkUri(producerContext.getImageRequest().getSourceUri())) {
            Consumer networkImagesProgressiveDecoder = new NetworkImagesProgressiveDecoder(consumer, producerContext, new ProgressiveJpegParser(this.mByteArrayPool), this.mProgressiveJpegConfig, this.mDecodeCancellationEnabled);
        } else {
            localImagesProgressiveDecoder = new LocalImagesProgressiveDecoder(consumer, producerContext, this.mDecodeCancellationEnabled);
        }
        this.mInputProducer.produceResults(localImagesProgressiveDecoder, producerContext);
    }
}
