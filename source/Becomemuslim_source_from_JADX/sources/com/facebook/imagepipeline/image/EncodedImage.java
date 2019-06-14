package com.facebook.imagepipeline.image;

import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.SharedReference;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imageutils.JfifUtil;
import com.facebook.imageutils.WebpUtil;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStream;

public class EncodedImage implements Closeable {
    public static final int DEFAULT_SAMPLE_SIZE = 1;
    public static final int UNKNOWN_HEIGHT = -1;
    public static final int UNKNOWN_ROTATION_ANGLE = -1;
    public static final int UNKNOWN_STREAM_SIZE = -1;
    public static final int UNKNOWN_WIDTH = -1;
    private BytesRange mBytesRange;
    private int mExifOrientation;
    private int mHeight;
    private ImageFormat mImageFormat;
    private final Supplier<FileInputStream> mInputStreamSupplier;
    private final CloseableReference<PooledByteBuffer> mPooledByteBufferRef;
    private int mRotationAngle;
    private int mSampleSize;
    private int mStreamSize;
    private int mWidth;

    public EncodedImage(CloseableReference<PooledByteBuffer> closeableReference) {
        this.mImageFormat = ImageFormat.UNKNOWN;
        this.mRotationAngle = -1;
        this.mExifOrientation = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.mStreamSize = -1;
        Preconditions.checkArgument(CloseableReference.isValid(closeableReference));
        this.mPooledByteBufferRef = closeableReference.clone();
        this.mInputStreamSupplier = null;
    }

    public EncodedImage(Supplier<FileInputStream> supplier) {
        this.mImageFormat = ImageFormat.UNKNOWN;
        this.mRotationAngle = -1;
        this.mExifOrientation = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.mStreamSize = -1;
        Preconditions.checkNotNull(supplier);
        this.mPooledByteBufferRef = null;
        this.mInputStreamSupplier = supplier;
    }

    public EncodedImage(Supplier<FileInputStream> supplier, int i) {
        this((Supplier) supplier);
        this.mStreamSize = i;
    }

    public static EncodedImage cloneOrNull(EncodedImage encodedImage) {
        return encodedImage != null ? encodedImage.cloneOrNull() : null;
    }

    public EncodedImage cloneOrNull() {
        EncodedImage encodedImage;
        if (this.mInputStreamSupplier != null) {
            encodedImage = new EncodedImage(this.mInputStreamSupplier, this.mStreamSize);
        } else {
            EncodedImage encodedImage2;
            CloseableReference cloneOrNull = CloseableReference.cloneOrNull(this.mPooledByteBufferRef);
            if (cloneOrNull == null) {
                encodedImage2 = null;
            } else {
                try {
                    encodedImage2 = new EncodedImage(cloneOrNull);
                } catch (Throwable th) {
                    CloseableReference.closeSafely(cloneOrNull);
                }
            }
            CloseableReference.closeSafely(cloneOrNull);
            encodedImage = encodedImage2;
        }
        if (encodedImage != null) {
            encodedImage.copyMetaDataFrom(this);
        }
        return encodedImage;
    }

    public void close() {
        CloseableReference.closeSafely(this.mPooledByteBufferRef);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!CloseableReference.isValid(this.mPooledByteBufferRef)) {
            if (this.mInputStreamSupplier == null) {
                z = false;
            }
        }
        z = true;
        return z;
    }

    public CloseableReference<PooledByteBuffer> getByteBufferRef() {
        return CloseableReference.cloneOrNull(this.mPooledByteBufferRef);
    }

    public InputStream getInputStream() {
        if (this.mInputStreamSupplier != null) {
            return (InputStream) this.mInputStreamSupplier.get();
        }
        CloseableReference cloneOrNull = CloseableReference.cloneOrNull(this.mPooledByteBufferRef);
        if (cloneOrNull == null) {
            return null;
        }
        try {
            InputStream pooledByteBufferInputStream = new PooledByteBufferInputStream((PooledByteBuffer) cloneOrNull.get());
            return pooledByteBufferInputStream;
        } finally {
            CloseableReference.closeSafely(cloneOrNull);
        }
    }

    public void setImageFormat(ImageFormat imageFormat) {
        this.mImageFormat = imageFormat;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void setRotationAngle(int i) {
        this.mRotationAngle = i;
    }

    public void setExifOrientation(int i) {
        this.mExifOrientation = i;
    }

    public void setSampleSize(int i) {
        this.mSampleSize = i;
    }

    public void setStreamSize(int i) {
        this.mStreamSize = i;
    }

    public void setBytesRange(BytesRange bytesRange) {
        this.mBytesRange = bytesRange;
    }

    public ImageFormat getImageFormat() {
        return this.mImageFormat;
    }

    public int getRotationAngle() {
        return this.mRotationAngle;
    }

    public int getExifOrientation() {
        return this.mExifOrientation;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getSampleSize() {
        return this.mSampleSize;
    }

    public BytesRange getBytesRange() {
        return this.mBytesRange;
    }

    public boolean isCompleteAt(int i) {
        boolean z = true;
        if (this.mImageFormat != DefaultImageFormats.JPEG || this.mInputStreamSupplier != null) {
            return true;
        }
        Preconditions.checkNotNull(this.mPooledByteBufferRef);
        PooledByteBuffer pooledByteBuffer = (PooledByteBuffer) this.mPooledByteBufferRef.get();
        if (pooledByteBuffer.read(i - 2) != (byte) -1 || pooledByteBuffer.read(i - 1) != -39) {
            z = false;
        }
        return z;
    }

    public int getSize() {
        if (this.mPooledByteBufferRef == null || this.mPooledByteBufferRef.get() == null) {
            return this.mStreamSize;
        }
        return ((PooledByteBuffer) this.mPooledByteBufferRef.get()).size();
    }

    public String getFirstBytesAsHexString(int i) {
        CloseableReference byteBufferRef = getByteBufferRef();
        if (byteBufferRef == null) {
            return "";
        }
        i = Math.min(getSize(), i);
        byte[] bArr = new byte[i];
        try {
            PooledByteBuffer pooledByteBuffer = (PooledByteBuffer) byteBufferRef.get();
            if (pooledByteBuffer == null) {
                i = "";
                return i;
            }
            pooledByteBuffer.read(0, bArr, 0, i);
            byteBufferRef.close();
            i = new StringBuilder(bArr.length * 2);
            int length = bArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                i.append(String.format("%02X", new Object[]{Byte.valueOf(bArr[i2])}));
            }
            return i.toString();
        } finally {
            byteBufferRef.close();
        }
    }

    public void parseMetaData() {
        Pair readWebPImageSize;
        ImageFormat imageFormat_WrapIOException = ImageFormatChecker.getImageFormat_WrapIOException(getInputStream());
        this.mImageFormat = imageFormat_WrapIOException;
        if (DefaultImageFormats.isWebpFormat(imageFormat_WrapIOException)) {
            readWebPImageSize = readWebPImageSize();
        } else {
            readWebPImageSize = readImageSize();
        }
        if (imageFormat_WrapIOException != DefaultImageFormats.JPEG || this.mRotationAngle != -1) {
            this.mRotationAngle = 0;
        } else if (readWebPImageSize != null) {
            this.mExifOrientation = JfifUtil.getOrientation(getInputStream());
            this.mRotationAngle = JfifUtil.getAutoRotateAngleFromOrientation(this.mExifOrientation);
        }
    }

    private Pair<Integer, Integer> readWebPImageSize() {
        Pair<Integer, Integer> size = WebpUtil.getSize(getInputStream());
        if (size != null) {
            this.mWidth = ((Integer) size.first).intValue();
            this.mHeight = ((Integer) size.second).intValue();
        }
        return size;
    }

    private android.util.Pair<java.lang.Integer, java.lang.Integer> readImageSize() {
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
        r3 = this;
        r0 = r3.getInputStream();	 Catch:{ all -> 0x0026 }
        r1 = com.facebook.imageutils.BitmapUtil.decodeDimensions(r0);	 Catch:{ all -> 0x0024 }
        if (r1 == 0) goto L_0x001e;	 Catch:{ all -> 0x0024 }
    L_0x000a:
        r2 = r1.first;	 Catch:{ all -> 0x0024 }
        r2 = (java.lang.Integer) r2;	 Catch:{ all -> 0x0024 }
        r2 = r2.intValue();	 Catch:{ all -> 0x0024 }
        r3.mWidth = r2;	 Catch:{ all -> 0x0024 }
        r2 = r1.second;	 Catch:{ all -> 0x0024 }
        r2 = (java.lang.Integer) r2;	 Catch:{ all -> 0x0024 }
        r2 = r2.intValue();	 Catch:{ all -> 0x0024 }
        r3.mHeight = r2;	 Catch:{ all -> 0x0024 }
    L_0x001e:
        if (r0 == 0) goto L_0x0023;
    L_0x0020:
        r0.close();	 Catch:{ IOException -> 0x0023 }
    L_0x0023:
        return r1;
    L_0x0024:
        r1 = move-exception;
        goto L_0x0028;
    L_0x0026:
        r1 = move-exception;
        r0 = 0;
    L_0x0028:
        if (r0 == 0) goto L_0x002d;
    L_0x002a:
        r0.close();	 Catch:{ IOException -> 0x002d }
    L_0x002d:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.image.EncodedImage.readImageSize():android.util.Pair<java.lang.Integer, java.lang.Integer>");
    }

    public void copyMetaDataFrom(EncodedImage encodedImage) {
        this.mImageFormat = encodedImage.getImageFormat();
        this.mWidth = encodedImage.getWidth();
        this.mHeight = encodedImage.getHeight();
        this.mRotationAngle = encodedImage.getRotationAngle();
        this.mExifOrientation = encodedImage.getExifOrientation();
        this.mSampleSize = encodedImage.getSampleSize();
        this.mStreamSize = encodedImage.getSize();
        this.mBytesRange = encodedImage.getBytesRange();
    }

    public static boolean isMetaDataAvailable(EncodedImage encodedImage) {
        return (encodedImage.mRotationAngle < 0 || encodedImage.mWidth < 0 || encodedImage.mHeight < null) ? null : true;
    }

    public static void closeSafely(EncodedImage encodedImage) {
        if (encodedImage != null) {
            encodedImage.close();
        }
    }

    public static boolean isValid(EncodedImage encodedImage) {
        return (encodedImage == null || encodedImage.isValid() == null) ? null : true;
    }

    @VisibleForTesting
    public synchronized SharedReference<PooledByteBuffer> getUnderlyingReferenceTestOnly() {
        return this.mPooledByteBufferRef != null ? this.mPooledByteBufferRef.getUnderlyingReferenceTestOnly() : null;
    }
}
