package com.google.maps.android.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class RotationLayout extends FrameLayout {
    /* renamed from: a */
    private int f18191a;

    public RotationLayout(Context context) {
        super(context);
    }

    public RotationLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RotationLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onMeasure(int i, int i2) {
        if (this.f18191a != 1) {
            if (this.f18191a != 3) {
                super.onMeasure(i, i2);
                return;
            }
        }
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
    }

    public void setViewRotation(int i) {
        this.f18191a = ((i + 360) % 360) / 90;
    }

    public void dispatchDraw(Canvas canvas) {
        if (this.f18191a == 0) {
            super.dispatchDraw(canvas);
            return;
        }
        if (this.f18191a == 1) {
            canvas.translate((float) getWidth(), 0.0f);
            canvas.rotate(90.0f, (float) (getWidth() / 2), 0.0f);
            canvas.translate((float) (getHeight() / 2), (float) (getWidth() / 2));
        } else if (this.f18191a == 2) {
            canvas.rotate(180.0f, (float) (getWidth() / 2), (float) (getHeight() / 2));
        } else {
            canvas.translate(0.0f, (float) getHeight());
            canvas.rotate(270.0f, (float) (getWidth() / 2), 0.0f);
            canvas.translate((float) (getHeight() / 2), (float) ((-getWidth()) / 2));
        }
        super.dispatchDraw(canvas);
    }
}
