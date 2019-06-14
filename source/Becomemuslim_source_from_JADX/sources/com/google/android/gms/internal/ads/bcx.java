package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.C2175b;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.customevent.C4298c;
import com.google.android.gms.ads.mediation.customevent.CustomEventAdapter;
import java.util.Map;

@cm
public final class bcx extends bcz {
    /* renamed from: b */
    private static final bes f28476b = new bes();
    /* renamed from: a */
    private Map<Class<? extends Object>, Object> f28477a;

    /* renamed from: d */
    private final <NetworkExtrasT extends com.google.ads.mediation.C2184f, ServerParametersT extends com.google.ads.mediation.C2183e> com.google.android.gms.internal.ads.bdb m37281d(java.lang.String r4) {
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
        r0 = com.google.android.gms.internal.ads.bcx.class;	 Catch:{ Throwable -> 0x0078 }
        r0 = r0.getClassLoader();	 Catch:{ Throwable -> 0x0078 }
        r1 = 0;	 Catch:{ Throwable -> 0x0078 }
        r0 = java.lang.Class.forName(r4, r1, r0);	 Catch:{ Throwable -> 0x0078 }
        r2 = com.google.ads.mediation.C2175b.class;	 Catch:{ Throwable -> 0x0078 }
        r2 = r2.isAssignableFrom(r0);	 Catch:{ Throwable -> 0x0078 }
        if (r2 == 0) goto L_0x0033;	 Catch:{ Throwable -> 0x0078 }
    L_0x0013:
        r2 = new java.lang.Class[r1];	 Catch:{ Throwable -> 0x0078 }
        r0 = r0.getDeclaredConstructor(r2);	 Catch:{ Throwable -> 0x0078 }
        r1 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x0078 }
        r0 = r0.newInstance(r1);	 Catch:{ Throwable -> 0x0078 }
        r0 = (com.google.ads.mediation.C2175b) r0;	 Catch:{ Throwable -> 0x0078 }
        r1 = r3.f28477a;	 Catch:{ Throwable -> 0x0078 }
        r2 = r0.getAdditionalParametersType();	 Catch:{ Throwable -> 0x0078 }
        r1 = r1.get(r2);	 Catch:{ Throwable -> 0x0078 }
        r1 = (com.google.ads.mediation.C2184f) r1;	 Catch:{ Throwable -> 0x0078 }
        r2 = new com.google.android.gms.internal.ads.beb;	 Catch:{ Throwable -> 0x0078 }
        r2.<init>(r0, r1);	 Catch:{ Throwable -> 0x0078 }
        return r2;	 Catch:{ Throwable -> 0x0078 }
    L_0x0033:
        r2 = com.google.android.gms.ads.mediation.C2683b.class;	 Catch:{ Throwable -> 0x0078 }
        r2 = r2.isAssignableFrom(r0);	 Catch:{ Throwable -> 0x0078 }
        if (r2 == 0) goto L_0x004f;	 Catch:{ Throwable -> 0x0078 }
    L_0x003b:
        r2 = new java.lang.Class[r1];	 Catch:{ Throwable -> 0x0078 }
        r0 = r0.getDeclaredConstructor(r2);	 Catch:{ Throwable -> 0x0078 }
        r1 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x0078 }
        r0 = r0.newInstance(r1);	 Catch:{ Throwable -> 0x0078 }
        r0 = (com.google.android.gms.ads.mediation.C2683b) r0;	 Catch:{ Throwable -> 0x0078 }
        r1 = new com.google.android.gms.internal.ads.bdw;	 Catch:{ Throwable -> 0x0078 }
        r1.<init>(r0);	 Catch:{ Throwable -> 0x0078 }
        return r1;	 Catch:{ Throwable -> 0x0078 }
    L_0x004f:
        r0 = java.lang.String.valueOf(r4);	 Catch:{ Throwable -> 0x0078 }
        r0 = r0.length();	 Catch:{ Throwable -> 0x0078 }
        r0 = r0 + 64;	 Catch:{ Throwable -> 0x0078 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0078 }
        r1.<init>(r0);	 Catch:{ Throwable -> 0x0078 }
        r0 = "Could not instantiate mediation adapter: ";	 Catch:{ Throwable -> 0x0078 }
        r1.append(r0);	 Catch:{ Throwable -> 0x0078 }
        r1.append(r4);	 Catch:{ Throwable -> 0x0078 }
        r0 = " (not a valid adapter).";	 Catch:{ Throwable -> 0x0078 }
        r1.append(r0);	 Catch:{ Throwable -> 0x0078 }
        r0 = r1.toString();	 Catch:{ Throwable -> 0x0078 }
        com.google.android.gms.internal.ads.mt.m19924e(r0);	 Catch:{ Throwable -> 0x0078 }
        r0 = new android.os.RemoteException;	 Catch:{ Throwable -> 0x0078 }
        r0.<init>();	 Catch:{ Throwable -> 0x0078 }
        throw r0;	 Catch:{ Throwable -> 0x0078 }
    L_0x0078:
        r4 = r3.m37282e(r4);
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.bcx.d(java.lang.String):com.google.android.gms.internal.ads.bdb");
    }

    /* renamed from: e */
    private final bdb m37282e(String str) {
        try {
            mt.m19918b("Reflection failed, retrying using direct instantiation");
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
                return new bdw(new AdMobAdapter());
            }
            if ("com.google.ads.mediation.AdUrlAdapter".equals(str)) {
                return new bdw(new AdUrlAdapter());
            }
            if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
                return new bdw(new CustomEventAdapter());
            }
            if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
                C2175b customEventAdapter = new com.google.ads.mediation.customevent.CustomEventAdapter();
                return new beb(customEventAdapter, (C4298c) this.f28477a.get(customEventAdapter.getAdditionalParametersType()));
            }
            throw new RemoteException();
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 43);
            stringBuilder.append("Could not instantiate mediation adapter: ");
            stringBuilder.append(str);
            stringBuilder.append(". ");
            mt.m19921c(stringBuilder.toString(), th);
        }
    }

    /* renamed from: a */
    public final bdb mo4102a(String str) {
        return m37281d(str);
    }

    /* renamed from: a */
    public final void m37284a(Map<Class<? extends Object>, Object> map) {
        this.f28477a = map;
    }

    /* renamed from: b */
    public final boolean mo4103b(java.lang.String r4) {
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
        r0 = 0;
        r1 = com.google.android.gms.internal.ads.bcx.class;	 Catch:{ Throwable -> 0x0012 }
        r1 = r1.getClassLoader();	 Catch:{ Throwable -> 0x0012 }
        r1 = java.lang.Class.forName(r4, r0, r1);	 Catch:{ Throwable -> 0x0012 }
        r2 = com.google.android.gms.ads.mediation.customevent.C2685a.class;	 Catch:{ Throwable -> 0x0012 }
        r1 = r2.isAssignableFrom(r1);	 Catch:{ Throwable -> 0x0012 }
        return r1;
    L_0x0012:
        r1 = java.lang.String.valueOf(r4);
        r1 = r1.length();
        r1 = r1 + 80;
        r2 = new java.lang.StringBuilder;
        r2.<init>(r1);
        r1 = "Could not load custom event implementation class: ";
        r2.append(r1);
        r2.append(r4);
        r4 = ", assuming old implementation.";
        r2.append(r4);
        r4 = r2.toString();
        com.google.android.gms.internal.ads.mt.m19924e(r4);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.bcx.b(java.lang.String):boolean");
    }

    /* renamed from: c */
    public final ben mo4104c(String str) {
        return bes.m19357a(str);
    }
}
