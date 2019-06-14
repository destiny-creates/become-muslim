package org.spongycastle.crypto.digests;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.util.Memoable;

public class MD4Digest extends GeneralDigest {
    /* renamed from: a */
    private int f32530a;
    /* renamed from: b */
    private int f32531b;
    /* renamed from: c */
    private int f32532c;
    /* renamed from: d */
    private int f32533d;
    /* renamed from: e */
    private int[] f32534e;
    /* renamed from: f */
    private int f32535f;

    /* renamed from: a */
    private int m43137a(int i, int i2) {
        return (i >>> (32 - i2)) | (i << i2);
    }

    /* renamed from: a */
    private int m43138a(int i, int i2, int i3) {
        return ((~i) & i3) | (i2 & i);
    }

    /* renamed from: b */
    private int m43141b(int i, int i2, int i3) {
        return ((i & i3) | (i & i2)) | (i2 & i3);
    }

    /* renamed from: c */
    private int m43142c(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    /* renamed from: a */
    public String mo5729a() {
        return "MD4";
    }

    /* renamed from: b */
    public int mo5732b() {
        return 16;
    }

    public MD4Digest() {
        this.f32534e = new int[16];
        mo5733c();
    }

    public MD4Digest(MD4Digest mD4Digest) {
        super(mD4Digest);
        this.f32534e = new int[16];
        m43140a(mD4Digest);
    }

    /* renamed from: a */
    private void m43140a(MD4Digest mD4Digest) {
        super.m40566a((GeneralDigest) mD4Digest);
        this.f32530a = mD4Digest.f32530a;
        this.f32531b = mD4Digest.f32531b;
        this.f32532c = mD4Digest.f32532c;
        this.f32533d = mD4Digest.f32533d;
        System.arraycopy(mD4Digest.f32534e, 0, this.f32534e, 0, mD4Digest.f32534e.length);
        this.f32535f = mD4Digest.f32535f;
    }

    /* renamed from: b */
    protected void mo6794b(byte[] bArr, int i) {
        int[] iArr = this.f32534e;
        int i2 = this.f32535f;
        this.f32535f = i2 + 1;
        iArr[i2] = ((bArr[i + 3] & JfifUtil.MARKER_FIRST_BYTE) << 24) | (((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) | ((bArr[i + 1] & JfifUtil.MARKER_FIRST_BYTE) << 8)) | ((bArr[i + 2] & JfifUtil.MARKER_FIRST_BYTE) << 16));
        if (this.f32535f == 16) {
            mo6795g();
        }
    }

    /* renamed from: a */
    protected void mo6793a(long j) {
        if (this.f32535f > 14) {
            mo6795g();
        }
        this.f32534e[14] = (int) (-1 & j);
        this.f32534e[15] = (int) (j >>> 32);
    }

    /* renamed from: a */
    private void m43139a(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2 + 2] = (byte) (i >>> 16);
        bArr[i2 + 3] = (byte) (i >>> 24);
    }

    /* renamed from: a */
    public int mo5728a(byte[] bArr, int i) {
        m40571f();
        m43139a(this.f32530a, bArr, i);
        m43139a(this.f32531b, bArr, i + 4);
        m43139a(this.f32532c, bArr, i + 8);
        m43139a(this.f32533d, bArr, i + 12);
        mo5733c();
        return 16;
    }

    /* renamed from: c */
    public void mo5733c() {
        super.mo5733c();
        this.f32530a = 1732584193;
        this.f32531b = -271733879;
        this.f32532c = -1732584194;
        this.f32533d = 271733878;
        this.f32535f = 0;
        for (int i = 0; i != this.f32534e.length; i++) {
            this.f32534e[i] = 0;
        }
    }

    /* renamed from: g */
    protected void mo6795g() {
        int i = this.f32530a;
        int i2 = this.f32531b;
        int i3 = this.f32532c;
        int i4 = this.f32533d;
        i = m43137a((i + m43138a(i2, i3, i4)) + this.f32534e[0], 3);
        i4 = m43137a((i4 + m43138a(i, i2, i3)) + this.f32534e[1], 7);
        i3 = m43137a((i3 + m43138a(i4, i, i2)) + this.f32534e[2], 11);
        i2 = m43137a((i2 + m43138a(i3, i4, i)) + this.f32534e[3], 19);
        i = m43137a((i + m43138a(i2, i3, i4)) + this.f32534e[4], 3);
        i4 = m43137a((i4 + m43138a(i, i2, i3)) + this.f32534e[5], 7);
        i3 = m43137a((i3 + m43138a(i4, i, i2)) + this.f32534e[6], 11);
        i2 = m43137a((i2 + m43138a(i3, i4, i)) + this.f32534e[7], 19);
        i = m43137a((i + m43138a(i2, i3, i4)) + this.f32534e[8], 3);
        i4 = m43137a((i4 + m43138a(i, i2, i3)) + this.f32534e[9], 7);
        i3 = m43137a((i3 + m43138a(i4, i, i2)) + this.f32534e[10], 11);
        i2 = m43137a((i2 + m43138a(i3, i4, i)) + this.f32534e[11], 19);
        i = m43137a((i + m43138a(i2, i3, i4)) + this.f32534e[12], 3);
        i4 = m43137a((i4 + m43138a(i, i2, i3)) + this.f32534e[13], 7);
        i3 = m43137a((i3 + m43138a(i4, i, i2)) + this.f32534e[14], 11);
        i2 = m43137a((i2 + m43138a(i3, i4, i)) + this.f32534e[15], 19);
        i = m43137a(((i + m43141b(i2, i3, i4)) + this.f32534e[0]) + 1518500249, 3);
        i4 = m43137a(((i4 + m43141b(i, i2, i3)) + this.f32534e[4]) + 1518500249, 5);
        i3 = m43137a(((i3 + m43141b(i4, i, i2)) + this.f32534e[8]) + 1518500249, 9);
        i2 = m43137a(((i2 + m43141b(i3, i4, i)) + this.f32534e[12]) + 1518500249, 13);
        i = m43137a(((i + m43141b(i2, i3, i4)) + this.f32534e[1]) + 1518500249, 3);
        i4 = m43137a(((i4 + m43141b(i, i2, i3)) + this.f32534e[5]) + 1518500249, 5);
        i3 = m43137a(((i3 + m43141b(i4, i, i2)) + this.f32534e[9]) + 1518500249, 9);
        i2 = m43137a(((i2 + m43141b(i3, i4, i)) + this.f32534e[13]) + 1518500249, 13);
        i = m43137a(((i + m43141b(i2, i3, i4)) + this.f32534e[2]) + 1518500249, 3);
        i4 = m43137a(((i4 + m43141b(i, i2, i3)) + this.f32534e[6]) + 1518500249, 5);
        i3 = m43137a(((i3 + m43141b(i4, i, i2)) + this.f32534e[10]) + 1518500249, 9);
        i2 = m43137a(((i2 + m43141b(i3, i4, i)) + this.f32534e[14]) + 1518500249, 13);
        i = m43137a(((i + m43141b(i2, i3, i4)) + this.f32534e[3]) + 1518500249, 3);
        i4 = m43137a(((i4 + m43141b(i, i2, i3)) + this.f32534e[7]) + 1518500249, 5);
        i3 = m43137a(((i3 + m43141b(i4, i, i2)) + this.f32534e[11]) + 1518500249, 9);
        i2 = m43137a(((i2 + m43141b(i3, i4, i)) + this.f32534e[15]) + 1518500249, 13);
        i = m43137a(((i + m43142c(i2, i3, i4)) + this.f32534e[0]) + 1859775393, 3);
        i4 = m43137a(((i4 + m43142c(i, i2, i3)) + this.f32534e[8]) + 1859775393, 9);
        i3 = m43137a(((i3 + m43142c(i4, i, i2)) + this.f32534e[4]) + 1859775393, 11);
        i2 = m43137a(((i2 + m43142c(i3, i4, i)) + this.f32534e[12]) + 1859775393, 15);
        i = m43137a(((i + m43142c(i2, i3, i4)) + this.f32534e[2]) + 1859775393, 3);
        i4 = m43137a(((i4 + m43142c(i, i2, i3)) + this.f32534e[10]) + 1859775393, 9);
        i3 = m43137a(((i3 + m43142c(i4, i, i2)) + this.f32534e[6]) + 1859775393, 11);
        i2 = m43137a(((i2 + m43142c(i3, i4, i)) + this.f32534e[14]) + 1859775393, 15);
        i = m43137a(((i + m43142c(i2, i3, i4)) + this.f32534e[1]) + 1859775393, 3);
        i4 = m43137a(((i4 + m43142c(i, i2, i3)) + this.f32534e[9]) + 1859775393, 9);
        i3 = m43137a(((i3 + m43142c(i4, i, i2)) + this.f32534e[5]) + 1859775393, 11);
        i2 = m43137a(((i2 + m43142c(i3, i4, i)) + this.f32534e[13]) + 1859775393, 15);
        i = m43137a(((i + m43142c(i2, i3, i4)) + this.f32534e[3]) + 1859775393, 3);
        i4 = m43137a(((i4 + m43142c(i, i2, i3)) + this.f32534e[11]) + 1859775393, 9);
        i3 = m43137a(((i3 + m43142c(i4, i, i2)) + this.f32534e[7]) + 1859775393, 11);
        i2 = m43137a(((i2 + m43142c(i3, i4, i)) + this.f32534e[15]) + 1859775393, 15);
        this.f32530a += i;
        this.f32531b += i2;
        this.f32532c += i3;
        this.f32533d += i4;
        this.f32535f = 0;
        for (i = 0; i != r0.f32534e.length; i++) {
            r0.f32534e[i] = 0;
        }
    }

    /* renamed from: e */
    public Memoable mo5735e() {
        return new MD4Digest(this);
    }

    /* renamed from: a */
    public void mo5734a(Memoable memoable) {
        m43140a((MD4Digest) memoable);
    }
}
