package expolib_v1.p321a.p322a;

/* compiled from: NamedRunnable */
/* renamed from: expolib_v1.a.a.b */
public abstract class C6155b implements Runnable {
    /* renamed from: b */
    protected final String f19897b;

    /* renamed from: c */
    protected abstract void mo5268c();

    public C6155b(String str, Object... objArr) {
        this.f19897b = C6165c.m25308a(str, objArr);
    }

    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f19897b);
        try {
            mo5268c();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
