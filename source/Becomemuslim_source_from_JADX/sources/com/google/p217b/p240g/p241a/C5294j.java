package com.google.p217b.p240g.p241a;

import com.google.p217b.p222b.C5202b;

/* compiled from: Version */
/* renamed from: com.google.b.g.a.j */
public final class C5294j {
    /* renamed from: a */
    private static final int[] f17880a = new int[]{31892, 34236, 39577, 42195, 48118, 51042, 55367, 58893, 63784, 68472, 70749, 76311, 79154, 84390, 87683, 92361, 96236, 102084, 102881, 110507, 110734, 117786, 119615, 126325, 127568, 133589, 136944, 141498, 145311, 150283, 152622, 158308, 161089, 167017};
    /* renamed from: b */
    private static final C5294j[] f17881b = C5294j.m22458f();
    /* renamed from: c */
    private final int f17882c;
    /* renamed from: d */
    private final int[] f17883d;
    /* renamed from: e */
    private final C5293b[] f17884e;
    /* renamed from: f */
    private final int f17885f;

    /* compiled from: Version */
    /* renamed from: com.google.b.g.a.j$a */
    public static final class C5292a {
        /* renamed from: a */
        private final int f17876a;
        /* renamed from: b */
        private final int f17877b;

        C5292a(int i, int i2) {
            this.f17876a = i;
            this.f17877b = i2;
        }

        /* renamed from: a */
        public int m22449a() {
            return this.f17876a;
        }

        /* renamed from: b */
        public int m22450b() {
            return this.f17877b;
        }
    }

    /* compiled from: Version */
    /* renamed from: com.google.b.g.a.j$b */
    public static final class C5293b {
        /* renamed from: a */
        private final int f17878a;
        /* renamed from: b */
        private final C5292a[] f17879b;

        C5293b(int i, C5292a... c5292aArr) {
            this.f17878a = i;
            this.f17879b = c5292aArr;
        }

        /* renamed from: a */
        public int m22451a() {
            return this.f17878a;
        }

        /* renamed from: b */
        public int m22452b() {
            int i = 0;
            for (C5292a a : this.f17879b) {
                i += a.m22449a();
            }
            return i;
        }

        /* renamed from: c */
        public int m22453c() {
            return this.f17878a * m22452b();
        }

        /* renamed from: d */
        public C5292a[] m22454d() {
            return this.f17879b;
        }
    }

    private C5294j(int i, int[] iArr, C5293b... c5293bArr) {
        this.f17882c = i;
        this.f17883d = iArr;
        this.f17884e = c5293bArr;
        i = 0;
        iArr = c5293bArr[0].m22451a();
        c5293bArr = c5293bArr[0].m22454d();
        int length = c5293bArr.length;
        int i2 = 0;
        while (i < length) {
            C5292a c5292a = c5293bArr[i];
            i2 += c5292a.m22449a() * (c5292a.m22450b() + iArr);
            i++;
        }
        this.f17885f = i2;
    }

    /* renamed from: a */
    public int m22459a() {
        return this.f17882c;
    }

    /* renamed from: b */
    public int[] m22461b() {
        return this.f17883d;
    }

    /* renamed from: c */
    public int m22462c() {
        return this.f17885f;
    }

    /* renamed from: d */
    public int m22463d() {
        return (this.f17882c * 4) + 17;
    }

    /* renamed from: a */
    public C5293b m22460a(C5288f c5288f) {
        return this.f17884e[c5288f.ordinal()];
    }

    /* renamed from: a */
    public static com.google.p217b.p240g.p241a.C5294j m22455a(int r2) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = r2 % 4;
        r1 = 1;
        if (r0 != r1) goto L_0x0013;
    L_0x0005:
        r2 = r2 + -17;
        r2 = r2 / 4;	 Catch:{ IllegalArgumentException -> 0x000e }
        r2 = com.google.p217b.p240g.p241a.C5294j.m22456b(r2);	 Catch:{ IllegalArgumentException -> 0x000e }
        return r2;
    L_0x000e:
        r2 = com.google.p217b.C6891h.m32342a();
        throw r2;
    L_0x0013:
        r2 = com.google.p217b.C6891h.m32342a();
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.b.g.a.j.a(int):com.google.b.g.a.j");
    }

    /* renamed from: b */
    public static C5294j m22456b(int i) {
        if (i > 0 && i <= 40) {
            return f17881b[i - 1];
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: c */
    static C5294j m22457c(int i) {
        int i2 = Integer.MAX_VALUE;
        int i3 = 0;
        for (int i4 = 0; i4 < f17880a.length; i4++) {
            int i5 = f17880a[i4];
            if (i5 == i) {
                return C5294j.m22456b(i4 + 7);
            }
            i5 = C5289g.m22440a(i, i5);
            if (i5 < i2) {
                i3 = i4 + 7;
                i2 = i5;
            }
        }
        return i2 <= 3 ? C5294j.m22456b(i3) : 0;
    }

    /* renamed from: e */
    C5202b m22464e() {
        int d = m22463d();
        C5202b c5202b = new C5202b(d);
        c5202b.m22001a(0, 0, 9, 9);
        int i = d - 8;
        c5202b.m22001a(i, 0, 8, 9);
        c5202b.m22001a(0, i, 9, 8);
        i = this.f17883d.length;
        int i2 = 0;
        while (i2 < i) {
            int i3 = this.f17883d[i2] - 2;
            int i4 = 0;
            while (i4 < i) {
                if (!((i2 == 0 && (i4 == 0 || i4 == i - 1)) || (i2 == i - 1 && i4 == 0))) {
                    c5202b.m22001a(this.f17883d[i4] - 2, i3, 5, 5);
                }
                i4++;
            }
            i2++;
        }
        i = d - 17;
        c5202b.m22001a(6, 9, 1, i);
        c5202b.m22001a(9, 6, i, 1);
        if (this.f17882c > 6) {
            d -= 11;
            c5202b.m22001a(d, 0, 3, 6);
            c5202b.m22001a(0, d, 6, 3);
        }
        return c5202b;
    }

    public String toString() {
        return String.valueOf(this.f17882c);
    }

    /* renamed from: f */
    private static C5294j[] m22458f() {
        r0 = new C5294j[40];
        int[] iArr = new int[0];
        C5293b[] c5293bArr = new C5293b[4];
        c5293bArr[0] = new C5293b(7, new C5292a(1, 19));
        c5293bArr[1] = new C5293b(10, new C5292a(1, 16));
        c5293bArr[2] = new C5293b(13, new C5292a(1, 13));
        c5293bArr[3] = new C5293b(17, new C5292a(1, 9));
        r0[0] = new C5294j(1, iArr, c5293bArr);
        iArr = new int[]{6, 18};
        c5293bArr = new C5293b[4];
        c5293bArr[0] = new C5293b(10, new C5292a(1, 34));
        c5293bArr[1] = new C5293b(16, new C5292a(1, 28));
        c5293bArr[2] = new C5293b(22, new C5292a(1, 22));
        c5293bArr[3] = new C5293b(28, new C5292a(1, 16));
        r0[1] = new C5294j(2, iArr, c5293bArr);
        iArr = new int[]{6, 22};
        c5293bArr = new C5293b[4];
        c5293bArr[0] = new C5293b(15, new C5292a(1, 55));
        c5293bArr[1] = new C5293b(26, new C5292a(1, 44));
        c5293bArr[2] = new C5293b(18, new C5292a(2, 17));
        c5293bArr[3] = new C5293b(22, new C5292a(2, 13));
        r0[2] = new C5294j(3, iArr, c5293bArr);
        iArr = new int[]{6, 26};
        c5293bArr = new C5293b[4];
        c5293bArr[0] = new C5293b(20, new C5292a(1, 80));
        c5293bArr[1] = new C5293b(18, new C5292a(2, 32));
        c5293bArr[2] = new C5293b(26, new C5292a(2, 24));
        c5293bArr[3] = new C5293b(16, new C5292a(4, 9));
        r0[3] = new C5294j(4, iArr, c5293bArr);
        iArr = new int[]{6, 30};
        c5293bArr = new C5293b[4];
        c5293bArr[0] = new C5293b(26, new C5292a(1, 108));
        c5293bArr[1] = new C5293b(24, new C5292a(2, 43));
        c5293bArr[2] = new C5293b(18, new C5292a(2, 15), new C5292a(2, 16));
        c5293bArr[3] = new C5293b(22, new C5292a(2, 11), new C5292a(2, 12));
        r0[4] = new C5294j(5, iArr, c5293bArr);
        iArr = new int[]{6, 34};
        c5293bArr = new C5293b[4];
        c5293bArr[0] = new C5293b(18, new C5292a(2, 68));
        c5293bArr[1] = new C5293b(16, new C5292a(4, 27));
        c5293bArr[2] = new C5293b(24, new C5292a(4, 19));
        c5293bArr[3] = new C5293b(28, new C5292a(4, 15));
        r0[5] = new C5294j(6, iArr, c5293bArr);
        iArr = new int[]{6, 22, 38};
        c5293bArr = new C5293b[4];
        c5293bArr[0] = new C5293b(20, new C5292a(2, 78));
        c5293bArr[1] = new C5293b(18, new C5292a(4, 31));
        c5293bArr[2] = new C5293b(18, new C5292a(2, 14), new C5292a(4, 15));
        c5293bArr[3] = new C5293b(26, new C5292a(4, 13), new C5292a(1, 14));
        r0[6] = new C5294j(7, iArr, c5293bArr);
        iArr = new int[]{6, 24, 42};
        c5293bArr = new C5293b[4];
        c5293bArr[0] = new C5293b(24, new C5292a(2, 97));
        c5293bArr[1] = new C5293b(22, new C5292a(2, 38), new C5292a(2, 39));
        c5293bArr[2] = new C5293b(22, new C5292a(4, 18), new C5292a(2, 19));
        c5293bArr[3] = new C5293b(26, new C5292a(4, 14), new C5292a(2, 15));
        r0[7] = new C5294j(8, iArr, c5293bArr);
        iArr = new int[]{6, 26, 46};
        c5293bArr = new C5293b[4];
        c5293bArr[0] = new C5293b(30, new C5292a(2, 116));
        c5293bArr[1] = new C5293b(22, new C5292a(3, 36), new C5292a(2, 37));
        c5293bArr[2] = new C5293b(20, new C5292a(4, 16), new C5292a(4, 17));
        c5293bArr[3] = new C5293b(24, new C5292a(4, 12), new C5292a(4, 13));
        r0[8] = new C5294j(9, iArr, c5293bArr);
        iArr = new int[]{6, 28, 50};
        c5293bArr = new C5293b[4];
        c5293bArr[0] = new C5293b(18, new C5292a(2, 68), new C5292a(2, 69));
        c5293bArr[1] = new C5293b(26, new C5292a(4, 43), new C5292a(1, 44));
        c5293bArr[2] = new C5293b(24, new C5292a(6, 19), new C5292a(2, 20));
        c5293bArr[3] = new C5293b(28, new C5292a(6, 15), new C5292a(2, 16));
        r0[9] = new C5294j(10, iArr, c5293bArr);
        iArr = new int[]{6, 30, 54};
        c5293bArr = new C5293b[4];
        c5293bArr[0] = new C5293b(20, new C5292a(4, 81));
        c5293bArr[1] = new C5293b(30, new C5292a(1, 50), new C5292a(4, 51));
        c5293bArr[2] = new C5293b(28, new C5292a(4, 22), new C5292a(4, 23));
        c5293bArr[3] = new C5293b(24, new C5292a(3, 12), new C5292a(8, 13));
        r0[10] = new C5294j(11, iArr, c5293bArr);
        iArr = new int[]{6, 32, 58};
        c5293bArr = new C5293b[4];
        c5293bArr[0] = new C5293b(24, new C5292a(2, 92), new C5292a(2, 93));
        c5293bArr[1] = new C5293b(22, new C5292a(6, 36), new C5292a(2, 37));
        c5293bArr[2] = new C5293b(26, new C5292a(4, 20), new C5292a(6, 21));
        c5293bArr[3] = new C5293b(28, new C5292a(7, 14), new C5292a(4, 15));
        r0[11] = new C5294j(12, iArr, c5293bArr);
        iArr = new int[]{6, 34, 62};
        c5293bArr = new C5293b[4];
        c5293bArr[0] = new C5293b(26, new C5292a(4, 107));
        c5293bArr[1] = new C5293b(22, new C5292a(8, 37), new C5292a(1, 38));
        c5293bArr[2] = new C5293b(24, new C5292a(8, 20), new C5292a(4, 21));
        c5293bArr[3] = new C5293b(22, new C5292a(12, 11), new C5292a(4, 12));
        r0[12] = new C5294j(13, iArr, c5293bArr);
        iArr = new int[]{6, 26, 46, 66};
        c5293bArr = new C5293b[4];
        c5293bArr[0] = new C5293b(30, new C5292a(3, 115), new C5292a(1, 116));
        c5293bArr[1] = new C5293b(24, new C5292a(4, 40), new C5292a(5, 41));
        c5293bArr[2] = new C5293b(20, new C5292a(11, 16), new C5292a(5, 17));
        c5293bArr[3] = new C5293b(24, new C5292a(11, 12), new C5292a(5, 13));
        r0[13] = new C5294j(14, iArr, c5293bArr);
        iArr = new int[]{6, 26, 48, 70};
        c5293bArr = new C5293b[4];
        c5293bArr[0] = new C5293b(22, new C5292a(5, 87), new C5292a(1, 88));
        c5293bArr[1] = new C5293b(24, new C5292a(5, 41), new C5292a(5, 42));
        c5293bArr[2] = new C5293b(30, new C5292a(5, 24), new C5292a(7, 25));
        c5293bArr[3] = new C5293b(24, new C5292a(11, 12), new C5292a(7, 13));
        r0[14] = new C5294j(15, iArr, c5293bArr);
        iArr = new int[]{6, 26, 50, 74};
        c5293bArr = new C5293b[4];
        c5293bArr[0] = new C5293b(24, new C5292a(5, 98), new C5292a(1, 99));
        c5293bArr[1] = new C5293b(28, new C5292a(7, 45), new C5292a(3, 46));
        c5293bArr[2] = new C5293b(24, new C5292a(15, 19), new C5292a(2, 20));
        c5293bArr[3] = new C5293b(30, new C5292a(3, 15), new C5292a(13, 16));
        r0[15] = new C5294j(16, iArr, c5293bArr);
        iArr = new int[]{6, 30, 54, 78};
        c5293bArr = new C5293b[4];
        c5293bArr[0] = new C5293b(28, new C5292a(1, 107), new C5292a(5, 108));
        c5293bArr[1] = new C5293b(28, new C5292a(10, 46), new C5292a(1, 47));
        c5293bArr[2] = new C5293b(28, new C5292a(1, 22), new C5292a(15, 23));
        c5293bArr[3] = new C5293b(28, new C5292a(2, 14), new C5292a(17, 15));
        r0[16] = new C5294j(17, iArr, c5293bArr);
        iArr = new int[]{6, 30, 56, 82};
        c5293bArr = new C5293b[4];
        c5293bArr[0] = new C5293b(30, new C5292a(5, 120), new C5292a(1, 121));
        c5293bArr[1] = new C5293b(26, new C5292a(9, 43), new C5292a(4, 44));
        c5293bArr[2] = new C5293b(28, new C5292a(17, 22), new C5292a(1, 23));
        c5293bArr[3] = new C5293b(28, new C5292a(2, 14), new C5292a(19, 15));
        r0[17] = new C5294j(18, iArr, c5293bArr);
        iArr = new int[]{6, 30, 58, 86};
        c5293bArr = new C5293b[4];
        c5293bArr[0] = new C5293b(28, new C5292a(3, 113), new C5292a(4, 114));
        c5293bArr[1] = new C5293b(26, new C5292a(3, 44), new C5292a(11, 45));
        c5293bArr[2] = new C5293b(26, new C5292a(17, 21), new C5292a(4, 22));
        c5293bArr[3] = new C5293b(26, new C5292a(9, 13), new C5292a(16, 14));
        r0[18] = new C5294j(19, iArr, c5293bArr);
        iArr = new int[]{6, 34, 62, 90};
        c5293bArr = new C5293b[4];
        c5293bArr[0] = new C5293b(28, new C5292a(3, 107), new C5292a(5, 108));
        c5293bArr[1] = new C5293b(26, new C5292a(3, 41), new C5292a(13, 42));
        c5293bArr[2] = new C5293b(30, new C5292a(15, 24), new C5292a(5, 25));
        c5293bArr[3] = new C5293b(28, new C5292a(15, 15), new C5292a(10, 16));
        r0[19] = new C5294j(20, iArr, c5293bArr);
        int[] iArr2 = new int[]{6, 28, 50, 72, 94};
        r3 = new C5293b[4];
        r3[0] = new C5293b(28, new C5292a(4, 116), new C5292a(4, 117));
        r3[1] = new C5293b(26, new C5292a(17, 42));
        r3[2] = new C5293b(28, new C5292a(17, 22), new C5292a(6, 23));
        r3[3] = new C5293b(30, new C5292a(19, 16), new C5292a(6, 17));
        r0[20] = new C5294j(21, iArr2, r3);
        iArr2 = new int[]{6, 26, 50, 74, 98};
        r3 = new C5293b[4];
        r3[0] = new C5293b(28, new C5292a(2, 111), new C5292a(7, 112));
        r3[1] = new C5293b(28, new C5292a(17, 46));
        r3[2] = new C5293b(30, new C5292a(7, 24), new C5292a(16, 25));
        r3[3] = new C5293b(24, new C5292a(34, 13));
        r0[21] = new C5294j(22, iArr2, r3);
        iArr2 = new int[]{6, 30, 54, 78, 102};
        r6 = new C5293b[4];
        r6[0] = new C5293b(30, new C5292a(4, 121), new C5292a(5, 122));
        r6[1] = new C5293b(28, new C5292a(4, 47), new C5292a(14, 48));
        r6[2] = new C5293b(30, new C5292a(11, 24), new C5292a(14, 25));
        r6[3] = new C5293b(30, new C5292a(16, 15), new C5292a(14, 16));
        r0[22] = new C5294j(23, iArr2, r6);
        iArr2 = new int[]{6, 28, 54, 80, 106};
        r3 = new C5293b[4];
        r3[0] = new C5293b(30, new C5292a(6, 117), new C5292a(4, 118));
        r3[1] = new C5293b(28, new C5292a(6, 45), new C5292a(14, 46));
        r3[2] = new C5293b(30, new C5292a(11, 24), new C5292a(16, 25));
        r3[3] = new C5293b(30, new C5292a(30, 16), new C5292a(2, 17));
        r0[23] = new C5294j(24, iArr2, r3);
        iArr2 = new int[]{6, 32, 58, 84, 110};
        r3 = new C5293b[4];
        r3[0] = new C5293b(26, new C5292a(8, 106), new C5292a(4, 107));
        r3[1] = new C5293b(28, new C5292a(8, 47), new C5292a(13, 48));
        r3[2] = new C5293b(30, new C5292a(7, 24), new C5292a(22, 25));
        r3[3] = new C5293b(30, new C5292a(22, 15), new C5292a(13, 16));
        r0[24] = new C5294j(25, iArr2, r3);
        iArr2 = new int[]{6, 30, 58, 86, 114};
        r3 = new C5293b[4];
        r3[0] = new C5293b(28, new C5292a(10, 114), new C5292a(2, 115));
        r3[1] = new C5293b(28, new C5292a(19, 46), new C5292a(4, 47));
        r3[2] = new C5293b(28, new C5292a(28, 22), new C5292a(6, 23));
        r3[3] = new C5293b(30, new C5292a(33, 16), new C5292a(4, 17));
        r0[25] = new C5294j(26, iArr2, r3);
        iArr2 = new int[]{6, 34, 62, 90, 118};
        r3 = new C5293b[4];
        r3[0] = new C5293b(30, new C5292a(8, 122), new C5292a(4, 123));
        r3[1] = new C5293b(28, new C5292a(22, 45), new C5292a(3, 46));
        r3[2] = new C5293b(30, new C5292a(8, 23), new C5292a(26, 24));
        r3[3] = new C5293b(30, new C5292a(12, 15), new C5292a(28, 16));
        r0[26] = new C5294j(27, iArr2, r3);
        iArr2 = new int[]{6, 26, 50, 74, 98, 122};
        r3 = new C5293b[4];
        r3[0] = new C5293b(30, new C5292a(3, 117), new C5292a(10, 118));
        r3[1] = new C5293b(28, new C5292a(3, 45), new C5292a(23, 46));
        r3[2] = new C5293b(30, new C5292a(4, 24), new C5292a(31, 25));
        r3[3] = new C5293b(30, new C5292a(11, 15), new C5292a(31, 16));
        r0[27] = new C5294j(28, iArr2, r3);
        iArr2 = new int[]{6, 30, 54, 78, 102, 126};
        r3 = new C5293b[4];
        r3[0] = new C5293b(30, new C5292a(7, 116), new C5292a(7, 117));
        r3[1] = new C5293b(28, new C5292a(21, 45), new C5292a(7, 46));
        r3[2] = new C5293b(30, new C5292a(1, 23), new C5292a(37, 24));
        r3[3] = new C5293b(30, new C5292a(19, 15), new C5292a(26, 16));
        r0[28] = new C5294j(29, iArr2, r3);
        iArr2 = new int[]{6, 26, 52, 78, 104, 130};
        r3 = new C5293b[4];
        r3[0] = new C5293b(30, new C5292a(5, 115), new C5292a(10, 116));
        r3[1] = new C5293b(28, new C5292a(19, 47), new C5292a(10, 48));
        r3[2] = new C5293b(30, new C5292a(15, 24), new C5292a(25, 25));
        r3[3] = new C5293b(30, new C5292a(23, 15), new C5292a(25, 16));
        r0[29] = new C5294j(30, iArr2, r3);
        iArr2 = new int[]{6, 30, 56, 82, 108, 134};
        r3 = new C5293b[4];
        r3[0] = new C5293b(30, new C5292a(13, 115), new C5292a(3, 116));
        r3[1] = new C5293b(28, new C5292a(2, 46), new C5292a(29, 47));
        r3[2] = new C5293b(30, new C5292a(42, 24), new C5292a(1, 25));
        r3[3] = new C5293b(30, new C5292a(23, 15), new C5292a(28, 16));
        r0[30] = new C5294j(31, iArr2, r3);
        iArr2 = new int[]{6, 34, 60, 86, 112, 138};
        r3 = new C5293b[4];
        r3[0] = new C5293b(30, new C5292a(17, 115));
        r3[1] = new C5293b(28, new C5292a(10, 46), new C5292a(23, 47));
        r3[2] = new C5293b(30, new C5292a(10, 24), new C5292a(35, 25));
        r3[3] = new C5293b(30, new C5292a(19, 15), new C5292a(35, 16));
        r0[31] = new C5294j(32, iArr2, r3);
        iArr2 = new int[]{6, 30, 58, 86, 114, 142};
        r3 = new C5293b[4];
        r3[0] = new C5293b(30, new C5292a(17, 115), new C5292a(1, 116));
        r3[1] = new C5293b(28, new C5292a(14, 46), new C5292a(21, 47));
        r3[2] = new C5293b(30, new C5292a(29, 24), new C5292a(19, 25));
        r3[3] = new C5293b(30, new C5292a(11, 15), new C5292a(46, 16));
        r0[32] = new C5294j(33, iArr2, r3);
        iArr2 = new int[]{6, 34, 62, 90, 118, 146};
        r3 = new C5293b[4];
        r3[0] = new C5293b(30, new C5292a(13, 115), new C5292a(6, 116));
        r3[1] = new C5293b(28, new C5292a(14, 46), new C5292a(23, 47));
        r3[2] = new C5293b(30, new C5292a(44, 24), new C5292a(7, 25));
        r3[3] = new C5293b(30, new C5292a(59, 16), new C5292a(1, 17));
        r0[33] = new C5294j(34, iArr2, r3);
        iArr2 = new int[]{6, 30, 54, 78, 102, 126, 150};
        r3 = new C5293b[4];
        r3[0] = new C5293b(30, new C5292a(12, 121), new C5292a(7, 122));
        r3[1] = new C5293b(28, new C5292a(12, 47), new C5292a(26, 48));
        r3[2] = new C5293b(30, new C5292a(39, 24), new C5292a(14, 25));
        r3[3] = new C5293b(30, new C5292a(22, 15), new C5292a(41, 16));
        r0[34] = new C5294j(35, iArr2, r3);
        iArr2 = new int[]{6, 24, 50, 76, 102, 128, 154};
        r3 = new C5293b[4];
        r3[0] = new C5293b(30, new C5292a(6, 121), new C5292a(14, 122));
        r3[1] = new C5293b(28, new C5292a(6, 47), new C5292a(34, 48));
        r3[2] = new C5293b(30, new C5292a(46, 24), new C5292a(10, 25));
        r3[3] = new C5293b(30, new C5292a(2, 15), new C5292a(64, 16));
        r0[35] = new C5294j(36, iArr2, r3);
        iArr2 = new int[]{6, 28, 54, 80, 106, 132, 158};
        r3 = new C5293b[4];
        r3[0] = new C5293b(30, new C5292a(17, 122), new C5292a(4, 123));
        r3[1] = new C5293b(28, new C5292a(29, 46), new C5292a(14, 47));
        r3[2] = new C5293b(30, new C5292a(49, 24), new C5292a(10, 25));
        r3[3] = new C5293b(30, new C5292a(24, 15), new C5292a(46, 16));
        r0[36] = new C5294j(37, iArr2, r3);
        iArr2 = new int[]{6, 32, 58, 84, 110, 136, 162};
        r3 = new C5293b[4];
        r3[0] = new C5293b(30, new C5292a(4, 122), new C5292a(18, 123));
        r3[1] = new C5293b(28, new C5292a(13, 46), new C5292a(32, 47));
        r3[2] = new C5293b(30, new C5292a(48, 24), new C5292a(14, 25));
        r3[3] = new C5293b(30, new C5292a(42, 15), new C5292a(32, 16));
        r0[37] = new C5294j(38, iArr2, r3);
        iArr2 = new int[]{6, 26, 54, 82, 110, 138, 166};
        r3 = new C5293b[4];
        r3[0] = new C5293b(30, new C5292a(20, 117), new C5292a(4, 118));
        r3[1] = new C5293b(28, new C5292a(40, 47), new C5292a(7, 48));
        r3[2] = new C5293b(30, new C5292a(43, 24), new C5292a(22, 25));
        r3[3] = new C5293b(30, new C5292a(10, 15), new C5292a(67, 16));
        r0[38] = new C5294j(39, iArr2, r3);
        iArr = new int[]{6, 30, 58, 86, 114, 142, 170};
        r4 = new C5293b[4];
        r4[0] = new C5293b(30, new C5292a(19, 118), new C5292a(6, 119));
        r4[1] = new C5293b(28, new C5292a(18, 47), new C5292a(31, 48));
        r4[2] = new C5293b(30, new C5292a(34, 24), new C5292a(34, 25));
        r4[3] = new C5293b(30, new C5292a(20, 15), new C5292a(61, 16));
        r0[39] = new C5294j(40, iArr, r4);
        return r0;
    }
}
