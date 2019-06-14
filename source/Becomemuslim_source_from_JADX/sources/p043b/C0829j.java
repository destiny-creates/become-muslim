package p043b;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* compiled from: Task */
/* renamed from: b.j */
public class C0829j<TResult> {
    /* renamed from: a */
    public static final ExecutorService f2301a = C0819d.m2968a();
    /* renamed from: b */
    public static final Executor f2302b = C0813a.m2963b();
    /* renamed from: c */
    private static final Executor f2303c = C0819d.m2969b();
    /* renamed from: d */
    private static volatile C0828b f2304d;
    /* renamed from: m */
    private static C0829j<?> f2305m = new C0829j(null);
    /* renamed from: n */
    private static C0829j<Boolean> f2306n = new C0829j(Boolean.valueOf(true));
    /* renamed from: o */
    private static C0829j<Boolean> f2307o = new C0829j(Boolean.valueOf(false));
    /* renamed from: p */
    private static C0829j<?> f2308p = new C0829j(true);
    /* renamed from: e */
    private final Object f2309e = new Object();
    /* renamed from: f */
    private boolean f2310f;
    /* renamed from: g */
    private boolean f2311g;
    /* renamed from: h */
    private TResult f2312h;
    /* renamed from: i */
    private Exception f2313i;
    /* renamed from: j */
    private boolean f2314j;
    /* renamed from: k */
    private C0831l f2315k;
    /* renamed from: l */
    private List<C0823h<TResult, Void>> f2316l = new ArrayList();

    /* compiled from: Task */
    /* renamed from: b.j$b */
    public interface C0828b {
        /* renamed from: a */
        void m2976a(C0829j<?> c0829j, C0832m c0832m);
    }

    /* compiled from: Task */
    /* renamed from: b.j$a */
    public class C3338a extends C0830k<TResult> {
        /* renamed from: a */
        final /* synthetic */ C0829j f8882a;

        C3338a(C0829j c0829j) {
            this.f8882a = c0829j;
        }
    }

    /* renamed from: a */
    public static C0828b m2977a() {
        return f2304d;
    }

    C0829j() {
    }

    private C0829j(TResult tResult) {
        m2995b((Object) tResult);
    }

    private C0829j(boolean z) {
        if (z) {
            m3003i();
        } else {
            m2995b((Object) false);
        }
    }

    /* renamed from: b */
    public static <TResult> C3338a m2983b() {
        C0829j c0829j = new C0829j();
        c0829j.getClass();
        return new C3338a(c0829j);
    }

    /* renamed from: c */
    public boolean m2998c() {
        boolean z;
        synchronized (this.f2309e) {
            z = this.f2310f;
        }
        return z;
    }

    /* renamed from: d */
    public boolean m2999d() {
        boolean z;
        synchronized (this.f2309e) {
            z = this.f2311g;
        }
        return z;
    }

    /* renamed from: e */
    public boolean m3000e() {
        boolean z;
        synchronized (this.f2309e) {
            z = m3002g() != null;
        }
        return z;
    }

    /* renamed from: f */
    public TResult m3001f() {
        TResult tResult;
        synchronized (this.f2309e) {
            tResult = this.f2312h;
        }
        return tResult;
    }

    /* renamed from: g */
    public Exception m3002g() {
        Exception exception;
        synchronized (this.f2309e) {
            if (this.f2313i != null) {
                this.f2314j = true;
                if (this.f2315k != null) {
                    this.f2315k.m3011a();
                    this.f2315k = null;
                }
            }
            exception = this.f2313i;
        }
        return exception;
    }

    /* renamed from: a */
    public static <TResult> C0829j<TResult> m2979a(TResult tResult) {
        if (tResult == null) {
            return f2305m;
        }
        if (tResult instanceof Boolean) {
            return ((Boolean) tResult).booleanValue() != null ? f2306n : f2307o;
        }
        C0830k c0830k = new C0830k();
        c0830k.m3008b((Object) tResult);
        return c0830k.m3004a();
    }

    /* renamed from: a */
    public static <TResult> C0829j<TResult> m2978a(Exception exception) {
        C0830k c0830k = new C0830k();
        c0830k.m3007b(exception);
        return c0830k.m3004a();
    }

    /* renamed from: h */
    public static <TResult> C0829j<TResult> m2987h() {
        return f2308p;
    }

    /* renamed from: a */
    public static <TResult> C0829j<TResult> m2980a(Callable<TResult> callable, Executor executor) {
        return C0829j.m2981a((Callable) callable, executor, null);
    }

    /* renamed from: a */
    public static <TResult> C0829j<TResult> m2981a(final Callable<TResult> callable, Executor executor, final C0820e c0820e) {
        final C0830k c0830k = new C0830k();
        try {
            executor.execute(new Runnable() {
                public void run() {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
                    /*
                    r2 = this;
                    r0 = r4;
                    if (r0 == 0) goto L_0x0012;
                L_0x0004:
                    r0 = r4;
                    r0 = r0.m2971a();
                    if (r0 == 0) goto L_0x0012;
                L_0x000c:
                    r0 = r0;
                    r0.m3010c();
                    return;
                L_0x0012:
                    r0 = r0;	 Catch:{ CancellationException -> 0x0025, Exception -> 0x001e }
                    r1 = r2;	 Catch:{ CancellationException -> 0x0025, Exception -> 0x001e }
                    r1 = r1.call();	 Catch:{ CancellationException -> 0x0025, Exception -> 0x001e }
                    r0.m3008b(r1);	 Catch:{ CancellationException -> 0x0025, Exception -> 0x001e }
                    goto L_0x002a;
                L_0x001e:
                    r0 = move-exception;
                    r1 = r0;
                    r1.m3007b(r0);
                    goto L_0x002a;
                L_0x0025:
                    r0 = r0;
                    r0.m3010c();
                L_0x002a:
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: b.j.6.run():void");
                }
            });
        } catch (Callable<TResult> callable2) {
            c0830k.m3007b(new C0824i(callable2));
        }
        return c0830k.m3004a();
    }

    /* renamed from: a */
    public <TContinuationResult> C0829j<TContinuationResult> m2991a(C0823h<TResult, TContinuationResult> c0823h, Executor executor, C0820e c0820e) {
        C0830k c0830k = new C0830k();
        synchronized (this.f2309e) {
            boolean c = m2998c();
            if (!c) {
                final C0830k c0830k2 = c0830k;
                final C0823h<TResult, TContinuationResult> c0823h2 = c0823h;
                final Executor executor2 = executor;
                final C0820e c0820e2 = c0820e;
                this.f2316l.add(new C0823h<TResult, Void>(this) {
                    /* renamed from: e */
                    final /* synthetic */ C0829j f8872e;

                    public /* synthetic */ Object then(C0829j c0829j) {
                        return m10640a(c0829j);
                    }

                    /* renamed from: a */
                    public Void m10640a(C0829j<TResult> c0829j) {
                        C0829j.m2985c(c0830k2, c0823h2, c0829j, executor2, c0820e2);
                        return null;
                    }
                });
            }
        }
        if (c) {
            C0829j.m2985c(c0830k, c0823h, this, executor, c0820e);
        }
        return c0830k.m3004a();
    }

    /* renamed from: a */
    public <TContinuationResult> C0829j<TContinuationResult> m2989a(C0823h<TResult, TContinuationResult> c0823h) {
        return m2991a((C0823h) c0823h, f2303c, null);
    }

    /* renamed from: a */
    public <TContinuationResult> C0829j<TContinuationResult> m2990a(C0823h<TResult, C0829j<TContinuationResult>> c0823h, Executor executor) {
        return m2993b(c0823h, executor, null);
    }

    /* renamed from: b */
    public <TContinuationResult> C0829j<TContinuationResult> m2993b(C0823h<TResult, C0829j<TContinuationResult>> c0823h, Executor executor, C0820e c0820e) {
        C0830k c0830k = new C0830k();
        synchronized (this.f2309e) {
            boolean c = m2998c();
            if (!c) {
                final C0830k c0830k2 = c0830k;
                final C0823h<TResult, C0829j<TContinuationResult>> c0823h2 = c0823h;
                final Executor executor2 = executor;
                final C0820e c0820e2 = c0820e;
                this.f2316l.add(new C0823h<TResult, Void>(this) {
                    /* renamed from: e */
                    final /* synthetic */ C0829j f8877e;

                    public /* synthetic */ Object then(C0829j c0829j) {
                        return m10641a(c0829j);
                    }

                    /* renamed from: a */
                    public Void m10641a(C0829j<TResult> c0829j) {
                        C0829j.m2986d(c0830k2, c0823h2, c0829j, executor2, c0820e2);
                        return null;
                    }
                });
            }
        }
        if (c) {
            C0829j.m2986d(c0830k, c0823h, this, executor, c0820e);
        }
        return c0830k.m3004a();
    }

    /* renamed from: b */
    public <TContinuationResult> C0829j<TContinuationResult> m2992b(C0823h<TResult, C0829j<TContinuationResult>> c0823h) {
        return m2993b(c0823h, f2303c, null);
    }

    /* renamed from: c */
    public <TContinuationResult> C0829j<TContinuationResult> m2997c(final C0823h<TResult, TContinuationResult> c0823h, Executor executor, final C0820e c0820e) {
        return m2990a(new C0823h<TResult, C0829j<TContinuationResult>>(this) {
            /* renamed from: c */
            final /* synthetic */ C0829j f8880c;

            public /* synthetic */ Object then(C0829j c0829j) {
                return m10642a(c0829j);
            }

            /* renamed from: a */
            public C0829j<TContinuationResult> m10642a(C0829j<TResult> c0829j) {
                if (c0820e != null && c0820e.m2971a()) {
                    return C0829j.m2987h();
                }
                if (c0829j.m3000e()) {
                    return C0829j.m2978a(c0829j.m3002g());
                }
                if (c0829j.m2999d()) {
                    return C0829j.m2987h();
                }
                return c0829j.m2989a(c0823h);
            }
        }, executor);
    }

    /* renamed from: c */
    public <TContinuationResult> C0829j<TContinuationResult> m2996c(C0823h<TResult, TContinuationResult> c0823h) {
        return m2997c(c0823h, f2303c, null);
    }

    /* renamed from: c */
    private static <TContinuationResult, TResult> void m2985c(final C0830k<TContinuationResult> c0830k, final C0823h<TResult, TContinuationResult> c0823h, final C0829j<TResult> c0829j, Executor executor, final C0820e c0820e) {
        try {
            executor.execute(new Runnable() {
                public void run() {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
                    /*
                    r2 = this;
                    r0 = r5;
                    if (r0 == 0) goto L_0x0012;
                L_0x0004:
                    r0 = r5;
                    r0 = r0.m2971a();
                    if (r0 == 0) goto L_0x0012;
                L_0x000c:
                    r0 = r1;
                    r0.m3010c();
                    return;
                L_0x0012:
                    r0 = r2;	 Catch:{ CancellationException -> 0x0027, Exception -> 0x0020 }
                    r1 = r3;	 Catch:{ CancellationException -> 0x0027, Exception -> 0x0020 }
                    r0 = r0.then(r1);	 Catch:{ CancellationException -> 0x0027, Exception -> 0x0020 }
                    r1 = r1;	 Catch:{ CancellationException -> 0x0027, Exception -> 0x0020 }
                    r1.m3008b(r0);	 Catch:{ CancellationException -> 0x0027, Exception -> 0x0020 }
                    goto L_0x002c;
                L_0x0020:
                    r0 = move-exception;
                    r1 = r1;
                    r1.m3007b(r0);
                    goto L_0x002c;
                L_0x0027:
                    r0 = r1;
                    r0.m3010c();
                L_0x002c:
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: b.j.4.run():void");
                }
            });
        } catch (C0823h<TResult, TContinuationResult> c0823h2) {
            c0830k.m3007b(new C0824i(c0823h2));
        }
    }

    /* renamed from: d */
    private static <TContinuationResult, TResult> void m2986d(final C0830k<TContinuationResult> c0830k, final C0823h<TResult, C0829j<TContinuationResult>> c0823h, final C0829j<TResult> c0829j, Executor executor, final C0820e c0820e) {
        try {
            executor.execute(new Runnable() {

                /* compiled from: Task */
                /* renamed from: b.j$5$1 */
                class C33371 implements C0823h<TContinuationResult, Void> {
                    /* renamed from: a */
                    final /* synthetic */ C08265 f8881a;

                    C33371(C08265 c08265) {
                        this.f8881a = c08265;
                    }

                    public /* synthetic */ Object then(C0829j c0829j) {
                        return m10643a(c0829j);
                    }

                    /* renamed from: a */
                    public Void m10643a(C0829j<TContinuationResult> c0829j) {
                        if (c0820e == null || !c0820e.m2971a()) {
                            if (c0829j.m2999d()) {
                                c0830k.m3010c();
                            } else if (c0829j.m3000e()) {
                                c0830k.m3007b(c0829j.m3002g());
                            } else {
                                c0830k.m3008b(c0829j.m3001f());
                            }
                            return null;
                        }
                        c0830k.m3010c();
                        return null;
                    }
                }

                public void run() {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
                    /*
                    r2 = this;
                    r0 = r5;
                    if (r0 == 0) goto L_0x0012;
                L_0x0004:
                    r0 = r5;
                    r0 = r0.m2971a();
                    if (r0 == 0) goto L_0x0012;
                L_0x000c:
                    r0 = r1;
                    r0.m3010c();
                    return;
                L_0x0012:
                    r0 = r2;	 Catch:{ CancellationException -> 0x0035, Exception -> 0x002e }
                    r1 = r3;	 Catch:{ CancellationException -> 0x0035, Exception -> 0x002e }
                    r0 = r0.then(r1);	 Catch:{ CancellationException -> 0x0035, Exception -> 0x002e }
                    r0 = (p043b.C0829j) r0;	 Catch:{ CancellationException -> 0x0035, Exception -> 0x002e }
                    if (r0 != 0) goto L_0x0025;	 Catch:{ CancellationException -> 0x0035, Exception -> 0x002e }
                L_0x001e:
                    r0 = r1;	 Catch:{ CancellationException -> 0x0035, Exception -> 0x002e }
                    r1 = 0;	 Catch:{ CancellationException -> 0x0035, Exception -> 0x002e }
                    r0.m3008b(r1);	 Catch:{ CancellationException -> 0x0035, Exception -> 0x002e }
                    goto L_0x003a;	 Catch:{ CancellationException -> 0x0035, Exception -> 0x002e }
                L_0x0025:
                    r1 = new b.j$5$1;	 Catch:{ CancellationException -> 0x0035, Exception -> 0x002e }
                    r1.<init>(r2);	 Catch:{ CancellationException -> 0x0035, Exception -> 0x002e }
                    r0.m2989a(r1);	 Catch:{ CancellationException -> 0x0035, Exception -> 0x002e }
                    goto L_0x003a;
                L_0x002e:
                    r0 = move-exception;
                    r1 = r1;
                    r1.m3007b(r0);
                    goto L_0x003a;
                L_0x0035:
                    r0 = r1;
                    r0.m3010c();
                L_0x003a:
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: b.j.5.run():void");
                }
            });
        } catch (C0823h<TResult, C0829j<TContinuationResult>> c0823h2) {
            c0830k.m3007b(new C0824i(c0823h2));
        }
    }

    /* renamed from: j */
    private void m2988j() {
        synchronized (this.f2309e) {
            for (C0823h then : this.f2316l) {
                try {
                    then.then(this);
                } catch (RuntimeException e) {
                    throw e;
                } catch (Throwable e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.f2316l = null;
        }
    }

    /* renamed from: i */
    boolean m3003i() {
        synchronized (this.f2309e) {
            if (this.f2310f) {
                return false;
            }
            this.f2310f = true;
            this.f2311g = true;
            this.f2309e.notifyAll();
            m2988j();
            return true;
        }
    }

    /* renamed from: b */
    boolean m2995b(TResult tResult) {
        synchronized (this.f2309e) {
            if (this.f2310f) {
                return null;
            }
            this.f2310f = true;
            this.f2312h = tResult;
            this.f2309e.notifyAll();
            m2988j();
            return true;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    boolean m2994b(java.lang.Exception r4) {
        /*
        r3 = this;
        r0 = r3.f2309e;
        monitor-enter(r0);
        r1 = r3.f2310f;	 Catch:{ all -> 0x002c }
        r2 = 0;
        if (r1 == 0) goto L_0x000a;
    L_0x0008:
        monitor-exit(r0);	 Catch:{ all -> 0x002c }
        return r2;
    L_0x000a:
        r1 = 1;
        r3.f2310f = r1;	 Catch:{ all -> 0x002c }
        r3.f2313i = r4;	 Catch:{ all -> 0x002c }
        r3.f2314j = r2;	 Catch:{ all -> 0x002c }
        r4 = r3.f2309e;	 Catch:{ all -> 0x002c }
        r4.notifyAll();	 Catch:{ all -> 0x002c }
        r3.m2988j();	 Catch:{ all -> 0x002c }
        r4 = r3.f2314j;	 Catch:{ all -> 0x002c }
        if (r4 != 0) goto L_0x002a;
    L_0x001d:
        r4 = p043b.C0829j.m2977a();	 Catch:{ all -> 0x002c }
        if (r4 == 0) goto L_0x002a;
    L_0x0023:
        r4 = new b.l;	 Catch:{ all -> 0x002c }
        r4.<init>(r3);	 Catch:{ all -> 0x002c }
        r3.f2315k = r4;	 Catch:{ all -> 0x002c }
    L_0x002a:
        monitor-exit(r0);	 Catch:{ all -> 0x002c }
        return r1;
    L_0x002c:
        r4 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x002c }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: b.j.b(java.lang.Exception):boolean");
    }
}
