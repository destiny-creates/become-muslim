package android.support.transition;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Method;

/* compiled from: ViewUtilsApi22 */
class ar extends aq {
    /* renamed from: a */
    private static Method f14102a;
    /* renamed from: b */
    private static boolean f14103b;

    ar() {
    }

    /* renamed from: a */
    public void mo125a(android.view.View r4, int r5, int r6, int r7, int r8) {
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
        r3.m17729a();
        r0 = f14102a;
        if (r0 == 0) goto L_0x0037;
    L_0x0007:
        r0 = f14102a;	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r1 = 4;	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r1 = new java.lang.Object[r1];	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r2 = 0;	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r1[r2] = r5;	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r5 = 1;	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r1[r5] = r6;	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r5 = 2;	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r6 = java.lang.Integer.valueOf(r7);	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r1[r5] = r6;	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r5 = 3;	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r6 = java.lang.Integer.valueOf(r8);	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r1[r5] = r6;	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r0.invoke(r4, r1);	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        goto L_0x0037;
    L_0x002c:
        r4 = move-exception;
        r5 = new java.lang.RuntimeException;
        r4 = r4.getCause();
        r5.<init>(r4);
        throw r5;
    L_0x0037:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.ar.a(android.view.View, int, int, int, int):void");
    }

    @SuppressLint({"PrivateApi"})
    /* renamed from: a */
    private void m17729a() {
        if (!f14103b) {
            try {
                f14102a = View.class.getDeclaredMethod("setLeftTopRightBottom", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                f14102a.setAccessible(true);
            } catch (Throwable e) {
                Log.i("ViewUtilsApi22", "Failed to retrieve setLeftTopRightBottom method", e);
            }
            f14103b = true;
        }
    }
}
