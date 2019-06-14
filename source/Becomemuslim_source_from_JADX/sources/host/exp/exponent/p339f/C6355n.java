package host.exp.exponent.p339f;

/* compiled from: KernelProvider */
/* renamed from: host.exp.exponent.f.n */
public class C6355n {
    /* renamed from: a */
    private static C6354a f20616a = new C75611();
    /* renamed from: b */
    private static C6353m f20617b;

    /* compiled from: KernelProvider */
    /* renamed from: host.exp.exponent.f.n$a */
    public interface C6354a {
        /* renamed from: a */
        C6353m mo5382a();
    }

    /* compiled from: KernelProvider */
    /* renamed from: host.exp.exponent.f.n$1 */
    static class C75611 implements C6354a {
        C75611() {
        }

        /* renamed from: a */
        public C6353m mo5382a() {
            return C7549c.m34188a();
        }
    }

    /* renamed from: a */
    public static void m26074a(C6354a c6354a) {
        f20616a = c6354a;
    }

    /* renamed from: a */
    public static C6353m m26073a() {
        if (f20617b == null) {
            f20617b = f20616a.mo5382a();
        }
        return f20617b;
    }
}
