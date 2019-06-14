package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup.MarginLayoutParams;

/* compiled from: MarginLayoutParamsCompat */
/* renamed from: android.support.v4.view.g */
public final class C0504g {
    /* renamed from: a */
    public static int m1592a(MarginLayoutParams marginLayoutParams) {
        if (VERSION.SDK_INT >= 17) {
            return marginLayoutParams.getMarginStart();
        }
        return marginLayoutParams.leftMargin;
    }

    /* renamed from: b */
    public static int m1593b(MarginLayoutParams marginLayoutParams) {
        if (VERSION.SDK_INT >= 17) {
            return marginLayoutParams.getMarginEnd();
        }
        return marginLayoutParams.rightMargin;
    }
}
