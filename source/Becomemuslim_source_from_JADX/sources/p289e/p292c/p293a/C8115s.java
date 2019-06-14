package p289e.p292c.p293a;

import java.util.concurrent.Callable;
import p289e.C5974e.C7335a;
import p289e.C5982f;
import p289e.C5984g;
import p289e.C7367k;
import p289e.p290a.C5903b;
import p289e.p292c.p386b.C7285b;

/* compiled from: OnSubscribeFromCallable */
/* renamed from: e.c.a.s */
public final class C8115s<T> implements C7335a<T> {
    /* renamed from: a */
    private final Callable<? extends T> f30222a;

    /* renamed from: b */
    public /* synthetic */ void mo4974b(Object obj) {
        m39430a((C7367k) obj);
    }

    public C8115s(Callable<? extends T> callable) {
        this.f30222a = callable;
    }

    /* renamed from: a */
    public void m39430a(C7367k<? super T> c7367k) {
        C5984g c7285b = new C7285b(c7367k);
        c7367k.mo6324a(c7285b);
        try {
            c7285b.m33603a(this.f30222a.call());
        } catch (Throwable th) {
            C5903b.m24789a(th, (C5982f) c7367k);
        }
    }
}
