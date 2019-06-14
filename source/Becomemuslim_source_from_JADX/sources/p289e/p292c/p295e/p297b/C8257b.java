package p289e.p292c.p295e.p297b;

import p289e.p292c.p295e.p296a.C5952c;

/* compiled from: BaseLinkedQueue */
/* renamed from: e.c.e.b.b */
abstract class C8257b<E> extends C8136d<E> {
    /* renamed from: a */
    protected static final long f32447a = ae.m24922a(C8257b.class, "consumerNode");
    protected C5952c<E> consumerNode;

    C8257b() {
    }

    /* renamed from: a */
    protected final void m42866a(C5952c<E> c5952c) {
        this.consumerNode = c5952c;
    }

    /* renamed from: a */
    protected final C5952c<E> m42865a() {
        return (C5952c) ae.f19707a.getObjectVolatile(this, f32447a);
    }
}
