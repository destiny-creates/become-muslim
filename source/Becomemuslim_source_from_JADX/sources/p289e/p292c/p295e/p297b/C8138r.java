package p289e.p292c.p295e.p297b;

/* compiled from: SpscArrayQueue */
/* renamed from: e.c.e.b.r */
abstract class C8138r<E> extends C7313f<E> {
    /* renamed from: e */
    private static final Integer f30291e = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    /* renamed from: d */
    protected final int f30292d;

    public C8138r(int i) {
        super(i);
        this.f30292d = Math.min(i / 4, f30291e.intValue());
    }
}
