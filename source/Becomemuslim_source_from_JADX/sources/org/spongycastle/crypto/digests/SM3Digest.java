package org.spongycastle.crypto.digests;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.util.Memoable;
import org.spongycastle.util.Pack;

public class SM3Digest extends GeneralDigest {
    /* renamed from: f */
    private static final int[] f32615f = new int[64];
    /* renamed from: a */
    private int[] f32616a;
    /* renamed from: b */
    private int[] f32617b;
    /* renamed from: c */
    private int f32618c;
    /* renamed from: d */
    private int[] f32619d;
    /* renamed from: e */
    private int[] f32620e;

    /* renamed from: a */
    private int m43323a(int i) {
        return (i ^ ((i << 9) | (i >>> 23))) ^ ((i << 17) | (i >>> 15));
    }

    /* renamed from: a */
    private int m43324a(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    /* renamed from: b */
    private int m43326b(int i) {
        return (i ^ ((i << 15) | (i >>> 17))) ^ ((i << 23) | (i >>> 9));
    }

    /* renamed from: b */
    private int m43327b(int i, int i2, int i3) {
        return ((i & i3) | (i & i2)) | (i2 & i3);
    }

    /* renamed from: c */
    private int m43328c(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    /* renamed from: d */
    private int m43329d(int i, int i2, int i3) {
        return ((~i) & i3) | (i2 & i);
    }

    /* renamed from: a */
    public String mo5729a() {
        return "SM3";
    }

    /* renamed from: b */
    public int mo5732b() {
        return 32;
    }

    static {
        int i = 0;
        while (true) {
            int i2 = 16;
            if (i >= 16) {
                break;
            }
            f32615f[i] = (2043430169 >>> (32 - i)) | (2043430169 << i);
            i++;
        }
        while (i2 < 64) {
            i = i2 % 32;
            f32615f[i2] = (2055708042 >>> (32 - i)) | (2055708042 << i);
            i2++;
        }
    }

    public SM3Digest() {
        this.f32616a = new int[8];
        this.f32617b = new int[16];
        this.f32619d = new int[68];
        this.f32620e = new int[64];
        mo5733c();
    }

    public SM3Digest(SM3Digest sM3Digest) {
        super(sM3Digest);
        this.f32616a = new int[8];
        this.f32617b = new int[16];
        this.f32619d = new int[68];
        this.f32620e = new int[64];
        m43325a(sM3Digest);
    }

    /* renamed from: a */
    private void m43325a(SM3Digest sM3Digest) {
        System.arraycopy(sM3Digest.f32616a, 0, this.f32616a, 0, this.f32616a.length);
        System.arraycopy(sM3Digest.f32617b, 0, this.f32617b, 0, this.f32617b.length);
        this.f32618c = sM3Digest.f32618c;
    }

    /* renamed from: e */
    public Memoable mo5735e() {
        return new SM3Digest(this);
    }

    /* renamed from: a */
    public void mo5734a(Memoable memoable) {
        SM3Digest sM3Digest = (SM3Digest) memoable;
        super.m40566a((GeneralDigest) sM3Digest);
        m43325a(sM3Digest);
    }

    /* renamed from: c */
    public void mo5733c() {
        super.mo5733c();
        this.f32616a[0] = 1937774191;
        this.f32616a[1] = 1226093241;
        this.f32616a[2] = 388252375;
        this.f32616a[3] = -628488704;
        this.f32616a[4] = -1452330820;
        this.f32616a[5] = 372324522;
        this.f32616a[6] = -477237683;
        this.f32616a[7] = -1325724082;
        this.f32618c = 0;
    }

    /* renamed from: a */
    public int mo5728a(byte[] bArr, int i) {
        m40571f();
        Pack.m29400a(this.f32616a[0], bArr, i + 0);
        Pack.m29400a(this.f32616a[1], bArr, i + 4);
        Pack.m29400a(this.f32616a[2], bArr, i + 8);
        Pack.m29400a(this.f32616a[3], bArr, i + 12);
        Pack.m29400a(this.f32616a[4], bArr, i + 16);
        Pack.m29400a(this.f32616a[5], bArr, i + 20);
        Pack.m29400a(this.f32616a[6], bArr, i + 24);
        Pack.m29400a(this.f32616a[7], bArr, i + 28);
        mo5733c();
        return 32;
    }

    /* renamed from: b */
    protected void mo6794b(byte[] bArr, int i) {
        i++;
        i++;
        this.f32617b[this.f32618c] = (bArr[i + 1] & JfifUtil.MARKER_FIRST_BYTE) | ((((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) << 24) | ((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) << 16)) | ((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) << 8));
        this.f32618c++;
        if (this.f32618c >= 16) {
            mo6795g();
        }
    }

    /* renamed from: a */
    protected void mo6793a(long j) {
        if (this.f32618c > 14) {
            this.f32617b[this.f32618c] = 0;
            this.f32618c++;
            mo6795g();
        }
        while (this.f32618c < 14) {
            this.f32617b[this.f32618c] = 0;
            this.f32618c++;
        }
        int[] iArr = this.f32617b;
        int i = this.f32618c;
        this.f32618c = i + 1;
        iArr[i] = (int) (j >>> 32);
        iArr = this.f32617b;
        i = this.f32618c;
        this.f32618c = i + 1;
        iArr[i] = (int) j;
    }

    /* renamed from: g */
    protected void mo6795g() {
        int i;
        int i2;
        SM3Digest sM3Digest = this;
        int i3 = 0;
        while (true) {
            i = 16;
            if (i3 >= 16) {
                break;
            }
            sM3Digest.f32619d[i3] = sM3Digest.f32617b[i3];
            i3++;
        }
        for (i3 = 16; i3 < 68; i3++) {
            int i4 = sM3Digest.f32619d[i3 - 3];
            i4 = (i4 >>> 17) | (i4 << 15);
            i2 = sM3Digest.f32619d[i3 - 13];
            sM3Digest.f32619d[i3] = (m43326b(i4 ^ (sM3Digest.f32619d[i3 - 16] ^ sM3Digest.f32619d[i3 - 9])) ^ ((i2 >>> 25) | (i2 << 7))) ^ sM3Digest.f32619d[i3 - 6];
        }
        i3 = 0;
        while (true) {
            i4 = 64;
            if (i3 >= 64) {
                break;
            }
            sM3Digest.f32620e[i3] = sM3Digest.f32619d[i3] ^ sM3Digest.f32619d[i3 + 4];
            i3++;
        }
        i3 = sM3Digest.f32616a[0];
        i2 = sM3Digest.f32616a[1];
        int i5 = sM3Digest.f32616a[2];
        int i6 = sM3Digest.f32616a[3];
        int i7 = sM3Digest.f32616a[4];
        int i8 = sM3Digest.f32616a[5];
        int i9 = sM3Digest.f32616a[6];
        int i10 = sM3Digest.f32616a[7];
        int i11 = i8;
        i8 = i7;
        i7 = i6;
        i6 = i5;
        i5 = i2;
        i2 = i3;
        i3 = 0;
        while (i3 < i) {
            int i12 = (i2 << 12) | (i2 >>> 20);
            int i13 = (i12 + i8) + f32615f[i3];
            i13 = (i13 << 7) | (i13 >>> 25);
            i7 = ((m43324a(i2, i5, i6) + i7) + (i13 ^ i12)) + sM3Digest.f32620e[i3];
            i5 = (i5 << 9) | (i5 >>> 23);
            i3++;
            i10 = i9;
            i9 = (i11 << 19) | (i11 >>> 13);
            i11 = i8;
            i8 = m43323a(((m43328c(i8, i11, i9) + i10) + i13) + sM3Digest.f32619d[i3]);
            i = 16;
            int i14 = i5;
            i5 = i2;
            i2 = i7;
            i7 = i6;
            i6 = i14;
        }
        i = i5;
        i3 = 16;
        i5 = i2;
        i2 = i7;
        i7 = i6;
        i6 = i11;
        i11 = i8;
        while (i3 < i4) {
            i8 = (i5 << 12) | (i5 >>> 20);
            i12 = (i8 + i11) + f32615f[i3];
            i12 = (i12 << 7) | (i12 >>> 25);
            i2 = ((m43327b(i5, i, i7) + i2) + (i12 ^ i8)) + sM3Digest.f32620e[i3];
            i8 = ((m43329d(i11, i6, i9) + i10) + i12) + sM3Digest.f32619d[i3];
            i = (i >>> 23) | (i << 9);
            i3++;
            i10 = i9;
            i9 = (i6 << 19) | (i6 >>> 13);
            i4 = 64;
            i14 = i7;
            i7 = i;
            i = i5;
            i5 = i2;
            i2 = i14;
            int i15 = i11;
            i11 = m43323a(i8);
            i6 = i15;
        }
        int[] iArr = sM3Digest.f32616a;
        iArr[0] = iArr[0] ^ i5;
        iArr = sM3Digest.f32616a;
        iArr[1] = i ^ iArr[1];
        iArr = sM3Digest.f32616a;
        iArr[2] = iArr[2] ^ i7;
        iArr = sM3Digest.f32616a;
        iArr[3] = iArr[3] ^ i2;
        iArr = sM3Digest.f32616a;
        iArr[4] = iArr[4] ^ i11;
        iArr = sM3Digest.f32616a;
        iArr[5] = iArr[5] ^ i6;
        iArr = sM3Digest.f32616a;
        iArr[6] = iArr[6] ^ i9;
        iArr = sM3Digest.f32616a;
        iArr[7] = iArr[7] ^ i10;
        sM3Digest.f32618c = 0;
    }
}
