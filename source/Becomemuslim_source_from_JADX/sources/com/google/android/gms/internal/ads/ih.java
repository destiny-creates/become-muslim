package com.google.android.gms.internal.ads;

import android.content.Context;

@cm
public final class ih implements akw {
    /* renamed from: a */
    private final Context f24109a;
    /* renamed from: b */
    private final Object f24110b;
    /* renamed from: c */
    private String f24111c;
    /* renamed from: d */
    private boolean f24112d;

    public ih(Context context, String str) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this.f24109a = context;
        this.f24111c = str;
        this.f24112d = false;
        this.f24110b = new Object();
    }

    /* renamed from: a */
    public final void mo4298a(akv akv) {
        m30815a(akv.f14657a);
    }

    /* renamed from: a */
    public final void m30814a(String str) {
        this.f24111c = str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void m30815a(boolean r4) {
        /*
        r3 = this;
        r0 = com.google.android.gms.ads.internal.ax.B();
        r1 = r3.f24109a;
        r0 = r0.m19541a(r1);
        if (r0 != 0) goto L_0x000d;
    L_0x000c:
        return;
    L_0x000d:
        r0 = r3.f24110b;
        monitor-enter(r0);
        r1 = r3.f24112d;	 Catch:{ all -> 0x003f }
        if (r1 != r4) goto L_0x0016;
    L_0x0014:
        monitor-exit(r0);	 Catch:{ all -> 0x003f }
        return;
    L_0x0016:
        r3.f24112d = r4;	 Catch:{ all -> 0x003f }
        r4 = r3.f24111c;	 Catch:{ all -> 0x003f }
        r4 = android.text.TextUtils.isEmpty(r4);	 Catch:{ all -> 0x003f }
        if (r4 == 0) goto L_0x0022;
    L_0x0020:
        monitor-exit(r0);	 Catch:{ all -> 0x003f }
        return;
    L_0x0022:
        r4 = r3.f24112d;	 Catch:{ all -> 0x003f }
        if (r4 == 0) goto L_0x0032;
    L_0x0026:
        r4 = com.google.android.gms.ads.internal.ax.B();	 Catch:{ all -> 0x003f }
        r1 = r3.f24109a;	 Catch:{ all -> 0x003f }
        r2 = r3.f24111c;	 Catch:{ all -> 0x003f }
        r4.m19538a(r1, r2);	 Catch:{ all -> 0x003f }
        goto L_0x003d;
    L_0x0032:
        r4 = com.google.android.gms.ads.internal.ax.B();	 Catch:{ all -> 0x003f }
        r1 = r3.f24109a;	 Catch:{ all -> 0x003f }
        r2 = r3.f24111c;	 Catch:{ all -> 0x003f }
        r4.m19542b(r1, r2);	 Catch:{ all -> 0x003f }
    L_0x003d:
        monitor-exit(r0);	 Catch:{ all -> 0x003f }
        return;
    L_0x003f:
        r4 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x003f }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ih.a(boolean):void");
    }
}
