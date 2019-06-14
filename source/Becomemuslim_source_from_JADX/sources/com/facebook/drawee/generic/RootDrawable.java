package com.facebook.drawee.generic;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.VisibilityAwareDrawable;
import com.facebook.drawee.drawable.VisibilityCallback;

public class RootDrawable extends ForwardingDrawable implements VisibilityAwareDrawable {
    @VisibleForTesting
    Drawable mControllerOverlay = null;
    private VisibilityCallback mVisibilityCallback;

    public int getIntrinsicHeight() {
        return -1;
    }

    public int getIntrinsicWidth() {
        return -1;
    }

    public RootDrawable(Drawable drawable) {
        super(drawable);
    }

    public void setVisibilityCallback(VisibilityCallback visibilityCallback) {
        this.mVisibilityCallback = visibilityCallback;
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (this.mVisibilityCallback != null) {
            this.mVisibilityCallback.onVisibilityChange(z);
        }
        return super.setVisible(z, z2);
    }

    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        if (isVisible()) {
            if (this.mVisibilityCallback != null) {
                this.mVisibilityCallback.onDraw();
            }
            super.draw(canvas);
            if (this.mControllerOverlay != null) {
                this.mControllerOverlay.setBounds(getBounds());
                this.mControllerOverlay.draw(canvas);
            }
        }
    }

    public void setControllerOverlay(Drawable drawable) {
        this.mControllerOverlay = drawable;
        invalidateSelf();
    }
}
