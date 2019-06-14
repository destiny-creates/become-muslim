package org.spongycastle.crypto.digests;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.util.Memoable;

public class RIPEMD128Digest extends GeneralDigest {
    /* renamed from: a */
    private int f32542a;
    /* renamed from: b */
    private int f32543b;
    /* renamed from: c */
    private int f32544c;
    /* renamed from: d */
    private int f32545d;
    /* renamed from: e */
    private int[] f32546e;
    /* renamed from: f */
    private int f32547f;

    /* renamed from: a */
    private int m43168a(int i, int i2) {
        return (i >>> (32 - i2)) | (i << i2);
    }

    /* renamed from: a */
    private int m43169a(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    /* renamed from: b */
    private int m43173b(int i, int i2, int i3) {
        return ((~i) & i3) | (i2 & i);
    }

    /* renamed from: c */
    private int m43175c(int i, int i2, int i3) {
        return (i | (~i2)) ^ i3;
    }

    /* renamed from: d */
    private int m43177d(int i, int i2, int i3) {
        return (i & i3) | (i2 & (~i3));
    }

    /* renamed from: a */
    public String mo5729a() {
        return "RIPEMD128";
    }

    /* renamed from: b */
    public int mo5732b() {
        return 16;
    }

    public RIPEMD128Digest() {
        this.f32546e = new int[16];
        mo5733c();
    }

    public RIPEMD128Digest(RIPEMD128Digest rIPEMD128Digest) {
        super(rIPEMD128Digest);
        this.f32546e = new int[16];
        m43172a(rIPEMD128Digest);
    }

    /* renamed from: a */
    private void m43172a(RIPEMD128Digest rIPEMD128Digest) {
        super.m40566a((GeneralDigest) rIPEMD128Digest);
        this.f32542a = rIPEMD128Digest.f32542a;
        this.f32543b = rIPEMD128Digest.f32543b;
        this.f32544c = rIPEMD128Digest.f32544c;
        this.f32545d = rIPEMD128Digest.f32545d;
        System.arraycopy(rIPEMD128Digest.f32546e, 0, this.f32546e, 0, rIPEMD128Digest.f32546e.length);
        this.f32547f = rIPEMD128Digest.f32547f;
    }

    /* renamed from: b */
    protected void mo6794b(byte[] bArr, int i) {
        int[] iArr = this.f32546e;
        int i2 = this.f32547f;
        this.f32547f = i2 + 1;
        iArr[i2] = ((bArr[i + 3] & JfifUtil.MARKER_FIRST_BYTE) << 24) | (((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) | ((bArr[i + 1] & JfifUtil.MARKER_FIRST_BYTE) << 8)) | ((bArr[i + 2] & JfifUtil.MARKER_FIRST_BYTE) << 16));
        if (this.f32547f == 16) {
            mo6795g();
        }
    }

    /* renamed from: a */
    protected void mo6793a(long j) {
        if (this.f32547f > 14) {
            mo6795g();
        }
        this.f32546e[14] = (int) (-1 & j);
        this.f32546e[15] = (int) (j >>> 32);
    }

    /* renamed from: a */
    private void m43171a(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2 + 2] = (byte) (i >>> 16);
        bArr[i2 + 3] = (byte) (i >>> 24);
    }

    /* renamed from: a */
    public int mo5728a(byte[] bArr, int i) {
        m40571f();
        m43171a(this.f32542a, bArr, i);
        m43171a(this.f32543b, bArr, i + 4);
        m43171a(this.f32544c, bArr, i + 8);
        m43171a(this.f32545d, bArr, i + 12);
        mo5733c();
        return 16;
    }

    /* renamed from: c */
    public void mo5733c() {
        super.mo5733c();
        this.f32542a = 1732584193;
        this.f32543b = -271733879;
        this.f32544c = -1732584194;
        this.f32545d = 271733878;
        this.f32547f = 0;
        for (int i = 0; i != this.f32546e.length; i++) {
            this.f32546e[i] = 0;
        }
    }

    /* renamed from: a */
    private int m43170a(int i, int i2, int i3, int i4, int i5, int i6) {
        return m43168a((i + m43169a(i2, i3, i4)) + i5, i6);
    }

    /* renamed from: b */
    private int m43174b(int i, int i2, int i3, int i4, int i5, int i6) {
        return m43168a(((i + m43173b(i2, i3, i4)) + i5) + 1518500249, i6);
    }

    /* renamed from: c */
    private int m43176c(int i, int i2, int i3, int i4, int i5, int i6) {
        return m43168a(((i + m43175c(i2, i3, i4)) + i5) + 1859775393, i6);
    }

    /* renamed from: d */
    private int m43178d(int i, int i2, int i3, int i4, int i5, int i6) {
        return m43168a(((i + m43177d(i2, i3, i4)) + i5) - 1894007588, i6);
    }

    /* renamed from: e */
    private int m43179e(int i, int i2, int i3, int i4, int i5, int i6) {
        return m43168a((i + m43169a(i2, i3, i4)) + i5, i6);
    }

    /* renamed from: f */
    private int m43180f(int i, int i2, int i3, int i4, int i5, int i6) {
        return m43168a(((i + m43173b(i2, i3, i4)) + i5) + 1836072691, i6);
    }

    /* renamed from: g */
    private int m43181g(int i, int i2, int i3, int i4, int i5, int i6) {
        return m43168a(((i + m43175c(i2, i3, i4)) + i5) + 1548603684, i6);
    }

    /* renamed from: h */
    private int m43182h(int i, int i2, int i3, int i4, int i5, int i6) {
        return m43168a(((i + m43177d(i2, i3, i4)) + i5) + 1352829926, i6);
    }

    /* renamed from: g */
    protected void mo6795g() {
        int i = this.f32542a;
        int i2 = this.f32543b;
        int i3 = this.f32544c;
        int i4 = this.f32545d;
        int a = m43170a(i, i2, i3, i4, this.f32546e[0], 11);
        int a2 = m43170a(i4, a, i2, i3, this.f32546e[1], 14);
        int a3 = m43170a(i3, a2, a, i2, this.f32546e[2], 15);
        int a4 = m43170a(i2, a3, a2, a, this.f32546e[3], 12);
        a = m43170a(a, a4, a3, a2, this.f32546e[4], 5);
        a2 = m43170a(a2, a, a4, a3, this.f32546e[5], 8);
        a3 = m43170a(a3, a2, a, a4, this.f32546e[6], 7);
        a4 = m43170a(a4, a3, a2, a, this.f32546e[7], 9);
        a = m43170a(a, a4, a3, a2, this.f32546e[8], 11);
        a2 = m43170a(a2, a, a4, a3, this.f32546e[9], 13);
        a3 = m43170a(a3, a2, a, a4, this.f32546e[10], 14);
        a4 = m43170a(a4, a3, a2, a, this.f32546e[11], 15);
        a = m43170a(a, a4, a3, a2, this.f32546e[12], 6);
        a2 = m43170a(a2, a, a4, a3, this.f32546e[13], 7);
        a3 = m43170a(a3, a2, a, a4, this.f32546e[14], 9);
        a4 = m43170a(a4, a3, a2, a, this.f32546e[15], 8);
        a = m43174b(a, a4, a3, a2, this.f32546e[7], 7);
        a2 = m43174b(a2, a, a4, a3, this.f32546e[4], 6);
        a3 = m43174b(a3, a2, a, a4, this.f32546e[13], 8);
        a4 = m43174b(a4, a3, a2, a, this.f32546e[1], 13);
        a = m43174b(a, a4, a3, a2, this.f32546e[10], 11);
        a2 = m43174b(a2, a, a4, a3, this.f32546e[6], 9);
        a3 = m43174b(a3, a2, a, a4, this.f32546e[15], 7);
        a4 = m43174b(a4, a3, a2, a, this.f32546e[3], 15);
        a = m43174b(a, a4, a3, a2, this.f32546e[12], 7);
        a2 = m43174b(a2, a, a4, a3, this.f32546e[0], 12);
        a3 = m43174b(a3, a2, a, a4, this.f32546e[9], 15);
        a4 = m43174b(a4, a3, a2, a, this.f32546e[5], 9);
        a = m43174b(a, a4, a3, a2, this.f32546e[2], 11);
        a2 = m43174b(a2, a, a4, a3, this.f32546e[14], 7);
        a3 = m43174b(a3, a2, a, a4, this.f32546e[11], 13);
        a4 = m43174b(a4, a3, a2, a, this.f32546e[8], 12);
        a = m43176c(a, a4, a3, a2, this.f32546e[3], 11);
        a2 = m43176c(a2, a, a4, a3, this.f32546e[10], 13);
        a3 = m43176c(a3, a2, a, a4, this.f32546e[14], 6);
        a4 = m43176c(a4, a3, a2, a, this.f32546e[4], 7);
        a = m43176c(a, a4, a3, a2, this.f32546e[9], 14);
        a2 = m43176c(a2, a, a4, a3, this.f32546e[15], 9);
        a3 = m43176c(a3, a2, a, a4, this.f32546e[8], 13);
        a4 = m43176c(a4, a3, a2, a, this.f32546e[1], 15);
        a = m43176c(a, a4, a3, a2, this.f32546e[2], 14);
        a2 = m43176c(a2, a, a4, a3, this.f32546e[7], 8);
        a3 = m43176c(a3, a2, a, a4, this.f32546e[0], 13);
        a4 = m43176c(a4, a3, a2, a, this.f32546e[6], 6);
        a = m43176c(a, a4, a3, a2, this.f32546e[13], 5);
        a2 = m43176c(a2, a, a4, a3, this.f32546e[11], 12);
        a3 = m43176c(a3, a2, a, a4, this.f32546e[5], 7);
        a4 = m43176c(a4, a3, a2, a, this.f32546e[12], 5);
        a = m43178d(a, a4, a3, a2, this.f32546e[1], 11);
        a2 = m43178d(a2, a, a4, a3, this.f32546e[9], 12);
        a3 = m43178d(a3, a2, a, a4, this.f32546e[11], 14);
        a4 = m43178d(a4, a3, a2, a, this.f32546e[10], 15);
        a = m43178d(a, a4, a3, a2, this.f32546e[0], 14);
        a2 = m43178d(a2, a, a4, a3, this.f32546e[8], 15);
        a3 = m43178d(a3, a2, a, a4, this.f32546e[12], 9);
        a4 = m43178d(a4, a3, a2, a, this.f32546e[4], 8);
        a = m43178d(a, a4, a3, a2, this.f32546e[13], 9);
        a2 = m43178d(a2, a, a4, a3, this.f32546e[3], 14);
        a3 = m43178d(a3, a2, a, a4, this.f32546e[7], 5);
        a4 = m43178d(a4, a3, a2, a, this.f32546e[15], 6);
        a = m43178d(a, a4, a3, a2, this.f32546e[14], 8);
        a2 = m43178d(a2, a, a4, a3, this.f32546e[5], 6);
        a3 = m43178d(a3, a2, a, a4, this.f32546e[6], 5);
        a4 = m43178d(a4, a3, a2, a, this.f32546e[2], 12);
        i = m43182h(i, i2, i3, i4, this.f32546e[5], 8);
        i4 = m43182h(i4, i, i2, i3, this.f32546e[14], 9);
        i3 = m43182h(i3, i4, i, i2, this.f32546e[7], 9);
        i2 = m43182h(i2, i3, i4, i, this.f32546e[0], 11);
        i = m43182h(i, i2, i3, i4, this.f32546e[9], 13);
        i4 = m43182h(i4, i, i2, i3, this.f32546e[2], 15);
        i3 = m43182h(i3, i4, i, i2, this.f32546e[11], 15);
        i2 = m43182h(i2, i3, i4, i, this.f32546e[4], 5);
        i = m43182h(i, i2, i3, i4, this.f32546e[13], 7);
        i4 = m43182h(i4, i, i2, i3, this.f32546e[6], 7);
        i3 = m43182h(i3, i4, i, i2, this.f32546e[15], 8);
        i2 = m43182h(i2, i3, i4, i, this.f32546e[8], 11);
        i = m43182h(i, i2, i3, i4, this.f32546e[1], 14);
        i4 = m43182h(i4, i, i2, i3, this.f32546e[10], 14);
        i3 = m43182h(i3, i4, i, i2, this.f32546e[3], 12);
        i2 = m43182h(i2, i3, i4, i, this.f32546e[12], 6);
        i = m43181g(i, i2, i3, i4, this.f32546e[6], 9);
        i4 = m43181g(i4, i, i2, i3, this.f32546e[11], 13);
        i3 = m43181g(i3, i4, i, i2, this.f32546e[3], 15);
        i2 = m43181g(i2, i3, i4, i, this.f32546e[7], 7);
        i = m43181g(i, i2, i3, i4, this.f32546e[0], 12);
        i4 = m43181g(i4, i, i2, i3, this.f32546e[13], 8);
        i3 = m43181g(i3, i4, i, i2, this.f32546e[5], 9);
        i2 = m43181g(i2, i3, i4, i, this.f32546e[10], 11);
        i = m43181g(i, i2, i3, i4, this.f32546e[14], 7);
        i4 = m43181g(i4, i, i2, i3, this.f32546e[15], 7);
        i3 = m43181g(i3, i4, i, i2, this.f32546e[8], 12);
        i2 = m43181g(i2, i3, i4, i, this.f32546e[12], 7);
        i = m43181g(i, i2, i3, i4, this.f32546e[4], 6);
        i4 = m43181g(i4, i, i2, i3, this.f32546e[9], 15);
        i3 = m43181g(i3, i4, i, i2, this.f32546e[1], 13);
        i2 = m43181g(i2, i3, i4, i, this.f32546e[2], 11);
        i = m43180f(i, i2, i3, i4, this.f32546e[15], 9);
        i4 = m43180f(i4, i, i2, i3, this.f32546e[5], 7);
        i3 = m43180f(i3, i4, i, i2, this.f32546e[1], 15);
        i2 = m43180f(i2, i3, i4, i, this.f32546e[3], 11);
        i = m43180f(i, i2, i3, i4, this.f32546e[7], 8);
        i4 = m43180f(i4, i, i2, i3, this.f32546e[14], 6);
        i3 = m43180f(i3, i4, i, i2, this.f32546e[6], 6);
        i2 = m43180f(i2, i3, i4, i, this.f32546e[9], 14);
        i = m43180f(i, i2, i3, i4, this.f32546e[11], 12);
        i4 = m43180f(i4, i, i2, i3, this.f32546e[8], 13);
        i3 = m43180f(i3, i4, i, i2, this.f32546e[12], 5);
        i2 = m43180f(i2, i3, i4, i, this.f32546e[2], 14);
        i = m43180f(i, i2, i3, i4, this.f32546e[10], 13);
        i4 = m43180f(i4, i, i2, i3, this.f32546e[0], 13);
        i3 = m43180f(i3, i4, i, i2, this.f32546e[4], 7);
        i2 = m43180f(i2, i3, i4, i, this.f32546e[13], 5);
        i = m43179e(i, i2, i3, i4, this.f32546e[8], 15);
        i4 = m43179e(i4, i, i2, i3, this.f32546e[6], 5);
        i3 = m43179e(i3, i4, i, i2, this.f32546e[4], 8);
        i2 = m43179e(i2, i3, i4, i, this.f32546e[1], 11);
        i = m43179e(i, i2, i3, i4, this.f32546e[3], 14);
        i4 = m43179e(i4, i, i2, i3, this.f32546e[11], 14);
        i3 = m43179e(i3, i4, i, i2, this.f32546e[15], 6);
        i2 = m43179e(i2, i3, i4, i, this.f32546e[0], 14);
        i = m43179e(i, i2, i3, i4, this.f32546e[5], 6);
        i4 = m43179e(i4, i, i2, i3, this.f32546e[12], 9);
        i3 = m43179e(i3, i4, i, i2, this.f32546e[2], 12);
        i2 = m43179e(i2, i3, i4, i, this.f32546e[13], 9);
        i = m43179e(i, i2, i3, i4, this.f32546e[9], 12);
        i4 = m43179e(i4, i, i2, i3, this.f32546e[7], 5);
        i3 = m43179e(i3, i4, i, i2, this.f32546e[10], 15);
        int e = m43179e(i2, i3, i4, i, this.f32546e[14], 8);
        i4 += a3 + this.f32543b;
        this.f32543b = (this.f32544c + a2) + i;
        this.f32544c = (this.f32545d + a) + e;
        this.f32545d = (this.f32542a + a4) + i3;
        this.f32542a = i4;
        this.f32547f = 0;
        for (e = 0; e != r7.f32546e.length; e++) {
            r7.f32546e[e] = 0;
        }
    }

    /* renamed from: e */
    public Memoable mo5735e() {
        return new RIPEMD128Digest(this);
    }

    /* renamed from: a */
    public void mo5734a(Memoable memoable) {
        m43172a((RIPEMD128Digest) memoable);
    }
}
