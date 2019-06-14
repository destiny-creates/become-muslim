package p289e.p292c.p293a;

import java.util.NoSuchElementException;
import p289e.C5974e;
import p289e.C5988i.C7359a;
import p289e.C5989l;
import p289e.C7366j;
import p289e.C7367k;

/* compiled from: OnSubscribeSingle */
/* renamed from: e.c.a.aa */
public class aa<T> implements C7359a<T> {
    /* renamed from: a */
    private final C5974e<T> f29868a;

    /* renamed from: b */
    public /* synthetic */ void mo4974b(Object obj) {
        m39092a((C7366j) obj);
    }

    public aa(C5974e<T> c5974e) {
        this.f29868a = c5974e;
    }

    /* renamed from: a */
    public void m39092a(final C7366j<? super T> c7366j) {
        C7367k c80491 = new C7367k<T>(this) {
            /* renamed from: b */
            final /* synthetic */ aa f29864b;
            /* renamed from: c */
            private boolean f29865c;
            /* renamed from: d */
            private boolean f29866d;
            /* renamed from: e */
            private T f29867e;

            /* renamed from: c */
            public void mo6323c() {
                m33779a(2);
            }

            public void L_() {
                if (!this.f29865c) {
                    if (this.f29866d) {
                        c7366j.mo6328a(this.f29867e);
                    } else {
                        c7366j.mo6329a(new NoSuchElementException("Observable emitted no items"));
                    }
                }
            }

            /* renamed from: a */
            public void mo5001a(Throwable th) {
                c7366j.mo6329a(th);
                U_();
            }

            /* renamed from: a */
            public void mo5000a(T t) {
                if (this.f29866d) {
                    this.f29865c = true;
                    c7366j.mo6329a(new IllegalArgumentException("Observable emitted too many elements"));
                    U_();
                    return;
                }
                this.f29866d = true;
                this.f29867e = t;
            }
        };
        c7366j.m33774a((C5989l) c80491);
        this.f29868a.m25007a(c80491);
    }

    /* renamed from: a */
    public static <T> aa<T> m39091a(C5974e<T> c5974e) {
        return new aa(c5974e);
    }
}
