package p289e.p292c.p295e.p296a;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: SpscAtomicArrayQueue */
/* renamed from: e.c.e.a.d */
public final class C7309d<E> extends C5950a<E> {
    /* renamed from: g */
    private static final Integer f25698g = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    /* renamed from: c */
    final AtomicLong f25699c = new AtomicLong();
    /* renamed from: d */
    long f25700d;
    /* renamed from: e */
    final AtomicLong f25701e = new AtomicLong();
    /* renamed from: f */
    final int f25702f;

    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    public C7309d(int i) {
        super(i);
        this.f25702f = Math.min(i / 4, f25698g.intValue());
    }

    public boolean offer(E e) {
        if (e != null) {
            AtomicReferenceArray atomicReferenceArray = this.a;
            int i = this.b;
            long j = this.f25699c.get();
            int a = m24872a(j, i);
            if (j >= this.f25700d) {
                long j2 = ((long) this.f25702f) + j;
                if (m24874a(atomicReferenceArray, m24872a(j2, i)) == null) {
                    this.f25700d = j2;
                } else if (m24874a(atomicReferenceArray, a) != null) {
                    return null;
                }
            }
            m24875a(atomicReferenceArray, a, e);
            m33644b(j + 1);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    public E poll() {
        long j = this.f25701e.get();
        int a = m24871a(j);
        AtomicReferenceArray atomicReferenceArray = this.a;
        E a2 = m24874a(atomicReferenceArray, a);
        if (a2 == null) {
            return null;
        }
        m24875a(atomicReferenceArray, a, null);
        m33645c(j + 1);
        return a2;
    }

    public E peek() {
        return m24873a(m24871a(this.f25701e.get()));
    }

    public int size() {
        long a = m33642a();
        while (true) {
            long b = m33643b();
            long a2 = m33642a();
            if (a == a2) {
                return (int) (b - a2);
            }
            a = a2;
        }
    }

    public boolean isEmpty() {
        return m33643b() == m33642a();
    }

    /* renamed from: b */
    private void m33644b(long j) {
        this.f25699c.lazySet(j);
    }

    /* renamed from: c */
    private void m33645c(long j) {
        this.f25701e.lazySet(j);
    }

    /* renamed from: a */
    private long m33642a() {
        return this.f25701e.get();
    }

    /* renamed from: b */
    private long m33643b() {
        return this.f25699c.get();
    }
}
