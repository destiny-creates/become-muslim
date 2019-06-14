package p289e.p292c.p293a;

import p289e.C5974e.C7336b;
import p289e.C5989l;
import p289e.C7367k;
import p289e.p290a.C5903b;
import p289e.p291b.C5919g;
import p289e.p291b.C5920h;

/* compiled from: OperatorTakeWhile */
/* renamed from: e.c.a.bb */
public final class bb<T> implements C7336b<T, T> {
    /* renamed from: a */
    final C5920h<? super T, ? super Integer, Boolean> f30129a;

    /* compiled from: OperatorTakeWhile */
    /* renamed from: e.c.a.bb$1 */
    class C72641 implements C5920h<T, Integer, Boolean> {
        /* renamed from: a */
        final /* synthetic */ C5919g f25578a;

        C72641(C5919g c5919g) {
            this.f25578a = c5919g;
        }

        /* renamed from: a */
        public Boolean m33565a(T t, Integer num) {
            return (Boolean) this.f25578a.mo4976a(t);
        }
    }

    public bb(C5919g<? super T, Boolean> c5919g) {
        this(new C72641(c5919g));
    }

    public bb(C5920h<? super T, ? super Integer, Boolean> c5920h) {
        this.f30129a = c5920h;
    }

    /* renamed from: a */
    public C7367k<? super T> m39319a(final C7367k<? super T> c7367k) {
        C5989l c80862 = new C7367k<T>(this, false, c7367k) {
            /* renamed from: b */
            final /* synthetic */ bb f30126b;
            /* renamed from: c */
            private int f30127c;
            /* renamed from: d */
            private boolean f30128d;

            /* renamed from: a */
            public void mo5000a(T t) {
                try {
                    C5920h c5920h = this.f30126b.f30129a;
                    int i = this.f30127c;
                    this.f30127c = i + 1;
                    if (((Boolean) c5920h.mo5126a(t, Integer.valueOf(i))).booleanValue()) {
                        c7367k.mo5000a((Object) t);
                    } else {
                        this.f30128d = true;
                        c7367k.L_();
                        U_();
                    }
                } catch (Throwable th) {
                    this.f30128d = true;
                    C5903b.m24790a(th, c7367k, t);
                    U_();
                }
            }

            public void L_() {
                if (!this.f30128d) {
                    c7367k.L_();
                }
            }

            /* renamed from: a */
            public void mo5001a(Throwable th) {
                if (!this.f30128d) {
                    c7367k.mo5001a(th);
                }
            }
        };
        c7367k.m33781a(c80862);
        return c80862;
    }
}
