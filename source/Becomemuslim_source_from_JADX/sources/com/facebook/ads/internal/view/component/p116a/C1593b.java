package com.facebook.ads.internal.view.component.p116a;

import android.widget.RelativeLayout;
import com.facebook.ads.internal.adapters.p086a.C1312d;
import com.facebook.ads.internal.adapters.p086a.C1316h;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.view.component.C1599a;
import com.facebook.ads.internal.view.component.C1606h;
import java.util.HashMap;

/* renamed from: com.facebook.ads.internal.view.component.a.b */
public abstract class C1593b extends RelativeLayout {
    /* renamed from: a */
    static final int f4755a = ((int) (C1523w.f4503b * 16.0f));
    /* renamed from: b */
    static final int f4756b = ((int) (C1523w.f4503b * 28.0f));
    /* renamed from: c */
    private final C1606h f4757c;
    /* renamed from: d */
    private final C1599a f4758d;
    /* renamed from: e */
    private final C1412c f4759e;

    protected C1593b(C1597d c1597d, C1312d c1312d, boolean z) {
        super(c1597d.m5564a());
        this.f4759e = c1597d.m5565b();
        this.f4758d = new C1599a(c1597d.m5564a(), mo2874d(), mo1024e(), "com.facebook.ads.interstitial.clicked", c1312d, c1597d.m5565b(), c1597d.m5566c(), c1597d.m5568e(), c1597d.m5569f());
        C1523w.m5341a(this.f4758d);
        this.f4757c = new C1606h(getContext(), c1312d, z, mo2875b(), mo1026c());
        C1523w.m5341a(this.f4757c);
    }

    /* renamed from: a */
    public void mo1025a(C1316h c1316h, String str, double d) {
        C1606h c1606h = this.f4757c;
        String b = c1316h.m4533a().m4503b();
        String c = c1316h.m4533a().m4504c();
        boolean z = !mo1023a() && d > 0.0d && d < 1.0d;
        c1606h.m5586a(b, c, false, z);
        this.f4758d.m5582a(c1316h.m4534b(), str, new HashMap());
    }

    /* renamed from: a */
    public abstract boolean mo1023a();

    /* renamed from: b */
    protected boolean mo2875b() {
        return true;
    }

    /* renamed from: c */
    protected boolean mo1026c() {
        return true;
    }

    /* renamed from: d */
    protected boolean mo2874d() {
        return true;
    }

    /* renamed from: e */
    protected boolean mo1024e() {
        return true;
    }

    public C1412c getAdEventManager() {
        return this.f4759e;
    }

    protected C1599a getCtaButton() {
        return this.f4758d;
    }

    protected C1606h getTitleDescContainer() {
        return this.f4757c;
    }
}
