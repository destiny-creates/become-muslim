package com.google.android.gms.internal.p213l;

/* renamed from: com.google.android.gms.internal.l.j */
public abstract class C5043j {
    /* renamed from: b */
    protected volatile int f17294b = -1;

    /* renamed from: a */
    protected int mo4756a() {
        return 0;
    }

    /* renamed from: a */
    public abstract C5043j mo6216a(C5033a c5033a);

    /* renamed from: a */
    public void mo4757a(C5035b c5035b) {
    }

    /* renamed from: b */
    public C5043j mo4758b() {
        return (C5043j) super.clone();
    }

    /* renamed from: c */
    public final int m21443c() {
        if (this.f17294b < 0) {
            m21444d();
        }
        return this.f17294b;
    }

    public /* synthetic */ Object clone() {
        return mo4758b();
    }

    /* renamed from: d */
    public final int m21444d() {
        int a = mo4756a();
        this.f17294b = a;
        return a;
    }

    public String toString() {
        return C5044k.m21445a(this);
    }
}
