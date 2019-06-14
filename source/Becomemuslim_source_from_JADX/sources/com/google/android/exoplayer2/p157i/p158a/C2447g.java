package com.google.android.exoplayer2.p157i.p158a;

import android.util.Log;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.p137e.C2329m;
import com.google.android.exoplayer2.p164l.C2529l;

/* compiled from: CeaUtil */
/* renamed from: com.google.android.exoplayer2.i.a.g */
public final class C2447g {
    /* renamed from: a */
    public static void m6765a(long j, C2529l c2529l, C2329m[] c2329mArr) {
        while (c2529l.m7093b() > 1) {
            int a = C2447g.m6764a(c2529l);
            int a2 = C2447g.m6764a(c2529l);
            if (a2 != -1) {
                if (a2 <= c2529l.m7093b()) {
                    if (C2447g.m6766a(a, a2, c2529l)) {
                        c2529l.m7098d(8);
                        a = c2529l.m7103g() & 31;
                        c2529l.m7098d(1);
                        a *= 3;
                        int d = c2529l.m7097d();
                        for (C2329m c2329m : c2329mArr) {
                            c2529l.m7096c(d);
                            c2329m.mo2200a(c2529l, a);
                            c2329m.mo2198a(j, 1, a, 0, null);
                        }
                        c2529l.m7098d(a2 - (a + 10));
                    } else {
                        c2529l.m7098d(a2);
                    }
                }
            }
            Log.w("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
            c2529l.m7096c(c2529l.m7095c());
        }
    }

    /* renamed from: a */
    private static int m6764a(C2529l c2529l) {
        int i = 0;
        while (c2529l.m7093b() != 0) {
            int g = c2529l.m7103g();
            i += g;
            if (g != JfifUtil.MARKER_FIRST_BYTE) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: a */
    private static boolean m6766a(int i, int i2, C2529l c2529l) {
        boolean z = false;
        if (i == 4) {
            if (i2 >= 8) {
                i = c2529l.m7097d();
                i2 = c2529l.m7103g();
                int h = c2529l.m7104h();
                int o = c2529l.m7111o();
                int g = c2529l.m7103g();
                c2529l.m7096c(i);
                if (i2 == 181 && h == 49 && o == 1195456820 && g == 3) {
                    z = true;
                }
                return z;
            }
        }
        return false;
    }
}
