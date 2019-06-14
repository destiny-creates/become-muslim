package io.p347a.p348a.p349a.p350a.p353c.p354a;

/* compiled from: ExponentialBackoff */
/* renamed from: io.a.a.a.a.c.a.c */
public class C7610c implements C6453a {
    /* renamed from: a */
    private final long f26310a;
    /* renamed from: b */
    private final int f26311b;

    public C7610c(long j, int i) {
        this.f26310a = j;
        this.f26311b = i;
    }

    /* renamed from: a */
    public long mo5439a(int i) {
        return (long) (((double) this.f26310a) * Math.pow((double) this.f26311b, (double) i));
    }
}
