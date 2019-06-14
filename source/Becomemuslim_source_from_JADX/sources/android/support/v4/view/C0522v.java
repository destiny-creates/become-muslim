package android.support.v4.view;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;

/* compiled from: ViewParentCompat */
/* renamed from: android.support.v4.view.v */
public final class C0522v {
    /* renamed from: a */
    static final C0521c f1297a;

    /* compiled from: ViewParentCompat */
    /* renamed from: android.support.v4.view.v$c */
    static class C0521c {
        C0521c() {
        }

        /* renamed from: a */
        public boolean mo2702a(ViewParent viewParent, View view, View view2, int i) {
            return viewParent instanceof C0510m ? ((C0510m) viewParent).onStartNestedScroll(view, view2, i) : null;
        }

        /* renamed from: b */
        public void mo2703b(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof C0510m) {
                ((C0510m) viewParent).onNestedScrollAccepted(view, view2, i);
            }
        }

        /* renamed from: a */
        public void mo2697a(ViewParent viewParent, View view) {
            if (viewParent instanceof C0510m) {
                ((C0510m) viewParent).onStopNestedScroll(view);
            }
        }

        /* renamed from: a */
        public void mo2698a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            if (viewParent instanceof C0510m) {
                ((C0510m) viewParent).onNestedScroll(view, i, i2, i3, i4);
            }
        }

        /* renamed from: a */
        public void mo2699a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            if (viewParent instanceof C0510m) {
                ((C0510m) viewParent).onNestedPreScroll(view, i, i2, iArr);
            }
        }

        /* renamed from: a */
        public boolean mo2701a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            return viewParent instanceof C0510m ? ((C0510m) viewParent).onNestedFling(view, f, f2, z) : null;
        }

        /* renamed from: a */
        public boolean mo2700a(ViewParent viewParent, View view, float f, float f2) {
            return viewParent instanceof C0510m ? ((C0510m) viewParent).onNestedPreFling(view, f, f2) : null;
        }
    }

    /* compiled from: ViewParentCompat */
    /* renamed from: android.support.v4.view.v$a */
    static class C3230a extends C0521c {
        C3230a() {
        }
    }

    /* compiled from: ViewParentCompat */
    /* renamed from: android.support.v4.view.v$b */
    static class C4467b extends C3230a {
        C4467b() {
        }

        /* renamed from: a */
        public boolean mo2702a(ViewParent viewParent, View view, View view2, int i) {
            try {
                return viewParent.onStartNestedScroll(view, view2, i);
            } catch (View view3) {
                i = new StringBuilder();
                i.append("ViewParent ");
                i.append(viewParent);
                i.append(" does not implement interface ");
                i.append("method onStartNestedScroll");
                Log.e("ViewParentCompat", i.toString(), view3);
                return null;
            }
        }

        /* renamed from: b */
        public void mo2703b(ViewParent viewParent, View view, View view2, int i) {
            try {
                viewParent.onNestedScrollAccepted(view, view2, i);
            } catch (View view3) {
                i = new StringBuilder();
                i.append("ViewParent ");
                i.append(viewParent);
                i.append(" does not implement interface ");
                i.append("method onNestedScrollAccepted");
                Log.e("ViewParentCompat", i.toString(), view3);
            }
        }

        /* renamed from: a */
        public void mo2697a(ViewParent viewParent, View view) {
            try {
                viewParent.onStopNestedScroll(view);
            } catch (View view2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("ViewParent ");
                stringBuilder.append(viewParent);
                stringBuilder.append(" does not implement interface ");
                stringBuilder.append("method onStopNestedScroll");
                Log.e("ViewParentCompat", stringBuilder.toString(), view2);
            }
        }

        /* renamed from: a */
        public void mo2698a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            try {
                viewParent.onNestedScroll(view, i, i2, i3, i4);
            } catch (View view2) {
                i2 = new StringBuilder();
                i2.append("ViewParent ");
                i2.append(viewParent);
                i2.append(" does not implement interface ");
                i2.append("method onNestedScroll");
                Log.e("ViewParentCompat", i2.toString(), view2);
            }
        }

        /* renamed from: a */
        public void mo2699a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            try {
                viewParent.onNestedPreScroll(view, i, i2, iArr);
            } catch (View view2) {
                i2 = new StringBuilder();
                i2.append("ViewParent ");
                i2.append(viewParent);
                i2.append(" does not implement interface ");
                i2.append("method onNestedPreScroll");
                Log.e("ViewParentCompat", i2.toString(), view2);
            }
        }

        /* renamed from: a */
        public boolean mo2701a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            try {
                return viewParent.onNestedFling(view, f, f2, z);
            } catch (View view2) {
                f2 = new StringBuilder();
                f2.append("ViewParent ");
                f2.append(viewParent);
                f2.append(" does not implement interface ");
                f2.append("method onNestedFling");
                Log.e("ViewParentCompat", f2.toString(), view2);
                return null;
            }
        }

        /* renamed from: a */
        public boolean mo2700a(ViewParent viewParent, View view, float f, float f2) {
            try {
                return viewParent.onNestedPreFling(view, f, f2);
            } catch (View view2) {
                f2 = new StringBuilder();
                f2.append("ViewParent ");
                f2.append(viewParent);
                f2.append(" does not implement interface ");
                f2.append("method onNestedPreFling");
                Log.e("ViewParentCompat", f2.toString(), view2);
                return null;
            }
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f1297a = new C4467b();
        } else if (VERSION.SDK_INT >= 19) {
            f1297a = new C3230a();
        } else {
            f1297a = new C0521c();
        }
    }

    /* renamed from: a */
    public static boolean m1750a(ViewParent viewParent, View view, View view2, int i, int i2) {
        if (viewParent instanceof C3227n) {
            return ((C3227n) viewParent).mo2644a(view, view2, i, i2);
        }
        return i2 == 0 ? f1297a.mo2702a(viewParent, view, view2, i) : null;
    }

    /* renamed from: b */
    public static void m1751b(ViewParent viewParent, View view, View view2, int i, int i2) {
        if (viewParent instanceof C3227n) {
            ((C3227n) viewParent).mo2645b(view, view2, i, i2);
        } else if (i2 == 0) {
            f1297a.mo2703b(viewParent, view, view2, i);
        }
    }

    /* renamed from: a */
    public static void m1745a(ViewParent viewParent, View view, int i) {
        if (viewParent instanceof C3227n) {
            ((C3227n) viewParent).mo2646c(view, i);
        } else if (i == 0) {
            f1297a.mo2697a(viewParent, view);
        }
    }

    /* renamed from: a */
    public static void m1746a(ViewParent viewParent, View view, int i, int i2, int i3, int i4, int i5) {
        if (viewParent instanceof C3227n) {
            ((C3227n) viewParent).mo2642a(view, i, i2, i3, i4, i5);
        } else if (i5 == 0) {
            f1297a.mo2698a(viewParent, view, i, i2, i3, i4);
        }
    }

    /* renamed from: a */
    public static void m1747a(ViewParent viewParent, View view, int i, int i2, int[] iArr, int i3) {
        if (viewParent instanceof C3227n) {
            ((C3227n) viewParent).mo2643a(view, i, i2, iArr, i3);
        } else if (i3 == 0) {
            f1297a.mo2699a(viewParent, view, i, i2, iArr);
        }
    }

    /* renamed from: a */
    public static boolean m1749a(ViewParent viewParent, View view, float f, float f2, boolean z) {
        return f1297a.mo2701a(viewParent, view, f, f2, z);
    }

    /* renamed from: a */
    public static boolean m1748a(ViewParent viewParent, View view, float f, float f2) {
        return f1297a.mo2700a(viewParent, view, f, f2);
    }
}
