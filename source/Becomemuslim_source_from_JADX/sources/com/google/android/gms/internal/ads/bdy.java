package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.mediation.C4299g;
import com.google.android.gms.ads.p168b.C2609c.C2608b;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C4757d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@cm
public final class bdy extends bdm {
    /* renamed from: a */
    private final C4299g f28482a;

    public bdy(C4299g c4299g) {
        this.f28482a = c4299g;
    }

    /* renamed from: a */
    public final String mo4145a() {
        return this.f28482a.i();
    }

    /* renamed from: a */
    public final void mo4146a(C2758b c2758b) {
        this.f28482a.c((View) C4757d.a(c2758b));
    }

    /* renamed from: a */
    public final void mo4147a(C2758b c2758b, C2758b c2758b2, C2758b c2758b3) {
        this.f28482a.a((View) C4757d.a(c2758b), (HashMap) C4757d.a(c2758b2), (HashMap) C4757d.a(c2758b3));
    }

    /* renamed from: b */
    public final List mo4148b() {
        List<C2608b> j = this.f28482a.j();
        if (j == null) {
            return null;
        }
        List arrayList = new ArrayList();
        for (C2608b c2608b : j) {
            arrayList.add(new att(c2608b.a(), c2608b.b(), c2608b.c()));
        }
        return arrayList;
    }

    /* renamed from: b */
    public final void mo4149b(C2758b c2758b) {
        this.f28482a.a((View) C4757d.a(c2758b));
    }

    /* renamed from: c */
    public final String mo4150c() {
        return this.f28482a.k();
    }

    /* renamed from: c */
    public final void mo4151c(C2758b c2758b) {
        this.f28482a.b((View) C4757d.a(c2758b));
    }

    /* renamed from: d */
    public final avd mo4152d() {
        C2608b l = this.f28482a.l();
        return l != null ? new att(l.a(), l.b(), l.c()) : null;
    }

    /* renamed from: e */
    public final String mo4153e() {
        return this.f28482a.m();
    }

    /* renamed from: f */
    public final double mo4154f() {
        return this.f28482a.n();
    }

    /* renamed from: g */
    public final String mo4155g() {
        return this.f28482a.o();
    }

    /* renamed from: h */
    public final String mo4156h() {
        return this.f28482a.p();
    }

    /* renamed from: i */
    public final void mo4157i() {
        this.f28482a.e();
    }

    /* renamed from: j */
    public final boolean mo4158j() {
        return this.f28482a.a();
    }

    /* renamed from: k */
    public final boolean mo4159k() {
        return this.f28482a.b();
    }

    /* renamed from: l */
    public final Bundle mo4160l() {
        return this.f28482a.c();
    }

    /* renamed from: m */
    public final aqv mo4161m() {
        return this.f28482a.g() != null ? this.f28482a.g().a() : null;
    }

    /* renamed from: n */
    public final C2758b mo4162n() {
        View d = this.f28482a.d();
        return d == null ? null : C4757d.a(d);
    }

    /* renamed from: o */
    public final auz mo4163o() {
        return null;
    }

    /* renamed from: p */
    public final C2758b mo4164p() {
        View f = this.f28482a.f();
        return f == null ? null : C4757d.a(f);
    }

    /* renamed from: q */
    public final C2758b mo4165q() {
        return null;
    }
}
