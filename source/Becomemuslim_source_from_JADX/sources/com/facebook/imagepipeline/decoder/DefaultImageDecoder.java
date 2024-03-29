package com.facebook.imagepipeline.decoder;

import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import java.util.Map;

public class DefaultImageDecoder implements ImageDecoder {
    private final ImageDecoder mAnimatedGifDecoder;
    private final ImageDecoder mAnimatedWebPDecoder;
    private final Map<ImageFormat, ImageDecoder> mCustomDecoders;
    private final ImageDecoder mDefaultDecoder;
    private final PlatformDecoder mPlatformDecoder;

    /* renamed from: com.facebook.imagepipeline.decoder.DefaultImageDecoder$1 */
    class C37511 implements ImageDecoder {
        C37511() {
        }

        public CloseableImage decode(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
            ImageFormat imageFormat = encodedImage.getImageFormat();
            if (imageFormat == DefaultImageFormats.JPEG) {
                return DefaultImageDecoder.this.decodeJpeg(encodedImage, i, qualityInfo, imageDecodeOptions);
            }
            if (imageFormat == DefaultImageFormats.GIF) {
                return DefaultImageDecoder.this.decodeGif(encodedImage, i, qualityInfo, imageDecodeOptions);
            }
            if (imageFormat == DefaultImageFormats.WEBP_ANIMATED) {
                return DefaultImageDecoder.this.decodeAnimatedWebp(encodedImage, i, qualityInfo, imageDecodeOptions);
            }
            if (imageFormat != ImageFormat.UNKNOWN) {
                return DefaultImageDecoder.this.decodeStaticImage(encodedImage, imageDecodeOptions);
            }
            throw new DecodeException("unknown image format", encodedImage);
        }
    }

    public DefaultImageDecoder(ImageDecoder imageDecoder, ImageDecoder imageDecoder2, PlatformDecoder platformDecoder) {
        this(imageDecoder, imageDecoder2, platformDecoder, null);
    }

    public DefaultImageDecoder(ImageDecoder imageDecoder, ImageDecoder imageDecoder2, PlatformDecoder platformDecoder, Map<ImageFormat, ImageDecoder> map) {
        this.mDefaultDecoder = new C37511();
        this.mAnimatedGifDecoder = imageDecoder;
        this.mAnimatedWebPDecoder = imageDecoder2;
        this.mPlatformDecoder = platformDecoder;
        this.mCustomDecoders = map;
    }

    public CloseableImage decode(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        if (imageDecodeOptions.customImageDecoder != null) {
            return imageDecodeOptions.customImageDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
        }
        Object imageFormat = encodedImage.getImageFormat();
        if (imageFormat == null || imageFormat == ImageFormat.UNKNOWN) {
            imageFormat = ImageFormatChecker.getImageFormat_WrapIOException(encodedImage.getInputStream());
            encodedImage.setImageFormat(imageFormat);
        }
        if (this.mCustomDecoders != null) {
            ImageDecoder imageDecoder = (ImageDecoder) this.mCustomDecoders.get(imageFormat);
            if (imageDecoder != null) {
                return imageDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
            }
        }
        return this.mDefaultDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
    }

    public CloseableImage decodeGif(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        if (imageDecodeOptions.forceStaticImage || this.mAnimatedGifDecoder == null) {
            return decodeStaticImage(encodedImage, imageDecodeOptions);
        }
        return this.mAnimatedGifDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
    }

    public CloseableStaticBitmap decodeStaticImage(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions) {
        CloseableStaticBitmap closeableStaticBitmap = this.mPlatformDecoder;
        CloseableReference decodeFromEncodedImage = closeableStaticBitmap.decodeFromEncodedImage(encodedImage, imageDecodeOptions.bitmapConfig, null);
        try {
            closeableStaticBitmap = new CloseableStaticBitmap(decodeFromEncodedImage, ImmutableQualityInfo.FULL_QUALITY, encodedImage.getRotationAngle(), encodedImage.getExifOrientation());
            return closeableStaticBitmap;
        } finally {
            decodeFromEncodedImage.close();
        }
    }

    public CloseableStaticBitmap decodeJpeg(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        PlatformDecoder platformDecoder = this.mPlatformDecoder;
        imageDecodeOptions = imageDecodeOptions.bitmapConfig;
        CloseableReference decodeJPEGFromEncodedImage = platformDecoder.decodeJPEGFromEncodedImage(encodedImage, imageDecodeOptions, null, i);
        try {
            imageDecodeOptions = new CloseableStaticBitmap(decodeJPEGFromEncodedImage, qualityInfo, encodedImage.getRotationAngle(), encodedImage.getExifOrientation());
            return imageDecodeOptions;
        } finally {
            decodeJPEGFromEncodedImage.close();
        }
    }

    public CloseableImage decodeAnimatedWebp(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        return this.mAnimatedWebPDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
    }
}
