package com.facebook.imagepipeline.bitmaps;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.platform.PlatformDecoder;

@TargetApi(11)
public class HoneycombBitmapFactory extends PlatformBitmapFactory {
    private static final String TAG = "HoneycombBitmapFactory";
    private boolean mImmutableBitmapFallback;
    private final EmptyJpegGenerator mJpegGenerator;
    private final PlatformDecoder mPurgeableDecoder;

    public HoneycombBitmapFactory(EmptyJpegGenerator emptyJpegGenerator, PlatformDecoder platformDecoder) {
        this.mJpegGenerator = emptyJpegGenerator;
        this.mPurgeableDecoder = platformDecoder;
    }

    @TargetApi(12)
    public CloseableReference<Bitmap> createBitmapInternal(int i, int i2, Config config) {
        if (this.mImmutableBitmapFallback) {
            return createFallbackBitmap(i, i2, config);
        }
        CloseableReference generate = this.mJpegGenerator.generate((short) i, (short) i2);
        EncodedImage encodedImage;
        try {
            encodedImage = new EncodedImage(generate);
            encodedImage.setImageFormat(DefaultImageFormats.JPEG);
            CloseableReference decodeJPEGFromEncodedImage = this.mPurgeableDecoder.decodeJPEGFromEncodedImage(encodedImage, config, null, ((PooledByteBuffer) generate.get()).size());
            if (((Bitmap) decodeJPEGFromEncodedImage.get()).isMutable()) {
                ((Bitmap) decodeJPEGFromEncodedImage.get()).setHasAlpha(true);
                ((Bitmap) decodeJPEGFromEncodedImage.get()).eraseColor(0);
                EncodedImage.closeSafely(encodedImage);
                generate.close();
                return decodeJPEGFromEncodedImage;
            }
            CloseableReference.closeSafely(decodeJPEGFromEncodedImage);
            this.mImmutableBitmapFallback = true;
            FLog.wtf(TAG, "Immutable bitmap returned by decoder");
            i = createFallbackBitmap(i, i2, config);
            EncodedImage.closeSafely(encodedImage);
            generate.close();
            return i;
        } catch (Throwable th) {
            generate.close();
        }
    }

    private static CloseableReference<Bitmap> createFallbackBitmap(int i, int i2, Config config) {
        return CloseableReference.of(Bitmap.createBitmap(i, i2, config), SimpleBitmapReleaser.getInstance());
    }
}
