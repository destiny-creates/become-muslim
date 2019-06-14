package com.google.android.gms.internal.p210i;

/* renamed from: com.google.android.gms.internal.i.o */
public abstract class C6797o extends C5006n {
    /* renamed from: a */
    private boolean f24562a;

    protected C6797o(C5008q c5008q) {
        super(c5008q);
    }

    /* renamed from: a */
    protected abstract void mo6145a();

    /* renamed from: y */
    public final boolean m31799y() {
        return this.f24562a;
    }

    /* renamed from: z */
    protected final void m31800z() {
        if (!m31799y()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    /* renamed from: A */
    public final void m31797A() {
        mo6145a();
        this.f24562a = true;
    }
}
