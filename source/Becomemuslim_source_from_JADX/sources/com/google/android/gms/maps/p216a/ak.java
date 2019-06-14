package com.google.android.gms.maps.p216a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.C2831g;
import com.google.android.gms.common.C2832i;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.maps.model.C5146u;
import com.google.android.gms.p174b.C4757d;

/* renamed from: com.google.android.gms.maps.a.ak */
public class ak {
    /* renamed from: a */
    private static final String f17391a = "ak";
    @SuppressLint({"StaticFieldLeak"})
    /* renamed from: b */
    private static Context f17392b;
    /* renamed from: c */
    private static an f17393c;

    /* renamed from: a */
    public static an m21594a(Context context) {
        C2872v.a(context);
        if (f17393c != null) {
            return f17393c;
        }
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context, C2832i.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        if (isGooglePlayServicesAvailable == 0) {
            an anVar;
            Log.i(f17391a, "Making Creator dynamically");
            IBinder iBinder = (IBinder) ak.m21596a(ak.m21597b(context).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl");
            if (iBinder == null) {
                anVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
                anVar = queryLocalInterface instanceof an ? (an) queryLocalInterface : new ao(iBinder);
            }
            f17393c = anVar;
            try {
                f17393c.mo4794a(C4757d.a(ak.m21597b(context).getResources()), GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE);
                return f17393c;
            } catch (RemoteException e) {
                throw new C5146u(e);
            }
        }
        throw new C2831g(isGooglePlayServicesAvailable);
    }

    /* renamed from: a */
    private static <T> T m21595a(java.lang.Class<?> r3) {
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
        r0 = r3.newInstance();	 Catch:{ InstantiationException -> 0x0025, IllegalAccessException -> 0x0005 }
        return r0;
    L_0x0005:
        r0 = new java.lang.IllegalStateException;
        r1 = "Unable to call the default constructor of ";
        r3 = r3.getName();
        r3 = java.lang.String.valueOf(r3);
        r2 = r3.length();
        if (r2 == 0) goto L_0x001c;
    L_0x0017:
        r3 = r1.concat(r3);
        goto L_0x0021;
    L_0x001c:
        r3 = new java.lang.String;
        r3.<init>(r1);
    L_0x0021:
        r0.<init>(r3);
        throw r0;
    L_0x0025:
        r0 = new java.lang.IllegalStateException;
        r1 = "Unable to instantiate the dynamic class ";
        r3 = r3.getName();
        r3 = java.lang.String.valueOf(r3);
        r2 = r3.length();
        if (r2 == 0) goto L_0x003c;
    L_0x0037:
        r3 = r1.concat(r3);
        goto L_0x0041;
    L_0x003c:
        r3 = new java.lang.String;
        r3.<init>(r1);
    L_0x0041:
        r0.<init>(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.a.ak.a(java.lang.Class):T");
    }

    /* renamed from: a */
    private static <T> T m21596a(java.lang.ClassLoader r2, java.lang.String r3) {
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
        r2 = com.google.android.gms.common.internal.C2872v.a(r2);	 Catch:{ ClassNotFoundException -> 0x000f }
        r2 = (java.lang.ClassLoader) r2;	 Catch:{ ClassNotFoundException -> 0x000f }
        r2 = r2.loadClass(r3);	 Catch:{ ClassNotFoundException -> 0x000f }
        r2 = com.google.android.gms.maps.p216a.ak.m21595a(r2);	 Catch:{ ClassNotFoundException -> 0x000f }
        return r2;
        r2 = new java.lang.IllegalStateException;
        r0 = "Unable to find dynamic class ";
        r3 = java.lang.String.valueOf(r3);
        r1 = r3.length();
        if (r1 == 0) goto L_0x0023;
    L_0x001e:
        r3 = r0.concat(r3);
        goto L_0x0028;
    L_0x0023:
        r3 = new java.lang.String;
        r3.<init>(r0);
    L_0x0028:
        r2.<init>(r3);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.a.ak.a(java.lang.ClassLoader, java.lang.String):T");
    }

    /* renamed from: b */
    private static Context m21597b(Context context) {
        if (f17392b != null) {
            return f17392b;
        }
        context = ak.m21598c(context);
        f17392b = context;
        return context;
    }

    /* renamed from: c */
    private static Context m21598c(Context context) {
        try {
            return DynamiteModule.a(context, DynamiteModule.f7429a, "com.google.android.gms.maps_dynamite").a();
        } catch (Throwable th) {
            Log.e(f17391a, "Failed to load maps module, use legacy", th);
            return GooglePlayServicesUtil.getRemoteContext(context);
        }
    }
}
