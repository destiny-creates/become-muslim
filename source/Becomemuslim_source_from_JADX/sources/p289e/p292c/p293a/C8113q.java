package p289e.p292c.p293a;

import p289e.C5974e;
import p289e.C5974e.C7335a;
import p289e.C5984g;
import p289e.C5989l;
import p289e.C7367k;
import p289e.p290a.C5903b;
import p289e.p290a.C5910g;
import p289e.p291b.C5919g;
import p289e.p300f.C5977c;

/* compiled from: OnSubscribeFilter */
/* renamed from: e.c.a.q */
public final class C8113q<T> implements C7335a<T> {
    /* renamed from: a */
    final C5974e<T> f30219a;
    /* renamed from: b */
    final C5919g<? super T, Boolean> f30220b;

    /* compiled from: OnSubscribeFilter */
    /* renamed from: e.c.a.q$a */
    static final class C8112a<T> extends C7367k<T> {
        /* renamed from: a */
        final C7367k<? super T> f30216a;
        /* renamed from: b */
        final C5919g<? super T, Boolean> f30217b;
        /* renamed from: c */
        boolean f30218c;

        public C8112a(C7367k<? super T> c7367k, C5919g<? super T, Boolean> c5919g) {
            this.f30216a = c7367k;
            this.f30217b = c5919g;
            m33779a((long) null);
        }

        /* renamed from: a */
        public void mo5000a(T t) {
            try {
                if (((Boolean) this.f30217b.mo4976a(t)).booleanValue()) {
                    this.f30216a.mo5000a((Object) t);
                } else {
                    m33779a(1);
                }
            } catch (Throwable th) {
                C5903b.m24794b(th);
                U_();
                mo5001a(C5910g.m24799a(th, t));
            }
        }

        /* renamed from: a */
        public void mo5001a(Throwable th) {
            if (this.f30218c) {
                C5977c.m25068a(th);
                return;
            }
            this.f30218c = true;
            this.f30216a.mo5001a(th);
        }

        public void L_() {
            if (!this.f30218c) {
                this.f30216a.L_();
            }
        }

        /* renamed from: a */
        public void mo6324a(C5984g c5984g) {
            super.mo6324a(c5984g);
            this.f30216a.mo6324a(c5984g);
        }
    }

    /* renamed from: b */
    public /* synthetic */ void mo4974b(Object obj) {
        m39426a((C7367k) obj);
    }

    public C8113q(C5974e<T> c5974e, C5919g<? super T, Boolean> c5919g) {
        this.f30219a = c5974e;
        this.f30220b = c5919g;
    }

    /* renamed from: a */
    public void m39426a(C7367k<? super T> c7367k) {
        C7367k c8112a = new C8112a(c7367k, this.f30220b);
        c7367k.m33781a((C5989l) c8112a);
        this.f30219a.m25007a(c8112a);
    }
}
