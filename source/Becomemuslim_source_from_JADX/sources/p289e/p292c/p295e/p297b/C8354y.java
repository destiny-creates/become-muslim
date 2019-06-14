package p289e.p292c.p295e.p297b;

import java.util.Iterator;

/* compiled from: SpscUnboundedArrayQueue */
/* renamed from: e.c.e.b.y */
public class C8354y<E> extends aa<E> {
    /* renamed from: a */
    static final int f32886a = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    /* renamed from: h */
    private static final long f32887h;
    /* renamed from: i */
    private static final long f32888i;
    /* renamed from: j */
    private static final long f32889j = ((long) ae.f19707a.arrayBaseOffset(Object[].class));
    /* renamed from: k */
    private static final int f32890k;
    /* renamed from: l */
    private static final Object f32891l = new Object();

    static {
        InternalError internalError;
        int arrayIndexScale = ae.f19707a.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            f32890k = 2;
        } else if (8 == arrayIndexScale) {
            f32890k = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        try {
            f32887h = ae.f19707a.objectFieldOffset(ad.class.getDeclaredField("producerIndex"));
            try {
                f32888i = ae.f19707a.objectFieldOffset(aa.class.getDeclaredField("consumerIndex"));
            } catch (Throwable e) {
                internalError = new InternalError();
                internalError.initCause(e);
                throw internalError;
            }
        } catch (Throwable e2) {
            internalError = new InternalError();
            internalError.initCause(e2);
            throw internalError;
        }
    }

    public C8354y(int i) {
        i = C5958h.m24924a(i);
        long j = (long) (i - 1);
        Object[] objArr = new Object[(i + 1)];
        this.g = objArr;
        this.f = j;
        m44436a(i);
        this.c = objArr;
        this.b = j;
        this.e = j - 1;
        m44437a(0);
    }

    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    public final boolean offer(E e) {
        if (e != null) {
            Object[] objArr = this.g;
            long j = this.producerIndex;
            long j2 = this.f;
            long a = C8354y.m44433a(j, j2);
            if (j < this.e) {
                return m44441a(objArr, e, j, a);
            }
            long j3 = ((long) this.d) + j;
            if (C8354y.m44434a(objArr, C8354y.m44433a(j3, j2)) == null) {
                this.e = j3 - 1;
                return m44441a(objArr, e, j, a);
            } else if (C8354y.m44434a(objArr, C8354y.m44433a(1 + j, j2)) != null) {
                return m44441a(objArr, e, j, a);
            } else {
                m44438a(objArr, j, a, e, j2);
                return true;
            }
        }
        throw new NullPointerException("Null is not a valid element");
    }

    /* renamed from: a */
    private boolean m44441a(E[] eArr, E e, long j, long j2) {
        C8354y.m44439a((Object[]) eArr, j2, (Object) e);
        m44437a(j + 1);
        return 1;
    }

    /* renamed from: a */
    private void m44438a(E[] eArr, long j, long j2, E e, long j3) {
        Object[] objArr = new Object[eArr.length];
        this.g = objArr;
        this.e = (j3 + j) - 1;
        C8354y.m44439a(objArr, j2, (Object) e);
        m44440a((Object[]) eArr, objArr);
        C8354y.m44439a((Object[]) eArr, j2, f32891l);
        m44437a(j + 1);
    }

    /* renamed from: a */
    private void m44440a(E[] eArr, E[] eArr2) {
        C8354y.m44439a((Object[]) eArr, C8354y.m44446c((long) (eArr.length - 1)), (Object) eArr2);
    }

    /* renamed from: a */
    private E[] m44442a(E[] eArr) {
        return (Object[]) C8354y.m44434a((Object[]) eArr, C8354y.m44446c((long) (eArr.length - 1)));
    }

    public final E poll() {
        Object[] objArr = this.c;
        long j = this.consumerIndex;
        long j2 = this.b;
        long a = C8354y.m44433a(j, j2);
        E a2 = C8354y.m44434a(objArr, a);
        Object obj = a2 == f32891l ? 1 : null;
        if (a2 != null && obj == null) {
            C8354y.m44439a(objArr, a, null);
            m44445b(j + 1);
            return a2;
        } else if (obj != null) {
            return m44435a(m44442a(objArr), j, j2);
        } else {
            return null;
        }
    }

    /* renamed from: a */
    private E m44435a(E[] eArr, long j, long j2) {
        this.c = eArr;
        j2 = C8354y.m44433a(j, j2);
        E a = C8354y.m44434a((Object[]) eArr, j2);
        if (a == null) {
            return null;
        }
        C8354y.m44439a((Object[]) eArr, j2, null);
        m44445b(j + 1);
        return a;
    }

    public final E peek() {
        Object[] objArr = this.c;
        long j = this.consumerIndex;
        long j2 = this.b;
        E a = C8354y.m44434a(objArr, C8354y.m44433a(j, j2));
        return a == f32891l ? m44444b(m44442a(objArr), j, j2) : a;
    }

    /* renamed from: b */
    private E m44444b(E[] eArr, long j, long j2) {
        this.c = eArr;
        return C8354y.m44434a((Object[]) eArr, C8354y.m44433a(j, j2));
    }

    public final int size() {
        long b = m44443b();
        while (true) {
            long a = m44432a();
            long b2 = m44443b();
            if (b == b2) {
                return (int) (a - b2);
            }
            b = b2;
        }
    }

    /* renamed from: a */
    private void m44436a(int i) {
        this.d = Math.min(i / 4, f32886a);
    }

    /* renamed from: a */
    private long m44432a() {
        return ae.f19707a.getLongVolatile(this, f32887h);
    }

    /* renamed from: b */
    private long m44443b() {
        return ae.f19707a.getLongVolatile(this, f32888i);
    }

    /* renamed from: a */
    private void m44437a(long j) {
        ae.f19707a.putOrderedLong(this, f32887h, j);
    }

    /* renamed from: b */
    private void m44445b(long j) {
        ae.f19707a.putOrderedLong(this, f32888i, j);
    }

    /* renamed from: a */
    private static long m44433a(long j, long j2) {
        return C8354y.m44446c(j & j2);
    }

    /* renamed from: c */
    private static long m44446c(long j) {
        return f32889j + (j << f32890k);
    }

    /* renamed from: a */
    private static void m44439a(Object[] objArr, long j, Object obj) {
        ae.f19707a.putOrderedObject(objArr, j, obj);
    }

    /* renamed from: a */
    private static <E> Object m44434a(E[] eArr, long j) {
        return ae.f19707a.getObjectVolatile(eArr, j);
    }
}
