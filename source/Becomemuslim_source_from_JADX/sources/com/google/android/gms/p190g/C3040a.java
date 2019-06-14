package com.google.android.gms.p190g;

/* renamed from: com.google.android.gms.g.a */
public abstract class C3040a<T> {
    /* renamed from: a */
    private final Object f7748a = new Object();
    /* renamed from: b */
    private C3024a<T> f7749b;

    /* renamed from: com.google.android.gms.g.a$a */
    public interface C3024a<T> {
        /* renamed from: a */
        void m8868a();
    }

    /* renamed from: a */
    public void mo2596a() {
        synchronized (this.f7748a) {
            if (this.f7749b != null) {
                this.f7749b.m8868a();
                this.f7749b = null;
            }
        }
    }

    /* renamed from: b */
    public boolean mo2597b() {
        return true;
    }
}
