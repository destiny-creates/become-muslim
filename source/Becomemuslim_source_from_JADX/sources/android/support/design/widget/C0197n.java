package android.support.design.widget;

import android.content.Context;
import android.support.v7.p035a.C0591a.C0581a;

/* compiled from: ThemeUtils */
/* renamed from: android.support.design.widget.n */
class C0197n {
    /* renamed from: a */
    private static final int[] f453a = new int[]{C0581a.colorPrimary};

    /* renamed from: a */
    static void m454a(Context context) {
        context = context.obtainStyledAttributes(f453a);
        int hasValue = context.hasValue(0) ^ 1;
        context.recycle();
        if (hasValue != 0) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }
}
