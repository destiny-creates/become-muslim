package com.google.android.gms.analytics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Process;
import android.util.DisplayMetrics;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.internal.p210i.bz;
import com.google.android.gms.internal.p210i.eg;
import com.google.android.gms.internal.p210i.jl;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressLint({"StaticFieldLeak"})
/* renamed from: com.google.android.gms.analytics.s */
public final class C2721s {
    /* renamed from: a */
    private static volatile C2721s f6982a;
    /* renamed from: b */
    private final Context f6983b;
    /* renamed from: c */
    private final List<C2724v> f6984c = new CopyOnWriteArrayList();
    /* renamed from: d */
    private final C4310m f6985d = new C4310m();
    /* renamed from: e */
    private final C2718a f6986e = new C2718a(this);
    /* renamed from: f */
    private volatile eg f6987f;
    /* renamed from: g */
    private UncaughtExceptionHandler f6988g;

    /* renamed from: com.google.android.gms.analytics.s$a */
    class C2718a extends ThreadPoolExecutor {
        /* renamed from: a */
        final /* synthetic */ C2721s f6980a;

        public C2718a(C2721s c2721s) {
            this.f6980a = c2721s;
            super(1, 1, 1, TimeUnit.MINUTES, new LinkedBlockingQueue());
            setThreadFactory(new C2719b());
            allowCoreThreadTimeOut(true);
        }

        protected final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
            return new C2723u(this, runnable, t);
        }
    }

    /* renamed from: com.google.android.gms.analytics.s$b */
    static class C2719b implements ThreadFactory {
        /* renamed from: a */
        private static final AtomicInteger f6981a = new AtomicInteger();

        private C2719b() {
        }

        public final Thread newThread(Runnable runnable) {
            int incrementAndGet = f6981a.incrementAndGet();
            StringBuilder stringBuilder = new StringBuilder(23);
            stringBuilder.append("measurement-");
            stringBuilder.append(incrementAndGet);
            return new C2720c(runnable, stringBuilder.toString());
        }
    }

    /* renamed from: com.google.android.gms.analytics.s$c */
    static class C2720c extends Thread {
        C2720c(Runnable runnable, String str) {
            super(runnable, str);
        }

        public final void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    private C2721s(Context context) {
        Object applicationContext = context.getApplicationContext();
        C2872v.m8380a(applicationContext);
        this.f6983b = applicationContext;
    }

    /* renamed from: a */
    public static C2721s m7765a(Context context) {
        C2872v.m8380a((Object) context);
        if (f6982a == null) {
            synchronized (C2721s.class) {
                if (f6982a == null) {
                    f6982a = new C2721s(context);
                }
            }
        }
        return f6982a;
    }

    /* renamed from: a */
    public final com.google.android.gms.internal.p210i.eg m7771a() {
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
        r7 = this;
        r0 = r7.f6987f;
        if (r0 != 0) goto L_0x0070;
    L_0x0004:
        monitor-enter(r7);
        r0 = r7.f6987f;	 Catch:{ all -> 0x006d }
        if (r0 != 0) goto L_0x006b;	 Catch:{ all -> 0x006d }
    L_0x0009:
        r0 = new com.google.android.gms.internal.i.eg;	 Catch:{ all -> 0x006d }
        r0.<init>();	 Catch:{ all -> 0x006d }
        r1 = r7.f6983b;	 Catch:{ all -> 0x006d }
        r1 = r1.getPackageManager();	 Catch:{ all -> 0x006d }
        r2 = r7.f6983b;	 Catch:{ all -> 0x006d }
        r2 = r2.getPackageName();	 Catch:{ all -> 0x006d }
        r0.c(r2);	 Catch:{ all -> 0x006d }
        r3 = r1.getInstallerPackageName(r2);	 Catch:{ all -> 0x006d }
        r0.d(r3);	 Catch:{ all -> 0x006d }
        r3 = 0;
        r4 = r7.f6983b;	 Catch:{ NameNotFoundException -> 0x0047 }
        r4 = r4.getPackageName();	 Catch:{ NameNotFoundException -> 0x0047 }
        r5 = 0;	 Catch:{ NameNotFoundException -> 0x0047 }
        r4 = r1.getPackageInfo(r4, r5);	 Catch:{ NameNotFoundException -> 0x0047 }
        if (r4 == 0) goto L_0x0063;	 Catch:{ NameNotFoundException -> 0x0047 }
    L_0x0032:
        r5 = r4.applicationInfo;	 Catch:{ NameNotFoundException -> 0x0047 }
        r1 = r1.getApplicationLabel(r5);	 Catch:{ NameNotFoundException -> 0x0047 }
        r5 = android.text.TextUtils.isEmpty(r1);	 Catch:{ NameNotFoundException -> 0x0047 }
        if (r5 != 0) goto L_0x0043;	 Catch:{ NameNotFoundException -> 0x0047 }
    L_0x003e:
        r1 = r1.toString();	 Catch:{ NameNotFoundException -> 0x0047 }
        r2 = r1;	 Catch:{ NameNotFoundException -> 0x0047 }
    L_0x0043:
        r1 = r4.versionName;	 Catch:{ NameNotFoundException -> 0x0047 }
        r3 = r1;
        goto L_0x0063;
    L_0x0047:
        r1 = "GAv4";	 Catch:{ all -> 0x006d }
        r4 = "Error retrieving package info: appName set to ";	 Catch:{ all -> 0x006d }
        r5 = java.lang.String.valueOf(r2);	 Catch:{ all -> 0x006d }
        r6 = r5.length();	 Catch:{ all -> 0x006d }
        if (r6 == 0) goto L_0x005a;	 Catch:{ all -> 0x006d }
    L_0x0055:
        r4 = r4.concat(r5);	 Catch:{ all -> 0x006d }
        goto L_0x0060;	 Catch:{ all -> 0x006d }
    L_0x005a:
        r5 = new java.lang.String;	 Catch:{ all -> 0x006d }
        r5.<init>(r4);	 Catch:{ all -> 0x006d }
        r4 = r5;	 Catch:{ all -> 0x006d }
    L_0x0060:
        android.util.Log.e(r1, r4);	 Catch:{ all -> 0x006d }
    L_0x0063:
        r0.a(r2);	 Catch:{ all -> 0x006d }
        r0.b(r3);	 Catch:{ all -> 0x006d }
        r7.f6987f = r0;	 Catch:{ all -> 0x006d }
    L_0x006b:
        monitor-exit(r7);	 Catch:{ all -> 0x006d }
        goto L_0x0070;	 Catch:{ all -> 0x006d }
    L_0x006d:
        r0 = move-exception;	 Catch:{ all -> 0x006d }
        monitor-exit(r7);	 Catch:{ all -> 0x006d }
        throw r0;
    L_0x0070:
        r0 = r7.f6987f;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.s.a():com.google.android.gms.internal.i.eg");
    }

    /* renamed from: b */
    public final jl m7776b() {
        DisplayMetrics displayMetrics = this.f6983b.getResources().getDisplayMetrics();
        jl jlVar = new jl();
        jlVar.a(bz.a(Locale.getDefault()));
        jlVar.f24539b = displayMetrics.widthPixels;
        jlVar.f24540c = displayMetrics.heightPixels;
        return jlVar;
    }

    /* renamed from: a */
    final void m7773a(C2714o c2714o) {
        if (c2714o.m7754i()) {
            throw new IllegalStateException("Measurement prototype can't be submitted");
        } else if (c2714o.m7751f()) {
            throw new IllegalStateException("Measurement can only be submitted once");
        } else {
            c2714o = c2714o.m7742a();
            c2714o.m7752g();
            this.f6986e.execute(new C2722t(this, c2714o));
        }
    }

    /* renamed from: c */
    public final Context m7777c() {
        return this.f6983b;
    }

    /* renamed from: d */
    public static void m7770d() {
        if (!(Thread.currentThread() instanceof C2720c)) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    /* renamed from: a */
    public final void m7775a(UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f6988g = uncaughtExceptionHandler;
    }

    /* renamed from: a */
    public final <V> Future<V> m7772a(Callable<V> callable) {
        C2872v.m8380a((Object) callable);
        if (!(Thread.currentThread() instanceof C2720c)) {
            return this.f6986e.submit(callable);
        }
        Future futureTask = new FutureTask(callable);
        futureTask.run();
        return futureTask;
    }

    /* renamed from: a */
    public final void m7774a(Runnable runnable) {
        C2872v.m8380a((Object) runnable);
        this.f6986e.submit(runnable);
    }

    /* renamed from: b */
    private static void m7769b(C2714o c2714o) {
        C2872v.m8393c("deliver should be called from worker thread");
        C2872v.m8391b(c2714o.m7751f(), "Measurement must be submitted");
        List<C2725w> c = c2714o.m7748c();
        if (!c.isEmpty()) {
            Set hashSet = new HashSet();
            for (C2725w c2725w : c) {
                Uri a = c2725w.mo2357a();
                if (!hashSet.contains(a)) {
                    hashSet.add(a);
                    c2725w.mo2358a(c2714o);
                }
            }
        }
    }
}
