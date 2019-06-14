package com.facebook.ads.internal.view.component.p116a;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.adapters.p086a.C1312d;
import com.facebook.ads.internal.adapters.p086a.C1316h;

/* renamed from: com.facebook.ads.internal.view.component.a.e */
public class C3632e extends C1593b {
    /* renamed from: c */
    private static final int f9729c = Resources.getSystem().getDisplayMetrics().widthPixels;
    /* renamed from: d */
    private final C1598f f9730d;

    public C3632e(C1597d c1597d, boolean z, C1312d c1312d) {
        super(c1597d, c1312d, z);
        this.f9730d = new C1598f(c1597d.m5564a(), c1597d.m5567d());
        this.f9730d.m5576a(c1597d.m5571h(), c1597d.m5572i(), getTitleDescContainer(), z);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.setMargins(a, a, a, a);
        getCtaButton().setLayoutParams(layoutParams);
        View frameLayout = new FrameLayout(c1597d.m5564a());
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(2, getCtaButton().getId());
        frameLayout.setLayoutParams(layoutParams2);
        layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 17;
        layoutParams2.setMargins(a, 0, a, 0);
        frameLayout.addView(this.f9730d, layoutParams2);
        addView(frameLayout);
        addView(getCtaButton());
    }

    /* renamed from: a */
    public void mo1025a(C1316h c1316h, String str, double d) {
        super.mo1025a(c1316h, str, d);
        if (d > 0.0d) {
            this.f9730d.m5575a((int) (((double) (f9729c - (a * 2))) / d));
        }
    }

    /* renamed from: a */
    public boolean mo1023a() {
        return false;
    }

    /* renamed from: c */
    protected boolean mo1026c() {
        return false;
    }

    /* renamed from: e */
    protected boolean mo1024e() {
        return false;
    }
}
