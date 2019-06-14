package com.google.android.gms.internal.p213l;

/* renamed from: com.google.android.gms.internal.l.fl */
abstract class fl extends fk {
    /* renamed from: b */
    private boolean f32358b;

    fl(fm fmVar) {
        super(fmVar);
        this.a.m32047a(this);
    }

    /* renamed from: H */
    final boolean m42631H() {
        return this.f32358b;
    }

    /* renamed from: I */
    protected final void m42632I() {
        if (!m42631H()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    /* renamed from: J */
    public final void m42633J() {
        if (this.f32358b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        mo6850e();
        this.a.m32072l();
        this.f32358b = true;
    }

    /* renamed from: e */
    protected abstract boolean mo6850e();
}
