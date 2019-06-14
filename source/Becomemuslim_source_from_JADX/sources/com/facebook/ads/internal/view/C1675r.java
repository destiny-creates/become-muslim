package com.facebook.ads.internal.view;

import android.content.Context;
import android.widget.RelativeLayout;

/* renamed from: com.facebook.ads.internal.view.r */
public class C1675r extends RelativeLayout {
    /* renamed from: a */
    private int f4975a = 0;
    /* renamed from: b */
    private int f4976b = 0;

    public C1675r(Context context) {
        super(context);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f4976b > 0 && getMeasuredWidth() > this.f4976b) {
            i = this.f4976b;
        } else if (getMeasuredWidth() < this.f4975a) {
            i = this.f4975a;
        } else {
            return;
        }
        setMeasuredDimension(i, getMeasuredHeight());
    }

    public void setMaxWidth(int i) {
        this.f4976b = i;
    }

    public void setMinWidth(int i) {
        this.f4975a = i;
    }
}
