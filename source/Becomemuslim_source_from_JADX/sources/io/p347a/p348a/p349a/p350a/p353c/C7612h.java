package io.p347a.p348a.p349a.p350a.p353c;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* compiled from: PriorityFutureTask */
/* renamed from: io.a.a.a.a.c.h */
public class C7612h<V> extends FutureTask<V> implements C6457b<C6465l>, C6462i, C6465l {
    /* renamed from: b */
    final Object f26313b;

    /* renamed from: c */
    public /* synthetic */ void mo5444c(Object obj) {
        m34358a((C6465l) obj);
    }

    public C7612h(Callable<V> callable) {
        super(callable);
        this.f26313b = m34357a((Object) callable);
    }

    public C7612h(Runnable runnable, V v) {
        super(runnable, v);
        this.f26313b = m34357a((Object) runnable);
    }

    public int compareTo(Object obj) {
        return ((C6462i) mo6413a()).compareTo(obj);
    }

    /* renamed from: a */
    public void m34358a(C6465l c6465l) {
        ((C6457b) ((C6462i) mo6413a())).mo5444c(c6465l);
    }

    /* renamed from: c */
    public Collection<C6465l> mo5443c() {
        return ((C6457b) ((C6462i) mo6413a())).mo5443c();
    }

    /* renamed from: d */
    public boolean mo5445d() {
        return ((C6457b) ((C6462i) mo6413a())).mo5445d();
    }

    /* renamed from: b */
    public C6460e mo5441b() {
        return ((C6462i) mo6413a()).mo5441b();
    }

    /* renamed from: b */
    public void mo5442b(boolean z) {
        ((C6465l) ((C6462i) mo6413a())).mo5442b(z);
    }

    /* renamed from: f */
    public boolean mo5446f() {
        return ((C6465l) ((C6462i) mo6413a())).mo5446f();
    }

    /* renamed from: a */
    public void mo5440a(Throwable th) {
        ((C6465l) ((C6462i) mo6413a())).mo5440a(th);
    }

    /* renamed from: a */
    public <T extends C6457b<C6465l> & C6462i & C6465l> T mo6413a() {
        return (C6457b) this.f26313b;
    }

    /* renamed from: a */
    protected <T extends C6457b<C6465l> & C6462i & C6465l> T m34357a(Object obj) {
        if (C7613j.m34366a(obj)) {
            return (C6457b) obj;
        }
        return new C7613j();
    }
}
