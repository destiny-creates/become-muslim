package com.google.android.gms.internal.p210i;

import android.content.ComponentName;
import com.google.android.gms.analytics.C2721s;

/* renamed from: com.google.android.gms.internal.i.u */
public final class C7818u extends C6797o {
    /* renamed from: a */
    private final C5012w f28916a = new C5012w(this);
    /* renamed from: b */
    private bh f28917b;
    /* renamed from: c */
    private final au f28918c;
    /* renamed from: d */
    private final by f28919d;

    protected C7818u(C5008q c5008q) {
        super(c5008q);
        this.f28919d = new by(c5008q.m21061c());
        this.f28918c = new C6798v(this, c5008q);
    }

    /* renamed from: a */
    protected final void mo6145a() {
    }

    /* renamed from: b */
    public final boolean m37984b() {
        C2721s.d();
        m31800z();
        return this.f28917b != null;
    }

    /* renamed from: a */
    public final boolean m37983a(com.google.android.gms.internal.p210i.bg r8) {
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
        r7 = this;
        com.google.android.gms.common.internal.C2872v.a(r8);
        com.google.android.gms.analytics.C2721s.d();
        r7.m31800z();
        r0 = r7.f28917b;
        r6 = 0;
        if (r0 != 0) goto L_0x000f;
    L_0x000e:
        return r6;
    L_0x000f:
        r1 = r8.m20325f();
        if (r1 == 0) goto L_0x001b;
    L_0x0015:
        r1 = com.google.android.gms.internal.p210i.as.m20293h();
    L_0x0019:
        r4 = r1;
        goto L_0x0020;
    L_0x001b:
        r1 = com.google.android.gms.internal.p210i.as.m20294i();
        goto L_0x0019;
    L_0x0020:
        r5 = java.util.Collections.emptyList();
        r1 = r8.m20321b();	 Catch:{ RemoteException -> 0x0034 }
        r2 = r8.m20323d();	 Catch:{ RemoteException -> 0x0034 }
        r0.mo4421a(r1, r2, r4, r5);	 Catch:{ RemoteException -> 0x0034 }
        r7.m37980f();	 Catch:{ RemoteException -> 0x0034 }
        r8 = 1;
        return r8;
    L_0x0034:
        r8 = "Failed to send hits to AnalyticsService";
        r7.m21036e(r8);
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.u.a(com.google.android.gms.internal.i.bg):boolean");
    }

    /* renamed from: c */
    public final boolean m37985c() {
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
        r2 = this;
        com.google.android.gms.analytics.C2721s.d();
        r2.m31800z();
        r0 = r2.f28917b;
        r1 = 0;
        if (r0 != 0) goto L_0x000c;
    L_0x000b:
        return r1;
    L_0x000c:
        r0.mo4420a();	 Catch:{ RemoteException -> 0x0014 }
        r2.m37980f();	 Catch:{ RemoteException -> 0x0014 }
        r0 = 1;
        return r0;
    L_0x0014:
        r0 = "Failed to clear hits from AnalyticsService";
        r2.m21036e(r0);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.u.c():boolean");
    }

    /* renamed from: f */
    private final void m37980f() {
        this.f28919d.m20365a();
        this.f28918c.m20303a(((Long) ba.f16364A.m20315a()).longValue());
    }

    /* renamed from: d */
    public final boolean m37986d() {
        C2721s.d();
        m31800z();
        if (this.f28917b != null) {
            return true;
        }
        bh a = this.f28916a.m21085a();
        if (a == null) {
            return false;
        }
        this.f28917b = a;
        m37980f();
        return true;
    }

    /* renamed from: a */
    private final void m37976a(bh bhVar) {
        C2721s.d();
        this.f28917b = bhVar;
        m37980f();
        m21049p().m37945g();
    }

    /* renamed from: e */
    public final void m37987e() {
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
        com.google.android.gms.analytics.C2721s.d();
        r3.m31800z();
        r0 = com.google.android.gms.common.stats.C2882a.a();	 Catch:{ IllegalStateException -> 0x0014, IllegalStateException -> 0x0014 }
        r1 = r3.m21044k();	 Catch:{ IllegalStateException -> 0x0014, IllegalStateException -> 0x0014 }
        r2 = r3.f28916a;	 Catch:{ IllegalStateException -> 0x0014, IllegalStateException -> 0x0014 }
        r0.a(r1, r2);	 Catch:{ IllegalStateException -> 0x0014, IllegalStateException -> 0x0014 }
        goto L_0x0015;
    L_0x0015:
        r0 = r3.f28917b;
        if (r0 == 0) goto L_0x0023;
    L_0x0019:
        r0 = 0;
        r3.f28917b = r0;
        r0 = r3.m21049p();
        r0.m37944f();
    L_0x0023:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.u.e():void");
    }

    /* renamed from: a */
    private final void m37975a(ComponentName componentName) {
        C2721s.d();
        if (this.f28917b != null) {
            this.f28917b = null;
            m21026a("Disconnected from device AnalyticsService", componentName);
            m21049p().m37944f();
        }
    }

    /* renamed from: g */
    private final void m37981g() {
        C2721s.d();
        if (m37984b()) {
            m21036e("Inactivity, disconnecting from device AnalyticsService");
            m37987e();
        }
    }
}
