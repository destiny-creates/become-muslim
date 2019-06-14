package com.facebook.ads.internal.view.component.p116a.p117a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.adapters.p086a.C1312d;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.view.component.p116a.C1597d;
import com.facebook.ads.internal.view.p114c.p115a.C3621a;

/* renamed from: com.facebook.ads.internal.view.component.a.a.a */
public class C4571a extends C3630b {
    /* renamed from: c */
    private static final int f12455c = ((int) (C1523w.f4503b * 12.0f));

    C4571a(C1597d c1597d, C1312d c1312d, String str, C3621a c3621a) {
        super(c1597d, c1312d, true, str, c3621a);
    }

    /* renamed from: a */
    protected void mo2873a(Context context) {
        View titleDescContainer = getTitleDescContainer();
        titleDescContainer.setAlignment(3);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(8, getMediaContainer().getId());
        titleDescContainer.setLayoutParams(layoutParams);
        titleDescContainer.setPadding(f12455c, f12455c, f12455c, f12455c);
        Drawable gradientDrawable = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{0, -15658735});
        gradientDrawable.setCornerRadius(0.0f);
        C1523w.m5343a(titleDescContainer, gradientDrawable);
        layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, getMediaContainer().getId());
        getCtaButton().setLayoutParams(layoutParams);
        addView(getMediaContainer());
        addView(titleDescContainer);
        addView(getCtaButton());
    }

    /* renamed from: d */
    protected boolean mo2874d() {
        return false;
    }

    /* renamed from: e */
    protected boolean mo1024e() {
        return false;
    }
}
