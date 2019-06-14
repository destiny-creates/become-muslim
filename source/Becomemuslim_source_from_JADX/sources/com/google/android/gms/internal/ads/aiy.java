package com.google.android.gms.internal.ads;

public final class aiy extends ajk {
    public aiy(ahz ahz, String str, String str2, aaa aaa, int i, int i2) {
        super(ahz, str, str2, aaa, i, 3);
    }

    /* renamed from: a */
    protected final void mo3820a() {
        synchronized (this.b) {
            ahm ahm = new ahm((String) this.c.invoke(null, new Object[]{this.a.m18454a()}));
            synchronized (this.b) {
                this.b.f27954c = Long.valueOf(ahm.f23608a);
                this.b.f27942O = Long.valueOf(ahm.f23609b);
            }
        }
    }
}
