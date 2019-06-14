package com.google.android.gms.internal.ads;

public final class air extends ajk {
    /* renamed from: d */
    private static volatile Long f23653d;
    /* renamed from: e */
    private static final Object f23654e = new Object();

    public air(ahz ahz, String str, String str2, aaa aaa, int i, int i2) {
        super(ahz, str, str2, aaa, i, 44);
    }

    /* renamed from: a */
    protected final void mo3820a() {
        if (f23653d == null) {
            synchronized (f23654e) {
                if (f23653d == null) {
                    f23653d = (Long) this.c.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.b) {
            this.b.f27928A = f23653d;
        }
    }
}
