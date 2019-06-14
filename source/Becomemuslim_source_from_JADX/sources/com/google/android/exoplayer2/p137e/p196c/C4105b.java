package com.google.android.exoplayer2.p137e.p196c;

import com.google.android.exoplayer2.p137e.C2303e;
import com.google.android.exoplayer2.p137e.C2304f;
import com.google.android.exoplayer2.p137e.C2320g;
import com.google.android.exoplayer2.p137e.C2323h;
import com.google.android.exoplayer2.p137e.C2324i;
import com.google.android.exoplayer2.p137e.C2325j;
import com.google.android.exoplayer2.p137e.C2327l;
import com.google.android.exoplayer2.p137e.C2329m;
import com.google.android.exoplayer2.p145g.C2344a;
import com.google.android.exoplayer2.p145g.p147b.C4162g;
import com.google.android.exoplayer2.p164l.C2529l;
import com.google.android.exoplayer2.p164l.C2541v;

/* compiled from: Mp3Extractor */
/* renamed from: com.google.android.exoplayer2.e.c.b */
public final class C4105b implements C2303e {
    /* renamed from: a */
    public static final C2323h f10452a = new C41031();
    /* renamed from: b */
    private static final int f10453b = C2541v.m7193g("Xing");
    /* renamed from: c */
    private static final int f10454c = C2541v.m7193g("Info");
    /* renamed from: d */
    private static final int f10455d = C2541v.m7193g("VBRI");
    /* renamed from: e */
    private final int f10456e;
    /* renamed from: f */
    private final long f10457f;
    /* renamed from: g */
    private final C2529l f10458g;
    /* renamed from: h */
    private final C2325j f10459h;
    /* renamed from: i */
    private final C2324i f10460i;
    /* renamed from: j */
    private C2320g f10461j;
    /* renamed from: k */
    private C2329m f10462k;
    /* renamed from: l */
    private int f10463l;
    /* renamed from: m */
    private C2344a f10464m;
    /* renamed from: n */
    private C4104a f10465n;
    /* renamed from: o */
    private long f10466o;
    /* renamed from: p */
    private long f10467p;
    /* renamed from: q */
    private int f10468q;

    /* compiled from: Mp3Extractor */
    /* renamed from: com.google.android.exoplayer2.e.c.b$1 */
    static class C41031 implements C2323h {
        C41031() {
        }

        /* renamed from: a */
        public C2303e[] mo2161a() {
            return new C2303e[]{new C4105b()};
        }
    }

    /* compiled from: Mp3Extractor */
    /* renamed from: com.google.android.exoplayer2.e.c.b$a */
    interface C4104a extends C2327l {
        /* renamed from: a */
        long mo3195a(long j);
    }

    /* renamed from: a */
    private static boolean m12896a(int i, long j) {
        return ((long) (i & -128000)) == (j & -128000);
    }

    /* renamed from: c */
    public void mo2166c() {
    }

    public C4105b() {
        this(0);
    }

    public C4105b(int i) {
        this(i, -9223372036854775807L);
    }

    public C4105b(int i, long j) {
        this.f10456e = i;
        this.f10457f = j;
        this.f10458g = new C2529l((int) 10);
        this.f10459h = new C2325j();
        this.f10460i = new C2324i();
        this.f10466o = 1;
    }

    /* renamed from: a */
    public boolean mo2165a(C2304f c2304f) {
        return m12897a(c2304f, true);
    }

    /* renamed from: a */
    public void mo2164a(C2320g c2320g) {
        this.f10461j = c2320g;
        this.f10462k = this.f10461j.mo2231a(0, 1);
        this.f10461j.mo2232a();
    }

    /* renamed from: a */
    public void mo2163a(long j, long j2) {
        this.f10463l = 0;
        this.f10466o = -9223372036854775807L;
        this.f10467p = 0;
        this.f10468q = 0;
    }

    /* renamed from: a */
    public int mo2162a(com.google.android.exoplayer2.p137e.C2304f r19, com.google.android.exoplayer2.p137e.C2326k r20) {
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
        r0 = r18;
        r1 = r0.f10463l;
        if (r1 != 0) goto L_0x000f;
    L_0x0006:
        r1 = 0;
        r2 = r19;
        r0.m12897a(r2, r1);	 Catch:{ EOFException -> 0x000d }
        goto L_0x0011;
    L_0x000d:
        r1 = -1;
        return r1;
    L_0x000f:
        r2 = r19;
    L_0x0011:
        r1 = r0.f10465n;
        if (r1 != 0) goto L_0x006f;
    L_0x0015:
        r1 = r18.m12900d(r19);
        r0.f10465n = r1;
        r1 = r0.f10465n;
        if (r1 == 0) goto L_0x002d;
    L_0x001f:
        r1 = r0.f10465n;
        r1 = r1.mo2167a();
        if (r1 != 0) goto L_0x0033;
    L_0x0027:
        r1 = r0.f10456e;
        r1 = r1 & 1;
        if (r1 == 0) goto L_0x0033;
    L_0x002d:
        r1 = r18.m12901e(r19);
        r0.f10465n = r1;
    L_0x0033:
        r1 = r0.f10461j;
        r3 = r0.f10465n;
        r1.mo2233a(r3);
        r1 = r0.f10462k;
        r3 = 0;
        r4 = r0.f10459h;
        r4 = r4.f5770b;
        r5 = 0;
        r6 = -1;
        r7 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r8 = r0.f10459h;
        r8 = r8.f5773e;
        r9 = r0.f10459h;
        r9 = r9.f5772d;
        r10 = -1;
        r11 = r0.f10460i;
        r11 = r11.f5760b;
        r12 = r0.f10460i;
        r12 = r12.f5761c;
        r13 = 0;
        r14 = 0;
        r16 = 0;
        r15 = r0.f10456e;
        r15 = r15 & 2;
        if (r15 == 0) goto L_0x0064;
    L_0x0060:
        r15 = 0;
    L_0x0061:
        r17 = r15;
        goto L_0x0067;
    L_0x0064:
        r15 = r0.f10464m;
        goto L_0x0061;
    L_0x0067:
        r15 = 0;
        r3 = com.google.android.exoplayer2.C2515k.m6986a(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
        r1.mo2199a(r3);
    L_0x006f:
        r1 = r18.m12898b(r19);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.c.b.a(com.google.android.exoplayer2.e.f, com.google.android.exoplayer2.e.k):int");
    }

    /* renamed from: b */
    private int m12898b(C2304f c2304f) {
        if (this.f10468q == 0) {
            c2304f.mo2183a();
            if (!c2304f.mo2188b(this.f10458g.f6441a, 0, 4, true)) {
                return -1;
            }
            this.f10458g.m7096c(0);
            int o = this.f10458g.m7111o();
            if (C4105b.m12896a(o, (long) this.f10463l)) {
                if (C2325j.m6448a(o) != -1) {
                    C2325j.m6450a(o, this.f10459h);
                    if (this.f10466o == -9223372036854775807L) {
                        this.f10466o = this.f10465n.mo3195a(c2304f.mo2189c());
                        if (this.f10457f != -9223372036854775807L) {
                            this.f10466o += this.f10457f - this.f10465n.mo3195a(0);
                        }
                    }
                    this.f10468q = this.f10459h.f5771c;
                }
            }
            c2304f.mo2186b(1);
            this.f10463l = 0;
            return 0;
        }
        c2304f = this.f10462k.mo2197a(c2304f, this.f10468q, true);
        if (c2304f == -1) {
            return -1;
        }
        this.f10468q -= c2304f;
        if (this.f10468q > null) {
            return 0;
        }
        this.f10462k.mo2198a(this.f10466o + ((this.f10467p * 1000000) / ((long) this.f10459h.f5772d)), 1, this.f10459h.f5771c, 0, null);
        this.f10467p += (long) this.f10459h.f5775g;
        this.f10468q = 0;
        return 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private boolean m12897a(com.google.android.exoplayer2.p137e.C2304f r13, boolean r14) {
        /*
        r12 = this;
        if (r14 == 0) goto L_0x0005;
    L_0x0002:
        r0 = 16384; // 0x4000 float:2.2959E-41 double:8.0948E-320;
        goto L_0x0007;
    L_0x0005:
        r0 = 131072; // 0x20000 float:1.83671E-40 double:6.47582E-319;
    L_0x0007:
        r13.mo2183a();
        r1 = r13.mo2189c();
        r3 = 0;
        r5 = 0;
        r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r1 != 0) goto L_0x0027;
    L_0x0015:
        r12.m12899c(r13);
        r1 = r13.mo2185b();
        r1 = (int) r1;
        if (r14 != 0) goto L_0x0022;
    L_0x001f:
        r13.mo2186b(r1);
    L_0x0022:
        r4 = r1;
        r1 = 0;
        r2 = 0;
        r3 = 0;
        goto L_0x002b;
    L_0x0027:
        r1 = 0;
        r2 = 0;
        r3 = 0;
        r4 = 0;
    L_0x002b:
        r6 = r12.f10458g;
        r6 = r6.f6441a;
        r7 = 1;
        if (r1 <= 0) goto L_0x0034;
    L_0x0032:
        r8 = 1;
        goto L_0x0035;
    L_0x0034:
        r8 = 0;
    L_0x0035:
        r9 = 4;
        r6 = r13.mo2188b(r6, r5, r9, r8);
        if (r6 != 0) goto L_0x003d;
    L_0x003c:
        goto L_0x0086;
    L_0x003d:
        r6 = r12.f10458g;
        r6.m7096c(r5);
        r6 = r12.f10458g;
        r6 = r6.m7111o();
        if (r2 == 0) goto L_0x0051;
    L_0x004a:
        r10 = (long) r2;
        r8 = com.google.android.exoplayer2.p137e.p196c.C4105b.m12896a(r6, r10);
        if (r8 == 0) goto L_0x0058;
    L_0x0051:
        r8 = com.google.android.exoplayer2.p137e.C2325j.m6448a(r6);
        r10 = -1;
        if (r8 != r10) goto L_0x0079;
    L_0x0058:
        r1 = r3 + 1;
        if (r3 != r0) goto L_0x0067;
    L_0x005c:
        if (r14 == 0) goto L_0x005f;
    L_0x005e:
        return r5;
    L_0x005f:
        r13 = new com.google.android.exoplayer2.p;
        r14 = "Searched too many bytes.";
        r13.<init>(r14);
        throw r13;
    L_0x0067:
        if (r14 == 0) goto L_0x0072;
    L_0x0069:
        r13.mo2183a();
        r2 = r4 + r1;
        r13.mo2190c(r2);
        goto L_0x0075;
    L_0x0072:
        r13.mo2186b(r7);
    L_0x0075:
        r3 = r1;
        r1 = 0;
        r2 = 0;
        goto L_0x002b;
    L_0x0079:
        r1 = r1 + 1;
        if (r1 != r7) goto L_0x0084;
    L_0x007d:
        r2 = r12.f10459h;
        com.google.android.exoplayer2.p137e.C2325j.m6450a(r6, r2);
        r2 = r6;
        goto L_0x0093;
    L_0x0084:
        if (r1 != r9) goto L_0x0093;
    L_0x0086:
        if (r14 == 0) goto L_0x008d;
    L_0x0088:
        r4 = r4 + r3;
        r13.mo2186b(r4);
        goto L_0x0090;
    L_0x008d:
        r13.mo2183a();
    L_0x0090:
        r12.f10463l = r2;
        return r7;
    L_0x0093:
        r8 = r8 + -4;
        r13.mo2190c(r8);
        goto L_0x002b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.c.b.a(com.google.android.exoplayer2.e.f, boolean):boolean");
    }

    /* renamed from: c */
    private void m12899c(C2304f c2304f) {
        int i = 0;
        while (true) {
            c2304f.mo2191c(this.f10458g.f6441a, 0, 10);
            this.f10458g.m7096c(0);
            if (this.f10458g.m7107k() != C4162g.f10796a) {
                c2304f.mo2183a();
                c2304f.mo2190c(i);
                return;
            }
            this.f10458g.m7098d(3);
            int t = this.f10458g.m7116t();
            int i2 = t + 10;
            if (this.f10464m == null) {
                byte[] bArr = new byte[i2];
                System.arraycopy(this.f10458g.f6441a, 0, bArr, 0, 10);
                c2304f.mo2191c(bArr, 10, t);
                this.f10464m = new C4162g((this.f10456e & 2) != 0 ? C2324i.f5758a : null).m13254a(bArr, i2);
                if (this.f10464m != null) {
                    this.f10460i.m6447a(this.f10464m);
                }
            } else {
                c2304f.mo2190c(t);
            }
            i += i2;
        }
    }

    /* renamed from: d */
    private C4104a m12900d(C2304f c2304f) {
        int i;
        int a;
        C4104a a2;
        C2529l c2529l = new C2529l(this.f10459h.f5771c);
        c2304f.mo2191c(c2529l.f6441a, 0, this.f10459h.f5771c);
        if ((this.f10459h.f5769a & 1) != 0) {
            if (this.f10459h.f5773e != 1) {
                i = 36;
                a = C4105b.m12895a(c2529l, i);
                if (a != f10453b) {
                    if (a == f10454c) {
                        if (a == f10455d) {
                            a2 = C4693c.m16040a(c2304f.mo2192d(), c2304f.mo2189c(), this.f10459h, c2529l);
                            c2304f.mo2186b(this.f10459h.f5771c);
                        } else {
                            a2 = null;
                            c2304f.mo2183a();
                        }
                        return a2;
                    }
                }
                a2 = C4694d.m16046a(c2304f.mo2192d(), c2304f.mo2189c(), this.f10459h, c2529l);
                if (!(a2 == null || this.f10460i.m6445a())) {
                    c2304f.mo2183a();
                    c2304f.mo2190c(i + 141);
                    c2304f.mo2191c(this.f10458g.f6441a, 0, 3);
                    this.f10458g.m7096c(0);
                    this.f10460i.m6446a(this.f10458g.m7107k());
                }
                c2304f.mo2186b(this.f10459h.f5771c);
                if (!(a2 == null || a2.mo2167a() || a != f10454c)) {
                    return m12901e(c2304f);
                }
                return a2;
            }
        } else if (this.f10459h.f5773e == 1) {
            i = 13;
            a = C4105b.m12895a(c2529l, i);
            if (a != f10453b) {
                if (a == f10454c) {
                    if (a == f10455d) {
                        a2 = null;
                        c2304f.mo2183a();
                    } else {
                        a2 = C4693c.m16040a(c2304f.mo2192d(), c2304f.mo2189c(), this.f10459h, c2529l);
                        c2304f.mo2186b(this.f10459h.f5771c);
                    }
                    return a2;
                }
            }
            a2 = C4694d.m16046a(c2304f.mo2192d(), c2304f.mo2189c(), this.f10459h, c2529l);
            c2304f.mo2183a();
            c2304f.mo2190c(i + 141);
            c2304f.mo2191c(this.f10458g.f6441a, 0, 3);
            this.f10458g.m7096c(0);
            this.f10460i.m6446a(this.f10458g.m7107k());
            c2304f.mo2186b(this.f10459h.f5771c);
            return m12901e(c2304f);
        }
        i = 21;
        a = C4105b.m12895a(c2529l, i);
        if (a != f10453b) {
            if (a == f10454c) {
                if (a == f10455d) {
                    a2 = C4693c.m16040a(c2304f.mo2192d(), c2304f.mo2189c(), this.f10459h, c2529l);
                    c2304f.mo2186b(this.f10459h.f5771c);
                } else {
                    a2 = null;
                    c2304f.mo2183a();
                }
                return a2;
            }
        }
        a2 = C4694d.m16046a(c2304f.mo2192d(), c2304f.mo2189c(), this.f10459h, c2529l);
        c2304f.mo2183a();
        c2304f.mo2190c(i + 141);
        c2304f.mo2191c(this.f10458g.f6441a, 0, 3);
        this.f10458g.m7096c(0);
        this.f10460i.m6446a(this.f10458g.m7107k());
        c2304f.mo2186b(this.f10459h.f5771c);
        return m12901e(c2304f);
    }

    /* renamed from: e */
    private C4104a m12901e(C2304f c2304f) {
        c2304f.mo2191c(this.f10458g.f6441a, 0, 4);
        this.f10458g.m7096c(0);
        C2325j.m6450a(this.f10458g.m7111o(), this.f10459h);
        return new C4692a(c2304f.mo2192d(), c2304f.mo2189c(), this.f10459h);
    }

    /* renamed from: a */
    private static int m12895a(C2529l c2529l, int i) {
        if (c2529l.m7095c() >= i + 4) {
            c2529l.m7096c(i);
            i = c2529l.m7111o();
            if (i == f10453b || i == f10454c) {
                return i;
            }
        }
        if (c2529l.m7095c() >= 40) {
            c2529l.m7096c(36);
            if (c2529l.m7111o() == f10455d) {
                return f10455d;
            }
        }
        return null;
    }
}
