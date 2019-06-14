package p289e.p292c.p293a;

import p289e.C5974e.C7335a;
import p289e.C5974e.C7336b;
import p289e.C7367k;
import p289e.p290a.C5903b;
import p289e.p300f.C5977c;

/* compiled from: OnSubscribeLift */
/* renamed from: e.c.a.u */
public final class C8117u<T, R> implements C7335a<R> {
    /* renamed from: a */
    final C7335a<T> f30224a;
    /* renamed from: b */
    final C7336b<? extends R, ? super T> f30225b;

    /* renamed from: b */
    public /* synthetic */ void mo4974b(Object obj) {
        m39434a((C7367k) obj);
    }

    public C8117u(C7335a<T> c7335a, C7336b<? extends R, ? super T> c7336b) {
        this.f30224a = c7335a;
        this.f30225b = c7336b;
    }

    /* renamed from: a */
    public void m39434a(C7367k<? super R> c7367k) {
        C7367k c7367k2;
        try {
            c7367k2 = (C7367k) C5977c.m25062a(this.f30225b).mo4976a(c7367k);
            c7367k2.mo6323c();
            this.f30224a.mo4974b(c7367k2);
        } catch (Throwable th) {
            C5903b.m24794b(th);
            c7367k.mo5001a(th);
        }
    }
}
