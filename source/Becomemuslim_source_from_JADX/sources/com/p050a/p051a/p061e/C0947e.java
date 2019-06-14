package com.p050a.p051a.p061e;

import android.graphics.Path;
import android.graphics.PointF;
import com.p050a.p051a.p052a.p053a.C3359j;
import com.p050a.p051a.p056c.C0894a;
import com.p050a.p051a.p056c.C0917e;
import com.p050a.p051a.p056c.C0918f;
import com.p050a.p051a.p056c.p058b.C0902l;
import java.util.List;

/* compiled from: MiscUtils */
/* renamed from: com.a.a.e.e */
public class C0947e {
    /* renamed from: a */
    public static double m3301a(double d, double d2, double d3) {
        return d + (d3 * (d2 - d));
    }

    /* renamed from: a */
    public static float m3302a(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }

    /* renamed from: a */
    public static int m3305a(int i, int i2, float f) {
        return (int) (((float) i) + (f * ((float) (i2 - i))));
    }

    /* renamed from: c */
    public static boolean m3312c(float f, float f2, float f3) {
        return f >= f2 && f <= f3;
    }

    /* renamed from: a */
    public static PointF m3307a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    /* renamed from: a */
    public static void m3308a(C0902l c0902l, Path path) {
        path.reset();
        PointF a = c0902l.m3182a();
        path.moveTo(a.x, a.y);
        PointF pointF = new PointF(a.x, a.y);
        for (int i = 0; i < c0902l.m3185c().size(); i++) {
            C0894a c0894a = (C0894a) c0902l.m3185c().get(i);
            PointF a2 = c0894a.m3165a();
            PointF b = c0894a.m3167b();
            PointF c = c0894a.m3169c();
            if (a2.equals(pointF) && b.equals(c)) {
                path.lineTo(c.x, c.y);
            } else {
                path.cubicTo(a2.x, a2.y, b.x, b.y, c.x, c.y);
            }
            pointF.set(c.x, c.y);
        }
        if (c0902l.m3184b() != null) {
            path.close();
        }
    }

    /* renamed from: a */
    static int m3303a(float f, float f2) {
        return C0947e.m3304a((int) f, (int) f2);
    }

    /* renamed from: a */
    private static int m3304a(int i, int i2) {
        return i - (i2 * C0947e.m3311b(i, i2));
    }

    /* renamed from: b */
    private static int m3311b(int i, int i2) {
        int i3 = i / i2;
        return (((i ^ i2) >= 0 ? 1 : null) != null || i % i2 == 0) ? i3 : i3 - 1;
    }

    /* renamed from: a */
    public static int m3306a(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    /* renamed from: b */
    public static float m3310b(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    /* renamed from: a */
    public static void m3309a(C0917e c0917e, int i, List<C0917e> list, C0917e c0917e2, C3359j c3359j) {
        if (c0917e.m3224c(c3359j.mo730b(), i) != null) {
            list.add(c0917e2.m3220a(c3359j.mo730b()).m3219a((C0918f) c3359j));
        }
    }
}
