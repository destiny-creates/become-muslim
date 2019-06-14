package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.ConditionVariable;

@cm
public final class asn {
    /* renamed from: a */
    private final Object f14903a = new Object();
    /* renamed from: b */
    private final ConditionVariable f14904b = new ConditionVariable();
    /* renamed from: c */
    private volatile boolean f14905c = false;
    /* renamed from: d */
    private SharedPreferences f14906d = null;
    /* renamed from: e */
    private Context f14907e;

    /* renamed from: a */
    public final <T> T m18889a(asf<T> asf) {
        if (this.f14904b.block(5000)) {
            if (!this.f14905c || this.f14906d == null) {
                synchronized (this.f14903a) {
                    if (this.f14905c) {
                        if (this.f14906d == null) {
                        }
                    }
                    T b = asf.m18880b();
                    return b;
                }
            }
            return lz.m19845a(this.f14907e, new aso(this, asf));
        }
        throw new IllegalStateException("Flags.initialize() was not called!");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void m18890a(android.content.Context r4) {
        /*
        r3 = this;
        r0 = r3.f14905c;
        if (r0 == 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = r3.f14903a;
        monitor-enter(r0);
        r1 = r3.f14905c;	 Catch:{ all -> 0x0051 }
        if (r1 == 0) goto L_0x000e;
    L_0x000c:
        monitor-exit(r0);	 Catch:{ all -> 0x0051 }
        return;
    L_0x000e:
        r1 = r4.getApplicationContext();	 Catch:{ all -> 0x0051 }
        if (r1 != 0) goto L_0x0016;
    L_0x0014:
        r1 = r4;
        goto L_0x001a;
    L_0x0016:
        r1 = r4.getApplicationContext();	 Catch:{ all -> 0x0051 }
    L_0x001a:
        r3.f14907e = r1;	 Catch:{ all -> 0x0051 }
        r1 = com.google.android.gms.common.C2832i.getRemoteContext(r4);	 Catch:{ all -> 0x004a }
        if (r1 != 0) goto L_0x002b;
    L_0x0022:
        if (r4 == 0) goto L_0x002b;
    L_0x0024:
        r1 = r4.getApplicationContext();	 Catch:{ all -> 0x004a }
        if (r1 != 0) goto L_0x002b;
    L_0x002a:
        r1 = r4;
    L_0x002b:
        if (r1 != 0) goto L_0x0034;
    L_0x002d:
        r4 = r3.f14904b;	 Catch:{ all -> 0x0051 }
        r4.open();	 Catch:{ all -> 0x0051 }
        monitor-exit(r0);	 Catch:{ all -> 0x0051 }
        return;
    L_0x0034:
        com.google.android.gms.internal.ads.aph.m18686d();	 Catch:{ all -> 0x004a }
        r4 = "google_ads_flags";
        r2 = 0;
        r4 = r1.getSharedPreferences(r4, r2);	 Catch:{ all -> 0x004a }
        r3.f14906d = r4;	 Catch:{ all -> 0x004a }
        r4 = 1;
        r3.f14905c = r4;	 Catch:{ all -> 0x004a }
        r4 = r3.f14904b;	 Catch:{ all -> 0x0051 }
        r4.open();	 Catch:{ all -> 0x0051 }
        monitor-exit(r0);	 Catch:{ all -> 0x0051 }
        return;
    L_0x004a:
        r4 = move-exception;
        r1 = r3.f14904b;	 Catch:{ all -> 0x0051 }
        r1.open();	 Catch:{ all -> 0x0051 }
        throw r4;	 Catch:{ all -> 0x0051 }
    L_0x0051:
        r4 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0051 }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.asn.a(android.content.Context):void");
    }
}
