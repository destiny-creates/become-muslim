package android.support.v4.view.p034b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* compiled from: PathInterpolatorApi14 */
/* renamed from: android.support.v4.view.b.e */
class C0492e implements Interpolator {
    /* renamed from: a */
    private final float[] f1265a;
    /* renamed from: b */
    private final float[] f1266b;

    C0492e(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        path = pathMeasure.getLength();
        int i = ((int) (path / 0.002f)) + 1;
        this.f1265a = new float[i];
        this.f1266b = new float[i];
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < i; i2++) {
            pathMeasure.getPosTan((((float) i2) * path) / ((float) (i - 1)), fArr, null);
            this.f1265a[i2] = fArr[0];
            this.f1266b[i2] = fArr[1];
        }
    }

    C0492e(float f, float f2, float f3, float f4) {
        this(C0492e.m1570a(f, f2, f3, f4));
    }

    public float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int i = 0;
        int length = this.f1265a.length - 1;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.f1265a[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float f2 = this.f1265a[length] - this.f1265a[i];
        if (f2 == 0.0f) {
            return this.f1266b[i];
        }
        f = (f - this.f1265a[i]) / f2;
        float f3 = this.f1266b[i];
        return f3 + (f * (this.f1266b[length] - f3));
    }

    /* renamed from: a */
    private static Path m1570a(float f, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f, f2, f3, f4, 1.0f, 1.0f);
        return path;
    }
}
