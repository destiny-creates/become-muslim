package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import com.facebook.internal.NativeProtocol;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.internal.gmsg.C2650j;
import com.google.android.gms.ads.internal.gmsg.C4272i;
import com.google.android.gms.ads.internal.gmsg.ai;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.C2663l;
import com.google.android.gms.ads.internal.overlay.C4740d;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.util.C2904o;
import com.google.android.gms.internal.ads.aks;
import com.google.android.gms.internal.ads.aoq;
import com.google.android.gms.internal.ads.aou;
import com.google.android.gms.internal.ads.aph;
import com.google.android.gms.internal.ads.asp;
import com.google.android.gms.internal.ads.atc;
import com.google.android.gms.internal.ads.bch;
import com.google.android.gms.internal.ads.bci;
import com.google.android.gms.internal.ads.bcy;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.dp;
import com.google.android.gms.internal.ads.ez;
import com.google.android.gms.internal.ads.fw;
import com.google.android.gms.internal.ads.hq;
import com.google.android.gms.internal.ads.id;
import com.google.android.gms.internal.ads.ih;
import com.google.android.gms.internal.ads.is;
import com.google.android.gms.internal.ads.it;
import com.google.android.gms.internal.ads.jn;
import com.google.android.gms.internal.ads.jw;
import com.google.android.gms.internal.ads.kc;
import com.google.android.gms.internal.ads.mv;
import com.google.android.gms.internal.ads.qo;
import com.google.android.gms.internal.ads.qv;
import com.google.android.gms.internal.ads.rw;
import com.google.android.gms.internal.ads.sc;
import java.util.Collections;
import java.util.HashMap;
import org.json.JSONObject;

@cm
/* renamed from: com.google.android.gms.ads.internal.m */
public final class C4910m extends bg implements ai, C2650j {
    /* renamed from: k */
    private transient boolean f14110k;
    /* renamed from: l */
    private int f14111l = -1;
    /* renamed from: m */
    private boolean f14112m;
    /* renamed from: n */
    private float f14113n;
    /* renamed from: o */
    private boolean f14114o;
    /* renamed from: p */
    private ih f14115p;
    /* renamed from: q */
    private String f14116q;
    /* renamed from: r */
    private final String f14117r;
    /* renamed from: s */
    private final fw f14118s;

    public C4910m(Context context, aou aou, String str, bcy bcy, mv mvVar, bu buVar) {
        fw fwVar;
        super(context, aou, str, bcy, mvVar, buVar);
        boolean z = false;
        this.f14110k = false;
        if (aou != null && "reward_mb".equals(aou.f28279a)) {
            z = true;
        }
        this.f14117r = z ? "/Rewarded" : "/Interstitial";
        if (z) {
            fw fwVar2 = new fw(this.e, this.j, new C4288o(this), this, this);
        } else {
            fwVar = null;
        }
        this.f14118s = fwVar;
    }

    /* renamed from: a */
    private final void m17763a(Bundle bundle) {
        ax.m7464e().b(this.e.f6792c, this.e.f6794e.f28709a, "gmob-apps", bundle, false);
    }

    /* renamed from: b */
    private static it m17766b(it itVar) {
        it itVar2 = itVar;
        try {
            String jSONObject = ez.a(itVar2.f15601b).toString();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, itVar2.f15600a.f28549e);
            bch bch = new bch(jSONObject, null, Collections.singletonList("com.google.ads.mediation.admob.AdMobAdapter"), null, null, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), jSONObject2.toString(), null, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, null, null, null, null, Collections.emptyList(), null, -1);
            dp dpVar = itVar2.f15601b;
            bci bci = new bci(Collections.singletonList(bch), ((Long) aph.f().a(asp.bB)).longValue(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), dpVar.f28579H, dpVar.f28580I, "", -1, 0, 1, null, 0, -1, -1, false);
            return new it(itVar2.f15600a, new dp(itVar2.f15600a, dpVar.f28596a, dpVar.f28597b, Collections.emptyList(), Collections.emptyList(), dpVar.f28601f, true, dpVar.f28603h, Collections.emptyList(), dpVar.f28605j, dpVar.f28606k, dpVar.f28607l, dpVar.f28608m, dpVar.f28609n, dpVar.f28610o, dpVar.f28611p, null, dpVar.f28613r, dpVar.f28614s, dpVar.f28615t, dpVar.f28616u, dpVar.f28617v, dpVar.f28619x, dpVar.f28620y, dpVar.f28621z, null, Collections.emptyList(), Collections.emptyList(), dpVar.f28575D, dpVar.f28576E, dpVar.f28577F, dpVar.f28578G, dpVar.f28579H, dpVar.f28580I, dpVar.f28581J, null, dpVar.f28583L, dpVar.f28584M, dpVar.f28585N, dpVar.f28586O, 0, dpVar.f28588Q, Collections.emptyList(), dpVar.f28590S, dpVar.f28591T), bci, itVar2.f15603d, itVar2.f15604e, itVar2.f15605f, itVar2.f15606g, null, itVar2.f15608i, null);
        } catch (Throwable e) {
            jn.b("Unable to generate ad state for an interstitial ad with pooling.", e);
            return itVar2;
        }
    }

    /* renamed from: e */
    private final boolean m17768e(boolean z) {
        return this.f14118s != null && z;
    }

    /* renamed from: H */
    public final void mo3534H() {
        C2872v.m8389b("showInterstitial must be called on the main UI thread.");
        boolean z = this.e.f6799j != null && this.e.f6799j.f15587n;
        if (m17768e(z)) {
            this.f14118s.a(this.f14114o);
            return;
        }
        if (ax.m7455B().d(this.e.f6792c)) {
            this.f14116q = ax.m7455B().g(this.e.f6792c);
            String valueOf = String.valueOf(this.f14116q);
            String valueOf2 = String.valueOf(this.f14117r);
            this.f14116q = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        }
        if (this.e.f6799j == null) {
            jn.e("The interstitial has not loaded.");
            return;
        }
        if (((Boolean) aph.f().a(asp.br)).booleanValue()) {
            Bundle bundle;
            valueOf = (this.e.f6792c.getApplicationContext() != null ? this.e.f6792c.getApplicationContext() : this.e.f6792c).getPackageName();
            if (!this.f14110k) {
                jn.e("It is not recommended to show an interstitial before onAdLoaded completes.");
                bundle = new Bundle();
                bundle.putString("appid", valueOf);
                bundle.putString(NativeProtocol.WEB_DIALOG_ACTION, "show_interstitial_before_load_finish");
                m17763a(bundle);
            }
            ax.m7464e();
            if (!jw.g(this.e.f6792c)) {
                jn.e("It is not recommended to show an interstitial when app is not in foreground.");
                bundle = new Bundle();
                bundle.putString("appid", valueOf);
                bundle.putString(NativeProtocol.WEB_DIALOG_ACTION, "show_interstitial_app_not_in_foreground");
                m17763a(bundle);
            }
        }
        if (!this.e.m7494e()) {
            if (this.e.f6799j.f15587n && this.e.f6799j.f15589p != null) {
                try {
                    if (((Boolean) aph.f().a(asp.aQ)).booleanValue()) {
                        this.e.f6799j.f15589p.a(this.f14114o);
                    }
                    this.e.f6799j.f15589p.b();
                } catch (Throwable e) {
                    jn.c("Could not show interstitial.", e);
                    m17771J();
                }
            } else if (this.e.f6799j.f15575b == null) {
                jn.e("The interstitial failed to load.");
            } else if (this.e.f6799j.f15575b.z()) {
                jn.e("The interstitial is already showing.");
            } else {
                Bitmap h;
                this.e.f6799j.f15575b.b(true);
                this.e.m7488a(this.e.f6799j.f15575b.getView());
                if (this.e.f6799j.f15584k != null) {
                    this.g.a(this.e.f6798i, this.e.f6799j);
                }
                if (C2904o.m8456b()) {
                    is isVar = this.e.f6799j;
                    if (isVar.a()) {
                        new aks(this.e.f6792c, isVar.f15575b.getView()).a(isVar.f15575b);
                    } else {
                        isVar.f15575b.v().a(new C4287n(this, isVar));
                    }
                }
                if (this.e.f6782J) {
                    ax.m7464e();
                    h = jw.h(this.e.f6792c);
                } else {
                    h = null;
                }
                this.f14111l = ax.m7484y().a(h);
                if (!((Boolean) aph.f().a(asp.bR)).booleanValue() || h == null) {
                    C4744r c4744r = new C4744r(this.e.f6782J, m17770I(), false, 0.0f, -1, this.f14114o, this.e.f6799j.f15566L, this.e.f6799j.f15569O);
                    int requestedOrientation = this.e.f6799j.f15575b.getRequestedOrientation();
                    if (requestedOrientation == -1) {
                        requestedOrientation = this.e.f6799j.f15581h;
                    }
                    AdOverlayInfoParcel adOverlayInfoParcel = new AdOverlayInfoParcel(this, this, this, this.e.f6799j.f15575b, requestedOrientation, this.e.f6794e, this.e.f6799j.f15555A, c4744r);
                    ax.m7462c();
                    C2663l.m7543a(this.e.f6792c, adOverlayInfoParcel, true);
                    return;
                }
                new C4743p(this, this.f14111l).h();
            }
        }
    }

    /* renamed from: I */
    protected final boolean m17770I() {
        if (!(this.e.f6792c instanceof Activity)) {
            return false;
        }
        Window window = ((Activity) this.e.f6792c).getWindow();
        if (window != null) {
            if (window.getDecorView() != null) {
                Rect rect = new Rect();
                Rect rect2 = new Rect();
                window.getDecorView().getGlobalVisibleRect(rect, null);
                window.getDecorView().getWindowVisibleDisplayFrame(rect2);
                if (!(rect.bottom == 0 || rect2.bottom == 0 || rect.top != rect2.top)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: J */
    public final void m17771J() {
        ax.m7484y().b(Integer.valueOf(this.f14111l));
        if (this.e.m7493d()) {
            this.e.m7491b();
            this.e.f6799j = null;
            this.e.f6782J = false;
            this.f14110k = false;
        }
    }

    /* renamed from: K */
    public final void m17772K() {
        C4740d r = this.e.f6799j.f15575b.r();
        if (r != null) {
            r.m16559a();
        }
    }

    /* renamed from: a */
    protected final qo mo3586a(it itVar, bv bvVar, id idVar) {
        ax.m7465f();
        qo a = qv.a(this.e.f6792c, sc.a(this.e.f6798i), this.e.f6798i.f28279a, false, false, this.e.f6793d, this.e.f6794e, this.a, this, this.i, itVar.f15608i);
        a.v().a(this, this, null, this, this, ((Boolean) aph.f().a(asp.ai)).booleanValue(), this, bvVar, this, idVar);
        m17685a(a);
        a.a(itVar.f15600a.f28566v);
        a.a("/reward", new C4272i(this));
        return a;
    }

    /* renamed from: a */
    public final void mo3588a(hq hqVar) {
        boolean z = this.e.f6799j != null && this.e.f6799j.f15587n;
        if (m17768e(z)) {
            m16453b(this.f14118s.a(hqVar));
            return;
        }
        if (this.e.f6799j != null) {
            if (this.e.f6799j.f15597x != null) {
                ax.m7464e();
                jw.a(this.e.f6792c, this.e.f6794e.f28709a, this.e.f6799j.f15597x);
            }
            if (this.e.f6799j.f15595v != null) {
                hqVar = this.e.f6799j.f15595v;
            }
        }
        m16453b(hqVar);
    }

    /* renamed from: a */
    public final void mo3541a(it itVar, atc atc) {
        if (itVar.f15604e != -2) {
            super.mo3541a(itVar, atc);
            return;
        }
        if (m17768e(itVar.f15602c != null)) {
            this.f14118s.c();
            return;
        }
        if (((Boolean) aph.f().a(asp.aT)).booleanValue()) {
            int i = itVar.f15601b.f28602g ^ 1;
            if (C4736a.m16416a(itVar.f15600a.f28547c) && i != 0) {
                this.e.f6800k = C4910m.m17766b(itVar);
            }
            super.mo3541a(this.e.f6800k, atc);
            return;
        }
        super.mo3541a(itVar, atc);
    }

    /* renamed from: a */
    public final void mo3589a(boolean z) {
        this.e.f6782J = z;
    }

    /* renamed from: a */
    public final void mo3590a(boolean z, float f) {
        this.f14112m = z;
        this.f14113n = f;
    }

    /* renamed from: a */
    public final boolean mo3433a(aoq aoq, atc atc) {
        if (this.e.f6799j != null) {
            jn.e("An interstitial is already loading. Aborting.");
            return false;
        }
        if (this.f14115p == null && C4736a.m16416a(aoq) && ax.m7455B().d(this.e.f6792c) && !TextUtils.isEmpty(this.e.f6791b)) {
            this.f14115p = new ih(this.e.f6792c, this.e.f6791b);
        }
        return super.mo3433a(aoq, atc);
    }

    /* renamed from: a */
    protected final boolean mo3543a(aoq aoq, is isVar, boolean z) {
        if (this.e.m7493d() && isVar.f15575b != null) {
            ax.m7466g();
            kc.a(isVar.f15575b);
        }
        return this.d.m7445e();
    }

    /* renamed from: a */
    public final boolean mo3435a(is isVar, is isVar2) {
        if (m17768e(isVar2.f15587n)) {
            return fw.a(isVar, isVar2);
        }
        if (!super.mo3435a(isVar, isVar2)) {
            return false;
        }
        if (!(this.e.m7493d() || this.e.f6780H == null || isVar2.f15584k == null)) {
            this.g.a(this.e.f6798i, isVar2, this.e.f6780H);
        }
        m17434b(isVar2, false);
        return true;
    }

    /* renamed from: c */
    public final void mo3591c(boolean z) {
        C2872v.m8389b("setImmersiveMode must be called on the main UI thread.");
        this.f14114o = z;
    }

    public final void i_() {
        boolean z = this.e.f6799j != null && this.e.f6799j.f15587n;
        if (m17768e(z)) {
            this.f14118s.g();
            m16479z();
            return;
        }
        if (!(this.e.f6799j == null || this.e.f6799j.f15596w == null)) {
            ax.m7464e();
            jw.a(this.e.f6792c, this.e.f6794e.f28709a, this.e.f6799j.f15596w);
        }
        m16479z();
    }

    public final void j_() {
        boolean z = this.e.f6799j != null && this.e.f6799j.f15587n;
        if (m17768e(z)) {
            this.f14118s.h();
        }
        m16418A();
    }

    /* renamed from: t */
    protected final void mo3594t() {
        m17771J();
        super.mo3594t();
    }

    public final void u_() {
        super.u_();
        this.g.a(this.e.f6799j);
        if (this.f14115p != null) {
            this.f14115p.a(false);
        }
        m16423F();
    }

    public final void v_() {
        ab();
        super.v_();
        if (!(this.e.f6799j == null || this.e.f6799j.f15575b == null)) {
            rw v = this.e.f6799j.f15575b.v();
            if (v != null) {
                v.g();
            }
        }
        if (!(!ax.m7455B().d(this.e.f6792c) || this.e.f6799j == null || this.e.f6799j.f15575b == null)) {
            ax.m7455B().c(this.e.f6799j.f15575b.getContext(), this.f14116q);
        }
        if (this.f14115p != null) {
            this.f14115p.a(true);
        }
        if (this.h != null && this.e.f6799j != null && this.e.f6799j.f15575b != null) {
            this.e.f6799j.f15575b.a("onSdkImpression", new HashMap());
        }
    }

    /* renamed from: w */
    protected final void mo3546w() {
        qo qoVar = this.e.f6799j != null ? this.e.f6799j.f15575b : null;
        it itVar = this.e.f6800k;
        if (!(itVar == null || itVar.f15601b == null || !itVar.f15601b.f28588Q || qoVar == null || !ax.m7480u().a(this.e.f6792c))) {
            int i = this.e.f6794e.f28710b;
            int i2 = this.e.f6794e.f28711c;
            StringBuilder stringBuilder = new StringBuilder(23);
            stringBuilder.append(i);
            stringBuilder.append(".");
            stringBuilder.append(i2);
            this.h = ax.m7480u().a(stringBuilder.toString(), qoVar.getWebView(), "", "javascript", m16424G());
            if (!(this.h == null || qoVar.getView() == null)) {
                ax.m7480u().a(this.h, qoVar.getView());
                ax.m7480u().a(this.h);
            }
        }
        super.mo3546w();
        this.f14110k = true;
    }
}
