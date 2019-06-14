package com.facebook.ads.internal.view.component.p116a;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.adapters.p086a.C1312d;
import com.facebook.ads.internal.p105q.p106a.C1523w;

/* renamed from: com.facebook.ads.internal.view.component.a.a */
public class C3631a extends C1593b {
    public C3631a(C1597d c1597d, C1312d c1312d, boolean z) {
        super(c1597d, c1312d, true);
        View relativeLayout = new RelativeLayout(c1597d.m5564a());
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        Drawable gradientDrawable = new GradientDrawable(Orientation.BOTTOM_TOP, new int[]{-1778384896, 0});
        gradientDrawable.setCornerRadius(0.0f);
        gradientDrawable.setGradientType(0);
        C1523w.m5343a(relativeLayout, gradientDrawable);
        View linearLayout = new LinearLayout(c1597d.m5564a());
        linearLayout.setOrientation(z ^ 1);
        linearLayout.setGravity(80);
        C1523w.m5341a(linearLayout);
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(a, 0, a, c1597d.m5571h() == null ? a : a / 2);
        LayoutParams layoutParams3 = new LinearLayout.LayoutParams(z ? -2 : -1, -2);
        layoutParams3.setMargins(z ? a : 0, z ? 0 : a, 0, 0);
        LayoutParams layoutParams4 = new LinearLayout.LayoutParams(z ? 0 : -1, -2);
        layoutParams4.setMargins(0, 0, 0, 0);
        layoutParams4.weight = 1.0f;
        linearLayout.addView(getTitleDescContainer(), layoutParams4);
        linearLayout.addView(getCtaButton(), layoutParams3);
        relativeLayout.addView(linearLayout, layoutParams2);
        if (c1597d.m5571h() != null) {
            LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams5.setMargins(0, 0, 0, 0);
            layoutParams5.addRule(3, linearLayout.getId());
            relativeLayout.addView(c1597d.m5571h(), layoutParams5);
        }
        addView(c1597d.m5567d(), new RelativeLayout.LayoutParams(-1, -1));
        addView(relativeLayout, layoutParams);
        if (c1597d.m5572i() != null) {
            LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(b, b);
            layoutParams6.addRule(10);
            layoutParams6.addRule(11);
            layoutParams6.setMargins(a, a + c1597d.m5573j(), a, a);
            addView(c1597d.m5572i(), layoutParams6);
        }
    }

    /* renamed from: a */
    public boolean mo1023a() {
        return true;
    }
}
