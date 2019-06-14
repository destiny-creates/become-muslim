package com.google.android.gms.internal.ads;

public final class ajf extends ajk {
    /* renamed from: d */
    private static volatile Long f23666d;
    /* renamed from: e */
    private static final Object f23667e = new Object();

    public ajf(ahz ahz, String str, String str2, aaa aaa, int i, int i2) {
        super(ahz, str, str2, aaa, i, 33);
    }

    /* renamed from: a */
    protected final void mo3820a() {
        if (f23666d == null) {
            synchronized (f23667e) {
                if (f23666d == null) {
                    f23666d = (Long) this.c.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.b) {
            this.b.f27969r = f23666d;
        }
    }
}
