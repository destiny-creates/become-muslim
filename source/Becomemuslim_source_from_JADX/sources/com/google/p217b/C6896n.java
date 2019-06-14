package com.google.p217b;

import com.facebook.imageutils.JfifUtil;

/* compiled from: RGBLuminanceSource */
/* renamed from: com.google.b.n */
public final class C6896n extends C5310i {
    /* renamed from: a */
    private final byte[] f24709a;
    /* renamed from: b */
    private final int f24710b;
    /* renamed from: c */
    private final int f24711c;
    /* renamed from: d */
    private final int f24712d = 0;
    /* renamed from: e */
    private final int f24713e = 0;

    public C6896n(int i, int i2, int[] iArr) {
        super(i, i2);
        this.f24710b = i;
        this.f24711c = i2;
        int i3 = 0;
        i *= i2;
        this.f24709a = new byte[i];
        while (i3 < i) {
            i2 = iArr[i3];
            int i4 = (i2 >> 16) & JfifUtil.MARKER_FIRST_BYTE;
            int i5 = (i2 >> 7) & 510;
            this.f24709a[i3] = (byte) (((i4 + i5) + (i2 & JfifUtil.MARKER_FIRST_BYTE)) / 4);
            i3++;
        }
    }

    /* renamed from: a */
    public byte[] mo4873a(int i, byte[] bArr) {
        if (i < 0 || i >= m22567c()) {
            throw new IllegalArgumentException("Requested row is outside the image: ".concat(String.valueOf(i)));
        }
        int b = m22566b();
        if (bArr == null || bArr.length < b) {
            bArr = new byte[b];
        }
        System.arraycopy(this.f24709a, ((i + this.f24713e) * this.f24710b) + this.f24712d, bArr, 0, b);
        return bArr;
    }

    /* renamed from: a */
    public byte[] mo4872a() {
        int b = m22566b();
        int c = m22567c();
        if (b == this.f24710b && c == this.f24711c) {
            return this.f24709a;
        }
        int i = b * c;
        Object obj = new byte[i];
        int i2 = (this.f24713e * this.f24710b) + this.f24712d;
        int i3 = 0;
        if (b == this.f24710b) {
            System.arraycopy(this.f24709a, i2, obj, 0, i);
            return obj;
        }
        while (i3 < c) {
            System.arraycopy(this.f24709a, i2, obj, i3 * b, b);
            i2 += this.f24710b;
            i3++;
        }
        return obj;
    }
}
