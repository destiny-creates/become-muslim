package host.exp.exponent.p339f.p340a.p342b;

import host.exp.exponent.p339f.C6330b;

/* compiled from: SensorKernelServiceSubscription */
/* renamed from: host.exp.exponent.f.a.b.j */
public class C6326j {
    /* renamed from: a */
    private boolean f20543a = false;
    /* renamed from: b */
    private Long f20544b = null;
    /* renamed from: c */
    private final C6330b f20545c;
    /* renamed from: d */
    private boolean f20546d = false;
    /* renamed from: e */
    private final C8176k f20547e;
    /* renamed from: f */
    private final C6325i f20548f;

    C6326j(C6330b c6330b, C8176k c8176k, C6325i c6325i) {
        this.f20545c = c6330b;
        this.f20548f = c6325i;
        this.f20547e = c8176k;
    }

    /* renamed from: a */
    public void m26016a() {
        m26015h();
        if (!this.f20543a) {
            this.f20543a = true;
            this.f20547e.m39714b(this);
        }
    }

    /* renamed from: b */
    public boolean m26018b() {
        return !this.f20546d && this.f20543a;
    }

    /* renamed from: c */
    public C6330b m26019c() {
        return this.f20545c;
    }

    /* renamed from: d */
    public Long m26020d() {
        return this.f20544b;
    }

    /* renamed from: e */
    C6325i m26021e() {
        return this.f20548f;
    }

    /* renamed from: a */
    public void m26017a(long j) {
        m26015h();
        this.f20544b = Long.valueOf(j);
    }

    /* renamed from: f */
    public void m26022f() {
        m26015h();
        if (this.f20543a) {
            this.f20543a = false;
            this.f20547e.m39714b(this);
        }
    }

    /* renamed from: g */
    public void m26023g() {
        m26015h();
        this.f20547e.m39712a(this);
        this.f20546d = true;
    }

    /* renamed from: h */
    private void m26015h() {
        if (this.f20546d) {
            throw new IllegalStateException("Subscription has been released, cannot call methods on a released subscription.");
        }
    }
}
