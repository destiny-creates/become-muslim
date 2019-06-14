package p289e.p292c.p295e.p297b;

import p289e.p292c.p295e.p296a.C5952c;

/* compiled from: BaseLinkedQueue */
/* renamed from: e.c.e.b.e */
abstract class C7312e<E> extends C5956c<E> {
    /* renamed from: b */
    protected static final long f25710b = ae.m24922a(C7312e.class, "producerNode");
    protected C5952c<E> producerNode;

    C7312e() {
    }

    /* renamed from: b */
    protected final void m33649b(C5952c<E> c5952c) {
        this.producerNode = c5952c;
    }

    /* renamed from: b */
    protected final C5952c<E> m33648b() {
        return (C5952c) ae.f19707a.getObjectVolatile(this, f25710b);
    }
}
