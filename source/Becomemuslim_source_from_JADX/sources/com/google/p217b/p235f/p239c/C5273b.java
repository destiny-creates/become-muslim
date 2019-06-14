package com.google.p217b.p235f.p239c;

/* compiled from: BarcodeRow */
/* renamed from: com.google.b.f.c.b */
final class C5273b {
    /* renamed from: a */
    private final byte[] f17794a;
    /* renamed from: b */
    private int f17795b = 0;

    C5273b(int i) {
        this.f17794a = new byte[i];
    }

    /* renamed from: a */
    private void m22367a(int i, boolean z) {
        this.f17794a[i] = (byte) z;
    }

    /* renamed from: a */
    void m22368a(boolean z, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.f17795b;
            this.f17795b = i3 + 1;
            m22367a(i3, z);
        }
    }

    /* renamed from: a */
    byte[] m22369a(int i) {
        byte[] bArr = new byte[(this.f17794a.length * i)];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = this.f17794a[i2 / i];
        }
        return bArr;
    }
}
