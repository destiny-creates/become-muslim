package com.google.android.gms.internal.p213l;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.util.C3211a;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.util.C2895e;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.l.n */
public final class C8219n extends C7825r {
    /* renamed from: a */
    private final Map<String, Long> f32364a = new C3211a();
    /* renamed from: b */
    private final Map<String, Integer> f32365b = new C3211a();
    /* renamed from: c */
    private long f32366c;

    public C8219n(cg cgVar) {
        super(cgVar);
    }

    /* renamed from: a */
    private final void m42694a(long j, dz dzVar) {
        if (dzVar == null) {
            mo4754r().m42579w().m21307a("Not logging ad exposure. No active activity");
        } else if (j < 1000) {
            mo4754r().m42579w().m21308a("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j);
            ea.m44136a(dzVar, bundle, true);
            mo6742f().m44099a("am", "_xa", bundle);
        }
    }

    /* renamed from: a */
    private final void m42697a(String str, long j) {
        mo6208b();
        mo6210d();
        C2872v.a(str);
        if (this.f32365b.isEmpty()) {
            this.f32366c = j;
        }
        Integer num = (Integer) this.f32365b.get(str);
        if (num != null) {
            this.f32365b.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (this.f32365b.size() >= 100) {
            mo4754r().m42565i().m21307a("Too many ads visible");
        } else {
            this.f32365b.put(str, Integer.valueOf(1));
            this.f32364a.put(str, Long.valueOf(j));
        }
    }

    /* renamed from: a */
    private final void m42698a(String str, long j, dz dzVar) {
        if (dzVar == null) {
            mo4754r().m42579w().m21307a("Not logging ad unit exposure. No active activity");
        } else if (j < 1000) {
            mo4754r().m42579w().m21308a("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j);
            ea.m44136a(dzVar, bundle, true);
            mo6742f().m44099a("am", "_xu", bundle);
        }
    }

    /* renamed from: b */
    private final void m42699b(long j) {
        for (String put : this.f32364a.keySet()) {
            this.f32364a.put(put, Long.valueOf(j));
        }
        if (!this.f32364a.isEmpty()) {
            this.f32366c = j;
        }
    }

    /* renamed from: b */
    private final void m42701b(String str, long j) {
        mo6208b();
        mo6210d();
        C2872v.a(str);
        Integer num = (Integer) this.f32365b.get(str);
        if (num != null) {
            dz B = mo6745i().m44139B();
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.f32365b.remove(str);
                Long l = (Long) this.f32364a.get(str);
                if (l == null) {
                    mo4754r().I_().m21307a("First ad unit exposure time was never set");
                } else {
                    long longValue = j - l.longValue();
                    this.f32364a.remove(str);
                    m42698a(str, longValue, B);
                }
                if (this.f32365b.isEmpty()) {
                    if (this.f32366c == 0) {
                        mo4754r().I_().m21307a("First ad exposure time was never set");
                        return;
                    } else {
                        m42694a(j - this.f32366c, B);
                        this.f32366c = 0;
                    }
                }
                return;
            }
            this.f32365b.put(str, Integer.valueOf(intValue));
            return;
        }
        mo4754r().I_().m21308a("Call to endAdUnitExposure for unknown ad unit id", str);
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo6207a() {
        super.mo6207a();
    }

    /* renamed from: a */
    public final void m42703a(long j) {
        dz B = mo6745i().m44139B();
        for (String str : this.f32364a.keySet()) {
            m42698a(str, j - ((Long) this.f32364a.get(str)).longValue(), B);
        }
        if (!this.f32364a.isEmpty()) {
            m42694a(j - this.f32366c, B);
        }
        m42699b(j);
    }

    /* renamed from: a */
    public final void m42704a(String str) {
        if (str != null) {
            if (str.length() != 0) {
                mo4753q().m42612a(new C5047o(this, str, mo4751m().b()));
                return;
            }
        }
        mo4754r().I_().m21307a("Ad unit id must be a non-empty string");
    }

    /* renamed from: b */
    public final /* bridge */ /* synthetic */ void mo6208b() {
        super.mo6208b();
    }

    /* renamed from: b */
    public final void m42706b(String str) {
        if (str != null) {
            if (str.length() != 0) {
                mo4753q().m42612a(new C5048p(this, str, mo4751m().b()));
                return;
            }
        }
        mo4754r().I_().m21307a("Ad unit id must be a non-empty string");
    }

    /* renamed from: c */
    public final /* bridge */ /* synthetic */ void mo6209c() {
        super.mo6209c();
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
}
