package com.facebook.ads.internal.view;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.View.MeasureSpec;
import android.widget.TextView;

/* renamed from: com.facebook.ads.internal.view.p */
public class C1673p extends TextView {
    /* renamed from: a */
    private int f4970a;
    /* renamed from: b */
    private float f4971b;
    /* renamed from: c */
    private float f4972c = 8.0f;

    public C1673p(Context context, int i) {
        super(context);
        setMaxLines(i);
        setEllipsize(TruncateAt.END);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.setMaxLines(this.f4970a + 1);
        super.setTextSize(this.f4971b);
        int i5 = i3 - i;
        int i6 = i4 - i2;
        measure(MeasureSpec.makeMeasureSpec(i5, 1073741824), MeasureSpec.makeMeasureSpec(i6, 0));
        if (getMeasuredHeight() > i6) {
            float f = this.f4971b;
            while (f > this.f4972c) {
                f -= 0.5f;
                super.setTextSize(f);
                measure(MeasureSpec.makeMeasureSpec(i5, 1073741824), 0);
                if (getMeasuredHeight() <= i6 && getLineCount() <= this.f4970a) {
                    break;
                }
            }
        }
        super.setMaxLines(this.f4970a);
        setMeasuredDimension(i5, i6);
        super.onLayout(z, i, i2, i3, i4);
    }

    public void setMaxLines(int i) {
        this.f4970a = i;
        super.setMaxLines(i);
    }

    public void setMinTextSize(float f) {
        this.f4972c = f;
    }

    public void setTextSize(float f) {
        this.f4971b = f;
        super.setTextSize(f);
    }
}
