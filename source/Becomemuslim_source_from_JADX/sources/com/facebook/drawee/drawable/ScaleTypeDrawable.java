package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.drawable.ScalingUtils.StatefulScaleType;

public class ScaleTypeDrawable extends ForwardingDrawable {
    @VisibleForTesting
    Matrix mDrawMatrix;
    @VisibleForTesting
    PointF mFocusPoint = null;
    @VisibleForTesting
    ScaleType mScaleType;
    @VisibleForTesting
    Object mScaleTypeState;
    private Matrix mTempMatrix = new Matrix();
    @VisibleForTesting
    int mUnderlyingHeight = 0;
    @VisibleForTesting
    int mUnderlyingWidth = 0;

    public ScaleTypeDrawable(Drawable drawable, ScaleType scaleType) {
        super((Drawable) Preconditions.checkNotNull(drawable));
        this.mScaleType = scaleType;
    }

    public Drawable setCurrent(Drawable drawable) {
        drawable = super.setCurrent(drawable);
        configureBounds();
        return drawable;
    }

    public ScaleType getScaleType() {
        return this.mScaleType;
    }

    public void setScaleType(ScaleType scaleType) {
        if (!Objects.equal(this.mScaleType, scaleType)) {
            this.mScaleType = scaleType;
            this.mScaleTypeState = null;
            configureBounds();
            invalidateSelf();
        }
    }

    public PointF getFocusPoint() {
        return this.mFocusPoint;
    }

    public void setFocusPoint(PointF pointF) {
        if (!Objects.equal(this.mFocusPoint, pointF)) {
            if (this.mFocusPoint == null) {
                this.mFocusPoint = new PointF();
            }
            this.mFocusPoint.set(pointF);
            configureBounds();
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        configureBoundsIfUnderlyingChanged();
        if (this.mDrawMatrix != null) {
            int save = canvas.save();
            canvas.clipRect(getBounds());
            canvas.concat(this.mDrawMatrix);
            super.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        super.draw(canvas);
    }

    protected void onBoundsChange(Rect rect) {
        configureBounds();
    }

    private void configureBoundsIfUnderlyingChanged() {
        Object obj = 1;
        Object obj2;
        if (this.mScaleType instanceof StatefulScaleType) {
            Object state = ((StatefulScaleType) this.mScaleType).getState();
            if (state != null) {
                if (state.equals(this.mScaleTypeState)) {
                    obj2 = null;
                    this.mScaleTypeState = state;
                }
            }
            obj2 = 1;
            this.mScaleTypeState = state;
        } else {
            obj2 = null;
        }
        if (this.mUnderlyingWidth == getCurrent().getIntrinsicWidth()) {
            if (this.mUnderlyingHeight == getCurrent().getIntrinsicHeight()) {
                obj = null;
            }
        }
        if (obj != null || r3 != null) {
            configureBounds();
        }
    }

    @VisibleForTesting
    void configureBounds() {
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.mUnderlyingWidth = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.mUnderlyingHeight = intrinsicHeight;
        if (intrinsicWidth > 0) {
            if (intrinsicHeight > 0) {
                if (intrinsicWidth == width && intrinsicHeight == height) {
                    current.setBounds(bounds);
                    this.mDrawMatrix = null;
                    return;
                } else if (this.mScaleType == ScaleType.FIT_XY) {
                    current.setBounds(bounds);
                    this.mDrawMatrix = null;
                    return;
                } else {
                    current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                    this.mScaleType.getTransform(this.mTempMatrix, bounds, intrinsicWidth, intrinsicHeight, this.mFocusPoint != null ? this.mFocusPoint.x : 0.5f, this.mFocusPoint != null ? this.mFocusPoint.y : 0.5f);
                    this.mDrawMatrix = this.mTempMatrix;
                    return;
                }
            }
        }
        current.setBounds(bounds);
        this.mDrawMatrix = null;
    }

    public void getTransform(Matrix matrix) {
        getParentTransform(matrix);
        configureBoundsIfUnderlyingChanged();
        if (this.mDrawMatrix != null) {
            matrix.preConcat(this.mDrawMatrix);
        }
    }
}
