package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.p030f.C0397h;
import android.support.v4.util.C0462k;
import android.support.v4.view.C0487a;
import android.support.v4.view.C0507i;
import android.support.v4.view.C0509l;
import android.support.v4.view.C0517s;
import android.support.v4.view.C0518t;
import android.support.v4.view.C3226k;
import android.support.v4.view.p033a.C0479a;
import android.support.v4.view.p033a.C0483b;
import android.support.v4.view.p033a.C0483b.C0481b;
import android.support.v4.view.p033a.C0483b.C0482c;
import android.support.v4.widget.C0555j;
import android.support.v7.p041e.C0636a.C0634a;
import android.support.v7.p041e.C0636a.C0635b;
import android.support.v7.widget.C3319f.C0793a;
import android.support.v7.widget.C3319f.C0794b;
import android.support.v7.widget.ah.C0741b;
import android.support.v7.widget.aq.C3307a;
import android.support.v7.widget.bw.C0783b;
import android.support.v7.widget.bx.C0785b;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import com.facebook.imagepipeline.memory.DefaultFlexByteArrayPoolParams;
import com.facebook.internal.Utility;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerView extends ViewGroup implements C3226k {
    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC = (VERSION.SDK_INT < 23);
    private static final boolean ALLOW_THREAD_GAP_WORK = (VERSION.SDK_INT < 21);
    private static final int[] CLIP_TO_PADDING_ATTR = new int[]{16842987};
    static final boolean DEBUG = false;
    static final int DEFAULT_ORIENTATION = 1;
    static final boolean DISPATCH_TEMP_DETACH = false;
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION = (VERSION.SDK_INT > 15);
    static final boolean FORCE_INVALIDATE_DISPLAY_LIST;
    static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD = (VERSION.SDK_INT > 15);
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
    static final int MAX_SCROLL_DURATION = 2000;
    private static final int[] NESTED_SCROLLING_ATTRS = new int[]{16843830};
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    static final boolean POST_UPDATES_ON_ANIMATION = (VERSION.SDK_INT < 16);
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    static final String TRACE_SCROLL_TAG = "RV Scroll";
    static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    static final Interpolator sQuinticInterpolator = new C06883();
    ba mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    private C0705m mActiveOnItemTouchListener;
    C0689a mAdapter;
    C3319f mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private C0692d mChildDrawingOrderCallback;
    ah mChildHelper;
    boolean mClipToPadding;
    boolean mDataSetHasChangedAfterLayout;
    boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;
    private C0693e mEdgeEffectFactory;
    boolean mEnableFastScroller;
    boolean mFirstLayoutComplete;
    aq mGapWorker;
    boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    boolean mIsAttached;
    C0697f mItemAnimator;
    private C0695b mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    final ArrayList<C0698h> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastTouchX;
    private int mLastTouchY;
    C0701i mLayout;
    boolean mLayoutFrozen;
    private int mLayoutOrScrollCounter;
    boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final C3294r mObserver;
    private List<C0703k> mOnChildAttachStateListeners;
    private C0704l mOnFlingListener;
    private final ArrayList<C0705m> mOnItemTouchListeners;
    final List<C0718x> mPendingAccessibilityImportanceChange;
    private C3295s mPendingSavedState;
    boolean mPostedAnimatorRunner;
    C3307a mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    final C0709p mRecycler;
    C0710q mRecyclerListener;
    private EdgeEffect mRightGlow;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    private final int[] mScrollConsumed;
    private C0706n mScrollListener;
    private List<C0706n> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private C0509l mScrollingChildHelper;
    final C0715u mState;
    final Rect mTempRect;
    private final Rect mTempRect2;
    final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    final C0717w mViewFlinger;
    private final C0785b mViewInfoProcessCallback;
    final bx mViewInfoStore;

    /* renamed from: android.support.v7.widget.RecyclerView$1 */
    class C06861 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ RecyclerView f1798a;

        C06861(RecyclerView recyclerView) {
            this.f1798a = recyclerView;
        }

        public void run() {
            if (this.f1798a.mFirstLayoutComplete) {
                if (!this.f1798a.isLayoutRequested()) {
                    if (!this.f1798a.mIsAttached) {
                        this.f1798a.requestLayout();
                    } else if (this.f1798a.mLayoutFrozen) {
                        this.f1798a.mLayoutWasDefered = true;
                    } else {
                        this.f1798a.consumePendingUpdateOperations();
                    }
                }
            }
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$2 */
    class C06872 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ RecyclerView f1799a;

        C06872(RecyclerView recyclerView) {
            this.f1799a = recyclerView;
        }

        public void run() {
            if (this.f1799a.mItemAnimator != null) {
                this.f1799a.mItemAnimator.mo2763a();
            }
            this.f1799a.mPostedAnimatorRunner = false;
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$3 */
    static class C06883 implements Interpolator {
        public float getInterpolation(float f) {
            f -= 1.0f;
            return ((((f * f) * f) * f) * f) + 1.0f;
        }

        C06883() {
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$a */
    public static abstract class C0689a<VH extends C0718x> {
        private boolean mHasStableIds = false;
        private final C0690b mObservable = new C0690b();

        public abstract int getItemCount();

        public long getItemId(int i) {
            return -1;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(VH vh, int i);

        public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i);

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(VH vh) {
            return false;
        }

        public void onViewAttachedToWindow(VH vh) {
        }

        public void onViewDetachedFromWindow(VH vh) {
        }

        public void onViewRecycled(VH vh) {
        }

        public void onBindViewHolder(VH vh, int i, List<Object> list) {
            onBindViewHolder(vh, i);
        }

        public final VH createViewHolder(ViewGroup viewGroup, int i) {
            try {
                C0397h.m1177a(RecyclerView.TRACE_CREATE_VIEW_TAG);
                viewGroup = onCreateViewHolder(viewGroup, i);
                if (viewGroup.itemView.getParent() == null) {
                    viewGroup.mItemViewType = i;
                    return viewGroup;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } finally {
                C0397h.m1176a();
            }
        }

        public final void bindViewHolder(VH vh, int i) {
            vh.mPosition = i;
            if (hasStableIds()) {
                vh.mItemId = getItemId(i);
            }
            vh.setFlags(1, 519);
            C0397h.m1177a(RecyclerView.TRACE_BIND_VIEW_TAG);
            onBindViewHolder(vh, i, vh.getUnmodifiedPayloads());
            vh.clearPayload();
            vh = vh.itemView.getLayoutParams();
            if ((vh instanceof C0702j) != 0) {
                ((C0702j) vh).f1816e = true;
            }
            C0397h.m1176a();
        }

        public void setHasStableIds(boolean z) {
            if (hasObservers()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.mHasStableIds = z;
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final boolean hasObservers() {
            return this.mObservable.m2279a();
        }

        public void registerAdapterDataObserver(C0691c c0691c) {
            this.mObservable.registerObserver(c0691c);
        }

        public void unregisterAdapterDataObserver(C0691c c0691c) {
            this.mObservable.unregisterObserver(c0691c);
        }

        public final void notifyDataSetChanged() {
            this.mObservable.m2280b();
        }

        public final void notifyItemChanged(int i) {
            this.mObservable.m2277a(i, 1);
        }

        public final void notifyItemChanged(int i, Object obj) {
            this.mObservable.m2278a(i, 1, obj);
        }

        public final void notifyItemRangeChanged(int i, int i2) {
            this.mObservable.m2277a(i, i2);
        }

        public final void notifyItemRangeChanged(int i, int i2, Object obj) {
            this.mObservable.m2278a(i, i2, obj);
        }

        public final void notifyItemInserted(int i) {
            this.mObservable.m2281b(i, 1);
        }

        public final void notifyItemMoved(int i, int i2) {
            this.mObservable.m2283d(i, i2);
        }

        public final void notifyItemRangeInserted(int i, int i2) {
            this.mObservable.m2281b(i, i2);
        }

        public final void notifyItemRemoved(int i) {
            this.mObservable.m2282c(i, 1);
        }

        public final void notifyItemRangeRemoved(int i, int i2) {
            this.mObservable.m2282c(i, i2);
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$b */
    static class C0690b extends Observable<C0691c> {
        C0690b() {
        }

        /* renamed from: a */
        public boolean m2279a() {
            return this.mObservers.isEmpty() ^ 1;
        }

        /* renamed from: b */
        public void m2280b() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((C0691c) this.mObservers.get(size)).mo582a();
            }
        }

        /* renamed from: a */
        public void m2277a(int i, int i2) {
            m2278a(i, i2, null);
        }

        /* renamed from: a */
        public void m2278a(int i, int i2, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((C0691c) this.mObservers.get(size)).mo584a(i, i2, obj);
            }
        }

        /* renamed from: b */
        public void m2281b(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((C0691c) this.mObservers.get(size)).mo585b(i, i2);
            }
        }

        /* renamed from: c */
        public void m2282c(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((C0691c) this.mObservers.get(size)).mo586c(i, i2);
            }
        }

        /* renamed from: d */
        public void m2283d(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((C0691c) this.mObservers.get(size)).mo583a(i, i2, 1);
            }
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$c */
    public static abstract class C0691c {
        /* renamed from: a */
        public void mo582a() {
        }

        /* renamed from: a */
        public void m2285a(int i, int i2) {
        }

        /* renamed from: a */
        public void mo583a(int i, int i2, int i3) {
        }

        /* renamed from: b */
        public void mo585b(int i, int i2) {
        }

        /* renamed from: c */
        public void mo586c(int i, int i2) {
        }

        /* renamed from: a */
        public void mo584a(int i, int i2, Object obj) {
            m2285a(i, i2);
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$d */
    public interface C0692d {
        /* renamed from: a */
        int m2290a(int i, int i2);
    }

    /* renamed from: android.support.v7.widget.RecyclerView$e */
    public static class C0693e {
        /* renamed from: a */
        protected EdgeEffect m2291a(RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$f */
    public static abstract class C0697f {
        /* renamed from: a */
        private C0695b f1804a = null;
        /* renamed from: b */
        private ArrayList<C0694a> f1805b = new ArrayList();
        /* renamed from: c */
        private long f1806c = 120;
        /* renamed from: d */
        private long f1807d = 120;
        /* renamed from: e */
        private long f1808e = 250;
        /* renamed from: f */
        private long f1809f = 250;

        /* renamed from: android.support.v7.widget.RecyclerView$f$a */
        public interface C0694a {
            /* renamed from: a */
            void m2292a();
        }

        /* renamed from: android.support.v7.widget.RecyclerView$f$b */
        interface C0695b {
            /* renamed from: a */
            void mo576a(C0718x c0718x);
        }

        /* renamed from: android.support.v7.widget.RecyclerView$f$c */
        public static class C0696c {
            /* renamed from: a */
            public int f1800a;
            /* renamed from: b */
            public int f1801b;
            /* renamed from: c */
            public int f1802c;
            /* renamed from: d */
            public int f1803d;

            /* renamed from: a */
            public C0696c m2294a(C0718x c0718x) {
                return m2295a(c0718x, 0);
            }

            /* renamed from: a */
            public C0696c m2295a(C0718x c0718x, int i) {
                c0718x = c0718x.itemView;
                this.f1800a = c0718x.getLeft();
                this.f1801b = c0718x.getTop();
                this.f1802c = c0718x.getRight();
                this.f1803d = c0718x.getBottom();
                return this;
            }
        }

        /* renamed from: a */
        public abstract void mo2763a();

        /* renamed from: a */
        public abstract boolean mo661a(C0718x c0718x, C0696c c0696c, C0696c c0696c2);

        /* renamed from: a */
        public abstract boolean mo662a(C0718x c0718x, C0718x c0718x2, C0696c c0696c, C0696c c0696c2);

        /* renamed from: b */
        public abstract boolean mo2768b();

        /* renamed from: b */
        public abstract boolean mo663b(C0718x c0718x, C0696c c0696c, C0696c c0696c2);

        /* renamed from: c */
        public abstract boolean mo664c(C0718x c0718x, C0696c c0696c, C0696c c0696c2);

        /* renamed from: d */
        public abstract void mo2770d();

        /* renamed from: d */
        public abstract void mo2771d(C0718x c0718x);

        /* renamed from: g */
        public void m2313g(C0718x c0718x) {
        }

        /* renamed from: h */
        public boolean mo665h(C0718x c0718x) {
            return true;
        }

        /* renamed from: e */
        public long m2309e() {
            return this.f1808e;
        }

        /* renamed from: f */
        public long m2310f() {
            return this.f1806c;
        }

        /* renamed from: g */
        public long m2312g() {
            return this.f1807d;
        }

        /* renamed from: h */
        public long m2314h() {
            return this.f1809f;
        }

        /* renamed from: a */
        void m2300a(C0695b c0695b) {
            this.f1804a = c0695b;
        }

        /* renamed from: a */
        public C0696c m2298a(C0715u c0715u, C0718x c0718x, int i, List<Object> list) {
            return m2317j().m2294a(c0718x);
        }

        /* renamed from: a */
        public C0696c m2297a(C0715u c0715u, C0718x c0718x) {
            return m2317j().m2294a(c0718x);
        }

        /* renamed from: e */
        static int m2296e(C0718x c0718x) {
            int access$1600 = c0718x.mFlags & 14;
            if (c0718x.isInvalid()) {
                return 4;
            }
            if ((access$1600 & 4) == 0) {
                int oldPosition = c0718x.getOldPosition();
                c0718x = c0718x.getAdapterPosition();
                if (!(oldPosition == -1 || c0718x == -1 || oldPosition == c0718x)) {
                    access$1600 |= 2048;
                }
            }
            return access$1600;
        }

        /* renamed from: f */
        public final void m2311f(C0718x c0718x) {
            m2313g(c0718x);
            if (this.f1804a != null) {
                this.f1804a.mo576a(c0718x);
            }
        }

        /* renamed from: a */
        public boolean mo2767a(C0718x c0718x, List<Object> list) {
            return mo665h(c0718x);
        }

        /* renamed from: i */
        public final void m2316i() {
            int size = this.f1805b.size();
            for (int i = 0; i < size; i++) {
                ((C0694a) this.f1805b.get(i)).m2292a();
            }
            this.f1805b.clear();
        }

        /* renamed from: j */
        public C0696c m2317j() {
            return new C0696c();
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$h */
    public static abstract class C0698h {
        @Deprecated
        /* renamed from: a */
        public void m2318a(Canvas canvas, RecyclerView recyclerView) {
        }

        @Deprecated
        /* renamed from: b */
        public void m2322b(Canvas canvas, RecyclerView recyclerView) {
        }

        /* renamed from: b */
        public void m2323b(Canvas canvas, RecyclerView recyclerView, C0715u c0715u) {
            m2318a(canvas, recyclerView);
        }

        /* renamed from: a */
        public void mo625a(Canvas canvas, RecyclerView recyclerView, C0715u c0715u) {
            m2322b(canvas, recyclerView);
        }

        @Deprecated
        /* renamed from: a */
        public void m2320a(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        /* renamed from: a */
        public void m2321a(Rect rect, View view, RecyclerView recyclerView, C0715u c0715u) {
            m2320a(rect, ((C0702j) view.getLayoutParams()).m2328f(), recyclerView);
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$i */
    public static abstract class C0701i {
        boolean mAutoMeasure = false;
        ah mChildHelper;
        private int mHeight;
        private int mHeightMode;
        bw mHorizontalBoundCheck = new bw(this.mHorizontalBoundCheckCallback);
        private final C0783b mHorizontalBoundCheckCallback = new C32921(this);
        boolean mIsAttachedToWindow = false;
        private boolean mItemPrefetchEnabled = true;
        private boolean mMeasurementCacheEnabled = true;
        int mPrefetchMaxCountObserved;
        boolean mPrefetchMaxObservedInInitialPrefetch;
        RecyclerView mRecyclerView;
        boolean mRequestedSimpleAnimations = false;
        C0714t mSmoothScroller;
        bw mVerticalBoundCheck = new bw(this.mVerticalBoundCheckCallback);
        private final C0783b mVerticalBoundCheckCallback = new C32932(this);
        private int mWidth;
        private int mWidthMode;

        /* renamed from: android.support.v7.widget.RecyclerView$i$a */
        public interface C0699a {
            /* renamed from: b */
            void mo629b(int i, int i2);
        }

        /* renamed from: android.support.v7.widget.RecyclerView$i$b */
        public static class C0700b {
            /* renamed from: a */
            public int f1810a;
            /* renamed from: b */
            public int f1811b;
            /* renamed from: c */
            public boolean f1812c;
            /* renamed from: d */
            public boolean f1813d;
        }

        /* renamed from: android.support.v7.widget.RecyclerView$i$1 */
        class C32921 implements C0783b {
            /* renamed from: a */
            final /* synthetic */ C0701i f8629a;

            C32921(C0701i c0701i) {
                this.f8629a = c0701i;
            }

            /* renamed from: a */
            public View mo579a(int i) {
                return this.f8629a.getChildAt(i);
            }

            /* renamed from: a */
            public int mo577a() {
                return this.f8629a.getPaddingLeft();
            }

            /* renamed from: b */
            public int mo580b() {
                return this.f8629a.getWidth() - this.f8629a.getPaddingRight();
            }

            /* renamed from: a */
            public int mo578a(View view) {
                return this.f8629a.getDecoratedLeft(view) - ((C0702j) view.getLayoutParams()).leftMargin;
            }

            /* renamed from: b */
            public int mo581b(View view) {
                return this.f8629a.getDecoratedRight(view) + ((C0702j) view.getLayoutParams()).rightMargin;
            }
        }

        /* renamed from: android.support.v7.widget.RecyclerView$i$2 */
        class C32932 implements C0783b {
            /* renamed from: a */
            final /* synthetic */ C0701i f8630a;

            C32932(C0701i c0701i) {
                this.f8630a = c0701i;
            }

            /* renamed from: a */
            public View mo579a(int i) {
                return this.f8630a.getChildAt(i);
            }

            /* renamed from: a */
            public int mo577a() {
                return this.f8630a.getPaddingTop();
            }

            /* renamed from: b */
            public int mo580b() {
                return this.f8630a.getHeight() - this.f8630a.getPaddingBottom();
            }

            /* renamed from: a */
            public int mo578a(View view) {
                return this.f8630a.getDecoratedTop(view) - ((C0702j) view.getLayoutParams()).topMargin;
            }

            /* renamed from: b */
            public int mo581b(View view) {
                return this.f8630a.getDecoratedBottom(view) + ((C0702j) view.getLayoutParams()).bottomMargin;
            }
        }

        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public boolean checkLayoutParams(C0702j c0702j) {
            return c0702j != null;
        }

        public void collectAdjacentPrefetchPositions(int i, int i2, C0715u c0715u, C0699a c0699a) {
        }

        public void collectInitialPrefetchPositions(int i, C0699a c0699a) {
        }

        public int computeHorizontalScrollExtent(C0715u c0715u) {
            return 0;
        }

        public int computeHorizontalScrollOffset(C0715u c0715u) {
            return 0;
        }

        public int computeHorizontalScrollRange(C0715u c0715u) {
            return 0;
        }

        public int computeVerticalScrollExtent(C0715u c0715u) {
            return 0;
        }

        public int computeVerticalScrollOffset(C0715u c0715u) {
            return 0;
        }

        public int computeVerticalScrollRange(C0715u c0715u) {
            return 0;
        }

        public abstract C0702j generateDefaultLayoutParams();

        public int getBaseline() {
            return -1;
        }

        public int getSelectionModeForAccessibility(C0709p c0709p, C0715u c0715u) {
            return 0;
        }

        public boolean isLayoutHierarchical(C0709p c0709p, C0715u c0715u) {
            return false;
        }

        public void onAdapterChanged(C0689a c0689a, C0689a c0689a2) {
        }

        public boolean onAddFocusables(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        public void onAttachedToWindow(RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView recyclerView) {
        }

        public View onFocusSearchFailed(View view, int i, C0709p c0709p, C0715u c0715u) {
            return null;
        }

        public View onInterceptFocusSearch(View view, int i) {
            return null;
        }

        public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsChanged(RecyclerView recyclerView) {
        }

        public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        }

        public void onLayoutCompleted(C0715u c0715u) {
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onScrollStateChanged(int i) {
        }

        public boolean performAccessibilityActionForItem(C0709p c0709p, C0715u c0715u, View view, int i, Bundle bundle) {
            return false;
        }

        public int scrollHorizontallyBy(int i, C0709p c0709p, C0715u c0715u) {
            return 0;
        }

        public void scrollToPosition(int i) {
        }

        public int scrollVerticallyBy(int i, C0709p c0709p, C0715u c0715u) {
            return 0;
        }

        boolean shouldMeasureTwice() {
            return false;
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }

        void setRecyclerView(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.mRecyclerView = null;
                this.mChildHelper = null;
                this.mWidth = 0;
                this.mHeight = 0;
            } else {
                this.mRecyclerView = recyclerView;
                this.mChildHelper = recyclerView.mChildHelper;
                this.mWidth = recyclerView.getWidth();
                this.mHeight = recyclerView.getHeight();
            }
            this.mWidthMode = 1073741824;
            this.mHeightMode = 1073741824;
        }

        void setMeasureSpecs(int i, int i2) {
            this.mWidth = MeasureSpec.getSize(i);
            this.mWidthMode = MeasureSpec.getMode(i);
            if (this.mWidthMode == 0 && RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC == 0) {
                this.mWidth = 0;
            }
            this.mHeight = MeasureSpec.getSize(i2);
            this.mHeightMode = MeasureSpec.getMode(i2);
            if (this.mHeightMode == 0 && RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC == 0) {
                this.mHeight = 0;
            }
        }

        void setMeasuredDimensionFromChildren(int i, int i2) {
            int childCount = getChildCount();
            if (childCount == 0) {
                this.mRecyclerView.defaultOnMeasure(i, i2);
                return;
            }
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = LinearLayoutManager.INVALID_OFFSET;
            int i6 = LinearLayoutManager.INVALID_OFFSET;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                Rect rect = this.mRecyclerView.mTempRect;
                getDecoratedBoundsWithMargins(childAt, rect);
                if (rect.left < i3) {
                    i3 = rect.left;
                }
                if (rect.right > i5) {
                    i5 = rect.right;
                }
                if (rect.top < i4) {
                    i4 = rect.top;
                }
                if (rect.bottom > i6) {
                    i6 = rect.bottom;
                }
            }
            this.mRecyclerView.mTempRect.set(i3, i4, i5, i6);
            setMeasuredDimension(this.mRecyclerView.mTempRect, i, i2);
        }

        public void setMeasuredDimension(Rect rect, int i, int i2) {
            setMeasuredDimension(C0701i.chooseSize(i, (rect.width() + getPaddingLeft()) + getPaddingRight(), getMinimumWidth()), C0701i.chooseSize(i2, (rect.height() + getPaddingTop()) + getPaddingBottom(), getMinimumHeight()));
        }

        public void requestLayout() {
            if (this.mRecyclerView != null) {
                this.mRecyclerView.requestLayout();
            }
        }

        public void assertInLayoutOrScroll(String str) {
            if (this.mRecyclerView != null) {
                this.mRecyclerView.assertInLayoutOrScroll(str);
            }
        }

        public static int chooseSize(int i, int i2, int i3) {
            int mode = MeasureSpec.getMode(i);
            i = MeasureSpec.getSize(i);
            if (mode != LinearLayoutManager.INVALID_OFFSET) {
                return mode != 1073741824 ? Math.max(i2, i3) : i;
            } else {
                return Math.min(i, Math.max(i2, i3));
            }
        }

        public void assertNotInLayoutOrScroll(String str) {
            if (this.mRecyclerView != null) {
                this.mRecyclerView.assertNotInLayoutOrScroll(str);
            }
        }

        @Deprecated
        public void setAutoMeasureEnabled(boolean z) {
            this.mAutoMeasure = z;
        }

        public boolean isAutoMeasureEnabled() {
            return this.mAutoMeasure;
        }

        public final void setItemPrefetchEnabled(boolean z) {
            if (z != this.mItemPrefetchEnabled) {
                this.mItemPrefetchEnabled = z;
                this.mPrefetchMaxCountObserved = false;
                if (this.mRecyclerView) {
                    this.mRecyclerView.mRecycler.m2366b();
                }
            }
        }

        public final boolean isItemPrefetchEnabled() {
            return this.mItemPrefetchEnabled;
        }

        void dispatchAttachedToWindow(RecyclerView recyclerView) {
            this.mIsAttachedToWindow = true;
            onAttachedToWindow(recyclerView);
        }

        void dispatchDetachedFromWindow(RecyclerView recyclerView, C0709p c0709p) {
            this.mIsAttachedToWindow = false;
            onDetachedFromWindow(recyclerView, c0709p);
        }

        public boolean isAttachedToWindow() {
            return this.mIsAttachedToWindow;
        }

        public void postOnAnimation(Runnable runnable) {
            if (this.mRecyclerView != null) {
                C0517s.m1697a(this.mRecyclerView, runnable);
            }
        }

        public boolean removeCallbacks(Runnable runnable) {
            return this.mRecyclerView != null ? this.mRecyclerView.removeCallbacks(runnable) : null;
        }

        public void onDetachedFromWindow(RecyclerView recyclerView, C0709p c0709p) {
            onDetachedFromWindow(recyclerView);
        }

        public boolean getClipToPadding() {
            return this.mRecyclerView != null && this.mRecyclerView.mClipToPadding;
        }

        public void onLayoutChildren(C0709p c0709p, C0715u c0715u) {
            Log.e(RecyclerView.TAG, "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public C0702j generateLayoutParams(LayoutParams layoutParams) {
            if (layoutParams instanceof C0702j) {
                return new C0702j((C0702j) layoutParams);
            }
            if (layoutParams instanceof MarginLayoutParams) {
                return new C0702j((MarginLayoutParams) layoutParams);
            }
            return new C0702j(layoutParams);
        }

        public C0702j generateLayoutParams(Context context, AttributeSet attributeSet) {
            return new C0702j(context, attributeSet);
        }

        public void smoothScrollToPosition(RecyclerView recyclerView, C0715u c0715u, int i) {
            Log.e(RecyclerView.TAG, "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void startSmoothScroll(C0714t c0714t) {
            if (!(this.mSmoothScroller == null || c0714t == this.mSmoothScroller || !this.mSmoothScroller.isRunning())) {
                this.mSmoothScroller.stop();
            }
            this.mSmoothScroller = c0714t;
            this.mSmoothScroller.start(this.mRecyclerView, this);
        }

        public boolean isSmoothScrolling() {
            return this.mSmoothScroller != null && this.mSmoothScroller.isRunning();
        }

        public int getLayoutDirection() {
            return C0517s.m1711e(this.mRecyclerView);
        }

        public void endAnimation(View view) {
            if (this.mRecyclerView.mItemAnimator != null) {
                this.mRecyclerView.mItemAnimator.mo2771d(RecyclerView.getChildViewHolderInt(view));
            }
        }

        public void addDisappearingView(View view) {
            addDisappearingView(view, -1);
        }

        public void addDisappearingView(View view, int i) {
            addViewInt(view, i, true);
        }

        public void addView(View view) {
            addView(view, -1);
        }

        public void addView(View view, int i) {
            addViewInt(view, i, false);
        }

        private void addViewInt(View view, int i, boolean z) {
            C0702j c0702j;
            int b;
            C0718x childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!z) {
                if (!childViewHolderInt.isRemoved()) {
                    this.mRecyclerView.mViewInfoStore.m2837f(childViewHolderInt);
                    c0702j = (C0702j) view.getLayoutParams();
                    if (!childViewHolderInt.wasReturnedFromScrap()) {
                        if (childViewHolderInt.isScrap()) {
                            if (view.getParent() != this.mRecyclerView) {
                                b = this.mChildHelper.m2562b(view);
                                if (i == -1) {
                                    i = this.mChildHelper.m2561b();
                                }
                                if (b != -1) {
                                    z = new StringBuilder();
                                    z.append("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
                                    z.append(this.mRecyclerView.indexOfChild(view));
                                    z.append(this.mRecyclerView.exceptionLabel());
                                    throw new IllegalStateException(z.toString());
                                } else if (b != i) {
                                    this.mRecyclerView.mLayout.moveView(b, i);
                                }
                            } else {
                                this.mChildHelper.m2559a(view, i, false);
                                c0702j.f1816e = true;
                                if (!(this.mSmoothScroller == 0 || this.mSmoothScroller.isRunning() == 0)) {
                                    this.mSmoothScroller.onChildAttachedToWindow(view);
                                }
                            }
                            if (c0702j.f1817f == null) {
                                childViewHolderInt.itemView.invalidate();
                                c0702j.f1817f = false;
                            }
                        }
                    }
                    if (childViewHolderInt.isScrap()) {
                        childViewHolderInt.clearReturnedFromScrapFlag();
                    } else {
                        childViewHolderInt.unScrap();
                    }
                    this.mChildHelper.m2558a(view, i, view.getLayoutParams(), false);
                    if (c0702j.f1817f == null) {
                        childViewHolderInt.itemView.invalidate();
                        c0702j.f1817f = false;
                    }
                }
            }
            this.mRecyclerView.mViewInfoStore.m2836e(childViewHolderInt);
            c0702j = (C0702j) view.getLayoutParams();
            if (childViewHolderInt.wasReturnedFromScrap()) {
                if (childViewHolderInt.isScrap()) {
                    if (view.getParent() != this.mRecyclerView) {
                        this.mChildHelper.m2559a(view, i, false);
                        c0702j.f1816e = true;
                        this.mSmoothScroller.onChildAttachedToWindow(view);
                    } else {
                        b = this.mChildHelper.m2562b(view);
                        if (i == -1) {
                            i = this.mChildHelper.m2561b();
                        }
                        if (b != -1) {
                            z = new StringBuilder();
                            z.append("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
                            z.append(this.mRecyclerView.indexOfChild(view));
                            z.append(this.mRecyclerView.exceptionLabel());
                            throw new IllegalStateException(z.toString());
                        } else if (b != i) {
                            this.mRecyclerView.mLayout.moveView(b, i);
                        }
                    }
                    if (c0702j.f1817f == null) {
                        childViewHolderInt.itemView.invalidate();
                        c0702j.f1817f = false;
                    }
                }
            }
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.clearReturnedFromScrapFlag();
            } else {
                childViewHolderInt.unScrap();
            }
            this.mChildHelper.m2558a(view, i, view.getLayoutParams(), false);
            if (c0702j.f1817f == null) {
                childViewHolderInt.itemView.invalidate();
                c0702j.f1817f = false;
            }
        }

        public void removeView(View view) {
            this.mChildHelper.m2557a(view);
        }

        public void removeViewAt(int i) {
            if (getChildAt(i) != null) {
                this.mChildHelper.m2556a(i);
            }
        }

        public void removeAllViews() {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                this.mChildHelper.m2556a(childCount);
            }
        }

        public int getPosition(View view) {
            return ((C0702j) view.getLayoutParams()).m2328f();
        }

        public int getItemViewType(View view) {
            return RecyclerView.getChildViewHolderInt(view).getItemViewType();
        }

        public View findContainingItemView(View view) {
            if (this.mRecyclerView == null) {
                return null;
            }
            view = this.mRecyclerView.findContainingItemView(view);
            if (view == null || this.mChildHelper.m2566c(view)) {
                return null;
            }
            return view;
        }

        public View findViewByPosition(int i) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                C0718x childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
                if (childViewHolderInt != null) {
                    if (childViewHolderInt.getLayoutPosition() == i && !childViewHolderInt.shouldIgnore() && (this.mRecyclerView.mState.m2398a() || !childViewHolderInt.isRemoved())) {
                        return childAt;
                    }
                }
            }
            return 0;
        }

        public void detachView(View view) {
            int b = this.mChildHelper.m2562b(view);
            if (b >= 0) {
                detachViewInternal(b, view);
            }
        }

        public void detachViewAt(int i) {
            detachViewInternal(i, getChildAt(i));
        }

        private void detachViewInternal(int i, View view) {
            this.mChildHelper.m2569e(i);
        }

        public void attachView(View view, int i, C0702j c0702j) {
            C0718x childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.m2836e(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.m2837f(childViewHolderInt);
            }
            this.mChildHelper.m2558a(view, i, c0702j, childViewHolderInt.isRemoved());
        }

        public void attachView(View view, int i) {
            attachView(view, i, (C0702j) view.getLayoutParams());
        }

        public void attachView(View view) {
            attachView(view, -1);
        }

        public void removeDetachedView(View view) {
            this.mRecyclerView.removeDetachedView(view, false);
        }

        public void moveView(int i, int i2) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                detachViewAt(i);
                attachView(childAt, i2);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot move a child from non-existing index:");
            stringBuilder.append(i);
            stringBuilder.append(this.mRecyclerView.toString());
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        public void detachAndScrapView(View view, C0709p c0709p) {
            scrapOrRecycleView(c0709p, this.mChildHelper.m2562b(view), view);
        }

        public void detachAndScrapViewAt(int i, C0709p c0709p) {
            scrapOrRecycleView(c0709p, i, getChildAt(i));
        }

        public void removeAndRecycleView(View view, C0709p c0709p) {
            removeView(view);
            c0709p.m2362a(view);
        }

        public void removeAndRecycleViewAt(int i, C0709p c0709p) {
            View childAt = getChildAt(i);
            removeViewAt(i);
            c0709p.m2362a(childAt);
        }

        public int getChildCount() {
            return this.mChildHelper != null ? this.mChildHelper.m2561b() : 0;
        }

        public View getChildAt(int i) {
            return this.mChildHelper != null ? this.mChildHelper.m2563b(i) : 0;
        }

        public int getWidthMode() {
            return this.mWidthMode;
        }

        public int getHeightMode() {
            return this.mHeightMode;
        }

        public int getWidth() {
            return this.mWidth;
        }

        public int getHeight() {
            return this.mHeight;
        }

        public int getPaddingLeft() {
            return this.mRecyclerView != null ? this.mRecyclerView.getPaddingLeft() : 0;
        }

        public int getPaddingTop() {
            return this.mRecyclerView != null ? this.mRecyclerView.getPaddingTop() : 0;
        }

        public int getPaddingRight() {
            return this.mRecyclerView != null ? this.mRecyclerView.getPaddingRight() : 0;
        }

        public int getPaddingBottom() {
            return this.mRecyclerView != null ? this.mRecyclerView.getPaddingBottom() : 0;
        }

        public int getPaddingStart() {
            return this.mRecyclerView != null ? C0517s.m1713g(this.mRecyclerView) : 0;
        }

        public int getPaddingEnd() {
            return this.mRecyclerView != null ? C0517s.m1714h(this.mRecyclerView) : 0;
        }

        public boolean isFocused() {
            return this.mRecyclerView != null && this.mRecyclerView.isFocused();
        }

        public boolean hasFocus() {
            return this.mRecyclerView != null && this.mRecyclerView.hasFocus();
        }

        public View getFocusedChild() {
            if (this.mRecyclerView == null) {
                return null;
            }
            View focusedChild = this.mRecyclerView.getFocusedChild();
            if (focusedChild != null) {
                if (!this.mChildHelper.m2566c(focusedChild)) {
                    return focusedChild;
                }
            }
            return null;
        }

        public int getItemCount() {
            C0689a adapter = this.mRecyclerView != null ? this.mRecyclerView.getAdapter() : null;
            return adapter != null ? adapter.getItemCount() : 0;
        }

        public void offsetChildrenHorizontal(int i) {
            if (this.mRecyclerView != null) {
                this.mRecyclerView.offsetChildrenHorizontal(i);
            }
        }

        public void offsetChildrenVertical(int i) {
            if (this.mRecyclerView != null) {
                this.mRecyclerView.offsetChildrenVertical(i);
            }
        }

        public void ignoreView(View view) {
            if (view.getParent() != this.mRecyclerView || this.mRecyclerView.indexOfChild(view) == -1) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("View should be fully attached to be ignored");
                stringBuilder.append(this.mRecyclerView.exceptionLabel());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            view = RecyclerView.getChildViewHolderInt(view);
            view.addFlags(128);
            this.mRecyclerView.mViewInfoStore.m2838g(view);
        }

        public void stopIgnoringView(View view) {
            view = RecyclerView.getChildViewHolderInt(view);
            view.stopIgnoring();
            view.resetInternal();
            view.addFlags(4);
        }

        public void detachAndScrapAttachedViews(C0709p c0709p) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                scrapOrRecycleView(c0709p, childCount, getChildAt(childCount));
            }
        }

        private void scrapOrRecycleView(C0709p c0709p, int i, View view) {
            C0718x childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.shouldIgnore()) {
                if (!childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved() || this.mRecyclerView.mAdapter.hasStableIds()) {
                    detachViewAt(i);
                    c0709p.m2374c(view);
                    this.mRecyclerView.mViewInfoStore.m2839h(childViewHolderInt);
                } else {
                    removeViewAt(i);
                    c0709p.m2368b(childViewHolderInt);
                }
            }
        }

        void removeAndRecycleScrapInt(C0709p c0709p) {
            int e = c0709p.m2378e();
            for (int i = e - 1; i >= 0; i--) {
                View e2 = c0709p.m2379e(i);
                C0718x childViewHolderInt = RecyclerView.getChildViewHolderInt(e2);
                if (!childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.setIsRecyclable(false);
                    if (childViewHolderInt.isTmpDetached()) {
                        this.mRecyclerView.removeDetachedView(e2, false);
                    }
                    if (this.mRecyclerView.mItemAnimator != null) {
                        this.mRecyclerView.mItemAnimator.mo2771d(childViewHolderInt);
                    }
                    childViewHolderInt.setIsRecyclable(true);
                    c0709p.m2369b(e2);
                }
            }
            c0709p.m2381f();
            if (e > 0) {
                this.mRecyclerView.invalidate();
            }
        }

        public void measureChild(View view, int i, int i2) {
            C0702j c0702j = (C0702j) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            i2 += itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            i = C0701i.getChildMeasureSpec(getWidth(), getWidthMode(), (getPaddingLeft() + getPaddingRight()) + (i + (itemDecorInsetsForChild.left + itemDecorInsetsForChild.right)), c0702j.width, canScrollHorizontally());
            i2 = C0701i.getChildMeasureSpec(getHeight(), getHeightMode(), (getPaddingTop() + getPaddingBottom()) + i2, c0702j.height, canScrollVertically());
            if (shouldMeasureChild(view, i, i2, c0702j)) {
                view.measure(i, i2);
            }
        }

        boolean shouldReMeasureChild(View view, int i, int i2, C0702j c0702j) {
            if (this.mMeasurementCacheEnabled && C0701i.isMeasurementUpToDate(view.getMeasuredWidth(), i, c0702j.width) != 0) {
                if (C0701i.isMeasurementUpToDate(view.getMeasuredHeight(), i2, c0702j.height) != null) {
                    return null;
                }
            }
            return true;
        }

        boolean shouldMeasureChild(View view, int i, int i2, C0702j c0702j) {
            if (!(view.isLayoutRequested() || !this.mMeasurementCacheEnabled || C0701i.isMeasurementUpToDate(view.getWidth(), i, c0702j.width) == 0)) {
                if (C0701i.isMeasurementUpToDate(view.getHeight(), i2, c0702j.height) != null) {
                    return null;
                }
            }
            return true;
        }

        public boolean isMeasurementCacheEnabled() {
            return this.mMeasurementCacheEnabled;
        }

        public void setMeasurementCacheEnabled(boolean z) {
            this.mMeasurementCacheEnabled = z;
        }

        private static boolean isMeasurementUpToDate(int i, int i2, int i3) {
            int mode = MeasureSpec.getMode(i2);
            i2 = MeasureSpec.getSize(i2);
            boolean z = false;
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode == LinearLayoutManager.INVALID_OFFSET) {
                if (i2 >= i) {
                    z = true;
                }
                return z;
            } else if (mode == 0) {
                return true;
            } else {
                if (mode != 1073741824) {
                    return false;
                }
                if (i2 == i) {
                    z = true;
                }
                return z;
            }
        }

        public void measureChildWithMargins(View view, int i, int i2) {
            C0702j c0702j = (C0702j) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            i2 += itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            i = C0701i.getChildMeasureSpec(getWidth(), getWidthMode(), (((getPaddingLeft() + getPaddingRight()) + c0702j.leftMargin) + c0702j.rightMargin) + (i + (itemDecorInsetsForChild.left + itemDecorInsetsForChild.right)), c0702j.width, canScrollHorizontally());
            i2 = C0701i.getChildMeasureSpec(getHeight(), getHeightMode(), (((getPaddingTop() + getPaddingBottom()) + c0702j.topMargin) + c0702j.bottomMargin) + i2, c0702j.height, canScrollVertically());
            if (shouldMeasureChild(view, i, i2, c0702j)) {
                view.measure(i, i2);
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        @java.lang.Deprecated
        public static int getChildMeasureSpec(int r1, int r2, int r3, boolean r4) {
            /*
            r1 = r1 - r2;
            r2 = 0;
            r1 = java.lang.Math.max(r2, r1);
            r0 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
            if (r4 == 0) goto L_0x0012;
        L_0x000a:
            if (r3 < 0) goto L_0x0010;
        L_0x000c:
            r1 = r3;
        L_0x000d:
            r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
            goto L_0x001e;
        L_0x0010:
            r1 = 0;
            goto L_0x001e;
        L_0x0012:
            if (r3 < 0) goto L_0x0015;
        L_0x0014:
            goto L_0x000c;
        L_0x0015:
            r4 = -1;
            if (r3 != r4) goto L_0x0019;
        L_0x0018:
            goto L_0x000d;
        L_0x0019:
            r4 = -2;
            if (r3 != r4) goto L_0x0010;
        L_0x001c:
            r2 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        L_0x001e:
            r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r2);
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.i.getChildMeasureSpec(int, int, int, boolean):int");
        }

        public static int getChildMeasureSpec(int i, int i2, int i3, int i4, boolean z) {
            i -= i3;
            i3 = 0;
            i = Math.max(0, i);
            if (z) {
                if (i4 < 0) {
                    if (i4 == -1) {
                        if (i2 == LinearLayoutManager.INVALID_OFFSET || (i2 != 0 && i2 == 1073741824)) {
                            i4 = i;
                        } else {
                            i2 = 0;
                            i4 = 0;
                        }
                        i3 = i2;
                        i = i4;
                        return MeasureSpec.makeMeasureSpec(i, i3);
                    }
                    i = 0;
                    return MeasureSpec.makeMeasureSpec(i, i3);
                }
            } else if (i4 < 0) {
                if (i4 == -1) {
                    i3 = i2;
                } else {
                    if (i4 == -2) {
                        if (i2 == LinearLayoutManager.INVALID_OFFSET || i2 == 1073741824) {
                            i3 = LinearLayoutManager.INVALID_OFFSET;
                        }
                    }
                    i = 0;
                }
                return MeasureSpec.makeMeasureSpec(i, i3);
            }
            i = i4;
            i3 = 1073741824;
            return MeasureSpec.makeMeasureSpec(i, i3);
        }

        public int getDecoratedMeasuredWidth(View view) {
            Rect rect = ((C0702j) view.getLayoutParams()).f1815d;
            return (view.getMeasuredWidth() + rect.left) + rect.right;
        }

        public int getDecoratedMeasuredHeight(View view) {
            Rect rect = ((C0702j) view.getLayoutParams()).f1815d;
            return (view.getMeasuredHeight() + rect.top) + rect.bottom;
        }

        public void layoutDecorated(View view, int i, int i2, int i3, int i4) {
            Rect rect = ((C0702j) view.getLayoutParams()).f1815d;
            view.layout(i + rect.left, i2 + rect.top, i3 - rect.right, i4 - rect.bottom);
        }

        public void layoutDecoratedWithMargins(View view, int i, int i2, int i3, int i4) {
            C0702j c0702j = (C0702j) view.getLayoutParams();
            Rect rect = c0702j.f1815d;
            view.layout((i + rect.left) + c0702j.leftMargin, (i2 + rect.top) + c0702j.topMargin, (i3 - rect.right) - c0702j.rightMargin, (i4 - rect.bottom) - c0702j.bottomMargin);
        }

        public void getTransformedBoundingBox(View view, boolean z, Rect rect) {
            if (z) {
                z = ((C0702j) view.getLayoutParams()).f1815d;
                rect.set(-z.left, -z.top, view.getWidth() + z.right, view.getHeight() + z.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.mRecyclerView) {
                z = view.getMatrix();
                if (z && !z.isIdentity()) {
                    RectF rectF = this.mRecyclerView.mTempRectF;
                    rectF.set(rect);
                    z.mapRect(rectF);
                    rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
                }
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void getDecoratedBoundsWithMargins(View view, Rect rect) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
        }

        public int getDecoratedLeft(View view) {
            return view.getLeft() - getLeftDecorationWidth(view);
        }

        public int getDecoratedTop(View view) {
            return view.getTop() - getTopDecorationHeight(view);
        }

        public int getDecoratedRight(View view) {
            return view.getRight() + getRightDecorationWidth(view);
        }

        public int getDecoratedBottom(View view) {
            return view.getBottom() + getBottomDecorationHeight(view);
        }

        public void calculateItemDecorationsForChild(View view, Rect rect) {
            if (this.mRecyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(this.mRecyclerView.getItemDecorInsetsForChild(view));
            }
        }

        public int getTopDecorationHeight(View view) {
            return ((C0702j) view.getLayoutParams()).f1815d.top;
        }

        public int getBottomDecorationHeight(View view) {
            return ((C0702j) view.getLayoutParams()).f1815d.bottom;
        }

        public int getLeftDecorationWidth(View view) {
            return ((C0702j) view.getLayoutParams()).f1815d.left;
        }

        public int getRightDecorationWidth(View view) {
            return ((C0702j) view.getLayoutParams()).f1815d.right;
        }

        private int[] getChildRectangleOnScreenScrollAmount(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            recyclerView = new int[2];
            z = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            view = rect.width() + left;
            rect = rect.height() + top;
            left -= z;
            int min = Math.min(0, left);
            top -= paddingTop;
            paddingTop = Math.min(0, top);
            view -= width;
            width = Math.max(0, view);
            rect = Math.max(0, rect - height);
            if (getLayoutDirection() != 1) {
                if (min == 0) {
                    min = Math.min(left, width);
                }
                width = min;
            } else if (width == 0) {
                width = Math.max(min, view);
            }
            if (paddingTop == 0) {
                paddingTop = Math.min(top, rect);
            }
            recyclerView[0] = width;
            recyclerView[1] = paddingTop;
            return recyclerView;
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return requestChildRectangleOnScreen(recyclerView, view, rect, z, false);
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            view = getChildRectangleOnScreenScrollAmount(recyclerView, view, rect, z);
            int i = view[0];
            view = view[1];
            if (!z2 || isFocusedChildVisibleAfterScrolling(recyclerView, i, view)) {
                if (i == 0) {
                    if (view != null) {
                    }
                }
                if (z) {
                    recyclerView.scrollBy(i, view);
                } else {
                    recyclerView.smoothScrollBy(i, view);
                }
                return true;
            }
            return false;
        }

        public boolean isViewPartiallyVisible(View view, boolean z, boolean z2) {
            view = (!this.mHorizontalBoundCheck.m2815a(view, 24579) || this.mVerticalBoundCheck.m2815a(view, 24579) == null) ? null : true;
            return z ? view : view ^ 1;
        }

        private boolean isFocusedChildVisibleAfterScrolling(RecyclerView recyclerView, int i, int i2) {
            recyclerView = recyclerView.getFocusedChild();
            if (recyclerView == null) {
                return false;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            Rect rect = this.mRecyclerView.mTempRect;
            getDecoratedBoundsWithMargins(recyclerView, rect);
            if (rect.left - i < width && rect.right - i > paddingLeft && rect.top - i2 < height) {
                if (rect.bottom - i2 > paddingTop) {
                    return true;
                }
            }
            return false;
        }

        @Deprecated
        public boolean onRequestChildFocus(RecyclerView recyclerView, View view, View view2) {
            if (isSmoothScrolling() == null) {
                if (recyclerView.isComputingLayout() == null) {
                    return null;
                }
            }
            return true;
        }

        public boolean onRequestChildFocus(RecyclerView recyclerView, C0715u c0715u, View view, View view2) {
            return onRequestChildFocus(recyclerView, view, view2);
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
            onItemsUpdated(recyclerView, i, i2);
        }

        public void onMeasure(C0709p c0709p, C0715u c0715u, int i, int i2) {
            this.mRecyclerView.defaultOnMeasure(i, i2);
        }

        public void setMeasuredDimension(int i, int i2) {
            this.mRecyclerView.setMeasuredDimension(i, i2);
        }

        public int getMinimumWidth() {
            return C0517s.m1715i(this.mRecyclerView);
        }

        public int getMinimumHeight() {
            return C0517s.m1716j(this.mRecyclerView);
        }

        void stopSmoothScroller() {
            if (this.mSmoothScroller != null) {
                this.mSmoothScroller.stop();
            }
        }

        private void onSmoothScrollerStopped(C0714t c0714t) {
            if (this.mSmoothScroller == c0714t) {
                this.mSmoothScroller = null;
            }
        }

        public void removeAndRecycleAllViews(C0709p c0709p) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!RecyclerView.getChildViewHolderInt(getChildAt(childCount)).shouldIgnore()) {
                    removeAndRecycleViewAt(childCount, c0709p);
                }
            }
        }

        void onInitializeAccessibilityNodeInfo(C0483b c0483b) {
            onInitializeAccessibilityNodeInfo(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, c0483b);
        }

        public void onInitializeAccessibilityNodeInfo(C0709p c0709p, C0715u c0715u, C0483b c0483b) {
            if (this.mRecyclerView.canScrollVertically(-1) || this.mRecyclerView.canScrollHorizontally(-1)) {
                c0483b.m1502a((int) Utility.DEFAULT_STREAM_BUFFER_SIZE);
                c0483b.m1539k(true);
            }
            if (this.mRecyclerView.canScrollVertically(1) || this.mRecyclerView.canScrollHorizontally(1)) {
                c0483b.m1502a(4096);
                c0483b.m1539k(true);
            }
            c0483b.m1506a(C0481b.m1496a(getRowCountForAccessibility(c0709p, c0715u), getColumnCountForAccessibility(c0709p, c0715u), isLayoutHierarchical(c0709p, c0715u), getSelectionModeForAccessibility(c0709p, c0715u)));
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            onInitializeAccessibilityEvent(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, accessibilityEvent);
        }

        public void onInitializeAccessibilityEvent(C0709p c0709p, C0715u c0715u, AccessibilityEvent accessibilityEvent) {
            if (this.mRecyclerView != null) {
                if (accessibilityEvent != null) {
                    c0715u = true;
                    if (this.mRecyclerView.canScrollVertically(1) == null && this.mRecyclerView.canScrollVertically(-1) == null && this.mRecyclerView.canScrollHorizontally(-1) == null) {
                        if (this.mRecyclerView.canScrollHorizontally(1) == null) {
                            c0715u = null;
                        }
                    }
                    accessibilityEvent.setScrollable(c0715u);
                    if (this.mRecyclerView.mAdapter != null) {
                        accessibilityEvent.setItemCount(this.mRecyclerView.mAdapter.getItemCount());
                    }
                }
            }
        }

        void onInitializeAccessibilityNodeInfoForItem(View view, C0483b c0483b) {
            C0718x childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && !this.mChildHelper.m2566c(childViewHolderInt.itemView)) {
                onInitializeAccessibilityNodeInfoForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, view, c0483b);
            }
        }

        public void onInitializeAccessibilityNodeInfoForItem(C0709p c0709p, C0715u c0715u, View view, C0483b c0483b) {
            c0483b.m1513b(C0482c.m1497a(canScrollVertically() != null ? getPosition(view) : 0, 1, canScrollHorizontally() != null ? getPosition(view) : 0, 1, false, false));
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.mRequestedSimpleAnimations = true;
        }

        public int getRowCountForAccessibility(C0709p c0709p, C0715u c0715u) {
            c0715u = true;
            if (this.mRecyclerView != null) {
                if (this.mRecyclerView.mAdapter != null) {
                    if (canScrollVertically() != null) {
                        c0715u = this.mRecyclerView.mAdapter.getItemCount();
                    }
                    return c0715u;
                }
            }
            return 1;
        }

        public int getColumnCountForAccessibility(C0709p c0709p, C0715u c0715u) {
            c0715u = true;
            if (this.mRecyclerView != null) {
                if (this.mRecyclerView.mAdapter != null) {
                    if (canScrollHorizontally() != null) {
                        c0715u = this.mRecyclerView.mAdapter.getItemCount();
                    }
                    return c0715u;
                }
            }
            return 1;
        }

        boolean performAccessibilityAction(int i, Bundle bundle) {
            return performAccessibilityAction(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, i, bundle);
        }

        public boolean performAccessibilityAction(C0709p c0709p, C0715u c0715u, int i, Bundle bundle) {
            if (this.mRecyclerView == null) {
                return false;
            }
            if (i == 4096) {
                c0709p = this.mRecyclerView.canScrollVertically(1) != null ? (getHeight() - getPaddingTop()) - getPaddingBottom() : null;
                if (this.mRecyclerView.canScrollHorizontally(1) != 0) {
                    i = (getWidth() - getPaddingLeft()) - getPaddingRight();
                    if (c0709p != null) {
                    }
                    this.mRecyclerView.scrollBy(i, c0709p);
                    return true;
                }
            } else if (i != Utility.DEFAULT_STREAM_BUFFER_SIZE) {
                c0709p = null;
            } else {
                c0709p = this.mRecyclerView.canScrollVertically(-1) != null ? -((getHeight() - getPaddingTop()) - getPaddingBottom()) : null;
                if (this.mRecyclerView.canScrollHorizontally(-1) != 0) {
                    i = -((getWidth() - getPaddingLeft()) - getPaddingRight());
                    if (c0709p != null && i == 0) {
                        return false;
                    }
                    this.mRecyclerView.scrollBy(i, c0709p);
                    return true;
                }
            }
            i = 0;
            if (c0709p != null) {
            }
            this.mRecyclerView.scrollBy(i, c0709p);
            return true;
        }

        boolean performAccessibilityActionForItem(View view, int i, Bundle bundle) {
            return performAccessibilityActionForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, view, i, bundle);
        }

        public static C0700b getProperties(Context context, AttributeSet attributeSet, int i, int i2) {
            C0700b c0700b = new C0700b();
            context = context.obtainStyledAttributes(attributeSet, C0635b.RecyclerView, i, i2);
            c0700b.f1810a = context.getInt(C0635b.RecyclerView_android_orientation, 1);
            c0700b.f1811b = context.getInt(C0635b.RecyclerView_spanCount, 1);
            c0700b.f1812c = context.getBoolean(C0635b.RecyclerView_reverseLayout, false);
            c0700b.f1813d = context.getBoolean(C0635b.RecyclerView_stackFromEnd, false);
            context.recycle();
            return c0700b;
        }

        void setExactMeasureSpecsFrom(RecyclerView recyclerView) {
            setMeasureSpecs(MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        boolean hasFlexibleChildInBothOrientations() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                LayoutParams layoutParams = getChildAt(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$j */
    public static class C0702j extends MarginLayoutParams {
        /* renamed from: c */
        C0718x f1814c;
        /* renamed from: d */
        final Rect f1815d = new Rect();
        /* renamed from: e */
        boolean f1816e = true;
        /* renamed from: f */
        boolean f1817f = false;

        public C0702j(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0702j(int i, int i2) {
            super(i, i2);
        }

        public C0702j(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public C0702j(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C0702j(C0702j c0702j) {
            super(c0702j);
        }

        /* renamed from: c */
        public boolean m2325c() {
            return this.f1814c.isInvalid();
        }

        /* renamed from: d */
        public boolean m2326d() {
            return this.f1814c.isRemoved();
        }

        /* renamed from: e */
        public boolean m2327e() {
            return this.f1814c.isUpdated();
        }

        /* renamed from: f */
        public int m2328f() {
            return this.f1814c.getLayoutPosition();
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$k */
    public interface C0703k {
        /* renamed from: a */
        void m2329a(View view);

        /* renamed from: b */
        void m2330b(View view);
    }

    /* renamed from: android.support.v7.widget.RecyclerView$l */
    public static abstract class C0704l {
        /* renamed from: a */
        public abstract boolean mo667a(int i, int i2);
    }

    /* renamed from: android.support.v7.widget.RecyclerView$m */
    public interface C0705m {
        /* renamed from: a */
        void mo626a(boolean z);

        /* renamed from: a */
        boolean mo627a(RecyclerView recyclerView, MotionEvent motionEvent);

        /* renamed from: b */
        void mo628b(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    /* renamed from: android.support.v7.widget.RecyclerView$n */
    public static abstract class C0706n {
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$o */
    public static class C0708o {
        /* renamed from: a */
        SparseArray<C0707a> f1822a = new SparseArray();
        /* renamed from: b */
        private int f1823b = 0;

        /* renamed from: android.support.v7.widget.RecyclerView$o$a */
        static class C0707a {
            /* renamed from: a */
            final ArrayList<C0718x> f1818a = new ArrayList();
            /* renamed from: b */
            int f1819b = 5;
            /* renamed from: c */
            long f1820c = 0;
            /* renamed from: d */
            long f1821d = 0;

            C0707a() {
            }
        }

        /* renamed from: a */
        public void m2338a() {
            for (int i = 0; i < this.f1822a.size(); i++) {
                ((C0707a) this.f1822a.valueAt(i)).f1818a.clear();
            }
        }

        /* renamed from: a */
        public C0718x m2337a(int i) {
            C0707a c0707a = (C0707a) this.f1822a.get(i);
            if (c0707a == null || c0707a.f1818a.isEmpty()) {
                return 0;
            }
            i = c0707a.f1818a;
            return (C0718x) i.remove(i.size() - 1);
        }

        /* renamed from: a */
        public void m2342a(C0718x c0718x) {
            int itemViewType = c0718x.getItemViewType();
            ArrayList arrayList = m2335b(itemViewType).f1818a;
            if (((C0707a) this.f1822a.get(itemViewType)).f1819b > arrayList.size()) {
                c0718x.resetInternal();
                arrayList.add(c0718x);
            }
        }

        /* renamed from: a */
        long m2336a(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        /* renamed from: a */
        void m2339a(int i, long j) {
            i = m2335b(i);
            i.f1820c = m2336a(i.f1820c, j);
        }

        /* renamed from: b */
        void m2345b(int i, long j) {
            i = m2335b(i);
            i.f1821d = m2336a(i.f1821d, j);
        }

        /* renamed from: a */
        boolean m2343a(int i, long j, long j2) {
            long j3 = m2335b(i).f1820c;
            if (j3 != 0) {
                if (j + j3 >= j2) {
                    return false;
                }
            }
            return true;
        }

        /* renamed from: b */
        boolean m2346b(int i, long j, long j2) {
            long j3 = m2335b(i).f1821d;
            if (j3 != 0) {
                if (j + j3 >= j2) {
                    return false;
                }
            }
            return true;
        }

        /* renamed from: a */
        void m2340a(C0689a c0689a) {
            this.f1823b++;
        }

        /* renamed from: b */
        void m2344b() {
            this.f1823b--;
        }

        /* renamed from: a */
        void m2341a(C0689a c0689a, C0689a c0689a2, boolean z) {
            if (c0689a != null) {
                m2344b();
            }
            if (!z && this.f1823b == null) {
                m2338a();
            }
            if (c0689a2 != null) {
                m2340a(c0689a2);
            }
        }

        /* renamed from: b */
        private C0707a m2335b(int i) {
            C0707a c0707a = (C0707a) this.f1822a.get(i);
            if (c0707a != null) {
                return c0707a;
            }
            c0707a = new C0707a();
            this.f1822a.put(i, c0707a);
            return c0707a;
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$p */
    public final class C0709p {
        /* renamed from: a */
        final ArrayList<C0718x> f1824a = new ArrayList();
        /* renamed from: b */
        ArrayList<C0718x> f1825b = null;
        /* renamed from: c */
        final ArrayList<C0718x> f1826c = new ArrayList();
        /* renamed from: d */
        int f1827d = 2;
        /* renamed from: e */
        C0708o f1828e;
        /* renamed from: f */
        final /* synthetic */ RecyclerView f1829f;
        /* renamed from: g */
        private final List<C0718x> f1830g = Collections.unmodifiableList(this.f1824a);
        /* renamed from: h */
        private int f1831h = 2;
        /* renamed from: i */
        private C0716v f1832i;

        public C0709p(RecyclerView recyclerView) {
            this.f1829f = recyclerView;
        }

        /* renamed from: a */
        public void m2354a() {
            this.f1824a.clear();
            m2375d();
        }

        /* renamed from: a */
        public void m2355a(int i) {
            this.f1831h = i;
            m2366b();
        }

        /* renamed from: b */
        void m2366b() {
            this.f1827d = this.f1831h + (this.f1829f.mLayout != null ? this.f1829f.mLayout.mPrefetchMaxCountObserved : 0);
            for (int size = this.f1826c.size() - 1; size >= 0 && this.f1826c.size() > this.f1827d; size--) {
                m2376d(size);
            }
        }

        /* renamed from: c */
        public List<C0718x> m2371c() {
            return this.f1830g;
        }

        /* renamed from: a */
        boolean m2363a(C0718x c0718x) {
            if (c0718x.isRemoved()) {
                return this.f1829f.mState.m2398a();
            }
            if (c0718x.mPosition < 0 || c0718x.mPosition >= this.f1829f.mAdapter.getItemCount()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Inconsistency detected. Invalid view holder adapter position");
                stringBuilder.append(c0718x);
                stringBuilder.append(this.f1829f.exceptionLabel());
                throw new IndexOutOfBoundsException(stringBuilder.toString());
            }
            boolean z = false;
            if (!this.f1829f.mState.m2398a() && this.f1829f.mAdapter.getItemViewType(c0718x.mPosition) != c0718x.getItemViewType()) {
                return false;
            }
            if (!this.f1829f.mAdapter.hasStableIds()) {
                return true;
            }
            if (c0718x.getItemId() == this.f1829f.mAdapter.getItemId(c0718x.mPosition)) {
                z = true;
            }
            return z;
        }

        /* renamed from: a */
        private boolean m2348a(C0718x c0718x, int i, int i2, long j) {
            c0718x.mOwnerRecyclerView = this.f1829f;
            int itemViewType = c0718x.getItemViewType();
            long nanoTime = this.f1829f.getNanoTime();
            if (j != Long.MAX_VALUE && this.f1828e.m2346b(itemViewType, nanoTime, j) == null) {
                return null;
            }
            this.f1829f.mAdapter.bindViewHolder(c0718x, i);
            this.f1828e.m2345b(c0718x.getItemViewType(), this.f1829f.getNanoTime() - nanoTime);
            m2349e(c0718x);
            if (this.f1829f.mState.m2398a() != 0) {
                c0718x.mPreLayoutPosition = i2;
            }
            return true;
        }

        /* renamed from: b */
        public int m2364b(int i) {
            if (i < 0 || i >= this.f1829f.mState.m2402e()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("invalid position ");
                stringBuilder.append(i);
                stringBuilder.append(". State ");
                stringBuilder.append("item count is ");
                stringBuilder.append(this.f1829f.mState.m2402e());
                stringBuilder.append(this.f1829f.exceptionLabel());
                throw new IndexOutOfBoundsException(stringBuilder.toString());
            } else if (this.f1829f.mState.m2398a()) {
                return this.f1829f.mAdapterHelper.m10612b(i);
            } else {
                return i;
            }
        }

        /* renamed from: c */
        public View m2370c(int i) {
            return m2353a(i, false);
        }

        /* renamed from: a */
        View m2353a(int i, boolean z) {
            return m2351a(i, z, Long.MAX_VALUE).itemView;
        }

        /* renamed from: a */
        C0718x m2351a(int i, boolean z, long j) {
            C0709p c0709p = this;
            int i2 = i;
            boolean z2 = z;
            if (i2 < 0 || i2 >= c0709p.f1829f.mState.m2402e()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid item position ");
                stringBuilder.append(i2);
                stringBuilder.append("(");
                stringBuilder.append(i2);
                stringBuilder.append("). Item count:");
                stringBuilder.append(c0709p.f1829f.mState.m2402e());
                stringBuilder.append(c0709p.f1829f.exceptionLabel());
                throw new IndexOutOfBoundsException(stringBuilder.toString());
            }
            C0718x f;
            Object obj;
            C0718x c0718x;
            Object obj2;
            LayoutParams layoutParams;
            C0702j c0702j;
            boolean z3 = true;
            int b;
            if (c0709p.f1829f.mState.m2398a()) {
                f = m2380f(i);
                if (f != null) {
                    obj = 1;
                    if (f == null) {
                        f = m2365b(i, z);
                        if (f != null) {
                            if (m2363a(f)) {
                                if (!z2) {
                                    f.addFlags(4);
                                    if (f.isScrap()) {
                                        c0709p.f1829f.removeDetachedView(f.itemView, false);
                                        f.unScrap();
                                    } else if (f.wasReturnedFromScrap()) {
                                        f.clearReturnedFromScrapFlag();
                                    }
                                    m2368b(f);
                                }
                                f = null;
                            } else {
                                obj = 1;
                            }
                        }
                    }
                    if (f == null) {
                        b = c0709p.f1829f.mAdapterHelper.m10612b(i2);
                        if (b >= 0 || b >= c0709p.f1829f.mAdapter.getItemCount()) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("Inconsistency detected. Invalid item position ");
                            stringBuilder.append(i2);
                            stringBuilder.append("(offset:");
                            stringBuilder.append(b);
                            stringBuilder.append(").");
                            stringBuilder.append("state:");
                            stringBuilder.append(c0709p.f1829f.mState.m2402e());
                            stringBuilder.append(c0709p.f1829f.exceptionLabel());
                            throw new IndexOutOfBoundsException(stringBuilder.toString());
                        }
                        int itemViewType = c0709p.f1829f.mAdapter.getItemViewType(b);
                        if (c0709p.f1829f.mAdapter.hasStableIds()) {
                            f = m2352a(c0709p.f1829f.mAdapter.getItemId(b), itemViewType, z2);
                            if (f != null) {
                                f.mPosition = b;
                                obj = 1;
                            }
                        }
                        if (f == null && c0709p.f1832i != null) {
                            View a = c0709p.f1832i.m2403a(c0709p, i2, itemViewType);
                            if (a != null) {
                                f = c0709p.f1829f.getChildViewHolder(a);
                                if (f == null) {
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append("getViewForPositionAndType returned a view which does not have a ViewHolder");
                                    stringBuilder.append(c0709p.f1829f.exceptionLabel());
                                    throw new IllegalArgumentException(stringBuilder.toString());
                                } else if (f.shouldIgnore()) {
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                                    stringBuilder.append(c0709p.f1829f.exceptionLabel());
                                    throw new IllegalArgumentException(stringBuilder.toString());
                                }
                            }
                        }
                        if (f == null) {
                            f = m2382g().m2337a(itemViewType);
                            if (f != null) {
                                f.resetInternal();
                                if (RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST) {
                                    m2350f(f);
                                }
                            }
                        }
                        if (f == null) {
                            long nanoTime = c0709p.f1829f.getNanoTime();
                            if (j != Long.MAX_VALUE && !c0709p.f1828e.m2343a(itemViewType, nanoTime, j)) {
                                return null;
                            }
                            C0718x createViewHolder = c0709p.f1829f.mAdapter.createViewHolder(c0709p.f1829f, itemViewType);
                            if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                                RecyclerView findNestedRecyclerView = RecyclerView.findNestedRecyclerView(createViewHolder.itemView);
                                if (findNestedRecyclerView != null) {
                                    createViewHolder.mNestedRecyclerView = new WeakReference(findNestedRecyclerView);
                                }
                            }
                            c0709p.f1828e.m2339a(itemViewType, c0709p.f1829f.getNanoTime() - nanoTime);
                            c0718x = createViewHolder;
                            obj2 = obj;
                            if (!(obj2 == null || c0709p.f1829f.mState.m2398a() || !c0718x.hasAnyOfTheFlags(Utility.DEFAULT_STREAM_BUFFER_SIZE))) {
                                c0718x.setFlags(0, Utility.DEFAULT_STREAM_BUFFER_SIZE);
                                if (c0709p.f1829f.mState.f1848i) {
                                    c0709p.f1829f.recordAnimationInfoIfBouncedHiddenView(c0718x, c0709p.f1829f.mItemAnimator.m2298a(c0709p.f1829f.mState, c0718x, C0697f.m2296e(c0718x) | 4096, c0718x.getUnmodifiedPayloads()));
                                }
                            }
                            if (c0709p.f1829f.mState.m2398a() || !c0718x.isBound()) {
                                if (c0718x.isBound() && !c0718x.needsUpdate()) {
                                    if (c0718x.isInvalid()) {
                                    }
                                }
                                z2 = m2348a(c0718x, c0709p.f1829f.mAdapterHelper.m10612b(i2), i, j);
                                layoutParams = c0718x.itemView.getLayoutParams();
                                if (layoutParams == null) {
                                    c0702j = (C0702j) c0709p.f1829f.generateDefaultLayoutParams();
                                    c0718x.itemView.setLayoutParams(c0702j);
                                } else if (c0709p.f1829f.checkLayoutParams(layoutParams)) {
                                    c0702j = (C0702j) c0709p.f1829f.generateLayoutParams(layoutParams);
                                    c0718x.itemView.setLayoutParams(c0702j);
                                } else {
                                    c0702j = (C0702j) layoutParams;
                                }
                                c0702j.f1814c = c0718x;
                                if (obj2 != null || !r0) {
                                    z3 = false;
                                }
                                c0702j.f1817f = z3;
                                return c0718x;
                            }
                            c0718x.mPreLayoutPosition = i2;
                            z2 = false;
                            layoutParams = c0718x.itemView.getLayoutParams();
                            if (layoutParams == null) {
                                c0702j = (C0702j) c0709p.f1829f.generateDefaultLayoutParams();
                                c0718x.itemView.setLayoutParams(c0702j);
                            } else if (c0709p.f1829f.checkLayoutParams(layoutParams)) {
                                c0702j = (C0702j) layoutParams;
                            } else {
                                c0702j = (C0702j) c0709p.f1829f.generateLayoutParams(layoutParams);
                                c0718x.itemView.setLayoutParams(c0702j);
                            }
                            c0702j.f1814c = c0718x;
                            if (obj2 != null) {
                            }
                            z3 = false;
                            c0702j.f1817f = z3;
                            return c0718x;
                        }
                    }
                    c0718x = f;
                    obj2 = obj;
                    c0718x.setFlags(0, Utility.DEFAULT_STREAM_BUFFER_SIZE);
                    if (c0709p.f1829f.mState.f1848i) {
                        c0709p.f1829f.recordAnimationInfoIfBouncedHiddenView(c0718x, c0709p.f1829f.mItemAnimator.m2298a(c0709p.f1829f.mState, c0718x, C0697f.m2296e(c0718x) | 4096, c0718x.getUnmodifiedPayloads()));
                    }
                    if (c0709p.f1829f.mState.m2398a()) {
                    }
                    if (c0718x.isInvalid()) {
                        z2 = m2348a(c0718x, c0709p.f1829f.mAdapterHelper.m10612b(i2), i, j);
                        layoutParams = c0718x.itemView.getLayoutParams();
                        if (layoutParams == null) {
                            c0702j = (C0702j) c0709p.f1829f.generateDefaultLayoutParams();
                            c0718x.itemView.setLayoutParams(c0702j);
                        } else if (c0709p.f1829f.checkLayoutParams(layoutParams)) {
                            c0702j = (C0702j) c0709p.f1829f.generateLayoutParams(layoutParams);
                            c0718x.itemView.setLayoutParams(c0702j);
                        } else {
                            c0702j = (C0702j) layoutParams;
                        }
                        c0702j.f1814c = c0718x;
                        if (obj2 != null) {
                        }
                        z3 = false;
                        c0702j.f1817f = z3;
                        return c0718x;
                    }
                    z2 = false;
                    layoutParams = c0718x.itemView.getLayoutParams();
                    if (layoutParams == null) {
                        c0702j = (C0702j) c0709p.f1829f.generateDefaultLayoutParams();
                        c0718x.itemView.setLayoutParams(c0702j);
                    } else if (c0709p.f1829f.checkLayoutParams(layoutParams)) {
                        c0702j = (C0702j) layoutParams;
                    } else {
                        c0702j = (C0702j) c0709p.f1829f.generateLayoutParams(layoutParams);
                        c0718x.itemView.setLayoutParams(c0702j);
                    }
                    c0702j.f1814c = c0718x;
                    if (obj2 != null) {
                    }
                    z3 = false;
                    c0702j.f1817f = z3;
                    return c0718x;
                }
            }
            f = null;
            obj = null;
            if (f == null) {
                f = m2365b(i, z);
                if (f != null) {
                    if (m2363a(f)) {
                        obj = 1;
                    } else {
                        if (z2) {
                            f.addFlags(4);
                            if (f.isScrap()) {
                                c0709p.f1829f.removeDetachedView(f.itemView, false);
                                f.unScrap();
                            } else if (f.wasReturnedFromScrap()) {
                                f.clearReturnedFromScrapFlag();
                            }
                            m2368b(f);
                        }
                        f = null;
                    }
                }
            }
            if (f == null) {
                b = c0709p.f1829f.mAdapterHelper.m10612b(i2);
                if (b >= 0) {
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("Inconsistency detected. Invalid item position ");
                stringBuilder.append(i2);
                stringBuilder.append("(offset:");
                stringBuilder.append(b);
                stringBuilder.append(").");
                stringBuilder.append("state:");
                stringBuilder.append(c0709p.f1829f.mState.m2402e());
                stringBuilder.append(c0709p.f1829f.exceptionLabel());
                throw new IndexOutOfBoundsException(stringBuilder.toString());
            }
            c0718x = f;
            obj2 = obj;
            c0718x.setFlags(0, Utility.DEFAULT_STREAM_BUFFER_SIZE);
            if (c0709p.f1829f.mState.f1848i) {
                c0709p.f1829f.recordAnimationInfoIfBouncedHiddenView(c0718x, c0709p.f1829f.mItemAnimator.m2298a(c0709p.f1829f.mState, c0718x, C0697f.m2296e(c0718x) | 4096, c0718x.getUnmodifiedPayloads()));
            }
            if (c0709p.f1829f.mState.m2398a()) {
            }
            if (c0718x.isInvalid()) {
                z2 = m2348a(c0718x, c0709p.f1829f.mAdapterHelper.m10612b(i2), i, j);
                layoutParams = c0718x.itemView.getLayoutParams();
                if (layoutParams == null) {
                    c0702j = (C0702j) c0709p.f1829f.generateDefaultLayoutParams();
                    c0718x.itemView.setLayoutParams(c0702j);
                } else if (c0709p.f1829f.checkLayoutParams(layoutParams)) {
                    c0702j = (C0702j) c0709p.f1829f.generateLayoutParams(layoutParams);
                    c0718x.itemView.setLayoutParams(c0702j);
                } else {
                    c0702j = (C0702j) layoutParams;
                }
                c0702j.f1814c = c0718x;
                if (obj2 != null) {
                }
                z3 = false;
                c0702j.f1817f = z3;
                return c0718x;
            }
            z2 = false;
            layoutParams = c0718x.itemView.getLayoutParams();
            if (layoutParams == null) {
                c0702j = (C0702j) c0709p.f1829f.generateDefaultLayoutParams();
                c0718x.itemView.setLayoutParams(c0702j);
            } else if (c0709p.f1829f.checkLayoutParams(layoutParams)) {
                c0702j = (C0702j) layoutParams;
            } else {
                c0702j = (C0702j) c0709p.f1829f.generateLayoutParams(layoutParams);
                c0718x.itemView.setLayoutParams(c0702j);
            }
            c0702j.f1814c = c0718x;
            if (obj2 != null) {
            }
            z3 = false;
            c0702j.f1817f = z3;
            return c0718x;
        }

        /* renamed from: e */
        private void m2349e(C0718x c0718x) {
            if (this.f1829f.isAccessibilityEnabled()) {
                View view = c0718x.itemView;
                if (C0517s.m1709d(view) == 0) {
                    C0517s.m1688a(view, 1);
                }
                if (!C0517s.m1701a(view)) {
                    c0718x.addFlags(16384);
                    C0517s.m1695a(view, this.f1829f.mAccessibilityDelegate.m10507b());
                }
            }
        }

        /* renamed from: f */
        private void m2350f(C0718x c0718x) {
            if (c0718x.itemView instanceof ViewGroup) {
                m2347a((ViewGroup) c0718x.itemView, false);
            }
        }

        /* renamed from: a */
        private void m2347a(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    m2347a((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility()) {
                    viewGroup.setVisibility(false);
                    viewGroup.setVisibility(4);
                } else {
                    z = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(z);
                }
            }
        }

        /* renamed from: a */
        public void m2362a(View view) {
            C0718x childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isTmpDetached()) {
                this.f1829f.removeDetachedView(view, false);
            }
            if (childViewHolderInt.isScrap() != null) {
                childViewHolderInt.unScrap();
            } else if (childViewHolderInt.wasReturnedFromScrap() != null) {
                childViewHolderInt.clearReturnedFromScrapFlag();
            }
            m2368b(childViewHolderInt);
        }

        /* renamed from: d */
        void m2375d() {
            for (int size = this.f1826c.size() - 1; size >= 0; size--) {
                m2376d(size);
            }
            this.f1826c.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                this.f1829f.mPrefetchRegistry.m10437a();
            }
        }

        /* renamed from: d */
        void m2376d(int i) {
            m2361a((C0718x) this.f1826c.get(i), true);
            this.f1826c.remove(i);
        }

        /* renamed from: b */
        void m2368b(C0718x c0718x) {
            boolean z = false;
            if (!c0718x.isScrap()) {
                if (c0718x.itemView.getParent() == null) {
                    if (c0718x.isTmpDetached()) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
                        stringBuilder.append(c0718x);
                        stringBuilder.append(this.f1829f.exceptionLabel());
                        throw new IllegalArgumentException(stringBuilder.toString());
                    } else if (c0718x.shouldIgnore()) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
                        stringBuilder2.append(this.f1829f.exceptionLabel());
                        throw new IllegalArgumentException(stringBuilder2.toString());
                    } else {
                        boolean access$900 = c0718x.doesTransientStatePreventRecycling();
                        Object obj = (this.f1829f.mAdapter != null && access$900 && this.f1829f.mAdapter.onFailedToRecycleView(c0718x)) ? 1 : null;
                        if (obj == null) {
                            if (!c0718x.isRecyclable()) {
                                obj = null;
                                this.f1829f.mViewInfoStore.m2838g(c0718x);
                                if (obj == null && !r1 && access$900) {
                                    c0718x.mOwnerRecyclerView = null;
                                    return;
                                }
                                return;
                            }
                        }
                        if (this.f1827d <= 0 || c0718x.hasAnyOfTheFlags(526)) {
                            obj = null;
                        } else {
                            int size = this.f1826c.size();
                            if (size >= this.f1827d && size > 0) {
                                m2376d(0);
                                size--;
                            }
                            if (RecyclerView.ALLOW_THREAD_GAP_WORK && size > 0 && !this.f1829f.mPrefetchRegistry.m10440a(c0718x.mPosition)) {
                                size--;
                                while (size >= 0) {
                                    if (!this.f1829f.mPrefetchRegistry.m10440a(((C0718x) this.f1826c.get(size)).mPosition)) {
                                        break;
                                    }
                                    size--;
                                }
                                size++;
                            }
                            this.f1826c.add(size, c0718x);
                            obj = 1;
                        }
                        if (obj == null) {
                            m2361a(c0718x, true);
                            z = true;
                        }
                        this.f1829f.mViewInfoStore.m2838g(c0718x);
                        if (obj == null) {
                            return;
                        }
                        return;
                    }
                }
            }
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Scrapped or attached views may not be recycled. isScrap:");
            stringBuilder3.append(c0718x.isScrap());
            stringBuilder3.append(" isAttached:");
            if (c0718x.itemView.getParent() != null) {
                z = true;
            }
            stringBuilder3.append(z);
            stringBuilder3.append(this.f1829f.exceptionLabel());
            throw new IllegalArgumentException(stringBuilder3.toString());
        }

        /* renamed from: a */
        void m2361a(C0718x c0718x, boolean z) {
            RecyclerView.clearNestedRecyclerViewIfNotNested(c0718x);
            if (c0718x.hasAnyOfTheFlags(16384)) {
                c0718x.setFlags(0, 16384);
                C0517s.m1695a(c0718x.itemView, null);
            }
            if (z) {
                m2377d(c0718x);
            }
            c0718x.mOwnerRecyclerView = null;
            m2382g().m2342a(c0718x);
        }

        /* renamed from: b */
        void m2369b(View view) {
            C0718x childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.mScrapContainer = null;
            childViewHolderInt.mInChangeScrap = false;
            childViewHolderInt.clearReturnedFromScrapFlag();
            m2368b(childViewHolderInt);
        }

        /* renamed from: c */
        void m2374c(View view) {
            view = RecyclerView.getChildViewHolderInt(view);
            if (!view.hasAnyOfTheFlags(12) && view.isUpdated()) {
                if (!this.f1829f.canReuseUpdatedViewHolder(view)) {
                    if (this.f1825b == null) {
                        this.f1825b = new ArrayList();
                    }
                    view.setScrapContainer(this, true);
                    this.f1825b.add(view);
                    return;
                }
            }
            if (view.isInvalid() && !view.isRemoved()) {
                if (!this.f1829f.mAdapter.hasStableIds()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
                    stringBuilder.append(this.f1829f.exceptionLabel());
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            view.setScrapContainer(this, false);
            this.f1824a.add(view);
        }

        /* renamed from: c */
        void m2373c(C0718x c0718x) {
            if (c0718x.mInChangeScrap) {
                this.f1825b.remove(c0718x);
            } else {
                this.f1824a.remove(c0718x);
            }
            c0718x.mScrapContainer = null;
            c0718x.mInChangeScrap = false;
            c0718x.clearReturnedFromScrapFlag();
        }

        /* renamed from: e */
        int m2378e() {
            return this.f1824a.size();
        }

        /* renamed from: e */
        View m2379e(int i) {
            return ((C0718x) this.f1824a.get(i)).itemView;
        }

        /* renamed from: f */
        void m2381f() {
            this.f1824a.clear();
            if (this.f1825b != null) {
                this.f1825b.clear();
            }
        }

        /* renamed from: f */
        C0718x m2380f(int i) {
            if (this.f1825b != null) {
                int size = this.f1825b.size();
                if (size != 0) {
                    int i2 = 0;
                    int i3 = 0;
                    while (i3 < size) {
                        C0718x c0718x = (C0718x) this.f1825b.get(i3);
                        if (c0718x.wasReturnedFromScrap() || c0718x.getLayoutPosition() != i) {
                            i3++;
                        } else {
                            c0718x.addFlags(32);
                            return c0718x;
                        }
                    }
                    if (this.f1829f.mAdapter.hasStableIds()) {
                        i = this.f1829f.mAdapterHelper.m10612b(i);
                        if (i > 0 && i < this.f1829f.mAdapter.getItemCount()) {
                            long itemId = this.f1829f.mAdapter.getItemId(i);
                            while (i2 < size) {
                                C0718x c0718x2 = (C0718x) this.f1825b.get(i2);
                                if (c0718x2.wasReturnedFromScrap() || c0718x2.getItemId() != itemId) {
                                    i2++;
                                } else {
                                    c0718x2.addFlags(32);
                                    return c0718x2;
                                }
                            }
                        }
                    }
                    return null;
                }
            }
            return null;
        }

        /* renamed from: b */
        C0718x m2365b(int i, boolean z) {
            int size = this.f1824a.size();
            int i2 = 0;
            int i3 = 0;
            while (i3 < size) {
                C0718x c0718x = (C0718x) this.f1824a.get(i3);
                if (c0718x.wasReturnedFromScrap() || c0718x.getLayoutPosition() != i || c0718x.isInvalid() || (!this.f1829f.mState.f1845f && c0718x.isRemoved())) {
                    i3++;
                } else {
                    c0718x.addFlags(32);
                    return c0718x;
                }
            }
            if (!z) {
                View c = this.f1829f.mChildHelper.m2565c(i);
                if (c != null) {
                    i = RecyclerView.getChildViewHolderInt(c);
                    this.f1829f.mChildHelper.m2570e(c);
                    int b = this.f1829f.mChildHelper.m2562b(c);
                    if (b != true) {
                        this.f1829f.mChildHelper.m2569e(b);
                        m2374c(c);
                        i.addFlags(true);
                        return i;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("layout index should not be -1 after unhiding a view:");
                    stringBuilder.append(i);
                    stringBuilder.append(this.f1829f.exceptionLabel());
                    throw new IllegalStateException(stringBuilder.toString());
                }
            }
            size = this.f1826c.size();
            while (i2 < size) {
                C0718x c0718x2 = (C0718x) this.f1826c.get(i2);
                if (c0718x2.isInvalid() || c0718x2.getLayoutPosition() != i) {
                    i2++;
                } else {
                    if (!z) {
                        this.f1826c.remove(i2);
                    }
                    return c0718x2;
                }
            }
            return 0;
        }

        /* renamed from: a */
        C0718x m2352a(long j, int i, boolean z) {
            int size;
            for (size = this.f1824a.size() - 1; size >= 0; size--) {
                C0718x c0718x = (C0718x) this.f1824a.get(size);
                if (c0718x.getItemId() == j && !c0718x.wasReturnedFromScrap()) {
                    if (i == c0718x.getItemViewType()) {
                        c0718x.addFlags(32);
                        if (c0718x.isRemoved() != null && this.f1829f.mState.m2398a() == null) {
                            c0718x.setFlags(2, 14);
                        }
                        return c0718x;
                    } else if (!z) {
                        this.f1824a.remove(size);
                        this.f1829f.removeDetachedView(c0718x.itemView, false);
                        m2369b(c0718x.itemView);
                    }
                }
            }
            for (size = this.f1826c.size() - 1; size >= 0; size--) {
                C0718x c0718x2 = (C0718x) this.f1826c.get(size);
                if (c0718x2.getItemId() == j) {
                    if (i == c0718x2.getItemViewType()) {
                        if (!z) {
                            this.f1826c.remove(size);
                        }
                        return c0718x2;
                    } else if (!z) {
                        m2376d(size);
                        return null;
                    }
                }
            }
            return null;
        }

        /* renamed from: d */
        void m2377d(C0718x c0718x) {
            if (this.f1829f.mRecyclerListener != null) {
                this.f1829f.mRecyclerListener.m2386a(c0718x);
            }
            if (this.f1829f.mAdapter != null) {
                this.f1829f.mAdapter.onViewRecycled(c0718x);
            }
            if (this.f1829f.mState != null) {
                this.f1829f.mViewInfoStore.m2838g(c0718x);
            }
        }

        /* renamed from: a */
        void m2358a(C0689a c0689a, C0689a c0689a2, boolean z) {
            m2354a();
            m2382g().m2341a(c0689a, c0689a2, z);
        }

        /* renamed from: a */
        void m2356a(int i, int i2) {
            int i3;
            int i4;
            int i5;
            if (i < i2) {
                i5 = i;
                i3 = i2;
                i4 = -1;
            } else {
                i3 = i;
                i5 = i2;
                i4 = 1;
            }
            int size = this.f1826c.size();
            for (int i6 = 0; i6 < size; i6++) {
                C0718x c0718x = (C0718x) this.f1826c.get(i6);
                if (c0718x != null && c0718x.mPosition >= r0) {
                    if (c0718x.mPosition <= i3) {
                        if (c0718x.mPosition == i) {
                            c0718x.offsetPosition(i2 - i, false);
                        } else {
                            c0718x.offsetPosition(i4, false);
                        }
                    }
                }
            }
        }

        /* renamed from: b */
        void m2367b(int i, int i2) {
            int size = this.f1826c.size();
            for (int i3 = 0; i3 < size; i3++) {
                C0718x c0718x = (C0718x) this.f1826c.get(i3);
                if (c0718x != null && c0718x.mPosition >= i) {
                    c0718x.offsetPosition(i2, true);
                }
            }
        }

        /* renamed from: a */
        void m2357a(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.f1826c.size() - 1; size >= 0; size--) {
                C0718x c0718x = (C0718x) this.f1826c.get(size);
                if (c0718x != null) {
                    if (c0718x.mPosition >= i3) {
                        c0718x.offsetPosition(-i2, z);
                    } else if (c0718x.mPosition >= i) {
                        c0718x.addFlags(8);
                        m2376d(size);
                    }
                }
            }
        }

        /* renamed from: a */
        void m2360a(C0716v c0716v) {
            this.f1832i = c0716v;
        }

        /* renamed from: a */
        void m2359a(C0708o c0708o) {
            if (this.f1828e != null) {
                this.f1828e.m2344b();
            }
            this.f1828e = c0708o;
            if (c0708o != null) {
                this.f1828e.m2340a(this.f1829f.getAdapter());
            }
        }

        /* renamed from: g */
        C0708o m2382g() {
            if (this.f1828e == null) {
                this.f1828e = new C0708o();
            }
            return this.f1828e;
        }

        /* renamed from: c */
        void m2372c(int i, int i2) {
            i2 += i;
            for (int size = this.f1826c.size() - 1; size >= 0; size--) {
                C0718x c0718x = (C0718x) this.f1826c.get(size);
                if (c0718x != null) {
                    int i3 = c0718x.mPosition;
                    if (i3 >= i && i3 < i2) {
                        c0718x.addFlags(2);
                        m2376d(size);
                    }
                }
            }
        }

        /* renamed from: h */
        void m2383h() {
            int size = this.f1826c.size();
            for (int i = 0; i < size; i++) {
                C0718x c0718x = (C0718x) this.f1826c.get(i);
                if (c0718x != null) {
                    c0718x.addFlags(6);
                    c0718x.addChangePayload(null);
                }
            }
            if (this.f1829f.mAdapter == null || !this.f1829f.mAdapter.hasStableIds()) {
                m2375d();
            }
        }

        /* renamed from: i */
        void m2384i() {
            int i;
            int size = this.f1826c.size();
            for (i = 0; i < size; i++) {
                ((C0718x) this.f1826c.get(i)).clearOldPosition();
            }
            size = this.f1824a.size();
            for (i = 0; i < size; i++) {
                ((C0718x) this.f1824a.get(i)).clearOldPosition();
            }
            if (this.f1825b != null) {
                size = this.f1825b.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((C0718x) this.f1825b.get(i2)).clearOldPosition();
                }
            }
        }

        /* renamed from: j */
        void m2385j() {
            int size = this.f1826c.size();
            for (int i = 0; i < size; i++) {
                C0702j c0702j = (C0702j) ((C0718x) this.f1826c.get(i)).itemView.getLayoutParams();
                if (c0702j != null) {
                    c0702j.f1816e = true;
                }
            }
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$q */
    public interface C0710q {
        /* renamed from: a */
        void m2386a(C0718x c0718x);
    }

    /* renamed from: android.support.v7.widget.RecyclerView$t */
    public static abstract class C0714t {
        private C0701i mLayoutManager;
        private boolean mPendingInitialRun;
        private RecyclerView mRecyclerView;
        private final C0712a mRecyclingAction = new C0712a(0, 0);
        private boolean mRunning;
        private int mTargetPosition = -1;
        private View mTargetView;

        /* renamed from: android.support.v7.widget.RecyclerView$t$a */
        public static class C0712a {
            /* renamed from: a */
            private int f1833a;
            /* renamed from: b */
            private int f1834b;
            /* renamed from: c */
            private int f1835c;
            /* renamed from: d */
            private int f1836d;
            /* renamed from: e */
            private Interpolator f1837e;
            /* renamed from: f */
            private boolean f1838f;
            /* renamed from: g */
            private int f1839g;

            public C0712a(int i, int i2) {
                this(i, i2, LinearLayoutManager.INVALID_OFFSET, null);
            }

            public C0712a(int i, int i2, int i3, Interpolator interpolator) {
                this.f1836d = -1;
                this.f1838f = false;
                this.f1839g = 0;
                this.f1833a = i;
                this.f1834b = i2;
                this.f1835c = i3;
                this.f1837e = interpolator;
            }

            /* renamed from: a */
            public void m2391a(int i) {
                this.f1836d = i;
            }

            /* renamed from: a */
            boolean m2394a() {
                return this.f1836d >= 0;
            }

            /* renamed from: a */
            void m2393a(RecyclerView recyclerView) {
                if (this.f1836d >= 0) {
                    int i = this.f1836d;
                    this.f1836d = -1;
                    recyclerView.jumpToPositionForSmoothScroller(i);
                    this.f1838f = false;
                    return;
                }
                if (this.f1838f) {
                    m2390b();
                    if (this.f1837e != null) {
                        recyclerView.mViewFlinger.m2413a(this.f1833a, this.f1834b, this.f1835c, this.f1837e);
                    } else if (this.f1835c == LinearLayoutManager.INVALID_OFFSET) {
                        recyclerView.mViewFlinger.m2416b(this.f1833a, this.f1834b);
                    } else {
                        recyclerView.mViewFlinger.m2411a(this.f1833a, this.f1834b, this.f1835c);
                    }
                    this.f1839g++;
                    if (this.f1839g > 10) {
                        Log.e(RecyclerView.TAG, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f1838f = false;
                } else {
                    this.f1839g = 0;
                }
            }

            /* renamed from: b */
            private void m2390b() {
                if (this.f1837e != null) {
                    if (this.f1835c < 1) {
                        throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                    }
                }
                if (this.f1835c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            /* renamed from: a */
            public void m2392a(int i, int i2, int i3, Interpolator interpolator) {
                this.f1833a = i;
                this.f1834b = i2;
                this.f1835c = i3;
                this.f1837e = interpolator;
                this.f1838f = true;
            }
        }

        /* renamed from: android.support.v7.widget.RecyclerView$t$b */
        public interface C0713b {
            PointF computeScrollVectorForPosition(int i);
        }

        protected abstract void onSeekTargetStep(int i, int i2, C0715u c0715u, C0712a c0712a);

        protected abstract void onStart();

        protected abstract void onStop();

        protected abstract void onTargetFound(View view, C0715u c0715u, C0712a c0712a);

        void start(RecyclerView recyclerView, C0701i c0701i) {
            this.mRecyclerView = recyclerView;
            this.mLayoutManager = c0701i;
            if (this.mTargetPosition != -1) {
                this.mRecyclerView.mState.f1855p = this.mTargetPosition;
                this.mRunning = true;
                this.mPendingInitialRun = true;
                this.mTargetView = findViewByPosition(getTargetPosition());
                onStart();
                this.mRecyclerView.mViewFlinger.m2409a();
                return;
            }
            throw new IllegalArgumentException("Invalid target position");
        }

        public void setTargetPosition(int i) {
            this.mTargetPosition = i;
        }

        public C0701i getLayoutManager() {
            return this.mLayoutManager;
        }

        protected final void stop() {
            if (this.mRunning) {
                this.mRunning = false;
                onStop();
                this.mRecyclerView.mState.f1855p = -1;
                this.mTargetView = null;
                this.mTargetPosition = -1;
                this.mPendingInitialRun = false;
                this.mLayoutManager.onSmoothScrollerStopped(this);
                this.mLayoutManager = null;
                this.mRecyclerView = null;
            }
        }

        public boolean isPendingInitialRun() {
            return this.mPendingInitialRun;
        }

        public boolean isRunning() {
            return this.mRunning;
        }

        public int getTargetPosition() {
            return this.mTargetPosition;
        }

        private void onAnimation(int i, int i2) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (!this.mRunning || this.mTargetPosition == -1 || recyclerView == null) {
                stop();
            }
            this.mPendingInitialRun = false;
            if (this.mTargetView != null) {
                if (getChildPosition(this.mTargetView) == this.mTargetPosition) {
                    onTargetFound(this.mTargetView, recyclerView.mState, this.mRecyclingAction);
                    this.mRecyclingAction.m2393a(recyclerView);
                    stop();
                } else {
                    Log.e(RecyclerView.TAG, "Passed over target position while smooth scrolling.");
                    this.mTargetView = null;
                }
            }
            if (this.mRunning) {
                onSeekTargetStep(i, i2, recyclerView.mState, this.mRecyclingAction);
                i = this.mRecyclingAction.m2394a();
                this.mRecyclingAction.m2393a(recyclerView);
                if (i == 0) {
                    return;
                }
                if (this.mRunning != 0) {
                    this.mPendingInitialRun = true;
                    recyclerView.mViewFlinger.m2409a();
                    return;
                }
                stop();
            }
        }

        public int getChildPosition(View view) {
            return this.mRecyclerView.getChildLayoutPosition(view);
        }

        public int getChildCount() {
            return this.mRecyclerView.mLayout.getChildCount();
        }

        public View findViewByPosition(int i) {
            return this.mRecyclerView.mLayout.findViewByPosition(i);
        }

        @Deprecated
        public void instantScrollToPosition(int i) {
            this.mRecyclerView.scrollToPosition(i);
        }

        protected void onChildAttachedToWindow(View view) {
            if (getChildPosition(view) == getTargetPosition()) {
                this.mTargetView = view;
            }
        }

        protected void normalize(PointF pointF) {
            float sqrt = (float) Math.sqrt((double) ((pointF.x * pointF.x) + (pointF.y * pointF.y)));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$u */
    public static class C0715u {
        /* renamed from: a */
        int f1840a = 0;
        /* renamed from: b */
        int f1841b = 0;
        /* renamed from: c */
        int f1842c = 1;
        /* renamed from: d */
        int f1843d = 0;
        /* renamed from: e */
        boolean f1844e = false;
        /* renamed from: f */
        boolean f1845f = false;
        /* renamed from: g */
        boolean f1846g = false;
        /* renamed from: h */
        boolean f1847h = false;
        /* renamed from: i */
        boolean f1848i = false;
        /* renamed from: j */
        boolean f1849j = false;
        /* renamed from: k */
        int f1850k;
        /* renamed from: l */
        long f1851l;
        /* renamed from: m */
        int f1852m;
        /* renamed from: n */
        int f1853n;
        /* renamed from: o */
        int f1854o;
        /* renamed from: p */
        private int f1855p = -1;
        /* renamed from: q */
        private SparseArray<Object> f1856q;

        /* renamed from: a */
        void m2396a(int i) {
            if ((this.f1842c & i) == 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Layout state should be one of ");
                stringBuilder.append(Integer.toBinaryString(i));
                stringBuilder.append(" but it is ");
                stringBuilder.append(Integer.toBinaryString(this.f1842c));
                throw new IllegalStateException(stringBuilder.toString());
            }
        }

        /* renamed from: a */
        void m2397a(C0689a c0689a) {
            this.f1842c = 1;
            this.f1843d = c0689a.getItemCount();
            this.f1845f = false;
            this.f1846g = false;
            this.f1847h = false;
        }

        /* renamed from: a */
        public boolean m2398a() {
            return this.f1845f;
        }

        /* renamed from: b */
        public boolean m2399b() {
            return this.f1849j;
        }

        /* renamed from: c */
        public int m2400c() {
            return this.f1855p;
        }

        /* renamed from: d */
        public boolean m2401d() {
            return this.f1855p != -1;
        }

        /* renamed from: e */
        public int m2402e() {
            return this.f1845f ? this.f1840a - this.f1841b : this.f1843d;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("State{mTargetPosition=");
            stringBuilder.append(this.f1855p);
            stringBuilder.append(", mData=");
            stringBuilder.append(this.f1856q);
            stringBuilder.append(", mItemCount=");
            stringBuilder.append(this.f1843d);
            stringBuilder.append(", mIsMeasuring=");
            stringBuilder.append(this.f1847h);
            stringBuilder.append(", mPreviousLayoutItemCount=");
            stringBuilder.append(this.f1840a);
            stringBuilder.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
            stringBuilder.append(this.f1841b);
            stringBuilder.append(", mStructureChanged=");
            stringBuilder.append(this.f1844e);
            stringBuilder.append(", mInPreLayout=");
            stringBuilder.append(this.f1845f);
            stringBuilder.append(", mRunSimpleAnimations=");
            stringBuilder.append(this.f1848i);
            stringBuilder.append(", mRunPredictiveAnimations=");
            stringBuilder.append(this.f1849j);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$v */
    public static abstract class C0716v {
        /* renamed from: a */
        public abstract View m2403a(C0709p c0709p, int i, int i2);
    }

    /* renamed from: android.support.v7.widget.RecyclerView$w */
    class C0717w implements Runnable {
        /* renamed from: a */
        Interpolator f1857a = RecyclerView.sQuinticInterpolator;
        /* renamed from: b */
        final /* synthetic */ RecyclerView f1858b;
        /* renamed from: c */
        private int f1859c;
        /* renamed from: d */
        private int f1860d;
        /* renamed from: e */
        private OverScroller f1861e;
        /* renamed from: f */
        private boolean f1862f = false;
        /* renamed from: g */
        private boolean f1863g = false;

        C0717w(RecyclerView recyclerView) {
            this.f1858b = recyclerView;
            this.f1861e = new OverScroller(recyclerView.getContext(), RecyclerView.sQuinticInterpolator);
        }

        public void run() {
            if (this.f1858b.mLayout == null) {
                m2415b();
                return;
            }
            m2407c();
            r0.f1858b.consumePendingUpdateOperations();
            OverScroller overScroller = r0.f1861e;
            C0714t c0714t = r0.f1858b.mLayout.mSmoothScroller;
            if (overScroller.computeScrollOffset()) {
                int scrollHorizontallyBy;
                int i;
                int scrollVerticallyBy;
                int i2;
                int e;
                int[] access$500 = r0.f1858b.mScrollConsumed;
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i3 = currX - r0.f1859c;
                int i4 = currY - r0.f1860d;
                r0.f1859c = currX;
                r0.f1860d = currY;
                if (r0.f1858b.dispatchNestedPreScroll(i3, i4, access$500, null, 1)) {
                    i3 -= access$500[0];
                    i4 -= access$500[1];
                }
                if (r0.f1858b.mAdapter != null) {
                    r0.f1858b.startInterceptRequestLayout();
                    r0.f1858b.onEnterLayoutOrScroll();
                    C0397h.m1177a(RecyclerView.TRACE_SCROLL_TAG);
                    r0.f1858b.fillRemainingScrollValues(r0.f1858b.mState);
                    if (i3 != 0) {
                        scrollHorizontallyBy = r0.f1858b.mLayout.scrollHorizontallyBy(i3, r0.f1858b.mRecycler, r0.f1858b.mState);
                        i = i3 - scrollHorizontallyBy;
                    } else {
                        scrollHorizontallyBy = 0;
                        i = 0;
                    }
                    if (i4 != 0) {
                        scrollVerticallyBy = r0.f1858b.mLayout.scrollVerticallyBy(i4, r0.f1858b.mRecycler, r0.f1858b.mState);
                        i2 = i4 - scrollVerticallyBy;
                    } else {
                        scrollVerticallyBy = 0;
                        i2 = 0;
                    }
                    C0397h.m1176a();
                    r0.f1858b.repositionShadowingViews();
                    r0.f1858b.onExitLayoutOrScroll();
                    r0.f1858b.stopInterceptRequestLayout(false);
                    if (!(c0714t == null || c0714t.isPendingInitialRun() || !c0714t.isRunning())) {
                        e = r0.f1858b.mState.m2402e();
                        if (e == 0) {
                            c0714t.stop();
                        } else if (c0714t.getTargetPosition() >= e) {
                            c0714t.setTargetPosition(e - 1);
                            c0714t.onAnimation(i3 - i, i4 - i2);
                        } else {
                            c0714t.onAnimation(i3 - i, i4 - i2);
                        }
                    }
                } else {
                    scrollHorizontallyBy = 0;
                    i = 0;
                    scrollVerticallyBy = 0;
                    i2 = 0;
                }
                if (!r0.f1858b.mItemDecorations.isEmpty()) {
                    r0.f1858b.invalidate();
                }
                if (r0.f1858b.getOverScrollMode() != 2) {
                    r0.f1858b.considerReleasingGlowsOnScroll(i3, i4);
                }
                if (!(r0.f1858b.dispatchNestedScroll(scrollHorizontallyBy, scrollVerticallyBy, i, i2, null, 1) || (i == 0 && i2 == 0))) {
                    int i5;
                    e = (int) overScroller.getCurrVelocity();
                    if (i != currX) {
                        if (i < 0) {
                            i5 = -e;
                        } else if (i > 0) {
                            i5 = e;
                        }
                        if (i2 != currY) {
                            if (i2 < 0) {
                                e = -e;
                            } else if (i2 > 0) {
                            }
                            if (r0.f1858b.getOverScrollMode() != 2) {
                                r0.f1858b.absorbGlows(i5, e);
                            }
                            if ((i5 != 0 || i == currX || overScroller.getFinalX() == 0) && (e != 0 || i2 == currY || overScroller.getFinalY() == 0)) {
                                overScroller.abortAnimation();
                            }
                        }
                        e = 0;
                        if (r0.f1858b.getOverScrollMode() != 2) {
                            r0.f1858b.absorbGlows(i5, e);
                        }
                        overScroller.abortAnimation();
                    }
                    i5 = 0;
                    if (i2 != currY) {
                        if (i2 < 0) {
                            e = -e;
                        } else if (i2 > 0) {
                        }
                        if (r0.f1858b.getOverScrollMode() != 2) {
                            r0.f1858b.absorbGlows(i5, e);
                        }
                        overScroller.abortAnimation();
                    }
                    e = 0;
                    if (r0.f1858b.getOverScrollMode() != 2) {
                        r0.f1858b.absorbGlows(i5, e);
                    }
                    overScroller.abortAnimation();
                }
                if (!(scrollHorizontallyBy == 0 && scrollVerticallyBy == 0)) {
                    r0.f1858b.dispatchOnScrolled(scrollHorizontallyBy, scrollVerticallyBy);
                }
                if (!r0.f1858b.awakenScrollBars()) {
                    r0.f1858b.invalidate();
                }
                Object obj = (i4 != 0 && r0.f1858b.mLayout.canScrollVertically() && scrollVerticallyBy == i4) ? 1 : null;
                Object obj2 = (i3 != 0 && r0.f1858b.mLayout.canScrollHorizontally() && scrollHorizontallyBy == i3) ? 1 : null;
                if (!(i3 == 0 && i4 == 0) && obj2 == null) {
                    if (obj == null) {
                        obj2 = null;
                        if (!overScroller.isFinished()) {
                            if (obj2 == null || r0.f1858b.hasNestedScrollingParent(1)) {
                                m2409a();
                                if (r0.f1858b.mGapWorker != null) {
                                    r0.f1858b.mGapWorker.m2652a(r0.f1858b, i3, i4);
                                }
                            }
                        }
                        r0.f1858b.setScrollState(0);
                        if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                            r0.f1858b.mPrefetchRegistry.m10437a();
                        }
                        r0.f1858b.stopNestedScroll(1);
                    }
                }
                obj2 = 1;
                if (overScroller.isFinished()) {
                    if (obj2 == null) {
                    }
                    m2409a();
                    if (r0.f1858b.mGapWorker != null) {
                        r0.f1858b.mGapWorker.m2652a(r0.f1858b, i3, i4);
                    }
                }
                r0.f1858b.setScrollState(0);
                if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                    r0.f1858b.mPrefetchRegistry.m10437a();
                }
                r0.f1858b.stopNestedScroll(1);
            }
            if (c0714t != null) {
                if (c0714t.isPendingInitialRun()) {
                    c0714t.onAnimation(0, 0);
                }
                if (!r0.f1863g) {
                    c0714t.stop();
                }
            }
            m2408d();
        }

        /* renamed from: c */
        private void m2407c() {
            this.f1863g = false;
            this.f1862f = true;
        }

        /* renamed from: d */
        private void m2408d() {
            this.f1862f = false;
            if (this.f1863g) {
                m2409a();
            }
        }

        /* renamed from: a */
        void m2409a() {
            if (this.f1862f) {
                this.f1863g = true;
                return;
            }
            this.f1858b.removeCallbacks(this);
            C0517s.m1697a(this.f1858b, (Runnable) this);
        }

        /* renamed from: a */
        public void m2410a(int i, int i2) {
            this.f1858b.setScrollState(2);
            this.f1860d = 0;
            this.f1859c = 0;
            this.f1861e.fling(0, 0, i, i2, LinearLayoutManager.INVALID_OFFSET, Integer.MAX_VALUE, LinearLayoutManager.INVALID_OFFSET, Integer.MAX_VALUE);
            m2409a();
        }

        /* renamed from: b */
        public void m2416b(int i, int i2) {
            m2412a(i, i2, 0, 0);
        }

        /* renamed from: a */
        public void m2412a(int i, int i2, int i3, int i4) {
            m2411a(i, i2, m2406b(i, i2, i3, i4));
        }

        /* renamed from: a */
        private float m2404a(float f) {
            return (float) Math.sin((double) ((f - 0.5f) * 0.47123894f));
        }

        /* renamed from: b */
        private int m2406b(int i, int i2, int i3, int i4) {
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            Object obj = abs > abs2 ? 1 : null;
            i3 = (int) Math.sqrt((double) ((i3 * i3) + (i4 * i4)));
            i = (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
            i2 = obj != null ? this.f1858b.getWidth() : this.f1858b.getHeight();
            i4 = i2 / 2;
            i2 = (float) i2;
            i4 = (float) i4;
            i4 += m2404a(Math.min(1.0f, (((float) i) * 1065353216) / i2)) * i4;
            if (i3 > 0) {
                i = Math.round(Math.abs(i4 / ((float) i3)) * 1148846080) * 4;
            } else {
                if (obj == null) {
                    abs = abs2;
                }
                i = (int) (((((float) abs) / i2) + 1065353216) * 1133903872);
            }
            return Math.min(i, 2000);
        }

        /* renamed from: a */
        public void m2411a(int i, int i2, int i3) {
            m2413a(i, i2, i3, RecyclerView.sQuinticInterpolator);
        }

        /* renamed from: a */
        public void m2414a(int i, int i2, Interpolator interpolator) {
            int b = m2406b(i, i2, 0, 0);
            if (interpolator == null) {
                interpolator = RecyclerView.sQuinticInterpolator;
            }
            m2413a(i, i2, b, interpolator);
        }

        /* renamed from: a */
        public void m2413a(int i, int i2, int i3, Interpolator interpolator) {
            if (this.f1857a != interpolator) {
                this.f1857a = interpolator;
                this.f1861e = new OverScroller(this.f1858b.getContext(), interpolator);
            }
            this.f1858b.setScrollState(2);
            this.f1860d = 0;
            this.f1859c = 0;
            this.f1861e.startScroll(0, 0, i, i2, i3);
            if (VERSION.SDK_INT < 23) {
                this.f1861e.computeScrollOffset();
            }
            m2409a();
        }

        /* renamed from: b */
        public void m2415b() {
            this.f1858b.removeCallbacks(this);
            this.f1861e.abortAnimation();
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$x */
    public static abstract class C0718x {
        static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        static final int FLAG_BOUND = 1;
        static final int FLAG_IGNORE = 128;
        static final int FLAG_INVALID = 4;
        static final int FLAG_MOVED = 2048;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 32;
        static final int FLAG_SET_A11Y_ITEM_DELEGATE = 16384;
        static final int FLAG_TMP_DETACHED = 256;
        static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS = Collections.EMPTY_LIST;
        static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
        public final View itemView;
        private int mFlags;
        private boolean mInChangeScrap = false;
        private int mIsRecyclableCount = 0;
        long mItemId = -1;
        int mItemViewType = -1;
        WeakReference<RecyclerView> mNestedRecyclerView;
        int mOldPosition = -1;
        RecyclerView mOwnerRecyclerView;
        List<Object> mPayloads = null;
        int mPendingAccessibilityState = -1;
        int mPosition = -1;
        int mPreLayoutPosition = -1;
        private C0709p mScrapContainer = null;
        C0718x mShadowedHolder = null;
        C0718x mShadowingHolder = null;
        List<Object> mUnmodifiedPayloads = null;
        private int mWasImportantForAccessibilityBeforeHidden = 0;

        public C0718x(View view) {
            if (view != null) {
                this.itemView = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        void flagRemovedAndOffsetPosition(int i, int i2, boolean z) {
            addFlags(8);
            offsetPosition(i2, z);
            this.mPosition = i;
        }

        void offsetPosition(int i, boolean z) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z) {
                this.mPreLayoutPosition += i;
            }
            this.mPosition += i;
            if (this.itemView.getLayoutParams() != 0) {
                ((C0702j) this.itemView.getLayoutParams()).f1816e = true;
            }
        }

        void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        boolean shouldIgnore() {
            return (this.mFlags & FLAG_IGNORE) != 0;
        }

        @Deprecated
        public final int getPosition() {
            return this.mPreLayoutPosition == -1 ? this.mPosition : this.mPreLayoutPosition;
        }

        public final int getLayoutPosition() {
            return this.mPreLayoutPosition == -1 ? this.mPosition : this.mPreLayoutPosition;
        }

        public final int getAdapterPosition() {
            if (this.mOwnerRecyclerView == null) {
                return -1;
            }
            return this.mOwnerRecyclerView.getAdapterPositionFor(this);
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        boolean isScrap() {
            return this.mScrapContainer != null;
        }

        void unScrap() {
            this.mScrapContainer.m2373c(this);
        }

        boolean wasReturnedFromScrap() {
            return (this.mFlags & 32) != 0;
        }

        void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        void stopIgnoring() {
            this.mFlags &= -129;
        }

        void setScrapContainer(C0709p c0709p, boolean z) {
            this.mScrapContainer = c0709p;
            this.mInChangeScrap = z;
        }

        boolean isInvalid() {
            return (this.mFlags & 4) != 0;
        }

        boolean needsUpdate() {
            return (this.mFlags & 2) != 0;
        }

        boolean isBound() {
            return (this.mFlags & 1) != 0;
        }

        boolean isRemoved() {
            return (this.mFlags & 8) != 0;
        }

        boolean hasAnyOfTheFlags(int i) {
            return (i & this.mFlags) != 0;
        }

        boolean isTmpDetached() {
            return (this.mFlags & FLAG_TMP_DETACHED) != 0;
        }

        boolean isAdapterPositionUnknown() {
            if ((this.mFlags & FLAG_ADAPTER_POSITION_UNKNOWN) == 0) {
                if (!isInvalid()) {
                    return false;
                }
            }
            return true;
        }

        void setFlags(int i, int i2) {
            this.mFlags = (i & i2) | (this.mFlags & (~i2));
        }

        void addFlags(int i) {
            this.mFlags = i | this.mFlags;
        }

        void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(1024);
            } else if ((1024 & this.mFlags) == 0) {
                createPayloadsIfNeeded();
                this.mPayloads.add(obj);
            }
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads == null) {
                this.mPayloads = new ArrayList();
                this.mUnmodifiedPayloads = Collections.unmodifiableList(this.mPayloads);
            }
        }

        void clearPayload() {
            if (this.mPayloads != null) {
                this.mPayloads.clear();
            }
            this.mFlags &= -1025;
        }

        List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 1024) != 0) {
                return FULLUPDATE_PAYLOADS;
            }
            if (this.mPayloads != null) {
                if (this.mPayloads.size() != 0) {
                    return this.mUnmodifiedPayloads;
                }
            }
            return FULLUPDATE_PAYLOADS;
        }

        void resetInternal() {
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.clearNestedRecyclerViewIfNotNested(this);
        }

        private void onEnteredHiddenState(RecyclerView recyclerView) {
            if (this.mPendingAccessibilityState != -1) {
                this.mWasImportantForAccessibilityBeforeHidden = this.mPendingAccessibilityState;
            } else {
                this.mWasImportantForAccessibilityBeforeHidden = C0517s.m1709d(this.itemView);
            }
            recyclerView.setChildImportantForAccessibilityInternal(this, 4);
        }

        private void onLeftHiddenState(RecyclerView recyclerView) {
            recyclerView.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = null;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ViewHolder{");
            stringBuilder.append(Integer.toHexString(hashCode()));
            stringBuilder.append(" position=");
            stringBuilder.append(this.mPosition);
            stringBuilder.append(" id=");
            stringBuilder.append(this.mItemId);
            stringBuilder.append(", oldPos=");
            stringBuilder.append(this.mOldPosition);
            stringBuilder.append(", pLpos:");
            stringBuilder.append(this.mPreLayoutPosition);
            StringBuilder stringBuilder2 = new StringBuilder(stringBuilder.toString());
            if (isScrap()) {
                stringBuilder2.append(" scrap ");
                stringBuilder2.append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
            }
            if (isInvalid()) {
                stringBuilder2.append(" invalid");
            }
            if (!isBound()) {
                stringBuilder2.append(" unbound");
            }
            if (needsUpdate()) {
                stringBuilder2.append(" update");
            }
            if (isRemoved()) {
                stringBuilder2.append(" removed");
            }
            if (shouldIgnore()) {
                stringBuilder2.append(" ignored");
            }
            if (isTmpDetached()) {
                stringBuilder2.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(" not recyclable(");
                stringBuilder.append(this.mIsRecyclableCount);
                stringBuilder.append(")");
                stringBuilder2.append(stringBuilder.toString());
            }
            if (isAdapterPositionUnknown()) {
                stringBuilder2.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                stringBuilder2.append(" no parent");
            }
            stringBuilder2.append("}");
            return stringBuilder2.toString();
        }

        public final void setIsRecyclable(boolean z) {
            this.mIsRecyclableCount = z ? this.mIsRecyclableCount - 1 : this.mIsRecyclableCount + 1;
            if (this.mIsRecyclableCount < 0) {
                this.mIsRecyclableCount = false;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ");
                stringBuilder.append(this);
                Log.e("View", stringBuilder.toString());
            } else if (!z && this.mIsRecyclableCount == 1) {
                this.mFlags |= 16;
            } else if (z && !this.mIsRecyclableCount) {
                this.mFlags &= -17;
            }
        }

        public final boolean isRecyclable() {
            return (this.mFlags & 16) == 0 && !C0517s.m1705b(this.itemView);
        }

        private boolean shouldBeKeptAsChild() {
            return (this.mFlags & 16) != 0;
        }

        private boolean doesTransientStatePreventRecycling() {
            return (this.mFlags & 16) == 0 && C0517s.m1705b(this.itemView);
        }

        boolean isUpdated() {
            return (this.mFlags & 2) != 0;
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$4 */
    class C32884 implements C0785b {
        /* renamed from: a */
        final /* synthetic */ RecyclerView f8625a;

        C32884(RecyclerView recyclerView) {
            this.f8625a = recyclerView;
        }

        /* renamed from: a */
        public void mo554a(C0718x c0718x, C0696c c0696c, C0696c c0696c2) {
            this.f8625a.mRecycler.m2373c(c0718x);
            this.f8625a.animateDisappearance(c0718x, c0696c, c0696c2);
        }

        /* renamed from: b */
        public void mo555b(C0718x c0718x, C0696c c0696c, C0696c c0696c2) {
            this.f8625a.animateAppearance(c0718x, c0696c, c0696c2);
        }

        /* renamed from: c */
        public void mo556c(C0718x c0718x, C0696c c0696c, C0696c c0696c2) {
            c0718x.setIsRecyclable(false);
            if (this.f8625a.mDataSetHasChangedAfterLayout) {
                if (this.f8625a.mItemAnimator.mo662a(c0718x, c0718x, c0696c, c0696c2) != null) {
                    this.f8625a.postAnimationRunner();
                }
            } else if (this.f8625a.mItemAnimator.mo664c(c0718x, c0696c, c0696c2) != null) {
                this.f8625a.postAnimationRunner();
            }
        }

        /* renamed from: a */
        public void mo553a(C0718x c0718x) {
            this.f8625a.mLayout.removeAndRecycleView(c0718x.itemView, this.f8625a.mRecycler);
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$5 */
    class C32895 implements C0741b {
        /* renamed from: a */
        final /* synthetic */ RecyclerView f8626a;

        C32895(RecyclerView recyclerView) {
            this.f8626a = recyclerView;
        }

        /* renamed from: a */
        public int mo557a() {
            return this.f8626a.getChildCount();
        }

        /* renamed from: a */
        public void mo560a(View view, int i) {
            this.f8626a.addView(view, i);
            this.f8626a.dispatchChildAttached(view);
        }

        /* renamed from: a */
        public int mo558a(View view) {
            return this.f8626a.indexOfChild(view);
        }

        /* renamed from: a */
        public void mo559a(int i) {
            View childAt = this.f8626a.getChildAt(i);
            if (childAt != null) {
                this.f8626a.dispatchChildDetached(childAt);
                childAt.clearAnimation();
            }
            this.f8626a.removeViewAt(i);
        }

        /* renamed from: b */
        public View mo563b(int i) {
            return this.f8626a.getChildAt(i);
        }

        /* renamed from: b */
        public void mo564b() {
            int a = mo557a();
            for (int i = 0; i < a; i++) {
                View b = mo563b(i);
                this.f8626a.dispatchChildDetached(b);
                b.clearAnimation();
            }
            this.f8626a.removeAllViews();
        }

        /* renamed from: b */
        public C0718x mo562b(View view) {
            return RecyclerView.getChildViewHolderInt(view);
        }

        /* renamed from: a */
        public void mo561a(View view, int i, LayoutParams layoutParams) {
            C0718x childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                if (!childViewHolderInt.isTmpDetached()) {
                    if (!childViewHolderInt.shouldIgnore()) {
                        i = new StringBuilder();
                        i.append("Called attach on a child which is not detached: ");
                        i.append(childViewHolderInt);
                        i.append(this.f8626a.exceptionLabel());
                        throw new IllegalArgumentException(i.toString());
                    }
                }
                childViewHolderInt.clearTmpDetachFlag();
            }
            this.f8626a.attachViewToParent(view, i, layoutParams);
        }

        /* renamed from: c */
        public void mo565c(int i) {
            View b = mo563b(i);
            if (b != null) {
                C0718x childViewHolderInt = RecyclerView.getChildViewHolderInt(b);
                if (childViewHolderInt != null) {
                    if (childViewHolderInt.isTmpDetached()) {
                        if (!childViewHolderInt.shouldIgnore()) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("called detach on an already detached child ");
                            stringBuilder.append(childViewHolderInt);
                            stringBuilder.append(this.f8626a.exceptionLabel());
                            throw new IllegalArgumentException(stringBuilder.toString());
                        }
                    }
                    childViewHolderInt.addFlags(256);
                }
            }
            this.f8626a.detachViewFromParent(i);
        }

        /* renamed from: c */
        public void mo566c(View view) {
            view = RecyclerView.getChildViewHolderInt(view);
            if (view != null) {
                view.onEnteredHiddenState(this.f8626a);
            }
        }

        /* renamed from: d */
        public void mo567d(View view) {
            view = RecyclerView.getChildViewHolderInt(view);
            if (view != null) {
                view.onLeftHiddenState(this.f8626a);
            }
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$6 */
    class C32906 implements C0793a {
        /* renamed from: a */
        final /* synthetic */ RecyclerView f8627a;

        C32906(RecyclerView recyclerView) {
            this.f8627a = recyclerView;
        }

        /* renamed from: a */
        public C0718x mo568a(int i) {
            i = this.f8627a.findViewHolderForPosition(i, true);
            if (i == 0 || this.f8627a.mChildHelper.m2566c(i.itemView)) {
                return null;
            }
            return i;
        }

        /* renamed from: a */
        public void mo569a(int i, int i2) {
            this.f8627a.offsetPositionRecordsForRemove(i, i2, true);
            this.f8627a.mItemsAddedOrRemoved = true;
            i = this.f8627a.mState;
            i.f1841b += i2;
        }

        /* renamed from: b */
        public void mo572b(int i, int i2) {
            this.f8627a.offsetPositionRecordsForRemove(i, i2, false);
            this.f8627a.mItemsAddedOrRemoved = true;
        }

        /* renamed from: a */
        public void mo570a(int i, int i2, Object obj) {
            this.f8627a.viewRangeUpdate(i, i2, obj);
            this.f8627a.mItemsChanged = true;
        }

        /* renamed from: a */
        public void mo571a(C0794b c0794b) {
            m10248c(c0794b);
        }

        /* renamed from: c */
        void m10248c(C0794b c0794b) {
            int i = c0794b.f2200a;
            if (i == 4) {
                this.f8627a.mLayout.onItemsUpdated(this.f8627a, c0794b.f2201b, c0794b.f2203d, c0794b.f2202c);
            } else if (i != 8) {
                switch (i) {
                    case 1:
                        this.f8627a.mLayout.onItemsAdded(this.f8627a, c0794b.f2201b, c0794b.f2203d);
                        return;
                    case 2:
                        this.f8627a.mLayout.onItemsRemoved(this.f8627a, c0794b.f2201b, c0794b.f2203d);
                        return;
                    default:
                        return;
                }
            } else {
                this.f8627a.mLayout.onItemsMoved(this.f8627a, c0794b.f2201b, c0794b.f2203d, 1);
            }
        }

        /* renamed from: b */
        public void mo573b(C0794b c0794b) {
            m10248c(c0794b);
        }

        /* renamed from: c */
        public void mo574c(int i, int i2) {
            this.f8627a.offsetPositionRecordsForInsert(i, i2);
            this.f8627a.mItemsAddedOrRemoved = true;
        }

        /* renamed from: d */
        public void mo575d(int i, int i2) {
            this.f8627a.offsetPositionRecordsForMove(i, i2);
            this.f8627a.mItemsAddedOrRemoved = true;
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$g */
    private class C3291g implements C0695b {
        /* renamed from: a */
        final /* synthetic */ RecyclerView f8628a;

        C3291g(RecyclerView recyclerView) {
            this.f8628a = recyclerView;
        }

        /* renamed from: a */
        public void mo576a(C0718x c0718x) {
            c0718x.setIsRecyclable(true);
            if (c0718x.mShadowedHolder != null && c0718x.mShadowingHolder == null) {
                c0718x.mShadowedHolder = null;
            }
            c0718x.mShadowingHolder = null;
            if (!c0718x.shouldBeKeptAsChild() && !this.f8628a.removeAnimatingView(c0718x.itemView) && c0718x.isTmpDetached()) {
                this.f8628a.removeDetachedView(c0718x.itemView, false);
            }
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$r */
    private class C3294r extends C0691c {
        /* renamed from: a */
        final /* synthetic */ RecyclerView f8631a;

        C3294r(RecyclerView recyclerView) {
            this.f8631a = recyclerView;
        }

        /* renamed from: a */
        public void mo582a() {
            this.f8631a.assertNotInLayoutOrScroll(null);
            this.f8631a.mState.f1844e = true;
            this.f8631a.processDataSetCompletelyChanged(true);
            if (!this.f8631a.mAdapterHelper.m10618d()) {
                this.f8631a.requestLayout();
            }
        }

        /* renamed from: a */
        public void mo584a(int i, int i2, Object obj) {
            this.f8631a.assertNotInLayoutOrScroll(null);
            if (this.f8631a.mAdapterHelper.m10611a(i, i2, obj) != 0) {
                m10264b();
            }
        }

        /* renamed from: b */
        public void mo585b(int i, int i2) {
            this.f8631a.assertNotInLayoutOrScroll(null);
            if (this.f8631a.mAdapterHelper.m10614b(i, i2) != 0) {
                m10264b();
            }
        }

        /* renamed from: c */
        public void mo586c(int i, int i2) {
            this.f8631a.assertNotInLayoutOrScroll(null);
            if (this.f8631a.mAdapterHelper.m10617c(i, i2) != 0) {
                m10264b();
            }
        }

        /* renamed from: a */
        public void mo583a(int i, int i2, int i3) {
            this.f8631a.assertNotInLayoutOrScroll(null);
            if (this.f8631a.mAdapterHelper.m10610a(i, i2, i3) != 0) {
                m10264b();
            }
        }

        /* renamed from: b */
        void m10264b() {
            if (RecyclerView.POST_UPDATES_ON_ANIMATION && this.f8631a.mHasFixedSize && this.f8631a.mIsAttached) {
                C0517s.m1697a(this.f8631a, this.f8631a.mUpdateChildViewsRunnable);
                return;
            }
            this.f8631a.mAdapterUpdateDuringMeasure = true;
            this.f8631a.requestLayout();
        }
    }

    /* renamed from: android.support.v7.widget.RecyclerView$s */
    public static class C3295s extends C0487a {
        public static final Creator<C3295s> CREATOR = new C07111();
        /* renamed from: a */
        Parcelable f8632a;

        /* renamed from: android.support.v7.widget.RecyclerView$s$1 */
        static class C07111 implements ClassLoaderCreator<C3295s> {
            C07111() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m2387a(parcel);
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return m2388a(parcel, classLoader);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m2389a(i);
            }

            /* renamed from: a */
            public C3295s m2388a(Parcel parcel, ClassLoader classLoader) {
                return new C3295s(parcel, classLoader);
            }

            /* renamed from: a */
            public C3295s m2387a(Parcel parcel) {
                return new C3295s(parcel, null);
            }

            /* renamed from: a */
            public C3295s[] m2389a(int i) {
                return new C3295s[i];
            }
        }

        C3295s(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                classLoader = C0701i.class.getClassLoader();
            }
            this.f8632a = parcel.readParcelable(classLoader);
        }

        C3295s(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f8632a, 0);
        }

        /* renamed from: a */
        void m10267a(C3295s c3295s) {
            this.f8632a = c3295s.f8632a;
        }
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    public void onScrollStateChanged(int i) {
    }

    public void onScrolled(int i, int i2) {
    }

    static {
        boolean z;
        if (!(VERSION.SDK_INT == 18 || VERSION.SDK_INT == 19)) {
            if (VERSION.SDK_INT != 20) {
                z = false;
                FORCE_INVALIDATE_DISPLAY_LIST = z;
            }
        }
        z = true;
        FORCE_INVALIDATE_DISPLAY_LIST = z;
        if (VERSION.SDK_INT < 23) {
        }
        if (VERSION.SDK_INT < 16) {
        }
        if (VERSION.SDK_INT < 21) {
        }
        if (VERSION.SDK_INT > 15) {
        }
        if (VERSION.SDK_INT > 15) {
        }
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mObserver = new C3294r(this);
        this.mRecycler = new C0709p(this);
        this.mViewInfoStore = new bx();
        this.mUpdateChildViewsRunnable = new C06861(this);
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mItemDecorations = new ArrayList();
        this.mOnItemTouchListeners = new ArrayList();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = new C0693e();
        this.mItemAnimator = new ak();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        boolean z = true;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new C0717w(this);
        this.mPrefetchRegistry = ALLOW_THREAD_GAP_WORK ? new C3307a() : null;
        this.mState = new C0715u();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new C3291g(this);
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        this.mNestedOffsets = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new C06872(this);
        this.mViewInfoProcessCallback = new C32884(this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, CLIP_TO_PADDING_ATTR, i, 0);
            this.mClipToPadding = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            this.mClipToPadding = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = C0518t.m1733a(viewConfiguration, context);
        this.mScaledVerticalScrollFactor = C0518t.m1734b(viewConfiguration, context);
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.mItemAnimator.m2300a(this.mItemAnimatorListener);
        initAdapterManager();
        initChildrenHelper();
        if (C0517s.m1709d(this) == 0) {
            C0517s.m1688a((View) this, 1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new ba(this));
        if (attributeSet != null) {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0635b.RecyclerView, i, 0);
            String string = obtainStyledAttributes.getString(C0635b.RecyclerView_layoutManager);
            if (obtainStyledAttributes.getInt(C0635b.RecyclerView_android_descendantFocusability, -1) == -1) {
                setDescendantFocusability(262144);
            }
            this.mEnableFastScroller = obtainStyledAttributes.getBoolean(C0635b.RecyclerView_fastScrollEnabled, false);
            if (this.mEnableFastScroller) {
                initFastScroller((StateListDrawable) obtainStyledAttributes.getDrawable(C0635b.RecyclerView_fastScrollVerticalThumbDrawable), obtainStyledAttributes.getDrawable(C0635b.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) obtainStyledAttributes.getDrawable(C0635b.RecyclerView_fastScrollHorizontalThumbDrawable), obtainStyledAttributes.getDrawable(C0635b.RecyclerView_fastScrollHorizontalTrackDrawable));
            }
            obtainStyledAttributes.recycle();
            createLayoutManager(context, string, attributeSet, i, 0);
            if (VERSION.SDK_INT >= 21) {
                context = context.obtainStyledAttributes(attributeSet, NESTED_SCROLLING_ATTRS, i, 0);
                attributeSet = context.getBoolean(0, true);
                context.recycle();
                z = attributeSet;
            }
        } else {
            setDescendantFocusability(262144);
        }
        setNestedScrollingEnabled(z);
    }

    String exceptionLabel() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" ");
        stringBuilder.append(super.toString());
        stringBuilder.append(", adapter:");
        stringBuilder.append(this.mAdapter);
        stringBuilder.append(", layout:");
        stringBuilder.append(this.mLayout);
        stringBuilder.append(", context:");
        stringBuilder.append(getContext());
        return stringBuilder.toString();
    }

    public ba getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void setAccessibilityDelegateCompat(ba baVar) {
        this.mAccessibilityDelegate = baVar;
        C0517s.m1695a((View) this, this.mAccessibilityDelegate);
    }

    private void createLayoutManager(Context context, String str, AttributeSet attributeSet, int i, int i2) {
        if (str != null) {
            str = str.trim();
            if (!str.isEmpty()) {
                str = getFullClassName(context, str);
                try {
                    ClassLoader classLoader;
                    Constructor constructor;
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class asSubclass = classLoader.loadClass(str).asSubclass(C0701i.class);
                    Object[] objArr = null;
                    try {
                        constructor = asSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
                    } catch (Context context2) {
                        constructor = asSubclass.getConstructor(new Class[0]);
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((C0701i) constructor.newInstance(objArr));
                } catch (int i3) {
                    i3.initCause(context2);
                    i2 = new StringBuilder();
                    i2.append(attributeSet.getPositionDescription());
                    i2.append(": Error creating LayoutManager ");
                    i2.append(str);
                    throw new IllegalStateException(i2.toString(), i3);
                } catch (Context context22) {
                    i2 = new StringBuilder();
                    i2.append(attributeSet.getPositionDescription());
                    i2.append(": Unable to find LayoutManager ");
                    i2.append(str);
                    throw new IllegalStateException(i2.toString(), context22);
                } catch (Context context222) {
                    i2 = new StringBuilder();
                    i2.append(attributeSet.getPositionDescription());
                    i2.append(": Could not instantiate the LayoutManager: ");
                    i2.append(str);
                    throw new IllegalStateException(i2.toString(), context222);
                } catch (Context context2222) {
                    i2 = new StringBuilder();
                    i2.append(attributeSet.getPositionDescription());
                    i2.append(": Could not instantiate the LayoutManager: ");
                    i2.append(str);
                    throw new IllegalStateException(i2.toString(), context2222);
                } catch (Context context22222) {
                    i2 = new StringBuilder();
                    i2.append(attributeSet.getPositionDescription());
                    i2.append(": Cannot access non-public constructor ");
                    i2.append(str);
                    throw new IllegalStateException(i2.toString(), context22222);
                } catch (Context context222222) {
                    i2 = new StringBuilder();
                    i2.append(attributeSet.getPositionDescription());
                    i2.append(": Class is not a LayoutManager ");
                    i2.append(str);
                    throw new IllegalStateException(i2.toString(), context222222);
                }
            }
        }
    }

    private String getFullClassName(Context context, String str) {
        if (str.charAt(0) == '.') {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.getPackageName());
            stringBuilder.append(str);
            return stringBuilder.toString();
        } else if (str.contains(".") != null) {
            return str;
        } else {
            context = new StringBuilder();
            context.append(RecyclerView.class.getPackage().getName());
            context.append('.');
            context.append(str);
            return context.toString();
        }
    }

    private void initChildrenHelper() {
        this.mChildHelper = new ah(new C32895(this));
    }

    void initAdapterManager() {
        this.mAdapterHelper = new C3319f(new C32906(this));
    }

    public void setHasFixedSize(boolean z) {
        this.mHasFixedSize = z;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    public void setClipToPadding(boolean z) {
        if (z != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z;
        super.setClipToPadding(z);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        switch (i) {
            case 0:
                break;
            case 1:
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            default:
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("setScrollingTouchSlop(): bad argument constant ");
                stringBuilder.append(i);
                stringBuilder.append("; using default value");
                Log.w(str, stringBuilder.toString());
                break;
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void swapAdapter(C0689a c0689a, boolean z) {
        setLayoutFrozen(false);
        setAdapterInternal(c0689a, true, z);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    public void setAdapter(C0689a c0689a) {
        setLayoutFrozen(false);
        setAdapterInternal(c0689a, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    void removeAndRecycleViews() {
        if (this.mItemAnimator != null) {
            this.mItemAnimator.mo2770d();
        }
        if (this.mLayout != null) {
            this.mLayout.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        }
        this.mRecycler.m2354a();
    }

    private void setAdapterInternal(C0689a c0689a, boolean z, boolean z2) {
        if (this.mAdapter != null) {
            this.mAdapter.unregisterAdapterDataObserver(this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!z || z2) {
            removeAndRecycleViews();
        }
        this.mAdapterHelper.m10605a();
        C0689a c0689a2 = this.mAdapter;
        this.mAdapter = c0689a;
        if (c0689a != null) {
            c0689a.registerAdapterDataObserver(this.mObserver);
            c0689a.onAttachedToRecyclerView(this);
        }
        if (this.mLayout != null) {
            this.mLayout.onAdapterChanged(c0689a2, this.mAdapter);
        }
        this.mRecycler.m2358a(c0689a2, this.mAdapter, z);
        this.mState.f1844e = true;
    }

    public C0689a getAdapter() {
        return this.mAdapter;
    }

    public void setRecyclerListener(C0710q c0710q) {
        this.mRecyclerListener = c0710q;
    }

    public int getBaseline() {
        if (this.mLayout != null) {
            return this.mLayout.getBaseline();
        }
        return super.getBaseline();
    }

    public void addOnChildAttachStateChangeListener(C0703k c0703k) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(c0703k);
    }

    public void removeOnChildAttachStateChangeListener(C0703k c0703k) {
        if (this.mOnChildAttachStateListeners != null) {
            this.mOnChildAttachStateListeners.remove(c0703k);
        }
    }

    public void clearOnChildAttachStateChangeListeners() {
        if (this.mOnChildAttachStateListeners != null) {
            this.mOnChildAttachStateListeners.clear();
        }
    }

    public void setLayoutManager(C0701i c0701i) {
        if (c0701i != this.mLayout) {
            stopScroll();
            if (this.mLayout != null) {
                if (this.mItemAnimator != null) {
                    this.mItemAnimator.mo2770d();
                }
                this.mLayout.removeAndRecycleAllViews(this.mRecycler);
                this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
                this.mRecycler.m2354a();
                if (this.mIsAttached) {
                    this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
                }
                this.mLayout.setRecyclerView(null);
                this.mLayout = null;
            } else {
                this.mRecycler.m2354a();
            }
            this.mChildHelper.m2555a();
            this.mLayout = c0701i;
            if (c0701i != null) {
                if (c0701i.mRecyclerView == null) {
                    this.mLayout.setRecyclerView(this);
                    if (this.mIsAttached != null) {
                        this.mLayout.dispatchAttachedToWindow(this);
                    }
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("LayoutManager ");
                    stringBuilder.append(c0701i);
                    stringBuilder.append(" is already attached to a RecyclerView:");
                    stringBuilder.append(c0701i.mRecyclerView.exceptionLabel());
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            this.mRecycler.m2366b();
            requestLayout();
        }
    }

    public void setOnFlingListener(C0704l c0704l) {
        this.mOnFlingListener = c0704l;
    }

    public C0704l getOnFlingListener() {
        return this.mOnFlingListener;
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable c3295s = new C3295s(super.onSaveInstanceState());
        if (this.mPendingSavedState != null) {
            c3295s.m10267a(this.mPendingSavedState);
        } else if (this.mLayout != null) {
            c3295s.f8632a = this.mLayout.onSaveInstanceState();
        } else {
            c3295s.f8632a = null;
        }
        return c3295s;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C3295s) {
            this.mPendingSavedState = (C3295s) parcelable;
            super.onRestoreInstanceState(this.mPendingSavedState.m1558a());
            if (!(this.mLayout == null || this.mPendingSavedState.f8632a == null)) {
                this.mLayout.onRestoreInstanceState(this.mPendingSavedState.f8632a);
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    private void addAnimatingView(C0718x c0718x) {
        View view = c0718x.itemView;
        Object obj = view.getParent() == this ? 1 : null;
        this.mRecycler.m2373c(getChildViewHolder(view));
        if (c0718x.isTmpDetached() != null) {
            this.mChildHelper.m2558a(view, -1, view.getLayoutParams(), true);
        } else if (obj == null) {
            this.mChildHelper.m2560a(view, true);
        } else {
            this.mChildHelper.m2568d(view);
        }
    }

    boolean removeAnimatingView(View view) {
        startInterceptRequestLayout();
        boolean f = this.mChildHelper.m2571f(view);
        if (f) {
            C0718x childViewHolderInt = getChildViewHolderInt(view);
            this.mRecycler.m2373c(childViewHolderInt);
            this.mRecycler.m2368b(childViewHolderInt);
        }
        stopInterceptRequestLayout(f ^ 1);
        return f;
    }

    public C0701i getLayoutManager() {
        return this.mLayout;
    }

    public C0708o getRecycledViewPool() {
        return this.mRecycler.m2382g();
    }

    public void setRecycledViewPool(C0708o c0708o) {
        this.mRecycler.m2359a(c0708o);
    }

    public void setViewCacheExtension(C0716v c0716v) {
        this.mRecycler.m2360a(c0716v);
    }

    public void setItemViewCacheSize(int i) {
        this.mRecycler.m2355a(i);
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    void setScrollState(int i) {
        if (i != this.mScrollState) {
            this.mScrollState = i;
            if (i != 2) {
                stopScrollersInternal();
            }
            dispatchOnScrollStateChanged(i);
        }
    }

    public void addItemDecoration(C0698h c0698h, int i) {
        if (this.mLayout != null) {
            this.mLayout.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i < 0) {
            this.mItemDecorations.add(c0698h);
        } else {
            this.mItemDecorations.add(i, c0698h);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addItemDecoration(C0698h c0698h) {
        addItemDecoration(c0698h, -1);
    }

    public C0698h getItemDecorationAt(int i) {
        int itemDecorationCount = getItemDecorationCount();
        if (i >= 0 && i < itemDecorationCount) {
            return (C0698h) this.mItemDecorations.get(i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append(" is an invalid index for size ");
        stringBuilder.append(itemDecorationCount);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    public void removeItemDecorationAt(int i) {
        int itemDecorationCount = getItemDecorationCount();
        if (i < 0 || i >= itemDecorationCount) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i);
            stringBuilder.append(" is an invalid index for size ");
            stringBuilder.append(itemDecorationCount);
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        }
        removeItemDecoration(getItemDecorationAt(i));
    }

    public void removeItemDecoration(C0698h c0698h) {
        if (this.mLayout != null) {
            this.mLayout.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(c0698h);
        if (this.mItemDecorations.isEmpty() != null) {
            setWillNotDraw(getOverScrollMode() == 2 ? true : null);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void setChildDrawingOrderCallback(C0692d c0692d) {
        if (c0692d != this.mChildDrawingOrderCallback) {
            this.mChildDrawingOrderCallback = c0692d;
            setChildrenDrawingOrderEnabled(this.mChildDrawingOrderCallback != null ? true : null);
        }
    }

    @Deprecated
    public void setOnScrollListener(C0706n c0706n) {
        this.mScrollListener = c0706n;
    }

    public void addOnScrollListener(C0706n c0706n) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(c0706n);
    }

    public void removeOnScrollListener(C0706n c0706n) {
        if (this.mScrollListeners != null) {
            this.mScrollListeners.remove(c0706n);
        }
    }

    public void clearOnScrollListeners() {
        if (this.mScrollListeners != null) {
            this.mScrollListeners.clear();
        }
    }

    public void scrollToPosition(int i) {
        if (!this.mLayoutFrozen) {
            stopScroll();
            if (this.mLayout == null) {
                Log.e(TAG, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
                return;
            }
            this.mLayout.scrollToPosition(i);
            awakenScrollBars();
        }
    }

    void jumpToPositionForSmoothScroller(int i) {
        if (this.mLayout != null) {
            this.mLayout.scrollToPosition(i);
            awakenScrollBars();
        }
    }

    public void smoothScrollToPosition(int i) {
        if (!this.mLayoutFrozen) {
            if (this.mLayout == null) {
                Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            } else {
                this.mLayout.smoothScrollToPosition(this, this.mState, i);
            }
        }
    }

    public void scrollTo(int i, int i2) {
        Log.w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollBy(int i, int i2) {
        if (this.mLayout == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.mLayoutFrozen) {
            boolean canScrollHorizontally = this.mLayout.canScrollHorizontally();
            boolean canScrollVertically = this.mLayout.canScrollVertically();
            if (canScrollHorizontally || canScrollVertically) {
                if (!canScrollHorizontally) {
                    i = 0;
                }
                if (!canScrollVertically) {
                    i2 = 0;
                }
                scrollByInternal(i, i2, null);
            }
        }
    }

    void consumePendingUpdateOperations() {
        if (this.mFirstLayoutComplete) {
            if (!this.mDataSetHasChangedAfterLayout) {
                if (this.mAdapterHelper.m10618d()) {
                    if (this.mAdapterHelper.m10609a(4) && !this.mAdapterHelper.m10609a(11)) {
                        C0397h.m1177a(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
                        startInterceptRequestLayout();
                        onEnterLayoutOrScroll();
                        this.mAdapterHelper.m10613b();
                        if (!this.mLayoutWasDefered) {
                            if (hasUpdatedView()) {
                                dispatchLayout();
                            } else {
                                this.mAdapterHelper.m10616c();
                            }
                        }
                        stopInterceptRequestLayout(true);
                        onExitLayoutOrScroll();
                        C0397h.m1176a();
                    } else if (this.mAdapterHelper.m10618d()) {
                        C0397h.m1177a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
                        dispatchLayout();
                        C0397h.m1176a();
                    }
                    return;
                }
                return;
            }
        }
        C0397h.m1177a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
        dispatchLayout();
        C0397h.m1176a();
    }

    private boolean hasUpdatedView() {
        int b = this.mChildHelper.m2561b();
        for (int i = 0; i < b; i++) {
            C0718x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2563b(i));
            if (childViewHolderInt != null) {
                if (!childViewHolderInt.shouldIgnore()) {
                    if (childViewHolderInt.isUpdated()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean scrollByInternal(int i, int i2, MotionEvent motionEvent) {
        int scrollHorizontallyBy;
        int i3;
        int scrollVerticallyBy;
        int i4;
        consumePendingUpdateOperations();
        if (this.mAdapter != null) {
            startInterceptRequestLayout();
            onEnterLayoutOrScroll();
            C0397h.m1177a(TRACE_SCROLL_TAG);
            fillRemainingScrollValues(this.mState);
            if (i != 0) {
                scrollHorizontallyBy = this.mLayout.scrollHorizontallyBy(i, this.mRecycler, this.mState);
                i3 = i - scrollHorizontallyBy;
            } else {
                scrollHorizontallyBy = 0;
                i3 = 0;
            }
            if (i2 != 0) {
                scrollVerticallyBy = this.mLayout.scrollVerticallyBy(i2, this.mRecycler, this.mState);
                i4 = i2 - scrollVerticallyBy;
            } else {
                scrollVerticallyBy = 0;
                i4 = 0;
            }
            C0397h.m1176a();
            repositionShadowingViews();
            onExitLayoutOrScroll();
            stopInterceptRequestLayout(false);
        } else {
            scrollHorizontallyBy = 0;
            i3 = 0;
            scrollVerticallyBy = 0;
            i4 = 0;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        if (dispatchNestedScroll(scrollHorizontallyBy, scrollVerticallyBy, i3, i4, this.mScrollOffset, 0)) {
            this.mLastTouchX -= this.mScrollOffset[0];
            this.mLastTouchY -= this.mScrollOffset[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation((float) this.mScrollOffset[0], (float) this.mScrollOffset[1]);
            }
            i = this.mNestedOffsets;
            i[0] = i[0] + this.mScrollOffset[0];
            i = this.mNestedOffsets;
            i[1] = i[1] + this.mScrollOffset[1];
        } else if (getOverScrollMode() != 2) {
            if (!(motionEvent == null || C0507i.m1608a(motionEvent, 8194))) {
                pullGlows(motionEvent.getX(), (float) i3, motionEvent.getY(), (float) i4);
            }
            considerReleasingGlowsOnScroll(i, i2);
        }
        if (!(scrollHorizontallyBy == 0 && scrollVerticallyBy == 0)) {
            dispatchOnScrolled(scrollHorizontallyBy, scrollVerticallyBy);
        }
        if (awakenScrollBars() == 0) {
            invalidate();
        }
        if (scrollHorizontallyBy == 0 && scrollVerticallyBy == 0) {
            return false;
        }
        return true;
    }

    public int computeHorizontalScrollOffset() {
        int i = 0;
        if (this.mLayout == null) {
            return 0;
        }
        if (this.mLayout.canScrollHorizontally()) {
            i = this.mLayout.computeHorizontalScrollOffset(this.mState);
        }
        return i;
    }

    public int computeHorizontalScrollExtent() {
        int i = 0;
        if (this.mLayout == null) {
            return 0;
        }
        if (this.mLayout.canScrollHorizontally()) {
            i = this.mLayout.computeHorizontalScrollExtent(this.mState);
        }
        return i;
    }

    public int computeHorizontalScrollRange() {
        int i = 0;
        if (this.mLayout == null) {
            return 0;
        }
        if (this.mLayout.canScrollHorizontally()) {
            i = this.mLayout.computeHorizontalScrollRange(this.mState);
        }
        return i;
    }

    public int computeVerticalScrollOffset() {
        int i = 0;
        if (this.mLayout == null) {
            return 0;
        }
        if (this.mLayout.canScrollVertically()) {
            i = this.mLayout.computeVerticalScrollOffset(this.mState);
        }
        return i;
    }

    public int computeVerticalScrollExtent() {
        int i = 0;
        if (this.mLayout == null) {
            return 0;
        }
        if (this.mLayout.canScrollVertically()) {
            i = this.mLayout.computeVerticalScrollExtent(this.mState);
        }
        return i;
    }

    public int computeVerticalScrollRange() {
        int i = 0;
        if (this.mLayout == null) {
            return 0;
        }
        if (this.mLayout.canScrollVertically()) {
            i = this.mLayout.computeVerticalScrollRange(this.mState);
        }
        return i;
    }

    void startInterceptRequestLayout() {
        this.mInterceptRequestLayoutDepth++;
        if (this.mInterceptRequestLayoutDepth == 1 && !this.mLayoutFrozen) {
            this.mLayoutWasDefered = false;
        }
    }

    void stopInterceptRequestLayout(boolean z) {
        if (this.mInterceptRequestLayoutDepth < 1) {
            this.mInterceptRequestLayoutDepth = 1;
        }
        if (!(z || this.mLayoutFrozen)) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (z && this.mLayoutWasDefered && !this.mLayoutFrozen && this.mLayout && this.mAdapter) {
                dispatchLayout();
            }
            if (!this.mLayoutFrozen) {
                this.mLayoutWasDefered = false;
            }
        }
        this.mInterceptRequestLayoutDepth -= true;
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.mLayoutFrozen) {
            assertNotInLayoutOrScroll("Do not setLayoutFrozen in layout or scroll");
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                this.mLayoutFrozen = true;
                this.mIgnoreMotionEventTillDown = true;
                stopScroll();
                return;
            }
            this.mLayoutFrozen = false;
            if (!(!this.mLayoutWasDefered || this.mLayout == null || this.mAdapter == null)) {
                requestLayout();
            }
            this.mLayoutWasDefered = false;
        }
    }

    public boolean isLayoutFrozen() {
        return this.mLayoutFrozen;
    }

    public void smoothScrollBy(int i, int i2) {
        smoothScrollBy(i, i2, null);
    }

    public void smoothScrollBy(int i, int i2, Interpolator interpolator) {
        if (this.mLayout == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.mLayoutFrozen) {
            if (!this.mLayout.canScrollHorizontally()) {
                i = 0;
            }
            if (!this.mLayout.canScrollVertically()) {
                i2 = 0;
            }
            if (!(i == 0 && i2 == 0)) {
                this.mViewFlinger.m2414a(i, i2, interpolator);
            }
        }
    }

    public boolean fling(int i, int i2) {
        int i3 = 0;
        if (this.mLayout == null) {
            Log.e(TAG, "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.mLayoutFrozen) {
            return false;
        } else {
            boolean canScrollHorizontally = this.mLayout.canScrollHorizontally();
            boolean canScrollVertically = this.mLayout.canScrollVertically();
            if (!canScrollHorizontally || Math.abs(i) < this.mMinFlingVelocity) {
                i = 0;
            }
            if (!canScrollVertically || Math.abs(i2) < this.mMinFlingVelocity) {
                i2 = 0;
            }
            if (i == 0 && i2 == 0) {
                return false;
            }
            float f = (float) i;
            float f2 = (float) i2;
            if (!dispatchNestedPreFling(f, f2)) {
                boolean z;
                if (!canScrollHorizontally) {
                    if (!canScrollVertically) {
                        z = false;
                        dispatchNestedFling(f, f2, z);
                        if (this.mOnFlingListener == null && this.mOnFlingListener.mo667a(i, i2)) {
                            return true;
                        }
                        if (z) {
                            if (canScrollHorizontally) {
                                i3 = 1;
                            }
                            if (canScrollVertically) {
                                i3 |= 2;
                            }
                            startNestedScroll(i3, 1);
                            this.mViewFlinger.m2410a(Math.max(-this.mMaxFlingVelocity, Math.min(i, this.mMaxFlingVelocity)), Math.max(-this.mMaxFlingVelocity, Math.min(i2, this.mMaxFlingVelocity)));
                            return true;
                        }
                    }
                }
                z = true;
                dispatchNestedFling(f, f2, z);
                if (this.mOnFlingListener == null) {
                }
                if (z) {
                    if (canScrollHorizontally) {
                        i3 = 1;
                    }
                    if (canScrollVertically) {
                        i3 |= 2;
                    }
                    startNestedScroll(i3, 1);
                    this.mViewFlinger.m2410a(Math.max(-this.mMaxFlingVelocity, Math.min(i, this.mMaxFlingVelocity)), Math.max(-this.mMaxFlingVelocity, Math.min(i2, this.mMaxFlingVelocity)));
                    return true;
                }
            }
            return false;
        }
    }

    public void stopScroll() {
        setScrollState(0);
        stopScrollersInternal();
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.m2415b();
        if (this.mLayout != null) {
            this.mLayout.stopSmoothScroller();
        }
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    private void pullGlows(float f, float f2, float f3, float f4) {
        Object obj = 1;
        if (f2 < 0.0f) {
            ensureLeftGlow();
            C0555j.m1880a(this.mLeftGlow, (-f2) / ((float) getWidth()), 1.0f - (f3 / ((float) getHeight())));
        } else if (f2 > 0.0f) {
            ensureRightGlow();
            C0555j.m1880a(this.mRightGlow, f2 / ((float) getWidth()), f3 / ((float) getHeight()));
        } else {
            f3 = 0.0f;
            if (f4 < 0.0f) {
                ensureTopGlow();
                C0555j.m1880a(this.mTopGlow, (-f4) / ((float) getHeight()), f / ((float) getWidth()));
            } else if (f4 <= 0.0f) {
                ensureBottomGlow();
                C0555j.m1880a(this.mBottomGlow, f4 / ((float) getHeight()), 1.0f - (f / ((float) getWidth())));
            } else {
                obj = f3;
            }
            if (obj == null || f2 != 0.0f || f4 != 0.0f) {
                C0517s.m1706c(this);
            }
            return;
        }
        f3 = Float.MIN_VALUE;
        if (f4 < 0.0f) {
            ensureTopGlow();
            C0555j.m1880a(this.mTopGlow, (-f4) / ((float) getHeight()), f / ((float) getWidth()));
        } else if (f4 <= 0.0f) {
            obj = f3;
        } else {
            ensureBottomGlow();
            C0555j.m1880a(this.mBottomGlow, f4 / ((float) getHeight()), 1.0f - (f / ((float) getWidth())));
        }
        if (obj == null) {
        }
        C0517s.m1706c(this);
    }

    private void releaseGlows() {
        int isFinished;
        if (this.mLeftGlow != null) {
            this.mLeftGlow.onRelease();
            isFinished = this.mLeftGlow.isFinished();
        } else {
            isFinished = 0;
        }
        if (this.mTopGlow != null) {
            this.mTopGlow.onRelease();
            isFinished |= this.mTopGlow.isFinished();
        }
        if (this.mRightGlow != null) {
            this.mRightGlow.onRelease();
            isFinished |= this.mRightGlow.isFinished();
        }
        if (this.mBottomGlow != null) {
            this.mBottomGlow.onRelease();
            isFinished |= this.mBottomGlow.isFinished();
        }
        if (isFinished != 0) {
            C0517s.m1706c(this);
        }
    }

    void considerReleasingGlowsOnScroll(int i, int i2) {
        int i3;
        if (this.mLeftGlow == null || this.mLeftGlow.isFinished() || i <= 0) {
            i3 = 0;
        } else {
            this.mLeftGlow.onRelease();
            i3 = this.mLeftGlow.isFinished();
        }
        if (!(this.mRightGlow == null || this.mRightGlow.isFinished() || i >= 0)) {
            this.mRightGlow.onRelease();
            i3 |= this.mRightGlow.isFinished();
        }
        if (this.mTopGlow != 0 && this.mTopGlow.isFinished() == 0 && i2 > 0) {
            this.mTopGlow.onRelease();
            i3 |= this.mTopGlow.isFinished();
        }
        if (this.mBottomGlow != 0 && this.mBottomGlow.isFinished() == 0 && i2 < 0) {
            this.mBottomGlow.onRelease();
            i3 |= this.mBottomGlow.isFinished();
        }
        if (i3 != 0) {
            C0517s.m1706c(this);
        }
    }

    void absorbGlows(int i, int i2) {
        if (i < 0) {
            ensureLeftGlow();
            this.mLeftGlow.onAbsorb(-i);
        } else if (i > 0) {
            ensureRightGlow();
            this.mRightGlow.onAbsorb(i);
        }
        if (i2 < 0) {
            ensureTopGlow();
            this.mTopGlow.onAbsorb(-i2);
        } else if (i2 > 0) {
            ensureBottomGlow();
            this.mBottomGlow.onAbsorb(i2);
        }
        if (i != 0 || i2 != 0) {
            C0517s.m1706c(this);
        }
    }

    void ensureLeftGlow() {
        if (this.mLeftGlow == null) {
            this.mLeftGlow = this.mEdgeEffectFactory.m2291a(this, 0);
            if (this.mClipToPadding) {
                this.mLeftGlow.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.mLeftGlow.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void ensureRightGlow() {
        if (this.mRightGlow == null) {
            this.mRightGlow = this.mEdgeEffectFactory.m2291a(this, 2);
            if (this.mClipToPadding) {
                this.mRightGlow.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.mRightGlow.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void ensureTopGlow() {
        if (this.mTopGlow == null) {
            this.mTopGlow = this.mEdgeEffectFactory.m2291a(this, 1);
            if (this.mClipToPadding) {
                this.mTopGlow.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.mTopGlow.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    void ensureBottomGlow() {
        if (this.mBottomGlow == null) {
            this.mBottomGlow = this.mEdgeEffectFactory.m2291a(this, 3);
            if (this.mClipToPadding) {
                this.mBottomGlow.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.mBottomGlow.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void setEdgeEffectFactory(C0693e c0693e) {
        C0462k.m1451a(c0693e);
        this.mEdgeEffectFactory = c0693e;
        invalidateGlows();
    }

    public C0693e getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    public View focusSearch(View view, int i) {
        View onInterceptFocusSearch = this.mLayout.onInterceptFocusSearch(view, i);
        if (onInterceptFocusSearch != null) {
            return onInterceptFocusSearch;
        }
        Object obj = (this.mAdapter == null || this.mLayout == null || isComputingLayout() || this.mLayoutFrozen) ? null : 1;
        FocusFinder instance = FocusFinder.getInstance();
        if (obj == null || !(i == 2 || i == 1)) {
            View findNextFocus = instance.findNextFocus(this, view, i);
            if (findNextFocus != null || obj == null) {
                onInterceptFocusSearch = findNextFocus;
            } else {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                onInterceptFocusSearch = this.mLayout.onFocusSearchFailed(view, i, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
        } else {
            int i2;
            Object obj2;
            if (this.mLayout.canScrollVertically()) {
                i2 = i == 2 ? 130 : 33;
                obj2 = instance.findNextFocus(this, view, i2) == null ? 1 : null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i = i2;
                }
            } else {
                obj2 = null;
            }
            if (obj2 == null && this.mLayout.canScrollHorizontally()) {
                i2 = ((this.mLayout.getLayoutDirection() == 1 ? 1 : 0) ^ (i == 2 ? 1 : 0)) != 0 ? 66 : 17;
                obj2 = instance.findNextFocus(this, view, i2) == null ? 1 : null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i = i2;
                }
            }
            if (obj2 != null) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                this.mLayout.onFocusSearchFailed(view, i, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
            onInterceptFocusSearch = instance.findNextFocus(this, view, i);
        }
        if (onInterceptFocusSearch == null || onInterceptFocusSearch.hasFocusable()) {
            if (!isPreferredNextFocus(view, onInterceptFocusSearch, i)) {
                onInterceptFocusSearch = super.focusSearch(view, i);
            }
            return onInterceptFocusSearch;
        } else if (getFocusedChild() == null) {
            return super.focusSearch(view, i);
        } else {
            requestChildOnScreen(onInterceptFocusSearch, null);
            return view;
        }
    }

    private boolean isPreferredNextFocus(View view, View view2, int i) {
        boolean z = false;
        if (view2 != null) {
            if (view2 != this) {
                if (findContainingItemView(view2) == null) {
                    return false;
                }
                if (view == null || findContainingItemView(view) == null) {
                    return true;
                }
                this.mTempRect.set(0, 0, view.getWidth(), view.getHeight());
                this.mTempRect2.set(0, 0, view2.getWidth(), view2.getHeight());
                offsetDescendantRectToMyCoords(view, this.mTempRect);
                offsetDescendantRectToMyCoords(view2, this.mTempRect2);
                view2 = -1;
                view = this.mLayout.getLayoutDirection() == 1 ? -1 : true;
                int i2 = ((this.mTempRect.left < this.mTempRect2.left || this.mTempRect.right <= this.mTempRect2.left) && this.mTempRect.right < this.mTempRect2.right) ? 1 : ((this.mTempRect.right > this.mTempRect2.right || this.mTempRect.left >= this.mTempRect2.right) && this.mTempRect.left > this.mTempRect2.left) ? -1 : 0;
                if ((this.mTempRect.top < this.mTempRect2.top || this.mTempRect.bottom <= this.mTempRect2.top) && this.mTempRect.bottom < this.mTempRect2.bottom) {
                    view2 = true;
                } else if ((this.mTempRect.bottom <= this.mTempRect2.bottom && this.mTempRect.top < this.mTempRect2.bottom) || this.mTempRect.top <= this.mTempRect2.top) {
                    view2 = null;
                }
                if (i == 17) {
                    if (i2 < 0) {
                        z = true;
                    }
                    return z;
                } else if (i == 33) {
                    if (view2 < null) {
                        z = true;
                    }
                    return z;
                } else if (i == 66) {
                    if (i2 > 0) {
                        z = true;
                    }
                    return z;
                } else if (i != 130) {
                    switch (i) {
                        case 1:
                            if (view2 < null || (view2 == null && i2 * view <= 0)) {
                                z = true;
                            }
                            return z;
                        case 2:
                            if (view2 > null || (view2 == null && i2 * view >= 0)) {
                                z = true;
                            }
                            return z;
                        default:
                            view2 = new StringBuilder();
                            view2.append("Invalid direction: ");
                            view2.append(i);
                            view2.append(exceptionLabel());
                            throw new IllegalArgumentException(view2.toString());
                    }
                } else {
                    if (view2 > null) {
                        z = true;
                    }
                    return z;
                }
            }
        }
        return false;
    }

    public void requestChildFocus(View view, View view2) {
        if (!(this.mLayout.onRequestChildFocus(this, this.mState, view, view2) || view2 == null)) {
            requestChildOnScreen(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    private void requestChildOnScreen(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof C0702j) {
            C0702j c0702j = (C0702j) layoutParams;
            if (!c0702j.f1816e) {
                Rect rect = c0702j.f1815d;
                Rect rect2 = this.mTempRect;
                rect2.left -= rect.left;
                rect2 = this.mTempRect;
                rect2.right += rect.right;
                rect2 = this.mTempRect;
                rect2.top -= rect.top;
                rect2 = this.mTempRect;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
        }
        this.mLayout.requestChildRectangleOnScreen(this, view, this.mTempRect, this.mFirstLayoutComplete ^ 1, view2 == null);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.mLayout.requestChildRectangleOnScreen(this, view, rect, z);
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (this.mLayout == null || !this.mLayout.onAddFocusables(this, arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mLayoutOrScrollCounter = 0;
        boolean z = true;
        this.mIsAttached = true;
        if (!this.mFirstLayoutComplete || isLayoutRequested()) {
            z = false;
        }
        this.mFirstLayoutComplete = z;
        if (this.mLayout != null) {
            this.mLayout.dispatchAttachedToWindow(this);
        }
        this.mPostedAnimatorRunner = false;
        if (ALLOW_THREAD_GAP_WORK) {
            this.mGapWorker = (aq) aq.f2012a.get();
            if (this.mGapWorker == null) {
                float refreshRate;
                this.mGapWorker = new aq();
                Display C = C0517s.m1685C(this);
                if (!(isInEditMode() || C == null)) {
                    refreshRate = C.getRefreshRate();
                    if (refreshRate >= 30.0f) {
                        this.mGapWorker.f2016d = (long) (1.0E9f / refreshRate);
                        aq.f2012a.set(this.mGapWorker);
                    }
                }
                refreshRate = 60.0f;
                this.mGapWorker.f2016d = (long) (1.0E9f / refreshRate);
                aq.f2012a.set(this.mGapWorker);
            }
            this.mGapWorker.m2651a(this);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mItemAnimator != null) {
            this.mItemAnimator.mo2770d();
        }
        stopScroll();
        this.mIsAttached = false;
        if (this.mLayout != null) {
            this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.m2831b();
        if (ALLOW_THREAD_GAP_WORK && this.mGapWorker != null) {
            this.mGapWorker.m2653b(this);
            this.mGapWorker = null;
        }
    }

    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    void assertInLayoutOrScroll(String str) {
        if (!isComputingLayout()) {
            if (str == null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Cannot call this method unless RecyclerView is computing a layout or scrolling");
                stringBuilder.append(exceptionLabel());
                throw new IllegalStateException(stringBuilder.toString());
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append(exceptionLabel());
            throw new IllegalStateException(stringBuilder2.toString());
        }
    }

    void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str == null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Cannot call this method while RecyclerView is computing a layout or scrolling");
                stringBuilder.append(exceptionLabel());
                throw new IllegalStateException(stringBuilder.toString());
            }
            throw new IllegalStateException(str);
        } else if (this.mDispatchScrollCounter > null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("");
            stringBuilder2.append(exceptionLabel());
            Log.w(TAG, "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(stringBuilder2.toString()));
        }
    }

    public void addOnItemTouchListener(C0705m c0705m) {
        this.mOnItemTouchListeners.add(c0705m);
    }

    public void removeOnItemTouchListener(C0705m c0705m) {
        this.mOnItemTouchListeners.remove(c0705m);
        if (this.mActiveOnItemTouchListener == c0705m) {
            this.mActiveOnItemTouchListener = null;
        }
    }

    private boolean dispatchOnItemTouchIntercept(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.mActiveOnItemTouchListener = null;
        }
        int size = this.mOnItemTouchListeners.size();
        int i = 0;
        while (i < size) {
            C0705m c0705m = (C0705m) this.mOnItemTouchListeners.get(i);
            if (!c0705m.mo627a(this, motionEvent) || action == 3) {
                i++;
            } else {
                this.mActiveOnItemTouchListener = c0705m;
                return true;
            }
        }
        return false;
    }

    private boolean dispatchOnItemTouch(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mActiveOnItemTouchListener != null) {
            if (action == 0) {
                this.mActiveOnItemTouchListener = null;
            } else {
                this.mActiveOnItemTouchListener.mo628b(this, motionEvent);
                if (action == 3 || action == 1) {
                    this.mActiveOnItemTouchListener = null;
                }
                return true;
            }
        }
        if (action != 0) {
            action = this.mOnItemTouchListeners.size();
            for (int i = 0; i < action; i++) {
                C0705m c0705m = (C0705m) this.mOnItemTouchListeners.get(i);
                if (c0705m.mo627a(this, motionEvent)) {
                    this.mActiveOnItemTouchListener = c0705m;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.mLayoutFrozen) {
            return false;
        }
        if (dispatchOnItemTouchIntercept(motionEvent)) {
            cancelTouch();
            return true;
        } else if (this.mLayout == null) {
            return false;
        } else {
            boolean canScrollHorizontally = this.mLayout.canScrollHorizontally();
            boolean canScrollVertically = this.mLayout.canScrollVertically();
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            int actionIndex = motionEvent.getActionIndex();
            switch (actionMasked) {
                case 0:
                    if (this.mIgnoreMotionEventTillDown) {
                        this.mIgnoreMotionEventTillDown = false;
                    }
                    this.mScrollPointerId = motionEvent.getPointerId(0);
                    actionMasked = (int) (motionEvent.getX() + 0.5f);
                    this.mLastTouchX = actionMasked;
                    this.mInitialTouchX = actionMasked;
                    motionEvent = (int) (motionEvent.getY() + 1056964608);
                    this.mLastTouchY = motionEvent;
                    this.mInitialTouchY = motionEvent;
                    if (this.mScrollState == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                    }
                    motionEvent = this.mNestedOffsets;
                    this.mNestedOffsets[1] = 0;
                    motionEvent[0] = null;
                    motionEvent = canScrollHorizontally ? true : null;
                    if (canScrollVertically) {
                        motionEvent |= 2;
                    }
                    startNestedScroll(motionEvent, 0);
                    break;
                case 1:
                    this.mVelocityTracker.clear();
                    stopNestedScroll(0);
                    break;
                case 2:
                    actionMasked = motionEvent.findPointerIndex(this.mScrollPointerId);
                    if (actionMasked >= 0) {
                        actionIndex = (int) (motionEvent.getX(actionMasked) + 0.5f);
                        motionEvent = (int) (motionEvent.getY(actionMasked) + 1056964608);
                        if (this.mScrollState != 1) {
                            Object obj;
                            actionMasked = actionIndex - this.mInitialTouchX;
                            int i = motionEvent - this.mInitialTouchY;
                            if (!canScrollHorizontally || Math.abs(actionMasked) <= this.mTouchSlop) {
                                obj = null;
                            } else {
                                this.mLastTouchX = actionIndex;
                                obj = 1;
                            }
                            if (canScrollVertically && Math.abs(i) > this.mTouchSlop) {
                                this.mLastTouchY = motionEvent;
                                obj = 1;
                            }
                            if (obj != null) {
                                setScrollState(1);
                                break;
                            }
                        }
                    }
                    motionEvent = TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Error processing scroll; pointer index for id ");
                    stringBuilder.append(this.mScrollPointerId);
                    stringBuilder.append(" not found. Did any MotionEvents get skipped?");
                    Log.e(motionEvent, stringBuilder.toString());
                    return false;
                    break;
                case 3:
                    cancelTouch();
                    break;
                case 5:
                    this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
                    int x = (int) (motionEvent.getX(actionIndex) + 0.5f);
                    this.mLastTouchX = x;
                    this.mInitialTouchX = x;
                    motionEvent = (int) (motionEvent.getY(actionIndex) + 1056964608);
                    this.mLastTouchY = motionEvent;
                    this.mInitialTouchY = motionEvent;
                    break;
                case 6:
                    onPointerUp(motionEvent);
                    break;
                default:
                    break;
            }
            if (this.mScrollState == 1) {
                z = true;
            }
            return z;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.mOnItemTouchListeners.size();
        for (int i = 0; i < size; i++) {
            ((C0705m) this.mOnItemTouchListeners.get(i)).mo626a(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.mLayoutFrozen) {
            if (!this.mIgnoreMotionEventTillDown) {
                if (dispatchOnItemTouch(motionEvent)) {
                    cancelTouch();
                    return true;
                } else if (this.mLayout == null) {
                    return false;
                } else {
                    int[] iArr;
                    boolean canScrollHorizontally = this.mLayout.canScrollHorizontally();
                    boolean canScrollVertically = this.mLayout.canScrollVertically();
                    if (this.mVelocityTracker == null) {
                        this.mVelocityTracker = VelocityTracker.obtain();
                    }
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    int actionMasked = motionEvent.getActionMasked();
                    int actionIndex = motionEvent.getActionIndex();
                    if (actionMasked == 0) {
                        iArr = this.mNestedOffsets;
                        this.mNestedOffsets[1] = 0;
                        iArr[0] = 0;
                    }
                    obtain.offsetLocation((float) this.mNestedOffsets[0], (float) this.mNestedOffsets[1]);
                    switch (actionMasked) {
                        case 0:
                            this.mScrollPointerId = motionEvent.getPointerId(0);
                            actionMasked = (int) (motionEvent.getX() + 0.5f);
                            this.mLastTouchX = actionMasked;
                            this.mInitialTouchX = actionMasked;
                            motionEvent = (int) (motionEvent.getY() + 1056964608);
                            this.mLastTouchY = motionEvent;
                            this.mInitialTouchY = motionEvent;
                            motionEvent = canScrollHorizontally ? true : null;
                            if (canScrollVertically) {
                                motionEvent |= 2;
                            }
                            startNestedScroll(motionEvent, 0);
                            break;
                        case 1:
                            this.mVelocityTracker.addMovement(obtain);
                            this.mVelocityTracker.computeCurrentVelocity(1000, (float) this.mMaxFlingVelocity);
                            float f = canScrollHorizontally ? -this.mVelocityTracker.getXVelocity(this.mScrollPointerId) : 0.0f;
                            float f2 = canScrollVertically ? -this.mVelocityTracker.getYVelocity(this.mScrollPointerId) : 0.0f;
                            if ((f == 0.0f && f2 == 0.0f) || fling((int) f, (int) f2) == null) {
                                setScrollState(0);
                            }
                            resetTouch();
                            z = true;
                            break;
                        case 2:
                            actionMasked = motionEvent.findPointerIndex(this.mScrollPointerId);
                            if (actionMasked >= 0) {
                                actionIndex = (int) (motionEvent.getX(actionMasked) + 0.5f);
                                motionEvent = (int) (motionEvent.getY(actionMasked) + 1056964608);
                                actionMasked = this.mLastTouchX - actionIndex;
                                int i = this.mLastTouchY - motionEvent;
                                if (dispatchNestedPreScroll(actionMasked, i, this.mScrollConsumed, this.mScrollOffset, 0)) {
                                    actionMasked -= this.mScrollConsumed[0];
                                    i -= this.mScrollConsumed[1];
                                    obtain.offsetLocation((float) this.mScrollOffset[0], (float) this.mScrollOffset[1]);
                                    iArr = this.mNestedOffsets;
                                    iArr[0] = iArr[0] + this.mScrollOffset[0];
                                    iArr = this.mNestedOffsets;
                                    iArr[1] = iArr[1] + this.mScrollOffset[1];
                                }
                                if (this.mScrollState != 1) {
                                    Object obj;
                                    if (!canScrollHorizontally || Math.abs(actionMasked) <= this.mTouchSlop) {
                                        obj = null;
                                    } else {
                                        if (actionMasked > 0) {
                                            actionMasked -= this.mTouchSlop;
                                        } else {
                                            actionMasked += this.mTouchSlop;
                                        }
                                        obj = 1;
                                    }
                                    if (canScrollVertically && Math.abs(i) > this.mTouchSlop) {
                                        if (i > 0) {
                                            i -= this.mTouchSlop;
                                        } else {
                                            i += this.mTouchSlop;
                                        }
                                        obj = 1;
                                    }
                                    if (obj != null) {
                                        setScrollState(1);
                                    }
                                }
                                if (this.mScrollState == 1) {
                                    this.mLastTouchX = actionIndex - this.mScrollOffset[0];
                                    this.mLastTouchY = motionEvent - this.mScrollOffset[1];
                                    if (scrollByInternal(canScrollHorizontally ? actionMasked : null, canScrollVertically ? i : 0, obtain) != null) {
                                        getParent().requestDisallowInterceptTouchEvent(true);
                                    }
                                    if (!(this.mGapWorker == null || (actionMasked == 0 && i == 0))) {
                                        this.mGapWorker.m2652a(this, actionMasked, i);
                                        break;
                                    }
                                }
                            }
                            motionEvent = TAG;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Error processing scroll; pointer index for id ");
                            stringBuilder.append(this.mScrollPointerId);
                            stringBuilder.append(" not found. Did any MotionEvents get skipped?");
                            Log.e(motionEvent, stringBuilder.toString());
                            return false;
                            break;
                        case 3:
                            cancelTouch();
                            break;
                        case 5:
                            this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
                            int x = (int) (motionEvent.getX(actionIndex) + 0.5f);
                            this.mLastTouchX = x;
                            this.mInitialTouchX = x;
                            motionEvent = (int) (motionEvent.getY(actionIndex) + 1056964608);
                            this.mLastTouchY = motionEvent;
                            this.mInitialTouchY = motionEvent;
                            break;
                        case 6:
                            onPointerUp(motionEvent);
                            break;
                        default:
                            break;
                    }
                    if (!z) {
                        this.mVelocityTracker.addMovement(obtain);
                    }
                    obtain.recycle();
                    return true;
                }
            }
        }
        return false;
    }

    private void resetTouch() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
        }
        stopNestedScroll(0);
        releaseGlows();
    }

    private void cancelTouch() {
        resetTouch();
        setScrollState(0);
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            actionIndex = actionIndex == 0 ? 1 : 0;
            this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
            int x = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.mLastTouchX = x;
            this.mInitialTouchX = x;
            motionEvent = (int) (motionEvent.getY(actionIndex) + 1056964608);
            this.mLastTouchY = motionEvent;
            this.mInitialTouchY = motionEvent;
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (!(this.mLayout == null || this.mLayoutFrozen || motionEvent.getAction() != 8)) {
            float f;
            float axisValue;
            if ((motionEvent.getSource() & 2) != 0) {
                f = this.mLayout.canScrollVertically() ? -motionEvent.getAxisValue(9) : 0.0f;
                if (this.mLayout.canScrollHorizontally()) {
                    axisValue = motionEvent.getAxisValue(10);
                    if (!(f == 0.0f && axisValue == 0.0f)) {
                        scrollByInternal((int) (axisValue * this.mScaledHorizontalScrollFactor), (int) (f * this.mScaledVerticalScrollFactor), motionEvent);
                    }
                }
            } else {
                if ((motionEvent.getSource() & DefaultFlexByteArrayPoolParams.DEFAULT_MAX_BYTE_ARRAY_SIZE) != 0) {
                    f = motionEvent.getAxisValue(26);
                    if (this.mLayout.canScrollVertically()) {
                        f = -f;
                    } else if (this.mLayout.canScrollHorizontally()) {
                        axisValue = f;
                        f = 0.0f;
                        scrollByInternal((int) (axisValue * this.mScaledHorizontalScrollFactor), (int) (f * this.mScaledVerticalScrollFactor), motionEvent);
                    }
                }
                f = 0.0f;
            }
            axisValue = 0.0f;
            scrollByInternal((int) (axisValue * this.mScaledHorizontalScrollFactor), (int) (f * this.mScaledVerticalScrollFactor), motionEvent);
        }
        return false;
    }

    protected void onMeasure(int i, int i2) {
        if (this.mLayout == null) {
            defaultOnMeasure(i, i2);
            return;
        }
        boolean z = false;
        if (this.mLayout.isAutoMeasureEnabled()) {
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            this.mLayout.onMeasure(this.mRecycler, this.mState, i, i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            if (!z) {
                if (this.mAdapter != null) {
                    if (this.mState.f1842c == 1) {
                        dispatchLayoutStep1();
                    }
                    this.mLayout.setMeasureSpecs(i, i2);
                    this.mState.f1847h = true;
                    dispatchLayoutStep2();
                    this.mLayout.setMeasuredDimensionFromChildren(i, i2);
                    if (this.mLayout.shouldMeasureTwice()) {
                        this.mLayout.setMeasureSpecs(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                        this.mState.f1847h = true;
                        dispatchLayoutStep2();
                        this.mLayout.setMeasuredDimensionFromChildren(i, i2);
                    }
                }
            }
        } else if (this.mHasFixedSize) {
            this.mLayout.onMeasure(this.mRecycler, this.mState, i, i2);
        } else {
            if (this.mAdapterUpdateDuringMeasure) {
                startInterceptRequestLayout();
                onEnterLayoutOrScroll();
                processAdapterUpdatesAndSetAnimationFlags();
                onExitLayoutOrScroll();
                if (this.mState.f1849j) {
                    this.mState.f1845f = true;
                } else {
                    this.mAdapterHelper.m10619e();
                    this.mState.f1845f = false;
                }
                this.mAdapterUpdateDuringMeasure = false;
                stopInterceptRequestLayout(false);
            } else if (this.mState.f1849j) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            if (this.mAdapter != null) {
                this.mState.f1843d = this.mAdapter.getItemCount();
            } else {
                this.mState.f1843d = 0;
            }
            startInterceptRequestLayout();
            this.mLayout.onMeasure(this.mRecycler, this.mState, i, i2);
            stopInterceptRequestLayout(false);
            this.mState.f1845f = false;
        }
    }

    void defaultOnMeasure(int i, int i2) {
        setMeasuredDimension(C0701i.chooseSize(i, getPaddingLeft() + getPaddingRight(), C0517s.m1715i(this)), C0701i.chooseSize(i2, getPaddingTop() + getPaddingBottom(), C0517s.m1716j(this)));
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            invalidateGlows();
        }
    }

    public void setItemAnimator(C0697f c0697f) {
        if (this.mItemAnimator != null) {
            this.mItemAnimator.mo2770d();
            this.mItemAnimator.m2300a(null);
        }
        this.mItemAnimator = c0697f;
        if (this.mItemAnimator != null) {
            this.mItemAnimator.m2300a(this.mItemAnimatorListener);
        }
    }

    void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    void onExitLayoutOrScroll(boolean z) {
        this.mLayoutOrScrollCounter--;
        if (this.mLayoutOrScrollCounter < 1) {
            this.mLayoutOrScrollCounter = 0;
            if (z) {
                dispatchContentChangedIfNecessary();
                dispatchPendingImportantForAccessibilityChanges();
            }
        }
    }

    boolean isAccessibilityEnabled() {
        return this.mAccessibilityManager != null && this.mAccessibilityManager.isEnabled();
    }

    private void dispatchContentChangedIfNecessary() {
        int i = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (i != 0 && isAccessibilityEnabled()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            C0479a.m1495a(obtain, i);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    public boolean isComputingLayout() {
        return this.mLayoutOrScrollCounter > 0;
    }

    boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (!isComputingLayout()) {
            return false;
        }
        accessibilityEvent = accessibilityEvent != null ? C0479a.m1494a(accessibilityEvent) : null;
        if (accessibilityEvent == null) {
            accessibilityEvent = null;
        }
        this.mEatenAccessibilityChangeFlags = accessibilityEvent | this.mEatenAccessibilityChangeFlags;
        return true;
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!shouldDeferAccessibilityEvent(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public C0697f getItemAnimator() {
        return this.mItemAnimator;
    }

    void postAnimationRunner() {
        if (!this.mPostedAnimatorRunner && this.mIsAttached) {
            C0517s.m1697a((View) this, this.mItemAnimatorRunner);
            this.mPostedAnimatorRunner = true;
        }
    }

    private boolean predictiveItemAnimationsEnabled() {
        return this.mItemAnimator != null && this.mLayout.supportsPredictiveItemAnimations();
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        Object obj;
        C0715u c0715u;
        boolean z;
        if (this.mDataSetHasChangedAfterLayout) {
            this.mAdapterHelper.m10605a();
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.onItemsChanged(this);
            }
        }
        if (predictiveItemAnimationsEnabled()) {
            this.mAdapterHelper.m10613b();
        } else {
            this.mAdapterHelper.m10619e();
        }
        boolean z2 = false;
        if (!this.mItemsAddedOrRemoved) {
            if (!this.mItemsChanged) {
                obj = null;
                c0715u = this.mState;
                z = this.mFirstLayoutComplete && this.mItemAnimator != null && ((this.mDataSetHasChangedAfterLayout || obj != null || this.mLayout.mRequestedSimpleAnimations) && (!this.mDataSetHasChangedAfterLayout || this.mAdapter.hasStableIds()));
                c0715u.f1848i = z;
                c0715u = this.mState;
                if (this.mState.f1848i && obj != null && !this.mDataSetHasChangedAfterLayout && predictiveItemAnimationsEnabled()) {
                    z2 = true;
                }
                c0715u.f1849j = z2;
            }
        }
        obj = 1;
        c0715u = this.mState;
        if (!this.mFirstLayoutComplete) {
        }
        c0715u.f1848i = z;
        c0715u = this.mState;
        z2 = true;
        c0715u.f1849j = z2;
    }

    void dispatchLayout() {
        if (this.mAdapter == null) {
            Log.e(TAG, "No adapter attached; skipping layout");
        } else if (this.mLayout == null) {
            Log.e(TAG, "No layout manager attached; skipping layout");
        } else {
            this.mState.f1847h = false;
            if (this.mState.f1842c == 1) {
                dispatchLayoutStep1();
                this.mLayout.setExactMeasureSpecsFrom(this);
                dispatchLayoutStep2();
            } else {
                if (!this.mAdapterHelper.m10620f() && this.mLayout.getWidth() == getWidth()) {
                    if (this.mLayout.getHeight() == getHeight()) {
                        this.mLayout.setExactMeasureSpecsFrom(this);
                    }
                }
                this.mLayout.setExactMeasureSpecsFrom(this);
                dispatchLayoutStep2();
            }
            dispatchLayoutStep3();
        }
    }

    private void saveFocusInfo() {
        C0718x c0718x = null;
        View focusedChild = (this.mPreserveFocusAfterLayout && hasFocus() && this.mAdapter != null) ? getFocusedChild() : null;
        if (focusedChild != null) {
            c0718x = findContainingViewHolder(focusedChild);
        }
        if (c0718x == null) {
            resetFocusInfo();
            return;
        }
        int i;
        this.mState.f1851l = this.mAdapter.hasStableIds() ? c0718x.getItemId() : -1;
        C0715u c0715u = this.mState;
        if (this.mDataSetHasChangedAfterLayout) {
            i = -1;
        } else if (c0718x.isRemoved()) {
            i = c0718x.mOldPosition;
        } else {
            i = c0718x.getAdapterPosition();
        }
        c0715u.f1850k = i;
        this.mState.f1852m = getDeepestFocusedViewWithId(c0718x.itemView);
    }

    private void resetFocusInfo() {
        this.mState.f1851l = -1;
        this.mState.f1850k = -1;
        this.mState.f1852m = -1;
    }

    private View findNextViewToFocus() {
        int i = this.mState.f1850k != -1 ? this.mState.f1850k : 0;
        int e = this.mState.m2402e();
        int i2 = i;
        while (i2 < e) {
            C0718x findViewHolderForAdapterPosition = findViewHolderForAdapterPosition(i2);
            if (findViewHolderForAdapterPosition == null) {
                break;
            } else if (findViewHolderForAdapterPosition.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition.itemView;
            } else {
                i2++;
            }
        }
        for (i = Math.min(e, i) - 1; i >= 0; i--) {
            C0718x findViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i);
            if (findViewHolderForAdapterPosition2 == null) {
                return null;
            }
            if (findViewHolderForAdapterPosition2.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition2.itemView;
            }
        }
        return null;
    }

    private void recoverFocusFromState() {
        if (this.mPreserveFocusAfterLayout && this.mAdapter != null && hasFocus() && getDescendantFocusability() != 393216) {
            if (getDescendantFocusability() != 131072 || !isFocused()) {
                View focusedChild;
                if (!isFocused()) {
                    focusedChild = getFocusedChild();
                    if (!IGNORE_DETACHED_FOCUSED_CHILD || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                        if (!this.mChildHelper.m2566c(focusedChild)) {
                            return;
                        }
                    } else if (this.mChildHelper.m2561b() == 0) {
                        requestFocus();
                        return;
                    }
                }
                View view = null;
                C0718x findViewHolderForItemId = (this.mState.f1851l == -1 || !this.mAdapter.hasStableIds()) ? null : findViewHolderForItemId(this.mState.f1851l);
                if (!(findViewHolderForItemId == null || this.mChildHelper.m2566c(findViewHolderForItemId.itemView))) {
                    if (findViewHolderForItemId.itemView.hasFocusable()) {
                        view = findViewHolderForItemId.itemView;
                        if (view != null) {
                            if (((long) this.mState.f1852m) != -1) {
                                focusedChild = view.findViewById(this.mState.f1852m);
                                if (focusedChild != null && focusedChild.isFocusable()) {
                                    focusedChild.requestFocus();
                                }
                            }
                            focusedChild = view;
                            focusedChild.requestFocus();
                        }
                    }
                }
                if (this.mChildHelper.m2561b() > 0) {
                    view = findNextViewToFocus();
                }
                if (view != null) {
                    if (((long) this.mState.f1852m) != -1) {
                        focusedChild = view.findViewById(this.mState.f1852m);
                        focusedChild.requestFocus();
                    }
                    focusedChild = view;
                    focusedChild.requestFocus();
                }
            }
        }
    }

    private int getDeepestFocusedViewWithId(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    final void fillRemainingScrollValues(C0715u c0715u) {
        if (getScrollState() == 2) {
            OverScroller a = this.mViewFlinger.f1861e;
            c0715u.f1853n = a.getFinalX() - a.getCurrX();
            c0715u.f1854o = a.getFinalY() - a.getCurrY();
            return;
        }
        c0715u.f1853n = 0;
        c0715u.f1854o = 0;
    }

    private void dispatchLayoutStep1() {
        int b;
        boolean z = true;
        this.mState.m2396a(1);
        fillRemainingScrollValues(this.mState);
        this.mState.f1847h = false;
        startInterceptRequestLayout();
        this.mViewInfoStore.m2825a();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        C0715u c0715u = this.mState;
        if (!this.mState.f1848i || !this.mItemsChanged) {
            z = false;
        }
        c0715u.f1846g = z;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        this.mState.f1845f = this.mState.f1849j;
        this.mState.f1843d = this.mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.f1848i) {
            b = this.mChildHelper.m2561b();
            for (int i = 0; i < b; i++) {
                C0718x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2563b(i));
                if (!childViewHolderInt.shouldIgnore()) {
                    if (!childViewHolderInt.isInvalid() || this.mAdapter.hasStableIds()) {
                        this.mViewInfoStore.m2827a(childViewHolderInt, this.mItemAnimator.m2298a(this.mState, childViewHolderInt, C0697f.m2296e(childViewHolderInt), childViewHolderInt.getUnmodifiedPayloads()));
                        if (!(!this.mState.f1846g || !childViewHolderInt.isUpdated() || childViewHolderInt.isRemoved() || childViewHolderInt.shouldIgnore() || childViewHolderInt.isInvalid())) {
                            this.mViewInfoStore.m2826a(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                        }
                    }
                }
            }
        }
        if (this.mState.f1849j) {
            saveOldPositions();
            boolean z2 = this.mState.f1844e;
            this.mState.f1844e = false;
            this.mLayout.onLayoutChildren(this.mRecycler, this.mState);
            this.mState.f1844e = z2;
            for (b = 0; b < this.mChildHelper.m2561b(); b++) {
                C0718x childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.m2563b(b));
                if (!childViewHolderInt2.shouldIgnore()) {
                    if (!this.mViewInfoStore.m2835d(childViewHolderInt2)) {
                        int e = C0697f.m2296e(childViewHolderInt2);
                        boolean hasAnyOfTheFlags = childViewHolderInt2.hasAnyOfTheFlags(Utility.DEFAULT_STREAM_BUFFER_SIZE);
                        if (!hasAnyOfTheFlags) {
                            e |= 4096;
                        }
                        C0696c a = this.mItemAnimator.m2298a(this.mState, childViewHolderInt2, e, childViewHolderInt2.getUnmodifiedPayloads());
                        if (hasAnyOfTheFlags) {
                            recordAnimationInfoIfBouncedHiddenView(childViewHolderInt2, a);
                        } else {
                            this.mViewInfoStore.m2832b(childViewHolderInt2, a);
                        }
                    }
                }
            }
            clearOldPositions();
        } else {
            clearOldPositions();
        }
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.f1842c = 2;
    }

    private void dispatchLayoutStep2() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.m2396a(6);
        this.mAdapterHelper.m10619e();
        this.mState.f1843d = this.mAdapter.getItemCount();
        this.mState.f1841b = 0;
        this.mState.f1845f = false;
        this.mLayout.onLayoutChildren(this.mRecycler, this.mState);
        this.mState.f1844e = false;
        this.mPendingSavedState = null;
        C0715u c0715u = this.mState;
        boolean z = this.mState.f1848i && this.mItemAnimator != null;
        c0715u.f1848i = z;
        this.mState.f1842c = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
    }

    private void dispatchLayoutStep3() {
        this.mState.m2396a(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.f1842c = 1;
        if (this.mState.f1848i) {
            for (int b = this.mChildHelper.m2561b() - 1; b >= 0; b--) {
                C0718x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2563b(b));
                if (!childViewHolderInt.shouldIgnore()) {
                    long changedHolderKey = getChangedHolderKey(childViewHolderInt);
                    C0696c a = this.mItemAnimator.m2297a(this.mState, childViewHolderInt);
                    C0718x a2 = this.mViewInfoStore.m2824a(changedHolderKey);
                    if (a2 == null || a2.shouldIgnore()) {
                        this.mViewInfoStore.m2834c(childViewHolderInt, a);
                    } else {
                        boolean a3 = this.mViewInfoStore.m2829a(a2);
                        boolean a4 = this.mViewInfoStore.m2829a(childViewHolderInt);
                        if (a3 && a2 == childViewHolderInt) {
                            this.mViewInfoStore.m2834c(childViewHolderInt, a);
                        } else {
                            C0696c b2 = this.mViewInfoStore.m2830b(a2);
                            this.mViewInfoStore.m2834c(childViewHolderInt, a);
                            C0696c c = this.mViewInfoStore.m2833c(childViewHolderInt);
                            if (b2 == null) {
                                handleMissingPreInfoForChangeError(changedHolderKey, childViewHolderInt, a2);
                            } else {
                                animateChange(a2, childViewHolderInt, b2, c, a3, a4);
                            }
                        }
                    }
                }
            }
            this.mViewInfoStore.m2828a(this.mViewInfoProcessCallback);
        }
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        this.mState.f1840a = this.mState.f1843d;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mState.f1848i = false;
        this.mState.f1849j = false;
        this.mLayout.mRequestedSimpleAnimations = false;
        if (this.mRecycler.f1825b != null) {
            this.mRecycler.f1825b.clear();
        }
        if (this.mLayout.mPrefetchMaxObservedInInitialPrefetch) {
            this.mLayout.mPrefetchMaxCountObserved = 0;
            this.mLayout.mPrefetchMaxObservedInInitialPrefetch = false;
            this.mRecycler.m2366b();
        }
        this.mLayout.onLayoutCompleted(this.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mViewInfoStore.m2825a();
        if (didChildRangeChange(this.mMinMaxLayoutPositions[0], this.mMinMaxLayoutPositions[1])) {
            dispatchOnScrolled(0, 0);
        }
        recoverFocusFromState();
        resetFocusInfo();
    }

    private void handleMissingPreInfoForChangeError(long j, C0718x c0718x, C0718x c0718x2) {
        StringBuilder stringBuilder;
        int b = this.mChildHelper.m2561b();
        for (int i = 0; i < b; i++) {
            C0718x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2563b(i));
            if (childViewHolderInt != c0718x) {
                if (getChangedHolderKey(childViewHolderInt) == j) {
                    if (this.mAdapter == null || this.mAdapter.hasStableIds() == null) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:");
                        stringBuilder.append(childViewHolderInt);
                        stringBuilder.append(" \n View Holder 2:");
                        stringBuilder.append(c0718x);
                        stringBuilder.append(exceptionLabel());
                        throw new IllegalStateException(stringBuilder.toString());
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:");
                    stringBuilder.append(childViewHolderInt);
                    stringBuilder.append(" \n View Holder 2:");
                    stringBuilder.append(c0718x);
                    stringBuilder.append(exceptionLabel());
                    throw new IllegalStateException(stringBuilder.toString());
                }
            }
        }
        j = TAG;
        stringBuilder = new StringBuilder();
        stringBuilder.append("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ");
        stringBuilder.append(c0718x2);
        stringBuilder.append(" cannot be found but it is necessary for ");
        stringBuilder.append(c0718x);
        stringBuilder.append(exceptionLabel());
        Log.e(j, stringBuilder.toString());
    }

    void recordAnimationInfoIfBouncedHiddenView(C0718x c0718x, C0696c c0696c) {
        c0718x.setFlags(0, Utility.DEFAULT_STREAM_BUFFER_SIZE);
        if (this.mState.f1846g && c0718x.isUpdated() && !c0718x.isRemoved() && !c0718x.shouldIgnore()) {
            this.mViewInfoStore.m2826a(getChangedHolderKey(c0718x), c0718x);
        }
        this.mViewInfoStore.m2827a(c0718x, c0696c);
    }

    private void findMinMaxChildLayoutPositions(int[] iArr) {
        int b = this.mChildHelper.m2561b();
        if (b == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = LinearLayoutManager.INVALID_OFFSET;
        for (int i3 = 0; i3 < b; i3++) {
            C0718x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2563b(i3));
            if (!childViewHolderInt.shouldIgnore()) {
                int layoutPosition = childViewHolderInt.getLayoutPosition();
                if (layoutPosition < i) {
                    i = layoutPosition;
                }
                if (layoutPosition > i2) {
                    i2 = layoutPosition;
                }
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    private boolean didChildRangeChange(int i, int i2) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        return (this.mMinMaxLayoutPositions[0] == i && this.mMinMaxLayoutPositions[1] == i2) ? false : true;
    }

    protected void removeDetachedView(View view, boolean z) {
        C0718x childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.clearTmpDetachFlag();
            } else if (!childViewHolderInt.shouldIgnore()) {
                z = new StringBuilder();
                z.append("Called removeDetachedView with a view which is not flagged as tmp detached.");
                z.append(childViewHolderInt);
                z.append(exceptionLabel());
                throw new IllegalArgumentException(z.toString());
            }
        }
        view.clearAnimation();
        dispatchChildDetached(view);
        super.removeDetachedView(view, z);
    }

    long getChangedHolderKey(C0718x c0718x) {
        return this.mAdapter.hasStableIds() ? c0718x.getItemId() : (long) c0718x.mPosition;
    }

    void animateAppearance(C0718x c0718x, C0696c c0696c, C0696c c0696c2) {
        c0718x.setIsRecyclable(false);
        if (this.mItemAnimator.mo663b(c0718x, c0696c, c0696c2) != null) {
            postAnimationRunner();
        }
    }

    void animateDisappearance(C0718x c0718x, C0696c c0696c, C0696c c0696c2) {
        addAnimatingView(c0718x);
        c0718x.setIsRecyclable(false);
        if (this.mItemAnimator.mo661a(c0718x, c0696c, c0696c2) != null) {
            postAnimationRunner();
        }
    }

    private void animateChange(C0718x c0718x, C0718x c0718x2, C0696c c0696c, C0696c c0696c2, boolean z, boolean z2) {
        c0718x.setIsRecyclable(false);
        if (z) {
            addAnimatingView(c0718x);
        }
        if (c0718x != c0718x2) {
            if (z2) {
                addAnimatingView(c0718x2);
            }
            c0718x.mShadowedHolder = c0718x2;
            addAnimatingView(c0718x);
            this.mRecycler.m2373c(c0718x);
            c0718x2.setIsRecyclable(false);
            c0718x2.mShadowingHolder = c0718x;
        }
        if (this.mItemAnimator.mo662a(c0718x, c0718x2, c0696c, c0696c2) != null) {
            postAnimationRunner();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        C0397h.m1177a(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        C0397h.m1176a();
        this.mFirstLayoutComplete = true;
    }

    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth != 0 || this.mLayoutFrozen) {
            this.mLayoutWasDefered = true;
        } else {
            super.requestLayout();
        }
    }

    void markItemDecorInsetsDirty() {
        int c = this.mChildHelper.m2564c();
        for (int i = 0; i < c; i++) {
            ((C0702j) this.mChildHelper.m2567d(i).getLayoutParams()).f1816e = true;
        }
        this.mRecycler.m2385j();
    }

    public void draw(Canvas canvas) {
        int i;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            ((C0698h) this.mItemDecorations.get(i3)).mo625a(canvas, this, this.mState);
        }
        if (this.mLeftGlow == null || this.mLeftGlow.isFinished()) {
            i = 0;
        } else {
            size = canvas.save();
            i = this.mClipToPadding ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) ((-getHeight()) + i), 0.0f);
            i = (this.mLeftGlow == null || !this.mLeftGlow.draw(canvas)) ? 0 : 1;
            canvas.restoreToCount(size);
        }
        if (!(this.mTopGlow == null || this.mTopGlow.isFinished())) {
            size = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            int i4 = (this.mTopGlow == null || !this.mTopGlow.draw(canvas)) ? 0 : 1;
            i |= i4;
            canvas.restoreToCount(size);
        }
        if (!(this.mRightGlow == null || this.mRightGlow.isFinished())) {
            size = canvas.save();
            i4 = getWidth();
            int paddingTop = this.mClipToPadding ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate((float) (-paddingTop), (float) (-i4));
            i4 = (this.mRightGlow == null || !this.mRightGlow.draw(canvas)) ? 0 : 1;
            i |= i4;
            canvas.restoreToCount(size);
        }
        if (this.mBottomGlow == null || this.mBottomGlow.isFinished()) {
            i2 = i;
        } else {
            size = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            if (this.mBottomGlow != null && this.mBottomGlow.draw(canvas)) {
                i2 = 1;
            }
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (i2 == 0 && this.mItemAnimator != null && this.mItemDecorations.size() > null && this.mItemAnimator.mo2768b() != null) {
            i2 = 1;
        }
        if (i2 != 0) {
            C0517s.m1706c(this);
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.mItemDecorations.size();
        for (int i = 0; i < size; i++) {
            ((C0698h) this.mItemDecorations.get(i)).m2323b(canvas, this, this.mState);
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (!(layoutParams instanceof C0702j) || this.mLayout.checkLayoutParams((C0702j) layoutParams) == null) ? null : true;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        if (this.mLayout != null) {
            return this.mLayout.generateDefaultLayoutParams();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RecyclerView has no LayoutManager");
        stringBuilder.append(exceptionLabel());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.mLayout != null) {
            return this.mLayout.generateLayoutParams(getContext(), attributeSet);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RecyclerView has no LayoutManager");
        stringBuilder.append(exceptionLabel());
        throw new IllegalStateException(stringBuilder.toString());
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        if (this.mLayout != null) {
            return this.mLayout.generateLayoutParams(layoutParams);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RecyclerView has no LayoutManager");
        stringBuilder.append(exceptionLabel());
        throw new IllegalStateException(stringBuilder.toString());
    }

    public boolean isAnimating() {
        return this.mItemAnimator != null && this.mItemAnimator.mo2768b();
    }

    void saveOldPositions() {
        int c = this.mChildHelper.m2564c();
        for (int i = 0; i < c; i++) {
            C0718x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2567d(i));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.saveOldPosition();
            }
        }
    }

    void clearOldPositions() {
        int c = this.mChildHelper.m2564c();
        for (int i = 0; i < c; i++) {
            C0718x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2567d(i));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.clearOldPosition();
            }
        }
        this.mRecycler.m2384i();
    }

    void offsetPositionRecordsForMove(int i, int i2) {
        int i3;
        int i4;
        int c = this.mChildHelper.m2564c();
        int i5;
        if (i < i2) {
            i5 = i;
            i3 = i2;
            i4 = -1;
        } else {
            i3 = i;
            i5 = i2;
            i4 = 1;
        }
        for (int i6 = 0; i6 < c; i6++) {
            C0718x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2567d(i6));
            if (childViewHolderInt != null && childViewHolderInt.mPosition >= r2) {
                if (childViewHolderInt.mPosition <= i3) {
                    if (childViewHolderInt.mPosition == i) {
                        childViewHolderInt.offsetPosition(i2 - i, false);
                    } else {
                        childViewHolderInt.offsetPosition(i4, false);
                    }
                    this.mState.f1844e = true;
                }
            }
        }
        this.mRecycler.m2356a(i, i2);
        requestLayout();
    }

    void offsetPositionRecordsForInsert(int i, int i2) {
        int c = this.mChildHelper.m2564c();
        for (int i3 = 0; i3 < c; i3++) {
            C0718x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2567d(i3));
            if (!(childViewHolderInt == null || childViewHolderInt.shouldIgnore() || childViewHolderInt.mPosition < i)) {
                childViewHolderInt.offsetPosition(i2, false);
                this.mState.f1844e = true;
            }
        }
        this.mRecycler.m2367b(i, i2);
        requestLayout();
    }

    void offsetPositionRecordsForRemove(int i, int i2, boolean z) {
        int i3 = i + i2;
        int c = this.mChildHelper.m2564c();
        for (int i4 = 0; i4 < c; i4++) {
            C0718x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2567d(i4));
            if (!(childViewHolderInt == null || childViewHolderInt.shouldIgnore())) {
                if (childViewHolderInt.mPosition >= i3) {
                    childViewHolderInt.offsetPosition(-i2, z);
                    this.mState.f1844e = true;
                } else if (childViewHolderInt.mPosition >= i) {
                    childViewHolderInt.flagRemovedAndOffsetPosition(i - 1, -i2, z);
                    this.mState.f1844e = true;
                }
            }
        }
        this.mRecycler.m2357a(i, i2, z);
        requestLayout();
    }

    void viewRangeUpdate(int i, int i2, Object obj) {
        int c = this.mChildHelper.m2564c();
        int i3 = i + i2;
        for (int i4 = 0; i4 < c; i4++) {
            View d = this.mChildHelper.m2567d(i4);
            C0718x childViewHolderInt = getChildViewHolderInt(d);
            if (childViewHolderInt != null) {
                if (!childViewHolderInt.shouldIgnore()) {
                    if (childViewHolderInt.mPosition >= i && childViewHolderInt.mPosition < i3) {
                        childViewHolderInt.addFlags(2);
                        childViewHolderInt.addChangePayload(obj);
                        ((C0702j) d.getLayoutParams()).f1816e = true;
                    }
                }
            }
        }
        this.mRecycler.m2372c(i, i2);
    }

    boolean canReuseUpdatedViewHolder(C0718x c0718x) {
        if (this.mItemAnimator != null) {
            if (this.mItemAnimator.mo2767a(c0718x, c0718x.getUnmodifiedPayloads()) == null) {
                return null;
            }
        }
        return true;
    }

    void processDataSetCompletelyChanged(boolean z) {
        this.mDispatchItemsChangedEvent = z | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    void markKnownViewsInvalid() {
        int c = this.mChildHelper.m2564c();
        for (int i = 0; i < c; i++) {
            C0718x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2567d(i));
            if (!(childViewHolderInt == null || childViewHolderInt.shouldIgnore())) {
                childViewHolderInt.addFlags(6);
            }
        }
        markItemDecorInsetsDirty();
        this.mRecycler.m2383h();
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() != 0) {
            if (this.mLayout != null) {
                this.mLayout.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
            }
            markItemDecorInsetsDirty();
            requestLayout();
        }
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.mPreserveFocusAfterLayout = z;
    }

    public C0718x getChildViewHolder(View view) {
        Object parent = view.getParent();
        if (parent != null) {
            if (parent != this) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("View ");
                stringBuilder.append(view);
                stringBuilder.append(" is not a direct child of ");
                stringBuilder.append(this);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        return getChildViewHolderInt(view);
    }

    public View findContainingItemView(View view) {
        View parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        return parent == this ? view : null;
    }

    public C0718x findContainingViewHolder(View view) {
        view = findContainingItemView(view);
        if (view == null) {
            return null;
        }
        return getChildViewHolder(view);
    }

    static C0718x getChildViewHolderInt(View view) {
        return view == null ? null : ((C0702j) view.getLayoutParams()).f1814c;
    }

    @Deprecated
    public int getChildPosition(View view) {
        return getChildAdapterPosition(view);
    }

    public int getChildAdapterPosition(View view) {
        view = getChildViewHolderInt(view);
        return view != null ? view.getAdapterPosition() : -1;
    }

    public int getChildLayoutPosition(View view) {
        view = getChildViewHolderInt(view);
        return view != null ? view.getLayoutPosition() : -1;
    }

    public long getChildItemId(View view) {
        long j = -1;
        if (this.mAdapter != null) {
            if (this.mAdapter.hasStableIds()) {
                view = getChildViewHolderInt(view);
                if (view != null) {
                    j = view.getItemId();
                }
                return j;
            }
        }
        return -1;
    }

    @Deprecated
    public C0718x findViewHolderForPosition(int i) {
        return findViewHolderForPosition(i, false);
    }

    public C0718x findViewHolderForLayoutPosition(int i) {
        return findViewHolderForPosition(i, false);
    }

    public C0718x findViewHolderForAdapterPosition(int i) {
        C0718x c0718x = null;
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int c = this.mChildHelper.m2564c();
        for (int i2 = 0; i2 < c; i2++) {
            C0718x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2567d(i2));
            if (!(childViewHolderInt == null || childViewHolderInt.isRemoved() || getAdapterPositionFor(childViewHolderInt) != i)) {
                if (!this.mChildHelper.m2566c(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                c0718x = childViewHolderInt;
            }
        }
        return c0718x;
    }

    C0718x findViewHolderForPosition(int i, boolean z) {
        int c = this.mChildHelper.m2564c();
        C0718x c0718x = null;
        for (int i2 = 0; i2 < c; i2++) {
            C0718x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2567d(i2));
            if (!(childViewHolderInt == null || childViewHolderInt.isRemoved())) {
                if (z) {
                    if (childViewHolderInt.mPosition != i) {
                    }
                } else if (childViewHolderInt.getLayoutPosition() != i) {
                }
                if (!this.mChildHelper.m2566c(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                c0718x = childViewHolderInt;
            }
        }
        return c0718x;
    }

    public C0718x findViewHolderForItemId(long j) {
        C0718x c0718x = null;
        if (this.mAdapter != null) {
            if (this.mAdapter.hasStableIds()) {
                int c = this.mChildHelper.m2564c();
                for (int i = 0; i < c; i++) {
                    C0718x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2567d(i));
                    if (!(childViewHolderInt == null || childViewHolderInt.isRemoved() || childViewHolderInt.getItemId() != j)) {
                        if (!this.mChildHelper.m2566c(childViewHolderInt.itemView)) {
                            return childViewHolderInt;
                        }
                        c0718x = childViewHolderInt;
                    }
                }
                return c0718x;
            }
        }
        return null;
    }

    public View findChildViewUnder(float f, float f2) {
        for (int b = this.mChildHelper.m2561b() - 1; b >= 0; b--) {
            View b2 = this.mChildHelper.m2563b(b);
            float translationX = b2.getTranslationX();
            float translationY = b2.getTranslationY();
            if (f >= ((float) b2.getLeft()) + translationX && f <= ((float) b2.getRight()) + translationX && f2 >= ((float) b2.getTop()) + translationY && f2 <= ((float) b2.getBottom()) + translationY) {
                return b2;
            }
        }
        return 0.0f;
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    public void offsetChildrenVertical(int i) {
        int b = this.mChildHelper.m2561b();
        for (int i2 = 0; i2 < b; i2++) {
            this.mChildHelper.m2563b(i2).offsetTopAndBottom(i);
        }
    }

    public void offsetChildrenHorizontal(int i) {
        int b = this.mChildHelper.m2561b();
        for (int i2 = 0; i2 < b; i2++) {
            this.mChildHelper.m2563b(i2).offsetLeftAndRight(i);
        }
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        getDecoratedBoundsWithMarginsInt(view, rect);
    }

    static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        C0702j c0702j = (C0702j) view.getLayoutParams();
        Rect rect2 = c0702j.f1815d;
        rect.set((view.getLeft() - rect2.left) - c0702j.leftMargin, (view.getTop() - rect2.top) - c0702j.topMargin, (view.getRight() + rect2.right) + c0702j.rightMargin, (view.getBottom() + rect2.bottom) + c0702j.bottomMargin);
    }

    Rect getItemDecorInsetsForChild(View view) {
        C0702j c0702j = (C0702j) view.getLayoutParams();
        if (!c0702j.f1816e) {
            return c0702j.f1815d;
        }
        if (this.mState.m2398a() && (c0702j.m2327e() || c0702j.m2325c())) {
            return c0702j.f1815d;
        }
        Rect rect = c0702j.f1815d;
        rect.set(0, 0, 0, 0);
        int size = this.mItemDecorations.size();
        for (int i = 0; i < size; i++) {
            this.mTempRect.set(0, 0, 0, 0);
            ((C0698h) this.mItemDecorations.get(i)).m2321a(this.mTempRect, view, this, this.mState);
            rect.left += this.mTempRect.left;
            rect.top += this.mTempRect.top;
            rect.right += this.mTempRect.right;
            rect.bottom += this.mTempRect.bottom;
        }
        c0702j.f1816e = false;
        return rect;
    }

    void dispatchOnScrolled(int i, int i2) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        onScrolled(i, i2);
        if (this.mScrollListener != null) {
            this.mScrollListener.onScrolled(this, i, i2);
        }
        if (this.mScrollListeners != null) {
            for (scrollX = this.mScrollListeners.size() - 1; scrollX >= 0; scrollX--) {
                ((C0706n) this.mScrollListeners.get(scrollX)).onScrolled(this, i, i2);
            }
        }
        this.mDispatchScrollCounter--;
    }

    void dispatchOnScrollStateChanged(int i) {
        if (this.mLayout != null) {
            this.mLayout.onScrollStateChanged(i);
        }
        onScrollStateChanged(i);
        if (this.mScrollListener != null) {
            this.mScrollListener.onScrollStateChanged(this, i);
        }
        if (this.mScrollListeners != null) {
            for (int size = this.mScrollListeners.size() - 1; size >= 0; size--) {
                ((C0706n) this.mScrollListeners.get(size)).onScrollStateChanged(this, i);
            }
        }
    }

    public boolean hasPendingAdapterUpdates() {
        if (this.mFirstLayoutComplete && !this.mDataSetHasChangedAfterLayout) {
            if (!this.mAdapterHelper.m10618d()) {
                return false;
            }
        }
        return true;
    }

    void repositionShadowingViews() {
        int b = this.mChildHelper.m2561b();
        for (int i = 0; i < b; i++) {
            View b2 = this.mChildHelper.m2563b(i);
            C0718x childViewHolder = getChildViewHolder(b2);
            if (!(childViewHolder == null || childViewHolder.mShadowingHolder == null)) {
                View view = childViewHolder.mShadowingHolder.itemView;
                int left = b2.getLeft();
                int top = b2.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    static RecyclerView findNestedRecyclerView(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView findNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i));
            if (findNestedRecyclerView != null) {
                return findNestedRecyclerView;
            }
        }
        return null;
    }

    static void clearNestedRecyclerViewIfNotNested(C0718x c0718x) {
        if (c0718x.mNestedRecyclerView != null) {
            View view = (View) c0718x.mNestedRecyclerView.get();
            while (view != null) {
                if (view != c0718x.itemView) {
                    ViewParent parent = view.getParent();
                    view = parent instanceof View ? (View) parent : null;
                } else {
                    return;
                }
            }
            c0718x.mNestedRecyclerView = null;
        }
    }

    long getNanoTime() {
        return ALLOW_THREAD_GAP_WORK ? System.nanoTime() : 0;
    }

    void dispatchChildDetached(View view) {
        C0718x childViewHolderInt = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        if (!(this.mAdapter == null || childViewHolderInt == null)) {
            this.mAdapter.onViewDetachedFromWindow(childViewHolderInt);
        }
        if (this.mOnChildAttachStateListeners != null) {
            for (int size = this.mOnChildAttachStateListeners.size() - 1; size >= 0; size--) {
                ((C0703k) this.mOnChildAttachStateListeners.get(size)).m2330b(view);
            }
        }
    }

    void dispatchChildAttached(View view) {
        C0718x childViewHolderInt = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        if (!(this.mAdapter == null || childViewHolderInt == null)) {
            this.mAdapter.onViewAttachedToWindow(childViewHolderInt);
        }
        if (this.mOnChildAttachStateListeners != null) {
            for (int size = this.mOnChildAttachStateListeners.size() - 1; size >= 0; size--) {
                ((C0703k) this.mOnChildAttachStateListeners.get(size)).m2329a(view);
            }
        }
    }

    boolean setChildImportantForAccessibilityInternal(C0718x c0718x, int i) {
        if (isComputingLayout()) {
            c0718x.mPendingAccessibilityState = i;
            this.mPendingAccessibilityImportanceChange.add(c0718x);
            return null;
        }
        C0517s.m1688a(c0718x.itemView, i);
        return true;
    }

    void dispatchPendingImportantForAccessibilityChanges() {
        for (int size = this.mPendingAccessibilityImportanceChange.size() - 1; size >= 0; size--) {
            C0718x c0718x = (C0718x) this.mPendingAccessibilityImportanceChange.get(size);
            if (c0718x.itemView.getParent() == this) {
                if (!c0718x.shouldIgnore()) {
                    int i = c0718x.mPendingAccessibilityState;
                    if (i != -1) {
                        C0517s.m1688a(c0718x.itemView, i);
                        c0718x.mPendingAccessibilityState = -1;
                    }
                }
            }
        }
        this.mPendingAccessibilityImportanceChange.clear();
    }

    int getAdapterPositionFor(C0718x c0718x) {
        if (!c0718x.hasAnyOfTheFlags(524)) {
            if (c0718x.isBound()) {
                return this.mAdapterHelper.m10615c(c0718x.mPosition);
            }
        }
        return -1;
    }

    void initFastScroller(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            drawable = new StringBuilder();
            drawable.append("Trying to set fast scroller without both required drawables.");
            drawable.append(exceptionLabel());
            throw new IllegalArgumentException(drawable.toString());
        }
        Resources resources = getContext().getResources();
        an anVar = new an(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(C0634a.fastscroll_default_thickness), resources.getDimensionPixelSize(C0634a.fastscroll_minimum_range), resources.getDimensionPixelOffset(C0634a.fastscroll_margin));
    }

    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().m1611a(z);
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().m1612a();
    }

    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().m1622b(i);
    }

    public boolean startNestedScroll(int i, int i2) {
        return getScrollingChildHelper().m1616a(i, i2);
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().m1623c();
    }

    public void stopNestedScroll(int i) {
        getScrollingChildHelper().m1624c(i);
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().m1621b();
    }

    public boolean hasNestedScrollingParent(int i) {
        return getScrollingChildHelper().m1615a(i);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().m1617a(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return getScrollingChildHelper().m1618a(i, i2, i3, i4, iArr, i5);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().m1619a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return getScrollingChildHelper().m1620a(i, i2, iArr, iArr2, i3);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().m1614a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().m1613a(f, f2);
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.mChildDrawingOrderCallback == null) {
            return super.getChildDrawingOrder(i, i2);
        }
        return this.mChildDrawingOrderCallback.m2290a(i, i2);
    }

    private C0509l getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new C0509l(this);
        }
        return this.mScrollingChildHelper;
    }
}
