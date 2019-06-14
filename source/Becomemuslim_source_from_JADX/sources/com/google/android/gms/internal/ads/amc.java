package com.google.android.gms.internal.ads;

public final class amc {
    /* renamed from: a */
    final long f14748a;
    /* renamed from: b */
    final String f14749b;
    /* renamed from: c */
    final int f14750c;

    amc(long j, String str, int i) {
        this.f14748a = j;
        this.f14749b = str;
        this.f14750c = i;
    }

    public final boolean equals(Object obj) {
        if (obj != null) {
            if (obj instanceof amc) {
                amc amc = (amc) obj;
                if (amc.f14748a == this.f14748a && amc.f14750c == this.f14750c) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return (int) this.f14748a;
    }
}
