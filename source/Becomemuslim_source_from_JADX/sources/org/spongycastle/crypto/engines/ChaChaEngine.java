package org.spongycastle.crypto.engines;

import org.spongycastle.util.Pack;

public class ChaChaEngine extends Salsa20Engine {
    public ChaChaEngine(int i) {
        super(i);
    }

    /* renamed from: a */
    public String mo5749a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ChaCha");
        stringBuilder.append(this.c);
        return stringBuilder.toString();
    }

    /* renamed from: c */
    protected void mo6799c(long j) {
        int i = (int) (j >>> 32);
        j = (int) j;
        if (i > 0) {
            int[] iArr = this.d;
            iArr[13] = iArr[13] + i;
        }
        i = this.d[12];
        int[] iArr2 = this.d;
        iArr2[12] = iArr2[12] + j;
        if (i != 0 && this.d[12] < i) {
            j = this.d;
            j[13] = j[13] + 1;
        }
    }

    /* renamed from: b */
    protected void mo6798b() {
        int[] iArr = this.d;
        int i = iArr[12] + 1;
        iArr[12] = i;
        if (i == 0) {
            iArr = this.d;
            iArr[13] = iArr[13] + 1;
        }
    }

    /* renamed from: d */
    protected void mo6800d(long j) {
        int i = (int) (j >>> 32);
        j = (int) j;
        if (i != 0) {
            if ((((long) this.d[13]) & 4294967295L) >= (((long) i) & 4294967295L)) {
                int[] iArr = this.d;
                iArr[13] = iArr[13] - i;
            } else {
                throw new IllegalStateException("attempt to reduce counter past zero.");
            }
        }
        int[] iArr2;
        if ((((long) this.d[12]) & 4294967295L) >= (((long) j) & 4294967295L)) {
            iArr2 = this.d;
            iArr2[12] = iArr2[12] - j;
        } else if (this.d[13] != 0) {
            int[] iArr3 = this.d;
            iArr3[13] = iArr3[13] - 1;
            iArr2 = this.d;
            iArr2[12] = iArr2[12] - j;
        } else {
            throw new IllegalStateException("attempt to reduce counter past zero.");
        }
    }

    /* renamed from: e */
    protected void mo6801e() {
        if (this.d[12] == 0) {
            if (this.d[13] == 0) {
                throw new IllegalStateException("attempt to reduce counter past zero.");
            }
        }
        int[] iArr = this.d;
        int i = iArr[12] - 1;
        iArr[12] = i;
        if (i == -1) {
            iArr = this.d;
            iArr[13] = iArr[13] - 1;
        }
    }

    /* renamed from: f */
    protected long mo6802f() {
        return (((long) this.d[13]) << 32) | (((long) this.d[12]) & 4294967295L);
    }

    /* renamed from: g */
    protected void mo6803g() {
        int[] iArr = this.d;
        this.d[13] = 0;
        iArr[12] = 0;
    }

    /* renamed from: a */
    protected void mo6797a(byte[] bArr, byte[] bArr2) {
        if (bArr != null) {
            byte[] bArr3;
            int i = 16;
            if (bArr.length != 16) {
                if (bArr.length != 32) {
                    bArr2 = new StringBuilder();
                    bArr2.append(mo5749a());
                    bArr2.append(" requires 128 bit or 256 bit key");
                    throw new IllegalArgumentException(bArr2.toString());
                }
            }
            this.d[4] = Pack.m29411c(bArr, 0);
            this.d[5] = Pack.m29411c(bArr, 4);
            this.d[6] = Pack.m29411c(bArr, 8);
            this.d[7] = Pack.m29411c(bArr, 12);
            if (bArr.length == 32) {
                bArr3 = a;
            } else {
                bArr3 = b;
                i = 0;
            }
            this.d[8] = Pack.m29411c(bArr, i);
            this.d[9] = Pack.m29411c(bArr, i + 4);
            this.d[10] = Pack.m29411c(bArr, i + 8);
            this.d[11] = Pack.m29411c(bArr, i + 12);
            this.d[0] = Pack.m29411c(bArr3, 0);
            this.d[1] = Pack.m29411c(bArr3, 4);
            this.d[2] = Pack.m29411c(bArr3, 8);
            this.d[3] = Pack.m29411c(bArr3, 12);
        }
        this.d[14] = Pack.m29411c(bArr2, 0);
        this.d[15] = Pack.m29411c(bArr2, 4);
    }

    /* renamed from: a */
    protected void mo6796a(byte[] bArr) {
        m43339a(this.c, this.d, this.e);
        Pack.m29410b(this.e, bArr, 0);
    }

    /* renamed from: a */
    public static void m43339a(int i, int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        int i2 = 16;
        if (iArr3.length != 16) {
            throw new IllegalArgumentException();
        } else if (iArr4.length != 16) {
            throw new IllegalArgumentException();
        } else if (i % 2 == 0) {
            int i3 = iArr3[0];
            int i4 = iArr3[1];
            int i5 = iArr3[2];
            int i6 = iArr3[3];
            int i7 = iArr3[4];
            int i8 = iArr3[5];
            int i9 = iArr3[6];
            int i10 = 7;
            int i11 = iArr3[7];
            int i12 = 8;
            int i13 = iArr3[8];
            int i14 = iArr3[9];
            int i15 = iArr3[10];
            int i16 = iArr3[11];
            int i17 = 12;
            int i18 = iArr3[12];
            int i19 = iArr3[13];
            int i20 = iArr3[14];
            int i21 = iArr3[15];
            int i22 = i;
            while (i22 > 0) {
                i3 += i7;
                int a = Salsa20Engine.m40704a(i18 ^ i3, i2);
                i13 += a;
                i7 = Salsa20Engine.m40704a(i7 ^ i13, i17);
                i3 += i7;
                a = Salsa20Engine.m40704a(a ^ i3, i12);
                i13 += a;
                i7 = Salsa20Engine.m40704a(i7 ^ i13, i10);
                i4 += i8;
                int a2 = Salsa20Engine.m40704a(i19 ^ i4, i2);
                i14 += a2;
                i8 = Salsa20Engine.m40704a(i8 ^ i14, i17);
                i4 += i8;
                a2 = Salsa20Engine.m40704a(a2 ^ i4, i12);
                i14 += a2;
                i8 = Salsa20Engine.m40704a(i8 ^ i14, i10);
                i5 += i9;
                int a3 = Salsa20Engine.m40704a(i20 ^ i5, i2);
                i15 += a3;
                i2 = Salsa20Engine.m40704a(i9 ^ i15, i17);
                i5 += i2;
                a3 = Salsa20Engine.m40704a(a3 ^ i5, i12);
                i15 += a3;
                i2 = Salsa20Engine.m40704a(i2 ^ i15, i10);
                i6 += i11;
                i10 = Salsa20Engine.m40704a(i21 ^ i6, 16);
                i16 += i10;
                i12 = Salsa20Engine.m40704a(i11 ^ i16, i17);
                i6 += i12;
                i10 = Salsa20Engine.m40704a(i10 ^ i6, 8);
                i16 += i10;
                i17 = Salsa20Engine.m40704a(i12 ^ i16, 7);
                i3 += i8;
                i12 = Salsa20Engine.m40704a(i10 ^ i3, 16);
                i15 += i12;
                i10 = Salsa20Engine.m40704a(i8 ^ i15, 12);
                i3 += i10;
                i21 = Salsa20Engine.m40704a(i12 ^ i3, 8);
                i15 += i21;
                i8 = Salsa20Engine.m40704a(i10 ^ i15, 7);
                i4 += i2;
                a = Salsa20Engine.m40704a(a ^ i4, 16);
                i16 += a;
                i2 = Salsa20Engine.m40704a(i2 ^ i16, 12);
                i4 += i2;
                i18 = Salsa20Engine.m40704a(a ^ i4, 8);
                i16 += i18;
                i9 = Salsa20Engine.m40704a(i2 ^ i16, 7);
                i5 += i17;
                i2 = Salsa20Engine.m40704a(a2 ^ i5, 16);
                i13 += i2;
                a2 = Salsa20Engine.m40704a(i17 ^ i13, 12);
                i5 += a2;
                i19 = Salsa20Engine.m40704a(i2 ^ i5, 8);
                i13 += i19;
                i11 = Salsa20Engine.m40704a(a2 ^ i13, 7);
                i6 += i7;
                i2 = Salsa20Engine.m40704a(a3 ^ i6, 16);
                i14 += i2;
                a2 = Salsa20Engine.m40704a(i7 ^ i14, 12);
                i6 += a2;
                i20 = Salsa20Engine.m40704a(i2 ^ i6, 8);
                i14 += i20;
                i7 = Salsa20Engine.m40704a(a2 ^ i14, 7);
                i22 -= 2;
                i2 = 16;
                i17 = 12;
                i12 = 8;
                i10 = 7;
            }
            iArr4[0] = i3 + iArr3[0];
            iArr4[1] = i4 + iArr3[1];
            iArr4[2] = i5 + iArr3[2];
            iArr4[3] = i6 + iArr3[3];
            iArr4[4] = i7 + iArr3[4];
            iArr4[5] = i8 + iArr3[5];
            iArr4[6] = i9 + iArr3[6];
            iArr4[7] = i11 + iArr3[7];
            iArr4[8] = i13 + iArr3[8];
            iArr4[9] = i14 + iArr3[9];
            iArr4[10] = i15 + iArr3[10];
            iArr4[11] = i16 + iArr3[11];
            iArr4[12] = i18 + iArr3[12];
            iArr4[13] = i19 + iArr3[13];
            iArr4[14] = i20 + iArr3[14];
            iArr4[15] = i21 + iArr3[15];
        } else {
            throw new IllegalArgumentException("Number of rounds must be even");
        }
    }
}
