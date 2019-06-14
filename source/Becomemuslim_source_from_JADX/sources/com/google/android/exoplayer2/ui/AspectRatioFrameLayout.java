package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.ui.C2579a.C2578a;

public final class AspectRatioFrameLayout extends FrameLayout {
    /* renamed from: a */
    private float f6575a;
    /* renamed from: b */
    private int f6576b;

    public AspectRatioFrameLayout(Context context) {
        this(context, null);
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6576b = 0;
        if (attributeSet != null) {
            context = context.getTheme().obtainStyledAttributes(attributeSet, C2578a.AspectRatioFrameLayout, 0, 0);
            try {
                this.f6576b = context.getInt(C2578a.AspectRatioFrameLayout_resize_mode, 0);
            } finally {
                context.recycle();
            }
        }
    }

    public void setAspectRatio(float f) {
        if (this.f6575a != f) {
            this.f6575a = f;
            requestLayout();
        }
    }

    public int getResizeMode() {
        return this.f6576b;
    }

    public void setResizeMode(int i) {
        if (this.f6576b != i) {
            this.f6576b = i;
            requestLayout();
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f6576b != 3) {
            if (this.f6575a > 0) {
                i = getMeasuredWidth();
                int measuredHeight = getMeasuredHeight();
                float f = (float) i;
                float f2 = (float) measuredHeight;
                float f3 = (this.f6575a / (f / f2)) - 1.0f;
                if (Math.abs(f3) > 0.01f) {
                    int i3 = this.f6576b;
                    if (i3 != 4) {
                        switch (i3) {
                            case 1:
                                measuredHeight = (int) (f / this.f6575a);
                                break;
                            case 2:
                                i = (int) (f2 * this.f6575a);
                                break;
                            default:
                                if (f3 <= 0.0f) {
                                    i = (int) (f2 * this.f6575a);
                                    break;
                                } else {
                                    measuredHeight = (int) (f / this.f6575a);
                                    break;
                                }
                        }
                    } else if (f3 > 0.0f) {
                        i = (int) (f2 * this.f6575a);
                    } else {
                        measuredHeight = (int) (f / this.f6575a);
                    }
                    super.onMeasure(MeasureSpec.makeMeasureSpec(i, 1073741824), MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
                }
            }
        }
    }
}
