package org.spongycastle.crypto.digests;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.util.Memoable;

public class RIPEMD256Digest extends GeneralDigest {
    /* renamed from: a */
    private int f32555a;
    /* renamed from: b */
    private int f32556b;
    /* renamed from: c */
    private int f32557c;
    /* renamed from: d */
    private int f32558d;
    /* renamed from: e */
    private int f32559e;
    /* renamed from: f */
    private int f32560f;
    /* renamed from: g */
    private int f32561g;
    /* renamed from: h */
    private int f32562h;
    /* renamed from: i */
    private int[] f32563i;
    /* renamed from: j */
    private int f32564j;

    /* renamed from: a */
    private int m43209a(int i, int i2) {
        return (i >>> (32 - i2)) | (i << i2);
    }

    /* renamed from: a */
    private int m43210a(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    /* renamed from: b */
    private int m43214b(int i, int i2, int i3) {
        return ((~i) & i3) | (i2 & i);
    }

    /* renamed from: c */
    private int m43216c(int i, int i2, int i3) {
        return (i | (~i2)) ^ i3;
    }

    /* renamed from: d */
    private int m43218d(int i, int i2, int i3) {
        return (i & i3) | (i2 & (~i3));
    }

    /* renamed from: a */
    public String mo5729a() {
        return "RIPEMD256";
    }

    /* renamed from: b */
    public int mo5732b() {
        return 32;
    }

    public RIPEMD256Digest() {
        this.f32563i = new int[16];
        mo5733c();
    }

    public RIPEMD256Digest(RIPEMD256Digest rIPEMD256Digest) {
        super(rIPEMD256Digest);
        this.f32563i = new int[16];
        m43213a(rIPEMD256Digest);
    }

    /* renamed from: a */
    private void m43213a(RIPEMD256Digest rIPEMD256Digest) {
        super.m40566a((GeneralDigest) rIPEMD256Digest);
        this.f32555a = rIPEMD256Digest.f32555a;
        this.f32556b = rIPEMD256Digest.f32556b;
        this.f32557c = rIPEMD256Digest.f32557c;
        this.f32558d = rIPEMD256Digest.f32558d;
        this.f32559e = rIPEMD256Digest.f32559e;
        this.f32560f = rIPEMD256Digest.f32560f;
        this.f32561g = rIPEMD256Digest.f32561g;
        this.f32562h = rIPEMD256Digest.f32562h;
        System.arraycopy(rIPEMD256Digest.f32563i, 0, this.f32563i, 0, rIPEMD256Digest.f32563i.length);
        this.f32564j = rIPEMD256Digest.f32564j;
    }

    /* renamed from: b */
    protected void mo6794b(byte[] bArr, int i) {
        int[] iArr = this.f32563i;
        int i2 = this.f32564j;
        this.f32564j = i2 + 1;
        iArr[i2] = ((bArr[i + 3] & JfifUtil.MARKER_FIRST_BYTE) << 24) | (((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) | ((bArr[i + 1] & JfifUtil.MARKER_FIRST_BYTE) << 8)) | ((bArr[i + 2] & JfifUtil.MARKER_FIRST_BYTE) << 16));
        if (this.f32564j == 16) {
            mo6795g();
        }
    }

    /* renamed from: a */
    protected void mo6793a(long j) {
        if (this.f32564j > 14) {
            mo6795g();
        }
        this.f32563i[14] = (int) (-1 & j);
        this.f32563i[15] = (int) (j >>> 32);
    }

    /* renamed from: a */
    private void m43212a(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2 + 2] = (byte) (i >>> 16);
        bArr[i2 + 3] = (byte) (i >>> 24);
    }

    /* renamed from: a */
    public int mo5728a(byte[] bArr, int i) {
        m40571f();
        m43212a(this.f32555a, bArr, i);
        m43212a(this.f32556b, bArr, i + 4);
        m43212a(this.f32557c, bArr, i + 8);
        m43212a(this.f32558d, bArr, i + 12);
        m43212a(this.f32559e, bArr, i + 16);
        m43212a(this.f32560f, bArr, i + 20);
        m43212a(this.f32561g, bArr, i + 24);
        m43212a(this.f32562h, bArr, i + 28);
        mo5733c();
        return 32;
    }

    /* renamed from: c */
    public void mo5733c() {
        super.mo5733c();
        this.f32555a = 1732584193;
        this.f32556b = -271733879;
        this.f32557c = -1732584194;
        this.f32558d = 271733878;
        this.f32559e = 1985229328;
        this.f32560f = -19088744;
        this.f32561g = -1985229329;
        this.f32562h = 19088743;
        this.f32564j = 0;
        for (int i = 0; i != this.f32563i.length; i++) {
            this.f32563i[i] = 0;
        }
    }

    /* renamed from: a */
    private int m43211a(int i, int i2, int i3, int i4, int i5, int i6) {
        return m43209a((i + m43210a(i2, i3, i4)) + i5, i6);
    }

    /* renamed from: b */
    private int m43215b(int i, int i2, int i3, int i4, int i5, int i6) {
        return m43209a(((i + m43214b(i2, i3, i4)) + i5) + 1518500249, i6);
    }

    /* renamed from: c */
    private int m43217c(int i, int i2, int i3, int i4, int i5, int i6) {
        return m43209a(((i + m43216c(i2, i3, i4)) + i5) + 1859775393, i6);
    }

    /* renamed from: d */
    private int m43219d(int i, int i2, int i3, int i4, int i5, int i6) {
        return m43209a(((i + m43218d(i2, i3, i4)) + i5) - 1894007588, i6);
    }

    /* renamed from: e */
    private int m43220e(int i, int i2, int i3, int i4, int i5, int i6) {
        return m43209a((i + m43210a(i2, i3, i4)) + i5, i6);
    }

    /* renamed from: f */
    private int m43221f(int i, int i2, int i3, int i4, int i5, int i6) {
        return m43209a(((i + m43214b(i2, i3, i4)) + i5) + 1836072691, i6);
    }

    /* renamed from: g */
    private int m43222g(int i, int i2, int i3, int i4, int i5, int i6) {
        return m43209a(((i + m43216c(i2, i3, i4)) + i5) + 1548603684, i6);
    }

    /* renamed from: h */
    private int m43223h(int i, int i2, int i3, int i4, int i5, int i6) {
        return m43209a(((i + m43218d(i2, i3, i4)) + i5) + 1352829926, i6);
    }

    /* renamed from: g */
    protected void mo6795g() {
        int i = this.f32555a;
        int i2 = this.f32556b;
        int i3 = this.f32557c;
        int i4 = this.f32558d;
        int i5 = this.f32559e;
        int i6 = this.f32560f;
        int i7 = this.f32561g;
        int i8 = this.f32562h;
        int a = m43211a(i, i2, i3, i4, this.f32563i[0], 11);
        i4 = m43211a(i4, a, i2, i3, this.f32563i[1], 14);
        i3 = m43211a(i3, i4, a, i2, this.f32563i[2], 15);
        i2 = m43211a(i2, i3, i4, a, this.f32563i[3], 12);
        a = m43211a(a, i2, i3, i4, this.f32563i[4], 5);
        i4 = m43211a(i4, a, i2, i3, this.f32563i[5], 8);
        i3 = m43211a(i3, i4, a, i2, this.f32563i[6], 7);
        i2 = m43211a(i2, i3, i4, a, this.f32563i[7], 9);
        a = m43211a(a, i2, i3, i4, this.f32563i[8], 11);
        i4 = m43211a(i4, a, i2, i3, this.f32563i[9], 13);
        i3 = m43211a(i3, i4, a, i2, this.f32563i[10], 14);
        i2 = m43211a(i2, i3, i4, a, this.f32563i[11], 15);
        a = m43211a(a, i2, i3, i4, this.f32563i[12], 6);
        i4 = m43211a(i4, a, i2, i3, this.f32563i[13], 7);
        i3 = m43211a(i3, i4, a, i2, this.f32563i[14], 9);
        i2 = m43211a(i2, i3, i4, a, this.f32563i[15], 8);
        i5 = m43223h(i5, i6, i7, i8, this.f32563i[5], 8);
        i8 = m43223h(i8, i5, i6, i7, this.f32563i[14], 9);
        i7 = m43223h(i7, i8, i5, i6, this.f32563i[7], 9);
        i6 = m43223h(i6, i7, i8, i5, this.f32563i[0], 11);
        i5 = m43223h(i5, i6, i7, i8, this.f32563i[9], 13);
        i8 = m43223h(i8, i5, i6, i7, this.f32563i[2], 15);
        i7 = m43223h(i7, i8, i5, i6, this.f32563i[11], 15);
        i6 = m43223h(i6, i7, i8, i5, this.f32563i[4], 5);
        i5 = m43223h(i5, i6, i7, i8, this.f32563i[13], 7);
        i8 = m43223h(i8, i5, i6, i7, this.f32563i[6], 7);
        i7 = m43223h(i7, i8, i5, i6, this.f32563i[15], 8);
        i6 = m43223h(i6, i7, i8, i5, this.f32563i[8], 11);
        i5 = m43223h(i5, i6, i7, i8, this.f32563i[1], 14);
        i8 = m43223h(i8, i5, i6, i7, this.f32563i[10], 14);
        i7 = m43223h(i7, i8, i5, i6, this.f32563i[3], 12);
        i6 = m43223h(i6, i7, i8, i5, this.f32563i[12], 6);
        i5 = m43215b(i5, i2, i3, i4, this.f32563i[7], 7);
        i4 = m43215b(i4, i5, i2, i3, this.f32563i[4], 6);
        i3 = m43215b(i3, i4, i5, i2, this.f32563i[13], 8);
        i2 = m43215b(i2, i3, i4, i5, this.f32563i[1], 13);
        i5 = m43215b(i5, i2, i3, i4, this.f32563i[10], 11);
        i4 = m43215b(i4, i5, i2, i3, this.f32563i[6], 9);
        i3 = m43215b(i3, i4, i5, i2, this.f32563i[15], 7);
        i2 = m43215b(i2, i3, i4, i5, this.f32563i[3], 15);
        i5 = m43215b(i5, i2, i3, i4, this.f32563i[12], 7);
        i4 = m43215b(i4, i5, i2, i3, this.f32563i[0], 12);
        i3 = m43215b(i3, i4, i5, i2, this.f32563i[9], 15);
        i2 = m43215b(i2, i3, i4, i5, this.f32563i[5], 9);
        i5 = m43215b(i5, i2, i3, i4, this.f32563i[2], 11);
        i4 = m43215b(i4, i5, i2, i3, this.f32563i[14], 7);
        i3 = m43215b(i3, i4, i5, i2, this.f32563i[11], 13);
        i2 = m43215b(i2, i3, i4, i5, this.f32563i[8], 12);
        a = m43222g(a, i6, i7, i8, this.f32563i[6], 9);
        i8 = m43222g(i8, a, i6, i7, this.f32563i[11], 13);
        i7 = m43222g(i7, i8, a, i6, this.f32563i[3], 15);
        i6 = m43222g(i6, i7, i8, a, this.f32563i[7], 7);
        a = m43222g(a, i6, i7, i8, this.f32563i[0], 12);
        i8 = m43222g(i8, a, i6, i7, this.f32563i[13], 8);
        i7 = m43222g(i7, i8, a, i6, this.f32563i[5], 9);
        i6 = m43222g(i6, i7, i8, a, this.f32563i[10], 11);
        a = m43222g(a, i6, i7, i8, this.f32563i[14], 7);
        i8 = m43222g(i8, a, i6, i7, this.f32563i[15], 7);
        i7 = m43222g(i7, i8, a, i6, this.f32563i[8], 12);
        i6 = m43222g(i6, i7, i8, a, this.f32563i[12], 7);
        a = m43222g(a, i6, i7, i8, this.f32563i[4], 6);
        i8 = m43222g(i8, a, i6, i7, this.f32563i[9], 15);
        i7 = m43222g(i7, i8, a, i6, this.f32563i[1], 13);
        i6 = m43222g(i6, i7, i8, a, this.f32563i[2], 11);
        i5 = m43217c(i5, i6, i3, i4, this.f32563i[3], 11);
        i4 = m43217c(i4, i5, i6, i3, this.f32563i[10], 13);
        i3 = m43217c(i3, i4, i5, i6, this.f32563i[14], 6);
        i6 = m43217c(i6, i3, i4, i5, this.f32563i[4], 7);
        i5 = m43217c(i5, i6, i3, i4, this.f32563i[9], 14);
        i4 = m43217c(i4, i5, i6, i3, this.f32563i[15], 9);
        i3 = m43217c(i3, i4, i5, i6, this.f32563i[8], 13);
        i6 = m43217c(i6, i3, i4, i5, this.f32563i[1], 15);
        i5 = m43217c(i5, i6, i3, i4, this.f32563i[2], 14);
        i4 = m43217c(i4, i5, i6, i3, this.f32563i[7], 8);
        i3 = m43217c(i3, i4, i5, i6, this.f32563i[0], 13);
        i6 = m43217c(i6, i3, i4, i5, this.f32563i[6], 6);
        i5 = m43217c(i5, i6, i3, i4, this.f32563i[13], 5);
        i4 = m43217c(i4, i5, i6, i3, this.f32563i[11], 12);
        i3 = m43217c(i3, i4, i5, i6, this.f32563i[5], 7);
        i6 = m43217c(i6, i3, i4, i5, this.f32563i[12], 5);
        a = m43221f(a, i2, i7, i8, this.f32563i[15], 9);
        i8 = m43221f(i8, a, i2, i7, this.f32563i[5], 7);
        i7 = m43221f(i7, i8, a, i2, this.f32563i[1], 15);
        i2 = m43221f(i2, i7, i8, a, this.f32563i[3], 11);
        a = m43221f(a, i2, i7, i8, this.f32563i[7], 8);
        i8 = m43221f(i8, a, i2, i7, this.f32563i[14], 6);
        i7 = m43221f(i7, i8, a, i2, this.f32563i[6], 6);
        i2 = m43221f(i2, i7, i8, a, this.f32563i[9], 14);
        a = m43221f(a, i2, i7, i8, this.f32563i[11], 12);
        i8 = m43221f(i8, a, i2, i7, this.f32563i[8], 13);
        i7 = m43221f(i7, i8, a, i2, this.f32563i[12], 5);
        i2 = m43221f(i2, i7, i8, a, this.f32563i[2], 14);
        a = m43221f(a, i2, i7, i8, this.f32563i[10], 13);
        i8 = m43221f(i8, a, i2, i7, this.f32563i[0], 13);
        i7 = m43221f(i7, i8, a, i2, this.f32563i[4], 7);
        i2 = m43221f(i2, i7, i8, a, this.f32563i[13], 5);
        i5 = m43219d(i5, i6, i7, i4, this.f32563i[1], 11);
        i4 = m43219d(i4, i5, i6, i7, this.f32563i[9], 12);
        i7 = m43219d(i7, i4, i5, i6, this.f32563i[11], 14);
        i6 = m43219d(i6, i7, i4, i5, this.f32563i[10], 15);
        i5 = m43219d(i5, i6, i7, i4, this.f32563i[0], 14);
        i4 = m43219d(i4, i5, i6, i7, this.f32563i[8], 15);
        i7 = m43219d(i7, i4, i5, i6, this.f32563i[12], 9);
        i6 = m43219d(i6, i7, i4, i5, this.f32563i[4], 8);
        i5 = m43219d(i5, i6, i7, i4, this.f32563i[13], 9);
        i4 = m43219d(i4, i5, i6, i7, this.f32563i[3], 14);
        i7 = m43219d(i7, i4, i5, i6, this.f32563i[7], 5);
        i6 = m43219d(i6, i7, i4, i5, this.f32563i[15], 6);
        i5 = m43219d(i5, i6, i7, i4, this.f32563i[14], 8);
        i4 = m43219d(i4, i5, i6, i7, this.f32563i[5], 6);
        i7 = m43219d(i7, i4, i5, i6, this.f32563i[6], 5);
        i6 = m43219d(i6, i7, i4, i5, this.f32563i[2], 12);
        a = m43220e(a, i2, i3, i8, this.f32563i[8], 15);
        i8 = m43220e(i8, a, i2, i3, this.f32563i[6], 5);
        i3 = m43220e(i3, i8, a, i2, this.f32563i[4], 8);
        i2 = m43220e(i2, i3, i8, a, this.f32563i[1], 11);
        a = m43220e(a, i2, i3, i8, this.f32563i[3], 14);
        i8 = m43220e(i8, a, i2, i3, this.f32563i[11], 14);
        i3 = m43220e(i3, i8, a, i2, this.f32563i[15], 6);
        i2 = m43220e(i2, i3, i8, a, this.f32563i[0], 14);
        a = m43220e(a, i2, i3, i8, this.f32563i[5], 6);
        i8 = m43220e(i8, a, i2, i3, this.f32563i[12], 9);
        i3 = m43220e(i3, i8, a, i2, this.f32563i[2], 12);
        i2 = m43220e(i2, i3, i8, a, this.f32563i[13], 9);
        a = m43220e(a, i2, i3, i8, this.f32563i[9], 12);
        i8 = m43220e(i8, a, i2, i3, this.f32563i[7], 5);
        i3 = m43220e(i3, i8, a, i2, this.f32563i[10], 15);
        int e = m43220e(i2, i3, i8, a, this.f32563i[14], 8);
        this.f32555a += i5;
        this.f32556b += i6;
        this.f32557c += i7;
        this.f32558d += i8;
        this.f32559e += a;
        this.f32560f += e;
        this.f32561g += i3;
        this.f32562h += i4;
        this.f32564j = 0;
        for (e = 0; e != r7.f32563i.length; e++) {
            r7.f32563i[e] = 0;
        }
    }

    /* renamed from: e */
    public Memoable mo5735e() {
        return new RIPEMD256Digest(this);
    }

    /* renamed from: a */
    public void mo5734a(Memoable memoable) {
        m43213a((RIPEMD256Digest) memoable);
    }
}
