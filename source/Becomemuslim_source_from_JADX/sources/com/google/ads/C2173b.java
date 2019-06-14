package com.google.ads;

import com.google.android.gms.ads.C2631d;

@Deprecated
/* renamed from: com.google.ads.b */
public final class C2173b {
    /* renamed from: a */
    public static final C2173b f5213a = new C2173b(-1, -2, "mb");
    /* renamed from: b */
    public static final C2173b f5214b = new C2173b(320, 50, "mb");
    /* renamed from: c */
    public static final C2173b f5215c = new C2173b(300, 250, "as");
    /* renamed from: d */
    public static final C2173b f5216d = new C2173b(468, 60, "as");
    /* renamed from: e */
    public static final C2173b f5217e = new C2173b(728, 90, "as");
    /* renamed from: f */
    public static final C2173b f5218f = new C2173b(160, 600, "as");
    /* renamed from: g */
    private final C2631d f5219g;

    private C2173b(int i, int i2, String str) {
        this(new C2631d(i, i2));
    }

    public C2173b(C2631d c2631d) {
        this.f5219g = c2631d;
    }

    /* renamed from: a */
    public final int m6012a() {
        return this.f5219g.m7412b();
    }

    /* renamed from: b */
    public final int m6013b() {
        return this.f5219g.m7410a();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C2173b)) {
            return false;
        }
        return this.f5219g.equals(((C2173b) obj).f5219g);
    }

    public final int hashCode() {
        return this.f5219g.hashCode();
    }

    public final String toString() {
        return this.f5219g.toString();
    }
}
