package p289e.p292c.p295e.p296a;

/* compiled from: SpscLinkedAtomicQueue */
/* renamed from: e.c.e.a.g */
public final class C7310g<E> extends C5951b<E> {
    public C7310g() {
        C5952c c5952c = new C5952c();
        m24877a(c5952c);
        m24879b(c5952c);
        c5952c.m24883a(null);
    }

    public boolean offer(E e) {
        if (e != null) {
            C5952c c5952c = new C5952c(e);
            m24878b().m24883a(c5952c);
            m24877a(c5952c);
            return true;
        }
        throw new NullPointerException("null elements not allowed");
    }

    public E poll() {
        C5952c c = m24881d().m24886c();
        if (c == null) {
            return null;
        }
        E a = c.m24882a();
        m24879b(c);
        return a;
    }

    public E peek() {
        C5952c c = m24881d().m24886c();
        return c != null ? c.m24885b() : null;
    }
}
