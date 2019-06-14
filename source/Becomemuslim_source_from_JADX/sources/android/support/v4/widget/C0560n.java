package android.support.v4.widget;

import android.os.Build.VERSION;
import android.support.v4.view.C0501e;
import android.support.v4.view.C0517s;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: PopupWindowCompat */
/* renamed from: android.support.v4.widget.n */
public final class C0560n {
    /* renamed from: a */
    static final C0559d f1399a;

    /* compiled from: PopupWindowCompat */
    /* renamed from: android.support.v4.widget.n$d */
    static class C0559d {
        /* renamed from: a */
        private static Method f1397a;
        /* renamed from: b */
        private static boolean f1398b;

        /* renamed from: a */
        public void mo2705a(PopupWindow popupWindow, boolean z) {
        }

        C0559d() {
        }

        /* renamed from: a */
        public void mo348a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            if ((C0501e.m1587a(i3, C0517s.m1711e(view)) & 7) == 5) {
                i -= popupWindow.getWidth() - view.getWidth();
            }
            popupWindow.showAsDropDown(view, i, i2);
        }

        /* renamed from: a */
        public void mo3334a(android.widget.PopupWindow r7, int r8) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r6 = this;
            r0 = f1398b;
            r1 = 0;
            r2 = 1;
            if (r0 != 0) goto L_0x001d;
        L_0x0006:
            r0 = android.widget.PopupWindow.class;	 Catch:{ Exception -> 0x001b }
            r3 = "setWindowLayoutType";	 Catch:{ Exception -> 0x001b }
            r4 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x001b }
            r5 = java.lang.Integer.TYPE;	 Catch:{ Exception -> 0x001b }
            r4[r1] = r5;	 Catch:{ Exception -> 0x001b }
            r0 = r0.getDeclaredMethod(r3, r4);	 Catch:{ Exception -> 0x001b }
            f1397a = r0;	 Catch:{ Exception -> 0x001b }
            r0 = f1397a;	 Catch:{ Exception -> 0x001b }
            r0.setAccessible(r2);	 Catch:{ Exception -> 0x001b }
        L_0x001b:
            f1398b = r2;
        L_0x001d:
            r0 = f1397a;
            if (r0 == 0) goto L_0x002e;
        L_0x0021:
            r0 = f1397a;	 Catch:{ Exception -> 0x002e }
            r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x002e }
            r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x002e }
            r2[r1] = r8;	 Catch:{ Exception -> 0x002e }
            r0.invoke(r7, r2);	 Catch:{ Exception -> 0x002e }
        L_0x002e:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.n.d.a(android.widget.PopupWindow, int):void");
        }
    }

    /* compiled from: PopupWindowCompat */
    /* renamed from: android.support.v4.widget.n$a */
    static class C3243a extends C0559d {
        C3243a() {
        }

        /* renamed from: a */
        public void mo348a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            popupWindow.showAsDropDown(view, i, i2, i3);
        }
    }

    /* compiled from: PopupWindowCompat */
    /* renamed from: android.support.v4.widget.n$b */
    static class C4470b extends C3243a {
        /* renamed from: a */
        private static Field f11943a;

        C4470b() {
        }

        static {
            try {
                f11943a = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                f11943a.setAccessible(true);
            } catch (Throwable e) {
                Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e);
            }
        }

        /* renamed from: a */
        public void mo2705a(PopupWindow popupWindow, boolean z) {
            if (f11943a != null) {
                try {
                    f11943a.set(popupWindow, Boolean.valueOf(z));
                } catch (PopupWindow popupWindow2) {
                    Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", popupWindow2);
                }
            }
        }
    }

    /* compiled from: PopupWindowCompat */
    /* renamed from: android.support.v4.widget.n$c */
    static class C4829c extends C4470b {
        C4829c() {
        }

        /* renamed from: a */
        public void mo2705a(PopupWindow popupWindow, boolean z) {
            popupWindow.setOverlapAnchor(z);
        }

        /* renamed from: a */
        public void mo3334a(PopupWindow popupWindow, int i) {
            popupWindow.setWindowLayoutType(i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 23) {
            f1399a = new C4829c();
        } else if (VERSION.SDK_INT >= 21) {
            f1399a = new C4470b();
        } else if (VERSION.SDK_INT >= 19) {
            f1399a = new C3243a();
        } else {
            f1399a = new C0559d();
        }
    }

    /* renamed from: a */
    public static void m1895a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        f1399a.mo348a(popupWindow, view, i, i2, i3);
    }

    /* renamed from: a */
    public static void m1896a(PopupWindow popupWindow, boolean z) {
        f1399a.mo2705a(popupWindow, z);
    }

    /* renamed from: a */
    public static void m1894a(PopupWindow popupWindow, int i) {
        f1399a.mo3334a(popupWindow, i);
    }
}
