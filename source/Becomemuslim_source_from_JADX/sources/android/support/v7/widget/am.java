package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p020a.p021a.C0259a;
import android.support.v4.view.C0525w;
import android.support.v4.widget.C3242l;
import android.support.v7.p035a.C0591a.C0581a;
import android.support.v7.p039d.p040a.C0633a;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

/* compiled from: DropDownListView */
class am extends ListView {
    /* renamed from: a */
    private final Rect f1978a = new Rect();
    /* renamed from: b */
    private int f1979b = 0;
    /* renamed from: c */
    private int f1980c = 0;
    /* renamed from: d */
    private int f1981d = 0;
    /* renamed from: e */
    private int f1982e = 0;
    /* renamed from: f */
    private int f1983f;
    /* renamed from: g */
    private Field f1984g;
    /* renamed from: h */
    private C3305a f1985h;
    /* renamed from: i */
    private boolean f1986i;
    /* renamed from: j */
    private boolean f1987j;
    /* renamed from: k */
    private boolean f1988k;
    /* renamed from: l */
    private C0525w f1989l;
    /* renamed from: m */
    private C3242l f1990m;
    /* renamed from: n */
    private C0753b f1991n;

    /* compiled from: DropDownListView */
    /* renamed from: android.support.v7.widget.am$b */
    private class C0753b implements Runnable {
        /* renamed from: a */
        final /* synthetic */ am f1977a;

        private C0753b(am amVar) {
            this.f1977a = amVar;
        }

        public void run() {
            this.f1977a.f1991n = null;
            this.f1977a.drawableStateChanged();
        }

        /* renamed from: a */
        public void m2617a() {
            this.f1977a.f1991n = null;
            this.f1977a.removeCallbacks(this);
        }

        /* renamed from: b */
        public void m2618b() {
            this.f1977a.post(this);
        }
    }

    /* compiled from: DropDownListView */
    /* renamed from: android.support.v7.widget.am$a */
    private static class C3305a extends C0633a {
        /* renamed from: a */
        private boolean f8717a = true;

        C3305a(Drawable drawable) {
            super(drawable);
        }

        /* renamed from: a */
        void m10406a(boolean z) {
            this.f8717a = z;
        }

        public boolean setState(int[] iArr) {
            return this.f8717a ? super.setState(iArr) : null;
        }

        public void draw(Canvas canvas) {
            if (this.f8717a) {
                super.draw(canvas);
            }
        }

        public void setHotspot(float f, float f2) {
            if (this.f8717a) {
                super.setHotspot(f, f2);
            }
        }

        public void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.f8717a) {
                super.setHotspotBounds(i, i2, i3, i4);
            }
        }

        public boolean setVisible(boolean z, boolean z2) {
            return this.f8717a ? super.setVisible(z, z2) : false;
        }
    }

    am(Context context, boolean z) {
        super(context, null, C0581a.dropDownListViewStyle);
        this.f1987j = z;
        setCacheColorHint(0);
        try {
            this.f1984g = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f1984g.setAccessible(true);
        } catch (Context context2) {
            context2.printStackTrace();
        }
    }

    public boolean isInTouchMode() {
        return (this.f1987j && this.f1986i) || super.isInTouchMode();
    }

    public boolean hasWindowFocus() {
        if (!this.f1987j) {
            if (!super.hasWindowFocus()) {
                return false;
            }
        }
        return true;
    }

    public boolean isFocused() {
        if (!this.f1987j) {
            if (!super.isFocused()) {
                return false;
            }
        }
        return true;
    }

    public boolean hasFocus() {
        if (!this.f1987j) {
            if (!super.hasFocus()) {
                return false;
            }
        }
        return true;
    }

    public void setSelector(Drawable drawable) {
        this.f1985h = drawable != null ? new C3305a(drawable) : null;
        super.setSelector(this.f1985h);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f1979b = rect.left;
        this.f1980c = rect.top;
        this.f1981d = rect.right;
        this.f1982e = rect.bottom;
    }

    protected void drawableStateChanged() {
        if (this.f1991n == null) {
            super.drawableStateChanged();
            setSelectorEnabled(true);
            m2620a();
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        m2623a(canvas);
        super.dispatchDraw(canvas);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f1983f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (this.f1991n != null) {
            this.f1991n.m2617a();
        }
        return super.onTouchEvent(motionEvent);
    }

    /* renamed from: a */
    public int mo638a(int i, int i2, int i3, int i4, int i5) {
        i2 = getListPaddingTop();
        i3 = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return i2 + i3;
        }
        i2 += i3;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i6 = i2;
        View view = null;
        i2 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i2 < count) {
            int itemViewType = adapter.getItemViewType(i2);
            if (itemViewType != i7) {
                view = null;
                i7 = itemViewType;
            }
            view = adapter.getView(i2, view, this);
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            if (layoutParams.height > 0) {
                itemViewType = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            } else {
                itemViewType = MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i, itemViewType);
            view.forceLayout();
            if (i2 > 0) {
                i6 += dividerHeight;
            }
            i6 += view.getMeasuredHeight();
            if (i6 >= i4) {
                if (i5 >= 0 && i2 > i5 && i8 > 0 && i6 != i4) {
                    i4 = i8;
                }
                return i4;
            }
            if (i5 >= 0 && i2 >= i5) {
                i8 = i6;
            }
            i2++;
        }
        return i6;
    }

    private void setSelectorEnabled(boolean z) {
        if (this.f1985h != null) {
            this.f1985h.m10406a(z);
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f1991n == null) {
            this.f1991n = new C0753b();
            this.f1991n.m2618b();
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked != 9) {
            if (actionMasked != 7) {
                setSelection(-1);
                return onHoverEvent;
            }
        }
        motionEvent = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        if (!(motionEvent == -1 || motionEvent == getSelectedItemPosition())) {
            View childAt = getChildAt(motionEvent - getFirstVisiblePosition());
            if (childAt.isEnabled()) {
                setSelectionFromTop(motionEvent, childAt.getTop() - getTop());
            }
            m2620a();
        }
        return onHoverEvent;
    }

    protected void onDetachedFromWindow() {
        this.f1991n = null;
        super.onDetachedFromWindow();
    }

    /* renamed from: a */
    public boolean mo639a(MotionEvent motionEvent, int i) {
        boolean z;
        int actionMasked = motionEvent.getActionMasked();
        switch (actionMasked) {
            case 1:
                z = false;
                break;
            case 2:
                z = true;
                break;
            case 3:
                i = 0;
                z = false;
                break;
            default:
                i = 0;
                z = true;
                break;
        }
        i = motionEvent.findPointerIndex(i);
        if (i < 0) {
            i = 0;
            z = false;
            if (!(z && r9 == 0)) {
                m2626b();
            }
            if (!z) {
                if (this.f1990m == 0) {
                    this.f1990m = new C3242l(this);
                }
                this.f1990m.m1792a(true);
                this.f1990m.onTouch(this, motionEvent);
            } else if (this.f1990m != null) {
                this.f1990m.m1792a(false);
            }
            return z;
        }
        int x = (int) motionEvent.getX(i);
        i = (int) motionEvent.getY(i);
        int pointToPosition = pointToPosition(x, i);
        if (pointToPosition == -1) {
            i = 1;
            m2626b();
            if (!z) {
                if (this.f1990m == 0) {
                    this.f1990m = new C3242l(this);
                }
                this.f1990m.m1792a(true);
                this.f1990m.onTouch(this, motionEvent);
            } else if (this.f1990m != null) {
                this.f1990m.m1792a(false);
            }
            return z;
        }
        View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
        m2625a(childAt, pointToPosition, (float) x, (float) i);
        if (actionMasked == 1) {
            m2624a(childAt, pointToPosition);
        }
        i = 0;
        z = true;
        m2626b();
        if (!z) {
            if (this.f1990m == 0) {
                this.f1990m = new C3242l(this);
            }
            this.f1990m.m1792a(true);
            this.f1990m.onTouch(this, motionEvent);
        } else if (this.f1990m != null) {
            this.f1990m.m1792a(false);
        }
        return z;
    }

    /* renamed from: a */
    private void m2624a(View view, int i) {
        performItemClick(view, i, getItemIdAtPosition(i));
    }

    void setListSelectionHidden(boolean z) {
        this.f1986i = z;
    }

    /* renamed from: a */
    private void m2620a() {
        Drawable selector = getSelector();
        if (selector != null && m2628c() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    /* renamed from: a */
    private void m2623a(Canvas canvas) {
        if (!this.f1978a.isEmpty()) {
            Drawable selector = getSelector();
            if (selector != null) {
                selector.setBounds(this.f1978a);
                selector.draw(canvas);
            }
        }
    }

    /* renamed from: a */
    private void m2622a(int i, View view, float f, float f2) {
        m2621a(i, view);
        view = getSelector();
        if (view != null && i != -1) {
            C0259a.m689a(view, f, f2);
        }
    }

    /* renamed from: a */
    private void m2621a(int i, View view) {
        Drawable selector = getSelector();
        boolean z = true;
        Object obj = (selector == null || i == -1) ? null : 1;
        if (obj != null) {
            selector.setVisible(false, false);
        }
        m2627b(i, view);
        if (obj != null) {
            i = this.f1978a;
            view = i.exactCenterX();
            i = i.exactCenterY();
            if (getVisibility() != 0) {
                z = false;
            }
            selector.setVisible(z, false);
            C0259a.m689a(selector, view, i);
        }
    }

    /* renamed from: b */
    private void m2627b(int i, View view) {
        Rect rect = this.f1978a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f1979b;
        rect.top -= this.f1980c;
        rect.right += this.f1981d;
        rect.bottom += this.f1982e;
        try {
            boolean z = this.f1984g.getBoolean(this);
            if (view.isEnabled() != z) {
                this.f1984g.set(this, Boolean.valueOf(z ^ 1));
                if (i != -1) {
                    refreshDrawableState();
                }
            }
        } catch (int i2) {
            i2.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m2626b() {
        this.f1988k = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f1983f - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        if (this.f1989l != null) {
            this.f1989l.m1761b();
            this.f1989l = null;
        }
    }

    /* renamed from: a */
    private void m2625a(View view, int i, float f, float f2) {
        this.f1988k = true;
        if (VERSION.SDK_INT >= 21) {
            drawableHotspotChanged(f, f2);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        if (this.f1983f != -1) {
            View childAt = getChildAt(this.f1983f - getFirstVisiblePosition());
            if (!(childAt == null || childAt == view || !childAt.isPressed())) {
                childAt.setPressed(false);
            }
        }
        this.f1983f = i;
        float left = f - ((float) view.getLeft());
        float top = f2 - ((float) view.getTop());
        if (VERSION.SDK_INT >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        m2622a(i, view, f, f2);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    /* renamed from: c */
    private boolean m2628c() {
        return this.f1988k;
    }
}
