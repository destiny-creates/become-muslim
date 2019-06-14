package p289e.p292c.p295e.p296a;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p289e.p292c.p295e.p297b.C5958h;

/* compiled from: SpscLinkedArrayQueue */
/* renamed from: e.c.e.a.f */
public final class C5954f<T> implements Queue<T> {
    /* renamed from: a */
    static final int f19687a = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    /* renamed from: j */
    private static final Object f19688j = new Object();
    /* renamed from: b */
    final AtomicLong f19689b = new AtomicLong();
    /* renamed from: c */
    int f19690c;
    /* renamed from: d */
    long f19691d;
    /* renamed from: e */
    int f19692e;
    /* renamed from: f */
    AtomicReferenceArray<Object> f19693f;
    /* renamed from: g */
    int f19694g;
    /* renamed from: h */
    AtomicReferenceArray<Object> f19695h;
    /* renamed from: i */
    final AtomicLong f19696i = new AtomicLong();

    /* renamed from: b */
    private static int m24898b(int i) {
        return i;
    }

    public C5954f(int i) {
        i = C5958h.m24924a(i);
        int i2 = i - 1;
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(i + 1);
        this.f19693f = atomicReferenceArray;
        this.f19692e = i2;
        m24892a(i);
        this.f19695h = atomicReferenceArray;
        this.f19694g = i2;
        this.f19691d = (long) (i2 - 1);
    }

    public boolean offer(T t) {
        AtomicReferenceArray atomicReferenceArray = this.f19693f;
        long c = m24902c();
        int i = this.f19692e;
        int a = C5954f.m24887a(c, i);
        if (c < this.f19691d) {
            return m24897a(atomicReferenceArray, t, c, a);
        }
        long j = ((long) this.f19690c) + c;
        if (C5954f.m24889a(atomicReferenceArray, C5954f.m24887a(j, i)) == null) {
            this.f19691d = j - 1;
            return m24897a(atomicReferenceArray, t, c, a);
        } else if (C5954f.m24889a(atomicReferenceArray, C5954f.m24887a(1 + c, i)) == null) {
            return m24897a(atomicReferenceArray, t, c, a);
        } else {
            m24895a(atomicReferenceArray, c, a, t, (long) i);
            return true;
        }
    }

    /* renamed from: a */
    private boolean m24897a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        C5954f.m24894a((AtomicReferenceArray) atomicReferenceArray, i, (Object) t);
        m24893a(j + 1);
        return true;
    }

    /* renamed from: a */
    private void m24895a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i, T t, long j2) {
        AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(atomicReferenceArray.length());
        this.f19693f = atomicReferenceArray2;
        this.f19691d = (j2 + j) - 1;
        C5954f.m24894a(atomicReferenceArray2, i, (Object) t);
        m24896a((AtomicReferenceArray) atomicReferenceArray, atomicReferenceArray2);
        C5954f.m24894a((AtomicReferenceArray) atomicReferenceArray, i, f19688j);
        m24893a(j + 1);
    }

    /* renamed from: a */
    private void m24896a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        C5954f.m24894a((AtomicReferenceArray) atomicReferenceArray, C5954f.m24898b(atomicReferenceArray.length() - 1), (Object) atomicReferenceArray2);
    }

    /* renamed from: a */
    private AtomicReferenceArray<Object> m24891a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) C5954f.m24889a((AtomicReferenceArray) atomicReferenceArray, C5954f.m24898b(atomicReferenceArray.length() - 1));
    }

    public T poll() {
        AtomicReferenceArray atomicReferenceArray = this.f19695h;
        long d = m24903d();
        int i = this.f19694g;
        int a = C5954f.m24887a(d, i);
        T a2 = C5954f.m24889a(atomicReferenceArray, a);
        Object obj = a2 == f19688j ? 1 : null;
        if (a2 != null && obj == null) {
            C5954f.m24894a(atomicReferenceArray, a, null);
            m24901b(d + 1);
            return a2;
        } else if (obj != null) {
            return m24890a(m24891a(atomicReferenceArray), d, i);
        } else {
            return null;
        }
    }

    /* renamed from: a */
    private T m24890a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.f19695h = atomicReferenceArray;
        i = C5954f.m24887a(j, i);
        T a = C5954f.m24889a((AtomicReferenceArray) atomicReferenceArray, i);
        if (a == null) {
            return null;
        }
        C5954f.m24894a((AtomicReferenceArray) atomicReferenceArray, i, null);
        m24901b(j + 1);
        return a;
    }

    public T peek() {
        AtomicReferenceArray atomicReferenceArray = this.f19695h;
        long d = m24903d();
        int i = this.f19694g;
        T a = C5954f.m24889a(atomicReferenceArray, C5954f.m24887a(d, i));
        return a == f19688j ? m24900b(m24891a(atomicReferenceArray), d, i) : a;
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

    /* renamed from: b */
    private T m24900b(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.f19695h = atomicReferenceArray;
        return C5954f.m24889a((AtomicReferenceArray) atomicReferenceArray, C5954f.m24887a(j, i));
    }

    public int size() {
        long b = m24899b();
        while (true) {
            long a = m24888a();
            long b2 = m24899b();
            if (b == b2) {
                return (int) (a - b2);
            }
            b = b2;
        }
    }

    public boolean isEmpty() {
        return m24888a() == m24899b();
    }

    /* renamed from: a */
    private void m24892a(int i) {
        this.f19690c = Math.min(i / 4, f19687a);
    }

    /* renamed from: a */
    private long m24888a() {
        return this.f19689b.get();
    }

    /* renamed from: b */
    private long m24899b() {
        return this.f19696i.get();
    }

    /* renamed from: c */
    private long m24902c() {
        return this.f19689b.get();
    }

    /* renamed from: d */
    private long m24903d() {
        return this.f19696i.get();
    }

    /* renamed from: a */
    private void m24893a(long j) {
        this.f19689b.lazySet(j);
    }

    /* renamed from: b */
    private void m24901b(long j) {
        this.f19696i.lazySet(j);
    }

    /* renamed from: a */
    private static int m24887a(long j, int i) {
        return C5954f.m24898b(((int) j) & i);
    }

    /* renamed from: a */
    private static void m24894a(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    /* renamed from: a */
    private static <E> Object m24889a(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public boolean contains(Object obj) {
        throw new UnsupportedOperationException();
    }

    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    public <E> E[] toArray(E[] eArr) {
        throw new UnsupportedOperationException();
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean add(T t) {
        throw new UnsupportedOperationException();
    }

    public T remove() {
        throw new UnsupportedOperationException();
    }

    public T element() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public boolean m24904a(T t, T t2) {
        AtomicReferenceArray atomicReferenceArray = this.f19693f;
        long a = m24888a();
        int i = this.f19692e;
        long j = 2 + a;
        int a2;
        if (C5954f.m24889a(atomicReferenceArray, C5954f.m24887a(j, i)) == null) {
            a2 = C5954f.m24887a(a, i);
            C5954f.m24894a(atomicReferenceArray, a2 + 1, (Object) t2);
            C5954f.m24894a(atomicReferenceArray, a2, (Object) t);
            m24893a(j);
        } else {
            AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(atomicReferenceArray.length());
            this.f19693f = atomicReferenceArray2;
            a2 = C5954f.m24887a(a, i);
            C5954f.m24894a(atomicReferenceArray2, a2 + 1, (Object) t2);
            C5954f.m24894a(atomicReferenceArray2, a2, (Object) t);
            m24896a(atomicReferenceArray, atomicReferenceArray2);
            C5954f.m24894a(atomicReferenceArray, a2, f19688j);
            m24893a(j);
        }
        return true;
    }
}
