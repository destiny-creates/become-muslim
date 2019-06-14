package p289e.p292c.p295e.p297b;

import p289e.p292c.p295e.p296a.C5952c;

/* compiled from: SpscLinkedQueue */
/* renamed from: e.c.e.b.x */
public final class C8353x<E> extends C8345a<E> {
    public C8353x() {
        m33649b(new C5952c());
        m42866a(this.producerNode);
        this.consumerNode.m24883a(null);
    }

    public boolean offer(E e) {
        if (e != null) {
            C5952c c5952c = new C5952c(e);
            this.producerNode.m24883a(c5952c);
            this.producerNode = c5952c;
            return true;
        }
        throw new NullPointerException("null elements not allowed");
    }

    public E poll() {
        C5952c c = this.consumerNode.m24886c();
        if (c == null) {
            return null;
        }
        E a = c.m24882a();
        this.consumerNode = c;
        return a;
    }

    public E peek() {
        C5952c c = this.consumerNode.m24886c();
        return c != null ? c.m24885b() : null;
    }
}
