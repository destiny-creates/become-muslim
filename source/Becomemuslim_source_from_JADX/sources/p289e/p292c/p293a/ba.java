package p289e.p292c.p293a;

import p289e.C5974e.C7336b;
import p289e.C5984g;
import p289e.C5989l;
import p289e.C7367k;
import p289e.p290a.C5903b;
import p289e.p291b.C5919g;

/* compiled from: OperatorTakeUntilPredicate */
/* renamed from: e.c.a.ba */
public final class ba<T> implements C7336b<T, T> {
    /* renamed from: a */
    final C5919g<? super T, Boolean> f30124a;

    /* compiled from: OperatorTakeUntilPredicate */
    /* renamed from: e.c.a.ba$a */
    final class C8085a extends C7367k<T> {
        /* renamed from: a */
        final /* synthetic */ ba f30121a;
        /* renamed from: b */
        private final C7367k<? super T> f30122b;
        /* renamed from: c */
        private boolean f30123c;

        C8085a(ba baVar, C7367k<? super T> c7367k) {
            this.f30121a = baVar;
            this.f30122b = c7367k;
        }

        /* renamed from: a */
        public void mo5000a(T t) {
            this.f30122b.mo5000a((Object) t);
            try {
                if (((Boolean) this.f30121a.f30124a.mo4976a(t)).booleanValue()) {
                    this.f30123c = true;
                    this.f30122b.L_();
                    U_();
                }
            } catch (Throwable th) {
                this.f30123c = true;
                C5903b.m24790a(th, this.f30122b, t);
                U_();
            }
        }

        public void L_() {
            if (!this.f30123c) {
                this.f30122b.L_();
            }
        }

        /* renamed from: a */
        public void mo5001a(Throwable th) {
            if (!this.f30123c) {
                this.f30122b.mo5001a(th);
            }
        }

        /* renamed from: b */
        void mo6325b(long j) {
            m33779a(j);
        }
    }

    public ba(C5919g<? super T, Boolean> c5919g) {
        this.f30124a = c5919g;
    }

    /* renamed from: a */
    public C7367k<? super T> m39315a(C7367k<? super T> c7367k) {
        final C5989l c8085a = new C8085a(this, c7367k);
        c7367k.m33781a(c8085a);
        c7367k.mo6324a(new C5984g(this) {
            /* renamed from: b */
            final /* synthetic */ ba f25577b;

            /* renamed from: a */
            public void mo5119a(long j) {
                c8085a.mo6325b(j);
            }
        });
        return c8085a;
    }
}
