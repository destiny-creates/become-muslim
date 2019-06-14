package com.google.android.gms.internal.ads;

import java.util.List;

public final class aiz extends ajk {
    /* renamed from: d */
    private List<Long> f23661d = null;

    public aiz(ahz ahz, String str, String str2, aaa aaa, int i, int i2) {
        super(ahz, str, str2, aaa, i, 31);
    }

    /* renamed from: a */
    protected final void mo3820a() {
        this.b.f27967p = Long.valueOf(-1);
        this.b.f27968q = Long.valueOf(-1);
        if (this.f23661d == null) {
            this.f23661d = (List) this.c.invoke(null, new Object[]{this.a.m18454a()});
        }
        if (this.f23661d != null && this.f23661d.size() == 2) {
            synchronized (this.b) {
                this.b.f27967p = Long.valueOf(((Long) this.f23661d.get(0)).longValue());
                this.b.f27968q = Long.valueOf(((Long) this.f23661d.get(1)).longValue());
            }
        }
    }
}
