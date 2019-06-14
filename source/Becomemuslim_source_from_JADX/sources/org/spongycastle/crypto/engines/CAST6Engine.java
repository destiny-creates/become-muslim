package org.spongycastle.crypto.engines;

import com.facebook.imageutils.JfifUtil;

public final class CAST6Engine extends CAST5Engine {
    /* renamed from: k */
    protected int[] f31655k = new int[48];
    /* renamed from: l */
    protected int[] f31656l = new int[48];
    /* renamed from: m */
    protected int[] f31657m = new int[JfifUtil.MARKER_SOFn];
    /* renamed from: n */
    protected int[] f31658n = new int[JfifUtil.MARKER_SOFn];
    /* renamed from: o */
    private int[] f31659o = new int[8];

    /* renamed from: a */
    public String mo5741a() {
        return "CAST6";
    }

    /* renamed from: b */
    public int mo5743b() {
        return 16;
    }

    /* renamed from: c */
    public void mo5744c() {
    }

    /* renamed from: a */
    protected void mo6446a(byte[] bArr) {
        int i;
        CAST6Engine cAST6Engine = this;
        Object obj = bArr;
        int i2 = 0;
        int i3 = 1518500249;
        int i4 = 19;
        while (i2 < 24) {
            int i5 = i4;
            i4 = i3;
            for (i3 = 0; i3 < 8; i3++) {
                int i6 = (i2 * 8) + i3;
                cAST6Engine.f31658n[i6] = i4;
                i4 += 1859775393;
                cAST6Engine.f31657m[i6] = i5;
                i5 = (i5 + 17) & 31;
            }
            i2++;
            i3 = i4;
            i4 = i5;
        }
        Object obj2 = new byte[64];
        System.arraycopy(obj, 0, obj2, 0, obj.length);
        for (i = 0; i < 8; i++) {
            cAST6Engine.f31659o[i] = m34865a((byte[]) obj2, i * 4);
        }
        for (i = 0; i < 12; i++) {
            i2 = i * 2;
            i3 = i2 * 8;
            int[] iArr = cAST6Engine.f31659o;
            iArr[6] = iArr[6] ^ m34864a(cAST6Engine.f31659o[7], cAST6Engine.f31658n[i3], cAST6Engine.f31657m[i3]);
            iArr = cAST6Engine.f31659o;
            int i7 = i3 + 1;
            iArr[5] = iArr[5] ^ m34875b(cAST6Engine.f31659o[6], cAST6Engine.f31658n[i7], cAST6Engine.f31657m[i7]);
            iArr = cAST6Engine.f31659o;
            int i8 = i3 + 2;
            iArr[4] = iArr[4] ^ m34878c(cAST6Engine.f31659o[5], cAST6Engine.f31658n[i8], cAST6Engine.f31657m[i8]);
            iArr = cAST6Engine.f31659o;
            int i9 = i3 + 3;
            iArr[3] = m34864a(cAST6Engine.f31659o[4], cAST6Engine.f31658n[i9], cAST6Engine.f31657m[i9]) ^ iArr[3];
            iArr = cAST6Engine.f31659o;
            i9 = i3 + 4;
            iArr[2] = m34875b(cAST6Engine.f31659o[3], cAST6Engine.f31658n[i9], cAST6Engine.f31657m[i9]) ^ iArr[2];
            iArr = cAST6Engine.f31659o;
            i9 = i3 + 5;
            iArr[1] = m34878c(cAST6Engine.f31659o[2], cAST6Engine.f31658n[i9], cAST6Engine.f31657m[i9]) ^ iArr[1];
            iArr = cAST6Engine.f31659o;
            i8 = i3 + 6;
            iArr[0] = iArr[0] ^ m34864a(cAST6Engine.f31659o[1], cAST6Engine.f31658n[i8], cAST6Engine.f31657m[i8]);
            iArr = cAST6Engine.f31659o;
            i3 += 7;
            iArr[7] = m34875b(cAST6Engine.f31659o[0], cAST6Engine.f31658n[i3], cAST6Engine.f31657m[i3]) ^ iArr[7];
            i2 = (i2 + 1) * 8;
            int[] iArr2 = cAST6Engine.f31659o;
            iArr2[6] = iArr2[6] ^ m34864a(cAST6Engine.f31659o[7], cAST6Engine.f31658n[i2], cAST6Engine.f31657m[i2]);
            iArr2 = cAST6Engine.f31659o;
            i7 = i2 + 1;
            iArr2[5] = iArr2[5] ^ m34875b(cAST6Engine.f31659o[6], cAST6Engine.f31658n[i7], cAST6Engine.f31657m[i7]);
            iArr2 = cAST6Engine.f31659o;
            i8 = i2 + 2;
            iArr2[4] = iArr2[4] ^ m34878c(cAST6Engine.f31659o[5], cAST6Engine.f31658n[i8], cAST6Engine.f31657m[i8]);
            iArr2 = cAST6Engine.f31659o;
            i8 = i2 + 3;
            iArr2[3] = m34864a(cAST6Engine.f31659o[4], cAST6Engine.f31658n[i8], cAST6Engine.f31657m[i8]) ^ iArr2[3];
            iArr2 = cAST6Engine.f31659o;
            i8 = i2 + 4;
            iArr2[2] = m34875b(cAST6Engine.f31659o[3], cAST6Engine.f31658n[i8], cAST6Engine.f31657m[i8]) ^ iArr2[2];
            iArr2 = cAST6Engine.f31659o;
            i7 = i2 + 5;
            iArr2[1] = m34878c(cAST6Engine.f31659o[2], cAST6Engine.f31658n[i7], cAST6Engine.f31657m[i7]) ^ iArr2[1];
            iArr2 = cAST6Engine.f31659o;
            i7 = i2 + 6;
            iArr2[0] = iArr2[0] ^ m34864a(cAST6Engine.f31659o[1], cAST6Engine.f31658n[i7], cAST6Engine.f31657m[i7]);
            iArr2 = cAST6Engine.f31659o;
            i2 += 7;
            iArr2[7] = m34875b(cAST6Engine.f31659o[0], cAST6Engine.f31658n[i2], cAST6Engine.f31657m[i2]) ^ iArr2[7];
            i3 = i * 4;
            cAST6Engine.f31655k[i3] = cAST6Engine.f31659o[0] & 31;
            i4 = i3 + 1;
            cAST6Engine.f31655k[i4] = cAST6Engine.f31659o[2] & 31;
            i6 = i3 + 2;
            cAST6Engine.f31655k[i6] = cAST6Engine.f31659o[4] & 31;
            int i10 = i3 + 3;
            cAST6Engine.f31655k[i10] = cAST6Engine.f31659o[6] & 31;
            cAST6Engine.f31656l[i3] = cAST6Engine.f31659o[7];
            cAST6Engine.f31656l[i4] = cAST6Engine.f31659o[5];
            cAST6Engine.f31656l[i6] = cAST6Engine.f31659o[3];
            cAST6Engine.f31656l[i10] = cAST6Engine.f31659o[1];
        }
    }

    /* renamed from: b */
    protected int mo6447b(byte[] bArr, int i, byte[] bArr2, int i2) {
        int[] iArr = new int[4];
        m40692a(m34865a(bArr, i), m34865a(bArr, i + 4), m34865a(bArr, i + 8), m34865a(bArr, i + 12), iArr);
        m34870a((int) iArr[null], bArr2, i2);
        m34870a((int) iArr[1], bArr2, i2 + 4);
        m34870a((int) iArr[2], bArr2, i2 + 8);
        m34870a((int) iArr[3], bArr2, i2 + 12);
        return 16;
    }

    /* renamed from: c */
    protected int mo6448c(byte[] bArr, int i, byte[] bArr2, int i2) {
        int[] iArr = new int[4];
        m40696b(m34865a(bArr, i), m34865a(bArr, i + 4), m34865a(bArr, i + 8), m34865a(bArr, i + 12), iArr);
        m34870a((int) iArr[null], bArr2, i2);
        m34870a((int) iArr[1], bArr2, i2 + 4);
        m34870a((int) iArr[2], bArr2, i2 + 8);
        m34870a((int) iArr[3], bArr2, i2 + 12);
        return 16;
    }

    /* renamed from: a */
    protected final void m40692a(int i, int i2, int i3, int i4, int[] iArr) {
        int i5 = i;
        i = 0;
        while (true) {
            int i6 = 6;
            if (i >= 6) {
                break;
            }
            i6 = i * 4;
            i3 ^= m34864a(i4, this.f31656l[i6], this.f31655k[i6]);
            int i7 = i6 + 1;
            i2 ^= m34875b(i3, this.f31656l[i7], this.f31655k[i7]);
            i7 = i6 + 2;
            i5 ^= m34878c(i2, this.f31656l[i7], this.f31655k[i7]);
            i6 += 3;
            i4 ^= m34864a(i5, this.f31656l[i6], this.f31655k[i6]);
            i++;
        }
        while (i6 < 12) {
            i = i6 * 4;
            i7 = i + 3;
            i4 ^= m34864a(i5, this.f31656l[i7], this.f31655k[i7]);
            i7 = i + 2;
            i5 ^= m34878c(i2, this.f31656l[i7], this.f31655k[i7]);
            i7 = i + 1;
            i2 ^= m34875b(i3, this.f31656l[i7], this.f31655k[i7]);
            i3 ^= m34864a(i4, this.f31656l[i], this.f31655k[i]);
            i6++;
        }
        iArr[0] = i5;
        iArr[1] = i2;
        iArr[2] = i3;
        iArr[3] = i4;
    }

    /* renamed from: b */
    protected final void m40696b(int i, int i2, int i3, int i4, int[] iArr) {
        int i5 = i;
        i = 0;
        while (true) {
            int i6 = 6;
            if (i >= 6) {
                break;
            }
            i6 = (11 - i) * 4;
            i3 ^= m34864a(i4, this.f31656l[i6], this.f31655k[i6]);
            int i7 = i6 + 1;
            i2 ^= m34875b(i3, this.f31656l[i7], this.f31655k[i7]);
            i7 = i6 + 2;
            i5 ^= m34878c(i2, this.f31656l[i7], this.f31655k[i7]);
            i6 += 3;
            i4 ^= m34864a(i5, this.f31656l[i6], this.f31655k[i6]);
            i++;
        }
        while (i6 < 12) {
            i = (11 - i6) * 4;
            i7 = i + 3;
            i4 ^= m34864a(i5, this.f31656l[i7], this.f31655k[i7]);
            i7 = i + 2;
            i5 ^= m34878c(i2, this.f31656l[i7], this.f31655k[i7]);
            i7 = i + 1;
            i2 ^= m34875b(i3, this.f31656l[i7], this.f31655k[i7]);
            i3 ^= m34864a(i4, this.f31656l[i], this.f31655k[i]);
            i6++;
        }
        iArr[0] = i5;
        iArr[1] = i2;
        iArr[2] = i3;
        iArr[3] = i4;
    }
}
