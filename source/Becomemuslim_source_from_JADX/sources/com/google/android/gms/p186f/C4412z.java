package com.google.android.gms.p186f;

import com.google.android.gms.common.internal.C2872v;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.f.z */
final class C4412z<TResult> extends C2954g<TResult> {
    /* renamed from: a */
    private final Object f11777a = new Object();
    /* renamed from: b */
    private final C2966x<TResult> f11778b = new C2966x();
    /* renamed from: c */
    private boolean f11779c;
    /* renamed from: d */
    private volatile boolean f11780d;
    /* renamed from: e */
    private TResult f11781e;
    /* renamed from: f */
    private Exception f11782f;

    C4412z() {
    }

    /* renamed from: a */
    public final boolean mo2587a() {
        boolean z;
        synchronized (this.f11777a) {
            z = this.f11779c;
        }
        return z;
    }

    /* renamed from: c */
    public final boolean mo2590c() {
        return this.f11780d;
    }

    /* renamed from: b */
    public final boolean mo2589b() {
        boolean z;
        synchronized (this.f11777a) {
            z = this.f11779c && !this.f11780d && this.f11782f == null;
        }
        return z;
    }

    /* renamed from: d */
    public final TResult mo2591d() {
        TResult tResult;
        synchronized (this.f11777a) {
            m14659g();
            m14661i();
            if (this.f11782f == null) {
                tResult = this.f11781e;
            } else {
                throw new C2953f(this.f11782f);
            }
        }
        return tResult;
    }

    /* renamed from: a */
    public final <X extends Throwable> TResult mo2586a(Class<X> cls) {
        synchronized (this.f11777a) {
            m14659g();
            m14661i();
            if (cls.isInstance(this.f11782f)) {
                throw ((Throwable) cls.cast(this.f11782f));
            } else if (this.f11782f == null) {
                cls = this.f11781e;
            } else {
                throw new C2953f(this.f11782f);
            }
        }
        return cls;
    }

    /* renamed from: e */
    public final Exception mo2592e() {
        Exception exception;
        synchronized (this.f11777a) {
            exception = this.f11782f;
        }
        return exception;
    }

    /* renamed from: a */
    public final C2954g<TResult> mo2580a(C2952e<? super TResult> c2952e) {
        return mo2585a(C2957i.f7593a, (C2952e) c2952e);
    }

    /* renamed from: a */
    public final C2954g<TResult> mo2585a(Executor executor, C2952e<? super TResult> c2952e) {
        this.f11778b.m8797a(new C4411u(executor, c2952e));
        m14662j();
        return this;
    }

    /* renamed from: a */
    public final C2954g<TResult> mo2579a(C2951d c2951d) {
        return mo2584a(C2957i.f7593a, c2951d);
    }

    /* renamed from: a */
    public final C2954g<TResult> mo2584a(Executor executor, C2951d c2951d) {
        this.f11778b.m8797a(new C4410s(executor, c2951d));
        m14662j();
        return this;
    }

    /* renamed from: a */
    public final C2954g<TResult> mo2578a(C2950c<TResult> c2950c) {
        return mo2583a(C2957i.f7593a, (C2950c) c2950c);
    }

    /* renamed from: a */
    public final C2954g<TResult> mo2583a(Executor executor, C2950c<TResult> c2950c) {
        this.f11778b.m8797a(new C4409q(executor, c2950c));
        m14662j();
        return this;
    }

    /* renamed from: a */
    public final <TContinuationResult> C2954g<TContinuationResult> mo2581a(Executor executor, C2948a<TResult, TContinuationResult> c2948a) {
        C2954g c4412z = new C4412z();
        this.f11778b.m8797a(new C4406k(executor, c2948a, c4412z));
        m14662j();
        return c4412z;
    }

    /* renamed from: a */
    public final C2954g<TResult> mo2582a(Executor executor, C2949b c2949b) {
        this.f11778b.m8797a(new C4408o(executor, c2949b));
        m14662j();
        return this;
    }

    /* renamed from: b */
    public final <TContinuationResult> C2954g<TContinuationResult> mo2588b(Executor executor, C2948a<TResult, C2954g<TContinuationResult>> c2948a) {
        C2954g c4412z = new C4412z();
        this.f11778b.m8797a(new C4407m(executor, c2948a, c4412z));
        m14662j();
        return c4412z;
    }

    /* renamed from: a */
    public final void m14673a(TResult tResult) {
        synchronized (this.f11777a) {
            m14660h();
            this.f11779c = true;
            this.f11781e = tResult;
        }
        this.f11778b.m8796a((C2954g) this);
    }

    /* renamed from: b */
    public final boolean m14678b(TResult tResult) {
        synchronized (this.f11777a) {
            if (this.f11779c) {
                return null;
            }
            this.f11779c = true;
            this.f11781e = tResult;
            this.f11778b.m8796a((C2954g) this);
            return true;
        }
    }

    /* renamed from: a */
    public final void m14672a(Exception exception) {
        C2872v.m8381a((Object) exception, (Object) "Exception must not be null");
        synchronized (this.f11777a) {
            m14660h();
            this.f11779c = true;
            this.f11782f = exception;
        }
        this.f11778b.m8796a((C2954g) this);
    }

    /* renamed from: b */
    public final boolean m14677b(Exception exception) {
        C2872v.m8381a((Object) exception, (Object) "Exception must not be null");
        synchronized (this.f11777a) {
            if (this.f11779c) {
                return null;
            }
            this.f11779c = true;
            this.f11782f = exception;
            this.f11778b.m8796a((C2954g) this);
            return true;
        }
    }

    /* renamed from: f */
    public final boolean m14682f() {
        synchronized (this.f11777a) {
            if (this.f11779c) {
                return false;
            }
            this.f11779c = true;
            this.f11780d = true;
            this.f11778b.m8796a((C2954g) this);
            return true;
        }
    }

    /* renamed from: g */
    private final void m14659g() {
        C2872v.m8387a(this.f11779c, (Object) "Task is not yet complete");
    }

    /* renamed from: h */
    private final void m14660h() {
        C2872v.m8387a(this.f11779c ^ 1, (Object) "Task is already complete");
    }

    /* renamed from: i */
    private final void m14661i() {
        if (this.f11780d) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    /* renamed from: j */
    private final void m14662j() {
        synchronized (this.f11777a) {
            if (this.f11779c) {
                this.f11778b.m8796a((C2954g) this);
                return;
            }
        }
    }
}
