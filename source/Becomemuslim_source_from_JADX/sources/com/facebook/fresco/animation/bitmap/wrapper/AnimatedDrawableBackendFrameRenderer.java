package com.facebook.fresco.animation.bitmap.wrapper;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.fresco.animation.bitmap.BitmapFrameRenderer;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback;

public class AnimatedDrawableBackendFrameRenderer implements BitmapFrameRenderer {
    private static final Class<?> TAG = AnimatedDrawableBackendFrameRenderer.class;
    private AnimatedDrawableBackend mAnimatedDrawableBackend;
    private AnimatedImageCompositor mAnimatedImageCompositor;
    private final BitmapFrameCache mBitmapFrameCache;
    private final Callback mCallback = new C37251();

    /* renamed from: com.facebook.fresco.animation.bitmap.wrapper.AnimatedDrawableBackendFrameRenderer$1 */
    class C37251 implements Callback {
        public void onIntermediateResult(int i, Bitmap bitmap) {
        }

        C37251() {
        }

        public CloseableReference<Bitmap> getCachedBitmap(int i) {
            return AnimatedDrawableBackendFrameRenderer.this.mBitmapFrameCache.getCachedFrame(i);
        }
    }

    public AnimatedDrawableBackendFrameRenderer(BitmapFrameCache bitmapFrameCache, AnimatedDrawableBackend animatedDrawableBackend) {
        this.mBitmapFrameCache = bitmapFrameCache;
        this.mAnimatedDrawableBackend = animatedDrawableBackend;
        this.mAnimatedImageCompositor = new AnimatedImageCompositor(this.mAnimatedDrawableBackend, this.mCallback);
    }

    public void setBounds(Rect rect) {
        rect = this.mAnimatedDrawableBackend.forNewBounds(rect);
        if (rect != this.mAnimatedDrawableBackend) {
            this.mAnimatedDrawableBackend = rect;
            this.mAnimatedImageCompositor = new AnimatedImageCompositor(this.mAnimatedDrawableBackend, this.mCallback);
        }
    }

    public int getIntrinsicWidth() {
        return this.mAnimatedDrawableBackend.getWidth();
    }

    public int getIntrinsicHeight() {
        return this.mAnimatedDrawableBackend.getHeight();
    }

    public boolean renderFrame(int i, Bitmap bitmap) {
        try {
            this.mAnimatedImageCompositor.renderFrame(i, bitmap);
            return true;
        } catch (Throwable e) {
            FLog.m5673e(TAG, e, "Rendering of frame unsuccessful. Frame number: %d", Integer.valueOf(i));
            return false;
        }
    }
}
