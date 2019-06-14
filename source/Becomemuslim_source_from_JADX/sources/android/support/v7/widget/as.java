package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.view.C0501e;
import android.support.v4.view.C0517s;
import android.support.v7.p035a.C0591a.C0590j;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/* compiled from: LinearLayoutCompat */
public class as extends ViewGroup {
    /* renamed from: a */
    private boolean f2029a;
    /* renamed from: b */
    private int f2030b;
    /* renamed from: c */
    private int f2031c;
    /* renamed from: d */
    private int f2032d;
    /* renamed from: e */
    private int f2033e;
    /* renamed from: f */
    private int f2034f;
    /* renamed from: g */
    private float f2035g;
    /* renamed from: h */
    private boolean f2036h;
    /* renamed from: i */
    private int[] f2037i;
    /* renamed from: j */
    private int[] f2038j;
    /* renamed from: k */
    private Drawable f2039k;
    /* renamed from: l */
    private int f2040l;
    /* renamed from: m */
    private int f2041m;
    /* renamed from: n */
    private int f2042n;
    /* renamed from: o */
    private int f2043o;

    /* compiled from: LinearLayoutCompat */
    /* renamed from: android.support.v7.widget.as$a */
    public static class C0762a extends MarginLayoutParams {
        /* renamed from: g */
        public float f2027g;
        /* renamed from: h */
        public int f2028h;

        public C0762a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2028h = -1;
            context = context.obtainStyledAttributes(attributeSet, C0590j.LinearLayoutCompat_Layout);
            this.f2027g = context.getFloat(C0590j.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.f2028h = context.getInt(C0590j.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            context.recycle();
        }

        public C0762a(int i, int i2) {
            super(i, i2);
            this.f2028h = -1;
            this.f2027g = 0;
        }

        public C0762a(LayoutParams layoutParams) {
            super(layoutParams);
            this.f2028h = -1;
        }
    }

    /* renamed from: a */
    int m2659a(View view) {
        return 0;
    }

    /* renamed from: a */
    int m2660a(View view, int i) {
        return 0;
    }

    /* renamed from: b */
    int m2666b(View view) {
        return 0;
    }

    /* renamed from: d */
    int m2675d(int i) {
        return 0;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return mo505j();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return mo499b(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return mo500b(layoutParams);
    }

    public as(Context context) {
        this(context, null);
    }

    public as(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public as(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2029a = true;
        this.f2030b = -1;
        this.f2031c = 0;
        this.f2033e = 8388659;
        context = bq.m2769a(context, attributeSet, C0590j.LinearLayoutCompat, i, 0);
        attributeSet = context.m2771a(C0590j.LinearLayoutCompat_android_orientation, -1);
        if (attributeSet >= null) {
            setOrientation(attributeSet);
        }
        attributeSet = context.m2771a(C0590j.LinearLayoutCompat_android_gravity, -1);
        if (attributeSet >= null) {
            setGravity(attributeSet);
        }
        attributeSet = context.m2775a(C0590j.LinearLayoutCompat_android_baselineAligned, true);
        if (attributeSet == null) {
            setBaselineAligned(attributeSet);
        }
        this.f2035g = context.m2770a(C0590j.LinearLayoutCompat_android_weightSum, (float) -1082130432);
        this.f2030b = context.m2771a(C0590j.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.f2036h = context.m2775a(C0590j.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(context.m2773a(C0590j.LinearLayoutCompat_divider));
        this.f2042n = context.m2771a(C0590j.LinearLayoutCompat_showDividers, 0);
        this.f2043o = context.m2782e(C0590j.LinearLayoutCompat_dividerPadding, 0);
        context.m2774a();
    }

    public void setShowDividers(int i) {
        if (i != this.f2042n) {
            requestLayout();
        }
        this.f2042n = i;
    }

    public int getShowDividers() {
        return this.f2042n;
    }

    public Drawable getDividerDrawable() {
        return this.f2039k;
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable != this.f2039k) {
            this.f2039k = drawable;
            boolean z = false;
            if (drawable != null) {
                this.f2040l = drawable.getIntrinsicWidth();
                this.f2041m = drawable.getIntrinsicHeight();
            } else {
                this.f2040l = 0;
                this.f2041m = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        this.f2043o = i;
    }

    public int getDividerPadding() {
        return this.f2043o;
    }

    public int getDividerWidth() {
        return this.f2040l;
    }

    protected void onDraw(Canvas canvas) {
        if (this.f2039k != null) {
            if (this.f2032d == 1) {
                m2663a(canvas);
            } else {
                m2672b(canvas);
            }
        }
    }

    /* renamed from: a */
    void m2663a(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        int i = 0;
        while (i < virtualChildCount) {
            View b = m2669b(i);
            if (!(b == null || b.getVisibility() == 8 || !m2674c(i))) {
                m2664a(canvas, (b.getTop() - ((C0762a) b.getLayoutParams()).topMargin) - this.f2041m);
            }
            i++;
        }
        if (m2674c(virtualChildCount)) {
            View b2 = m2669b(virtualChildCount - 1);
            if (b2 == null) {
                virtualChildCount = (getHeight() - getPaddingBottom()) - this.f2041m;
            } else {
                virtualChildCount = b2.getBottom() + ((C0762a) b2.getLayoutParams()).bottomMargin;
            }
            m2664a(canvas, virtualChildCount);
        }
    }

    /* renamed from: b */
    void m2672b(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        boolean a = by.m2841a(this);
        int i = 0;
        while (i < virtualChildCount) {
            View b = m2669b(i);
            if (!(b == null || b.getVisibility() == 8 || !m2674c(i))) {
                int right;
                C0762a c0762a = (C0762a) b.getLayoutParams();
                if (a) {
                    right = b.getRight() + c0762a.rightMargin;
                } else {
                    right = (b.getLeft() - c0762a.leftMargin) - this.f2040l;
                }
                m2673b(canvas, right);
            }
            i++;
        }
        if (m2674c(virtualChildCount)) {
            View b2 = m2669b(virtualChildCount - 1);
            if (b2 != null) {
                C0762a c0762a2 = (C0762a) b2.getLayoutParams();
                if (a) {
                    virtualChildCount = (b2.getLeft() - c0762a2.leftMargin) - this.f2040l;
                } else {
                    virtualChildCount = b2.getRight() + c0762a2.rightMargin;
                }
            } else if (a) {
                virtualChildCount = getPaddingLeft();
            } else {
                virtualChildCount = (getWidth() - getPaddingRight()) - this.f2040l;
            }
            m2673b(canvas, virtualChildCount);
        }
    }

    /* renamed from: a */
    void m2664a(Canvas canvas, int i) {
        this.f2039k.setBounds(getPaddingLeft() + this.f2043o, i, (getWidth() - getPaddingRight()) - this.f2043o, this.f2041m + i);
        this.f2039k.draw(canvas);
    }

    /* renamed from: b */
    void m2673b(Canvas canvas, int i) {
        this.f2039k.setBounds(i, getPaddingTop() + this.f2043o, this.f2040l + i, (getHeight() - getPaddingBottom()) - this.f2043o);
        this.f2039k.draw(canvas);
    }

    public void setBaselineAligned(boolean z) {
        this.f2029a = z;
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.f2036h = z;
    }

    public int getBaseline() {
        if (this.f2030b < 0) {
            return super.getBaseline();
        }
        if (getChildCount() > this.f2030b) {
            View childAt = getChildAt(this.f2030b);
            int baseline = childAt.getBaseline();
            if (baseline != -1) {
                int i = this.f2031c;
                if (this.f2032d == 1) {
                    int i2 = this.f2033e & 112;
                    if (i2 != 48) {
                        if (i2 == 16) {
                            i += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f2034f) / 2;
                        } else if (i2 == 80) {
                            i = ((getBottom() - getTop()) - getPaddingBottom()) - this.f2034f;
                        }
                    }
                }
                return (i + ((C0762a) childAt.getLayoutParams()).topMargin) + baseline;
            } else if (this.f2030b == 0) {
                return -1;
            } else {
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
        }
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
    }

    public int getBaselineAlignedChildIndex() {
        return this.f2030b;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("base aligned child index out of range (0, ");
            stringBuilder.append(getChildCount());
            stringBuilder.append(")");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.f2030b = i;
    }

    /* renamed from: b */
    View m2669b(int i) {
        return getChildAt(i);
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f2035g;
    }

    public void setWeightSum(float f) {
        this.f2035g = Math.max(0.0f, f);
    }

    protected void onMeasure(int i, int i2) {
        if (this.f2032d == 1) {
            m2661a(i, i2);
        } else {
            m2670b(i, i2);
        }
    }

    /* renamed from: c */
    protected boolean m2674c(int i) {
        boolean z = false;
        if (i == 0) {
            if ((this.f2042n & 1) != 0) {
                z = true;
            }
            return z;
        } else if (i == getChildCount()) {
            if ((this.f2042n & 4) != 0) {
                z = true;
            }
            return z;
        } else if ((this.f2042n & 2) == 0) {
            return false;
        } else {
            for (i--; i >= 0; i--) {
                if (getChildAt(i).getVisibility() != 8) {
                    z = true;
                    break;
                }
            }
            return z;
        }
    }

    /* renamed from: a */
    void m2661a(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = i;
        int i10 = i2;
        this.f2034f = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int i11 = this.f2030b;
        boolean z = this.f2036h;
        float f = 0.0f;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        Object obj = null;
        Object obj2 = 1;
        Object obj3 = null;
        while (true) {
            i3 = 8;
            i4 = i15;
            if (i17 >= virtualChildCount) {
                break;
            }
            View view;
            Object obj4;
            View b = m2669b(i17);
            if (b == null) {
                r7.f2034f += m2675d(i17);
                i5 = virtualChildCount;
                i6 = mode2;
                i15 = i4;
            } else {
                int i18 = i12;
                if (b.getVisibility() == 8) {
                    i17 += m2660a(b, i17);
                    i5 = virtualChildCount;
                    i6 = mode2;
                    i15 = i4;
                    i12 = i18;
                } else {
                    int i19;
                    int i20;
                    if (m2674c(i17)) {
                        r7.f2034f += r7.f2041m;
                    }
                    C0762a c0762a = (C0762a) b.getLayoutParams();
                    float f2 = f + c0762a.f2027g;
                    int i21;
                    if (mode2 == 1073741824 && c0762a.height == 0 && c0762a.f2027g > 0.0f) {
                        i7 = r7.f2034f;
                        i21 = i13;
                        r7.f2034f = Math.max(i7, (c0762a.topMargin + i7) + c0762a.bottomMargin);
                        i7 = i14;
                        view = b;
                        i19 = i16;
                        i5 = virtualChildCount;
                        i6 = mode2;
                        mode2 = i4;
                        i9 = i18;
                        i20 = i21;
                        obj = 1;
                        virtualChildCount = i17;
                    } else {
                        i21 = i13;
                        if (c0762a.height != 0 || c0762a.f2027g <= 0.0f) {
                            i13 = LinearLayoutManager.INVALID_OFFSET;
                        } else {
                            c0762a.height = -2;
                            i13 = 0;
                        }
                        i9 = i18;
                        int i22 = i13;
                        i20 = i21;
                        i10 = i14;
                        View view2 = b;
                        i5 = virtualChildCount;
                        i6 = mode2;
                        mode2 = i4;
                        i19 = i16;
                        virtualChildCount = i17;
                        m2665a(b, i17, i, 0, i2, f2 == 0.0f ? r7.f2034f : 0);
                        i7 = i22;
                        if (i7 != LinearLayoutManager.INVALID_OFFSET) {
                            c0762a.height = i7;
                        }
                        i7 = view2.getMeasuredHeight();
                        i12 = r7.f2034f;
                        view = view2;
                        r7.f2034f = Math.max(i12, (((i12 + i7) + c0762a.topMargin) + c0762a.bottomMargin) + m2666b(view));
                        i7 = z ? Math.max(i7, i10) : i10;
                    }
                    if (i11 >= 0 && i11 == virtualChildCount + 1) {
                        r7.f2031c = r7.f2034f;
                    }
                    if (virtualChildCount < i11) {
                        if (c0762a.f2027g > 0.0f) {
                            throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                        }
                    }
                    if (mode == 1073741824 || c0762a.width != -1) {
                        obj4 = null;
                    } else {
                        obj4 = 1;
                        obj3 = 1;
                    }
                    i13 = c0762a.leftMargin + c0762a.rightMargin;
                    i15 = view.getMeasuredWidth() + i13;
                    i16 = Math.max(i20, i15);
                    i17 = View.combineMeasuredStates(i9, view.getMeasuredState());
                    Object obj5 = (obj2 == null || c0762a.width != -1) ? null : 1;
                    if (c0762a.f2027g > 0.0f) {
                        if (obj4 == null) {
                            i13 = i15;
                        }
                        mode2 = Math.max(mode2, i13);
                        i12 = i19;
                    } else {
                        if (obj4 == null) {
                            i13 = i15;
                        }
                        i12 = Math.max(i19, i13);
                    }
                    i14 = i7;
                    obj2 = obj5;
                    i15 = mode2;
                    f = f2;
                    i8 = i16;
                    i16 = i12;
                    i12 = i17;
                    i17 = m2660a(view, virtualChildCount) + virtualChildCount;
                    i13 = i8;
                }
            }
            i17++;
            mode2 = i6;
            virtualChildCount = i5;
            i9 = i;
            i10 = i2;
        }
        i9 = i12;
        i10 = i14;
        i12 = i16;
        i5 = virtualChildCount;
        i6 = mode2;
        mode2 = i4;
        i16 = i13;
        if (r7.f2034f > 0) {
            i13 = i5;
            if (m2674c(i13)) {
                r7.f2034f += r7.f2041m;
            }
        } else {
            i13 = i5;
        }
        if (z) {
            i14 = i6;
            if (i14 == Integer.MIN_VALUE || i14 == 0) {
                r7.f2034f = 0;
                i15 = 0;
                while (i15 < i13) {
                    View b2 = m2669b(i15);
                    if (b2 == null) {
                        r7.f2034f += m2675d(i15);
                    } else if (b2.getVisibility() == i3) {
                        i15 += m2660a(b2, i15);
                    } else {
                        C0762a c0762a2 = (C0762a) b2.getLayoutParams();
                        i11 = r7.f2034f;
                        r7.f2034f = Math.max(i11, (((i11 + i10) + c0762a2.topMargin) + c0762a2.bottomMargin) + m2666b(b2));
                    }
                    i15++;
                    i3 = 8;
                }
            }
        } else {
            i14 = i6;
        }
        r7.f2034f += getPaddingTop() + getPaddingBottom();
        i3 = i10;
        i17 = i2;
        i15 = View.resolveSizeAndState(Math.max(r7.f2034f, getSuggestedMinimumHeight()), i17, 0);
        i10 = (16777215 & i15) - r7.f2034f;
        if (obj == null) {
            if (i10 == 0 || f <= 0.0f) {
                i7 = Math.max(i12, mode2);
                if (z && r3 != 1073741824) {
                    for (i12 = 0; i12 < i13; i12++) {
                        view = m2669b(i12);
                        if (view != null) {
                            if (view.getVisibility() != 8) {
                                if (((C0762a) view.getLayoutParams()).f2027g > 0.0f) {
                                    view.measure(MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(i3, 1073741824));
                                }
                            }
                        }
                    }
                }
                i12 = i9;
                virtualChildCount = i;
                if (obj2 == null || mode == 1073741824) {
                    i7 = i16;
                }
                setMeasuredDimension(View.resolveSizeAndState(Math.max(i7 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), virtualChildCount, i12), i15);
                if (obj3 != null) {
                    m2657c(i13, i17);
                }
            }
        }
        if (r7.f2035g > 0.0f) {
            f = r7.f2035g;
        }
        r7.f2034f = 0;
        float f3 = f;
        i7 = 0;
        i8 = i9;
        i9 = i12;
        i12 = i8;
        while (i7 < i13) {
            int i23;
            float f4;
            View b3 = m2669b(i7);
            if (b3.getVisibility() == 8) {
                i23 = i14;
                f4 = f3;
                virtualChildCount = i;
            } else {
                int i24;
                C0762a c0762a3 = (C0762a) b3.getLayoutParams();
                f4 = c0762a3.f2027g;
                if (f4 > 0.0f) {
                    i24 = (int) ((((float) i10) * f4) / f3);
                    int i25 = i10 - i24;
                    float f5 = f3 - f4;
                    i10 = getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + c0762a3.leftMargin) + c0762a3.rightMargin, c0762a3.width);
                    if (c0762a3.height == 0) {
                        i3 = 1073741824;
                        if (i14 == 1073741824) {
                            if (i24 <= 0) {
                                i24 = 0;
                            }
                            b3.measure(i10, MeasureSpec.makeMeasureSpec(i24, 1073741824));
                            i12 = View.combineMeasuredStates(i12, b3.getMeasuredState() & -256);
                            i10 = i25;
                            f4 = f5;
                        }
                    } else {
                        i3 = 1073741824;
                    }
                    i24 = b3.getMeasuredHeight() + i24;
                    if (i24 < 0) {
                        i24 = 0;
                    }
                    b3.measure(i10, MeasureSpec.makeMeasureSpec(i24, i3));
                    i12 = View.combineMeasuredStates(i12, b3.getMeasuredState() & -256);
                    i10 = i25;
                    f4 = f5;
                } else {
                    f4 = f3;
                    virtualChildCount = i;
                }
                int i26 = i12;
                i24 = c0762a3.leftMargin + c0762a3.rightMargin;
                i12 = b3.getMeasuredWidth() + i24;
                i16 = Math.max(i16, i12);
                int i27 = i12;
                if (mode != 1073741824) {
                    i23 = i14;
                    i14 = -1;
                    if (c0762a3.width == -1) {
                        obj4 = 1;
                        if (obj4 != null) {
                            i24 = i27;
                        }
                        i12 = Math.max(i9, i24);
                        obj5 = (obj2 == null && c0762a3.width == i14) ? 1 : null;
                        i24 = r7.f2034f;
                        r7.f2034f = Math.max(i24, (((i24 + b3.getMeasuredHeight()) + c0762a3.topMargin) + c0762a3.bottomMargin) + m2666b(b3));
                        obj2 = obj5;
                        i9 = i12;
                        i12 = i26;
                    }
                } else {
                    i23 = i14;
                    i14 = -1;
                }
                obj4 = null;
                if (obj4 != null) {
                    i24 = i27;
                }
                i12 = Math.max(i9, i24);
                if (obj2 == null) {
                }
                i24 = r7.f2034f;
                r7.f2034f = Math.max(i24, (((i24 + b3.getMeasuredHeight()) + c0762a3.topMargin) + c0762a3.bottomMargin) + m2666b(b3));
                obj2 = obj5;
                i9 = i12;
                i12 = i26;
            }
            i7++;
            f3 = f4;
            i14 = i23;
        }
        virtualChildCount = i;
        r7.f2034f += getPaddingTop() + getPaddingBottom();
        i7 = i9;
        if (obj2 == null) {
        }
        i7 = i16;
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i7 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), virtualChildCount, i12), i15);
        if (obj3 != null) {
            m2657c(i13, i17);
        }
    }

    /* renamed from: c */
    private void m2657c(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View b = m2669b(i3);
            if (b.getVisibility() != 8) {
                C0762a c0762a = (C0762a) b.getLayoutParams();
                if (c0762a.width == -1) {
                    int i4 = c0762a.height;
                    c0762a.height = b.getMeasuredHeight();
                    measureChildWithMargins(b, makeMeasureSpec, 0, i2, 0);
                    c0762a.height = i4;
                }
            }
        }
    }

    /* renamed from: b */
    void m2670b(int i, int i2) {
        int[] iArr;
        int i3;
        boolean z;
        boolean z2;
        int baseline;
        int i4;
        int i5;
        int i6;
        View b;
        C0762a c0762a;
        int i7;
        int i8;
        float f;
        View b2;
        float f2;
        float f3;
        int i9;
        float f4;
        Object obj;
        Object obj2;
        int i10 = i;
        int i11 = i2;
        this.f2034f = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        if (this.f2037i == null || r7.f2038j == null) {
            r7.f2037i = new int[4];
            r7.f2038j = new int[4];
        }
        int[] iArr2 = r7.f2037i;
        int[] iArr3 = r7.f2038j;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        iArr3[3] = -1;
        iArr3[2] = -1;
        iArr3[1] = -1;
        iArr3[0] = -1;
        boolean z3 = r7.f2029a;
        boolean z4 = r7.f2036h;
        int i12 = 1073741824;
        Object obj3 = mode == 1073741824 ? 1 : null;
        float f5 = 0.0f;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        Object obj4 = null;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        Object obj5 = 1;
        Object obj6 = null;
        while (true) {
            iArr = iArr3;
            if (i13 >= virtualChildCount) {
                break;
            }
            View view;
            int measuredHeight;
            int combineMeasuredStates;
            View b3 = m2669b(i13);
            if (b3 == null) {
                r7.f2034f += m2675d(i13);
            } else if (b3.getVisibility() == 8) {
                i13 += m2660a(b3, i13);
            } else {
                int i19;
                Object obj7;
                Object obj8;
                if (m2674c(i13)) {
                    r7.f2034f += r7.f2040l;
                }
                C0762a c0762a2 = (C0762a) b3.getLayoutParams();
                float f6 = f5 + c0762a2.f2027g;
                if (mode == i12 && c0762a2.width == 0 && c0762a2.f2027g > 0.0f) {
                    if (obj3 != null) {
                        r7.f2034f += c0762a2.leftMargin + c0762a2.rightMargin;
                    } else {
                        i3 = r7.f2034f;
                        r7.f2034f = Math.max(i3, (c0762a2.leftMargin + i3) + c0762a2.rightMargin);
                    }
                    if (z3) {
                        i12 = MeasureSpec.makeMeasureSpec(0, 0);
                        b3.measure(i12, i12);
                        i19 = i13;
                        z = z4;
                        z2 = z3;
                        view = b3;
                    } else {
                        i19 = i13;
                        z = z4;
                        z2 = z3;
                        view = b3;
                        i13 = 1073741824;
                        obj4 = 1;
                        if (mode2 == i13 && c0762a2.height == -1) {
                            obj7 = 1;
                            obj6 = 1;
                        } else {
                            obj7 = null;
                        }
                        i12 = c0762a2.topMargin + c0762a2.bottomMargin;
                        measuredHeight = view.getMeasuredHeight() + i12;
                        combineMeasuredStates = View.combineMeasuredStates(i18, view.getMeasuredState());
                        if (z2) {
                            baseline = view.getBaseline();
                            if (baseline != -1) {
                                i11 = ((((c0762a2.f2028h >= 0 ? r7.f2033e : c0762a2.f2028h) & 112) >> 4) & -2) >> 1;
                                iArr2[i11] = Math.max(iArr2[i11], baseline);
                                iArr[i11] = Math.max(iArr[i11], measuredHeight - baseline);
                            }
                        }
                        i13 = Math.max(i15, measuredHeight);
                        obj8 = (obj5 == null && c0762a2.height == -1) ? 1 : null;
                        if (c0762a2.f2027g <= 0.0f) {
                            if (obj7 == null) {
                                i12 = measuredHeight;
                            }
                            i17 = Math.max(i17, i12);
                        } else {
                            i4 = i17;
                            if (obj7 != null) {
                                measuredHeight = i12;
                            }
                            i16 = Math.max(i16, measuredHeight);
                            i17 = i4;
                        }
                        i4 = i19;
                        i15 = i13;
                        i18 = combineMeasuredStates;
                        obj5 = obj8;
                        i13 = m2660a(view, i4) + i4;
                        f5 = f6;
                        i13++;
                        iArr3 = iArr;
                        z4 = z;
                        z3 = z2;
                        i12 = 1073741824;
                        i11 = i2;
                    }
                } else {
                    if (c0762a2.width != 0 || c0762a2.f2027g <= 0.0f) {
                        i12 = LinearLayoutManager.INVALID_OFFSET;
                    } else {
                        c0762a2.width = -2;
                        i12 = 0;
                    }
                    i19 = i13;
                    int i20 = i12;
                    z = z4;
                    z2 = z3;
                    View view2 = b3;
                    m2665a(b3, i19, i, f6 == 0.0f ? r7.f2034f : 0, i2, 0);
                    i3 = i20;
                    if (i3 != LinearLayoutManager.INVALID_OFFSET) {
                        c0762a2.width = i3;
                    }
                    i3 = view2.getMeasuredWidth();
                    if (obj3 != null) {
                        view = view2;
                        r7.f2034f += ((c0762a2.leftMargin + i3) + c0762a2.rightMargin) + m2666b(view);
                    } else {
                        view = view2;
                        i13 = r7.f2034f;
                        r7.f2034f = Math.max(i13, (((i13 + i3) + c0762a2.leftMargin) + c0762a2.rightMargin) + m2666b(view));
                    }
                    if (z) {
                        i14 = Math.max(i3, i14);
                    }
                }
                i13 = 1073741824;
                if (mode2 == i13) {
                }
                obj7 = null;
                i12 = c0762a2.topMargin + c0762a2.bottomMargin;
                measuredHeight = view.getMeasuredHeight() + i12;
                combineMeasuredStates = View.combineMeasuredStates(i18, view.getMeasuredState());
                if (z2) {
                    baseline = view.getBaseline();
                    if (baseline != -1) {
                        if (c0762a2.f2028h >= 0) {
                        }
                        i11 = ((((c0762a2.f2028h >= 0 ? r7.f2033e : c0762a2.f2028h) & 112) >> 4) & -2) >> 1;
                        iArr2[i11] = Math.max(iArr2[i11], baseline);
                        iArr[i11] = Math.max(iArr[i11], measuredHeight - baseline);
                    }
                }
                i13 = Math.max(i15, measuredHeight);
                if (obj5 == null) {
                }
                if (c0762a2.f2027g <= 0.0f) {
                    i4 = i17;
                    if (obj7 != null) {
                        measuredHeight = i12;
                    }
                    i16 = Math.max(i16, measuredHeight);
                    i17 = i4;
                } else {
                    if (obj7 == null) {
                        i12 = measuredHeight;
                    }
                    i17 = Math.max(i17, i12);
                }
                i4 = i19;
                i15 = i13;
                i18 = combineMeasuredStates;
                obj5 = obj8;
                i13 = m2660a(view, i4) + i4;
                f5 = f6;
                i13++;
                iArr3 = iArr;
                z4 = z;
                z3 = z2;
                i12 = 1073741824;
                i11 = i2;
            }
            z = z4;
            z2 = z3;
            i13++;
            iArr3 = iArr;
            z4 = z;
            z3 = z2;
            i12 = 1073741824;
            i11 = i2;
        }
        z = z4;
        z2 = z3;
        i13 = i15;
        i12 = i16;
        i4 = i17;
        baseline = i18;
        if (r7.f2034f > 0 && m2674c(virtualChildCount)) {
            r7.f2034f += r7.f2040l;
        }
        if (iArr2[1] == -1 && iArr2[0] == -1 && iArr2[2] == -1) {
            if (iArr2[3] == -1) {
                i5 = baseline;
                if (z && (mode == LinearLayoutManager.INVALID_OFFSET || mode == 0)) {
                    r7.f2034f = 0;
                    i6 = 0;
                    while (i6 < virtualChildCount) {
                        b = m2669b(i6);
                        if (b == null) {
                            r7.f2034f += m2675d(i6);
                        } else if (b.getVisibility() != 8) {
                            i6 += m2660a(b, i6);
                        } else {
                            c0762a = (C0762a) b.getLayoutParams();
                            if (obj3 == null) {
                                r7.f2034f += ((c0762a.leftMargin + i14) + c0762a.rightMargin) + m2666b(b);
                            } else {
                                baseline = r7.f2034f;
                                i7 = i13;
                                r7.f2034f = Math.max(baseline, (((baseline + i14) + c0762a.leftMargin) + c0762a.rightMargin) + m2666b(b));
                                i6++;
                                i13 = i7;
                            }
                        }
                        i7 = i13;
                        i6++;
                        i13 = i7;
                    }
                }
                i7 = i13;
                r7.f2034f += getPaddingLeft() + getPaddingRight();
                i13 = View.resolveSizeAndState(Math.max(r7.f2034f, getSuggestedMinimumWidth()), i10, 0);
                i6 = (16777215 & i13) - r7.f2034f;
                if (obj4 == null) {
                    if (i6 != 0 || f5 <= 0.0f) {
                        i3 = Math.max(i12, i4);
                        if (z && mode != 1073741824) {
                            for (i12 = 0; i12 < virtualChildCount; i12++) {
                                view = m2669b(i12);
                                if (view == null) {
                                    if (view.getVisibility() == 8) {
                                        if (((C0762a) view.getLayoutParams()).f2027g > 0.0f) {
                                            view.measure(MeasureSpec.makeMeasureSpec(i14, 1073741824), MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 1073741824));
                                        }
                                    }
                                }
                            }
                        }
                        i8 = virtualChildCount;
                        i6 = i2;
                        if (obj5 == null && mode2 != 1073741824) {
                            i7 = i3;
                        }
                        setMeasuredDimension(i13 | (i5 & -16777216), View.resolveSizeAndState(Math.max(i7 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i6, i5 << 16));
                        if (obj6 != null) {
                            m2658d(i8, i);
                        }
                    }
                }
                if (r7.f2035g > 0.0f) {
                    f5 = r7.f2035g;
                }
                iArr2[3] = -1;
                iArr2[2] = -1;
                iArr2[1] = -1;
                iArr2[0] = -1;
                iArr[3] = -1;
                iArr[2] = -1;
                iArr[1] = -1;
                iArr[0] = -1;
                r7.f2034f = 0;
                i4 = i12;
                i11 = i5;
                baseline = -1;
                f = f5;
                i3 = 0;
                while (i3 < virtualChildCount) {
                    b2 = m2669b(i3);
                    if (b2 != null) {
                        if (b2.getVisibility() == 8) {
                            c0762a = (C0762a) b2.getLayoutParams();
                            f2 = c0762a.f2027g;
                            if (f2 <= 0.0f) {
                                i10 = (int) ((((float) i6) * f2) / f);
                                f3 = f - f2;
                                i9 = i6 - i10;
                                i8 = virtualChildCount;
                                i12 = getChildMeasureSpec(i2, ((getPaddingTop() + getPaddingBottom()) + c0762a.topMargin) + c0762a.bottomMargin, c0762a.height);
                                if (c0762a.width != 0) {
                                    measuredHeight = 1073741824;
                                    if (mode != 1073741824) {
                                        if (i10 > 0) {
                                            i10 = 0;
                                        }
                                        b2.measure(MeasureSpec.makeMeasureSpec(i10, 1073741824), i12);
                                        i11 = View.combineMeasuredStates(i11, b2.getMeasuredState() & -16777216);
                                        f = f3;
                                        measuredHeight = i9;
                                    }
                                } else {
                                    measuredHeight = 1073741824;
                                }
                                i10 = b2.getMeasuredWidth() + i10;
                                if (i10 < 0) {
                                    i10 = 0;
                                }
                                b2.measure(MeasureSpec.makeMeasureSpec(i10, measuredHeight), i12);
                                i11 = View.combineMeasuredStates(i11, b2.getMeasuredState() & -16777216);
                                f = f3;
                                measuredHeight = i9;
                            } else {
                                measuredHeight = i6;
                                i8 = virtualChildCount;
                                i6 = i2;
                            }
                            if (obj3 == null) {
                                r7.f2034f += ((b2.getMeasuredWidth() + c0762a.leftMargin) + c0762a.rightMargin) + m2666b(b2);
                                f4 = f;
                            } else {
                                i10 = r7.f2034f;
                                f4 = f;
                                r7.f2034f = Math.max(i10, (((b2.getMeasuredWidth() + i10) + c0762a.leftMargin) + c0762a.rightMargin) + m2666b(b2));
                            }
                            obj = (mode2 == 1073741824 && c0762a.height == -1) ? 1 : null;
                            i10 = c0762a.topMargin + c0762a.bottomMargin;
                            virtualChildCount = b2.getMeasuredHeight() + i10;
                            baseline = Math.max(baseline, virtualChildCount);
                            if (obj != null) {
                                i10 = virtualChildCount;
                            }
                            i12 = Math.max(i4, i10);
                            if (obj5 == null) {
                                i4 = -1;
                                if (c0762a.height == -1) {
                                    obj2 = 1;
                                    if (z2) {
                                        i14 = b2.getBaseline();
                                        if (i14 != i4) {
                                            combineMeasuredStates = ((((c0762a.f2028h >= 0 ? r7.f2033e : c0762a.f2028h) & 112) >> 4) & -2) >> 1;
                                            iArr2[combineMeasuredStates] = Math.max(iArr2[combineMeasuredStates], i14);
                                            iArr[combineMeasuredStates] = Math.max(iArr[combineMeasuredStates], virtualChildCount - i14);
                                            i4 = i12;
                                            obj5 = obj2;
                                            f = f4;
                                            i3++;
                                            i6 = measuredHeight;
                                            virtualChildCount = i8;
                                            i10 = i;
                                        }
                                    }
                                    i4 = i12;
                                    obj5 = obj2;
                                    f = f4;
                                    i3++;
                                    i6 = measuredHeight;
                                    virtualChildCount = i8;
                                    i10 = i;
                                }
                            } else {
                                i4 = -1;
                            }
                            obj2 = null;
                            if (z2) {
                                i14 = b2.getBaseline();
                                if (i14 != i4) {
                                    if (c0762a.f2028h >= 0) {
                                    }
                                    combineMeasuredStates = ((((c0762a.f2028h >= 0 ? r7.f2033e : c0762a.f2028h) & 112) >> 4) & -2) >> 1;
                                    iArr2[combineMeasuredStates] = Math.max(iArr2[combineMeasuredStates], i14);
                                    iArr[combineMeasuredStates] = Math.max(iArr[combineMeasuredStates], virtualChildCount - i14);
                                    i4 = i12;
                                    obj5 = obj2;
                                    f = f4;
                                    i3++;
                                    i6 = measuredHeight;
                                    virtualChildCount = i8;
                                    i10 = i;
                                }
                            }
                            i4 = i12;
                            obj5 = obj2;
                            f = f4;
                            i3++;
                            i6 = measuredHeight;
                            virtualChildCount = i8;
                            i10 = i;
                        }
                    }
                    measuredHeight = i6;
                    i8 = virtualChildCount;
                    i6 = i2;
                    i3++;
                    i6 = measuredHeight;
                    virtualChildCount = i8;
                    i10 = i;
                }
                i8 = virtualChildCount;
                i6 = i2;
                r7.f2034f += getPaddingLeft() + getPaddingRight();
                if (iArr2[1] == -1 && iArr2[0] == -1 && iArr2[2] == -1) {
                    if (iArr2[3] != -1) {
                        i3 = baseline;
                        i7 = i3;
                        i5 = i11;
                        i3 = i4;
                        i7 = i3;
                        setMeasuredDimension(i13 | (i5 & -16777216), View.resolveSizeAndState(Math.max(i7 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i6, i5 << 16));
                        if (obj6 != null) {
                            m2658d(i8, i);
                        }
                    }
                }
                i3 = Math.max(baseline, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
                i7 = i3;
                i5 = i11;
                i3 = i4;
                i7 = i3;
                setMeasuredDimension(i13 | (i5 & -16777216), View.resolveSizeAndState(Math.max(i7 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i6, i5 << 16));
                if (obj6 != null) {
                    m2658d(i8, i);
                }
            }
        }
        i5 = baseline;
        i13 = Math.max(i13, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
        r7.f2034f = 0;
        i6 = 0;
        while (i6 < virtualChildCount) {
            b = m2669b(i6);
            if (b == null) {
                r7.f2034f += m2675d(i6);
            } else if (b.getVisibility() != 8) {
                c0762a = (C0762a) b.getLayoutParams();
                if (obj3 == null) {
                    baseline = r7.f2034f;
                    i7 = i13;
                    r7.f2034f = Math.max(baseline, (((baseline + i14) + c0762a.leftMargin) + c0762a.rightMargin) + m2666b(b));
                    i6++;
                    i13 = i7;
                } else {
                    r7.f2034f += ((c0762a.leftMargin + i14) + c0762a.rightMargin) + m2666b(b);
                }
            } else {
                i6 += m2660a(b, i6);
            }
            i7 = i13;
            i6++;
            i13 = i7;
        }
        i7 = i13;
        r7.f2034f += getPaddingLeft() + getPaddingRight();
        i13 = View.resolveSizeAndState(Math.max(r7.f2034f, getSuggestedMinimumWidth()), i10, 0);
        i6 = (16777215 & i13) - r7.f2034f;
        if (obj4 == null) {
            if (i6 != 0) {
            }
            i3 = Math.max(i12, i4);
            for (i12 = 0; i12 < virtualChildCount; i12++) {
                view = m2669b(i12);
                if (view == null) {
                    if (view.getVisibility() == 8) {
                        if (((C0762a) view.getLayoutParams()).f2027g > 0.0f) {
                            view.measure(MeasureSpec.makeMeasureSpec(i14, 1073741824), MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 1073741824));
                        }
                    }
                }
            }
            i8 = virtualChildCount;
            i6 = i2;
            i7 = i3;
            setMeasuredDimension(i13 | (i5 & -16777216), View.resolveSizeAndState(Math.max(i7 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i6, i5 << 16));
            if (obj6 != null) {
                m2658d(i8, i);
            }
        }
        if (r7.f2035g > 0.0f) {
            f5 = r7.f2035g;
        }
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        r7.f2034f = 0;
        i4 = i12;
        i11 = i5;
        baseline = -1;
        f = f5;
        i3 = 0;
        while (i3 < virtualChildCount) {
            b2 = m2669b(i3);
            if (b2 != null) {
                if (b2.getVisibility() == 8) {
                    c0762a = (C0762a) b2.getLayoutParams();
                    f2 = c0762a.f2027g;
                    if (f2 <= 0.0f) {
                        measuredHeight = i6;
                        i8 = virtualChildCount;
                        i6 = i2;
                    } else {
                        i10 = (int) ((((float) i6) * f2) / f);
                        f3 = f - f2;
                        i9 = i6 - i10;
                        i8 = virtualChildCount;
                        i12 = getChildMeasureSpec(i2, ((getPaddingTop() + getPaddingBottom()) + c0762a.topMargin) + c0762a.bottomMargin, c0762a.height);
                        if (c0762a.width != 0) {
                            measuredHeight = 1073741824;
                        } else {
                            measuredHeight = 1073741824;
                            if (mode != 1073741824) {
                                if (i10 > 0) {
                                    i10 = 0;
                                }
                                b2.measure(MeasureSpec.makeMeasureSpec(i10, 1073741824), i12);
                                i11 = View.combineMeasuredStates(i11, b2.getMeasuredState() & -16777216);
                                f = f3;
                                measuredHeight = i9;
                            }
                        }
                        i10 = b2.getMeasuredWidth() + i10;
                        if (i10 < 0) {
                            i10 = 0;
                        }
                        b2.measure(MeasureSpec.makeMeasureSpec(i10, measuredHeight), i12);
                        i11 = View.combineMeasuredStates(i11, b2.getMeasuredState() & -16777216);
                        f = f3;
                        measuredHeight = i9;
                    }
                    if (obj3 == null) {
                        i10 = r7.f2034f;
                        f4 = f;
                        r7.f2034f = Math.max(i10, (((b2.getMeasuredWidth() + i10) + c0762a.leftMargin) + c0762a.rightMargin) + m2666b(b2));
                    } else {
                        r7.f2034f += ((b2.getMeasuredWidth() + c0762a.leftMargin) + c0762a.rightMargin) + m2666b(b2);
                        f4 = f;
                    }
                    if (mode2 == 1073741824) {
                    }
                    i10 = c0762a.topMargin + c0762a.bottomMargin;
                    virtualChildCount = b2.getMeasuredHeight() + i10;
                    baseline = Math.max(baseline, virtualChildCount);
                    if (obj != null) {
                        i10 = virtualChildCount;
                    }
                    i12 = Math.max(i4, i10);
                    if (obj5 == null) {
                        i4 = -1;
                    } else {
                        i4 = -1;
                        if (c0762a.height == -1) {
                            obj2 = 1;
                            if (z2) {
                                i14 = b2.getBaseline();
                                if (i14 != i4) {
                                    if (c0762a.f2028h >= 0) {
                                    }
                                    combineMeasuredStates = ((((c0762a.f2028h >= 0 ? r7.f2033e : c0762a.f2028h) & 112) >> 4) & -2) >> 1;
                                    iArr2[combineMeasuredStates] = Math.max(iArr2[combineMeasuredStates], i14);
                                    iArr[combineMeasuredStates] = Math.max(iArr[combineMeasuredStates], virtualChildCount - i14);
                                    i4 = i12;
                                    obj5 = obj2;
                                    f = f4;
                                    i3++;
                                    i6 = measuredHeight;
                                    virtualChildCount = i8;
                                    i10 = i;
                                }
                            }
                            i4 = i12;
                            obj5 = obj2;
                            f = f4;
                            i3++;
                            i6 = measuredHeight;
                            virtualChildCount = i8;
                            i10 = i;
                        }
                    }
                    obj2 = null;
                    if (z2) {
                        i14 = b2.getBaseline();
                        if (i14 != i4) {
                            if (c0762a.f2028h >= 0) {
                            }
                            combineMeasuredStates = ((((c0762a.f2028h >= 0 ? r7.f2033e : c0762a.f2028h) & 112) >> 4) & -2) >> 1;
                            iArr2[combineMeasuredStates] = Math.max(iArr2[combineMeasuredStates], i14);
                            iArr[combineMeasuredStates] = Math.max(iArr[combineMeasuredStates], virtualChildCount - i14);
                            i4 = i12;
                            obj5 = obj2;
                            f = f4;
                            i3++;
                            i6 = measuredHeight;
                            virtualChildCount = i8;
                            i10 = i;
                        }
                    }
                    i4 = i12;
                    obj5 = obj2;
                    f = f4;
                    i3++;
                    i6 = measuredHeight;
                    virtualChildCount = i8;
                    i10 = i;
                }
            }
            measuredHeight = i6;
            i8 = virtualChildCount;
            i6 = i2;
            i3++;
            i6 = measuredHeight;
            virtualChildCount = i8;
            i10 = i;
        }
        i8 = virtualChildCount;
        i6 = i2;
        r7.f2034f += getPaddingLeft() + getPaddingRight();
        if (iArr2[3] != -1) {
            i3 = baseline;
            i7 = i3;
            i5 = i11;
            i3 = i4;
            i7 = i3;
            setMeasuredDimension(i13 | (i5 & -16777216), View.resolveSizeAndState(Math.max(i7 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i6, i5 << 16));
            if (obj6 != null) {
                m2658d(i8, i);
            }
        }
        i3 = Math.max(baseline, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
        i7 = i3;
        i5 = i11;
        i3 = i4;
        i7 = i3;
        setMeasuredDimension(i13 | (i5 & -16777216), View.resolveSizeAndState(Math.max(i7 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i6, i5 << 16));
        if (obj6 != null) {
            m2658d(i8, i);
        }
    }

    /* renamed from: d */
    private void m2658d(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View b = m2669b(i3);
            if (b.getVisibility() != 8) {
                C0762a c0762a = (C0762a) b.getLayoutParams();
                if (c0762a.height == -1) {
                    int i4 = c0762a.width;
                    c0762a.width = b.getMeasuredWidth();
                    measureChildWithMargins(b, i2, 0, makeMeasureSpec, 0);
                    c0762a.width = i4;
                }
            }
        }
    }

    /* renamed from: a */
    void m2665a(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f2032d) {
            m2662a(i, i2, i3, i4);
        } else {
            m2671b(i, i2, i3, i4);
        }
    }

    /* renamed from: a */
    void m2662a(int i, int i2, int i3, int i4) {
        int paddingTop;
        int paddingLeft = getPaddingLeft();
        int i5 = i3 - i;
        int paddingRight = i5 - getPaddingRight();
        int paddingRight2 = (i5 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        i5 = this.f2033e & 112;
        int i6 = this.f2033e & 8388615;
        if (i5 == 16) {
            paddingTop = (((i4 - i2) - r6.f2034f) / 2) + getPaddingTop();
        } else if (i5 != 80) {
            paddingTop = getPaddingTop();
        } else {
            paddingTop = ((getPaddingTop() + i4) - i2) - r6.f2034f;
        }
        int i7 = 0;
        while (i7 < virtualChildCount) {
            View b = m2669b(i7);
            if (b == null) {
                paddingTop += m2675d(i7);
            } else if (b.getVisibility() != 8) {
                int measuredWidth = b.getMeasuredWidth();
                int measuredHeight = b.getMeasuredHeight();
                C0762a c0762a = (C0762a) b.getLayoutParams();
                int i8 = c0762a.f2028h;
                if (i8 < 0) {
                    i8 = i6;
                }
                i8 = C0501e.m1587a(i8, C0517s.m1711e(this)) & 7;
                if (i8 == 1) {
                    i8 = ((((paddingRight2 - measuredWidth) / 2) + paddingLeft) + c0762a.leftMargin) - c0762a.rightMargin;
                } else if (i8 != 5) {
                    i8 = c0762a.leftMargin + paddingLeft;
                } else {
                    i8 = (paddingRight - measuredWidth) - c0762a.rightMargin;
                }
                i5 = i8;
                if (m2674c(i7)) {
                    paddingTop += r6.f2041m;
                }
                int i9 = paddingTop + c0762a.topMargin;
                C0762a c0762a2 = c0762a;
                m2656a(b, i5, i9 + m2659a(b), measuredWidth, measuredHeight);
                i7 += m2660a(b, i7);
                paddingTop = i9 + ((measuredHeight + c0762a2.bottomMargin) + m2666b(b));
            }
            i7++;
        }
    }

    /* renamed from: b */
    void m2671b(int i, int i2, int i3, int i4) {
        int paddingLeft;
        int i5;
        int i6;
        boolean a = by.m2841a(this);
        int paddingTop = getPaddingTop();
        int i7 = i4 - i2;
        int paddingBottom = i7 - getPaddingBottom();
        int paddingBottom2 = (i7 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        i7 = this.f2033e & 8388615;
        int i8 = this.f2033e & 112;
        boolean z = this.f2029a;
        int[] iArr = this.f2037i;
        int[] iArr2 = this.f2038j;
        i7 = C0501e.m1587a(i7, C0517s.m1711e(this));
        if (i7 == 1) {
            paddingLeft = (((i3 - i) - r6.f2034f) / 2) + getPaddingLeft();
        } else if (i7 != 5) {
            paddingLeft = getPaddingLeft();
        } else {
            paddingLeft = ((getPaddingLeft() + i3) - i) - r6.f2034f;
        }
        if (a) {
            i5 = virtualChildCount - 1;
            i6 = -1;
        } else {
            i5 = 0;
            i6 = 1;
        }
        i7 = 0;
        while (i7 < virtualChildCount) {
            int i9;
            int i10;
            int i11;
            int i12 = i5 + (i6 * i7);
            View b = m2669b(i12);
            if (b == null) {
                paddingLeft += m2675d(i12);
            } else if (b.getVisibility() != 8) {
                int i13;
                View view;
                C0762a c0762a;
                View view2;
                int measuredWidth = b.getMeasuredWidth();
                int measuredHeight = b.getMeasuredHeight();
                C0762a c0762a2 = (C0762a) b.getLayoutParams();
                if (z) {
                    i13 = i7;
                    i9 = virtualChildCount;
                    if (c0762a2.height != -1) {
                        i7 = b.getBaseline();
                        virtualChildCount = c0762a2.f2028h;
                        if (virtualChildCount < 0) {
                            virtualChildCount = i8;
                        }
                        virtualChildCount &= 112;
                        i10 = i8;
                        if (virtualChildCount != 16) {
                            i7 = ((((paddingBottom2 - measuredHeight) / 2) + paddingTop) + c0762a2.topMargin) - c0762a2.bottomMargin;
                        } else if (virtualChildCount != 48) {
                            virtualChildCount = c0762a2.topMargin + paddingTop;
                            if (i7 != -1) {
                                virtualChildCount += iArr[1] - i7;
                            }
                            i7 = virtualChildCount;
                        } else if (virtualChildCount == 80) {
                            i7 = paddingTop;
                        } else {
                            virtualChildCount = (paddingBottom - measuredHeight) - c0762a2.bottomMargin;
                            if (i7 != -1) {
                                virtualChildCount -= iArr2[2] - (b.getMeasuredHeight() - i7);
                            }
                            i7 = virtualChildCount;
                        }
                        if (m2674c(i12)) {
                            paddingLeft += r6.f2040l;
                        }
                        virtualChildCount = c0762a2.leftMargin + paddingLeft;
                        view = b;
                        i8 = i12;
                        i12 = virtualChildCount + m2659a(b);
                        r19 = i13;
                        i11 = paddingTop;
                        c0762a = c0762a2;
                        m2656a(b, i12, i7, measuredWidth, measuredHeight);
                        view2 = view;
                        i7 = r19 + m2660a(view2, i8);
                        paddingLeft = virtualChildCount + ((measuredWidth + c0762a.rightMargin) + m2666b(view2));
                        i7++;
                        virtualChildCount = i9;
                        i8 = i10;
                        paddingTop = i11;
                    }
                } else {
                    i13 = i7;
                    i9 = virtualChildCount;
                }
                i7 = -1;
                virtualChildCount = c0762a2.f2028h;
                if (virtualChildCount < 0) {
                    virtualChildCount = i8;
                }
                virtualChildCount &= 112;
                i10 = i8;
                if (virtualChildCount != 16) {
                    i7 = ((((paddingBottom2 - measuredHeight) / 2) + paddingTop) + c0762a2.topMargin) - c0762a2.bottomMargin;
                } else if (virtualChildCount != 48) {
                    virtualChildCount = c0762a2.topMargin + paddingTop;
                    if (i7 != -1) {
                        virtualChildCount += iArr[1] - i7;
                    }
                    i7 = virtualChildCount;
                } else if (virtualChildCount == 80) {
                    virtualChildCount = (paddingBottom - measuredHeight) - c0762a2.bottomMargin;
                    if (i7 != -1) {
                        virtualChildCount -= iArr2[2] - (b.getMeasuredHeight() - i7);
                    }
                    i7 = virtualChildCount;
                } else {
                    i7 = paddingTop;
                }
                if (m2674c(i12)) {
                    paddingLeft += r6.f2040l;
                }
                virtualChildCount = c0762a2.leftMargin + paddingLeft;
                view = b;
                i8 = i12;
                i12 = virtualChildCount + m2659a(b);
                r19 = i13;
                i11 = paddingTop;
                c0762a = c0762a2;
                m2656a(b, i12, i7, measuredWidth, measuredHeight);
                view2 = view;
                i7 = r19 + m2660a(view2, i8);
                paddingLeft = virtualChildCount + ((measuredWidth + c0762a.rightMargin) + m2666b(view2));
                i7++;
                virtualChildCount = i9;
                i8 = i10;
                paddingTop = i11;
            } else {
                r19 = i7;
            }
            i11 = paddingTop;
            i9 = virtualChildCount;
            i10 = i8;
            i7++;
            virtualChildCount = i9;
            i8 = i10;
            paddingTop = i11;
        }
    }

    /* renamed from: a */
    private void m2656a(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }

    public void setOrientation(int i) {
        if (this.f2032d != i) {
            this.f2032d = i;
            requestLayout();
        }
    }

    public int getOrientation() {
        return this.f2032d;
    }

    public void setGravity(int i) {
        if (this.f2033e != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.f2033e = i;
            requestLayout();
        }
    }

    public int getGravity() {
        return this.f2033e;
    }

    public void setHorizontalGravity(int i) {
        i &= 8388615;
        if ((8388615 & this.f2033e) != i) {
            this.f2033e = i | (this.f2033e & -8388616);
            requestLayout();
        }
    }

    public void setVerticalGravity(int i) {
        i &= 112;
        if ((this.f2033e & 112) != i) {
            this.f2033e = i | (this.f2033e & -113);
            requestLayout();
        }
    }

    /* renamed from: b */
    public C0762a mo499b(AttributeSet attributeSet) {
        return new C0762a(getContext(), attributeSet);
    }

    /* renamed from: j */
    protected C0762a mo505j() {
        if (this.f2032d == 0) {
            return new C0762a(-2, -2);
        }
        return this.f2032d == 1 ? new C0762a(-1, -2) : null;
    }

    /* renamed from: b */
    protected C0762a mo500b(LayoutParams layoutParams) {
        return new C0762a(layoutParams);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof C0762a;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(as.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(as.class.getName());
    }
}
