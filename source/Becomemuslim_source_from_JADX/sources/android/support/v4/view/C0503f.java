package android.support.v4.view;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import java.lang.reflect.Field;

/* compiled from: LayoutInflaterCompat */
/* renamed from: android.support.v4.view.f */
public final class C0503f {
    /* renamed from: a */
    static final C0502b f1272a;
    /* renamed from: b */
    private static Field f1273b;
    /* renamed from: c */
    private static boolean f1274c;

    /* compiled from: LayoutInflaterCompat */
    /* renamed from: android.support.v4.view.f$b */
    static class C0502b {
        C0502b() {
        }

        /* renamed from: a */
        public void mo318a(LayoutInflater layoutInflater, Factory2 factory2) {
            layoutInflater.setFactory2(factory2);
            Factory factory = layoutInflater.getFactory();
            if (factory instanceof Factory2) {
                C0503f.m1590a(layoutInflater, (Factory2) factory);
            } else {
                C0503f.m1590a(layoutInflater, factory2);
            }
        }
    }

    /* compiled from: LayoutInflaterCompat */
    /* renamed from: android.support.v4.view.f$a */
    static class C3224a extends C0502b {
        C3224a() {
        }

        /* renamed from: a */
        public void mo318a(LayoutInflater layoutInflater, Factory2 factory2) {
            layoutInflater.setFactory2(factory2);
        }
    }

    /* renamed from: a */
    static void m1590a(LayoutInflater layoutInflater, Factory2 factory2) {
        if (!f1274c) {
            try {
                f1273b = LayoutInflater.class.getDeclaredField("mFactory2");
                f1273b.setAccessible(true);
            } catch (Throwable e) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("forceSetFactory2 Could not find field 'mFactory2' on class ");
                stringBuilder.append(LayoutInflater.class.getName());
                stringBuilder.append("; inflation may have unexpected results.");
                Log.e("LayoutInflaterCompatHC", stringBuilder.toString(), e);
            }
            f1274c = true;
        }
        if (f1273b != null) {
            try {
                f1273b.set(layoutInflater, factory2);
            } catch (Factory2 factory22) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("forceSetFactory2 could not set the Factory2 on LayoutInflater ");
                stringBuilder2.append(layoutInflater);
                stringBuilder2.append("; inflation may have unexpected results.");
                Log.e("LayoutInflaterCompatHC", stringBuilder2.toString(), factory22);
            }
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f1272a = new C3224a();
        } else {
            f1272a = new C0502b();
        }
    }

    /* renamed from: b */
    public static void m1591b(LayoutInflater layoutInflater, Factory2 factory2) {
        f1272a.mo318a(layoutInflater, factory2);
    }
}
