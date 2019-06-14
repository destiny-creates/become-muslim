package com.google.android.gms.internal.p213l;

import android.content.Context;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.util.C2895e;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.google.android.gms.internal.l.cb */
public final class cb extends dc {
    /* renamed from: k */
    private static final AtomicLong f32347k = new AtomicLong(Long.MIN_VALUE);
    /* renamed from: a */
    private ExecutorService f32348a;
    /* renamed from: b */
    private cf f32349b;
    /* renamed from: c */
    private cf f32350c;
    /* renamed from: d */
    private final PriorityBlockingQueue<ce<?>> f32351d = new PriorityBlockingQueue();
    /* renamed from: e */
    private final BlockingQueue<ce<?>> f32352e = new LinkedBlockingQueue();
    /* renamed from: f */
    private final UncaughtExceptionHandler f32353f = new cd(this, "Thread death: Uncaught exception on worker thread");
    /* renamed from: g */
    private final UncaughtExceptionHandler f32354g = new cd(this, "Thread death: Uncaught exception on network thread");
    /* renamed from: h */
    private final Object f32355h = new Object();
    /* renamed from: i */
    private final Semaphore f32356i = new Semaphore(2);
    /* renamed from: j */
    private volatile boolean f32357j;

    cb(cg cgVar) {
        super(cgVar);
    }

    /* renamed from: a */
    private final void m42602a(ce<?> ceVar) {
        synchronized (this.f32355h) {
            this.f32351d.add(ceVar);
            if (this.f32349b == null) {
                this.f32349b = new cf(this, "Measurement Worker", this.f32351d);
                this.f32349b.setUncaughtExceptionHandler(this.f32353f);
                this.f32349b.start();
            } else {
                this.f32349b.m21336a();
            }
        }
    }

    /* renamed from: a */
    final <T> T m42609a(java.util.concurrent.atomic.AtomicReference<T> r1, long r2, java.lang.String r4, java.lang.Runnable r5) {
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
        r0 = this;
        monitor-enter(r1);
        r2 = r0.mo4753q();	 Catch:{ all -> 0x005c }
        r2.m42612a(r5);	 Catch:{ all -> 0x005c }
        r2 = 15000; // 0x3a98 float:2.102E-41 double:7.411E-320;
        r1.wait(r2);	 Catch:{ InterruptedException -> 0x0037 }
        monitor-exit(r1);	 Catch:{ all -> 0x005c }
        r1 = r1.get();
        if (r1 != 0) goto L_0x0036;
    L_0x0014:
        r2 = r0.mo4754r();
        r2 = r2.m42565i();
        r3 = "Timed out waiting for ";
        r4 = java.lang.String.valueOf(r4);
        r5 = r4.length();
        if (r5 == 0) goto L_0x002d;
    L_0x0028:
        r3 = r3.concat(r4);
        goto L_0x0033;
    L_0x002d:
        r4 = new java.lang.String;
        r4.<init>(r3);
        r3 = r4;
    L_0x0033:
        r2.m21307a(r3);
    L_0x0036:
        return r1;
    L_0x0037:
        r2 = r0.mo4754r();	 Catch:{ all -> 0x005c }
        r2 = r2.m42565i();	 Catch:{ all -> 0x005c }
        r3 = "Interrupted waiting for ";	 Catch:{ all -> 0x005c }
        r4 = java.lang.String.valueOf(r4);	 Catch:{ all -> 0x005c }
        r5 = r4.length();	 Catch:{ all -> 0x005c }
        if (r5 == 0) goto L_0x0050;	 Catch:{ all -> 0x005c }
    L_0x004b:
        r3 = r3.concat(r4);	 Catch:{ all -> 0x005c }
        goto L_0x0056;	 Catch:{ all -> 0x005c }
    L_0x0050:
        r4 = new java.lang.String;	 Catch:{ all -> 0x005c }
        r4.<init>(r3);	 Catch:{ all -> 0x005c }
        r3 = r4;	 Catch:{ all -> 0x005c }
    L_0x0056:
        r2.m21307a(r3);	 Catch:{ all -> 0x005c }
        r2 = 0;	 Catch:{ all -> 0x005c }
        monitor-exit(r1);	 Catch:{ all -> 0x005c }
        return r2;	 Catch:{ all -> 0x005c }
    L_0x005c:
        r2 = move-exception;	 Catch:{ all -> 0x005c }
        monitor-exit(r1);	 Catch:{ all -> 0x005c }
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.l.cb.a(java.util.concurrent.atomic.AtomicReference, long, java.lang.String, java.lang.Runnable):T");
    }

    /* renamed from: a */
    public final <V> Future<V> m42610a(Callable<V> callable) {
        m38104z();
        C2872v.a(callable);
        ce ceVar = new ce(this, (Callable) callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.f32349b) {
            if (!this.f32351d.isEmpty()) {
                mo4754r().m42565i().m21307a("Callable skipped the worker queue.");
            }
            ceVar.run();
        } else {
            m42602a(ceVar);
        }
        return ceVar;
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo6207a() {
        super.mo6207a();
    }

    /* renamed from: a */
    public final void m42612a(Runnable runnable) {
        m38104z();
        C2872v.a(runnable);
        m42602a(new ce(this, runnable, false, "Task exception on worker thread"));
    }

    /* renamed from: b */
    public final <V> Future<V> m42613b(Callable<V> callable) {
        m38104z();
        C2872v.a(callable);
        ce ceVar = new ce(this, (Callable) callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.f32349b) {
            ceVar.run();
        } else {
            m42602a(ceVar);
        }
        return ceVar;
    }

    /* renamed from: b */
    public final /* bridge */ /* synthetic */ void mo6208b() {
        super.mo6208b();
    }

    /* renamed from: b */
    public final void m42615b(Runnable runnable) {
        m38104z();
        C2872v.a(runnable);
        ce ceVar = new ce(this, runnable, false, "Task exception on network thread");
        synchronized (this.f32355h) {
            this.f32352e.add(ceVar);
            if (this.f32350c == null) {
                this.f32350c = new cf(this, "Measurement Network", this.f32352e);
                this.f32350c.setUncaughtExceptionHandler(this.f32354g);
                this.f32350c.start();
            } else {
                this.f32350c.m21336a();
            }
        }
    }

    /* renamed from: c */
    public final void mo6209c() {
        if (Thread.currentThread() != this.f32350c) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    /* renamed from: d */
    public final void mo6210d() {
        if (Thread.currentThread() != this.f32349b) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    /* renamed from: e */
    protected final boolean mo6739e() {
        return false;
    }

    /* renamed from: g */
    public final boolean m42619g() {
        return Thread.currentThread() == this.f32349b;
    }

    /* renamed from: h */
    final ExecutorService m42620h() {
        ExecutorService executorService;
        synchronized (this.f32355h) {
            if (this.f32348a == null) {
                this.f32348a = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new ArrayBlockingQueue(100));
            }
            executorService = this.f32348a;
        }
        return executorService;
    }

    /* renamed from: l */
    public final /* bridge */ /* synthetic */ ak mo6211l() {
        return super.mo6211l();
    }

    /* renamed from: m */
    public final /* bridge */ /* synthetic */ C2895e mo4751m() {
        return super.mo4751m();
    }

    /* renamed from: n */
    public final /* bridge */ /* synthetic */ Context mo4752n() {
        return super.mo4752n();
    }

    /* renamed from: o */
    public final /* bridge */ /* synthetic */ az mo6212o() {
        return super.mo6212o();
    }

    /* renamed from: p */
    public final /* bridge */ /* synthetic */ fw mo6213p() {
        return super.mo6213p();
    }

    /* renamed from: q */
    public final /* bridge */ /* synthetic */ cb mo4753q() {
        return super.mo4753q();
    }

    /* renamed from: r */
    public final /* bridge */ /* synthetic */ bb mo4754r() {
        return super.mo4754r();
    }

    /* renamed from: s */
    public final /* bridge */ /* synthetic */ bm mo6214s() {
        return super.mo6214s();
    }

    /* renamed from: t */
    public final /* bridge */ /* synthetic */ aa mo6215t() {
        return super.mo6215t();
    }

    /* renamed from: u */
    public final /* bridge */ /* synthetic */ C5052x mo4755u() {
        return super.mo4755u();
    }
}
