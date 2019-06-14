package com.google.android.gms.internal.p210i;

import android.content.ComponentName;
import android.content.ServiceConnection;
import com.google.android.gms.common.internal.C2872v;

/* renamed from: com.google.android.gms.internal.i.w */
public final class C5012w implements ServiceConnection {
    /* renamed from: a */
    final /* synthetic */ C7818u f16840a;
    /* renamed from: b */
    private volatile bh f16841b;
    /* renamed from: c */
    private volatile boolean f16842c;

    protected C5012w(C7818u c7818u) {
        this.f16840a = c7818u;
    }

    /* renamed from: a */
    public final com.google.android.gms.internal.p210i.bh m21085a() {
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
        r6 = this;
        com.google.android.gms.analytics.C2721s.d();
        r0 = new android.content.Intent;
        r1 = "com.google.android.gms.analytics.service.START";
        r0.<init>(r1);
        r1 = new android.content.ComponentName;
        r2 = "com.google.android.gms";
        r3 = "com.google.android.gms.analytics.service.AnalyticsService";
        r1.<init>(r2, r3);
        r0.setComponent(r1);
        r1 = r6.f16840a;
        r1 = r1.m21044k();
        r2 = "app_package_name";
        r3 = r1.getPackageName();
        r0.putExtra(r2, r3);
        r2 = com.google.android.gms.common.stats.C2882a.a();
        monitor-enter(r6);
        r3 = 0;
        r6.f16841b = r3;	 Catch:{ all -> 0x0076 }
        r4 = 1;	 Catch:{ all -> 0x0076 }
        r6.f16842c = r4;	 Catch:{ all -> 0x0076 }
        r4 = r6.f16840a;	 Catch:{ all -> 0x0076 }
        r4 = r4.f28916a;	 Catch:{ all -> 0x0076 }
        r5 = 129; // 0x81 float:1.81E-43 double:6.37E-322;	 Catch:{ all -> 0x0076 }
        r0 = r2.a(r1, r0, r4, r5);	 Catch:{ all -> 0x0076 }
        r1 = r6.f16840a;	 Catch:{ all -> 0x0076 }
        r2 = "Bind to service requested";	 Catch:{ all -> 0x0076 }
        r4 = java.lang.Boolean.valueOf(r0);	 Catch:{ all -> 0x0076 }
        r1.m21026a(r2, r4);	 Catch:{ all -> 0x0076 }
        r1 = 0;	 Catch:{ all -> 0x0076 }
        if (r0 != 0) goto L_0x004e;	 Catch:{ all -> 0x0076 }
    L_0x004a:
        r6.f16842c = r1;	 Catch:{ all -> 0x0076 }
        monitor-exit(r6);	 Catch:{ all -> 0x0076 }
        return r3;
    L_0x004e:
        r0 = com.google.android.gms.internal.p210i.ba.f16365B;	 Catch:{ InterruptedException -> 0x005e }
        r0 = r0.m20315a();	 Catch:{ InterruptedException -> 0x005e }
        r0 = (java.lang.Long) r0;	 Catch:{ InterruptedException -> 0x005e }
        r4 = r0.longValue();	 Catch:{ InterruptedException -> 0x005e }
        r6.wait(r4);	 Catch:{ InterruptedException -> 0x005e }
        goto L_0x0065;
    L_0x005e:
        r0 = r6.f16840a;	 Catch:{ all -> 0x0076 }
        r2 = "Wait for service connect was interrupted";	 Catch:{ all -> 0x0076 }
        r0.m21040h(r2);	 Catch:{ all -> 0x0076 }
    L_0x0065:
        r6.f16842c = r1;	 Catch:{ all -> 0x0076 }
        r0 = r6.f16841b;	 Catch:{ all -> 0x0076 }
        r6.f16841b = r3;	 Catch:{ all -> 0x0076 }
        if (r0 != 0) goto L_0x0074;	 Catch:{ all -> 0x0076 }
    L_0x006d:
        r1 = r6.f16840a;	 Catch:{ all -> 0x0076 }
        r2 = "Successfully bound to service but never got onServiceConnected callback";	 Catch:{ all -> 0x0076 }
        r1.m21042i(r2);	 Catch:{ all -> 0x0076 }
    L_0x0074:
        monitor-exit(r6);	 Catch:{ all -> 0x0076 }
        return r0;	 Catch:{ all -> 0x0076 }
    L_0x0076:
        r0 = move-exception;	 Catch:{ all -> 0x0076 }
        monitor-exit(r6);	 Catch:{ all -> 0x0076 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.w.a():com.google.android.gms.internal.i.bh");
    }

    public final void onServiceConnected(android.content.ComponentName r3, android.os.IBinder r4) {
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
        r2 = this;
        r3 = "AnalyticsServiceConnection.onServiceConnected";
        com.google.android.gms.common.internal.C2872v.b(r3);
        monitor-enter(r2);
        if (r4 != 0) goto L_0x0017;
    L_0x0008:
        r3 = r2.f16840a;	 Catch:{ all -> 0x0014 }
        r4 = "Service connected with null binder";	 Catch:{ all -> 0x0014 }
        r3.m21042i(r4);	 Catch:{ all -> 0x0014 }
        r2.notifyAll();	 Catch:{ all -> 0x008d }
        monitor-exit(r2);	 Catch:{ all -> 0x008d }
        return;
    L_0x0014:
        r3 = move-exception;
        goto L_0x0089;
    L_0x0017:
        r3 = 0;
        r0 = r4.getInterfaceDescriptor();	 Catch:{ RemoteException -> 0x004b }
        r1 = "com.google.android.gms.analytics.internal.IAnalyticsService";	 Catch:{ RemoteException -> 0x004b }
        r1 = r1.equals(r0);	 Catch:{ RemoteException -> 0x004b }
        if (r1 == 0) goto L_0x0043;	 Catch:{ RemoteException -> 0x004b }
    L_0x0024:
        if (r4 != 0) goto L_0x0027;	 Catch:{ RemoteException -> 0x004b }
    L_0x0026:
        goto L_0x003b;	 Catch:{ RemoteException -> 0x004b }
    L_0x0027:
        r0 = "com.google.android.gms.analytics.internal.IAnalyticsService";	 Catch:{ RemoteException -> 0x004b }
        r0 = r4.queryLocalInterface(r0);	 Catch:{ RemoteException -> 0x004b }
        r1 = r0 instanceof com.google.android.gms.internal.p210i.bh;	 Catch:{ RemoteException -> 0x004b }
        if (r1 == 0) goto L_0x0035;	 Catch:{ RemoteException -> 0x004b }
    L_0x0031:
        r0 = (com.google.android.gms.internal.p210i.bh) r0;	 Catch:{ RemoteException -> 0x004b }
    L_0x0033:
        r3 = r0;	 Catch:{ RemoteException -> 0x004b }
        goto L_0x003b;	 Catch:{ RemoteException -> 0x004b }
    L_0x0035:
        r0 = new com.google.android.gms.internal.i.bi;	 Catch:{ RemoteException -> 0x004b }
        r0.<init>(r4);	 Catch:{ RemoteException -> 0x004b }
        goto L_0x0033;	 Catch:{ RemoteException -> 0x004b }
    L_0x003b:
        r4 = r2.f16840a;	 Catch:{ RemoteException -> 0x004b }
        r0 = "Bound to IAnalyticsService interface";	 Catch:{ RemoteException -> 0x004b }
        r4.m21036e(r0);	 Catch:{ RemoteException -> 0x004b }
        goto L_0x0052;	 Catch:{ RemoteException -> 0x004b }
    L_0x0043:
        r4 = r2.f16840a;	 Catch:{ RemoteException -> 0x004b }
        r1 = "Got binder with a wrong descriptor";	 Catch:{ RemoteException -> 0x004b }
        r4.m21037e(r1, r0);	 Catch:{ RemoteException -> 0x004b }
        goto L_0x0052;
    L_0x004b:
        r4 = r2.f16840a;	 Catch:{ all -> 0x0014 }
        r0 = "Service connect failed to get IAnalyticsService";	 Catch:{ all -> 0x0014 }
        r4.m21042i(r0);	 Catch:{ all -> 0x0014 }
    L_0x0052:
        if (r3 != 0) goto L_0x0068;
    L_0x0054:
        r3 = com.google.android.gms.common.stats.C2882a.a();	 Catch:{ IllegalArgumentException -> 0x0084 }
        r4 = r2.f16840a;	 Catch:{ IllegalArgumentException -> 0x0084 }
        r4 = r4.m21044k();	 Catch:{ IllegalArgumentException -> 0x0084 }
        r0 = r2.f16840a;	 Catch:{ IllegalArgumentException -> 0x0084 }
        r0 = r0.f28916a;	 Catch:{ IllegalArgumentException -> 0x0084 }
        r3.a(r4, r0);	 Catch:{ IllegalArgumentException -> 0x0084 }
        goto L_0x0084;
    L_0x0068:
        r4 = r2.f16842c;	 Catch:{ all -> 0x0014 }
        if (r4 != 0) goto L_0x0082;	 Catch:{ all -> 0x0014 }
    L_0x006c:
        r4 = r2.f16840a;	 Catch:{ all -> 0x0014 }
        r0 = "onServiceConnected received after the timeout limit";	 Catch:{ all -> 0x0014 }
        r4.m21040h(r0);	 Catch:{ all -> 0x0014 }
        r4 = r2.f16840a;	 Catch:{ all -> 0x0014 }
        r4 = r4.m21047n();	 Catch:{ all -> 0x0014 }
        r0 = new com.google.android.gms.internal.i.x;	 Catch:{ all -> 0x0014 }
        r0.<init>(r2, r3);	 Catch:{ all -> 0x0014 }
        r4.a(r0);	 Catch:{ all -> 0x0014 }
        goto L_0x0084;	 Catch:{ all -> 0x0014 }
    L_0x0082:
        r2.f16841b = r3;	 Catch:{ all -> 0x0014 }
    L_0x0084:
        r2.notifyAll();	 Catch:{ all -> 0x008d }
        monitor-exit(r2);	 Catch:{ all -> 0x008d }
        return;	 Catch:{ all -> 0x008d }
    L_0x0089:
        r2.notifyAll();	 Catch:{ all -> 0x008d }
        throw r3;	 Catch:{ all -> 0x008d }
    L_0x008d:
        r3 = move-exception;	 Catch:{ all -> 0x008d }
        monitor-exit(r2);	 Catch:{ all -> 0x008d }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.w.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        C2872v.b("AnalyticsServiceConnection.onServiceDisconnected");
        this.f16840a.m21047n().a(new C5014y(this, componentName));
    }
}
