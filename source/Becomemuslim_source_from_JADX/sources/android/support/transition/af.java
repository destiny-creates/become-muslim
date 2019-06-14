package android.support.transition;

import android.os.Build.VERSION;
import android.view.ViewGroup;

/* compiled from: ViewGroupUtils */
class af {
    /* renamed from: a */
    private static final ai f548a;

    static {
        if (VERSION.SDK_INT >= 18) {
            f548a = new ah();
        } else {
            f548a = new ag();
        }
    }

    /* renamed from: a */
    static ae m558a(ViewGroup viewGroup) {
        return f548a.mo119a(viewGroup);
    }

    /* renamed from: a */
    static void m559a(ViewGroup viewGroup, boolean z) {
        f548a.mo120a(viewGroup, z);
    }
}
