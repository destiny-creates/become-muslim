package com.google.android.gms.internal.ads;

public final class aiv extends ajk {
    /* renamed from: d */
    private static volatile Long f23656d;
    /* renamed from: e */
    private static final Object f23657e = new Object();

    public aiv(ahz ahz, String str, String str2, aaa aaa, int i, int i2) {
        super(ahz, str, str2, aaa, i, 22);
    }

    /* renamed from: a */
    protected final void mo3820a() {
        if (f23656d == null) {
            synchronized (f23657e) {
                if (f23656d == null) {
                    f23656d = (Long) this.c.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.b) {
            this.b.f27963l = f23656d;
        }
    }
}
