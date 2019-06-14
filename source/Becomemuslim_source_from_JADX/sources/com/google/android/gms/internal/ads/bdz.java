package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.mediation.C4300h;
import com.google.android.gms.ads.p168b.C2609c.C2608b;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C4757d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@cm
public final class bdz extends bdp {
    /* renamed from: a */
    private final C4300h f28483a;

    public bdz(C4300h c4300h) {
        this.f28483a = c4300h;
    }

    /* renamed from: a */
    public final String mo4166a() {
        return this.f28483a.i();
    }

    /* renamed from: a */
    public final void mo4167a(C2758b c2758b) {
        this.f28483a.c((View) C4757d.a(c2758b));
    }

    /* renamed from: a */
    public final void mo4168a(C2758b c2758b, C2758b c2758b2, C2758b c2758b3) {
        this.f28483a.a((View) C4757d.a(c2758b), (HashMap) C4757d.a(c2758b2), (HashMap) C4757d.a(c2758b3));
    }

    /* renamed from: b */
    public final List mo4169b() {
        List<C2608b> j = this.f28483a.j();
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
    public final void mo4170b(C2758b c2758b) {
        this.f28483a.a((View) C4757d.a(c2758b));
    }

    /* renamed from: c */
    public final String mo4171c() {
        return this.f28483a.k();
    }

    /* renamed from: c */
    public final void mo4172c(C2758b c2758b) {
        this.f28483a.b((View) C4757d.a(c2758b));
    }

    /* renamed from: d */
    public final avd mo4173d() {
        C2608b l = this.f28483a.l();
        return l != null ? new att(l.a(), l.b(), l.c()) : null;
    }

    /* renamed from: e */
    public final String mo4174e() {
        return this.f28483a.m();
    }

    /* renamed from: f */
    public final String mo4175f() {
        return this.f28483a.n();
    }

    /* renamed from: g */
    public final void mo4176g() {
        this.f28483a.e();
    }

    /* renamed from: h */
    public final boolean mo4177h() {
        return this.f28483a.a();
    }

    /* renamed from: i */
    public final boolean mo4178i() {
        return this.f28483a.b();
    }

    /* renamed from: j */
    public final Bundle mo4179j() {
        return this.f28483a.c();
    }

    /* renamed from: k */
    public final C2758b mo4180k() {
        View d = this.f28483a.d();
        return d == null ? null : C4757d.a(d);
    }

    /* renamed from: l */
    public final aqv mo4181l() {
        return this.f28483a.g() != null ? this.f28483a.g().a() : null;
    }

    /* renamed from: m */
    public final auz mo4182m() {
        return null;
    }

    /* renamed from: n */
    public final C2758b mo4183n() {
        View f = this.f28483a.f();
        return f == null ? null : C4757d.a(f);
    }

    /* renamed from: o */
    public final C2758b mo4184o() {
        return null;
    }
}
