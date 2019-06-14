package com.facebook.imagepipeline.common;

import android.graphics.Bitmap.Config;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import java.util.Locale;

public class ImageDecodeOptions {
    private static final ImageDecodeOptions DEFAULTS = newBuilder().build();
    public final Config bitmapConfig;
    public final ImageDecoder customImageDecoder;
    public final boolean decodeAllFrames;
    public final boolean decodePreviewFrame;
    public final boolean forceStaticImage;
    public final int minDecodeIntervalMs;
    public final boolean useLastFrameForPreview;

    public ImageDecodeOptions(ImageDecodeOptionsBuilder imageDecodeOptionsBuilder) {
        this.minDecodeIntervalMs = imageDecodeOptionsBuilder.getMinDecodeIntervalMs();
        this.decodePreviewFrame = imageDecodeOptionsBuilder.getDecodePreviewFrame();
        this.useLastFrameForPreview = imageDecodeOptionsBuilder.getUseLastFrameForPreview();
        this.decodeAllFrames = imageDecodeOptionsBuilder.getDecodeAllFrames();
        this.forceStaticImage = imageDecodeOptionsBuilder.getForceStaticImage();
        this.bitmapConfig = imageDecodeOptionsBuilder.getBitmapConfig();
        this.customImageDecoder = imageDecodeOptionsBuilder.getCustomImageDecoder();
    }

    public static ImageDecodeOptions defaults() {
        return DEFAULTS;
    }

    public static ImageDecodeOptionsBuilder newBuilder() {
        return new ImageDecodeOptionsBuilder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                ImageDecodeOptions imageDecodeOptions = (ImageDecodeOptions) obj;
                return this.decodePreviewFrame == imageDecodeOptions.decodePreviewFrame && this.useLastFrameForPreview == imageDecodeOptions.useLastFrameForPreview && this.decodeAllFrames == imageDecodeOptions.decodeAllFrames && this.forceStaticImage == imageDecodeOptions.forceStaticImage && this.bitmapConfig == imageDecodeOptions.bitmapConfig && this.customImageDecoder == imageDecodeOptions.customImageDecoder;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.minDecodeIntervalMs * 31) + this.decodePreviewFrame) * 31) + this.useLastFrameForPreview) * 31) + this.decodeAllFrames) * 31) + this.forceStaticImage) * 31) + this.bitmapConfig.ordinal()) * 31) + (this.customImageDecoder != null ? this.customImageDecoder.hashCode() : 0);
    }

    public String toString() {
        return String.format((Locale) null, "%d-%b-%b-%b-%b-%s-%s", new Object[]{Integer.valueOf(this.minDecodeIntervalMs), Boolean.valueOf(this.decodePreviewFrame), Boolean.valueOf(this.useLastFrameForPreview), Boolean.valueOf(this.decodeAllFrames), Boolean.valueOf(this.forceStaticImage), this.bitmapConfig.name(), this.customImageDecoder});
    }
}
