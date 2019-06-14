package com.google.p217b.p231e.p232a;

import com.google.p217b.C5316s;

/* compiled from: FinderPattern */
/* renamed from: com.google.b.e.a.c */
public final class C5247c {
    /* renamed from: a */
    private final int f17702a;
    /* renamed from: b */
    private final int[] f17703b;
    /* renamed from: c */
    private final C5316s[] f17704c;

    public C5247c(int i, int[] iArr, int i2, int i3, int i4) {
        this.f17702a = i;
        this.f17703b = iArr;
        i = new C5316s[2];
        i4 = (float) i4;
        i[0] = new C5316s((float) i2, i4);
        i[1] = new C5316s((float) i3, i4);
        this.f17704c = i;
    }

    /* renamed from: a */
    public int m22226a() {
        return this.f17702a;
    }

    /* renamed from: b */
    public int[] m22227b() {
        return this.f17703b;
    }

    /* renamed from: c */
    public C5316s[] m22228c() {
        return this.f17704c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C5247c)) {
            return false;
        }
        if (this.f17702a == ((C5247c) obj).f17702a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f17702a;
    }
}
