package android.support.design.widget;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.support.v7.p039d.p040a.C0633a;

/* compiled from: ShadowDrawableWrapper */
/* renamed from: android.support.design.widget.i */
class C3138i extends C0633a {
    /* renamed from: a */
    static final double f8038a = Math.cos(Math.toRadians(45.0d));
    /* renamed from: b */
    final Paint f8039b;
    /* renamed from: c */
    final Paint f8040c;
    /* renamed from: d */
    final RectF f8041d;
    /* renamed from: e */
    float f8042e;
    /* renamed from: f */
    Path f8043f;
    /* renamed from: g */
    float f8044g;
    /* renamed from: h */
    float f8045h;
    /* renamed from: i */
    float f8046i;
    /* renamed from: j */
    float f8047j;
    /* renamed from: k */
    private boolean f8048k;
    /* renamed from: l */
    private final int f8049l;
    /* renamed from: m */
    private final int f8050m;
    /* renamed from: n */
    private final int f8051n;
    /* renamed from: o */
    private boolean f8052o;
    /* renamed from: p */
    private float f8053p;
    /* renamed from: q */
    private boolean f8054q;

    public int getOpacity() {
        return -3;
    }

    /* renamed from: c */
    private static int m9259c(float f) {
        f = Math.round(f);
        return f % 2 == 1 ? f - 1 : f;
    }

    public void setAlpha(int i) {
        super.setAlpha(i);
        this.f8039b.setAlpha(i);
        this.f8040c.setAlpha(i);
    }

    protected void onBoundsChange(Rect rect) {
        this.f8048k = true;
    }

    /* renamed from: a */
    void m9263a(float f, float f2) {
        if (f < 0.0f || f2 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        f = (float) C3138i.m9259c(f);
        f2 = (float) C3138i.m9259c(f2);
        if (f > f2) {
            if (this.f8054q == null) {
                this.f8054q = true;
            }
            f = f2;
        }
        if (this.f8047j != f || this.f8045h != f2) {
            this.f8047j = f;
            this.f8045h = f2;
            this.f8046i = (float) Math.round(f * 1.5f);
            this.f8044g = f2;
            this.f8048k = true;
            invalidateSelf();
        }
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) C3138i.m9255a(this.f8045h, this.f8042e, this.f8052o));
        int ceil2 = (int) Math.ceil((double) C3138i.m9258b(this.f8045h, this.f8042e, this.f8052o));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    /* renamed from: a */
    public static float m9255a(float f, float f2, boolean z) {
        return z ? (float) (((double) (f * 1.5f)) + ((1.0d - f8038a) * ((double) f2))) : f * 1.5f;
    }

    /* renamed from: b */
    public static float m9258b(float f, float f2, boolean z) {
        return z ? (float) (((double) f) + ((1.0d - f8038a) * ((double) f2))) : f;
    }

    public void draw(Canvas canvas) {
        if (this.f8048k) {
            m9257a(getBounds());
            this.f8048k = false;
        }
        m9256a(canvas);
        super.draw(canvas);
    }

    /* renamed from: a */
    final void m9262a(float f) {
        if (this.f8053p != f) {
            this.f8053p = f;
            invalidateSelf();
        }
    }

    /* renamed from: a */
    private void m9256a(Canvas canvas) {
        int i;
        float f;
        int i2;
        float f2;
        float f3;
        Canvas canvas2 = canvas;
        int save = canvas.save();
        canvas2.rotate(this.f8053p, this.f8041d.centerX(), this.f8041d.centerY());
        float f4 = (-this.f8042e) - this.f8046i;
        float f5 = this.f8042e;
        float f6 = f5 * 2.0f;
        Object obj = this.f8041d.width() - f6 > 0.0f ? 1 : null;
        Object obj2 = r0.f8041d.height() - f6 > 0.0f ? 1 : null;
        float f7 = f5 / ((r0.f8047j - (r0.f8047j * 0.5f)) + f5);
        float f8 = f5 / ((r0.f8047j - (r0.f8047j * 0.25f)) + f5);
        float f9 = f5 / ((r0.f8047j - (r0.f8047j * 1.0f)) + f5);
        int save2 = canvas.save();
        canvas2.translate(r0.f8041d.left + f5, r0.f8041d.top + f5);
        canvas2.scale(f7, f8);
        canvas2.drawPath(r0.f8043f, r0.f8039b);
        if (obj != null) {
            canvas2.scale(1.0f / f7, 1.0f);
            i = save2;
            f = f9;
            i2 = save;
            f2 = f8;
            canvas.drawRect(0.0f, f4, r0.f8041d.width() - f6, -r0.f8042e, r0.f8040c);
        } else {
            i = save2;
            f = f9;
            i2 = save;
            f2 = f8;
        }
        canvas2.restoreToCount(i);
        i = canvas.save();
        canvas2.translate(r0.f8041d.right - f5, r0.f8041d.bottom - f5);
        f8 = f;
        canvas2.scale(f7, f8);
        canvas2.rotate(180.0f);
        canvas2.drawPath(r0.f8043f, r0.f8039b);
        if (obj != null) {
            canvas2.scale(1.0f / f7, 1.0f);
            f3 = f2;
            f2 = f8;
            canvas.drawRect(0.0f, f4, r0.f8041d.width() - f6, (-r0.f8042e) + r0.f8046i, r0.f8040c);
        } else {
            f3 = f2;
            f2 = f8;
        }
        canvas2.restoreToCount(i);
        int save3 = canvas.save();
        canvas2.translate(r0.f8041d.left + f5, r0.f8041d.bottom - f5);
        canvas2.scale(f7, f2);
        canvas2.rotate(270.0f);
        canvas2.drawPath(r0.f8043f, r0.f8039b);
        if (obj2 != null) {
            canvas2.scale(1.0f / f2, 1.0f);
            canvas.drawRect(0.0f, f4, r0.f8041d.height() - f6, -r0.f8042e, r0.f8040c);
        }
        canvas2.restoreToCount(save3);
        save = canvas.save();
        canvas2.translate(r0.f8041d.right - f5, r0.f8041d.top + f5);
        f5 = f3;
        canvas2.scale(f7, f5);
        canvas2.rotate(90.0f);
        canvas2.drawPath(r0.f8043f, r0.f8039b);
        if (obj2 != null) {
            canvas2.scale(1.0f / f5, 1.0f);
            canvas.drawRect(0.0f, f4, r0.f8041d.height() - f6, -r0.f8042e, r0.f8040c);
        }
        canvas2.restoreToCount(save);
        canvas2.restoreToCount(i2);
    }

    /* renamed from: c */
    private void m9260c() {
        RectF rectF = new RectF(-this.f8042e, -this.f8042e, this.f8042e, this.f8042e);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(-this.f8046i, -this.f8046i);
        if (this.f8043f == null) {
            r0.f8043f = new Path();
        } else {
            r0.f8043f.reset();
        }
        r0.f8043f.setFillType(FillType.EVEN_ODD);
        r0.f8043f.moveTo(-r0.f8042e, 0.0f);
        r0.f8043f.rLineTo(-r0.f8046i, 0.0f);
        r0.f8043f.arcTo(rectF2, 180.0f, 90.0f, false);
        r0.f8043f.arcTo(rectF, 270.0f, -90.0f, false);
        r0.f8043f.close();
        float f = -rectF2.top;
        if (f > 0.0f) {
            float f2 = r0.f8042e / f;
            float f3 = ((1.0f - f2) / 2.0f) + f2;
            Paint paint = r0.f8039b;
            Shader shader = r8;
            Shader radialGradient = new RadialGradient(0.0f, 0.0f, f, new int[]{0, r0.f8049l, r0.f8050m, r0.f8051n}, new float[]{0.0f, f2, f3, 1.0f}, TileMode.CLAMP);
            paint.setShader(shader);
        }
        r0.f8040c.setShader(new LinearGradient(0.0f, rectF.top, 0.0f, rectF2.top, new int[]{r0.f8049l, r0.f8050m, r0.f8051n}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP));
        r0.f8040c.setAntiAlias(false);
    }

    /* renamed from: a */
    private void m9257a(Rect rect) {
        float f = this.f8045h * 1.5f;
        this.f8041d.set(((float) rect.left) + this.f8045h, ((float) rect.top) + f, ((float) rect.right) - this.f8045h, ((float) rect.bottom) - f);
        m2120b().setBounds((int) this.f8041d.left, (int) this.f8041d.top, (int) this.f8041d.right, (int) this.f8041d.bottom);
        m9260c();
    }

    /* renamed from: b */
    public void m9264b(float f) {
        m9263a(f, this.f8045h);
    }

    /* renamed from: a */
    public float m9261a() {
        return this.f8047j;
    }
}
