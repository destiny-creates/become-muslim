package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.ads.internal.ax;

@cm
public final class ami {
    /* renamed from: a */
    private final Runnable f14760a = new amj(this);
    /* renamed from: b */
    private final Object f14761b = new Object();
    /* renamed from: c */
    private amp f14762c;
    /* renamed from: d */
    private Context f14763d;
    /* renamed from: e */
    private amt f14764e;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private final void m18632b() {
        /*
        r6 = this;
        r0 = r6.f14761b;
        monitor-enter(r0);
        r1 = r6.f14763d;	 Catch:{ all -> 0x0030 }
        if (r1 == 0) goto L_0x002e;
    L_0x0007:
        r1 = r6.f14762c;	 Catch:{ all -> 0x0030 }
        if (r1 == 0) goto L_0x000c;
    L_0x000b:
        goto L_0x002e;
    L_0x000c:
        r1 = new com.google.android.gms.internal.ads.aml;	 Catch:{ all -> 0x0030 }
        r1.<init>(r6);	 Catch:{ all -> 0x0030 }
        r2 = new com.google.android.gms.internal.ads.amm;	 Catch:{ all -> 0x0030 }
        r2.<init>(r6);	 Catch:{ all -> 0x0030 }
        r3 = new com.google.android.gms.internal.ads.amp;	 Catch:{ all -> 0x0030 }
        r4 = r6.f14763d;	 Catch:{ all -> 0x0030 }
        r5 = com.google.android.gms.ads.internal.ax.t();	 Catch:{ all -> 0x0030 }
        r5 = r5.m19837a();	 Catch:{ all -> 0x0030 }
        r3.<init>(r4, r5, r1, r2);	 Catch:{ all -> 0x0030 }
        r6.f14762c = r3;	 Catch:{ all -> 0x0030 }
        r1 = r6.f14762c;	 Catch:{ all -> 0x0030 }
        r1.q();	 Catch:{ all -> 0x0030 }
        monitor-exit(r0);	 Catch:{ all -> 0x0030 }
        return;
    L_0x002e:
        monitor-exit(r0);	 Catch:{ all -> 0x0030 }
        return;
    L_0x0030:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0030 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ami.b():void");
    }

    /* renamed from: c */
    private final void m18635c() {
        synchronized (this.f14761b) {
            if (this.f14762c == null) {
                return;
            }
            if (this.f14762c.h() || this.f14762c.i()) {
                this.f14762c.g();
            }
            this.f14762c = null;
            this.f14764e = null;
            Binder.flushPendingCommands();
        }
    }

    /* renamed from: a */
    public final amn m18637a(amq amq) {
        synchronized (this.f14761b) {
            if (this.f14764e == null) {
                amn amn = new amn();
                return amn;
            }
            try {
                amn = this.f14764e.mo3847a(amq);
                return amn;
            } catch (Throwable e) {
                mt.m19919b("Unable to call into cache service.", e);
                return new amn();
            }
        }
    }

    /* renamed from: a */
    public final void m18638a() {
        if (((Boolean) aph.m18688f().m18889a(asp.cF)).booleanValue()) {
            synchronized (this.f14761b) {
                m18632b();
                ax.e();
                jw.f15691a.removeCallbacks(this.f14760a);
                ax.e();
                jw.f15691a.postDelayed(this.f14760a, ((Long) aph.m18688f().m18889a(asp.cG)).longValue());
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void m18639a(android.content.Context r3) {
        /*
        r2 = this;
        if (r3 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0 = r2.f14761b;
        monitor-enter(r0);
        r1 = r2.f14763d;	 Catch:{ all -> 0x0048 }
        if (r1 == 0) goto L_0x000c;
    L_0x000a:
        monitor-exit(r0);	 Catch:{ all -> 0x0048 }
        return;
    L_0x000c:
        r3 = r3.getApplicationContext();	 Catch:{ all -> 0x0048 }
        r2.f14763d = r3;	 Catch:{ all -> 0x0048 }
        r3 = com.google.android.gms.internal.ads.asp.cE;	 Catch:{ all -> 0x0048 }
        r1 = com.google.android.gms.internal.ads.aph.m18688f();	 Catch:{ all -> 0x0048 }
        r3 = r1.m18889a(r3);	 Catch:{ all -> 0x0048 }
        r3 = (java.lang.Boolean) r3;	 Catch:{ all -> 0x0048 }
        r3 = r3.booleanValue();	 Catch:{ all -> 0x0048 }
        if (r3 == 0) goto L_0x0028;
    L_0x0024:
        r2.m18632b();	 Catch:{ all -> 0x0048 }
        goto L_0x0046;
    L_0x0028:
        r3 = com.google.android.gms.internal.ads.asp.cD;	 Catch:{ all -> 0x0048 }
        r1 = com.google.android.gms.internal.ads.aph.m18688f();	 Catch:{ all -> 0x0048 }
        r3 = r1.m18889a(r3);	 Catch:{ all -> 0x0048 }
        r3 = (java.lang.Boolean) r3;	 Catch:{ all -> 0x0048 }
        r3 = r3.booleanValue();	 Catch:{ all -> 0x0048 }
        if (r3 == 0) goto L_0x0046;
    L_0x003a:
        r3 = new com.google.android.gms.internal.ads.amk;	 Catch:{ all -> 0x0048 }
        r3.<init>(r2);	 Catch:{ all -> 0x0048 }
        r1 = com.google.android.gms.ads.internal.ax.h();	 Catch:{ all -> 0x0048 }
        r1.m18586a(r3);	 Catch:{ all -> 0x0048 }
    L_0x0046:
        monitor-exit(r0);	 Catch:{ all -> 0x0048 }
        return;
    L_0x0048:
        r3 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0048 }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ami.a(android.content.Context):void");
    }
}
