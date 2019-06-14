package com.facebook.ads.internal.view.component.p116a;

import com.facebook.ads.internal.adapters.p086a.C1312d;
import com.facebook.ads.internal.adapters.p086a.C1316h;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.view.component.C1599a;

/* renamed from: com.facebook.ads.internal.view.component.a.c */
public final class C1594c {
    /* renamed from: a */
    private static final int f4760a = C1523w.f4502a.heightPixels;
    /* renamed from: b */
    private static final int f4761b = C1523w.f4502a.widthPixels;

    /* renamed from: a */
    private static float m5541a(C1316h c1316h) {
        int h = c1316h.m4535c().m4492h();
        int i = c1316h.m4535c().m4493i();
        return i > 0 ? ((float) h) / ((float) i) : -1.0f;
    }

    /* renamed from: a */
    private static int m5542a(int i) {
        return (f4760a - i) - ((C1523w.m5340a(16) + (C1599a.f4786a * 2)) + (C3632e.a * 2));
    }

    /* renamed from: a */
    public static C1593b m5543a(C1597d c1597d) {
        C1593b c3631a;
        boolean z = true;
        C1312d a = c1597d.m5574k() == 1 ? c1597d.m5570g().m4525b().m4463a() : c1597d.m5570g().m4525b().m4464b();
        C1316h c1316h = (C1316h) c1597d.m5570g().m4527d().get(0);
        double a2 = (double) C1594c.m5541a(c1316h);
        if (C1594c.m5546a(c1597d.m5574k(), c1597d.m5573j(), a2)) {
            if (c1597d.m5574k() != 2) {
                z = false;
            }
            c3631a = new C3631a(c1597d, a, z);
        } else {
            c3631a = new C3632e(c1597d, C1594c.m5544a(a2), a);
        }
        c3631a.mo1025a(c1316h, c1597d.m5570g().m4526c(), a2);
        return c3631a;
    }

    /* renamed from: a */
    private static boolean m5544a(double d) {
        return d < 0.9d;
    }

    /* renamed from: a */
    private static boolean m5545a(double d, int i) {
        return C1594c.m5542a(i) < C1594c.m5547b(d);
    }

    /* renamed from: a */
    private static boolean m5546a(int i, int i2, double d) {
        if (i != 2) {
            if (!C1594c.m5545a(d, i2)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    private static int m5547b(double d) {
        return (int) (((double) (f4761b - (C3632e.a * 2))) / d);
    }
}
