package com.google.android.gms.auth.api.signin.internal;

/* renamed from: com.google.android.gms.auth.api.signin.internal.b */
public class C2741b {
    /* renamed from: a */
    private static int f7029a = 31;
    /* renamed from: b */
    private int f7030b = 1;

    /* renamed from: a */
    public C2741b m7798a(Object obj) {
        this.f7030b = (f7029a * this.f7030b) + (obj == null ? null : obj.hashCode());
        return this;
    }

    /* renamed from: a */
    public final C2741b m7799a(boolean z) {
        this.f7030b = (f7029a * this.f7030b) + z;
        return this;
    }

    /* renamed from: a */
    public int m7797a() {
        return this.f7030b;
    }
}
