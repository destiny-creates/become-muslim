package com.facebook.fresco.animation.bitmap.cache;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache.FrameCacheListener;
import com.facebook.imagepipeline.animated.impl.AnimatedFrameCache;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imageutils.BitmapUtil;

public class FrescoFrameCache implements BitmapFrameCache {
    private static final Class<?> TAG = FrescoFrameCache.class;
    private final AnimatedFrameCache mAnimatedFrameCache;
    private final boolean mEnableBitmapReusing;
    private CloseableReference<CloseableImage> mLastRenderedItem;
    private final SparseArray<CloseableReference<CloseableImage>> mPreparedPendingFrames = new SparseArray();

    public void setFrameCacheListener(FrameCacheListener frameCacheListener) {
    }

    public FrescoFrameCache(AnimatedFrameCache animatedFrameCache, boolean z) {
        this.mAnimatedFrameCache = animatedFrameCache;
        this.mEnableBitmapReusing = z;
    }

    public synchronized CloseableReference<Bitmap> getCachedFrame(int i) {
        return convertToBitmapReferenceAndClose(this.mAnimatedFrameCache.get(i));
    }

    public synchronized CloseableReference<Bitmap> getFallbackFrame(int i) {
        return convertToBitmapReferenceAndClose(CloseableReference.cloneOrNull(this.mLastRenderedItem));
    }

    public synchronized CloseableReference<Bitmap> getBitmapToReuseForFrame(int i, int i2, int i3) {
        if (this.mEnableBitmapReusing == 0) {
            return 0;
        }
        return convertToBitmapReferenceAndClose(this.mAnimatedFrameCache.getForReuse());
    }

    public synchronized boolean contains(int i) {
        return this.mAnimatedFrameCache.contains(i);
    }

    public synchronized int getSizeInBytes() {
        return getBitmapSizeBytes(this.mLastRenderedItem) + getPreparedPendingFramesSizeBytes();
    }

    public synchronized void clear() {
        CloseableReference.closeSafely(this.mLastRenderedItem);
        this.mLastRenderedItem = null;
        for (int i = 0; i < this.mPreparedPendingFrames.size(); i++) {
            CloseableReference.closeSafely((CloseableReference) this.mPreparedPendingFrames.valueAt(i));
        }
        this.mPreparedPendingFrames.clear();
    }

    public synchronized void onFrameRendered(int i, CloseableReference<Bitmap> closeableReference, int i2) {
        Preconditions.checkNotNull(closeableReference);
        removePreparedReference(i);
        CloseableReference createImageReference;
        try {
            createImageReference = createImageReference(closeableReference);
            if (createImageReference != null) {
                try {
                    CloseableReference.closeSafely(this.mLastRenderedItem);
                    this.mLastRenderedItem = this.mAnimatedFrameCache.cache(i, createImageReference);
                } catch (Throwable th) {
                    i = th;
                    CloseableReference.closeSafely(createImageReference);
                    throw i;
                }
            }
            CloseableReference.closeSafely(createImageReference);
        } catch (Throwable th2) {
            i = th2;
            createImageReference = 0;
            CloseableReference.closeSafely(createImageReference);
            throw i;
        }
    }

    public synchronized void onFramePrepared(int i, CloseableReference<Bitmap> closeableReference, int i2) {
        CloseableReference createImageReference;
        Preconditions.checkNotNull(closeableReference);
        try {
            createImageReference = createImageReference(closeableReference);
            if (createImageReference == null) {
                CloseableReference.closeSafely(createImageReference);
                return;
            }
            try {
                i2 = this.mAnimatedFrameCache.cache(i, createImageReference);
                if (CloseableReference.isValid(i2)) {
                    CloseableReference.closeSafely((CloseableReference) this.mPreparedPendingFrames.get(i));
                    this.mPreparedPendingFrames.put(i, i2);
                    FLog.m5696v(TAG, "cachePreparedFrame(%d) cached. Pending frames: %s", Integer.valueOf(i), this.mPreparedPendingFrames);
                }
                CloseableReference.closeSafely(createImageReference);
            } catch (Throwable th) {
                i = th;
                CloseableReference.closeSafely(createImageReference);
                throw i;
            }
        } catch (Throwable th2) {
            i = th2;
            createImageReference = 0;
            CloseableReference.closeSafely(createImageReference);
            throw i;
        }
    }

    private synchronized int getPreparedPendingFramesSizeBytes() {
        int i;
        i = 0;
        for (int i2 = 0; i2 < this.mPreparedPendingFrames.size(); i2++) {
            i += getBitmapSizeBytes((CloseableReference) this.mPreparedPendingFrames.valueAt(i2));
        }
        return i;
    }

    private synchronized void removePreparedReference(int i) {
        CloseableReference closeableReference = (CloseableReference) this.mPreparedPendingFrames.get(i);
        if (closeableReference != null) {
            this.mPreparedPendingFrames.delete(i);
            CloseableReference.closeSafely(closeableReference);
            FLog.m5696v(TAG, "removePreparedReference(%d) removed. Pending frames: %s", Integer.valueOf(i), this.mPreparedPendingFrames);
        }
    }

    @VisibleForTesting
    static CloseableReference<Bitmap> convertToBitmapReferenceAndClose(CloseableReference<CloseableImage> closeableReference) {
        try {
            if (CloseableReference.isValid(closeableReference) && (closeableReference.get() instanceof CloseableStaticBitmap)) {
                CloseableStaticBitmap closeableStaticBitmap = (CloseableStaticBitmap) closeableReference.get();
                if (closeableStaticBitmap != null) {
                    CloseableReference<Bitmap> cloneUnderlyingBitmapReference = closeableStaticBitmap.cloneUnderlyingBitmapReference();
                    return cloneUnderlyingBitmapReference;
                }
            }
            CloseableReference.closeSafely((CloseableReference) closeableReference);
            return null;
        } finally {
            CloseableReference.closeSafely((CloseableReference) closeableReference);
        }
    }

    private static int getBitmapSizeBytes(CloseableReference<CloseableImage> closeableReference) {
        if (CloseableReference.isValid(closeableReference)) {
            return getBitmapSizeBytes((CloseableImage) closeableReference.get());
        }
        return null;
    }

    private static int getBitmapSizeBytes(CloseableImage closeableImage) {
        if (closeableImage instanceof CloseableBitmap) {
            return BitmapUtil.getSizeInBytes(((CloseableBitmap) closeableImage).getUnderlyingBitmap());
        }
        return null;
    }

    private static CloseableReference<CloseableImage> createImageReference(CloseableReference<Bitmap> closeableReference) {
        return CloseableReference.of(new CloseableStaticBitmap(closeableReference, ImmutableQualityInfo.FULL_QUALITY, 0));
    }
}
