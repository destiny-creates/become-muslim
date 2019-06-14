package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.ax;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@cm
public final class nd {
    /* renamed from: a */
    public static <T> nm<T> m19937a(Throwable th) {
        return new nm(th);
    }

    /* renamed from: a */
    public static <T> nn<T> m19938a(T t) {
        return new nn(t);
    }

    /* renamed from: a */
    public static <V> no<V> m19939a(no<V> noVar, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        nz nzVar = new nz();
        m19947a((no) nzVar, (Future) noVar);
        Future schedule = scheduledExecutorService.schedule(new nh(nzVar), j, timeUnit);
        m19946a((no) noVar, nzVar);
        nzVar.mo4319a(new ni(schedule), nu.f15847b);
        return nzVar;
    }

    /* renamed from: a */
    public static <A, B> no<B> m19940a(no<A> noVar, my<? super A, ? extends B> myVar, Executor executor) {
        no nzVar = new nz();
        noVar.mo4319a(new ng(nzVar, myVar, noVar), executor);
        m19947a(nzVar, (Future) noVar);
        return nzVar;
    }

    /* renamed from: a */
    public static <A, B> no<B> m19941a(no<A> noVar, mz<A, B> mzVar, Executor executor) {
        no nzVar = new nz();
        noVar.mo4319a(new nf(nzVar, mzVar, noVar), executor);
        m19947a(nzVar, (Future) noVar);
        return nzVar;
    }

    /* renamed from: a */
    public static <V, X extends Throwable> no<V> m19942a(no<? extends V> noVar, Class<X> cls, my<? super X, ? extends V> myVar, Executor executor) {
        no nzVar = new nz();
        m19947a(nzVar, (Future) noVar);
        noVar.mo4319a(new nj(nzVar, noVar, cls, myVar, executor), nu.f15847b);
        return nzVar;
    }

    /* renamed from: a */
    public static <T> T m19943a(Future<T> future, T t) {
        Throwable e;
        try {
            return future.get(((Long) aph.m18688f().m18889a(asp.bz)).longValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            e = e2;
            future.cancel(true);
            mt.m19921c("InterruptedException caught while resolving future.", e);
            Thread.currentThread().interrupt();
            ax.i().m30837b(e, "Futures.resolveFuture");
            return t;
        } catch (Exception e3) {
            e = e3;
            future.cancel(true);
            mt.m19919b("Error waiting for future.", e);
            ax.i().m30837b(e, "Futures.resolveFuture");
            return t;
        }
    }

    /* renamed from: a */
    public static <T> T m19944a(Future<T> future, T t, long j, TimeUnit timeUnit) {
        Throwable e;
        try {
            return future.get(j, timeUnit);
        } catch (InterruptedException e2) {
            e = e2;
            future.cancel(true);
            mt.m19921c("InterruptedException caught while resolving future.", e);
            Thread.currentThread().interrupt();
            ax.i().m30834a(e, "Futures.resolveFuture");
            return t;
        } catch (Exception e3) {
            e = e3;
            future.cancel(true);
            mt.m19919b("Error waiting for future.", e);
            ax.i().m30834a(e, "Futures.resolveFuture");
            return t;
        }
    }

    /* renamed from: a */
    public static <V> void m19945a(no<V> noVar, na<V> naVar, Executor executor) {
        noVar.mo4319a(new ne(naVar, noVar), executor);
    }

    /* renamed from: a */
    private static <V> void m19946a(no<? extends V> noVar, nz<V> nzVar) {
        m19947a((no) nzVar, (Future) noVar);
        noVar.mo4319a(new nk(nzVar, noVar), nu.f15847b);
    }

    /* renamed from: a */
    private static <A, B> void m19947a(no<A> noVar, Future<B> future) {
        noVar.mo4319a(new nl(noVar, future), nu.f15847b);
    }

    /* renamed from: a */
    static final /* synthetic */ void m19948a(com.google.android.gms.internal.ads.nz r1, com.google.android.gms.internal.ads.my r2, com.google.android.gms.internal.ads.no r3) {
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
        r0 = r1.isCancelled();
        if (r0 == 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r3 = r3.get();	 Catch:{ CancellationException -> 0x002d, ExecutionException -> 0x0024, InterruptedException -> 0x0018, Exception -> 0x0013 }
        r2 = r2.mo4228a(r3);	 Catch:{ CancellationException -> 0x002d, ExecutionException -> 0x0024, InterruptedException -> 0x0018, Exception -> 0x0013 }
        m19946a(r2, r1);	 Catch:{ CancellationException -> 0x002d, ExecutionException -> 0x0024, InterruptedException -> 0x0018, Exception -> 0x0013 }
        return;
    L_0x0013:
        r2 = move-exception;
        r1.m30914a(r2);
        return;
    L_0x0018:
        r2 = move-exception;
        r3 = java.lang.Thread.currentThread();
        r3.interrupt();
        r1.m30914a(r2);
        return;
    L_0x0024:
        r2 = move-exception;
        r2 = r2.getCause();
        r1.m30914a(r2);
        return;
    L_0x002d:
        r2 = 1;
        r1.cancel(r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.nd.a(com.google.android.gms.internal.ads.nz, com.google.android.gms.internal.ads.my, com.google.android.gms.internal.ads.no):void");
    }

    /* renamed from: a */
    static final /* synthetic */ void m19949a(nz nzVar, no noVar, Class cls, my myVar, Executor executor) {
        Object cause;
        try {
            nzVar.m30915b(noVar.get());
        } catch (ExecutionException e) {
            cause = e.getCause();
            if (cls.isInstance(cause)) {
                m19946a(m19940a(m19938a(cause), myVar, executor), nzVar);
            } else {
                nzVar.m30914a(cause);
            }
        } catch (InterruptedException e2) {
            cause = e2;
            Thread.currentThread().interrupt();
            if (cls.isInstance(cause)) {
                nzVar.m30914a(cause);
            } else {
                m19946a(m19940a(m19938a(cause), myVar, executor), nzVar);
            }
        } catch (Exception e3) {
            cause = e3;
            if (cls.isInstance(cause)) {
                m19946a(m19940a(m19938a(cause), myVar, executor), nzVar);
            } else {
                nzVar.m30914a(cause);
            }
        }
    }
}
