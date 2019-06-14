package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.ads.internal.bb;
import com.google.android.gms.ads.internal.bu;
import com.google.android.gms.common.internal.C2872v;
import java.util.Arrays;
import java.util.Collections;
import org.json.JSONObject;

@cm
public final class fz extends bb implements hd {
    /* renamed from: k */
    private static fz f32749k;
    /* renamed from: l */
    private boolean f32750l;
    /* renamed from: m */
    private boolean f32751m;
    /* renamed from: n */
    private final ih f32752n;
    /* renamed from: o */
    private final fw f32753o = new fw(this.e, this.j, this, this, this);

    public fz(Context context, bu buVar, aou aou, bcy bcy, mv mvVar) {
        super(context, aou, null, bcy, mvVar, buVar);
        f32749k = this;
        this.f32752n = new ih(context, null);
    }

    /* renamed from: I */
    public static fz m43483I() {
        return f32749k;
    }

    /* renamed from: b */
    private static it m43485b(it itVar) {
        it itVar2 = itVar;
        jn.m30864a("Creating mediation ad response for non-mediated rewarded ad.");
        try {
            ez.m19401a(itVar2.f15601b).remove("impression_urls");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, itVar2.f15600a.f28549e);
            String jSONObject2 = jSONObject.toString();
            bci bci = new bci(Arrays.asList(new bch[]{new bch(ez.m19401a(itVar2.f15601b).toString(), null, Arrays.asList(new String[]{"com.google.ads.mediation.admob.AdMobAdapter"}), null, null, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), jSONObject2, null, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, null, null, null, null, Collections.emptyList(), null, -1)}), ((Long) aph.m18688f().m18889a(asp.bB)).longValue(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), false, "", -1, 0, 1, null, 0, -1, -1, false);
            return new it(itVar2.f15600a, itVar2.f15601b, bci, itVar2.f15603d, itVar2.f15604e, itVar2.f15605f, itVar2.f15606g, itVar2.f15607h, itVar2.f15608i, null);
        } catch (Throwable e) {
            mt.m19919b("Unable to generate ad state for non-mediated rewarded video.", e);
            return new it(itVar2.f15600a, itVar2.f15601b, null, itVar2.f15603d, 0, itVar2.f15605f, itVar2.f15606g, itVar2.f15607h, itVar2.f15608i, null);
        }
    }

    /* renamed from: J */
    public final void m43486J() {
        C2872v.b("showAd must be called on the main UI thread.");
        if (m43487K()) {
            this.f32753o.m19447a(this.f32751m);
        } else {
            mt.m19924e("The reward video has not loaded.");
        }
    }

    /* renamed from: K */
    public final boolean m43487K() {
        C2872v.b("isLoaded must be called on the main UI thread.");
        return this.e.f6796g == null && this.e.f6797h == null && this.e.f6799j != null;
    }

    /* renamed from: a */
    public final void m43488a(Context context) {
        this.f32753o.m19446a(context);
    }

    /* renamed from: a */
    public final void m43489a(gt gtVar) {
        C2872v.b("loadAd must be called on the main UI thread.");
        if (TextUtils.isEmpty(gtVar.f28664b)) {
            mt.m19924e("Invalid ad unit id. Aborting.");
            jw.f15691a.post(new ga(this));
            return;
        }
        this.f32750l = false;
        this.e.f6791b = gtVar.f28664b;
        this.f32752n.m30814a(gtVar.f28664b);
        super.b(gtVar.f28663a);
    }

    /* renamed from: a */
    public final void mo6836a(hq hqVar) {
        hqVar = this.f32753o.m19445a(hqVar);
        if (ax.B().m19549e(this.e.f6792c) && hqVar != null) {
            ax.B().m19540a(this.e.f6792c, ax.B().m19555j(this.e.f6792c), this.e.f6791b, hqVar.f28691a, hqVar.f28692b);
        }
        b(hqVar);
    }

    /* renamed from: a */
    public final void m43491a(it itVar, atc atc) {
        if (itVar.f15604e != -2) {
            jw.f15691a.post(new gb(this, itVar));
            return;
        }
        this.e.f6800k = itVar;
        if (itVar.f15602c == null) {
            this.e.f6800k = m43485b(itVar);
        }
        this.f32753o.m19449c();
    }

    /* renamed from: a */
    protected final boolean m43492a(aoq aoq, is isVar, boolean z) {
        return false;
    }

    /* renamed from: a */
    public final boolean m43493a(is isVar, is isVar2) {
        b(isVar2, false);
        return fw.m19442a(isVar, isVar2);
    }

    /* renamed from: b */
    public final hl m43494b(String str) {
        return this.f32753o.m19444a(str);
    }

    /* renamed from: b */
    public final void mo6837b() {
        this.f32753o.m19453g();
        z();
    }

    /* renamed from: c */
    public final void mo6838c() {
        if (ax.B().m19549e(this.e.f6792c)) {
            this.f32752n.m30815a(false);
        }
        t();
    }

    /* renamed from: c */
    public final void m43497c(boolean z) {
        C2872v.b("setImmersiveMode must be called on the main UI thread.");
        this.f32751m = z;
    }

    /* renamed from: f */
    public final void mo6839f() {
        this.f32753o.m19454h();
        A();
    }

    /* renamed from: i */
    public final void m43499i() {
        this.f32753o.m19452f();
        super.i();
    }

    /* renamed from: n */
    public final void m43500n() {
        this.f32753o.m19450d();
    }

    /* renamed from: o */
    public final void m43501o() {
        this.f32753o.m19451e();
    }

    public final void r_() {
        if (ax.B().m19549e(this.e.f6792c)) {
            this.f32752n.m30815a(true);
        }
        a(this.e.f6799j, false);
        v();
    }

    public final void s_() {
        onAdClicked();
    }

    /* renamed from: t */
    protected final void m43502t() {
        this.e.f6799j = null;
        super.t();
    }

    public final void t_() {
        u();
    }
}
