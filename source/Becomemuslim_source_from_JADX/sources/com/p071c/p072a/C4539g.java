package com.p071c.p072a;

import p289e.C5974e.C7335a;
import p289e.C7367k;

/* compiled from: SerializedRelay */
/* renamed from: com.c.a.g */
public class C4539g<T, R> extends C3455d<T, R> {
    /* renamed from: b */
    private final C3458f<T> f12273b;
    /* renamed from: c */
    private final C3455d<T, R> f12274c;

    /* compiled from: SerializedRelay */
    /* renamed from: com.c.a.g$1 */
    class C45381 implements C7335a<R> {
        /* renamed from: a */
        final /* synthetic */ C3455d f12272a;

        C45381(C3455d c3455d) {
            this.f12272a = c3455d;
        }

        /* renamed from: b */
        public /* synthetic */ void m15444b(Object obj) {
            m15443a((C7367k) obj);
        }

        /* renamed from: a */
        public void m15443a(C7367k<? super R> c7367k) {
            this.f12272a.a(c7367k);
        }
    }

    public C4539g(C3455d<T, R> c3455d) {
        super(new C45381(c3455d));
        this.f12274c = c3455d;
        this.f12273b = new C3458f(c3455d);
    }

    /* renamed from: b */
    public void m15446b(T t) {
        this.f12273b.m11110b(t);
    }

    /* renamed from: a */
    public boolean mo2803a() {
        return this.f12274c.mo2803a();
    }
}
