package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageFrame;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;

public class AnimatedDrawableBackendImpl implements AnimatedDrawableBackend {
    private final AnimatedDrawableUtil mAnimatedDrawableUtil;
    private final AnimatedImage mAnimatedImage;
    private final AnimatedImageResult mAnimatedImageResult;
    private final int mDurationMs;
    private final int[] mFrameDurationsMs;
    private final AnimatedDrawableFrameInfo[] mFrameInfos;
    private final int[] mFrameTimestampsMs;
    private final Rect mRenderDstRect = new Rect();
    private final Rect mRenderSrcRect = new Rect();
    private final Rect mRenderedBounds;
    private Bitmap mTempBitmap;

    public AnimatedDrawableBackendImpl(AnimatedDrawableUtil animatedDrawableUtil, AnimatedImageResult animatedImageResult, Rect rect) {
        this.mAnimatedDrawableUtil = animatedDrawableUtil;
        this.mAnimatedImageResult = animatedImageResult;
        this.mAnimatedImage = animatedImageResult.getImage();
        this.mFrameDurationsMs = this.mAnimatedImage.getFrameDurations();
        this.mAnimatedDrawableUtil.fixFrameDurations(this.mFrameDurationsMs);
        this.mDurationMs = this.mAnimatedDrawableUtil.getTotalDurationFromFrameDurations(this.mFrameDurationsMs);
        this.mFrameTimestampsMs = this.mAnimatedDrawableUtil.getFrameTimeStampsFromDurations(this.mFrameDurationsMs);
        this.mRenderedBounds = getBoundsToUse(this.mAnimatedImage, rect);
        this.mFrameInfos = new AnimatedDrawableFrameInfo[this.mAnimatedImage.getFrameCount()];
        for (animatedDrawableUtil = null; animatedDrawableUtil < this.mAnimatedImage.getFrameCount(); animatedDrawableUtil++) {
            this.mFrameInfos[animatedDrawableUtil] = this.mAnimatedImage.getFrameInfo(animatedDrawableUtil);
        }
    }

    private static Rect getBoundsToUse(AnimatedImage animatedImage, Rect rect) {
        if (rect == null) {
            return new Rect(0, 0, animatedImage.getWidth(), animatedImage.getHeight());
        }
        return new Rect(0, 0, Math.min(rect.width(), animatedImage.getWidth()), Math.min(rect.height(), animatedImage.getHeight()));
    }

    public AnimatedImageResult getAnimatedImageResult() {
        return this.mAnimatedImageResult;
    }

    public int getDurationMs() {
        return this.mDurationMs;
    }

    public int getFrameCount() {
        return this.mAnimatedImage.getFrameCount();
    }

    public int getLoopCount() {
        return this.mAnimatedImage.getLoopCount();
    }

    public int getWidth() {
        return this.mAnimatedImage.getWidth();
    }

    public int getHeight() {
        return this.mAnimatedImage.getHeight();
    }

    public int getRenderedWidth() {
        return this.mRenderedBounds.width();
    }

    public int getRenderedHeight() {
        return this.mRenderedBounds.height();
    }

    public AnimatedDrawableFrameInfo getFrameInfo(int i) {
        return this.mFrameInfos[i];
    }

    public int getFrameForTimestampMs(int i) {
        return this.mAnimatedDrawableUtil.getFrameForTimestampMs(this.mFrameTimestampsMs, i);
    }

    public int getTimestampMsForFrame(int i) {
        Preconditions.checkElementIndex(i, this.mFrameTimestampsMs.length);
        return this.mFrameTimestampsMs[i];
    }

    public int getDurationMsForFrame(int i) {
        return this.mFrameDurationsMs[i];
    }

    public int getFrameForPreview() {
        return this.mAnimatedImageResult.getFrameForPreview();
    }

    public AnimatedDrawableBackend forNewBounds(Rect rect) {
        if (getBoundsToUse(this.mAnimatedImage, rect).equals(this.mRenderedBounds)) {
            return this;
        }
        return new AnimatedDrawableBackendImpl(this.mAnimatedDrawableUtil, this.mAnimatedImageResult, rect);
    }

    public synchronized int getMemoryUsage() {
        int i;
        i = 0;
        if (this.mTempBitmap != null) {
            i = 0 + this.mAnimatedDrawableUtil.getSizeOfBitmap(this.mTempBitmap);
        }
        return i + this.mAnimatedImage.getSizeInBytes();
    }

    public CloseableReference<Bitmap> getPreDecodedFrame(int i) {
        return this.mAnimatedImageResult.getDecodedFrame(i);
    }

    public boolean hasPreDecodedFrame(int i) {
        return this.mAnimatedImageResult.hasDecodedFrame(i);
    }

    public void renderFrame(int i, Canvas canvas) {
        i = this.mAnimatedImage.getFrame(i);
        try {
            if (this.mAnimatedImage.doesRenderSupportScaling()) {
                renderImageSupportsScaling(canvas, i);
            } else {
                renderImageDoesNotSupportScaling(canvas, i);
            }
            i.dispose();
        } catch (Throwable th) {
            i.dispose();
        }
    }

    private synchronized void prepareTempBitmapForThisSize(int i, int i2) {
        if (this.mTempBitmap != null && (this.mTempBitmap.getWidth() < i || this.mTempBitmap.getHeight() < i2)) {
            clearTempBitmap();
        }
        if (this.mTempBitmap == null) {
            this.mTempBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        }
        this.mTempBitmap.eraseColor(0);
    }

    private void renderImageSupportsScaling(Canvas canvas, AnimatedImageFrame animatedImageFrame) {
        double width = ((double) this.mRenderedBounds.width()) / ((double) this.mAnimatedImage.getWidth());
        double height = ((double) this.mRenderedBounds.height()) / ((double) this.mAnimatedImage.getHeight());
        int round = (int) Math.round(((double) animatedImageFrame.getWidth()) * width);
        int round2 = (int) Math.round(((double) animatedImageFrame.getHeight()) * height);
        int xOffset = (int) (((double) animatedImageFrame.getXOffset()) * width);
        int yOffset = (int) (((double) animatedImageFrame.getYOffset()) * height);
        synchronized (this) {
            int width2 = this.mRenderedBounds.width();
            int height2 = this.mRenderedBounds.height();
            prepareTempBitmapForThisSize(width2, height2);
            animatedImageFrame.renderFrame(round, round2, this.mTempBitmap);
            this.mRenderSrcRect.set(0, 0, width2, height2);
            this.mRenderDstRect.set(xOffset, yOffset, width2 + xOffset, height2 + yOffset);
            canvas.drawBitmap(this.mTempBitmap, this.mRenderSrcRect, this.mRenderDstRect, null);
        }
    }

    private void renderImageDoesNotSupportScaling(Canvas canvas, AnimatedImageFrame animatedImageFrame) {
        int width = animatedImageFrame.getWidth();
        int height = animatedImageFrame.getHeight();
        int xOffset = animatedImageFrame.getXOffset();
        int yOffset = animatedImageFrame.getYOffset();
        synchronized (this) {
            prepareTempBitmapForThisSize(width, height);
            animatedImageFrame.renderFrame(width, height, this.mTempBitmap);
            this.mRenderSrcRect.set(0, 0, width, height);
            this.mRenderDstRect.set(0, 0, width, height);
            canvas.save();
            canvas.translate((float) xOffset, (float) yOffset);
            canvas.drawBitmap(this.mTempBitmap, this.mRenderSrcRect, this.mRenderDstRect, null);
            canvas.restore();
        }
    }

    public synchronized void dropCaches() {
        clearTempBitmap();
    }

    private synchronized void clearTempBitmap() {
        if (this.mTempBitmap != null) {
            this.mTempBitmap.recycle();
            this.mTempBitmap = null;
        }
    }
}
