package com.google.android.gms.internal.p213l;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.util.C3211a;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.util.C2895e;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.l.ea */
public final class ea extends C8220s {
    /* renamed from: a */
    protected dz f32814a;
    /* renamed from: b */
    private volatile dz f32815b;
    /* renamed from: c */
    private dz f32816c;
    /* renamed from: d */
    private final Map<Activity, dz> f32817d = new C3211a();
    /* renamed from: e */
    private dz f32818e;
    /* renamed from: f */
    private String f32819f;

    public ea(cg cgVar) {
        super(cgVar);
    }

    /* renamed from: a */
    private static String m44133a(String str) {
        String[] split = str.split("\\.");
        str = split.length > 0 ? split[split.length - 1] : "";
        return str.length() > 100 ? str.substring(0, 100) : str;
    }

    /* renamed from: a */
    private final void m44134a(Activity activity, dz dzVar, boolean z) {
        dz dzVar2 = this.f32815b == null ? this.f32816c : this.f32815b;
        if (dzVar.f17146b == null) {
            dzVar = new dz(dzVar.f17145a, ea.m44133a(activity.getClass().getCanonicalName()), dzVar.f17147c);
        }
        this.f32816c = this.f32815b;
        this.f32815b = dzVar;
        mo4753q().m42612a(new eb(this, z, dzVar2, dzVar));
    }

    /* renamed from: a */
    private final void m44135a(dz dzVar) {
        mo6741e().m42703a(mo4751m().b());
        if (mo6747k().m44232a(dzVar.f17148d)) {
            dzVar.f17148d = false;
        }
    }

    /* renamed from: a */
    public static void m44136a(dz dzVar, Bundle bundle, boolean z) {
        if (bundle == null || dzVar == null || (bundle.containsKey("_sc") && !z)) {
            if (bundle != null && dzVar == null && z) {
                bundle.remove("_sn");
                bundle.remove("_sc");
                bundle.remove("_si");
            }
            return;
        }
        if (dzVar.f17145a != null) {
            bundle.putString("_sn", dzVar.f17145a);
        } else {
            bundle.remove("_sn");
        }
        bundle.putString("_sc", dzVar.f17146b);
        bundle.putLong("_si", dzVar.f17147c);
    }

    /* renamed from: d */
    private final dz m44138d(Activity activity) {
        C2872v.a(activity);
        dz dzVar = (dz) this.f32817d.get(activity);
        if (dzVar != null) {
            return dzVar;
        }
        dz dzVar2 = new dz(null, ea.m44133a(activity.getClass().getCanonicalName()), mo6213p().m42680g());
        this.f32817d.put(activity, dzVar2);
        return dzVar2;
    }

    /* renamed from: B */
    public final dz m44139B() {
        m42728w();
        mo6210d();
        return this.f32814a;
    }

    /* renamed from: C */
    public final dz m44140C() {
        mo6208b();
        return this.f32815b;
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo6207a() {
        super.mo6207a();
    }

    /* renamed from: a */
    public final void m44142a(Activity activity) {
        m44134a(activity, m44138d(activity), false);
        db e = mo6741e();
        e.mo4753q().m42612a(new C5049q(e, e.mo4751m().b()));
    }

    /* renamed from: a */
    public final void m44143a(Activity activity, Bundle bundle) {
        if (bundle != null) {
            bundle = bundle.getBundle("com.google.firebase.analytics.screen_service");
            if (bundle != null) {
                this.f32817d.put(activity, new dz(bundle.getString("name"), bundle.getString("referrer_name"), bundle.getLong("id")));
            }
        }
    }

    /* renamed from: a */
    public final void m44144a(Activity activity, String str, String str2) {
        if (!C5052x.m21503a()) {
            mo4754r().m42565i().m21307a("setCurrentScreen must be called from the main thread");
        } else if (this.f32815b == null) {
            mo4754r().m42565i().m21307a("setCurrentScreen cannot be called while no activity active");
        } else if (this.f32817d.get(activity) == null) {
            mo4754r().m42565i().m21307a("setCurrentScreen must be called with an activity in the activity lifecycle");
        } else {
            if (str2 == null) {
                str2 = ea.m44133a(activity.getClass().getCanonicalName());
            }
            boolean equals = this.f32815b.f17146b.equals(str2);
            boolean b = fw.m42649b(this.f32815b.f17145a, str);
            if (equals && b) {
                mo4754r().m42566j().m21307a("setCurrentScreen cannot be called with the same class and name");
            } else if (str != null && (str.length() <= 0 || str.length() > 100)) {
                mo4754r().m42565i().m21308a("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            } else if (str2 == null || (str2.length() > 0 && str2.length() <= 100)) {
                mo4754r().m42579w().m21309a("Setting current screen to name, class", str == null ? "null" : str, str2);
                dz dzVar = new dz(str, str2, mo6213p().m42680g());
                this.f32817d.put(activity, dzVar);
                m44134a(activity, dzVar, true);
            } else {
                mo4754r().m42565i().m21308a("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            }
        }
    }

    /* renamed from: a */
    public final void m44145a(String str, dz dzVar) {
        mo6210d();
        synchronized (this) {
            if (this.f32819f == null || this.f32819f.equals(str) || dzVar != null) {
                this.f32819f = str;
                this.f32818e = dzVar;
            }
        }
    }

    /* renamed from: b */
    public final /* bridge */ /* synthetic */ void mo6208b() {
        super.mo6208b();
    }

    /* renamed from: b */
    public final void m44147b(Activity activity) {
        dz d = m44138d(activity);
        this.f32816c = this.f32815b;
        this.f32815b = null;
        mo4753q().m42612a(new ec(this, d));
    }

    /* renamed from: b */
    public final void m44148b(Activity activity, Bundle bundle) {
        if (bundle != null) {
            dz dzVar = (dz) this.f32817d.get(activity);
            if (dzVar != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putLong("id", dzVar.f17147c);
                bundle2.putString("name", dzVar.f17145a);
                bundle2.putString("referrer_name", dzVar.f17146b);
                bundle.putBundle("com.google.firebase.analytics.screen_service", bundle2);
            }
        }
    }

    /* renamed from: c */
    public final /* bridge */ /* synthetic */ void mo6209c() {
        super.mo6209c();
    }

    /* renamed from: c */
    public final void m44150c(Activity activity) {
        this.f32817d.remove(activity);
    }

    /* renamed from: d */
    public final /* bridge */ /* synthetic */ void mo6210d() {
        super.mo6210d();
    }

    /* renamed from: e */
    public final /* bridge */ /* synthetic */ C8219n mo6741e() {
        return super.mo6741e();
    }

    /* renamed from: f */
    public final /* bridge */ /* synthetic */ df mo6742f() {
        return super.mo6742f();
    }

    /* renamed from: g */
    public final /* bridge */ /* synthetic */ aw mo6743g() {
        return super.mo6743g();
    }

    /* renamed from: h */
    public final /* bridge */ /* synthetic */ ed mo6744h() {
        return super.mo6744h();
    }

    /* renamed from: i */
    public final /* bridge */ /* synthetic */ ea mo6745i() {
        return super.mo6745i();
    }

    /* renamed from: j */
    public final /* bridge */ /* synthetic */ ax mo6746j() {
        return super.mo6746j();
    }

    /* renamed from: k */
    public final /* bridge */ /* synthetic */ fc mo6747k() {
        return super.mo6747k();
    }

    /* renamed from: l */
    public final /* bridge */ /* synthetic */ ak mo6211l() {
        return super.mo6211l();
    }

    /* renamed from: m */
    public final /* bridge */ /* synthetic */ C2895e mo4751m() {
        return super.mo4751m();
    }

    /* renamed from: n */
    public final /* bridge */ /* synthetic */ Context mo4752n() {
        return super.mo4752n();
    }

    /* renamed from: o */
    public final /* bridge */ /* synthetic */ az mo6212o() {
        return super.mo6212o();
    }

    /* renamed from: p */
    public final /* bridge */ /* synthetic */ fw mo6213p() {
        return super.mo6213p();
    }

    /* renamed from: q */
    public final /* bridge */ /* synthetic */ cb mo4753q() {
        return super.mo4753q();
    }

    /* renamed from: r */
    public final /* bridge */ /* synthetic */ bb mo4754r() {
        return super.mo4754r();
    }

    /* renamed from: s */
    public final /* bridge */ /* synthetic */ bm mo6214s() {
        return super.mo6214s();
    }

    /* renamed from: t */
    public final /* bridge */ /* synthetic */ aa mo6215t() {
        return super.mo6215t();
    }

    /* renamed from: u */
    public final /* bridge */ /* synthetic */ C5052x mo4755u() {
        return super.mo4755u();
    }

    /* renamed from: z */
    protected final boolean mo6852z() {
        return false;
    }
}
