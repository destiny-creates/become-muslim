package com.google.android.gms.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.reward.C2699c;
import com.google.android.gms.ads.reward.C2700d;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.internal.ads.aok;
import com.google.android.gms.internal.ads.ari;

/* renamed from: com.google.android.gms.ads.h */
public final class C2634h {
    /* renamed from: a */
    private final ari f6684a;

    public C2634h(Context context) {
        this.f6684a = new ari(context);
        C2872v.m8381a((Object) context, (Object) "Context cannot be null");
    }

    /* renamed from: a */
    public final void m7420a(C2603a c2603a) {
        this.f6684a.a(c2603a);
        if (c2603a == null || !(c2603a instanceof aok)) {
            if (c2603a == null) {
                this.f6684a.a(null);
            }
            return;
        }
        this.f6684a.a((aok) c2603a);
    }

    /* renamed from: a */
    public final void m7421a(C2628c c2628c) {
        this.f6684a.a(c2628c.m7408a());
    }

    /* renamed from: a */
    public final void m7422a(C2699c c2699c) {
        this.f6684a.a(c2699c);
    }

    /* renamed from: a */
    public final void m7423a(C2700d c2700d) {
        this.f6684a.a(c2700d);
    }

    /* renamed from: a */
    public final void m7424a(String str) {
        this.f6684a.a(str);
    }

    /* renamed from: a */
    public final void m7425a(boolean z) {
        this.f6684a.a(true);
    }

    /* renamed from: a */
    public final boolean m7426a() {
        return this.f6684a.a();
    }

    /* renamed from: b */
    public final void m7427b(boolean z) {
        this.f6684a.b(z);
    }

    /* renamed from: b */
    public final boolean m7428b() {
        return this.f6684a.b();
    }

    /* renamed from: c */
    public final void m7429c() {
        this.f6684a.d();
    }

    /* renamed from: d */
    public final Bundle m7430d() {
        return this.f6684a.c();
    }
}
