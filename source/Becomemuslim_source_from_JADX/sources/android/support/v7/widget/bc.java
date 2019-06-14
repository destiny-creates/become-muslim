package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* compiled from: RoundRectDrawable */
class bc extends Drawable {
    /* renamed from: a */
    private float f2057a;
    /* renamed from: b */
    private final Paint f2058b;
    /* renamed from: c */
    private final RectF f2059c;
    /* renamed from: d */
    private final Rect f2060d;
    /* renamed from: e */
    private float f2061e;
    /* renamed from: f */
    private boolean f2062f = false;
    /* renamed from: g */
    private boolean f2063g = true;
    /* renamed from: h */
    private ColorStateList f2064h;
    /* renamed from: i */
    private PorterDuffColorFilter f2065i;
    /* renamed from: j */
    private ColorStateList f2066j;
    /* renamed from: k */
    private Mode f2067k = Mode.SRC_IN;

    public int getOpacity() {
        return -3;
    }

    bc(ColorStateList colorStateList, float f) {
        this.f2057a = f;
        this.f2058b = new Paint(5);
        m2708b(colorStateList);
        this.f2059c = new RectF();
        this.f2060d = new Rect();
    }

    /* renamed from: b */
    private void m2708b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(null);
        }
        this.f2064h = colorStateList;
        this.f2058b.setColor(this.f2064h.getColorForState(getState(), this.f2064h.getDefaultColor()));
    }

    /* renamed from: a */
    void m2711a(float f, boolean z, boolean z2) {
        if (f != this.f2061e || this.f2062f != z || this.f2063g != z2) {
            this.f2061e = f;
            this.f2062f = z;
            this.f2063g = z2;
            m2707a((Rect) 0.0f);
            invalidateSelf();
        }
    }

    /* renamed from: a */
    float m2709a() {
        return this.f2061e;
    }

    public void draw(Canvas canvas) {
        Object obj;
        Paint paint = this.f2058b;
        if (this.f2065i == null || paint.getColorFilter() != null) {
            obj = null;
        } else {
            paint.setColorFilter(this.f2065i);
            obj = 1;
        }
        canvas.drawRoundRect(this.f2059c, this.f2057a, this.f2057a, paint);
        if (obj != null) {
            paint.setColorFilter(null);
        }
    }

    /* renamed from: a */
    private void m2707a(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f2059c.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        this.f2060d.set(rect);
        if (this.f2062f != null) {
            rect = bd.m2716a(this.f2061e, this.f2057a, this.f2063g);
            this.f2060d.inset((int) Math.ceil((double) bd.m2719b(this.f2061e, this.f2057a, this.f2063g)), (int) Math.ceil((double) rect));
            this.f2059c.set(this.f2060d);
        }
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        m2707a(rect);
    }

    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f2060d, this.f2057a);
    }

    /* renamed from: a */
    void m2710a(float f) {
        if (f != this.f2057a) {
            this.f2057a = f;
            m2707a((Rect) 0.0f);
            invalidateSelf();
        }
    }

    public void setAlpha(int i) {
        this.f2058b.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f2058b.setColorFilter(colorFilter);
    }

    /* renamed from: b */
    public float m2713b() {
        return this.f2057a;
    }

    /* renamed from: a */
    public void m2712a(ColorStateList colorStateList) {
        m2708b(colorStateList);
        invalidateSelf();
    }

    /* renamed from: c */
    public ColorStateList m2714c() {
        return this.f2064h;
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f2066j = colorStateList;
        this.f2065i = m2706a(this.f2066j, this.f2067k);
        invalidateSelf();
    }

    public void setTintMode(Mode mode) {
        this.f2067k = mode;
        this.f2065i = m2706a(this.f2066j, this.f2067k);
        invalidateSelf();
    }

    protected boolean onStateChange(int[] iArr) {
        iArr = this.f2064h.getColorForState(iArr, this.f2064h.getDefaultColor());
        boolean z = iArr != this.f2058b.getColor();
        if (z) {
            this.f2058b.setColor(iArr);
        }
        if (this.f2066j == null || this.f2067k == null) {
            return z;
        }
        this.f2065i = m2706a(this.f2066j, this.f2067k);
        return true;
    }

    public boolean isStateful() {
        return (this.f2066j != null && this.f2066j.isStateful()) || ((this.f2064h != null && this.f2064h.isStateful()) || super.isStateful());
    }

    /* renamed from: a */
    private PorterDuffColorFilter m2706a(ColorStateList colorStateList, Mode mode) {
        if (colorStateList != null) {
            if (mode != null) {
                return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
            }
        }
        return null;
    }
}
