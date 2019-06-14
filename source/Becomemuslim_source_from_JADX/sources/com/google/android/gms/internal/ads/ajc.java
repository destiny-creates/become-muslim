package com.google.android.gms.internal.ads;

public final class ajc extends ajk {
    /* renamed from: d */
    private final StackTraceElement[] f23663d;

    public ajc(ahz ahz, String str, String str2, aaa aaa, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(ahz, str, str2, aaa, i, 45);
        this.f23663d = stackTraceElementArr;
    }

    /* renamed from: a */
    protected final void mo3820a() {
        if (this.f23663d != null) {
            ahx ahx = new ahx((String) this.c.invoke(null, new Object[]{this.f23663d}));
            synchronized (this.b) {
                this.b.f27929B = ahx.f23619a;
                if (ahx.f23620b.booleanValue()) {
                    this.b.f27937J = Integer.valueOf(ahx.f23621c.booleanValue() ^ 1);
                }
            }
        }
    }
}
