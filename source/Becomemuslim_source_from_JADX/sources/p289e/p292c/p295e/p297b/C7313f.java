package p289e.p292c.p295e.p297b;

import java.util.Iterator;

/* compiled from: ConcurrentCircularArrayQueue */
/* renamed from: e.c.e.b.f */
public abstract class C7313f<E> extends C5957g<E> {
    /* renamed from: a */
    protected static final int f25711a = Integer.getInteger("sparse.shift", 0).intValue();
    /* renamed from: d */
    private static final long f25712d = ((long) (ae.f19707a.arrayBaseOffset(Object[].class) + (32 << (f25713e - f25711a))));
    /* renamed from: e */
    private static final int f25713e;
    /* renamed from: b */
    protected final long f25714b;
    /* renamed from: c */
    protected final E[] f25715c;

    static {
        int arrayIndexScale = ae.f19707a.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            f25713e = f25711a + 2;
        } else if (8 == arrayIndexScale) {
            f25713e = f25711a + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
    }

    public C7313f(int i) {
        i = C5958h.m24924a(i);
        this.f25714b = (long) (i - 1);
        this.f25715c = (Object[]) new Object[((i << f25711a) + 64)];
    }

    /* renamed from: a */
    protected final long m33650a(long j) {
        return m33651a(j, this.f25714b);
    }

    /* renamed from: a */
    protected final long m33651a(long j, long j2) {
        return f25712d + ((j & j2) << f25713e);
    }

    /* renamed from: a */
    protected final void m33653a(E[] eArr, long j, E e) {
        ae.f19707a.putObject(eArr, j, e);
    }

    /* renamed from: b */
    protected final void m33656b(E[] eArr, long j, E e) {
        ae.f19707a.putOrderedObject(eArr, j, e);
    }

    /* renamed from: a */
    protected final E m33652a(E[] eArr, long j) {
        return ae.f19707a.getObject(eArr, j);
    }

    /* renamed from: b */
    protected final E m33654b(long j) {
        return m33655b(this.f25715c, j);
    }

    /* renamed from: b */
    protected final E m33655b(E[] eArr, long j) {
        return ae.f19707a.getObjectVolatile(eArr, j);
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
}
