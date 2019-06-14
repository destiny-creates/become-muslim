package org.spongycastle.crypto.digests;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.util.Memoable;

public class RIPEMD320Digest extends GeneralDigest {
    /* renamed from: a */
    private int f32565a;
    /* renamed from: b */
    private int f32566b;
    /* renamed from: c */
    private int f32567c;
    /* renamed from: d */
    private int f32568d;
    /* renamed from: e */
    private int f32569e;
    /* renamed from: f */
    private int f32570f;
    /* renamed from: g */
    private int f32571g;
    /* renamed from: h */
    private int f32572h;
    /* renamed from: i */
    private int f32573i;
    /* renamed from: j */
    private int f32574j;
    /* renamed from: k */
    private int[] f32575k;
    /* renamed from: l */
    private int f32576l;

    /* renamed from: a */
    private int m43233a(int i, int i2) {
        return (i >>> (32 - i2)) | (i << i2);
    }

    /* renamed from: a */
    private int m43234a(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    /* renamed from: b */
    private int m43237b(int i, int i2, int i3) {
        return ((~i) & i3) | (i2 & i);
    }

    /* renamed from: c */
    private int m43238c(int i, int i2, int i3) {
        return (i | (~i2)) ^ i3;
    }

    /* renamed from: d */
    private int m43239d(int i, int i2, int i3) {
        return (i & i3) | (i2 & (~i3));
    }

    /* renamed from: e */
    private int m43240e(int i, int i2, int i3) {
        return i ^ (i2 | (~i3));
    }

    /* renamed from: a */
    public String mo5729a() {
        return "RIPEMD320";
    }

    /* renamed from: b */
    public int mo5732b() {
        return 40;
    }

    public RIPEMD320Digest() {
        this.f32575k = new int[16];
        mo5733c();
    }

    public RIPEMD320Digest(RIPEMD320Digest rIPEMD320Digest) {
        super(rIPEMD320Digest);
        this.f32575k = new int[16];
        m43236a(rIPEMD320Digest);
    }

    /* renamed from: a */
    private void m43236a(RIPEMD320Digest rIPEMD320Digest) {
        super.m40566a((GeneralDigest) rIPEMD320Digest);
        this.f32565a = rIPEMD320Digest.f32565a;
        this.f32566b = rIPEMD320Digest.f32566b;
        this.f32567c = rIPEMD320Digest.f32567c;
        this.f32568d = rIPEMD320Digest.f32568d;
        this.f32569e = rIPEMD320Digest.f32569e;
        this.f32570f = rIPEMD320Digest.f32570f;
        this.f32571g = rIPEMD320Digest.f32571g;
        this.f32572h = rIPEMD320Digest.f32572h;
        this.f32573i = rIPEMD320Digest.f32573i;
        this.f32574j = rIPEMD320Digest.f32574j;
        System.arraycopy(rIPEMD320Digest.f32575k, 0, this.f32575k, 0, rIPEMD320Digest.f32575k.length);
        this.f32576l = rIPEMD320Digest.f32576l;
    }

    /* renamed from: b */
    protected void mo6794b(byte[] bArr, int i) {
        int[] iArr = this.f32575k;
        int i2 = this.f32576l;
        this.f32576l = i2 + 1;
        iArr[i2] = ((bArr[i + 3] & JfifUtil.MARKER_FIRST_BYTE) << 24) | (((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) | ((bArr[i + 1] & JfifUtil.MARKER_FIRST_BYTE) << 8)) | ((bArr[i + 2] & JfifUtil.MARKER_FIRST_BYTE) << 16));
        if (this.f32576l == 16) {
            mo6795g();
        }
    }

    /* renamed from: a */
    protected void mo6793a(long j) {
        if (this.f32576l > 14) {
            mo6795g();
        }
        this.f32575k[14] = (int) (-1 & j);
        this.f32575k[15] = (int) (j >>> 32);
    }

    /* renamed from: a */
    private void m43235a(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2 + 2] = (byte) (i >>> 16);
        bArr[i2 + 3] = (byte) (i >>> 24);
    }

    /* renamed from: a */
    public int mo5728a(byte[] bArr, int i) {
        m40571f();
        m43235a(this.f32565a, bArr, i);
        m43235a(this.f32566b, bArr, i + 4);
        m43235a(this.f32567c, bArr, i + 8);
        m43235a(this.f32568d, bArr, i + 12);
        m43235a(this.f32569e, bArr, i + 16);
        m43235a(this.f32570f, bArr, i + 20);
        m43235a(this.f32571g, bArr, i + 24);
        m43235a(this.f32572h, bArr, i + 28);
        m43235a(this.f32573i, bArr, i + 32);
        m43235a(this.f32574j, bArr, i + 36);
        mo5733c();
        return 40;
    }

    /* renamed from: c */
    public void mo5733c() {
        super.mo5733c();
        this.f32565a = 1732584193;
        this.f32566b = -271733879;
        this.f32567c = -1732584194;
        this.f32568d = 271733878;
        this.f32569e = -1009589776;
        this.f32570f = 1985229328;
        this.f32571g = -19088744;
        this.f32572h = -1985229329;
        this.f32573i = 19088743;
        this.f32574j = 1009589775;
        this.f32576l = 0;
        for (int i = 0; i != this.f32575k.length; i++) {
            this.f32575k[i] = 0;
        }
    }

    /* renamed from: g */
    protected void mo6795g() {
        int i = this.f32565a;
        int i2 = this.f32566b;
        int i3 = this.f32567c;
        int i4 = this.f32568d;
        int i5 = this.f32569e;
        int i6 = this.f32570f;
        int i7 = this.f32571g;
        int i8 = this.f32572h;
        int i9 = this.f32573i;
        int i10 = this.f32574j;
        i = m43233a((i + m43234a(i2, i3, i4)) + this.f32575k[0], 11) + i5;
        i3 = m43233a(i3, 10);
        i5 = m43233a((i5 + m43234a(i, i2, i3)) + this.f32575k[1], 14) + i4;
        i2 = m43233a(i2, 10);
        i4 = m43233a((i4 + m43234a(i5, i, i2)) + this.f32575k[2], 15) + i3;
        i = m43233a(i, 10);
        i3 = m43233a((i3 + m43234a(i4, i5, i)) + this.f32575k[3], 12) + i2;
        i5 = m43233a(i5, 10);
        i2 = m43233a((i2 + m43234a(i3, i4, i5)) + this.f32575k[4], 5) + i;
        i4 = m43233a(i4, 10);
        i = m43233a((i + m43234a(i2, i3, i4)) + this.f32575k[5], 8) + i5;
        i3 = m43233a(i3, 10);
        i5 = m43233a((i5 + m43234a(i, i2, i3)) + this.f32575k[6], 7) + i4;
        i2 = m43233a(i2, 10);
        i4 = m43233a((i4 + m43234a(i5, i, i2)) + this.f32575k[7], 9) + i3;
        i = m43233a(i, 10);
        i3 = m43233a((i3 + m43234a(i4, i5, i)) + this.f32575k[8], 11) + i2;
        i5 = m43233a(i5, 10);
        i2 = m43233a((i2 + m43234a(i3, i4, i5)) + this.f32575k[9], 13) + i;
        i4 = m43233a(i4, 10);
        i = m43233a((i + m43234a(i2, i3, i4)) + this.f32575k[10], 14) + i5;
        i3 = m43233a(i3, 10);
        i5 = m43233a((i5 + m43234a(i, i2, i3)) + this.f32575k[11], 15) + i4;
        i2 = m43233a(i2, 10);
        i4 = m43233a((i4 + m43234a(i5, i, i2)) + this.f32575k[12], 6) + i3;
        i = m43233a(i, 10);
        i3 = m43233a((i3 + m43234a(i4, i5, i)) + this.f32575k[13], 7) + i2;
        i5 = m43233a(i5, 10);
        i2 = m43233a((i2 + m43234a(i3, i4, i5)) + this.f32575k[14], 9) + i;
        i4 = m43233a(i4, 10);
        i = m43233a((i + m43234a(i2, i3, i4)) + this.f32575k[15], 8) + i5;
        i3 = m43233a(i3, 10);
        i6 = m43233a(((i6 + m43240e(i7, i8, i9)) + this.f32575k[5]) + 1352829926, 8) + i10;
        i8 = m43233a(i8, 10);
        i10 = m43233a(((i10 + m43240e(i6, i7, i8)) + this.f32575k[14]) + 1352829926, 9) + i9;
        i7 = m43233a(i7, 10);
        i9 = m43233a(((i9 + m43240e(i10, i6, i7)) + this.f32575k[7]) + 1352829926, 9) + i8;
        i6 = m43233a(i6, 10);
        i8 = m43233a(((i8 + m43240e(i9, i10, i6)) + this.f32575k[0]) + 1352829926, 11) + i7;
        i10 = m43233a(i10, 10);
        i7 = m43233a(((i7 + m43240e(i8, i9, i10)) + this.f32575k[9]) + 1352829926, 13) + i6;
        i9 = m43233a(i9, 10);
        i6 = m43233a(((i6 + m43240e(i7, i8, i9)) + this.f32575k[2]) + 1352829926, 15) + i10;
        i8 = m43233a(i8, 10);
        i10 = m43233a(((i10 + m43240e(i6, i7, i8)) + this.f32575k[11]) + 1352829926, 15) + i9;
        i7 = m43233a(i7, 10);
        i9 = m43233a(((i9 + m43240e(i10, i6, i7)) + this.f32575k[4]) + 1352829926, 5) + i8;
        i6 = m43233a(i6, 10);
        i8 = m43233a(((i8 + m43240e(i9, i10, i6)) + this.f32575k[13]) + 1352829926, 7) + i7;
        i10 = m43233a(i10, 10);
        i7 = m43233a(((i7 + m43240e(i8, i9, i10)) + this.f32575k[6]) + 1352829926, 7) + i6;
        i9 = m43233a(i9, 10);
        i6 = m43233a(((i6 + m43240e(i7, i8, i9)) + this.f32575k[15]) + 1352829926, 8) + i10;
        i8 = m43233a(i8, 10);
        i10 = m43233a(((i10 + m43240e(i6, i7, i8)) + this.f32575k[8]) + 1352829926, 11) + i9;
        i7 = m43233a(i7, 10);
        i9 = m43233a(((i9 + m43240e(i10, i6, i7)) + this.f32575k[1]) + 1352829926, 14) + i8;
        i6 = m43233a(i6, 10);
        i8 = m43233a(((i8 + m43240e(i9, i10, i6)) + this.f32575k[10]) + 1352829926, 14) + i7;
        i10 = m43233a(i10, 10);
        i7 = m43233a(((i7 + m43240e(i8, i9, i10)) + this.f32575k[3]) + 1352829926, 12) + i6;
        i9 = m43233a(i9, 10);
        i6 = m43233a(((i6 + m43240e(i7, i8, i9)) + this.f32575k[12]) + 1352829926, 6) + i10;
        i8 = m43233a(i8, 10);
        i5 = m43233a(((i5 + m43237b(i6, i2, i3)) + this.f32575k[7]) + 1518500249, 7) + i4;
        i2 = m43233a(i2, 10);
        i4 = m43233a(((i4 + m43237b(i5, i6, i2)) + this.f32575k[4]) + 1518500249, 6) + i3;
        i6 = m43233a(i6, 10);
        i3 = m43233a(((i3 + m43237b(i4, i5, i6)) + this.f32575k[13]) + 1518500249, 8) + i2;
        i5 = m43233a(i5, 10);
        i2 = m43233a(((i2 + m43237b(i3, i4, i5)) + this.f32575k[1]) + 1518500249, 13) + i6;
        i4 = m43233a(i4, 10);
        i6 = m43233a(((i6 + m43237b(i2, i3, i4)) + this.f32575k[10]) + 1518500249, 11) + i5;
        i3 = m43233a(i3, 10);
        i5 = m43233a(((i5 + m43237b(i6, i2, i3)) + this.f32575k[6]) + 1518500249, 9) + i4;
        i2 = m43233a(i2, 10);
        i4 = m43233a(((i4 + m43237b(i5, i6, i2)) + this.f32575k[15]) + 1518500249, 7) + i3;
        i6 = m43233a(i6, 10);
        i3 = m43233a(((i3 + m43237b(i4, i5, i6)) + this.f32575k[3]) + 1518500249, 15) + i2;
        i5 = m43233a(i5, 10);
        i2 = m43233a(((i2 + m43237b(i3, i4, i5)) + this.f32575k[12]) + 1518500249, 7) + i6;
        i4 = m43233a(i4, 10);
        i6 = m43233a(((i6 + m43237b(i2, i3, i4)) + this.f32575k[0]) + 1518500249, 12) + i5;
        i3 = m43233a(i3, 10);
        i5 = m43233a(((i5 + m43237b(i6, i2, i3)) + this.f32575k[9]) + 1518500249, 15) + i4;
        i2 = m43233a(i2, 10);
        i4 = m43233a(((i4 + m43237b(i5, i6, i2)) + this.f32575k[5]) + 1518500249, 9) + i3;
        i6 = m43233a(i6, 10);
        i3 = m43233a(((i3 + m43237b(i4, i5, i6)) + this.f32575k[2]) + 1518500249, 11) + i2;
        i5 = m43233a(i5, 10);
        i2 = m43233a(((i2 + m43237b(i3, i4, i5)) + this.f32575k[14]) + 1518500249, 7) + i6;
        i4 = m43233a(i4, 10);
        i6 = m43233a(((i6 + m43237b(i2, i3, i4)) + this.f32575k[11]) + 1518500249, 13) + i5;
        i3 = m43233a(i3, 10);
        i5 = m43233a(((i5 + m43237b(i6, i2, i3)) + this.f32575k[8]) + 1518500249, 12) + i4;
        i2 = m43233a(i2, 10);
        i10 = m43233a(((i10 + m43239d(i, i7, i8)) + this.f32575k[6]) + 1548603684, 9) + i9;
        i7 = m43233a(i7, 10);
        i9 = m43233a(((i9 + m43239d(i10, i, i7)) + this.f32575k[11]) + 1548603684, 13) + i8;
        i = m43233a(i, 10);
        i8 = m43233a(((i8 + m43239d(i9, i10, i)) + this.f32575k[3]) + 1548603684, 15) + i7;
        i10 = m43233a(i10, 10);
        i7 = m43233a(((i7 + m43239d(i8, i9, i10)) + this.f32575k[7]) + 1548603684, 7) + i;
        i9 = m43233a(i9, 10);
        i = m43233a(((i + m43239d(i7, i8, i9)) + this.f32575k[0]) + 1548603684, 12) + i10;
        i8 = m43233a(i8, 10);
        i10 = m43233a(((i10 + m43239d(i, i7, i8)) + this.f32575k[13]) + 1548603684, 8) + i9;
        i7 = m43233a(i7, 10);
        i9 = m43233a(((i9 + m43239d(i10, i, i7)) + this.f32575k[5]) + 1548603684, 9) + i8;
        i = m43233a(i, 10);
        i8 = m43233a(((i8 + m43239d(i9, i10, i)) + this.f32575k[10]) + 1548603684, 11) + i7;
        i10 = m43233a(i10, 10);
        i7 = m43233a(((i7 + m43239d(i8, i9, i10)) + this.f32575k[14]) + 1548603684, 7) + i;
        i9 = m43233a(i9, 10);
        i = m43233a(((i + m43239d(i7, i8, i9)) + this.f32575k[15]) + 1548603684, 7) + i10;
        i8 = m43233a(i8, 10);
        i10 = m43233a(((i10 + m43239d(i, i7, i8)) + this.f32575k[8]) + 1548603684, 12) + i9;
        i7 = m43233a(i7, 10);
        i9 = m43233a(((i9 + m43239d(i10, i, i7)) + this.f32575k[12]) + 1548603684, 7) + i8;
        i = m43233a(i, 10);
        i8 = m43233a(((i8 + m43239d(i9, i10, i)) + this.f32575k[4]) + 1548603684, 6) + i7;
        i10 = m43233a(i10, 10);
        i7 = m43233a(((i7 + m43239d(i8, i9, i10)) + this.f32575k[9]) + 1548603684, 15) + i;
        i9 = m43233a(i9, 10);
        i = m43233a(((i + m43239d(i7, i8, i9)) + this.f32575k[1]) + 1548603684, 13) + i10;
        i8 = m43233a(i8, 10);
        i10 = m43233a(((i10 + m43239d(i, i7, i8)) + this.f32575k[2]) + 1548603684, 11) + i9;
        i7 = m43233a(i7, 10);
        i4 = m43233a(((i4 + m43238c(i5, i6, i7)) + this.f32575k[3]) + 1859775393, 11) + i3;
        i6 = m43233a(i6, 10);
        i3 = m43233a(((i3 + m43238c(i4, i5, i6)) + this.f32575k[10]) + 1859775393, 13) + i7;
        i5 = m43233a(i5, 10);
        i7 = m43233a(((i7 + m43238c(i3, i4, i5)) + this.f32575k[14]) + 1859775393, 6) + i6;
        i4 = m43233a(i4, 10);
        i6 = m43233a(((i6 + m43238c(i7, i3, i4)) + this.f32575k[4]) + 1859775393, 7) + i5;
        i3 = m43233a(i3, 10);
        i5 = m43233a(((i5 + m43238c(i6, i7, i3)) + this.f32575k[9]) + 1859775393, 14) + i4;
        i7 = m43233a(i7, 10);
        i4 = m43233a(((i4 + m43238c(i5, i6, i7)) + this.f32575k[15]) + 1859775393, 9) + i3;
        i6 = m43233a(i6, 10);
        i3 = m43233a(((i3 + m43238c(i4, i5, i6)) + this.f32575k[8]) + 1859775393, 13) + i7;
        i5 = m43233a(i5, 10);
        i7 = m43233a(((i7 + m43238c(i3, i4, i5)) + this.f32575k[1]) + 1859775393, 15) + i6;
        i4 = m43233a(i4, 10);
        i6 = m43233a(((i6 + m43238c(i7, i3, i4)) + this.f32575k[2]) + 1859775393, 14) + i5;
        i3 = m43233a(i3, 10);
        i5 = m43233a(((i5 + m43238c(i6, i7, i3)) + this.f32575k[7]) + 1859775393, 8) + i4;
        i7 = m43233a(i7, 10);
        i4 = m43233a(((i4 + m43238c(i5, i6, i7)) + this.f32575k[0]) + 1859775393, 13) + i3;
        i6 = m43233a(i6, 10);
        i3 = m43233a(((i3 + m43238c(i4, i5, i6)) + this.f32575k[6]) + 1859775393, 6) + i7;
        i5 = m43233a(i5, 10);
        i7 = m43233a(((i7 + m43238c(i3, i4, i5)) + this.f32575k[13]) + 1859775393, 5) + i6;
        i4 = m43233a(i4, 10);
        i6 = m43233a(((i6 + m43238c(i7, i3, i4)) + this.f32575k[11]) + 1859775393, 12) + i5;
        i3 = m43233a(i3, 10);
        i5 = m43233a(((i5 + m43238c(i6, i7, i3)) + this.f32575k[5]) + 1859775393, 7) + i4;
        i7 = m43233a(i7, 10);
        i4 = m43233a(((i4 + m43238c(i5, i6, i7)) + this.f32575k[12]) + 1859775393, 5) + i3;
        i6 = m43233a(i6, 10);
        i9 = m43233a(((i9 + m43238c(i10, i, i2)) + this.f32575k[15]) + 1836072691, 9) + i8;
        i = m43233a(i, 10);
        i8 = m43233a(((i8 + m43238c(i9, i10, i)) + this.f32575k[5]) + 1836072691, 7) + i2;
        i10 = m43233a(i10, 10);
        i2 = m43233a(((i2 + m43238c(i8, i9, i10)) + this.f32575k[1]) + 1836072691, 15) + i;
        i9 = m43233a(i9, 10);
        i = m43233a(((i + m43238c(i2, i8, i9)) + this.f32575k[3]) + 1836072691, 11) + i10;
        i8 = m43233a(i8, 10);
        i10 = m43233a(((i10 + m43238c(i, i2, i8)) + this.f32575k[7]) + 1836072691, 8) + i9;
        i2 = m43233a(i2, 10);
        i9 = m43233a(((i9 + m43238c(i10, i, i2)) + this.f32575k[14]) + 1836072691, 6) + i8;
        i = m43233a(i, 10);
        i8 = m43233a(((i8 + m43238c(i9, i10, i)) + this.f32575k[6]) + 1836072691, 6) + i2;
        i10 = m43233a(i10, 10);
        i2 = m43233a(((i2 + m43238c(i8, i9, i10)) + this.f32575k[9]) + 1836072691, 14) + i;
        i9 = m43233a(i9, 10);
        i = m43233a(((i + m43238c(i2, i8, i9)) + this.f32575k[11]) + 1836072691, 12) + i10;
        i8 = m43233a(i8, 10);
        i10 = m43233a(((i10 + m43238c(i, i2, i8)) + this.f32575k[8]) + 1836072691, 13) + i9;
        i2 = m43233a(i2, 10);
        i9 = m43233a(((i9 + m43238c(i10, i, i2)) + this.f32575k[12]) + 1836072691, 5) + i8;
        i = m43233a(i, 10);
        i8 = m43233a(((i8 + m43238c(i9, i10, i)) + this.f32575k[2]) + 1836072691, 14) + i2;
        i10 = m43233a(i10, 10);
        i2 = m43233a(((i2 + m43238c(i8, i9, i10)) + this.f32575k[10]) + 1836072691, 13) + i;
        i9 = m43233a(i9, 10);
        i = m43233a(((i + m43238c(i2, i8, i9)) + this.f32575k[0]) + 1836072691, 13) + i10;
        i8 = m43233a(i8, 10);
        i10 = m43233a(((i10 + m43238c(i, i2, i8)) + this.f32575k[4]) + 1836072691, 7) + i9;
        i2 = m43233a(i2, 10);
        i9 = m43233a(((i9 + m43238c(i10, i, i2)) + this.f32575k[13]) + 1836072691, 5) + i8;
        i = m43233a(i, 10);
        i8 = m43233a(((i8 + m43239d(i4, i5, i6)) + this.f32575k[1]) - 1894007588, 11) + i7;
        i5 = m43233a(i5, 10);
        i7 = m43233a(((i7 + m43239d(i8, i4, i5)) + this.f32575k[9]) - 1894007588, 12) + i6;
        i4 = m43233a(i4, 10);
        i6 = m43233a(((i6 + m43239d(i7, i8, i4)) + this.f32575k[11]) - 1894007588, 14) + i5;
        i8 = m43233a(i8, 10);
        i5 = m43233a(((i5 + m43239d(i6, i7, i8)) + this.f32575k[10]) - 1894007588, 15) + i4;
        i7 = m43233a(i7, 10);
        i4 = m43233a(((i4 + m43239d(i5, i6, i7)) + this.f32575k[0]) - 1894007588, 14) + i8;
        i6 = m43233a(i6, 10);
        i8 = m43233a(((i8 + m43239d(i4, i5, i6)) + this.f32575k[8]) - 1894007588, 15) + i7;
        i5 = m43233a(i5, 10);
        i7 = m43233a(((i7 + m43239d(i8, i4, i5)) + this.f32575k[12]) - 1894007588, 9) + i6;
        i4 = m43233a(i4, 10);
        i6 = m43233a(((i6 + m43239d(i7, i8, i4)) + this.f32575k[4]) - 1894007588, 8) + i5;
        i8 = m43233a(i8, 10);
        i5 = m43233a(((i5 + m43239d(i6, i7, i8)) + this.f32575k[13]) - 1894007588, 9) + i4;
        i7 = m43233a(i7, 10);
        i4 = m43233a(((i4 + m43239d(i5, i6, i7)) + this.f32575k[3]) - 1894007588, 14) + i8;
        i6 = m43233a(i6, 10);
        i8 = m43233a(((i8 + m43239d(i4, i5, i6)) + this.f32575k[7]) - 1894007588, 5) + i7;
        i5 = m43233a(i5, 10);
        i7 = m43233a(((i7 + m43239d(i8, i4, i5)) + this.f32575k[15]) - 1894007588, 6) + i6;
        i4 = m43233a(i4, 10);
        i6 = m43233a(((i6 + m43239d(i7, i8, i4)) + this.f32575k[14]) - 1894007588, 8) + i5;
        i8 = m43233a(i8, 10);
        i5 = m43233a(((i5 + m43239d(i6, i7, i8)) + this.f32575k[5]) - 1894007588, 6) + i4;
        i7 = m43233a(i7, 10);
        i4 = m43233a(((i4 + m43239d(i5, i6, i7)) + this.f32575k[6]) - 1894007588, 5) + i8;
        i6 = m43233a(i6, 10);
        i8 = m43233a(((i8 + m43239d(i4, i5, i6)) + this.f32575k[2]) - 1894007588, 12) + i7;
        i5 = m43233a(i5, 10);
        i3 = m43233a(((i3 + m43237b(i9, i10, i)) + this.f32575k[8]) + 2053994217, 15) + i2;
        i10 = m43233a(i10, 10);
        i2 = m43233a(((i2 + m43237b(i3, i9, i10)) + this.f32575k[6]) + 2053994217, 5) + i;
        i9 = m43233a(i9, 10);
        i = m43233a(((i + m43237b(i2, i3, i9)) + this.f32575k[4]) + 2053994217, 8) + i10;
        i3 = m43233a(i3, 10);
        i10 = m43233a(((i10 + m43237b(i, i2, i3)) + this.f32575k[1]) + 2053994217, 11) + i9;
        i2 = m43233a(i2, 10);
        i9 = m43233a(((i9 + m43237b(i10, i, i2)) + this.f32575k[3]) + 2053994217, 14) + i3;
        i = m43233a(i, 10);
        i3 = m43233a(((i3 + m43237b(i9, i10, i)) + this.f32575k[11]) + 2053994217, 14) + i2;
        i10 = m43233a(i10, 10);
        i2 = m43233a(((i2 + m43237b(i3, i9, i10)) + this.f32575k[15]) + 2053994217, 6) + i;
        i9 = m43233a(i9, 10);
        i = m43233a(((i + m43237b(i2, i3, i9)) + this.f32575k[0]) + 2053994217, 14) + i10;
        i3 = m43233a(i3, 10);
        i10 = m43233a(((i10 + m43237b(i, i2, i3)) + this.f32575k[5]) + 2053994217, 6) + i9;
        i2 = m43233a(i2, 10);
        i9 = m43233a(((i9 + m43237b(i10, i, i2)) + this.f32575k[12]) + 2053994217, 9) + i3;
        i = m43233a(i, 10);
        i3 = m43233a(((i3 + m43237b(i9, i10, i)) + this.f32575k[2]) + 2053994217, 12) + i2;
        i10 = m43233a(i10, 10);
        i2 = m43233a(((i2 + m43237b(i3, i9, i10)) + this.f32575k[13]) + 2053994217, 9) + i;
        i9 = m43233a(i9, 10);
        i = m43233a(((i + m43237b(i2, i3, i9)) + this.f32575k[9]) + 2053994217, 12) + i10;
        i3 = m43233a(i3, 10);
        i10 = m43233a(((i10 + m43237b(i, i2, i3)) + this.f32575k[7]) + 2053994217, 5) + i9;
        i2 = m43233a(i2, 10);
        i9 = m43233a(((i9 + m43237b(i10, i, i2)) + this.f32575k[10]) + 2053994217, 15) + i3;
        i = m43233a(i, 10);
        i3 = m43233a(((i3 + m43237b(i9, i10, i)) + this.f32575k[14]) + 2053994217, 8) + i2;
        i10 = m43233a(i10, 10);
        i7 = m43233a(((i7 + m43240e(i8, i9, i5)) + this.f32575k[4]) - 1454113458, 9) + i6;
        i9 = m43233a(i9, 10);
        i6 = m43233a(((i6 + m43240e(i7, i8, i9)) + this.f32575k[0]) - 1454113458, 15) + i5;
        i8 = m43233a(i8, 10);
        i5 = m43233a(((i5 + m43240e(i6, i7, i8)) + this.f32575k[5]) - 1454113458, 5) + i9;
        i7 = m43233a(i7, 10);
        i9 = m43233a(((i9 + m43240e(i5, i6, i7)) + this.f32575k[9]) - 1454113458, 11) + i8;
        i6 = m43233a(i6, 10);
        i8 = m43233a(((i8 + m43240e(i9, i5, i6)) + this.f32575k[7]) - 1454113458, 6) + i7;
        i5 = m43233a(i5, 10);
        i7 = m43233a(((i7 + m43240e(i8, i9, i5)) + this.f32575k[12]) - 1454113458, 8) + i6;
        i9 = m43233a(i9, 10);
        i6 = m43233a(((i6 + m43240e(i7, i8, i9)) + this.f32575k[2]) - 1454113458, 13) + i5;
        i8 = m43233a(i8, 10);
        i5 = m43233a(((i5 + m43240e(i6, i7, i8)) + this.f32575k[10]) - 1454113458, 12) + i9;
        i7 = m43233a(i7, 10);
        i9 = m43233a(((i9 + m43240e(i5, i6, i7)) + this.f32575k[14]) - 1454113458, 5) + i8;
        i6 = m43233a(i6, 10);
        i8 = m43233a(((i8 + m43240e(i9, i5, i6)) + this.f32575k[1]) - 1454113458, 12) + i7;
        i5 = m43233a(i5, 10);
        i7 = m43233a(((i7 + m43240e(i8, i9, i5)) + this.f32575k[3]) - 1454113458, 13) + i6;
        i9 = m43233a(i9, 10);
        i6 = m43233a(((i6 + m43240e(i7, i8, i9)) + this.f32575k[8]) - 1454113458, 14) + i5;
        i8 = m43233a(i8, 10);
        i5 = m43233a(((i5 + m43240e(i6, i7, i8)) + this.f32575k[11]) - 1454113458, 11) + i9;
        i7 = m43233a(i7, 10);
        i9 = m43233a(((i9 + m43240e(i5, i6, i7)) + this.f32575k[6]) - 1454113458, 8) + i8;
        i6 = m43233a(i6, 10);
        i8 = m43233a(((i8 + m43240e(i9, i5, i6)) + this.f32575k[15]) - 1454113458, 5) + i7;
        i5 = m43233a(i5, 10);
        i7 = m43233a(((i7 + m43240e(i8, i9, i5)) + this.f32575k[13]) - 1454113458, 6) + i6;
        i9 = m43233a(i9, 10);
        i2 = m43233a((i2 + m43234a(i3, i4, i10)) + this.f32575k[12], 8) + i;
        i4 = m43233a(i4, 10);
        i = m43233a((i + m43234a(i2, i3, i4)) + this.f32575k[15], 5) + i10;
        i3 = m43233a(i3, 10);
        i10 = m43233a((i10 + m43234a(i, i2, i3)) + this.f32575k[10], 12) + i4;
        i2 = m43233a(i2, 10);
        i4 = m43233a((i4 + m43234a(i10, i, i2)) + this.f32575k[4], 9) + i3;
        i = m43233a(i, 10);
        i3 = m43233a((i3 + m43234a(i4, i10, i)) + this.f32575k[1], 12) + i2;
        i10 = m43233a(i10, 10);
        i2 = m43233a((i2 + m43234a(i3, i4, i10)) + this.f32575k[5], 5) + i;
        i4 = m43233a(i4, 10);
        i = m43233a((i + m43234a(i2, i3, i4)) + this.f32575k[8], 14) + i10;
        i3 = m43233a(i3, 10);
        i10 = m43233a((i10 + m43234a(i, i2, i3)) + this.f32575k[7], 6) + i4;
        i2 = m43233a(i2, 10);
        i4 = m43233a((i4 + m43234a(i10, i, i2)) + this.f32575k[6], 8) + i3;
        i = m43233a(i, 10);
        i3 = m43233a((i3 + m43234a(i4, i10, i)) + this.f32575k[2], 13) + i2;
        i10 = m43233a(i10, 10);
        i2 = m43233a((i2 + m43234a(i3, i4, i10)) + this.f32575k[13], 6) + i;
        i4 = m43233a(i4, 10);
        i = m43233a((i + m43234a(i2, i3, i4)) + this.f32575k[14], 5) + i10;
        i3 = m43233a(i3, 10);
        i10 = m43233a((i10 + m43234a(i, i2, i3)) + this.f32575k[0], 15) + i4;
        i2 = m43233a(i2, 10);
        i4 = m43233a((i4 + m43234a(i10, i, i2)) + this.f32575k[3], 13) + i3;
        i = m43233a(i, 10);
        i3 = m43233a((i3 + m43234a(i4, i10, i)) + this.f32575k[9], 11) + i2;
        i10 = m43233a(i10, 10);
        i2 = m43233a((i2 + m43234a(i3, i4, i10)) + this.f32575k[11], 11) + i;
        i4 = m43233a(i4, 10);
        this.f32565a += i6;
        this.f32566b += i7;
        this.f32567c += i8;
        this.f32568d += i9;
        this.f32569e += i10;
        this.f32570f += i;
        this.f32571g += i2;
        this.f32572h += i3;
        this.f32573i += i4;
        this.f32574j += i5;
        i = 0;
        this.f32576l = 0;
        while (i != r0.f32575k.length) {
            r0.f32575k[i] = 0;
            i++;
        }
    }

    /* renamed from: e */
    public Memoable mo5735e() {
        return new RIPEMD320Digest(this);
    }

    /* renamed from: a */
    public void mo5734a(Memoable memoable) {
        m43236a((RIPEMD320Digest) memoable);
    }
}
