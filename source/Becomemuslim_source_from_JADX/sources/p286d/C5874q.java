package p286d;

/* compiled from: SegmentPool */
/* renamed from: d.q */
final class C5874q {
    /* renamed from: a */
    static C5873p f19546a;
    /* renamed from: b */
    static long f19547b;

    private C5874q() {
    }

    /* renamed from: a */
    static C5873p m24742a() {
        synchronized (C5874q.class) {
            if (f19546a != null) {
                C5873p c5873p = f19546a;
                f19546a = c5873p.f19544f;
                c5873p.f19544f = null;
                f19547b -= 8192;
                return c5873p;
            }
            return new C5873p();
        }
    }

    /* renamed from: a */
    static void m24743a(C5873p c5873p) {
        if (c5873p.f19544f != null || c5873p.f19545g != null) {
            throw new IllegalArgumentException();
        } else if (!c5873p.f19542d) {
            synchronized (C5874q.class) {
                if (f19547b + 8192 > 65536) {
                    return;
                }
                f19547b += 8192;
                c5873p.f19544f = f19546a;
                c5873p.f19541c = 0;
                c5873p.f19540b = 0;
                f19546a = c5873p;
            }
        }
    }
}
