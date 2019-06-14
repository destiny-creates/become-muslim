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

/* compiled from: OnSubscribeMap */
/* renamed from: e.c.a.v */
public final class C8119v<T, R> implements C7335a<R> {
    /* renamed from: a */
    final C5974e<T> f30229a;
    /* renamed from: b */
    final C5919g<? super T, ? extends R> f30230b;

    /* compiled from: OnSubscribeMap */
    /* renamed from: e.c.a.v$a */
    static final class C8118a<T, R> extends C7367k<T> {
        /* renamed from: a */
        final C7367k<? super R> f30226a;
        /* renamed from: b */
        final C5919g<? super T, ? extends R> f30227b;
        /* renamed from: c */
        boolean f30228c;

        public C8118a(C7367k<? super R> c7367k, C5919g<? super T, ? extends R> c5919g) {
            this.f30226a = c7367k;
            this.f30227b = c5919g;
        }

        /* renamed from: a */
        public void mo5000a(T t) {
            try {
                this.f30226a.mo5000a(this.f30227b.mo4976a(t));
            } catch (Throwable th) {
                C5903b.m24794b(th);
                U_();
                mo5001a(C5910g.m24799a(th, t));
            }
        }

        /* renamed from: a */
        public void mo5001a(Throwable th) {
            if (this.f30228c) {
                C5977c.m25068a(th);
                return;
            }
            this.f30228c = true;
            this.f30226a.mo5001a(th);
        }

        public void L_() {
            if (!this.f30228c) {
                this.f30226a.L_();
            }
        }

        /* renamed from: a */
        public void mo6324a(C5984g c5984g) {
            this.f30226a.mo6324a(c5984g);
        }
    }

    /* renamed from: b */
    public /* synthetic */ void mo4974b(Object obj) {
        m39439a((C7367k) obj);
    }

    public C8119v(C5974e<T> c5974e, C5919g<? super T, ? extends R> c5919g) {
        this.f30229a = c5974e;
        this.f30230b = c5919g;
    }

    /* renamed from: a */
    public void m39439a(C7367k<? super R> c7367k) {
        C7367k c8118a = new C8118a(c7367k, this.f30230b);
        c7367k.m33781a((C5989l) c8118a);
        this.f30229a.m25007a(c8118a);
    }
}
