package com.facebook.ads.internal.p105q.p107b;

import com.facebook.imageutils.JfifUtil;
import java.util.concurrent.Callable;

/* renamed from: com.facebook.ads.internal.q.b.d */
class C3608d implements C1526a {
    /* renamed from: a */
    private static final short[] f9620a = new short[]{(short) 512, (short) 512, (short) 456, (short) 512, (short) 328, (short) 456, (short) 335, (short) 512, (short) 405, (short) 328, (short) 271, (short) 456, (short) 388, (short) 335, (short) 292, (short) 512, (short) 454, (short) 405, (short) 364, (short) 328, (short) 298, (short) 271, (short) 496, (short) 456, (short) 420, (short) 388, (short) 360, (short) 335, (short) 312, (short) 292, (short) 273, (short) 512, (short) 482, (short) 454, (short) 428, (short) 405, (short) 383, (short) 364, (short) 345, (short) 328, (short) 312, (short) 298, (short) 284, (short) 271, (short) 259, (short) 496, (short) 475, (short) 456, (short) 437, (short) 420, (short) 404, (short) 388, (short) 374, (short) 360, (short) 347, (short) 335, (short) 323, (short) 312, (short) 302, (short) 292, (short) 282, (short) 273, (short) 265, (short) 512, (short) 497, (short) 482, (short) 468, (short) 454, (short) 441, (short) 428, (short) 417, (short) 405, (short) 394, (short) 383, (short) 373, (short) 364, (short) 354, (short) 345, (short) 337, (short) 328, (short) 320, (short) 312, (short) 305, (short) 298, (short) 291, (short) 284, (short) 278, (short) 271, (short) 265, (short) 259, (short) 507, (short) 496, (short) 485, (short) 475, (short) 465, (short) 456, (short) 446, (short) 437, (short) 428, (short) 420, (short) 412, (short) 404, (short) 396, (short) 388, (short) 381, (short) 374, (short) 367, (short) 360, (short) 354, (short) 347, (short) 341, (short) 335, (short) 329, (short) 323, (short) 318, (short) 312, (short) 307, (short) 302, (short) 297, (short) 292, (short) 287, (short) 282, (short) 278, (short) 273, (short) 269, (short) 265, (short) 261, (short) 512, (short) 505, (short) 497, (short) 489, (short) 482, (short) 475, (short) 468, (short) 461, (short) 454, (short) 447, (short) 441, (short) 435, (short) 428, (short) 422, (short) 417, (short) 411, (short) 405, (short) 399, (short) 394, (short) 389, (short) 383, (short) 378, (short) 373, (short) 368, (short) 364, (short) 359, (short) 354, (short) 350, (short) 345, (short) 341, (short) 337, (short) 332, (short) 328, (short) 324, (short) 320, (short) 316, (short) 312, (short) 309, (short) 305, (short) 301, (short) 298, (short) 294, (short) 291, (short) 287, (short) 284, (short) 281, (short) 278, (short) 274, (short) 271, (short) 268, (short) 265, (short) 262, (short) 259, (short) 257, (short) 507, (short) 501, (short) 496, (short) 491, (short) 485, (short) 480, (short) 475, (short) 470, (short) 465, (short) 460, (short) 456, (short) 451, (short) 446, (short) 442, (short) 437, (short) 433, (short) 428, (short) 424, (short) 420, (short) 416, (short) 412, (short) 408, (short) 404, (short) 400, (short) 396, (short) 392, (short) 388, (short) 385, (short) 381, (short) 377, (short) 374, (short) 370, (short) 367, (short) 363, (short) 360, (short) 357, (short) 354, (short) 350, (short) 347, (short) 344, (short) 341, (short) 338, (short) 335, (short) 332, (short) 329, (short) 326, (short) 323, (short) 320, (short) 318, (short) 315, (short) 312, (short) 310, (short) 307, (short) 304, (short) 302, (short) 299, (short) 297, (short) 294, (short) 292, (short) 289, (short) 287, (short) 285, (short) 282, (short) 280, (short) 278, (short) 275, (short) 273, (short) 271, (short) 269, (short) 267, (short) 265, (short) 263, (short) 261, (short) 259};
    /* renamed from: b */
    private static final byte[] f9621b = new byte[]{(byte) 9, (byte) 11, (byte) 12, (byte) 13, (byte) 13, (byte) 14, (byte) 14, (byte) 15, (byte) 15, (byte) 15, (byte) 15, (byte) 16, (byte) 16, (byte) 16, (byte) 16, (byte) 17, (byte) 17, (byte) 17, (byte) 17, (byte) 17, (byte) 17, (byte) 17, (byte) 18, (byte) 18, (byte) 18, (byte) 18, (byte) 18, (byte) 18, (byte) 18, (byte) 18, (byte) 18, (byte) 19, (byte) 19, (byte) 19, (byte) 19, (byte) 19, (byte) 19, (byte) 19, (byte) 19, (byte) 19, (byte) 19, (byte) 19, (byte) 19, (byte) 19, (byte) 19, (byte) 20, (byte) 20, (byte) 20, (byte) 20, (byte) 20, (byte) 20, (byte) 20, (byte) 20, (byte) 20, (byte) 20, (byte) 20, (byte) 20, (byte) 20, (byte) 20, (byte) 20, (byte) 20, (byte) 20, (byte) 20, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24};

    /* renamed from: com.facebook.ads.internal.q.b.d$a */
    private static class C1529a implements Callable<Void> {
        /* renamed from: a */
        private final int[] f4522a;
        /* renamed from: b */
        private final int f4523b;
        /* renamed from: c */
        private final int f4524c;
        /* renamed from: d */
        private final int f4525d;
        /* renamed from: e */
        private final int f4526e;
        /* renamed from: f */
        private final int f4527f;
        /* renamed from: g */
        private final int f4528g;

        public C1529a(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6) {
            this.f4522a = iArr;
            this.f4523b = i;
            this.f4524c = i2;
            this.f4525d = i3;
            this.f4526e = i4;
            this.f4527f = i5;
            this.f4528g = i6;
        }

        /* renamed from: a */
        public Void m5358a() {
            C3608d.m11765b(this.f4522a, this.f4523b, this.f4524c, this.f4525d, this.f4526e, this.f4527f, this.f4528g);
            return null;
        }

        public /* synthetic */ Object call() {
            return m5358a();
        }
    }

    C3608d() {
    }

    /* renamed from: b */
    private static void m11765b(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i6;
        int i11 = i7 - 1;
        int i12 = i8 - 1;
        int i13 = (i9 * 2) + 1;
        short s = f9620a[i9];
        byte b = f9621b[i9];
        int[] iArr2 = new int[i13];
        int i14;
        int i15;
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        int i16;
        int i17;
        if (i10 == 1) {
            i10 = (i5 * i8) / i4;
            i14 = ((i5 + 1) * i8) / i4;
            while (i10 < i14) {
                int i18;
                i8 = i7 * i10;
                i15 = 0;
                j = 0;
                j2 = 0;
                j3 = 0;
                j4 = 0;
                j5 = 0;
                j6 = 0;
                while (i15 <= i9) {
                    iArr2[i15] = iArr[i8];
                    i15++;
                    j += (long) (((iArr[i8] >>> 16) & JfifUtil.MARKER_FIRST_BYTE) * i15);
                    j2 += (long) (((iArr[i8] >>> 8) & JfifUtil.MARKER_FIRST_BYTE) * i15);
                    j3 += (long) ((iArr[i8] & JfifUtil.MARKER_FIRST_BYTE) * i15);
                    j4 += (long) ((iArr[i8] >>> 16) & JfifUtil.MARKER_FIRST_BYTE);
                    j5 += (long) ((iArr[i8] >>> 8) & JfifUtil.MARKER_FIRST_BYTE);
                    j6 += (long) (iArr[i8] & JfifUtil.MARKER_FIRST_BYTE);
                    s = s;
                }
                short s2 = s;
                i12 = i8;
                long j9 = 0;
                j7 = 0;
                long j10 = 0;
                for (i15 = 1; i15 <= i9; i15++) {
                    if (i15 <= i11) {
                        i12++;
                    }
                    iArr2[i15 + i9] = iArr[i12];
                    int i19 = (i9 + 1) - i15;
                    j += (long) (((iArr[i12] >>> 16) & JfifUtil.MARKER_FIRST_BYTE) * i19);
                    j2 += (long) (((iArr[i12] >>> 8) & JfifUtil.MARKER_FIRST_BYTE) * i19);
                    j3 += (long) ((iArr[i12] & JfifUtil.MARKER_FIRST_BYTE) * i19);
                    j9 += (long) ((iArr[i12] >>> 16) & JfifUtil.MARKER_FIRST_BYTE);
                    j7 += (long) ((iArr[i12] >>> 8) & JfifUtil.MARKER_FIRST_BYTE);
                    j10 += (long) (iArr[i12] & JfifUtil.MARKER_FIRST_BYTE);
                }
                i15 = i9 > i11 ? i11 : i9;
                j8 = j9;
                i16 = i15;
                i17 = i15 + i8;
                i15 = i8;
                i12 = i9;
                i8 = 0;
                while (i8 < i7) {
                    i18 = i14;
                    int i20 = i10;
                    long j11 = j8;
                    short s3 = s2;
                    j8 = (long) s3;
                    iArr[i15] = (int) (((((long) (iArr[i15] & -16777216)) | ((((j * j8) >>> b) & 255) << 16)) | ((((j2 * j8) >>> b) & 255) << 8)) | (((j8 * j3) >>> b) & 255));
                    i15++;
                    j -= j4;
                    j2 -= j5;
                    j3 -= j6;
                    i14 = (i12 + i13) - i9;
                    if (i14 >= i13) {
                        i14 -= i13;
                    }
                    j4 -= (long) ((iArr2[i14] >>> 16) & JfifUtil.MARKER_FIRST_BYTE);
                    j5 -= (long) ((iArr2[i14] >>> 8) & JfifUtil.MARKER_FIRST_BYTE);
                    j6 -= (long) (iArr2[i14] & JfifUtil.MARKER_FIRST_BYTE);
                    if (i16 < i11) {
                        i17++;
                        i16++;
                    }
                    iArr2[i14] = iArr[i17];
                    j8 = j11 + ((long) ((iArr[i17] >>> 16) & JfifUtil.MARKER_FIRST_BYTE));
                    j7 += (long) ((iArr[i17] >>> 8) & JfifUtil.MARKER_FIRST_BYTE);
                    j10 += (long) (iArr[i17] & JfifUtil.MARKER_FIRST_BYTE);
                    j += j8;
                    j2 += j7;
                    j3 += j10;
                    i12++;
                    if (i12 >= i13) {
                        i12 = 0;
                    }
                    j4 += (long) ((iArr2[i12] >>> 16) & JfifUtil.MARKER_FIRST_BYTE);
                    j5 += (long) ((iArr2[i12] >>> 8) & JfifUtil.MARKER_FIRST_BYTE);
                    j6 += (long) (iArr2[i12] & JfifUtil.MARKER_FIRST_BYTE);
                    j8 -= (long) ((iArr2[i12] >>> 16) & JfifUtil.MARKER_FIRST_BYTE);
                    j7 -= (long) ((iArr2[i12] >>> 8) & JfifUtil.MARKER_FIRST_BYTE);
                    j10 -= (long) (iArr2[i12] & JfifUtil.MARKER_FIRST_BYTE);
                    i8++;
                    s2 = s3;
                    i14 = i18;
                    i10 = i20;
                    i7 = i;
                }
                i18 = i14;
                i10++;
                s = s2;
                i7 = i;
            }
            return;
        }
        s3 = s;
        if (i10 == 2) {
            short s4 = s3;
            i7 = i;
            i11 = (i5 * i7) / i4;
            i14 = ((i5 + 1) * i7) / i4;
            while (i11 < i14) {
                int i21;
                i15 = 0;
                j8 = 0;
                j = 0;
                j2 = 0;
                j3 = 0;
                j4 = 0;
                j5 = 0;
                while (i15 <= i9) {
                    iArr2[i15] = iArr[i11];
                    i15++;
                    j8 += (long) (((iArr[i11] >>> 16) & JfifUtil.MARKER_FIRST_BYTE) * i15);
                    j += (long) (((iArr[i11] >>> 8) & JfifUtil.MARKER_FIRST_BYTE) * i15);
                    j2 += (long) ((iArr[i11] & JfifUtil.MARKER_FIRST_BYTE) * i15);
                    j3 += (long) ((iArr[i11] >>> 16) & JfifUtil.MARKER_FIRST_BYTE);
                    j4 += (long) ((iArr[i11] >>> 8) & JfifUtil.MARKER_FIRST_BYTE);
                    j5 += (long) (iArr[i11] & JfifUtil.MARKER_FIRST_BYTE);
                }
                i16 = i11;
                i15 = 1;
                j6 = 0;
                long j12 = 0;
                j7 = 0;
                while (i15 <= i9) {
                    if (i15 <= i12) {
                        i16 += i7;
                    }
                    iArr2[i15 + i9] = iArr[i16];
                    i19 = (i9 + 1) - i15;
                    j8 += (long) (((iArr[i16] >>> 16) & JfifUtil.MARKER_FIRST_BYTE) * i19);
                    j += (long) (((iArr[i16] >>> 8) & JfifUtil.MARKER_FIRST_BYTE) * i19);
                    j2 += (long) ((iArr[i16] & JfifUtil.MARKER_FIRST_BYTE) * i19);
                    j6 += (long) ((iArr[i16] >>> 16) & JfifUtil.MARKER_FIRST_BYTE);
                    j12 += (long) ((iArr[i16] >>> 8) & JfifUtil.MARKER_FIRST_BYTE);
                    j7 += (long) (iArr[i16] & JfifUtil.MARKER_FIRST_BYTE);
                    i15++;
                    b = b;
                }
                byte b2 = b;
                i15 = i9 > i12 ? i12 : i9;
                i17 = i9;
                int i22 = i15;
                i19 = (i15 * i7) + i11;
                i15 = 0;
                i16 = i11;
                while (i15 < i8) {
                    int i23 = i15;
                    i21 = i14;
                    int i24 = i11;
                    int i25 = i12;
                    long j13 = (long) s4;
                    iArr[i16] = (int) (((((long) (iArr[i16] & -16777216)) | ((((j8 * j13) >>> b2) & 255) << 16)) | ((((j * j13) >>> b2) & 255) << 8)) | (((j13 * j2) >>> b2) & 255));
                    i16 += i7;
                    j8 -= j3;
                    j -= j4;
                    j2 -= j5;
                    i8 = (i17 + i13) - i9;
                    if (i8 >= i13) {
                        i8 -= i13;
                    }
                    j3 -= (long) ((iArr2[i8] >>> 16) & JfifUtil.MARKER_FIRST_BYTE);
                    j4 -= (long) ((iArr2[i8] >>> 8) & JfifUtil.MARKER_FIRST_BYTE);
                    j5 -= (long) (iArr2[i8] & JfifUtil.MARKER_FIRST_BYTE);
                    i15 = i25;
                    if (i22 < i15) {
                        i19 += i7;
                        i22++;
                    }
                    iArr2[i8] = iArr[i19];
                    j6 += (long) ((iArr[i19] >>> 16) & JfifUtil.MARKER_FIRST_BYTE);
                    j12 += (long) ((iArr[i19] >>> 8) & JfifUtil.MARKER_FIRST_BYTE);
                    j7 += (long) (iArr[i19] & JfifUtil.MARKER_FIRST_BYTE);
                    j8 += j6;
                    j += j12;
                    j2 += j7;
                    i17++;
                    if (i17 >= i13) {
                        i17 = 0;
                    }
                    j3 += (long) ((iArr2[i17] >>> 16) & JfifUtil.MARKER_FIRST_BYTE);
                    j4 += (long) ((iArr2[i17] >>> 8) & JfifUtil.MARKER_FIRST_BYTE);
                    j5 += (long) (iArr2[i17] & JfifUtil.MARKER_FIRST_BYTE);
                    j6 -= (long) ((iArr2[i17] >>> 16) & JfifUtil.MARKER_FIRST_BYTE);
                    j12 -= (long) ((iArr2[i17] >>> 8) & JfifUtil.MARKER_FIRST_BYTE);
                    j7 -= (long) (iArr2[i17] & JfifUtil.MARKER_FIRST_BYTE);
                    i12 = i15;
                    i14 = i21;
                    i11 = i24;
                    i15 = i23 + 1;
                    i8 = i2;
                }
                i21 = i14;
                i15 = i12;
                i11++;
                b = b2;
                i8 = i2;
            }
        }
    }

    /* renamed from: a */
    public android.graphics.Bitmap mo996a(android.graphics.Bitmap r19, float r20) {
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
        r18 = this;
        r8 = r19.getWidth();
        r9 = r19.getHeight();
        r0 = r8 * r9;
        r11 = new int[r0];	 Catch:{ OutOfMemoryError -> 0x0067 }
        r2 = 0;
        r4 = 0;
        r5 = 0;
        r0 = r19;
        r1 = r11;
        r3 = r8;
        r6 = r8;
        r7 = r9;
        r0.getPixels(r1, r2, r3, r4, r5, r6, r7);
        r12 = com.facebook.ads.internal.p105q.p107b.C1530e.f4529a;
        r13 = new java.util.ArrayList;
        r13.<init>(r12);
        r14 = new java.util.ArrayList;
        r14.<init>(r12);
        r0 = 0;
        r15 = 0;
    L_0x0026:
        if (r15 >= r12) goto L_0x0050;
    L_0x0028:
        r7 = new com.facebook.ads.internal.q.b.d$a;
        r6 = r20;
        r5 = (int) r6;
        r16 = 1;
        r0 = r7;
        r1 = r11;
        r2 = r8;
        r3 = r9;
        r4 = r5;
        r17 = r5;
        r5 = r12;
        r6 = r15;
        r10 = r7;
        r7 = r16;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r13.add(r10);
        r10 = new com.facebook.ads.internal.q.b.d$a;
        r7 = 2;
        r0 = r10;
        r4 = r17;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r14.add(r10);
        r15 = r15 + 1;
        goto L_0x0026;
    L_0x0050:
        r0 = com.facebook.ads.internal.p105q.p107b.C1530e.f4530b;	 Catch:{ InterruptedException -> 0x0065 }
        r0.invokeAll(r13);	 Catch:{ InterruptedException -> 0x0065 }
        r0 = com.facebook.ads.internal.p105q.p107b.C1530e.f4530b;	 Catch:{ InterruptedException -> 0x0063 }
        r0.invokeAll(r14);	 Catch:{ InterruptedException -> 0x0063 }
        r0 = android.graphics.Bitmap.Config.ARGB_8888;	 Catch:{ OutOfMemoryError -> 0x0061 }
        r0 = android.graphics.Bitmap.createBitmap(r11, r8, r9, r0);	 Catch:{ OutOfMemoryError -> 0x0061 }
        return r0;
    L_0x0061:
        r0 = 0;
        return r0;
    L_0x0063:
        r0 = 0;
        return r0;
    L_0x0065:
        r0 = 0;
        return r0;
    L_0x0067:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.q.b.d.a(android.graphics.Bitmap, float):android.graphics.Bitmap");
    }
}
