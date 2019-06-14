package p289e.p292c.p293a;

import p289e.C5974e.C7336b;
import p289e.C5984g;
import p289e.C5989l;
import p289e.C7367k;
import p289e.p290a.C5903b;
import p289e.p290a.C5910g;
import p289e.p300f.C5977c;

/* compiled from: OperatorCast */
/* renamed from: e.c.a.ai */
public class ai<T, R> implements C7336b<R, T> {
    /* renamed from: a */
    final Class<R> f29930a;

    /* compiled from: OperatorCast */
    /* renamed from: e.c.a.ai$a */
    static final class C8057a<T, R> extends C7367k<T> {
        /* renamed from: a */
        final C7367k<? super R> f29927a;
        /* renamed from: b */
        final Class<R> f29928b;
        /* renamed from: c */
        boolean f29929c;

        public C8057a(C7367k<? super R> c7367k, Class<R> cls) {
            this.f29927a = c7367k;
            this.f29928b = cls;
        }

        /* renamed from: a */
        public void mo5000a(T t) {
            try {
                this.f29927a.mo5000a(this.f29928b.cast(t));
            } catch (Throwable th) {
                C5903b.m24794b(th);
                U_();
                mo5001a(C5910g.m24799a(th, t));
            }
        }

        /* renamed from: a */
        public void mo5001a(Throwable th) {
            if (this.f29929c) {
                C5977c.m25068a(th);
                return;
            }
            this.f29929c = true;
            this.f29927a.mo5001a(th);
        }

        public void L_() {
            if (!this.f29929c) {
                this.f29927a.L_();
            }
        }

        /* renamed from: a */
        public void mo6324a(C5984g c5984g) {
            this.f29927a.mo6324a(c5984g);
        }
    }

    public ai(Class<R> cls) {
        this.f29930a = cls;
    }

    /* renamed from: a */
    public C7367k<? super T> m39136a(C7367k<? super R> c7367k) {
        C5989l c8057a = new C8057a(c7367k, this.f29930a);
        c7367k.m33781a(c8057a);
        return c8057a;
    }
}
