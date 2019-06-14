package android.support.v4.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.content.C0366b;
import android.support.v4.view.C0508j;
import android.support.v4.view.C0509l;
import android.support.v4.view.C0510m;
import android.support.v4.view.C0511o;
import android.support.v4.view.C0517s;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.ListView;

/* compiled from: SwipeRefreshLayout */
/* renamed from: android.support.v4.widget.q */
public class C3244q extends ViewGroup implements C0508j, C0510m {
    private static final int ALPHA_ANIMATION_DURATION = 300;
    private static final int ANIMATE_TO_START_DURATION = 200;
    private static final int ANIMATE_TO_TRIGGER_DURATION = 200;
    private static final int CIRCLE_BG_LIGHT = -328966;
    static final int CIRCLE_DIAMETER = 40;
    static final int CIRCLE_DIAMETER_LARGE = 56;
    private static final float DECELERATE_INTERPOLATION_FACTOR = 2.0f;
    public static final int DEFAULT = 1;
    private static final int DEFAULT_CIRCLE_TARGET = 64;
    private static final float DRAG_RATE = 0.5f;
    private static final int INVALID_POINTER = -1;
    public static final int LARGE = 0;
    private static final int[] LAYOUT_ATTRS = new int[]{16842766};
    private static final String LOG_TAG = "q";
    private static final int MAX_ALPHA = 255;
    private static final float MAX_PROGRESS_ANGLE = 0.8f;
    private static final int SCALE_DOWN_DURATION = 150;
    private static final int STARTING_PROGRESS_ALPHA = 76;
    private int mActivePointerId;
    private Animation mAlphaMaxAnimation;
    private Animation mAlphaStartAnimation;
    private final Animation mAnimateToCorrectPosition;
    private final Animation mAnimateToStartPosition;
    private C0570a mChildScrollUpCallback;
    private int mCircleDiameter;
    C0536c mCircleView;
    private int mCircleViewIndex;
    int mCurrentTargetOffsetTop;
    private final DecelerateInterpolator mDecelerateInterpolator;
    protected int mFrom;
    private float mInitialDownY;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    C0571b mListener;
    private int mMediumAnimationDuration;
    private boolean mNestedScrollInProgress;
    private final C0509l mNestedScrollingChildHelper;
    private final C0511o mNestedScrollingParentHelper;
    boolean mNotify;
    protected int mOriginalOffsetTop;
    private final int[] mParentOffsetInWindow;
    private final int[] mParentScrollConsumed;
    C0540d mProgress;
    private AnimationListener mRefreshListener;
    boolean mRefreshing;
    private boolean mReturningToStart;
    boolean mScale;
    private Animation mScaleAnimation;
    private Animation mScaleDownAnimation;
    private Animation mScaleDownToStartAnimation;
    int mSpinnerOffsetEnd;
    float mStartingScale;
    private View mTarget;
    private float mTotalDragDistance;
    private float mTotalUnconsumed;
    private int mTouchSlop;
    boolean mUsingCustomStart;

    /* compiled from: SwipeRefreshLayout */
    /* renamed from: android.support.v4.widget.q$1 */
    class C05621 implements AnimationListener {
        /* renamed from: a */
        final /* synthetic */ C3244q f1400a;

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }

        C05621(C3244q c3244q) {
            this.f1400a = c3244q;
        }

        public void onAnimationEnd(Animation animation) {
            if (this.f1400a.mRefreshing != null) {
                this.f1400a.mProgress.setAlpha(255);
                this.f1400a.mProgress.start();
                if (!(this.f1400a.mNotify == null || this.f1400a.mListener == null)) {
                    this.f1400a.mListener.onRefresh();
                }
                this.f1400a.mCurrentTargetOffsetTop = this.f1400a.mCircleView.getTop();
                return;
            }
            this.f1400a.reset();
        }
    }

    /* compiled from: SwipeRefreshLayout */
    /* renamed from: android.support.v4.widget.q$2 */
    class C05632 extends Animation {
        /* renamed from: a */
        final /* synthetic */ C3244q f1401a;

        C05632(C3244q c3244q) {
            this.f1401a = c3244q;
        }

        public void applyTransformation(float f, Transformation transformation) {
            this.f1401a.setAnimationProgress(f);
        }
    }

    /* compiled from: SwipeRefreshLayout */
    /* renamed from: android.support.v4.widget.q$3 */
    class C05643 extends Animation {
        /* renamed from: a */
        final /* synthetic */ C3244q f1402a;

        C05643(C3244q c3244q) {
            this.f1402a = c3244q;
        }

        public void applyTransformation(float f, Transformation transformation) {
            this.f1402a.setAnimationProgress(1.0f - f);
        }
    }

    /* compiled from: SwipeRefreshLayout */
    /* renamed from: android.support.v4.widget.q$5 */
    class C05665 implements AnimationListener {
        /* renamed from: a */
        final /* synthetic */ C3244q f1406a;

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }

        C05665(C3244q c3244q) {
            this.f1406a = c3244q;
        }

        public void onAnimationEnd(Animation animation) {
            if (this.f1406a.mScale == null) {
                this.f1406a.startScaleDownAnimation(null);
            }
        }
    }

    /* compiled from: SwipeRefreshLayout */
    /* renamed from: android.support.v4.widget.q$6 */
    class C05676 extends Animation {
        /* renamed from: a */
        final /* synthetic */ C3244q f1407a;

        C05676(C3244q c3244q) {
            this.f1407a = c3244q;
        }

        public void applyTransformation(float f, Transformation transformation) {
            if (this.f1407a.mUsingCustomStart == null) {
                transformation = this.f1407a.mSpinnerOffsetEnd - Math.abs(this.f1407a.mOriginalOffsetTop);
            } else {
                transformation = this.f1407a.mSpinnerOffsetEnd;
            }
            this.f1407a.setTargetOffsetTopAndBottom((this.f1407a.mFrom + ((int) (((float) (transformation - this.f1407a.mFrom)) * f))) - this.f1407a.mCircleView.getTop());
            this.f1407a.mProgress.m1853b(1.0f - f);
        }
    }

    /* compiled from: SwipeRefreshLayout */
    /* renamed from: android.support.v4.widget.q$7 */
    class C05687 extends Animation {
        /* renamed from: a */
        final /* synthetic */ C3244q f1408a;

        C05687(C3244q c3244q) {
            this.f1408a = c3244q;
        }

        public void applyTransformation(float f, Transformation transformation) {
            this.f1408a.moveToStart(f);
        }
    }

    /* compiled from: SwipeRefreshLayout */
    /* renamed from: android.support.v4.widget.q$8 */
    class C05698 extends Animation {
        /* renamed from: a */
        final /* synthetic */ C3244q f1409a;

        C05698(C3244q c3244q) {
            this.f1409a = c3244q;
        }

        public void applyTransformation(float f, Transformation transformation) {
            this.f1409a.setAnimationProgress(this.f1409a.mStartingScale + ((-this.f1409a.mStartingScale) * f));
            this.f1409a.moveToStart(f);
        }
    }

    /* compiled from: SwipeRefreshLayout */
    /* renamed from: android.support.v4.widget.q$a */
    public interface C0570a {
        /* renamed from: a */
        boolean m1898a(C3244q c3244q, View view);
    }

    /* compiled from: SwipeRefreshLayout */
    /* renamed from: android.support.v4.widget.q$b */
    public interface C0571b {
        void onRefresh();
    }

    void reset() {
        this.mCircleView.clearAnimation();
        this.mProgress.stop();
        this.mCircleView.setVisibility(8);
        setColorViewAlpha(255);
        if (this.mScale) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCurrentTargetOffsetTop);
        }
        this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (!z) {
            reset();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void setColorViewAlpha(int i) {
        this.mCircleView.getBackground().setAlpha(i);
        this.mProgress.setAlpha(i);
    }

    public void setProgressViewOffset(boolean z, int i, int i2) {
        this.mScale = z;
        this.mOriginalOffsetTop = i;
        this.mSpinnerOffsetEnd = i2;
        this.mUsingCustomStart = true;
        reset();
        this.mRefreshing = false;
    }

    public int getProgressViewStartOffset() {
        return this.mOriginalOffsetTop;
    }

    public int getProgressViewEndOffset() {
        return this.mSpinnerOffsetEnd;
    }

    public void setProgressViewEndTarget(boolean z, int i) {
        this.mSpinnerOffsetEnd = i;
        this.mScale = z;
        this.mCircleView.invalidate();
    }

    public void setSize(int i) {
        if (i == 0 || i == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i == 0) {
                this.mCircleDiameter = (int) (displayMetrics.density * 56.0f);
            } else {
                this.mCircleDiameter = (int) (displayMetrics.density * 40.0f);
            }
            this.mCircleView.setImageDrawable(null);
            this.mProgress.m1850a(i);
            this.mCircleView.setImageDrawable(this.mProgress);
        }
    }

    public C3244q(Context context) {
        this(context, null);
    }

    public C3244q(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRefreshing = false;
        this.mTotalDragDistance = -1.0f;
        this.mParentScrollConsumed = new int[2];
        this.mParentOffsetInWindow = new int[2];
        this.mActivePointerId = -1;
        this.mCircleViewIndex = -1;
        this.mRefreshListener = new C05621(this);
        this.mAnimateToCorrectPosition = new C05676(this);
        this.mAnimateToStartPosition = new C05687(this);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mMediumAnimationDuration = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.mDecelerateInterpolator = new DecelerateInterpolator(DECELERATE_INTERPOLATION_FACTOR);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.mCircleDiameter = (int) (displayMetrics.density * 40.0f);
        createProgressView();
        setChildrenDrawingOrderEnabled(true);
        this.mSpinnerOffsetEnd = (int) (displayMetrics.density * 64.0f);
        this.mTotalDragDistance = (float) this.mSpinnerOffsetEnd;
        this.mNestedScrollingParentHelper = new C0511o(this);
        this.mNestedScrollingChildHelper = new C0509l(this);
        setNestedScrollingEnabled(true);
        int i = -this.mCircleDiameter;
        this.mCurrentTargetOffsetTop = i;
        this.mOriginalOffsetTop = i;
        moveToStart(1.0f);
        context = context.obtainStyledAttributes(attributeSet, LAYOUT_ATTRS);
        setEnabled(context.getBoolean(0, true));
        context.recycle();
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.mCircleViewIndex < 0) {
            return i2;
        }
        if (i2 == i - 1) {
            return this.mCircleViewIndex;
        }
        return i2 >= this.mCircleViewIndex ? i2 + 1 : i2;
    }

    private void createProgressView() {
        this.mCircleView = new C0536c(getContext(), CIRCLE_BG_LIGHT);
        this.mProgress = new C0540d(getContext());
        this.mProgress.m1850a(1);
        this.mCircleView.setImageDrawable(this.mProgress);
        this.mCircleView.setVisibility(8);
        addView(this.mCircleView);
    }

    public void setOnRefreshListener(C0571b c0571b) {
        this.mListener = c0571b;
    }

    public void setRefreshing(boolean z) {
        if (!z || this.mRefreshing == z) {
            setRefreshing(z, false);
            return;
        }
        this.mRefreshing = z;
        if (this.mUsingCustomStart) {
            z = this.mSpinnerOffsetEnd;
        } else {
            z = this.mSpinnerOffsetEnd + this.mOriginalOffsetTop;
        }
        setTargetOffsetTopAndBottom(z - this.mCurrentTargetOffsetTop);
        this.mNotify = false;
        startScaleUpAnimation(this.mRefreshListener);
    }

    private void startScaleUpAnimation(AnimationListener animationListener) {
        this.mCircleView.setVisibility(0);
        this.mProgress.setAlpha(255);
        this.mScaleAnimation = new C05632(this);
        this.mScaleAnimation.setDuration((long) this.mMediumAnimationDuration);
        if (animationListener != null) {
            this.mCircleView.m1807a(animationListener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleAnimation);
    }

    void setAnimationProgress(float f) {
        this.mCircleView.setScaleX(f);
        this.mCircleView.setScaleY(f);
    }

    private void setRefreshing(boolean z, boolean z2) {
        if (this.mRefreshing != z) {
            this.mNotify = z2;
            ensureTarget();
            this.mRefreshing = z;
            if (this.mRefreshing) {
                animateOffsetToCorrectPosition(this.mCurrentTargetOffsetTop, this.mRefreshListener);
            } else {
                startScaleDownAnimation(this.mRefreshListener);
            }
        }
    }

    void startScaleDownAnimation(AnimationListener animationListener) {
        this.mScaleDownAnimation = new C05643(this);
        this.mScaleDownAnimation.setDuration(150);
        this.mCircleView.m1807a(animationListener);
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleDownAnimation);
    }

    private void startProgressAlphaStartAnimation() {
        this.mAlphaStartAnimation = startAlphaAnimation(this.mProgress.getAlpha(), 76);
    }

    private void startProgressAlphaMaxAnimation() {
        this.mAlphaMaxAnimation = startAlphaAnimation(this.mProgress.getAlpha(), 255);
    }

    private Animation startAlphaAnimation(final int i, final int i2) {
        Animation c05654 = new Animation(this) {
            /* renamed from: c */
            final /* synthetic */ C3244q f1405c;

            public void applyTransformation(float f, Transformation transformation) {
                this.f1405c.mProgress.setAlpha((int) (((float) i) + (((float) (i2 - i)) * f)));
            }
        };
        c05654.setDuration(300);
        this.mCircleView.m1807a(0);
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(c05654);
        return c05654;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i) {
        setProgressBackgroundColorSchemeResource(i);
    }

    public void setProgressBackgroundColorSchemeResource(int i) {
        setProgressBackgroundColorSchemeColor(C0366b.m1112c(getContext(), i));
    }

    public void setProgressBackgroundColorSchemeColor(int i) {
        this.mCircleView.setBackgroundColor(i);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = C0366b.m1112c(context, iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setColorSchemeColors(int... iArr) {
        ensureTarget();
        this.mProgress.m1852a(iArr);
    }

    public boolean isRefreshing() {
        return this.mRefreshing;
    }

    private void ensureTarget() {
        if (this.mTarget == null) {
            int i = 0;
            while (i < getChildCount()) {
                View childAt = getChildAt(i);
                if (childAt.equals(this.mCircleView)) {
                    i++;
                } else {
                    this.mTarget = childAt;
                    return;
                }
            }
        }
    }

    public void setDistanceToTriggerSync(int i) {
        this.mTotalDragDistance = (float) i;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        z = getMeasuredWidth();
        i = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.mTarget == 0) {
                ensureTarget();
            }
            if (this.mTarget != 0) {
                i2 = this.mTarget;
                i3 = getPaddingLeft();
                i4 = getPaddingTop();
                i2.layout(i3, i4, ((z - getPaddingLeft()) - getPaddingRight()) + i3, ((i - getPaddingTop()) - getPaddingBottom()) + i4);
                i = this.mCircleView.getMeasuredWidth();
                z /= 2;
                i /= 2;
                this.mCircleView.layout(z - i, this.mCurrentTargetOffsetTop, z + i, this.mCurrentTargetOffsetTop + this.mCircleView.getMeasuredHeight());
            }
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mTarget == 0) {
            ensureTarget();
        }
        if (this.mTarget != 0) {
            this.mTarget.measure(MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.mCircleView.measure(MeasureSpec.makeMeasureSpec(this.mCircleDiameter, 1073741824), MeasureSpec.makeMeasureSpec(this.mCircleDiameter, 1073741824));
            this.mCircleViewIndex = -1;
            for (i = 0; i < getChildCount(); i++) {
                if (getChildAt(i) == this.mCircleView) {
                    this.mCircleViewIndex = i;
                    break;
                }
            }
        }
    }

    public int getProgressCircleDiameter() {
        return this.mCircleDiameter;
    }

    public boolean canChildScrollUp() {
        if (this.mChildScrollUpCallback != null) {
            return this.mChildScrollUpCallback.m1898a(this, this.mTarget);
        }
        if (this.mTarget instanceof ListView) {
            return C0558m.m1890b((ListView) this.mTarget, -1);
        }
        return this.mTarget.canScrollVertically(-1);
    }

    public void setOnChildScrollUpCallback(C0570a c0570a) {
        this.mChildScrollUpCallback = c0570a;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ensureTarget();
        int actionMasked = motionEvent.getActionMasked();
        if (this.mReturningToStart && actionMasked == 0) {
            this.mReturningToStart = false;
        }
        if (!(!isEnabled() || this.mReturningToStart || canChildScrollUp() || this.mRefreshing)) {
            if (!this.mNestedScrollInProgress) {
                if (actionMasked != 6) {
                    switch (actionMasked) {
                        case 0:
                            setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCircleView.getTop());
                            this.mActivePointerId = motionEvent.getPointerId(0);
                            this.mIsBeingDragged = false;
                            actionMasked = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (actionMasked >= 0) {
                                this.mInitialDownY = motionEvent.getY(actionMasked);
                                break;
                            }
                            return false;
                        case 1:
                        case 3:
                            this.mIsBeingDragged = false;
                            this.mActivePointerId = -1;
                            break;
                        case 2:
                            if (this.mActivePointerId != -1) {
                                actionMasked = motionEvent.findPointerIndex(this.mActivePointerId);
                                if (actionMasked >= 0) {
                                    startDragging(motionEvent.getY(actionMasked));
                                    break;
                                }
                                return false;
                            }
                            Log.e(LOG_TAG, "Got ACTION_MOVE event but don't have an active pointer id.");
                            return false;
                        default:
                            break;
                    }
                }
                onSecondaryPointerUp(motionEvent);
                return this.mIsBeingDragged;
            }
        }
        return false;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (VERSION.SDK_INT < 21 && (this.mTarget instanceof AbsListView)) {
            return;
        }
        if (this.mTarget == null || C0517s.m1727u(this.mTarget)) {
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (isEnabled() == null || this.mReturningToStart != null || this.mRefreshing != null || (i & 2) == null) ? null : true;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.mNestedScrollingParentHelper.m1628a(view, view2, i);
        startNestedScroll(i & 2);
        this.mTotalUnconsumed = null;
        this.mNestedScrollInProgress = true;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0 && this.mTotalUnconsumed > 0.0f) {
            float f = (float) i2;
            if (f > this.mTotalUnconsumed) {
                iArr[1] = i2 - ((int) this.mTotalUnconsumed);
                this.mTotalUnconsumed = 0.0f;
            } else {
                this.mTotalUnconsumed -= f;
                iArr[1] = i2;
            }
            moveSpinner(this.mTotalUnconsumed);
        }
        if (this.mUsingCustomStart && i2 > 0 && this.mTotalUnconsumed == 0.0f && Math.abs(i2 - iArr[1]) > null) {
            this.mCircleView.setVisibility(8);
        }
        view = this.mParentScrollConsumed;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], view, null) != 0) {
            iArr[0] = iArr[0] + view[0];
            iArr[1] = iArr[1] + view[1];
        }
    }

    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.m1625a();
    }

    public void onStopNestedScroll(View view) {
        this.mNestedScrollingParentHelper.m1626a(view);
        this.mNestedScrollInProgress = null;
        if (this.mTotalUnconsumed > null) {
            finishSpinner(this.mTotalUnconsumed);
            this.mTotalUnconsumed = 0.0f;
        }
        stopNestedScroll();
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        dispatchNestedScroll(i, i2, i3, i4, this.mParentOffsetInWindow);
        i4 += this.mParentOffsetInWindow[1];
        if (i4 < 0 && canChildScrollUp() == null) {
            this.mTotalUnconsumed += (float) Math.abs(i4);
            moveSpinner(this.mTotalUnconsumed);
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.mNestedScrollingChildHelper.m1611a(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.mNestedScrollingChildHelper.m1612a();
    }

    public boolean startNestedScroll(int i) {
        return this.mNestedScrollingChildHelper.m1622b(i);
    }

    public void stopNestedScroll() {
        this.mNestedScrollingChildHelper.m1623c();
    }

    public boolean hasNestedScrollingParent() {
        return this.mNestedScrollingChildHelper.m1621b();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.mNestedScrollingChildHelper.m1617a(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.mNestedScrollingChildHelper.m1619a(i, i2, iArr, iArr2);
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.mNestedScrollingChildHelper.m1614a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.mNestedScrollingChildHelper.m1613a(f, f2);
    }

    private boolean isAnimationRunning(Animation animation) {
        return (animation != null && animation.hasStarted() && animation.hasEnded() == null) ? true : null;
    }

    private void moveSpinner(float f) {
        this.mProgress.m1851a(true);
        float min = Math.min(1.0f, Math.abs(f / this.mTotalDragDistance));
        float max = (((float) Math.max(((double) min) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float f2 = (float) (this.mUsingCustomStart ? this.mSpinnerOffsetEnd - this.mOriginalOffsetTop : this.mSpinnerOffsetEnd);
        double max2 = (double) (Math.max(0.0f, Math.min(Math.abs(f) - this.mTotalDragDistance, f2 * DECELERATE_INTERPOLATION_FACTOR) / f2) / 4.0f);
        float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * DECELERATE_INTERPOLATION_FACTOR;
        int i = this.mOriginalOffsetTop + ((int) ((f2 * min) + ((f2 * pow) * DECELERATE_INTERPOLATION_FACTOR)));
        if (this.mCircleView.getVisibility() != 0) {
            this.mCircleView.setVisibility(0);
        }
        if (!this.mScale) {
            this.mCircleView.setScaleX(1.0f);
            this.mCircleView.setScaleY(1.0f);
        }
        if (this.mScale) {
            setAnimationProgress(Math.min(1.0f, f / this.mTotalDragDistance));
        }
        if (f < this.mTotalDragDistance) {
            if (this.mProgress.getAlpha() > 76 && isAnimationRunning(this.mAlphaStartAnimation) == null) {
                startProgressAlphaStartAnimation();
            }
        } else if (this.mProgress.getAlpha() < 255 && isAnimationRunning(this.mAlphaMaxAnimation) == null) {
            startProgressAlphaMaxAnimation();
        }
        this.mProgress.m1849a(0.0f, Math.min(MAX_PROGRESS_ANGLE, max * MAX_PROGRESS_ANGLE));
        this.mProgress.m1853b(Math.min(1.0f, max));
        this.mProgress.m1854c((((max * 0.4f) - 16.0f) + (pow * DECELERATE_INTERPOLATION_FACTOR)) * DRAG_RATE);
        setTargetOffsetTopAndBottom(i - this.mCurrentTargetOffsetTop);
    }

    private void finishSpinner(float f) {
        if (f > this.mTotalDragDistance) {
            setRefreshing(true, true);
            return;
        }
        this.mRefreshing = false;
        this.mProgress.m1849a(0.0f, 0.0f);
        AnimationListener animationListener = null;
        if (!this.mScale) {
            animationListener = new C05665(this);
        }
        animateOffsetToStartPosition(this.mCurrentTargetOffsetTop, animationListener);
        this.mProgress.m1851a(false);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.mReturningToStart && actionMasked == 0) {
            this.mReturningToStart = false;
        }
        if (!(!isEnabled() || this.mReturningToStart || canChildScrollUp() || this.mRefreshing)) {
            if (!this.mNestedScrollInProgress) {
                switch (actionMasked) {
                    case 0:
                        this.mActivePointerId = motionEvent.getPointerId(0);
                        this.mIsBeingDragged = false;
                        break;
                    case 1:
                        actionMasked = motionEvent.findPointerIndex(this.mActivePointerId);
                        if (actionMasked < 0) {
                            Log.e(LOG_TAG, "Got ACTION_UP event but don't have an active pointer id.");
                            return false;
                        }
                        if (this.mIsBeingDragged) {
                            motionEvent = (motionEvent.getY(actionMasked) - this.mInitialMotionY) * 1056964608;
                            this.mIsBeingDragged = false;
                            finishSpinner(motionEvent);
                        }
                        this.mActivePointerId = -1;
                        return false;
                    case 2:
                        actionMasked = motionEvent.findPointerIndex(this.mActivePointerId);
                        if (actionMasked < 0) {
                            Log.e(LOG_TAG, "Got ACTION_MOVE event but have an invalid active pointer id.");
                            return false;
                        }
                        motionEvent = motionEvent.getY(actionMasked);
                        startDragging(motionEvent);
                        if (this.mIsBeingDragged) {
                            motionEvent = (motionEvent - this.mInitialMotionY) * 1056964608;
                            if (motionEvent > 0.0f) {
                                moveSpinner(motionEvent);
                                break;
                            }
                            return false;
                        }
                        break;
                    case 3:
                        return false;
                    case 5:
                        actionMasked = motionEvent.getActionIndex();
                        if (actionMasked >= 0) {
                            this.mActivePointerId = motionEvent.getPointerId(actionMasked);
                            break;
                        }
                        Log.e(LOG_TAG, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                        return false;
                    case 6:
                        onSecondaryPointerUp(motionEvent);
                        break;
                    default:
                        break;
                }
                return true;
            }
        }
        return false;
    }

    private void startDragging(float f) {
        if (f - this.mInitialDownY > ((float) this.mTouchSlop) && this.mIsBeingDragged == null) {
            this.mInitialMotionY = this.mInitialDownY + ((float) this.mTouchSlop);
            this.mIsBeingDragged = true;
            this.mProgress.setAlpha(76);
        }
    }

    private void animateOffsetToCorrectPosition(int i, AnimationListener animationListener) {
        this.mFrom = i;
        this.mAnimateToCorrectPosition.reset();
        this.mAnimateToCorrectPosition.setDuration(200);
        this.mAnimateToCorrectPosition.setInterpolator(this.mDecelerateInterpolator);
        if (animationListener != null) {
            this.mCircleView.m1807a(animationListener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mAnimateToCorrectPosition);
    }

    private void animateOffsetToStartPosition(int i, AnimationListener animationListener) {
        if (this.mScale) {
            startScaleDownReturnToStartAnimation(i, animationListener);
            return;
        }
        this.mFrom = i;
        this.mAnimateToStartPosition.reset();
        this.mAnimateToStartPosition.setDuration(200);
        this.mAnimateToStartPosition.setInterpolator(this.mDecelerateInterpolator);
        if (animationListener != null) {
            this.mCircleView.m1807a(animationListener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mAnimateToStartPosition);
    }

    void moveToStart(float f) {
        setTargetOffsetTopAndBottom((this.mFrom + ((int) (((float) (this.mOriginalOffsetTop - this.mFrom)) * f))) - this.mCircleView.getTop());
    }

    private void startScaleDownReturnToStartAnimation(int i, AnimationListener animationListener) {
        this.mFrom = i;
        this.mStartingScale = this.mCircleView.getScaleX();
        this.mScaleDownToStartAnimation = new C05698(this);
        this.mScaleDownToStartAnimation.setDuration(150);
        if (animationListener != null) {
            this.mCircleView.m1807a(animationListener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleDownToStartAnimation);
    }

    void setTargetOffsetTopAndBottom(int i) {
        this.mCircleView.bringToFront();
        C0517s.m1707c(this.mCircleView, i);
        this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            this.mActivePointerId = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }
}
