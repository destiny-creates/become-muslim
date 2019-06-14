package p289e.p299e;

import p289e.C5982f;
import p289e.C7367k;

/* compiled from: SerializedSubscriber */
/* renamed from: e.e.d */
public class C8146d<T> extends C7367k<T> {
    /* renamed from: a */
    private final C5982f<T> f30308a;

    public C8146d(C7367k<? super T> c7367k) {
        this(c7367k, true);
    }

    public C8146d(C7367k<? super T> c7367k, boolean z) {
        super(c7367k, z);
        this.f30308a = new C7339c(c7367k);
    }

    public void L_() {
        this.f30308a.L_();
    }

    /* renamed from: a */
    public void mo5001a(Throwable th) {
        this.f30308a.mo5001a(th);
    }

    /* renamed from: a */
    public void mo5000a(T t) {
        this.f30308a.mo5000a((Object) t);
    }
}
