package org.spongycastle.crypto.digests;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.util.Memoable;

public class RIPEMD160Digest extends GeneralDigest {
    /* renamed from: a */
    private int f32548a;
    /* renamed from: b */
    private int f32549b;
    /* renamed from: c */
    private int f32550c;
    /* renamed from: d */
    private int f32551d;
    /* renamed from: e */
    private int f32552e;
    /* renamed from: f */
    private int[] f32553f;
    /* renamed from: g */
    private int f32554g;

    /* renamed from: a */
    private int m43192a(int i, int i2) {
        return (i >>> (32 - i2)) | (i << i2);
    }

    /* renamed from: a */
    private int m43193a(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    /* renamed from: b */
    private int m43196b(int i, int i2, int i3) {
        return ((~i) & i3) | (i2 & i);
    }

    /* renamed from: c */
    private int m43197c(int i, int i2, int i3) {
        return (i | (~i2)) ^ i3;
    }

    /* renamed from: d */
    private int m43198d(int i, int i2, int i3) {
        return (i & i3) | (i2 & (~i3));
    }

    /* renamed from: e */
    private int m43199e(int i, int i2, int i3) {
        return i ^ (i2 | (~i3));
    }

    /* renamed from: a */
    public String mo5729a() {
        return "RIPEMD160";
    }

    /* renamed from: b */
    public int mo5732b() {
        return 20;
    }

    public RIPEMD160Digest() {
        this.f32553f = new int[16];
        mo5733c();
    }

    public RIPEMD160Digest(RIPEMD160Digest rIPEMD160Digest) {
        super(rIPEMD160Digest);
        this.f32553f = new int[16];
        m43195a(rIPEMD160Digest);
    }

    /* renamed from: a */
    private void m43195a(RIPEMD160Digest rIPEMD160Digest) {
        super.m40566a((GeneralDigest) rIPEMD160Digest);
        this.f32548a = rIPEMD160Digest.f32548a;
        this.f32549b = rIPEMD160Digest.f32549b;
        this.f32550c = rIPEMD160Digest.f32550c;
        this.f32551d = rIPEMD160Digest.f32551d;
        this.f32552e = rIPEMD160Digest.f32552e;
        System.arraycopy(rIPEMD160Digest.f32553f, 0, this.f32553f, 0, rIPEMD160Digest.f32553f.length);
        this.f32554g = rIPEMD160Digest.f32554g;
    }

    /* renamed from: b */
    protected void mo6794b(byte[] bArr, int i) {
        int[] iArr = this.f32553f;
        int i2 = this.f32554g;
        this.f32554g = i2 + 1;
        iArr[i2] = ((bArr[i + 3] & JfifUtil.MARKER_FIRST_BYTE) << 24) | (((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) | ((bArr[i + 1] & JfifUtil.MARKER_FIRST_BYTE) << 8)) | ((bArr[i + 2] & JfifUtil.MARKER_FIRST_BYTE) << 16));
        if (this.f32554g == 16) {
            mo6795g();
        }
    }

    /* renamed from: a */
    protected void mo6793a(long j) {
        if (this.f32554g > 14) {
            mo6795g();
        }
        this.f32553f[14] = (int) (-1 & j);
        this.f32553f[15] = (int) (j >>> 32);
    }

    /* renamed from: a */
    private void m43194a(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2 + 2] = (byte) (i >>> 16);
        bArr[i2 + 3] = (byte) (i >>> 24);
    }

    /* renamed from: a */
    public int mo5728a(byte[] bArr, int i) {
        m40571f();
        m43194a(this.f32548a, bArr, i);
        m43194a(this.f32549b, bArr, i + 4);
        m43194a(this.f32550c, bArr, i + 8);
        m43194a(this.f32551d, bArr, i + 12);
        m43194a(this.f32552e, bArr, i + 16);
        mo5733c();
        return 20;
    }

    /* renamed from: c */
    public void mo5733c() {
        super.mo5733c();
        this.f32548a = 1732584193;
        this.f32549b = -271733879;
        this.f32550c = -1732584194;
        this.f32551d = 271733878;
        this.f32552e = -1009589776;
        this.f32554g = 0;
        for (int i = 0; i != this.f32553f.length; i++) {
            this.f32553f[i] = 0;
        }
    }

    /* renamed from: g */
    protected void mo6795g() {
        int i = this.f32548a;
        int i2 = this.f32549b;
        int i3 = this.f32550c;
        int i4 = this.f32551d;
        int i5 = this.f32552e;
        int a = m43192a((m43193a(i2, i3, i4) + i) + this.f32553f[0], 11) + i5;
        int a2 = m43192a(i3, 10);
        int a3 = m43192a((m43193a(a, i2, a2) + i5) + this.f32553f[1], 14) + i4;
        int a4 = m43192a(i2, 10);
        int a5 = m43192a((m43193a(a3, a, a4) + i4) + this.f32553f[2], 15) + a2;
        a = m43192a(a, 10);
        a2 = m43192a((a2 + m43193a(a5, a3, a)) + this.f32553f[3], 12) + a4;
        a3 = m43192a(a3, 10);
        a4 = m43192a((a4 + m43193a(a2, a5, a3)) + this.f32553f[4], 5) + a;
        a5 = m43192a(a5, 10);
        a = m43192a((a + m43193a(a4, a2, a5)) + this.f32553f[5], 8) + a3;
        a2 = m43192a(a2, 10);
        a3 = m43192a((a3 + m43193a(a, a4, a2)) + this.f32553f[6], 7) + a5;
        a4 = m43192a(a4, 10);
        a5 = m43192a((a5 + m43193a(a3, a, a4)) + this.f32553f[7], 9) + a2;
        a = m43192a(a, 10);
        a2 = m43192a((a2 + m43193a(a5, a3, a)) + this.f32553f[8], 11) + a4;
        a3 = m43192a(a3, 10);
        a4 = m43192a((a4 + m43193a(a2, a5, a3)) + this.f32553f[9], 13) + a;
        a5 = m43192a(a5, 10);
        a = m43192a((a + m43193a(a4, a2, a5)) + this.f32553f[10], 14) + a3;
        a2 = m43192a(a2, 10);
        a3 = m43192a((a3 + m43193a(a, a4, a2)) + this.f32553f[11], 15) + a5;
        a4 = m43192a(a4, 10);
        a5 = m43192a((a5 + m43193a(a3, a, a4)) + this.f32553f[12], 6) + a2;
        a = m43192a(a, 10);
        a2 = m43192a((a2 + m43193a(a5, a3, a)) + this.f32553f[13], 7) + a4;
        a3 = m43192a(a3, 10);
        a4 = m43192a((a4 + m43193a(a2, a5, a3)) + this.f32553f[14], 9) + a;
        a5 = m43192a(a5, 10);
        a = m43192a((a + m43193a(a4, a2, a5)) + this.f32553f[15], 8) + a3;
        a2 = m43192a(a2, 10);
        i = m43192a(((i + m43199e(i2, i3, i4)) + this.f32553f[5]) + 1352829926, 8) + i5;
        i3 = m43192a(i3, 10);
        i5 = m43192a(((i5 + m43199e(i, i2, i3)) + this.f32553f[14]) + 1352829926, 9) + i4;
        i2 = m43192a(i2, 10);
        i4 = m43192a(((i4 + m43199e(i5, i, i2)) + this.f32553f[7]) + 1352829926, 9) + i3;
        i = m43192a(i, 10);
        i3 = m43192a(((i3 + m43199e(i4, i5, i)) + this.f32553f[0]) + 1352829926, 11) + i2;
        i5 = m43192a(i5, 10);
        i2 = m43192a(((i2 + m43199e(i3, i4, i5)) + this.f32553f[9]) + 1352829926, 13) + i;
        i4 = m43192a(i4, 10);
        i = m43192a(((i + m43199e(i2, i3, i4)) + this.f32553f[2]) + 1352829926, 15) + i5;
        i3 = m43192a(i3, 10);
        i5 = m43192a(((i5 + m43199e(i, i2, i3)) + this.f32553f[11]) + 1352829926, 15) + i4;
        i2 = m43192a(i2, 10);
        i4 = m43192a(((i4 + m43199e(i5, i, i2)) + this.f32553f[4]) + 1352829926, 5) + i3;
        i = m43192a(i, 10);
        i3 = m43192a(((i3 + m43199e(i4, i5, i)) + this.f32553f[13]) + 1352829926, 7) + i2;
        i5 = m43192a(i5, 10);
        i2 = m43192a(((i2 + m43199e(i3, i4, i5)) + this.f32553f[6]) + 1352829926, 7) + i;
        i4 = m43192a(i4, 10);
        i = m43192a(((i + m43199e(i2, i3, i4)) + this.f32553f[15]) + 1352829926, 8) + i5;
        i3 = m43192a(i3, 10);
        i5 = m43192a(((i5 + m43199e(i, i2, i3)) + this.f32553f[8]) + 1352829926, 11) + i4;
        i2 = m43192a(i2, 10);
        i4 = m43192a(((i4 + m43199e(i5, i, i2)) + this.f32553f[1]) + 1352829926, 14) + i3;
        i = m43192a(i, 10);
        i3 = m43192a(((i3 + m43199e(i4, i5, i)) + this.f32553f[10]) + 1352829926, 14) + i2;
        i5 = m43192a(i5, 10);
        i2 = m43192a(((i2 + m43199e(i3, i4, i5)) + this.f32553f[3]) + 1352829926, 12) + i;
        i4 = m43192a(i4, 10);
        i = m43192a(((i + m43199e(i2, i3, i4)) + this.f32553f[12]) + 1352829926, 6) + i5;
        i3 = m43192a(i3, 10);
        a3 = m43192a(((a3 + m43196b(a, a4, a2)) + this.f32553f[7]) + 1518500249, 7) + a5;
        a4 = m43192a(a4, 10);
        a5 = m43192a(((a5 + m43196b(a3, a, a4)) + this.f32553f[4]) + 1518500249, 6) + a2;
        a = m43192a(a, 10);
        a2 = m43192a(((a2 + m43196b(a5, a3, a)) + this.f32553f[13]) + 1518500249, 8) + a4;
        a3 = m43192a(a3, 10);
        a4 = m43192a(((a4 + m43196b(a2, a5, a3)) + this.f32553f[1]) + 1518500249, 13) + a;
        a5 = m43192a(a5, 10);
        a = m43192a(((a + m43196b(a4, a2, a5)) + this.f32553f[10]) + 1518500249, 11) + a3;
        a2 = m43192a(a2, 10);
        a3 = m43192a(((a3 + m43196b(a, a4, a2)) + this.f32553f[6]) + 1518500249, 9) + a5;
        a4 = m43192a(a4, 10);
        a5 = m43192a(((a5 + m43196b(a3, a, a4)) + this.f32553f[15]) + 1518500249, 7) + a2;
        a = m43192a(a, 10);
        a2 = m43192a(((a2 + m43196b(a5, a3, a)) + this.f32553f[3]) + 1518500249, 15) + a4;
        a3 = m43192a(a3, 10);
        a4 = m43192a(((a4 + m43196b(a2, a5, a3)) + this.f32553f[12]) + 1518500249, 7) + a;
        a5 = m43192a(a5, 10);
        a = m43192a(((a + m43196b(a4, a2, a5)) + this.f32553f[0]) + 1518500249, 12) + a3;
        a2 = m43192a(a2, 10);
        a3 = m43192a(((a3 + m43196b(a, a4, a2)) + this.f32553f[9]) + 1518500249, 15) + a5;
        a4 = m43192a(a4, 10);
        a5 = m43192a(((a5 + m43196b(a3, a, a4)) + this.f32553f[5]) + 1518500249, 9) + a2;
        a = m43192a(a, 10);
        a2 = m43192a(((a2 + m43196b(a5, a3, a)) + this.f32553f[2]) + 1518500249, 11) + a4;
        a3 = m43192a(a3, 10);
        a4 = m43192a(((a4 + m43196b(a2, a5, a3)) + this.f32553f[14]) + 1518500249, 7) + a;
        a5 = m43192a(a5, 10);
        a = m43192a(((a + m43196b(a4, a2, a5)) + this.f32553f[11]) + 1518500249, 13) + a3;
        a2 = m43192a(a2, 10);
        a3 = m43192a(((a3 + m43196b(a, a4, a2)) + this.f32553f[8]) + 1518500249, 12) + a5;
        int a6 = m43192a(a4, 10);
        i5 = m43192a(((i5 + m43198d(i, i2, i3)) + this.f32553f[6]) + 1548603684, 9) + i4;
        i2 = m43192a(i2, 10);
        i4 = m43192a(((i4 + m43198d(i5, i, i2)) + this.f32553f[11]) + 1548603684, 13) + i3;
        i = m43192a(i, 10);
        i3 = m43192a(((i3 + m43198d(i4, i5, i)) + this.f32553f[3]) + 1548603684, 15) + i2;
        i5 = m43192a(i5, 10);
        i2 = m43192a(((i2 + m43198d(i3, i4, i5)) + this.f32553f[7]) + 1548603684, 7) + i;
        i4 = m43192a(i4, 10);
        i = m43192a(((i + m43198d(i2, i3, i4)) + this.f32553f[0]) + 1548603684, 12) + i5;
        i3 = m43192a(i3, 10);
        i5 = m43192a(((i5 + m43198d(i, i2, i3)) + this.f32553f[13]) + 1548603684, 8) + i4;
        i2 = m43192a(i2, 10);
        i4 = m43192a(((i4 + m43198d(i5, i, i2)) + this.f32553f[5]) + 1548603684, 9) + i3;
        i = m43192a(i, 10);
        i3 = m43192a(((i3 + m43198d(i4, i5, i)) + this.f32553f[10]) + 1548603684, 11) + i2;
        i5 = m43192a(i5, 10);
        i2 = m43192a(((i2 + m43198d(i3, i4, i5)) + this.f32553f[14]) + 1548603684, 7) + i;
        i4 = m43192a(i4, 10);
        i = m43192a(((i + m43198d(i2, i3, i4)) + this.f32553f[15]) + 1548603684, 7) + i5;
        i3 = m43192a(i3, 10);
        i5 = m43192a(((i5 + m43198d(i, i2, i3)) + this.f32553f[8]) + 1548603684, 12) + i4;
        i2 = m43192a(i2, 10);
        i4 = m43192a(((i4 + m43198d(i5, i, i2)) + this.f32553f[12]) + 1548603684, 7) + i3;
        i = m43192a(i, 10);
        i3 = m43192a(((i3 + m43198d(i4, i5, i)) + this.f32553f[4]) + 1548603684, 6) + i2;
        i5 = m43192a(i5, 10);
        i2 = m43192a(((i2 + m43198d(i3, i4, i5)) + this.f32553f[9]) + 1548603684, 15) + i;
        i4 = m43192a(i4, 10);
        i = m43192a(((i + m43198d(i2, i3, i4)) + this.f32553f[1]) + 1548603684, 13) + i5;
        i3 = m43192a(i3, 10);
        i5 = m43192a(((i5 + m43198d(i, i2, i3)) + this.f32553f[2]) + 1548603684, 11) + i4;
        i2 = m43192a(i2, 10);
        a5 = m43192a(((a5 + m43197c(a3, a, a6)) + this.f32553f[3]) + 1859775393, 11) + a2;
        a = m43192a(a, 10);
        a2 = m43192a(((a2 + m43197c(a5, a3, a)) + this.f32553f[10]) + 1859775393, 13) + a6;
        a3 = m43192a(a3, 10);
        a6 = m43192a(((a6 + m43197c(a2, a5, a3)) + this.f32553f[14]) + 1859775393, 6) + a;
        a5 = m43192a(a5, 10);
        a = m43192a(((a + m43197c(a6, a2, a5)) + this.f32553f[4]) + 1859775393, 7) + a3;
        a2 = m43192a(a2, 10);
        a3 = m43192a(((a3 + m43197c(a, a6, a2)) + this.f32553f[9]) + 1859775393, 14) + a5;
        a6 = m43192a(a6, 10);
        a5 = m43192a(((a5 + m43197c(a3, a, a6)) + this.f32553f[15]) + 1859775393, 9) + a2;
        a = m43192a(a, 10);
        a2 = m43192a(((a2 + m43197c(a5, a3, a)) + this.f32553f[8]) + 1859775393, 13) + a6;
        a3 = m43192a(a3, 10);
        a6 = m43192a(((a6 + m43197c(a2, a5, a3)) + this.f32553f[1]) + 1859775393, 15) + a;
        a5 = m43192a(a5, 10);
        a = m43192a(((a + m43197c(a6, a2, a5)) + this.f32553f[2]) + 1859775393, 14) + a3;
        a2 = m43192a(a2, 10);
        a3 = m43192a(((a3 + m43197c(a, a6, a2)) + this.f32553f[7]) + 1859775393, 8) + a5;
        a6 = m43192a(a6, 10);
        a5 = m43192a(((a5 + m43197c(a3, a, a6)) + this.f32553f[0]) + 1859775393, 13) + a2;
        a = m43192a(a, 10);
        a2 = m43192a(((a2 + m43197c(a5, a3, a)) + this.f32553f[6]) + 1859775393, 6) + a6;
        a3 = m43192a(a3, 10);
        a6 = m43192a(((a6 + m43197c(a2, a5, a3)) + this.f32553f[13]) + 1859775393, 5) + a;
        a5 = m43192a(a5, 10);
        a = m43192a(((a + m43197c(a6, a2, a5)) + this.f32553f[11]) + 1859775393, 12) + a3;
        a2 = m43192a(a2, 10);
        a3 = m43192a(((a3 + m43197c(a, a6, a2)) + this.f32553f[5]) + 1859775393, 7) + a5;
        a6 = m43192a(a6, 10);
        a5 = m43192a(((a5 + m43197c(a3, a, a6)) + this.f32553f[12]) + 1859775393, 5) + a2;
        a = m43192a(a, 10);
        i4 = m43192a(((i4 + m43197c(i5, i, i2)) + this.f32553f[15]) + 1836072691, 9) + i3;
        i = m43192a(i, 10);
        i3 = m43192a(((i3 + m43197c(i4, i5, i)) + this.f32553f[5]) + 1836072691, 7) + i2;
        i5 = m43192a(i5, 10);
        i2 = m43192a(((i2 + m43197c(i3, i4, i5)) + this.f32553f[1]) + 1836072691, 15) + i;
        i4 = m43192a(i4, 10);
        i = m43192a(((i + m43197c(i2, i3, i4)) + this.f32553f[3]) + 1836072691, 11) + i5;
        i3 = m43192a(i3, 10);
        i5 = m43192a(((i5 + m43197c(i, i2, i3)) + this.f32553f[7]) + 1836072691, 8) + i4;
        i2 = m43192a(i2, 10);
        i4 = m43192a(((i4 + m43197c(i5, i, i2)) + this.f32553f[14]) + 1836072691, 6) + i3;
        i = m43192a(i, 10);
        i3 = m43192a(((i3 + m43197c(i4, i5, i)) + this.f32553f[6]) + 1836072691, 6) + i2;
        i5 = m43192a(i5, 10);
        i2 = m43192a(((i2 + m43197c(i3, i4, i5)) + this.f32553f[9]) + 1836072691, 14) + i;
        i4 = m43192a(i4, 10);
        i = m43192a(((i + m43197c(i2, i3, i4)) + this.f32553f[11]) + 1836072691, 12) + i5;
        i3 = m43192a(i3, 10);
        i5 = m43192a(((i5 + m43197c(i, i2, i3)) + this.f32553f[8]) + 1836072691, 13) + i4;
        i2 = m43192a(i2, 10);
        i4 = m43192a(((i4 + m43197c(i5, i, i2)) + this.f32553f[12]) + 1836072691, 5) + i3;
        i = m43192a(i, 10);
        i3 = m43192a(((i3 + m43197c(i4, i5, i)) + this.f32553f[2]) + 1836072691, 14) + i2;
        i5 = m43192a(i5, 10);
        i2 = m43192a(((i2 + m43197c(i3, i4, i5)) + this.f32553f[10]) + 1836072691, 13) + i;
        i4 = m43192a(i4, 10);
        i = m43192a(((i + m43197c(i2, i3, i4)) + this.f32553f[0]) + 1836072691, 13) + i5;
        i3 = m43192a(i3, 10);
        i5 = m43192a(((i5 + m43197c(i, i2, i3)) + this.f32553f[4]) + 1836072691, 7) + i4;
        i2 = m43192a(i2, 10);
        i4 = m43192a(((i4 + m43197c(i5, i, i2)) + this.f32553f[13]) + 1836072691, 5) + i3;
        i = m43192a(i, 10);
        a2 = m43192a(((a2 + m43198d(a5, a3, a)) + this.f32553f[1]) - 1894007588, 11) + a6;
        a3 = m43192a(a3, 10);
        a6 = m43192a(((a6 + m43198d(a2, a5, a3)) + this.f32553f[9]) - 1894007588, 12) + a;
        a4 = m43192a(a5, 10);
        a = m43192a(((a + m43198d(a6, a2, a4)) + this.f32553f[11]) - 1894007588, 14) + a3;
        a2 = m43192a(a2, 10);
        a3 = m43192a(((a3 + m43198d(a, a6, a2)) + this.f32553f[10]) - 1894007588, 15) + a4;
        a6 = m43192a(a6, 10);
        a4 = m43192a(((a4 + m43198d(a3, a, a6)) + this.f32553f[0]) - 1894007588, 14) + a2;
        a = m43192a(a, 10);
        a2 = m43192a(((a2 + m43198d(a4, a3, a)) + this.f32553f[8]) - 1894007588, 15) + a6;
        a3 = m43192a(a3, 10);
        a6 = m43192a(((a6 + m43198d(a2, a4, a3)) + this.f32553f[12]) - 1894007588, 9) + a;
        a4 = m43192a(a4, 10);
        a = m43192a(((a + m43198d(a6, a2, a4)) + this.f32553f[4]) - 1894007588, 8) + a3;
        a2 = m43192a(a2, 10);
        a3 = m43192a(((a3 + m43198d(a, a6, a2)) + this.f32553f[13]) - 1894007588, 9) + a4;
        a6 = m43192a(a6, 10);
        a4 = m43192a(((a4 + m43198d(a3, a, a6)) + this.f32553f[3]) - 1894007588, 14) + a2;
        a = m43192a(a, 10);
        a2 = m43192a(((a2 + m43198d(a4, a3, a)) + this.f32553f[7]) - 1894007588, 5) + a6;
        a3 = m43192a(a3, 10);
        a6 = m43192a(((a6 + m43198d(a2, a4, a3)) + this.f32553f[15]) - 1894007588, 6) + a;
        a4 = m43192a(a4, 10);
        a = m43192a(((a + m43198d(a6, a2, a4)) + this.f32553f[14]) - 1894007588, 8) + a3;
        a2 = m43192a(a2, 10);
        a3 = m43192a(((a3 + m43198d(a, a6, a2)) + this.f32553f[5]) - 1894007588, 6) + a4;
        a6 = m43192a(a6, 10);
        a4 = m43192a(((a4 + m43198d(a3, a, a6)) + this.f32553f[6]) - 1894007588, 5) + a2;
        a = m43192a(a, 10);
        a2 = m43192a(((a2 + m43198d(a4, a3, a)) + this.f32553f[2]) - 1894007588, 12) + a6;
        a3 = m43192a(a3, 10);
        i3 = m43192a(((i3 + m43196b(i4, i5, i)) + this.f32553f[8]) + 2053994217, 15) + i2;
        i5 = m43192a(i5, 10);
        i2 = m43192a(((i2 + m43196b(i3, i4, i5)) + this.f32553f[6]) + 2053994217, 5) + i;
        i4 = m43192a(i4, 10);
        i = m43192a(((i + m43196b(i2, i3, i4)) + this.f32553f[4]) + 2053994217, 8) + i5;
        i3 = m43192a(i3, 10);
        i5 = m43192a(((i5 + m43196b(i, i2, i3)) + this.f32553f[1]) + 2053994217, 11) + i4;
        i2 = m43192a(i2, 10);
        i4 = m43192a(((i4 + m43196b(i5, i, i2)) + this.f32553f[3]) + 2053994217, 14) + i3;
        i = m43192a(i, 10);
        i3 = m43192a(((i3 + m43196b(i4, i5, i)) + this.f32553f[11]) + 2053994217, 14) + i2;
        i5 = m43192a(i5, 10);
        i2 = m43192a(((i2 + m43196b(i3, i4, i5)) + this.f32553f[15]) + 2053994217, 6) + i;
        i4 = m43192a(i4, 10);
        i = m43192a(((i + m43196b(i2, i3, i4)) + this.f32553f[0]) + 2053994217, 14) + i5;
        i3 = m43192a(i3, 10);
        i5 = m43192a(((i5 + m43196b(i, i2, i3)) + this.f32553f[5]) + 2053994217, 6) + i4;
        i2 = m43192a(i2, 10);
        i4 = m43192a(((i4 + m43196b(i5, i, i2)) + this.f32553f[12]) + 2053994217, 9) + i3;
        i = m43192a(i, 10);
        i3 = m43192a(((i3 + m43196b(i4, i5, i)) + this.f32553f[2]) + 2053994217, 12) + i2;
        i5 = m43192a(i5, 10);
        i2 = m43192a(((i2 + m43196b(i3, i4, i5)) + this.f32553f[13]) + 2053994217, 9) + i;
        i4 = m43192a(i4, 10);
        i = m43192a(((i + m43196b(i2, i3, i4)) + this.f32553f[9]) + 2053994217, 12) + i5;
        i3 = m43192a(i3, 10);
        i5 = m43192a(((i5 + m43196b(i, i2, i3)) + this.f32553f[7]) + 2053994217, 5) + i4;
        i2 = m43192a(i2, 10);
        i4 = m43192a(((i4 + m43196b(i5, i, i2)) + this.f32553f[10]) + 2053994217, 15) + i3;
        i = m43192a(i, 10);
        i3 = m43192a(((i3 + m43196b(i4, i5, i)) + this.f32553f[14]) + 2053994217, 8) + i2;
        i5 = m43192a(i5, 10);
        a6 = m43192a(((a6 + m43199e(a2, a4, a3)) + this.f32553f[4]) - 1454113458, 9) + a;
        a4 = m43192a(a4, 10);
        a = m43192a(((a + m43199e(a6, a2, a4)) + this.f32553f[0]) - 1454113458, 15) + a3;
        a2 = m43192a(a2, 10);
        a3 = m43192a(((a3 + m43199e(a, a6, a2)) + this.f32553f[5]) - 1454113458, 5) + a4;
        a6 = m43192a(a6, 10);
        a4 = m43192a(((a4 + m43199e(a3, a, a6)) + this.f32553f[9]) - 1454113458, 11) + a2;
        a = m43192a(a, 10);
        a2 = m43192a(((a2 + m43199e(a4, a3, a)) + this.f32553f[7]) - 1454113458, 6) + a6;
        a3 = m43192a(a3, 10);
        a6 = m43192a(((a6 + m43199e(a2, a4, a3)) + this.f32553f[12]) - 1454113458, 8) + a;
        a4 = m43192a(a4, 10);
        a = m43192a(((a + m43199e(a6, a2, a4)) + this.f32553f[2]) - 1454113458, 13) + a3;
        a2 = m43192a(a2, 10);
        a3 = m43192a(((a3 + m43199e(a, a6, a2)) + this.f32553f[10]) - 1454113458, 12) + a4;
        a6 = m43192a(a6, 10);
        a4 = m43192a(((a4 + m43199e(a3, a, a6)) + this.f32553f[14]) - 1454113458, 5) + a2;
        a = m43192a(a, 10);
        a2 = m43192a(((a2 + m43199e(a4, a3, a)) + this.f32553f[1]) - 1454113458, 12) + a6;
        a3 = m43192a(a3, 10);
        a6 = m43192a(((a6 + m43199e(a2, a4, a3)) + this.f32553f[3]) - 1454113458, 13) + a;
        a4 = m43192a(a4, 10);
        a = m43192a(((a + m43199e(a6, a2, a4)) + this.f32553f[8]) - 1454113458, 14) + a3;
        a2 = m43192a(a2, 10);
        a3 = m43192a(((a3 + m43199e(a, a6, a2)) + this.f32553f[11]) - 1454113458, 11) + a4;
        a6 = m43192a(a6, 10);
        a4 = m43192a(((a4 + m43199e(a3, a, a6)) + this.f32553f[6]) - 1454113458, 8) + a2;
        a = m43192a(a, 10);
        a2 = m43192a(((a2 + m43199e(a4, a3, a)) + this.f32553f[15]) - 1454113458, 5) + a6;
        a3 = m43192a(a3, 10);
        a6 = m43192a(((a6 + m43199e(a2, a4, a3)) + this.f32553f[13]) - 1454113458, 6) + a;
        a4 = m43192a(a4, 10);
        i2 = m43192a((i2 + m43193a(i3, i4, i5)) + this.f32553f[12], 8) + i;
        i4 = m43192a(i4, 10);
        i = m43192a((i + m43193a(i2, i3, i4)) + this.f32553f[15], 5) + i5;
        i3 = m43192a(i3, 10);
        i5 = m43192a((i5 + m43193a(i, i2, i3)) + this.f32553f[10], 12) + i4;
        i2 = m43192a(i2, 10);
        i4 = m43192a((i4 + m43193a(i5, i, i2)) + this.f32553f[4], 9) + i3;
        i = m43192a(i, 10);
        i3 = m43192a((i3 + m43193a(i4, i5, i)) + this.f32553f[1], 12) + i2;
        i5 = m43192a(i5, 10);
        i2 = m43192a((i2 + m43193a(i3, i4, i5)) + this.f32553f[5], 5) + i;
        i4 = m43192a(i4, 10);
        i = m43192a((i + m43193a(i2, i3, i4)) + this.f32553f[8], 14) + i5;
        i3 = m43192a(i3, 10);
        i5 = m43192a((i5 + m43193a(i, i2, i3)) + this.f32553f[7], 6) + i4;
        i2 = m43192a(i2, 10);
        i4 = m43192a((i4 + m43193a(i5, i, i2)) + this.f32553f[6], 8) + i3;
        i = m43192a(i, 10);
        i3 = m43192a((i3 + m43193a(i4, i5, i)) + this.f32553f[2], 13) + i2;
        i5 = m43192a(i5, 10);
        i2 = m43192a((i2 + m43193a(i3, i4, i5)) + this.f32553f[13], 6) + i;
        i4 = m43192a(i4, 10);
        i = m43192a((i + m43193a(i2, i3, i4)) + this.f32553f[14], 5) + i5;
        i3 = m43192a(i3, 10);
        i5 = m43192a((i5 + m43193a(i, i2, i3)) + this.f32553f[0], 15) + i4;
        i2 = m43192a(i2, 10);
        i4 = m43192a((i4 + m43193a(i5, i, i2)) + this.f32553f[3], 13) + i3;
        i = m43192a(i, 10);
        i3 = m43192a((i3 + m43193a(i4, i5, i)) + this.f32553f[9], 11) + i2;
        i5 = m43192a(i5, 10);
        i2 = m43192a((i2 + m43193a(i3, i4, i5)) + this.f32553f[11], 11) + i;
        i4 = m43192a(i4, 10) + (a2 + this.f32549b);
        this.f32549b = (this.f32550c + a4) + i5;
        this.f32550c = (this.f32551d + a3) + i;
        this.f32551d = (this.f32552e + a) + i2;
        this.f32552e = (this.f32548a + a6) + i3;
        this.f32548a = i4;
        i = 0;
        this.f32554g = 0;
        while (i != r0.f32553f.length) {
            r0.f32553f[i] = 0;
            i++;
        }
    }

    /* renamed from: e */
    public Memoable mo5735e() {
        return new RIPEMD160Digest(this);
    }

    /* renamed from: a */
    public void mo5734a(Memoable memoable) {
        m43195a((RIPEMD160Digest) memoable);
    }
}
