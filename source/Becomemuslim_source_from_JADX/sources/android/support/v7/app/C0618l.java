package android.support.v7.app;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

/* compiled from: ResourcesFlusher */
/* renamed from: android.support.v7.app.l */
class C0618l {
    /* renamed from: a */
    private static Field f1591a;
    /* renamed from: b */
    private static boolean f1592b;
    /* renamed from: c */
    private static Class f1593c;
    /* renamed from: d */
    private static boolean f1594d;
    /* renamed from: e */
    private static Field f1595e;
    /* renamed from: f */
    private static boolean f1596f;
    /* renamed from: g */
    private static Field f1597g;
    /* renamed from: h */
    private static boolean f1598h;

    /* renamed from: a */
    static boolean m2091a(Resources resources) {
        if (VERSION.SDK_INT >= 24) {
            return C0618l.m2095d(resources);
        }
        if (VERSION.SDK_INT >= 23) {
            return C0618l.m2094c(resources);
        }
        return VERSION.SDK_INT >= 21 ? C0618l.m2093b(resources) : null;
    }

    /* renamed from: b */
    private static boolean m2093b(Resources resources) {
        if (!f1592b) {
            try {
                f1591a = Resources.class.getDeclaredField("mDrawableCache");
                f1591a.setAccessible(true);
            } catch (Throwable e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e);
            }
            f1592b = true;
        }
        if (f1591a != null) {
            try {
                resources = (Map) f1591a.get(resources);
            } catch (Resources resources2) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", resources2);
                resources2 = null;
            }
            if (resources2 != null) {
                resources2.clear();
                return true;
            }
        }
        return null;
    }

    /* renamed from: c */
    private static boolean m2094c(Resources resources) {
        Object obj;
        boolean z;
        if (!f1592b) {
            try {
                f1591a = Resources.class.getDeclaredField("mDrawableCache");
                f1591a.setAccessible(true);
            } catch (Throwable e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e);
            }
            f1592b = true;
        }
        if (f1591a != null) {
            try {
                obj = f1591a.get(resources);
            } catch (Resources resources2) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", resources2);
            }
            z = false;
            if (obj == null) {
                return false;
            }
            if (!(obj == null || C0618l.m2092a(obj) == null)) {
                z = true;
            }
            return z;
        }
        obj = null;
        z = false;
        if (obj == null) {
            return false;
        }
        z = true;
        return z;
    }

    /* renamed from: d */
    private static boolean m2095d(Resources resources) {
        boolean z = true;
        if (!f1598h) {
            try {
                f1597g = Resources.class.getDeclaredField("mResourcesImpl");
                f1597g.setAccessible(true);
            } catch (Throwable e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e);
            }
            f1598h = true;
        }
        if (f1597g == null) {
            return false;
        }
        try {
            resources = f1597g.get(resources);
        } catch (Resources resources2) {
            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", resources2);
            resources2 = null;
        }
        if (resources2 == null) {
            return false;
        }
        Object obj;
        if (!f1592b) {
            try {
                f1591a = resources2.getClass().getDeclaredField("mDrawableCache");
                f1591a.setAccessible(true);
            } catch (Throwable e2) {
                Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e2);
            }
            f1592b = true;
        }
        if (f1591a != null) {
            try {
                obj = f1591a.get(resources2);
            } catch (Resources resources22) {
                Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", resources22);
            }
            if (obj != null || C0618l.m2092a(obj) == null) {
                z = false;
            }
            return z;
        }
        obj = null;
        if (obj != null) {
        }
        z = false;
        return z;
    }

    /* renamed from: a */
    private static boolean m2092a(Object obj) {
        if (!f1594d) {
            try {
                f1593c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (Throwable e) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e);
            }
            f1594d = true;
        }
        if (f1593c == null) {
            return false;
        }
        if (!f1596f) {
            try {
                f1595e = f1593c.getDeclaredField("mUnthemedEntries");
                f1595e.setAccessible(true);
            } catch (Throwable e2) {
                Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e2);
            }
            f1596f = true;
        }
        if (f1595e == null) {
            return false;
        }
        try {
            obj = (LongSparseArray) f1595e.get(obj);
        } catch (Object obj2) {
            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", obj2);
            obj2 = null;
        }
        if (obj2 == null) {
            return false;
        }
        obj2.clear();
        return true;
    }
}
