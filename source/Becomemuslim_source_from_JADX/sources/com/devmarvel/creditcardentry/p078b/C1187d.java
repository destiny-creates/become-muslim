package com.devmarvel.creditcardentry.p078b;

import android.graphics.Camera;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: FlipAnimator */
/* renamed from: com.devmarvel.creditcardentry.b.d */
class C1187d extends Animation {
    /* renamed from: a */
    private Camera f3311a;
    /* renamed from: b */
    private View f3312b;
    /* renamed from: c */
    private View f3313c;
    /* renamed from: d */
    private final float f3314d;
    /* renamed from: e */
    private final float f3315e;
    /* renamed from: f */
    private boolean f3316f = true;
    /* renamed from: g */
    private boolean f3317g;

    public C1187d(View view, View view2) {
        this.f3312b = view;
        this.f3313c = view2;
        if (view.getVisibility() != 0) {
            view = view2;
        }
        this.f3314d = (float) (view.getWidth() / 2);
        this.f3315e = (float) (view.getHeight() / 2);
        setDuration(500);
        setFillAfter(true);
        setInterpolator(new AccelerateDecelerateInterpolator());
    }

    /* renamed from: a */
    public void m4159a() {
        this.f3316f = false;
        View view = this.f3313c;
        this.f3313c = this.f3312b;
        this.f3312b = view;
    }

    public void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        this.f3311a = new Camera();
    }

    protected void applyTransformation(float f, Transformation transformation) {
        double d = ((double) f) * 3.141592653589793d;
        float f2 = (float) ((180.0d * d) / 3.141592653589793d);
        if (f >= 0.5f) {
            f2 -= 180.0f;
            if (this.f3317g == null) {
                this.f3312b.setVisibility(8);
                this.f3313c.setVisibility(0);
                this.f3317g = true;
            }
        }
        if (this.f3316f != null) {
            f2 = -f2;
        }
        f = transformation.getMatrix();
        this.f3311a.save();
        this.f3311a.translate(0.0f, 0.0f, (float) (Math.sin(d) * 150.0d));
        this.f3311a.rotateY(f2);
        this.f3311a.getMatrix(f);
        this.f3311a.restore();
        f.preTranslate(-this.f3314d, -this.f3315e);
        f.postTranslate(this.f3314d, this.f3315e);
    }
}
