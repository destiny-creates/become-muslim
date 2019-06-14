package p289e.p292c.p295e.p296a;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: LinkedQueueNode */
/* renamed from: e.c.e.a.c */
public final class C5952c<E> extends AtomicReference<C5952c<E>> {
    private static final long serialVersionUID = 2404266111789071508L;
    /* renamed from: a */
    private E f19682a;

    public C5952c(E e) {
        m24884a((Object) e);
    }

    /* renamed from: a */
    public E m24882a() {
        E b = m24885b();
        m24884a(null);
        return b;
    }

    /* renamed from: b */
    public E m24885b() {
        return this.f19682a;
    }

    /* renamed from: a */
    public void m24884a(E e) {
        this.f19682a = e;
    }

    /* renamed from: a */
    public void m24883a(C5952c<E> c5952c) {
        lazySet(c5952c);
    }

    /* renamed from: c */
    public C5952c<E> m24886c() {
        return (C5952c) get();
    }
}
