package p289e.p292c.p293a;

import p289e.C5974e;
import p289e.C5974e.C7335a;
import p289e.C5989l;
import p289e.C7367k;
import p289e.p299e.C5973e;
import p289e.p300f.C5977c;
import p289e.p303i.C5987e;
import p289e.p303i.C7364d;

/* compiled from: OnSubscribeDelaySubscriptionOther */
/* renamed from: e.c.a.o */
public final class C8109o<T, U> implements C7335a<T> {
    /* renamed from: a */
    final C5974e<? extends T> f30209a;
    /* renamed from: b */
    final C5974e<U> f30210b;

    /* renamed from: b */
    public /* synthetic */ void mo4974b(Object obj) {
        m39417a((C7367k) obj);
    }

    public C8109o(C5974e<? extends T> c5974e, C5974e<U> c5974e2) {
        this.f30209a = c5974e;
        this.f30210b = c5974e2;
    }

    /* renamed from: a */
    public void m39417a(C7367k<? super T> c7367k) {
        final C5989l c7364d = new C7364d();
        c7367k.m33781a(c7364d);
        c7367k = C5973e.m24966a((C7367k) c7367k);
        C7367k c81081 = new C7367k<U>(this) {
            /* renamed from: a */
            boolean f30205a;
            /* renamed from: d */
            final /* synthetic */ C8109o f30208d;

            /* renamed from: a */
            public void mo5000a(U u) {
                L_();
            }

            /* renamed from: a */
            public void mo5001a(Throwable th) {
                if (this.f30205a) {
                    C5977c.m25068a(th);
                    return;
                }
                this.f30205a = true;
                c7367k.mo5001a(th);
            }

            public void L_() {
                if (!this.f30205a) {
                    this.f30205a = true;
                    c7364d.m33770a(C5987e.m25119b());
                    this.f30208d.f30209a.m25007a(c7367k);
                }
            }
        };
        c7364d.m33770a(c81081);
        this.f30210b.m25007a(c81081);
    }
}
