package com.p050a.p051a.p061e;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.p050a.p051a.C0940d;
import com.p050a.p051a.p052a.p053a.C3361r;

/* compiled from: Utils */
/* renamed from: com.a.a.e.f */
public final class C0948f {
    /* renamed from: a */
    private static final PathMeasure f2638a = new PathMeasure();
    /* renamed from: b */
    private static final Path f2639b = new Path();
    /* renamed from: c */
    private static final Path f2640c = new Path();
    /* renamed from: d */
    private static final float[] f2641d = new float[4];
    /* renamed from: e */
    private static final float f2642e = ((float) Math.sqrt(2.0d));
    /* renamed from: f */
    private static float f2643f = -1.0f;

    /* renamed from: a */
    public static int m3315a(float f, float f2, float f3, float f4) {
        int i = f != 0.0f ? (int) (((float) 527) * f) : 17;
        if (f2 != 0.0f) {
            i = (int) (((float) (i * 31)) * f2);
        }
        if (f3 != 0.0f) {
            i = (int) (((float) (i * 31)) * f3);
        }
        return f4 != 0.0f ? (int) (((float) (i * 31)) * f4) : i;
    }

    /* renamed from: a */
    public static boolean m3319a(int i, int i2, int i3, int i4, int i5, int i6) {
        boolean z = false;
        if (i < i4) {
            return false;
        }
        if (i > i4) {
            return true;
        }
        if (i2 < i5) {
            return false;
        }
        if (i2 > i5) {
            return true;
        }
        if (i3 >= i6) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    public static Path m3316a(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 == null || pointF4 == null || (pointF3.length() == 0.0f && pointF4.length() == 0.0f)) {
            path.lineTo(pointF2.x, pointF2.y);
        } else {
            Path path2 = path;
            path2.cubicTo(pointF3.x + pointF.x, pointF.y + pointF3.y, pointF2.x + pointF4.x, pointF2.y + pointF4.y, pointF2.x, pointF2.y);
        }
        return path;
    }

    /* renamed from: a */
    public static float m3314a(Matrix matrix) {
        f2641d[0] = 0.0f;
        f2641d[1] = 0.0f;
        f2641d[2] = f2642e;
        f2641d[3] = f2642e;
        matrix.mapPoints(f2641d);
        return ((float) Math.hypot((double) (f2641d[2] - f2641d[0]), (double) (f2641d[3] - f2641d[1]))) / 2.0f;
    }

    /* renamed from: a */
    public static void m3318a(Path path, C3361r c3361r) {
        if (c3361r != null) {
            C0948f.m3317a(path, ((Float) c3361r.m10670d().mo733e()).floatValue() / 100.0f, ((Float) c3361r.m10671e().mo733e()).floatValue() / 100.0f, ((Float) c3361r.m10672f().mo733e()).floatValue() / 360.0f);
        }
    }

    /* renamed from: a */
    public static void m3317a(Path path, float f, float f2, float f3) {
        C0940d.m3288b("applyTrimPathIfNeeded");
        f2638a.setPath(path, false);
        float length = f2638a.getLength();
        if (f == 1.0f && f2 == 0.0f) {
            C0940d.m3289c("applyTrimPathIfNeeded");
            return;
        }
        if (length >= 1.0f) {
            if (((double) Math.abs((f2 - f) - 1.0f)) >= 0.01d) {
                f *= length;
                f2 *= length;
                f3 *= length;
                float min = Math.min(f, f2) + f3;
                f = Math.max(f, f2) + f3;
                if (min >= length && f >= length) {
                    min = (float) C0947e.m3303a(min, length);
                    f = (float) C0947e.m3303a(f, length);
                }
                if (min < 0.0f) {
                    min = (float) C0947e.m3303a(min, length);
                }
                if (f < 0.0f) {
                    f = (float) C0947e.m3303a(f, length);
                }
                f2 = (min > f ? 1 : (min == f ? 0 : -1));
                if (f2 == null) {
                    path.reset();
                    C0940d.m3289c("applyTrimPathIfNeeded");
                    return;
                }
                if (f2 >= null) {
                    min -= length;
                }
                f2639b.reset();
                f2638a.getSegment(min, f, f2639b, true);
                if (f > length) {
                    f2640c.reset();
                    f2638a.getSegment(0.0f, f % length, f2640c, true);
                    f2639b.addPath(f2640c);
                } else if (min < 0.0f) {
                    f2640c.reset();
                    f2638a.getSegment(min + length, length, f2640c, true);
                    f2639b.addPath(f2640c);
                }
                path.set(f2639b);
                C0940d.m3289c("applyTrimPathIfNeeded");
                return;
            }
        }
        C0940d.m3289c("applyTrimPathIfNeeded");
    }

    /* renamed from: a */
    public static float m3313a() {
        if (f2643f == -1.0f) {
            f2643f = Resources.getSystem().getDisplayMetrics().density;
        }
        return f2643f;
    }
}
