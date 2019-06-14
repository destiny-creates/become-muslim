package com.facebook.imagepipeline.nativecode;

import android.os.Build.VERSION;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import java.io.InputStream;
import java.io.OutputStream;

@DoNotStrip
public class WebpTranscoderImpl implements WebpTranscoder {
    @DoNotStrip
    private static native void nativeTranscodeWebpToJpeg(InputStream inputStream, OutputStream outputStream, int i);

    @DoNotStrip
    private static native void nativeTranscodeWebpToPng(InputStream inputStream, OutputStream outputStream);

    public boolean isWebpNativelySupported(ImageFormat imageFormat) {
        boolean z = false;
        if (imageFormat == DefaultImageFormats.WEBP_SIMPLE) {
            if (VERSION.SDK_INT >= 14) {
                z = true;
            }
            return z;
        }
        if (!(imageFormat == DefaultImageFormats.WEBP_LOSSLESS || imageFormat == DefaultImageFormats.WEBP_EXTENDED)) {
            if (imageFormat != DefaultImageFormats.WEBP_EXTENDED_WITH_ALPHA) {
                if (imageFormat == DefaultImageFormats.WEBP_ANIMATED) {
                    return false;
                }
                throw new IllegalArgumentException("Image format is not a WebP.");
            }
        }
        return WebpSupportStatus.sIsExtendedWebpSupported;
    }

    public void transcodeWebpToJpeg(InputStream inputStream, OutputStream outputStream, int i) {
        StaticWebpNativeLoader.ensure();
        nativeTranscodeWebpToJpeg((InputStream) Preconditions.checkNotNull(inputStream), (OutputStream) Preconditions.checkNotNull(outputStream), i);
    }

    public void transcodeWebpToPng(InputStream inputStream, OutputStream outputStream) {
        StaticWebpNativeLoader.ensure();
        nativeTranscodeWebpToPng((InputStream) Preconditions.checkNotNull(inputStream), (OutputStream) Preconditions.checkNotNull(outputStream));
    }
}
