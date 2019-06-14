package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.ax;

@cm
public final class lx {
    /* renamed from: a */
    private long f15771a;
    /* renamed from: b */
    private long f15772b = Long.MIN_VALUE;
    /* renamed from: c */
    private Object f15773c = new Object();

    public lx(long j) {
        this.f15771a = j;
    }

    /* renamed from: a */
    public final boolean m19842a() {
        synchronized (this.f15773c) {
            long b = ax.l().b();
            if (this.f15772b + this.f15771a > b) {
                return false;
            }
            this.f15772b = b;
            return true;
        }
    }
}
