package com.google.android.gms.internal.p213l;

/* renamed from: com.google.android.gms.internal.l.s */
abstract class C8220s extends C7825r {
    /* renamed from: a */
    private boolean f32367a;

    C8220s(cg cgVar) {
        super(cgVar);
        this.q.m31959a(this);
    }

    /* renamed from: A */
    protected void mo6851A() {
    }

    /* renamed from: v */
    final boolean m42727v() {
        return this.f32367a;
    }

    /* renamed from: w */
    protected final void m42728w() {
        if (!m42727v()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    /* renamed from: x */
    public final void m42729x() {
        if (this.f32367a) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!mo6852z()) {
            this.q.m31955C();
            this.f32367a = true;
        }
    }

    /* renamed from: y */
    public final void m42730y() {
        if (this.f32367a) {
            throw new IllegalStateException("Can't initialize twice");
        }
        mo6851A();
        this.q.m31955C();
        this.f32367a = true;
    }

    /* renamed from: z */
    protected abstract boolean mo6852z();
}
