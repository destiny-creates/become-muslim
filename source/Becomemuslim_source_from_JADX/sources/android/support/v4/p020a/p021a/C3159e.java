package android.support.v4.p020a.p021a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;

/* compiled from: WrappedDrawableApi14 */
/* renamed from: android.support.v4.a.a.e */
class C3159e extends Drawable implements Callback, C0261c, C0262d {
    /* renamed from: a */
    static final Mode f8107a = Mode.SRC_IN;
    /* renamed from: b */
    C0263a f8108b;
    /* renamed from: c */
    Drawable f8109c;
    /* renamed from: d */
    private int f8110d;
    /* renamed from: e */
    private Mode f8111e;
    /* renamed from: f */
    private boolean f8112f;
    /* renamed from: g */
    private boolean f8113g;

    /* compiled from: WrappedDrawableApi14 */
    /* renamed from: android.support.v4.a.a.e$a */
    protected static abstract class C0263a extends ConstantState {
        /* renamed from: a */
        int f662a;
        /* renamed from: b */
        ConstantState f663b;
        /* renamed from: c */
        ColorStateList f664c = null;
        /* renamed from: d */
        Mode f665d = C3159e.f8107a;

        public abstract Drawable newDrawable(Resources resources);

        C0263a(C0263a c0263a, Resources resources) {
            if (c0263a != null) {
                this.f662a = c0263a.f662a;
                this.f663b = c0263a.f663b;
                this.f664c = c0263a.f664c;
                this.f665d = c0263a.f665d;
            }
        }

        public Drawable newDrawable() {
            return newDrawable(null);
        }

        public int getChangingConfigurations() {
            return this.f662a | (this.f663b != null ? this.f663b.getChangingConfigurations() : 0);
        }

        /* renamed from: a */
        boolean m713a() {
            return this.f663b != null;
        }
    }

    /* compiled from: WrappedDrawableApi14 */
    /* renamed from: android.support.v4.a.a.e$b */
    private static class C3158b extends C0263a {
        C3158b(C0263a c0263a, Resources resources) {
            super(c0263a, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new C3159e(this, resources);
        }
    }

    /* renamed from: c */
    protected boolean mo3325c() {
        return true;
    }

    C3159e(C0263a c0263a, Resources resources) {
        this.f8108b = c0263a;
        m9387a(resources);
    }

    C3159e(Drawable drawable) {
        this.f8108b = mo2655b();
        mo163a(drawable);
    }

    /* renamed from: a */
    private void m9387a(Resources resources) {
        if (this.f8108b != null && this.f8108b.f663b != null) {
            mo163a(this.f8108b.f663b.newDrawable(resources));
        }
    }

    public void jumpToCurrentState() {
        this.f8109c.jumpToCurrentState();
    }

    public void draw(Canvas canvas) {
        this.f8109c.draw(canvas);
    }

    protected void onBoundsChange(Rect rect) {
        if (this.f8109c != null) {
            this.f8109c.setBounds(rect);
        }
    }

    public void setChangingConfigurations(int i) {
        this.f8109c.setChangingConfigurations(i);
    }

    public int getChangingConfigurations() {
        return (super.getChangingConfigurations() | (this.f8108b != null ? this.f8108b.getChangingConfigurations() : 0)) | this.f8109c.getChangingConfigurations();
    }

    public void setDither(boolean z) {
        this.f8109c.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f8109c.setFilterBitmap(z);
    }

    public void setAlpha(int i) {
        this.f8109c.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f8109c.setColorFilter(colorFilter);
    }

    public boolean isStateful() {
        ColorStateList colorStateList = (!mo3325c() || this.f8108b == null) ? null : this.f8108b.f664c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f8109c.isStateful();
    }

    public boolean setState(int[] iArr) {
        boolean state = this.f8109c.setState(iArr);
        if (m9388a(iArr) == null) {
            if (!state) {
                return null;
            }
        }
        return 1;
    }

    public int[] getState() {
        return this.f8109c.getState();
    }

    public Drawable getCurrent() {
        return this.f8109c.getCurrent();
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (!super.setVisible(z, z2)) {
            if (!this.f8109c.setVisible(z, z2)) {
                return false;
            }
        }
        return true;
    }

    public int getOpacity() {
        return this.f8109c.getOpacity();
    }

    public Region getTransparentRegion() {
        return this.f8109c.getTransparentRegion();
    }

    public int getIntrinsicWidth() {
        return this.f8109c.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.f8109c.getIntrinsicHeight();
    }

    public int getMinimumWidth() {
        return this.f8109c.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.f8109c.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        return this.f8109c.getPadding(rect);
    }

    public ConstantState getConstantState() {
        if (this.f8108b == null || !this.f8108b.m713a()) {
            return null;
        }
        this.f8108b.f662a = getChangingConfigurations();
        return this.f8108b;
    }

    public Drawable mutate() {
        if (!this.f8113g && super.mutate() == this) {
            this.f8108b = mo2655b();
            if (this.f8109c != null) {
                this.f8109c.mutate();
            }
            if (this.f8108b != null) {
                this.f8108b.f663b = this.f8109c != null ? this.f8109c.getConstantState() : null;
            }
            this.f8113g = true;
        }
        return this;
    }

    /* renamed from: b */
    C0263a mo2655b() {
        return new C3158b(this.f8108b, null);
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    protected boolean onLevelChange(int i) {
        return this.f8109c.setLevel(i);
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f8108b.f664c = colorStateList;
        m9388a(getState());
    }

    public void setTintMode(Mode mode) {
        this.f8108b.f665d = mode;
        m9388a(getState());
    }

    /* renamed from: a */
    private boolean m9388a(int[] iArr) {
        if (!mo3325c()) {
            return false;
        }
        ColorStateList colorStateList = this.f8108b.f664c;
        Mode mode = this.f8108b.f665d;
        if (colorStateList == null || mode == null) {
            this.f8112f = false;
            clearColorFilter();
        } else {
            iArr = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!(this.f8112f && iArr == this.f8110d && mode == this.f8111e)) {
                setColorFilter(iArr, mode);
                this.f8110d = iArr;
                this.f8111e = mode;
                this.f8112f = true;
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public final Drawable mo162a() {
        return this.f8109c;
    }

    /* renamed from: a */
    public final void mo163a(Drawable drawable) {
        if (this.f8109c != null) {
            this.f8109c.setCallback(null);
        }
        this.f8109c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            if (this.f8108b != null) {
                this.f8108b.f663b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }
}
