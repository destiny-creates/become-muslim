package com.google.android.gms.internal.ads;

public final class aje extends ajk {
    /* renamed from: d */
    private final aij f23664d;
    /* renamed from: e */
    private long f23665e;

    public aje(ahz ahz, String str, String str2, aaa aaa, int i, int i2, aij aij) {
        super(ahz, str, str2, aaa, i, 53);
        this.f23664d = aij;
        if (aij != null) {
            this.f23665e = aij.m18490a();
        }
    }

    /* renamed from: a */
    protected final void mo3820a() {
        if (this.f23664d != null) {
            this.b.f27936I = (Long) this.c.invoke(null, new Object[]{Long.valueOf(this.f23665e)});
        }
    }
}
