package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.internal.ads.ao;
import com.google.android.gms.internal.ads.aoq;
import com.google.android.gms.internal.ads.aou;
import com.google.android.gms.internal.ads.aqv;
import com.google.android.gms.internal.ads.atc;
import com.google.android.gms.internal.ads.atj;
import com.google.android.gms.internal.ads.atu;
import com.google.android.gms.internal.ads.atw;
import com.google.android.gms.internal.ads.aub;
import com.google.android.gms.internal.ads.aud;
import com.google.android.gms.internal.ads.aue;
import com.google.android.gms.internal.ads.auf;
import com.google.android.gms.internal.ads.auh;
import com.google.android.gms.internal.ads.avd;
import com.google.android.gms.internal.ads.awa;
import com.google.android.gms.internal.ads.awl;
import com.google.android.gms.internal.ads.bci;
import com.google.android.gms.internal.ads.bcy;
import com.google.android.gms.internal.ads.bdk;
import com.google.android.gms.internal.ads.bdo;
import com.google.android.gms.internal.ads.bdr;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.is;
import com.google.android.gms.internal.ads.it;
import com.google.android.gms.internal.ads.jn;
import com.google.android.gms.internal.ads.jw;
import com.google.android.gms.internal.ads.mt;
import com.google.android.gms.internal.ads.mv;
import com.google.android.gms.internal.ads.qo;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C4757d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@cm
public final class bo extends bb implements auh {
    /* renamed from: k */
    private boolean f14097k;
    /* renamed from: l */
    private is f14098l;
    /* renamed from: m */
    private boolean f14099m = false;

    public bo(Context context, bu buVar, aou aou, String str, bcy bcy, mv mvVar) {
        super(context, aou, str, bcy, mvVar, buVar);
    }

    /* renamed from: I */
    private final bci m17689I() {
        return (this.e.f6799j == null || !this.e.f6799j.f15587n) ? null : this.e.f6799j.f15591r;
    }

    /* renamed from: a */
    private static is m17691a(it itVar, int i) {
        it itVar2 = itVar;
        return new is(itVar2.f15600a.f28547c, null, itVar2.f15601b.f28598c, i, itVar2.f15601b.f28600e, itVar2.f15601b.f28604i, itVar2.f15601b.f28606k, itVar2.f15601b.f28605j, itVar2.f15600a.f28553i, itVar2.f15601b.f28602g, null, null, null, itVar2.f15602c, null, itVar2.f15601b.f28603h, itVar2.f15603d, itVar2.f15601b.f28601f, itVar2.f15605f, itVar2.f15606g, itVar2.f15601b.f28609n, itVar2.f15607h, null, itVar2.f15601b.f28572A, itVar2.f15601b.f28573B, itVar2.f15601b.f28573B, itVar2.f15601b.f28575D, itVar2.f15601b.f28576E, null, itVar2.f15601b.f28579H, itVar2.f15601b.f28583L, itVar2.f15608i, itVar2.f15601b.f28586O, itVar2.f15609j, itVar2.f15601b.f28588Q, itVar2.f15601b.f28589R, itVar2.f15601b.f28590S, itVar2.f15601b.f28591T);
    }

    /* renamed from: a */
    private final void m17692a(aub aub) {
        jw.f15691a.post(new bq(this, aub));
    }

    /* renamed from: b */
    private final boolean m17693b(is isVar, is isVar2) {
        is isVar3 = isVar2;
        List list = null;
        m17714c(null);
        if (this.e.m7493d()) {
            try {
                bdr p = isVar3.f15589p != null ? isVar3.f15589p.p() : null;
                bdk h = isVar3.f15589p != null ? isVar3.f15589p.h() : null;
                bdo i = isVar3.f15589p != null ? isVar3.f15589p.i() : null;
                awa n = isVar3.f15589p != null ? isVar3.f15589p.n() : null;
                String c = bb.m17415c(isVar2);
                String a;
                List b;
                String c2;
                avd d;
                String e;
                String f;
                double g;
                String h2;
                String i2;
                aqv j;
                aub aub;
                if (p != null && r7.e.f6809t != null) {
                    a = p.a();
                    b = p.b();
                    c2 = p.c();
                    d = p.d() != null ? p.d() : null;
                    e = p.e();
                    f = p.f();
                    g = p.g();
                    h2 = p.h();
                    i2 = p.i();
                    j = p.j();
                    if (p.m() != null) {
                        list = (View) C4757d.m16685a(p.m());
                    }
                    aub = new aub(a, b, c2, d, e, f, g, h2, i2, null, j, list, p.n(), c, p.o());
                    aub.a(new aue(r7.e.f6792c, this, r7.e.f6793d, p, aub));
                } else if (h == null || r7.e.f6809t == null) {
                    Handler handler;
                    Runnable brVar;
                    if (h != null && r7.e.f6807r != null) {
                        a = h.a();
                        b = h.b();
                        c2 = h.c();
                        d = h.d() != null ? h.d() : null;
                        e = h.e();
                        double f2 = h.f();
                        String g2 = h.g();
                        h2 = h.h();
                        Bundle l = h.l();
                        j = h.m();
                        if (h.p() != null) {
                            list = (View) C4757d.m16685a(h.p());
                        }
                        atu atu = new atu(a, b, c2, d, e, f2, g2, h2, null, l, j, list, h.q(), c);
                        atu.a(new aue(r7.e.f6792c, this, r7.e.f6793d, h, atu));
                        handler = jw.f15691a;
                        brVar = new br(r7, atu);
                    } else if (i != null && r7.e.f6809t != null) {
                        a = i.a();
                        b = i.b();
                        c2 = i.c();
                        d = i.d() != null ? i.d() : null;
                        e = i.e();
                        f = i.f();
                        j = i.l();
                        if (i.n() != null) {
                            list = (View) C4757d.m16685a(i.n());
                        }
                        r10 = new aub(a, b, c2, d, e, f, -1.0d, null, null, null, j, list, i.o(), c, i.j());
                        r5 = i;
                        r9 = r10;
                        r9.a(new aue(r7.e.f6792c, this, r7.e.f6793d, r5, r10));
                    } else if (i != null && r7.e.f6808s != null) {
                        a = i.a();
                        b = i.b();
                        c2 = i.c();
                        d = i.d() != null ? i.d() : null;
                        e = i.e();
                        f = i.f();
                        Bundle j2 = i.j();
                        aqv l2 = i.l();
                        if (i.n() != null) {
                            list = (View) C4757d.m16685a(i.n());
                        }
                        r10 = new atw(a, b, c2, d, e, f, null, j2, l2, list, i.o(), c);
                        r5 = i;
                        r9 = r10;
                        r9.a(new aue(r7.e.f6792c, this, r7.e.f6793d, r5, r10));
                        handler = jw.f15691a;
                        brVar = new bs(r7, r9);
                    } else if (n == null || r7.e.f6811v == null || r7.e.f6811v.get(n.l()) == null) {
                        jn.e("No matching mapper/listener for retrieved native ad template.");
                        mo3538a(0);
                        return false;
                    } else {
                        jw.f15691a.post(new bt(r7, n));
                        return super.mo3435a(isVar, isVar2);
                    }
                    handler.post(brVar);
                    return super.mo3435a(isVar, isVar2);
                } else {
                    a = h.a();
                    b = h.b();
                    c2 = h.c();
                    d = h.d() != null ? h.d() : null;
                    e = h.e();
                    g = h.f();
                    h2 = h.g();
                    i2 = h.h();
                    j = h.m();
                    if (h.p() != null) {
                        list = (View) C4757d.m16685a(h.p());
                    }
                    aub = new aub(a, b, c2, d, e, null, g, h2, i2, null, j, list, h.q(), c, h.l());
                    aub.a(new aue(r7.e.f6792c, this, r7.e.f6793d, h, aub));
                }
                m17692a(r9);
                return super.mo3435a(isVar, isVar2);
            } catch (Throwable e2) {
                jn.d("#007 Could not call remote method.", e2);
            }
        } else {
            jn.e("Native ad does not have custom rendering mode.");
        }
        mo3538a(0);
        return false;
    }

    /* renamed from: c */
    private final boolean m17694c(is isVar, is isVar2) {
        View a = C2674t.m7549a(isVar2);
        if (a == null) {
            return false;
        }
        View nextView = this.e.f6795f.getNextView();
        if (nextView != null) {
            if (nextView instanceof qo) {
                ((qo) nextView).destroy();
            }
            this.e.f6795f.removeView(nextView);
        }
        if (!C2674t.m7561b(isVar2)) {
            try {
                m16428a(a);
            } catch (Throwable th) {
                ax.m7468i().a(th, "AdLoaderManager.swapBannerViews");
                jn.c("Could not add mediation view to view hierarchy.", th);
                return false;
            }
        }
        if (this.e.f6795f.getChildCount() > 1) {
            this.e.f6795f.showNext();
        }
        if (isVar != null) {
            View nextView2 = this.e.f6795f.getNextView();
            if (nextView2 != null) {
                this.e.f6795f.removeView(nextView2);
            }
            this.e.m7492c();
        }
        this.e.f6795f.setMinimumWidth(m16464k().f28284f);
        this.e.f6795f.setMinimumHeight(m16464k().f28281c);
        this.e.f6795f.requestLayout();
        this.e.f6795f.setVisibility(0);
        return true;
    }

    /* renamed from: H */
    public final void mo3534H() {
        throw new IllegalStateException("Interstitial is not supported by AdLoaderManager.");
    }

    /* renamed from: K */
    public final void m17696K() {
        mt.d("#005 Unexpected call to an abstract (unimplemented) method.", null);
    }

    /* renamed from: O */
    public final void m17697O() {
        mt.d("#005 Unexpected call to an abstract (unimplemented) method.", null);
    }

    /* renamed from: P */
    public final void m17698P() {
        mt.d("#005 Unexpected call to an abstract (unimplemented) method.", null);
    }

    /* renamed from: R */
    public final boolean m17699R() {
        return m17689I() != null ? m17689I().f15209p : false;
    }

    /* renamed from: S */
    public final boolean m17700S() {
        return m17689I() != null ? m17689I().f15210q : false;
    }

    /* renamed from: T */
    public final void mo3535T() {
        if (this.e.f6799j == null || !"com.google.ads.mediation.admob.AdMobAdapter".equals(this.e.f6799j.f15590q) || this.e.f6799j.f15588o == null || !this.e.f6799j.f15588o.b()) {
            super.mo3535T();
        } else {
            m16478y();
        }
    }

    /* renamed from: U */
    public final void mo3536U() {
        if (this.e.f6799j == null || !"com.google.ads.mediation.admob.AdMobAdapter".equals(this.e.f6799j.f15590q) || this.e.f6799j.f15588o == null || !this.e.f6799j.f15588o.b()) {
            super.mo3536U();
        } else {
            m16477x();
        }
    }

    /* renamed from: a */
    protected final void m17703a(C2758b c2758b) {
        Object a = c2758b != null ? C4757d.m16685a(c2758b) : null;
        if (a instanceof auf) {
            ((auf) a).d();
        }
        super.m17434b(this.e.f6799j, false);
    }

    /* renamed from: a */
    public final void mo3540a(atj atj) {
        throw new IllegalStateException("CustomRendering is not supported by AdLoaderManager.");
    }

    /* renamed from: a */
    public final void m17705a(aud aud) {
        mt.d("#005 Unexpected call to an abstract (unimplemented) method.", null);
    }

    /* renamed from: a */
    public final void m17706a(auf auf) {
        mt.d("#005 Unexpected call to an abstract (unimplemented) method.", null);
    }

    /* renamed from: a */
    public final void mo3541a(it itVar, atc atc) {
        is a;
        this.f14098l = null;
        if (itVar.f15604e != -2) {
            a = m17691a(itVar, itVar.f15604e);
        } else {
            if (!itVar.f15601b.f28602g) {
                jn.e("partialAdState is not mediation");
                a = m17691a(itVar, 0);
            }
            if (this.f14098l == null) {
                jw.f15691a.post(new bp(this));
            }
            if (itVar.f15603d != null) {
                this.e.f6798i = itVar.f15603d;
            }
            this.e.f6781I = 0;
            ay ayVar = this.e;
            ax.m7463d();
            ayVar.f6797h = ao.a(this.e.f6792c, this, itVar, this.e.f6793d, null, this.j, this, atc);
            return;
        }
        this.f14098l = a;
        if (this.f14098l == null) {
            if (itVar.f15603d != null) {
                this.e.f6798i = itVar.f15603d;
            }
            this.e.f6781I = 0;
            ay ayVar2 = this.e;
            ax.m7463d();
            ayVar2.f6797h = ao.a(this.e.f6792c, this, itVar, this.e.f6793d, null, this.j, this, atc);
            return;
        }
        jw.f15691a.post(new bp(this));
    }

    /* renamed from: a */
    protected final boolean mo3543a(aoq aoq, is isVar, boolean z) {
        return false;
    }

    /* renamed from: a */
    protected final boolean mo3435a(is isVar, is isVar2) {
        if (this.e.m7493d()) {
            String str;
            if (isVar2.f15587n) {
                if (isVar2.f15588o != null && isVar2.f15588o.a()) {
                    Object obj;
                    if (this.e.m7493d() && this.e.f6795f != null) {
                        this.e.f6795f.m7496a().c(isVar2.f15555A);
                    }
                    if (super.mo3435a(isVar, isVar2)) {
                        if (!this.e.m7493d() || m17694c(isVar, isVar2)) {
                            if (!this.e.m7494e()) {
                                super.mo3587a(isVar2, false);
                            }
                            obj = 1;
                            if (obj == null) {
                                return false;
                            }
                            this.f14099m = true;
                        } else {
                            mo3538a(0);
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        return false;
                    }
                    this.f14099m = true;
                } else if (isVar2.f15588o == null || !isVar2.f15588o.b()) {
                    mo3538a(0);
                    str = "Response is neither banner nor native.";
                } else if (!m17693b(isVar, isVar2)) {
                    return false;
                }
                m17715d(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(2)})));
                return true;
            }
            mo3538a(0);
            str = "newState is not mediation.";
            jn.e(str);
            return false;
        }
        throw new IllegalStateException("AdLoader API does not support custom rendering.");
    }

    /* renamed from: b */
    public final awl mo3544b(String str) {
        C2872v.m8389b("getOnCustomClickListener must be called on the main UI thread.");
        return (awl) this.e.f6810u.get(str);
    }

    /* renamed from: b */
    public final void m17711b(View view) {
        mt.d("#005 Unexpected call to an abstract (unimplemented) method.", null);
    }

    /* renamed from: b */
    public final void mo3550b(boolean z) {
        C2872v.m8389b("setManualImpressionsEnabled must be called from the main thread.");
        this.f14097k = z;
    }

    /* renamed from: b */
    public final boolean mo3551b(aoq aoq) {
        aoq aoq2 = aoq;
        Object obj = (this.e.f6773A != null && r0.e.f6773A.size() == 1 && ((Integer) r0.e.f6773A.get(0)).intValue() == 2) ? 1 : null;
        if (obj != null) {
            jn.c("Requesting only banner Ad from AdLoader or calling loadAd on returned banner is not yet supported");
            mo3538a(0);
            return false;
        } else if (r0.e.f6815z == null) {
            return super.mo3551b(aoq);
        } else {
            if (aoq2.f28268h != r0.f14097k) {
                boolean z;
                int i = aoq2.f28261a;
                long j = aoq2.f28262b;
                Bundle bundle = aoq2.f28263c;
                int i2 = aoq2.f28264d;
                List list = aoq2.f28265e;
                boolean z2 = aoq2.f28266f;
                int i3 = aoq2.f28267g;
                if (!aoq2.f28268h) {
                    if (!r0.f14097k) {
                        z = false;
                        aoq2 = new aoq(i, j, bundle, i2, list, z2, i3, z, aoq2.f28269i, aoq2.f28270j, aoq2.f28271k, aoq2.f28272l, aoq2.f28273m, aoq2.f28274n, aoq2.f28275o, aoq2.f28276p, aoq2.f28277q, aoq2.f28278r);
                    }
                }
                z = true;
                aoq2 = new aoq(i, j, bundle, i2, list, z2, i3, z, aoq2.f28269i, aoq2.f28270j, aoq2.f28271k, aoq2.f28272l, aoq2.f28273m, aoq2.f28274n, aoq2.f28275o, aoq2.f28276p, aoq2.f28277q, aoq2.f28278r);
            }
            return super.mo3551b(aoq2);
        }
    }

    /* renamed from: c */
    public final void m17714c(List<String> list) {
        C2872v.m8389b("setNativeTemplates must be called on the main UI thread.");
        this.e.f6778F = list;
    }

    /* renamed from: d */
    public final void m17715d(List<Integer> list) {
        C2872v.m8389b("setAllowedAdTypes must be called on the main UI thread.");
        this.e.f6773A = list;
    }

    /* renamed from: n */
    public final void mo3441n() {
        if (this.f14099m) {
            super.mo3441n();
            return;
        }
        throw new IllegalStateException("Native Ad does not support pause().");
    }

    /* renamed from: o */
    public final void mo3443o() {
        if (this.f14099m) {
            super.mo3443o();
            return;
        }
        throw new IllegalStateException("Native Ad does not support resume().");
    }

    /* renamed from: s */
    public final aqv mo3552s() {
        return null;
    }

    /* renamed from: w */
    protected final void mo3546w() {
        super.mo3546w();
        is isVar = this.e.f6799j;
        if (!(isVar == null || isVar.f15588o == null || !isVar.f15588o.a() || this.e.f6815z == null)) {
            try {
                this.e.f6815z.a(this, C4757d.m16684a(this.e.f6792c));
                super.m17434b(this.e.f6799j, false);
            } catch (Throwable e) {
                jn.d("#007 Could not call remote method.", e);
            }
        }
    }
}
