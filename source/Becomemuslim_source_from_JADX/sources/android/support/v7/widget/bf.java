package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.C0701i;
import android.support.v7.widget.RecyclerView.C0715u;
import android.view.View;

/* compiled from: ScrollbarHelper */
class bf {
    /* renamed from: a */
    static int m2744a(C0715u c0715u, ay ayVar, View view, View view2, C0701i c0701i, boolean z, boolean z2) {
        if (!(c0701i.getChildCount() == 0 || c0715u.m2402e() == 0 || view == null)) {
            if (view2 != null) {
                int min = Math.min(c0701i.getPosition(view), c0701i.getPosition(view2));
                int max = Math.max(c0701i.getPosition(view), c0701i.getPosition(view2));
                if (z2) {
                    c0715u = Math.max(0, (c0715u.m2402e() - max) - 1);
                } else {
                    c0715u = Math.max(0, min);
                }
                if (!z) {
                    return c0715u;
                }
                return Math.round((((float) c0715u) * (((float) Math.abs(ayVar.mo649b(view2) - ayVar.mo647a(view))) / ((float) (Math.abs(c0701i.getPosition(view) - c0701i.getPosition(view2)) + 1)))) + ((float) (ayVar.mo650c() - ayVar.mo647a(view))));
            }
        }
        return 0;
    }

    /* renamed from: a */
    static int m2743a(C0715u c0715u, ay ayVar, View view, View view2, C0701i c0701i, boolean z) {
        if (!(c0701i.getChildCount() == 0 || c0715u.m2402e() == null || view == null)) {
            if (view2 != null) {
                if (!z) {
                    return Math.abs(c0701i.getPosition(view) - c0701i.getPosition(view2)) + 1;
                }
                return Math.min(ayVar.mo656f(), ayVar.mo649b(view2) - ayVar.mo647a(view));
            }
        }
        return null;
    }

    /* renamed from: b */
    static int m2745b(C0715u c0715u, ay ayVar, View view, View view2, C0701i c0701i, boolean z) {
        if (!(c0701i.getChildCount() == 0 || c0715u.m2402e() == 0 || view == null)) {
            if (view2 != null) {
                if (!z) {
                    return c0715u.m2402e();
                }
                return (int) ((((float) (ayVar.mo649b(view2) - ayVar.mo647a(view))) / ((float) (Math.abs(c0701i.getPosition(view) - c0701i.getPosition(view2)) + 1))) * ((float) c0715u.m2402e()));
            }
        }
        return null;
    }
}
