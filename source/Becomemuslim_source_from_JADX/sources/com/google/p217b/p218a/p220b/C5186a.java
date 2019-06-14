package com.google.p217b.p218a.p220b;

import com.google.p217b.C5316s;
import com.google.p217b.C6894l;
import com.google.p217b.p218a.C6851a;
import com.google.p217b.p222b.C5202b;
import com.google.p217b.p222b.C5207i;
import com.google.p217b.p222b.p223a.C5194a;

/* compiled from: Detector */
/* renamed from: com.google.b.a.b.a */
public final class C5186a {
    /* renamed from: a */
    private static final int[] f17463a = new int[]{3808, 476, 2107, 1799};
    /* renamed from: b */
    private final C5202b f17464b;
    /* renamed from: c */
    private boolean f17465c;
    /* renamed from: d */
    private int f17466d;
    /* renamed from: e */
    private int f17467e;
    /* renamed from: f */
    private int f17468f;
    /* renamed from: g */
    private int f17469g;

    /* compiled from: Detector */
    /* renamed from: com.google.b.a.b.a$a */
    static final class C5185a {
        /* renamed from: a */
        private final int f17461a;
        /* renamed from: b */
        private final int f17462b;

        /* renamed from: a */
        C5316s m21888a() {
            return new C5316s((float) m21889b(), (float) m21890c());
        }

        C5185a(int i, int i2) {
            this.f17461a = i;
            this.f17462b = i2;
        }

        /* renamed from: b */
        int m21889b() {
            return this.f17461a;
        }

        /* renamed from: c */
        int m21890c() {
            return this.f17462b;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("<");
            stringBuilder.append(this.f17461a);
            stringBuilder.append(' ');
            stringBuilder.append(this.f17462b);
            stringBuilder.append('>');
            return stringBuilder.toString();
        }
    }

    public C5186a(C5202b c5202b) {
        this.f17464b = c5202b;
    }

    /* renamed from: a */
    public C6851a m21908a(boolean z) {
        C5316s[] a = m21903a(m21896a());
        if (z) {
            C5316s c5316s = a[0];
            a[0] = a[2];
            a[2] = c5316s;
        }
        m21899a(a);
        return new C6851a(m21898a(this.f17464b, a[this.f17469g % 4], a[(this.f17469g + 1) % 4], a[(this.f17469g + 2) % 4], a[(this.f17469g + 3) % 4]), m21907b(a), this.f17465c, this.f17467e, this.f17466d);
    }

    /* renamed from: a */
    private void m21899a(C5316s[] c5316sArr) {
        int i = 0;
        if (m21902a(c5316sArr[0]) && m21902a(c5316sArr[1]) && m21902a(c5316sArr[2]) && m21902a(c5316sArr[3])) {
            int[] iArr = new int[]{m21894a(c5316sArr[0], c5316sArr[1], this.f17468f * 2), m21894a(c5316sArr[1], c5316sArr[2], this.f17468f * 2), m21894a(c5316sArr[2], c5316sArr[3], this.f17468f * 2), m21894a(c5316sArr[3], c5316sArr[0], this.f17468f * 2)};
            this.f17469g = C5186a.m21895a(iArr, this.f17468f * 2);
            long j = 0;
            while (i < 4) {
                c5316sArr = iArr[(this.f17469g + i) % 4];
                j = this.f17465c ? (j << 7) + ((long) ((c5316sArr >> 1) & 127)) : (j << 10) + ((long) (((c5316sArr >> 2) & 992) + ((c5316sArr >> 1) & 31)));
                i++;
            }
            c5316sArr = C5186a.m21892a(j, this.f17465c);
            if (this.f17465c) {
                this.f17466d = (c5316sArr >> 6) + 1;
                this.f17467e = (c5316sArr & 63) + 1;
                return;
            }
            this.f17466d = (c5316sArr >> 11) + 1;
            this.f17467e = (c5316sArr & 2047) + 1;
            return;
        }
        throw C6894l.m32349a();
    }

    /* renamed from: a */
    private static int m21895a(int[] iArr, int i) {
        int i2 = 0;
        for (int i3 : iArr) {
            i2 = (i2 << 3) + (((i3 >> (i - 2)) << 1) + (i3 & 1));
        }
        iArr = ((i2 & 1) << 11) + (i2 >> 1);
        for (int i4 = 0; i4 < 4; i4++) {
            if (Integer.bitCount(f17463a[i4] ^ iArr) <= 2) {
                return i4;
            }
        }
        throw C6894l.m32349a();
    }

    /* renamed from: a */
    private static int m21892a(long r5, boolean r7) {
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
        r0 = 4;
        if (r7 == 0) goto L_0x0006;
    L_0x0003:
        r7 = 7;
        r1 = 2;
        goto L_0x0009;
    L_0x0006:
        r7 = 10;
        r1 = 4;
    L_0x0009:
        r2 = r7 - r1;
        r3 = new int[r7];
        r7 = r7 + -1;
    L_0x000f:
        if (r7 < 0) goto L_0x001a;
    L_0x0011:
        r4 = (int) r5;
        r4 = r4 & 15;
        r3[r7] = r4;
        r5 = r5 >> r0;
        r7 = r7 + -1;
        goto L_0x000f;
    L_0x001a:
        r5 = new com.google.b.b.b.c;	 Catch:{ e -> 0x0031 }
        r6 = com.google.p217b.p222b.p224b.C5197a.f17519d;	 Catch:{ e -> 0x0031 }
        r5.<init>(r6);	 Catch:{ e -> 0x0031 }
        r5.m21994a(r3, r2);	 Catch:{ e -> 0x0031 }
        r5 = 0;
        r6 = 0;
    L_0x0026:
        if (r5 >= r1) goto L_0x0030;
    L_0x0028:
        r6 = r6 << 4;
        r7 = r3[r5];
        r6 = r6 + r7;
        r5 = r5 + 1;
        goto L_0x0026;
    L_0x0030:
        return r6;
    L_0x0031:
        r5 = com.google.p217b.C6894l.m32349a();
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.b.a.b.a.a(long, boolean):int");
    }

    /* renamed from: a */
    private C5316s[] m21903a(C5185a c5185a) {
        this.f17468f = 1;
        C5185a c5185a2 = c5185a;
        C5185a c5185a3 = c5185a2;
        C5185a c5185a4 = c5185a3;
        boolean z = true;
        while (this.f17468f < 9) {
            C5185a a = m21897a(c5185a, z, 1, -1);
            C5185a a2 = m21897a(c5185a2, z, 1, 1);
            C5185a a3 = m21897a(c5185a3, z, -1, 1);
            C5185a a4 = m21897a(c5185a4, z, -1, -1);
            if (this.f17468f > 2) {
                double b = (double) ((C5186a.m21905b(a4, a) * ((float) this.f17468f)) / (C5186a.m21905b(c5185a4, c5185a) * ((float) (this.f17468f + 2))));
                if (b < 0.75d || b > 1.25d || !m21901a(a, a2, a3, a4)) {
                    break;
                }
            }
            z ^= 1;
            this.f17468f += 1;
            c5185a4 = a4;
            c5185a = a;
            c5185a2 = a2;
            c5185a3 = a3;
        }
        if (this.f17468f != 5) {
            if (this.f17468f != 7) {
                throw C6894l.m32349a();
            }
        }
        this.f17465c = this.f17468f == 5;
        C5316s c5316s = new C5316s(((float) c5185a.m21889b()) + 0.5f, ((float) c5185a.m21890c()) - 1056964608);
        c5185a = new C5316s(((float) c5185a2.m21889b()) + 0.5f, ((float) c5185a2.m21890c()) + 0.5f);
        C5316s c5316s2 = new C5316s(((float) c5185a3.m21889b()) - 0.5f, ((float) c5185a3.m21890c()) + 0.5f);
        C5316s c5316s3 = new C5316s(((float) c5185a4.m21889b()) - 0.5f, ((float) c5185a4.m21890c()) - 0.5f);
        return C5186a.m21904a(new C5316s[]{c5316s, c5185a, c5316s2, c5316s3}, (this.f17468f * 2) - 3, this.f17468f * 2);
    }

    /* renamed from: a */
    private com.google.p217b.p218a.p220b.C5186a.C5185a m21896a() {
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
        r12 = this;
        r0 = 3;
        r1 = 2;
        r2 = -1;
        r3 = 1;
        r4 = 0;
        r5 = new com.google.b.b.a.b;	 Catch:{ l -> 0x0019 }
        r6 = r12.f17464b;	 Catch:{ l -> 0x0019 }
        r5.<init>(r6);	 Catch:{ l -> 0x0019 }
        r5 = r5.m21951a();	 Catch:{ l -> 0x0019 }
        r6 = r5[r4];	 Catch:{ l -> 0x0019 }
        r7 = r5[r3];	 Catch:{ l -> 0x0019 }
        r8 = r5[r1];	 Catch:{ l -> 0x0019 }
        r5 = r5[r0];	 Catch:{ l -> 0x0019 }
        goto L_0x0067;
    L_0x0019:
        r5 = r12.f17464b;
        r5 = r5.m22010f();
        r5 = r5 / r1;
        r6 = r12.f17464b;
        r6 = r6.m22011g();
        r6 = r6 / r1;
        r7 = new com.google.b.a.b.a$a;
        r8 = r5 + 7;
        r9 = r6 + -7;
        r7.<init>(r8, r9);
        r7 = r12.m21897a(r7, r4, r3, r2);
        r7 = r7.m21888a();
        r10 = new com.google.b.a.b.a$a;
        r6 = r6 + 7;
        r10.<init>(r8, r6);
        r8 = r12.m21897a(r10, r4, r3, r3);
        r8 = r8.m21888a();
        r10 = new com.google.b.a.b.a$a;
        r5 = r5 + -7;
        r10.<init>(r5, r6);
        r6 = r12.m21897a(r10, r4, r2, r3);
        r6 = r6.m21888a();
        r10 = new com.google.b.a.b.a$a;
        r10.<init>(r5, r9);
        r5 = r12.m21897a(r10, r4, r2, r2);
        r5 = r5.m21888a();
        r11 = r8;
        r8 = r6;
        r6 = r7;
        r7 = r11;
    L_0x0067:
        r9 = r6.m22582a();
        r10 = r5.m22582a();
        r9 = r9 + r10;
        r10 = r7.m22582a();
        r9 = r9 + r10;
        r10 = r8.m22582a();
        r9 = r9 + r10;
        r10 = 1082130432; // 0x40800000 float:4.0 double:5.34643471E-315;
        r9 = r9 / r10;
        r9 = com.google.p217b.p222b.p223a.C5194a.m21946a(r9);
        r6 = r6.m22583b();
        r5 = r5.m22583b();
        r6 = r6 + r5;
        r5 = r7.m22583b();
        r6 = r6 + r5;
        r5 = r8.m22583b();
        r6 = r6 + r5;
        r6 = r6 / r10;
        r5 = com.google.p217b.p222b.p223a.C5194a.m21946a(r6);
        r6 = new com.google.b.b.a.b;	 Catch:{ l -> 0x00af }
        r7 = r12.f17464b;	 Catch:{ l -> 0x00af }
        r8 = 15;	 Catch:{ l -> 0x00af }
        r6.<init>(r7, r8, r9, r5);	 Catch:{ l -> 0x00af }
        r6 = r6.m21951a();	 Catch:{ l -> 0x00af }
        r7 = r6[r4];	 Catch:{ l -> 0x00af }
        r8 = r6[r3];	 Catch:{ l -> 0x00af }
        r1 = r6[r1];	 Catch:{ l -> 0x00af }
        r0 = r6[r0];	 Catch:{ l -> 0x00af }
        goto L_0x00eb;
    L_0x00af:
        r0 = new com.google.b.a.b.a$a;
        r1 = r9 + 7;
        r6 = r5 + -7;
        r0.<init>(r1, r6);
        r0 = r12.m21897a(r0, r4, r3, r2);
        r7 = r0.m21888a();
        r0 = new com.google.b.a.b.a$a;
        r5 = r5 + 7;
        r0.<init>(r1, r5);
        r0 = r12.m21897a(r0, r4, r3, r3);
        r8 = r0.m21888a();
        r0 = new com.google.b.a.b.a$a;
        r9 = r9 + -7;
        r0.<init>(r9, r5);
        r0 = r12.m21897a(r0, r4, r2, r3);
        r1 = r0.m21888a();
        r0 = new com.google.b.a.b.a$a;
        r0.<init>(r9, r6);
        r0 = r12.m21897a(r0, r4, r2, r2);
        r0 = r0.m21888a();
    L_0x00eb:
        r2 = r7.m22582a();
        r3 = r0.m22582a();
        r2 = r2 + r3;
        r3 = r8.m22582a();
        r2 = r2 + r3;
        r3 = r1.m22582a();
        r2 = r2 + r3;
        r2 = r2 / r10;
        r2 = com.google.p217b.p222b.p223a.C5194a.m21946a(r2);
        r3 = r7.m22583b();
        r0 = r0.m22583b();
        r3 = r3 + r0;
        r0 = r8.m22583b();
        r3 = r3 + r0;
        r0 = r1.m22583b();
        r3 = r3 + r0;
        r3 = r3 / r10;
        r0 = com.google.p217b.p222b.p223a.C5194a.m21946a(r3);
        r1 = new com.google.b.a.b.a$a;
        r1.<init>(r2, r0);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.b.a.b.a.a():com.google.b.a.b.a$a");
    }

    /* renamed from: b */
    private C5316s[] m21907b(C5316s[] c5316sArr) {
        return C5186a.m21904a(c5316sArr, this.f17468f * 2, m21906b());
    }

    /* renamed from: a */
    private C5202b m21898a(C5202b c5202b, C5316s c5316s, C5316s c5316s2, C5316s c5316s3, C5316s c5316s4) {
        C5202b c5202b2 = c5202b;
        C5207i a = C5207i.m22035a();
        int b = m21906b();
        float f = ((float) b) / 2.0f;
        float f2 = f - ((float) this.f17468f);
        f += (float) this.f17468f;
        return a.mo4861a(c5202b2, b, b, f2, f2, f, f2, f, f, f2, f, c5316s.m22582a(), c5316s.m22583b(), c5316s2.m22582a(), c5316s2.m22583b(), c5316s3.m22582a(), c5316s3.m22583b(), c5316s4.m22582a(), c5316s4.m22583b());
    }

    /* renamed from: a */
    private int m21894a(C5316s c5316s, C5316s c5316s2, int i) {
        float a = C5186a.m21891a(c5316s, c5316s2);
        float f = a / ((float) i);
        float a2 = c5316s.m22582a();
        float b = c5316s.m22583b();
        float a3 = ((c5316s2.m22582a() - c5316s.m22582a()) * f) / a;
        f = (f * (c5316s2.m22583b() - c5316s.m22583b())) / a;
        c5316s2 = null;
        for (c5316s = null; c5316s < i; c5316s++) {
            float f2 = (float) c5316s;
            if (this.f17464b.m22002a(C5194a.m21946a((f2 * a3) + a2), C5194a.m21946a((f2 * f) + b))) {
                c5316s2 |= 1 << ((i - c5316s) - 1);
            }
        }
        return c5316s2;
    }

    /* renamed from: a */
    private boolean m21901a(C5185a c5185a, C5185a c5185a2, C5185a c5185a3, C5185a c5185a4) {
        C5185a c5185a5 = new C5185a(c5185a.m21889b() - 3, c5185a.m21890c() + 3);
        c5185a = new C5185a(c5185a2.m21889b() - 3, c5185a2.m21890c() - 3);
        c5185a2 = new C5185a(c5185a3.m21889b() + 3, c5185a3.m21890c() - 3);
        c5185a3 = new C5185a(c5185a4.m21889b() + 3, c5185a4.m21890c() + 3);
        c5185a4 = m21893a(c5185a3, c5185a5);
        if (c5185a4 != null && m21893a(c5185a5, c5185a) == c5185a4 && m21893a(c5185a, c5185a2) == c5185a4 && m21893a(c5185a2, c5185a3) == c5185a4) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private int m21893a(C5185a c5185a, C5185a c5185a2) {
        float b = C5186a.m21905b(c5185a, c5185a2);
        float b2 = ((float) (c5185a2.m21889b() - c5185a.m21889b())) / b;
        c5185a2 = ((float) (c5185a2.m21890c() - c5185a.m21890c())) / b;
        float b3 = (float) c5185a.m21889b();
        float c = (float) c5185a.m21890c();
        c5185a = this.f17464b.m22002a(c5185a.m21889b(), c5185a.m21890c());
        int ceil = (int) Math.ceil((double) b);
        int i = 0;
        float f = c;
        int i2 = 0;
        c = b3;
        for (int i3 = 0; i3 < ceil; i3++) {
            c += b2;
            f += c5185a2;
            if (this.f17464b.m22002a(C5194a.m21946a(c), C5194a.m21946a(f)) != c5185a) {
                i2++;
            }
        }
        c5185a2 = ((float) i2) / b;
        if (c5185a2 > 1036831949 && c5185a2 < 0.9f) {
            return 0;
        }
        if (c5185a2 <= 1036831949) {
            i = 1;
        }
        return i == c5185a ? 1 : -1;
    }

    /* renamed from: a */
    private C5185a m21897a(C5185a c5185a, boolean z, int i, int i2) {
        int b = c5185a.m21889b() + i;
        int c = c5185a.m21890c() + i2;
        while (m21900a(b, c) && this.f17464b.m22002a(b, c) == z) {
            b += i;
            c += i2;
        }
        b -= i;
        c -= i2;
        while (m21900a(b, c) && this.f17464b.m22002a(b, c) == z) {
            b += i;
        }
        b -= i;
        while (m21900a(b, c) != 0 && this.f17464b.m22002a(b, c) == z) {
            c += i2;
        }
        return new C5185a(b, c - i2);
    }

    /* renamed from: a */
    private static C5316s[] m21904a(C5316s[] c5316sArr, int i, int i2) {
        i2 = ((float) i2) / (((float) i) * 1073741824);
        float a = (c5316sArr[0].m22582a() + c5316sArr[2].m22582a()) / 2.0f;
        float b = (c5316sArr[0].m22583b() + c5316sArr[2].m22583b()) / 2.0f;
        float a2 = (c5316sArr[0].m22582a() - c5316sArr[2].m22582a()) * i2;
        float b2 = (c5316sArr[0].m22583b() - c5316sArr[2].m22583b()) * i2;
        C5316s c5316s = new C5316s(a + a2, b + b2);
        C5316s c5316s2 = new C5316s(a - a2, b - b2);
        float a3 = (c5316sArr[1].m22582a() + c5316sArr[3].m22582a()) / 2.0f;
        float b3 = (c5316sArr[1].m22583b() + c5316sArr[3].m22583b()) / 2.0f;
        b2 = (c5316sArr[1].m22582a() - c5316sArr[3].m22582a()) * i2;
        i2 *= c5316sArr[1].m22583b() - c5316sArr[3].m22583b();
        c5316sArr = new C5316s(a3 + b2, b3 + i2);
        C5316s c5316s3 = new C5316s(a3 - b2, b3 - i2);
        return new C5316s[]{c5316s, c5316sArr, c5316s2, c5316s3};
    }

    /* renamed from: a */
    private boolean m21900a(int i, int i2) {
        return i >= 0 && i < this.f17464b.m22010f() && i2 > 0 && i2 < this.f17464b.m22011g();
    }

    /* renamed from: a */
    private boolean m21902a(C5316s c5316s) {
        return m21900a(C5194a.m21946a(c5316s.m22582a()), C5194a.m21946a(c5316s.m22583b()));
    }

    /* renamed from: b */
    private static float m21905b(C5185a c5185a, C5185a c5185a2) {
        return C5194a.m21945a(c5185a.m21889b(), c5185a.m21890c(), c5185a2.m21889b(), c5185a2.m21890c());
    }

    /* renamed from: a */
    private static float m21891a(C5316s c5316s, C5316s c5316s2) {
        return C5194a.m21944a(c5316s.m22582a(), c5316s.m22583b(), c5316s2.m22582a(), c5316s2.m22583b());
    }

    /* renamed from: b */
    private int m21906b() {
        if (this.f17465c) {
            return (this.f17466d * 4) + 11;
        }
        if (this.f17466d <= 4) {
            return (this.f17466d * 4) + 15;
        }
        return ((this.f17466d * 4) + ((((this.f17466d - 4) / 8) + 1) * 2)) + 15;
    }
}
