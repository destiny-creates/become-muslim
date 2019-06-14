package android.support.v4.widget;

import android.os.Build.VERSION;
import android.widget.EdgeEffect;

/* compiled from: EdgeEffectCompat */
/* renamed from: android.support.v4.widget.j */
public final class C0555j {
    /* renamed from: a */
    private static final C0554b f1395a;

    /* compiled from: EdgeEffectCompat */
    /* renamed from: android.support.v4.widget.j$b */
    static class C0554b {
        C0554b() {
        }

        /* renamed from: a */
        public void mo340a(EdgeEffect edgeEffect, float f, float f2) {
            edgeEffect.onPull(f);
        }
    }

    /* compiled from: EdgeEffectCompat */
    /* renamed from: android.support.v4.widget.j$a */
    static class C3240a extends C0554b {
        C3240a() {
        }

        /* renamed from: a */
        public void mo340a(EdgeEffect edgeEffect, float f, float f2) {
            edgeEffect.onPull(f, f2);
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f1395a = new C3240a();
        } else {
            f1395a = new C0554b();
        }
    }

    /* renamed from: a */
    public static void m1880a(EdgeEffect edgeEffect, float f, float f2) {
        f1395a.mo340a(edgeEffect, f, f2);
    }
}
