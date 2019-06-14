package p289e.p292c.p293a;

import p289e.C5974e;
import p289e.C5974e.C7335a;
import p289e.C5982f;
import p289e.C7367k;
import p289e.p290a.C5903b;
import p289e.p291b.C5918f;
import p289e.p299e.C5973e;

/* compiled from: OnSubscribeDefer */
/* renamed from: e.c.a.n */
public final class C8107n<T> implements C7335a<T> {
    /* renamed from: a */
    final C5918f<? extends C5974e<? extends T>> f30204a;

    /* renamed from: b */
    public /* synthetic */ void mo4974b(Object obj) {
        m39413a((C7367k) obj);
    }

    public C8107n(C5918f<? extends C5974e<? extends T>> c5918f) {
        this.f30204a = c5918f;
    }

    /* renamed from: a */
    public void m39413a(C7367k<? super T> c7367k) {
        try {
            ((C5974e) this.f30204a.call()).m25007a(C5973e.m24966a((C7367k) c7367k));
        } catch (Throwable th) {
            C5903b.m24789a(th, (C5982f) c7367k);
        }
    }
}
