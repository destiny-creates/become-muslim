package android.support.v7.p039d.p040a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.v4.p020a.p021a.C0259a;

/* compiled from: DrawableWrapper */
/* renamed from: android.support.v7.d.a.a */
public class C0633a extends Drawable implements Callback {
    /* renamed from: a */
    private Drawable f1620a;

    public C0633a(Drawable drawable) {
        m2119a(drawable);
    }

    public void draw(Canvas canvas) {
        this.f1620a.draw(canvas);
    }

    protected void onBoundsChange(Rect rect) {
        this.f1620a.setBounds(rect);
    }

    public void setChangingConfigurations(int i) {
        this.f1620a.setChangingConfigurations(i);
    }

    public int getChangingConfigurations() {
        return this.f1620a.getChangingConfigurations();
    }

    public void setDither(boolean z) {
        this.f1620a.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f1620a.setFilterBitmap(z);
    }

    public void setAlpha(int i) {
        this.f1620a.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1620a.setColorFilter(colorFilter);
    }

    public boolean isStateful() {
        return this.f1620a.isStateful();
    }

    public boolean setState(int[] iArr) {
        return this.f1620a.setState(iArr);
    }

    public int[] getState() {
        return this.f1620a.getState();
    }

    public void jumpToCurrentState() {
        C0259a.m688a(this.f1620a);
    }

    public Drawable getCurrent() {
        return this.f1620a.getCurrent();
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (!super.setVisible(z, z2)) {
            if (!this.f1620a.setVisible(z, z2)) {
                return false;
            }
        }
        return true;
    }

    public int getOpacity() {
        return this.f1620a.getOpacity();
    }

    public Region getTransparentRegion() {
        return this.f1620a.getTransparentRegion();
    }

    public int getIntrinsicWidth() {
        return this.f1620a.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.f1620a.getIntrinsicHeight();
    }

    public int getMinimumWidth() {
        return this.f1620a.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.f1620a.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        return this.f1620a.getPadding(rect);
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
        return this.f1620a.setLevel(i);
    }

    public void setAutoMirrored(boolean z) {
        C0259a.m696a(this.f1620a, z);
    }

    public boolean isAutoMirrored() {
        return C0259a.m697b(this.f1620a);
    }

    public void setTint(int i) {
        C0259a.m690a(this.f1620a, i);
    }

    public void setTintList(ColorStateList colorStateList) {
        C0259a.m692a(this.f1620a, colorStateList);
    }

    public void setTintMode(Mode mode) {
        C0259a.m695a(this.f1620a, mode);
    }

    public void setHotspot(float f, float f2) {
        C0259a.m689a(this.f1620a, f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        C0259a.m691a(this.f1620a, i, i2, i3, i4);
    }

    /* renamed from: b */
    public Drawable m2120b() {
        return this.f1620a;
    }

    /* renamed from: a */
    public void m2119a(Drawable drawable) {
        if (this.f1620a != null) {
            this.f1620a.setCallback(null);
        }
        this.f1620a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }
}
