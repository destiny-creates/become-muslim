package com.facebook.ads.internal.view.p119e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.adapters.p086a.C1312d;
import com.facebook.ads.internal.adapters.p086a.C1321k;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.p105q.p106a.C1520t;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.p111r.C1545a;
import com.facebook.ads.internal.view.C1566a.C1551a;
import com.facebook.ads.internal.view.component.C1599a;
import com.facebook.ads.internal.view.component.C1603e;
import com.facebook.ads.internal.view.component.C1606h;
import com.facebook.ads.internal.view.p113b.C1577d;
import com.facebook.ads.internal.view.p120f.p122b.C1627z;
import java.util.HashMap;

/* renamed from: com.facebook.ads.internal.view.e.a */
public class C1609a extends LinearLayout {
    /* renamed from: a */
    private static final int f4829a = ((int) (C1523w.f4503b * 12.0f));
    /* renamed from: b */
    private static final int f4830b = ((int) (C1523w.f4503b * 16.0f));
    /* renamed from: c */
    private final C1606h f4831c;
    /* renamed from: d */
    private final ImageView f4832d;
    /* renamed from: e */
    private final RelativeLayout f4833e;
    /* renamed from: f */
    private final C1599a f4834f;
    /* renamed from: g */
    private final int f4835g;

    public C1609a(Context context, int i, C1312d c1312d, C1412c c1412c, C1551a c1551a, boolean z, boolean z2, C1545a c1545a, C1520t c1520t) {
        Context context2 = context;
        int i2 = i;
        super(context);
        this.f4835g = i2;
        this.f4832d = new C1603e(context2);
        C1523w.m5342a(this.f4832d, 0);
        C1523w.m5341a(this.f4832d);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i2);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        layoutParams.setMargins(0, 0, f4829a, 0);
        if (z2) {
            r0.f4832d.setVisibility(8);
        }
        r0.f4831c = new C1606h(context, c1312d, true, z, true);
        r0.f4831c.setAlignment(8388611);
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(1, r0.f4832d.getId());
        layoutParams2.addRule(15);
        C1599a c1599a = r1;
        C1599a c1599a2 = new C1599a(context, true, false, C1627z.REWARDED_VIDEO_AD_CLICK.m5610a(), c1312d, c1412c, c1551a, c1545a, c1520t);
        r0.f4834f = c1599a;
        r0.f4834f.setVisibility(8);
        r0.f4833e = new RelativeLayout(context2);
        C1523w.m5341a(r0.f4833e);
        r0.f4833e.addView(r0.f4832d, layoutParams);
        r0.f4833e.addView(r0.f4831c, layoutParams2);
        addView(r0.f4833e, new LinearLayout.LayoutParams(-2, -2));
        Drawable gradientDrawable = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{0, -15658735});
        gradientDrawable.setCornerRadius(0.0f);
        C1523w.m5343a(r0, gradientDrawable);
    }

    /* renamed from: a */
    public void m5589a() {
        this.f4834f.setVisibility(0);
    }

    /* renamed from: a */
    public void m5590a(int i) {
        C1523w.m5346b(this.f4834f);
        int i2 = 1;
        if (i != 1) {
            i2 = 0;
        }
        setOrientation(i2);
        int i3 = -1;
        LayoutParams layoutParams = new LinearLayout.LayoutParams(i2 != 0 ? -1 : 0, -2);
        layoutParams.weight = 1.0f;
        if (i2 == 0) {
            i3 = -2;
        }
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i3, -2);
        layoutParams2.setMargins(i2 != 0 ? 0 : f4830b, i2 != 0 ? f4830b : 0, 0, 0);
        layoutParams2.gravity = 80;
        this.f4833e.setLayoutParams(layoutParams);
        addView(this.f4834f, layoutParams2);
    }

    public void setInfo(C1321k c1321k) {
        this.f4831c.m5586a(c1321k.m4559b().m4502a(), c1321k.m4559b().m4503b(), false, false);
        this.f4834f.m5582a(c1321k.m4561c(), c1321k.m4565g(), new HashMap());
        new C1577d(this.f4832d).m5505a(this.f4835g, this.f4835g).m5508a(c1321k.m4556a().m4546b());
    }
}
