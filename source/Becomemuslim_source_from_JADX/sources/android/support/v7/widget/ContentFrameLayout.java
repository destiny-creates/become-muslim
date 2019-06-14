package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.C0517s;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class ContentFrameLayout extends FrameLayout {
    /* renamed from: a */
    private TypedValue f1764a;
    /* renamed from: b */
    private TypedValue f1765b;
    /* renamed from: c */
    private TypedValue f1766c;
    /* renamed from: d */
    private TypedValue f1767d;
    /* renamed from: e */
    private TypedValue f1768e;
    /* renamed from: f */
    private TypedValue f1769f;
    /* renamed from: g */
    private final Rect f1770g;
    /* renamed from: h */
    private C0679a f1771h;

    /* renamed from: android.support.v7.widget.ContentFrameLayout$a */
    public interface C0679a {
        /* renamed from: a */
        void mo376a();

        /* renamed from: b */
        void mo377b();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1770g = new Rect();
    }

    /* renamed from: a */
    public void m2254a(Rect rect) {
        fitSystemWindows(rect);
    }

    public void setAttachListener(C0679a c0679a) {
        this.f1771h = c0679a;
    }

    /* renamed from: a */
    public void m2253a(int i, int i2, int i3, int i4) {
        this.f1770g.set(i, i2, i3, i4);
        if (C0517s.m1730x(this) != 0) {
            requestLayout();
        }
    }

    protected void onMeasure(int i, int i2) {
        int dimension;
        TypedValue typedValue;
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        Object obj = 1;
        Object obj2 = displayMetrics.widthPixels < displayMetrics.heightPixels ? 1 : null;
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        if (mode == LinearLayoutManager.INVALID_OFFSET) {
            TypedValue typedValue2 = obj2 != null ? this.f1767d : this.f1766c;
            if (!(typedValue2 == null || typedValue2.type == 0)) {
                dimension = typedValue2.type == 5 ? (int) typedValue2.getDimension(displayMetrics) : typedValue2.type == 6 ? (int) typedValue2.getFraction((float) displayMetrics.widthPixels, (float) displayMetrics.widthPixels) : 0;
                if (dimension > 0) {
                    dimension = MeasureSpec.makeMeasureSpec(Math.min(dimension - (this.f1770g.left + this.f1770g.right), MeasureSpec.getSize(i)), 1073741824);
                    i = 1;
                    if (mode2 == LinearLayoutManager.INVALID_OFFSET) {
                        typedValue = obj2 == null ? this.f1768e : this.f1769f;
                        if (!(typedValue == null || typedValue.type == 0)) {
                            mode2 = typedValue.type != 5 ? (int) typedValue.getDimension(displayMetrics) : typedValue.type != 6 ? (int) typedValue.getFraction((float) displayMetrics.heightPixels, (float) displayMetrics.heightPixels) : 0;
                            if (mode2 > 0) {
                                i2 = MeasureSpec.makeMeasureSpec(Math.min(mode2 - (this.f1770g.top + this.f1770g.bottom), MeasureSpec.getSize(i2)), 1073741824);
                            }
                        }
                    }
                    super.onMeasure(dimension, i2);
                    mode2 = getMeasuredWidth();
                    dimension = MeasureSpec.makeMeasureSpec(mode2, 1073741824);
                    if (i == 0 && mode == LinearLayoutManager.INVALID_OFFSET) {
                        i = obj2 == null ? this.f1765b : this.f1764a;
                        if (!(i == 0 || i.type == 0)) {
                            i = i.type != 5 ? (int) i.getDimension(displayMetrics) : i.type != 6 ? (int) i.getFraction((float) displayMetrics.widthPixels, (float) displayMetrics.widthPixels) : 0;
                            if (i > 0) {
                                i -= this.f1770g.left + this.f1770g.right;
                            }
                            if (mode2 < i) {
                                dimension = MeasureSpec.makeMeasureSpec(i, 1073741824);
                                if (obj == null) {
                                    super.onMeasure(dimension, i2);
                                }
                            }
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        super.onMeasure(dimension, i2);
                    }
                }
            }
        }
        dimension = i;
        i = 0;
        if (mode2 == LinearLayoutManager.INVALID_OFFSET) {
            if (obj2 == null) {
            }
            if (typedValue.type != 5) {
                if (typedValue.type != 6) {
                }
            }
            if (mode2 > 0) {
                i2 = MeasureSpec.makeMeasureSpec(Math.min(mode2 - (this.f1770g.top + this.f1770g.bottom), MeasureSpec.getSize(i2)), 1073741824);
            }
        }
        super.onMeasure(dimension, i2);
        mode2 = getMeasuredWidth();
        dimension = MeasureSpec.makeMeasureSpec(mode2, 1073741824);
        if (obj2 == null) {
        }
        if (i.type != 5) {
            if (i.type != 6) {
            }
        }
        if (i > 0) {
            i -= this.f1770g.left + this.f1770g.right;
        }
        if (mode2 < i) {
            dimension = MeasureSpec.makeMeasureSpec(i, 1073741824);
            if (obj == null) {
                super.onMeasure(dimension, i2);
            }
        }
        obj = null;
        if (obj == null) {
            super.onMeasure(dimension, i2);
        }
    }

    public TypedValue getMinWidthMajor() {
        if (this.f1764a == null) {
            this.f1764a = new TypedValue();
        }
        return this.f1764a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f1765b == null) {
            this.f1765b = new TypedValue();
        }
        return this.f1765b;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f1766c == null) {
            this.f1766c = new TypedValue();
        }
        return this.f1766c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f1767d == null) {
            this.f1767d = new TypedValue();
        }
        return this.f1767d;
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f1768e == null) {
            this.f1768e = new TypedValue();
        }
        return this.f1768e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f1769f == null) {
            this.f1769f = new TypedValue();
        }
        return this.f1769f;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f1771h != null) {
            this.f1771h.mo376a();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f1771h != null) {
            this.f1771h.mo377b();
        }
    }
}
