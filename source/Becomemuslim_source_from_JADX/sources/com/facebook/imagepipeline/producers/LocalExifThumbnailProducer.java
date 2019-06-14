package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.media.ExifInterface;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imageutils.BitmapUtil;
import com.facebook.imageutils.JfifUtil;
import java.io.File;
import java.util.Map;
import java.util.concurrent.Executor;

public class LocalExifThumbnailProducer implements ThumbnailProducer<EncodedImage> {
    private static final int COMMON_EXIF_THUMBNAIL_MAX_DIMENSION = 512;
    @VisibleForTesting
    static final String CREATED_THUMBNAIL = "createdThumbnail";
    public static final String PRODUCER_NAME = "LocalExifThumbnailProducer";
    private final ContentResolver mContentResolver;
    private final Executor mExecutor;
    private final PooledByteBufferFactory mPooledByteBufferFactory;

    public LocalExifThumbnailProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, ContentResolver contentResolver) {
        this.mExecutor = executor;
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
        this.mContentResolver = contentResolver;
    }

    public boolean canProvideImageForSize(ResizeOptions resizeOptions) {
        return ThumbnailSizeChecker.isImageBigEnough(COMMON_EXIF_THUMBNAIL_MAX_DIMENSION, COMMON_EXIF_THUMBNAIL_MAX_DIMENSION, resizeOptions);
    }

    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        ProducerListener listener = producerContext.getListener();
        String id = producerContext.getId();
        final ImageRequest imageRequest = producerContext.getImageRequest();
        final Runnable c46481 = new StatefulProducerRunnable<EncodedImage>(consumer, listener, PRODUCER_NAME, id) {
            protected EncodedImage getResult() {
                ExifInterface exifInterface = LocalExifThumbnailProducer.this.getExifInterface(imageRequest.getSourceUri());
                if (exifInterface != null) {
                    if (exifInterface.hasThumbnail()) {
                        return LocalExifThumbnailProducer.this.buildEncodedImage(LocalExifThumbnailProducer.this.mPooledByteBufferFactory.newByteBuffer(exifInterface.getThumbnail()), exifInterface);
                    }
                }
                return null;
            }

            protected void disposeResult(EncodedImage encodedImage) {
                EncodedImage.closeSafely(encodedImage);
            }

            protected Map<String, String> getExtraMapOnSuccess(EncodedImage encodedImage) {
                return ImmutableMap.of(LocalExifThumbnailProducer.CREATED_THUMBNAIL, Boolean.toString(encodedImage != null ? true : null));
            }
        };
        producerContext.addCallbacks(new BaseProducerContextCallbacks() {
            public void onCancellationRequested() {
                c46481.cancel();
            }
        });
        this.mExecutor.execute(c46481);
    }

    @com.facebook.common.internal.VisibleForTesting
    android.media.ExifInterface getExifInterface(android.net.Uri r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r1 = this;
        r0 = r1.mContentResolver;
        r2 = com.facebook.common.util.UriUtil.getRealPathFromUri(r0, r2);
        r0 = r1.canReadAsFile(r2);	 Catch:{ IOException -> 0x0019, StackOverflowError -> 0x0012 }
        if (r0 == 0) goto L_0x0019;	 Catch:{ IOException -> 0x0019, StackOverflowError -> 0x0012 }
    L_0x000c:
        r0 = new android.media.ExifInterface;	 Catch:{ IOException -> 0x0019, StackOverflowError -> 0x0012 }
        r0.<init>(r2);	 Catch:{ IOException -> 0x0019, StackOverflowError -> 0x0012 }
        return r0;
    L_0x0012:
        r2 = com.facebook.imagepipeline.producers.LocalExifThumbnailProducer.class;
        r0 = "StackOverflowError in ExifInterface constructor";
        com.facebook.common.logging.FLog.m5670e(r2, r0);
    L_0x0019:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.LocalExifThumbnailProducer.getExifInterface(android.net.Uri):android.media.ExifInterface");
    }

    private EncodedImage buildEncodedImage(PooledByteBuffer pooledByteBuffer, ExifInterface exifInterface) {
        EncodedImage decodeDimensions = BitmapUtil.decodeDimensions(new PooledByteBufferInputStream(pooledByteBuffer));
        exifInterface = getRotationAngle(exifInterface);
        int i = -1;
        int intValue = decodeDimensions != null ? ((Integer) decodeDimensions.first).intValue() : -1;
        if (decodeDimensions != null) {
            decodeDimensions = (Integer) decodeDimensions.second;
            i = decodeDimensions.intValue();
        }
        CloseableReference of = CloseableReference.of(pooledByteBuffer);
        try {
            decodeDimensions = new EncodedImage(of);
            decodeDimensions.setImageFormat(DefaultImageFormats.JPEG);
            decodeDimensions.setRotationAngle(exifInterface);
            decodeDimensions.setWidth(intValue);
            decodeDimensions.setHeight(i);
            return decodeDimensions;
        } finally {
            CloseableReference.closeSafely(of);
        }
    }

    private int getRotationAngle(ExifInterface exifInterface) {
        return JfifUtil.getAutoRotateAngleFromOrientation(Integer.parseInt(exifInterface.getAttribute("Orientation")));
    }

    @VisibleForTesting
    boolean canReadAsFile(String str) {
        boolean z = false;
        if (str == null) {
            return false;
        }
        File file = new File(str);
        if (!(file.exists() == null || file.canRead() == null)) {
            z = true;
        }
        return z;
    }
}
