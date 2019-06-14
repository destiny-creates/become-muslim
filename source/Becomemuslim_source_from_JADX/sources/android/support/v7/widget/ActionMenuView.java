package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.C0662o.C0661a;
import android.support.v7.view.menu.C0664p;
import android.support.v7.view.menu.C3273h;
import android.support.v7.view.menu.C3273h.C0657a;
import android.support.v7.view.menu.C3273h.C0658b;
import android.support.v7.view.menu.C3276j;
import android.support.v7.widget.as.C0762a;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView extends as implements C0658b, C0664p {
    /* renamed from: a */
    C0657a f8603a;
    /* renamed from: b */
    C0676e f8604b;
    /* renamed from: c */
    private C3273h f8605c;
    /* renamed from: d */
    private Context f8606d;
    /* renamed from: e */
    private int f8607e;
    /* renamed from: f */
    private boolean f8608f;
    /* renamed from: g */
    private C4492d f8609g;
    /* renamed from: h */
    private C0661a f8610h;
    /* renamed from: i */
    private boolean f8611i;
    /* renamed from: j */
    private int f8612j;
    /* renamed from: k */
    private int f8613k;
    /* renamed from: l */
    private int f8614l;

    /* renamed from: android.support.v7.widget.ActionMenuView$a */
    public interface C0675a {
        /* renamed from: c */
        boolean mo2733c();

        /* renamed from: d */
        boolean mo2734d();
    }

    /* renamed from: android.support.v7.widget.ActionMenuView$e */
    public interface C0676e {
        /* renamed from: a */
        boolean mo602a(MenuItem menuItem);
    }

    /* renamed from: android.support.v7.widget.ActionMenuView$b */
    private static class C3282b implements C0661a {
        /* renamed from: a */
        public void mo378a(C3273h c3273h, boolean z) {
        }

        /* renamed from: a */
        public boolean mo379a(C3273h c3273h) {
            return false;
        }

        C3282b() {
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuView$c */
    public static class C3283c extends C0762a {
        @ExportedProperty
        /* renamed from: a */
        public boolean f8596a;
        @ExportedProperty
        /* renamed from: b */
        public int f8597b;
        @ExportedProperty
        /* renamed from: c */
        public int f8598c;
        @ExportedProperty
        /* renamed from: d */
        public boolean f8599d;
        @ExportedProperty
        /* renamed from: e */
        public boolean f8600e;
        /* renamed from: f */
        boolean f8601f;

        public C3283c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C3283c(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C3283c(C3283c c3283c) {
            super(c3283c);
            this.f8596a = c3283c.f8596a;
        }

        public C3283c(int i, int i2) {
            super(i, i2);
            this.f8596a = false;
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuView$d */
    private class C3284d implements C0657a {
        /* renamed from: a */
        final /* synthetic */ ActionMenuView f8602a;

        C3284d(ActionMenuView actionMenuView) {
            this.f8602a = actionMenuView;
        }

        /* renamed from: a */
        public boolean mo389a(C3273h c3273h, MenuItem menuItem) {
            return (this.f8602a.f8604b == null || this.f8602a.f8604b.mo602a(menuItem) == null) ? null : true;
        }

        /* renamed from: a */
        public void mo388a(C3273h c3273h) {
            if (this.f8602a.f8603a != null) {
                this.f8602a.f8603a.mo388a(c3273h);
            }
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public int getWindowAnimations() {
        return 0;
    }

    /* renamed from: b */
    public /* synthetic */ C0762a mo499b(AttributeSet attributeSet) {
        return m10193a(attributeSet);
    }

    /* renamed from: b */
    protected /* synthetic */ C0762a mo500b(LayoutParams layoutParams) {
        return m10194a(layoutParams);
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m10200b();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m10193a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m10194a(layoutParams);
    }

    /* renamed from: j */
    protected /* synthetic */ C0762a mo505j() {
        return m10200b();
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.f8613k = (int) (56.0f * f);
        this.f8614l = (int) (f * 4.0f);
        this.f8606d = context;
        this.f8607e = 0;
    }

    public void setPopupTheme(int i) {
        if (this.f8607e != i) {
            this.f8607e = i;
            if (i == 0) {
                this.f8606d = getContext();
            } else {
                this.f8606d = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.f8607e;
    }

    public void setPresenter(C4492d c4492d) {
        this.f8609g = c4492d;
        this.f8609g.m15202a(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f8609g != null) {
            this.f8609g.mo468b(false);
            if (this.f8609g.m15216h() != null) {
                this.f8609g.m15213e();
                this.f8609g.m15212d();
            }
        }
    }

    public void setOnMenuItemClickListener(C0676e c0676e) {
        this.f8604b = c0676e;
    }

    protected void onMeasure(int i, int i2) {
        boolean z = this.f8611i;
        this.f8611i = MeasureSpec.getMode(i) == 1073741824;
        if (z != this.f8611i) {
            this.f8612j = 0;
        }
        int size = MeasureSpec.getSize(i);
        if (!(!this.f8611i || this.f8605c == null || size == this.f8612j)) {
            this.f8612j = size;
            this.f8605c.m10076b(true);
        }
        size = getChildCount();
        if (!this.f8611i || size <= 0) {
            for (int i3 = 0; i3 < size; i3++) {
                C3283c c3283c = (C3283c) getChildAt(i3).getLayoutParams();
                c3283c.rightMargin = 0;
                c3283c.leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        m10192c(i, i2);
    }

    /* renamed from: c */
    private void m10192c(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        size -= paddingLeft;
        paddingLeft = size / this.f8613k;
        int i3 = size % this.f8613k;
        if (paddingLeft == 0) {
            setMeasuredDimension(size, 0);
            return;
        }
        int i4;
        int i5;
        Object obj;
        int i6;
        int i7;
        int i8;
        int i9 = r0.f8613k + (i3 / paddingLeft);
        i3 = getChildCount();
        int i10 = paddingLeft;
        paddingLeft = 0;
        int i11 = 0;
        Object obj2 = null;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        long j = 0;
        while (paddingLeft < i3) {
            View childAt = getChildAt(paddingLeft);
            i4 = size2;
            if (childAt.getVisibility() == 8) {
                i5 = size;
            } else {
                int i15;
                boolean z;
                int i16;
                boolean z2 = childAt instanceof ActionMenuItemView;
                i12++;
                if (z2) {
                    i15 = i12;
                    i5 = size;
                    z = false;
                    childAt.setPadding(r0.f8614l, 0, r0.f8614l, 0);
                } else {
                    i5 = size;
                    i15 = i12;
                    z = false;
                }
                C3283c c3283c = (C3283c) childAt.getLayoutParams();
                c3283c.f8601f = z;
                c3283c.f8598c = z;
                c3283c.f8597b = z;
                c3283c.f8599d = z;
                c3283c.leftMargin = z;
                c3283c.rightMargin = z;
                z = z2 && ((ActionMenuItemView) childAt).m15061b();
                c3283c.f8600e = z;
                size = m10191a(childAt, i9, c3283c.f8596a ? 1 : i10, childMeasureSpec, paddingTop);
                size2 = Math.max(i13, size);
                if (c3283c.f8599d) {
                    i14++;
                }
                if (c3283c.f8596a) {
                    obj2 = 1;
                }
                i10 -= size;
                i11 = Math.max(i11, childAt.getMeasuredHeight());
                if (size == 1) {
                    i16 = size2;
                    j |= (long) (1 << paddingLeft);
                } else {
                    i16 = size2;
                }
                i12 = i15;
                i13 = i16;
            }
            paddingLeft++;
            size2 = i4;
            size = i5;
        }
        i5 = size;
        i4 = size2;
        Object obj3 = (obj2 == null || i12 != 2) ? null : 1;
        Object obj4 = null;
        while (i14 > 0 && i10 > 0) {
            paddingTop = 0;
            int i17 = 0;
            int i18 = Integer.MAX_VALUE;
            long j2 = 0;
            while (paddingTop < i3) {
                C3283c c3283c2 = (C3283c) getChildAt(paddingTop).getLayoutParams();
                obj = obj4;
                if (c3283c2.f8599d) {
                    if (c3283c2.f8597b < i18) {
                        j2 = 1 << paddingTop;
                        i18 = c3283c2.f8597b;
                        i17 = 1;
                    } else if (c3283c2.f8597b == i18) {
                        j2 |= 1 << paddingTop;
                        i17++;
                    }
                }
                paddingTop++;
                obj4 = obj;
            }
            obj = obj4;
            j |= j2;
            if (i17 > i10) {
                break;
            }
            i18++;
            size = 0;
            while (size < i3) {
                View childAt2 = getChildAt(size);
                C3283c c3283c3 = (C3283c) childAt2.getLayoutParams();
                i6 = i11;
                i7 = childMeasureSpec;
                i8 = i3;
                long j3 = (long) (1 << size);
                if ((j2 & j3) != 0) {
                    boolean z3;
                    if (obj3 == null || !c3283c3.f8600e) {
                        z3 = true;
                    } else {
                        z3 = true;
                        if (i10 == 1) {
                            childAt2.setPadding(r0.f8614l + i9, 0, r0.f8614l, 0);
                        }
                    }
                    c3283c3.f8597b += z3;
                    c3283c3.f8601f = z3;
                    i10--;
                } else if (c3283c3.f8597b == i18) {
                    j |= j3;
                }
                size++;
                i11 = i6;
                childMeasureSpec = i7;
                i3 = i8;
            }
            obj4 = 1;
        }
        obj = obj4;
        i7 = childMeasureSpec;
        i8 = i3;
        i6 = i11;
        View childAt3;
        C3283c c3283c4;
        if (obj2 == null) {
            size = 1;
            if (i12 == 1) {
                obj3 = 1;
                if (i10 > 0 || j == 0 || (i10 >= i12 - r2 && obj3 == null && i13 <= r2)) {
                    size = i8;
                    size2 = 0;
                } else {
                    float bitCount = (float) Long.bitCount(j);
                    if (obj3 == null) {
                        if ((j & 1) != 0) {
                            size2 = 0;
                            if (!((C3283c) getChildAt(0).getLayoutParams()).f8600e) {
                                bitCount -= 0.5f;
                            }
                        } else {
                            size2 = 0;
                        }
                        i3 = i8 - 1;
                        if (!((j & ((long) (1 << i3))) == 0 || ((C3283c) getChildAt(i3).getLayoutParams()).f8600e)) {
                            bitCount -= 0.5f;
                        }
                    } else {
                        size2 = 0;
                    }
                    i17 = bitCount > 0.0f ? (int) (((float) (i10 * i9)) / bitCount) : 0;
                    Object obj5 = obj;
                    size = i8;
                    for (paddingLeft = 0; paddingLeft < size; paddingLeft++) {
                        if ((j & ((long) (1 << paddingLeft))) != 0) {
                            childAt3 = getChildAt(paddingLeft);
                            c3283c4 = (C3283c) childAt3.getLayoutParams();
                            if (childAt3 instanceof ActionMenuItemView) {
                                c3283c4.f8598c = i17;
                                c3283c4.f8601f = true;
                                if (paddingLeft == 0 && !c3283c4.f8600e) {
                                    c3283c4.leftMargin = (-i17) / 2;
                                }
                            } else if (c3283c4.f8596a) {
                                c3283c4.f8598c = i17;
                                c3283c4.f8601f = true;
                                c3283c4.rightMargin = (-i17) / 2;
                            } else {
                                if (paddingLeft != 0) {
                                    c3283c4.leftMargin = i17 / 2;
                                }
                                if (paddingLeft != size - 1) {
                                    c3283c4.rightMargin = i17 / 2;
                                }
                            }
                            obj5 = 1;
                        }
                    }
                    obj = obj5;
                }
                if (obj != null) {
                    while (size2 < size) {
                        childAt3 = getChildAt(size2);
                        c3283c4 = (C3283c) childAt3.getLayoutParams();
                        if (c3283c4.f8601f) {
                            i3 = i7;
                        } else {
                            i3 = i7;
                            childAt3.measure(MeasureSpec.makeMeasureSpec((c3283c4.f8597b * i9) + c3283c4.f8598c, 1073741824), i3);
                        }
                        size2++;
                        i7 = i3;
                    }
                }
                if (mode == 1073741824) {
                    size = i5;
                    mode = i6;
                } else {
                    mode = i4;
                    size = i5;
                }
                setMeasuredDimension(size, mode);
            }
        }
        size = 1;
        obj3 = null;
        if (i10 > 0) {
        }
        size = i8;
        size2 = 0;
        if (obj != null) {
            while (size2 < size) {
                childAt3 = getChildAt(size2);
                c3283c4 = (C3283c) childAt3.getLayoutParams();
                if (c3283c4.f8601f) {
                    i3 = i7;
                    childAt3.measure(MeasureSpec.makeMeasureSpec((c3283c4.f8597b * i9) + c3283c4.f8598c, 1073741824), i3);
                } else {
                    i3 = i7;
                }
                size2++;
                i7 = i3;
            }
        }
        if (mode == 1073741824) {
            mode = i4;
            size = i5;
        } else {
            size = i5;
            mode = i6;
        }
        setMeasuredDimension(size, mode);
    }

    /* renamed from: a */
    static int m10191a(View view, int i, int i2, int i3, int i4) {
        C3283c c3283c = (C3283c) view.getLayoutParams();
        i3 = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i3) - i4, MeasureSpec.getMode(i3));
        i4 = (view instanceof ActionMenuItemView) != 0 ? (ActionMenuItemView) view : 0;
        boolean z = true;
        i4 = (i4 == 0 || i4.m15061b() == 0) ? 0 : 1;
        int i5 = 2;
        if (i2 <= 0 || (i4 != 0 && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(MeasureSpec.makeMeasureSpec(i2 * i, LinearLayoutManager.INVALID_OFFSET), i3);
            i2 = view.getMeasuredWidth();
            int i6 = i2 / i;
            if (i2 % i != 0) {
                i6++;
            }
            if (i4 == 0 || i6 >= 2) {
                i5 = i6;
            }
        }
        if (c3283c.f8596a != 0 || i4 == 0) {
            z = false;
        }
        c3283c.f8599d = z;
        c3283c.f8597b = i5;
        view.measure(MeasureSpec.makeMeasureSpec(i * i5, 1073741824), i3);
        return i5;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f8611i) {
            int i5;
            int childCount = getChildCount();
            int i6 = (i4 - i2) / 2;
            int dividerWidth = getDividerWidth();
            int i7 = i3 - i;
            int paddingRight = (i7 - getPaddingRight()) - getPaddingLeft();
            boolean a = by.m2841a(this);
            int i8 = paddingRight;
            int i9 = 0;
            int i10 = 0;
            for (paddingRight = 0; paddingRight < childCount; paddingRight++) {
                View childAt = getChildAt(paddingRight);
                if (childAt.getVisibility() != 8) {
                    C3283c c3283c = (C3283c) childAt.getLayoutParams();
                    if (c3283c.f8596a) {
                        int paddingLeft;
                        int i11;
                        i9 = childAt.getMeasuredWidth();
                        if (m10198a(paddingRight)) {
                            i9 += dividerWidth;
                        }
                        int measuredHeight = childAt.getMeasuredHeight();
                        if (a) {
                            paddingLeft = getPaddingLeft() + c3283c.leftMargin;
                            i11 = paddingLeft + i9;
                        } else {
                            i11 = (getWidth() - getPaddingRight()) - c3283c.rightMargin;
                            paddingLeft = i11 - i9;
                        }
                        i5 = i6 - (measuredHeight / 2);
                        childAt.layout(paddingLeft, i5, i11, measuredHeight + i5);
                        i8 -= i9;
                        i9 = 1;
                    } else {
                        i8 -= (childAt.getMeasuredWidth() + c3283c.leftMargin) + c3283c.rightMargin;
                        boolean a2 = m10198a(paddingRight);
                        i10++;
                    }
                }
            }
            if (childCount == 1 && i9 == 0) {
                View childAt2 = getChildAt(0);
                dividerWidth = childAt2.getMeasuredWidth();
                paddingRight = childAt2.getMeasuredHeight();
                i7 = (i7 / 2) - (dividerWidth / 2);
                i6 -= paddingRight / 2;
                childAt2.layout(i7, i6, dividerWidth + i7, paddingRight + i6);
                return;
            }
            i10 -= i9 ^ 1;
            if (i10 > 0) {
                i5 = i8 / i10;
                dividerWidth = 0;
            } else {
                dividerWidth = 0;
                i5 = 0;
            }
            i7 = Math.max(dividerWidth, i5);
            View childAt3;
            C3283c c3283c2;
            if (a) {
                paddingRight = getWidth() - getPaddingRight();
                while (dividerWidth < childCount) {
                    childAt3 = getChildAt(dividerWidth);
                    c3283c2 = (C3283c) childAt3.getLayoutParams();
                    if (childAt3.getVisibility() != 8) {
                        if (!c3283c2.f8596a) {
                            paddingRight -= c3283c2.rightMargin;
                            i9 = childAt3.getMeasuredWidth();
                            i10 = childAt3.getMeasuredHeight();
                            i8 = i6 - (i10 / 2);
                            childAt3.layout(paddingRight - i9, i8, paddingRight, i10 + i8);
                            paddingRight -= (i9 + c3283c2.leftMargin) + i7;
                        }
                    }
                    dividerWidth++;
                }
            } else {
                paddingRight = getPaddingLeft();
                while (dividerWidth < childCount) {
                    childAt3 = getChildAt(dividerWidth);
                    c3283c2 = (C3283c) childAt3.getLayoutParams();
                    if (childAt3.getVisibility() != 8) {
                        if (!c3283c2.f8596a) {
                            paddingRight += c3283c2.leftMargin;
                            i9 = childAt3.getMeasuredWidth();
                            i10 = childAt3.getMeasuredHeight();
                            i8 = i6 - (i10 / 2);
                            childAt3.layout(paddingRight, i8, paddingRight + i9, i10 + i8);
                            paddingRight += (i9 + c3283c2.rightMargin) + i7;
                        }
                    }
                    dividerWidth++;
                }
            }
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m10209i();
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f8609g.m15199a(drawable);
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f8609g.m15209c();
    }

    /* renamed from: a */
    public boolean m10197a() {
        return this.f8608f;
    }

    public void setOverflowReserved(boolean z) {
        this.f8608f = z;
    }

    /* renamed from: b */
    protected C3283c m10200b() {
        C3283c c3283c = new C3283c(-2, -2);
        c3283c.h = 16;
        return c3283c;
    }

    /* renamed from: a */
    public C3283c m10193a(AttributeSet attributeSet) {
        return new C3283c(getContext(), attributeSet);
    }

    /* renamed from: a */
    protected C3283c m10194a(LayoutParams layoutParams) {
        if (layoutParams == null) {
            return m10200b();
        }
        C3283c c3283c = layoutParams instanceof C3283c ? new C3283c((C3283c) layoutParams) : new C3283c(layoutParams);
        if (c3283c.h <= null) {
            c3283c.h = 16;
        }
        return c3283c;
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams == null || (layoutParams instanceof C3283c) == null) ? null : true;
    }

    /* renamed from: c */
    public C3283c m10203c() {
        C3283c b = m10200b();
        b.f8596a = true;
        return b;
    }

    /* renamed from: a */
    public boolean mo436a(C3276j c3276j) {
        return this.f8605c.m10070a((MenuItem) c3276j, 0);
    }

    /* renamed from: a */
    public void mo435a(C3273h c3273h) {
        this.f8605c = c3273h;
    }

    public Menu getMenu() {
        if (this.f8605c == null) {
            Context context = getContext();
            this.f8605c = new C3273h(context);
            this.f8605c.mo2749a(new C3284d(this));
            this.f8609g = new C4492d(context);
            this.f8609g.m15210c(true);
            this.f8609g.mo465a(this.f8610h != null ? this.f8610h : new C3282b());
            this.f8605c.m10065a(this.f8609g, this.f8606d);
            this.f8609g.m15202a(this);
        }
        return this.f8605c;
    }

    /* renamed from: a */
    public void m10196a(C0661a c0661a, C0657a c0657a) {
        this.f8610h = c0661a;
        this.f8603a = c0657a;
    }

    /* renamed from: d */
    public C3273h m10204d() {
        return this.f8605c;
    }

    /* renamed from: e */
    public boolean m10205e() {
        return this.f8609g != null && this.f8609g.m15212d();
    }

    /* renamed from: f */
    public boolean m10206f() {
        return this.f8609g != null && this.f8609g.m15213e();
    }

    /* renamed from: g */
    public boolean m10207g() {
        return this.f8609g != null && this.f8609g.m15216h();
    }

    /* renamed from: h */
    public boolean m10208h() {
        return this.f8609g != null && this.f8609g.m15217i();
    }

    /* renamed from: i */
    public void m10209i() {
        if (this.f8609g != null) {
            this.f8609g.m15214f();
        }
    }

    /* renamed from: a */
    protected boolean m10198a(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof C0675a)) {
            z = 0 | ((C0675a) childAt).mo2734d();
        }
        if (i > 0 && (childAt2 instanceof C0675a) != 0) {
            z |= ((C0675a) childAt2).mo2733c();
        }
        return z;
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.f8609g.m15211d(z);
    }
}
