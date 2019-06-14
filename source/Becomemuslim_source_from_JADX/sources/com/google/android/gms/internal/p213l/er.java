package com.google.android.gms.internal.p213l;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Looper;
import com.google.android.gms.common.C4775b;
import com.google.android.gms.common.internal.C2850d.C2844a;
import com.google.android.gms.common.internal.C2850d.C2845b;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.stats.C2882a;

/* renamed from: com.google.android.gms.internal.l.er */
public final class er implements ServiceConnection, C2844a, C2845b {
    /* renamed from: a */
    final /* synthetic */ ed f24601a;
    /* renamed from: b */
    private volatile boolean f24602b;
    /* renamed from: c */
    private volatile ba f24603c;

    protected er(ed edVar) {
        this.f24601a = edVar;
    }

    /* renamed from: a */
    public final void m32006a() {
        this.f24601a.mo6210d();
        Context n = this.f24601a.mo4752n();
        synchronized (this) {
            if (this.f24602b) {
                this.f24601a.mo4754r().m42579w().m21307a("Connection attempt already in progress");
            } else if (this.f24603c != null) {
                this.f24601a.mo4754r().m42579w().m21307a("Already awaiting connection attempt");
            } else {
                this.f24603c = new ba(n, Looper.getMainLooper(), this, this);
                this.f24601a.mo4754r().m42579w().m21307a("Connecting to remote service");
                this.f24602b = true;
                this.f24603c.q();
            }
        }
    }

    /* renamed from: a */
    public final void m32007a(int i) {
        C2872v.b("MeasurementServiceConnection.onConnectionSuspended");
        this.f24601a.mo4754r().m42578v().m21307a("Service connection suspended");
        this.f24601a.mo4753q().m42612a(new ev(this));
    }

    /* renamed from: a */
    public final void m32008a(Intent intent) {
        this.f24601a.mo6210d();
        Context n = this.f24601a.mo4752n();
        C2882a a = C2882a.a();
        synchronized (this) {
            if (this.f24602b) {
                this.f24601a.mo4754r().m42579w().m21307a("Connection attempt already in progress");
                return;
            }
            this.f24601a.mo4754r().m42579w().m21307a("Using local app measurement service");
            this.f24602b = true;
            a.a(n, intent, this.f24601a.f32820a, 129);
        }
    }

    /* renamed from: a */
    public final void m32009a(android.os.Bundle r4) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r3 = this;
        r4 = "MeasurementServiceConnection.onConnected";
        com.google.android.gms.common.internal.C2872v.b(r4);
        monitor-enter(r3);
        r4 = 0;
        r0 = r3.f24603c;	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        r0 = r0.w();	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        r0 = (com.google.android.gms.internal.p213l.at) r0;	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        r3.f24603c = r4;	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        r1 = r3.f24601a;	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        r1 = r1.mo4753q();	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        r2 = new com.google.android.gms.internal.l.eu;	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        r2.<init>(r3, r0);	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        r1.m42612a(r2);	 Catch:{ DeadObjectException -> 0x0022, DeadObjectException -> 0x0022 }
        goto L_0x0027;
    L_0x0020:
        r4 = move-exception;
        goto L_0x0029;
    L_0x0022:
        r3.f24603c = r4;	 Catch:{ all -> 0x0020 }
        r4 = 0;	 Catch:{ all -> 0x0020 }
        r3.f24602b = r4;	 Catch:{ all -> 0x0020 }
    L_0x0027:
        monitor-exit(r3);	 Catch:{ all -> 0x0020 }
        return;	 Catch:{ all -> 0x0020 }
    L_0x0029:
        monitor-exit(r3);	 Catch:{ all -> 0x0020 }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.l.er.a(android.os.Bundle):void");
    }

    /* renamed from: a */
    public final void m32010a(C4775b c4775b) {
        C2872v.b("MeasurementServiceConnection.onConnectionFailed");
        bb d = this.f24601a.q.m31962d();
        if (d != null) {
            d.m42565i().m21308a("Service connection failed", c4775b);
        }
        synchronized (this) {
            this.f24602b = false;
            this.f24603c = null;
        }
        this.f24601a.mo4753q().m42612a(new ew(this));
    }

    public final void onServiceConnected(android.content.ComponentName r4, android.os.IBinder r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r3 = this;
        r4 = "MeasurementServiceConnection.onServiceConnected";
        com.google.android.gms.common.internal.C2872v.b(r4);
        monitor-enter(r3);
        r4 = 0;
        if (r5 != 0) goto L_0x001f;
    L_0x0009:
        r3.f24602b = r4;	 Catch:{ all -> 0x001c }
        r4 = r3.f24601a;	 Catch:{ all -> 0x001c }
        r4 = r4.mo4754r();	 Catch:{ all -> 0x001c }
        r4 = r4.I_();	 Catch:{ all -> 0x001c }
        r5 = "Service connected with null binder";	 Catch:{ all -> 0x001c }
        r4.m21307a(r5);	 Catch:{ all -> 0x001c }
        monitor-exit(r3);	 Catch:{ all -> 0x001c }
        return;
    L_0x001c:
        r4 = move-exception;
        goto L_0x009a;
    L_0x001f:
        r0 = 0;
        r1 = r5.getInterfaceDescriptor();	 Catch:{ RemoteException -> 0x0063 }
        r2 = "com.google.android.gms.measurement.internal.IMeasurementService";	 Catch:{ RemoteException -> 0x0063 }
        r2 = r2.equals(r1);	 Catch:{ RemoteException -> 0x0063 }
        if (r2 == 0) goto L_0x0053;	 Catch:{ RemoteException -> 0x0063 }
    L_0x002c:
        if (r5 != 0) goto L_0x002f;	 Catch:{ RemoteException -> 0x0063 }
    L_0x002e:
        goto L_0x0043;	 Catch:{ RemoteException -> 0x0063 }
    L_0x002f:
        r1 = "com.google.android.gms.measurement.internal.IMeasurementService";	 Catch:{ RemoteException -> 0x0063 }
        r1 = r5.queryLocalInterface(r1);	 Catch:{ RemoteException -> 0x0063 }
        r2 = r1 instanceof com.google.android.gms.internal.p213l.at;	 Catch:{ RemoteException -> 0x0063 }
        if (r2 == 0) goto L_0x003d;	 Catch:{ RemoteException -> 0x0063 }
    L_0x0039:
        r1 = (com.google.android.gms.internal.p213l.at) r1;	 Catch:{ RemoteException -> 0x0063 }
    L_0x003b:
        r0 = r1;	 Catch:{ RemoteException -> 0x0063 }
        goto L_0x0043;	 Catch:{ RemoteException -> 0x0063 }
    L_0x003d:
        r1 = new com.google.android.gms.internal.l.av;	 Catch:{ RemoteException -> 0x0063 }
        r1.<init>(r5);	 Catch:{ RemoteException -> 0x0063 }
        goto L_0x003b;	 Catch:{ RemoteException -> 0x0063 }
    L_0x0043:
        r5 = r3.f24601a;	 Catch:{ RemoteException -> 0x0063 }
        r5 = r5.mo4754r();	 Catch:{ RemoteException -> 0x0063 }
        r5 = r5.m42579w();	 Catch:{ RemoteException -> 0x0063 }
        r1 = "Bound to IMeasurementService interface";	 Catch:{ RemoteException -> 0x0063 }
        r5.m21307a(r1);	 Catch:{ RemoteException -> 0x0063 }
        goto L_0x0072;	 Catch:{ RemoteException -> 0x0063 }
    L_0x0053:
        r5 = r3.f24601a;	 Catch:{ RemoteException -> 0x0063 }
        r5 = r5.mo4754r();	 Catch:{ RemoteException -> 0x0063 }
        r5 = r5.I_();	 Catch:{ RemoteException -> 0x0063 }
        r2 = "Got binder with a wrong descriptor";	 Catch:{ RemoteException -> 0x0063 }
        r5.m21308a(r2, r1);	 Catch:{ RemoteException -> 0x0063 }
        goto L_0x0072;
    L_0x0063:
        r5 = r3.f24601a;	 Catch:{ all -> 0x001c }
        r5 = r5.mo4754r();	 Catch:{ all -> 0x001c }
        r5 = r5.I_();	 Catch:{ all -> 0x001c }
        r1 = "Service connect failed to get IMeasurementService";	 Catch:{ all -> 0x001c }
        r5.m21307a(r1);	 Catch:{ all -> 0x001c }
    L_0x0072:
        if (r0 != 0) goto L_0x008a;	 Catch:{ all -> 0x001c }
    L_0x0074:
        r3.f24602b = r4;	 Catch:{ all -> 0x001c }
        r4 = com.google.android.gms.common.stats.C2882a.a();	 Catch:{ IllegalArgumentException -> 0x0098 }
        r5 = r3.f24601a;	 Catch:{ IllegalArgumentException -> 0x0098 }
        r5 = r5.mo4752n();	 Catch:{ IllegalArgumentException -> 0x0098 }
        r0 = r3.f24601a;	 Catch:{ IllegalArgumentException -> 0x0098 }
        r0 = r0.f32820a;	 Catch:{ IllegalArgumentException -> 0x0098 }
        r4.a(r5, r0);	 Catch:{ IllegalArgumentException -> 0x0098 }
        goto L_0x0098;
    L_0x008a:
        r4 = r3.f24601a;	 Catch:{ all -> 0x001c }
        r4 = r4.mo4753q();	 Catch:{ all -> 0x001c }
        r5 = new com.google.android.gms.internal.l.es;	 Catch:{ all -> 0x001c }
        r5.<init>(r3, r0);	 Catch:{ all -> 0x001c }
        r4.m42612a(r5);	 Catch:{ all -> 0x001c }
    L_0x0098:
        monitor-exit(r3);	 Catch:{ all -> 0x001c }
        return;	 Catch:{ all -> 0x001c }
    L_0x009a:
        monitor-exit(r3);	 Catch:{ all -> 0x001c }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.l.er.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        C2872v.b("MeasurementServiceConnection.onServiceDisconnected");
        this.f24601a.mo4754r().m42578v().m21307a("Service disconnected");
        this.f24601a.mo4753q().m42612a(new et(this, componentName));
    }
}
