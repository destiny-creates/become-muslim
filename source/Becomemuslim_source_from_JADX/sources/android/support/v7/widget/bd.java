package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.v7.p036b.C0628a.C0624b;
import android.support.v7.p036b.C0628a.C0625c;

/* compiled from: RoundRectDrawableWithShadow */
class bd extends Drawable {
    /* renamed from: a */
    static C0772a f2068a;
    /* renamed from: b */
    private static final double f2069b = Math.cos(Math.toRadians(45.0d));
    /* renamed from: c */
    private final int f2070c;
    /* renamed from: d */
    private Paint f2071d;
    /* renamed from: e */
    private Paint f2072e;
    /* renamed from: f */
    private Paint f2073f;
    /* renamed from: g */
    private final RectF f2074g;
    /* renamed from: h */
    private float f2075h;
    /* renamed from: i */
    private Path f2076i;
    /* renamed from: j */
    private float f2077j;
    /* renamed from: k */
    private float f2078k;
    /* renamed from: l */
    private float f2079l;
    /* renamed from: m */
    private ColorStateList f2080m;
    /* renamed from: n */
    private boolean f2081n = true;
    /* renamed from: o */
    private final int f2082o;
    /* renamed from: p */
    private final int f2083p;
    /* renamed from: q */
    private boolean f2084q = true;
    /* renamed from: r */
    private boolean f2085r = false;

    /* compiled from: RoundRectDrawableWithShadow */
    /* renamed from: android.support.v7.widget.bd$a */
    interface C0772a {
        /* renamed from: a */
        void mo605a(Canvas canvas, RectF rectF, float f, Paint paint);
    }

    public int getOpacity() {
        return -3;
    }

    bd(Resources resources, ColorStateList colorStateList, float f, float f2, float f3) {
        this.f2082o = resources.getColor(C0624b.cardview_shadow_start_color);
        this.f2083p = resources.getColor(C0624b.cardview_shadow_end_color);
        this.f2070c = resources.getDimensionPixelSize(C0625c.cardview_compat_inset_shadow);
        this.f2071d = new Paint(5);
        m2720b(colorStateList);
        this.f2072e = new Paint(5);
        this.f2072e.setStyle(Style.FILL);
        this.f2075h = (float) ((int) (f + 0.5f));
        this.f2074g = new RectF();
        this.f2073f = new Paint(this.f2072e);
        this.f2073f.setAntiAlias(false);
        m2717a(f2, f3);
    }

    /* renamed from: b */
    private void m2720b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(null);
        }
        this.f2080m = colorStateList;
        this.f2071d.setColor(this.f2080m.getColorForState(getState(), this.f2080m.getDefaultColor()));
    }

    /* renamed from: d */
    private int m2722d(float f) {
        f = (int) (f + 0.5f);
        return f % 2 == 1 ? f - Float.MIN_VALUE : f;
    }

    /* renamed from: a */
    void m2728a(boolean z) {
        this.f2084q = z;
        invalidateSelf();
    }

    public void setAlpha(int i) {
        this.f2071d.setAlpha(i);
        this.f2072e.setAlpha(i);
        this.f2073f.setAlpha(i);
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f2081n = true;
    }

    /* renamed from: a */
    private void m2717a(float f, float f2) {
        StringBuilder stringBuilder;
        if (f < 0.0f) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid shadow size ");
            stringBuilder.append(f);
            stringBuilder.append(". Must be >= 0");
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (f2 >= 0.0f) {
            f = (float) m2722d(f);
            f2 = (float) m2722d(f2);
            if (f > f2) {
                if (this.f2085r == null) {
                    this.f2085r = true;
                }
                f = f2;
            }
            if (this.f2079l != f || this.f2077j != f2) {
                this.f2079l = f;
                this.f2077j = f2;
                this.f2078k = (float) ((int) (((f * 1.5f) + ((float) this.f2070c)) + 0.5f));
                this.f2081n = true;
                invalidateSelf();
            }
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid max shadow size ");
            stringBuilder.append(f2);
            stringBuilder.append(". Must be >= 0");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) m2716a(this.f2077j, this.f2075h, this.f2084q));
        int ceil2 = (int) Math.ceil((double) m2719b(this.f2077j, this.f2075h, this.f2084q));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    /* renamed from: a */
    static float m2716a(float f, float f2, boolean z) {
        return z ? (float) (((double) (f * 1.5f)) + ((1.0d - f2069b) * ((double) f2))) : f * 1.5f;
    }

    /* renamed from: b */
    static float m2719b(float f, float f2, boolean z) {
        return z ? (float) (((double) f) + ((1.0d - f2069b) * ((double) f2))) : f;
    }

    protected boolean onStateChange(int[] iArr) {
        iArr = this.f2080m.getColorForState(iArr, this.f2080m.getDefaultColor());
        if (this.f2071d.getColor() == iArr) {
            return null;
        }
        this.f2071d.setColor(iArr);
        this.f2081n = true;
        invalidateSelf();
        return true;
    }

    public boolean isStateful() {
        return (this.f2080m != null && this.f2080m.isStateful()) || super.isStateful();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f2071d.setColorFilter(colorFilter);
    }

    /* renamed from: a */
    void m2725a(float f) {
        if (f >= 0.0f) {
            f = (float) ((int) (f + 0.5f));
            if (this.f2075h != f) {
                this.f2075h = f;
                this.f2081n = true;
                invalidateSelf();
                return;
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid radius ");
        stringBuilder.append(f);
        stringBuilder.append(". Must be >= 0");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public void draw(Canvas canvas) {
        if (this.f2081n) {
            m2721b(getBounds());
            this.f2081n = false;
        }
        canvas.translate(0.0f, this.f2079l / 2.0f);
        m2718a(canvas);
        canvas.translate(0.0f, (-this.f2079l) / 2.0f);
        f2068a.mo605a(canvas, this.f2074g, this.f2075h, this.f2071d);
    }

    /* renamed from: a */
    private void m2718a(Canvas canvas) {
        float f = (-this.f2075h) - this.f2078k;
        float f2 = (this.f2075h + ((float) this.f2070c)) + (this.f2079l / 2.0f);
        float f3 = f2 * 2.0f;
        Object obj = this.f2074g.width() - f3 > 0.0f ? 1 : null;
        Object obj2 = this.f2074g.height() - f3 > 0.0f ? 1 : null;
        int save = canvas.save();
        canvas.translate(this.f2074g.left + f2, this.f2074g.top + f2);
        canvas.drawPath(this.f2076i, this.f2072e);
        if (obj != null) {
            canvas.drawRect(0.0f, f, this.f2074g.width() - f3, -this.f2075h, this.f2073f);
        }
        canvas.restoreToCount(save);
        save = canvas.save();
        canvas.translate(this.f2074g.right - f2, this.f2074g.bottom - f2);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f2076i, this.f2072e);
        if (obj != null) {
            canvas.drawRect(0.0f, f, this.f2074g.width() - f3, (-this.f2075h) + this.f2078k, this.f2073f);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        canvas.translate(this.f2074g.left + f2, this.f2074g.bottom - f2);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f2076i, this.f2072e);
        if (obj2 != null) {
            canvas.drawRect(0.0f, f, this.f2074g.height() - f3, -this.f2075h, this.f2073f);
        }
        canvas.restoreToCount(save2);
        save2 = canvas.save();
        canvas.translate(this.f2074g.right - f2, this.f2074g.top + f2);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f2076i, this.f2072e);
        if (obj2 != null) {
            canvas.drawRect(0.0f, f, this.f2074g.height() - f3, -this.f2075h, this.f2073f);
        }
        canvas.restoreToCount(save2);
    }

    /* renamed from: g */
    private void m2723g() {
        RectF rectF = new RectF(-this.f2075h, -this.f2075h, this.f2075h, this.f2075h);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(-this.f2078k, -this.f2078k);
        if (this.f2076i == null) {
            r0.f2076i = new Path();
        } else {
            r0.f2076i.reset();
        }
        r0.f2076i.setFillType(FillType.EVEN_ODD);
        r0.f2076i.moveTo(-r0.f2075h, 0.0f);
        r0.f2076i.rLineTo(-r0.f2078k, 0.0f);
        r0.f2076i.arcTo(rectF2, 180.0f, 90.0f, false);
        r0.f2076i.arcTo(rectF, 270.0f, -90.0f, false);
        r0.f2076i.close();
        float f = r0.f2075h / (r0.f2075h + r0.f2078k);
        r0.f2072e.setShader(new RadialGradient(0.0f, 0.0f, r0.f2075h + r0.f2078k, new int[]{r0.f2082o, r0.f2082o, r0.f2083p}, new float[]{0.0f, f, 1.0f}, TileMode.CLAMP));
        r0.f2073f.setShader(new LinearGradient(0.0f, (-r0.f2075h) + r0.f2078k, 0.0f, (-r0.f2075h) - r0.f2078k, new int[]{r0.f2082o, r0.f2082o, r0.f2083p}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP));
        r0.f2073f.setAntiAlias(false);
    }

    /* renamed from: b */
    private void m2721b(Rect rect) {
        float f = this.f2077j * 1.5f;
        this.f2074g.set(((float) rect.left) + this.f2077j, ((float) rect.top) + f, ((float) rect.right) - this.f2077j, ((float) rect.bottom) - f);
        m2723g();
    }

    /* renamed from: a */
    float m2724a() {
        return this.f2075h;
    }

    /* renamed from: a */
    void m2727a(Rect rect) {
        getPadding(rect);
    }

    /* renamed from: b */
    void m2730b(float f) {
        m2717a(f, this.f2077j);
    }

    /* renamed from: c */
    void m2732c(float f) {
        m2717a(this.f2079l, f);
    }

    /* renamed from: b */
    float m2729b() {
        return this.f2079l;
    }

    /* renamed from: c */
    float m2731c() {
        return this.f2077j;
    }

    /* renamed from: d */
    float m2733d() {
        return (Math.max(this.f2077j, (this.f2075h + ((float) this.f2070c)) + (this.f2077j / 2.0f)) * 2.0f) + ((this.f2077j + ((float) this.f2070c)) * 2.0f);
    }

    /* renamed from: e */
    float m2734e() {
        return (Math.max(this.f2077j, (this.f2075h + ((float) this.f2070c)) + ((this.f2077j * 1.5f) / 2.0f)) * 2.0f) + (((this.f2077j * 1.5f) + ((float) this.f2070c)) * 2.0f);
    }

    /* renamed from: a */
    void m2726a(ColorStateList colorStateList) {
        m2720b(colorStateList);
        invalidateSelf();
    }

    /* renamed from: f */
    ColorStateList m2735f() {
        return this.f2080m;
    }
}
