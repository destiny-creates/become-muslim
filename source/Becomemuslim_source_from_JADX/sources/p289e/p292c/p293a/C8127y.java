package p289e.p292c.p293a;

import p289e.C5974e;
import p289e.C5974e.C7335a;
import p289e.C7367k;
import p289e.p290a.C5903b;
import p289e.p291b.C5920h;

/* compiled from: OnSubscribeReduceSeed */
/* renamed from: e.c.a.y */
public final class C8127y<T, R> implements C7335a<R> {
    /* renamed from: a */
    final C5974e<T> f30254a;
    /* renamed from: b */
    final R f30255b;
    /* renamed from: c */
    final C5920h<R, ? super T, R> f30256c;

    /* compiled from: OnSubscribeReduceSeed */
    /* renamed from: e.c.a.y$a */
    static final class C8254a<T, R> extends C8095d<T, R> {
        /* renamed from: e */
        final C5920h<R, ? super T, R> f32445e;

        public C8254a(C7367k<? super R> c7367k, R r, C5920h<R, ? super T, R> c5920h) {
            super(c7367k);
            this.c = r;
            this.b = true;
            this.f32445e = c5920h;
        }

        /* renamed from: a */
        public void mo5000a(T t) {
            try {
                this.c = this.f32445e.mo5126a(this.c, t);
            } catch (T t2) {
                C5903b.m24794b(t2);
                U_();
                this.a.mo5001a((Throwable) t2);
            }
        }
    }

    /* renamed from: b */
    public /* synthetic */ void mo4974b(Object obj) {
        m39474a((C7367k) obj);
    }

    public C8127y(C5974e<T> c5974e, R r, C5920h<R, ? super T, R> c5920h) {
        this.f30254a = c5974e;
        this.f30255b = r;
        this.f30256c = c5920h;
    }

    /* renamed from: a */
    public void m39474a(C7367k<? super R> c7367k) {
        new C8254a(c7367k, this.f30255b, this.f30256c).m39363a((C5974e) this.f30254a);
    }
}
