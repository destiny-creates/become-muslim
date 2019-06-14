package android.support.v4.view.p033a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityRecord;

/* compiled from: AccessibilityRecordCompat */
/* renamed from: android.support.v4.view.a.d */
public class C0486d {
    /* renamed from: a */
    private final AccessibilityRecord f1255a;

    /* renamed from: a */
    public static void m1556a(AccessibilityRecord accessibilityRecord, int i) {
        if (VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollX(i);
        }
    }

    /* renamed from: b */
    public static void m1557b(AccessibilityRecord accessibilityRecord, int i) {
        if (VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollY(i);
        }
    }

    @Deprecated
    public int hashCode() {
        return this.f1255a == null ? 0 : this.f1255a.hashCode();
    }

    @Deprecated
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0486d c0486d = (C0486d) obj;
        if (this.f1255a == null) {
            if (c0486d.f1255a != null) {
                return false;
            }
        } else if (this.f1255a.equals(c0486d.f1255a) == null) {
            return false;
        }
        return true;
    }
}
