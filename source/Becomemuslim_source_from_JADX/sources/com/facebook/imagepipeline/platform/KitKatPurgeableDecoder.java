package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.FlexByteArrayPool;

@TargetApi(19)
public class KitKatPurgeableDecoder extends DalvikPurgeableDecoder {
    private final FlexByteArrayPool mFlexByteArrayPool;

    public /* bridge */ /* synthetic */ CloseableReference decodeFromEncodedImage(EncodedImage encodedImage, Config config, Rect rect) {
        return super.decodeFromEncodedImage(encodedImage, config, rect);
    }

    public /* bridge */ /* synthetic */ CloseableReference decodeJPEGFromEncodedImage(EncodedImage encodedImage, Config config, Rect rect, int i) {
        return super.decodeJPEGFromEncodedImage(encodedImage, config, rect, i);
    }

    public /* bridge */ /* synthetic */ CloseableReference pinBitmap(Bitmap bitmap) {
        return super.pinBitmap(bitmap);
    }

    public KitKatPurgeableDecoder(FlexByteArrayPool flexByteArrayPool) {
        this.mFlexByteArrayPool = flexByteArrayPool;
    }

    protected Bitmap decodeByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> closeableReference, Options options) {
        PooledByteBuffer pooledByteBuffer = (PooledByteBuffer) closeableReference.get();
        int size = pooledByteBuffer.size();
        CloseableReference closeableReference2 = this.mFlexByteArrayPool.get(size);
        try {
            byte[] bArr = (byte[]) closeableReference2.get();
            pooledByteBuffer.read(0, bArr, 0, size);
            Bitmap bitmap = (Bitmap) Preconditions.checkNotNull(BitmapFactory.decodeByteArray(bArr, 0, size, options), "BitmapFactory returned null");
            return bitmap;
        } finally {
            CloseableReference.closeSafely(closeableReference2);
        }
    }

    protected Bitmap decodeJPEGByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> closeableReference, int i, Options options) {
        byte[] bArr = DalvikPurgeableDecoder.endsWithEOI(closeableReference, i) ? null : EOI;
        PooledByteBuffer pooledByteBuffer = (PooledByteBuffer) closeableReference.get();
        Preconditions.checkArgument(i <= pooledByteBuffer.size());
        int i2 = i + 2;
        CloseableReference closeableReference2 = this.mFlexByteArrayPool.get(i2);
        try {
            byte[] bArr2 = (byte[]) closeableReference2.get();
            pooledByteBuffer.read(0, bArr2, 0, i);
            if (bArr != null) {
                putEOI(bArr2, i);
                i = i2;
            }
            Bitmap bitmap = (Bitmap) Preconditions.checkNotNull(BitmapFactory.decodeByteArray(bArr2, 0, i, options), "BitmapFactory returned null");
            return bitmap;
        } finally {
            CloseableReference.closeSafely(closeableReference2);
        }
    }

    private static void putEOI(byte[] bArr, int i) {
        bArr[i] = (byte) -1;
        bArr[i + 1] = (byte) -39;
    }
}
