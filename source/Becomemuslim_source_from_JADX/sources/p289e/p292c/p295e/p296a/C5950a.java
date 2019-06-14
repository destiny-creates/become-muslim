package p289e.p292c.p295e.p296a;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p289e.p292c.p295e.p297b.C5958h;

/* compiled from: AtomicReferenceArrayQueue */
/* renamed from: e.c.e.a.a */
abstract class C5950a<E> extends AbstractQueue<E> {
    /* renamed from: a */
    protected final AtomicReferenceArray<E> f19678a;
    /* renamed from: b */
    protected final int f19679b;

    /* renamed from: a */
    protected final int m24872a(long j, int i) {
        return ((int) j) & i;
    }

    public C5950a(int i) {
        i = C5958h.m24924a(i);
        this.f19679b = i - 1;
        this.f19678a = new AtomicReferenceArray(i);
    }

    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        while (true) {
            if (poll() == null) {
                if (isEmpty()) {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    protected final int m24871a(long j) {
        return ((int) j) & this.f19679b;
    }

    /* renamed from: a */
    protected final E m24874a(AtomicReferenceArray<E> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    /* renamed from: a */
    protected final void m24875a(AtomicReferenceArray<E> atomicReferenceArray, int i, E e) {
        atomicReferenceArray.lazySet(i, e);
    }

    /* renamed from: a */
    protected final E m24873a(int i) {
        return m24874a(this.f19678a, i);
    }
}
