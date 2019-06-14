package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.RecyclerView.C0701i;
import android.support.v7.widget.RecyclerView.C0702j;
import android.support.v7.widget.RecyclerView.C0714t;
import android.support.v7.widget.RecyclerView.C0714t.C0712a;
import android.support.v7.widget.RecyclerView.C0714t.C0713b;
import android.support.v7.widget.RecyclerView.C0715u;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* compiled from: LinearSmoothScroller */
public class at extends C0714t {
    private static final boolean DEBUG = false;
    private static final float MILLISECONDS_PER_INCH = 25.0f;
    public static final int SNAP_TO_ANY = 0;
    public static final int SNAP_TO_END = 1;
    public static final int SNAP_TO_START = -1;
    private static final String TAG = "LinearSmoothScroller";
    private static final float TARGET_SEEK_EXTRA_SCROLL_RATIO = 1.2f;
    private static final int TARGET_SEEK_SCROLL_DISTANCE_PX = 10000;
    private final float MILLISECONDS_PER_PX;
    protected final DecelerateInterpolator mDecelerateInterpolator = new DecelerateInterpolator();
    protected int mInterimTargetDx = 0;
    protected int mInterimTargetDy = 0;
    protected final LinearInterpolator mLinearInterpolator = new LinearInterpolator();
    protected PointF mTargetVector;

    private int clampApplyScroll(int i, int i2) {
        i2 = i - i2;
        return i * i2 <= 0 ? 0 : i2;
    }

    protected void onStart() {
    }

    public at(Context context) {
        this.MILLISECONDS_PER_PX = calculateSpeedPerPixel(context.getResources().getDisplayMetrics());
    }

    protected void onTargetFound(View view, C0715u c0715u, C0712a c0712a) {
        c0715u = calculateDxToMakeVisible(view, getHorizontalSnapPreference());
        view = calculateDyToMakeVisible(view, getVerticalSnapPreference());
        int calculateTimeForDeceleration = calculateTimeForDeceleration((int) Math.sqrt((double) ((c0715u * c0715u) + (view * view))));
        if (calculateTimeForDeceleration > 0) {
            c0712a.m2392a(-c0715u, -view, calculateTimeForDeceleration, this.mDecelerateInterpolator);
        }
    }

    protected void onSeekTargetStep(int i, int i2, C0715u c0715u, C0712a c0712a) {
        if (getChildCount() == null) {
            stop();
            return;
        }
        this.mInterimTargetDx = clampApplyScroll(this.mInterimTargetDx, i);
        this.mInterimTargetDy = clampApplyScroll(this.mInterimTargetDy, i2);
        if (this.mInterimTargetDx == 0 && this.mInterimTargetDy == 0) {
            updateActionForInterimTarget(c0712a);
        }
    }

    protected void onStop() {
        this.mInterimTargetDy = 0;
        this.mInterimTargetDx = 0;
        this.mTargetVector = null;
    }

    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        return MILLISECONDS_PER_INCH / ((float) displayMetrics.densityDpi);
    }

    protected int calculateTimeForDeceleration(int i) {
        return (int) Math.ceil(((double) calculateTimeForScrolling(i)) / 0.3356d);
    }

    protected int calculateTimeForScrolling(int i) {
        return (int) Math.ceil((double) (((float) Math.abs(i)) * this.MILLISECONDS_PER_PX));
    }

    protected int getHorizontalSnapPreference() {
        if (this.mTargetVector != null) {
            if (this.mTargetVector.x != 0.0f) {
                return this.mTargetVector.x > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }

    protected int getVerticalSnapPreference() {
        if (this.mTargetVector != null) {
            if (this.mTargetVector.y != 0.0f) {
                return this.mTargetVector.y > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }

    protected void updateActionForInterimTarget(C0712a c0712a) {
        PointF computeScrollVectorForPosition = computeScrollVectorForPosition(getTargetPosition());
        if (computeScrollVectorForPosition != null) {
            if (computeScrollVectorForPosition.x != 0.0f || computeScrollVectorForPosition.y != 0.0f) {
                normalize(computeScrollVectorForPosition);
                this.mTargetVector = computeScrollVectorForPosition;
                this.mInterimTargetDx = (int) (computeScrollVectorForPosition.x * 10000.0f);
                this.mInterimTargetDy = (int) (computeScrollVectorForPosition.y * 10000.0f);
                c0712a.m2392a((int) (((float) this.mInterimTargetDx) * TARGET_SEEK_EXTRA_SCROLL_RATIO), (int) (((float) this.mInterimTargetDy) * TARGET_SEEK_EXTRA_SCROLL_RATIO), (int) (((float) calculateTimeForScrolling(TARGET_SEEK_SCROLL_DISTANCE_PX)) * TARGET_SEEK_EXTRA_SCROLL_RATIO), this.mLinearInterpolator);
                return;
            }
        }
        c0712a.m2391a(getTargetPosition());
        stop();
    }

    public int calculateDtToFit(int i, int i2, int i3, int i4, int i5) {
        switch (i5) {
            case -1:
                return i3 - i;
            case 0:
                i3 -= i;
                if (i3 > 0) {
                    return i3;
                }
                i4 -= i2;
                return i4 < 0 ? i4 : 0;
            case 1:
                return i4 - i2;
            default:
                throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
    }

    public int calculateDyToMakeVisible(View view, int i) {
        C0701i layoutManager = getLayoutManager();
        if (layoutManager != null) {
            if (layoutManager.canScrollVertically()) {
                C0702j c0702j = (C0702j) view.getLayoutParams();
                return calculateDtToFit(layoutManager.getDecoratedTop(view) - c0702j.topMargin, layoutManager.getDecoratedBottom(view) + c0702j.bottomMargin, layoutManager.getPaddingTop(), layoutManager.getHeight() - layoutManager.getPaddingBottom(), i);
            }
        }
        return null;
    }

    public int calculateDxToMakeVisible(View view, int i) {
        C0701i layoutManager = getLayoutManager();
        if (layoutManager != null) {
            if (layoutManager.canScrollHorizontally()) {
                C0702j c0702j = (C0702j) view.getLayoutParams();
                return calculateDtToFit(layoutManager.getDecoratedLeft(view) - c0702j.leftMargin, layoutManager.getDecoratedRight(view) + c0702j.rightMargin, layoutManager.getPaddingLeft(), layoutManager.getWidth() - layoutManager.getPaddingRight(), i);
            }
        }
        return null;
    }

    public PointF computeScrollVectorForPosition(int i) {
        C0701i layoutManager = getLayoutManager();
        if (layoutManager instanceof C0713b) {
            return ((C0713b) layoutManager).computeScrollVectorForPosition(i);
        }
        i = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("You should override computeScrollVectorForPosition when the LayoutManager does not implement ");
        stringBuilder.append(C0713b.class.getCanonicalName());
        Log.w(i, stringBuilder.toString());
        return 0;
    }
}
