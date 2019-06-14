package com.p064b.p065a.p066a;

import io.p347a.p348a.p349a.C6514c;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: BackgroundManager */
/* renamed from: com.b.a.a.g */
class C0992g {
    /* renamed from: a */
    final AtomicReference<ScheduledFuture<?>> f2757a = new AtomicReference();
    /* renamed from: b */
    boolean f2758b = true;
    /* renamed from: c */
    private final ScheduledExecutorService f2759c;
    /* renamed from: d */
    private final List<C0991a> f2760d = new ArrayList();
    /* renamed from: e */
    private volatile boolean f2761e = true;

    /* compiled from: BackgroundManager */
    /* renamed from: com.b.a.a.g$1 */
    class C09901 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C0992g f2756a;

        C09901(C0992g c0992g) {
            this.f2756a = c0992g;
        }

        public void run() {
            this.f2756a.f2757a.set(null);
            this.f2756a.m3432c();
        }
    }

    /* compiled from: BackgroundManager */
    /* renamed from: com.b.a.a.g$a */
    public interface C0991a {
        /* renamed from: a */
        void mo745a();
    }

    public C0992g(ScheduledExecutorService scheduledExecutorService) {
        this.f2759c = scheduledExecutorService;
    }

    /* renamed from: a */
    public void m3435a(boolean z) {
        this.f2761e = z;
    }

    /* renamed from: c */
    private void m3432c() {
        for (C0991a a : this.f2760d) {
            a.mo745a();
        }
    }

    /* renamed from: a */
    public void m3434a(C0991a c0991a) {
        this.f2760d.add(c0991a);
    }

    /* renamed from: a */
    public void m3433a() {
        this.f2758b = false;
        ScheduledFuture scheduledFuture = (ScheduledFuture) this.f2757a.getAndSet(null);
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }

    /* renamed from: b */
    public void m3436b() {
        if (this.f2761e && !this.f2758b) {
            this.f2758b = true;
            try {
                this.f2757a.compareAndSet(null, this.f2759c.schedule(new C09901(this), 5000, TimeUnit.MILLISECONDS));
            } catch (Throwable e) {
                C6514c.h().a("Answers", "Failed to schedule background detector", e);
            }
        }
    }
}
