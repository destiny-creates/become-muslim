package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.util.C0463l;
import android.util.Log;
import android.view.View;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.internal.ads.C4939y;
import com.google.android.gms.internal.ads.ajx;
import com.google.android.gms.internal.ads.ao;
import com.google.android.gms.internal.ads.aoq;
import com.google.android.gms.internal.ads.aou;
import com.google.android.gms.internal.ads.aph;
import com.google.android.gms.internal.ads.aqv;
import com.google.android.gms.internal.ads.aqy;
import com.google.android.gms.internal.ads.asp;
import com.google.android.gms.internal.ads.atc;
import com.google.android.gms.internal.ads.atj;
import com.google.android.gms.internal.ads.atu;
import com.google.android.gms.internal.ads.atw;
import com.google.android.gms.internal.ads.aty;
import com.google.android.gms.internal.ads.aub;
import com.google.android.gms.internal.ads.aud;
import com.google.android.gms.internal.ads.aue;
import com.google.android.gms.internal.ads.auf;
import com.google.android.gms.internal.ads.auh;
import com.google.android.gms.internal.ads.aui;
import com.google.android.gms.internal.ads.auk;
import com.google.android.gms.internal.ads.avd;
import com.google.android.gms.internal.ads.awa;
import com.google.android.gms.internal.ads.awl;
import com.google.android.gms.internal.ads.awo;
import com.google.android.gms.internal.ads.bci;
import com.google.android.gms.internal.ads.bcy;
import com.google.android.gms.internal.ads.bdb;
import com.google.android.gms.internal.ads.bdk;
import com.google.android.gms.internal.ads.bdo;
import com.google.android.gms.internal.ads.bdr;
import com.google.android.gms.internal.ads.bq;
import com.google.android.gms.internal.ads.bu;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.is;
import com.google.android.gms.internal.ads.it;
import com.google.android.gms.internal.ads.jn;
import com.google.android.gms.internal.ads.ju;
import com.google.android.gms.internal.ads.jw;
import com.google.android.gms.internal.ads.mt;
import com.google.android.gms.internal.ads.mv;
import com.google.android.gms.internal.ads.no;
import com.google.android.gms.internal.ads.nz;
import com.google.android.gms.internal.ads.qo;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C4757d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

@cm
public final class ae extends bb implements auh {
    /* renamed from: k */
    private final Object f14087k;
    /* renamed from: l */
    private boolean f14088l;
    /* renamed from: m */
    private nz<aui> f14089m;
    /* renamed from: n */
    private qo f14090n;
    /* renamed from: o */
    private qo f14091o;
    /* renamed from: p */
    private boolean f14092p;
    /* renamed from: q */
    private int f14093q;
    /* renamed from: r */
    private bq f14094r;
    /* renamed from: s */
    private final String f14095s;

    public ae(Context context, bu buVar, aou aou, String str, bcy bcy, mv mvVar) {
        this(context, buVar, aou, str, bcy, mvVar, false);
    }

    public ae(Context context, bu buVar, aou aou, String str, bcy bcy, mv mvVar, boolean z) {
        super(context, aou, str, bcy, mvVar, buVar);
        this.f14087k = new Object();
        this.f14089m = new nz();
        this.f14093q = 1;
        this.f14095s = UUID.randomUUID().toString();
        this.f14088l = z;
    }

    /* renamed from: a */
    private static void m17637a(ay ayVar, ay ayVar2) {
        if (ayVar2.f6807r == null) {
            ayVar2.f6807r = ayVar.f6807r;
        }
        if (ayVar2.f6808s == null) {
            ayVar2.f6808s = ayVar.f6808s;
        }
        if (ayVar2.f6810u == null) {
            ayVar2.f6810u = ayVar.f6810u;
        }
        if (ayVar2.f6811v == null) {
            ayVar2.f6811v = ayVar.f6811v;
        }
        if (ayVar2.f6813x == null) {
            ayVar2.f6813x = ayVar.f6813x;
        }
        if (ayVar2.f6812w == null) {
            ayVar2.f6812w = ayVar.f6812w;
        }
        if (ayVar2.f6778F == null) {
            ayVar2.f6778F = ayVar.f6778F;
        }
        if (ayVar2.f6801l == null) {
            ayVar2.f6801l = ayVar.f6801l;
        }
        if (ayVar2.f6779G == null) {
            ayVar2.f6779G = ayVar.f6779G;
        }
        if (ayVar2.f6802m == null) {
            ayVar2.f6802m = ayVar.f6802m;
        }
        if (ayVar2.f6803n == null) {
            ayVar2.f6803n = ayVar.f6803n;
        }
        if (ayVar2.f6798i == null) {
            ayVar2.f6798i = ayVar.f6798i;
        }
        if (ayVar2.f6799j == null) {
            ayVar2.f6799j = ayVar.f6799j;
        }
        if (ayVar2.f6800k == null) {
            ayVar2.f6800k = ayVar.f6800k;
        }
    }

    /* renamed from: a */
    private final void m17638a(atu atu) {
        jw.f15691a.post(new ai(this, atu));
    }

    /* renamed from: a */
    private final void m17639a(atw atw) {
        jw.f15691a.post(new ak(this, atw));
    }

    /* renamed from: a */
    private final void m17640a(aub aub) {
        jw.f15691a.post(new aj(this, aub));
    }

    private final boolean ac() {
        return this.e.f6799j != null && this.e.f6799j.f15568N;
    }

    private final bci ad() {
        return (this.e.f6799j == null || !this.e.f6799j.f15587n) ? null : this.e.f6799j.f15591r;
    }

    private final void ae() {
        bq I = m17644I();
        if (I != null) {
            I.a();
        }
    }

    /* renamed from: b */
    private static aub m17641b(aui aui) {
        C2758b j;
        aub aub;
        aui aui2 = aui;
        Object obj = null;
        if (aui2 instanceof atw) {
            atw atw = (atw) aui2;
            aub aub2 = new aub(atw.a(), atw.b(), atw.e(), atw.f(), atw.g(), atw.h(), -1.0d, null, null, atw.m(), atw.i(), atw.o(), atw.c(), atw.d(), atw.n());
            if (atw.j() != null) {
                j = atw.j();
            }
            if (obj instanceof auk) {
                aub.a((auk) obj);
            }
            return aub;
        }
        if (aui2 instanceof atu) {
            atu atu = (atu) aui2;
            aub2 = new aub(atu.a(), atu.b(), atu.c(), atu.d(), atu.e(), null, atu.f(), atu.g(), atu.h(), atu.m(), atu.i(), atu.o(), atu.p(), atu.q(), atu.n());
            if (atu.j() != null) {
                j = atu.j();
            }
        } else {
            aub = null;
        }
        if (obj instanceof auk) {
            aub.a((auk) obj);
        }
        return aub;
        obj = C4757d.m16685a(j);
        if (obj instanceof auk) {
            aub.a((auk) obj);
        }
        return aub;
    }

    /* renamed from: C */
    public final String mo3533C() {
        return this.e.f6791b;
    }

    /* renamed from: H */
    public final void mo3534H() {
        throw new IllegalStateException("Interstitial is NOT supported by NativeAdManager.");
    }

    /* renamed from: I */
    public final bq m17644I() {
        bq bqVar;
        synchronized (this.f14087k) {
            bqVar = this.f14094r;
        }
        return bqVar;
    }

    /* renamed from: J */
    protected final Future<aui> m17645J() {
        return this.f14089m;
    }

    /* renamed from: K */
    public final void m17646K() {
        if (ac() && this.h != null) {
            qo qoVar = null;
            if (this.f14091o != null) {
                qoVar = this.f14091o;
            } else if (this.f14090n != null) {
                qoVar = this.f14090n;
            }
            if (qoVar != null) {
                qoVar.a("onSdkImpression", new HashMap());
            }
        }
    }

    /* renamed from: L */
    public final void m17647L() {
        if (this.e.f6799j == null || this.f14090n == null) {
            this.f14092p = true;
            jn.e("Request to enable ActiveView before adState is available.");
            return;
        }
        ax.m7468i().g().a(this.e.f6798i, this.e.f6799j, this.f14090n.getView(), this.f14090n);
        this.f14092p = false;
    }

    /* renamed from: M */
    public final void m17648M() {
        this.f14092p = false;
        if (this.e.f6799j == null || this.f14090n == null) {
            jn.e("Request to enable ActiveView before adState is available.");
        } else {
            ax.m7468i().g().a(this.e.f6799j);
        }
    }

    /* renamed from: N */
    public final C0463l<String, awo> m17649N() {
        C2872v.m8389b("getOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        return this.e.f6811v;
    }

    /* renamed from: O */
    public final void m17650O() {
        if (this.f14090n != null) {
            this.f14090n.destroy();
            this.f14090n = null;
        }
    }

    /* renamed from: P */
    public final void m17651P() {
        super.m16423F();
        if (this.f14091o != null) {
            this.f14091o.destroy();
            this.f14091o = null;
        }
    }

    /* renamed from: Q */
    public final void m17652Q() {
        if (this.f14090n != null && this.f14090n.b() != null && this.e.f6812w != null && this.e.f6812w.f28392f != null) {
            this.f14090n.b().a(this.e.f6812w.f28392f);
        }
    }

    /* renamed from: R */
    public final boolean m17653R() {
        return ad() != null ? ad().f15209p : false;
    }

    /* renamed from: S */
    public final boolean m17654S() {
        return ad() != null ? ad().f15210q : false;
    }

    /* renamed from: T */
    public final void mo3535T() {
        if (this.e.f6799j == null || !"com.google.ads.mediation.admob.AdMobAdapter".equals(this.e.f6799j.f15590q)) {
            super.mo3535T();
        } else {
            m16478y();
        }
    }

    /* renamed from: U */
    public final void mo3536U() {
        if (this.e.f6799j == null || !"com.google.ads.mediation.admob.AdMobAdapter".equals(this.e.f6799j.f15590q)) {
            super.mo3536U();
        } else {
            m16477x();
        }
    }

    /* renamed from: V */
    public final void mo3537V() {
        is isVar = this.e.f6799j;
        if (isVar.f15589p == null) {
            super.mo3537V();
            return;
        }
        try {
            bdb bdb = isVar.f15589p;
            aqv aqv = null;
            bdk h = bdb.h();
            if (h != null) {
                aqv = h.m();
            } else {
                bdo i = bdb.i();
                if (i != null) {
                    aqv = i.l();
                } else {
                    awa n = bdb.n();
                    if (n != null) {
                        aqv = n.c();
                    }
                }
            }
            if (aqv != null) {
                aqy h2 = aqv.h();
                if (h2 != null) {
                    h2.d();
                }
            }
        } catch (Throwable e) {
            jn.d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: a */
    protected final void mo3538a(int i) {
        mo3539a(i, false);
    }

    /* renamed from: a */
    protected final void mo3539a(int i, boolean z) {
        ae();
        super.mo3539a(i, z);
    }

    /* renamed from: a */
    protected final void m17660a(C2758b c2758b) {
        Object a = c2758b != null ? C4757d.m16685a(c2758b) : null;
        if (a instanceof auf) {
            ((auf) a).d();
        }
        super.m17434b(this.e.f6799j, false);
    }

    /* renamed from: a */
    public final void mo3540a(atj atj) {
        throw new IllegalStateException("CustomRendering is NOT supported by NativeAdManager.");
    }

    /* renamed from: a */
    public final void m17662a(aud aud) {
        if (this.f14090n != null) {
            this.f14090n.a(aud);
        }
    }

    /* renamed from: a */
    public final void m17663a(auf auf) {
        if (this.e.f6799j.f15584k != null) {
            ax.m7468i().g().a(this.e.f6798i, this.e.f6799j, new ajx(auf), null);
        }
    }

    /* renamed from: a */
    public final void mo3541a(it itVar, atc atc) {
        if (itVar.f15603d != null) {
            this.e.f6798i = itVar.f15603d;
        }
        if (itVar.f15604e != -2) {
            jw.f15691a.post(new af(this, itVar));
            return;
        }
        int i = itVar.f15600a.f28543Y;
        int i2 = 0;
        if (i == 1) {
            this.e.f6781I = 0;
            ay ayVar = this.e;
            ax.m7463d();
            ayVar.f6797h = ao.a(this.e.f6792c, this, itVar, this.e.f6793d, null, this.j, this, atc);
            String str = "AdRenderer: ";
            String valueOf = String.valueOf(this.e.f6797h.getClass().getName());
            jn.b(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            return;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            JSONArray jSONArray2 = new JSONObject(itVar.f15601b.f28597b).getJSONArray("slots");
            for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                JSONArray jSONArray3 = jSONArray2.getJSONObject(i3).getJSONArray("ads");
                for (int i4 = 0; i4 < jSONArray3.length(); i4++) {
                    jSONArray.put(jSONArray3.get(i4));
                }
            }
            ae();
            List arrayList = new ArrayList();
            for (int i5 = 0; i5 < i; i5++) {
                arrayList.add(ju.a(new ag(this, i5, jSONArray, i, itVar)));
            }
            while (i2 < arrayList.size()) {
                try {
                    jw.f15691a.post(new ah(this, (aui) ((no) arrayList.get(i2)).get(((Long) aph.f().a(asp.bB)).longValue(), TimeUnit.MILLISECONDS), i2, arrayList));
                } catch (Throwable e) {
                    mt.c("", e);
                    Thread.currentThread().interrupt();
                } catch (Throwable e2) {
                    mt.c("", e2);
                }
                i2++;
            }
        } catch (Throwable e22) {
            jn.c("Malformed native ad response", e22);
            mo3538a(0);
        }
    }

    /* renamed from: a */
    public final void m17665a(qo qoVar) {
        this.f14090n = qoVar;
    }

    /* renamed from: a */
    public final void mo3542a(C4939y c4939y) {
        throw new IllegalStateException("In App Purchase is NOT supported by NativeAdManager.");
    }

    /* renamed from: a */
    public final boolean mo3433a(aoq aoq, atc atc) {
        try {
            p_();
            return super.m17428a(aoq, atc, this.f14093q);
        } catch (Throwable e) {
            String str = "Error initializing webview.";
            if (mt.a(4)) {
                Log.i("Ads", str, e);
            }
            return false;
        }
    }

    /* renamed from: a */
    protected final boolean mo3543a(aoq aoq, is isVar, boolean z) {
        return this.d.m7445e();
    }

    /* renamed from: a */
    protected final boolean mo3435a(is isVar, is isVar2) {
        is isVar3 = isVar2;
        List list = null;
        m17674c(null);
        if (this.e.m7493d()) {
            if (isVar3.f15587n) {
                ae();
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
                    } else if (h != null && r7.e.f6809t != null) {
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
                    } else if (h != null && r7.e.f6807r != null) {
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
                        m17638a(atu);
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
                        aui aui = r10;
                        aui.a(new aue(r7.e.f6792c, this, r7.e.f6793d, r5, r10));
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
                        atw atw = r10;
                        atw.a(new aue(r7.e.f6792c, this, r7.e.f6793d, r5, r10));
                        m17639a(atw);
                    } else if (n == null || r7.e.f6811v == null || r7.e.f6811v.get(n.l()) == null) {
                        jn.e("No matching mapper/listener for retrieved native ad template.");
                        mo3538a(0);
                        return false;
                    } else {
                        jw.f15691a.post(new am(r7, n));
                    }
                    m17640a(r9);
                } catch (Throwable e2) {
                    jn.d("#007 Could not call remote method.", e2);
                }
            } else {
                aui aui2 = isVar3.f15557C;
                if (r7.f14088l) {
                    r7.f14089m.b(aui2);
                } else {
                    boolean z = aui2 instanceof atw;
                    if (!z || r7.e.f6809t == null) {
                        if (!z || r7.e.f6808s == null) {
                            z = aui2 instanceof atu;
                            if (!z || r7.e.f6809t == null) {
                                if (!z || r7.e.f6807r == null) {
                                    if ((aui2 instanceof aty) && r7.e.f6811v != null) {
                                        aty aty = (aty) aui2;
                                        if (r7.e.f6811v.get(aty.l()) != null) {
                                            jw.f15691a.post(new al(r7, aty.l(), isVar3));
                                        }
                                    }
                                    jn.e("No matching listener for retrieved native ad template.");
                                    mo3538a(0);
                                    return false;
                                }
                                m17638a((atu) isVar3.f15557C);
                            }
                        } else {
                            m17639a((atw) isVar3.f15557C);
                        }
                    }
                    m17640a(m17641b(isVar3.f15557C));
                }
            }
            return super.mo3435a(isVar, isVar2);
        }
        throw new IllegalStateException("Native ad DOES NOT have custom rendering mode.");
    }

    /* renamed from: b */
    public final awl mo3544b(String str) {
        C2872v.m8389b("getOnCustomClickListener must be called on the main UI thread.");
        return this.e.f6810u == null ? null : (awl) this.e.f6810u.get(str);
    }

    /* renamed from: b */
    public final void m17671b(int i) {
        C2872v.m8389b("setMaxNumberOfAds must be called on the main UI thread.");
        this.f14093q = i;
    }

    /* renamed from: b */
    public final void m17672b(View view) {
        if (this.h != null) {
            ax.m7480u().a(this.h, view);
        }
    }

    /* renamed from: b */
    public final void m17673b(qo qoVar) {
        this.f14091o = qoVar;
    }

    /* renamed from: c */
    public final void m17674c(List<String> list) {
        C2872v.m8389b("setNativeTemplates must be called on the main UI thread.");
        this.e.f6778F = list;
    }

    /* renamed from: d */
    protected final void mo3545d(boolean z) {
        super.mo3545d(z);
        if (this.f14092p) {
            if (((Boolean) aph.f().a(asp.cg)).booleanValue()) {
                m17647L();
            }
        }
        if (!ac()) {
            return;
        }
        if (this.f14091o != null || this.f14090n != null) {
            String str;
            qo qoVar = null;
            if (this.f14091o != null) {
                str = null;
                qoVar = this.f14091o;
            } else if (this.f14090n != null) {
                qoVar = this.f14090n;
                str = "javascript";
            } else {
                str = null;
            }
            if (qoVar.getWebView() != null && ax.m7480u().a(this.e.f6792c)) {
                int i = this.e.f6794e.f28710b;
                int i2 = this.e.f6794e.f28711c;
                StringBuilder stringBuilder = new StringBuilder(23);
                stringBuilder.append(i);
                stringBuilder.append(".");
                stringBuilder.append(i2);
                this.h = ax.m7480u().a(stringBuilder.toString(), qoVar.getWebView(), "", "javascript", str);
                if (this.h != null) {
                    ax.m7480u().a(this.h);
                }
            }
        }
    }

    /* renamed from: n */
    public final void mo3441n() {
        throw new IllegalStateException("Native Ad DOES NOT support pause().");
    }

    /* renamed from: o */
    public final void mo3443o() {
        throw new IllegalStateException("Native Ad DOES NOT support resume().");
    }

    public final String o_() {
        return this.f14095s;
    }

    final void p_() {
        synchronized (this.f14087k) {
            jn.a("Initializing webview native ads utills");
            this.f14094r = new bu(this.e.f6792c, this, this.f14095s, this.e.f6793d, this.e.f6794e);
        }
    }

    /* renamed from: w */
    protected final void mo3546w() {
        mo3545d(false);
    }
}
