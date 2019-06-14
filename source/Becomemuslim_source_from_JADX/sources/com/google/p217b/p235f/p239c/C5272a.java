package com.google.p217b.p235f.p239c;

import java.lang.reflect.Array;

/* compiled from: BarcodeMatrix */
/* renamed from: com.google.b.f.c.a */
public final class C5272a {
    /* renamed from: a */
    private final C5273b[] f17790a;
    /* renamed from: b */
    private int f17791b;
    /* renamed from: c */
    private final int f17792c;
    /* renamed from: d */
    private final int f17793d;

    C5272a(int i, int i2) {
        this.f17790a = new C5273b[i];
        int length = this.f17790a.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.f17790a[i3] = new C5273b(((i2 + 4) * 17) + 1);
        }
        this.f17793d = i2 * 17;
        this.f17792c = i;
        this.f17791b = -1;
    }

    /* renamed from: a */
    void m22364a() {
        this.f17791b++;
    }

    /* renamed from: b */
    C5273b m22366b() {
        return this.f17790a[this.f17791b];
    }

    /* renamed from: a */
    public byte[][] m22365a(int i, int i2) {
        byte[][] bArr = (byte[][]) Array.newInstance(byte.class, new int[]{this.f17792c * i2, this.f17793d * i});
        int i3 = this.f17792c * i2;
        for (int i4 = 0; i4 < i3; i4++) {
            bArr[(i3 - i4) - 1] = this.f17790a[i4 / i2].m22369a(i);
        }
        return bArr;
    }
}
