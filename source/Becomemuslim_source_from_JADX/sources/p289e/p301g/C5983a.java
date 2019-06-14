package p289e.p301g;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import p289e.C5986h;
import p289e.p292c.p294c.C5948k;
import p289e.p292c.p294c.C7294c;
import p289e.p292c.p294c.C7305m;
import p289e.p300f.C5977c;
import p289e.p300f.C5979f;
import p289e.p300f.C5980g;

/* compiled from: Schedulers */
/* renamed from: e.g.a */
public final class C5983a {
    /* renamed from: d */
    private static final AtomicReference<C5983a> f19776d = new AtomicReference();
    /* renamed from: a */
    private final C5986h f19777a;
    /* renamed from: b */
    private final C5986h f19778b;
    /* renamed from: c */
    private final C5986h f19779c;

    /* renamed from: d */
    private static C5983a m25110d() {
        while (true) {
            C5983a c5983a = (C5983a) f19776d.get();
            if (c5983a != null) {
                return c5983a;
            }
            c5983a = new C5983a();
            if (f19776d.compareAndSet(null, c5983a)) {
                return c5983a;
            }
            c5983a.m25111c();
        }
    }

    private C5983a() {
        C5980g f = C5979f.m25082a().m25088f();
        C5986h d = f.m25097d();
        if (d != null) {
            this.f19777a = d;
        } else {
            this.f19777a = C5980g.m25089a();
        }
        d = f.m25098e();
        if (d != null) {
            this.f19778b = d;
        } else {
            this.f19778b = C5980g.m25091b();
        }
        C5986h f2 = f.m25099f();
        if (f2 != null) {
            this.f19779c = f2;
        } else {
            this.f19779c = C5980g.m25093c();
        }
    }

    /* renamed from: a */
    public static C5986h m25107a() {
        return C7305m.f25695a;
    }

    /* renamed from: b */
    public static C5986h m25109b() {
        return C5977c.m25063a(C5983a.m25110d().f19777a);
    }

    /* renamed from: a */
    public static C5986h m25108a(Executor executor) {
        return new C7294c(executor);
    }

    /* renamed from: c */
    synchronized void m25111c() {
        if (this.f19777a instanceof C5948k) {
            ((C5948k) this.f19777a).mo5128d();
        }
        if (this.f19778b instanceof C5948k) {
            ((C5948k) this.f19778b).mo5128d();
        }
        if (this.f19779c instanceof C5948k) {
            ((C5948k) this.f19779c).mo5128d();
        }
    }
}
