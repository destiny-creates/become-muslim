package android.support.v4.util;

import android.os.Build.VERSION;
import java.util.Objects;

/* compiled from: ObjectsCompat */
/* renamed from: android.support.v4.util.i */
public class C0460i {
    /* renamed from: a */
    public static boolean m1449a(Object obj, Object obj2) {
        if (VERSION.SDK_INT >= 19) {
            return Objects.equals(obj, obj2);
        }
        if (obj != obj2) {
            if (obj == null || obj.equals(obj2) == null) {
                obj = null;
                return obj;
            }
        }
        obj = true;
        return obj;
    }
}
