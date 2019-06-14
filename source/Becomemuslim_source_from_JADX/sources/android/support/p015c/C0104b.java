package android.support.p015c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* compiled from: CustomTabsClient */
/* renamed from: android.support.c.b */
public class C0104b {
    /* renamed from: a */
    private final C0111g f233a;
    /* renamed from: b */
    private final ComponentName f234b;

    C0104b(C0111g c0111g, ComponentName componentName) {
        this.f233a = c0111g;
        this.f234b = componentName;
    }

    /* renamed from: a */
    public static boolean m212a(Context context, String str, C0108d c0108d) {
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        return context.bindService(intent, c0108d, 33);
    }

    /* renamed from: a */
    public boolean m214a(long r2) {
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
        r1 = this;
        r0 = r1.f233a;	 Catch:{ RemoteException -> 0x0007 }
        r2 = r0.mo34a(r2);	 Catch:{ RemoteException -> 0x0007 }
        return r2;
    L_0x0007:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.c.b.a(long):boolean");
    }

    /* renamed from: a */
    public android.support.p015c.C0109e m213a(final android.support.p015c.C0098a r4) {
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
        r3 = this;
        r0 = new android.support.c.b$1;
        r0.<init>(r3, r4);
        r4 = 0;
        r1 = r3.f233a;	 Catch:{ RemoteException -> 0x0019 }
        r1 = r1.mo35a(r0);	 Catch:{ RemoteException -> 0x0019 }
        if (r1 != 0) goto L_0x000f;
    L_0x000e:
        return r4;
    L_0x000f:
        r4 = new android.support.c.e;
        r1 = r3.f233a;
        r2 = r3.f234b;
        r4.<init>(r1, r0, r2);
        return r4;
    L_0x0019:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.c.b.a(android.support.c.a):android.support.c.e");
    }
}
