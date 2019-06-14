package com.google.android.gms.p185e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;

/* renamed from: com.google.android.gms.e.dy */
final class dy extends dx {
    /* renamed from: a */
    private static final Object f11693a = new Object();
    /* renamed from: n */
    private static dy f11694n;
    /* renamed from: b */
    private Context f11695b;
    /* renamed from: c */
    private bc f11696c;
    /* renamed from: d */
    private volatile ay f11697d;
    /* renamed from: e */
    private int f11698e = 1800000;
    /* renamed from: f */
    private boolean f11699f = true;
    /* renamed from: g */
    private boolean f11700g = false;
    /* renamed from: h */
    private boolean f11701h = true;
    /* renamed from: i */
    private boolean f11702i = true;
    /* renamed from: j */
    private bd f11703j = new dz(this);
    /* renamed from: k */
    private eb f11704k;
    /* renamed from: l */
    private bx f11705l;
    /* renamed from: m */
    private boolean f11706m = false;

    /* renamed from: c */
    public static dy m14545c() {
        if (f11694n == null) {
            f11694n = new dy();
        }
        return f11694n;
    }

    private dy() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    final synchronized void m14551a(android.content.Context r2, com.google.android.gms.p185e.ay r3) {
        /*
        r1 = this;
        monitor-enter(r1);
        r0 = r1.f11695b;	 Catch:{ all -> 0x0015 }
        if (r0 == 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r1);
        return;
    L_0x0007:
        r2 = r2.getApplicationContext();	 Catch:{ all -> 0x0015 }
        r1.f11695b = r2;	 Catch:{ all -> 0x0015 }
        r2 = r1.f11697d;	 Catch:{ all -> 0x0015 }
        if (r2 != 0) goto L_0x0013;
    L_0x0011:
        r1.f11697d = r3;	 Catch:{ all -> 0x0015 }
    L_0x0013:
        monitor-exit(r1);
        return;
    L_0x0015:
        r2 = move-exception;
        monitor-exit(r1);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.e.dy.a(android.content.Context, com.google.android.gms.e.ay):void");
    }

    /* renamed from: d */
    final synchronized bc m14555d() {
        if (this.f11696c == null) {
            if (this.f11695b != null) {
                this.f11696c = new cm(this.f11703j, this.f11695b);
            } else {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
        }
        if (this.f11704k == null) {
            this.f11704k = new ec();
            if (this.f11698e > 0) {
                this.f11704k.mo2554a((long) this.f11698e);
            }
        }
        this.f11700g = true;
        if (this.f11699f) {
            mo2549a();
            this.f11699f = false;
        }
        if (this.f11705l == null && this.f11702i) {
            this.f11705l = new bx(this);
            BroadcastReceiver broadcastReceiver = this.f11705l;
            Context context = this.f11695b;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            context.registerReceiver(broadcastReceiver, intentFilter);
            intentFilter = new IntentFilter();
            intentFilter.addAction("com.google.analytics.RADIO_POWERED");
            intentFilter.addCategory(context.getPackageName());
            context.registerReceiver(broadcastReceiver, intentFilter);
        }
        return this.f11696c;
    }

    /* renamed from: a */
    public final synchronized void mo2549a() {
        if (this.f11700g) {
            this.f11697d.mo2508a(new ea(this));
            return;
        }
        bs.m8588e("Dispatch call queued. Dispatch will run once initialization is complete.");
        this.f11699f = true;
    }

    /* renamed from: a */
    final synchronized void m14553a(boolean z, boolean z2) {
        boolean f = m14549f();
        this.f11706m = z;
        this.f11701h = z2;
        if (m14549f() != f) {
            if (m14549f()) {
                this.f11704k.mo2555b();
                bs.m8588e("PowerSaveMode initiated.");
                return;
            }
            this.f11704k.mo2554a((long) this.f11698e);
            bs.m8588e("PowerSaveMode terminated.");
        }
    }

    /* renamed from: a */
    public final synchronized void mo2550a(boolean z) {
        m14553a(this.f11706m, z);
    }

    /* renamed from: b */
    public final synchronized void mo2551b() {
        if (!m14549f()) {
            this.f11704k.mo2553a();
        }
    }

    /* renamed from: f */
    private final boolean m14549f() {
        if (!this.f11706m && this.f11701h) {
            if (this.f11698e > 0) {
                return false;
            }
        }
        return true;
    }
}
