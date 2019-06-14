package android.support.v7.p037c.p038a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.content.C0366b;
import android.support.v7.widget.C0799m;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;

/* compiled from: AppCompatResources */
/* renamed from: android.support.v7.c.a.b */
public final class C0631b {
    /* renamed from: a */
    private static final ThreadLocal<TypedValue> f1616a = new ThreadLocal();
    /* renamed from: b */
    private static final WeakHashMap<Context, SparseArray<C0630a>> f1617b = new WeakHashMap(0);
    /* renamed from: c */
    private static final Object f1618c = new Object();

    /* compiled from: AppCompatResources */
    /* renamed from: android.support.v7.c.a.b$a */
    private static class C0630a {
        /* renamed from: a */
        final ColorStateList f1614a;
        /* renamed from: b */
        final Configuration f1615b;

        C0630a(ColorStateList colorStateList, Configuration configuration) {
            this.f1614a = colorStateList;
            this.f1615b = configuration;
        }
    }

    /* renamed from: a */
    public static ColorStateList m2109a(Context context, int i) {
        if (VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        ColorStateList d = C0631b.m2114d(context, i);
        if (d != null) {
            return d;
        }
        d = C0631b.m2113c(context, i);
        if (d == null) {
            return C0366b.m1110b(context, i);
        }
        C0631b.m2111a(context, i, d);
        return d;
    }

    /* renamed from: b */
    public static Drawable m2112b(Context context, int i) {
        return C0799m.m2896a().m2915a(context, i);
    }

    /* renamed from: c */
    private static ColorStateList m2113c(Context context, int i) {
        if (C0631b.m2115e(context, i)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            return C0629a.m2105a(resources, resources.getXml(i), context.getTheme());
        } catch (Context context2) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", context2);
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: d */
    private static android.content.res.ColorStateList m2114d(android.content.Context r4, int r5) {
        /*
        r0 = f1618c;
        monitor-enter(r0);
        r1 = f1617b;	 Catch:{ all -> 0x0035 }
        r1 = r1.get(r4);	 Catch:{ all -> 0x0035 }
        r1 = (android.util.SparseArray) r1;	 Catch:{ all -> 0x0035 }
        if (r1 == 0) goto L_0x0032;
    L_0x000d:
        r2 = r1.size();	 Catch:{ all -> 0x0035 }
        if (r2 <= 0) goto L_0x0032;
    L_0x0013:
        r2 = r1.get(r5);	 Catch:{ all -> 0x0035 }
        r2 = (android.support.v7.p037c.p038a.C0631b.C0630a) r2;	 Catch:{ all -> 0x0035 }
        if (r2 == 0) goto L_0x0032;
    L_0x001b:
        r3 = r2.f1615b;	 Catch:{ all -> 0x0035 }
        r4 = r4.getResources();	 Catch:{ all -> 0x0035 }
        r4 = r4.getConfiguration();	 Catch:{ all -> 0x0035 }
        r4 = r3.equals(r4);	 Catch:{ all -> 0x0035 }
        if (r4 == 0) goto L_0x002f;
    L_0x002b:
        r4 = r2.f1614a;	 Catch:{ all -> 0x0035 }
        monitor-exit(r0);	 Catch:{ all -> 0x0035 }
        return r4;
    L_0x002f:
        r1.remove(r5);	 Catch:{ all -> 0x0035 }
    L_0x0032:
        monitor-exit(r0);	 Catch:{ all -> 0x0035 }
        r4 = 0;
        return r4;
    L_0x0035:
        r4 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0035 }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.c.a.b.d(android.content.Context, int):android.content.res.ColorStateList");
    }

    /* renamed from: a */
    private static void m2111a(Context context, int i, ColorStateList colorStateList) {
        synchronized (f1618c) {
            SparseArray sparseArray = (SparseArray) f1617b.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                f1617b.put(context, sparseArray);
            }
            sparseArray.append(i, new C0630a(colorStateList, context.getResources().getConfiguration()));
        }
    }

    /* renamed from: e */
    private static boolean m2115e(Context context, int i) {
        context = context.getResources();
        TypedValue a = C0631b.m2110a();
        context.getValue(i, a, true);
        if (a.type < 28 || a.type > 31) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private static TypedValue m2110a() {
        TypedValue typedValue = (TypedValue) f1616a.get();
        if (typedValue != null) {
            return typedValue;
        }
        typedValue = new TypedValue();
        f1616a.set(typedValue);
        return typedValue;
    }
}
