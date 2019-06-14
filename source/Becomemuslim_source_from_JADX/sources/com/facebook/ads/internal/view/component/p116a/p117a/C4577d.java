package com.facebook.ads.internal.view.component.p116a.p117a;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.ads.internal.adapters.p086a.C1312d;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.view.component.p116a.C1597d;
import com.facebook.ads.internal.view.p114c.p115a.C3621a;

/* renamed from: com.facebook.ads.internal.view.component.a.a.d */
public class C4577d extends C3630b {
    /* renamed from: c */
    private static final int f12461c = ((int) (C1523w.f4503b * 20.0f));
    /* renamed from: d */
    private static final int f12462d = ((int) (C1523w.f4503b * 16.0f));

    C4577d(C1597d c1597d, C1312d c1312d, String str, C3621a c3621a) {
        super(c1597d, c1312d, false, str, c3621a);
    }

    /* renamed from: a */
    protected void mo2873a(Context context) {
        View titleDescContainer = getTitleDescContainer();
        titleDescContainer.setAlignment(3);
        titleDescContainer.setLayoutParams(new LayoutParams(-1, -2));
        titleDescContainer.setPadding(0, 0, 0, f12461c);
        getCtaButton().setLayoutParams(new LayoutParams(-1, -2));
        View linearLayout = new LinearLayout(context);
        C1523w.m5343a(linearLayout, new ColorDrawable(-1));
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.addRule(3, getMediaContainer().getId());
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(f12462d, f12462d, f12462d, f12462d);
        linearLayout.addView(titleDescContainer);
        linearLayout.addView(getCtaButton());
        addView(getMediaContainer());
        addView(linearLayout);
    }

    /* renamed from: b */
    protected boolean mo2875b() {
        return false;
    }
}
