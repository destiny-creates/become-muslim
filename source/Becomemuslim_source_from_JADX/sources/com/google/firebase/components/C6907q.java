package com.google.firebase.components;

import com.google.firebase.p245b.C5334a;

/* compiled from: com.google.firebase:firebase-common@@16.0.2 */
/* renamed from: com.google.firebase.components.q */
final class C6907q<T> implements C5334a<T> {
    /* renamed from: a */
    private static final Object f24724a = new Object();
    /* renamed from: b */
    private volatile Object f24725b = f24724a;
    /* renamed from: c */
    private volatile C5334a<T> f24726c;

    C6907q(C5342c<T> c5342c, C5341b c5341b) {
        this.f24726c = C6908r.m32374a(c5342c, c5341b);
    }

    /* renamed from: a */
    public final T mo4881a() {
        T t = this.f24725b;
        if (t == f24724a) {
            synchronized (this) {
                t = this.f24725b;
                if (t == f24724a) {
                    t = this.f24726c.mo4881a();
                    this.f24725b = t;
                    this.f24726c = null;
                }
            }
        }
        return t;
    }
}
