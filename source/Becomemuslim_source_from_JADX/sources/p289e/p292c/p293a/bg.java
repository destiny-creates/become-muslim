package p289e.p292c.p293a;

import p289e.C5974e.C7336b;
import p289e.C5988i.C7359a;
import p289e.C5989l;
import p289e.C7366j;
import p289e.C7367k;
import p289e.p290a.C5903b;
import p289e.p292c.p293a.bf.C8091a;
import p289e.p292c.p386b.C7286c;
import p289e.p300f.C5977c;

/* compiled from: SingleLiftObservableOperator */
/* renamed from: e.c.a.bg */
public final class bg<T, R> implements C7359a<R> {
    /* renamed from: a */
    final C7359a<T> f30155a;
    /* renamed from: b */
    final C7336b<? extends R, ? super T> f30156b;

    /* compiled from: SingleLiftObservableOperator */
    /* renamed from: e.c.a.bg$a */
    static final class C8092a<T> extends C7366j<T> {
        /* renamed from: a */
        final C7367k<? super T> f30154a;

        C8092a(C7367k<? super T> c7367k) {
            this.f30154a = c7367k;
        }

        /* renamed from: a */
        public void mo6328a(T t) {
            this.f30154a.mo6324a(new C7286c(this.f30154a, t));
        }

        /* renamed from: a */
        public void mo6329a(Throwable th) {
            this.f30154a.mo5001a(th);
        }
    }

    /* renamed from: b */
    public /* synthetic */ void mo4974b(Object obj) {
        m39353a((C7366j) obj);
    }

    /* renamed from: a */
    public void m39353a(C7366j<? super R> c7366j) {
        C5989l c8091a = new C8091a(c7366j);
        c7366j.m33774a(c8091a);
        try {
            C7367k c7367k = (C7367k) C5977c.m25069b(this.f30156b).mo4976a(c8091a);
            C7366j a = bg.m39352a(c7367k);
            c7367k.mo6323c();
            this.f30155a.mo4974b(a);
        } catch (Throwable th) {
            C5903b.m24791a(th, (C7366j) c7366j);
        }
    }

    /* renamed from: a */
    public static <T> C7366j<T> m39352a(C7367k<T> c7367k) {
        C5989l c8092a = new C8092a(c7367k);
        c7367k.m33781a(c8092a);
        return c8092a;
    }
}
