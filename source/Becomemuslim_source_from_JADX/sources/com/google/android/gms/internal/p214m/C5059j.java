package com.google.android.gms.internal.p214m;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule;

/* renamed from: com.google.android.gms.internal.m.j */
public abstract class C5059j<T> {
    /* renamed from: a */
    private static String f17349a = "com.google.android.gms.vision.dynamite";
    /* renamed from: b */
    private final Context f17350b;
    /* renamed from: c */
    private final Object f17351c = new Object();
    /* renamed from: d */
    private final String f17352d;
    /* renamed from: e */
    private final String f17353e;
    /* renamed from: f */
    private final String f17354f;
    /* renamed from: g */
    private boolean f17355g = false;
    /* renamed from: h */
    private T f17356h;

    public C5059j(Context context, String str, String str2) {
        this.f17350b = context;
        this.f17352d = str;
        String str3 = f17349a;
        StringBuilder stringBuilder = new StringBuilder((String.valueOf(str3).length() + 1) + String.valueOf(str2).length());
        stringBuilder.append(str3);
        stringBuilder.append(".");
        stringBuilder.append(str2);
        this.f17353e = stringBuilder.toString();
        this.f17354f = f17349a;
    }

    /* renamed from: a */
    protected abstract T mo4767a(DynamiteModule dynamiteModule, Context context);

    /* renamed from: a */
    protected abstract void mo4768a();

    /* renamed from: b */
    public final boolean m21514b() {
        return m21516d() != null;
    }

    /* renamed from: c */
    public final void m21515c() {
        synchronized (this.f17351c) {
            if (this.f17356h == null) {
                return;
            }
            try {
                mo4768a();
            } catch (Throwable e) {
                Log.e(this.f17352d, "Could not finalize native handle", e);
            }
        }
    }

    /* renamed from: d */
    protected final T m21516d() {
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
        r5 = this;
        r0 = r5.f17351c;
        monitor-enter(r0);
        r1 = r5.f17356h;	 Catch:{ all -> 0x006c }
        if (r1 == 0) goto L_0x000b;	 Catch:{ all -> 0x006c }
    L_0x0007:
        r1 = r5.f17356h;	 Catch:{ all -> 0x006c }
        monitor-exit(r0);	 Catch:{ all -> 0x006c }
        return r1;
    L_0x000b:
        r1 = 0;
        r2 = r5.f17350b;	 Catch:{ a -> 0x0019 }
        r3 = com.google.android.gms.dynamite.DynamiteModule.f7432d;	 Catch:{ a -> 0x0019 }
        r4 = r5.f17353e;	 Catch:{ a -> 0x0019 }
        r2 = com.google.android.gms.dynamite.DynamiteModule.a(r2, r3, r4);	 Catch:{ a -> 0x0019 }
        goto L_0x0034;
    L_0x0017:
        r1 = move-exception;
        goto L_0x003f;
    L_0x0019:
        r2 = r5.f17352d;	 Catch:{ RemoteException -> 0x0017, RemoteException -> 0x0017 }
        r3 = "Cannot load feature, fall back to load whole module.";	 Catch:{ RemoteException -> 0x0017, RemoteException -> 0x0017 }
        android.util.Log.d(r2, r3);	 Catch:{ RemoteException -> 0x0017, RemoteException -> 0x0017 }
        r2 = r5.f17350b;	 Catch:{ a -> 0x002b }
        r3 = com.google.android.gms.dynamite.DynamiteModule.f7432d;	 Catch:{ a -> 0x002b }
        r4 = r5.f17354f;	 Catch:{ a -> 0x002b }
        r2 = com.google.android.gms.dynamite.DynamiteModule.a(r2, r3, r4);	 Catch:{ a -> 0x002b }
        goto L_0x0034;
    L_0x002b:
        r2 = move-exception;
        r3 = r5.f17352d;	 Catch:{ RemoteException -> 0x0017, RemoteException -> 0x0017 }
        r4 = "Error Loading module";	 Catch:{ RemoteException -> 0x0017, RemoteException -> 0x0017 }
        android.util.Log.e(r3, r4, r2);	 Catch:{ RemoteException -> 0x0017, RemoteException -> 0x0017 }
        r2 = r1;	 Catch:{ RemoteException -> 0x0017, RemoteException -> 0x0017 }
    L_0x0034:
        if (r2 == 0) goto L_0x0046;	 Catch:{ RemoteException -> 0x0017, RemoteException -> 0x0017 }
    L_0x0036:
        r1 = r5.f17350b;	 Catch:{ RemoteException -> 0x0017, RemoteException -> 0x0017 }
        r1 = r5.mo4767a(r2, r1);	 Catch:{ RemoteException -> 0x0017, RemoteException -> 0x0017 }
        r5.f17356h = r1;	 Catch:{ RemoteException -> 0x0017, RemoteException -> 0x0017 }
        goto L_0x0046;
    L_0x003f:
        r2 = r5.f17352d;	 Catch:{ all -> 0x006c }
        r3 = "Error creating remote native handle";	 Catch:{ all -> 0x006c }
        android.util.Log.e(r2, r3, r1);	 Catch:{ all -> 0x006c }
    L_0x0046:
        r1 = r5.f17355g;	 Catch:{ all -> 0x006c }
        if (r1 != 0) goto L_0x0059;	 Catch:{ all -> 0x006c }
    L_0x004a:
        r1 = r5.f17356h;	 Catch:{ all -> 0x006c }
        if (r1 != 0) goto L_0x0059;	 Catch:{ all -> 0x006c }
    L_0x004e:
        r1 = r5.f17352d;	 Catch:{ all -> 0x006c }
        r2 = "Native handle not yet available. Reverting to no-op handle.";	 Catch:{ all -> 0x006c }
        android.util.Log.w(r1, r2);	 Catch:{ all -> 0x006c }
        r1 = 1;	 Catch:{ all -> 0x006c }
        r5.f17355g = r1;	 Catch:{ all -> 0x006c }
        goto L_0x0068;	 Catch:{ all -> 0x006c }
    L_0x0059:
        r1 = r5.f17355g;	 Catch:{ all -> 0x006c }
        if (r1 == 0) goto L_0x0068;	 Catch:{ all -> 0x006c }
    L_0x005d:
        r1 = r5.f17356h;	 Catch:{ all -> 0x006c }
        if (r1 == 0) goto L_0x0068;	 Catch:{ all -> 0x006c }
    L_0x0061:
        r1 = r5.f17352d;	 Catch:{ all -> 0x006c }
        r2 = "Native handle is now available.";	 Catch:{ all -> 0x006c }
        android.util.Log.w(r1, r2);	 Catch:{ all -> 0x006c }
    L_0x0068:
        r1 = r5.f17356h;	 Catch:{ all -> 0x006c }
        monitor-exit(r0);	 Catch:{ all -> 0x006c }
        return r1;	 Catch:{ all -> 0x006c }
    L_0x006c:
        r1 = move-exception;	 Catch:{ all -> 0x006c }
        monitor-exit(r0);	 Catch:{ all -> 0x006c }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.m.j.d():T");
    }
}
