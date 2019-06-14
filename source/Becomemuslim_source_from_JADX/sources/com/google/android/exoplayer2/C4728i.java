package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.C2570o.C2569a;
import com.google.android.exoplayer2.C2589y.C2587a;
import com.google.android.exoplayer2.C2589y.C2588b;
import com.google.android.exoplayer2.C4159f.C2332c;
import com.google.android.exoplayer2.p149h.C2423i;
import com.google.android.exoplayer2.p149h.C2423i.C2421a;
import com.google.android.exoplayer2.p149h.C2423i.C2422b;
import com.google.android.exoplayer2.p149h.C2435m;
import com.google.android.exoplayer2.p149h.C2437n;
import com.google.android.exoplayer2.p149h.C4213e;
import com.google.android.exoplayer2.p149h.C4219h;
import com.google.android.exoplayer2.p149h.C4219h.C4218a;
import com.google.android.exoplayer2.p149h.C4719c;
import com.google.android.exoplayer2.p162j.C2484f;
import com.google.android.exoplayer2.p162j.C2485g;
import com.google.android.exoplayer2.p162j.C2487h;
import com.google.android.exoplayer2.p162j.C2487h.C2486a;
import com.google.android.exoplayer2.p162j.C2488i;
import com.google.android.exoplayer2.p164l.C2516a;
import com.google.android.exoplayer2.p164l.C2523h;
import com.google.android.exoplayer2.p164l.C2538t;
import com.google.android.exoplayer2.p164l.C4254q;
import java.io.IOException;

/* compiled from: ExoPlayerImplInternal */
/* renamed from: com.google.android.exoplayer2.i */
final class C4728i implements Callback, C4218a, C2421a, C2486a {
    /* renamed from: A */
    private int f12874A;
    /* renamed from: B */
    private long f12875B;
    /* renamed from: C */
    private int f12876C;
    /* renamed from: D */
    private int f12877D;
    /* renamed from: E */
    private C2442c f12878E;
    /* renamed from: F */
    private long f12879F;
    /* renamed from: G */
    private C2440a f12880G;
    /* renamed from: H */
    private C2440a f12881H;
    /* renamed from: I */
    private C2440a f12882I;
    /* renamed from: a */
    private final C4256t[] f12883a;
    /* renamed from: b */
    private final C2576u[] f12884b;
    /* renamed from: c */
    private final C2487h f12885c;
    /* renamed from: d */
    private final C2567n f12886d;
    /* renamed from: e */
    private final C4254q f12887e;
    /* renamed from: f */
    private final Handler f12888f;
    /* renamed from: g */
    private final HandlerThread f12889g;
    /* renamed from: h */
    private final Handler f12890h;
    /* renamed from: i */
    private final C4159f f12891i;
    /* renamed from: j */
    private final C2588b f12892j;
    /* renamed from: k */
    private final C2587a f12893k;
    /* renamed from: l */
    private final C2570o f12894l;
    /* renamed from: m */
    private C2572q f12895m;
    /* renamed from: n */
    private C2573r f12896n;
    /* renamed from: o */
    private C4256t f12897o;
    /* renamed from: p */
    private C2523h f12898p;
    /* renamed from: q */
    private C2423i f12899q;
    /* renamed from: r */
    private C4256t[] f12900r;
    /* renamed from: s */
    private boolean f12901s;
    /* renamed from: t */
    private boolean f12902t;
    /* renamed from: u */
    private boolean f12903u;
    /* renamed from: v */
    private boolean f12904v;
    /* renamed from: w */
    private int f12905w = 1;
    /* renamed from: x */
    private int f12906x;
    /* renamed from: y */
    private boolean f12907y;
    /* renamed from: z */
    private int f12908z;

    /* compiled from: ExoPlayerImplInternal */
    /* renamed from: com.google.android.exoplayer2.i$a */
    private static final class C2440a {
        /* renamed from: a */
        public final C4219h f6071a;
        /* renamed from: b */
        public final Object f6072b;
        /* renamed from: c */
        public final int f6073c;
        /* renamed from: d */
        public final C2435m[] f6074d;
        /* renamed from: e */
        public final boolean[] f6075e;
        /* renamed from: f */
        public final long f6076f;
        /* renamed from: g */
        public C2569a f6077g;
        /* renamed from: h */
        public boolean f6078h;
        /* renamed from: i */
        public boolean f6079i;
        /* renamed from: j */
        public C2440a f6080j;
        /* renamed from: k */
        public C2488i f6081k;
        /* renamed from: l */
        private final C4256t[] f6082l;
        /* renamed from: m */
        private final C2576u[] f6083m;
        /* renamed from: n */
        private final C2487h f6084n;
        /* renamed from: o */
        private final C2567n f6085o;
        /* renamed from: p */
        private final C2423i f6086p;
        /* renamed from: q */
        private C2488i f6087q;

        public C2440a(C4256t[] c4256tArr, C2576u[] c2576uArr, long j, C2487h c2487h, C2567n c2567n, C2423i c2423i, Object obj, int i, C2569a c2569a) {
            this.f6082l = c4256tArr;
            this.f6083m = c2576uArr;
            this.f6076f = j;
            this.f6084n = c2487h;
            this.f6085o = c2567n;
            this.f6086p = c2423i;
            this.f6072b = C2516a.m7015a(obj);
            this.f6073c = i;
            this.f6077g = c2569a;
            this.f6074d = new C2435m[c4256tArr.length];
            this.f6075e = new boolean[c4256tArr.length];
            c4256tArr = c2423i.mo2261a(c2569a.f6552a, c2567n.mo2157d());
            if (c2569a.f6554c != Long.MIN_VALUE) {
                c2576uArr = new C4719c(c4256tArr, 1);
                c2576uArr.m16134a(0, c2569a.f6554c);
                c4256tArr = c2576uArr;
            }
            this.f6071a = c4256tArr;
        }

        /* renamed from: a */
        public long m6721a(long j) {
            return j + m6720a();
        }

        /* renamed from: b */
        public long m6725b(long j) {
            return j - m6720a();
        }

        /* renamed from: a */
        public long m6720a() {
            return this.f6073c == 0 ? this.f6076f : this.f6076f - this.f6077g.f6553b;
        }

        /* renamed from: b */
        public boolean m6726b() {
            return this.f6078h && (!this.f6079i || this.f6071a.mo2242d() == Long.MIN_VALUE);
        }

        /* renamed from: a */
        public boolean m6724a(boolean z, long j) {
            long d;
            if (this.f6078h) {
                d = this.f6071a.mo2242d();
            } else {
                d = this.f6077g.f6553b;
            }
            if (d == Long.MIN_VALUE) {
                if (this.f6077g.f6558g) {
                    return true;
                }
                d = this.f6077g.f6556e;
            }
            return this.f6085o.mo2154a(d - m6725b(j), z);
        }

        /* renamed from: c */
        public void m6727c() {
            this.f6078h = true;
            m6730d();
            this.f6077g = this.f6077g.m7253a(m6722a(this.f6077g.f6553b, false));
        }

        /* renamed from: c */
        public boolean m6728c(long j) {
            long e = !this.f6078h ? 0 : this.f6071a.mo2243e();
            if (e == Long.MIN_VALUE) {
                return 0;
            }
            return this.f6085o.mo2153a(e - m6725b(j));
        }

        /* renamed from: d */
        public void m6729d(long j) {
            this.f6071a.mo2241c(m6725b(j));
        }

        /* renamed from: d */
        public boolean m6730d() {
            C2488i a = this.f6084n.mo2309a(this.f6083m, this.f6071a.mo3207b());
            if (a.m6936a(this.f6087q)) {
                return false;
            }
            this.f6081k = a;
            return true;
        }

        /* renamed from: a */
        public long m6722a(long j, boolean z) {
            return m6723a(j, z, new boolean[this.f6082l.length]);
        }

        /* renamed from: a */
        public long m6723a(long j, boolean z, boolean[] zArr) {
            C2485g c2485g = this.f6081k.f6335c;
            int i = 0;
            while (true) {
                boolean z2 = true;
                if (i >= c2485g.f6329a) {
                    break;
                }
                boolean[] zArr2 = r0.f6075e;
                if (z || !r0.f6081k.m6937a(r0.f6087q, i)) {
                    z2 = false;
                }
                zArr2[i] = z2;
                i++;
            }
            m6716a(r0.f6074d);
            m6715a(r0.f6081k);
            long a = r0.f6071a.mo3202a(c2485g.m6932a(), r0.f6075e, r0.f6074d, zArr, j);
            m6718b(r0.f6074d);
            r0.f6079i = false;
            for (int i2 = 0; i2 < r0.f6074d.length; i2++) {
                if (r0.f6074d[i2] != null) {
                    C2516a.m7019b(r0.f6081k.f6334b[i2]);
                    if (r0.f6083m[i2].mo3177a() != 5) {
                        r0.f6079i = true;
                    }
                } else {
                    C2516a.m7019b(c2485g.m6931a(i2) == null);
                }
            }
            r0.f6085o.mo2152a(r0.f6082l, r0.f6081k.f6333a, c2485g);
            return a;
        }

        /* renamed from: e */
        public void m6731e() {
            m6715a(null);
            try {
                if (this.f6077g.f6554c != Long.MIN_VALUE) {
                    this.f6086p.mo2264a(((C4719c) this.f6071a).f12782a);
                } else {
                    this.f6086p.mo2264a(this.f6071a);
                }
            } catch (Throwable e) {
                Log.e("ExoPlayerImplInternal", "Period release failed.", e);
            }
        }

        /* renamed from: a */
        private void m6715a(C2488i c2488i) {
            if (this.f6087q != null) {
                m6719c(this.f6087q);
            }
            this.f6087q = c2488i;
            if (this.f6087q != null) {
                m6717b(this.f6087q);
            }
        }

        /* renamed from: b */
        private void m6717b(C2488i c2488i) {
            for (int i = 0; i < c2488i.f6334b.length; i++) {
                boolean z = c2488i.f6334b[i];
                C2484f a = c2488i.f6335c.m6931a(i);
                if (z && a != null) {
                    a.mo2303d();
                }
            }
        }

        /* renamed from: c */
        private void m6719c(C2488i c2488i) {
            for (int i = 0; i < c2488i.f6334b.length; i++) {
                boolean z = c2488i.f6334b[i];
                C2484f a = c2488i.f6335c.m6931a(i);
                if (z && a != null) {
                    a.mo2304e();
                }
            }
        }

        /* renamed from: a */
        private void m6716a(C2435m[] c2435mArr) {
            for (int i = 0; i < this.f6083m.length; i++) {
                if (this.f6083m[i].mo3177a() == 5) {
                    c2435mArr[i] = null;
                }
            }
        }

        /* renamed from: b */
        private void m6718b(C2435m[] c2435mArr) {
            int i = 0;
            while (i < this.f6083m.length) {
                if (this.f6083m[i].mo3177a() == 5 && this.f6081k.f6334b[i]) {
                    c2435mArr[i] = new C4213e();
                }
                i++;
            }
        }
    }

    /* compiled from: ExoPlayerImplInternal */
    /* renamed from: com.google.android.exoplayer2.i$b */
    private static final class C2441b {
        /* renamed from: a */
        public final C2423i f6088a;
        /* renamed from: b */
        public final C2589y f6089b;
        /* renamed from: c */
        public final Object f6090c;

        public C2441b(C2423i c2423i, C2589y c2589y, Object obj) {
            this.f6088a = c2423i;
            this.f6089b = c2589y;
            this.f6090c = obj;
        }
    }

    /* compiled from: ExoPlayerImplInternal */
    /* renamed from: com.google.android.exoplayer2.i$c */
    private static final class C2442c {
        /* renamed from: a */
        public final C2589y f6091a;
        /* renamed from: b */
        public final int f6092b;
        /* renamed from: c */
        public final long f6093c;

        public C2442c(C2589y c2589y, int i, long j) {
            this.f6091a = c2589y;
            this.f6092b = i;
            this.f6093c = j;
        }
    }

    /* renamed from: a */
    public /* synthetic */ void mo3205a(C2437n c2437n) {
        m16329b((C4219h) c2437n);
    }

    public C4728i(C4256t[] c4256tArr, C2487h c2487h, C2567n c2567n, boolean z, int i, boolean z2, Handler handler, C4159f c4159f) {
        this.f12883a = c4256tArr;
        this.f12885c = c2487h;
        this.f12886d = c2567n;
        this.f12902t = z;
        this.f12906x = i;
        this.f12907y = z2;
        this.f12890h = handler;
        this.f12891i = c4159f;
        this.f12895m = new C2572q(null, null, 0, -9223372036854775807L);
        this.f12884b = new C2576u[c4256tArr.length];
        for (int i2 = false; i2 < c4256tArr.length; i2++) {
            c4256tArr[i2].mo3178a(i2);
            this.f12884b[i2] = c4256tArr[i2].mo3183b();
        }
        this.f12887e = new C4254q();
        this.f12900r = new C4256t[null];
        this.f12892j = new C2588b();
        this.f12893k = new C2587a();
        this.f12894l = new C2570o();
        c2487h.m6934a((C2486a) this);
        this.f12896n = C2573r.f6571a;
        this.f12889g = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.f12889g.start();
        this.f12888f = new Handler(this.f12889g.getLooper(), this);
    }

    /* renamed from: a */
    public void m16322a(C2423i c2423i, boolean z) {
        this.f12888f.obtainMessage(0, z, 0, c2423i).sendToTarget();
    }

    /* renamed from: a */
    public void m16326a(boolean z) {
        this.f12888f.obtainMessage(1, z, 0).sendToTarget();
    }

    /* renamed from: a */
    public void m16319a(int i) {
        this.f12888f.obtainMessage(12, i, 0).sendToTarget();
    }

    /* renamed from: a */
    public void m16325a(C2589y c2589y, int i, long j) {
        this.f12888f.obtainMessage(3, new C2442c(c2589y, i, j)).sendToTarget();
    }

    /* renamed from: a */
    public void m16324a(C2573r c2573r) {
        this.f12888f.obtainMessage(4, c2573r).sendToTarget();
    }

    /* renamed from: a */
    public void m16318a() {
        this.f12888f.sendEmptyMessage(5);
    }

    /* renamed from: a */
    public void m16327a(C2332c... c2332cArr) {
        if (this.f12901s) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            return;
        }
        this.f12908z++;
        this.f12888f.obtainMessage(11, c2332cArr).sendToTarget();
    }

    /* renamed from: b */
    public synchronized void m16330b(com.google.android.exoplayer2.C4159f.C2332c... r4) {
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
        monitor-enter(r3);
        r0 = r3.f12901s;	 Catch:{ all -> 0x0035 }
        if (r0 == 0) goto L_0x000e;	 Catch:{ all -> 0x0035 }
    L_0x0005:
        r4 = "ExoPlayerImplInternal";	 Catch:{ all -> 0x0035 }
        r0 = "Ignoring messages sent after release.";	 Catch:{ all -> 0x0035 }
        android.util.Log.w(r4, r0);	 Catch:{ all -> 0x0035 }
        monitor-exit(r3);
        return;
    L_0x000e:
        r0 = r3.f12908z;	 Catch:{ all -> 0x0035 }
        r1 = r0 + 1;	 Catch:{ all -> 0x0035 }
        r3.f12908z = r1;	 Catch:{ all -> 0x0035 }
        r1 = r3.f12888f;	 Catch:{ all -> 0x0035 }
        r2 = 11;	 Catch:{ all -> 0x0035 }
        r4 = r1.obtainMessage(r2, r4);	 Catch:{ all -> 0x0035 }
        r4.sendToTarget();	 Catch:{ all -> 0x0035 }
        r4 = 0;	 Catch:{ all -> 0x0035 }
    L_0x0020:
        r1 = r3.f12874A;	 Catch:{ all -> 0x0035 }
        if (r1 > r0) goto L_0x002a;
    L_0x0024:
        r3.wait();	 Catch:{ InterruptedException -> 0x0028 }
        goto L_0x0020;
    L_0x0028:
        r4 = 1;
        goto L_0x0020;
    L_0x002a:
        if (r4 == 0) goto L_0x0033;
    L_0x002c:
        r4 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0035 }
        r4.interrupt();	 Catch:{ all -> 0x0035 }
    L_0x0033:
        monitor-exit(r3);
        return;
    L_0x0035:
        r4 = move-exception;
        monitor-exit(r3);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.i.b(com.google.android.exoplayer2.f$c[]):void");
    }

    /* renamed from: b */
    public synchronized void m16328b() {
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
        r2 = this;
        monitor-enter(r2);
        r0 = r2.f12901s;	 Catch:{ all -> 0x0023 }
        if (r0 == 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r2);
        return;
    L_0x0007:
        r0 = r2.f12888f;	 Catch:{ all -> 0x0023 }
        r1 = 6;	 Catch:{ all -> 0x0023 }
        r0.sendEmptyMessage(r1);	 Catch:{ all -> 0x0023 }
        r0 = 0;	 Catch:{ all -> 0x0023 }
    L_0x000e:
        r1 = r2.f12901s;	 Catch:{ all -> 0x0023 }
        if (r1 != 0) goto L_0x0018;
    L_0x0012:
        r2.wait();	 Catch:{ InterruptedException -> 0x0016 }
        goto L_0x000e;
    L_0x0016:
        r0 = 1;
        goto L_0x000e;
    L_0x0018:
        if (r0 == 0) goto L_0x0021;
    L_0x001a:
        r0 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0023 }
        r0.interrupt();	 Catch:{ all -> 0x0023 }
    L_0x0021:
        monitor-exit(r2);
        return;
    L_0x0023:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.i.b():void");
    }

    /* renamed from: a */
    public void mo3249a(C2423i c2423i, C2589y c2589y, Object obj) {
        this.f12888f.obtainMessage(7, new C2441b(c2423i, c2589y, obj)).sendToTarget();
    }

    /* renamed from: a */
    public void mo3223a(C4219h c4219h) {
        this.f12888f.obtainMessage(8, c4219h).sendToTarget();
    }

    /* renamed from: b */
    public void m16329b(C4219h c4219h) {
        this.f12888f.obtainMessage(9, c4219h).sendToTarget();
    }

    public boolean handleMessage(Message message) {
        try {
            boolean z = false;
            switch (message.what) {
                case 0:
                    C2423i c2423i = (C2423i) message.obj;
                    if (message.arg1 != null) {
                        z = true;
                    }
                    m16290b(c2423i, z);
                    return true;
                case 1:
                    if (message.arg1 != null) {
                        z = true;
                    }
                    m16299c(z);
                    return true;
                case 2:
                    m16308g();
                    return true;
                case 3:
                    m16281a((C2442c) message.obj);
                    return true;
                case 4:
                    m16292b((C2573r) message.obj);
                    return true;
                case 5:
                    m16309h();
                    return true;
                case 6:
                    m16310i();
                    return true;
                case 7:
                    m16280a((C2441b) message.obj);
                    return true;
                case 8:
                    m16298c((C4219h) message.obj);
                    return true;
                case 9:
                    m16303d((C4219h) message.obj);
                    return true;
                case 10:
                    m16311j();
                    return true;
                case 11:
                    m16300c((C2332c[]) message.obj);
                    return true;
                case 12:
                    m16297c(message.arg1);
                    return true;
                case 13:
                    if (message.arg1 != null) {
                        z = true;
                    }
                    m16304d(z);
                    return true;
                default:
                    return false;
            }
        } catch (Message message2) {
            Log.e("ExoPlayerImplInternal", "Renderer error.", message2);
            this.f12890h.obtainMessage(7, message2).sendToTarget();
            m16309h();
            return true;
        } catch (IOException e) {
            Log.e("ExoPlayerImplInternal", "Source error.", e);
            this.f12890h.obtainMessage(7, C2330e.m6458a(e)).sendToTarget();
            m16309h();
            return true;
        } catch (RuntimeException e2) {
            Log.e("ExoPlayerImplInternal", "Internal runtime error.", e2);
            this.f12890h.obtainMessage(7, C2330e.m6460a(e2)).sendToTarget();
            m16309h();
            return true;
        }
    }

    /* renamed from: b */
    private void m16288b(int i) {
        if (this.f12905w != i) {
            this.f12905w = i;
            this.f12890h.obtainMessage(0, i, 0).sendToTarget();
        }
    }

    /* renamed from: b */
    private void m16294b(boolean z) {
        if (this.f12904v != z) {
            this.f12904v = z;
            this.f12890h.obtainMessage(1, z, 0).sendToTarget();
        }
    }

    /* renamed from: b */
    private void m16290b(C2423i c2423i, boolean z) {
        C2423i c2423i2 = c2423i;
        this.f12876C++;
        m16306e(true);
        this.f12886d.mo2151a();
        if (z) {
            r0.f12895m = new C2572q(null, null, 0, -9223372036854775807L);
        } else {
            r0.f12895m = new C2572q(null, null, r0.f12895m.f6566c, r0.f12895m.f6569f, r0.f12895m.f6568e);
        }
        r0.f12899q = c2423i2;
        c2423i2.mo2263a(r0.f12891i, true, r0);
        m16288b(2);
        r0.f12888f.sendEmptyMessage(2);
    }

    /* renamed from: c */
    private void m16299c(boolean z) {
        this.f12903u = false;
        this.f12902t = z;
        if (!z) {
            m16305e();
            m16307f();
        } else if (this.f12905w) {
            m16302d();
            this.f12888f.sendEmptyMessage(2);
        } else if (this.f12905w) {
            this.f12888f.sendEmptyMessage(2);
        }
    }

    /* renamed from: c */
    private void m16297c(int i) {
        this.f12906x = i;
        this.f12894l.m7265a(i);
        m16296c();
    }

    /* renamed from: d */
    private void m16304d(boolean z) {
        this.f12907y = z;
        this.f12894l.m7267a(z);
        m16296c();
    }

    /* renamed from: c */
    private void m16296c() {
        C2440a c2440a = this.f12882I != null ? this.f12882I : this.f12880G;
        if (c2440a != null) {
            int a;
            while (true) {
                a = this.f12895m.f6564a.m7321a(c2440a.f6077g.f6552a.f5978b, this.f12893k, this.f12892j, this.f12906x, this.f12907y);
                while (c2440a.f6080j != null && !c2440a.f6077g.f6557f) {
                    c2440a = c2440a.f6080j;
                }
                if (a == -1 || c2440a.f6080j == null) {
                    break;
                } else if (c2440a.f6080j.f6077g.f6552a.f5978b != a) {
                    break;
                } else {
                    c2440a = c2440a.f6080j;
                }
            }
            a = this.f12880G.f6073c;
            int i = this.f12881H != null ? this.f12881H.f6073c : -1;
            if (c2440a.f6080j != null) {
                m16279a(c2440a.f6080j);
                c2440a.f6080j = null;
            }
            c2440a.f6077g = this.f12894l.m7261a(c2440a.f6077g);
            Object obj = 1;
            if ((a <= c2440a.f6073c ? 1 : null) == null) {
                this.f12880G = c2440a;
            }
            if (i == -1 || i > c2440a.f6073c) {
                obj = null;
            }
            if (obj == null && this.f12882I != null) {
                C2422b c2422b = this.f12882I.f6077g.f6552a;
                long a2 = m16272a(c2422b, this.f12895m.f6569f);
                if (a2 != this.f12895m.f6569f) {
                    this.f12895m = this.f12895m.m7271a(c2422b, a2, this.f12895m.f6568e);
                    this.f12890h.obtainMessage(4, 3, 0, this.f12895m).sendToTarget();
                }
            }
        }
    }

    /* renamed from: d */
    private void m16302d() {
        int i = 0;
        this.f12903u = false;
        this.f12887e.m13811a();
        C4256t[] c4256tArr = this.f12900r;
        int length = c4256tArr.length;
        while (i < length) {
            c4256tArr[i].mo3186e();
            i++;
        }
    }

    /* renamed from: e */
    private void m16305e() {
        this.f12887e.m13813b();
        for (C4256t a : this.f12900r) {
            m16282a(a);
        }
    }

    /* renamed from: f */
    private void m16307f() {
        if (this.f12882I != null) {
            long j;
            long c = this.f12882I.f6071a.mo3208c();
            if (c != -9223372036854775807L) {
                m16277a(c);
                this.f12895m = this.f12895m.m7271a(this.f12895m.f6566c, c, this.f12895m.f6568e);
                this.f12890h.obtainMessage(4, 3, 0, this.f12895m).sendToTarget();
            } else {
                if (!(this.f12897o == null || this.f12897o.mo3419u())) {
                    if (this.f12897o.mo3418t() || !m16301c(this.f12897o)) {
                        this.f12879F = this.f12898p.mo2324w();
                        this.f12887e.m13812a(this.f12879F);
                        c = this.f12882I.m6725b(this.f12879F);
                    }
                }
                this.f12879F = this.f12887e.mo2324w();
                c = this.f12882I.m6725b(this.f12879F);
            }
            this.f12895m.f6569f = c;
            this.f12875B = SystemClock.elapsedRealtime() * 1000;
            if (this.f12900r.length == 0) {
                j = Long.MIN_VALUE;
            } else {
                j = this.f12882I.f6071a.mo2242d();
            }
            C2572q c2572q = this.f12895m;
            if (j == Long.MIN_VALUE) {
                j = this.f12882I.f6077g.f6556e;
            }
            c2572q.f6570g = j;
        }
    }

    /* renamed from: g */
    private void m16308g() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        m16315n();
        if (this.f12882I == null) {
            m16312k();
            m16278a(elapsedRealtime, 10);
            return;
        }
        C2538t.m7155a("doSomeWork");
        m16307f();
        r0.f12882I.f6071a.mo3203a(r0.f12895m.f6569f);
        Object obj = 1;
        boolean z = true;
        for (C4256t c4256t : r0.f12900r) {
            Object obj2;
            c4256t.mo3412a(r0.f12879F, r0.f12875B);
            obj = (obj == null || !c4256t.mo3419u()) ? null : 1;
            if (!(c4256t.mo3418t() || c4256t.mo3419u())) {
                if (!m16301c(c4256t)) {
                    obj2 = null;
                    if (obj2 == null) {
                        c4256t.mo3191j();
                    }
                    z = z && obj2 != null;
                }
            }
            obj2 = 1;
            if (obj2 == null) {
                c4256t.mo3191j();
            }
            if (!z) {
            }
        }
        if (!z) {
            m16312k();
        }
        if (r0.f12898p != null) {
            C2573r x = r0.f12898p.mo2325x();
            if (!x.equals(r0.f12896n)) {
                r0.f12896n = x;
                r0.f12887e.mo2323a(x);
                r0.f12890h.obtainMessage(6, x).sendToTarget();
            }
        }
        long j = r0.f12882I.f6077g.f6556e;
        if (obj != null && ((j == -9223372036854775807L || j <= r0.f12895m.f6569f) && r0.f12882I.f6077g.f6558g)) {
            m16288b(4);
            m16305e();
        } else if (r0.f12905w == 2) {
            boolean b = r0.f12900r.length > 0 ? z && r0.f12880G.m6724a(r0.f12903u, r0.f12879F) : m16295b(j);
            if (b) {
                m16288b(3);
                if (r0.f12902t) {
                    m16302d();
                }
            }
        } else if (r0.f12905w == 3) {
            if (r0.f12900r.length <= 0) {
                z = m16295b(j);
            }
            if (!z) {
                r0.f12903u = r0.f12902t;
                m16288b(2);
                m16305e();
            }
        }
        if (r0.f12905w == 2) {
            for (C4256t j2 : r0.f12900r) {
                j2.mo3191j();
            }
        }
        if ((r0.f12902t && r0.f12905w == 3) || r0.f12905w == 2) {
            m16278a(elapsedRealtime, 10);
        } else if (r0.f12900r.length == 0 || r0.f12905w == 4) {
            r0.f12888f.removeMessages(2);
        } else {
            m16278a(elapsedRealtime, 1000);
        }
        C2538t.m7154a();
    }

    /* renamed from: a */
    private void m16278a(long j, long j2) {
        this.f12888f.removeMessages(2);
        j = (j + j2) - SystemClock.elapsedRealtime();
        if (j <= 0) {
            this.f12888f.sendEmptyMessage(2);
        } else {
            this.f12888f.sendEmptyMessageDelayed(2, j);
        }
    }

    /* renamed from: a */
    private void m16281a(C2442c c2442c) {
        C2442c c2442c2 = c2442c;
        C2589y c2589y = this.f12895m.f6564a;
        if (c2589y == null) {
            r1.f12877D++;
            r1.f12878E = c2442c2;
            return;
        }
        Pair b = m16286b(c2442c);
        if (b == null) {
            int i = c2589y.m7331a() ? 0 : c2589y.m7328a(c2589y.m7333b(r1.f12907y), r1.f12892j).f6633f;
            r1.f12895m = r1.f12895m.m7270a(i, -9223372036854775807L, -9223372036854775807L);
            m16288b(4);
            r1.f12890h.obtainMessage(3, 1, 0, r1.f12895m.m7270a(i, 0, -9223372036854775807L)).sendToTarget();
            m16306e(false);
            return;
        }
        long j;
        int i2 = c2442c2.f6093c == -9223372036854775807L ? 1 : 0;
        int intValue = ((Integer) b.first).intValue();
        long longValue = ((Long) b.second).longValue();
        C2422b a = r1.f12894l.m7260a(intValue, longValue);
        if (a.m6657a()) {
            j = 0;
            intValue = 1;
        } else {
            intValue = i2;
            j = longValue;
        }
        try {
            if (!a.equals(r1.f12895m.f6566c) || j / 1000 != r1.f12895m.f6569f / 1000) {
                long a2 = m16272a(a, j);
                i2 = (j != a2 ? 1 : 0) | intValue;
                r1.f12895m = r1.f12895m.m7271a(a, a2, longValue);
                r1.f12890h.obtainMessage(3, i2 != 0 ? 1 : 0, 0, r1.f12895m).sendToTarget();
            }
        } finally {
            r1.f12895m = r1.f12895m.m7271a(a, j, longValue);
            r1.f12890h.obtainMessage(3, intValue, 0, r1.f12895m).sendToTarget();
        }
    }

    /* renamed from: a */
    private long m16272a(C2422b c2422b, long j) {
        C2440a c2440a;
        m16305e();
        this.f12903u = false;
        m16288b(2);
        if (this.f12882I == null) {
            if (this.f12880G != null) {
                this.f12880G.m6731e();
            }
            c2440a = null;
        } else {
            C2440a c2440a2 = this.f12882I;
            c2440a = null;
            while (c2440a2 != null) {
                if (c2440a == null && m16284a(c2422b, j, c2440a2)) {
                    c2440a = c2440a2;
                } else {
                    c2440a2.m6731e();
                }
                c2440a2 = c2440a2.f6080j;
            }
        }
        if (!(this.f12882I == c2440a && this.f12882I == this.f12881H)) {
            for (C4256t b : this.f12900r) {
                m16293b(b);
            }
            this.f12900r = new C4256t[0];
            this.f12882I = null;
        }
        if (c2440a != null) {
            c2440a.f6080j = null;
            this.f12880G = c2440a;
            this.f12881H = c2440a;
            m16291b(c2440a);
            if (this.f12882I.f6079i != null) {
                j = this.f12882I.f6071a.mo3206b(j);
            }
            m16277a(j);
            m16317p();
        } else {
            this.f12880G = null;
            this.f12881H = null;
            this.f12882I = null;
            m16277a(j);
        }
        this.f12888f.sendEmptyMessage(2);
        return j;
    }

    /* renamed from: a */
    private boolean m16284a(C2422b c2422b, long j, C2440a c2440a) {
        if (!(c2422b.equals(c2440a.f6077g.f6552a) == null || c2440a.f6078h == null)) {
            this.f12895m.f6564a.m7326a(c2440a.f6077g.f6552a.f5978b, this.f12893k);
            int b = this.f12893k.m7309b(j);
            if (b == -1 || this.f12893k.m7304a(b) == c2440a.f6077g.f6554c) {
                return true;
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m16277a(long j) {
        if (this.f12882I == null) {
            j += 60000000;
        } else {
            j = this.f12882I.m6721a(j);
        }
        this.f12879F = j;
        this.f12887e.m13812a(this.f12879F);
        for (C4256t a : this.f12900r) {
            a.mo3180a(this.f12879F);
        }
    }

    /* renamed from: b */
    private void m16292b(C2573r c2573r) {
        if (this.f12898p != null) {
            c2573r = this.f12898p.mo2323a(c2573r);
        }
        this.f12887e.mo2323a(c2573r);
        this.f12896n = c2573r;
        this.f12890h.obtainMessage(6, c2573r).sendToTarget();
    }

    /* renamed from: h */
    private void m16309h() {
        m16306e(true);
        this.f12886d.mo2155b();
        m16288b(1);
    }

    /* renamed from: i */
    private void m16310i() {
        m16306e(true);
        this.f12886d.mo2156c();
        m16288b(1);
        this.f12889g.quit();
        synchronized (this) {
            this.f12901s = true;
            notifyAll();
        }
    }

    /* renamed from: e */
    private void m16306e(boolean z) {
        this.f12888f.removeMessages(2);
        this.f12903u = false;
        this.f12887e.m13813b();
        this.f12879F = 60000000;
        for (C4256t b : this.f12900r) {
            try {
                m16293b(b);
            } catch (Throwable e) {
                Log.e("ExoPlayerImplInternal", "Stop failed.", e);
            }
        }
        this.f12900r = new C4256t[0];
        m16279a(this.f12882I != null ? this.f12882I : this.f12880G);
        this.f12880G = null;
        this.f12881H = null;
        this.f12882I = null;
        m16294b(false);
        if (z) {
            if (this.f12899q) {
                this.f12899q.mo2265b();
                this.f12899q = null;
            }
            this.f12894l.m7266a(null);
            this.f12895m = this.f12895m.m7272a(null, null);
        }
    }

    /* renamed from: c */
    private void m16300c(C2332c[] c2332cArr) {
        try {
            for (C2332c c2332c : c2332cArr) {
                c2332c.f5783a.mo3179a(c2332c.f5784b, c2332c.f5785c);
            }
            if (this.f12905w == 3 || this.f12905w == 2) {
                this.f12888f.sendEmptyMessage(2);
            }
            synchronized (this) {
                this.f12874A++;
                notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this) {
                this.f12874A++;
                notifyAll();
            }
        }
    }

    /* renamed from: a */
    private void m16282a(C4256t c4256t) {
        if (c4256t.mo3185d() == 2) {
            c4256t.mo3192k();
        }
    }

    /* renamed from: b */
    private void m16293b(C4256t c4256t) {
        if (c4256t == this.f12897o) {
            this.f12898p = null;
            this.f12897o = null;
        }
        m16282a(c4256t);
        c4256t.mo3193l();
    }

    /* renamed from: j */
    private void m16311j() {
        if (this.f12882I != null) {
            C2440a c2440a = r0.f12882I;
            Object obj = 1;
            while (c2440a != null) {
                if (!c2440a.f6078h) {
                    break;
                } else if (c2440a.m6730d()) {
                    if (obj != null) {
                        boolean z = r0.f12881H != r0.f12882I;
                        m16279a(r0.f12882I.f6080j);
                        r0.f12882I.f6080j = null;
                        r0.f12880G = r0.f12882I;
                        r0.f12881H = r0.f12882I;
                        boolean[] zArr = new boolean[r0.f12883a.length];
                        long a = r0.f12882I.m6723a(r0.f12895m.f6569f, z, zArr);
                        if (!(r0.f12905w == 4 || a == r0.f12895m.f6569f)) {
                            r0.f12895m = r0.f12895m.m7271a(r0.f12895m.f6566c, a, r0.f12895m.f6568e);
                            r0.f12890h.obtainMessage(4, 3, 0, r0.f12895m).sendToTarget();
                            m16277a(a);
                        }
                        boolean[] zArr2 = new boolean[r0.f12883a.length];
                        int i = 0;
                        for (int i2 = 0; i2 < r0.f12883a.length; i2++) {
                            C4256t c4256t = r0.f12883a[i2];
                            zArr2[i2] = c4256t.mo3185d() != 0;
                            C2435m c2435m = r0.f12882I.f6074d[i2];
                            if (c2435m != null) {
                                i++;
                            }
                            if (zArr2[i2]) {
                                if (c2435m != c4256t.mo3187f()) {
                                    m16293b(c4256t);
                                } else if (zArr[i2]) {
                                    c4256t.mo3180a(r0.f12879F);
                                }
                            }
                        }
                        r0.f12890h.obtainMessage(2, c2440a.f6081k).sendToTarget();
                        m16283a(zArr2, i);
                    } else {
                        r0.f12880G = c2440a;
                        for (c2440a = r0.f12880G.f6080j; c2440a != null; c2440a = c2440a.f6080j) {
                            c2440a.m6731e();
                        }
                        r0.f12880G.f6080j = null;
                        if (r0.f12880G.f6078h) {
                            r0.f12880G.m6722a(Math.max(r0.f12880G.f6077g.f6553b, r0.f12880G.m6725b(r0.f12879F)), false);
                        }
                    }
                    if (r0.f12905w != 4) {
                        m16317p();
                        m16307f();
                        r0.f12888f.sendEmptyMessage(2);
                    }
                    return;
                } else {
                    if (c2440a == r0.f12881H) {
                        obj = null;
                    }
                    c2440a = c2440a.f6080j;
                }
            }
        }
    }

    /* renamed from: b */
    private boolean m16295b(long j) {
        if (j != -9223372036854775807L && this.f12895m.f6569f >= j) {
            if (this.f12882I.f6080j != null) {
                if (this.f12882I.f6080j.f6078h == null) {
                    if (this.f12882I.f6080j.f6077g.f6552a.m6657a() != null) {
                    }
                }
            }
            return 0;
        }
        return 1;
    }

    /* renamed from: k */
    private void m16312k() {
        if (!(this.f12880G == null || this.f12880G.f6078h || (this.f12881H != null && this.f12881H.f6080j != this.f12880G))) {
            C4256t[] c4256tArr = this.f12900r;
            int length = c4256tArr.length;
            int i = 0;
            while (i < length) {
                if (c4256tArr[i].mo3188g()) {
                    i++;
                } else {
                    return;
                }
            }
            this.f12880G.f6071a.e_();
        }
    }

    /* renamed from: a */
    private void m16280a(C2441b c2441b) {
        C2441b c2441b2 = c2441b;
        if (c2441b2.f6088a == this.f12899q) {
            C2589y c2589y = r0.f12895m.f6564a;
            C2589y c2589y2 = c2441b2.f6089b;
            Object obj = c2441b2.f6090c;
            r0.f12894l.m7266a(c2589y2);
            r0.f12895m = r0.f12895m.m7272a(c2589y2, obj);
            long j = -9223372036854775807L;
            int i = 0;
            int i2;
            int i3;
            int intValue;
            Pair b;
            if (c2589y == null) {
                i2 = r0.f12876C;
                r0.f12876C = 0;
                if (r0.f12877D > 0) {
                    Pair b2 = m16286b(r0.f12878E);
                    i3 = r0.f12877D;
                    r0.f12877D = 0;
                    r0.f12878E = null;
                    if (b2 == null) {
                        m16274a(i2, i3);
                    } else {
                        intValue = ((Integer) b2.first).intValue();
                        long longValue = ((Long) b2.second).longValue();
                        C2422b a = r0.f12894l.m7260a(intValue, longValue);
                        r0.f12895m = r0.f12895m.m7271a(a, a.m6657a() ? 0 : longValue, longValue);
                        m16289b(i2, i3);
                    }
                } else if (r0.f12895m.f6567d != -9223372036854775807L) {
                    m16289b(i2, 0);
                } else if (c2589y2.m7331a()) {
                    m16274a(i2, 0);
                } else {
                    b = m16287b(c2589y2, c2589y2.m7333b(r0.f12907y), -9223372036854775807L);
                    int intValue2 = ((Integer) b.first).intValue();
                    long longValue2 = ((Long) b.second).longValue();
                    C2422b a2 = r0.f12894l.m7260a(intValue2, longValue2);
                    r0.f12895m = r0.f12895m.m7271a(a2, a2.m6657a() ? 0 : longValue2, longValue2);
                    m16289b(i2, 0);
                }
                return;
            }
            int i4 = r0.f12895m.f6566c.f5978b;
            C2440a c2440a = r0.f12882I != null ? r0.f12882I : r0.f12880G;
            if (c2440a != null || i4 < c2589y.mo2260c()) {
                int a3 = c2589y2.mo2256a(c2440a == null ? c2589y.mo2257a(i4, r0.f12893k, true).f6618b : c2440a.f6072b);
                if (a3 == -1) {
                    intValue = m16271a(i4, c2589y, c2589y2);
                    if (intValue == -1) {
                        m16313l();
                        return;
                    }
                    b = m16287b(c2589y2, c2589y2.m7326a(intValue, r0.f12893k).f6619c, -9223372036854775807L);
                    i2 = ((Integer) b.first).intValue();
                    j = ((Long) b.second).longValue();
                    c2589y2.mo2257a(i2, r0.f12893k, true);
                    if (c2440a != null) {
                        obj = r0.f12893k.f6618b;
                        c2440a.f6077g = c2440a.f6077g.m7252a(-1);
                        while (c2440a.f6080j != null) {
                            c2440a = c2440a.f6080j;
                            if (c2440a.f6072b.equals(obj)) {
                                c2440a.f6077g = r0.f12894l.m7262a(c2440a.f6077g, i2);
                            } else {
                                c2440a.f6077g = c2440a.f6077g.m7252a(-1);
                            }
                        }
                    }
                    C2422b c2422b = new C2422b(i2);
                    r0.f12895m = r0.f12895m.m7271a(c2422b, m16272a(c2422b, j), -9223372036854775807L);
                    m16314m();
                    return;
                }
                if (a3 != i4) {
                    r0.f12895m = r0.f12895m.m7269a(a3);
                }
                if (r0.f12895m.f6566c.m6657a()) {
                    C2422b a4 = r0.f12894l.m7260a(a3, r0.f12895m.f6568e);
                    if (!(a4.m6657a() && a4.f5980d == r0.f12895m.f6566c.f5980d)) {
                        long a5 = m16272a(a4, r0.f12895m.f6568e);
                        if (a4.m6657a()) {
                            j = r0.f12895m.f6568e;
                        }
                        r0.f12895m = r0.f12895m.m7271a(a4, a5, j);
                        m16314m();
                        return;
                    }
                }
                if (c2440a == null) {
                    m16314m();
                    return;
                }
                C2440a a6 = m16273a(c2440a, a3);
                i3 = a3;
                while (a6.f6080j != null) {
                    C2440a c2440a2 = a6.f6080j;
                    i3 = c2589y2.m7321a(i3, r0.f12893k, r0.f12892j, r0.f12906x, r0.f12907y);
                    if (i3 == -1 || !c2440a2.f6072b.equals(c2589y2.mo2257a(i3, r0.f12893k, true).f6618b)) {
                        if (r0.f12881H != null && r0.f12881H.f6073c < c2440a2.f6073c) {
                            i = 1;
                        }
                        if (i == 0) {
                            r0.f12895m = r0.f12895m.m7271a(r0.f12882I.f6077g.f6552a, m16272a(r0.f12882I.f6077g.f6552a, r0.f12895m.f6569f), r0.f12895m.f6568e);
                        } else {
                            r0.f12880G = a6;
                            r0.f12880G.f6080j = null;
                            m16279a(c2440a2);
                        }
                        m16314m();
                        return;
                    }
                    a6 = m16273a(c2440a2, i3);
                }
                m16314m();
                return;
            }
            m16314m();
        }
    }

    /* renamed from: a */
    private C2440a m16273a(C2440a c2440a, int i) {
        while (true) {
            c2440a.f6077g = this.f12894l.m7262a(c2440a.f6077g, i);
            if (c2440a.f6077g.f6557f) {
                break;
            } else if (c2440a.f6080j == null) {
                break;
            } else {
                c2440a = c2440a.f6080j;
            }
        }
        return c2440a;
    }

    /* renamed from: l */
    private void m16313l() {
        m16274a(0, 0);
    }

    /* renamed from: a */
    private void m16274a(int i, int i2) {
        C2589y c2589y = this.f12895m.f6564a;
        int i3 = c2589y.m7331a() ? 0 : c2589y.m7328a(c2589y.m7333b(this.f12907y), this.f12892j).f6633f;
        this.f12895m = this.f12895m.m7270a(i3, -9223372036854775807L, -9223372036854775807L);
        m16288b(4);
        m16275a(i, i2, this.f12895m.m7270a(i3, 0, -9223372036854775807L));
        m16306e(false);
    }

    /* renamed from: m */
    private void m16314m() {
        m16289b(0, 0);
    }

    /* renamed from: b */
    private void m16289b(int i, int i2) {
        m16275a(i, i2, this.f12895m);
    }

    /* renamed from: a */
    private void m16275a(int i, int i2, C2572q c2572q) {
        this.f12890h.obtainMessage(5, i, i2, c2572q).sendToTarget();
    }

    /* renamed from: a */
    private int m16271a(int i, C2589y c2589y, C2589y c2589y2) {
        int c = c2589y.mo2260c();
        int i2 = i;
        i = -1;
        for (int i3 = 0; i3 < c && i == -1; i3++) {
            i2 = c2589y.m7321a(i2, this.f12893k, this.f12892j, this.f12906x, this.f12907y);
            if (i2 == -1) {
                break;
            }
            i = c2589y2.mo2256a(c2589y.mo2257a(i2, this.f12893k, true).f6618b);
        }
        return i;
    }

    /* renamed from: b */
    private android.util.Pair<java.lang.Integer, java.lang.Long> m16286b(com.google.android.exoplayer2.C4728i.C2442c r10) {
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
        r9 = this;
        r0 = r9.f12895m;
        r0 = r0.f6564a;
        r1 = r10.f6091a;
        r2 = r1.m7331a();
        if (r2 == 0) goto L_0x000d;
    L_0x000c:
        r1 = r0;
    L_0x000d:
        r4 = r9.f12892j;	 Catch:{ IndexOutOfBoundsException -> 0x0062 }
        r5 = r9.f12893k;	 Catch:{ IndexOutOfBoundsException -> 0x0062 }
        r6 = r10.f6092b;	 Catch:{ IndexOutOfBoundsException -> 0x0062 }
        r7 = r10.f6093c;	 Catch:{ IndexOutOfBoundsException -> 0x0062 }
        r3 = r1;	 Catch:{ IndexOutOfBoundsException -> 0x0062 }
        r2 = r3.m7324a(r4, r5, r6, r7);	 Catch:{ IndexOutOfBoundsException -> 0x0062 }
        if (r0 != r1) goto L_0x001d;
    L_0x001c:
        return r2;
    L_0x001d:
        r10 = r2.first;
        r10 = (java.lang.Integer) r10;
        r10 = r10.intValue();
        r3 = r9.f12893k;
        r4 = 1;
        r10 = r1.mo2257a(r10, r3, r4);
        r10 = r10.f6618b;
        r10 = r0.mo2256a(r10);
        r3 = -1;
        if (r10 == r3) goto L_0x0040;
    L_0x0035:
        r10 = java.lang.Integer.valueOf(r10);
        r0 = r2.second;
        r10 = android.util.Pair.create(r10, r0);
        return r10;
    L_0x0040:
        r10 = r2.first;
        r10 = (java.lang.Integer) r10;
        r10 = r10.intValue();
        r10 = r9.m16271a(r10, r1, r0);
        if (r10 == r3) goto L_0x0060;
    L_0x004e:
        r1 = r9.f12893k;
        r10 = r0.m7326a(r10, r1);
        r10 = r10.f6619c;
        r1 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r10 = r9.m16287b(r0, r10, r1);
        return r10;
    L_0x0060:
        r10 = 0;
        return r10;
    L_0x0062:
        r1 = new com.google.android.exoplayer2.m;
        r2 = r10.f6092b;
        r3 = r10.f6093c;
        r1.<init>(r0, r2, r3);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.i.b(com.google.android.exoplayer2.i$c):android.util.Pair<java.lang.Integer, java.lang.Long>");
    }

    /* renamed from: b */
    private Pair<Integer, Long> m16287b(C2589y c2589y, int i, long j) {
        return c2589y.m7324a(this.f12892j, this.f12893k, i, j);
    }

    /* renamed from: n */
    private void m16315n() {
        if (this.f12895m.f6564a == null) {
            this.f12899q.mo2262a();
            return;
        }
        int i;
        C4256t c4256t;
        C2435m c2435m;
        C2488i c2488i;
        C2488i c2488i2;
        Object obj;
        int i2;
        C4256t c4256t2;
        boolean z;
        C4256t c4256t3;
        m16316o();
        int i3 = 0;
        if (this.f12880G != null) {
            if (!this.f12880G.m6726b()) {
                if (!(this.f12880G == null || this.f12904v)) {
                    m16317p();
                }
                if (this.f12882I == null) {
                    while (this.f12902t && this.f12882I != this.f12881H && this.f12879F >= this.f12882I.f6080j.f6076f) {
                        this.f12882I.m6731e();
                        m16291b(this.f12882I.f6080j);
                        this.f12895m = this.f12895m.m7271a(this.f12882I.f6077g.f6552a, this.f12882I.f6077g.f6553b, this.f12882I.f6077g.f6555d);
                        m16307f();
                        this.f12890h.obtainMessage(4, 0, 0, this.f12895m).sendToTarget();
                    }
                    if (this.f12881H.f6077g.f6558g) {
                        if (this.f12881H.f6080j != null) {
                            if (!this.f12881H.f6080j.f6078h) {
                                i = 0;
                                while (i < this.f12883a.length) {
                                    c4256t = this.f12883a[i];
                                    c2435m = this.f12881H.f6074d[i];
                                    if (c4256t.mo3187f() != c2435m) {
                                        if (c2435m != null || c4256t.mo3188g()) {
                                            i++;
                                        }
                                    }
                                    return;
                                }
                                c2488i = this.f12881H.f6081k;
                                this.f12881H = this.f12881H.f6080j;
                                c2488i2 = this.f12881H.f6081k;
                                obj = this.f12881H.f6071a.mo3208c() == -9223372036854775807L ? 1 : null;
                                for (i2 = 0; i2 < this.f12883a.length; i2++) {
                                    c4256t2 = this.f12883a[i2];
                                    if (!c2488i.f6334b[i2]) {
                                        if (obj != null) {
                                            c4256t2.mo3189h();
                                        } else if (!c4256t2.mo3190i()) {
                                            C2484f a = c2488i2.f6335c.m6931a(i2);
                                            z = c2488i2.f6334b[i2];
                                            Object obj2 = this.f12884b[i2].mo3177a() != 5 ? 1 : null;
                                            Object obj3 = c2488i.f6337e[i2];
                                            C2583v c2583v = c2488i2.f6337e[i2];
                                            if (!z && c2583v.equals(obj3) && obj2 == null) {
                                                c4256t2.mo3182a(C4728i.m16285a(a), this.f12881H.f6074d[i2], this.f12881H.m6720a());
                                            } else {
                                                c4256t2.mo3189h();
                                            }
                                        }
                                    }
                                }
                                return;
                            }
                        }
                        return;
                    }
                    while (i3 < this.f12883a.length) {
                        c4256t3 = this.f12883a[i3];
                        C2435m c2435m2 = this.f12881H.f6074d[i3];
                        if (c2435m2 != null && c4256t3.mo3187f() == c2435m2 && c4256t3.mo3188g()) {
                            c4256t3.mo3189h();
                        }
                        i3++;
                    }
                }
            }
        }
        m16294b(false);
        if (this.f12882I == null) {
            while (this.f12902t) {
                this.f12882I.m6731e();
                m16291b(this.f12882I.f6080j);
                this.f12895m = this.f12895m.m7271a(this.f12882I.f6077g.f6552a, this.f12882I.f6077g.f6553b, this.f12882I.f6077g.f6555d);
                m16307f();
                this.f12890h.obtainMessage(4, 0, 0, this.f12895m).sendToTarget();
            }
            if (this.f12881H.f6077g.f6558g) {
                if (this.f12881H.f6080j != null) {
                    if (!this.f12881H.f6080j.f6078h) {
                        i = 0;
                        while (i < this.f12883a.length) {
                            c4256t = this.f12883a[i];
                            c2435m = this.f12881H.f6074d[i];
                            if (c4256t.mo3187f() != c2435m) {
                                if (c2435m != null) {
                                }
                                i++;
                            }
                            return;
                        }
                        c2488i = this.f12881H.f6081k;
                        this.f12881H = this.f12881H.f6080j;
                        c2488i2 = this.f12881H.f6081k;
                        if (this.f12881H.f6071a.mo3208c() == -9223372036854775807L) {
                        }
                        while (i2 < this.f12883a.length) {
                            c4256t2 = this.f12883a[i2];
                            if (!c2488i.f6334b[i2]) {
                                if (obj != null) {
                                    c4256t2.mo3189h();
                                } else if (!c4256t2.mo3190i()) {
                                    C2484f a2 = c2488i2.f6335c.m6931a(i2);
                                    z = c2488i2.f6334b[i2];
                                    if (this.f12884b[i2].mo3177a() != 5) {
                                    }
                                    Object obj32 = c2488i.f6337e[i2];
                                    C2583v c2583v2 = c2488i2.f6337e[i2];
                                    if (!z) {
                                    }
                                    c4256t2.mo3189h();
                                }
                            }
                        }
                        return;
                    }
                }
                return;
            }
            while (i3 < this.f12883a.length) {
                c4256t3 = this.f12883a[i3];
                C2435m c2435m22 = this.f12881H.f6074d[i3];
                c4256t3.mo3189h();
                i3++;
            }
        }
    }

    /* renamed from: o */
    private void m16316o() {
        C2569a a;
        if (this.f12880G == null) {
            a = this.f12894l.m7264a(this.f12895m);
        } else {
            if (!this.f12880G.f6077g.f6558g && this.f12880G.m6726b()) {
                if (this.f12880G.f6077g.f6556e != -9223372036854775807L) {
                    if (this.f12882I == null || this.f12880G.f6073c - this.f12882I.f6073c != 100) {
                        a = this.f12894l.m7263a(this.f12880G.f6077g, this.f12880G.m6720a(), this.f12879F);
                    } else {
                        return;
                    }
                }
            }
            return;
        }
        if (a == null) {
            this.f12899q.mo2262a();
            return;
        }
        long j;
        if (this.f12880G == null) {
            j = 60000000;
        } else {
            j = this.f12880G.m6720a() + this.f12880G.f6077g.f6556e;
        }
        C2440a c2440a = new C2440a(this.f12883a, this.f12884b, j, this.f12885c, this.f12886d, this.f12899q, this.f12895m.f6564a.mo2257a(a.f6552a.f5978b, this.f12893k, true).f6618b, this.f12880G == null ? 0 : this.f12880G.f6073c + 1, a);
        if (this.f12880G != null) {
            this.f12880G.f6080j = c2440a;
        }
        this.f12880G = c2440a;
        this.f12880G.f6071a.mo3204a(this, a.f6553b);
        m16294b(true);
    }

    /* renamed from: c */
    private void m16298c(C4219h c4219h) {
        if (this.f12880G != null) {
            if (this.f12880G.f6071a == c4219h) {
                this.f12880G.m6727c();
                if (this.f12882I == null) {
                    this.f12881H = this.f12880G;
                    m16277a(this.f12881H.f6077g.f6553b);
                    m16291b(this.f12881H);
                }
                m16317p();
            }
        }
    }

    /* renamed from: d */
    private void m16303d(C4219h c4219h) {
        if (this.f12880G != null) {
            if (this.f12880G.f6071a == c4219h) {
                m16317p();
            }
        }
    }

    /* renamed from: p */
    private void m16317p() {
        boolean c = this.f12880G.m6728c(this.f12879F);
        m16294b(c);
        if (c) {
            this.f12880G.m6729d(this.f12879F);
        }
    }

    /* renamed from: a */
    private void m16279a(C2440a c2440a) {
        while (c2440a != null) {
            c2440a.m6731e();
            c2440a = c2440a.f6080j;
        }
    }

    /* renamed from: b */
    private void m16291b(C2440a c2440a) {
        if (this.f12882I != c2440a) {
            boolean[] zArr = new boolean[this.f12883a.length];
            int i = 0;
            int i2 = 0;
            while (i < this.f12883a.length) {
                C4256t c4256t = this.f12883a[i];
                zArr[i] = c4256t.mo3185d() != 0;
                if (c2440a.f6081k.f6334b[i]) {
                    i2++;
                }
                if (zArr[i] && (!c2440a.f6081k.f6334b[i] || (c4256t.mo3190i() && c4256t.mo3187f() == this.f12882I.f6074d[i]))) {
                    m16293b(c4256t);
                }
                i++;
            }
            this.f12882I = c2440a;
            this.f12890h.obtainMessage(2, c2440a.f6081k).sendToTarget();
            m16283a(zArr, i2);
        }
    }

    /* renamed from: a */
    private void m16283a(boolean[] zArr, int i) {
        this.f12900r = new C4256t[i];
        int i2 = 0;
        for (i = 0; i < this.f12883a.length; i++) {
            if (this.f12882I.f6081k.f6334b[i]) {
                int i3 = i2 + 1;
                m16276a(i, zArr[i], i2);
                i2 = i3;
            }
        }
    }

    /* renamed from: a */
    private void m16276a(int i, boolean z, int i2) {
        C4256t c4256t = this.f12883a[i];
        this.f12900r[i2] = c4256t;
        if (c4256t.mo3185d() == 0) {
            C2583v c2583v = this.f12882I.f6081k.f6337e[i];
            C2515k[] a = C4728i.m16285a(this.f12882I.f6081k.f6335c.m6931a(i));
            i2 = (this.f12902t == 0 || this.f12905w != 3) ? 0 : 1;
            boolean z2 = (z || i2 == 0) ? false : true;
            c4256t.mo3181a(c2583v, a, this.f12882I.f6074d[i], this.f12879F, z2, this.f12882I.m6720a());
            i = c4256t.mo3184c();
            if (i != 0) {
                if (this.f12898p) {
                    throw C2330e.m6460a(new IllegalStateException("Multiple renderer media clocks enabled."));
                }
                this.f12898p = i;
                this.f12897o = c4256t;
                this.f12898p.mo2323a(this.f12896n);
            }
            if (i2 != 0) {
                c4256t.mo3186e();
            }
        }
    }

    /* renamed from: c */
    private boolean m16301c(C4256t c4256t) {
        return (this.f12881H.f6080j == null || !this.f12881H.f6080j.f6078h || c4256t.mo3188g() == null) ? null : true;
    }

    /* renamed from: a */
    private static C2515k[] m16285a(C2484f c2484f) {
        int g = c2484f != null ? c2484f.mo2306g() : 0;
        C2515k[] c2515kArr = new C2515k[g];
        for (int i = 0; i < g; i++) {
            c2515kArr[i] = c2484f.mo2299a(i);
        }
        return c2515kArr;
    }
}
