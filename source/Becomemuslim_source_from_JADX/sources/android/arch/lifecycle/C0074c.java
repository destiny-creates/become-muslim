package android.arch.lifecycle;

/* compiled from: Lifecycle */
/* renamed from: android.arch.lifecycle.c */
public abstract class C0074c {

    /* compiled from: Lifecycle */
    /* renamed from: android.arch.lifecycle.c$a */
    public enum C0072a {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY
    }

    /* compiled from: Lifecycle */
    /* renamed from: android.arch.lifecycle.c$b */
    public enum C0073b {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        /* renamed from: a */
        public boolean m178a(C0073b c0073b) {
            return compareTo(c0073b) >= null ? true : null;
        }
    }

    /* renamed from: a */
    public abstract C0073b mo22a();

    /* renamed from: a */
    public abstract void mo23a(C0075d c0075d);

    /* renamed from: b */
    public abstract void mo24b(C0075d c0075d);
}
