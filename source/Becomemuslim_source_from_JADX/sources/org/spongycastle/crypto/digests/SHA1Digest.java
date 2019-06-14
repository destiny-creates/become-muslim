package org.spongycastle.crypto.digests;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.util.Memoable;
import org.spongycastle.util.Pack;

public class SHA1Digest extends GeneralDigest implements EncodableDigest {
    /* renamed from: a */
    private int f32577a;
    /* renamed from: b */
    private int f32578b;
    /* renamed from: c */
    private int f32579c;
    /* renamed from: d */
    private int f32580d;
    /* renamed from: e */
    private int f32581e;
    /* renamed from: f */
    private int[] f32582f;
    /* renamed from: g */
    private int f32583g;

    /* renamed from: a */
    private int m43250a(int i, int i2, int i3) {
        return ((~i) & i3) | (i2 & i);
    }

    /* renamed from: b */
    private int m43252b(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    /* renamed from: c */
    private int m43253c(int i, int i2, int i3) {
        return ((i & i3) | (i & i2)) | (i2 & i3);
    }

    /* renamed from: a */
    public String mo5729a() {
        return "SHA-1";
    }

    /* renamed from: b */
    public int mo5732b() {
        return 20;
    }

    public SHA1Digest() {
        this.f32582f = new int[80];
        mo5733c();
    }

    public SHA1Digest(SHA1Digest sHA1Digest) {
        super(sHA1Digest);
        this.f32582f = new int[80];
        m43251a(sHA1Digest);
    }

    /* renamed from: a */
    private void m43251a(SHA1Digest sHA1Digest) {
        this.f32577a = sHA1Digest.f32577a;
        this.f32578b = sHA1Digest.f32578b;
        this.f32579c = sHA1Digest.f32579c;
        this.f32580d = sHA1Digest.f32580d;
        this.f32581e = sHA1Digest.f32581e;
        System.arraycopy(sHA1Digest.f32582f, 0, this.f32582f, 0, sHA1Digest.f32582f.length);
        this.f32583g = sHA1Digest.f32583g;
    }

    /* renamed from: b */
    protected void mo6794b(byte[] bArr, int i) {
        i++;
        i++;
        this.f32582f[this.f32583g] = (bArr[i + 1] & JfifUtil.MARKER_FIRST_BYTE) | (((bArr[i] << 24) | ((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) << 16)) | ((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) << 8));
        bArr = this.f32583g + 1;
        this.f32583g = bArr;
        if (bArr == 16) {
            mo6795g();
        }
    }

    /* renamed from: a */
    protected void mo6793a(long j) {
        if (this.f32583g > 14) {
            mo6795g();
        }
        this.f32582f[14] = (int) (j >>> 32);
        this.f32582f[15] = (int) (j & -1);
    }

    /* renamed from: a */
    public int mo5728a(byte[] bArr, int i) {
        m40571f();
        Pack.m29400a(this.f32577a, bArr, i);
        Pack.m29400a(this.f32578b, bArr, i + 4);
        Pack.m29400a(this.f32579c, bArr, i + 8);
        Pack.m29400a(this.f32580d, bArr, i + 12);
        Pack.m29400a(this.f32581e, bArr, i + 16);
        mo5733c();
        return 20;
    }

    /* renamed from: c */
    public void mo5733c() {
        super.mo5733c();
        this.f32577a = 1732584193;
        this.f32578b = -271733879;
        this.f32579c = -1732584194;
        this.f32580d = 271733878;
        this.f32581e = -1009589776;
        this.f32583g = 0;
        for (int i = 0; i != this.f32582f.length; i++) {
            this.f32582f[i] = 0;
        }
    }

    /* renamed from: g */
    protected void mo6795g() {
        int i;
        int i2;
        for (i = 16; i < 80; i++) {
            i2 = ((this.f32582f[i - 3] ^ this.f32582f[i - 8]) ^ this.f32582f[i - 14]) ^ this.f32582f[i - 16];
            this.f32582f[i] = (i2 >>> 31) | (i2 << 1);
        }
        i = this.f32577a;
        i2 = this.f32578b;
        int i3 = this.f32579c;
        int i4 = this.f32580d;
        int i5 = this.f32581e;
        int i6 = i4;
        int i7 = 0;
        i4 = i3;
        i3 = i2;
        i2 = i;
        i = 0;
        while (i < 4) {
            int i8 = i7 + 1;
            i5 += ((((i2 << 5) | (i2 >>> 27)) + m43250a(i3, i4, i6)) + this.f32582f[i7]) + 1518500249;
            i3 = (i3 >>> 2) | (i3 << 30);
            int i9 = i8 + 1;
            i6 += ((((i5 << 5) | (i5 >>> 27)) + m43250a(i2, i3, i4)) + this.f32582f[i8]) + 1518500249;
            i2 = (i2 >>> 2) | (i2 << 30);
            i8 = i9 + 1;
            i4 += ((((i6 << 5) | (i6 >>> 27)) + m43250a(i5, i2, i3)) + this.f32582f[i9]) + 1518500249;
            i5 = (i5 >>> 2) | (i5 << 30);
            i9 = i8 + 1;
            i3 += ((((i4 << 5) | (i4 >>> 27)) + m43250a(i6, i5, i2)) + this.f32582f[i8]) + 1518500249;
            i6 = (i6 >>> 2) | (i6 << 30);
            i2 += ((((i3 << 5) | (i3 >>> 27)) + m43250a(i4, i6, i5)) + this.f32582f[i9]) + 1518500249;
            i4 = (i4 >>> 2) | (i4 << 30);
            i++;
            i7 = i9 + 1;
        }
        i = 0;
        while (i < 4) {
            i9 = i7 + 1;
            i5 += ((((i2 << 5) | (i2 >>> 27)) + m43252b(i3, i4, i6)) + this.f32582f[i7]) + 1859775393;
            i3 = (i3 >>> 2) | (i3 << 30);
            int i10 = i9 + 1;
            i6 += ((((i5 << 5) | (i5 >>> 27)) + m43252b(i2, i3, i4)) + this.f32582f[i9]) + 1859775393;
            i2 = (i2 >>> 2) | (i2 << 30);
            i9 = i10 + 1;
            i4 += ((((i6 << 5) | (i6 >>> 27)) + m43252b(i5, i2, i3)) + this.f32582f[i10]) + 1859775393;
            i5 = (i5 >>> 2) | (i5 << 30);
            i10 = i9 + 1;
            i3 += ((((i4 << 5) | (i4 >>> 27)) + m43252b(i6, i5, i2)) + this.f32582f[i9]) + 1859775393;
            i6 = (i6 >>> 2) | (i6 << 30);
            i2 += ((((i3 << 5) | (i3 >>> 27)) + m43252b(i4, i6, i5)) + this.f32582f[i10]) + 1859775393;
            i4 = (i4 >>> 2) | (i4 << 30);
            i++;
            i7 = i10 + 1;
        }
        i = 0;
        while (i < 4) {
            i9 = i7 + 1;
            i5 += ((((i2 << 5) | (i2 >>> 27)) + m43253c(i3, i4, i6)) + this.f32582f[i7]) - 1894007588;
            i3 = (i3 >>> 2) | (i3 << 30);
            i10 = i9 + 1;
            i6 += ((((i5 << 5) | (i5 >>> 27)) + m43253c(i2, i3, i4)) + this.f32582f[i9]) - 1894007588;
            i2 = (i2 >>> 2) | (i2 << 30);
            i9 = i10 + 1;
            i4 += ((((i6 << 5) | (i6 >>> 27)) + m43253c(i5, i2, i3)) + this.f32582f[i10]) - 1894007588;
            i5 = (i5 >>> 2) | (i5 << 30);
            i10 = i9 + 1;
            i3 += ((((i4 << 5) | (i4 >>> 27)) + m43253c(i6, i5, i2)) + this.f32582f[i9]) - 1894007588;
            i6 = (i6 >>> 2) | (i6 << 30);
            i2 += ((((i3 << 5) | (i3 >>> 27)) + m43253c(i4, i6, i5)) + this.f32582f[i10]) - 1894007588;
            i4 = (i4 >>> 2) | (i4 << 30);
            i++;
            i7 = i10 + 1;
        }
        i = 0;
        while (i <= 3) {
            i8 = i7 + 1;
            i5 += ((((i2 << 5) | (i2 >>> 27)) + m43252b(i3, i4, i6)) + this.f32582f[i7]) - 899497514;
            i3 = (i3 >>> 2) | (i3 << 30);
            i9 = i8 + 1;
            i6 += ((((i5 << 5) | (i5 >>> 27)) + m43252b(i2, i3, i4)) + this.f32582f[i8]) - 899497514;
            i2 = (i2 >>> 2) | (i2 << 30);
            i8 = i9 + 1;
            i4 += ((((i6 << 5) | (i6 >>> 27)) + m43252b(i5, i2, i3)) + this.f32582f[i9]) - 899497514;
            i5 = (i5 >>> 2) | (i5 << 30);
            i9 = i8 + 1;
            i3 += ((((i4 << 5) | (i4 >>> 27)) + m43252b(i6, i5, i2)) + this.f32582f[i8]) - 899497514;
            i6 = (i6 >>> 2) | (i6 << 30);
            i2 += ((((i3 << 5) | (i3 >>> 27)) + m43252b(i4, i6, i5)) + this.f32582f[i9]) - 899497514;
            i4 = (i4 >>> 2) | (i4 << 30);
            i++;
            i7 = i9 + 1;
        }
        this.f32577a += i2;
        this.f32578b += i3;
        this.f32579c += i4;
        this.f32580d += i6;
        this.f32581e += i5;
        this.f32583g = 0;
        for (i = 0; i < 16; i++) {
            this.f32582f[i] = 0;
        }
    }

    /* renamed from: e */
    public Memoable mo5735e() {
        return new SHA1Digest(this);
    }

    /* renamed from: a */
    public void mo5734a(Memoable memoable) {
        SHA1Digest sHA1Digest = (SHA1Digest) memoable;
        super.m40566a((GeneralDigest) sHA1Digest);
        m43251a(sHA1Digest);
    }
}
