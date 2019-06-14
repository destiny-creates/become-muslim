package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.OrientedDrawable;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;

public class DefaultDrawableFactory implements DrawableFactory {
    private final DrawableFactory mAnimatedDrawableFactory;
    private final Resources mResources;

    public boolean supportsImageType(CloseableImage closeableImage) {
        return true;
    }

    public DefaultDrawableFactory(Resources resources, DrawableFactory drawableFactory) {
        this.mResources = resources;
        this.mAnimatedDrawableFactory = drawableFactory;
    }

    public Drawable createDrawable(CloseableImage closeableImage) {
        if (!(closeableImage instanceof CloseableStaticBitmap)) {
            return (this.mAnimatedDrawableFactory == null || !this.mAnimatedDrawableFactory.supportsImageType(closeableImage)) ? null : this.mAnimatedDrawableFactory.createDrawable(closeableImage);
        } else {
            CloseableStaticBitmap closeableStaticBitmap = (CloseableStaticBitmap) closeableImage;
            Drawable bitmapDrawable = new BitmapDrawable(this.mResources, closeableStaticBitmap.getUnderlyingBitmap());
            if (hasTransformableRotationAngle(closeableStaticBitmap) || hasTransformableExifOrientation(closeableStaticBitmap)) {
                return new OrientedDrawable(bitmapDrawable, closeableStaticBitmap.getRotationAngle(), closeableStaticBitmap.getExifOrientation());
            }
            return bitmapDrawable;
        }
    }

    private static boolean hasTransformableRotationAngle(CloseableStaticBitmap closeableStaticBitmap) {
        return (closeableStaticBitmap.getRotationAngle() == 0 || closeableStaticBitmap.getRotationAngle() == -1) ? null : true;
    }

    private static boolean hasTransformableExifOrientation(CloseableStaticBitmap closeableStaticBitmap) {
        if (closeableStaticBitmap.getExifOrientation() == 1 || closeableStaticBitmap.getExifOrientation() == null) {
            return false;
        }
        return true;
    }
}
