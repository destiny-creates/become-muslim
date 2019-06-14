package android.support.v4.p032h;

import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.Locale;

/* compiled from: ICUCompat */
/* renamed from: android.support.v4.h.a */
public final class C0411a {
    /* renamed from: a */
    private static Method f1066a;
    /* renamed from: b */
    private static Method f1067b;

    static {
        if (VERSION.SDK_INT >= 21) {
            try {
                f1067b = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[]{Locale.class});
                return;
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
        try {
            Class cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                f1066a = cls.getMethod("getScript", new Class[]{String.class});
                f1067b = cls.getMethod("addLikelySubtags", new Class[]{String.class});
            }
        } catch (Throwable e2) {
            f1066a = null;
            f1067b = null;
            Log.w("ICUCompat", e2);
        }
    }

    /* renamed from: a */
    public static String m1215a(Locale locale) {
        if (VERSION.SDK_INT >= 21) {
            try {
                return ((Locale) f1067b.invoke(null, new Object[]{locale})).getScript();
            } catch (Throwable e) {
                Log.w("ICUCompat", e);
                return locale.getScript();
            } catch (Throwable e2) {
                Log.w("ICUCompat", e2);
                return locale.getScript();
            }
        }
        String b = C0411a.m1216b(locale);
        if (b != null) {
            return C0411a.m1214a(b);
        }
        return null;
    }

    /* renamed from: a */
    private static String m1214a(String str) {
        try {
            if (f1066a != null) {
                return (String) f1066a.invoke(null, new Object[]{str});
            }
        } catch (String str2) {
            Log.w("ICUCompat", str2);
        } catch (String str22) {
            Log.w("ICUCompat", str22);
        }
        return null;
    }

    /* renamed from: b */
    private static String m1216b(Locale locale) {
        locale = locale.toString();
        try {
            if (f1067b != null) {
                return (String) f1067b.invoke(null, new Object[]{locale});
            }
        } catch (Throwable e) {
            Log.w("ICUCompat", e);
        } catch (Throwable e2) {
            Log.w("ICUCompat", e2);
        }
        return locale;
    }
}
