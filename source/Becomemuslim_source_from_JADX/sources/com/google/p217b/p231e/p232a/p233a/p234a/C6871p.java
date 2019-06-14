package com.google.p217b.p231e.p232a.p233a.p234a;

import com.google.p217b.C6891h;

/* compiled from: DecodedNumeric */
/* renamed from: com.google.b.e.a.a.a.p */
final class C6871p extends C5240q {
    /* renamed from: a */
    private final int f24689a;
    /* renamed from: b */
    private final int f24690b;

    C6871p(int i, int i2, int i3) {
        super(i);
        if (i2 < 0 || i2 > 10 || i3 < 0 || i3 > 10) {
            throw C6891h.m32342a();
        }
        this.f24689a = i2;
        this.f24690b = i3;
    }

    /* renamed from: a */
    int m32287a() {
        return this.f24689a;
    }

    /* renamed from: b */
    int m32288b() {
        return this.f24690b;
    }

    /* renamed from: c */
    boolean m32289c() {
        return this.f24689a == 10;
    }

    /* renamed from: d */
    boolean m32290d() {
        return this.f24690b == 10;
    }
}
