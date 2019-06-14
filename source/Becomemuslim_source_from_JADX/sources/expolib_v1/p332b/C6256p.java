package expolib_v1.p332b;

/* compiled from: SegmentPool */
/* renamed from: expolib_v1.b.p */
final class C6256p {
    /* renamed from: a */
    static C6255o f20392a;
    /* renamed from: b */
    static long f20393b;

    private C6256p() {
    }

    /* renamed from: a */
    static C6255o m25877a() {
        synchronized (C6256p.class) {
            if (f20392a != null) {
                C6255o c6255o = f20392a;
                f20392a = c6255o.f20390f;
                c6255o.f20390f = null;
                f20393b -= 8192;
                return c6255o;
            }
            return new C6255o();
        }
    }

    /* renamed from: a */
    static void m25878a(C6255o c6255o) {
        if (c6255o.f20390f != null || c6255o.f20391g != null) {
            throw new IllegalArgumentException();
        } else if (!c6255o.f20388d) {
            synchronized (C6256p.class) {
                if (f20393b + 8192 > 65536) {
                    return;
                }
                f20393b += 8192;
                c6255o.f20390f = f20392a;
                c6255o.f20387c = 0;
                c6255o.f20386b = 0;
                f20392a = c6255o;
            }
        }
    }
}
