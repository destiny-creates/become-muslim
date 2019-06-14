package com.google.p217b.p222b;

import com.facebook.imageutils.JfifUtil;

/* compiled from: BitSource */
/* renamed from: com.google.b.b.c */
public final class C5203c {
    /* renamed from: a */
    private final byte[] f17540a;
    /* renamed from: b */
    private int f17541b;
    /* renamed from: c */
    private int f17542c;

    public C5203c(byte[] bArr) {
        this.f17540a = bArr;
    }

    /* renamed from: a */
    public int m22013a() {
        return this.f17542c;
    }

    /* renamed from: b */
    public int m22015b() {
        return this.f17541b;
    }

    /* renamed from: a */
    public int m22014a(int i) {
        if (i <= 0 || i > 32 || i > m22016c()) {
            throw new IllegalArgumentException(String.valueOf(i));
        }
        int i2;
        if (this.f17542c > 0) {
            i2 = 8 - this.f17542c;
            int i3 = i < i2 ? i : i2;
            i2 -= i3;
            i2 = (((JfifUtil.MARKER_FIRST_BYTE >> (8 - i3)) << i2) & this.f17540a[this.f17541b]) >> i2;
            i -= i3;
            this.f17542c += i3;
            if (this.f17542c == 8) {
                this.f17542c = 0;
                this.f17541b++;
            }
        } else {
            i2 = 0;
        }
        if (i <= 0) {
            return i2;
        }
        while (i >= 8) {
            i2 = (i2 << 8) | (this.f17540a[this.f17541b] & JfifUtil.MARKER_FIRST_BYTE);
            this.f17541b++;
            i -= 8;
        }
        if (i <= 0) {
            return i2;
        }
        int i4 = 8 - i;
        i2 = (i2 << i) | ((((JfifUtil.MARKER_FIRST_BYTE >> i4) << i4) & this.f17540a[this.f17541b]) >> i4);
        this.f17542c += i;
        return i2;
    }

    /* renamed from: c */
    public int m22016c() {
        return ((this.f17540a.length - this.f17541b) * 8) - this.f17542c;
    }
}
