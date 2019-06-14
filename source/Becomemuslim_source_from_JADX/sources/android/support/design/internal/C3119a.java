package android.support.design.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.C0140a.C0139j;
import android.support.v7.widget.as;
import android.util.AttributeSet;
import android.view.Gravity;

/* compiled from: ForegroundLinearLayout */
/* renamed from: android.support.design.internal.a */
public class C3119a extends as {
    /* renamed from: a */
    protected boolean f7961a;
    /* renamed from: b */
    boolean f7962b;
    /* renamed from: c */
    private Drawable f7963c;
    /* renamed from: d */
    private final Rect f7964d;
    /* renamed from: e */
    private final Rect f7965e;
    /* renamed from: f */
    private int f7966f;

    public C3119a(Context context) {
        this(context, null);
    }

    public C3119a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C3119a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7964d = new Rect();
        this.f7965e = new Rect();
        this.f7966f = 119;
        this.f7961a = true;
        this.f7962b = false;
        context = context.obtainStyledAttributes(attributeSet, C0139j.ForegroundLinearLayout, i, 0);
        this.f7966f = context.getInt(C0139j.ForegroundLinearLayout_android_foregroundGravity, this.f7966f);
        attributeSet = context.getDrawable(C0139j.ForegroundLinearLayout_android_foreground);
        if (attributeSet != null) {
            setForeground(attributeSet);
        }
        this.f7961a = context.getBoolean(C0139j.ForegroundLinearLayout_foregroundInsidePadding, true);
        context.recycle();
    }

    public int getForegroundGravity() {
        return this.f7966f;
    }

    public void setForegroundGravity(int i) {
        if (this.f7966f != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.f7966f = i;
            if (this.f7966f == 119 && this.f7963c != 0) {
                this.f7963c.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable)) {
            if (drawable != this.f7963c) {
                return null;
            }
        }
        return true;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.f7963c != null) {
            this.f7963c.jumpToCurrentState();
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f7963c != null && this.f7963c.isStateful()) {
            this.f7963c.setState(getDrawableState());
        }
    }

    public void setForeground(Drawable drawable) {
        if (this.f7963c != drawable) {
            if (this.f7963c != null) {
                this.f7963c.setCallback(null);
                unscheduleDrawable(this.f7963c);
            }
            this.f7963c = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f7966f == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    public Drawable getForeground() {
        return this.f7963c;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f7962b = z | this.f7962b;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f7962b = true;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f7963c != null) {
            Drawable drawable = this.f7963c;
            if (this.f7962b) {
                this.f7962b = false;
                Rect rect = this.f7964d;
                Rect rect2 = this.f7965e;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f7961a) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f7966f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        if (this.f7963c != null) {
            this.f7963c.setHotspot(f, f2);
        }
    }
}
