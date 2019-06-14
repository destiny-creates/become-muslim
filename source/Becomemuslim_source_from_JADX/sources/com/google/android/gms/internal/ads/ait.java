package com.google.android.gms.internal.ads;

public final class ait extends ajk {
    public ait(ahz ahz, String str, String str2, aaa aaa, int i, int i2) {
        super(ahz, str, str2, aaa, i, 24);
    }

    /* renamed from: c */
    private final void m29963c() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.a;
        r0 = r0.m18470m();
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r0 = r0.getInfo();	 Catch:{ IOException -> 0x0038 }
        r1 = r0.getId();	 Catch:{ IOException -> 0x0038 }
        r1 = com.google.android.gms.internal.ads.aih.m18479a(r1);	 Catch:{ IOException -> 0x0038 }
        if (r1 == 0) goto L_0x0038;	 Catch:{ IOException -> 0x0038 }
    L_0x0017:
        r2 = r4.b;	 Catch:{ IOException -> 0x0038 }
        monitor-enter(r2);	 Catch:{ IOException -> 0x0038 }
        r3 = r4.b;	 Catch:{ all -> 0x0035 }
        r3.f27947T = r1;	 Catch:{ all -> 0x0035 }
        r1 = r4.b;	 Catch:{ all -> 0x0035 }
        r0 = r0.isLimitAdTrackingEnabled();	 Catch:{ all -> 0x0035 }
        r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ all -> 0x0035 }
        r1.f27949V = r0;	 Catch:{ all -> 0x0035 }
        r0 = r4.b;	 Catch:{ all -> 0x0035 }
        r1 = 5;	 Catch:{ all -> 0x0035 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ all -> 0x0035 }
        r0.f27948U = r1;	 Catch:{ all -> 0x0035 }
        monitor-exit(r2);	 Catch:{ all -> 0x0035 }
        return;	 Catch:{ all -> 0x0035 }
    L_0x0035:
        r0 = move-exception;	 Catch:{ all -> 0x0035 }
        monitor-exit(r2);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ IOException -> 0x0038 }
    L_0x0038:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ait.c():void");
    }

    /* renamed from: a */
    protected final void mo3820a() {
        if (this.a.m18464g()) {
            m29963c();
            return;
        }
        synchronized (this.b) {
            this.b.f27947T = (String) this.c.invoke(null, new Object[]{this.a.m18454a()});
        }
    }

    /* renamed from: b */
    public final Void mo3821b() {
        if (this.a.m18459b()) {
            return super.mo3821b();
        }
        if (this.a.m18464g()) {
            m29963c();
        }
        return null;
    }

    public final /* synthetic */ Object call() {
        return mo3821b();
    }
}
