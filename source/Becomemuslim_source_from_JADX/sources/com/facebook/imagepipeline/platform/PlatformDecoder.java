package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;

public interface PlatformDecoder {
    CloseableReference<Bitmap> decodeFromEncodedImage(EncodedImage encodedImage, Config config, Rect rect);

    CloseableReference<Bitmap> decodeJPEGFromEncodedImage(EncodedImage encodedImage, Config config, Rect rect, int i);
}
