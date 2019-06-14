package com.google.android.exoplayer2.p165m;

import com.google.android.exoplayer2.C2571p;
import com.google.android.exoplayer2.p164l.C2518c;
import com.google.android.exoplayer2.p164l.C2527j;
import com.google.android.exoplayer2.p164l.C2529l;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AvcConfig */
/* renamed from: com.google.android.exoplayer2.m.a */
public final class C2544a {
    /* renamed from: a */
    public final List<byte[]> f6477a;
    /* renamed from: b */
    public final int f6478b;
    /* renamed from: c */
    public final int f6479c;
    /* renamed from: d */
    public final int f6480d;
    /* renamed from: e */
    public final float f6481e;

    /* renamed from: a */
    public static C2544a m7201a(C2529l c2529l) {
        try {
            c2529l.m7098d(4);
            int g = (c2529l.m7103g() & 3) + 1;
            if (g != 3) {
                int i;
                int i2;
                float f;
                int i3;
                List arrayList = new ArrayList();
                int g2 = c2529l.m7103g() & 31;
                for (i = 0; i < g2; i++) {
                    arrayList.add(C2544a.m7202b(c2529l));
                }
                i = c2529l.m7103g();
                for (i2 = 0; i2 < i; i2++) {
                    arrayList.add(C2544a.m7202b(c2529l));
                }
                if (g2 > 0) {
                    c2529l = C2527j.m7062a((byte[]) arrayList.get(0), g, ((byte[]) arrayList.get(0)).length);
                    g2 = c2529l.f6424b;
                    int i4 = c2529l.f6425c;
                    f = c2529l.f6426d;
                    i2 = g2;
                    i3 = i4;
                } else {
                    i2 = -1;
                    i3 = -1;
                    f = 1.0f;
                }
                return new C2544a(arrayList, g, i2, i3, f);
            }
            throw new IllegalStateException();
        } catch (C2529l c2529l2) {
            throw new C2571p("Error parsing AVC config", c2529l2);
        }
    }

    private C2544a(List<byte[]> list, int i, int i2, int i3, float f) {
        this.f6477a = list;
        this.f6478b = i;
        this.f6479c = i2;
        this.f6480d = i3;
        this.f6481e = f;
    }

    /* renamed from: b */
    private static byte[] m7202b(C2529l c2529l) {
        int h = c2529l.m7104h();
        int d = c2529l.m7097d();
        c2529l.m7098d(h);
        return C2518c.m7029a(c2529l.f6441a, d, h);
    }
}
