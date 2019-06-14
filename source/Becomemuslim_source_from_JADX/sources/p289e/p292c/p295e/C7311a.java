package p289e.p292c.p295e;

import p289e.C5982f;
import p289e.p291b.C5913a;
import p289e.p291b.C5914b;

/* compiled from: ActionObserver */
/* renamed from: e.c.e.a */
public final class C7311a<T> implements C5982f<T> {
    /* renamed from: a */
    final C5914b<? super T> f25703a;
    /* renamed from: b */
    final C5914b<? super Throwable> f25704b;
    /* renamed from: c */
    final C5913a f25705c;

    public C7311a(C5914b<? super T> c5914b, C5914b<? super Throwable> c5914b2, C5913a c5913a) {
        this.f25703a = c5914b;
        this.f25704b = c5914b2;
        this.f25705c = c5913a;
    }

    /* renamed from: a */
    public void mo5000a(T t) {
        this.f25703a.mo4974b(t);
    }

    /* renamed from: a */
    public void mo5001a(Throwable th) {
        this.f25704b.mo4974b(th);
    }

    public void L_() {
        this.f25705c.mo4985a();
    }
}
