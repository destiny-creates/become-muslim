package android.support.v4.p020a.p021a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.v4.p020a.p021a.C3159e.C0263a;
import android.util.Log;
import java.lang.reflect.Method;

/* compiled from: WrappedDrawableApi21 */
/* renamed from: android.support.v4.a.a.g */
class C4824g extends C4452f {
    /* renamed from: d */
    private static Method f13676d;

    /* compiled from: WrappedDrawableApi21 */
    /* renamed from: android.support.v4.a.a.g$a */
    private static class C3161a extends C0263a {
        C3161a(C0263a c0263a, Resources resources) {
            super(c0263a, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new C4824g(this, resources);
        }
    }

    C4824g(Drawable drawable) {
        super(drawable);
        m17108d();
    }

    C4824g(C0263a c0263a, Resources resources) {
        super(c0263a, resources);
        m17108d();
    }

    public void setHotspot(float f, float f2) {
        this.c.setHotspot(f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.c.setHotspotBounds(i, i2, i3, i4);
    }

    public void getOutline(Outline outline) {
        this.c.getOutline(outline);
    }

    public Rect getDirtyBounds() {
        return this.c.getDirtyBounds();
    }

    public void setTintList(ColorStateList colorStateList) {
        if (mo3325c()) {
            super.setTintList(colorStateList);
        } else {
            this.c.setTintList(colorStateList);
        }
    }

    public void setTint(int i) {
        if (mo3325c()) {
            super.setTint(i);
        } else {
            this.c.setTint(i);
        }
    }

    public void setTintMode(Mode mode) {
        if (mo3325c()) {
            super.setTintMode(mode);
        } else {
            this.c.setTintMode(mode);
        }
    }

    public boolean setState(int[] iArr) {
        if (super.setState(iArr) == null) {
            return null;
        }
        invalidateSelf();
        return 1;
    }

    /* renamed from: c */
    protected boolean mo3325c() {
        boolean z = false;
        if (VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.c;
        if ((drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable)) {
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    C0263a mo2655b() {
        return new C3161a(this.b, null);
    }

    /* renamed from: d */
    private void m17108d() {
        if (f13676d == null) {
            try {
                f13676d = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Throwable e) {
                Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", e);
            }
        }
    }
}
