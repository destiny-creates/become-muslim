package com.google.p217b;

/* compiled from: Dimension */
/* renamed from: com.google.b.f */
public final class C5281f {
    /* renamed from: a */
    private final int f17832a;
    /* renamed from: b */
    private final int f17833b;

    /* renamed from: a */
    public int m22413a() {
        return this.f17832a;
    }

    /* renamed from: b */
    public int m22414b() {
        return this.f17833b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C5281f)) {
            return false;
        }
        C5281f c5281f = (C5281f) obj;
        if (this.f17832a == c5281f.f17832a && this.f17833b == c5281f.f17833b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f17832a * 32713) + this.f17833b;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f17832a);
        stringBuilder.append("x");
        stringBuilder.append(this.f17833b);
        return stringBuilder.toString();
    }
}
