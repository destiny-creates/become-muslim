package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.ax;

final class ja {
    /* renamed from: a */
    private final Object f15637a;
    /* renamed from: b */
    private volatile int f15638b;
    /* renamed from: c */
    private volatile long f15639c;

    private ja() {
        this.f15637a = new Object();
        this.f15638b = jb.f15640a;
        this.f15639c = 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private final void m19586a(int r5, int r6) {
        /*
        r4 = this;
        r4.m19587d();
        r0 = com.google.android.gms.ads.internal.ax.l();
        r0 = r0.a();
        r2 = r4.f15637a;
        monitor-enter(r2);
        r3 = r4.f15638b;	 Catch:{ all -> 0x0020 }
        if (r3 == r5) goto L_0x0014;
    L_0x0012:
        monitor-exit(r2);	 Catch:{ all -> 0x0020 }
        return;
    L_0x0014:
        r4.f15638b = r6;	 Catch:{ all -> 0x0020 }
        r5 = r4.f15638b;	 Catch:{ all -> 0x0020 }
        r6 = com.google.android.gms.internal.ads.jb.f15642c;	 Catch:{ all -> 0x0020 }
        if (r5 != r6) goto L_0x001e;
    L_0x001c:
        r4.f15639c = r0;	 Catch:{ all -> 0x0020 }
    L_0x001e:
        monitor-exit(r2);	 Catch:{ all -> 0x0020 }
        return;
    L_0x0020:
        r5 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0020 }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ja.a(int, int):void");
    }

    /* renamed from: d */
    private final void m19587d() {
        long a = ax.l().a();
        synchronized (this.f15637a) {
            if (this.f15638b == jb.f15642c) {
                if (this.f15639c + ((Long) aph.m18688f().m18889a(asp.di)).longValue() <= a) {
                    this.f15638b = jb.f15640a;
                }
            }
        }
    }

    /* renamed from: a */
    public final void m19588a(boolean z) {
        int i;
        int i2;
        if (z) {
            i = jb.f15640a;
            i2 = jb.f15641b;
        } else {
            i = jb.f15641b;
            i2 = jb.f15640a;
        }
        m19586a(i, i2);
    }

    /* renamed from: a */
    public final boolean m19589a() {
        m19587d();
        return this.f15638b == jb.f15641b;
    }

    /* renamed from: b */
    public final boolean m19590b() {
        m19587d();
        return this.f15638b == jb.f15642c;
    }

    /* renamed from: c */
    public final void m19591c() {
        m19586a(jb.f15641b, jb.f15642c);
    }
}
