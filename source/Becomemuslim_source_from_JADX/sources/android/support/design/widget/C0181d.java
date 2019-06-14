package android.support.design.widget;

import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import java.lang.reflect.Method;

/* compiled from: DrawableUtils */
/* renamed from: android.support.design.widget.d */
class C0181d {
    /* renamed from: a */
    private static Method f401a;
    /* renamed from: b */
    private static boolean f402b;

    /* renamed from: a */
    static boolean m398a(DrawableContainer drawableContainer, ConstantState constantState) {
        return C0181d.m399b(drawableContainer, constantState);
    }

    /* renamed from: b */
    private static boolean m399b(android.graphics.drawable.DrawableContainer r6, android.graphics.drawable.Drawable.ConstantState r7) {
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
        r0 = f402b;
        r1 = 0;
        r2 = 1;
        if (r0 != 0) goto L_0x0025;
    L_0x0006:
        r0 = android.graphics.drawable.DrawableContainer.class;	 Catch:{ NoSuchMethodException -> 0x001c }
        r3 = "setConstantState";	 Catch:{ NoSuchMethodException -> 0x001c }
        r4 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x001c }
        r5 = android.graphics.drawable.DrawableContainer.DrawableContainerState.class;	 Catch:{ NoSuchMethodException -> 0x001c }
        r4[r1] = r5;	 Catch:{ NoSuchMethodException -> 0x001c }
        r0 = r0.getDeclaredMethod(r3, r4);	 Catch:{ NoSuchMethodException -> 0x001c }
        f401a = r0;	 Catch:{ NoSuchMethodException -> 0x001c }
        r0 = f401a;	 Catch:{ NoSuchMethodException -> 0x001c }
        r0.setAccessible(r2);	 Catch:{ NoSuchMethodException -> 0x001c }
        goto L_0x0023;
    L_0x001c:
        r0 = "DrawableUtils";
        r3 = "Could not fetch setConstantState(). Oh well.";
        android.util.Log.e(r0, r3);
    L_0x0023:
        f402b = r2;
    L_0x0025:
        r0 = f401a;
        if (r0 == 0) goto L_0x003a;
    L_0x0029:
        r0 = f401a;	 Catch:{ Exception -> 0x0033 }
        r3 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0033 }
        r3[r1] = r7;	 Catch:{ Exception -> 0x0033 }
        r0.invoke(r6, r3);	 Catch:{ Exception -> 0x0033 }
        return r2;
    L_0x0033:
        r6 = "DrawableUtils";
        r7 = "Could not invoke setConstantState(). Oh well.";
        android.util.Log.e(r6, r7);
    L_0x003a:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.d.b(android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable$ConstantState):boolean");
    }
}
