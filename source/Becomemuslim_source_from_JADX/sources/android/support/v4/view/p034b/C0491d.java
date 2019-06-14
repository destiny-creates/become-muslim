package android.support.v4.view.p034b;

import android.view.animation.Interpolator;

/* compiled from: LookupTableInterpolator */
/* renamed from: android.support.v4.view.b.d */
abstract class C0491d implements Interpolator {
    /* renamed from: a */
    private final float[] f1263a;
    /* renamed from: b */
    private final float f1264b = (1.0f / ((float) (this.f1263a.length - 1)));

    protected C0491d(float[] fArr) {
        this.f1263a = fArr;
    }

    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        int min = Math.min((int) (((float) (this.f1263a.length - 1)) * f), this.f1263a.length - 2);
        return this.f1263a[min] + (((f - (((float) min) * this.f1264b)) / this.f1264b) * (this.f1263a[min + 1] - this.f1263a[min]));
    }
}
