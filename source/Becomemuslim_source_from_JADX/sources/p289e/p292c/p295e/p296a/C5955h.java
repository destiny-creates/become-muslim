package p289e.p292c.p295e.p296a;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p289e.p292c.p295e.p297b.C5958h;

/* compiled from: SpscUnboundedAtomicArrayQueue */
/* renamed from: e.c.e.a.h */
public final class C5955h<T> implements Queue<T> {
    /* renamed from: a */
    static final int f19697a = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    /* renamed from: j */
    private static final Object f19698j = new Object();
    /* renamed from: b */
    final AtomicLong f19699b = new AtomicLong();
    /* renamed from: c */
    int f19700c;
    /* renamed from: d */
    long f19701d;
    /* renamed from: e */
    int f19702e;
    /* renamed from: f */
    AtomicReferenceArray<Object> f19703f;
    /* renamed from: g */
    int f19704g;
    /* renamed from: h */
    AtomicReferenceArray<Object> f19705h;
    /* renamed from: i */
    final AtomicLong f19706i = new AtomicLong();

    /* renamed from: b */
    private static int m24916b(int i) {
        return i;
    }

    public C5955h(int i) {
        i = C5958h.m24924a(Math.max(8, i));
        int i2 = i - 1;
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(i + 1);
        this.f19703f = atomicReferenceArray;
        this.f19702e = i2;
        m24910a(i);
        this.f19705h = atomicReferenceArray;
        this.f19704g = i2;
        this.f19701d = (long) (i2 - 1);
        m24911a(0);
    }

    public boolean offer(T t) {
        if (t != null) {
            AtomicReferenceArray atomicReferenceArray = this.f19703f;
            long c = m24920c();
            int i = this.f19702e;
            int a = C5955h.m24905a(c, i);
            if (c < this.f19701d) {
                return m24915a(atomicReferenceArray, t, c, a);
            }
            long j = ((long) this.f19700c) + c;
            if (C5955h.m24907a(atomicReferenceArray, C5955h.m24905a(j, i)) == null) {
                this.f19701d = j - 1;
                return m24915a(atomicReferenceArray, t, c, a);
            } else if (C5955h.m24907a(atomicReferenceArray, C5955h.m24905a(1 + c, i)) != null) {
                return m24915a(atomicReferenceArray, t, c, a);
            } else {
                m24913a(atomicReferenceArray, c, a, t, (long) i);
                return true;
            }
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    private boolean m24915a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        m24911a(j + 1);
        C5955h.m24912a((AtomicReferenceArray) atomicReferenceArray, i, (Object) t);
        return true;
    }

    /* renamed from: a */
    private void m24913a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i, T t, long j2) {
        AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(atomicReferenceArray.length());
        this.f19703f = atomicReferenceArray2;
        this.f19701d = (j2 + j) - 1;
        m24911a(j + 1);
        C5955h.m24912a(atomicReferenceArray2, i, (Object) t);
        m24914a((AtomicReferenceArray) atomicReferenceArray, atomicReferenceArray2);
        C5955h.m24912a((AtomicReferenceArray) atomicReferenceArray, i, f19698j);
    }

    /* renamed from: a */
    private void m24914a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        C5955h.m24912a((AtomicReferenceArray) atomicReferenceArray, C5955h.m24916b(atomicReferenceArray.length() - 1), (Object) atomicReferenceArray2);
    }

    /* renamed from: a */
    private AtomicReferenceArray<Object> m24909a(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) C5955h.m24907a((AtomicReferenceArray) atomicReferenceArray, C5955h.m24916b(atomicReferenceArray.length() - 1));
    }

    public T poll() {
        AtomicReferenceArray atomicReferenceArray = this.f19705h;
        long d = m24921d();
        int i = this.f19704g;
        int a = C5955h.m24905a(d, i);
        T a2 = C5955h.m24907a(atomicReferenceArray, a);
        Object obj = a2 == f19698j ? 1 : null;
        if (a2 != null && obj == null) {
            m24919b(d + 1);
            C5955h.m24912a(atomicReferenceArray, a, null);
            return a2;
        } else if (obj != null) {
            return m24908a(m24909a(atomicReferenceArray), d, i);
        } else {
            return null;
        }
    }

    /* renamed from: a */
    private T m24908a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.f19705h = atomicReferenceArray;
        i = C5955h.m24905a(j, i);
        T a = C5955h.m24907a((AtomicReferenceArray) atomicReferenceArray, i);
        if (a == null) {
            return null;
        }
        m24919b(j + 1);
        C5955h.m24912a((AtomicReferenceArray) atomicReferenceArray, i, null);
        return a;
    }

    public T peek() {
        AtomicReferenceArray atomicReferenceArray = this.f19705h;
        long d = m24921d();
        int i = this.f19704g;
        T a = C5955h.m24907a(atomicReferenceArray, C5955h.m24905a(d, i));
        return a == f19698j ? m24918b(m24909a(atomicReferenceArray), d, i) : a;
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
    private T m24918b(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.f19705h = atomicReferenceArray;
        return C5955h.m24907a((AtomicReferenceArray) atomicReferenceArray, C5955h.m24905a(j, i));
    }

    public int size() {
        long b = m24917b();
        while (true) {
            long a = m24906a();
            long b2 = m24917b();
            if (b == b2) {
                return (int) (a - b2);
            }
            b = b2;
        }
    }

    public boolean isEmpty() {
        return m24906a() == m24917b();
    }

    /* renamed from: a */
    private void m24910a(int i) {
        this.f19700c = Math.min(i / 4, f19697a);
    }

    /* renamed from: a */
    private long m24906a() {
        return this.f19699b.get();
    }

    /* renamed from: b */
    private long m24917b() {
        return this.f19706i.get();
    }

    /* renamed from: c */
    private long m24920c() {
        return this.f19699b.get();
    }

    /* renamed from: d */
    private long m24921d() {
        return this.f19706i.get();
    }

    /* renamed from: a */
    private void m24911a(long j) {
        this.f19699b.lazySet(j);
    }

    /* renamed from: b */
    private void m24919b(long j) {
        this.f19706i.lazySet(j);
    }

    /* renamed from: a */
    private static int m24905a(long j, int i) {
        return C5955h.m24916b(((int) j) & i);
    }

    /* renamed from: a */
    private static void m24912a(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    /* renamed from: a */
    private static <E> Object m24907a(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
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
}
