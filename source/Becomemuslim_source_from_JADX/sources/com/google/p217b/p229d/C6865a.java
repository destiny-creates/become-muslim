package com.google.p217b.p229d;

import com.google.p217b.C5193a;
import com.google.p217b.C5232c;
import com.google.p217b.C5254e;
import com.google.p217b.C5312o;
import com.google.p217b.C5314q;
import com.google.p217b.C5315r;
import com.google.p217b.C5316s;
import com.google.p217b.C6894l;
import com.google.p217b.p222b.C5202b;
import com.google.p217b.p229d.p230a.C5235c;
import java.util.Map;

/* compiled from: MaxiCodeReader */
/* renamed from: com.google.b.d.a */
public final class C6865a implements C5312o {
    /* renamed from: a */
    private static final C5316s[] f24682a = new C5316s[0];
    /* renamed from: b */
    private final C5235c f24683b = new C5235c();

    /* renamed from: a */
    public C5314q mo4858a(C5232c c5232c, Map<C5254e, ?> map) {
        if (map == null || !map.containsKey(C5254e.PURE_BARCODE)) {
            throw C6894l.m32349a();
        }
        c5232c = this.f24683b.m22178a(C6865a.m32275a(c5232c.m22164c()), map);
        map = new C5314q(c5232c.m22026c(), c5232c.m22023a(), f24682a, C5193a.MAXICODE);
        c5232c = c5232c.m22028e();
        if (c5232c != null) {
            map.m22572a(C5315r.ERROR_CORRECTION_LEVEL, c5232c);
        }
        return map;
    }

    /* renamed from: a */
    private static C5202b m32275a(C5202b c5202b) {
        int[] c = c5202b.m22007c();
        if (c != null) {
            int i = c[0];
            int i2 = c[1];
            int i3 = c[2];
            int i4 = c[3];
            C5202b c5202b2 = new C5202b(30, 33);
            for (int i5 = 0; i5 < 33; i5++) {
                int i6 = (((i5 * i4) + (i4 / 2)) / 33) + i2;
                for (int i7 = 0; i7 < 30; i7++) {
                    if (c5202b.m22002a(((((i7 * i3) + (i3 / 2)) + (((i5 & 1) * i3) / 2)) / 30) + i, i6)) {
                        c5202b2.m22004b(i7, i5);
                    }
                }
            }
            return c5202b2;
        }
        throw C6894l.m32349a();
    }
}
