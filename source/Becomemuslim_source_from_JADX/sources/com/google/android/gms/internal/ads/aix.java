package com.google.android.gms.internal.ads;

public final class aix extends ajk {
    /* renamed from: d */
    private static volatile String f23659d;
    /* renamed from: e */
    private static final Object f23660e = new Object();

    public aix(ahz ahz, String str, String str2, aaa aaa, int i, int i2) {
        super(ahz, str, str2, aaa, i, 1);
    }

    /* renamed from: a */
    protected final void mo3820a() {
        this.b.f27952a = "E";
        if (f23659d == null) {
            synchronized (f23660e) {
                if (f23659d == null) {
                    f23659d = (String) this.c.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.b) {
            this.b.f27952a = f23659d;
        }
    }
}
