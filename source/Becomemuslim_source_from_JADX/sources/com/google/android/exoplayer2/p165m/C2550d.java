package com.google.android.exoplayer2.p165m;

import com.google.android.exoplayer2.C2571p;
import com.google.android.exoplayer2.p164l.C2527j;
import com.google.android.exoplayer2.p164l.C2529l;
import java.util.Collections;
import java.util.List;

/* compiled from: HevcConfig */
/* renamed from: com.google.android.exoplayer2.m.d */
public final class C2550d {
    /* renamed from: a */
    public final List<byte[]> f6501a;
    /* renamed from: b */
    public final int f6502b;

    /* renamed from: a */
    public static C2550d m7213a(C2529l c2529l) {
        try {
            int i;
            int h;
            c2529l.m7098d(21);
            int g = c2529l.m7103g() & 3;
            int g2 = c2529l.m7103g();
            int d = c2529l.m7097d();
            int i2 = 0;
            int i3 = 0;
            while (i2 < g2) {
                c2529l.m7098d(1);
                int h2 = c2529l.m7104h();
                i = i3;
                for (i3 = 0; i3 < h2; i3++) {
                    h = c2529l.m7104h();
                    i += h + 4;
                    c2529l.m7098d(h);
                }
                i2++;
                i3 = i;
            }
            c2529l.m7096c(d);
            Object obj = new byte[i3];
            i2 = 0;
            i = 0;
            while (i2 < g2) {
                c2529l.m7098d(1);
                h = c2529l.m7104h();
                int i4 = i;
                for (i = 0; i < h; i++) {
                    int h3 = c2529l.m7104h();
                    System.arraycopy(C2527j.f6433a, 0, obj, i4, C2527j.f6433a.length);
                    i4 += C2527j.f6433a.length;
                    System.arraycopy(c2529l.f6441a, c2529l.m7097d(), obj, i4, h3);
                    i4 += h3;
                    c2529l.m7098d(h3);
                }
                i2++;
                i = i4;
            }
            if (i3 == 0) {
                c2529l = null;
            } else {
                c2529l = Collections.singletonList(obj);
            }
            return new C2550d(c2529l, g + 1);
        } catch (C2529l c2529l2) {
            throw new C2571p("Error parsing HEVC config", c2529l2);
        }
    }

    private C2550d(List<byte[]> list, int i) {
        this.f6501a = list;
        this.f6502b = i;
    }
}
