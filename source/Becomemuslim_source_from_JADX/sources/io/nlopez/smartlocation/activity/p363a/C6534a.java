package io.nlopez.smartlocation.activity.p363a;

/* compiled from: ActivityParams */
/* renamed from: io.nlopez.smartlocation.activity.a.a */
public class C6534a {
    /* renamed from: a */
    public static final C6534a f21047a = new C6533a().m26703a(500).m26704a();
    /* renamed from: b */
    private long f21048b;

    /* compiled from: ActivityParams */
    /* renamed from: io.nlopez.smartlocation.activity.a.a$a */
    public static class C6533a {
        /* renamed from: a */
        private long f21046a;

        /* renamed from: a */
        public C6533a m26703a(long j) {
            this.f21046a = j;
            return this;
        }

        /* renamed from: a */
        public C6534a m26704a() {
            return new C6534a(this.f21046a);
        }
    }

    C6534a(long j) {
        this.f21048b = j;
    }

    /* renamed from: a */
    public long m26705a() {
        return this.f21048b;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C6534a)) {
            return false;
        }
        if (this.f21048b != ((C6534a) obj).f21048b) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (int) (this.f21048b ^ (this.f21048b >>> 32));
    }
}
