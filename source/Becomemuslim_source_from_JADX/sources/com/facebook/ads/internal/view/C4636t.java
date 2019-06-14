package com.facebook.ads.internal.view;

import android.content.Context;
import android.view.View.MeasureSpec;
import com.facebook.ads.internal.view.p120f.C3640a;

/* renamed from: com.facebook.ads.internal.view.t */
public class C4636t extends C3640a {
    public C4636t(Context context) {
        super(context);
    }

    protected void onMeasure(int i, int i2) {
        if (MeasureSpec.getMode(i) == 1073741824) {
            i2 = i;
        } else if (MeasureSpec.getMode(i2) == 1073741824) {
            i = i2;
        }
        super.onMeasure(i, i2);
    }
}
