package android.support.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.C0517s;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Field;

/* compiled from: ViewUtils */
class am {
    /* renamed from: a */
    static final Property<View, Float> f555a = new Property<View, Float>(Float.class, "translationAlpha") {
        public /* synthetic */ Object get(Object obj) {
            return m570a((View) obj);
        }

        public /* synthetic */ void set(Object obj, Object obj2) {
            m571a((View) obj, (Float) obj2);
        }

        /* renamed from: a */
        public Float m570a(View view) {
            return Float.valueOf(am.m582c(view));
        }

        /* renamed from: a */
        public void m571a(View view, Float f) {
            am.m576a(view, f.floatValue());
        }
    };
    /* renamed from: b */
    static final Property<View, Rect> f556b = new Property<View, Rect>(Rect.class, "clipBounds") {
        public /* synthetic */ Object get(Object obj) {
            return m572a((View) obj);
        }

        public /* synthetic */ void set(Object obj, Object obj2) {
            m573a((View) obj, (Rect) obj2);
        }

        /* renamed from: a */
        public Rect m572a(View view) {
            return C0517s.m1732z(view);
        }

        /* renamed from: a */
        public void m573a(View view, Rect rect) {
            C0517s.m1693a(view, rect);
        }
    };
    /* renamed from: c */
    private static final as f557c;
    /* renamed from: d */
    private static Field f558d;
    /* renamed from: e */
    private static boolean f559e;

    static {
        if (VERSION.SDK_INT >= 22) {
            f557c = new ar();
        } else if (VERSION.SDK_INT >= 21) {
            f557c = new aq();
        } else if (VERSION.SDK_INT >= 19) {
            f557c = new ap();
        } else if (VERSION.SDK_INT >= 18) {
            f557c = new ao();
        } else {
            f557c = new an();
        }
    }

    /* renamed from: a */
    static al m574a(View view) {
        return f557c.mo123a(view);
    }

    /* renamed from: b */
    static aw m580b(View view) {
        return f557c.mo127b(view);
    }

    /* renamed from: a */
    static void m576a(View view, float f) {
        f557c.mo124a(view, f);
    }

    /* renamed from: c */
    static float m582c(View view) {
        return f557c.mo129c(view);
    }

    /* renamed from: d */
    static void m583d(View view) {
        f557c.mo130d(view);
    }

    /* renamed from: e */
    static void m584e(View view) {
        f557c.mo131e(view);
    }

    /* renamed from: a */
    static void m577a(android.view.View r2, int r3) {
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
        m575a();
        r0 = f558d;
        if (r0 == 0) goto L_0x0015;
    L_0x0007:
        r0 = f558d;	 Catch:{ IllegalAccessException -> 0x0015 }
        r0 = r0.getInt(r2);	 Catch:{ IllegalAccessException -> 0x0015 }
        r1 = f558d;	 Catch:{ IllegalAccessException -> 0x0015 }
        r0 = r0 & -13;	 Catch:{ IllegalAccessException -> 0x0015 }
        r3 = r3 | r0;	 Catch:{ IllegalAccessException -> 0x0015 }
        r1.setInt(r2, r3);	 Catch:{ IllegalAccessException -> 0x0015 }
    L_0x0015:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.am.a(android.view.View, int):void");
    }

    /* renamed from: a */
    static void m579a(View view, Matrix matrix) {
        f557c.mo126a(view, matrix);
    }

    /* renamed from: b */
    static void m581b(View view, Matrix matrix) {
        f557c.mo128b(view, matrix);
    }

    /* renamed from: a */
    static void m578a(View view, int i, int i2, int i3, int i4) {
        f557c.mo125a(view, i, i2, i3, i4);
    }

    /* renamed from: a */
    private static void m575a() {
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
        r0 = f559e;
        if (r0 != 0) goto L_0x001e;
    L_0x0004:
        r0 = 1;
        r1 = android.view.View.class;	 Catch:{ NoSuchFieldException -> 0x0015 }
        r2 = "mViewFlags";	 Catch:{ NoSuchFieldException -> 0x0015 }
        r1 = r1.getDeclaredField(r2);	 Catch:{ NoSuchFieldException -> 0x0015 }
        f558d = r1;	 Catch:{ NoSuchFieldException -> 0x0015 }
        r1 = f558d;	 Catch:{ NoSuchFieldException -> 0x0015 }
        r1.setAccessible(r0);	 Catch:{ NoSuchFieldException -> 0x0015 }
        goto L_0x001c;
    L_0x0015:
        r1 = "ViewUtils";
        r2 = "fetchViewFlagsField: ";
        android.util.Log.i(r1, r2);
    L_0x001c:
        f559e = r0;
    L_0x001e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.am.a():void");
    }
}
