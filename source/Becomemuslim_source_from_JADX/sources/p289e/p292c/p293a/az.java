package p289e.p292c.p293a;

import com.facebook.common.time.Clock;
import p289e.C5974e;
import p289e.C5974e.C7336b;
import p289e.C5989l;
import p289e.C7367k;
import p289e.p299e.C8146d;

/* compiled from: OperatorTakeUntil */
/* renamed from: e.c.a.az */
public final class az<T, E> implements C7336b<T, T> {
    /* renamed from: a */
    private final C5974e<? extends E> f30118a;

    public az(C5974e<? extends E> c5974e) {
        this.f30118a = c5974e;
    }

    /* renamed from: a */
    public C7367k<? super T> m39306a(C7367k<? super T> c7367k) {
        final C5989l c8146d = new C8146d(c7367k, false);
        final C5989l c80811 = new C7367k<T>(this, false, c8146d) {
            /* renamed from: b */
            final /* synthetic */ az f30115b;

            /* renamed from: a */
            public void mo5000a(T t) {
                c8146d.mo5000a((Object) t);
            }

            /* renamed from: a */
            public void mo5001a(Throwable th) {
                try {
                    c8146d.mo5001a(th);
                } finally {
                    c8146d.U_();
                }
            }

            public void L_() {
                try {
                    c8146d.L_();
                } finally {
                    c8146d.U_();
                }
            }
        };
        C7367k c80822 = new C7367k<E>(this) {
            /* renamed from: b */
            final /* synthetic */ az f30117b;

            /* renamed from: c */
            public void mo6323c() {
                m33779a((long) Clock.MAX_TIME);
            }

            public void L_() {
                c80811.L_();
            }

            /* renamed from: a */
            public void mo5001a(Throwable th) {
                c80811.mo5001a(th);
            }

            /* renamed from: a */
            public void mo5000a(E e) {
                L_();
            }
        };
        c8146d.m33781a(c80811);
        c8146d.m33781a((C5989l) c80822);
        c7367k.m33781a(c8146d);
        this.f30118a.m25007a(c80822);
        return c80811;
    }
}
