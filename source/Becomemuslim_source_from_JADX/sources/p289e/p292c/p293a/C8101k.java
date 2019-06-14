package p289e.p292c.p293a;

import p289e.C5974e;
import p289e.C5974e.C7335a;
import p289e.C7367k;
import p289e.p290a.C5903b;
import p289e.p291b.C5915c;
import p289e.p291b.C5918f;

/* compiled from: OnSubscribeCollect */
/* renamed from: e.c.a.k */
public final class C8101k<T, R> implements C7335a<R> {
    /* renamed from: a */
    final C5974e<T> f30181a;
    /* renamed from: b */
    final C5918f<R> f30182b;
    /* renamed from: c */
    final C5915c<R, ? super T> f30183c;

    /* compiled from: OnSubscribeCollect */
    /* renamed from: e.c.a.k$a */
    static final class C8342a<T, R> extends C8249e<T, R> {
        /* renamed from: f */
        final C5915c<R, ? super T> f32846f;

        public C8342a(C7367k<? super R> c7367k, R r, C5915c<R, ? super T> c5915c) {
            super(c7367k);
            this.c = r;
            this.b = true;
            this.f32846f = c5915c;
        }

        /* renamed from: a */
        public void mo5000a(T t) {
            if (!this.e) {
                try {
                    this.f32846f.mo4980a(this.c, t);
                } catch (T t2) {
                    C5903b.m24794b(t2);
                    U_();
                    mo5001a(t2);
                }
            }
        }
    }

    /* renamed from: b */
    public /* synthetic */ void mo4974b(Object obj) {
        m39388a((C7367k) obj);
    }

    public C8101k(C5974e<T> c5974e, C5918f<R> c5918f, C5915c<R, ? super T> c5915c) {
        this.f30181a = c5974e;
        this.f30182b = c5918f;
        this.f30183c = c5915c;
    }

    /* renamed from: a */
    public void m39388a(C7367k<? super R> c7367k) {
        try {
            new C8342a(c7367k, this.f30182b.call(), this.f30183c).m39363a((C5974e) this.f30181a);
        } catch (Throwable th) {
            C5903b.m24794b(th);
            c7367k.mo5001a(th);
        }
    }
}
