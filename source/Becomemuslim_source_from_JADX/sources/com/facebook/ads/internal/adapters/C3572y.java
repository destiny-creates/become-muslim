package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.view.View;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.p099n.C1418c;
import com.facebook.ads.internal.p099n.C1425f;
import com.facebook.ads.internal.p099n.C1425f.C1424c;
import com.facebook.ads.internal.p099n.C1427h;
import com.facebook.ads.internal.p099n.C1428j;
import com.facebook.ads.internal.p099n.C1429k;
import com.facebook.ads.internal.p099n.C1431m;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.List;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.adapters.y */
public abstract class C3572y implements AdAdapter {
    /* renamed from: a */
    private AdPlacementType f9546a = AdPlacementType.NATIVE;

    /* renamed from: A */
    public abstract String mo2816A();

    /* renamed from: B */
    public abstract String mo2817B();

    /* renamed from: C */
    public abstract C1431m mo2818C();

    /* renamed from: D */
    public abstract int mo2819D();

    /* renamed from: E */
    public abstract String mo2820E();

    /* renamed from: F */
    public abstract List<C1425f> mo2821F();

    /* renamed from: G */
    public abstract int mo2822G();

    /* renamed from: H */
    public abstract int mo2823H();

    /* renamed from: I */
    public abstract C1418c mo2824I();

    /* renamed from: K */
    public String mo2864K() {
        return mo2848p();
    }

    /* renamed from: a */
    public abstract void mo2826a(int i);

    /* renamed from: a */
    public abstract void mo2827a(Context context, C1346z c1346z, C1412c c1412c, Map<String, Object> map, C1424c c1424c);

    /* renamed from: a */
    public abstract void mo2828a(View view, List<View> list);

    /* renamed from: a */
    public abstract void mo2829a(C1346z c1346z);

    /* renamed from: a */
    protected void m11607a(AdPlacementType adPlacementType) {
        this.f9546a = adPlacementType;
    }

    /* renamed from: a */
    public abstract void mo2830a(Map<String, String> map);

    public boolean a_() {
        return true;
    }

    /* renamed from: b */
    public abstract void mo2831b(Map<String, String> map);

    public abstract void b_();

    /* renamed from: c */
    public abstract String mo2833c();

    public abstract boolean c_();

    /* renamed from: d */
    public abstract boolean mo2835d();

    /* renamed from: e */
    public abstract boolean mo2836e();

    /* renamed from: f */
    public abstract boolean mo2837f();

    /* renamed from: g */
    public abstract boolean mo2838g();

    public final AdPlacementType getPlacementType() {
        return this.f9546a;
    }

    /* renamed from: h */
    public abstract int mo2839h();

    /* renamed from: i */
    public abstract int mo2840i();

    /* renamed from: j */
    public abstract int mo2841j();

    /* renamed from: k */
    public abstract C1427h mo2842k();

    /* renamed from: l */
    public abstract C1427h mo2843l();

    /* renamed from: m */
    public abstract C1429k mo2844m();

    /* renamed from: n */
    public abstract String mo2845n();

    /* renamed from: o */
    public abstract String mo2846o();

    /* renamed from: p */
    public abstract String mo2848p();

    /* renamed from: q */
    public abstract String mo2849q();

    /* renamed from: r */
    public abstract String mo2850r();

    /* renamed from: s */
    public abstract String mo2851s();

    /* renamed from: t */
    public abstract String mo2852t();

    /* renamed from: u */
    public abstract String mo2853u();

    /* renamed from: v */
    public abstract String mo2854v();

    /* renamed from: w */
    public abstract C1428j mo2855w();

    /* renamed from: x */
    public abstract C1427h mo2856x();

    /* renamed from: y */
    public abstract String mo2857y();

    /* renamed from: z */
    public abstract String mo2858z();
}
