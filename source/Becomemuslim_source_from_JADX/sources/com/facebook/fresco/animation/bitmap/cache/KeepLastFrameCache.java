package com.facebook.fresco.animation.bitmap.cache;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache.FrameCacheListener;
import com.facebook.imageutils.BitmapUtil;

public class KeepLastFrameCache implements BitmapFrameCache {
    private static final int FRAME_NUMBER_UNSET = -1;
    private FrameCacheListener mFrameCacheListener;
    private CloseableReference<Bitmap> mLastBitmapReference;
    private int mLastFrameNumber = -1;

    public void onFramePrepared(int i, CloseableReference<Bitmap> closeableReference, int i2) {
    }

    public synchronized CloseableReference<Bitmap> getCachedFrame(int i) {
        if (this.mLastFrameNumber != i) {
            return 0;
        }
        return CloseableReference.cloneOrNull(this.mLastBitmapReference);
    }

    public synchronized CloseableReference<Bitmap> getFallbackFrame(int i) {
        return CloseableReference.cloneOrNull(this.mLastBitmapReference);
    }

    public synchronized CloseableReference<Bitmap> getBitmapToReuseForFrame(int i, int i2, int i3) {
        try {
            i = CloseableReference.cloneOrNull(this.mLastBitmapReference);
            closeAndResetLastBitmapReference();
        } catch (Throwable th) {
            closeAndResetLastBitmapReference();
        }
        return i;
    }

    public synchronized boolean contains(int i) {
        i = (i != this.mLastFrameNumber || CloseableReference.isValid(this.mLastBitmapReference) == 0) ? 0 : 1;
        return i;
    }

    public synchronized int getSizeInBytes() {
        int i;
        if (this.mLastBitmapReference == null) {
            i = 0;
        } else {
            i = BitmapUtil.getSizeInBytes((Bitmap) this.mLastBitmapReference.get());
        }
        return i;
    }

    public synchronized void clear() {
        closeAndResetLastBitmapReference();
    }

    public synchronized void onFrameRendered(int i, CloseableReference<Bitmap> closeableReference, int i2) {
        if (closeableReference != null) {
            if (!(this.mLastBitmapReference == 0 || ((Bitmap) closeableReference.get()).equals(this.mLastBitmapReference.get()) == 0)) {
                return;
            }
        }
        CloseableReference.closeSafely(this.mLastBitmapReference);
        if (!(this.mFrameCacheListener == 0 || this.mLastFrameNumber == -1)) {
            this.mFrameCacheListener.onFrameEvicted(this, this.mLastFrameNumber);
        }
        this.mLastBitmapReference = CloseableReference.cloneOrNull((CloseableReference) closeableReference);
        if (this.mFrameCacheListener != null) {
            this.mFrameCacheListener.onFrameCached(this, i);
        }
        this.mLastFrameNumber = i;
    }

    public void setFrameCacheListener(FrameCacheListener frameCacheListener) {
        this.mFrameCacheListener = frameCacheListener;
    }

    private synchronized void closeAndResetLastBitmapReference() {
        if (!(this.mFrameCacheListener == null || this.mLastFrameNumber == -1)) {
            this.mFrameCacheListener.onFrameEvicted(this, this.mLastFrameNumber);
        }
        CloseableReference.closeSafely(this.mLastBitmapReference);
        this.mLastBitmapReference = null;
        this.mLastFrameNumber = -1;
    }
}
