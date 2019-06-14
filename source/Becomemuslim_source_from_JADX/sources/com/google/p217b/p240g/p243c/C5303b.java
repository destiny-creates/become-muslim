package com.google.p217b.p240g.p243c;

import java.lang.reflect.Array;
import java.util.Arrays;

/* compiled from: ByteMatrix */
/* renamed from: com.google.b.g.c.b */
public final class C5303b {
    /* renamed from: a */
    private final byte[][] f17909a;
    /* renamed from: b */
    private final int f17910b;
    /* renamed from: c */
    private final int f17911c;

    public C5303b(int i, int i2) {
        this.f17909a = (byte[][]) Array.newInstance(byte.class, new int[]{i2, i});
        this.f17910b = i;
        this.f17911c = i2;
    }

    /* renamed from: a */
    public int m22502a() {
        return this.f17911c;
    }

    /* renamed from: b */
    public int m22506b() {
        return this.f17910b;
    }

    /* renamed from: a */
    public byte m22501a(int i, int i2) {
        return this.f17909a[i2][i];
    }

    /* renamed from: c */
    public byte[][] m22507c() {
        return this.f17909a;
    }

    /* renamed from: a */
    public void m22504a(int i, int i2, int i3) {
        this.f17909a[i2][i] = (byte) i3;
    }

    /* renamed from: a */
    public void m22505a(int i, int i2, boolean z) {
        this.f17909a[i2][i] = (byte) z;
    }

    /* renamed from: a */
    public void m22503a(byte b) {
        for (byte[] fill : this.f17909a) {
            Arrays.fill(fill, b);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(((this.f17910b * 2) * this.f17911c) + 2);
        for (int i = 0; i < this.f17911c; i++) {
            byte[] bArr = this.f17909a[i];
            for (int i2 = 0; i2 < this.f17910b; i2++) {
                switch (bArr[i2]) {
                    case (byte) 0:
                        stringBuilder.append(" 0");
                        break;
                    case (byte) 1:
                        stringBuilder.append(" 1");
                        break;
                    default:
                        stringBuilder.append("  ");
                        break;
                }
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
