package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.v4.p020a.C0264a;

/* compiled from: CircularBorderDrawable */
/* renamed from: android.support.design.widget.c */
class C0180c extends Drawable {
    /* renamed from: a */
    final Paint f389a;
    /* renamed from: b */
    final Rect f390b;
    /* renamed from: c */
    final RectF f391c;
    /* renamed from: d */
    float f392d;
    /* renamed from: e */
    private int f393e;
    /* renamed from: f */
    private int f394f;
    /* renamed from: g */
    private int f395g;
    /* renamed from: h */
    private int f396h;
    /* renamed from: i */
    private ColorStateList f397i;
    /* renamed from: j */
    private int f398j;
    /* renamed from: k */
    private boolean f399k;
    /* renamed from: l */
    private float f400l;

    public void draw(Canvas canvas) {
        if (this.f399k) {
            this.f389a.setShader(m395a());
            this.f399k = false;
        }
        float strokeWidth = this.f389a.getStrokeWidth() / 2.0f;
        RectF rectF = this.f391c;
        copyBounds(this.f390b);
        rectF.set(this.f390b);
        rectF.left += strokeWidth;
        rectF.top += strokeWidth;
        rectF.right -= strokeWidth;
        rectF.bottom -= strokeWidth;
        canvas.save();
        canvas.rotate(this.f400l, rectF.centerX(), rectF.centerY());
        canvas.drawOval(rectF, this.f389a);
        canvas.restore();
    }

    public boolean getPadding(Rect rect) {
        int round = Math.round(this.f392d);
        rect.set(round, round, round, round);
        return true;
    }

    public void setAlpha(int i) {
        this.f389a.setAlpha(i);
        invalidateSelf();
    }

    /* renamed from: a */
    void m397a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f398j = colorStateList.getColorForState(getState(), this.f398j);
        }
        this.f397i = colorStateList;
        this.f399k = true;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f389a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public int getOpacity() {
        return this.f392d > 0.0f ? -3 : -2;
    }

    /* renamed from: a */
    final void m396a(float f) {
        if (f != this.f400l) {
            this.f400l = f;
            invalidateSelf();
        }
    }

    protected void onBoundsChange(Rect rect) {
        this.f399k = true;
    }

    public boolean isStateful() {
        return (this.f397i != null && this.f397i.isStateful()) || super.isStateful();
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.f397i != null) {
            iArr = this.f397i.getColorForState(iArr, this.f398j);
            if (iArr != this.f398j) {
                this.f399k = true;
                this.f398j = iArr;
            }
        }
        if (this.f399k != null) {
            invalidateSelf();
        }
        return this.f399k;
    }

    /* renamed from: a */
    private Shader m395a() {
        Rect rect = this.f390b;
        copyBounds(rect);
        float height = this.f392d / ((float) rect.height());
        return new LinearGradient(0.0f, (float) rect.top, 0.0f, (float) rect.bottom, new int[]{C0264a.m714a(this.f393e, this.f398j), C0264a.m714a(this.f394f, this.f398j), C0264a.m714a(C0264a.m717b(this.f394f, 0), this.f398j), C0264a.m714a(C0264a.m717b(this.f396h, 0), this.f398j), C0264a.m714a(this.f396h, this.f398j), C0264a.m714a(this.f395g, this.f398j)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, TileMode.CLAMP);
    }
}
