package android.support.transition;

import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.Method;

/* compiled from: ViewGroupUtilsApi18 */
class ah extends ag {
    /* renamed from: a */
    private static Method f11887a;
    /* renamed from: b */
    private static boolean f11888b;

    ah() {
    }

    /* renamed from: a */
    public ae mo119a(ViewGroup viewGroup) {
        return new ad(viewGroup);
    }

    /* renamed from: a */
    public void mo120a(ViewGroup viewGroup, boolean z) {
        m14847a();
        if (f11887a != null) {
            try {
                f11887a.invoke(viewGroup, new Object[]{Boolean.valueOf(z)});
            } catch (ViewGroup viewGroup2) {
                Log.i("ViewUtilsApi18", "Failed to invoke suppressLayout method", viewGroup2);
            } catch (ViewGroup viewGroup22) {
                Log.i("ViewUtilsApi18", "Error invoking suppressLayout method", viewGroup22);
            }
        }
    }

    /* renamed from: a */
    private void m14847a() {
        if (!f11888b) {
            try {
                f11887a = ViewGroup.class.getDeclaredMethod("suppressLayout", new Class[]{Boolean.TYPE});
                f11887a.setAccessible(true);
            } catch (Throwable e) {
                Log.i("ViewUtilsApi18", "Failed to retrieve suppressLayout method", e);
            }
            f11888b = true;
        }
    }
}
