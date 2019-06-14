package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.p013a.C0093a.C0091a;
import android.view.ViewGroup;

/* compiled from: ViewGroupCompat */
/* renamed from: android.support.v4.view.u */
public final class C0520u {
    /* renamed from: a */
    static final C0519c f1296a;

    /* compiled from: ViewGroupCompat */
    /* renamed from: android.support.v4.view.u$c */
    static class C0519c {
        C0519c() {
        }

        /* renamed from: a */
        public boolean mo2696a(ViewGroup viewGroup) {
            Boolean bool = (Boolean) viewGroup.getTag(C0091a.tag_transition_group);
            if ((bool == null || !bool.booleanValue()) && viewGroup.getBackground() == null) {
                if (C0517s.m1719m(viewGroup) == null) {
                    return null;
                }
            }
            return true;
        }
    }

    /* compiled from: ViewGroupCompat */
    /* renamed from: android.support.v4.view.u$a */
    static class C3229a extends C0519c {
        C3229a() {
        }
    }

    /* compiled from: ViewGroupCompat */
    /* renamed from: android.support.v4.view.u$b */
    static class C4466b extends C3229a {
        C4466b() {
        }

        /* renamed from: a */
        public boolean mo2696a(ViewGroup viewGroup) {
            return viewGroup.isTransitionGroup();
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f1296a = new C4466b();
        } else if (VERSION.SDK_INT >= 18) {
            f1296a = new C3229a();
        } else {
            f1296a = new C0519c();
        }
    }

    /* renamed from: a */
    public static boolean m1737a(ViewGroup viewGroup) {
        return f1296a.mo2696a(viewGroup);
    }
}
