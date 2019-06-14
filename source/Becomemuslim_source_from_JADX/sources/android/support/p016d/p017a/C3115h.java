package android.support.p016d.p017a;

import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.v4.p020a.p021a.C0259a;
import android.support.v4.p020a.p021a.C0261c;

/* compiled from: VectorDrawableCommon */
/* renamed from: android.support.d.a.h */
abstract class C3115h extends Drawable implements C0261c {
    /* renamed from: b */
    Drawable f7942b;

    C3115h() {
    }

    public void setColorFilter(int i, Mode mode) {
        if (this.f7942b != null) {
            this.f7942b.setColorFilter(i, mode);
        } else {
            super.setColorFilter(i, mode);
        }
    }

    public ColorFilter getColorFilter() {
        return this.f7942b != null ? C0259a.m701e(this.f7942b) : null;
    }

    protected boolean onLevelChange(int i) {
        if (this.f7942b != null) {
            return this.f7942b.setLevel(i);
        }
        return super.onLevelChange(i);
    }

    protected void onBoundsChange(Rect rect) {
        if (this.f7942b != null) {
            this.f7942b.setBounds(rect);
        } else {
            super.onBoundsChange(rect);
        }
    }

    public void setHotspot(float f, float f2) {
        if (this.f7942b != null) {
            C0259a.m689a(this.f7942b, f, f2);
        }
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.f7942b != null) {
            C0259a.m691a(this.f7942b, i, i2, i3, i4);
        }
    }

    public void setFilterBitmap(boolean z) {
        if (this.f7942b != null) {
            this.f7942b.setFilterBitmap(z);
        }
    }

    public void jumpToCurrentState() {
        if (this.f7942b != null) {
            C0259a.m688a(this.f7942b);
        }
    }

    public void applyTheme(Theme theme) {
        if (this.f7942b != null) {
            C0259a.m693a(this.f7942b, theme);
        }
    }

    public void clearColorFilter() {
        if (this.f7942b != null) {
            this.f7942b.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    public Drawable getCurrent() {
        if (this.f7942b != null) {
            return this.f7942b.getCurrent();
        }
        return super.getCurrent();
    }

    public int getMinimumWidth() {
        if (this.f7942b != null) {
            return this.f7942b.getMinimumWidth();
        }
        return super.getMinimumWidth();
    }

    public int getMinimumHeight() {
        if (this.f7942b != null) {
            return this.f7942b.getMinimumHeight();
        }
        return super.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        if (this.f7942b != null) {
            return this.f7942b.getPadding(rect);
        }
        return super.getPadding(rect);
    }

    public int[] getState() {
        if (this.f7942b != null) {
            return this.f7942b.getState();
        }
        return super.getState();
    }

    public Region getTransparentRegion() {
        if (this.f7942b != null) {
            return this.f7942b.getTransparentRegion();
        }
        return super.getTransparentRegion();
    }

    public void setChangingConfigurations(int i) {
        if (this.f7942b != null) {
            this.f7942b.setChangingConfigurations(i);
        } else {
            super.setChangingConfigurations(i);
        }
    }

    public boolean setState(int[] iArr) {
        if (this.f7942b != null) {
            return this.f7942b.setState(iArr);
        }
        return super.setState(iArr);
    }
}
