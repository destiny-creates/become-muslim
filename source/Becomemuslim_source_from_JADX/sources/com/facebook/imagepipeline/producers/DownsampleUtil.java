package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;

public class DownsampleUtil {
    public static final int DEFAULT_SAMPLE_SIZE = 1;
    private static final float INTERVAL_ROUNDING = 0.33333334f;

    @VisibleForTesting
    static int ratioToSampleSizeJPEG(float f) {
        if (f > 0.6666667f) {
            return 1;
        }
        int i = 2;
        while (true) {
            int i2 = i * 2;
            double d = 1.0d / ((double) i2);
            if (d + (0.3333333432674408d * d) <= ((double) f)) {
                return i;
            }
            i = i2;
        }
    }

    @VisibleForTesting
    static int roundToPowerOfTwo(int i) {
        int i2 = 1;
        while (i2 < i) {
            i2 *= 2;
        }
        return i2;
    }

    private DownsampleUtil() {
    }

    public static int determineSampleSize(ImageRequest imageRequest, EncodedImage encodedImage) {
        if (!EncodedImage.isMetaDataAvailable(encodedImage)) {
            return 1;
        }
        int ratioToSampleSizeJPEG;
        float determineDownsampleRatio = determineDownsampleRatio(imageRequest, encodedImage);
        if (encodedImage.getImageFormat() == DefaultImageFormats.JPEG) {
            ratioToSampleSizeJPEG = ratioToSampleSizeJPEG(determineDownsampleRatio);
        } else {
            ratioToSampleSizeJPEG = ratioToSampleSize(determineDownsampleRatio);
        }
        int max = Math.max(encodedImage.getHeight(), encodedImage.getWidth());
        imageRequest = imageRequest.getResizeOptions();
        imageRequest = imageRequest != null ? imageRequest.maxBitmapSize : 1157627904;
        while (((float) (max / ratioToSampleSizeJPEG)) > imageRequest) {
            ratioToSampleSizeJPEG = encodedImage.getImageFormat() == DefaultImageFormats.JPEG ? ratioToSampleSizeJPEG * 2 : ratioToSampleSizeJPEG + 1;
        }
        return ratioToSampleSizeJPEG;
    }

    @VisibleForTesting
    static float determineDownsampleRatio(ImageRequest imageRequest, EncodedImage encodedImage) {
        Preconditions.checkArgument(EncodedImage.isMetaDataAvailable(encodedImage));
        ResizeOptions resizeOptions = imageRequest.getResizeOptions();
        if (resizeOptions != null && resizeOptions.height > 0 && resizeOptions.width > 0 && encodedImage.getWidth() != 0) {
            if (encodedImage.getHeight() != 0) {
                Object obj;
                int rotationAngle = getRotationAngle(imageRequest, encodedImage);
                if (rotationAngle != 90) {
                    if (rotationAngle != RotationOptions.ROTATE_270) {
                        obj = null;
                        FLog.m5708v("DownsampleUtil", "Downsample - Specified size: %dx%d, image size: %dx%d ratio: %.1f x %.1f, ratio: %.3f for %s", Integer.valueOf(resizeOptions.width), Integer.valueOf(resizeOptions.height), Integer.valueOf(obj == null ? encodedImage.getHeight() : encodedImage.getWidth()), Integer.valueOf(obj == null ? encodedImage.getWidth() : encodedImage.getHeight()), Float.valueOf(((float) resizeOptions.width) / ((float) (obj == null ? encodedImage.getHeight() : encodedImage.getWidth()))), Float.valueOf(((float) resizeOptions.height) / ((float) (obj == null ? encodedImage.getWidth() : encodedImage.getHeight()))), Float.valueOf(Math.max(((float) resizeOptions.width) / ((float) (obj == null ? encodedImage.getHeight() : encodedImage.getWidth())), ((float) resizeOptions.height) / ((float) (obj == null ? encodedImage.getWidth() : encodedImage.getHeight())))), imageRequest.getSourceUri().toString());
                        return Math.max(((float) resizeOptions.width) / ((float) (obj == null ? encodedImage.getHeight() : encodedImage.getWidth())), ((float) resizeOptions.height) / ((float) (obj == null ? encodedImage.getWidth() : encodedImage.getHeight())));
                    }
                }
                obj = 1;
                if (obj == null) {
                }
                if (obj == null) {
                }
                FLog.m5708v("DownsampleUtil", "Downsample - Specified size: %dx%d, image size: %dx%d ratio: %.1f x %.1f, ratio: %.3f for %s", Integer.valueOf(resizeOptions.width), Integer.valueOf(resizeOptions.height), Integer.valueOf(obj == null ? encodedImage.getHeight() : encodedImage.getWidth()), Integer.valueOf(obj == null ? encodedImage.getWidth() : encodedImage.getHeight()), Float.valueOf(((float) resizeOptions.width) / ((float) (obj == null ? encodedImage.getHeight() : encodedImage.getWidth()))), Float.valueOf(((float) resizeOptions.height) / ((float) (obj == null ? encodedImage.getWidth() : encodedImage.getHeight()))), Float.valueOf(Math.max(((float) resizeOptions.width) / ((float) (obj == null ? encodedImage.getHeight() : encodedImage.getWidth())), ((float) resizeOptions.height) / ((float) (obj == null ? encodedImage.getWidth() : encodedImage.getHeight())))), imageRequest.getSourceUri().toString());
                return Math.max(((float) resizeOptions.width) / ((float) (obj == null ? encodedImage.getHeight() : encodedImage.getWidth())), ((float) resizeOptions.height) / ((float) (obj == null ? encodedImage.getWidth() : encodedImage.getHeight())));
            }
        }
        return 1.0f;
    }

    @VisibleForTesting
    static int ratioToSampleSize(float f) {
        if (f > 0.6666667f) {
            return 1;
        }
        int i = 2;
        while (true) {
            double d = (double) i;
            if ((1.0d / d) + ((1.0d / (Math.pow(d, 2.0d) - d)) * 0.3333333432674408d) <= ((double) f)) {
                return i - 1;
            }
            i++;
        }
    }

    private static int getRotationAngle(ImageRequest imageRequest, EncodedImage encodedImage) {
        boolean z = false;
        if (imageRequest.getRotationOptions().useImageMetadata() == null) {
            return 0;
        }
        imageRequest = encodedImage.getRotationAngle();
        if (imageRequest == null || imageRequest == 90 || imageRequest == 180 || imageRequest == 270) {
            z = true;
        }
        Preconditions.checkArgument(z);
        return imageRequest;
    }
}
