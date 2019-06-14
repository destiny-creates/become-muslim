package com.google.android.gms.internal.ads;

public final class aio extends ajk {
    /* renamed from: d */
    private static volatile String f23648d;
    /* renamed from: e */
    private static final Object f23649e = new Object();

    public aio(ahz ahz, String str, String str2, aaa aaa, int i, int i2) {
        super(ahz, str, str2, aaa, i, 29);
    }

    /* renamed from: a */
    protected final void mo3820a() {
        this.b.f27966o = "E";
        if (f23648d == null) {
            synchronized (f23649e) {
                if (f23648d == null) {
                    f23648d = (String) this.c.invoke(null, new Object[]{this.a.m18454a()});
                }
            }
        }
        synchronized (this.b) {
            this.b.f27966o = agh.m18405a(f23648d.getBytes(), true);
        }
    }
}
