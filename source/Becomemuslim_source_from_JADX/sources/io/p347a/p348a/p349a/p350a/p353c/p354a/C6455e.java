package io.p347a.p348a.p349a.p350a.p353c.p354a;

/* compiled from: RetryState */
/* renamed from: io.a.a.a.a.c.a.e */
public class C6455e {
    /* renamed from: a */
    private final int f20836a;
    /* renamed from: b */
    private final C6453a f20837b;
    /* renamed from: c */
    private final C6454d f20838c;

    public C6455e(C6453a c6453a, C6454d c6454d) {
        this(0, c6453a, c6454d);
    }

    public C6455e(int i, C6453a c6453a, C6454d c6454d) {
        this.f20836a = i;
        this.f20837b = c6453a;
        this.f20838c = c6454d;
    }

    /* renamed from: a */
    public long m26452a() {
        return this.f20837b.mo5439a(this.f20836a);
    }

    /* renamed from: b */
    public C6455e m26453b() {
        return new C6455e(this.f20836a + 1, this.f20837b, this.f20838c);
    }

    /* renamed from: c */
    public C6455e m26454c() {
        return new C6455e(this.f20837b, this.f20838c);
    }
}
