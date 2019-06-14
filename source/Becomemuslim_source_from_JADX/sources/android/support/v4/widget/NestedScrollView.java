package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.C0494b;
import android.support.v4.view.C0509l;
import android.support.v4.view.C0510m;
import android.support.v4.view.C0511o;
import android.support.v4.view.C0517s;
import android.support.v4.view.C3226k;
import android.support.v4.view.p033a.C0483b;
import android.support.v4.view.p033a.C0486d;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.Utility;
import java.util.List;

public class NestedScrollView extends FrameLayout implements C3226k, C0510m {
    /* renamed from: w */
    private static final C3233a f11915w = new C3233a();
    /* renamed from: x */
    private static final int[] f11916x = new int[]{16843130};
    /* renamed from: A */
    private float f11917A;
    /* renamed from: B */
    private C0528b f11918B;
    /* renamed from: a */
    private long f11919a;
    /* renamed from: b */
    private final Rect f11920b;
    /* renamed from: c */
    private OverScroller f11921c;
    /* renamed from: d */
    private EdgeEffect f11922d;
    /* renamed from: e */
    private EdgeEffect f11923e;
    /* renamed from: f */
    private int f11924f;
    /* renamed from: g */
    private boolean f11925g;
    /* renamed from: h */
    private boolean f11926h;
    /* renamed from: i */
    private View f11927i;
    /* renamed from: j */
    private boolean f11928j;
    /* renamed from: k */
    private VelocityTracker f11929k;
    /* renamed from: l */
    private boolean f11930l;
    /* renamed from: m */
    private boolean f11931m;
    /* renamed from: n */
    private int f11932n;
    /* renamed from: o */
    private int f11933o;
    /* renamed from: p */
    private int f11934p;
    /* renamed from: q */
    private int f11935q;
    /* renamed from: r */
    private final int[] f11936r;
    /* renamed from: s */
    private final int[] f11937s;
    /* renamed from: t */
    private int f11938t;
    /* renamed from: u */
    private int f11939u;
    /* renamed from: v */
    private C0530c f11940v;
    /* renamed from: y */
    private final C0511o f11941y;
    /* renamed from: z */
    private final C0509l f11942z;

    /* renamed from: android.support.v4.widget.NestedScrollView$b */
    public interface C0528b {
        /* renamed from: a */
        void mo359a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4);
    }

    /* renamed from: android.support.v4.widget.NestedScrollView$c */
    static class C0530c extends BaseSavedState {
        public static final Creator<C0530c> CREATOR = new C05291();
        /* renamed from: a */
        public int f1308a;

        /* renamed from: android.support.v4.widget.NestedScrollView$c$1 */
        static class C05291 implements Creator<C0530c> {
            C05291() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m1768a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m1769a(i);
            }

            /* renamed from: a */
            public C0530c m1768a(Parcel parcel) {
                return new C0530c(parcel);
            }

            /* renamed from: a */
            public C0530c[] m1769a(int i) {
                return new C0530c[i];
            }
        }

        C0530c(Parcelable parcelable) {
            super(parcelable);
        }

        C0530c(Parcel parcel) {
            super(parcel);
            this.f1308a = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1308a);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("HorizontalScrollView.SavedState{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" scrollPosition=");
            stringBuilder.append(this.f1308a);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    /* renamed from: android.support.v4.widget.NestedScrollView$a */
    static class C3233a extends C0494b {
        C3233a() {
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle) != null) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (nestedScrollView.isEnabled() == null) {
                return false;
            }
            if (i == 4096) {
                i = Math.min(nestedScrollView.getScrollY() + ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
                if (i == nestedScrollView.getScrollY()) {
                    return false;
                }
                nestedScrollView.m14972c(0, i);
                return true;
            } else if (i != Utility.DEFAULT_STREAM_BUFFER_SIZE) {
                return false;
            } else {
                i = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                if (i == nestedScrollView.getScrollY()) {
                    return false;
                }
                nestedScrollView.m14972c(0, i);
                return true;
            }
        }

        public void onInitializeAccessibilityNodeInfo(View view, C0483b c0483b) {
            super.onInitializeAccessibilityNodeInfo(view, c0483b);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            c0483b.m1512b(ScrollView.class.getName());
            if (nestedScrollView.isEnabled()) {
                int scrollRange = nestedScrollView.getScrollRange();
                if (scrollRange > 0) {
                    c0483b.m1539k(true);
                    if (nestedScrollView.getScrollY() > 0) {
                        c0483b.m1502a((int) Utility.DEFAULT_STREAM_BUFFER_SIZE);
                    }
                    if (nestedScrollView.getScrollY() < scrollRange) {
                        c0483b.m1502a(4096);
                    }
                }
            }
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            C0486d.m1556a(accessibilityEvent, nestedScrollView.getScrollX());
            C0486d.m1557b(accessibilityEvent, nestedScrollView.getScrollRange());
        }
    }

    /* renamed from: b */
    private static int m14952b(int i, int i2, int i3) {
        if (i2 < i3) {
            if (i >= 0) {
                return i2 + i > i3 ? i3 - i2 : i;
            }
        }
        return 0;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11920b = new Rect();
        this.f11925g = true;
        this.f11926h = false;
        this.f11927i = null;
        this.f11928j = false;
        this.f11931m = true;
        this.f11935q = -1;
        this.f11936r = new int[2];
        this.f11937s = new int[2];
        m14945a();
        context = context.obtainStyledAttributes(attributeSet, f11916x, i, 0);
        setFillViewport(context.getBoolean(0, false));
        context.recycle();
        this.f11941y = new C0511o(this);
        this.f11942z = new C0509l(this);
        setNestedScrollingEnabled(true);
        C0517s.m1695a((View) this, f11915w);
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f11942z.m1611a(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.f11942z.m1612a();
    }

    public boolean startNestedScroll(int i) {
        return this.f11942z.m1622b(i);
    }

    /* renamed from: a */
    public boolean m14965a(int i, int i2) {
        return this.f11942z.m1616a(i, i2);
    }

    public void stopNestedScroll() {
        this.f11942z.m1623c();
    }

    /* renamed from: a */
    public void m14964a(int i) {
        this.f11942z.m1624c(i);
    }

    public boolean hasNestedScrollingParent() {
        return this.f11942z.m1621b();
    }

    /* renamed from: b */
    public boolean m14971b(int i) {
        return this.f11942z.m1615a(i);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f11942z.m1617a(i, i2, i3, i4, iArr);
    }

    /* renamed from: a */
    public boolean m14967a(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return this.f11942z.m1618a(i, i2, i3, i4, iArr, i5);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f11942z.m1619a(i, i2, iArr, iArr2);
    }

    /* renamed from: a */
    public boolean m14968a(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return this.f11942z.m1620a(i, i2, iArr, iArr2, i3);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f11942z.m1614a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f11942z.m1613a(f, f2);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f11941y.m1628a(view, view2, i);
        startNestedScroll(2);
    }

    public void onStopNestedScroll(View view) {
        this.f11941y.m1626a(view);
        stopNestedScroll();
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        view = getScrollY();
        scrollBy(0, i4);
        int scrollY = getScrollY() - view;
        dispatchNestedScroll(0, scrollY, 0, i4 - scrollY, null);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        dispatchNestedPreScroll(i, i2, iArr, null);
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return null;
        }
        m14962h((int) f2);
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public int getNestedScrollAxes() {
        return this.f11941y.m1625a();
    }

    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        return scrollY < verticalFadingEdgeLength ? ((float) scrollY) / ((float) verticalFadingEdgeLength) : 1.0f;
    }

    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = (getChildAt(0).getBottom() - getScrollY()) - (getHeight() - getPaddingBottom());
        return bottom < verticalFadingEdgeLength ? ((float) bottom) / ((float) verticalFadingEdgeLength) : 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (((float) getHeight()) * 0.5f);
    }

    /* renamed from: a */
    private void m14945a() {
        this.f11921c = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f11932n = viewConfiguration.getScaledTouchSlop();
        this.f11933o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f11934p = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    public void addView(View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View view, int i) {
        if (getChildCount() <= 0) {
            super.addView(view, i);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View view, LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void setOnScrollChangeListener(C0528b c0528b) {
        this.f11918B = c0528b;
    }

    /* renamed from: b */
    private boolean m14954b() {
        boolean z = false;
        View childAt = getChildAt(0);
        if (childAt == null) {
            return false;
        }
        if (getHeight() < (childAt.getHeight() + getPaddingTop()) + getPaddingBottom()) {
            z = true;
        }
        return z;
    }

    public void setFillViewport(boolean z) {
        if (z != this.f11930l) {
            this.f11930l = z;
            requestLayout();
        }
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.f11931m = z;
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.f11918B != null) {
            this.f11918B.mo359a(this, i, i2, i3, i4);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f11930l && MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            i2 = getChildAt(0);
            int measuredHeight = getMeasuredHeight();
            if (i2.getMeasuredHeight() < measuredHeight) {
                i2.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), ((FrameLayout.LayoutParams) i2.getLayoutParams()).width), MeasureSpec.makeMeasureSpec((measuredHeight - getPaddingTop()) - getPaddingBottom(), 1073741824));
            }
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!super.dispatchKeyEvent(keyEvent)) {
            if (m14969a(keyEvent) == null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: a */
    public boolean m14969a(KeyEvent keyEvent) {
        this.f11920b.setEmpty();
        boolean z = false;
        int i = 130;
        if (m14954b()) {
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (keyCode != 62) {
                    switch (keyCode) {
                        case 19:
                            if (keyEvent.isAltPressed() != null) {
                                z = m14974d(33);
                                break;
                            }
                            z = m14975e(33);
                            break;
                        case 20:
                            if (keyEvent.isAltPressed() != null) {
                                z = m14974d(130);
                                break;
                            }
                            z = m14975e(130);
                            break;
                        default:
                            break;
                    }
                }
                if (keyEvent.isShiftPressed() != null) {
                    i = 33;
                }
                m14973c(i);
            }
            return z;
        } else if (!isFocused() || keyEvent.getKeyCode() == 4) {
            return false;
        } else {
            keyEvent = findFocus();
            if (keyEvent == this) {
                keyEvent = null;
            }
            Object findNextFocus = FocusFinder.getInstance().findNextFocus(this, keyEvent, 130);
            if (!(findNextFocus == null || findNextFocus == this || findNextFocus.requestFocus(130) == null)) {
                z = true;
            }
            return z;
        }
    }

    /* renamed from: d */
    private boolean m14957d(int i, int i2) {
        boolean z = false;
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        if (i2 >= childAt.getTop() - scrollY && i2 < childAt.getBottom() - scrollY && i >= childAt.getLeft() && i < childAt.getRight()) {
            z = true;
        }
        return z;
    }

    /* renamed from: c */
    private void m14955c() {
        if (this.f11929k == null) {
            this.f11929k = VelocityTracker.obtain();
        } else {
            this.f11929k.clear();
        }
    }

    /* renamed from: d */
    private void m14956d() {
        if (this.f11929k == null) {
            this.f11929k = VelocityTracker.obtain();
        }
    }

    /* renamed from: e */
    private void m14958e() {
        if (this.f11929k != null) {
            this.f11929k.recycle();
            this.f11929k = null;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            m14958e();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 2 && this.f11928j) {
            return true;
        }
        action &= JfifUtil.MARKER_FIRST_BYTE;
        if (action != 6) {
            switch (action) {
                case 0:
                    action = (int) motionEvent.getY();
                    if (!m14957d((int) motionEvent.getX(), action)) {
                        this.f11928j = false;
                        m14958e();
                        break;
                    }
                    this.f11924f = action;
                    this.f11935q = motionEvent.getPointerId(0);
                    m14955c();
                    this.f11929k.addMovement(motionEvent);
                    this.f11921c.computeScrollOffset();
                    this.f11928j = this.f11921c.isFinished() ^ 1;
                    m14965a(2, 0);
                    break;
                case 1:
                case 3:
                    this.f11928j = false;
                    this.f11935q = -1;
                    m14958e();
                    if (this.f11921c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) != null) {
                        C0517s.m1706c(this);
                    }
                    m14964a(0);
                    break;
                case 2:
                    action = this.f11935q;
                    if (action != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(action);
                        if (findPointerIndex != -1) {
                            action = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(action - this.f11924f) > this.f11932n && (2 & getNestedScrollAxes()) == 0) {
                                this.f11928j = true;
                                this.f11924f = action;
                                m14956d();
                                this.f11929k.addMovement(motionEvent);
                                this.f11938t = 0;
                                motionEvent = getParent();
                                if (motionEvent != null) {
                                    motionEvent.requestDisallowInterceptTouchEvent(true);
                                    break;
                                }
                            }
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Invalid pointerId=");
                        stringBuilder.append(action);
                        stringBuilder.append(" in onInterceptTouchEvent");
                        Log.e("NestedScrollView", stringBuilder.toString());
                        break;
                    }
                    break;
                    break;
                default:
                    break;
            }
        }
        m14946a(motionEvent);
        return this.f11928j;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        NestedScrollView nestedScrollView = this;
        MotionEvent motionEvent2 = motionEvent;
        m14956d();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            nestedScrollView.f11938t = 0;
        }
        obtain.offsetLocation(0.0f, (float) nestedScrollView.f11938t);
        ViewParent parent;
        switch (actionMasked) {
            case 0:
                if (getChildCount() != 0) {
                    boolean isFinished = nestedScrollView.f11921c.isFinished() ^ true;
                    nestedScrollView.f11928j = isFinished;
                    if (isFinished) {
                        parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (!nestedScrollView.f11921c.isFinished()) {
                        nestedScrollView.f11921c.abortAnimation();
                    }
                    nestedScrollView.f11924f = (int) motionEvent.getY();
                    nestedScrollView.f11935q = motionEvent2.getPointerId(0);
                    m14965a(2, 0);
                    break;
                }
                return false;
            case 1:
                VelocityTracker velocityTracker = nestedScrollView.f11929k;
                velocityTracker.computeCurrentVelocity(1000, (float) nestedScrollView.f11934p);
                actionMasked = (int) velocityTracker.getYVelocity(nestedScrollView.f11935q);
                if (Math.abs(actionMasked) > nestedScrollView.f11933o) {
                    m14962h(-actionMasked);
                } else if (nestedScrollView.f11921c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    C0517s.m1706c(this);
                }
                nestedScrollView.f11935q = -1;
                m14959f();
                break;
            case 2:
                int findPointerIndex = motionEvent2.findPointerIndex(nestedScrollView.f11935q);
                if (findPointerIndex != -1) {
                    int y = (int) motionEvent2.getY(findPointerIndex);
                    int i = nestedScrollView.f11924f - y;
                    if (m14968a(0, i, nestedScrollView.f11937s, nestedScrollView.f11936r, 0)) {
                        i -= nestedScrollView.f11937s[1];
                        obtain.offsetLocation(0.0f, (float) nestedScrollView.f11936r[1]);
                        nestedScrollView.f11938t += nestedScrollView.f11936r[1];
                    }
                    if (!nestedScrollView.f11928j && Math.abs(i) > nestedScrollView.f11932n) {
                        parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                        nestedScrollView.f11928j = true;
                        if (i > 0) {
                            i -= nestedScrollView.f11932n;
                        } else {
                            i += nestedScrollView.f11932n;
                        }
                    }
                    int i2 = i;
                    if (nestedScrollView.f11928j) {
                        Object obj;
                        int i3;
                        int i4;
                        int i5;
                        int scrollY;
                        nestedScrollView.f11924f = y - nestedScrollView.f11936r[1];
                        int scrollY2 = getScrollY();
                        i = getScrollRange();
                        actionMasked = getOverScrollMode();
                        if (actionMasked != 0) {
                            if (actionMasked != 1 || i <= 0) {
                                obj = null;
                                i3 = i;
                                i4 = i2;
                                i5 = findPointerIndex;
                                if (m14966a(0, i2, 0, getScrollY(), 0, i, 0, 0, true) && !m14971b(0)) {
                                    nestedScrollView.f11929k.clear();
                                }
                                scrollY = getScrollY() - scrollY2;
                                if (m14967a(0, scrollY, 0, i4 - scrollY, nestedScrollView.f11936r, 0)) {
                                    if (obj != null) {
                                        m14960g();
                                        actionMasked = scrollY2 + i4;
                                        if (actionMasked >= 0) {
                                            C0555j.m1880a(nestedScrollView.f11922d, ((float) i4) / ((float) getHeight()), motionEvent2.getX(i5) / ((float) getWidth()));
                                            if (!nestedScrollView.f11923e.isFinished()) {
                                                nestedScrollView.f11923e.onRelease();
                                            }
                                        } else {
                                            scrollY = i5;
                                            if (actionMasked > i3) {
                                                C0555j.m1880a(nestedScrollView.f11923e, ((float) i4) / ((float) getHeight()), 1.0f - (motionEvent2.getX(scrollY) / ((float) getWidth())));
                                                if (!nestedScrollView.f11922d.isFinished()) {
                                                    nestedScrollView.f11922d.onRelease();
                                                }
                                            }
                                        }
                                        if (!(nestedScrollView.f11922d == null || (nestedScrollView.f11922d.isFinished() && nestedScrollView.f11923e.isFinished()))) {
                                            C0517s.m1706c(this);
                                            break;
                                        }
                                    }
                                }
                                nestedScrollView.f11924f -= nestedScrollView.f11936r[1];
                                obtain.offsetLocation(0.0f, (float) nestedScrollView.f11936r[1]);
                                nestedScrollView.f11938t += nestedScrollView.f11936r[1];
                                break;
                            }
                        }
                        obj = 1;
                        i3 = i;
                        i4 = i2;
                        i5 = findPointerIndex;
                        nestedScrollView.f11929k.clear();
                        scrollY = getScrollY() - scrollY2;
                        if (m14967a(0, scrollY, 0, i4 - scrollY, nestedScrollView.f11936r, 0)) {
                            if (obj != null) {
                                m14960g();
                                actionMasked = scrollY2 + i4;
                                if (actionMasked >= 0) {
                                    scrollY = i5;
                                    if (actionMasked > i3) {
                                        C0555j.m1880a(nestedScrollView.f11923e, ((float) i4) / ((float) getHeight()), 1.0f - (motionEvent2.getX(scrollY) / ((float) getWidth())));
                                        if (nestedScrollView.f11922d.isFinished()) {
                                            nestedScrollView.f11922d.onRelease();
                                        }
                                    }
                                } else {
                                    C0555j.m1880a(nestedScrollView.f11922d, ((float) i4) / ((float) getHeight()), motionEvent2.getX(i5) / ((float) getWidth()));
                                    if (nestedScrollView.f11923e.isFinished()) {
                                        nestedScrollView.f11923e.onRelease();
                                    }
                                }
                                C0517s.m1706c(this);
                                break;
                            }
                        }
                        nestedScrollView.f11924f -= nestedScrollView.f11936r[1];
                        obtain.offsetLocation(0.0f, (float) nestedScrollView.f11936r[1]);
                        nestedScrollView.f11938t += nestedScrollView.f11936r[1];
                        break;
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid pointerId=");
                stringBuilder.append(nestedScrollView.f11935q);
                stringBuilder.append(" in onTouchEvent");
                Log.e("NestedScrollView", stringBuilder.toString());
                break;
                break;
            case 3:
                if (nestedScrollView.f11928j && getChildCount() > 0 && nestedScrollView.f11921c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    C0517s.m1706c(this);
                }
                nestedScrollView.f11935q = -1;
                m14959f();
                break;
            case 5:
                actionMasked = motionEvent.getActionIndex();
                nestedScrollView.f11924f = (int) motionEvent2.getY(actionMasked);
                nestedScrollView.f11935q = motionEvent2.getPointerId(actionMasked);
                break;
            case 6:
                m14946a(motionEvent);
                nestedScrollView.f11924f = (int) motionEvent2.getY(motionEvent2.findPointerIndex(nestedScrollView.f11935q));
                break;
            default:
                break;
        }
        if (nestedScrollView.f11929k != null) {
            nestedScrollView.f11929k.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    /* renamed from: a */
    private void m14946a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f11935q) {
            actionIndex = actionIndex == 0 ? 1 : 0;
            this.f11924f = (int) motionEvent.getY(actionIndex);
            this.f11935q = motionEvent.getPointerId(actionIndex);
            if (this.f11929k != null) {
                this.f11929k.clear();
            }
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0) {
            if (motionEvent.getAction() == 8) {
                if (!this.f11928j) {
                    motionEvent = motionEvent.getAxisValue(9);
                    if (motionEvent != 0.0f) {
                        motionEvent = (int) (motionEvent * getVerticalScrollFactorCompat());
                        int scrollRange = getScrollRange();
                        int scrollY = getScrollY();
                        motionEvent = scrollY - motionEvent;
                        if (motionEvent < null) {
                            motionEvent = null;
                        } else if (motionEvent > scrollRange) {
                            motionEvent = scrollRange;
                        }
                        if (motionEvent != scrollY) {
                            super.scrollTo(getScrollX(), motionEvent);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.f11917A == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.f11917A = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.f11917A;
    }

    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    /* renamed from: a */
    boolean m14966a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        Object obj;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean z2;
        boolean z3;
        NestedScrollView nestedScrollView = this;
        int overScrollMode = getOverScrollMode();
        Object obj2 = computeHorizontalScrollRange() > computeHorizontalScrollExtent() ? 1 : null;
        Object obj3 = computeVerticalScrollRange() > computeVerticalScrollExtent() ? 1 : null;
        if (overScrollMode != 0) {
            if (overScrollMode != 1 || obj2 == null) {
                obj2 = null;
                if (overScrollMode != 0) {
                    if (overScrollMode == 1 || obj3 == null) {
                        obj = null;
                        overScrollMode = i3 + i;
                        i9 = obj2 != null ? 0 : i7;
                        i10 = i4 + i2;
                        i11 = obj != null ? 0 : i8;
                        i12 = -i9;
                        i9 += i5;
                        i13 = -i11;
                        i11 += i6;
                        if (overScrollMode <= i9) {
                            i12 = i9;
                        } else if (overScrollMode >= i12) {
                            i12 = overScrollMode;
                            z2 = false;
                            if (i10 <= i11) {
                                i13 = i11;
                            } else if (i10 >= i13) {
                                i13 = i10;
                                z3 = false;
                                if (z3 && !m14971b(1)) {
                                    nestedScrollView.f11921c.springBack(i12, i13, 0, 0, 0, getScrollRange());
                                }
                                onOverScrolled(i12, i13, z2, z3);
                                if (z2 || z3) {
                                    return true;
                                }
                                return false;
                            }
                            z3 = true;
                            nestedScrollView.f11921c.springBack(i12, i13, 0, 0, 0, getScrollRange());
                            onOverScrolled(i12, i13, z2, z3);
                            if (!z2) {
                            }
                            return true;
                        }
                        z2 = true;
                        if (i10 <= i11) {
                            i13 = i11;
                        } else if (i10 >= i13) {
                            i13 = i10;
                            z3 = false;
                            nestedScrollView.f11921c.springBack(i12, i13, 0, 0, 0, getScrollRange());
                            onOverScrolled(i12, i13, z2, z3);
                            if (z2) {
                            }
                            return true;
                        }
                        z3 = true;
                        nestedScrollView.f11921c.springBack(i12, i13, 0, 0, 0, getScrollRange());
                        onOverScrolled(i12, i13, z2, z3);
                        if (z2) {
                        }
                        return true;
                    }
                }
                obj = 1;
                overScrollMode = i3 + i;
                if (obj2 != null) {
                }
                i10 = i4 + i2;
                if (obj != null) {
                }
                i12 = -i9;
                i9 += i5;
                i13 = -i11;
                i11 += i6;
                if (overScrollMode <= i9) {
                    i12 = i9;
                } else if (overScrollMode >= i12) {
                    i12 = overScrollMode;
                    z2 = false;
                    if (i10 <= i11) {
                        i13 = i11;
                    } else if (i10 >= i13) {
                        i13 = i10;
                        z3 = false;
                        nestedScrollView.f11921c.springBack(i12, i13, 0, 0, 0, getScrollRange());
                        onOverScrolled(i12, i13, z2, z3);
                        if (z2) {
                        }
                        return true;
                    }
                    z3 = true;
                    nestedScrollView.f11921c.springBack(i12, i13, 0, 0, 0, getScrollRange());
                    onOverScrolled(i12, i13, z2, z3);
                    if (z2) {
                    }
                    return true;
                }
                z2 = true;
                if (i10 <= i11) {
                    i13 = i11;
                } else if (i10 >= i13) {
                    i13 = i10;
                    z3 = false;
                    nestedScrollView.f11921c.springBack(i12, i13, 0, 0, 0, getScrollRange());
                    onOverScrolled(i12, i13, z2, z3);
                    if (z2) {
                    }
                    return true;
                }
                z3 = true;
                nestedScrollView.f11921c.springBack(i12, i13, 0, 0, 0, getScrollRange());
                onOverScrolled(i12, i13, z2, z3);
                if (z2) {
                }
                return true;
            }
        }
        obj2 = 1;
        if (overScrollMode != 0) {
            if (overScrollMode == 1) {
            }
            obj = null;
            overScrollMode = i3 + i;
            if (obj2 != null) {
            }
            i10 = i4 + i2;
            if (obj != null) {
            }
            i12 = -i9;
            i9 += i5;
            i13 = -i11;
            i11 += i6;
            if (overScrollMode <= i9) {
                i12 = i9;
            } else if (overScrollMode >= i12) {
                i12 = overScrollMode;
                z2 = false;
                if (i10 <= i11) {
                    i13 = i11;
                } else if (i10 >= i13) {
                    i13 = i10;
                    z3 = false;
                    nestedScrollView.f11921c.springBack(i12, i13, 0, 0, 0, getScrollRange());
                    onOverScrolled(i12, i13, z2, z3);
                    if (z2) {
                    }
                    return true;
                }
                z3 = true;
                nestedScrollView.f11921c.springBack(i12, i13, 0, 0, 0, getScrollRange());
                onOverScrolled(i12, i13, z2, z3);
                if (z2) {
                }
                return true;
            }
            z2 = true;
            if (i10 <= i11) {
                i13 = i11;
            } else if (i10 >= i13) {
                i13 = i10;
                z3 = false;
                nestedScrollView.f11921c.springBack(i12, i13, 0, 0, 0, getScrollRange());
                onOverScrolled(i12, i13, z2, z3);
                if (z2) {
                }
                return true;
            }
            z3 = true;
            nestedScrollView.f11921c.springBack(i12, i13, 0, 0, 0, getScrollRange());
            onOverScrolled(i12, i13, z2, z3);
            if (z2) {
            }
            return true;
        }
        obj = 1;
        overScrollMode = i3 + i;
        if (obj2 != null) {
        }
        i10 = i4 + i2;
        if (obj != null) {
        }
        i12 = -i9;
        i9 += i5;
        i13 = -i11;
        i11 += i6;
        if (overScrollMode <= i9) {
            i12 = i9;
        } else if (overScrollMode >= i12) {
            i12 = overScrollMode;
            z2 = false;
            if (i10 <= i11) {
                i13 = i11;
            } else if (i10 >= i13) {
                i13 = i10;
                z3 = false;
                nestedScrollView.f11921c.springBack(i12, i13, 0, 0, 0, getScrollRange());
                onOverScrolled(i12, i13, z2, z3);
                if (z2) {
                }
                return true;
            }
            z3 = true;
            nestedScrollView.f11921c.springBack(i12, i13, 0, 0, 0, getScrollRange());
            onOverScrolled(i12, i13, z2, z3);
            if (z2) {
            }
            return true;
        }
        z2 = true;
        if (i10 <= i11) {
            i13 = i11;
        } else if (i10 >= i13) {
            i13 = i10;
            z3 = false;
            nestedScrollView.f11921c.springBack(i12, i13, 0, 0, 0, getScrollRange());
            onOverScrolled(i12, i13, z2, z3);
            if (z2) {
            }
            return true;
        }
        z3 = true;
        nestedScrollView.f11921c.springBack(i12, i13, 0, 0, 0, getScrollRange());
        onOverScrolled(i12, i13, z2, z3);
        if (z2) {
        }
        return true;
    }

    int getScrollRange() {
        if (getChildCount() > 0) {
            return Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
        }
        return 0;
    }

    /* renamed from: a */
    private View m14944a(boolean z, int i, int i2) {
        List focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        Object obj = null;
        for (int i3 = 0; i3 < size; i3++) {
            View view2 = (View) focusables.get(i3);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i < bottom && top < i2) {
                Object obj2 = (i >= top || bottom >= i2) ? null : 1;
                if (view == null) {
                    view = view2;
                    obj = obj2;
                } else {
                    Object obj3 = ((!z || top >= view.getTop()) && (z || bottom <= view.getBottom())) ? null : 1;
                    if (obj != null) {
                        if (!(obj2 == null || obj3 == null)) {
                        }
                    } else if (obj2 != null) {
                        view = view2;
                        obj = 1;
                    } else if (obj3 == null) {
                    }
                    view = view2;
                }
            }
        }
        return view;
    }

    /* renamed from: c */
    public boolean m14973c(int i) {
        Object obj = i == 130 ? 1 : null;
        int height = getHeight();
        if (obj != null) {
            this.f11920b.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                if (this.f11920b.top + height > childAt.getBottom()) {
                    this.f11920b.top = childAt.getBottom() - height;
                }
            }
        } else {
            this.f11920b.top = getScrollY() - height;
            if (this.f11920b.top < 0) {
                this.f11920b.top = 0;
            }
        }
        this.f11920b.bottom = this.f11920b.top + height;
        return m14947a(i, this.f11920b.top, this.f11920b.bottom);
    }

    /* renamed from: d */
    public boolean m14974d(int i) {
        Object obj = i == 130 ? 1 : null;
        int height = getHeight();
        this.f11920b.top = 0;
        this.f11920b.bottom = height;
        if (obj != null) {
            int childCount = getChildCount();
            if (childCount > 0) {
                this.f11920b.bottom = getChildAt(childCount - 1).getBottom() + getPaddingBottom();
                this.f11920b.top = this.f11920b.bottom - height;
            }
        }
        return m14947a(i, this.f11920b.top, this.f11920b.bottom);
    }

    /* renamed from: a */
    private boolean m14947a(int i, int i2, int i3) {
        int height = getHeight();
        int scrollY = getScrollY();
        height += scrollY;
        boolean z = false;
        boolean z2 = i == 33;
        View a = m14944a(z2, i2, i3);
        if (a == null) {
            a = this;
        }
        if (i2 < scrollY || i3 > height) {
            m14961g(z2 ? i2 - scrollY : i3 - height);
            z = true;
        }
        if (a != findFocus()) {
            a.requestFocus(i);
        }
        return z;
    }

    /* renamed from: e */
    public boolean m14975e(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !m14950a(findNextFocus, maxScrollAmount, getHeight())) {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                int bottom = getChildAt(0).getBottom() - ((getScrollY() + getHeight()) - getPaddingBottom());
                if (bottom < maxScrollAmount) {
                    maxScrollAmount = bottom;
                }
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            m14961g(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.f11920b);
            offsetDescendantRectToMyCoords(findNextFocus, this.f11920b);
            m14961g(m14963a(this.f11920b));
            findNextFocus.requestFocus(i);
        }
        if (!(findFocus == null || findFocus.isFocused() == 0 || m14949a(findFocus) == 0)) {
            i = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(i);
        }
        return true;
    }

    /* renamed from: a */
    private boolean m14949a(View view) {
        return m14950a(view, 0, getHeight()) ^ 1;
    }

    /* renamed from: a */
    private boolean m14950a(View view, int i, int i2) {
        view.getDrawingRect(this.f11920b);
        offsetDescendantRectToMyCoords(view, this.f11920b);
        return (this.f11920b.bottom + i < getScrollY() || this.f11920b.top - i > getScrollY() + i2) ? null : true;
    }

    /* renamed from: g */
    private void m14961g(int i) {
        if (i == 0) {
            return;
        }
        if (this.f11931m) {
            m14970b(0, i);
        } else {
            scrollBy(0, i);
        }
    }

    /* renamed from: b */
    public final void m14970b(int i, int i2) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.f11919a > 250) {
                i = Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
                int scrollY = getScrollY();
                this.f11921c.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i2 + scrollY, i)) - scrollY);
                C0517s.m1706c(this);
            } else {
                if (!this.f11921c.isFinished()) {
                    this.f11921c.abortAnimation();
                }
                scrollBy(i, i2);
            }
            this.f11919a = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    /* renamed from: c */
    public final void m14972c(int i, int i2) {
        m14970b(i - getScrollX(), i2 - getScrollY());
    }

    public int computeVerticalScrollRange() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (getChildCount() == 0) {
            return height;
        }
        int bottom = getChildAt(0).getBottom();
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        if (scrollY < 0) {
            bottom -= scrollY;
        } else if (scrollY > max) {
            bottom += scrollY - max;
        }
        return bottom;
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    protected void measureChild(View view, int i, int i2) {
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), MeasureSpec.makeMeasureSpec(0, 0));
    }

    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width), MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    public void computeScroll() {
        if (this.f11921c.computeScrollOffset()) {
            r10.f11921c.getCurrX();
            int currY = r10.f11921c.getCurrY();
            int i = currY - r10.f11939u;
            if (m14968a(0, i, r10.f11937s, null, 1)) {
                i -= r10.f11937s[1];
            }
            int i2 = i;
            if (i2 != 0) {
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int i3 = scrollY;
                m14966a(0, i2, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
                int scrollY2 = getScrollY() - i3;
                if (!m14967a(0, scrollY2, 0, i2 - scrollY2, null, 1)) {
                    Object obj;
                    int overScrollMode = getOverScrollMode();
                    if (overScrollMode != 0) {
                        if (overScrollMode != 1 || scrollRange <= 0) {
                            obj = null;
                            if (obj != null) {
                                m14960g();
                                if (currY > 0 && i3 > 0) {
                                    r10.f11922d.onAbsorb((int) r10.f11921c.getCurrVelocity());
                                } else if (currY >= scrollRange && i3 < scrollRange) {
                                    r10.f11923e.onAbsorb((int) r10.f11921c.getCurrVelocity());
                                }
                            }
                        }
                    }
                    obj = 1;
                    if (obj != null) {
                        m14960g();
                        if (currY > 0) {
                        }
                        r10.f11923e.onAbsorb((int) r10.f11921c.getCurrVelocity());
                    }
                }
            }
            r10.f11939u = currY;
            C0517s.m1706c(this);
            return;
        }
        if (m14971b(1)) {
            m14964a(1);
        }
        r10.f11939u = 0;
    }

    /* renamed from: b */
    private void m14953b(View view) {
        view.getDrawingRect(this.f11920b);
        offsetDescendantRectToMyCoords(view, this.f11920b);
        view = m14963a(this.f11920b);
        if (view != null) {
            scrollBy(0, view);
        }
    }

    /* renamed from: a */
    private boolean m14948a(Rect rect, boolean z) {
        rect = m14963a(rect);
        boolean z2 = rect != null;
        if (z2) {
            if (z) {
                scrollBy(0, rect);
            } else {
                m14970b(0, rect);
            }
        }
        return z2;
    }

    /* renamed from: a */
    protected int m14963a(Rect rect) {
        int i = 0;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i2 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        if (rect.bottom < getChildAt(0).getHeight()) {
            i2 -= verticalFadingEdgeLength;
        }
        if (rect.bottom > i2 && rect.top > scrollY) {
            if (rect.height() > height) {
                rect = (rect.top - scrollY) + null;
            } else {
                rect = (rect.bottom - i2) + null;
            }
            i = Math.min(rect, getChildAt(0).getBottom() - i2);
        } else if (rect.top < scrollY && rect.bottom < i2) {
            if (rect.height() > height) {
                i = 0 - (i2 - rect.bottom);
            } else {
                i = 0 - (scrollY - rect.top);
            }
            i = Math.max(i, -getScrollY());
        }
        return i;
    }

    public void requestChildFocus(View view, View view2) {
        if (this.f11925g) {
            this.f11927i = view2;
        } else {
            m14953b(view2);
        }
        super.requestChildFocus(view, view2);
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        View findNextFocus;
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        if (rect == null) {
            findNextFocus = FocusFinder.getInstance().findNextFocus(this, null, i);
        } else {
            findNextFocus = FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        }
        if (findNextFocus == null || m14949a(findNextFocus)) {
            return false;
        }
        return findNextFocus.requestFocus(i, rect);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return m14948a(rect, z);
    }

    public void requestLayout() {
        this.f11925g = true;
        super.requestLayout();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f11925g = false;
        if (!(this.f11927i == 0 || m14951a(this.f11927i, (View) this) == 0)) {
            m14953b(this.f11927i);
        }
        this.f11927i = null;
        if (this.f11926h == 0) {
            if (this.f11940v != 0) {
                scrollTo(getScrollX(), this.f11940v.f1308a);
                this.f11940v = null;
            }
            i = Math.max(0, (getChildCount() > 0 ? getChildAt(0).getMeasuredHeight() : 0) - (((i4 - i2) - getPaddingBottom()) - getPaddingTop()));
            if (getScrollY() > i) {
                scrollTo(getScrollX(), i);
            } else if (getScrollY() < 0) {
                scrollTo(getScrollX(), 0);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f11926h = true;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f11926h = false;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (findFocus != null) {
            if (this != findFocus) {
                if (m14950a(findFocus, 0, i4) != 0) {
                    findFocus.getDrawingRect(this.f11920b);
                    offsetDescendantRectToMyCoords(findFocus, this.f11920b);
                    m14961g(m14963a(this.f11920b));
                }
            }
        }
    }

    /* renamed from: a */
    private static boolean m14951a(View view, View view2) {
        boolean z = true;
        if (view == view2) {
            return true;
        }
        view = view.getParent();
        if (!(view instanceof ViewGroup) || m14951a(view, view2) == null) {
            z = false;
        }
        return z;
    }

    /* renamed from: f */
    public void m14976f(int i) {
        if (getChildCount() > 0) {
            m14965a(2, 1);
            this.f11921c.fling(getScrollX(), getScrollY(), 0, i, 0, 0, LinearLayoutManager.INVALID_OFFSET, Integer.MAX_VALUE, 0, 0);
            this.f11939u = getScrollY();
            C0517s.m1706c(this);
        }
    }

    /* renamed from: h */
    private void m14962h(int i) {
        boolean z;
        float f;
        int scrollY = getScrollY();
        if (scrollY > 0 || i > 0) {
            if (scrollY >= getScrollRange()) {
                if (i < 0) {
                }
            }
            z = true;
            f = (float) i;
            if (!dispatchNestedPreFling(0.0f, f)) {
                dispatchNestedFling(0.0f, f, z);
                m14976f(i);
            }
        }
        z = false;
        f = (float) i;
        if (!dispatchNestedPreFling(0.0f, f)) {
            dispatchNestedFling(0.0f, f, z);
            m14976f(i);
        }
    }

    /* renamed from: f */
    private void m14959f() {
        this.f11928j = false;
        m14958e();
        m14964a(0);
        if (this.f11922d != null) {
            this.f11922d.onRelease();
            this.f11923e.onRelease();
        }
    }

    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            i = m14952b(i, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth());
            i2 = m14952b(i2, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight());
            if (i != getScrollX() || i2 != getScrollY()) {
                super.scrollTo(i, i2);
            }
        }
    }

    /* renamed from: g */
    private void m14960g() {
        if (getOverScrollMode() == 2) {
            this.f11922d = null;
            this.f11923e = null;
        } else if (this.f11922d == null) {
            Context context = getContext();
            this.f11922d = new EdgeEffect(context);
            this.f11923e = new EdgeEffect(context);
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f11922d != null) {
            int save;
            int width;
            int height;
            int scrollY = getScrollY();
            int i = 0;
            if (!this.f11922d.isFinished()) {
                int i2;
                save = canvas.save();
                width = getWidth();
                height = getHeight();
                int min = Math.min(0, scrollY);
                if (VERSION.SDK_INT >= 21) {
                    if (!getClipToPadding()) {
                        i2 = 0;
                        if (VERSION.SDK_INT >= 21 && getClipToPadding()) {
                            height -= getPaddingTop() + getPaddingBottom();
                            min += getPaddingTop();
                        }
                        canvas.translate((float) i2, (float) min);
                        this.f11922d.setSize(width, height);
                        if (this.f11922d.draw(canvas)) {
                            C0517s.m1706c(this);
                        }
                        canvas.restoreToCount(save);
                    }
                }
                width -= getPaddingLeft() + getPaddingRight();
                i2 = getPaddingLeft() + 0;
                height -= getPaddingTop() + getPaddingBottom();
                min += getPaddingTop();
                canvas.translate((float) i2, (float) min);
                this.f11922d.setSize(width, height);
                if (this.f11922d.draw(canvas)) {
                    C0517s.m1706c(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.f11923e.isFinished()) {
                save = canvas.save();
                width = getWidth();
                height = getHeight();
                scrollY = Math.max(getScrollRange(), scrollY) + height;
                if (VERSION.SDK_INT < 21 || getClipToPadding()) {
                    width -= getPaddingLeft() + getPaddingRight();
                    i = 0 + getPaddingLeft();
                }
                if (VERSION.SDK_INT >= 21 && getClipToPadding()) {
                    height -= getPaddingTop() + getPaddingBottom();
                    scrollY -= getPaddingBottom();
                }
                canvas.translate((float) (i - width), (float) scrollY);
                canvas.rotate(180.0f, (float) width, 0.0f);
                this.f11923e.setSize(width, height);
                if (this.f11923e.draw(canvas)) {
                    C0517s.m1706c(this);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C0530c) {
            C0530c c0530c = (C0530c) parcelable;
            super.onRestoreInstanceState(c0530c.getSuperState());
            this.f11940v = c0530c;
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable c0530c = new C0530c(super.onSaveInstanceState());
        c0530c.f1308a = getScrollY();
        return c0530c;
    }
}
