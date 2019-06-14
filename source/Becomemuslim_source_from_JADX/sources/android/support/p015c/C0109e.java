package android.support.p015c;

import android.content.ComponentName;
import android.os.IBinder;

/* compiled from: CustomTabsSession */
/* renamed from: android.support.c.e */
public final class C0109e {
    /* renamed from: a */
    private final Object f242a = new Object();
    /* renamed from: b */
    private final C0111g f243b;
    /* renamed from: c */
    private final C0110f f244c;
    /* renamed from: d */
    private final ComponentName f245d;

    C0109e(C0111g c0111g, C0110f c0110f, ComponentName componentName) {
        this.f243b = c0111g;
        this.f244c = c0110f;
        this.f245d = componentName;
    }

    /* renamed from: a */
    public boolean m219a(android.net.Uri r3, android.os.Bundle r4, java.util.List<android.os.Bundle> r5) {
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
        r0 = r2.f243b;	 Catch:{ RemoteException -> 0x0009 }
        r1 = r2.f244c;	 Catch:{ RemoteException -> 0x0009 }
        r3 = r0.mo38a(r1, r3, r4, r5);	 Catch:{ RemoteException -> 0x0009 }
        return r3;
    L_0x0009:
        r3 = 0;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.c.e.a(android.net.Uri, android.os.Bundle, java.util.List):boolean");
    }

    /* renamed from: a */
    IBinder m218a() {
        return this.f244c.asBinder();
    }

    /* renamed from: b */
    ComponentName m220b() {
        return this.f245d;
    }
}
