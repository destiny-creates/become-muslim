package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;

public final class ThumbnailSizeChecker {
    public static final float ACCEPTABLE_REQUESTED_TO_ACTUAL_SIZE_RATIO = 1.3333334f;
    private static final int ROTATED_90_DEGREES_CLOCKWISE = 90;
    private static final int ROTATED_90_DEGREES_COUNTER_CLOCKWISE = 270;

    public static int getAcceptableSize(int i) {
        return (int) (((float) i) * 1.3333334f);
    }

    public static boolean isImageBigEnough(int i, int i2, ResizeOptions resizeOptions) {
        boolean z = true;
        if (resizeOptions == null) {
            if (((float) getAcceptableSize(i)) < 1157627904 || getAcceptableSize(i2) < 2048) {
                z = false;
            }
            return z;
        }
        if (getAcceptableSize(i) < resizeOptions.width || getAcceptableSize(i2) < resizeOptions.height) {
            z = false;
        }
        return z;
    }

    public static boolean isImageBigEnough(EncodedImage encodedImage, ResizeOptions resizeOptions) {
        if (encodedImage == null) {
            return null;
        }
        int rotationAngle = encodedImage.getRotationAngle();
        if (rotationAngle == 90 || rotationAngle == 270) {
            return isImageBigEnough(encodedImage.getHeight(), encodedImage.getWidth(), resizeOptions);
        }
        return isImageBigEnough(encodedImage.getWidth(), encodedImage.getHeight(), resizeOptions);
    }
}
