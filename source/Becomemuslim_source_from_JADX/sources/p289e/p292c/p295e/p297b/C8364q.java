package p289e.p292c.p295e.p297b;

/* compiled from: SpscArrayQueue */
/* renamed from: e.c.e.b.q */
public final class C8364q<E> extends C8361v<E> {
    public C8364q(int i) {
        super(i);
    }

    public boolean offer(E e) {
        if (e != null) {
            Object[] objArr = this.c;
            long j = this.producerIndex;
            long a = m33650a(j);
            if (m33655b(objArr, a) != null) {
                return null;
            }
            m33656b(objArr, a, e);
            m44569c(j + 1);
            return true;
        }
        throw new NullPointerException("null elements not allowed");
    }

    public E poll() {
        long j = this.consumerIndex;
        long a = m33650a(j);
        Object[] objArr = this.c;
        E b = m33655b(objArr, a);
        if (b == null) {
            return null;
        }
        m33656b(objArr, a, null);
        m44570d(j + 1);
        return b;
    }

    public E peek() {
        return m33654b(m33650a(this.consumerIndex));
    }

    public int size() {
        long b = m44568b();
        while (true) {
            long a = m44567a();
            long b2 = m44568b();
            if (b == b2) {
                return (int) (a - b2);
            }
            b = b2;
        }
    }

    public boolean isEmpty() {
        return m44567a() == m44568b();
    }

    /* renamed from: c */
    private void m44569c(long j) {
        ae.f19707a.putOrderedLong(this, f, j);
    }

    /* renamed from: d */
    private void m44570d(long j) {
        ae.f19707a.putOrderedLong(this, e, j);
    }

    /* renamed from: a */
    private long m44567a() {
        return ae.f19707a.getLongVolatile(this, f);
    }

    /* renamed from: b */
    private long m44568b() {
        return ae.f19707a.getLongVolatile(this, e);
    }
}
