package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.mediation.C2694l;
import com.google.android.gms.ads.p168b.C2609c.C2608b;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C4757d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@cm
public final class bei extends bds {
    /* renamed from: a */
    private final C2694l f28496a;

    public bei(C2694l c2694l) {
        this.f28496a = c2694l;
    }

    /* renamed from: a */
    public final String mo4185a() {
        return this.f28496a.a();
    }

    /* renamed from: a */
    public final void mo4186a(C2758b c2758b) {
        this.f28496a.a((View) C4757d.a(c2758b));
    }

    /* renamed from: a */
    public final void mo4187a(C2758b c2758b, C2758b c2758b2, C2758b c2758b3) {
        this.f28496a.a((View) C4757d.a(c2758b), (HashMap) C4757d.a(c2758b2), (HashMap) C4757d.a(c2758b3));
    }

    /* renamed from: b */
    public final List mo4188b() {
        List<C2608b> b = this.f28496a.b();
        List arrayList = new ArrayList();
        if (b != null) {
            for (C2608b c2608b : b) {
                arrayList.add(new att(c2608b.a(), c2608b.b(), c2608b.c()));
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public final void mo4189b(C2758b c2758b) {
        this.f28496a.b((View) C4757d.a(c2758b));
    }

    /* renamed from: c */
    public final String mo4190c() {
        return this.f28496a.c();
    }

    /* renamed from: d */
    public final avd mo4191d() {
        C2608b d = this.f28496a.d();
        return d != null ? new att(d.a(), d.b(), d.c()) : null;
    }

    /* renamed from: e */
    public final String mo4192e() {
        return this.f28496a.e();
    }

    /* renamed from: f */
    public final String mo4193f() {
        return this.f28496a.f();
    }

    /* renamed from: g */
    public final double mo4194g() {
        return this.f28496a.g() != null ? this.f28496a.g().doubleValue() : -1.0d;
    }

    /* renamed from: h */
    public final String mo4195h() {
        return this.f28496a.h();
    }

    /* renamed from: i */
    public final String mo4196i() {
        return this.f28496a.i();
    }

    /* renamed from: j */
    public final aqv mo4197j() {
        return this.f28496a.j() != null ? this.f28496a.j().a() : null;
    }

    /* renamed from: k */
    public final auz mo4198k() {
        return null;
    }

    /* renamed from: l */
    public final C2758b mo4199l() {
        View l = this.f28496a.l();
        return l == null ? null : C4757d.a(l);
    }

    /* renamed from: m */
    public final C2758b mo4200m() {
        View m = this.f28496a.m();
        return m == null ? null : C4757d.a(m);
    }

    /* renamed from: n */
    public final C2758b mo4201n() {
        Object n = this.f28496a.n();
        return n == null ? null : C4757d.a(n);
    }

    /* renamed from: o */
    public final Bundle mo4202o() {
        return this.f28496a.o();
    }

    /* renamed from: p */
    public final boolean mo4203p() {
        return this.f28496a.p();
    }

    /* renamed from: q */
    public final boolean mo4204q() {
        return this.f28496a.q();
    }

    /* renamed from: r */
    public final void mo4205r() {
        this.f28496a.r();
    }
}
