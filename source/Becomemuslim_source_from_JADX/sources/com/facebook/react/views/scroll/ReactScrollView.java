package com.facebook.react.views.scroll;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.C0517s;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.widget.OverScroller;
import android.widget.ScrollView;
import com.facebook.imageutils.JfifUtil;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.uimanager.MeasureSpecAssertions;
import com.facebook.react.uimanager.ReactClippingViewGroup;
import com.facebook.react.uimanager.ReactClippingViewGroupHelper;
import com.facebook.react.uimanager.events.NativeGestureUtil;
import com.facebook.react.views.view.ReactViewBackgroundManager;
import expolib_v1.com.facebook.infer.annotation.Assertions;
import java.lang.reflect.Field;
import java.util.List;

@TargetApi(11)
public class ReactScrollView extends ScrollView implements OnLayoutChangeListener, OnHierarchyChangeListener, ReactClippingViewGroup {
    private static Field sScrollerField = null;
    private static boolean sTriedToGetScrollerField = false;
    private boolean mActivelyScrolling;
    private Rect mClippingRect;
    private View mContentView;
    private float mDecelerationRate;
    private boolean mDragging;
    private Drawable mEndBackground;
    private int mEndFillColor;
    private FpsListener mFpsListener;
    private final OnScrollDispatchHelper mOnScrollDispatchHelper;
    private boolean mPagingEnabled;
    private Runnable mPostTouchRunnable;
    private ReactViewBackgroundManager mReactBackgroundManager;
    private final Rect mRect;
    private boolean mRemoveClippedSubviews;
    private boolean mScrollEnabled;
    private String mScrollPerfTag;
    private final OverScroller mScroller;
    private boolean mSendMomentumEvents;
    private int mSnapInterval;
    private List<Integer> mSnapOffsets;
    private final VelocityHelper mVelocityHelper;

    /* renamed from: com.facebook.react.views.scroll.ReactScrollView$1 */
    class C19871 implements Runnable {
        private boolean mSnappingToPage = null;

        C19871() {
        }

        public void run() {
            if (ReactScrollView.this.mActivelyScrolling) {
                ReactScrollView.this.mActivelyScrolling = false;
                C0517s.m1698a(ReactScrollView.this, (Runnable) this, 20);
            } else if (!ReactScrollView.this.mPagingEnabled || this.mSnappingToPage) {
                if (ReactScrollView.this.mSendMomentumEvents) {
                    ReactScrollViewHelper.emitScrollMomentumEndEvent(ReactScrollView.this);
                }
                ReactScrollView.this.mPostTouchRunnable = null;
                ReactScrollView.this.disableFpsListener();
            } else {
                this.mSnappingToPage = true;
                ReactScrollView.this.flingAndSnap(0);
                C0517s.m1698a(ReactScrollView.this, (Runnable) this, 20);
            }
        }
    }

    public ReactScrollView(ReactContext reactContext) {
        this(reactContext, null);
    }

    public ReactScrollView(ReactContext reactContext, FpsListener fpsListener) {
        super(reactContext);
        this.mOnScrollDispatchHelper = new OnScrollDispatchHelper();
        this.mVelocityHelper = new VelocityHelper();
        this.mRect = new Rect();
        this.mPagingEnabled = false;
        this.mScrollEnabled = true;
        this.mFpsListener = null;
        this.mEndFillColor = 0;
        this.mSnapInterval = 0;
        this.mDecelerationRate = 0.985f;
        this.mFpsListener = fpsListener;
        this.mReactBackgroundManager = new ReactViewBackgroundManager(this);
        this.mScroller = getOverScrollerFromParent();
        setOnHierarchyChangeListener(this);
        setScrollBarStyle(33554432);
    }

    private android.widget.OverScroller getOverScrollerFromParent() {
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
        r3 = this;
        r0 = sTriedToGetScrollerField;
        if (r0 != 0) goto L_0x001e;
    L_0x0004:
        r0 = 1;
        sTriedToGetScrollerField = r0;
        r1 = android.widget.ScrollView.class;	 Catch:{ NoSuchFieldException -> 0x0017 }
        r2 = "mScroller";	 Catch:{ NoSuchFieldException -> 0x0017 }
        r1 = r1.getDeclaredField(r2);	 Catch:{ NoSuchFieldException -> 0x0017 }
        sScrollerField = r1;	 Catch:{ NoSuchFieldException -> 0x0017 }
        r1 = sScrollerField;	 Catch:{ NoSuchFieldException -> 0x0017 }
        r1.setAccessible(r0);	 Catch:{ NoSuchFieldException -> 0x0017 }
        goto L_0x001e;
    L_0x0017:
        r0 = "ReactNative";
        r1 = "Failed to get mScroller field for ScrollView! This app will exhibit the bounce-back scrolling bug :(";
        android.util.Log.w(r0, r1);
    L_0x001e:
        r0 = sScrollerField;
        r1 = 0;
        if (r0 == 0) goto L_0x0042;
    L_0x0023:
        r0 = sScrollerField;	 Catch:{ IllegalAccessException -> 0x0039 }
        r0 = r0.get(r3);	 Catch:{ IllegalAccessException -> 0x0039 }
        r2 = r0 instanceof android.widget.OverScroller;	 Catch:{ IllegalAccessException -> 0x0039 }
        if (r2 == 0) goto L_0x0031;	 Catch:{ IllegalAccessException -> 0x0039 }
    L_0x002d:
        r0 = (android.widget.OverScroller) r0;	 Catch:{ IllegalAccessException -> 0x0039 }
        r1 = r0;	 Catch:{ IllegalAccessException -> 0x0039 }
        goto L_0x0042;	 Catch:{ IllegalAccessException -> 0x0039 }
    L_0x0031:
        r0 = "ReactNative";	 Catch:{ IllegalAccessException -> 0x0039 }
        r2 = "Failed to cast mScroller field in ScrollView (probably due to OEM changes to AOSP)! This app will exhibit the bounce-back scrolling bug :(";	 Catch:{ IllegalAccessException -> 0x0039 }
        android.util.Log.w(r0, r2);	 Catch:{ IllegalAccessException -> 0x0039 }
        goto L_0x0042;
    L_0x0039:
        r0 = move-exception;
        r1 = new java.lang.RuntimeException;
        r2 = "Failed to get mScroller from ScrollView!";
        r1.<init>(r2, r0);
        throw r1;
    L_0x0042:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.scroll.ReactScrollView.getOverScrollerFromParent():android.widget.OverScroller");
    }

    public void setSendMomentumEvents(boolean z) {
        this.mSendMomentumEvents = z;
    }

    public void setScrollPerfTag(String str) {
        this.mScrollPerfTag = str;
    }

    public void setScrollEnabled(boolean z) {
        this.mScrollEnabled = z;
    }

    public void setPagingEnabled(boolean z) {
        this.mPagingEnabled = z;
    }

    public void setDecelerationRate(float f) {
        this.mDecelerationRate = f;
        if (this.mScroller != null) {
            this.mScroller.setFriction(1.0f - this.mDecelerationRate);
        }
    }

    public void setSnapInterval(int i) {
        this.mSnapInterval = i;
    }

    public void setSnapOffsets(List<Integer> list) {
        this.mSnapOffsets = list;
    }

    public void flashScrollIndicators() {
        awakenScrollBars();
    }

    protected void onMeasure(int i, int i2) {
        MeasureSpecAssertions.assertExplicitMeasureSpec(i, i2);
        setMeasuredDimension(MeasureSpec.getSize(i), MeasureSpec.getSize(i2));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        scrollTo(getScrollX(), getScrollY());
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.mRemoveClippedSubviews != 0) {
            updateClippingRect();
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mRemoveClippedSubviews) {
            updateClippingRect();
        }
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        this.mActivelyScrolling = true;
        if (this.mOnScrollDispatchHelper.onScrollChanged(i, i2) != 0) {
            if (this.mRemoveClippedSubviews != 0) {
                updateClippingRect();
            }
            ReactScrollViewHelper.emitScrollEvent(this, this.mOnScrollDispatchHelper.getXFlingVelocity(), this.mOnScrollDispatchHelper.getYFlingVelocity());
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.mScrollEnabled) {
            return false;
        }
        try {
            if (super.onInterceptTouchEvent(motionEvent)) {
                NativeGestureUtil.notifyNativeGestureStarted(this, motionEvent);
                ReactScrollViewHelper.emitScrollBeginDragEvent(this);
                this.mDragging = true;
                enableFpsListener();
                return true;
            }
        } catch (MotionEvent motionEvent2) {
            Log.w(ReactConstants.TAG, "Error intercepting touch event.", motionEvent2);
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mScrollEnabled) {
            return false;
        }
        this.mVelocityHelper.calculateVelocity(motionEvent);
        if ((motionEvent.getAction() & JfifUtil.MARKER_FIRST_BYTE) == 1 && this.mDragging) {
            float xVelocity = this.mVelocityHelper.getXVelocity();
            float yVelocity = this.mVelocityHelper.getYVelocity();
            ReactScrollViewHelper.emitScrollEndDragEvent(this, xVelocity, yVelocity);
            this.mDragging = false;
            handlePostTouchScrolling(Math.round(xVelocity), Math.round(yVelocity));
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setRemoveClippedSubviews(boolean z) {
        if (z && this.mClippingRect == null) {
            this.mClippingRect = new Rect();
        }
        this.mRemoveClippedSubviews = z;
        updateClippingRect();
    }

    public boolean getRemoveClippedSubviews() {
        return this.mRemoveClippedSubviews;
    }

    public void updateClippingRect() {
        if (this.mRemoveClippedSubviews) {
            Assertions.assertNotNull(this.mClippingRect);
            ReactClippingViewGroupHelper.calculateClippingRect(this, this.mClippingRect);
            View childAt = getChildAt(0);
            if (childAt instanceof ReactClippingViewGroup) {
                ((ReactClippingViewGroup) childAt).updateClippingRect();
            }
        }
    }

    public void getClippingRect(Rect rect) {
        rect.set((Rect) Assertions.assertNotNull(this.mClippingRect));
    }

    public void fling(int i) {
        i = (int) (((float) Math.abs(i)) * Math.signum(this.mOnScrollDispatchHelper.getYFlingVelocity()));
        if (this.mPagingEnabled) {
            flingAndSnap(i);
        } else if (this.mScroller != null) {
            int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
            this.mScroller.fling(getScrollX(), getScrollY(), 0, i, 0, 0, 0, Integer.MAX_VALUE, 0, height / 2);
            C0517s.m1706c(this);
        } else {
            super.fling(i);
        }
        handlePostTouchScrolling(0, i);
    }

    private void enableFpsListener() {
        if (isScrollPerfLoggingEnabled()) {
            Assertions.assertNotNull(this.mFpsListener);
            Assertions.assertNotNull(this.mScrollPerfTag);
            this.mFpsListener.enable(this.mScrollPerfTag);
        }
    }

    private void disableFpsListener() {
        if (isScrollPerfLoggingEnabled()) {
            Assertions.assertNotNull(this.mFpsListener);
            Assertions.assertNotNull(this.mScrollPerfTag);
            this.mFpsListener.disable(this.mScrollPerfTag);
        }
    }

    private boolean isScrollPerfLoggingEnabled() {
        return (this.mFpsListener == null || this.mScrollPerfTag == null || this.mScrollPerfTag.isEmpty()) ? false : true;
    }

    private int getMaxScrollY() {
        return Math.max(0, this.mContentView.getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
    }

    public void draw(Canvas canvas) {
        if (this.mEndFillColor != 0) {
            View childAt = getChildAt(0);
            if (!(this.mEndBackground == null || childAt == null || childAt.getBottom() >= getHeight())) {
                this.mEndBackground.setBounds(0, childAt.getBottom(), getWidth(), getHeight());
                this.mEndBackground.draw(canvas);
            }
        }
        getDrawingRect(this.mRect);
        canvas.clipRect(this.mRect);
        super.draw(canvas);
    }

    private void handlePostTouchScrolling(int i, int i2) {
        if ((this.mSendMomentumEvents || this.mPagingEnabled || isScrollPerfLoggingEnabled()) && this.mPostTouchRunnable == null) {
            if (this.mSendMomentumEvents) {
                enableFpsListener();
                ReactScrollViewHelper.emitScrollMomentumBeginEvent(this, i, i2);
            }
            this.mActivelyScrolling = false;
            this.mPostTouchRunnable = new C19871();
            C0517s.m1698a((View) this, this.mPostTouchRunnable, 20);
        }
    }

    private int predictFinalScrollPosition(int i) {
        OverScroller overScroller = new OverScroller(getContext());
        overScroller.setFriction(1.0f - this.mDecelerationRate);
        int height = ((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2;
        OverScroller overScroller2 = overScroller;
        overScroller2.fling(getScrollX(), getScrollY(), 0, i, 0, 0, 0, getMaxScrollY(), 0, height);
        return overScroller.getFinalY();
    }

    private void smoothScrollAndSnap(int i) {
        double snapInterval = (double) getSnapInterval();
        double scrollY = (double) getScrollY();
        double d = scrollY / snapInterval;
        int floor = (int) Math.floor(d);
        int ceil = (int) Math.ceil(d);
        int round = (int) Math.round(d);
        int round2 = (int) Math.round(((double) predictFinalScrollPosition(i)) / snapInterval);
        if (i > 0 && ceil == floor) {
            ceil++;
        } else if (i < 0 && floor == ceil) {
            floor--;
        }
        if (i > 0 && round < ceil && round2 > floor) {
            round = ceil;
        } else if (i < 0 && round > floor && round2 < ceil) {
            round = floor;
        }
        double d2 = ((double) round) * snapInterval;
        if (d2 != scrollY) {
            this.mActivelyScrolling = true;
            smoothScrollTo(getScrollX(), (int) d2);
        }
    }

    private void flingAndSnap(int i) {
        ReactScrollView reactScrollView = this;
        if (getChildCount() > 0) {
            if (reactScrollView.mSnapInterval == 0 && reactScrollView.mSnapOffsets == null) {
                smoothScrollAndSnap(i);
                return;
            }
            int i2;
            int i3;
            int intValue;
            int maxScrollY = getMaxScrollY();
            int predictFinalScrollPosition = predictFinalScrollPosition(i);
            int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
            if (reactScrollView.mSnapOffsets != null) {
                i2 = maxScrollY;
                int i4 = 0;
                for (i3 = 0; i3 < reactScrollView.mSnapOffsets.size(); i3++) {
                    intValue = ((Integer) reactScrollView.mSnapOffsets.get(i3)).intValue();
                    if (intValue <= predictFinalScrollPosition && predictFinalScrollPosition - intValue < predictFinalScrollPosition - i4) {
                        i4 = intValue;
                    }
                    if (intValue >= predictFinalScrollPosition && intValue - predictFinalScrollPosition < r8 - predictFinalScrollPosition) {
                        i2 = intValue;
                    }
                }
                i3 = i4;
            } else {
                double snapInterval = (double) getSnapInterval();
                double d = ((double) predictFinalScrollPosition) / snapInterval;
                i3 = (int) (Math.floor(d) * snapInterval);
                i2 = (int) (Math.ceil(d) * snapInterval);
            }
            predictFinalScrollPosition = predictFinalScrollPosition - i3 < i2 - predictFinalScrollPosition ? i3 : i2;
            if (i > 0) {
                predictFinalScrollPosition = i2;
            } else if (i < 0) {
                predictFinalScrollPosition = i3;
            }
            int min = Math.min(Math.max(0, predictFinalScrollPosition), maxScrollY);
            if (reactScrollView.mScroller != null) {
                int i5;
                int i6;
                reactScrollView.mActivelyScrolling = true;
                OverScroller overScroller = reactScrollView.mScroller;
                i2 = getScrollX();
                intValue = getScrollY();
                if (i != 0) {
                    i5 = i;
                } else {
                    i5 = min - getScrollY();
                }
                if (min != 0) {
                    if (min != maxScrollY) {
                        i6 = 0;
                        overScroller.fling(i2, intValue, 0, i5, 0, 0, min, min, 0, i6);
                        postInvalidateOnAnimation();
                    }
                }
                i6 = height / 2;
                overScroller.fling(i2, intValue, 0, i5, 0, 0, min, min, 0, i6);
                postInvalidateOnAnimation();
            } else {
                smoothScrollTo(getScrollX(), min);
            }
        }
    }

    private int getSnapInterval() {
        if (this.mSnapInterval != 0) {
            return this.mSnapInterval;
        }
        return getHeight();
    }

    public void setEndFillColor(int i) {
        if (i != this.mEndFillColor) {
            this.mEndFillColor = i;
            this.mEndBackground = new ColorDrawable(this.mEndFillColor);
        }
    }

    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        if (!(this.mScroller == null || this.mScroller.isFinished() || this.mScroller.getCurrY() == this.mScroller.getFinalY())) {
            int maxScrollY = getMaxScrollY();
            if (i2 >= maxScrollY) {
                this.mScroller.abortAnimation();
                i2 = maxScrollY;
            }
        }
        super.onOverScrolled(i, i2, z, z2);
    }

    public void onChildViewAdded(View view, View view2) {
        this.mContentView = view2;
        this.mContentView.addOnLayoutChangeListener(this);
    }

    public void onChildViewRemoved(View view, View view2) {
        this.mContentView.removeOnLayoutChangeListener(this);
        this.mContentView = null;
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (this.mContentView != null) {
            view = getScrollY();
            i = getMaxScrollY();
            if (view > i) {
                scrollTo(getScrollX(), i);
            }
        }
    }

    public void setBackgroundColor(int i) {
        this.mReactBackgroundManager.setBackgroundColor(i);
    }

    public void setBorderWidth(int i, float f) {
        this.mReactBackgroundManager.setBorderWidth(i, f);
    }

    public void setBorderColor(int i, float f, float f2) {
        this.mReactBackgroundManager.setBorderColor(i, f, f2);
    }

    public void setBorderRadius(float f) {
        this.mReactBackgroundManager.setBorderRadius(f);
    }

    public void setBorderRadius(float f, int i) {
        this.mReactBackgroundManager.setBorderRadius(f, i);
    }

    public void setBorderStyle(String str) {
        this.mReactBackgroundManager.setBorderStyle(str);
    }
}
