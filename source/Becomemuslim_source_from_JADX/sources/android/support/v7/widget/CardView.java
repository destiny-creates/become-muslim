package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.p036b.C0628a.C0623a;
import android.support.v7.p036b.C0628a.C0624b;
import android.support.v7.p036b.C0628a.C0626d;
import android.support.v7.p036b.C0628a.C0627e;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class CardView extends FrameLayout {
    /* renamed from: e */
    private static final int[] f1755e = new int[]{16842801};
    /* renamed from: f */
    private static final ag f1756f;
    /* renamed from: a */
    int f1757a;
    /* renamed from: b */
    int f1758b;
    /* renamed from: c */
    final Rect f1759c;
    /* renamed from: d */
    final Rect f1760d;
    /* renamed from: g */
    private boolean f1761g;
    /* renamed from: h */
    private boolean f1762h;
    /* renamed from: i */
    private final af f1763i;

    /* renamed from: android.support.v7.widget.CardView$1 */
    class C32851 implements af {
        /* renamed from: a */
        final /* synthetic */ CardView f8619a;
        /* renamed from: b */
        private Drawable f8620b;

        C32851(CardView cardView) {
            this.f8619a = cardView;
        }

        /* renamed from: a */
        public void mo517a(Drawable drawable) {
            this.f8620b = drawable;
            this.f8619a.setBackgroundDrawable(drawable);
        }

        /* renamed from: a */
        public boolean mo518a() {
            return this.f8619a.getUseCompatPadding();
        }

        /* renamed from: b */
        public boolean mo519b() {
            return this.f8619a.getPreventCornerOverlap();
        }

        /* renamed from: a */
        public void mo516a(int i, int i2, int i3, int i4) {
            this.f8619a.f1760d.set(i, i2, i3, i4);
            super.setPadding(i + this.f8619a.f1759c.left, i2 + this.f8619a.f1759c.top, i3 + this.f8619a.f1759c.right, i4 + this.f8619a.f1759c.bottom);
        }

        /* renamed from: a */
        public void mo515a(int i, int i2) {
            if (i > this.f8619a.f1757a) {
                super.setMinimumWidth(i);
            }
            if (i2 > this.f8619a.f1758b) {
                super.setMinimumHeight(i2);
            }
        }

        /* renamed from: c */
        public Drawable mo520c() {
            return this.f8620b;
        }

        /* renamed from: d */
        public View mo521d() {
            return this.f8619a;
        }
    }

    public void setPadding(int i, int i2, int i3, int i4) {
    }

    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f1756f = new ad();
        } else if (VERSION.SDK_INT >= 17) {
            f1756f = new ac();
        } else {
            f1756f = new ae();
        }
        f1756f.mo607a();
    }

    public CardView(Context context) {
        this(context, null);
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0623a.cardViewStyle);
    }

    public CardView(Context context, AttributeSet attributeSet, int i) {
        int color;
        super(context, attributeSet, i);
        this.f1759c = new Rect();
        this.f1760d = new Rect();
        this.f1763i = new C32851(this);
        attributeSet = context.obtainStyledAttributes(attributeSet, C0627e.CardView, i, C0626d.CardView);
        if (attributeSet.hasValue(C0627e.CardView_cardBackgroundColor) != 0) {
            i = attributeSet.getColorStateList(C0627e.CardView_cardBackgroundColor);
        } else {
            i = getContext().obtainStyledAttributes(f1755e);
            color = i.getColor(0, 0);
            i.recycle();
            i = new float[3];
            Color.colorToHSV(color, i);
            if (i[2] > 1056964608) {
                i = getResources().getColor(C0624b.cardview_light_background);
            } else {
                i = getResources().getColor(C0624b.cardview_dark_background);
            }
            i = ColorStateList.valueOf(i);
        }
        ColorStateList colorStateList = i;
        float dimension = attributeSet.getDimension(C0627e.CardView_cardCornerRadius, 0.0f);
        float dimension2 = attributeSet.getDimension(C0627e.CardView_cardElevation, 0.0f);
        i = attributeSet.getDimension(C0627e.CardView_cardMaxElevation, 0.0f);
        this.f1761g = attributeSet.getBoolean(C0627e.CardView_cardUseCompatPadding, false);
        this.f1762h = attributeSet.getBoolean(C0627e.CardView_cardPreventCornerOverlap, true);
        color = attributeSet.getDimensionPixelSize(C0627e.CardView_contentPadding, 0);
        this.f1759c.left = attributeSet.getDimensionPixelSize(C0627e.CardView_contentPaddingLeft, color);
        this.f1759c.top = attributeSet.getDimensionPixelSize(C0627e.CardView_contentPaddingTop, color);
        this.f1759c.right = attributeSet.getDimensionPixelSize(C0627e.CardView_contentPaddingRight, color);
        this.f1759c.bottom = attributeSet.getDimensionPixelSize(C0627e.CardView_contentPaddingBottom, color);
        float f = dimension2 > i ? dimension2 : i;
        this.f1757a = attributeSet.getDimensionPixelSize(C0627e.CardView_android_minWidth, 0);
        this.f1758b = attributeSet.getDimensionPixelSize(C0627e.CardView_android_minHeight, 0);
        attributeSet.recycle();
        f1756f.mo609a(this.f1763i, context, colorStateList, dimension, dimension2, f);
    }

    public boolean getUseCompatPadding() {
        return this.f1761g;
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f1761g != z) {
            this.f1761g = z;
            f1756f.mo617g(this.f1763i);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (f1756f instanceof ad) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        if (mode == LinearLayoutManager.INVALID_OFFSET || mode == 1073741824) {
            i = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) f1756f.mo611b(this.f1763i)), MeasureSpec.getSize(i)), mode);
        }
        mode = MeasureSpec.getMode(i2);
        if (mode == LinearLayoutManager.INVALID_OFFSET || mode == 1073741824) {
            i2 = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) f1756f.mo613c(this.f1763i)), MeasureSpec.getSize(i2)), mode);
        }
        super.onMeasure(i, i2);
    }

    public void setMinimumWidth(int i) {
        this.f1757a = i;
        super.setMinimumWidth(i);
    }

    public void setMinimumHeight(int i) {
        this.f1758b = i;
        super.setMinimumHeight(i);
    }

    public void setCardBackgroundColor(int i) {
        f1756f.mo610a(this.f1763i, ColorStateList.valueOf(i));
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f1756f.mo610a(this.f1763i, colorStateList);
    }

    public ColorStateList getCardBackgroundColor() {
        return f1756f.mo619i(this.f1763i);
    }

    public int getContentPaddingLeft() {
        return this.f1759c.left;
    }

    public int getContentPaddingRight() {
        return this.f1759c.right;
    }

    public int getContentPaddingTop() {
        return this.f1759c.top;
    }

    public int getContentPaddingBottom() {
        return this.f1759c.bottom;
    }

    public void setRadius(float f) {
        f1756f.mo608a(this.f1763i, f);
    }

    public float getRadius() {
        return f1756f.mo615d(this.f1763i);
    }

    public void setCardElevation(float f) {
        f1756f.mo614c(this.f1763i, f);
    }

    public float getCardElevation() {
        return f1756f.mo616e(this.f1763i);
    }

    public void setMaxCardElevation(float f) {
        f1756f.mo612b(this.f1763i, f);
    }

    public float getMaxCardElevation() {
        return f1756f.mo606a(this.f1763i);
    }

    public boolean getPreventCornerOverlap() {
        return this.f1762h;
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.f1762h) {
            this.f1762h = z;
            f1756f.mo618h(this.f1763i);
        }
    }
}
