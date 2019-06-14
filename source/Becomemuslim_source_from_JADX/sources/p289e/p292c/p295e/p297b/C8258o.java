package p289e.p292c.p295e.p297b;

/* compiled from: SpmcArrayQueue */
/* renamed from: e.c.e.b.o */
abstract class C8258o<E> extends C8137k<E> {
    /* renamed from: e */
    protected static final long f32448e = ae.m24922a(C8258o.class, "producerIndex");
    private volatile long producerIndex;

    /* renamed from: b */
    protected final long m42867b() {
        return this.producerIndex;
    }

    /* renamed from: c */
    protected final void m42868c(long j) {
        ae.f19707a.putOrderedLong(this, f32448e, j);
    }

    public C8258o(int i) {
        super(i);
    }
}
