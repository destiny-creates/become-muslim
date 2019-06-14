package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.content.p027b.C0364b;
import android.support.v4.content.p027b.C0364b.C0363a;
import android.support.v7.p037c.p038a.C0631b;
import android.util.AttributeSet;
import android.util.TypedValue;

/* compiled from: TintTypedArray */
public class bq {
    /* renamed from: a */
    private final Context f2137a;
    /* renamed from: b */
    private final TypedArray f2138b;
    /* renamed from: c */
    private TypedValue f2139c;

    /* renamed from: a */
    public static bq m2768a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new bq(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    /* renamed from: a */
    public static bq m2769a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new bq(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    /* renamed from: a */
    public static bq m2767a(Context context, int i, int[] iArr) {
        return new bq(context, context.obtainStyledAttributes(i, iArr));
    }

    private bq(Context context, TypedArray typedArray) {
        this.f2137a = context;
        this.f2138b = typedArray;
    }

    /* renamed from: a */
    public Drawable m2773a(int i) {
        if (this.f2138b.hasValue(i)) {
            int resourceId = this.f2138b.getResourceId(i, 0);
            if (resourceId != 0) {
                return C0631b.m2112b(this.f2137a, resourceId);
            }
        }
        return this.f2138b.getDrawable(i);
    }

    /* renamed from: b */
    public Drawable m2777b(int i) {
        if (this.f2138b.hasValue(i)) {
            i = this.f2138b.getResourceId(i, 0);
            if (i != 0) {
                return C0799m.m2896a().m2916a(this.f2137a, i, true);
            }
        }
        return 0;
    }

    /* renamed from: a */
    public Typeface m2772a(int i, int i2, C0363a c0363a) {
        i = this.f2138b.getResourceId(i, 0);
        if (i == 0) {
            return 0;
        }
        if (this.f2139c == null) {
            this.f2139c = new TypedValue();
        }
        return C0364b.m1090a(this.f2137a, i, this.f2139c, i2, c0363a);
    }

    /* renamed from: c */
    public CharSequence m2779c(int i) {
        return this.f2138b.getText(i);
    }

    /* renamed from: d */
    public String m2781d(int i) {
        return this.f2138b.getString(i);
    }

    /* renamed from: a */
    public boolean m2775a(int i, boolean z) {
        return this.f2138b.getBoolean(i, z);
    }

    /* renamed from: a */
    public int m2771a(int i, int i2) {
        return this.f2138b.getInt(i, i2);
    }

    /* renamed from: a */
    public float m2770a(int i, float f) {
        return this.f2138b.getFloat(i, f);
    }

    /* renamed from: b */
    public int m2776b(int i, int i2) {
        return this.f2138b.getColor(i, i2);
    }

    /* renamed from: e */
    public ColorStateList m2783e(int i) {
        if (this.f2138b.hasValue(i)) {
            int resourceId = this.f2138b.getResourceId(i, 0);
            if (resourceId != 0) {
                ColorStateList a = C0631b.m2109a(this.f2137a, resourceId);
                if (a != null) {
                    return a;
                }
            }
        }
        return this.f2138b.getColorStateList(i);
    }

    /* renamed from: c */
    public int m2778c(int i, int i2) {
        return this.f2138b.getInteger(i, i2);
    }

    /* renamed from: d */
    public int m2780d(int i, int i2) {
        return this.f2138b.getDimensionPixelOffset(i, i2);
    }

    /* renamed from: e */
    public int m2782e(int i, int i2) {
        return this.f2138b.getDimensionPixelSize(i, i2);
    }

    /* renamed from: f */
    public int m2784f(int i, int i2) {
        return this.f2138b.getLayoutDimension(i, i2);
    }

    /* renamed from: g */
    public int m2786g(int i, int i2) {
        return this.f2138b.getResourceId(i, i2);
    }

    /* renamed from: f */
    public CharSequence[] m2785f(int i) {
        return this.f2138b.getTextArray(i);
    }

    /* renamed from: g */
    public boolean m2787g(int i) {
        return this.f2138b.hasValue(i);
    }

    /* renamed from: a */
    public void m2774a() {
        this.f2138b.recycle();
    }
}
