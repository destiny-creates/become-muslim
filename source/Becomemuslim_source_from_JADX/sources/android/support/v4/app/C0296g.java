package android.support.v4.app;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.Method;

/* compiled from: BundleCompat */
/* renamed from: android.support.v4.app.g */
public final class C0296g {

    /* compiled from: BundleCompat */
    /* renamed from: android.support.v4.app.g$a */
    static class C0295a {
        /* renamed from: a */
        private static Method f795a;
        /* renamed from: b */
        private static boolean f796b;
        /* renamed from: c */
        private static Method f797c;
        /* renamed from: d */
        private static boolean f798d;

        /* renamed from: a */
        public static IBinder m869a(Bundle bundle, String str) {
            if (!f796b) {
                try {
                    f795a = Bundle.class.getMethod("getIBinder", new Class[]{String.class});
                    f795a.setAccessible(true);
                } catch (Throwable e) {
                    Log.i("BundleCompatBaseImpl", "Failed to retrieve getIBinder method", e);
                }
                f796b = true;
            }
            if (f795a != null) {
                try {
                    return (IBinder) f795a.invoke(bundle, new Object[]{str});
                } catch (Bundle bundle2) {
                    Log.i("BundleCompatBaseImpl", "Failed to invoke getIBinder via reflection", bundle2);
                    f795a = null;
                }
            }
            return null;
        }

        /* renamed from: a */
        public static void m870a(Bundle bundle, String str, IBinder iBinder) {
            if (!f798d) {
                try {
                    f797c = Bundle.class.getMethod("putIBinder", new Class[]{String.class, IBinder.class});
                    f797c.setAccessible(true);
                } catch (Throwable e) {
                    Log.i("BundleCompatBaseImpl", "Failed to retrieve putIBinder method", e);
                }
                f798d = true;
            }
            if (f797c != null) {
                try {
                    f797c.invoke(bundle, new Object[]{str, iBinder});
                } catch (Bundle bundle2) {
                    Log.i("BundleCompatBaseImpl", "Failed to invoke putIBinder via reflection", bundle2);
                    f797c = null;
                }
            }
        }
    }

    /* renamed from: a */
    public static IBinder m871a(Bundle bundle, String str) {
        if (VERSION.SDK_INT >= 18) {
            return bundle.getBinder(str);
        }
        return C0295a.m869a(bundle, str);
    }

    /* renamed from: a */
    public static void m872a(Bundle bundle, String str, IBinder iBinder) {
        if (VERSION.SDK_INT >= 18) {
            bundle.putBinder(str, iBinder);
        } else {
            C0295a.m870a(bundle, str, iBinder);
        }
    }
}
