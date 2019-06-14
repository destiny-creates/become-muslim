package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.WindowInsets;

/* compiled from: WindowInsetsCompat */
public class aa {
    /* renamed from: a */
    private final Object f1258a;

    private aa(Object obj) {
        this.f1258a = obj;
    }

    /* renamed from: a */
    public int m1561a() {
        return VERSION.SDK_INT >= 20 ? ((WindowInsets) this.f1258a).getSystemWindowInsetLeft() : 0;
    }

    /* renamed from: b */
    public int m1563b() {
        return VERSION.SDK_INT >= 20 ? ((WindowInsets) this.f1258a).getSystemWindowInsetTop() : 0;
    }

    /* renamed from: c */
    public int m1564c() {
        return VERSION.SDK_INT >= 20 ? ((WindowInsets) this.f1258a).getSystemWindowInsetRight() : 0;
    }

    /* renamed from: d */
    public int m1565d() {
        return VERSION.SDK_INT >= 20 ? ((WindowInsets) this.f1258a).getSystemWindowInsetBottom() : 0;
    }

    /* renamed from: e */
    public boolean m1566e() {
        return VERSION.SDK_INT >= 21 ? ((WindowInsets) this.f1258a).isConsumed() : false;
    }

    /* renamed from: a */
    public aa m1562a(int i, int i2, int i3, int i4) {
        return VERSION.SDK_INT >= 20 ? new aa(((WindowInsets) this.f1258a).replaceSystemWindowInsets(i, i2, i3, i4)) : 0;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                aa aaVar = (aa) obj;
                if (this.f1258a != null) {
                    z = this.f1258a.equals(aaVar.f1258a);
                } else if (aaVar.f1258a != null) {
                    z = false;
                }
                return z;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f1258a == null ? 0 : this.f1258a.hashCode();
    }

    /* renamed from: a */
    static aa m1559a(Object obj) {
        return obj == null ? null : new aa(obj);
    }

    /* renamed from: a */
    static Object m1560a(aa aaVar) {
        return aaVar == null ? null : aaVar.f1258a;
    }
}
