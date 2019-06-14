package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.C2859l.C2858a;
import java.util.HashSet;
import java.util.Set;

final class au implements ServiceConnection {
    /* renamed from: a */
    private final Set<ServiceConnection> f7237a = new HashSet();
    /* renamed from: b */
    private int f7238b = 2;
    /* renamed from: c */
    private boolean f7239c;
    /* renamed from: d */
    private IBinder f7240d;
    /* renamed from: e */
    private final C2858a f7241e;
    /* renamed from: f */
    private ComponentName f7242f;
    /* renamed from: g */
    private final /* synthetic */ at f7243g;

    public au(at atVar, C2858a c2858a) {
        this.f7243g = atVar;
        this.f7241e = c2858a;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f7243g.f11583a) {
            this.f7243g.f11585c.removeMessages(1, this.f7241e);
            this.f7240d = iBinder;
            this.f7242f = componentName;
            for (ServiceConnection onServiceConnected : this.f7237a) {
                onServiceConnected.onServiceConnected(componentName, iBinder);
            }
            this.f7238b = 1;
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f7243g.f11583a) {
            this.f7243g.f11585c.removeMessages(1, this.f7241e);
            this.f7240d = null;
            this.f7242f = componentName;
            for (ServiceConnection onServiceDisconnected : this.f7237a) {
                onServiceDisconnected.onServiceDisconnected(componentName);
            }
            this.f7238b = 2;
        }
    }

    /* renamed from: a */
    public final void m8218a(java.lang.String r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r7 = this;
        r0 = 3;
        r7.f7238b = r0;
        r0 = r7.f7243g;
        r1 = r0.f11586d;
        r0 = r7.f7243g;
        r2 = r0.f11584b;
        r0 = r7.f7241e;
        r3 = r7.f7243g;
        r3 = r3.f11584b;
        r4 = r0.m8352a(r3);
        r0 = r7.f7241e;
        r6 = r0.m8355c();
        r3 = r8;
        r5 = r7;
        r8 = r1.m8410a(r2, r3, r4, r5, r6);
        r7.f7239c = r8;
        r8 = r7.f7239c;
        if (r8 == 0) goto L_0x004a;
    L_0x002d:
        r8 = r7.f7243g;
        r8 = r8.f11585c;
        r0 = 1;
        r1 = r7.f7241e;
        r8 = r8.obtainMessage(r0, r1);
        r0 = r7.f7243g;
        r0 = r0.f11585c;
        r1 = r7.f7243g;
        r1 = r1.f11588f;
        r0.sendMessageDelayed(r8, r1);
        return;
    L_0x004a:
        r8 = 2;
        r7.f7238b = r8;
        r8 = r7.f7243g;	 Catch:{ IllegalArgumentException -> 0x005d }
        r8 = r8.f11586d;	 Catch:{ IllegalArgumentException -> 0x005d }
        r0 = r7.f7243g;	 Catch:{ IllegalArgumentException -> 0x005d }
        r0 = r0.f11584b;	 Catch:{ IllegalArgumentException -> 0x005d }
        r8.m8408a(r0, r7);	 Catch:{ IllegalArgumentException -> 0x005d }
        return;
    L_0x005d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.au.a(java.lang.String):void");
    }

    /* renamed from: b */
    public final void m8223b(String str) {
        this.f7243g.f11585c.removeMessages(1, this.f7241e);
        this.f7243g.f11586d.m8408a(this.f7243g.f11584b, this);
        this.f7239c = null;
        this.f7238b = 2;
    }

    /* renamed from: a */
    public final void m8217a(ServiceConnection serviceConnection, String str) {
        this.f7243g.f11586d;
        this.f7243g.f11584b;
        this.f7241e.m8352a(this.f7243g.f11584b);
        this.f7237a.add(serviceConnection);
    }

    /* renamed from: b */
    public final void m8222b(ServiceConnection serviceConnection, String str) {
        this.f7243g.f11586d;
        this.f7243g.f11584b;
        this.f7237a.remove(serviceConnection);
    }

    /* renamed from: a */
    public final boolean m8219a() {
        return this.f7239c;
    }

    /* renamed from: b */
    public final int m8221b() {
        return this.f7238b;
    }

    /* renamed from: a */
    public final boolean m8220a(ServiceConnection serviceConnection) {
        return this.f7237a.contains(serviceConnection);
    }

    /* renamed from: c */
    public final boolean m8224c() {
        return this.f7237a.isEmpty();
    }

    /* renamed from: d */
    public final IBinder m8225d() {
        return this.f7240d;
    }

    /* renamed from: e */
    public final ComponentName m8226e() {
        return this.f7242f;
    }
}
