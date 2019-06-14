package com.google.android.gms.p186f;

import com.google.android.gms.common.internal.C2872v;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.google.android.gms.f.j */
public final class C2958j {

    /* renamed from: com.google.android.gms.f.j$b */
    interface C4405b extends C2949b, C2951d, C2952e<Object> {
    }

    /* renamed from: com.google.android.gms.f.j$a */
    private static final class C4791a implements C4405b {
        /* renamed from: a */
        private final CountDownLatch f13324a;

        private C4791a() {
            this.f13324a = new CountDownLatch(1);
        }

        /* renamed from: a */
        public final void mo2577a(Object obj) {
            this.f13324a.countDown();
        }

        /* renamed from: a */
        public final void mo2576a(Exception exception) {
            this.f13324a.countDown();
        }

        /* renamed from: a */
        public final void mo2575a() {
            this.f13324a.countDown();
        }

        /* renamed from: b */
        public final void m16937b() {
            this.f13324a.await();
        }

        /* renamed from: a */
        public final boolean m16936a(long j, TimeUnit timeUnit) {
            return this.f13324a.await(j, timeUnit);
        }
    }

    /* renamed from: a */
    public static <TResult> C2954g<TResult> m8789a(TResult tResult) {
        C2954g c4412z = new C4412z();
        c4412z.m14673a((Object) tResult);
        return c4412z;
    }

    /* renamed from: a */
    public static <TResult> C2954g<TResult> m8788a(Exception exception) {
        C2954g c4412z = new C4412z();
        c4412z.m14672a(exception);
        return c4412z;
    }

    /* renamed from: a */
    public static <TResult> C2954g<TResult> m8790a(Executor executor, Callable<TResult> callable) {
        C2872v.m8381a((Object) executor, (Object) "Executor must not be null");
        C2872v.m8381a((Object) callable, (Object) "Callback must not be null");
        C2954g c4412z = new C4412z();
        executor.execute(new aa(c4412z, callable));
        return c4412z;
    }

    /* renamed from: a */
    public static <TResult> TResult m8791a(C2954g<TResult> c2954g) {
        C2872v.m8384a();
        C2872v.m8381a((Object) c2954g, (Object) "Task must not be null");
        if (c2954g.mo2587a()) {
            return C2958j.m8794b(c2954g);
        }
        C4405b c4791a = new C4791a();
        C2958j.m8793a((C2954g) c2954g, c4791a);
        c4791a.m16937b();
        return C2958j.m8794b(c2954g);
    }

    /* renamed from: a */
    public static <TResult> TResult m8792a(C2954g<TResult> c2954g, long j, TimeUnit timeUnit) {
        C2872v.m8384a();
        C2872v.m8381a((Object) c2954g, (Object) "Task must not be null");
        C2872v.m8381a((Object) timeUnit, (Object) "TimeUnit must not be null");
        if (c2954g.mo2587a()) {
            return C2958j.m8794b(c2954g);
        }
        C4405b c4791a = new C4791a();
        C2958j.m8793a((C2954g) c2954g, c4791a);
        if (c4791a.m16936a(j, timeUnit) != null) {
            return C2958j.m8794b(c2954g);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    /* renamed from: b */
    private static <TResult> TResult m8794b(C2954g<TResult> c2954g) {
        if (c2954g.mo2589b()) {
            return c2954g.mo2591d();
        }
        if (c2954g.mo2590c()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(c2954g.mo2592e());
    }

    /* renamed from: a */
    private static void m8793a(C2954g<?> c2954g, C4405b c4405b) {
        c2954g.mo2585a(C2957i.f7594b, (C2952e) c4405b);
        c2954g.mo2584a(C2957i.f7594b, (C2951d) c4405b);
        c2954g.mo2582a(C2957i.f7594b, (C2949b) c4405b);
    }
}
