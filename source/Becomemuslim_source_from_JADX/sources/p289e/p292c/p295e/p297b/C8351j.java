package p289e.p292c.p295e.p297b;

/* compiled from: SpmcArrayQueue */
/* renamed from: e.c.e.b.j */
abstract class C8351j<E> extends C8346l<E> {
    /* renamed from: d */
    protected static final long f32885d = ae.m24922a(C8351j.class, "consumerIndex");
    private volatile long consumerIndex;

    public C8351j(int i) {
        super(i);
    }

    /* renamed from: a */
    protected final long m44430a() {
        return this.consumerIndex;
    }

    /* renamed from: b */
    protected final boolean m44431b(long j, long j2) {
        return ae.f19707a.compareAndSwapLong(this, f32885d, j, j2);
    }
}
