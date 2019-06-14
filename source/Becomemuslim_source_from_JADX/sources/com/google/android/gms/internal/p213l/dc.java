package com.google.android.gms.internal.p213l;

/* renamed from: com.google.android.gms.internal.l.dc */
abstract class dc extends db {
    /* renamed from: a */
    private boolean f28977a;

    dc(cg cgVar) {
        super(cgVar);
        this.q.m31958a(this);
    }

    /* renamed from: A */
    public final void m38099A() {
        if (this.f28977a) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!mo6739e()) {
            this.q.m31955C();
            this.f28977a = true;
        }
    }

    /* renamed from: B */
    public final void m38100B() {
        if (this.f28977a) {
            throw new IllegalStateException("Can't initialize twice");
        }
        mo6740f();
        this.q.m31955C();
        this.f28977a = true;
    }

    /* renamed from: e */
    protected abstract boolean mo6739e();

    /* renamed from: f */
    protected void mo6740f() {
    }

    /* renamed from: y */
    final boolean m38103y() {
        return this.f28977a;
    }

    /* renamed from: z */
    protected final void m38104z() {
        if (!m38103y()) {
            throw new IllegalStateException("Not initialized");
        }
    }
}
