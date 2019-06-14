package android.arch.lifecycle;

import android.arch.lifecycle.C0074c.C0072a;
import android.arch.lifecycle.C0074c.C0073b;
import android.arch.p010a.p012b.C3104a;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: LifecycleRegistry */
/* renamed from: android.arch.lifecycle.f */
public class C3107f extends C0074c {
    /* renamed from: a */
    private C3104a<C0075d, C0078a> f7932a = new C3104a();
    /* renamed from: b */
    private C0073b f7933b;
    /* renamed from: c */
    private final WeakReference<C0076e> f7934c;
    /* renamed from: d */
    private int f7935d = 0;
    /* renamed from: e */
    private boolean f7936e = false;
    /* renamed from: f */
    private boolean f7937f = false;
    /* renamed from: g */
    private ArrayList<C0073b> f7938g = new ArrayList();

    /* compiled from: LifecycleRegistry */
    /* renamed from: android.arch.lifecycle.f$a */
    static class C0078a {
        /* renamed from: a */
        C0073b f208a;
        /* renamed from: b */
        GenericLifecycleObserver f209b;

        C0078a(C0075d c0075d, C0073b c0073b) {
            this.f209b = C0079h.m183a((Object) c0075d);
            this.f208a = c0073b;
        }

        /* renamed from: a */
        void m182a(C0076e c0076e, C0072a c0072a) {
            C0073b b = C3107f.m9122b(c0072a);
            this.f208a = C3107f.m9120a(this.f208a, b);
            this.f209b.mo2620a(c0076e, c0072a);
            this.f208a = b;
        }
    }

    public C3107f(C0076e c0076e) {
        this.f7934c = new WeakReference(c0076e);
        this.f7933b = C0073b.INITIALIZED;
    }

    /* renamed from: a */
    public void m9134a(C0073b c0073b) {
        m9123b(c0073b);
    }

    /* renamed from: a */
    public void m9133a(C0072a c0072a) {
        m9123b(C3107f.m9122b(c0072a));
    }

    /* renamed from: b */
    private void m9123b(C0073b c0073b) {
        if (this.f7933b != c0073b) {
            this.f7933b = c0073b;
            if (this.f7936e == null) {
                if (this.f7935d == null) {
                    this.f7936e = true;
                    m9130d();
                    this.f7936e = null;
                    return;
                }
            }
            this.f7937f = true;
        }
    }

    /* renamed from: b */
    private boolean m9125b() {
        boolean z = true;
        if (this.f7932a.m138a() == 0) {
            return true;
        }
        C0073b c0073b = ((C0078a) this.f7932a.m145d().getValue()).f208a;
        C0073b c0073b2 = ((C0078a) this.f7932a.m146e().getValue()).f208a;
        if (c0073b != c0073b2 || this.f7933b != c0073b2) {
            z = false;
        }
        return z;
    }

    /* renamed from: c */
    private C0073b m9126c(C0075d c0075d) {
        c0075d = this.f7932a.m9107d(c0075d);
        C0073b c0073b = null;
        c0075d = c0075d != null ? ((C0078a) c0075d.getValue()).f208a : null;
        if (!this.f7938g.isEmpty()) {
            c0073b = (C0073b) this.f7938g.get(this.f7938g.size() - 1);
        }
        return C3107f.m9120a(C3107f.m9120a(this.f7933b, c0075d), c0073b);
    }

    /* renamed from: a */
    public void mo23a(C0075d c0075d) {
        C0078a c0078a = new C0078a(c0075d, this.f7933b == C0073b.DESTROYED ? C0073b.DESTROYED : C0073b.INITIALIZED);
        if (((C0078a) this.f7932a.mo19a(c0075d, c0078a)) == null) {
            C0076e c0076e = (C0076e) this.f7934c.get();
            if (c0076e != null) {
                Object obj;
                Enum c;
                if (this.f7935d == 0) {
                    if (!this.f7936e) {
                        obj = null;
                        c = m9126c(c0075d);
                        this.f7935d++;
                        while (c0078a.f208a.compareTo(c) < 0 && this.f7932a.m9106c(c0075d)) {
                            m9128c(c0078a.f208a);
                            c0078a.m182a(c0076e, C3107f.m9131e(c0078a.f208a));
                            m9127c();
                            c = m9126c(c0075d);
                        }
                        if (obj == null) {
                            m9130d();
                        }
                        this.f7935d -= 1;
                    }
                }
                obj = 1;
                c = m9126c(c0075d);
                this.f7935d++;
                while (c0078a.f208a.compareTo(c) < 0) {
                    m9128c(c0078a.f208a);
                    c0078a.m182a(c0076e, C3107f.m9131e(c0078a.f208a));
                    m9127c();
                    c = m9126c(c0075d);
                }
                if (obj == null) {
                    m9130d();
                }
                this.f7935d -= 1;
            }
        }
    }

    /* renamed from: c */
    private void m9127c() {
        this.f7938g.remove(this.f7938g.size() - 1);
    }

    /* renamed from: c */
    private void m9128c(C0073b c0073b) {
        this.f7938g.add(c0073b);
    }

    /* renamed from: b */
    public void mo24b(C0075d c0075d) {
        this.f7932a.mo20b(c0075d);
    }

    /* renamed from: a */
    public C0073b mo22a() {
        return this.f7933b;
    }

    /* renamed from: b */
    static C0073b m9122b(C0072a c0072a) {
        switch (c0072a) {
            case ON_CREATE:
            case ON_STOP:
                return C0073b.CREATED;
            case ON_START:
            case ON_PAUSE:
                return C0073b.STARTED;
            case ON_RESUME:
                return C0073b.RESUMED;
            case ON_DESTROY:
                return C0073b.DESTROYED;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected event value ");
                stringBuilder.append(c0072a);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    /* renamed from: d */
    private static C0072a m9129d(C0073b c0073b) {
        switch (c0073b) {
            case INITIALIZED:
                throw new IllegalArgumentException();
            case CREATED:
                return C0072a.ON_DESTROY;
            case STARTED:
                return C0072a.ON_STOP;
            case RESUMED:
                return C0072a.ON_PAUSE;
            case DESTROYED:
                throw new IllegalArgumentException();
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected state value ");
                stringBuilder.append(c0073b);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    /* renamed from: e */
    private static C0072a m9131e(C0073b c0073b) {
        switch (c0073b) {
            case INITIALIZED:
            case DESTROYED:
                return C0072a.ON_CREATE;
            case CREATED:
                return C0072a.ON_START;
            case STARTED:
                return C0072a.ON_RESUME;
            case RESUMED:
                throw new IllegalArgumentException();
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected state value ");
                stringBuilder.append(c0073b);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    private void m9121a(C0076e c0076e) {
        Iterator c = this.f7932a.m144c();
        while (c.hasNext() && !this.f7937f) {
            Entry entry = (Entry) c.next();
            C0078a c0078a = (C0078a) entry.getValue();
            while (c0078a.f208a.compareTo(this.f7933b) < 0 && !this.f7937f && this.f7932a.m9106c(entry.getKey())) {
                m9128c(c0078a.f208a);
                c0078a.m182a(c0076e, C3107f.m9131e(c0078a.f208a));
                m9127c();
            }
        }
    }

    /* renamed from: b */
    private void m9124b(C0076e c0076e) {
        Iterator b = this.f7932a.m143b();
        while (b.hasNext() && !this.f7937f) {
            Entry entry = (Entry) b.next();
            C0078a c0078a = (C0078a) entry.getValue();
            while (c0078a.f208a.compareTo(this.f7933b) > 0 && !this.f7937f && this.f7932a.m9106c(entry.getKey())) {
                C0072a d = C3107f.m9129d(c0078a.f208a);
                m9128c(C3107f.m9122b(d));
                c0078a.m182a(c0076e, d);
                m9127c();
            }
        }
    }

    /* renamed from: d */
    private void m9130d() {
        C0076e c0076e = (C0076e) this.f7934c.get();
        if (c0076e == null) {
            Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
            return;
        }
        while (!m9125b()) {
            this.f7937f = false;
            if (this.f7933b.compareTo(((C0078a) this.f7932a.m145d().getValue()).f208a) < 0) {
                m9124b(c0076e);
            }
            Entry e = this.f7932a.m146e();
            if (!(this.f7937f || e == null || this.f7933b.compareTo(((C0078a) e.getValue()).f208a) <= 0)) {
                m9121a(c0076e);
            }
        }
        this.f7937f = false;
    }

    /* renamed from: a */
    static C0073b m9120a(C0073b c0073b, C0073b c0073b2) {
        return (c0073b2 == null || c0073b2.compareTo(c0073b) >= 0) ? c0073b : c0073b2;
    }
}
