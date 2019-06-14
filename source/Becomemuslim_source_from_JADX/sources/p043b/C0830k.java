package p043b;

/* compiled from: TaskCompletionSource */
/* renamed from: b.k */
public class C0830k<TResult> {
    /* renamed from: a */
    private final C0829j<TResult> f2317a = new C0829j();

    /* renamed from: a */
    public C0829j<TResult> m3004a() {
        return this.f2317a;
    }

    /* renamed from: b */
    public boolean m3009b() {
        return this.f2317a.m3003i();
    }

    /* renamed from: a */
    public boolean m3006a(TResult tResult) {
        return this.f2317a.m2995b((Object) tResult);
    }

    /* renamed from: a */
    public boolean m3005a(Exception exception) {
        return this.f2317a.m2994b(exception);
    }

    /* renamed from: c */
    public void m3010c() {
        if (!m3009b()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }

    /* renamed from: b */
    public void m3008b(TResult tResult) {
        if (m3006a((Object) tResult) == null) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }

    /* renamed from: b */
    public void m3007b(Exception exception) {
        if (m3005a(exception) == null) {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }
}
