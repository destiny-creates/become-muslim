package android.arch.lifecycle;

import android.arch.lifecycle.C0074c.C0072a;
import android.arch.lifecycle.C0074c.C0073b;
import android.arch.p010a.p011a.C3102a;
import android.arch.p010a.p012b.C0064b;
import java.util.Iterator;
import java.util.Map.Entry;

public abstract class LiveData<T> {
    /* renamed from: b */
    private static final Object f183b = new Object();
    /* renamed from: a */
    private final Object f184a = new Object();
    /* renamed from: c */
    private C0064b<C0081k<T>, C0067a> f185c = new C0064b();
    /* renamed from: d */
    private int f186d = 0;
    /* renamed from: e */
    private volatile Object f187e = f183b;
    /* renamed from: f */
    private volatile Object f188f = f183b;
    /* renamed from: g */
    private int f189g = -1;
    /* renamed from: h */
    private boolean f190h;
    /* renamed from: i */
    private boolean f191i;
    /* renamed from: j */
    private final Runnable f192j = new C00661(this);

    /* renamed from: android.arch.lifecycle.LiveData$1 */
    class C00661 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ LiveData f178a;

        C00661(LiveData liveData) {
            this.f178a = liveData;
        }

        public void run() {
            Object b;
            synchronized (this.f178a.f184a) {
                b = this.f178a.f188f;
                this.f178a.f188f = LiveData.f183b;
            }
            this.f178a.mo26b(b);
        }
    }

    /* renamed from: android.arch.lifecycle.LiveData$a */
    private abstract class C0067a {
        /* renamed from: c */
        final C0081k<T> f179c;
        /* renamed from: d */
        boolean f180d;
        /* renamed from: e */
        int f181e = -1;
        /* renamed from: f */
        final /* synthetic */ LiveData f182f;

        /* renamed from: a */
        abstract boolean mo2621a();

        /* renamed from: a */
        boolean mo2622a(C0076e c0076e) {
            return false;
        }

        /* renamed from: b */
        void mo2623b() {
        }

        C0067a(LiveData liveData, C0081k<T> c0081k) {
            this.f182f = liveData;
            this.f179c = c0081k;
        }

        /* renamed from: a */
        void m147a(boolean z) {
            if (z != this.f180d) {
                this.f180d = z;
                int i = 1;
                z = !this.f182f.f186d;
                LiveData liveData = this.f182f;
                int c = liveData.f186d;
                if (!this.f180d) {
                    i = -1;
                }
                liveData.f186d = c + i;
                if (z && this.f180d) {
                    this.f182f.mo2658b();
                }
                if (!(this.f182f.f186d || this.f180d)) {
                    this.f182f.mo2659c();
                }
                if (this.f180d) {
                    this.f182f.m158b(this);
                }
            }
        }
    }

    class LifecycleBoundObserver extends C0067a implements GenericLifecycleObserver {
        /* renamed from: a */
        final C0076e f11813a;
        /* renamed from: b */
        final /* synthetic */ LiveData f11814b;

        LifecycleBoundObserver(LiveData liveData, C0076e c0076e, C0081k<T> c0081k) {
            this.f11814b = liveData;
            super(liveData, c0081k);
            this.f11813a = c0076e;
        }

        /* renamed from: a */
        boolean mo2621a() {
            return this.f11813a.getLifecycle().mo22a().m178a(C0073b.STARTED);
        }

        /* renamed from: a */
        public void mo2620a(C0076e c0076e, C0072a c0072a) {
            if (this.f11813a.getLifecycle().mo22a() == C0073b.DESTROYED) {
                this.f11814b.mo2656a(this.c);
            } else {
                m147a((boolean) mo2621a());
            }
        }

        /* renamed from: a */
        boolean mo2622a(C0076e c0076e) {
            return this.f11813a == c0076e ? true : null;
        }

        /* renamed from: b */
        void mo2623b() {
            this.f11813a.getLifecycle().mo24b(this);
        }
    }

    /* renamed from: b */
    protected void mo2658b() {
    }

    /* renamed from: c */
    protected void mo2659c() {
    }

    /* renamed from: a */
    private void m154a(C0067a c0067a) {
        if (!c0067a.f180d) {
            return;
        }
        if (!c0067a.mo2621a()) {
            c0067a.m147a(false);
        } else if (c0067a.f181e < this.f189g) {
            c0067a.f181e = this.f189g;
            c0067a.f179c.mo174a(this.f187e);
        }
    }

    /* renamed from: b */
    private void m158b(C0067a c0067a) {
        if (this.f190h) {
            this.f191i = true;
            return;
        }
        this.f190h = true;
        do {
            this.f191i = false;
            if (c0067a == null) {
                Iterator c = this.f185c.m144c();
                while (c.hasNext()) {
                    m154a((C0067a) ((Entry) c.next()).getValue());
                    if (this.f191i) {
                        break;
                    }
                }
            }
            m154a((C0067a) c0067a);
            c0067a = null;
        } while (this.f191i);
        this.f190h = false;
    }

    /* renamed from: a */
    public void m162a(C0076e c0076e, C0081k<T> c0081k) {
        if (c0076e.getLifecycle().mo22a() != C0073b.DESTROYED) {
            C0075d lifecycleBoundObserver = new LifecycleBoundObserver(this, c0076e, c0081k);
            C0067a c0067a = (C0067a) this.f185c.mo19a(c0081k, lifecycleBoundObserver);
            if (c0067a != null) {
                if (!c0067a.mo2622a(c0076e)) {
                    throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
                }
            }
            if (c0067a == null) {
                c0076e.getLifecycle().mo23a(lifecycleBoundObserver);
            }
        }
    }

    /* renamed from: a */
    public void mo2656a(C0081k<T> c0081k) {
        m156a("removeObserver");
        C0067a c0067a = (C0067a) this.f185c.mo20b(c0081k);
        if (c0067a != null) {
            c0067a.mo2623b();
            c0067a.m147a(false);
        }
    }

    /* renamed from: a */
    protected void mo25a(T t) {
        synchronized (this.f184a) {
            Object obj = this.f188f == f183b ? 1 : null;
            this.f188f = t;
        }
        if (obj != null) {
            C3102a.m9096a().mo16b(this.f192j);
        }
    }

    /* renamed from: b */
    protected void mo26b(T t) {
        m156a("setValue");
        this.f189g++;
        this.f187e = t;
        m158b((C0067a) null);
    }

    /* renamed from: a */
    public T m161a() {
        T t = this.f187e;
        return t != f183b ? t : null;
    }

    /* renamed from: d */
    public boolean m168d() {
        return this.f186d > 0;
    }

    /* renamed from: a */
    private static void m156a(String str) {
        if (!C3102a.m9096a().mo17b()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot invoke ");
            stringBuilder.append(str);
            stringBuilder.append(" on a background");
            stringBuilder.append(" thread");
            throw new IllegalStateException(stringBuilder.toString());
        }
    }
}
