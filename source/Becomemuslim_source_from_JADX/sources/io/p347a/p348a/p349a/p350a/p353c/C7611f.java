package io.p347a.p348a.p349a.p350a.p353c;

import io.p347a.p348a.p349a.p350a.p353c.C6456a.C6451d;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* compiled from: PriorityAsyncTask */
/* renamed from: io.a.a.a.a.c.f */
public abstract class C7611f<Params, Progress, Result> extends C6456a<Params, Progress, Result> implements C6457b<C6465l>, C6462i, C6465l {
    /* renamed from: a */
    private final C7613j f26312a = new C7613j();

    /* compiled from: PriorityAsyncTask */
    /* renamed from: io.a.a.a.a.c.f$a */
    private static class C6461a<Result> implements Executor {
        /* renamed from: a */
        private final Executor f20860a;
        /* renamed from: b */
        private final C7611f f20861b;

        public C6461a(Executor executor, C7611f c7611f) {
            this.f20860a = executor;
            this.f20861b = c7611f;
        }

        public void execute(Runnable runnable) {
            this.f20860a.execute(new C7612h<Result>(this, runnable, null) {
                /* renamed from: a */
                final /* synthetic */ C6461a f30384a;

                /* renamed from: a */
                public <T extends C6457b<C6465l> & C6462i & C6465l> T mo6413a() {
                    return this.f30384a.f20861b;
                }
            });
        }
    }

    /* renamed from: c */
    public /* synthetic */ void mo5444c(Object obj) {
        m34346a((C6465l) obj);
    }

    /* renamed from: a */
    public final void m34348a(ExecutorService executorService, Params... paramsArr) {
        super.m26462a(new C6461a(executorService, this), (Object[]) paramsArr);
    }

    public int compareTo(Object obj) {
        return C6460e.m26484a(this, obj);
    }

    /* renamed from: a */
    public void m34346a(C6465l c6465l) {
        if (Q_() == C6451d.PENDING) {
            ((C6457b) ((C6462i) m34355g())).mo5444c(c6465l);
            return;
        }
        throw new IllegalStateException("Must not add Dependency after task is running");
    }

    /* renamed from: c */
    public Collection<C6465l> mo5443c() {
        return ((C6457b) ((C6462i) m34355g())).mo5443c();
    }

    /* renamed from: d */
    public boolean mo5445d() {
        return ((C6457b) ((C6462i) m34355g())).mo5445d();
    }

    /* renamed from: b */
    public C6460e mo5441b() {
        return ((C6462i) m34355g()).mo5441b();
    }

    /* renamed from: b */
    public void mo5442b(boolean z) {
        ((C6465l) ((C6462i) m34355g())).mo5442b(z);
    }

    /* renamed from: f */
    public boolean mo5446f() {
        return ((C6465l) ((C6462i) m34355g())).mo5446f();
    }

    /* renamed from: a */
    public void mo5440a(Throwable th) {
        ((C6465l) ((C6462i) m34355g())).mo5440a(th);
    }

    /* renamed from: g */
    public <T extends C6457b<C6465l> & C6462i & C6465l> T m34355g() {
        return this.f26312a;
    }
}
