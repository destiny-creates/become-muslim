package com.google.android.gms.internal.ads;

public final class ajg extends ajk {
    public ajg(ahz ahz, String str, String str2, aaa aaa, int i, int i2) {
        super(ahz, str, str2, aaa, i, 48);
    }

    /* renamed from: a */
    protected final void mo3820a() {
        this.b.f27932E = Integer.valueOf(2);
        boolean booleanValue = ((Boolean) this.c.invoke(null, new Object[]{this.a.m18454a()})).booleanValue();
        synchronized (this.b) {
            aaa aaa;
            Integer valueOf;
            if (booleanValue) {
                aaa = this.b;
                valueOf = Integer.valueOf(1);
            } else {
                aaa = this.b;
                valueOf = Integer.valueOf(0);
            }
            aaa.f27932E = valueOf;
        }
    }
}
