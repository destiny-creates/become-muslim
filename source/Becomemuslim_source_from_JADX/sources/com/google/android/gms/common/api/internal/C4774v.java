package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.support.v4.util.C0448b;
import com.google.android.gms.common.C4775b;
import com.google.android.gms.common.internal.C2872v;

/* renamed from: com.google.android.gms.common.api.internal.v */
public class C4774v extends cj {
    /* renamed from: e */
    private final C0448b<cg<?>> f13204e = new C0448b();
    /* renamed from: f */
    private C2798d f13205f;

    /* renamed from: a */
    public static void m16816a(Activity activity, C2798d c2798d, cg<?> cgVar) {
        activity = LifecycleCallback.m7969a(activity);
        C4774v c4774v = (C4774v) activity.mo2449a("ConnectionlessLifecycleHelper", C4774v.class);
        if (c4774v == null) {
            c4774v = new C4774v(activity);
        }
        c4774v.f13205f = c2798d;
        C2872v.m8381a((Object) cgVar, (Object) "ApiKey cannot be null");
        c4774v.f13204e.add(cgVar);
        c2798d.m8060a(c4774v);
    }

    private C4774v(C2801g c2801g) {
        super(c2801g);
        this.a.mo2450a("ConnectionlessLifecycleHelper", (LifecycleCallback) this);
    }

    /* renamed from: b */
    public void mo2433b() {
        super.mo2433b();
        m16817i();
    }

    /* renamed from: c */
    public void mo3289c() {
        super.mo3289c();
        m16817i();
    }

    /* renamed from: d */
    public void mo2435d() {
        super.mo2435d();
        this.f13205f.m8062b(this);
    }

    /* renamed from: a */
    protected final void mo3285a(C4775b c4775b, int i) {
        this.f13205f.m8063b(c4775b, i);
    }

    /* renamed from: f */
    protected final void mo3287f() {
        this.f13205f.m8065d();
    }

    /* renamed from: g */
    final C0448b<cg<?>> m16823g() {
        return this.f13204e;
    }

    /* renamed from: i */
    private final void m16817i() {
        if (!this.f13204e.isEmpty()) {
            this.f13205f.m8060a(this);
        }
    }
}
