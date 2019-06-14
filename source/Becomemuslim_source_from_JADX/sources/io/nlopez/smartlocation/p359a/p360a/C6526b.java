package io.nlopez.smartlocation.p359a.p360a;

/* compiled from: LocationParams */
/* renamed from: io.nlopez.smartlocation.a.a.b */
public class C6526b {
    /* renamed from: a */
    public static final C6526b f21033a = new C6525a().m26684a(C6524a.HIGH).m26682a(0.0f).m26683a(500).m26685a();
    /* renamed from: b */
    public static final C6526b f21034b = new C6525a().m26684a(C6524a.MEDIUM).m26682a(150.0f).m26683a(2500).m26685a();
    /* renamed from: c */
    public static final C6526b f21035c = new C6525a().m26684a(C6524a.LOW).m26682a(500.0f).m26683a(5000).m26685a();
    /* renamed from: d */
    private long f21036d;
    /* renamed from: e */
    private float f21037e;
    /* renamed from: f */
    private C6524a f21038f;

    /* compiled from: LocationParams */
    /* renamed from: io.nlopez.smartlocation.a.a.b$a */
    public static class C6525a {
        /* renamed from: a */
        private C6524a f21030a;
        /* renamed from: b */
        private long f21031b;
        /* renamed from: c */
        private float f21032c;

        /* renamed from: a */
        public C6525a m26684a(C6524a c6524a) {
            this.f21030a = c6524a;
            return this;
        }

        /* renamed from: a */
        public C6525a m26683a(long j) {
            this.f21031b = j;
            return this;
        }

        /* renamed from: a */
        public C6525a m26682a(float f) {
            this.f21032c = f;
            return this;
        }

        /* renamed from: a */
        public C6526b m26685a() {
            return new C6526b(this.f21030a, this.f21031b, this.f21032c);
        }
    }

    C6526b(C6524a c6524a, long j, float f) {
        this.f21036d = j;
        this.f21037e = f;
        this.f21038f = c6524a;
    }

    /* renamed from: a */
    public long m26686a() {
        return this.f21036d;
    }

    /* renamed from: b */
    public float m26687b() {
        return this.f21037e;
    }

    /* renamed from: c */
    public C6524a m26688c() {
        return this.f21038f;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C6526b)) {
            return false;
        }
        C6526b c6526b = (C6526b) obj;
        if (Float.compare(c6526b.f21037e, this.f21037e) != 0 || this.f21036d != c6526b.f21036d || this.f21038f != c6526b.f21038f) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (((((int) (this.f21036d ^ (this.f21036d >>> 32))) * 31) + (this.f21037e != 0.0f ? Float.floatToIntBits(this.f21037e) : 0)) * 31) + this.f21038f.hashCode();
    }
}
