package p289e.p292c.p293a;

import p289e.C5974e.C7336b;
import p289e.C5986h;
import p289e.C5986h.C7353a;
import p289e.C7367k;
import p289e.p291b.C5913a;
import p289e.p303i.C5987e;

/* compiled from: OperatorUnsubscribeOn */
/* renamed from: e.c.a.bd */
public class bd<T> implements C7336b<T, T> {
    /* renamed from: a */
    final C5986h f30137a;

    public bd(C5986h c5986h) {
        this.f30137a = c5986h;
    }

    /* renamed from: a */
    public C7367k<? super T> m39329a(final C7367k<? super T> c7367k) {
        final C7367k<? super T> c80881 = new C7367k<T>(this) {
            /* renamed from: b */
            final /* synthetic */ bd f30136b;

            public void L_() {
                c7367k.L_();
            }

            /* renamed from: a */
            public void mo5001a(Throwable th) {
                c7367k.mo5001a(th);
            }

            /* renamed from: a */
            public void mo5000a(T t) {
                c7367k.mo5000a((Object) t);
            }
        };
        c7367k.m33781a(C5987e.m25118a(new C5913a(this) {
            /* renamed from: b */
            final /* synthetic */ bd f25582b;

            /* renamed from: a */
            public void mo4985a() {
                final C7353a a = this.f25582b.f30137a.mo5127a();
                a.mo6332a(new C5913a(this) {
                    /* renamed from: b */
                    final /* synthetic */ C72662 f25580b;

                    /* renamed from: a */
                    public void mo4985a() {
                        c80881.U_();
                        a.U_();
                    }
                });
            }
        }));
        return c80881;
    }
}
