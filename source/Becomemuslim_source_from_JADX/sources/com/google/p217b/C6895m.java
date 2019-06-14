package com.google.p217b;

/* compiled from: PlanarYUVLuminanceSource */
/* renamed from: com.google.b.m */
public final class C6895m extends C5310i {
    /* renamed from: a */
    private final byte[] f24704a;
    /* renamed from: b */
    private final int f24705b;
    /* renamed from: c */
    private final int f24706c;
    /* renamed from: d */
    private final int f24707d;
    /* renamed from: e */
    private final int f24708e;

    public C6895m(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        super(i5, i6);
        if (i3 + i5 > i || i4 + i6 > i2) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.f24704a = bArr;
        this.f24705b = i;
        this.f24706c = i2;
        this.f24707d = i3;
        this.f24708e = i4;
        if (z) {
            m32350a(i5, i6);
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
        System.arraycopy(this.f24704a, ((i + this.f24708e) * this.f24705b) + this.f24707d, bArr, 0, b);
        return bArr;
    }

    /* renamed from: a */
    public byte[] mo4872a() {
        int b = m22566b();
        int c = m22567c();
        if (b == this.f24705b && c == this.f24706c) {
            return this.f24704a;
        }
        int i = b * c;
        Object obj = new byte[i];
        int i2 = (this.f24708e * this.f24705b) + this.f24707d;
        int i3 = 0;
        if (b == this.f24705b) {
            System.arraycopy(this.f24704a, i2, obj, 0, i);
            return obj;
        }
        while (i3 < c) {
            System.arraycopy(this.f24704a, i2, obj, i3 * b, b);
            i2 += this.f24705b;
            i3++;
        }
        return obj;
    }

    /* renamed from: a */
    private void m32350a(int i, int i2) {
        byte[] bArr = this.f24704a;
        int i3 = (this.f24708e * this.f24705b) + this.f24707d;
        int i4 = 0;
        while (i4 < i2) {
            int i5 = (i / 2) + i3;
            int i6 = (i3 + i) - 1;
            int i7 = i3;
            while (i7 < i5) {
                byte b = bArr[i7];
                bArr[i7] = bArr[i6];
                bArr[i6] = b;
                i7++;
                i6--;
            }
            i4++;
            i3 += this.f24705b;
        }
    }
}
