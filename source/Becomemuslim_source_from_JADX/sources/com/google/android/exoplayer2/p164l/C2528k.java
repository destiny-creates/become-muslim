package com.google.android.exoplayer2.p164l;

import com.facebook.imageutils.JfifUtil;

/* compiled from: ParsableBitArray */
/* renamed from: com.google.android.exoplayer2.l.k */
public final class C2528k {
    /* renamed from: a */
    public byte[] f6437a;
    /* renamed from: b */
    private int f6438b;
    /* renamed from: c */
    private int f6439c;
    /* renamed from: d */
    private int f6440d;

    public C2528k(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public C2528k(byte[] bArr, int i) {
        this.f6437a = bArr;
        this.f6440d = i;
    }

    /* renamed from: a */
    public void m7074a(byte[] bArr) {
        m7075a(bArr, bArr.length);
    }

    /* renamed from: a */
    public void m7075a(byte[] bArr, int i) {
        this.f6437a = bArr;
        this.f6438b = 0;
        this.f6439c = 0;
        this.f6440d = i;
    }

    /* renamed from: a */
    public int m7072a() {
        return ((this.f6440d - this.f6438b) * 8) - this.f6439c;
    }

    /* renamed from: b */
    public int m7077b() {
        return (this.f6438b * 8) + this.f6439c;
    }

    /* renamed from: c */
    public int m7080c() {
        C2516a.m7019b(this.f6439c == 0);
        return this.f6438b;
    }

    /* renamed from: a */
    public void m7073a(int i) {
        this.f6438b = i / 8;
        this.f6439c = i - (this.f6438b * 8);
        m7071g();
    }

    /* renamed from: d */
    public void m7082d() {
        int i = this.f6439c + 1;
        this.f6439c = i;
        if (i == 8) {
            this.f6439c = 0;
            this.f6438b++;
        }
        m7071g();
    }

    /* renamed from: b */
    public void m7078b(int i) {
        int i2 = i / 8;
        this.f6438b += i2;
        this.f6439c += i - (i2 * 8);
        if (this.f6439c > 7) {
            this.f6438b++;
            this.f6439c -= 8;
        }
        m7071g();
    }

    /* renamed from: e */
    public boolean m7084e() {
        boolean z = (this.f6437a[this.f6438b] & (128 >> this.f6439c)) != 0;
        m7082d();
        return z;
    }

    /* renamed from: c */
    public int m7081c(int i) {
        if (i == 0) {
            return 0;
        }
        this.f6439c += i;
        int i2 = 0;
        while (this.f6439c > 8) {
            this.f6439c -= 8;
            byte[] bArr = this.f6437a;
            int i3 = this.f6438b;
            this.f6438b = i3 + 1;
            i2 |= (bArr[i3] & JfifUtil.MARKER_FIRST_BYTE) << this.f6439c;
        }
        i = (-1 >>> (32 - i)) & (i2 | ((this.f6437a[this.f6438b] & JfifUtil.MARKER_FIRST_BYTE) >> (8 - this.f6439c)));
        if (this.f6439c == 8) {
            this.f6439c = 0;
            this.f6438b++;
        }
        m7071g();
        return i;
    }

    /* renamed from: a */
    public void m7076a(byte[] bArr, int i, int i2) {
        int i3 = (i2 >> 3) + i;
        while (i < i3) {
            byte[] bArr2 = this.f6437a;
            int i4 = this.f6438b;
            this.f6438b = i4 + 1;
            bArr[i] = (byte) (bArr2[i4] << this.f6439c);
            bArr[i] = (byte) (((JfifUtil.MARKER_FIRST_BYTE & this.f6437a[this.f6438b]) >> (8 - this.f6439c)) | bArr[i]);
            i++;
        }
        i = i2 & 7;
        if (i != 0) {
            bArr[i3] = (byte) (bArr[i3] & (JfifUtil.MARKER_FIRST_BYTE >> i));
            if (this.f6439c + i > 8) {
                i2 = bArr[i3];
                bArr2 = this.f6437a;
                i4 = this.f6438b;
                this.f6438b = i4 + 1;
                bArr[i3] = (byte) (i2 | ((byte) ((bArr2[i4] & JfifUtil.MARKER_FIRST_BYTE) << this.f6439c)));
                this.f6439c -= 8;
            }
            this.f6439c += i;
            bArr[i3] = (byte) (((byte) (((this.f6437a[this.f6438b] & JfifUtil.MARKER_FIRST_BYTE) >> (8 - this.f6439c)) << (8 - i))) | bArr[i3]);
            if (this.f6439c == 8) {
                this.f6439c = null;
                this.f6438b++;
            }
            m7071g();
        }
    }

    /* renamed from: f */
    public void m7085f() {
        if (this.f6439c != 0) {
            this.f6439c = 0;
            this.f6438b++;
            m7071g();
        }
    }

    /* renamed from: b */
    public void m7079b(byte[] bArr, int i, int i2) {
        C2516a.m7019b(this.f6439c == 0);
        System.arraycopy(this.f6437a, this.f6438b, bArr, i, i2);
        this.f6438b += i2;
        m7071g();
    }

    /* renamed from: d */
    public void m7083d(int i) {
        C2516a.m7019b(this.f6439c == 0);
        this.f6438b += i;
        m7071g();
    }

    /* renamed from: g */
    private void m7071g() {
        boolean z = this.f6438b >= 0 && (this.f6438b < this.f6440d || (this.f6438b == this.f6440d && this.f6439c == 0));
        C2516a.m7019b(z);
    }
}
