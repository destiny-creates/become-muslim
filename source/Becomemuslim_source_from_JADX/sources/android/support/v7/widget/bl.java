package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v4.p020a.C0264a;
import android.util.TypedValue;

/* compiled from: ThemeUtils */
class bl {
    /* renamed from: a */
    static final int[] f2119a = new int[]{-16842910};
    /* renamed from: b */
    static final int[] f2120b = new int[]{16842908};
    /* renamed from: c */
    static final int[] f2121c = new int[]{16843518};
    /* renamed from: d */
    static final int[] f2122d = new int[]{16842919};
    /* renamed from: e */
    static final int[] f2123e = new int[]{16842912};
    /* renamed from: f */
    static final int[] f2124f = new int[]{16842913};
    /* renamed from: g */
    static final int[] f2125g = new int[]{-16842919, -16842908};
    /* renamed from: h */
    static final int[] f2126h = new int[0];
    /* renamed from: i */
    private static final ThreadLocal<TypedValue> f2127i = new ThreadLocal();
    /* renamed from: j */
    private static final int[] f2128j = new int[1];

    /* renamed from: a */
    public static int m2757a(Context context, int i) {
        f2128j[0] = i;
        context = bq.m2768a(context, null, f2128j);
        try {
            i = context.m2776b(0, 0);
            return i;
        } finally {
            context.m2774a();
        }
    }

    /* renamed from: b */
    public static ColorStateList m2760b(Context context, int i) {
        f2128j[0] = i;
        context = bq.m2768a(context, null, f2128j);
        try {
            i = context.m2783e(0);
            return i;
        } finally {
            context.m2774a();
        }
    }

    /* renamed from: c */
    public static int m2761c(Context context, int i) {
        ColorStateList b = m2760b(context, i);
        if (b != null && b.isStateful()) {
            return b.getColorForState(f2119a, b.getDefaultColor());
        }
        TypedValue a = m2759a();
        context.getTheme().resolveAttribute(16842803, a, true);
        return m2758a(context, i, a.getFloat());
    }

    /* renamed from: a */
    private static TypedValue m2759a() {
        TypedValue typedValue = (TypedValue) f2127i.get();
        if (typedValue != null) {
            return typedValue;
        }
        typedValue = new TypedValue();
        f2127i.set(typedValue);
        return typedValue;
    }

    /* renamed from: a */
    static int m2758a(Context context, int i, float f) {
        context = m2757a(context, i);
        return C0264a.m717b(context, Math.round(((float) Color.alpha(context)) * f));
    }
}
