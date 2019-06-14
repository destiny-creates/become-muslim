package com.google.android.exoplayer2.p149h;

import android.net.Uri;
import android.os.Handler;
import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.C2543l;
import com.google.android.exoplayer2.p135b.C4085e;
import com.google.android.exoplayer2.p137e.C2303e;
import com.google.android.exoplayer2.p137e.C2304f;
import com.google.android.exoplayer2.p137e.C2320g;
import com.google.android.exoplayer2.p137e.C2326k;
import com.google.android.exoplayer2.p137e.C2327l;
import com.google.android.exoplayer2.p137e.C2329m;
import com.google.android.exoplayer2.p137e.C4102b;
import com.google.android.exoplayer2.p149h.C2430j.C2429a;
import com.google.android.exoplayer2.p149h.C4219h.C4218a;
import com.google.android.exoplayer2.p149h.C4220l.C2434b;
import com.google.android.exoplayer2.p163k.C2492b;
import com.google.android.exoplayer2.p163k.C2498g;
import com.google.android.exoplayer2.p163k.C2501j;
import com.google.android.exoplayer2.p163k.C4251s;
import com.google.android.exoplayer2.p163k.C4251s.C2506a;
import com.google.android.exoplayer2.p163k.C4251s.C2508c;
import com.google.android.exoplayer2.p163k.C4251s.C2509d;
import com.google.android.exoplayer2.p164l.C2516a;
import com.google.android.exoplayer2.p164l.C2520e;
import com.google.android.exoplayer2.p164l.C2524i;
import com.google.android.exoplayer2.p164l.C2541v;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: ExtractorMediaPeriod */
/* renamed from: com.google.android.exoplayer2.h.f */
final class C4722f implements C2320g, C4219h, C2434b, C2506a<C4214a>, C2509d {
    /* renamed from: A */
    private boolean[] f12807A;
    /* renamed from: B */
    private boolean[] f12808B;
    /* renamed from: C */
    private boolean f12809C;
    /* renamed from: D */
    private long f12810D;
    /* renamed from: E */
    private long f12811E;
    /* renamed from: F */
    private long f12812F;
    /* renamed from: G */
    private int f12813G;
    /* renamed from: H */
    private boolean f12814H;
    /* renamed from: I */
    private boolean f12815I;
    /* renamed from: a */
    private final Uri f12816a;
    /* renamed from: b */
    private final C2498g f12817b;
    /* renamed from: c */
    private final int f12818c;
    /* renamed from: d */
    private final C2429a f12819d;
    /* renamed from: e */
    private final C2419c f12820e;
    /* renamed from: f */
    private final C2492b f12821f;
    /* renamed from: g */
    private final String f12822g;
    /* renamed from: h */
    private final long f12823h;
    /* renamed from: i */
    private final C4251s f12824i = new C4251s("Loader:ExtractorMediaPeriod");
    /* renamed from: j */
    private final C2418b f12825j;
    /* renamed from: k */
    private final C2520e f12826k;
    /* renamed from: l */
    private final Runnable f12827l;
    /* renamed from: m */
    private final Runnable f12828m;
    /* renamed from: n */
    private final Handler f12829n;
    /* renamed from: o */
    private C4218a f12830o;
    /* renamed from: p */
    private C2327l f12831p;
    /* renamed from: q */
    private C4220l[] f12832q;
    /* renamed from: r */
    private int[] f12833r;
    /* renamed from: s */
    private boolean f12834s;
    /* renamed from: t */
    private boolean f12835t;
    /* renamed from: u */
    private int f12836u;
    /* renamed from: v */
    private boolean f12837v;
    /* renamed from: w */
    private boolean f12838w;
    /* renamed from: x */
    private int f12839x;
    /* renamed from: y */
    private C2439q f12840y;
    /* renamed from: z */
    private long f12841z;

    /* compiled from: ExtractorMediaPeriod */
    /* renamed from: com.google.android.exoplayer2.h.f$1 */
    class C24161 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C4722f f5972a;

        C24161(C4722f c4722f) {
            this.f5972a = c4722f;
        }

        public void run() {
            this.f5972a.m16182j();
        }
    }

    /* compiled from: ExtractorMediaPeriod */
    /* renamed from: com.google.android.exoplayer2.h.f$2 */
    class C24172 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C4722f f5973a;

        C24172(C4722f c4722f) {
            this.f5973a = c4722f;
        }

        public void run() {
            if (!this.f5973a.f12815I) {
                this.f5973a.f12830o.mo3205a(this.f5973a);
            }
        }
    }

    /* compiled from: ExtractorMediaPeriod */
    /* renamed from: com.google.android.exoplayer2.h.f$b */
    private static final class C2418b {
        /* renamed from: a */
        private final C2303e[] f5974a;
        /* renamed from: b */
        private final C2320g f5975b;
        /* renamed from: c */
        private C2303e f5976c;

        public C2418b(C2303e[] c2303eArr, C2320g c2320g) {
            this.f5974a = c2303eArr;
            this.f5975b = c2320g;
        }

        /* renamed from: a */
        public com.google.android.exoplayer2.p137e.C2303e m6652a(com.google.android.exoplayer2.p137e.C2304f r6, android.net.Uri r7) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r5 = this;
            r0 = r5.f5976c;
            if (r0 == 0) goto L_0x0007;
        L_0x0004:
            r6 = r5.f5976c;
            return r6;
        L_0x0007:
            r0 = r5.f5974a;
            r1 = r0.length;
            r2 = 0;
        L_0x000b:
            if (r2 >= r1) goto L_0x0026;
        L_0x000d:
            r3 = r0[r2];
            r4 = r3.mo2165a(r6);	 Catch:{ EOFException -> 0x0020, all -> 0x001b }
            if (r4 == 0) goto L_0x0020;	 Catch:{ EOFException -> 0x0020, all -> 0x001b }
        L_0x0015:
            r5.f5976c = r3;	 Catch:{ EOFException -> 0x0020, all -> 0x001b }
            r6.mo2183a();
            goto L_0x0026;
        L_0x001b:
            r7 = move-exception;
            r6.mo2183a();
            throw r7;
        L_0x0020:
            r6.mo2183a();
            r2 = r2 + 1;
            goto L_0x000b;
        L_0x0026:
            r6 = r5.f5976c;
            if (r6 == 0) goto L_0x0034;
        L_0x002a:
            r6 = r5.f5976c;
            r7 = r5.f5975b;
            r6.mo2164a(r7);
            r6 = r5.f5976c;
            return r6;
        L_0x0034:
            r6 = new com.google.android.exoplayer2.h.r;
            r0 = new java.lang.StringBuilder;
            r0.<init>();
            r1 = "None of the available extractors (";
            r0.append(r1);
            r1 = r5.f5974a;
            r1 = com.google.android.exoplayer2.p164l.C2541v.m7172a(r1);
            r0.append(r1);
            r1 = ") could read the stream.";
            r0.append(r1);
            r0 = r0.toString();
            r6.<init>(r0, r7);
            throw r6;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.h.f.b.a(com.google.android.exoplayer2.e.f, android.net.Uri):com.google.android.exoplayer2.e.e");
        }

        /* renamed from: a */
        public void m6653a() {
            if (this.f5976c != null) {
                this.f5976c.mo2166c();
                this.f5976c = null;
            }
        }
    }

    /* compiled from: ExtractorMediaPeriod */
    /* renamed from: com.google.android.exoplayer2.h.f$c */
    interface C2419c {
        /* renamed from: a */
        void mo2290a(long j, boolean z);
    }

    /* compiled from: ExtractorMediaPeriod */
    /* renamed from: com.google.android.exoplayer2.h.f$a */
    final class C4214a implements C2508c {
        /* renamed from: a */
        final /* synthetic */ C4722f f11073a;
        /* renamed from: b */
        private final Uri f11074b;
        /* renamed from: c */
        private final C2498g f11075c;
        /* renamed from: d */
        private final C2418b f11076d;
        /* renamed from: e */
        private final C2520e f11077e;
        /* renamed from: f */
        private final C2326k f11078f = new C2326k();
        /* renamed from: g */
        private volatile boolean f11079g;
        /* renamed from: h */
        private boolean f11080h = true;
        /* renamed from: i */
        private long f11081i;
        /* renamed from: j */
        private C2501j f11082j;
        /* renamed from: k */
        private long f11083k = -1;
        /* renamed from: l */
        private long f11084l;

        public C4214a(C4722f c4722f, Uri uri, C2498g c2498g, C2418b c2418b, C2520e c2520e) {
            this.f11073a = c4722f;
            this.f11074b = (Uri) C2516a.m7015a((Object) uri);
            this.f11075c = (C2498g) C2516a.m7015a((Object) c2498g);
            this.f11076d = (C2418b) C2516a.m7015a((Object) c2418b);
            this.f11077e = c2520e;
        }

        /* renamed from: a */
        public void m13628a(long j, long j2) {
            this.f11078f.f5776a = j;
            this.f11081i = j2;
            this.f11080h = 1;
        }

        /* renamed from: a */
        public void mo2282a() {
            this.f11079g = true;
        }

        /* renamed from: b */
        public boolean mo2283b() {
            return this.f11079g;
        }

        /* renamed from: c */
        public void mo2284c() {
            Throwable th;
            int i = 0;
            while (i == 0 && !this.f11079g) {
                try {
                    long j = this.f11078f.f5776a;
                    this.f11082j = new C2501j(this.f11074b, j, -1, this.f11073a.f12822g);
                    this.f11083k = this.f11075c.mo2268a(this.f11082j);
                    if (this.f11083k != -1) {
                        this.f11083k += j;
                    }
                    C2304f c4102b = new C4102b(this.f11075c, j, this.f11083k);
                    try {
                        C2303e a = this.f11076d.m6652a(c4102b, this.f11075c.mo2269a());
                        if (this.f11080h) {
                            a.mo2163a(j, this.f11081i);
                            this.f11080h = false;
                        }
                        while (i == 0 && !this.f11079g) {
                            this.f11077e.m7040c();
                            int a2 = a.mo2162a(c4102b, this.f11078f);
                            try {
                                if (c4102b.mo2189c() > this.f11073a.f12823h + j) {
                                    j = c4102b.mo2189c();
                                    this.f11077e.m7039b();
                                    this.f11073a.f12829n.post(this.f11073a.f12828m);
                                }
                                i = a2;
                            } catch (Throwable th2) {
                                th = th2;
                                i = a2;
                            }
                        }
                        if (i == 1) {
                            i = 0;
                        } else {
                            this.f11078f.f5776a = c4102b.mo2189c();
                            this.f11084l = this.f11078f.f5776a - this.f11082j.f6351c;
                        }
                        C2541v.m7174a(this.f11075c);
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    C2304f c2304f = null;
                }
            }
            return;
            if (!(i == 1 || c2304f == null)) {
                this.f11078f.f5776a = c2304f.mo2189c();
                this.f11084l = this.f11078f.f5776a - this.f11082j.f6351c;
            }
            C2541v.m7174a(this.f11075c);
            throw th;
        }
    }

    /* compiled from: ExtractorMediaPeriod */
    /* renamed from: com.google.android.exoplayer2.h.f$d */
    private final class C4215d implements C2435m {
        /* renamed from: a */
        final /* synthetic */ C4722f f11085a;
        /* renamed from: b */
        private final int f11086b;

        public C4215d(C4722f c4722f, int i) {
            this.f11085a = c4722f;
            this.f11086b = i;
        }

        /* renamed from: c */
        public boolean mo2236c() {
            return this.f11085a.m16202a(this.f11086b);
        }

        public void f_() {
            this.f11085a.m16211h();
        }

        /* renamed from: a */
        public int mo2235a(C2543l c2543l, C4085e c4085e, boolean z) {
            return this.f11085a.m16188a(this.f11086b, c2543l, c4085e, z);
        }

        /* renamed from: a */
        public int mo2234a(long j) {
            return this.f11085a.m16187a(this.f11086b, j);
        }
    }

    public C4722f(Uri uri, C2498g c2498g, C2303e[] c2303eArr, int i, C2429a c2429a, C2419c c2419c, C2492b c2492b, String str, int i2) {
        this.f12816a = uri;
        this.f12817b = c2498g;
        this.f12818c = i;
        this.f12819d = c2429a;
        this.f12820e = c2419c;
        this.f12821f = c2492b;
        this.f12822g = str;
        this.f12823h = (long) i2;
        this.f12825j = new C2418b(c2303eArr, this);
        this.f12826k = new C2520e();
        this.f12827l = new C24161(this);
        this.f12828m = new C24172(this);
        this.f12829n = new Handler();
        this.f12833r = new int[0];
        this.f12832q = new C4220l[0];
        this.f12812F = 1;
        this.f12810D = -1;
        if (i == -1) {
            i = 3;
        }
        this.f12836u = i;
    }

    /* renamed from: f */
    public void m16209f() {
        boolean a = this.f12824i.m13800a((C2509d) this);
        if (this.f12835t && !a) {
            for (C4220l k : this.f12832q) {
                k.m13683k();
            }
        }
        this.f12829n.removeCallbacksAndMessages(null);
        this.f12815I = true;
    }

    /* renamed from: g */
    public void mo2244g() {
        this.f12825j.m6653a();
        for (C4220l a : this.f12832q) {
            a.m13663a();
        }
    }

    /* renamed from: a */
    public void mo3204a(C4218a c4218a, long j) {
        this.f12830o = c4218a;
        this.f12826k.m7038a();
        m16183k();
    }

    public void e_() {
        m16211h();
    }

    /* renamed from: b */
    public C2439q mo3207b() {
        return this.f12840y;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public long mo3202a(com.google.android.exoplayer2.p162j.C2484f[] r7, boolean[] r8, com.google.android.exoplayer2.p149h.C2435m[] r9, boolean[] r10, long r11) {
        /*
        r6 = this;
        r0 = r6.f12835t;
        com.google.android.exoplayer2.p164l.C2516a.m7019b(r0);
        r0 = r6.f12839x;
        r1 = 0;
        r2 = 0;
    L_0x0009:
        r3 = r7.length;
        r4 = 1;
        if (r2 >= r3) goto L_0x0037;
    L_0x000d:
        r3 = r9[r2];
        if (r3 == 0) goto L_0x0034;
    L_0x0011:
        r3 = r7[r2];
        if (r3 == 0) goto L_0x0019;
    L_0x0015:
        r3 = r8[r2];
        if (r3 != 0) goto L_0x0034;
    L_0x0019:
        r3 = r9[r2];
        r3 = (com.google.android.exoplayer2.p149h.C4722f.C4215d) r3;
        r3 = r3.f11086b;
        r5 = r6.f12807A;
        r5 = r5[r3];
        com.google.android.exoplayer2.p164l.C2516a.m7019b(r5);
        r5 = r6.f12839x;
        r5 = r5 - r4;
        r6.f12839x = r5;
        r4 = r6.f12807A;
        r4[r3] = r1;
        r3 = 0;
        r9[r2] = r3;
    L_0x0034:
        r2 = r2 + 1;
        goto L_0x0009;
    L_0x0037:
        r8 = r6.f12837v;
        if (r8 == 0) goto L_0x0041;
    L_0x003b:
        if (r0 != 0) goto L_0x003f;
    L_0x003d:
        r8 = 1;
        goto L_0x0048;
    L_0x003f:
        r8 = 0;
        goto L_0x0048;
    L_0x0041:
        r2 = 0;
        r8 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1));
        if (r8 == 0) goto L_0x003f;
    L_0x0047:
        goto L_0x003d;
    L_0x0048:
        r0 = r8;
        r8 = 0;
    L_0x004a:
        r2 = r7.length;
        if (r8 >= r2) goto L_0x00af;
    L_0x004d:
        r2 = r9[r8];
        if (r2 != 0) goto L_0x00ac;
    L_0x0051:
        r2 = r7[r8];
        if (r2 == 0) goto L_0x00ac;
    L_0x0055:
        r2 = r7[r8];
        r3 = r2.mo2306g();
        if (r3 != r4) goto L_0x005f;
    L_0x005d:
        r3 = 1;
        goto L_0x0060;
    L_0x005f:
        r3 = 0;
    L_0x0060:
        com.google.android.exoplayer2.p164l.C2516a.m7019b(r3);
        r3 = r2.mo2301b(r1);
        if (r3 != 0) goto L_0x006b;
    L_0x0069:
        r3 = 1;
        goto L_0x006c;
    L_0x006b:
        r3 = 0;
    L_0x006c:
        com.google.android.exoplayer2.p164l.C2516a.m7019b(r3);
        r3 = r6.f12840y;
        r2 = r2.mo2305f();
        r2 = r3.m6713a(r2);
        r3 = r6.f12807A;
        r3 = r3[r2];
        r3 = r3 ^ r4;
        com.google.android.exoplayer2.p164l.C2516a.m7019b(r3);
        r3 = r6.f12839x;
        r3 = r3 + r4;
        r6.f12839x = r3;
        r3 = r6.f12807A;
        r3[r2] = r4;
        r3 = new com.google.android.exoplayer2.h.f$d;
        r3.<init>(r6, r2);
        r9[r8] = r3;
        r10[r8] = r4;
        if (r0 != 0) goto L_0x00ac;
    L_0x0095:
        r0 = r6.f12832q;
        r0 = r0[r2];
        r0.m13681i();
        r2 = r0.m13672b(r11, r4, r4);
        r3 = -1;
        if (r2 != r3) goto L_0x00ab;
    L_0x00a3:
        r0 = r0.m13677e();
        if (r0 == 0) goto L_0x00ab;
    L_0x00a9:
        r0 = 1;
        goto L_0x00ac;
    L_0x00ab:
        r0 = 0;
    L_0x00ac:
        r8 = r8 + 1;
        goto L_0x004a;
    L_0x00af:
        r7 = r6.f12839x;
        if (r7 != 0) goto L_0x00dd;
    L_0x00b3:
        r6.f12838w = r1;
        r7 = r6.f12824i;
        r7 = r7.m13799a();
        if (r7 == 0) goto L_0x00d0;
    L_0x00bd:
        r7 = r6.f12832q;
        r8 = r7.length;
    L_0x00c0:
        if (r1 >= r8) goto L_0x00ca;
    L_0x00c2:
        r9 = r7[r1];
        r9.m13683k();
        r1 = r1 + 1;
        goto L_0x00c0;
    L_0x00ca:
        r7 = r6.f12824i;
        r7.m13801b();
        goto L_0x00ef;
    L_0x00d0:
        r7 = r6.f12832q;
        r8 = r7.length;
    L_0x00d3:
        if (r1 >= r8) goto L_0x00ef;
    L_0x00d5:
        r9 = r7[r1];
        r9.m13663a();
        r1 = r1 + 1;
        goto L_0x00d3;
    L_0x00dd:
        if (r0 == 0) goto L_0x00ef;
    L_0x00df:
        r11 = r6.mo3206b(r11);
    L_0x00e3:
        r7 = r9.length;
        if (r1 >= r7) goto L_0x00ef;
    L_0x00e6:
        r7 = r9[r1];
        if (r7 == 0) goto L_0x00ec;
    L_0x00ea:
        r10[r1] = r4;
    L_0x00ec:
        r1 = r1 + 1;
        goto L_0x00e3;
    L_0x00ef:
        r6.f12837v = r4;
        return r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.h.f.a(com.google.android.exoplayer2.j.f[], boolean[], com.google.android.exoplayer2.h.m[], boolean[], long):long");
    }

    /* renamed from: a */
    public void mo3203a(long j) {
        int length = this.f12832q.length;
        for (int i = 0; i < length; i++) {
            this.f12832q[i].m13667a(j, false, this.f12807A[i]);
        }
    }

    /* renamed from: c */
    public boolean mo2241c(long j) {
        if (this.f12814H == null) {
            if (this.f12835t == null || this.f12839x != null) {
                j = this.f12826k.m7038a();
                if (!this.f12824i.m13799a()) {
                    m16183k();
                    j = 1;
                }
                return j;
            }
        }
        return 0;
    }

    /* renamed from: e */
    public long mo2243e() {
        return this.f12839x == 0 ? Long.MIN_VALUE : mo2242d();
    }

    /* renamed from: c */
    public long mo3208c() {
        if (!this.f12838w || (!this.f12814H && m16184l() <= this.f12813G)) {
            return -9223372036854775807L;
        }
        this.f12838w = false;
        return this.f12811E;
    }

    /* renamed from: d */
    public long mo2242d() {
        if (this.f12814H) {
            return Long.MIN_VALUE;
        }
        if (m16186n()) {
            return this.f12812F;
        }
        long j;
        if (this.f12809C) {
            j = Clock.MAX_TIME;
            int length = this.f12832q.length;
            for (int i = 0; i < length; i++) {
                if (this.f12808B[i]) {
                    j = Math.min(j, this.f12832q[i].m13680h());
                }
            }
        } else {
            j = m16185m();
        }
        if (j == Long.MIN_VALUE) {
            j = this.f12811E;
        }
        return j;
    }

    /* renamed from: b */
    public long mo3206b(long j) {
        if (!this.f12831p.mo2167a()) {
            j = 0;
        }
        this.f12811E = j;
        int i = 0;
        this.f12838w = false;
        if (!m16186n() && m16177d(j)) {
            return j;
        }
        this.f12812F = j;
        this.f12814H = false;
        if (this.f12824i.m13799a()) {
            this.f12824i.m13801b();
        } else {
            C4220l[] c4220lArr = this.f12832q;
            int length = c4220lArr.length;
            while (i < length) {
                c4220lArr[i].m13663a();
                i++;
            }
        }
        return j;
    }

    /* renamed from: a */
    boolean m16202a(int i) {
        return !m16181i() && (this.f12814H || this.f12832q[i].m13676d() != 0);
    }

    /* renamed from: h */
    void m16211h() {
        this.f12824i.m13798a(this.f12836u);
    }

    /* renamed from: a */
    int m16188a(int i, C2543l c2543l, C4085e c4085e, boolean z) {
        if (m16181i()) {
            return -3;
        }
        return this.f12832q[i].m13662a(c2543l, c4085e, z, this.f12814H, this.f12811E);
    }

    /* renamed from: a */
    int m16187a(int i, long j) {
        if (m16181i()) {
            return 0;
        }
        i = this.f12832q[i];
        if (this.f12814H && j > i.m13680h()) {
            return i.m13684l();
        }
        i = i.m13672b(j, true, true);
        if (i == -1) {
            i = 0;
        }
        return i;
    }

    /* renamed from: i */
    private boolean m16181i() {
        if (!this.f12838w) {
            if (!m16186n()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public void m16196a(C4214a c4214a, long j, long j2) {
        if (this.f12841z == -9223372036854775807L) {
            long m = m16185m();
            r0.f12841z = m == Long.MIN_VALUE ? 0 : m + 10000;
            r0.f12820e.mo2290a(r0.f12841z, r0.f12831p.mo2167a());
        }
        r0.f12819d.m6669a(c4214a.f11082j, 1, -1, null, 0, null, 0, r0.f12841z, j, j2, c4214a.f11084l);
        m16170a(c4214a);
        r0.f12814H = true;
        r0.f12830o.mo3205a(r0);
    }

    /* renamed from: a */
    public void m16197a(C4214a c4214a, long j, long j2, boolean z) {
        this.f12819d.m6674b(c4214a.f11082j, 1, -1, null, 0, null, 0, this.f12841z, j, j2, c4214a.f11084l);
        if (!z) {
            m16170a(c4214a);
            for (C4220l a : r0.f12832q) {
                a.m13663a();
            }
            if (r0.f12839x > 0) {
                r0.f12830o.mo3205a(r0);
            }
        }
    }

    /* renamed from: a */
    public int m16189a(C4214a c4214a, long j, long j2, IOException iOException) {
        long j3 = j;
        long j4 = j2;
        IOException iOException2 = iOException;
        boolean a = m16172a(iOException);
        this.f12819d.m6670a(c4214a.f11082j, 1, -1, null, 0, null, 0, this.f12841z, j3, j4, c4214a.f11084l, iOException2, a);
        m16170a(c4214a);
        if (a) {
            return 3;
        }
        int i = m16184l() > r0.f12813G ? 1 : 0;
        m16173b(c4214a);
        r0.f12813G = m16184l();
        return i;
    }

    /* renamed from: a */
    public C2329m mo2231a(int i, int i2) {
        i2 = this.f12832q.length;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.f12833r[i3] == i) {
                return this.f12832q[i3];
            }
        }
        C2329m c4220l = new C4220l(this.f12821f);
        c4220l.m13668a((C2434b) this);
        int i4 = i2 + 1;
        this.f12833r = Arrays.copyOf(this.f12833r, i4);
        this.f12833r[i2] = i;
        this.f12832q = (C4220l[]) Arrays.copyOf(this.f12832q, i4);
        this.f12832q[i2] = c4220l;
        return c4220l;
    }

    /* renamed from: a */
    public void mo2232a() {
        this.f12834s = true;
        this.f12829n.post(this.f12827l);
    }

    /* renamed from: a */
    public void mo2233a(C2327l c2327l) {
        this.f12831p = c2327l;
        this.f12829n.post(this.f12827l);
    }

    /* renamed from: a */
    public void mo2274a(C2515k c2515k) {
        this.f12829n.post(this.f12827l);
    }

    /* renamed from: j */
    private void m16182j() {
        if (!(this.f12815I || this.f12835t || this.f12831p == null)) {
            if (this.f12834s) {
                C4220l[] c4220lArr = this.f12832q;
                int length = c4220lArr.length;
                int i = 0;
                while (i < length) {
                    if (c4220lArr[i].m13679g() != null) {
                        i++;
                    } else {
                        return;
                    }
                }
                this.f12826k.m7039b();
                int length2 = this.f12832q.length;
                C2438p[] c2438pArr = new C2438p[length2];
                this.f12808B = new boolean[length2];
                this.f12807A = new boolean[length2];
                this.f12841z = this.f12831p.mo2168b();
                i = 0;
                while (true) {
                    boolean z = true;
                    if (i >= length2) {
                        break;
                    }
                    c2438pArr[i] = new C2438p(this.f12832q[i].m13679g());
                    String str = r5.f6380f;
                    if (!C2524i.m7051b(str)) {
                        if (!C2524i.m7050a(str)) {
                            z = false;
                        }
                    }
                    this.f12808B[i] = z;
                    this.f12809C = z | this.f12809C;
                    i++;
                }
                this.f12840y = new C2439q(c2438pArr);
                if (this.f12818c == -1 && this.f12810D == -1 && this.f12831p.mo2168b() == -9223372036854775807L) {
                    this.f12836u = 6;
                }
                this.f12835t = true;
                this.f12820e.mo2290a(this.f12841z, this.f12831p.mo2167a());
                this.f12830o.mo3223a(this);
            }
        }
    }

    /* renamed from: a */
    private void m16170a(C4214a c4214a) {
        if (this.f12810D == -1) {
            this.f12810D = c4214a.f11083k;
        }
    }

    /* renamed from: k */
    private void m16183k() {
        C2508c c4214a = new C4214a(this, this.f12816a, this.f12817b, this.f12825j, this.f12826k);
        if (this.f12835t) {
            C2516a.m7019b(m16186n());
            if (this.f12841z == -9223372036854775807L || this.f12812F < this.f12841z) {
                c4214a.m13628a(this.f12831p.mo2169b(this.f12812F), this.f12812F);
                this.f12812F = -9223372036854775807L;
            } else {
                this.f12814H = true;
                this.f12812F = -9223372036854775807L;
                return;
            }
        }
        this.f12813G = m16184l();
        this.f12824i.m13797a(c4214a, this, this.f12836u);
    }

    /* renamed from: b */
    private void m16173b(C4214a c4214a) {
        if (this.f12810D != -1) {
            return;
        }
        if (this.f12831p == null || this.f12831p.mo2168b() == -9223372036854775807L) {
            this.f12811E = 0;
            this.f12838w = this.f12835t;
            for (C4220l a : this.f12832q) {
                a.m13663a();
            }
            c4214a.m13628a(0, 0);
        }
    }

    /* renamed from: d */
    private boolean m16177d(long j) {
        int length = this.f12832q.length;
        int i = 0;
        while (true) {
            boolean z = true;
            if (i >= length) {
                return true;
            }
            C4220l c4220l = this.f12832q[i];
            c4220l.m13681i();
            if (c4220l.m13672b(j, true, false) == -1) {
                z = false;
            }
            if (z || (!this.f12808B[i] && this.f12809C)) {
                c4220l.m13682j();
                i++;
            }
        }
        return false;
    }

    /* renamed from: l */
    private int m16184l() {
        int i = 0;
        for (C4220l c : this.f12832q) {
            i += c.m13675c();
        }
        return i;
    }

    /* renamed from: m */
    private long m16185m() {
        long j = Long.MIN_VALUE;
        for (C4220l h : this.f12832q) {
            j = Math.max(j, h.m13680h());
        }
        return j;
    }

    /* renamed from: n */
    private boolean m16186n() {
        return this.f12812F != -9223372036854775807L;
    }

    /* renamed from: a */
    private boolean m16172a(IOException iOException) {
        return iOException instanceof C4222r;
    }
}
