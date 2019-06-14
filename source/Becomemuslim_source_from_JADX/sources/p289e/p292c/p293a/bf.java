package p289e.p292c.p293a;

import java.util.NoSuchElementException;
import p289e.C5974e.C7335a;
import p289e.C5988i.C7359a;
import p289e.C5989l;
import p289e.C7366j;
import p289e.C7367k;
import p289e.p300f.C5977c;

/* compiled from: SingleFromObservable */
/* renamed from: e.c.a.bf */
public final class bf<T> implements C7359a<T> {
    /* renamed from: a */
    final C7335a<T> f30153a;

    /* compiled from: SingleFromObservable */
    /* renamed from: e.c.a.bf$a */
    static final class C8091a<T> extends C7367k<T> {
        /* renamed from: a */
        final C7366j<? super T> f30150a;
        /* renamed from: b */
        T f30151b;
        /* renamed from: c */
        int f30152c;

        C8091a(C7366j<? super T> c7366j) {
            this.f30150a = c7366j;
        }

        /* renamed from: a */
        public void mo5000a(T t) {
            int i = this.f30152c;
            if (i == 0) {
                this.f30152c = 1;
                this.f30151b = t;
            } else if (i == 1) {
                this.f30152c = 2;
                this.f30150a.mo6329a(new IndexOutOfBoundsException("The upstream produced more than one value"));
            }
        }

        /* renamed from: a */
        public void mo5001a(Throwable th) {
            if (this.f30152c == 2) {
                C5977c.m25068a(th);
                return;
            }
            this.f30151b = null;
            this.f30150a.mo6329a(th);
        }

        public void L_() {
            int i = this.f30152c;
            if (i == 0) {
                this.f30150a.mo6329a(new NoSuchElementException());
            } else if (i == 1) {
                this.f30152c = 2;
                Object obj = this.f30151b;
                this.f30151b = null;
                this.f30150a.mo6328a(obj);
            }
        }
    }

    /* renamed from: b */
    public /* synthetic */ void mo4974b(Object obj) {
        m39348a((C7366j) obj);
    }

    public bf(C7335a<T> c7335a) {
        this.f30153a = c7335a;
    }

    /* renamed from: a */
    public void m39348a(C7366j<? super T> c7366j) {
        C5989l c8091a = new C8091a(c7366j);
        c7366j.m33774a(c8091a);
        this.f30153a.mo4974b(c8091a);
    }
}
