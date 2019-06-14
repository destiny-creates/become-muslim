package p289e.p292c.p295e.p297b;

/* compiled from: SpmcArrayQueue */
/* renamed from: e.c.e.b.i */
public final class C8365i<E> extends C8363m<E> {
    public C8365i(int i) {
        super(i);
    }

    public boolean offer(E e) {
        if (e != null) {
            Object[] objArr = this.c;
            long j = this.b;
            long b = m42867b();
            long a = m33650a(b);
            if (m33655b(objArr, a) != null) {
                if (b - m44430a() > j) {
                    return null;
                }
                while (m33655b(objArr, a) != null) {
                }
            }
            m33653a(objArr, a, e);
            m42868c(b + 1);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    public E poll() {
        long a;
        long c = m44552c();
        do {
            a = m44430a();
            if (a >= c) {
                long b = m42867b();
                if (a >= b) {
                    return null;
                }
                m44553d(b);
            }
        } while (!m44431b(a, 1 + a));
        c = m33650a(a);
        Object[] objArr = this.c;
        E a2 = m33652a(objArr, c);
        m33656b(objArr, c, null);
        return a2;
    }

    public E peek() {
        E b;
        long c = m44552c();
        do {
            long a = m44430a();
            if (a >= c) {
                long b2 = m42867b();
                if (a >= b2) {
                    return null;
                }
                m44553d(b2);
            }
            b = m33654b(m33650a(a));
        } while (b == null);
        return b;
    }

    public int size() {
        long a = m44430a();
        while (true) {
            long b = m42867b();
            long a2 = m44430a();
            if (a == a2) {
                return (int) (b - a2);
            }
            a = a2;
        }
    }

    public boolean isEmpty() {
        return m44430a() == m42867b();
    }
}
