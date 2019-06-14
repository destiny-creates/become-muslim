package android.support.v4.view.p033a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: AccessibilityEventCompat */
/* renamed from: android.support.v4.view.a.a */
public final class C0479a {
    /* renamed from: a */
    public static void m1495a(AccessibilityEvent accessibilityEvent, int i) {
        if (VERSION.SDK_INT >= 19) {
            accessibilityEvent.setContentChangeTypes(i);
        }
    }

    /* renamed from: a */
    public static int m1494a(AccessibilityEvent accessibilityEvent) {
        return VERSION.SDK_INT >= 19 ? accessibilityEvent.getContentChangeTypes() : null;
    }
}
