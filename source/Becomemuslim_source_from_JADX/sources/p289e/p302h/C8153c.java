package p289e.p302h;

import p289e.C5974e.C7335a;
import p289e.C7367k;
import p289e.p299e.C7339c;

/* compiled from: SerializedSubject */
/* renamed from: e.h.c */
public class C8153c<T, R> extends C7356d<T, R> {
    /* renamed from: b */
    private final C7339c<T> f30318b;
    /* renamed from: c */
    private final C7356d<T, R> f30319c;

    /* compiled from: SerializedSubject */
    /* renamed from: e.h.c$1 */
    class C81521 implements C7335a<R> {
        /* renamed from: a */
        final /* synthetic */ C7356d f30317a;

        C81521(C7356d c7356d) {
            this.f30317a = c7356d;
        }

        /* renamed from: b */
        public /* synthetic */ void mo4974b(Object obj) {
            m39547a((C7367k) obj);
        }

        /* renamed from: a */
        public void m39547a(C7367k<? super R> c7367k) {
            this.f30317a.m25007a((C7367k) c7367k);
        }
    }

    public C8153c(C7356d<T, R> c7356d) {
        super(new C81521(c7356d));
        this.f30319c = c7356d;
        this.f30318b = new C7339c(c7356d);
    }

    public void L_() {
        this.f30318b.L_();
    }

    /* renamed from: a */
    public void mo5001a(Throwable th) {
        this.f30318b.mo5001a(th);
    }

    /* renamed from: a */
    public void mo5000a(T t) {
        this.f30318b.mo5000a((Object) t);
    }
}
