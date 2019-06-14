package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.util.C2904o;

@cm
public final class alk {
    /* renamed from: a */
    private final Object f14693a = new Object();
    /* renamed from: b */
    private all f14694b = null;
    /* renamed from: c */
    private boolean f14695c = false;

    /* renamed from: a */
    public final Activity m18584a() {
        synchronized (this.f14693a) {
            if (!C2904o.b()) {
                return null;
            } else if (this.f14694b != null) {
                Activity a = this.f14694b.m18594a();
                return a;
            } else {
                return null;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void m18585a(android.content.Context r5) {
        /*
        r4 = this;
        r0 = r4.f14693a;
        monitor-enter(r0);
        r1 = r4.f14695c;	 Catch:{ all -> 0x0050 }
        if (r1 != 0) goto L_0x004e;
    L_0x0007:
        r1 = com.google.android.gms.common.util.C2904o.b();	 Catch:{ all -> 0x0050 }
        if (r1 != 0) goto L_0x000f;
    L_0x000d:
        monitor-exit(r0);	 Catch:{ all -> 0x0050 }
        return;
    L_0x000f:
        r1 = com.google.android.gms.internal.ads.asp.aG;	 Catch:{ all -> 0x0050 }
        r2 = com.google.android.gms.internal.ads.aph.m18688f();	 Catch:{ all -> 0x0050 }
        r1 = r2.m18889a(r1);	 Catch:{ all -> 0x0050 }
        r1 = (java.lang.Boolean) r1;	 Catch:{ all -> 0x0050 }
        r1 = r1.booleanValue();	 Catch:{ all -> 0x0050 }
        if (r1 != 0) goto L_0x0023;
    L_0x0021:
        monitor-exit(r0);	 Catch:{ all -> 0x0050 }
        return;
    L_0x0023:
        r1 = 0;
        r2 = r5.getApplicationContext();	 Catch:{ all -> 0x0050 }
        if (r2 != 0) goto L_0x002b;
    L_0x002a:
        r2 = r5;
    L_0x002b:
        r3 = r2 instanceof android.app.Application;	 Catch:{ all -> 0x0050 }
        if (r3 == 0) goto L_0x0032;
    L_0x002f:
        r1 = r2;
        r1 = (android.app.Application) r1;	 Catch:{ all -> 0x0050 }
    L_0x0032:
        if (r1 != 0) goto L_0x003b;
    L_0x0034:
        r5 = "Can not cast Context to Application";
        com.google.android.gms.internal.ads.mt.m19924e(r5);	 Catch:{ all -> 0x0050 }
        monitor-exit(r0);	 Catch:{ all -> 0x0050 }
        return;
    L_0x003b:
        r2 = r4.f14694b;	 Catch:{ all -> 0x0050 }
        if (r2 != 0) goto L_0x0046;
    L_0x003f:
        r2 = new com.google.android.gms.internal.ads.all;	 Catch:{ all -> 0x0050 }
        r2.<init>();	 Catch:{ all -> 0x0050 }
        r4.f14694b = r2;	 Catch:{ all -> 0x0050 }
    L_0x0046:
        r2 = r4.f14694b;	 Catch:{ all -> 0x0050 }
        r2.m18595a(r1, r5);	 Catch:{ all -> 0x0050 }
        r5 = 1;
        r4.f14695c = r5;	 Catch:{ all -> 0x0050 }
    L_0x004e:
        monitor-exit(r0);	 Catch:{ all -> 0x0050 }
        return;
    L_0x0050:
        r5 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0050 }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.alk.a(android.content.Context):void");
    }

    /* renamed from: a */
    public final void m18586a(aln aln) {
        synchronized (this.f14693a) {
            if (C2904o.b()) {
                if (((Boolean) aph.m18688f().m18889a(asp.aG)).booleanValue()) {
                    if (this.f14694b == null) {
                        this.f14694b = new all();
                    }
                    this.f14694b.m18596a(aln);
                    return;
                }
                return;
            }
        }
    }

    /* renamed from: b */
    public final Context m18587b() {
        synchronized (this.f14693a) {
            if (!C2904o.b()) {
                return null;
            } else if (this.f14694b != null) {
                Context b = this.f14694b.m18597b();
                return b;
            } else {
                return null;
            }
        }
    }
}
