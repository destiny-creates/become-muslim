package android.support.v7.widget;

import android.graphics.Rect;
import android.support.v4.view.C0517s;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Method;

/* compiled from: ViewUtils */
public class by {
    /* renamed from: a */
    private static Method f2175a;

    static {
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
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 18;
        if (r0 < r1) goto L_0x0032;
    L_0x0006:
        r0 = android.view.View.class;	 Catch:{ NoSuchMethodException -> 0x002b }
        r1 = "computeFitSystemWindows";	 Catch:{ NoSuchMethodException -> 0x002b }
        r2 = 2;	 Catch:{ NoSuchMethodException -> 0x002b }
        r2 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x002b }
        r3 = 0;	 Catch:{ NoSuchMethodException -> 0x002b }
        r4 = android.graphics.Rect.class;	 Catch:{ NoSuchMethodException -> 0x002b }
        r2[r3] = r4;	 Catch:{ NoSuchMethodException -> 0x002b }
        r3 = android.graphics.Rect.class;	 Catch:{ NoSuchMethodException -> 0x002b }
        r4 = 1;	 Catch:{ NoSuchMethodException -> 0x002b }
        r2[r4] = r3;	 Catch:{ NoSuchMethodException -> 0x002b }
        r0 = r0.getDeclaredMethod(r1, r2);	 Catch:{ NoSuchMethodException -> 0x002b }
        f2175a = r0;	 Catch:{ NoSuchMethodException -> 0x002b }
        r0 = f2175a;	 Catch:{ NoSuchMethodException -> 0x002b }
        r0 = r0.isAccessible();	 Catch:{ NoSuchMethodException -> 0x002b }
        if (r0 != 0) goto L_0x0032;	 Catch:{ NoSuchMethodException -> 0x002b }
    L_0x0025:
        r0 = f2175a;	 Catch:{ NoSuchMethodException -> 0x002b }
        r0.setAccessible(r4);	 Catch:{ NoSuchMethodException -> 0x002b }
        goto L_0x0032;
    L_0x002b:
        r0 = "ViewUtils";
        r1 = "Could not find method computeFitSystemWindows. Oh well.";
        android.util.Log.d(r0, r1);
    L_0x0032:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.by.<clinit>():void");
    }

    /* renamed from: a */
    public static boolean m2841a(View view) {
        return C0517s.m1711e(view) == 1;
    }

    /* renamed from: a */
    public static void m2840a(View view, Rect rect, Rect rect2) {
        if (f2175a != null) {
            try {
                f2175a.invoke(view, new Object[]{rect, rect2});
            } catch (View view2) {
                Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", view2);
            }
        }
    }

    /* renamed from: b */
    public static void m2842b(android.view.View r4) {
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
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 16;
        if (r0 < r1) goto L_0x003c;
    L_0x0006:
        r0 = r4.getClass();	 Catch:{ NoSuchMethodException -> 0x0035, InvocationTargetException -> 0x002c, IllegalAccessException -> 0x0023 }
        r1 = "makeOptionalFitsSystemWindows";	 Catch:{ NoSuchMethodException -> 0x0035, InvocationTargetException -> 0x002c, IllegalAccessException -> 0x0023 }
        r2 = 0;	 Catch:{ NoSuchMethodException -> 0x0035, InvocationTargetException -> 0x002c, IllegalAccessException -> 0x0023 }
        r3 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x0035, InvocationTargetException -> 0x002c, IllegalAccessException -> 0x0023 }
        r0 = r0.getMethod(r1, r3);	 Catch:{ NoSuchMethodException -> 0x0035, InvocationTargetException -> 0x002c, IllegalAccessException -> 0x0023 }
        r1 = r0.isAccessible();	 Catch:{ NoSuchMethodException -> 0x0035, InvocationTargetException -> 0x002c, IllegalAccessException -> 0x0023 }
        if (r1 != 0) goto L_0x001d;	 Catch:{ NoSuchMethodException -> 0x0035, InvocationTargetException -> 0x002c, IllegalAccessException -> 0x0023 }
    L_0x0019:
        r1 = 1;	 Catch:{ NoSuchMethodException -> 0x0035, InvocationTargetException -> 0x002c, IllegalAccessException -> 0x0023 }
        r0.setAccessible(r1);	 Catch:{ NoSuchMethodException -> 0x0035, InvocationTargetException -> 0x002c, IllegalAccessException -> 0x0023 }
    L_0x001d:
        r1 = new java.lang.Object[r2];	 Catch:{ NoSuchMethodException -> 0x0035, InvocationTargetException -> 0x002c, IllegalAccessException -> 0x0023 }
        r0.invoke(r4, r1);	 Catch:{ NoSuchMethodException -> 0x0035, InvocationTargetException -> 0x002c, IllegalAccessException -> 0x0023 }
        goto L_0x003c;
    L_0x0023:
        r4 = move-exception;
        r0 = "ViewUtils";
        r1 = "Could not invoke makeOptionalFitsSystemWindows";
        android.util.Log.d(r0, r1, r4);
        goto L_0x003c;
    L_0x002c:
        r4 = move-exception;
        r0 = "ViewUtils";
        r1 = "Could not invoke makeOptionalFitsSystemWindows";
        android.util.Log.d(r0, r1, r4);
        goto L_0x003c;
    L_0x0035:
        r4 = "ViewUtils";
        r0 = "Could not find method makeOptionalFitsSystemWindows. Oh well...";
        android.util.Log.d(r4, r0);
    L_0x003c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.by.b(android.view.View):void");
    }
}
