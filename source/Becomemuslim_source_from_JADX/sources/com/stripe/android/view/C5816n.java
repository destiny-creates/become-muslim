package com.stripe.android.view;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p020a.p021a.C0259a;
import android.util.TypedValue;

/* compiled from: ViewUtils */
/* renamed from: com.stripe.android.view.n */
class C5816n {
    /* renamed from: a */
    static TypedValue m24523a(Context context) {
        int i;
        if (VERSION.SDK_INT >= 21) {
            i = 16843829;
        } else {
            i = context.getResources().getIdentifier("colorAccent", "attr", context.getPackageName());
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue;
    }

    /* renamed from: b */
    static TypedValue m24526b(Context context) {
        int i;
        if (VERSION.SDK_INT >= 21) {
            i = 16843817;
        } else {
            i = context.getResources().getIdentifier("colorControlNormal", "attr", context.getPackageName());
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue;
    }

    /* renamed from: c */
    static TypedValue m24529c(Context context) {
        int i = VERSION.SDK_INT >= 21 ? 16842808 : 17170439;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue;
    }

    /* renamed from: d */
    static TypedValue m24530d(Context context) {
        int i = VERSION.SDK_INT >= 21 ? 16842806 : 17170435;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue;
    }

    /* renamed from: a */
    static Drawable m24522a(Context context, Theme theme, int i, int i2) {
        TypedValue typedValue = new TypedValue();
        theme.resolveAttribute(i, typedValue, true);
        i = typedValue.data;
        if (VERSION.SDK_INT > 23) {
            context = context.getResources().getDrawable(i2, theme);
        } else {
            context = context.getResources().getDrawable(i2);
        }
        context = C0259a.g(context);
        C0259a.a(context.mutate(), i);
        return context;
    }

    /* renamed from: a */
    static boolean m24524a(int i) {
        return Color.alpha(i) < 16;
    }

    /* renamed from: b */
    static boolean m24527b(int i) {
        return (((((double) Color.red(i)) * 0.299d) + (((double) Color.green(i)) * 0.587d)) + (((double) Color.blue(i)) * 0.114d)) / 255.0d <= 0.5d;
    }

    /* renamed from: a */
    static boolean m24525a(String str, String str2) {
        boolean z = false;
        if (str2 == null) {
            return false;
        }
        if ("American Express".equals(str) != null) {
            if (str2.trim().length() == 4) {
                z = true;
            }
            return z;
        }
        if (str2.trim().length() == 3) {
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    static String[] m24528b(String str, String str2) {
        String[] strArr;
        int i = 0;
        if (str.length() > 16) {
            str = str.substring(0, 16);
        }
        int length;
        if (str2.equals("American Express") != null) {
            int i2;
            strArr = new String[3];
            length = str.length();
            if (length > 4) {
                strArr[0] = str.substring(0, 4);
                i2 = 4;
            } else {
                i2 = 0;
            }
            if (length > 10) {
                strArr[1] = str.substring(4, 10);
                i2 = 10;
            }
            while (i < 3) {
                if (strArr[i] == null) {
                    strArr[i] = str.substring(i2);
                    break;
                }
                i++;
            }
        } else {
            strArr = new String[4];
            str2 = null;
            while (true) {
                int i3 = i + 1;
                length = i3 * 4;
                if (length >= str.length()) {
                    break;
                }
                strArr[i] = str.substring(str2, length);
                i = i3;
                str2 = length;
            }
            strArr[i] = str.substring(str2);
        }
        return strArr;
    }

    /* renamed from: a */
    static int m24521a(Context context, int i) {
        return (int) (((float) i) * context.getResources().getDisplayMetrics().density);
    }
}
