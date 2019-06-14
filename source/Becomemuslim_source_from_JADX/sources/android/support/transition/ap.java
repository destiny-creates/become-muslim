package android.support.transition;

import android.util.Log;
import android.view.View;
import java.lang.reflect.Method;

/* compiled from: ViewUtilsApi19 */
class ap extends ao {
    /* renamed from: a */
    private static Method f13672a;
    /* renamed from: b */
    private static boolean f13673b;
    /* renamed from: c */
    private static Method f13674c;
    /* renamed from: d */
    private static boolean f13675d;

    /* renamed from: d */
    public void mo130d(View view) {
    }

    /* renamed from: e */
    public void mo131e(View view) {
    }

    ap() {
    }

    /* renamed from: a */
    public void mo124a(android.view.View r4, float r5) {
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
        r3.m17102a();
        r0 = f13672a;
        if (r0 == 0) goto L_0x0022;
    L_0x0007:
        r0 = f13672a;	 Catch:{ IllegalAccessException -> 0x0025, InvocationTargetException -> 0x0017 }
        r1 = 1;	 Catch:{ IllegalAccessException -> 0x0025, InvocationTargetException -> 0x0017 }
        r1 = new java.lang.Object[r1];	 Catch:{ IllegalAccessException -> 0x0025, InvocationTargetException -> 0x0017 }
        r2 = 0;	 Catch:{ IllegalAccessException -> 0x0025, InvocationTargetException -> 0x0017 }
        r5 = java.lang.Float.valueOf(r5);	 Catch:{ IllegalAccessException -> 0x0025, InvocationTargetException -> 0x0017 }
        r1[r2] = r5;	 Catch:{ IllegalAccessException -> 0x0025, InvocationTargetException -> 0x0017 }
        r0.invoke(r4, r1);	 Catch:{ IllegalAccessException -> 0x0025, InvocationTargetException -> 0x0017 }
        goto L_0x0025;
    L_0x0017:
        r4 = move-exception;
        r5 = new java.lang.RuntimeException;
        r4 = r4.getCause();
        r5.<init>(r4);
        throw r5;
    L_0x0022:
        r4.setAlpha(r5);
    L_0x0025:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.ap.a(android.view.View, float):void");
    }

    /* renamed from: c */
    public float mo129c(android.view.View r3) {
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
        r2.m17103b();
        r0 = f13674c;
        if (r0 == 0) goto L_0x0022;
    L_0x0007:
        r0 = f13674c;	 Catch:{ IllegalAccessException -> 0x0022, InvocationTargetException -> 0x0017 }
        r1 = 0;	 Catch:{ IllegalAccessException -> 0x0022, InvocationTargetException -> 0x0017 }
        r1 = new java.lang.Object[r1];	 Catch:{ IllegalAccessException -> 0x0022, InvocationTargetException -> 0x0017 }
        r0 = r0.invoke(r3, r1);	 Catch:{ IllegalAccessException -> 0x0022, InvocationTargetException -> 0x0017 }
        r0 = (java.lang.Float) r0;	 Catch:{ IllegalAccessException -> 0x0022, InvocationTargetException -> 0x0017 }
        r0 = r0.floatValue();	 Catch:{ IllegalAccessException -> 0x0022, InvocationTargetException -> 0x0017 }
        return r0;
    L_0x0017:
        r3 = move-exception;
        r0 = new java.lang.RuntimeException;
        r3 = r3.getCause();
        r0.<init>(r3);
        throw r0;
    L_0x0022:
        r3 = super.mo129c(r3);
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.ap.c(android.view.View):float");
    }

    /* renamed from: a */
    private void m17102a() {
        if (!f13673b) {
            try {
                f13672a = View.class.getDeclaredMethod("setTransitionAlpha", new Class[]{Float.TYPE});
                f13672a.setAccessible(true);
            } catch (Throwable e) {
                Log.i("ViewUtilsApi19", "Failed to retrieve setTransitionAlpha method", e);
            }
            f13673b = true;
        }
    }

    /* renamed from: b */
    private void m17103b() {
        if (!f13675d) {
            try {
                f13674c = View.class.getDeclaredMethod("getTransitionAlpha", new Class[0]);
                f13674c.setAccessible(true);
            } catch (Throwable e) {
                Log.i("ViewUtilsApi19", "Failed to retrieve getTransitionAlpha method", e);
            }
            f13675d = true;
        }
    }
}
