package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.C0140a.C0132c;
import android.support.design.C0140a.C0139j;
import android.support.design.widget.C0187e.C0185c;
import android.support.design.widget.CoordinatorLayout.C0150b;
import android.support.design.widget.CoordinatorLayout.C0151c;
import android.support.design.widget.CoordinatorLayout.C0153e;
import android.support.v4.view.C0517s;
import android.support.v4.widget.C0580v;
import android.support.v7.widget.C0801q;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import java.util.List;

@C0151c(a = Behavior.class)
public class FloatingActionButton extends C0201s {
    /* renamed from: a */
    int f8003a;
    /* renamed from: b */
    boolean f8004b;
    /* renamed from: c */
    final Rect f8005c;
    /* renamed from: d */
    private ColorStateList f8006d;
    /* renamed from: e */
    private Mode f8007e;
    /* renamed from: f */
    private int f8008f;
    /* renamed from: g */
    private int f8009g;
    /* renamed from: h */
    private int f8010h;
    /* renamed from: i */
    private int f8011i;
    /* renamed from: j */
    private final Rect f8012j;
    /* renamed from: k */
    private C0801q f8013k;
    /* renamed from: l */
    private C0187e f8014l;

    /* renamed from: android.support.design.widget.FloatingActionButton$a */
    public static abstract class C0157a {
        /* renamed from: a */
        public void m369a(FloatingActionButton floatingActionButton) {
        }

        /* renamed from: b */
        public void m370b(FloatingActionButton floatingActionButton) {
        }
    }

    public static class Behavior extends C0150b<FloatingActionButton> {
        /* renamed from: a */
        private Rect f7999a;
        /* renamed from: b */
        private C0157a f8000b;
        /* renamed from: c */
        private boolean f8001c;

        /* renamed from: b */
        public /* synthetic */ boolean mo68b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return m9202a(coordinatorLayout, (FloatingActionButton) view, view2);
        }

        public Behavior() {
            this.f8001c = true;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            context = context.obtainStyledAttributes(attributeSet, C0139j.FloatingActionButton_Behavior_Layout);
            this.f8001c = context.getBoolean(C0139j.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            context.recycle();
        }

        /* renamed from: a */
        public void mo66a(C0153e c0153e) {
            if (c0153e.f341h == 0) {
                c0153e.f341h = 80;
            }
        }

        /* renamed from: a */
        public boolean m9202a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                m9195a(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
            } else if (m9196a(view) != null) {
                m9198b(view, floatingActionButton);
            }
            return null;
        }

        /* renamed from: a */
        private static boolean m9196a(View view) {
            view = view.getLayoutParams();
            return view instanceof C0153e ? ((C0153e) view).m356b() instanceof BottomSheetBehavior : null;
        }

        /* renamed from: a */
        private boolean m9197a(View view, FloatingActionButton floatingActionButton) {
            C0153e c0153e = (C0153e) floatingActionButton.getLayoutParams();
            if (this.f8001c && c0153e.m348a() == view.getId() && floatingActionButton.getUserSetVisibility() == null) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        private boolean m9195a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!m9197a((View) appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f7999a == null) {
                this.f7999a = new Rect();
            }
            Rect rect = this.f7999a;
            C0580v.m1962b(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.m9217b(this.f8000b, false);
            } else {
                floatingActionButton.m9215a(this.f8000b, false);
            }
            return true;
        }

        /* renamed from: b */
        private boolean m9198b(View view, FloatingActionButton floatingActionButton) {
            if (!m9197a(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((C0153e) floatingActionButton.getLayoutParams()).topMargin) {
                floatingActionButton.m9217b(this.f8000b, false);
            } else {
                floatingActionButton.m9215a(this.f8000b, false);
            }
            return true;
        }

        /* renamed from: a */
        public boolean m9200a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            List c = coordinatorLayout.m14810c((View) floatingActionButton);
            int size = c.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = (View) c.get(i2);
                if (!(view instanceof AppBarLayout)) {
                    if (m9196a(view) && m9198b(view, floatingActionButton)) {
                        break;
                    }
                } else if (m9195a(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.m14796a((View) floatingActionButton, i);
            m9194a(coordinatorLayout, floatingActionButton);
            return true;
        }

        /* renamed from: a */
        public boolean m9201a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            coordinatorLayout = floatingActionButton.f8005c;
            rect.set(floatingActionButton.getLeft() + coordinatorLayout.left, floatingActionButton.getTop() + coordinatorLayout.top, floatingActionButton.getRight() - coordinatorLayout.right, floatingActionButton.getBottom() - coordinatorLayout.bottom);
            return true;
        }

        /* renamed from: a */
        private void m9194a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            Rect rect = floatingActionButton.f8005c;
            if (rect != null && rect.centerX() > 0 && rect.centerY() > 0) {
                C0153e c0153e = (C0153e) floatingActionButton.getLayoutParams();
                int i = 0;
                int i2 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - c0153e.rightMargin ? rect.right : floatingActionButton.getLeft() <= c0153e.leftMargin ? -rect.left : 0;
                if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - c0153e.bottomMargin) {
                    i = rect.bottom;
                } else if (floatingActionButton.getTop() <= c0153e.topMargin) {
                    i = -rect.top;
                }
                if (i != 0) {
                    C0517s.m1707c((View) floatingActionButton, i);
                }
                if (i2 != 0) {
                    C0517s.m1710d(floatingActionButton, i2);
                }
            }
        }
    }

    /* renamed from: android.support.design.widget.FloatingActionButton$b */
    private class C3127b implements C0189j {
        /* renamed from: a */
        final /* synthetic */ FloatingActionButton f8002a;

        C3127b(FloatingActionButton floatingActionButton) {
            this.f8002a = floatingActionButton;
        }

        /* renamed from: a */
        public float mo69a() {
            return ((float) this.f8002a.getSizeDimension()) / 2.0f;
        }

        /* renamed from: a */
        public void mo70a(int i, int i2, int i3, int i4) {
            this.f8002a.f8005c.set(i, i2, i3, i4);
            this.f8002a.setPadding(i + this.f8002a.f8003a, i2 + this.f8002a.f8003a, i3 + this.f8002a.f8003a, i4 + this.f8002a.f8003a);
        }

        /* renamed from: a */
        public void mo71a(Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        /* renamed from: b */
        public boolean mo72b() {
            return this.f8002a.f8004b;
        }
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    protected void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        this.f8003a = (sizeDimension - this.f8011i) / 2;
        getImpl().m422e();
        i = Math.min(m9211a(sizeDimension, i), m9211a(sizeDimension, i2));
        setMeasuredDimension((this.f8005c.left + i) + this.f8005c.right, (i + this.f8005c.top) + this.f8005c.bottom);
    }

    public int getRippleColor() {
        return this.f8008f;
    }

    public void setRippleColor(int i) {
        if (this.f8008f != i) {
            this.f8008f = i;
            getImpl().mo86a(i);
        }
    }

    public ColorStateList getBackgroundTintList() {
        return this.f8006d;
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f8006d != colorStateList) {
            this.f8006d = colorStateList;
            getImpl().m412a(colorStateList);
        }
    }

    public Mode getBackgroundTintMode() {
        return this.f8007e;
    }

    public void setBackgroundTintMode(Mode mode) {
        if (this.f8007e != mode) {
            this.f8007e = mode;
            getImpl().m413a(mode);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundResource(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundColor(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setImageResource(int i) {
        this.f8013k.m2923a(i);
    }

    /* renamed from: a */
    void m9215a(C0157a c0157a, boolean z) {
        getImpl().m419b(m9212a(c0157a), z);
    }

    /* renamed from: b */
    void m9217b(C0157a c0157a, boolean z) {
        getImpl().m415a(m9212a(c0157a), z);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f8004b != z) {
            this.f8004b = z;
            getImpl().mo91d();
        }
    }

    public boolean getUseCompatPadding() {
        return this.f8004b;
    }

    public void setSize(int i) {
        if (i != this.f8009g) {
            this.f8009g = i;
            requestLayout();
        }
    }

    public int getSize() {
        return this.f8009g;
    }

    /* renamed from: a */
    private C0185c m9212a(final C0157a c0157a) {
        return c0157a == null ? null : new C0185c(this) {
            /* renamed from: b */
            final /* synthetic */ FloatingActionButton f7998b;

            /* renamed from: a */
            public void mo64a() {
                c0157a.m369a(this.f7998b);
            }

            /* renamed from: b */
            public void mo65b() {
                c0157a.m370b(this.f7998b);
            }
        };
    }

    public void setCustomSize(int i) {
        if (i >= 0) {
            this.f8010h = i;
            return;
        }
        throw new IllegalArgumentException("Custom size should be non-negative.");
    }

    public int getCustomSize() {
        return this.f8010h;
    }

    int getSizeDimension() {
        return m9210a(this.f8009g);
    }

    /* renamed from: a */
    private int m9210a(int i) {
        Resources resources = getResources();
        if (this.f8010h != 0) {
            return this.f8010h;
        }
        if (i == -1) {
            if (Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470) {
                i = m9210a(1);
            } else {
                i = m9210a(0);
            }
            return i;
        } else if (i != 1) {
            return resources.getDimensionPixelSize(C0132c.design_fab_size_normal);
        } else {
            return resources.getDimensionPixelSize(C0132c.design_fab_size_mini);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().m423f();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().m424g();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().mo88a(getDrawableState());
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().mo89b();
    }

    /* renamed from: a */
    public boolean m9216a(Rect rect) {
        if (!C0517s.m1730x(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        rect.left += this.f8005c.left;
        rect.top += this.f8005c.top;
        rect.right -= this.f8005c.right;
        rect.bottom -= this.f8005c.bottom;
        return true;
    }

    public Drawable getContentBackground() {
        return getImpl().m420c();
    }

    /* renamed from: a */
    private static int m9211a(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        i2 = MeasureSpec.getSize(i2);
        if (mode == LinearLayoutManager.INVALID_OFFSET) {
            return Math.min(i, i2);
        }
        if (mode != 0) {
            return mode != 1073741824 ? i : i2;
        } else {
            return i;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (m9216a(this.f8012j) && !this.f8012j.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return null;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public float getCompatElevation() {
        return getImpl().mo84a();
    }

    public void setCompatElevation(float f) {
        getImpl().m409a(f);
    }

    private C0187e getImpl() {
        if (this.f8014l == null) {
            this.f8014l = m9213a();
        }
        return this.f8014l;
    }

    /* renamed from: a */
    private C0187e m9213a() {
        if (VERSION.SDK_INT >= 21) {
            return new C3137f(this, new C3127b(this));
        }
        return new C0187e(this, new C3127b(this));
    }
}
