package com.facebook.react.views.scroll;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.p032h.C0415d;
import android.support.v4.view.C0517s;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.HorizontalScrollView;
import android.widget.OverScroller;
import com.facebook.imageutils.JfifUtil;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.uimanager.MeasureSpecAssertions;
import com.facebook.react.uimanager.ReactClippingViewGroup;
import com.facebook.react.uimanager.ReactClippingViewGroupHelper;
import com.facebook.react.uimanager.events.NativeGestureUtil;
import com.facebook.react.views.view.ReactViewBackgroundManager;
import expolib_v1.com.facebook.infer.annotation.Assertions;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Locale;

@TargetApi(16)
public class ReactHorizontalScrollView extends HorizontalScrollView implements ReactClippingViewGroup {
    private static Field sScrollerField = null;
    private static boolean sTriedToGetScrollerField = false;
    private boolean mActivelyScrolling;
    private Rect mClippingRect;
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

    /* renamed from: com.facebook.react.views.scroll.ReactHorizontalScrollView$1 */
    class C19861 implements Runnable {
        private boolean mSnappingToPage = null;

        C19861() {
        }

        public void run() {
            if (ReactHorizontalScrollView.this.mActivelyScrolling) {
                ReactHorizontalScrollView.this.mActivelyScrolling = false;
                C0517s.m1698a(ReactHorizontalScrollView.this, (Runnable) this, 20);
            } else if (!ReactHorizontalScrollView.this.mPagingEnabled || this.mSnappingToPage) {
                if (ReactHorizontalScrollView.this.mSendMomentumEvents) {
                    ReactScrollViewHelper.emitScrollMomentumEndEvent(ReactHorizontalScrollView.this);
                }
                ReactHorizontalScrollView.this.mPostTouchRunnable = null;
                ReactHorizontalScrollView.this.disableFpsListener();
            } else {
                this.mSnappingToPage = true;
                ReactHorizontalScrollView.this.flingAndSnap(0);
                C0517s.m1698a(ReactHorizontalScrollView.this, (Runnable) this, 20);
            }
        }
    }

    public ReactHorizontalScrollView(Context context) {
        this(context, null);
    }

    public ReactHorizontalScrollView(Context context, FpsListener fpsListener) {
        super(context);
        this.mOnScrollDispatchHelper = new OnScrollDispatchHelper();
        this.mVelocityHelper = new VelocityHelper();
        this.mRect = new Rect();
        this.mPagingEnabled = false;
        this.mScrollEnabled = true;
        this.mFpsListener = null;
        this.mEndFillColor = 0;
        this.mSnapInterval = 0;
        this.mDecelerationRate = 0.985f;
        this.mReactBackgroundManager = new ReactViewBackgroundManager(this);
        this.mFpsListener = fpsListener;
        this.mScroller = getOverScrollerFromParent();
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
        r1 = android.widget.HorizontalScrollView.class;	 Catch:{ NoSuchFieldException -> 0x0017 }
        r2 = "mScroller";	 Catch:{ NoSuchFieldException -> 0x0017 }
        r1 = r1.getDeclaredField(r2);	 Catch:{ NoSuchFieldException -> 0x0017 }
        sScrollerField = r1;	 Catch:{ NoSuchFieldException -> 0x0017 }
        r1 = sScrollerField;	 Catch:{ NoSuchFieldException -> 0x0017 }
        r1.setAccessible(r0);	 Catch:{ NoSuchFieldException -> 0x0017 }
        goto L_0x001e;
    L_0x0017:
        r0 = "ReactNative";
        r1 = "Failed to get mScroller field for HorizontalScrollView! This app will exhibit the bounce-back scrolling bug :(";
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
        r2 = "Failed to cast mScroller field in HorizontalScrollView (probably due to OEM changes to AOSP)! This app will exhibit the bounce-back scrolling bug :(";	 Catch:{ IllegalAccessException -> 0x0039 }
        android.util.Log.w(r0, r2);	 Catch:{ IllegalAccessException -> 0x0039 }
        goto L_0x0042;
    L_0x0039:
        r0 = move-exception;
        r1 = new java.lang.RuntimeException;
        r2 = "Failed to get mScroller from HorizontalScrollView!";
        r1.<init>(r2, r0);
        throw r1;
    L_0x0042:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.scroll.ReactHorizontalScrollView.getOverScrollerFromParent():android.widget.OverScroller");
    }

    public void setScrollPerfTag(String str) {
        this.mScrollPerfTag = str;
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

    public void setSendMomentumEvents(boolean z) {
        this.mSendMomentumEvents = z;
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

    protected void onDraw(Canvas canvas) {
        getDrawingRect(this.mRect);
        canvas.clipRect(this.mRect);
        super.onDraw(canvas);
    }

    protected void onMeasure(int i, int i2) {
        MeasureSpecAssertions.assertExplicitMeasureSpec(i, i2);
        setMeasuredDimension(MeasureSpec.getSize(i), MeasureSpec.getSize(i2));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        scrollTo(getScrollX(), getScrollY());
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

    public void fling(int i) {
        if (this.mPagingEnabled) {
            flingAndSnap(i);
        } else if (this.mScroller != null) {
            int i2 = i;
            this.mScroller.fling(getScrollX(), getScrollY(), i2, 0, 0, Integer.MAX_VALUE, 0, 0, ((getWidth() - getPaddingStart()) - getPaddingEnd()) / 2, 0);
            C0517s.m1706c(this);
        } else {
            super.fling(i);
        }
        handlePostTouchScrolling(i, 0);
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

    private int getSnapInterval() {
        if (this.mSnapInterval != 0) {
            return this.mSnapInterval;
        }
        return getWidth();
    }

    public void setEndFillColor(int i) {
        if (i != this.mEndFillColor) {
            this.mEndFillColor = i;
            this.mEndBackground = new ColorDrawable(this.mEndFillColor);
        }
    }

    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        if (!(this.mScroller == null || this.mScroller.isFinished() || this.mScroller.getCurrX() == this.mScroller.getFinalX())) {
            int computeHorizontalScrollRange = computeHorizontalScrollRange() - getWidth();
            if (i >= computeHorizontalScrollRange) {
                this.mScroller.abortAnimation();
                i = computeHorizontalScrollRange;
            }
        }
        super.onOverScrolled(i, i2, z, z2);
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

    public void draw(Canvas canvas) {
        if (this.mEndFillColor != 0) {
            View childAt = getChildAt(0);
            if (!(this.mEndBackground == null || childAt == null || childAt.getRight() >= getWidth())) {
                this.mEndBackground.setBounds(childAt.getRight(), 0, getWidth(), getHeight());
                this.mEndBackground.draw(canvas);
            }
        }
        super.draw(canvas);
    }

    private void handlePostTouchScrolling(int i, int i2) {
        if ((this.mSendMomentumEvents || this.mPagingEnabled || isScrollPerfLoggingEnabled()) && this.mPostTouchRunnable == null) {
            if (this.mSendMomentumEvents) {
                ReactScrollViewHelper.emitScrollMomentumBeginEvent(this, i, i2);
            }
            this.mActivelyScrolling = false;
            this.mPostTouchRunnable = new C19861();
            C0517s.m1698a((View) this, this.mPostTouchRunnable, 20);
        }
    }

    private int predictFinalScrollPosition(int i) {
        OverScroller overScroller = new OverScroller(getContext());
        overScroller.setFriction(1.0f - this.mDecelerationRate);
        int width = ((getWidth() - getPaddingStart()) - getPaddingEnd()) / 2;
        OverScroller overScroller2 = overScroller;
        overScroller2.fling(getScrollX(), getScrollY(), i, 0, 0, Math.max(0, computeHorizontalScrollRange() - getWidth()), 0, 0, width, 0);
        return overScroller.getFinalX();
    }

    private void smoothScrollAndSnap(int i) {
        double snapInterval = (double) getSnapInterval();
        double scrollX = (double) getScrollX();
        double d = scrollX / snapInterval;
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
        if (d2 != scrollX) {
            this.mActivelyScrolling = true;
            smoothScrollTo((int) d2, getScrollY());
        }
    }

    private void flingAndSnap(int i) {
        ReactHorizontalScrollView reactHorizontalScrollView = this;
        if (getChildCount() > 0) {
            if (reactHorizontalScrollView.mSnapInterval == 0 && reactHorizontalScrollView.mSnapOffsets == null) {
                smoothScrollAndSnap(i);
                return;
            }
            int i2;
            int i3;
            int i4;
            int intValue;
            int max = Math.max(0, computeHorizontalScrollRange() - getWidth());
            int predictFinalScrollPosition = predictFinalScrollPosition(i);
            int width = (getWidth() - getPaddingStart()) - getPaddingEnd();
            Object obj = C0415d.m1221a(Locale.getDefault()) == 1 ? 1 : null;
            if (obj != null) {
                predictFinalScrollPosition = max - predictFinalScrollPosition;
                i2 = -i;
            } else {
                i2 = i;
            }
            if (reactHorizontalScrollView.mSnapOffsets != null) {
                i3 = max;
                i4 = 0;
                for (int i5 = 0; i5 < reactHorizontalScrollView.mSnapOffsets.size(); i5++) {
                    intValue = ((Integer) reactHorizontalScrollView.mSnapOffsets.get(i5)).intValue();
                    if (intValue <= predictFinalScrollPosition && predictFinalScrollPosition - intValue < predictFinalScrollPosition - r9) {
                        i4 = intValue;
                    }
                    if (intValue >= predictFinalScrollPosition && intValue - predictFinalScrollPosition < r10 - predictFinalScrollPosition) {
                        i3 = intValue;
                    }
                }
            } else {
                double snapInterval = (double) getSnapInterval();
                double d = ((double) predictFinalScrollPosition) / snapInterval;
                int floor = (int) (Math.floor(d) * snapInterval);
                i3 = (int) (Math.ceil(d) * snapInterval);
                i4 = floor;
            }
            predictFinalScrollPosition = predictFinalScrollPosition - i4 < i3 - predictFinalScrollPosition ? i4 : i3;
            if (i2 > 0) {
                predictFinalScrollPosition = i3;
            } else if (i2 < 0) {
                predictFinalScrollPosition = i4;
            }
            predictFinalScrollPosition = Math.min(Math.max(0, predictFinalScrollPosition), max);
            if (obj != null) {
                predictFinalScrollPosition = max - predictFinalScrollPosition;
                i2 = -i2;
            }
            int i6 = predictFinalScrollPosition;
            if (reactHorizontalScrollView.mScroller != null) {
                int i7;
                reactHorizontalScrollView.mActivelyScrolling = true;
                OverScroller overScroller = reactHorizontalScrollView.mScroller;
                i4 = getScrollX();
                i3 = getScrollY();
                if (i2 == 0) {
                    i2 = i6 - getScrollX();
                }
                intValue = i2;
                if (i6 != 0) {
                    if (i6 != max) {
                        i7 = 0;
                        overScroller.fling(i4, i3, intValue, 0, i6, i6, 0, 0, i7, 0);
                        postInvalidateOnAnimation();
                    }
                }
                i7 = width / 2;
                overScroller.fling(i4, i3, intValue, 0, i6, i6, 0, 0, i7, 0);
                postInvalidateOnAnimation();
            } else {
                smoothScrollTo(i6, getScrollY());
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
