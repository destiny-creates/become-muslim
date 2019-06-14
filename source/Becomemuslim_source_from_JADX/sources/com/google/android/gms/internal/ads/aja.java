package com.google.android.gms.internal.ads;

public final class aja extends ajk {
    /* renamed from: d */
    private final boolean f23662d;

    public aja(ahz ahz, String str, String str2, aaa aaa, int i, int i2) {
        super(ahz, str, str2, aaa, i, 61);
        this.f23662d = ahz.m18467j();
    }

    /* renamed from: a */
    protected final void mo3820a() {
        long longValue = ((Long) this.c.invoke(null, new Object[]{this.a.m18454a(), Boolean.valueOf(this.f23662d)})).longValue();
        synchronized (this.b) {
            this.b.f27943P = Long.valueOf(longValue);
        }
    }
}
