package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imageutils.JfifUtil;
import java.util.Arrays;

public class FadeDrawable extends ArrayDrawable {
    @VisibleForTesting
    public static final int TRANSITION_NONE = 2;
    @VisibleForTesting
    public static final int TRANSITION_RUNNING = 1;
    @VisibleForTesting
    public static final int TRANSITION_STARTING = 0;
    @VisibleForTesting
    int mAlpha;
    @VisibleForTesting
    int[] mAlphas;
    @VisibleForTesting
    int mDurationMs;
    @VisibleForTesting
    boolean[] mIsLayerOn;
    private final Drawable[] mLayers;
    @VisibleForTesting
    int mPreventInvalidateCount;
    @VisibleForTesting
    int[] mStartAlphas;
    @VisibleForTesting
    long mStartTimeMs;
    @VisibleForTesting
    int mTransitionState;

    public FadeDrawable(Drawable[] drawableArr) {
        super(drawableArr);
        boolean z = true;
        if (drawableArr.length < 1) {
            z = false;
        }
        Preconditions.checkState(z, "At least one layer required!");
        this.mLayers = drawableArr;
        this.mStartAlphas = new int[drawableArr.length];
        this.mAlphas = new int[drawableArr.length];
        this.mAlpha = JfifUtil.MARKER_FIRST_BYTE;
        this.mIsLayerOn = new boolean[drawableArr.length];
        this.mPreventInvalidateCount = 0;
        resetInternal();
    }

    public void invalidateSelf() {
        if (this.mPreventInvalidateCount == 0) {
            super.invalidateSelf();
        }
    }

    public void beginBatchMode() {
        this.mPreventInvalidateCount++;
    }

    public void endBatchMode() {
        this.mPreventInvalidateCount--;
        invalidateSelf();
    }

    public void setTransitionDuration(int i) {
        this.mDurationMs = i;
        if (this.mTransitionState == 1) {
            this.mTransitionState = 0;
        }
    }

    public int getTransitionDuration() {
        return this.mDurationMs;
    }

    private void resetInternal() {
        this.mTransitionState = 2;
        Arrays.fill(this.mStartAlphas, 0);
        this.mStartAlphas[0] = JfifUtil.MARKER_FIRST_BYTE;
        Arrays.fill(this.mAlphas, 0);
        this.mAlphas[0] = JfifUtil.MARKER_FIRST_BYTE;
        Arrays.fill(this.mIsLayerOn, false);
        this.mIsLayerOn[0] = true;
    }

    public void reset() {
        resetInternal();
        invalidateSelf();
    }

    public void fadeInLayer(int i) {
        this.mTransitionState = 0;
        this.mIsLayerOn[i] = true;
        invalidateSelf();
    }

    public void fadeOutLayer(int i) {
        this.mTransitionState = 0;
        this.mIsLayerOn[i] = false;
        invalidateSelf();
    }

    public void fadeInAllLayers() {
        this.mTransitionState = 0;
        Arrays.fill(this.mIsLayerOn, true);
        invalidateSelf();
    }

    public void fadeOutAllLayers() {
        this.mTransitionState = 0;
        Arrays.fill(this.mIsLayerOn, false);
        invalidateSelf();
    }

    public void fadeToLayer(int i) {
        this.mTransitionState = 0;
        Arrays.fill(this.mIsLayerOn, false);
        this.mIsLayerOn[i] = true;
        invalidateSelf();
    }

    public void fadeUpToLayer(int i) {
        this.mTransitionState = 0;
        i++;
        Arrays.fill(this.mIsLayerOn, 0, i, true);
        Arrays.fill(this.mIsLayerOn, i, this.mLayers.length, false);
        invalidateSelf();
    }

    public void finishTransitionImmediately() {
        this.mTransitionState = 2;
        for (int i = 0; i < this.mLayers.length; i++) {
            this.mAlphas[i] = this.mIsLayerOn[i] ? JfifUtil.MARKER_FIRST_BYTE : 0;
        }
        invalidateSelf();
    }

    private boolean updateAlphas(float f) {
        int i = 0;
        boolean z = true;
        while (i < this.mLayers.length) {
            this.mAlphas[i] = (int) (((float) this.mStartAlphas[i]) + (((float) ((this.mIsLayerOn[i] ? 1 : -1) * JfifUtil.MARKER_FIRST_BYTE)) * f));
            if (this.mAlphas[i] < 0) {
                this.mAlphas[i] = 0;
            }
            if (this.mAlphas[i] > 255) {
                this.mAlphas[i] = JfifUtil.MARKER_FIRST_BYTE;
            }
            if (this.mIsLayerOn[i] && this.mAlphas[i] < 255) {
                z = false;
            }
            if (!this.mIsLayerOn[i] && this.mAlphas[i] > 0) {
                z = false;
            }
            i++;
        }
        return z;
    }

    public void draw(Canvas canvas) {
        boolean updateAlphas;
        int i = 2;
        int i2 = 0;
        switch (this.mTransitionState) {
            case 0:
                System.arraycopy(this.mAlphas, 0, this.mStartAlphas, 0, this.mLayers.length);
                this.mStartTimeMs = getCurrentTimeMs();
                updateAlphas = updateAlphas(this.mDurationMs == 0 ? 1.0f : 0.0f);
                if (!updateAlphas) {
                    i = 1;
                }
                this.mTransitionState = i;
                break;
            case 1:
                Preconditions.checkState(this.mDurationMs > 0);
                updateAlphas = updateAlphas(((float) (getCurrentTimeMs() - this.mStartTimeMs)) / ((float) this.mDurationMs));
                if (!updateAlphas) {
                    i = 1;
                }
                this.mTransitionState = i;
                break;
            default:
                updateAlphas = true;
                break;
        }
        while (i2 < this.mLayers.length) {
            drawDrawableWithAlpha(canvas, this.mLayers[i2], (this.mAlphas[i2] * this.mAlpha) / JfifUtil.MARKER_FIRST_BYTE);
            i2++;
        }
        if (!updateAlphas) {
            invalidateSelf();
        }
    }

    private void drawDrawableWithAlpha(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.mPreventInvalidateCount++;
            drawable.mutate().setAlpha(i);
            this.mPreventInvalidateCount--;
            drawable.draw(canvas);
        }
    }

    public void setAlpha(int i) {
        if (this.mAlpha != i) {
            this.mAlpha = i;
            invalidateSelf();
        }
    }

    public int getAlpha() {
        return this.mAlpha;
    }

    protected long getCurrentTimeMs() {
        return SystemClock.uptimeMillis();
    }

    @VisibleForTesting
    public int getTransitionState() {
        return this.mTransitionState;
    }

    public boolean isLayerOn(int i) {
        return this.mIsLayerOn[i];
    }
}
