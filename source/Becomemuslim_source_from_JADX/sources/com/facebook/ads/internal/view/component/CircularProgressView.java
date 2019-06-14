package com.facebook.ads.internal.view.component;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.support.annotation.Keep;
import android.view.View;
import android.view.animation.LinearInterpolator;

public class CircularProgressView extends View {
    /* renamed from: a */
    private final float f4746a = (Resources.getSystem().getDisplayMetrics().density * 3.0f);
    /* renamed from: b */
    private final RectF f4747b = new RectF();
    /* renamed from: c */
    private final Paint f4748c = new Paint(1);
    /* renamed from: d */
    private final Paint f4749d;
    /* renamed from: e */
    private float f4750e = 0.0f;

    public CircularProgressView(Context context) {
        super(context);
        this.f4748c.setStyle(Style.STROKE);
        this.f4748c.setStrokeWidth(this.f4746a);
        this.f4749d = new Paint(1);
        this.f4749d.setStyle(Style.STROKE);
        this.f4749d.setStrokeWidth(this.f4746a);
    }

    /* renamed from: a */
    public void m5527a(int i, int i2) {
        this.f4748c.setColor(i);
        this.f4749d.setColor(i2);
    }

    @Keep
    public float getProgress() {
        return this.f4750e;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.f4747b, 0.0f, 360.0f, false, this.f4748c);
        canvas.drawArc(this.f4747b, -90.0f, (this.f4750e * 360.0f) / 100.0f, false, this.f4749d);
    }

    protected void onMeasure(int i, int i2) {
        i = Math.min(getDefaultSize(getSuggestedMinimumHeight(), i2), getDefaultSize(getSuggestedMinimumWidth(), i));
        setMeasuredDimension(i, i);
        float f = (float) i;
        this.f4747b.set(((this.f4746a / 2.0f) + 0.0f) + ((float) getPaddingLeft()), ((this.f4746a / 2.0f) + 0.0f) + ((float) getPaddingTop()), (f - (this.f4746a / 2.0f)) - ((float) getPaddingRight()), (f - (this.f4746a / 2.0f)) - ((float) getPaddingBottom()));
    }

    @Keep
    public void setProgress(float f) {
        this.f4750e = Math.min(f, 100.0f);
        postInvalidate();
    }

    public void setProgressWithAnimation(float f) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "progress", new float[]{f});
        ofFloat.setDuration(400);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.start();
    }
}
