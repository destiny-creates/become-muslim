package com.theartofdev.edmodo.cropper;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import android.widget.ImageView;

/* compiled from: CropImageAnimation */
/* renamed from: com.theartofdev.edmodo.cropper.e */
final class C5843e extends Animation implements AnimationListener {
    /* renamed from: a */
    private final ImageView f19401a;
    /* renamed from: b */
    private final CropOverlayView f19402b;
    /* renamed from: c */
    private final float[] f19403c = new float[8];
    /* renamed from: d */
    private final float[] f19404d = new float[8];
    /* renamed from: e */
    private final RectF f19405e = new RectF();
    /* renamed from: f */
    private final RectF f19406f = new RectF();
    /* renamed from: g */
    private final float[] f19407g = new float[9];
    /* renamed from: h */
    private final float[] f19408h = new float[9];
    /* renamed from: i */
    private final RectF f19409i = new RectF();
    /* renamed from: j */
    private final float[] f19410j = new float[8];
    /* renamed from: k */
    private final float[] f19411k = new float[9];

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }

    public C5843e(ImageView imageView, CropOverlayView cropOverlayView) {
        this.f19401a = imageView;
        this.f19402b = cropOverlayView;
        setDuration(300);
        setFillAfter(true);
        setInterpolator(new AccelerateDecelerateInterpolator());
        setAnimationListener(this);
    }

    /* renamed from: a */
    public void m24648a(float[] fArr, Matrix matrix) {
        reset();
        System.arraycopy(fArr, 0, this.f19403c, 0, 8);
        this.f19405e.set(this.f19402b.getCropWindowRect());
        matrix.getValues(this.f19407g);
    }

    /* renamed from: b */
    public void m24649b(float[] fArr, Matrix matrix) {
        System.arraycopy(fArr, 0, this.f19404d, 0, 8);
        this.f19406f.set(this.f19402b.getCropWindowRect());
        matrix.getValues(this.f19408h);
    }

    protected void applyTransformation(float f, Transformation transformation) {
        this.f19409i.left = this.f19405e.left + ((this.f19406f.left - this.f19405e.left) * f);
        this.f19409i.top = this.f19405e.top + ((this.f19406f.top - this.f19405e.top) * f);
        this.f19409i.right = this.f19405e.right + ((this.f19406f.right - this.f19405e.right) * f);
        this.f19409i.bottom = this.f19405e.bottom + ((this.f19406f.bottom - this.f19405e.bottom) * f);
        this.f19402b.setCropWindowRect(this.f19409i);
        for (int i = 0; i < this.f19410j.length; i++) {
            this.f19410j[i] = this.f19403c[i] + ((this.f19404d[i] - this.f19403c[i]) * f);
        }
        this.f19402b.m24585a(this.f19410j, this.f19401a.getWidth(), this.f19401a.getHeight());
        for (transformation = null; transformation < this.f19411k.length; transformation++) {
            this.f19411k[transformation] = this.f19407g[transformation] + ((this.f19408h[transformation] - this.f19407g[transformation]) * f);
        }
        f = this.f19401a.getImageMatrix();
        f.setValues(this.f19411k);
        this.f19401a.setImageMatrix(f);
        this.f19401a.invalidate();
        this.f19402b.invalidate();
    }

    public void onAnimationEnd(Animation animation) {
        this.f19401a.clearAnimation();
    }
}
