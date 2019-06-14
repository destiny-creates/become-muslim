package com.google.android.gms.internal.ads;

public final class ais extends ajk {
    /* renamed from: d */
    private long f23655d;

    public ais(ahz ahz, String str, String str2, aaa aaa, long j, int i, int i2) {
        super(ahz, str, str2, aaa, i, 25);
        this.f23655d = j;
    }

    /* renamed from: a */
    protected final void mo3820a() {
        long longValue = ((Long) this.c.invoke(null, new Object[0])).longValue();
        synchronized (this.b) {
            this.b.f27950W = Long.valueOf(longValue);
            if (this.f23655d != 0) {
                this.b.f27961j = Long.valueOf(longValue - this.f23655d);
                this.b.f27964m = Long.valueOf(this.f23655d);
            }
        }
    }
}
