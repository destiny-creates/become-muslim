package android.support.v4.view;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.content.C0366b;
import android.support.v4.view.p033a.C0483b;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.Utility;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager extends ViewGroup {
    private static final int CLOSE_ENOUGH = 2;
    private static final Comparator<C0470b> COMPARATOR = new C04661();
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = -1;
    static final int[] LAYOUT_ATTRS = new int[]{16842931};
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private static final boolean USE_CACHE = false;
    private static final Interpolator sInterpolator = new C04672();
    private static final C0477j sPositionComparator = new C0477j();
    private int mActivePointerId = -1;
    C0513q mAdapter;
    private List<C0472e> mAdapterChangeListeners;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList<View> mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable = new C04683(this);
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout = true;
    private float mFirstOffset = -3.4028235E38f;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private C0473f mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsScrollStarted;
    private boolean mIsUnableToDrag;
    private final ArrayList<C0470b> mItems = new ArrayList();
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset = Float.MAX_VALUE;
    private EdgeEffect mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets = false;
    private C0475h mObserver;
    private int mOffscreenPageLimit = 1;
    private C0473f mOnPageChangeListener;
    private List<C0473f> mOnPageChangeListeners;
    private int mPageMargin;
    private C0474g mPageTransformer;
    private int mPageTransformerLayerType;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState = null;
    private ClassLoader mRestoredClassLoader = null;
    private int mRestoredCurItem = -1;
    private EdgeEffect mRightEdge;
    private int mScrollState = 0;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private final C0470b mTempItem = new C0470b();
    private final Rect mTempRect = new Rect();
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    /* renamed from: android.support.v4.view.ViewPager$1 */
    static class C04661 implements Comparator<C0470b> {
        C04661() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m1484a((C0470b) obj, (C0470b) obj2);
        }

        /* renamed from: a */
        public int m1484a(C0470b c0470b, C0470b c0470b2) {
            return c0470b.f1207b - c0470b2.f1207b;
        }
    }

    /* renamed from: android.support.v4.view.ViewPager$2 */
    static class C04672 implements Interpolator {
        public float getInterpolation(float f) {
            f -= 1.0f;
            return ((((f * f) * f) * f) * f) + 1.0f;
        }

        C04672() {
        }
    }

    /* renamed from: android.support.v4.view.ViewPager$3 */
    class C04683 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ ViewPager f1205a;

        C04683(ViewPager viewPager) {
            this.f1205a = viewPager;
        }

        public void run() {
            this.f1205a.setScrollState(0);
            this.f1205a.populate();
        }
    }

    @Inherited
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: android.support.v4.view.ViewPager$a */
    public @interface C0469a {
    }

    /* renamed from: android.support.v4.view.ViewPager$b */
    static class C0470b {
        /* renamed from: a */
        Object f1206a;
        /* renamed from: b */
        int f1207b;
        /* renamed from: c */
        boolean f1208c;
        /* renamed from: d */
        float f1209d;
        /* renamed from: e */
        float f1210e;

        C0470b() {
        }
    }

    /* renamed from: android.support.v4.view.ViewPager$c */
    public static class C0471c extends LayoutParams {
        /* renamed from: a */
        public boolean f1211a;
        /* renamed from: b */
        public int f1212b;
        /* renamed from: c */
        float f1213c = 0.0f;
        /* renamed from: d */
        boolean f1214d;
        /* renamed from: e */
        int f1215e;
        /* renamed from: f */
        int f1216f;

        public C0471c() {
            super(-1, -1);
        }

        public C0471c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            context = context.obtainStyledAttributes(attributeSet, ViewPager.LAYOUT_ATTRS);
            this.f1212b = context.getInteger(null, 48);
            context.recycle();
        }
    }

    /* renamed from: android.support.v4.view.ViewPager$e */
    public interface C0472e {
        /* renamed from: a */
        void m1485a(ViewPager viewPager, C0513q c0513q, C0513q c0513q2);
    }

    /* renamed from: android.support.v4.view.ViewPager$f */
    public interface C0473f {
        void onPageScrollStateChanged(int i);

        void onPageScrolled(int i, float f, int i2);

        void onPageSelected(int i);
    }

    /* renamed from: android.support.v4.view.ViewPager$g */
    public interface C0474g {
        /* renamed from: a */
        void m1486a(View view, float f);
    }

    /* renamed from: android.support.v4.view.ViewPager$h */
    private class C0475h extends DataSetObserver {
        /* renamed from: a */
        final /* synthetic */ ViewPager f1217a;

        C0475h(ViewPager viewPager) {
            this.f1217a = viewPager;
        }

        public void onChanged() {
            this.f1217a.dataSetChanged();
        }

        public void onInvalidated() {
            this.f1217a.dataSetChanged();
        }
    }

    /* renamed from: android.support.v4.view.ViewPager$j */
    static class C0477j implements Comparator<View> {
        C0477j() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m1490a((View) obj, (View) obj2);
        }

        /* renamed from: a */
        public int m1490a(View view, View view2) {
            C0471c c0471c = (C0471c) view.getLayoutParams();
            C0471c c0471c2 = (C0471c) view2.getLayoutParams();
            if (c0471c.f1211a == c0471c2.f1211a) {
                return c0471c.f1215e - c0471c2.f1215e;
            }
            return c0471c.f1211a != null ? true : -1;
        }
    }

    /* renamed from: android.support.v4.view.ViewPager$4 */
    class C32134 implements C0512p {
        /* renamed from: a */
        final /* synthetic */ ViewPager f8268a;
        /* renamed from: b */
        private final Rect f8269b = new Rect();

        C32134(ViewPager viewPager) {
            this.f8268a = viewPager;
        }

        /* renamed from: a */
        public aa mo63a(View view, aa aaVar) {
            aa a = C0517s.m1686a(view, aaVar);
            if (a.m1566e() != null) {
                return a;
            }
            aaVar = this.f8269b;
            aaVar.left = a.m1561a();
            aaVar.top = a.m1563b();
            aaVar.right = a.m1564c();
            aaVar.bottom = a.m1565d();
            int childCount = this.f8268a.getChildCount();
            for (int i = 0; i < childCount; i++) {
                aa b = C0517s.m1702b(this.f8268a.getChildAt(i), a);
                aaVar.left = Math.min(b.m1561a(), aaVar.left);
                aaVar.top = Math.min(b.m1563b(), aaVar.top);
                aaVar.right = Math.min(b.m1564c(), aaVar.right);
                aaVar.bottom = Math.min(b.m1565d(), aaVar.bottom);
            }
            return a.m1562a(aaVar.left, aaVar.top, aaVar.right, aaVar.bottom);
        }
    }

    /* renamed from: android.support.v4.view.ViewPager$d */
    class C3214d extends C0494b {
        /* renamed from: a */
        final /* synthetic */ ViewPager f8270a;

        C3214d(ViewPager viewPager) {
            this.f8270a = viewPager;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(m9779a());
            if (accessibilityEvent.getEventType() == 4096 && this.f8270a.mAdapter != null) {
                accessibilityEvent.setItemCount(this.f8270a.mAdapter.getCount());
                accessibilityEvent.setFromIndex(this.f8270a.mCurItem);
                accessibilityEvent.setToIndex(this.f8270a.mCurItem);
            }
        }

        public void onInitializeAccessibilityNodeInfo(View view, C0483b c0483b) {
            super.onInitializeAccessibilityNodeInfo(view, c0483b);
            c0483b.m1512b(ViewPager.class.getName());
            c0483b.m1539k(m9779a());
            if (this.f8270a.canScrollHorizontally(1) != null) {
                c0483b.m1502a(4096);
            }
            if (this.f8270a.canScrollHorizontally(-1) != null) {
                c0483b.m1502a((int) Utility.DEFAULT_STREAM_BUFFER_SIZE);
            }
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle) != null) {
                return true;
            }
            if (i != 4096) {
                if (i != Utility.DEFAULT_STREAM_BUFFER_SIZE || this.f8270a.canScrollHorizontally(-1) == null) {
                    return false;
                }
                this.f8270a.setCurrentItem(this.f8270a.mCurItem - 1);
                return true;
            } else if (this.f8270a.canScrollHorizontally(1) == null) {
                return false;
            } else {
                this.f8270a.setCurrentItem(this.f8270a.mCurItem + 1);
                return true;
            }
        }

        /* renamed from: a */
        private boolean m9779a() {
            return this.f8270a.mAdapter != null && this.f8270a.mAdapter.getCount() > 1;
        }
    }

    /* renamed from: android.support.v4.view.ViewPager$i */
    public static class C3215i extends C0487a {
        public static final Creator<C3215i> CREATOR = new C04761();
        /* renamed from: a */
        int f8271a;
        /* renamed from: b */
        Parcelable f8272b;
        /* renamed from: c */
        ClassLoader f8273c;

        /* renamed from: android.support.v4.view.ViewPager$i$1 */
        static class C04761 implements ClassLoaderCreator<C3215i> {
            C04761() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m1487a(parcel);
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return m1488a(parcel, classLoader);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m1489a(i);
            }

            /* renamed from: a */
            public C3215i m1488a(Parcel parcel, ClassLoader classLoader) {
                return new C3215i(parcel, classLoader);
            }

            /* renamed from: a */
            public C3215i m1487a(Parcel parcel) {
                return new C3215i(parcel, null);
            }

            /* renamed from: a */
            public C3215i[] m1489a(int i) {
                return new C3215i[i];
            }
        }

        public C3215i(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f8271a);
            parcel.writeParcelable(this.f8272b, i);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("FragmentPager.SavedState{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" position=");
            stringBuilder.append(this.f8271a);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }

        C3215i(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                classLoader = getClass().getClassLoader();
            }
            this.f8271a = parcel.readInt();
            this.f8272b = parcel.readParcelable(classLoader);
            this.f8273c = classLoader;
        }
    }

    public ViewPager(Context context) {
        super(context);
        initViewPager();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initViewPager();
    }

    void initViewPager() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
        this.mMinimumVelocity = (int) (400.0f * f);
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new EdgeEffect(context);
        this.mRightEdge = new EdgeEffect(context);
        this.mFlingDistance = (int) (25.0f * f);
        this.mCloseEnough = (int) (2.0f * f);
        this.mDefaultGutterSize = (int) (f * 16.0f);
        C0517s.m1695a((View) this, new C3214d(this));
        if (C0517s.m1709d(this) == 0) {
            C0517s.m1688a((View) this, 1);
        }
        C0517s.m1696a((View) this, new C32134(this));
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.mEndScrollRunnable);
        if (!(this.mScroller == null || this.mScroller.isFinished())) {
            this.mScroller.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    void setScrollState(int i) {
        if (this.mScrollState != i) {
            this.mScrollState = i;
            if (this.mPageTransformer != null) {
                enableLayers(i != 0);
            }
            dispatchOnScrollStateChanged(i);
        }
    }

    public void setAdapter(C0513q c0513q) {
        int i = 0;
        if (this.mAdapter != null) {
            this.mAdapter.setViewPagerObserver(null);
            this.mAdapter.startUpdate((ViewGroup) this);
            for (int i2 = 0; i2 < this.mItems.size(); i2++) {
                C0470b c0470b = (C0470b) this.mItems.get(i2);
                this.mAdapter.destroyItem((ViewGroup) this, c0470b.f1207b, c0470b.f1206a);
            }
            this.mAdapter.finishUpdate((ViewGroup) this);
            this.mItems.clear();
            removeNonDecorViews();
            this.mCurItem = 0;
            scrollTo(0, 0);
        }
        C0513q c0513q2 = this.mAdapter;
        this.mAdapter = c0513q;
        this.mExpectedAdapterCount = 0;
        if (this.mAdapter != null) {
            if (this.mObserver == null) {
                this.mObserver = new C0475h(this);
            }
            this.mAdapter.setViewPagerObserver(this.mObserver);
            this.mPopulatePending = false;
            boolean z = this.mFirstLayout;
            this.mFirstLayout = true;
            this.mExpectedAdapterCount = this.mAdapter.getCount();
            if (this.mRestoredCurItem >= 0) {
                this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
                setCurrentItemInternal(this.mRestoredCurItem, false, true);
                this.mRestoredCurItem = -1;
                this.mRestoredAdapterState = null;
                this.mRestoredClassLoader = null;
            } else if (z) {
                requestLayout();
            } else {
                populate();
            }
        }
        if (this.mAdapterChangeListeners != null && !this.mAdapterChangeListeners.isEmpty()) {
            int size = this.mAdapterChangeListeners.size();
            while (i < size) {
                ((C0472e) this.mAdapterChangeListeners.get(i)).m1485a(this, c0513q2, c0513q);
                i++;
            }
        }
    }

    private void removeNonDecorViews() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((C0471c) getChildAt(i).getLayoutParams()).f1211a) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    public C0513q getAdapter() {
        return this.mAdapter;
    }

    public void addOnAdapterChangeListener(C0472e c0472e) {
        if (this.mAdapterChangeListeners == null) {
            this.mAdapterChangeListeners = new ArrayList();
        }
        this.mAdapterChangeListeners.add(c0472e);
    }

    public void removeOnAdapterChangeListener(C0472e c0472e) {
        if (this.mAdapterChangeListeners != null) {
            this.mAdapterChangeListeners.remove(c0472e);
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int i) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i, this.mFirstLayout ^ 1, false);
    }

    public void setCurrentItem(int i, boolean z) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i, z, false);
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    void setCurrentItemInternal(int i, boolean z, boolean z2) {
        setCurrentItemInternal(i, z, z2, 0);
    }

    void setCurrentItemInternal(int i, boolean z, boolean z2, int i2) {
        if (this.mAdapter != null) {
            if (this.mAdapter.getCount() > 0) {
                if (!z2 && this.mCurItem == i && this.mItems.size()) {
                    setScrollingCacheEnabled(false);
                    return;
                }
                z2 = true;
                if (i < 0) {
                    i = 0;
                } else if (i >= this.mAdapter.getCount()) {
                    i = this.mAdapter.getCount() - 1;
                }
                int i3 = this.mOffscreenPageLimit;
                if (i > this.mCurItem + i3 || i < this.mCurItem - i3) {
                    for (i3 = 0; i3 < this.mItems.size(); i3++) {
                        ((C0470b) this.mItems.get(i3)).f1208c = true;
                    }
                }
                if (this.mCurItem == i) {
                    z2 = false;
                }
                if (this.mFirstLayout) {
                    this.mCurItem = i;
                    if (z2) {
                        dispatchOnPageSelected(i);
                    }
                    requestLayout();
                } else {
                    populate(i);
                    scrollToItem(i, z, i2, z2);
                }
                return;
            }
        }
        setScrollingCacheEnabled(false);
    }

    private void scrollToItem(int i, boolean z, int i2, boolean z2) {
        C0470b infoForPosition = infoForPosition(i);
        int clientWidth = infoForPosition != null ? (int) (((float) getClientWidth()) * Math.max(this.mFirstOffset, Math.min(infoForPosition.f1210e, this.mLastOffset))) : 0;
        if (z) {
            smoothScrollTo(clientWidth, 0, i2);
            if (z2) {
                dispatchOnPageSelected(i);
                return;
            }
            return;
        }
        if (z2) {
            dispatchOnPageSelected(i);
        }
        completeScroll(false);
        scrollTo(clientWidth, 0);
        pageScrolled(clientWidth);
    }

    @Deprecated
    public void setOnPageChangeListener(C0473f c0473f) {
        this.mOnPageChangeListener = c0473f;
    }

    public void addOnPageChangeListener(C0473f c0473f) {
        if (this.mOnPageChangeListeners == null) {
            this.mOnPageChangeListeners = new ArrayList();
        }
        this.mOnPageChangeListeners.add(c0473f);
    }

    public void removeOnPageChangeListener(C0473f c0473f) {
        if (this.mOnPageChangeListeners != null) {
            this.mOnPageChangeListeners.remove(c0473f);
        }
    }

    public void clearOnPageChangeListeners() {
        if (this.mOnPageChangeListeners != null) {
            this.mOnPageChangeListeners.clear();
        }
    }

    public void setPageTransformer(boolean z, C0474g c0474g) {
        setPageTransformer(z, c0474g, 2);
    }

    public void setPageTransformer(boolean z, C0474g c0474g, int i) {
        int i2 = 1;
        boolean z2 = c0474g != null;
        Object obj = z2 != (this.mPageTransformer != null) ? 1 : null;
        this.mPageTransformer = c0474g;
        setChildrenDrawingOrderEnabled(z2);
        if (z2) {
            if (z) {
                i2 = 2;
            }
            this.mDrawingOrder = i2;
            this.mPageTransformerLayerType = i;
        } else {
            this.mDrawingOrder = 0;
        }
        if (obj != null) {
            populate();
        }
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.mDrawingOrder == 2) {
            i2 = (i - 1) - i2;
        }
        return ((C0471c) ((View) this.mDrawingOrderedChildren.get(i2)).getLayoutParams()).f1216f;
    }

    C0473f setInternalPageChangeListener(C0473f c0473f) {
        C0473f c0473f2 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = c0473f;
        return c0473f2;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Requested offscreen page limit ");
            stringBuilder.append(i);
            stringBuilder.append(" too small; defaulting to ");
            stringBuilder.append(1);
            Log.w(str, stringBuilder.toString());
            i = 1;
        }
        if (i != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = i;
            populate();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.mPageMargin;
        this.mPageMargin = i;
        int width = getWidth();
        recomputeScrollPosition(width, width, i, i2);
        requestLayout();
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.mMarginDrawable = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null ? true : null);
        invalidate();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(C0366b.m1103a(getContext(), i));
    }

    protected boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable)) {
            if (drawable != this.mMarginDrawable) {
                return null;
            }
        }
        return true;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mMarginDrawable;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    float distanceInfluenceForSnapDuration(float f) {
        return (float) Math.sin((double) ((f - 0.5f) * 0.47123894f));
    }

    void smoothScrollTo(int i, int i2) {
        smoothScrollTo(i, i2, 0);
    }

    void smoothScrollTo(int i, int i2, int i3) {
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int currX;
        Object obj = (this.mScroller == null || this.mScroller.isFinished()) ? null : 1;
        if (obj != null) {
            currX = this.mIsScrollStarted ? this.mScroller.getCurrX() : this.mScroller.getStartX();
            this.mScroller.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            currX = getScrollX();
        }
        int i4 = currX;
        int scrollY = getScrollY();
        int i5 = i - i4;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            completeScroll(false);
            populate();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        i = getClientWidth();
        i2 = i / 2;
        i = (float) i;
        i2 = (float) i2;
        i2 += distanceInfluenceForSnapDuration(Math.min(1.0f, (((float) Math.abs(i5)) * 1.0f) / i)) * i2;
        i3 = Math.abs(i3);
        if (i3 > 0) {
            i = Math.round(Math.abs(i2 / ((float) i3)) * 1148846080) * 4;
        } else {
            i = (int) (((((float) Math.abs(i5)) / ((i * this.mAdapter.getPageWidth(this.mCurItem)) + ((float) this.mPageMargin))) + 1065353216) * 1120403456);
        }
        int min = Math.min(i, MAX_SETTLE_DURATION);
        this.mIsScrollStarted = false;
        this.mScroller.startScroll(i4, scrollY, i5, i6, min);
        C0517s.m1706c(this);
    }

    C0470b addNewItem(int i, int i2) {
        C0470b c0470b = new C0470b();
        c0470b.f1207b = i;
        c0470b.f1206a = this.mAdapter.instantiateItem((ViewGroup) this, i);
        c0470b.f1209d = this.mAdapter.getPageWidth(i);
        if (i2 >= 0) {
            if (i2 < this.mItems.size()) {
                this.mItems.add(i2, c0470b);
                return c0470b;
            }
        }
        this.mItems.add(c0470b);
        return c0470b;
    }

    void dataSetChanged() {
        int count = this.mAdapter.getCount();
        this.mExpectedAdapterCount = count;
        Object obj = (this.mItems.size() >= (this.mOffscreenPageLimit * 2) + 1 || this.mItems.size() >= count) ? null : 1;
        Object obj2 = obj;
        int i = this.mCurItem;
        int i2 = 0;
        Object obj3 = null;
        while (i2 < this.mItems.size()) {
            C0470b c0470b = (C0470b) this.mItems.get(i2);
            int itemPosition = this.mAdapter.getItemPosition(c0470b.f1206a);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.mItems.remove(i2);
                    i2--;
                    if (obj3 == null) {
                        this.mAdapter.startUpdate((ViewGroup) this);
                        obj3 = 1;
                    }
                    this.mAdapter.destroyItem((ViewGroup) this, c0470b.f1207b, c0470b.f1206a);
                    if (this.mCurItem == c0470b.f1207b) {
                        i = Math.max(0, Math.min(this.mCurItem, count - 1));
                    }
                } else if (c0470b.f1207b != itemPosition) {
                    if (c0470b.f1207b == this.mCurItem) {
                        i = itemPosition;
                    }
                    c0470b.f1207b = itemPosition;
                }
                obj2 = 1;
            }
            i2++;
        }
        if (obj3 != null) {
            this.mAdapter.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.mItems, COMPARATOR);
        if (obj2 != null) {
            count = getChildCount();
            for (i2 = 0; i2 < count; i2++) {
                C0471c c0471c = (C0471c) getChildAt(i2).getLayoutParams();
                if (!c0471c.f1211a) {
                    c0471c.f1213c = 0.0f;
                }
            }
            setCurrentItemInternal(i, false, true);
            requestLayout();
        }
    }

    void populate() {
        populate(this.mCurItem);
    }

    void populate(int r18) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r17 = this;
        r0 = r17;
        r1 = r18;
        r2 = r0.mCurItem;
        if (r2 == r1) goto L_0x0011;
    L_0x0008:
        r2 = r0.mCurItem;
        r2 = r0.infoForPosition(r2);
        r0.mCurItem = r1;
        goto L_0x0012;
    L_0x0011:
        r2 = 0;
    L_0x0012:
        r1 = r0.mAdapter;
        if (r1 != 0) goto L_0x001a;
    L_0x0016:
        r17.sortChildDrawingOrder();
        return;
    L_0x001a:
        r1 = r0.mPopulatePending;
        if (r1 == 0) goto L_0x0022;
    L_0x001e:
        r17.sortChildDrawingOrder();
        return;
    L_0x0022:
        r1 = r17.getWindowToken();
        if (r1 != 0) goto L_0x0029;
    L_0x0028:
        return;
    L_0x0029:
        r1 = r0.mAdapter;
        r1.startUpdate(r0);
        r1 = r0.mOffscreenPageLimit;
        r4 = r0.mCurItem;
        r4 = r4 - r1;
        r5 = 0;
        r4 = java.lang.Math.max(r5, r4);
        r6 = r0.mAdapter;
        r6 = r6.getCount();
        r7 = r6 + -1;
        r8 = r0.mCurItem;
        r8 = r8 + r1;
        r1 = java.lang.Math.min(r7, r8);
        r7 = r0.mExpectedAdapterCount;
        if (r6 != r7) goto L_0x0216;
    L_0x004b:
        r7 = 0;
    L_0x004c:
        r8 = r0.mItems;
        r8 = r8.size();
        if (r7 >= r8) goto L_0x006c;
    L_0x0054:
        r8 = r0.mItems;
        r8 = r8.get(r7);
        r8 = (android.support.v4.view.ViewPager.C0470b) r8;
        r9 = r8.f1207b;
        r10 = r0.mCurItem;
        if (r9 < r10) goto L_0x0069;
    L_0x0062:
        r9 = r8.f1207b;
        r10 = r0.mCurItem;
        if (r9 != r10) goto L_0x006c;
    L_0x0068:
        goto L_0x006d;
    L_0x0069:
        r7 = r7 + 1;
        goto L_0x004c;
    L_0x006c:
        r8 = 0;
    L_0x006d:
        if (r8 != 0) goto L_0x0077;
    L_0x006f:
        if (r6 <= 0) goto L_0x0077;
    L_0x0071:
        r8 = r0.mCurItem;
        r8 = r0.addNewItem(r8, r7);
    L_0x0077:
        r9 = 0;
        if (r8 == 0) goto L_0x01a3;
    L_0x007a:
        r10 = r7 + -1;
        if (r10 < 0) goto L_0x0087;
    L_0x007e:
        r11 = r0.mItems;
        r11 = r11.get(r10);
        r11 = (android.support.v4.view.ViewPager.C0470b) r11;
        goto L_0x0088;
    L_0x0087:
        r11 = 0;
    L_0x0088:
        r12 = r17.getClientWidth();
        r13 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r12 > 0) goto L_0x0092;
    L_0x0090:
        r3 = 0;
        goto L_0x009f;
    L_0x0092:
        r14 = r8.f1209d;
        r14 = r13 - r14;
        r15 = r17.getPaddingLeft();
        r15 = (float) r15;
        r3 = (float) r12;
        r15 = r15 / r3;
        r3 = r14 + r15;
    L_0x009f:
        r14 = r0.mCurItem;
        r14 = r14 + -1;
        r15 = r7;
        r7 = 0;
    L_0x00a5:
        if (r14 < 0) goto L_0x0105;
    L_0x00a7:
        r16 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1));
        if (r16 < 0) goto L_0x00d3;
    L_0x00ab:
        if (r14 >= r4) goto L_0x00d3;
    L_0x00ad:
        if (r11 != 0) goto L_0x00b0;
    L_0x00af:
        goto L_0x0105;
    L_0x00b0:
        r5 = r11.f1207b;
        if (r14 != r5) goto L_0x0101;
    L_0x00b4:
        r5 = r11.f1208c;
        if (r5 != 0) goto L_0x0101;
    L_0x00b8:
        r5 = r0.mItems;
        r5.remove(r10);
        r5 = r0.mAdapter;
        r11 = r11.f1206a;
        r5.destroyItem(r0, r14, r11);
        r10 = r10 + -1;
        r15 = r15 + -1;
        if (r10 < 0) goto L_0x00ff;
    L_0x00ca:
        r5 = r0.mItems;
        r5 = r5.get(r10);
        r5 = (android.support.v4.view.ViewPager.C0470b) r5;
        goto L_0x0100;
    L_0x00d3:
        if (r11 == 0) goto L_0x00e9;
    L_0x00d5:
        r5 = r11.f1207b;
        if (r14 != r5) goto L_0x00e9;
    L_0x00d9:
        r5 = r11.f1209d;
        r7 = r7 + r5;
        r10 = r10 + -1;
        if (r10 < 0) goto L_0x00ff;
    L_0x00e0:
        r5 = r0.mItems;
        r5 = r5.get(r10);
        r5 = (android.support.v4.view.ViewPager.C0470b) r5;
        goto L_0x0100;
    L_0x00e9:
        r5 = r10 + 1;
        r5 = r0.addNewItem(r14, r5);
        r5 = r5.f1209d;
        r7 = r7 + r5;
        r15 = r15 + 1;
        if (r10 < 0) goto L_0x00ff;
    L_0x00f6:
        r5 = r0.mItems;
        r5 = r5.get(r10);
        r5 = (android.support.v4.view.ViewPager.C0470b) r5;
        goto L_0x0100;
    L_0x00ff:
        r5 = 0;
    L_0x0100:
        r11 = r5;
    L_0x0101:
        r14 = r14 + -1;
        r5 = 0;
        goto L_0x00a5;
    L_0x0105:
        r3 = r8.f1209d;
        r4 = r15 + 1;
        r5 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1));
        if (r5 >= 0) goto L_0x0197;
    L_0x010d:
        r5 = r0.mItems;
        r5 = r5.size();
        if (r4 >= r5) goto L_0x011e;
    L_0x0115:
        r5 = r0.mItems;
        r5 = r5.get(r4);
        r5 = (android.support.v4.view.ViewPager.C0470b) r5;
        goto L_0x011f;
    L_0x011e:
        r5 = 0;
    L_0x011f:
        if (r12 > 0) goto L_0x0123;
    L_0x0121:
        r7 = 0;
        goto L_0x012b;
    L_0x0123:
        r7 = r17.getPaddingRight();
        r7 = (float) r7;
        r10 = (float) r12;
        r7 = r7 / r10;
        r7 = r7 + r13;
    L_0x012b:
        r10 = r0.mCurItem;
    L_0x012d:
        r10 = r10 + 1;
        if (r10 >= r6) goto L_0x0197;
    L_0x0131:
        r11 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1));
        if (r11 < 0) goto L_0x0161;
    L_0x0135:
        if (r10 <= r1) goto L_0x0161;
    L_0x0137:
        if (r5 != 0) goto L_0x013a;
    L_0x0139:
        goto L_0x0197;
    L_0x013a:
        r11 = r5.f1207b;
        if (r10 != r11) goto L_0x0196;
    L_0x013e:
        r11 = r5.f1208c;
        if (r11 != 0) goto L_0x0196;
    L_0x0142:
        r11 = r0.mItems;
        r11.remove(r4);
        r11 = r0.mAdapter;
        r5 = r5.f1206a;
        r11.destroyItem(r0, r10, r5);
        r5 = r0.mItems;
        r5 = r5.size();
        if (r4 >= r5) goto L_0x015f;
    L_0x0156:
        r5 = r0.mItems;
        r5 = r5.get(r4);
        r5 = (android.support.v4.view.ViewPager.C0470b) r5;
        goto L_0x0196;
    L_0x015f:
        r5 = 0;
        goto L_0x0196;
    L_0x0161:
        if (r5 == 0) goto L_0x017d;
    L_0x0163:
        r11 = r5.f1207b;
        if (r10 != r11) goto L_0x017d;
    L_0x0167:
        r5 = r5.f1209d;
        r3 = r3 + r5;
        r4 = r4 + 1;
        r5 = r0.mItems;
        r5 = r5.size();
        if (r4 >= r5) goto L_0x015f;
    L_0x0174:
        r5 = r0.mItems;
        r5 = r5.get(r4);
        r5 = (android.support.v4.view.ViewPager.C0470b) r5;
        goto L_0x0196;
    L_0x017d:
        r5 = r0.addNewItem(r10, r4);
        r4 = r4 + 1;
        r5 = r5.f1209d;
        r3 = r3 + r5;
        r5 = r0.mItems;
        r5 = r5.size();
        if (r4 >= r5) goto L_0x015f;
    L_0x018e:
        r5 = r0.mItems;
        r5 = r5.get(r4);
        r5 = (android.support.v4.view.ViewPager.C0470b) r5;
    L_0x0196:
        goto L_0x012d;
    L_0x0197:
        r0.calculatePageOffsets(r8, r15, r2);
        r1 = r0.mAdapter;
        r2 = r0.mCurItem;
        r3 = r8.f1206a;
        r1.setPrimaryItem(r0, r2, r3);
    L_0x01a3:
        r1 = r0.mAdapter;
        r1.finishUpdate(r0);
        r1 = r17.getChildCount();
        r2 = 0;
    L_0x01ad:
        if (r2 >= r1) goto L_0x01d6;
    L_0x01af:
        r3 = r0.getChildAt(r2);
        r4 = r3.getLayoutParams();
        r4 = (android.support.v4.view.ViewPager.C0471c) r4;
        r4.f1216f = r2;
        r5 = r4.f1211a;
        if (r5 != 0) goto L_0x01d3;
    L_0x01bf:
        r5 = r4.f1213c;
        r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1));
        if (r5 != 0) goto L_0x01d3;
    L_0x01c5:
        r3 = r0.infoForChild(r3);
        if (r3 == 0) goto L_0x01d3;
    L_0x01cb:
        r5 = r3.f1209d;
        r4.f1213c = r5;
        r3 = r3.f1207b;
        r4.f1215e = r3;
    L_0x01d3:
        r2 = r2 + 1;
        goto L_0x01ad;
    L_0x01d6:
        r17.sortChildDrawingOrder();
        r1 = r17.hasFocus();
        if (r1 == 0) goto L_0x0215;
    L_0x01df:
        r1 = r17.findFocus();
        if (r1 == 0) goto L_0x01ea;
    L_0x01e5:
        r3 = r0.infoForAnyChild(r1);
        goto L_0x01eb;
    L_0x01ea:
        r3 = 0;
    L_0x01eb:
        if (r3 == 0) goto L_0x01f3;
    L_0x01ed:
        r1 = r3.f1207b;
        r2 = r0.mCurItem;
        if (r1 == r2) goto L_0x0215;
    L_0x01f3:
        r1 = 0;
    L_0x01f4:
        r2 = r17.getChildCount();
        if (r1 >= r2) goto L_0x0215;
    L_0x01fa:
        r2 = r0.getChildAt(r1);
        r3 = r0.infoForChild(r2);
        if (r3 == 0) goto L_0x0212;
    L_0x0204:
        r3 = r3.f1207b;
        r4 = r0.mCurItem;
        if (r3 != r4) goto L_0x0212;
    L_0x020a:
        r3 = 2;
        r2 = r2.requestFocus(r3);
        if (r2 == 0) goto L_0x0212;
    L_0x0211:
        goto L_0x0215;
    L_0x0212:
        r1 = r1 + 1;
        goto L_0x01f4;
    L_0x0215:
        return;
    L_0x0216:
        r1 = r17.getResources();	 Catch:{ NotFoundException -> 0x0223 }
        r2 = r17.getId();	 Catch:{ NotFoundException -> 0x0223 }
        r1 = r1.getResourceName(r2);	 Catch:{ NotFoundException -> 0x0223 }
        goto L_0x022b;
    L_0x0223:
        r1 = r17.getId();
        r1 = java.lang.Integer.toHexString(r1);
    L_0x022b:
        r2 = new java.lang.IllegalStateException;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ";
        r3.append(r4);
        r4 = r0.mExpectedAdapterCount;
        r3.append(r4);
        r4 = ", found: ";
        r3.append(r4);
        r3.append(r6);
        r4 = " Pager id: ";
        r3.append(r4);
        r3.append(r1);
        r1 = " Pager class: ";
        r3.append(r1);
        r1 = r17.getClass();
        r3.append(r1);
        r1 = " Problematic adapter: ";
        r3.append(r1);
        r1 = r0.mAdapter;
        r1 = r1.getClass();
        r3.append(r1);
        r1 = r3.toString();
        r2.<init>(r1);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.populate(int):void");
    }

    private void sortChildDrawingOrder() {
        if (this.mDrawingOrder != 0) {
            if (this.mDrawingOrderedChildren == null) {
                this.mDrawingOrderedChildren = new ArrayList();
            } else {
                this.mDrawingOrderedChildren.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.mDrawingOrderedChildren.add(getChildAt(i));
            }
            Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
        }
    }

    private void calculatePageOffsets(C0470b c0470b, int i, C0470b c0470b2) {
        int size;
        int count = this.mAdapter.getCount();
        int clientWidth = getClientWidth();
        float f = clientWidth > 0 ? ((float) this.mPageMargin) / ((float) clientWidth) : 0.0f;
        if (c0470b2 != null) {
            int i2 = c0470b2.f1207b;
            C0470b c0470b3;
            if (i2 < c0470b.f1207b) {
                float f2 = (c0470b2.f1210e + c0470b2.f1209d) + f;
                i2++;
                c0470b2 = null;
                while (i2 <= c0470b.f1207b && c0470b2 < this.mItems.size()) {
                    c0470b3 = (C0470b) this.mItems.get(c0470b2);
                    while (i2 > c0470b3.f1207b && c0470b2 < this.mItems.size() - 1) {
                        c0470b2++;
                        c0470b3 = (C0470b) this.mItems.get(c0470b2);
                    }
                    while (i2 < c0470b3.f1207b) {
                        f2 += this.mAdapter.getPageWidth(i2) + f;
                        i2++;
                    }
                    c0470b3.f1210e = f2;
                    f2 += c0470b3.f1209d + f;
                    i2++;
                }
            } else if (i2 > c0470b.f1207b) {
                size = this.mItems.size() - 1;
                c0470b2 = c0470b2.f1210e;
                i2--;
                while (i2 >= c0470b.f1207b && size >= 0) {
                    c0470b3 = (C0470b) this.mItems.get(size);
                    while (i2 < c0470b3.f1207b && size > 0) {
                        size--;
                        c0470b3 = (C0470b) this.mItems.get(size);
                    }
                    while (i2 > c0470b3.f1207b) {
                        c0470b2 -= this.mAdapter.getPageWidth(i2) + f;
                        i2--;
                    }
                    c0470b2 -= c0470b3.f1209d + f;
                    c0470b3.f1210e = c0470b2;
                    i2--;
                }
            }
        }
        c0470b2 = this.mItems.size();
        float f3 = c0470b.f1210e;
        size = c0470b.f1207b - 1;
        this.mFirstOffset = c0470b.f1207b == 0 ? c0470b.f1210e : -3.4028235E38f;
        count--;
        this.mLastOffset = c0470b.f1207b == count ? (c0470b.f1210e + c0470b.f1209d) - 1.0f : Float.MAX_VALUE;
        int i3 = i - 1;
        while (i3 >= 0) {
            C0470b c0470b4 = (C0470b) this.mItems.get(i3);
            while (size > c0470b4.f1207b) {
                f3 -= this.mAdapter.getPageWidth(size) + f;
                size--;
            }
            f3 -= c0470b4.f1209d + f;
            c0470b4.f1210e = f3;
            if (c0470b4.f1207b == 0) {
                this.mFirstOffset = f3;
            }
            i3--;
            size--;
        }
        f3 = (c0470b.f1210e + c0470b.f1209d) + f;
        c0470b = c0470b.f1207b + 1;
        i++;
        while (i < c0470b2) {
            C0470b c0470b5 = (C0470b) this.mItems.get(i);
            while (c0470b < c0470b5.f1207b) {
                f3 += this.mAdapter.getPageWidth(c0470b) + f;
                c0470b++;
            }
            if (c0470b5.f1207b == count) {
                this.mLastOffset = (c0470b5.f1209d + f3) - 1.0f;
            }
            c0470b5.f1210e = f3;
            f3 += c0470b5.f1209d + f;
            i++;
            c0470b++;
        }
        this.mNeedCalculatePageOffsets = false;
    }

    public Parcelable onSaveInstanceState() {
        Parcelable c3215i = new C3215i(super.onSaveInstanceState());
        c3215i.f8271a = this.mCurItem;
        if (this.mAdapter != null) {
            c3215i.f8272b = this.mAdapter.saveState();
        }
        return c3215i;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C3215i) {
            C3215i c3215i = (C3215i) parcelable;
            super.onRestoreInstanceState(c3215i.m1558a());
            if (this.mAdapter != null) {
                this.mAdapter.restoreState(c3215i.f8272b, c3215i.f8273c);
                setCurrentItemInternal(c3215i.f8271a, false, true);
            } else {
                this.mRestoredCurItem = c3215i.f8271a;
                this.mRestoredAdapterState = c3215i.f8272b;
                this.mRestoredClassLoader = c3215i.f8273c;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        C0471c c0471c = (C0471c) layoutParams;
        c0471c.f1211a |= isDecorView(view);
        if (this.mInLayout) {
            if (c0471c != null) {
                if (c0471c.f1211a) {
                    throw new IllegalStateException("Cannot add pager decor view during layout");
                }
            }
            c0471c.f1214d = true;
            addViewInLayout(view, i, layoutParams);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    private static boolean isDecorView(View view) {
        return view.getClass().getAnnotation(C0469a.class) != null ? true : null;
    }

    public void removeView(View view) {
        if (this.mInLayout) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    C0470b infoForChild(View view) {
        for (int i = 0; i < this.mItems.size(); i++) {
            C0470b c0470b = (C0470b) this.mItems.get(i);
            if (this.mAdapter.isViewFromObject(view, c0470b.f1206a)) {
                return c0470b;
            }
        }
        return null;
    }

    C0470b infoForAnyChild(View view) {
        while (true) {
            View parent = view.getParent();
            if (parent == this) {
                return infoForChild(view);
            }
            if (parent == null) {
                break;
            } else if ((parent instanceof View) == null) {
                break;
            } else {
                view = parent;
            }
        }
        return null;
    }

    C0470b infoForPosition(int i) {
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            C0470b c0470b = (C0470b) this.mItems.get(i2);
            if (c0470b.f1207b == i) {
                return c0470b;
            }
        }
        return 0;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.mGutterSize = Math.min(measuredWidth / 10, this.mDefaultGutterSize);
        measuredWidth = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i4 = measuredHeight;
        measuredHeight = measuredWidth;
        measuredWidth = 0;
        while (true) {
            boolean z = true;
            int i5 = 1073741824;
            if (measuredWidth >= childCount) {
                break;
            }
            View childAt = getChildAt(measuredWidth);
            if (childAt.getVisibility() != 8) {
                C0471c c0471c = (C0471c) childAt.getLayoutParams();
                if (c0471c != null && c0471c.f1211a) {
                    Object obj;
                    int i6;
                    int i7;
                    int i8 = c0471c.f1212b & 7;
                    int i9 = c0471c.f1212b & 112;
                    if (i9 != 48) {
                        if (i9 != 80) {
                            obj = null;
                            if (i8 != 3) {
                                if (i8 == 5) {
                                    z = false;
                                }
                            }
                            i8 = LinearLayoutManager.INVALID_OFFSET;
                            if (obj != null) {
                                i8 = 1073741824;
                            } else if (z) {
                                i6 = 1073741824;
                                if (c0471c.width == -2) {
                                    i7 = c0471c.width == -1 ? c0471c.width : measuredHeight;
                                    i8 = 1073741824;
                                } else {
                                    i7 = measuredHeight;
                                }
                                if (c0471c.height != -2) {
                                    i3 = c0471c.height == -1 ? c0471c.height : i4;
                                } else {
                                    i3 = i4;
                                    i5 = i6;
                                }
                                childAt.measure(MeasureSpec.makeMeasureSpec(i7, i8), MeasureSpec.makeMeasureSpec(i3, i5));
                                if (obj == null) {
                                    i4 -= childAt.getMeasuredHeight();
                                } else if (!z) {
                                    measuredHeight -= childAt.getMeasuredWidth();
                                }
                            }
                            i6 = LinearLayoutManager.INVALID_OFFSET;
                            if (c0471c.width == -2) {
                                i7 = measuredHeight;
                            } else {
                                if (c0471c.width == -1) {
                                }
                                i8 = 1073741824;
                            }
                            if (c0471c.height != -2) {
                                i3 = i4;
                                i5 = i6;
                            } else if (c0471c.height == -1) {
                            }
                            childAt.measure(MeasureSpec.makeMeasureSpec(i7, i8), MeasureSpec.makeMeasureSpec(i3, i5));
                            if (obj == null) {
                                i4 -= childAt.getMeasuredHeight();
                            } else if (!z) {
                                measuredHeight -= childAt.getMeasuredWidth();
                            }
                        }
                    }
                    obj = 1;
                    if (i8 != 3) {
                        if (i8 == 5) {
                            z = false;
                        }
                    }
                    i8 = LinearLayoutManager.INVALID_OFFSET;
                    if (obj != null) {
                        i8 = 1073741824;
                    } else if (z) {
                        i6 = 1073741824;
                        if (c0471c.width == -2) {
                            if (c0471c.width == -1) {
                            }
                            i8 = 1073741824;
                        } else {
                            i7 = measuredHeight;
                        }
                        if (c0471c.height != -2) {
                            i3 = i4;
                            i5 = i6;
                        } else if (c0471c.height == -1) {
                        }
                        childAt.measure(MeasureSpec.makeMeasureSpec(i7, i8), MeasureSpec.makeMeasureSpec(i3, i5));
                        if (obj == null) {
                            i4 -= childAt.getMeasuredHeight();
                        } else if (!z) {
                            measuredHeight -= childAt.getMeasuredWidth();
                        }
                    }
                    i6 = LinearLayoutManager.INVALID_OFFSET;
                    if (c0471c.width == -2) {
                        i7 = measuredHeight;
                    } else {
                        if (c0471c.width == -1) {
                        }
                        i8 = 1073741824;
                    }
                    if (c0471c.height != -2) {
                        i3 = i4;
                        i5 = i6;
                    } else if (c0471c.height == -1) {
                    }
                    childAt.measure(MeasureSpec.makeMeasureSpec(i7, i8), MeasureSpec.makeMeasureSpec(i3, i5));
                    if (obj == null) {
                        i4 -= childAt.getMeasuredHeight();
                    } else if (!z) {
                        measuredHeight -= childAt.getMeasuredWidth();
                    }
                }
            }
            measuredWidth++;
        }
        r0.mChildWidthMeasureSpec = MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        r0.mChildHeightMeasureSpec = MeasureSpec.makeMeasureSpec(i4, 1073741824);
        r0.mInLayout = true;
        populate();
        i3 = 0;
        r0.mInLayout = false;
        measuredWidth = getChildCount();
        while (i3 < measuredWidth) {
            View childAt2 = getChildAt(i3);
            if (childAt2.getVisibility() != 8) {
                C0471c c0471c2 = (C0471c) childAt2.getLayoutParams();
                if (c0471c2 == null || !c0471c2.f1211a) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (((float) measuredHeight) * c0471c2.f1213c), 1073741824), r0.mChildHeightMeasureSpec);
                }
            }
            i3++;
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            recomputeScrollPosition(i, i3, this.mPageMargin, this.mPageMargin);
        }
    }

    private void recomputeScrollPosition(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.mItems.isEmpty()) {
            i2 = infoForPosition(this.mCurItem);
            i = (int) ((i2 != 0 ? Math.min(i2.f1210e, this.mLastOffset) : 0) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (i != getScrollX()) {
                completeScroll(0);
                scrollTo(i, getScrollY());
            }
        } else if (this.mScroller.isFinished()) {
            scrollTo((int) ((((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4))) * ((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3))), getScrollY());
        } else {
            this.mScroller.setFinalX(getCurrentItem() * getClientWidth());
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        ViewPager viewPager = this;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i7 = paddingBottom;
        int i8 = 0;
        paddingBottom = paddingTop;
        paddingTop = paddingLeft;
        for (paddingLeft = 0; paddingLeft < childCount; paddingLeft++) {
            View childAt = getChildAt(paddingLeft);
            if (childAt.getVisibility() != 8) {
                C0471c c0471c = (C0471c) childAt.getLayoutParams();
                if (c0471c.f1211a) {
                    int i9 = c0471c.f1212b & 7;
                    int i10 = c0471c.f1212b & 112;
                    if (i9 == 1) {
                        i9 = Math.max((i5 - childAt.getMeasuredWidth()) / 2, paddingTop);
                    } else if (i9 == 3) {
                        i9 = paddingTop;
                        paddingTop = childAt.getMeasuredWidth() + paddingTop;
                    } else if (i9 != 5) {
                        i9 = paddingTop;
                    } else {
                        i9 = (i5 - paddingRight) - childAt.getMeasuredWidth();
                        paddingRight += childAt.getMeasuredWidth();
                    }
                    if (i10 == 16) {
                        i10 = Math.max((i6 - childAt.getMeasuredHeight()) / 2, paddingBottom);
                    } else if (i10 == 48) {
                        i10 = paddingBottom;
                        paddingBottom = childAt.getMeasuredHeight() + paddingBottom;
                    } else if (i10 != 80) {
                        i10 = paddingBottom;
                    } else {
                        i10 = (i6 - i7) - childAt.getMeasuredHeight();
                        i7 += childAt.getMeasuredHeight();
                    }
                    i9 += scrollX;
                    childAt.layout(i9, i10, childAt.getMeasuredWidth() + i9, i10 + childAt.getMeasuredHeight());
                    i8++;
                }
            }
        }
        i5 = (i5 - paddingTop) - paddingRight;
        for (paddingLeft = 0; paddingLeft < childCount; paddingLeft++) {
            View childAt2 = getChildAt(paddingLeft);
            if (childAt2.getVisibility() != 8) {
                C0471c c0471c2 = (C0471c) childAt2.getLayoutParams();
                if (!c0471c2.f1211a) {
                    C0470b infoForChild = infoForChild(childAt2);
                    if (infoForChild != null) {
                        float f = (float) i5;
                        int i11 = ((int) (infoForChild.f1210e * f)) + paddingTop;
                        if (c0471c2.f1214d) {
                            c0471c2.f1214d = false;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((int) (f * c0471c2.f1213c), 1073741824), MeasureSpec.makeMeasureSpec((i6 - paddingBottom) - i7, 1073741824));
                        }
                        childAt2.layout(i11, paddingBottom, childAt2.getMeasuredWidth() + i11, childAt2.getMeasuredHeight() + paddingBottom);
                    }
                }
            }
        }
        viewPager.mTopPageBounds = paddingBottom;
        viewPager.mBottomPageBounds = i6 - i7;
        viewPager.mDecorChildCount = i8;
        if (viewPager.mFirstLayout) {
            z2 = false;
            scrollToItem(viewPager.mCurItem, false, 0, false);
        } else {
            z2 = false;
        }
        viewPager.mFirstLayout = z2;
    }

    public void computeScroll() {
        this.mIsScrollStarted = true;
        if (this.mScroller.isFinished() || !this.mScroller.computeScrollOffset()) {
            completeScroll(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.mScroller.getCurrX();
        int currY = this.mScroller.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!pageScrolled(currX)) {
                this.mScroller.abortAnimation();
                scrollTo(0, currY);
            }
        }
        C0517s.m1706c(this);
    }

    private boolean pageScrolled(int i) {
        if (this.mItems.size() != 0) {
            C0470b infoForCurrentScrollPosition = infoForCurrentScrollPosition();
            int clientWidth = getClientWidth();
            int i2 = this.mPageMargin + clientWidth;
            float f = (float) clientWidth;
            float f2 = ((float) this.mPageMargin) / f;
            int i3 = infoForCurrentScrollPosition.f1207b;
            i = ((((float) i) / f) - infoForCurrentScrollPosition.f1210e) / (infoForCurrentScrollPosition.f1209d + f2);
            int i4 = (int) (((float) i2) * i);
            this.mCalledSuper = false;
            onPageScrolled(i3, i, i4);
            if (this.mCalledSuper != 0) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else if (this.mFirstLayout != 0) {
            return false;
        } else {
            this.mCalledSuper = false;
            onPageScrolled(0, 0, 0);
            if (this.mCalledSuper != 0) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    protected void onPageScrolled(int i, float f, int i2) {
        if (this.mDecorChildCount > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            int i3 = paddingRight;
            paddingRight = paddingLeft;
            for (paddingLeft = 0; paddingLeft < childCount; paddingLeft++) {
                View childAt = getChildAt(paddingLeft);
                C0471c c0471c = (C0471c) childAt.getLayoutParams();
                if (c0471c.f1211a) {
                    int i4 = c0471c.f1212b & 7;
                    if (i4 != 1) {
                        if (i4 == 3) {
                            i4 = childAt.getWidth() + paddingRight;
                        } else if (i4 != 5) {
                            i4 = paddingRight;
                        } else {
                            i4 = (width - i3) - childAt.getMeasuredWidth();
                            i3 += childAt.getMeasuredWidth();
                        }
                        paddingRight = (paddingRight + scrollX) - childAt.getLeft();
                        if (paddingRight != 0) {
                            childAt.offsetLeftAndRight(paddingRight);
                        }
                        paddingRight = i4;
                    } else {
                        i4 = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingRight);
                    }
                    int i5 = i4;
                    i4 = paddingRight;
                    paddingRight = i5;
                    paddingRight = (paddingRight + scrollX) - childAt.getLeft();
                    if (paddingRight != 0) {
                        childAt.offsetLeftAndRight(paddingRight);
                    }
                    paddingRight = i4;
                }
            }
        }
        dispatchOnPageScrolled(i, f, i2);
        if (this.mPageTransformer != 0) {
            i = getScrollX();
            int childCount2 = getChildCount();
            for (int i6 = 0; i6 < childCount2; i6++) {
                i2 = getChildAt(i6);
                if (!((C0471c) i2.getLayoutParams()).f1211a) {
                    this.mPageTransformer.m1486a(i2, ((float) (i2.getLeft() - i)) / ((float) getClientWidth()));
                }
            }
        }
        this.mCalledSuper = true;
    }

    private void dispatchOnPageScrolled(int i, float f, int i2) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
        if (this.mOnPageChangeListeners != null) {
            int size = this.mOnPageChangeListeners.size();
            for (int i3 = 0; i3 < size; i3++) {
                C0473f c0473f = (C0473f) this.mOnPageChangeListeners.get(i3);
                if (c0473f != null) {
                    c0473f.onPageScrolled(i, f, i2);
                }
            }
        }
        if (this.mInternalPageChangeListener != null) {
            this.mInternalPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    private void dispatchOnPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        if (this.mOnPageChangeListeners != null) {
            int size = this.mOnPageChangeListeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0473f c0473f = (C0473f) this.mOnPageChangeListeners.get(i2);
                if (c0473f != null) {
                    c0473f.onPageSelected(i);
                }
            }
        }
        if (this.mInternalPageChangeListener != null) {
            this.mInternalPageChangeListener.onPageSelected(i);
        }
    }

    private void dispatchOnScrollStateChanged(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrollStateChanged(i);
        }
        if (this.mOnPageChangeListeners != null) {
            int size = this.mOnPageChangeListeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0473f c0473f = (C0473f) this.mOnPageChangeListeners.get(i2);
                if (c0473f != null) {
                    c0473f.onPageScrollStateChanged(i);
                }
            }
        }
        if (this.mInternalPageChangeListener != null) {
            this.mInternalPageChangeListener.onPageScrollStateChanged(i);
        }
    }

    private void completeScroll(boolean z) {
        Object obj = this.mScrollState == 2 ? 1 : null;
        if (obj != null) {
            setScrollingCacheEnabled(false);
            if ((this.mScroller.isFinished() ^ 1) != 0) {
                this.mScroller.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        pageScrolled(currX);
                    }
                }
            }
        }
        this.mPopulatePending = false;
        Object obj2 = obj;
        for (int i = 0; i < this.mItems.size(); i++) {
            C0470b c0470b = (C0470b) this.mItems.get(i);
            if (c0470b.f1208c) {
                c0470b.f1208c = false;
                obj2 = 1;
            }
        }
        if (obj2 == null) {
            return;
        }
        if (z) {
            C0517s.m1697a((View) this, this.mEndScrollRunnable);
        } else {
            this.mEndScrollRunnable.run();
        }
    }

    private boolean isGutterDrag(float f, float f2) {
        return (f < ((float) this.mGutterSize) && f2 > 0.0f) || (f > ((float) (getWidth() - this.mGutterSize)) && f2 < 0.0f);
    }

    private void enableLayers(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setLayerType(z ? this.mPageTransformerLayerType : 0, null);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ViewPager viewPager = this;
        MotionEvent motionEvent2 = motionEvent;
        int action = motionEvent.getAction() & JfifUtil.MARKER_FIRST_BYTE;
        if (action != 3) {
            if (action != 1) {
                if (action != 0) {
                    if (viewPager.mIsBeingDragged) {
                        return true;
                    }
                    if (viewPager.mIsUnableToDrag) {
                        return false;
                    }
                }
                if (action == 0) {
                    float x = motionEvent.getX();
                    viewPager.mInitialMotionX = x;
                    viewPager.mLastMotionX = x;
                    x = motionEvent.getY();
                    viewPager.mInitialMotionY = x;
                    viewPager.mLastMotionY = x;
                    viewPager.mActivePointerId = motionEvent2.getPointerId(0);
                    viewPager.mIsUnableToDrag = false;
                    viewPager.mIsScrollStarted = true;
                    viewPager.mScroller.computeScrollOffset();
                    if (viewPager.mScrollState != 2 || Math.abs(viewPager.mScroller.getFinalX() - viewPager.mScroller.getCurrX()) <= viewPager.mCloseEnough) {
                        completeScroll(false);
                        viewPager.mIsBeingDragged = false;
                    } else {
                        viewPager.mScroller.abortAnimation();
                        viewPager.mPopulatePending = false;
                        populate();
                        viewPager.mIsBeingDragged = true;
                        requestParentDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                    }
                } else if (action == 2) {
                    action = viewPager.mActivePointerId;
                    if (action != -1) {
                        action = motionEvent2.findPointerIndex(action);
                        float x2 = motionEvent2.getX(action);
                        float f = x2 - viewPager.mLastMotionX;
                        float abs = Math.abs(f);
                        float y = motionEvent2.getY(action);
                        float abs2 = Math.abs(y - viewPager.mInitialMotionY);
                        int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
                        if (i == 0 || isGutterDrag(viewPager.mLastMotionX, f) || !canScroll(this, false, (int) f, (int) x2, (int) y)) {
                            if (abs > ((float) viewPager.mTouchSlop) && abs * 0.5f > abs2) {
                                viewPager.mIsBeingDragged = true;
                                requestParentDisallowInterceptTouchEvent(true);
                                setScrollState(1);
                                viewPager.mLastMotionX = i > 0 ? viewPager.mInitialMotionX + ((float) viewPager.mTouchSlop) : viewPager.mInitialMotionX - ((float) viewPager.mTouchSlop);
                                viewPager.mLastMotionY = y;
                                setScrollingCacheEnabled(true);
                            } else if (abs2 > ((float) viewPager.mTouchSlop)) {
                                viewPager.mIsUnableToDrag = true;
                            }
                            if (viewPager.mIsBeingDragged && performDrag(x2)) {
                                C0517s.m1706c(this);
                            }
                        } else {
                            viewPager.mLastMotionX = x2;
                            viewPager.mLastMotionY = y;
                            viewPager.mIsUnableToDrag = true;
                            return false;
                        }
                    }
                } else if (action == 6) {
                    onSecondaryPointerUp(motionEvent);
                }
                if (viewPager.mVelocityTracker == null) {
                    viewPager.mVelocityTracker = VelocityTracker.obtain();
                }
                viewPager.mVelocityTracker.addMovement(motionEvent2);
                return viewPager.mIsBeingDragged;
            }
        }
        resetTouch();
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mFakeDragging) {
            return true;
        }
        boolean z = false;
        if ((motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) && this.mAdapter != null) {
            if (this.mAdapter.getCount() != 0) {
                if (this.mVelocityTracker == null) {
                    this.mVelocityTracker = VelocityTracker.obtain();
                }
                this.mVelocityTracker.addMovement(motionEvent);
                float x;
                int xVelocity;
                switch (motionEvent.getAction() & JfifUtil.MARKER_FIRST_BYTE) {
                    case 0:
                        this.mScroller.abortAnimation();
                        this.mPopulatePending = false;
                        populate();
                        x = motionEvent.getX();
                        this.mInitialMotionX = x;
                        this.mLastMotionX = x;
                        x = motionEvent.getY();
                        this.mInitialMotionY = x;
                        this.mLastMotionY = x;
                        this.mActivePointerId = motionEvent.getPointerId(0);
                        break;
                    case 1:
                        if (this.mIsBeingDragged) {
                            VelocityTracker velocityTracker = this.mVelocityTracker;
                            velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
                            xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
                            this.mPopulatePending = true;
                            int clientWidth = getClientWidth();
                            int scrollX = getScrollX();
                            C0470b infoForCurrentScrollPosition = infoForCurrentScrollPosition();
                            float f = (float) clientWidth;
                            setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.f1207b, ((((float) scrollX) / f) - infoForCurrentScrollPosition.f1210e) / (infoForCurrentScrollPosition.f1209d + (((float) this.mPageMargin) / f)), xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)) - this.mInitialMotionX)), true, true, xVelocity);
                            z = resetTouch();
                            break;
                        }
                        break;
                    case 2:
                        if (!this.mIsBeingDragged) {
                            xVelocity = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (xVelocity == -1) {
                                z = resetTouch();
                                break;
                            }
                            float x2 = motionEvent.getX(xVelocity);
                            float abs = Math.abs(x2 - this.mLastMotionX);
                            x = motionEvent.getY(xVelocity);
                            float abs2 = Math.abs(x - this.mLastMotionY);
                            if (abs > ((float) this.mTouchSlop) && abs > abs2) {
                                this.mIsBeingDragged = true;
                                requestParentDisallowInterceptTouchEvent(true);
                                this.mLastMotionX = x2 - this.mInitialMotionX > 0.0f ? this.mInitialMotionX + ((float) this.mTouchSlop) : this.mInitialMotionX - ((float) this.mTouchSlop);
                                this.mLastMotionY = x;
                                setScrollState(1);
                                setScrollingCacheEnabled(true);
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                        if (this.mIsBeingDragged) {
                            z = false | performDrag(motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)));
                            break;
                        }
                        break;
                    case 3:
                        if (this.mIsBeingDragged != null) {
                            scrollToItem(this.mCurItem, true, 0, false);
                            z = resetTouch();
                            break;
                        }
                        break;
                    case 5:
                        xVelocity = motionEvent.getActionIndex();
                        this.mLastMotionX = motionEvent.getX(xVelocity);
                        this.mActivePointerId = motionEvent.getPointerId(xVelocity);
                        break;
                    case 6:
                        onSecondaryPointerUp(motionEvent);
                        this.mLastMotionX = motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId));
                        break;
                    default:
                        break;
                }
                if (z) {
                    C0517s.m1706c(this);
                }
                return true;
            }
        }
        return false;
    }

    private boolean resetTouch() {
        this.mActivePointerId = -1;
        endDrag();
        this.mLeftEdge.onRelease();
        this.mRightEdge.onRelease();
        if (!this.mLeftEdge.isFinished()) {
            if (!this.mRightEdge.isFinished()) {
                return false;
            }
        }
        return true;
    }

    private void requestParentDisallowInterceptTouchEvent(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean performDrag(float f) {
        Object obj;
        Object obj2;
        float f2 = this.mLastMotionX - f;
        this.mLastMotionX = f;
        f = ((float) getScrollX()) + f2;
        f2 = (float) getClientWidth();
        float f3 = this.mFirstOffset * f2;
        float f4 = this.mLastOffset * f2;
        boolean z = false;
        C0470b c0470b = (C0470b) this.mItems.get(0);
        C0470b c0470b2 = (C0470b) this.mItems.get(this.mItems.size() - 1);
        if (c0470b.f1207b != 0) {
            f3 = c0470b.f1210e * f2;
            obj = null;
        } else {
            obj = 1;
        }
        if (c0470b2.f1207b != this.mAdapter.getCount() - 1) {
            f4 = c0470b2.f1210e * f2;
            obj2 = null;
        } else {
            obj2 = 1;
        }
        if (f < f3) {
            if (obj != null) {
                this.mLeftEdge.onPull(Math.abs(f3 - f) / f2);
                z = true;
            }
            f = f3;
        } else if (f > f4) {
            if (obj2 != null) {
                this.mRightEdge.onPull(Math.abs(f - f4) / f2);
                z = true;
            }
            f = f4;
        }
        int i = (int) f;
        this.mLastMotionX += f - ((float) i);
        scrollTo(i, getScrollY());
        pageScrolled(i);
        return z;
    }

    private C0470b infoForCurrentScrollPosition() {
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        float f = clientWidth > 0 ? ((float) this.mPageMargin) / ((float) clientWidth) : 0.0f;
        C0470b c0470b = null;
        int i = 0;
        Object obj = 1;
        int i2 = -1;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (i < this.mItems.size()) {
            C0470b c0470b2 = (C0470b) this.mItems.get(i);
            if (obj == null) {
                i2++;
                if (c0470b2.f1207b != i2) {
                    c0470b2 = this.mTempItem;
                    c0470b2.f1210e = (f2 + f3) + f;
                    c0470b2.f1207b = i2;
                    c0470b2.f1209d = this.mAdapter.getPageWidth(c0470b2.f1207b);
                    i--;
                }
            }
            f2 = c0470b2.f1210e;
            float f4 = (c0470b2.f1209d + f2) + f;
            if (obj == null) {
                if (scrollX < f2) {
                    return c0470b;
                }
            }
            if (scrollX >= f4) {
                if (i != this.mItems.size() - 1) {
                    i2 = c0470b2.f1207b;
                    f3 = c0470b2.f1209d;
                    i++;
                    c0470b = c0470b2;
                    obj = null;
                }
            }
            return c0470b2;
        }
        return c0470b;
    }

    private int determineTargetPage(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.mFlingDistance || Math.abs(i2) <= this.mMinimumVelocity) {
            i += (int) (f + (i >= this.mCurItem ? 1053609165 : 1058642330));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.mItems.size() <= null) {
            return i;
        }
        return Math.max(((C0470b) this.mItems.get(0)).f1207b, Math.min(i, ((C0470b) this.mItems.get(this.mItems.size() - 1)).f1207b));
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        int i = 0;
        if (overScrollMode != 0) {
            if (overScrollMode != 1 || this.mAdapter == null || this.mAdapter.getCount() <= 1) {
                this.mLeftEdge.finish();
                this.mRightEdge.finish();
                if (i != 0) {
                    C0517s.m1706c(this);
                }
            }
        }
        if (!this.mLeftEdge.isFinished()) {
            overScrollMode = canvas.save();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int width = getWidth();
            canvas.rotate(270.0f);
            canvas.translate((float) ((-height) + getPaddingTop()), this.mFirstOffset * ((float) width));
            this.mLeftEdge.setSize(height, width);
            i = 0 | this.mLeftEdge.draw(canvas);
            canvas.restoreToCount(overScrollMode);
        }
        if (!this.mRightEdge.isFinished()) {
            overScrollMode = canvas.save();
            height = getWidth();
            width = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(90.0f);
            canvas.translate((float) (-getPaddingTop()), (-(this.mLastOffset + 1.0f)) * ((float) height));
            this.mRightEdge.setSize(width, height);
            i |= this.mRightEdge.draw(canvas);
            canvas.restoreToCount(overScrollMode);
        }
        if (i != 0) {
            C0517s.m1706c(this);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mPageMargin > 0 && r0.mMarginDrawable != null && r0.mItems.size() > 0 && r0.mAdapter != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f = (float) width;
            float f2 = ((float) r0.mPageMargin) / f;
            int i = 0;
            C0470b c0470b = (C0470b) r0.mItems.get(0);
            float f3 = c0470b.f1210e;
            int size = r0.mItems.size();
            int i2 = c0470b.f1207b;
            int i3 = ((C0470b) r0.mItems.get(size - 1)).f1207b;
            while (i2 < i3) {
                float f4;
                float f5;
                while (i2 > c0470b.f1207b && i < size) {
                    i++;
                    c0470b = (C0470b) r0.mItems.get(i);
                }
                if (i2 == c0470b.f1207b) {
                    f3 = (c0470b.f1210e + c0470b.f1209d) * f;
                    f4 = (c0470b.f1210e + c0470b.f1209d) + f2;
                } else {
                    f4 = r0.mAdapter.getPageWidth(i2);
                    f4 = f3 + (f4 + f2);
                    f3 = (f3 + f4) * f;
                }
                if (((float) r0.mPageMargin) + f3 > ((float) scrollX)) {
                    f5 = f2;
                    r0.mMarginDrawable.setBounds(Math.round(f3), r0.mTopPageBounds, Math.round(((float) r0.mPageMargin) + f3), r0.mBottomPageBounds);
                    r0.mMarginDrawable.draw(canvas);
                } else {
                    Canvas canvas2 = canvas;
                    f5 = f2;
                }
                if (f3 <= ((float) (scrollX + width))) {
                    i2++;
                    f3 = f4;
                    f2 = f5;
                } else {
                    return;
                }
            }
        }
    }

    public boolean beginFakeDrag() {
        if (this.mIsBeingDragged) {
            return false;
        }
        this.mFakeDragging = true;
        setScrollState(1);
        this.mLastMotionX = 0.0f;
        this.mInitialMotionX = 0.0f;
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            this.mVelocityTracker.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
        this.mVelocityTracker.addMovement(obtain);
        obtain.recycle();
        this.mFakeDragBeginTime = uptimeMillis;
        return true;
    }

    public void endFakeDrag() {
        if (this.mFakeDragging) {
            if (this.mAdapter != null) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
                int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
                this.mPopulatePending = true;
                int clientWidth = getClientWidth();
                int scrollX = getScrollX();
                C0470b infoForCurrentScrollPosition = infoForCurrentScrollPosition();
                setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.f1207b, ((((float) scrollX) / ((float) clientWidth)) - infoForCurrentScrollPosition.f1210e) / infoForCurrentScrollPosition.f1209d, xVelocity, (int) (this.mLastMotionX - this.mInitialMotionX)), true, true, xVelocity);
            }
            endDrag();
            this.mFakeDragging = false;
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public void fakeDragBy(float f) {
        if (!this.mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        } else if (this.mAdapter != null) {
            this.mLastMotionX += f;
            float scrollX = ((float) getScrollX()) - f;
            f = (float) getClientWidth();
            float f2 = this.mFirstOffset * f;
            float f3 = this.mLastOffset * f;
            C0470b c0470b = (C0470b) this.mItems.get(0);
            C0470b c0470b2 = (C0470b) this.mItems.get(this.mItems.size() - 1);
            if (c0470b.f1207b != 0) {
                f2 = c0470b.f1210e * f;
            }
            if (c0470b2.f1207b != this.mAdapter.getCount() - 1) {
                f3 = c0470b2.f1210e * f;
            }
            if (scrollX < f2) {
                scrollX = f2;
            } else if (scrollX > f3) {
                scrollX = f3;
            }
            int i = (int) scrollX;
            this.mLastMotionX += scrollX - ((float) i);
            scrollTo(i, getScrollY());
            pageScrolled(i);
            f = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), 2, this.mLastMotionX, 0.0f, 0);
            this.mVelocityTracker.addMovement(f);
            f.recycle();
        }
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            actionIndex = actionIndex == 0 ? 1 : 0;
            this.mLastMotionX = motionEvent.getX(actionIndex);
            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
            if (this.mVelocityTracker != null) {
                this.mVelocityTracker.clear();
            }
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.mScrollingCacheEnabled != z) {
            this.mScrollingCacheEnabled = z;
        }
    }

    public boolean canScrollHorizontally(int i) {
        boolean z = false;
        if (this.mAdapter == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX > ((int) (((float) clientWidth) * this.mFirstOffset))) {
                z = true;
            }
            return z;
        } else if (i <= 0) {
            return false;
        } else {
            if (scrollX < ((int) (((float) clientWidth) * this.mLastOffset))) {
                z = true;
            }
            return z;
        }
    }

    protected boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        View view2 = view;
        boolean z2 = true;
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i4 = i2 + scrollX;
                if (i4 >= childAt.getLeft() && i4 < childAt.getRight()) {
                    int i5 = i3 + scrollY;
                    if (i5 >= childAt.getTop() && i5 < childAt.getBottom()) {
                        if (canScroll(childAt, true, i, i4 - childAt.getLeft(), i5 - childAt.getTop())) {
                            return true;
                        }
                    }
                }
            }
        }
        if (!z || !view.canScrollHorizontally(-i)) {
            z2 = false;
        }
        return z2;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!super.dispatchKeyEvent(keyEvent)) {
            if (executeKeyEvent(keyEvent) == null) {
                return null;
            }
        }
        return true;
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 61) {
                switch (keyCode) {
                    case 21:
                        if (keyEvent.hasModifiers(2) != null) {
                            return pageLeft();
                        }
                        return arrowScroll(17);
                    case 22:
                        if (keyEvent.hasModifiers(2) != null) {
                            return pageRight();
                        }
                        return arrowScroll(66);
                    default:
                        break;
                }
            } else if (keyEvent.hasNoModifiers()) {
                return arrowScroll(2);
            } else {
                if (keyEvent.hasModifiers(1) != null) {
                    return arrowScroll(1);
                }
            }
        }
        return null;
    }

    public boolean arrowScroll(int i) {
        View findFocus = findFocus();
        boolean z = false;
        View view = null;
        if (findFocus != this) {
            if (findFocus != null) {
                Object obj;
                for (ViewPager parent = findFocus.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                    if (parent == this) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        stringBuilder.append(" => ");
                        stringBuilder.append(parent2.getClass().getSimpleName());
                    }
                    String str = TAG;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("arrowScroll tried to find focus based on non-child current focused view ");
                    stringBuilder2.append(stringBuilder.toString());
                    Log.e(str, stringBuilder2.toString());
                }
            }
            view = findFocus;
        }
        findFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findFocus == null || findFocus == view) {
            if (i != 17) {
                if (i != 1) {
                    if (i == 66 || i == 2) {
                        z = pageRight();
                    }
                }
            }
            z = pageLeft();
        } else {
            boolean requestFocus;
            int i2;
            int i3;
            if (i == 17) {
                i2 = getChildRectInPagerCoordinates(this.mTempRect, findFocus).left;
                i3 = getChildRectInPagerCoordinates(this.mTempRect, view).left;
                if (view == null || i2 < i3) {
                    requestFocus = findFocus.requestFocus();
                } else {
                    requestFocus = pageLeft();
                }
            } else if (i == 66) {
                i2 = getChildRectInPagerCoordinates(this.mTempRect, findFocus).left;
                i3 = getChildRectInPagerCoordinates(this.mTempRect, view).left;
                if (view == null || i2 > i3) {
                    requestFocus = findFocus.requestFocus();
                } else {
                    requestFocus = pageRight();
                }
            }
            z = requestFocus;
        }
        if (z) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return z;
    }

    private Rect getChildRectInPagerCoordinates(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        view = view.getParent();
        while ((view instanceof ViewGroup) && view != this) {
            ViewGroup viewGroup = (ViewGroup) view;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            view = viewGroup.getParent();
        }
        return rect;
    }

    boolean pageLeft() {
        if (this.mCurItem <= 0) {
            return false;
        }
        setCurrentItem(this.mCurItem - 1, true);
        return true;
    }

    boolean pageRight() {
        if (this.mAdapter == null || this.mCurItem >= this.mAdapter.getCount() - 1) {
            return false;
        }
        setCurrentItem(this.mCurItem + 1, true);
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    C0470b infoForChild = infoForChild(childAt);
                    if (infoForChild != null && infoForChild.f1207b == this.mCurItem) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || isFocusable() == 0) {
            return;
        }
        if (!(((i2 & 1) == 1 && isInTouchMode() != 0 && isFocusableInTouchMode() == 0) || arrayList == null)) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                C0470b infoForChild = infoForChild(childAt);
                if (infoForChild != null && infoForChild.f1207b == this.mCurItem) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int childCount = getChildCount();
        int i3 = -1;
        if ((i & 2) != 0) {
            i3 = childCount;
            childCount = 0;
            i2 = 1;
        } else {
            childCount--;
            i2 = -1;
        }
        while (childCount != i3) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                C0470b infoForChild = infoForChild(childAt);
                if (infoForChild != null && infoForChild.f1207b == this.mCurItem && childAt.requestFocus(i, rect)) {
                    return true;
                }
            }
            childCount += i2;
        }
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                C0470b infoForChild = infoForChild(childAt);
                if (infoForChild != null && infoForChild.f1207b == this.mCurItem && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new C0471c();
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (!(layoutParams instanceof C0471c) || super.checkLayoutParams(layoutParams) == null) ? null : true;
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0471c(getContext(), attributeSet);
    }
}
