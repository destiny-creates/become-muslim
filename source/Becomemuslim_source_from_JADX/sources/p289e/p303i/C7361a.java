package p289e.p303i;

import java.util.concurrent.atomic.AtomicReference;
import p289e.C5989l;
import p289e.p291b.C5913a;

/* compiled from: BooleanSubscription */
/* renamed from: e.i.a */
public final class C7361a implements C5989l {
    /* renamed from: b */
    static final C5913a f25761b = new C73601();
    /* renamed from: a */
    final AtomicReference<C5913a> f25762a;

    /* compiled from: BooleanSubscription */
    /* renamed from: e.i.a$1 */
    static class C73601 implements C5913a {
        /* renamed from: a */
        public void mo4985a() {
        }

        C73601() {
        }
    }

    public C7361a() {
        this.f25762a = new AtomicReference();
    }

    private C7361a(C5913a c5913a) {
        this.f25762a = new AtomicReference(c5913a);
    }

    /* renamed from: c */
    public static C7361a m33762c() {
        return new C7361a();
    }

    /* renamed from: a */
    public static C7361a m33761a(C5913a c5913a) {
        return new C7361a(c5913a);
    }

    /* renamed from: b */
    public boolean mo5121b() {
        return this.f25762a.get() == f25761b;
    }

    public void U_() {
        if (((C5913a) this.f25762a.get()) != f25761b) {
            C5913a c5913a = (C5913a) this.f25762a.getAndSet(f25761b);
            if (c5913a != null && c5913a != f25761b) {
                c5913a.mo4985a();
            }
        }
    }
}
