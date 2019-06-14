package com.facebook.ads.internal.p105q.p106a;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.facebook.ads.internal.q.a.w */
public class C1523w {
    /* renamed from: a */
    public static final DisplayMetrics f4502a = Resources.getSystem().getDisplayMetrics();
    /* renamed from: b */
    public static final float f4503b = f4502a.density;
    /* renamed from: c */
    private static final AtomicInteger f4504c = new AtomicInteger(1);

    /* renamed from: a */
    public static int m5339a() {
        int i;
        int i2;
        do {
            i = f4504c.get();
            i2 = i + 1;
            if (i2 > 16777215) {
                i2 = 1;
            }
        } while (!f4504c.compareAndSet(i, i2));
        return i;
    }

    /* renamed from: a */
    public static int m5340a(int i) {
        return (int) TypedValue.applyDimension(2, (float) i, f4502a);
    }

    /* renamed from: a */
    public static void m5341a(View view) {
        view.setId(VERSION.SDK_INT >= 17 ? View.generateViewId() : C1523w.m5339a());
    }

    /* renamed from: a */
    public static void m5342a(View view, int i) {
        if (VERSION.SDK_INT >= 16) {
            view.setBackground(new ColorDrawable(i));
        } else {
            view.setBackgroundDrawable(new ColorDrawable(i));
        }
    }

    /* renamed from: a */
    public static void m5343a(View view, Drawable drawable) {
        if (VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    /* renamed from: a */
    public static void m5344a(TextView textView, boolean z, int i) {
        Typeface typeface;
        int i2 = 0;
        if (!z) {
            typeface = Typeface.SANS_SERIF;
        } else if (VERSION.SDK_INT >= 21) {
            typeface = Typeface.create("sans-serif-medium", 0);
            textView.setTypeface(typeface);
            textView.setTextSize(2, (float) i);
        } else {
            typeface = Typeface.SANS_SERIF;
            i2 = 1;
        }
        typeface = Typeface.create(typeface, i2);
        textView.setTypeface(typeface);
        textView.setTextSize(2, (float) i);
    }

    /* renamed from: a */
    public static void m5345a(View... viewArr) {
        for (View b : viewArr) {
            C1523w.m5346b(b);
        }
    }

    /* renamed from: b */
    public static void m5346b(View view) {
        if (view != null) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
        }
    }
}
