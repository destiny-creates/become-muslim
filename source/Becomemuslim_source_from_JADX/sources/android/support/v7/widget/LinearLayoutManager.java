package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.widget.RecyclerView.C0701i;
import android.support.v7.widget.RecyclerView.C0701i.C0699a;
import android.support.v7.widget.RecyclerView.C0702j;
import android.support.v7.widget.RecyclerView.C0709p;
import android.support.v7.widget.RecyclerView.C0714t.C0713b;
import android.support.v7.widget.RecyclerView.C0715u;
import android.support.v7.widget.RecyclerView.C0718x;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class LinearLayoutManager extends C0701i implements C0713b {
    static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final C0681a mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final C0682b mLayoutChunkResult;
    private C0683c mLayoutState;
    int mOrientation;
    ay mOrientationHelper;
    C0685d mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    /* renamed from: android.support.v7.widget.LinearLayoutManager$a */
    static class C0681a {
        /* renamed from: a */
        ay f1774a;
        /* renamed from: b */
        int f1775b;
        /* renamed from: c */
        int f1776c;
        /* renamed from: d */
        boolean f1777d;
        /* renamed from: e */
        boolean f1778e;

        C0681a() {
            m2261a();
        }

        /* renamed from: a */
        void m2261a() {
            this.f1775b = -1;
            this.f1776c = LinearLayoutManager.INVALID_OFFSET;
            this.f1777d = false;
            this.f1778e = false;
        }

        /* renamed from: b */
        void m2264b() {
            int d;
            if (this.f1777d) {
                d = this.f1774a.mo652d();
            } else {
                d = this.f1774a.mo650c();
            }
            this.f1776c = d;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("AnchorInfo{mPosition=");
            stringBuilder.append(this.f1775b);
            stringBuilder.append(", mCoordinate=");
            stringBuilder.append(this.f1776c);
            stringBuilder.append(", mLayoutFromEnd=");
            stringBuilder.append(this.f1777d);
            stringBuilder.append(", mValid=");
            stringBuilder.append(this.f1778e);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }

        /* renamed from: a */
        boolean m2263a(View view, C0715u c0715u) {
            C0702j c0702j = (C0702j) view.getLayoutParams();
            return (c0702j.m2326d() || c0702j.m2328f() < 0 || c0702j.m2328f() >= c0715u.m2402e()) ? null : true;
        }

        /* renamed from: a */
        public void m2262a(View view, int i) {
            int b = this.f1774a.m2693b();
            if (b >= 0) {
                m2265b(view, i);
                return;
            }
            this.f1775b = i;
            int e;
            if (this.f1777d != 0) {
                i = (this.f1774a.mo652d() - b) - this.f1774a.mo649b(view);
                this.f1776c = this.f1774a.mo652d() - i;
                if (i > 0) {
                    e = this.f1776c - this.f1774a.mo655e(view);
                    b = this.f1774a.mo650c();
                    e -= b + Math.min(this.f1774a.mo647a(view) - b, 0);
                    if (e < 0) {
                        this.f1776c += Math.min(i, -e);
                    }
                }
            } else {
                i = this.f1774a.mo647a(view);
                e = i - this.f1774a.mo650c();
                this.f1776c = i;
                if (e > 0) {
                    view = (this.f1774a.mo652d() - Math.min(0, (this.f1774a.mo652d() - b) - this.f1774a.mo649b(view))) - (i + this.f1774a.mo655e(view));
                    if (view < null) {
                        this.f1776c -= Math.min(e, -view);
                    }
                }
            }
        }

        /* renamed from: b */
        public void m2265b(View view, int i) {
            if (this.f1777d) {
                this.f1776c = this.f1774a.mo649b(view) + this.f1774a.m2693b();
            } else {
                this.f1776c = this.f1774a.mo647a(view);
            }
            this.f1775b = i;
        }
    }

    /* renamed from: android.support.v7.widget.LinearLayoutManager$b */
    protected static class C0682b {
        /* renamed from: a */
        public int f1779a;
        /* renamed from: b */
        public boolean f1780b;
        /* renamed from: c */
        public boolean f1781c;
        /* renamed from: d */
        public boolean f1782d;

        protected C0682b() {
        }

        /* renamed from: a */
        void m2266a() {
            this.f1779a = 0;
            this.f1780b = false;
            this.f1781c = false;
            this.f1782d = false;
        }
    }

    /* renamed from: android.support.v7.widget.LinearLayoutManager$c */
    static class C0683c {
        /* renamed from: a */
        boolean f1783a = true;
        /* renamed from: b */
        int f1784b;
        /* renamed from: c */
        int f1785c;
        /* renamed from: d */
        int f1786d;
        /* renamed from: e */
        int f1787e;
        /* renamed from: f */
        int f1788f;
        /* renamed from: g */
        int f1789g;
        /* renamed from: h */
        int f1790h = 0;
        /* renamed from: i */
        boolean f1791i = false;
        /* renamed from: j */
        int f1792j;
        /* renamed from: k */
        List<C0718x> f1793k = null;
        /* renamed from: l */
        boolean f1794l;

        C0683c() {
        }

        /* renamed from: a */
        boolean m2271a(C0715u c0715u) {
            return (this.f1786d < 0 || this.f1786d >= c0715u.m2402e()) ? null : true;
        }

        /* renamed from: a */
        View m2268a(C0709p c0709p) {
            if (this.f1793k != null) {
                return m2267b();
            }
            c0709p = c0709p.m2370c(this.f1786d);
            this.f1786d += this.f1787e;
            return c0709p;
        }

        /* renamed from: b */
        private View m2267b() {
            int size = this.f1793k.size();
            for (int i = 0; i < size; i++) {
                View view = ((C0718x) this.f1793k.get(i)).itemView;
                C0702j c0702j = (C0702j) view.getLayoutParams();
                if (!c0702j.m2326d()) {
                    if (this.f1786d == c0702j.m2328f()) {
                        m2270a(view);
                        return view;
                    }
                }
            }
            return null;
        }

        /* renamed from: a */
        public void m2269a() {
            m2270a(null);
        }

        /* renamed from: a */
        public void m2270a(View view) {
            view = m2272b(view);
            if (view == null) {
                this.f1786d = -1;
            } else {
                this.f1786d = ((C0702j) view.getLayoutParams()).m2328f();
            }
        }

        /* renamed from: b */
        public View m2272b(View view) {
            int size = this.f1793k.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = ((C0718x) this.f1793k.get(i2)).itemView;
                C0702j c0702j = (C0702j) view3.getLayoutParams();
                if (view3 != view) {
                    if (!c0702j.m2326d()) {
                        int f = (c0702j.m2328f() - this.f1786d) * this.f1787e;
                        if (f >= 0) {
                            if (f >= i) {
                                continue;
                            } else if (f == 0) {
                                return view3;
                            } else {
                                view2 = view3;
                                i = f;
                            }
                        }
                    }
                }
            }
            return view2;
        }
    }

    /* renamed from: android.support.v7.widget.LinearLayoutManager$d */
    public static class C0685d implements Parcelable {
        public static final Creator<C0685d> CREATOR = new C06841();
        /* renamed from: a */
        int f1795a;
        /* renamed from: b */
        int f1796b;
        /* renamed from: c */
        boolean f1797c;

        /* renamed from: android.support.v7.widget.LinearLayoutManager$d$1 */
        static class C06841 implements Creator<C0685d> {
            C06841() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m2273a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m2274a(i);
            }

            /* renamed from: a */
            public C0685d m2273a(Parcel parcel) {
                return new C0685d(parcel);
            }

            /* renamed from: a */
            public C0685d[] m2274a(int i) {
                return new C0685d[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        C0685d(Parcel parcel) {
            this.f1795a = parcel.readInt();
            this.f1796b = parcel.readInt();
            boolean z = true;
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.f1797c = z;
        }

        public C0685d(C0685d c0685d) {
            this.f1795a = c0685d.f1795a;
            this.f1796b = c0685d.f1796b;
            this.f1797c = c0685d.f1797c;
        }

        /* renamed from: a */
        boolean m2275a() {
            return this.f1795a >= 0;
        }

        /* renamed from: b */
        void m2276b() {
            this.f1795a = -1;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f1795a);
            parcel.writeInt(this.f1796b);
            parcel.writeInt(this.f1797c);
        }
    }

    public boolean isAutoMeasureEnabled() {
        return true;
    }

    void onAnchorReady(C0709p c0709p, C0715u c0715u, C0681a c0681a, int i) {
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = INVALID_OFFSET;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new C0681a();
        this.mLayoutChunkResult = new C0682b();
        this.mInitialPrefetchItemCount = 2;
        setOrientation(i);
        setReverseLayout(z);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = INVALID_OFFSET;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new C0681a();
        this.mLayoutChunkResult = new C0682b();
        this.mInitialPrefetchItemCount = 2;
        context = C0701i.getProperties(context, attributeSet, i, i2);
        setOrientation(context.f1810a);
        setReverseLayout(context.f1812c);
        setStackFromEnd(context.f1813d);
    }

    public C0702j generateDefaultLayoutParams() {
        return new C0702j(-2, -2);
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public void setRecycleChildrenOnDetach(boolean z) {
        this.mRecycleChildrenOnDetach = z;
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, C0709p c0709p) {
        super.onDetachedFromWindow(recyclerView, c0709p);
        if (this.mRecycleChildrenOnDetach != null) {
            removeAndRecycleAllViews(c0709p);
            c0709p.m2354a();
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) {
            return new C0685d(this.mPendingSavedState);
        }
        Parcelable c0685d = new C0685d();
        if (getChildCount() > 0) {
            ensureLayoutState();
            boolean z = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            c0685d.f1797c = z;
            View childClosestToEnd;
            if (z) {
                childClosestToEnd = getChildClosestToEnd();
                c0685d.f1796b = this.mOrientationHelper.mo652d() - this.mOrientationHelper.mo649b(childClosestToEnd);
                c0685d.f1795a = getPosition(childClosestToEnd);
            } else {
                childClosestToEnd = getChildClosestToStart();
                c0685d.f1795a = getPosition(childClosestToEnd);
                c0685d.f1796b = this.mOrientationHelper.mo647a(childClosestToEnd) - this.mOrientationHelper.mo650c();
            }
        } else {
            c0685d.m2276b();
        }
        return c0685d;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C0685d) {
            this.mPendingSavedState = (C0685d) parcelable;
            requestLayout();
        }
    }

    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    public void setStackFromEnd(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (this.mStackFromEnd != z) {
            this.mStackFromEnd = z;
            requestLayout();
        }
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setOrientation(int i) {
        if (i != 0) {
            if (i != 1) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("invalid orientation:");
                stringBuilder.append(i);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        assertNotInLayoutOrScroll(null);
        if (i != this.mOrientation || this.mOrientationHelper == null) {
            this.mOrientationHelper = ay.m2688a(this, i);
            this.mAnchorInfo.f1774a = this.mOrientationHelper;
            this.mOrientation = i;
            requestLayout();
        }
    }

    private void resolveShouldLayoutReverse() {
        if (this.mOrientation != 1) {
            if (isLayoutRTL()) {
                this.mShouldReverseLayout = this.mReverseLayout ^ true;
                return;
            }
        }
        this.mShouldReverseLayout = this.mReverseLayout;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (z != this.mReverseLayout) {
            this.mReverseLayout = z;
            requestLayout();
        }
    }

    public View findViewByPosition(int i) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        int position = i - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i) {
                return childAt;
            }
        }
        return super.findViewByPosition(i);
    }

    protected int getExtraLayoutSpace(C0715u c0715u) {
        return c0715u.m2401d() != null ? this.mOrientationHelper.mo656f() : null;
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, C0715u c0715u, int i) {
        c0715u = new at(recyclerView.getContext());
        c0715u.setTargetPosition(i);
        startSmoothScroll(c0715u);
    }

    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return 0;
        }
        int i2 = 0;
        int i3 = 1;
        if (i < getPosition(getChildAt(0))) {
            i2 = 1;
        }
        if (i2 != this.mShouldReverseLayout) {
            i3 = -1;
        }
        if (this.mOrientation == 0) {
            return new PointF((float) i3, 0.0f);
        }
        return new PointF(0.0f, (float) i3);
    }

    public void onLayoutChildren(C0709p c0709p, C0715u c0715u) {
        int i = -1;
        if (!(this.mPendingSavedState == null && this.mPendingScrollPosition == -1) && c0715u.m2402e() == 0) {
            removeAndRecycleAllViews(c0709p);
            return;
        }
        int extraLayoutSpace;
        int i2;
        View findViewByPosition;
        int a;
        int i3;
        if (this.mPendingSavedState != null && this.mPendingSavedState.m2275a()) {
            this.mPendingScrollPosition = this.mPendingSavedState.f1795a;
        }
        ensureLayoutState();
        this.mLayoutState.f1783a = false;
        resolveShouldLayoutReverse();
        View focusedChild = getFocusedChild();
        if (this.mAnchorInfo.f1778e && this.mPendingScrollPosition == -1) {
            if (this.mPendingSavedState == null) {
                if (focusedChild != null && (this.mOrientationHelper.mo647a(focusedChild) >= this.mOrientationHelper.mo652d() || this.mOrientationHelper.mo649b(focusedChild) <= this.mOrientationHelper.mo650c())) {
                    this.mAnchorInfo.m2262a(focusedChild, getPosition(focusedChild));
                }
                extraLayoutSpace = getExtraLayoutSpace(c0715u);
                if (this.mLayoutState.f1792j < 0) {
                    i2 = extraLayoutSpace;
                    extraLayoutSpace = 0;
                } else {
                    i2 = 0;
                }
                extraLayoutSpace += this.mOrientationHelper.mo650c();
                i2 += this.mOrientationHelper.mo658g();
                if (!(!c0715u.m2398a() || this.mPendingScrollPosition == -1 || this.mPendingScrollPositionOffset == INVALID_OFFSET)) {
                    findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                    if (findViewByPosition != null) {
                        if (this.mShouldReverseLayout) {
                            a = this.mPendingScrollPositionOffset - (this.mOrientationHelper.mo647a(findViewByPosition) - this.mOrientationHelper.mo650c());
                        } else {
                            a = (this.mOrientationHelper.mo652d() - this.mOrientationHelper.mo649b(findViewByPosition)) - this.mPendingScrollPositionOffset;
                        }
                        if (a <= 0) {
                            extraLayoutSpace += a;
                        } else {
                            i2 -= a;
                        }
                    }
                }
                if (this.mAnchorInfo.f1777d ? this.mShouldReverseLayout : !this.mShouldReverseLayout) {
                    i = 1;
                }
                onAnchorReady(c0709p, c0715u, this.mAnchorInfo, i);
                detachAndScrapAttachedViews(c0709p);
                this.mLayoutState.f1794l = resolveIsInfinite();
                this.mLayoutState.f1791i = c0715u.m2398a();
                if (this.mAnchorInfo.f1777d) {
                    updateLayoutStateToFillEnd(this.mAnchorInfo);
                    this.mLayoutState.f1790h = i2;
                    fill(c0709p, this.mLayoutState, c0715u, false);
                    i2 = this.mLayoutState.f1784b;
                    i = this.mLayoutState.f1786d;
                    if (this.mLayoutState.f1785c > 0) {
                        extraLayoutSpace += this.mLayoutState.f1785c;
                    }
                    updateLayoutStateToFillStart(this.mAnchorInfo);
                    this.mLayoutState.f1790h = extraLayoutSpace;
                    C0683c c0683c = this.mLayoutState;
                    c0683c.f1786d += this.mLayoutState.f1787e;
                    fill(c0709p, this.mLayoutState, c0715u, false);
                    extraLayoutSpace = this.mLayoutState.f1784b;
                    if (this.mLayoutState.f1785c > 0) {
                        i3 = this.mLayoutState.f1785c;
                        updateLayoutStateToFillEnd(i, i2);
                        this.mLayoutState.f1790h = i3;
                        fill(c0709p, this.mLayoutState, c0715u, false);
                        i2 = this.mLayoutState.f1784b;
                    }
                } else {
                    updateLayoutStateToFillStart(this.mAnchorInfo);
                    this.mLayoutState.f1790h = extraLayoutSpace;
                    fill(c0709p, this.mLayoutState, c0715u, false);
                    extraLayoutSpace = this.mLayoutState.f1784b;
                    i = this.mLayoutState.f1786d;
                    if (this.mLayoutState.f1785c > 0) {
                        i2 += this.mLayoutState.f1785c;
                    }
                    updateLayoutStateToFillEnd(this.mAnchorInfo);
                    this.mLayoutState.f1790h = i2;
                    C0683c c0683c2 = this.mLayoutState;
                    c0683c2.f1786d += this.mLayoutState.f1787e;
                    fill(c0709p, this.mLayoutState, c0715u, false);
                    i2 = this.mLayoutState.f1784b;
                    if (this.mLayoutState.f1785c > 0) {
                        i3 = this.mLayoutState.f1785c;
                        updateLayoutStateToFillStart(i, extraLayoutSpace);
                        this.mLayoutState.f1790h = i3;
                        fill(c0709p, this.mLayoutState, c0715u, false);
                        extraLayoutSpace = this.mLayoutState.f1784b;
                    }
                }
                if (getChildCount() > 0) {
                    if ((this.mShouldReverseLayout ^ this.mStackFromEnd) == 0) {
                        i = fixLayoutEndGap(i2, c0709p, c0715u, true);
                        extraLayoutSpace += i;
                        i2 += i;
                        i = fixLayoutStartGap(extraLayoutSpace, c0709p, c0715u, false);
                        extraLayoutSpace += i;
                        i2 += i;
                    } else {
                        i = fixLayoutStartGap(extraLayoutSpace, c0709p, c0715u, true);
                        extraLayoutSpace += i;
                        i2 += i;
                        i = fixLayoutEndGap(i2, c0709p, c0715u, false);
                        extraLayoutSpace += i;
                        i2 += i;
                    }
                }
                layoutForPredictiveAnimations(c0709p, c0715u, extraLayoutSpace, i2);
                if (c0715u.m2398a() != null) {
                    this.mOrientationHelper.m2691a();
                } else {
                    this.mAnchorInfo.m2261a();
                }
                this.mLastStackFromEnd = this.mStackFromEnd;
            }
        }
        this.mAnchorInfo.m2261a();
        this.mAnchorInfo.f1777d = this.mShouldReverseLayout ^ this.mStackFromEnd;
        updateAnchorInfoForLayout(c0709p, c0715u, this.mAnchorInfo);
        this.mAnchorInfo.f1778e = true;
        extraLayoutSpace = getExtraLayoutSpace(c0715u);
        if (this.mLayoutState.f1792j < 0) {
            i2 = 0;
        } else {
            i2 = extraLayoutSpace;
            extraLayoutSpace = 0;
        }
        extraLayoutSpace += this.mOrientationHelper.mo650c();
        i2 += this.mOrientationHelper.mo658g();
        findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
        if (findViewByPosition != null) {
            if (this.mShouldReverseLayout) {
                a = this.mPendingScrollPositionOffset - (this.mOrientationHelper.mo647a(findViewByPosition) - this.mOrientationHelper.mo650c());
            } else {
                a = (this.mOrientationHelper.mo652d() - this.mOrientationHelper.mo649b(findViewByPosition)) - this.mPendingScrollPositionOffset;
            }
            if (a <= 0) {
                i2 -= a;
            } else {
                extraLayoutSpace += a;
            }
        }
        i = 1;
        onAnchorReady(c0709p, c0715u, this.mAnchorInfo, i);
        detachAndScrapAttachedViews(c0709p);
        this.mLayoutState.f1794l = resolveIsInfinite();
        this.mLayoutState.f1791i = c0715u.m2398a();
        if (this.mAnchorInfo.f1777d) {
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            this.mLayoutState.f1790h = i2;
            fill(c0709p, this.mLayoutState, c0715u, false);
            i2 = this.mLayoutState.f1784b;
            i = this.mLayoutState.f1786d;
            if (this.mLayoutState.f1785c > 0) {
                extraLayoutSpace += this.mLayoutState.f1785c;
            }
            updateLayoutStateToFillStart(this.mAnchorInfo);
            this.mLayoutState.f1790h = extraLayoutSpace;
            C0683c c0683c3 = this.mLayoutState;
            c0683c3.f1786d += this.mLayoutState.f1787e;
            fill(c0709p, this.mLayoutState, c0715u, false);
            extraLayoutSpace = this.mLayoutState.f1784b;
            if (this.mLayoutState.f1785c > 0) {
                i3 = this.mLayoutState.f1785c;
                updateLayoutStateToFillEnd(i, i2);
                this.mLayoutState.f1790h = i3;
                fill(c0709p, this.mLayoutState, c0715u, false);
                i2 = this.mLayoutState.f1784b;
            }
        } else {
            updateLayoutStateToFillStart(this.mAnchorInfo);
            this.mLayoutState.f1790h = extraLayoutSpace;
            fill(c0709p, this.mLayoutState, c0715u, false);
            extraLayoutSpace = this.mLayoutState.f1784b;
            i = this.mLayoutState.f1786d;
            if (this.mLayoutState.f1785c > 0) {
                i2 += this.mLayoutState.f1785c;
            }
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            this.mLayoutState.f1790h = i2;
            C0683c c0683c22 = this.mLayoutState;
            c0683c22.f1786d += this.mLayoutState.f1787e;
            fill(c0709p, this.mLayoutState, c0715u, false);
            i2 = this.mLayoutState.f1784b;
            if (this.mLayoutState.f1785c > 0) {
                i3 = this.mLayoutState.f1785c;
                updateLayoutStateToFillStart(i, extraLayoutSpace);
                this.mLayoutState.f1790h = i3;
                fill(c0709p, this.mLayoutState, c0715u, false);
                extraLayoutSpace = this.mLayoutState.f1784b;
            }
        }
        if (getChildCount() > 0) {
            if ((this.mShouldReverseLayout ^ this.mStackFromEnd) == 0) {
                i = fixLayoutStartGap(extraLayoutSpace, c0709p, c0715u, true);
                extraLayoutSpace += i;
                i2 += i;
                i = fixLayoutEndGap(i2, c0709p, c0715u, false);
                extraLayoutSpace += i;
                i2 += i;
            } else {
                i = fixLayoutEndGap(i2, c0709p, c0715u, true);
                extraLayoutSpace += i;
                i2 += i;
                i = fixLayoutStartGap(extraLayoutSpace, c0709p, c0715u, false);
                extraLayoutSpace += i;
                i2 += i;
            }
        }
        layoutForPredictiveAnimations(c0709p, c0715u, extraLayoutSpace, i2);
        if (c0715u.m2398a() != null) {
            this.mAnchorInfo.m2261a();
        } else {
            this.mOrientationHelper.m2691a();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    public void onLayoutCompleted(C0715u c0715u) {
        super.onLayoutCompleted(c0715u);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = INVALID_OFFSET;
        this.mAnchorInfo.m2261a();
    }

    private void layoutForPredictiveAnimations(C0709p c0709p, C0715u c0715u, int i, int i2) {
        LinearLayoutManager linearLayoutManager = this;
        C0709p c0709p2 = c0709p;
        C0715u c0715u2 = c0715u;
        if (!(!c0715u.m2399b() || getChildCount() == 0 || c0715u.m2398a())) {
            if (supportsPredictiveItemAnimations()) {
                List c = c0709p.m2371c();
                int size = c.size();
                int position = getPosition(getChildAt(0));
                int i3 = 0;
                int i4 = 0;
                for (int i5 = 0; i5 < size; i5++) {
                    C0718x c0718x = (C0718x) c.get(i5);
                    if (!c0718x.isRemoved()) {
                        int i6 = 1;
                        if ((c0718x.getLayoutPosition() < position) != linearLayoutManager.mShouldReverseLayout) {
                            i6 = -1;
                        }
                        if (i6 == -1) {
                            i3 += linearLayoutManager.mOrientationHelper.mo655e(c0718x.itemView);
                        } else {
                            i4 += linearLayoutManager.mOrientationHelper.mo655e(c0718x.itemView);
                        }
                    }
                }
                linearLayoutManager.mLayoutState.f1793k = c;
                if (i3 > 0) {
                    updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), i);
                    linearLayoutManager.mLayoutState.f1790h = i3;
                    linearLayoutManager.mLayoutState.f1785c = 0;
                    linearLayoutManager.mLayoutState.m2269a();
                    fill(c0709p2, linearLayoutManager.mLayoutState, c0715u2, false);
                }
                if (i4 > 0) {
                    updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), i2);
                    linearLayoutManager.mLayoutState.f1790h = i4;
                    linearLayoutManager.mLayoutState.f1785c = 0;
                    linearLayoutManager.mLayoutState.m2269a();
                    fill(c0709p2, linearLayoutManager.mLayoutState, c0715u2, false);
                }
                linearLayoutManager.mLayoutState.f1793k = null;
            }
        }
    }

    private void updateAnchorInfoForLayout(C0709p c0709p, C0715u c0715u, C0681a c0681a) {
        if (!updateAnchorFromPendingData(c0715u, c0681a) && updateAnchorFromChildren(c0709p, c0715u, c0681a) == null) {
            c0681a.m2264b();
            c0681a.f1775b = this.mStackFromEnd != null ? c0715u.m2402e() - 1 : null;
        }
    }

    private boolean updateAnchorFromChildren(C0709p c0709p, C0715u c0715u, C0681a c0681a) {
        boolean z = false;
        if (getChildCount() == 0) {
            return false;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild != null && c0681a.m2263a(focusedChild, c0715u)) {
            c0681a.m2262a(focusedChild, getPosition(focusedChild));
            return true;
        } else if (this.mLastStackFromEnd != this.mStackFromEnd) {
            return false;
        } else {
            View findReferenceChildClosestToEnd;
            if (c0681a.f1777d) {
                findReferenceChildClosestToEnd = findReferenceChildClosestToEnd(c0709p, c0715u);
            } else {
                findReferenceChildClosestToEnd = findReferenceChildClosestToStart(c0709p, c0715u);
            }
            if (findReferenceChildClosestToEnd == null) {
                return false;
            }
            c0681a.m2265b(findReferenceChildClosestToEnd, getPosition(findReferenceChildClosestToEnd));
            if (c0715u.m2398a() == null && supportsPredictiveItemAnimations() != null) {
                if (this.mOrientationHelper.mo647a(findReferenceChildClosestToEnd) >= this.mOrientationHelper.mo652d() || this.mOrientationHelper.mo649b(findReferenceChildClosestToEnd) < this.mOrientationHelper.mo650c()) {
                    z = true;
                }
                if (z) {
                    if (c0681a.f1777d != null) {
                        c0709p = this.mOrientationHelper.mo652d();
                    } else {
                        c0709p = this.mOrientationHelper.mo650c();
                    }
                    c0681a.f1776c = c0709p;
                }
            }
            return true;
        }
    }

    private boolean updateAnchorFromPendingData(C0715u c0715u, C0681a c0681a) {
        boolean z = false;
        if (!c0715u.m2398a()) {
            if (this.mPendingScrollPosition != -1) {
                if (this.mPendingScrollPosition >= 0) {
                    if (this.mPendingScrollPosition < c0715u.m2402e()) {
                        c0681a.f1775b = this.mPendingScrollPosition;
                        if (this.mPendingSavedState != null && this.mPendingSavedState.m2275a() != null) {
                            c0681a.f1777d = this.mPendingSavedState.f1797c;
                            if (c0681a.f1777d != null) {
                                c0681a.f1776c = this.mOrientationHelper.mo652d() - this.mPendingSavedState.f1796b;
                            } else {
                                c0681a.f1776c = this.mOrientationHelper.mo650c() + this.mPendingSavedState.f1796b;
                            }
                            return true;
                        } else if (this.mPendingScrollPositionOffset == -2147483648) {
                            View findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                            if (findViewByPosition == null) {
                                if (getChildCount() > null) {
                                    if ((this.mPendingScrollPosition < getPosition(getChildAt(0)) ? true : null) == this.mShouldReverseLayout) {
                                        z = true;
                                    }
                                    c0681a.f1777d = z;
                                }
                                c0681a.m2264b();
                            } else if (this.mOrientationHelper.mo655e(findViewByPosition) > this.mOrientationHelper.mo656f()) {
                                c0681a.m2264b();
                                return true;
                            } else if (this.mOrientationHelper.mo647a(findViewByPosition) - this.mOrientationHelper.mo650c() < 0) {
                                c0681a.f1776c = this.mOrientationHelper.mo650c();
                                c0681a.f1777d = false;
                                return true;
                            } else if (this.mOrientationHelper.mo652d() - this.mOrientationHelper.mo649b(findViewByPosition) < 0) {
                                c0681a.f1776c = this.mOrientationHelper.mo652d();
                                c0681a.f1777d = true;
                                return true;
                            } else {
                                if (c0681a.f1777d) {
                                    c0715u = this.mOrientationHelper.mo649b(findViewByPosition) + this.mOrientationHelper.m2693b();
                                } else {
                                    c0715u = this.mOrientationHelper.mo647a(findViewByPosition);
                                }
                                c0681a.f1776c = c0715u;
                            }
                            return true;
                        } else {
                            c0681a.f1777d = this.mShouldReverseLayout;
                            if (this.mShouldReverseLayout != null) {
                                c0681a.f1776c = this.mOrientationHelper.mo652d() - this.mPendingScrollPositionOffset;
                            } else {
                                c0681a.f1776c = this.mOrientationHelper.mo650c() + this.mPendingScrollPositionOffset;
                            }
                            return true;
                        }
                    }
                }
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = INVALID_OFFSET;
                return false;
            }
        }
        return false;
    }

    private int fixLayoutEndGap(int i, C0709p c0709p, C0715u c0715u, boolean z) {
        int d = this.mOrientationHelper.mo652d() - i;
        if (d <= 0) {
            return 0;
        }
        c0709p = -scrollBy(-d, c0709p, c0715u);
        i += c0709p;
        if (z) {
            int d2 = this.mOrientationHelper.mo652d() - i;
            if (d2 > null) {
                this.mOrientationHelper.mo648a(d2);
                return d2 + c0709p;
            }
        }
        return c0709p;
    }

    private int fixLayoutStartGap(int i, C0709p c0709p, C0715u c0715u, boolean z) {
        int c = i - this.mOrientationHelper.mo650c();
        if (c <= 0) {
            return 0;
        }
        c0709p = -scrollBy(c, c0709p, c0715u);
        i += c0709p;
        if (z) {
            i -= this.mOrientationHelper.mo650c();
            if (i > 0) {
                this.mOrientationHelper.mo648a(-i);
                return c0709p - i;
            }
        }
        return c0709p;
    }

    private void updateLayoutStateToFillEnd(C0681a c0681a) {
        updateLayoutStateToFillEnd(c0681a.f1775b, c0681a.f1776c);
    }

    private void updateLayoutStateToFillEnd(int i, int i2) {
        this.mLayoutState.f1785c = this.mOrientationHelper.mo652d() - i2;
        this.mLayoutState.f1787e = this.mShouldReverseLayout ? -1 : 1;
        this.mLayoutState.f1786d = i;
        this.mLayoutState.f1788f = 1;
        this.mLayoutState.f1784b = i2;
        this.mLayoutState.f1789g = INVALID_OFFSET;
    }

    private void updateLayoutStateToFillStart(C0681a c0681a) {
        updateLayoutStateToFillStart(c0681a.f1775b, c0681a.f1776c);
    }

    private void updateLayoutStateToFillStart(int i, int i2) {
        this.mLayoutState.f1785c = i2 - this.mOrientationHelper.mo650c();
        this.mLayoutState.f1786d = i;
        this.mLayoutState.f1787e = this.mShouldReverseLayout ? 1 : -1;
        this.mLayoutState.f1788f = -1;
        this.mLayoutState.f1784b = i2;
        this.mLayoutState.f1789g = INVALID_OFFSET;
    }

    protected boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = createLayoutState();
        }
    }

    C0683c createLayoutState() {
        return new C0683c();
    }

    public void scrollToPosition(int i) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = INVALID_OFFSET;
        if (this.mPendingSavedState != 0) {
            this.mPendingSavedState.m2276b();
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = i2;
        if (this.mPendingSavedState != 0) {
            this.mPendingSavedState.m2276b();
        }
        requestLayout();
    }

    public int scrollHorizontallyBy(int i, C0709p c0709p, C0715u c0715u) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return scrollBy(i, c0709p, c0715u);
    }

    public int scrollVerticallyBy(int i, C0709p c0709p, C0715u c0715u) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return scrollBy(i, c0709p, c0715u);
    }

    public int computeHorizontalScrollOffset(C0715u c0715u) {
        return computeScrollOffset(c0715u);
    }

    public int computeVerticalScrollOffset(C0715u c0715u) {
        return computeScrollOffset(c0715u);
    }

    public int computeHorizontalScrollExtent(C0715u c0715u) {
        return computeScrollExtent(c0715u);
    }

    public int computeVerticalScrollExtent(C0715u c0715u) {
        return computeScrollExtent(c0715u);
    }

    public int computeHorizontalScrollRange(C0715u c0715u) {
        return computeScrollRange(c0715u);
    }

    public int computeVerticalScrollRange(C0715u c0715u) {
        return computeScrollRange(c0715u);
    }

    private int computeScrollOffset(C0715u c0715u) {
        if (getChildCount() == 0) {
            return null;
        }
        ensureLayoutState();
        return bf.m2744a(c0715u, this.mOrientationHelper, findFirstVisibleChildClosestToStart(this.mSmoothScrollbarEnabled ^ true, true), findFirstVisibleChildClosestToEnd(this.mSmoothScrollbarEnabled ^ true, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollExtent(C0715u c0715u) {
        if (getChildCount() == 0) {
            return null;
        }
        ensureLayoutState();
        return bf.m2743a(c0715u, this.mOrientationHelper, findFirstVisibleChildClosestToStart(this.mSmoothScrollbarEnabled ^ true, true), findFirstVisibleChildClosestToEnd(this.mSmoothScrollbarEnabled ^ true, true), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollRange(C0715u c0715u) {
        if (getChildCount() == 0) {
            return null;
        }
        ensureLayoutState();
        return bf.m2745b(c0715u, this.mOrientationHelper, findFirstVisibleChildClosestToStart(this.mSmoothScrollbarEnabled ^ true, true), findFirstVisibleChildClosestToEnd(this.mSmoothScrollbarEnabled ^ true, true), this, this.mSmoothScrollbarEnabled);
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.mSmoothScrollbarEnabled = z;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    private void updateLayoutState(int i, int i2, boolean z, C0715u c0715u) {
        this.mLayoutState.f1794l = resolveIsInfinite();
        this.mLayoutState.f1790h = getExtraLayoutSpace(c0715u);
        this.mLayoutState.f1788f = i;
        c0715u = -1;
        View childClosestToEnd;
        C0683c c0683c;
        if (i == 1) {
            i = this.mLayoutState;
            i.f1790h += this.mOrientationHelper.mo658g();
            childClosestToEnd = getChildClosestToEnd();
            c0683c = this.mLayoutState;
            if (!this.mShouldReverseLayout) {
                c0715u = true;
            }
            c0683c.f1787e = c0715u;
            this.mLayoutState.f1786d = getPosition(childClosestToEnd) + this.mLayoutState.f1787e;
            this.mLayoutState.f1784b = this.mOrientationHelper.mo649b(childClosestToEnd);
            i = this.mOrientationHelper.mo649b(childClosestToEnd) - this.mOrientationHelper.mo652d();
        } else {
            childClosestToEnd = getChildClosestToStart();
            c0683c = this.mLayoutState;
            c0683c.f1790h += this.mOrientationHelper.mo650c();
            c0683c = this.mLayoutState;
            if (this.mShouldReverseLayout) {
                c0715u = true;
            }
            c0683c.f1787e = c0715u;
            this.mLayoutState.f1786d = getPosition(childClosestToEnd) + this.mLayoutState.f1787e;
            this.mLayoutState.f1784b = this.mOrientationHelper.mo647a(childClosestToEnd);
            i = (-this.mOrientationHelper.mo647a(childClosestToEnd)) + this.mOrientationHelper.mo650c();
        }
        this.mLayoutState.f1785c = i2;
        if (z) {
            i2 = this.mLayoutState;
            i2.f1785c -= i;
        }
        this.mLayoutState.f1789g = i;
    }

    boolean resolveIsInfinite() {
        return this.mOrientationHelper.mo659h() == 0 && this.mOrientationHelper.mo654e() == 0;
    }

    void collectPrefetchPositionsForLayoutState(C0715u c0715u, C0683c c0683c, C0699a c0699a) {
        int i = c0683c.f1786d;
        if (i >= 0 && i < c0715u.m2402e()) {
            c0699a.mo629b(i, Math.max(null, c0683c.f1789g));
        }
    }

    public void collectInitialPrefetchPositions(int i, C0699a c0699a) {
        boolean z;
        int i2;
        int i3 = -1;
        if (this.mPendingSavedState == null || !this.mPendingSavedState.m2275a()) {
            resolveShouldLayoutReverse();
            z = this.mShouldReverseLayout;
            i2 = this.mPendingScrollPosition == -1 ? z ? i - 1 : 0 : this.mPendingScrollPosition;
        } else {
            z = this.mPendingSavedState.f1797c;
            i2 = this.mPendingSavedState.f1795a;
        }
        if (!z) {
            i3 = 1;
        }
        for (int i4 = 0; i4 < this.mInitialPrefetchItemCount && i2 >= 0 && i2 < i; i4++) {
            c0699a.mo629b(i2, 0);
            i2 += i3;
        }
    }

    public void setInitialPrefetchItemCount(int i) {
        this.mInitialPrefetchItemCount = i;
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public void collectAdjacentPrefetchPositions(int i, int i2, C0715u c0715u, C0699a c0699a) {
        if (this.mOrientation != 0) {
            i = i2;
        }
        if (getChildCount() != 0) {
            if (i != 0) {
                ensureLayoutState();
                updateLayoutState(i > 0 ? 1 : -1, Math.abs(i), 1, c0715u);
                collectPrefetchPositionsForLayoutState(c0715u, this.mLayoutState, c0699a);
            }
        }
    }

    int scrollBy(int i, C0709p c0709p, C0715u c0715u) {
        if (getChildCount() != 0) {
            if (i != 0) {
                this.mLayoutState.f1783a = true;
                ensureLayoutState();
                int i2 = i > 0 ? 1 : -1;
                int abs = Math.abs(i);
                updateLayoutState(i2, abs, true, c0715u);
                int fill = this.mLayoutState.f1789g + fill(c0709p, this.mLayoutState, c0715u, false);
                if (fill < 0) {
                    return 0;
                }
                if (abs > fill) {
                    i = i2 * fill;
                }
                this.mOrientationHelper.mo648a(-i);
                this.mLayoutState.f1792j = i;
                return i;
            }
        }
        return 0;
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    private void recycleChildren(C0709p c0709p, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (i2--; i2 >= i; i2--) {
                    removeAndRecycleViewAt(i2, c0709p);
                }
            } else {
                while (i > i2) {
                    removeAndRecycleViewAt(i, c0709p);
                    i--;
                }
            }
        }
    }

    private void recycleViewsFromStart(C0709p c0709p, int i) {
        if (i >= 0) {
            int childCount = getChildCount();
            if (this.mShouldReverseLayout) {
                childCount--;
                int i2 = childCount;
                while (i2 >= 0) {
                    View childAt = getChildAt(i2);
                    if (this.mOrientationHelper.mo649b(childAt) <= i) {
                        if (this.mOrientationHelper.mo651c(childAt) <= i) {
                            i2--;
                        }
                    }
                    recycleChildren(c0709p, childCount, i2);
                    return;
                }
            }
            int i3 = 0;
            while (i3 < childCount) {
                View childAt2 = getChildAt(i3);
                if (this.mOrientationHelper.mo649b(childAt2) <= i) {
                    if (this.mOrientationHelper.mo651c(childAt2) <= i) {
                        i3++;
                    }
                }
                recycleChildren(c0709p, 0, i3);
                return;
            }
        }
    }

    private void recycleViewsFromEnd(C0709p c0709p, int i) {
        int childCount = getChildCount();
        if (i >= 0) {
            int e = this.mOrientationHelper.mo654e() - i;
            if (this.mShouldReverseLayout != 0) {
                int i2 = 0;
                while (i2 < childCount) {
                    View childAt = getChildAt(i2);
                    if (this.mOrientationHelper.mo647a(childAt) >= e) {
                        if (this.mOrientationHelper.mo653d(childAt) >= e) {
                            i2++;
                        }
                    }
                    recycleChildren(c0709p, 0, i2);
                    return;
                }
            }
            childCount--;
            i = childCount;
            while (i >= 0) {
                View childAt2 = getChildAt(i);
                if (this.mOrientationHelper.mo647a(childAt2) >= e) {
                    if (this.mOrientationHelper.mo653d(childAt2) >= e) {
                        i--;
                    }
                }
                recycleChildren(c0709p, childCount, i);
                return;
            }
        }
    }

    private void recycleByLayoutState(C0709p c0709p, C0683c c0683c) {
        if (c0683c.f1783a) {
            if (!c0683c.f1794l) {
                if (c0683c.f1788f == -1) {
                    recycleViewsFromEnd(c0709p, c0683c.f1789g);
                } else {
                    recycleViewsFromStart(c0709p, c0683c.f1789g);
                }
            }
        }
    }

    int fill(C0709p c0709p, C0683c c0683c, C0715u c0715u, boolean z) {
        int i = c0683c.f1785c;
        if (c0683c.f1789g != INVALID_OFFSET) {
            if (c0683c.f1785c < 0) {
                c0683c.f1789g += c0683c.f1785c;
            }
            recycleByLayoutState(c0709p, c0683c);
        }
        int i2 = c0683c.f1785c + c0683c.f1790h;
        C0682b c0682b = this.mLayoutChunkResult;
        while (true) {
            if ((!c0683c.f1794l && i2 <= 0) || !c0683c.m2271a(c0715u)) {
                break;
            }
            c0682b.m2266a();
            layoutChunk(c0709p, c0715u, c0683c, c0682b);
            if (!c0682b.f1780b) {
                c0683c.f1784b += c0682b.f1779a * c0683c.f1788f;
                if (!(c0682b.f1781c && this.mLayoutState.f1793k == null && c0715u.m2398a())) {
                    c0683c.f1785c -= c0682b.f1779a;
                    i2 -= c0682b.f1779a;
                }
                if (c0683c.f1789g != INVALID_OFFSET) {
                    c0683c.f1789g += c0682b.f1779a;
                    if (c0683c.f1785c < 0) {
                        c0683c.f1789g += c0683c.f1785c;
                    }
                    recycleByLayoutState(c0709p, c0683c);
                }
                if (z && c0682b.f1782d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - c0683c.f1785c;
    }

    void layoutChunk(C0709p c0709p, C0715u c0715u, C0683c c0683c, C0682b c0682b) {
        c0709p = c0683c.m2268a(c0709p);
        if (c0709p == null) {
            c0682b.f1780b = true;
            return;
        }
        int f;
        int i;
        int i2;
        int i3;
        C0702j c0702j = (C0702j) c0709p.getLayoutParams();
        if (c0683c.f1793k == null) {
            if (this.mShouldReverseLayout == (c0683c.f1788f == -1)) {
                addView(c0709p);
            } else {
                addView(c0709p, 0);
            }
        } else {
            if (this.mShouldReverseLayout == (c0683c.f1788f == -1)) {
                addDisappearingView(c0709p);
            } else {
                addDisappearingView(c0709p, 0);
            }
        }
        measureChildWithMargins(c0709p, 0, 0);
        c0682b.f1779a = this.mOrientationHelper.mo655e(c0709p);
        int width;
        if (this.mOrientation == 1) {
            if (isLayoutRTL()) {
                width = getWidth() - getPaddingRight();
                f = width - this.mOrientationHelper.mo657f(c0709p);
            } else {
                f = getPaddingLeft();
                width = this.mOrientationHelper.mo657f(c0709p) + f;
            }
            if (c0683c.f1788f == -1) {
                i = c0683c.f1784b - c0682b.f1779a;
                i2 = width;
                i3 = c0683c.f1784b;
            } else {
                i3 = c0683c.f1784b + c0682b.f1779a;
                i2 = width;
                i = c0683c.f1784b;
            }
        } else {
            width = getPaddingTop();
            f = this.mOrientationHelper.mo657f(c0709p) + width;
            if (c0683c.f1788f == -1) {
                i = width;
                i2 = c0683c.f1784b;
                i3 = f;
                f = c0683c.f1784b - c0682b.f1779a;
            } else {
                i2 = c0683c.f1784b + c0682b.f1779a;
                i = width;
                i3 = f;
                f = c0683c.f1784b;
            }
        }
        layoutDecoratedWithMargins(c0709p, f, i, i2, i3);
        if (!(c0702j.m2326d() == null && c0702j.m2327e() == null)) {
            c0682b.f1781c = true;
        }
        c0682b.f1782d = c0709p.hasFocusable();
    }

    boolean shouldMeasureTwice() {
        return (getHeightMode() == 1073741824 || getWidthMode() == 1073741824 || !hasFlexibleChildInBothOrientations()) ? false : true;
    }

    int convertFocusDirectionToLayoutDirection(int i) {
        int i2 = -1;
        int i3 = INVALID_OFFSET;
        if (i == 17) {
            if (this.mOrientation != 0) {
                i2 = INVALID_OFFSET;
            }
            return i2;
        } else if (i == 33) {
            if (this.mOrientation != 1) {
                i2 = INVALID_OFFSET;
            }
            return i2;
        } else if (i == 66) {
            if (this.mOrientation == 0) {
                i3 = 1;
            }
            return i3;
        } else if (i != 130) {
            switch (i) {
                case 1:
                    return (this.mOrientation == 1 || isLayoutRTL() == 0) ? -1 : 1;
                case 2:
                    return (this.mOrientation == 1 || isLayoutRTL() == 0) ? 1 : -1;
                default:
                    return INVALID_OFFSET;
            }
        } else {
            if (this.mOrientation == 1) {
                i3 = 1;
            }
            return i3;
        }
    }

    private View getChildClosestToStart() {
        return getChildAt(this.mShouldReverseLayout ? getChildCount() - 1 : 0);
    }

    private View getChildClosestToEnd() {
        return getChildAt(this.mShouldReverseLayout ? 0 : getChildCount() - 1);
    }

    private View findFirstVisibleChildClosestToStart(boolean z, boolean z2) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(getChildCount() - 1, -1, z, z2);
        }
        return findOneVisibleChild(0, getChildCount(), z, z2);
    }

    private View findFirstVisibleChildClosestToEnd(boolean z, boolean z2) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(0, getChildCount(), z, z2);
        }
        return findOneVisibleChild(getChildCount() - 1, -1, z, z2);
    }

    private View findReferenceChildClosestToEnd(C0709p c0709p, C0715u c0715u) {
        if (this.mShouldReverseLayout) {
            return findFirstReferenceChild(c0709p, c0715u);
        }
        return findLastReferenceChild(c0709p, c0715u);
    }

    private View findReferenceChildClosestToStart(C0709p c0709p, C0715u c0715u) {
        if (this.mShouldReverseLayout) {
            return findLastReferenceChild(c0709p, c0715u);
        }
        return findFirstReferenceChild(c0709p, c0715u);
    }

    private View findFirstReferenceChild(C0709p c0709p, C0715u c0715u) {
        return findReferenceChild(c0709p, c0715u, 0, getChildCount(), c0715u.m2402e());
    }

    private View findLastReferenceChild(C0709p c0709p, C0715u c0715u) {
        return findReferenceChild(c0709p, c0715u, getChildCount() - 1, -1, c0715u.m2402e());
    }

    View findReferenceChild(C0709p c0709p, C0715u c0715u, int i, int i2, int i3) {
        ensureLayoutState();
        c0709p = this.mOrientationHelper.mo650c();
        c0715u = this.mOrientationHelper.mo652d();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View childAt = getChildAt(i);
            int position = getPosition(childAt);
            if (position >= 0 && position < i3) {
                if (!((C0702j) childAt.getLayoutParams()).m2326d()) {
                    if (this.mOrientationHelper.mo647a(childAt) < c0715u) {
                        if (this.mOrientationHelper.mo649b(childAt) >= c0709p) {
                            return childAt;
                        }
                    }
                    if (view == null) {
                        view = childAt;
                    }
                } else if (view2 == null) {
                    view2 = childAt;
                }
            }
            i += i4;
        }
        if (view == null) {
            view = view2;
        }
        return view;
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToEnd(C0709p c0709p, C0715u c0715u) {
        if (this.mShouldReverseLayout) {
            return findFirstPartiallyOrCompletelyInvisibleChild(c0709p, c0715u);
        }
        return findLastPartiallyOrCompletelyInvisibleChild(c0709p, c0715u);
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToStart(C0709p c0709p, C0715u c0715u) {
        if (this.mShouldReverseLayout) {
            return findLastPartiallyOrCompletelyInvisibleChild(c0709p, c0715u);
        }
        return findFirstPartiallyOrCompletelyInvisibleChild(c0709p, c0715u);
    }

    private View findFirstPartiallyOrCompletelyInvisibleChild(C0709p c0709p, C0715u c0715u) {
        return findOnePartiallyOrCompletelyInvisibleChild(null, getChildCount());
    }

    private View findLastPartiallyOrCompletelyInvisibleChild(C0709p c0709p, C0715u c0715u) {
        return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
    }

    public int findFirstVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    View findOneVisibleChild(int i, int i2, boolean z, boolean z2) {
        ensureLayoutState();
        int i3 = 320;
        z = z ? true : true;
        if (!z2) {
            i3 = 0;
        }
        if (this.mOrientation) {
            return this.mVerticalBoundCheck.m2814a(i, i2, z, i3);
        }
        return this.mHorizontalBoundCheck.m2814a(i, i2, z, i3);
    }

    View findOnePartiallyOrCompletelyInvisibleChild(int i, int i2) {
        ensureLayoutState();
        Object obj = i2 > i ? 1 : i2 < i ? -1 : null;
        if (obj == null) {
            return getChildAt(i);
        }
        int i3;
        int i4;
        if (this.mOrientationHelper.mo647a(getChildAt(i)) < this.mOrientationHelper.mo650c()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = 4097;
        }
        if (this.mOrientation == 0) {
            i = this.mHorizontalBoundCheck.m2814a(i, i2, i3, i4);
        } else {
            i = this.mVerticalBoundCheck.m2814a(i, i2, i3, i4);
        }
        return i;
    }

    public View onFocusSearchFailed(View view, int i, C0709p c0709p, C0715u c0715u) {
        resolveShouldLayoutReverse();
        if (getChildCount() == null) {
            return null;
        }
        view = convertFocusDirectionToLayoutDirection(i);
        if (view == -2147483648) {
            return null;
        }
        ensureLayoutState();
        ensureLayoutState();
        updateLayoutState(view, (int) (((float) this.mOrientationHelper.mo656f()) * MAX_SCROLL_FACTOR), false, c0715u);
        this.mLayoutState.f1789g = INVALID_OFFSET;
        this.mLayoutState.f1783a = false;
        fill(c0709p, this.mLayoutState, c0715u, true);
        if (view == -1) {
            c0709p = findPartiallyOrCompletelyInvisibleChildClosestToStart(c0709p, c0715u);
        } else {
            c0709p = findPartiallyOrCompletelyInvisibleChildClosestToEnd(c0709p, c0715u);
        }
        if (view == -1) {
            view = getChildClosestToStart();
        } else {
            view = getChildClosestToEnd();
        }
        if (view.hasFocusable() == 0) {
            return c0709p;
        }
        if (c0709p == null) {
            return null;
        }
        return view;
    }

    private void logChildren() {
        Log.d(TAG, "internal representation of views on the screen");
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("item ");
            stringBuilder.append(getPosition(childAt));
            stringBuilder.append(", coord:");
            stringBuilder.append(this.mOrientationHelper.mo647a(childAt));
            Log.d(str, stringBuilder.toString());
        }
        Log.d(TAG, "==============");
    }

    void validateChildOrder() {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("validating child count ");
        stringBuilder.append(getChildCount());
        Log.d(str, stringBuilder.toString());
        if (getChildCount() >= 1) {
            boolean z = false;
            int position = getPosition(getChildAt(0));
            int a = this.mOrientationHelper.mo647a(getChildAt(0));
            int i;
            View childAt;
            int position2;
            int a2;
            StringBuilder stringBuilder2;
            if (this.mShouldReverseLayout) {
                i = 1;
                while (i < getChildCount()) {
                    childAt = getChildAt(i);
                    position2 = getPosition(childAt);
                    a2 = this.mOrientationHelper.mo647a(childAt);
                    if (position2 < position) {
                        logChildren();
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("detected invalid position. loc invalid? ");
                        if (a2 < a) {
                            z = true;
                        }
                        stringBuilder2.append(z);
                        throw new RuntimeException(stringBuilder2.toString());
                    } else if (a2 <= a) {
                        i++;
                    } else {
                        logChildren();
                        throw new RuntimeException("detected invalid location");
                    }
                }
            }
            i = 1;
            while (i < getChildCount()) {
                childAt = getChildAt(i);
                position2 = getPosition(childAt);
                a2 = this.mOrientationHelper.mo647a(childAt);
                if (position2 < position) {
                    logChildren();
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("detected invalid position. loc invalid? ");
                    if (a2 < a) {
                        z = true;
                    }
                    stringBuilder2.append(z);
                    throw new RuntimeException(stringBuilder2.toString());
                } else if (a2 >= a) {
                    i++;
                } else {
                    logChildren();
                    throw new RuntimeException("detected invalid location");
                }
            }
        }
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd;
    }

    public void prepareForDrop(View view, View view2, int i, int i2) {
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        resolveShouldLayoutReverse();
        i = getPosition(view);
        i2 = getPosition(view2);
        i = i < i2 ? 1 : -1;
        if (this.mShouldReverseLayout) {
            if (i == 1) {
                scrollToPositionWithOffset(i2, this.mOrientationHelper.mo652d() - (this.mOrientationHelper.mo647a(view2) + this.mOrientationHelper.mo655e(view)));
            } else {
                scrollToPositionWithOffset(i2, this.mOrientationHelper.mo652d() - this.mOrientationHelper.mo649b(view2));
            }
        } else if (i == -1) {
            scrollToPositionWithOffset(i2, this.mOrientationHelper.mo647a(view2));
        } else {
            scrollToPositionWithOffset(i2, this.mOrientationHelper.mo649b(view2) - this.mOrientationHelper.mo655e(view));
        }
    }
}
