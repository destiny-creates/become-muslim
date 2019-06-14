package p289e.p292c.p295e.p296a;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: BaseLinkedAtomicQueue */
/* renamed from: e.c.e.a.b */
abstract class C5951b<E> extends AbstractQueue<E> {
    /* renamed from: a */
    private final AtomicReference<C5952c<E>> f19680a = new AtomicReference();
    /* renamed from: b */
    private final AtomicReference<C5952c<E>> f19681b = new AtomicReference();

    /* renamed from: a */
    protected final C5952c<E> m24876a() {
        return (C5952c) this.f19680a.get();
    }

    /* renamed from: b */
    protected final C5952c<E> m24878b() {
        return (C5952c) this.f19680a.get();
    }

    /* renamed from: a */
    protected final void m24877a(C5952c<E> c5952c) {
        this.f19680a.lazySet(c5952c);
    }

    /* renamed from: c */
    protected final C5952c<E> m24880c() {
        return (C5952c) this.f19681b.get();
    }

    /* renamed from: d */
    protected final C5952c<E> m24881d() {
        return (C5952c) this.f19681b.get();
    }

    /* renamed from: b */
    protected final void m24879b(C5952c<E> c5952c) {
        this.f19681b.lazySet(c5952c);
    }

    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    public final int size() {
        C5952c c = m24880c();
        C5952c a = m24876a();
        int i = 0;
        while (c != a && i < Integer.MAX_VALUE) {
            C5952c c2;
            while (true) {
                c2 = c.m24886c();
                if (c2 != null) {
                    break;
                }
            }
            i++;
            c = c2;
        }
        return i;
    }

    public final boolean isEmpty() {
        return m24880c() == m24876a();
    }
}
