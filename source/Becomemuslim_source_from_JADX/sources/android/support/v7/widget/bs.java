package android.support.v7.widget;

import android.os.Build.VERSION;
import android.view.View;

/* compiled from: TooltipCompat */
public class bs {
    /* renamed from: a */
    public static void m2788a(View view, CharSequence charSequence) {
        if (VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence);
        } else {
            bt.m2792a(view, charSequence);
        }
    }
}
