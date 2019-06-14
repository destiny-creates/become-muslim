package com.amplitude.p063a;

import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.facebook.imageutils.JfifUtil;
import java.security.MessageDigest;

/* compiled from: MD5 */
/* renamed from: com.amplitude.a.a */
public final class C0968a extends MessageDigest implements Cloneable {
    /* renamed from: a */
    private long f2732a;
    /* renamed from: b */
    private int f2733b;
    /* renamed from: c */
    private byte[] f2734c = new byte[64];
    /* renamed from: d */
    private int f2735d;
    /* renamed from: e */
    private int f2736e;
    /* renamed from: f */
    private int f2737f;
    /* renamed from: g */
    private int f2738g;

    public int engineGetDigestLength() {
        return 16;
    }

    public C0968a() {
        super("MD5");
        m3412a();
    }

    public Object clone() {
        C0968a c0968a = (C0968a) super.clone();
        c0968a.f2734c = (byte[]) this.f2734c.clone();
        return c0968a;
    }

    public void engineReset() {
        this.f2733b = 0;
        this.f2732a = 0;
        byte[] bArr = this.f2734c;
        int i = 60;
        do {
            bArr[i - 4] = (byte) 0;
            bArr[i - 3] = (byte) 0;
            bArr[i - 2] = (byte) 0;
            bArr[i - 1] = (byte) 0;
            bArr[i] = (byte) 0;
            bArr[i + 1] = (byte) 0;
            bArr[i + 2] = (byte) 0;
            bArr[i + 3] = (byte) 0;
            i -= 8;
        } while (i >= 0);
        m3412a();
    }

    /* renamed from: a */
    protected void m3412a() {
        this.f2735d = 1732584193;
        this.f2736e = -271733879;
        this.f2737f = -1732584194;
        this.f2738g = 271733878;
    }

    public void engineUpdate(byte b) {
        this.f2732a++;
        if (this.f2733b < 63) {
            byte[] bArr = this.f2734c;
            int i = this.f2733b;
            this.f2733b = i + 1;
            bArr[i] = b;
            return;
        }
        this.f2734c[63] = b;
        m3411a(this.f2734c, this.f2733b);
        this.f2733b = (byte) 0;
    }

    public void engineUpdate(byte[] bArr, int i, int i2) {
        if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        this.f2732a += (long) i2;
        if (this.f2733b > 0 && this.f2733b + i2 >= 64) {
            int i3 = 64 - this.f2733b;
            System.arraycopy(bArr, i, this.f2734c, this.f2733b, i3);
            byte[] bArr2 = this.f2734c;
            this.f2733b = 0;
            m3411a(bArr2, 0);
            i += i3;
            i2 -= i3;
        }
        while (i2 >= 512) {
            m3411a(bArr, i);
            m3411a(bArr, i + 64);
            m3411a(bArr, i + 128);
            m3411a(bArr, i + JfifUtil.MARKER_SOFn);
            m3411a(bArr, i + 256);
            m3411a(bArr, i + 320);
            m3411a(bArr, i + BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT);
            m3411a(bArr, i + 448);
            i += 512;
            i2 -= 512;
        }
        while (i2 >= 64) {
            m3411a(bArr, i);
            i += 64;
            i2 -= 64;
        }
        if (i2 > 0) {
            System.arraycopy(bArr, i, this.f2734c, this.f2733b, i2);
            this.f2733b += i2;
        }
    }

    public byte[] engineDigest() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r3 = this;
        r0 = 16;
        r1 = new byte[r0];	 Catch:{ DigestException -> 0x0009 }
        r2 = 0;	 Catch:{ DigestException -> 0x0009 }
        r3.engineDigest(r1, r2, r0);	 Catch:{ DigestException -> 0x0009 }
        return r1;
    L_0x0009:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplitude.a.a.engineDigest():byte[]");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int engineDigest(byte[] r13, int r14, int r15) {
        /*
        r12 = this;
        r0 = 16;
        if (r15 < r0) goto L_0x018e;
    L_0x0004:
        r15 = r13.length;
        r15 = r15 - r14;
        if (r15 < r0) goto L_0x0186;
    L_0x0008:
        r15 = r12.f2734c;
        r1 = r12.f2733b;
        r2 = -128; // 0xffffffffffffff80 float:NaN double:NaN;
        r15[r1] = r2;
        r2 = 63;
        r3 = 62;
        r4 = 61;
        r5 = 60;
        r6 = 59;
        r7 = 58;
        r8 = 57;
        r9 = 0;
        switch(r1) {
            case 56: goto L_0x0023;
            case 57: goto L_0x0025;
            case 58: goto L_0x0027;
            case 59: goto L_0x0029;
            case 60: goto L_0x002b;
            case 61: goto L_0x002d;
            case 62: goto L_0x002f;
            case 63: goto L_0x0031;
            default: goto L_0x0022;
        };
    L_0x0022:
        goto L_0x0035;
    L_0x0023:
        r15[r8] = r9;
    L_0x0025:
        r15[r7] = r9;
    L_0x0027:
        r15[r6] = r9;
    L_0x0029:
        r15[r5] = r9;
    L_0x002b:
        r15[r4] = r9;
    L_0x002d:
        r15[r3] = r9;
    L_0x002f:
        r15[r2] = r9;
    L_0x0031:
        r12.m3411a(r15, r9);
        r1 = -1;
    L_0x0035:
        r10 = r1 & 7;
        switch(r10) {
            case 0: goto L_0x009f;
            case 1: goto L_0x0086;
            case 2: goto L_0x0071;
            case 3: goto L_0x0060;
            case 4: goto L_0x0053;
            case 5: goto L_0x0048;
            case 6: goto L_0x0040;
            case 7: goto L_0x003c;
            default: goto L_0x003a;
        };
    L_0x003a:
        goto L_0x00bb;
    L_0x003c:
        r1 = r1 + -3;
        goto L_0x00bb;
    L_0x0040:
        r1 = r1 + -2;
        r10 = r1 + 3;
        r15[r10] = r9;
        goto L_0x00bb;
    L_0x0048:
        r1 = r1 + -1;
        r10 = r1 + 2;
        r15[r10] = r9;
        r10 = r1 + 3;
        r15[r10] = r9;
        goto L_0x00bb;
    L_0x0053:
        r10 = r1 + 1;
        r15[r10] = r9;
        r10 = r1 + 2;
        r15[r10] = r9;
        r10 = r1 + 3;
        r15[r10] = r9;
        goto L_0x00bb;
    L_0x0060:
        r1 = r1 + 1;
        r15[r1] = r9;
        r10 = r1 + 1;
        r15[r10] = r9;
        r10 = r1 + 2;
        r15[r10] = r9;
        r10 = r1 + 3;
        r15[r10] = r9;
        goto L_0x00bb;
    L_0x0071:
        r1 = r1 + 2;
        r10 = r1 + -1;
        r15[r10] = r9;
        r15[r1] = r9;
        r10 = r1 + 1;
        r15[r10] = r9;
        r10 = r1 + 2;
        r15[r10] = r9;
        r10 = r1 + 3;
        r15[r10] = r9;
        goto L_0x00bb;
    L_0x0086:
        r1 = r1 + 3;
        r10 = r1 + -2;
        r15[r10] = r9;
        r10 = r1 + -1;
        r15[r10] = r9;
        r15[r1] = r9;
        r10 = r1 + 1;
        r15[r10] = r9;
        r10 = r1 + 2;
        r15[r10] = r9;
        r10 = r1 + 3;
        r15[r10] = r9;
        goto L_0x00bb;
    L_0x009f:
        r1 = r1 + 4;
        r10 = r1 + -3;
        r15[r10] = r9;
        r10 = r1 + -2;
        r15[r10] = r9;
        r10 = r1 + -1;
        r15[r10] = r9;
        r15[r1] = r9;
        r10 = r1 + 1;
        r15[r10] = r9;
        r10 = r1 + 2;
        r15[r10] = r9;
        r10 = r1 + 3;
        r15[r10] = r9;
    L_0x00bb:
        r1 = r1 + 8;
        r10 = 52;
        if (r1 > r10) goto L_0x00e0;
    L_0x00c1:
        r10 = r1 + -4;
        r15[r10] = r9;
        r10 = r1 + -3;
        r15[r10] = r9;
        r10 = r1 + -2;
        r15[r10] = r9;
        r10 = r1 + -1;
        r15[r10] = r9;
        r15[r1] = r9;
        r10 = r1 + 1;
        r15[r10] = r9;
        r10 = r1 + 2;
        r15[r10] = r9;
        r10 = r1 + 3;
        r15[r10] = r9;
        goto L_0x00bb;
    L_0x00e0:
        r1 = 56;
        r10 = r12.f2732a;
        r10 = (int) r10;
        r10 = r10 << 3;
        r11 = (byte) r10;
        r15[r1] = r11;
        r1 = r10 >>> 8;
        r1 = (byte) r1;
        r15[r8] = r1;
        r1 = r10 >>> 16;
        r1 = (byte) r1;
        r15[r7] = r1;
        r1 = r10 >>> 24;
        r1 = (byte) r1;
        r15[r6] = r1;
        r6 = r12.f2732a;
        r1 = 29;
        r6 = r6 >>> r1;
        r1 = (int) r6;
        r6 = (byte) r1;
        r15[r5] = r6;
        r5 = r1 >>> 8;
        r5 = (byte) r5;
        r15[r4] = r5;
        r4 = r1 >>> 16;
        r4 = (byte) r4;
        r15[r3] = r4;
        r1 = r1 >>> 24;
        r1 = (byte) r1;
        r15[r2] = r1;
        r12.m3411a(r15, r9);
        r15 = r12.f2735d;
        r1 = (byte) r15;
        r13[r14] = r1;
        r1 = r14 + 1;
        r2 = r15 >>> 8;
        r2 = (byte) r2;
        r13[r1] = r2;
        r1 = r14 + 2;
        r2 = r15 >>> 16;
        r2 = (byte) r2;
        r13[r1] = r2;
        r1 = r14 + 3;
        r15 = r15 >>> 24;
        r15 = (byte) r15;
        r13[r1] = r15;
        r15 = r14 + 4;
        r1 = r12.f2736e;
        r2 = (byte) r1;
        r13[r15] = r2;
        r15 = r14 + 5;
        r2 = r1 >>> 8;
        r2 = (byte) r2;
        r13[r15] = r2;
        r14 = r14 + 10;
        r15 = r14 + -4;
        r2 = r1 >>> 16;
        r2 = (byte) r2;
        r13[r15] = r2;
        r15 = r14 + -3;
        r1 = r1 >>> 24;
        r1 = (byte) r1;
        r13[r15] = r1;
        r15 = r14 + -2;
        r1 = r12.f2737f;
        r2 = (byte) r1;
        r13[r15] = r2;
        r15 = r14 + -1;
        r2 = r1 >>> 8;
        r2 = (byte) r2;
        r13[r15] = r2;
        r15 = r1 >>> 16;
        r15 = (byte) r15;
        r13[r14] = r15;
        r15 = r14 + 1;
        r1 = r1 >>> 24;
        r1 = (byte) r1;
        r13[r15] = r1;
        r15 = r14 + 2;
        r1 = r12.f2738g;
        r2 = (byte) r1;
        r13[r15] = r2;
        r15 = r14 + 3;
        r2 = r1 >>> 8;
        r2 = (byte) r2;
        r13[r15] = r2;
        r15 = r14 + 4;
        r2 = r1 >>> 16;
        r2 = (byte) r2;
        r13[r15] = r2;
        r14 = r14 + 5;
        r15 = r1 >>> 24;
        r15 = (byte) r15;
        r13[r14] = r15;
        r12.engineReset();
        return r0;
    L_0x0186:
        r13 = new java.security.DigestException;
        r14 = "insufficient space in output buffer to store the digest";
        r13.<init>(r14);
        throw r13;
    L_0x018e:
        r13 = new java.security.DigestException;
        r14 = "partial digests not returned";
        r13.<init>(r14);
        throw r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplitude.a.a.engineDigest(byte[], int, int):int");
    }

    /* renamed from: a */
    private final void m3411a(byte[] bArr, int i) {
        int i2 = this.f2736e;
        int i3 = this.f2737f;
        int i4 = this.f2738g;
        int i5 = (((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) | ((bArr[i + 1] & JfifUtil.MARKER_FIRST_BYTE) << 8)) | ((bArr[i + 2] & JfifUtil.MARKER_FIRST_BYTE) << 16)) | (bArr[i + 3] << 24);
        int i6 = (((((i3 ^ i4) & i2) ^ i4) + i5) - 680876936) + this.f2735d;
        i6 = ((i6 >>> 25) | (i6 << 7)) + i2;
        int i7 = i + 10;
        int i8 = (((bArr[i + 4] & JfifUtil.MARKER_FIRST_BYTE) | ((bArr[i + 5] & JfifUtil.MARKER_FIRST_BYTE) << 8)) | ((bArr[i7 - 4] & JfifUtil.MARKER_FIRST_BYTE) << 16)) | (bArr[i7 - 3] << 24);
        int i9 = (((((i2 ^ i3) & i6) ^ i3) + i8) - 389564586) + i4;
        i4 = ((i9 << 12) | (i9 >>> 20)) + i6;
        int i10 = (((bArr[i7 - 2] & JfifUtil.MARKER_FIRST_BYTE) | ((bArr[i7 - 1] & JfifUtil.MARKER_FIRST_BYTE) << 8)) | ((bArr[i7] & JfifUtil.MARKER_FIRST_BYTE) << 16)) | (bArr[i7 + 1] << 24);
        i9 = (((((i6 ^ i2) & i4) ^ i2) + i10) + 606105819) + i3;
        i3 = ((i9 << 17) | (i9 >>> 15)) + i4;
        int i11 = (((bArr[i7 + 2] & JfifUtil.MARKER_FIRST_BYTE) | ((bArr[i7 + 3] & JfifUtil.MARKER_FIRST_BYTE) << 8)) | ((bArr[i7 + 4] & JfifUtil.MARKER_FIRST_BYTE) << 16)) | (bArr[i7 + 5] << 24);
        i9 = (((((i4 ^ i6) & i3) ^ i6) + i11) - 1044525330) + i2;
        i9 = ((i9 >>> 10) | (i9 << 22)) + i3;
        i7 += 10;
        int i12 = (((bArr[i7 - 4] & JfifUtil.MARKER_FIRST_BYTE) | ((bArr[i7 - 3] & JfifUtil.MARKER_FIRST_BYTE) << 8)) | ((bArr[i7 - 2] & JfifUtil.MARKER_FIRST_BYTE) << 16)) | (bArr[i7 - 1] << 24);
        int i13 = (((((i3 ^ i4) & i9) ^ i4) + i12) - 176418897) + i6;
        i6 = ((i13 << 7) | (i13 >>> 25)) + i9;
        int i14 = (((bArr[i7] & JfifUtil.MARKER_FIRST_BYTE) | ((bArr[i7 + 1] & JfifUtil.MARKER_FIRST_BYTE) << 8)) | ((bArr[i7 + 2] & JfifUtil.MARKER_FIRST_BYTE) << 16)) | (bArr[i7 + 3] << 24);
        i13 = (((((i9 ^ i3) & i6) ^ i3) + i14) + 1200080426) + i4;
        i4 = ((i13 << 12) | (i13 >>> 20)) + i6;
        int i15 = bArr[i7 + 4] & JfifUtil.MARKER_FIRST_BYTE;
        i7 += 10;
        int i16 = ((((bArr[i7 + 5] & JfifUtil.MARKER_FIRST_BYTE) << 8) | i15) | ((bArr[i7 - 4] & JfifUtil.MARKER_FIRST_BYTE) << 16)) | (bArr[i7 - 3] << 24);
        i13 = (((((i6 ^ i9) & i4) ^ i9) + i16) - 1473231341) + i3;
        i3 = ((i13 << 17) | (i13 >>> 15)) + i4;
        int i17 = i2;
        i2 = ((((bArr[i7 - 1] & JfifUtil.MARKER_FIRST_BYTE) << 8) | (bArr[i7 - 2] & JfifUtil.MARKER_FIRST_BYTE)) | ((bArr[i7] & JfifUtil.MARKER_FIRST_BYTE) << 16)) | (bArr[i7 + 1] << 24);
        i13 = (((((i4 ^ i6) & i3) ^ i6) + i2) - 45705983) + i9;
        i9 = ((i13 << 22) | (i13 >>> 10)) + i3;
        int i18 = i2;
        i2 = ((((bArr[i7 + 3] & JfifUtil.MARKER_FIRST_BYTE) << 8) | (bArr[i7 + 2] & JfifUtil.MARKER_FIRST_BYTE)) | ((bArr[i7 + 4] & JfifUtil.MARKER_FIRST_BYTE) << 16)) | (bArr[i7 + 5] << 24);
        i13 = (((((i3 ^ i4) & i9) ^ i4) + i2) + 1770035416) + i6;
        i6 = ((i13 << 7) | (i13 >>> 25)) + i9;
        i7 += 10;
        int i19 = i10;
        i10 = ((((bArr[i7 - 3] & JfifUtil.MARKER_FIRST_BYTE) << 8) | (bArr[i7 - 4] & JfifUtil.MARKER_FIRST_BYTE)) | ((bArr[i7 - 2] & JfifUtil.MARKER_FIRST_BYTE) << 16)) | (bArr[i7 - 1] << 24);
        i13 = (((((i9 ^ i3) & i6) ^ i3) + i10) - 1958414417) + i4;
        i4 = ((i13 << 12) | (i13 >>> 20)) + i6;
        int i20 = i2;
        i2 = ((((bArr[i7 + 1] & JfifUtil.MARKER_FIRST_BYTE) << 8) | (bArr[i7] & JfifUtil.MARKER_FIRST_BYTE)) | ((bArr[i7 + 2] & JfifUtil.MARKER_FIRST_BYTE) << 16)) | (bArr[i7 + 3] << 24);
        i13 = (((((i6 ^ i9) & i4) ^ i9) + i2) - 42063) + i3;
        i3 = ((i13 << 17) | (i13 >>> 15)) + i4;
        i15 = bArr[i7 + 4] & JfifUtil.MARKER_FIRST_BYTE;
        int i21 = i11;
        i7 += 10;
        i11 = ((((bArr[i7 + 5] & JfifUtil.MARKER_FIRST_BYTE) << 8) | i15) | ((bArr[i7 - 4] & JfifUtil.MARKER_FIRST_BYTE) << 16)) | (bArr[i7 - 3] << 24);
        i13 = (((((i4 ^ i6) & i3) ^ i6) + i11) - 1990404162) + i9;
        i9 = ((i13 << 22) | (i13 >>> 10)) + i3;
        int i22 = i10;
        i10 = ((((bArr[i7 - 1] & JfifUtil.MARKER_FIRST_BYTE) << 8) | (bArr[i7 - 2] & JfifUtil.MARKER_FIRST_BYTE)) | ((bArr[i7] & JfifUtil.MARKER_FIRST_BYTE) << 16)) | (bArr[i7 + 1] << 24);
        i13 = (((((i3 ^ i4) & i9) ^ i4) + i10) + 1804603682) + i6;
        i6 = ((i13 << 7) | (i13 >>> 25)) + i9;
        int i23 = i10;
        i10 = ((((bArr[i7 + 3] & JfifUtil.MARKER_FIRST_BYTE) << 8) | (bArr[i7 + 2] & JfifUtil.MARKER_FIRST_BYTE)) | ((bArr[i7 + 4] & JfifUtil.MARKER_FIRST_BYTE) << 16)) | (bArr[i7 + 5] << 24);
        i13 = (((((i9 ^ i3) & i6) ^ i3) + i10) - 40341101) + i4;
        i4 = ((i13 << 12) | (i13 >>> 20)) + i6;
        i7 += 10;
        int i24 = i10;
        i10 = ((((bArr[i7 - 3] & JfifUtil.MARKER_FIRST_BYTE) << 8) | (bArr[i7 - 4] & JfifUtil.MARKER_FIRST_BYTE)) | ((bArr[i7 - 2] & JfifUtil.MARKER_FIRST_BYTE) << 16)) | (bArr[i7 - 1] << 24);
        i13 = (((((i6 ^ i9) & i4) ^ i9) + i10) - 1502002290) + i3;
        i3 = ((i13 << 17) | (i13 >>> 15)) + i4;
        int i25 = i10;
        int i26 = (bArr[i7 + 3] << 24) | ((((bArr[i7 + 1] & JfifUtil.MARKER_FIRST_BYTE) << 8) | (bArr[i7] & JfifUtil.MARKER_FIRST_BYTE)) | ((bArr[i7 + 2] & JfifUtil.MARKER_FIRST_BYTE) << 16));
        i13 = (((((i4 ^ i6) & i3) ^ i6) + i26) + 1236535329) + i9;
        i7 = ((i13 << 22) | (i13 >>> 10)) + i3;
        i9 = (((((i3 ^ i7) & i4) ^ i3) + i8) - 165796510) + i6;
        i6 = ((i9 << 5) | (i9 >>> 27)) + i7;
        i9 = (((((i7 ^ i6) & i3) ^ i7) + i16) - 1069501632) + i4;
        i4 = ((i9 << 9) | (i9 >>> 23)) + i6;
        i9 = (((((i6 ^ i4) & i7) ^ i6) + i11) + 643717713) + i3;
        i3 = ((i9 << 14) | (i9 >>> 18)) + i4;
        i9 = (((((i4 ^ i3) & i6) ^ i4) + i5) - 373897302) + i7;
        i7 = ((i9 << 20) | (i9 >>> 12)) + i3;
        i9 = (((((i3 ^ i7) & i4) ^ i3) + i14) - 701558691) + i6;
        i6 = ((i9 << 5) | (i9 >>> 27)) + i7;
        i9 = (((((i7 ^ i6) & i3) ^ i7) + i2) + 38016083) + i4;
        i4 = ((i9 << 9) | (i9 >>> 23)) + i6;
        i9 = (((((i6 ^ i4) & i7) ^ i6) + i26) - 660478335) + i3;
        i3 = ((i9 << 14) | (i9 >>> 18)) + i4;
        i9 = (((((i4 ^ i3) & i6) ^ i4) + i12) - 405537848) + i7;
        i7 = ((i9 << 20) | (i9 >>> 12)) + i3;
        i9 = (((((i3 ^ i7) & i4) ^ i3) + i22) + 568446438) + i6;
        i6 = ((i9 << 5) | (i9 >>> 27)) + i7;
        i9 = (((((i7 ^ i6) & i3) ^ i7) + i25) - 1019803690) + i4;
        i4 = ((i9 << 9) | (i9 >>> 23)) + i6;
        i9 = (((((i6 ^ i4) & i7) ^ i6) + i21) - 187363961) + i3;
        i3 = ((i9 << 14) | (i9 >>> 18)) + i4;
        i9 = (((((i4 ^ i3) & i6) ^ i4) + i20) + 1163531501) + i7;
        i7 = ((i9 << 20) | (i9 >>> 12)) + i3;
        i9 = (((((i3 ^ i7) & i4) ^ i3) + i24) - 1444681467) + i6;
        i6 = ((i9 << 5) | (i9 >>> 27)) + i7;
        i9 = (((((i7 ^ i6) & i3) ^ i7) + i19) - 51403784) + i4;
        i4 = ((i9 << 9) | (i9 >>> 23)) + i6;
        i9 = (((((i6 ^ i4) & i7) ^ i6) + i18) + 1735328473) + i3;
        i3 = ((i9 << 14) | (i9 >>> 18)) + i4;
        i9 = (((((i4 ^ i3) & i6) ^ i4) + i23) - 1926607734) + i7;
        i7 = ((i9 << 20) | (i9 >>> 12)) + i3;
        i9 = ((((i3 ^ i7) ^ i4) + i14) - 378558) + i6;
        i6 = ((i9 << 4) | (i9 >>> 28)) + i7;
        i9 = ((((i7 ^ i6) ^ i3) + i20) - 2022574463) + i4;
        i4 = ((i9 << 11) | (i9 >>> 21)) + i6;
        i9 = ((((i6 ^ i4) ^ i7) + i11) + 1839030562) + i3;
        i3 = ((i9 << 16) | (i9 >>> 16)) + i4;
        i9 = ((((i4 ^ i3) ^ i6) + i25) - 35309556) + i7;
        i7 = ((i9 << 23) | (i9 >>> 9)) + i3;
        i9 = ((((i3 ^ i7) ^ i4) + i8) - 1530992060) + i6;
        i6 = ((i9 << 4) | (i9 >>> 28)) + i7;
        i9 = ((((i7 ^ i6) ^ i3) + i12) + 1272893353) + i4;
        i4 = ((i9 << 11) | (i9 >>> 21)) + i6;
        i9 = ((((i6 ^ i4) ^ i7) + i18) - 155497632) + i3;
        i3 = ((i9 << 16) | (i9 >>> 16)) + i4;
        i9 = ((((i4 ^ i3) ^ i6) + i2) - 1094730640) + i7;
        i7 = ((i9 << 23) | (i9 >>> 9)) + i3;
        i9 = ((((i3 ^ i7) ^ i4) + i24) + 681279174) + i6;
        i6 = ((i9 << 4) | (i9 >>> 28)) + i7;
        i9 = ((((i7 ^ i6) ^ i3) + i5) - 358537222) + i4;
        i4 = ((i9 << 11) | (i9 >>> 21)) + i6;
        i9 = ((((i6 ^ i4) ^ i7) + i21) - 722521979) + i3;
        i3 = ((i9 << 16) | (i9 >>> 16)) + i4;
        i9 = ((((i4 ^ i3) ^ i6) + i16) + 76029189) + i7;
        i7 = ((i9 << 23) | (i9 >>> 9)) + i3;
        i9 = ((((i3 ^ i7) ^ i4) + i22) - 640364487) + i6;
        i6 = ((i9 << 4) | (i9 >>> 28)) + i7;
        i9 = ((((i7 ^ i6) ^ i3) + i23) - 421815835) + i4;
        i4 = ((i9 << 11) | (i9 >>> 21)) + i6;
        i9 = ((((i6 ^ i4) ^ i7) + i26) + 530742520) + i3;
        i3 = ((i9 << 16) | (i9 >>> 16)) + i4;
        i9 = ((((i4 ^ i3) ^ i6) + i19) - 995338651) + i7;
        i7 = ((i9 << 23) | (i9 >>> 9)) + i3;
        i9 = (((((~i4) | i7) ^ i3) + i5) - 198630844) + i6;
        i6 = ((i9 << 6) | (i9 >>> 26)) + i7;
        i5 = (((((~i3) | i6) ^ i7) + i18) + 1126891415) + i4;
        i4 = ((i5 << 10) | (i5 >>> 22)) + i6;
        i5 = (((((~i7) | i4) ^ i6) + i25) - 1416354905) + i3;
        i3 = ((i5 << 15) | (i5 >>> 17)) + i4;
        i5 = (((((~i6) | i3) ^ i4) + i14) - 57434055) + i7;
        i7 = ((i5 << 21) | (i5 >>> 11)) + i3;
        i5 = (((((~i4) | i7) ^ i3) + i23) + 1700485571) + i6;
        i6 = ((i5 << 6) | (i5 >>> 26)) + i7;
        i5 = (((((~i3) | i6) ^ i7) + i21) - 1894986606) + i4;
        i4 = ((i5 << 10) | (i5 >>> 22)) + i6;
        i5 = (((((~i7) | i4) ^ i6) + i2) - 1051523) + i3;
        i2 = ((i5 << 15) | (i5 >>> 17)) + i4;
        i3 = (((((~i6) | i2) ^ i4) + i8) - 2054922799) + i7;
        i7 = ((i3 << 21) | (i3 >>> 11)) + i2;
        i3 = (((((~i4) | i7) ^ i2) + i20) + 1873313359) + i6;
        i3 = ((i3 >>> 26) | (i3 << 6)) + i7;
        i6 = (((((~i2) | i3) ^ i7) + i26) - 30611744) + i4;
        i26 = ((i6 << 10) | (i6 >>> 22)) + i3;
        i4 = (((((~i7) | i26) ^ i3) + i16) - 1560198380) + i2;
        i16 = ((i4 << 15) | (i4 >>> 17)) + i26;
        i2 = (((((~i3) | i16) ^ i26) + i24) + 1309151649) + i7;
        i7 = ((i2 << 21) | (i2 >>> 11)) + i16;
        i2 = (((((~i26) | i7) ^ i16) + i12) - 145523070) + i3;
        i2 = ((i2 >>> 26) | (i2 << 6)) + i7;
        i3 = (((((~i16) | i2) ^ i7) + i11) - 1120210379) + i26;
        i26 = ((i3 << 10) | (i3 >>> 22)) + i2;
        i3 = (((((~i7) | i26) ^ i2) + i19) + 718787259) + i16;
        i16 = ((i3 << 15) | (i3 >>> 17)) + i26;
        i4 = (((((~i2) | i16) ^ i26) + i22) - 343485551) + i7;
        this.f2736e = (i17 + i16) + ((i4 << 21) | (i4 >>> 11));
        this.f2737f += i16;
        this.f2738g += i26;
        this.f2735d += i2;
    }
}
