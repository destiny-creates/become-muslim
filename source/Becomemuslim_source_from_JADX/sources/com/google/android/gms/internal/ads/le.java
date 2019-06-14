package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.C2868t;

public final class le {
    /* renamed from: a */
    public final String f15753a;
    /* renamed from: b */
    public final double f15754b;
    /* renamed from: c */
    public final int f15755c;
    /* renamed from: d */
    private final double f15756d;
    /* renamed from: e */
    private final double f15757e;

    public le(String str, double d, double d2, double d3, int i) {
        this.f15753a = str;
        this.f15757e = d;
        this.f15756d = d2;
        this.f15754b = d3;
        this.f15755c = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof le)) {
            return false;
        }
        le leVar = (le) obj;
        return C2868t.a(this.f15753a, leVar.f15753a) && this.f15756d == leVar.f15756d && this.f15757e == leVar.f15757e && this.f15755c == leVar.f15755c && Double.compare(this.f15754b, leVar.f15754b) == 0;
    }

    public final int hashCode() {
        return C2868t.a(new Object[]{this.f15753a, Double.valueOf(this.f15756d), Double.valueOf(this.f15757e), Double.valueOf(this.f15754b), Integer.valueOf(this.f15755c)});
    }

    public final String toString() {
        return C2868t.a(this).a("name", this.f15753a).a("minBound", Double.valueOf(this.f15757e)).a("maxBound", Double.valueOf(this.f15756d)).a("percent", Double.valueOf(this.f15754b)).a("count", Integer.valueOf(this.f15755c)).toString();
    }
}
