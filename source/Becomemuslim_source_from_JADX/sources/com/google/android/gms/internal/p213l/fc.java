package com.google.android.gms.internal.p213l;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.util.C2895e;

/* renamed from: com.google.android.gms.internal.l.fc */
public final class fc extends C8220s {
    /* renamed from: a */
    private Handler f32827a;
    /* renamed from: b */
    private long f32828b = mo4751m().b();
    /* renamed from: c */
    private final ai f32829c = new fd(this, this.q);
    /* renamed from: d */
    private final ai f32830d = new fe(this, this.q);

    fc(cg cgVar) {
        super(cgVar);
    }

    /* renamed from: C */
    private final void m44223C() {
        synchronized (this) {
            if (this.f32827a == null) {
                this.f32827a = new Handler(Looper.getMainLooper());
            }
        }
    }

    /* renamed from: D */
    private final void m44224D() {
        mo6210d();
        m44232a(false);
        mo6741e().m42703a(mo4751m().b());
    }

    /* renamed from: a */
    private final void m44225a(long j) {
        ai aiVar;
        long a;
        mo6210d();
        m44223C();
        this.f32829c.m21244c();
        this.f32830d.m21244c();
        mo4754r().m42579w().m21308a("Activity resumed, time", Long.valueOf(j));
        this.f32828b = j;
        if (mo4751m().a() - mo6214s().f32335l.m21318a() > mo6214s().f32337n.m21318a()) {
            mo6214s().f32336m.m21316a(true);
            mo6214s().f32338o.m21319a(0);
        }
        if (mo6214s().f32336m.m21317a()) {
            aiVar = this.f32829c;
            a = mo6214s().f32334k.m21318a();
        } else {
            aiVar = this.f32830d;
            a = 3600000;
        }
        aiVar.m21242a(Math.max(0, a - mo6214s().f32338o.m21318a()));
    }

    /* renamed from: b */
    private final void m44228b(long j) {
        mo6210d();
        m44223C();
        this.f32829c.m21244c();
        this.f32830d.m21244c();
        mo4754r().m42579w().m21308a("Activity paused, time", Long.valueOf(j));
        if (this.f32828b != 0) {
            mo6214s().f32338o.m21319a(mo6214s().f32338o.m21318a() + (j - this.f32828b));
        }
    }

    /* renamed from: B */
    final void m44230B() {
        this.f32829c.m21244c();
        this.f32830d.m21244c();
        this.f32828b = 0;
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo6207a() {
        super.mo6207a();
    }

    /* renamed from: a */
    public final boolean m44232a(boolean z) {
        mo6210d();
        m42728w();
        long b = mo4751m().b();
        mo6214s().f32337n.m21319a(mo4751m().a());
        long j = b - this.f32828b;
        if (z || j >= 1000) {
            mo6214s().f32338o.m21319a(j);
            mo4754r().m42579w().m21308a("Recording user engagement, ms", Long.valueOf(j));
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j);
            ea.m44136a(mo6745i().m44139B(), bundle, true);
            mo6742f().m44099a("auto", "_e", bundle);
            this.f32828b = b;
            this.f32830d.m21244c();
            this.f32830d.m21242a(Math.max(0, 3600000 - mo6214s().f32338o.m21318a()));
            return true;
        }
        mo4754r().m42579w().m21308a("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j));
        return false;
    }

    /* renamed from: b */
    public final /* bridge */ /* synthetic */ void mo6208b() {
        super.mo6208b();
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

    /* renamed from: z */
    protected final boolean mo6852z() {
        return false;
    }
}
