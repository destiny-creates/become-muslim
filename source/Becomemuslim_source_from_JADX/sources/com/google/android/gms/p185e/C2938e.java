package com.google.android.gms.p185e;

import android.content.Context;
import com.amplitude.api.Constants;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.util.C2895e;
import com.google.android.gms.common.util.C4376h;

/* renamed from: com.google.android.gms.e.e */
public final class C2938e {
    /* renamed from: l */
    private static Object f7548l = new Object();
    /* renamed from: m */
    private static C2938e f7549m;
    /* renamed from: a */
    private volatile long f7550a;
    /* renamed from: b */
    private volatile long f7551b;
    /* renamed from: c */
    private volatile boolean f7552c;
    /* renamed from: d */
    private volatile Info f7553d;
    /* renamed from: e */
    private volatile long f7554e;
    /* renamed from: f */
    private volatile long f7555f;
    /* renamed from: g */
    private final Context f7556g;
    /* renamed from: h */
    private final C2895e f7557h;
    /* renamed from: i */
    private final Thread f7558i;
    /* renamed from: j */
    private final Object f7559j;
    /* renamed from: k */
    private bj f7560k;

    /* renamed from: a */
    public static C2938e m8691a(Context context) {
        if (f7549m == null) {
            synchronized (f7548l) {
                if (f7549m == null) {
                    C2938e c2938e = new C2938e(context);
                    f7549m = c2938e;
                    c2938e.f7558i.start();
                }
            }
        }
        return f7549m;
    }

    private C2938e(Context context) {
        this(context, null, C4376h.m14397d());
    }

    private C2938e(Context context, bj bjVar, C2895e c2895e) {
        this.f7550a = 900000;
        this.f7551b = Constants.EVENT_UPLOAD_PERIOD_MILLIS;
        this.f7552c = null;
        this.f7559j = new Object();
        this.f7560k = new ae(this);
        this.f7557h = c2895e;
        if (context != null) {
            this.f7556g = context.getApplicationContext();
        } else {
            this.f7556g = context;
        }
        this.f7554e = this.f7557h.mo2482a();
        this.f7558i = new Thread(new ba(this));
    }

    /* renamed from: a */
    public final String m8697a() {
        if (this.f7553d == null) {
            m8693d();
        } else {
            m8694e();
        }
        m8695f();
        return this.f7553d == null ? null : this.f7553d.getId();
    }

    /* renamed from: b */
    public final boolean m8698b() {
        if (this.f7553d == null) {
            m8693d();
        } else {
            m8694e();
        }
        m8695f();
        if (this.f7553d != null) {
            if (!this.f7553d.isLimitAdTrackingEnabled()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    private final void m8693d() {
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
        r2 = this;
        monitor-enter(r2);
        r0 = r2.f7552c;	 Catch:{ InterruptedException -> 0x0010 }
        if (r0 != 0) goto L_0x0010;	 Catch:{ InterruptedException -> 0x0010 }
    L_0x0005:
        r2.m8694e();	 Catch:{ InterruptedException -> 0x0010 }
        r0 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;	 Catch:{ InterruptedException -> 0x0010 }
        r2.wait(r0);	 Catch:{ InterruptedException -> 0x0010 }
        goto L_0x0010;
    L_0x000e:
        r0 = move-exception;
        goto L_0x0012;
    L_0x0010:
        monitor-exit(r2);	 Catch:{ all -> 0x000e }
        return;	 Catch:{ all -> 0x000e }
    L_0x0012:
        monitor-exit(r2);	 Catch:{ all -> 0x000e }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.e.e.d():void");
    }

    /* renamed from: e */
    private final void m8694e() {
        if (this.f7557h.mo2482a() - this.f7554e > this.f7551b) {
            synchronized (this.f7559j) {
                this.f7559j.notify();
            }
            this.f7554e = this.f7557h.mo2482a();
        }
    }

    /* renamed from: f */
    private final void m8695f() {
        if (this.f7557h.mo2482a() - this.f7555f > 3600000) {
            this.f7553d = null;
        }
    }

    /* renamed from: g */
    private final void m8696g() {
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
        r4 = this;
        r0 = 10;
        android.os.Process.setThreadPriority(r0);
    L_0x0005:
        r0 = r4.f7552c;
        if (r0 != 0) goto L_0x003d;
    L_0x0009:
        r0 = r4.f7560k;
        r0 = r0.mo2496a();
        if (r0 == 0) goto L_0x0020;
    L_0x0011:
        r4.f7553d = r0;
        r0 = r4.f7557h;
        r0 = r0.mo2482a();
        r4.f7555f = r0;
        r0 = "Obtained fresh AdvertisingId info from GmsCore.";
        com.google.android.gms.p185e.bs.m8586c(r0);
    L_0x0020:
        monitor-enter(r4);
        r4.notifyAll();	 Catch:{ all -> 0x003a }
        monitor-exit(r4);	 Catch:{ all -> 0x003a }
        r0 = r4.f7559j;	 Catch:{ InterruptedException -> 0x0034 }
        monitor-enter(r0);	 Catch:{ InterruptedException -> 0x0034 }
        r1 = r4.f7559j;	 Catch:{ all -> 0x0031 }
        r2 = r4.f7550a;	 Catch:{ all -> 0x0031 }
        r1.wait(r2);	 Catch:{ all -> 0x0031 }
        monitor-exit(r0);	 Catch:{ all -> 0x0031 }
        goto L_0x0005;	 Catch:{ all -> 0x0031 }
    L_0x0031:
        r1 = move-exception;	 Catch:{ all -> 0x0031 }
        monitor-exit(r0);	 Catch:{ all -> 0x0031 }
        throw r1;	 Catch:{ InterruptedException -> 0x0034 }
    L_0x0034:
        r0 = "sleep interrupted in AdvertiserDataPoller thread; continuing";
        com.google.android.gms.p185e.bs.m8586c(r0);
        goto L_0x0005;
    L_0x003a:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x003a }
        throw r0;
    L_0x003d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.e.e.g():void");
    }

    /* renamed from: c */
    public final void m8699c() {
        this.f7552c = true;
        this.f7558i.interrupt();
    }
}
