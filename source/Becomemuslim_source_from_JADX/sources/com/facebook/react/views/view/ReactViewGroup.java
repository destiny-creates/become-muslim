package com.facebook.react.views.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.touch.OnInterceptTouchEventListener;
import com.facebook.react.touch.ReactHitSlopView;
import com.facebook.react.touch.ReactInterceptingViewGroup;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.MeasureSpecAssertions;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactClippingViewGroup;
import com.facebook.react.uimanager.ReactClippingViewGroupHelper;
import com.facebook.react.uimanager.ReactPointerEventsView;
import com.facebook.react.uimanager.ReactZIndexedViewGroup;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.RootViewUtil;
import com.facebook.react.uimanager.ViewGroupDrawingOrderHelper;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.view.ReactViewBackgroundDrawable.BorderRadiusLocation;
import com.facebook.yoga.YogaConstants;
import expolib_v1.com.facebook.infer.annotation.Assertions;
import java.util.ArrayList;
import java.util.List;

public class ReactViewGroup extends ViewGroup implements ReactHitSlopView, ReactInterceptingViewGroup, ReactClippingViewGroup, ReactPointerEventsView, ReactZIndexedViewGroup {
    private static final int ARRAY_CAPACITY_INCREMENT = 12;
    private static final int DEFAULT_BACKGROUND_COLOR = 0;
    private static final LayoutParams sDefaultLayoutParam = new LayoutParams(0, 0);
    private static final Rect sHelperRect = new Rect();
    private View[] mAllChildren = null;
    private int mAllChildrenCount;
    private ChildrenLayoutChangeListener mChildrenLayoutChangeListener;
    private Rect mClippingRect;
    private final ViewGroupDrawingOrderHelper mDrawingOrderHelper;
    private Rect mHitSlopRect;
    private int mLayoutDirection;
    private boolean mNeedsOffscreenAlphaCompositing = false;
    private OnInterceptTouchEventListener mOnInterceptTouchEventListener;
    private String mOverflow;
    private Path mPath;
    private PointerEvents mPointerEvents = PointerEvents.AUTO;
    private ReactViewBackgroundDrawable mReactBackgroundDrawable;
    private boolean mRemoveClippedSubviews = false;
    private List<View> mTransitioningViews;

    private static final class ChildrenLayoutChangeListener implements OnLayoutChangeListener {
        private final ReactViewGroup mParent;

        private ChildrenLayoutChangeListener(ReactViewGroup reactViewGroup) {
            this.mParent = reactViewGroup;
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (this.mParent.getRemoveClippedSubviews() != 0) {
                this.mParent.updateSubviewClipStatus(view);
            }
        }
    }

    protected void dispatchSetPressed(boolean z) {
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public void requestLayout() {
    }

    public ReactViewGroup(Context context) {
        super(context);
        if (!ViewProps.sDefaultOverflowHidden) {
            setClipChildren(false);
        }
        this.mDrawingOrderHelper = new ViewGroupDrawingOrderHelper(this);
    }

    protected void onMeasure(int i, int i2) {
        MeasureSpecAssertions.assertExplicitMeasureSpec(i, i2);
        setMeasuredDimension(MeasureSpec.getSize(i), MeasureSpec.getSize(i2));
    }

    public void onRtlPropertiesChanged(int i) {
        if (VERSION.SDK_INT >= 17 && this.mReactBackgroundDrawable != 0) {
            this.mReactBackgroundDrawable.setResolvedLayoutDirection(this.mLayoutDirection);
        }
    }

    public void setBackgroundColor(int i) {
        if (i != 0 || this.mReactBackgroundDrawable != null) {
            getOrCreateReactViewBackground().setColor(i);
        }
    }

    public void setBackground(Drawable drawable) {
        throw new UnsupportedOperationException("This method is not supported for ReactViewGroup instances");
    }

    public void setTranslucentBackgroundDrawable(Drawable drawable) {
        updateBackgroundDrawable(null);
        if (this.mReactBackgroundDrawable != null && drawable != null) {
            updateBackgroundDrawable(new LayerDrawable(new Drawable[]{this.mReactBackgroundDrawable, drawable}));
        } else if (drawable != null) {
            updateBackgroundDrawable(drawable);
        }
    }

    public void setOnInterceptTouchEventListener(OnInterceptTouchEventListener onInterceptTouchEventListener) {
        this.mOnInterceptTouchEventListener = onInterceptTouchEventListener;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if ((this.mOnInterceptTouchEventListener == null || !this.mOnInterceptTouchEventListener.onInterceptTouchEvent(this, motionEvent)) && this.mPointerEvents != PointerEvents.NONE) {
            if (this.mPointerEvents != PointerEvents.BOX_ONLY) {
                return super.onInterceptTouchEvent(motionEvent);
            }
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mPointerEvents != PointerEvents.NONE) {
            if (this.mPointerEvents != PointerEvents.BOX_NONE) {
                return true;
            }
        }
        return null;
    }

    public boolean hasOverlappingRendering() {
        return this.mNeedsOffscreenAlphaCompositing;
    }

    public void setNeedsOffscreenAlphaCompositing(boolean z) {
        this.mNeedsOffscreenAlphaCompositing = z;
    }

    public void setBorderWidth(int i, float f) {
        getOrCreateReactViewBackground().setBorderWidth(i, f);
    }

    public void setBorderColor(int i, float f, float f2) {
        getOrCreateReactViewBackground().setBorderColor(i, f, f2);
    }

    public void setBorderRadius(float f) {
        ReactViewBackgroundDrawable orCreateReactViewBackground = getOrCreateReactViewBackground();
        orCreateReactViewBackground.setRadius(f);
        if (11 < VERSION.SDK_INT && VERSION.SDK_INT < 18) {
            int i = orCreateReactViewBackground.hasRoundedBorders() != null ? 1 : 2;
            if (i != getLayerType()) {
                setLayerType(i, null);
            }
        }
    }

    public void setBorderRadius(float f, int i) {
        ReactViewBackgroundDrawable orCreateReactViewBackground = getOrCreateReactViewBackground();
        orCreateReactViewBackground.setRadius(f, i);
        if (11 < VERSION.SDK_INT && VERSION.SDK_INT < 18) {
            int i2 = orCreateReactViewBackground.hasRoundedBorders() != null ? 1 : 2;
            if (i2 != getLayerType()) {
                setLayerType(i2, 0);
            }
        }
    }

    public void setBorderStyle(String str) {
        getOrCreateReactViewBackground().setBorderStyle(str);
    }

    public void setRemoveClippedSubviews(boolean z) {
        if (z != this.mRemoveClippedSubviews) {
            this.mRemoveClippedSubviews = z;
            boolean z2 = false;
            if (z) {
                this.mClippingRect = new Rect();
                ReactClippingViewGroupHelper.calculateClippingRect(this, this.mClippingRect);
                this.mAllChildrenCount = getChildCount();
                this.mAllChildren = new View[Math.max(true, this.mAllChildrenCount)];
                this.mChildrenLayoutChangeListener = new ChildrenLayoutChangeListener();
                while (z2 < this.mAllChildrenCount) {
                    z = getChildAt(z2);
                    this.mAllChildren[z2] = z;
                    z.addOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
                    z2++;
                }
                updateClippingRect();
            } else {
                Assertions.assertNotNull(this.mClippingRect);
                Assertions.assertNotNull(this.mAllChildren);
                Assertions.assertNotNull(this.mChildrenLayoutChangeListener);
                for (z = false; z < this.mAllChildrenCount; z++) {
                    this.mAllChildren[z].removeOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
                }
                getDrawingRect(this.mClippingRect);
                updateClippingToRect(this.mClippingRect);
                this.mAllChildren = null;
                this.mClippingRect = null;
                this.mAllChildrenCount = 0;
                this.mChildrenLayoutChangeListener = null;
            }
        }
    }

    public boolean getRemoveClippedSubviews() {
        return this.mRemoveClippedSubviews;
    }

    public void getClippingRect(Rect rect) {
        rect.set(this.mClippingRect);
    }

    public void updateClippingRect() {
        if (this.mRemoveClippedSubviews) {
            Assertions.assertNotNull(this.mClippingRect);
            Assertions.assertNotNull(this.mAllChildren);
            ReactClippingViewGroupHelper.calculateClippingRect(this, this.mClippingRect);
            updateClippingToRect(this.mClippingRect);
        }
    }

    private void updateClippingToRect(Rect rect) {
        Assertions.assertNotNull(this.mAllChildren);
        int i = 0;
        for (int i2 = 0; i2 < this.mAllChildrenCount; i2++) {
            updateSubviewClipStatus(rect, i2, i);
            if (!isChildInViewGroup(this.mAllChildren[i2])) {
                i++;
            }
        }
    }

    private void updateSubviewClipStatus(Rect rect, int i, int i2) {
        View view = ((View[]) Assertions.assertNotNull(this.mAllChildren))[i];
        sHelperRect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect = rect.intersects(sHelperRect.left, sHelperRect.top, sHelperRect.right, sHelperRect.bottom);
        Animation animation = view.getAnimation();
        boolean z = true;
        Object obj = (animation == null || animation.hasEnded()) ? null : 1;
        if (rect == null && view.getParent() != null && obj == null) {
            super.removeViewsInLayout(i - i2, 1);
        } else if (rect != null && view.getParent() == null) {
            super.addViewInLayout(view, i - i2, sDefaultLayoutParam, true);
            invalidate();
        } else if (rect == null) {
            z = false;
        }
        if (z && (view instanceof ReactClippingViewGroup) != null) {
            ReactClippingViewGroup reactClippingViewGroup = (ReactClippingViewGroup) view;
            if (reactClippingViewGroup.getRemoveClippedSubviews() != null) {
                reactClippingViewGroup.updateClippingRect();
            }
        }
    }

    private void updateSubviewClipStatus(View view) {
        if (this.mRemoveClippedSubviews) {
            if (getParent() != null) {
                Assertions.assertNotNull(this.mClippingRect);
                Assertions.assertNotNull(this.mAllChildren);
                sHelperRect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                if (this.mClippingRect.intersects(sHelperRect.left, sHelperRect.top, sHelperRect.right, sHelperRect.bottom) != (view.getParent() != null)) {
                    int i = 0;
                    for (int i2 = 0; i2 < this.mAllChildrenCount; i2++) {
                        if (this.mAllChildren[i2] == view) {
                            updateSubviewClipStatus(this.mClippingRect, i2, i);
                            break;
                        }
                        if (!isChildInViewGroup(this.mAllChildren[i2])) {
                            i++;
                        }
                    }
                }
            }
        }
    }

    private boolean isChildInViewGroup(View view) {
        return (view.getParent() == null || !(this.mTransitioningViews == null || this.mTransitioningViews.contains(view) == null)) ? null : true;
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

    public void addView(View view, int i, LayoutParams layoutParams) {
        this.mDrawingOrderHelper.handleAddView(view);
        setChildrenDrawingOrderEnabled(this.mDrawingOrderHelper.shouldEnableCustomDrawingOrder());
        super.addView(view, i, layoutParams);
    }

    public void removeView(View view) {
        this.mDrawingOrderHelper.handleRemoveView(view);
        setChildrenDrawingOrderEnabled(this.mDrawingOrderHelper.shouldEnableCustomDrawingOrder());
        super.removeView(view);
    }

    public void removeViewAt(int i) {
        this.mDrawingOrderHelper.handleRemoveView(getChildAt(i));
        setChildrenDrawingOrderEnabled(this.mDrawingOrderHelper.shouldEnableCustomDrawingOrder());
        super.removeViewAt(i);
    }

    protected int getChildDrawingOrder(int i, int i2) {
        return this.mDrawingOrderHelper.getChildDrawingOrder(i, i2);
    }

    public int getZIndexMappedChildIndex(int i) {
        return this.mDrawingOrderHelper.shouldEnableCustomDrawingOrder() ? this.mDrawingOrderHelper.getChildDrawingOrder(getChildCount(), i) : i;
    }

    public void updateDrawingOrder() {
        this.mDrawingOrderHelper.update();
        setChildrenDrawingOrderEnabled(this.mDrawingOrderHelper.shouldEnableCustomDrawingOrder());
        invalidate();
    }

    public PointerEvents getPointerEvents() {
        return this.mPointerEvents;
    }

    void setPointerEvents(PointerEvents pointerEvents) {
        this.mPointerEvents = pointerEvents;
    }

    int getAllChildrenCount() {
        return this.mAllChildrenCount;
    }

    View getChildAtWithSubviewClippingEnabled(int i) {
        return ((View[]) Assertions.assertNotNull(this.mAllChildren))[i];
    }

    void addViewWithSubviewClippingEnabled(View view, int i) {
        addViewWithSubviewClippingEnabled(view, i, sDefaultLayoutParam);
    }

    void addViewWithSubviewClippingEnabled(View view, int i, LayoutParams layoutParams) {
        Assertions.assertCondition(this.mRemoveClippedSubviews);
        Assertions.assertNotNull(this.mClippingRect);
        Assertions.assertNotNull(this.mAllChildren);
        addInArray(view, i);
        int i2 = 0;
        for (layoutParams = null; layoutParams < i; layoutParams++) {
            if (!isChildInViewGroup(this.mAllChildren[layoutParams])) {
                i2++;
            }
        }
        updateSubviewClipStatus(this.mClippingRect, i, i2);
        view.addOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
    }

    void removeViewWithSubviewClippingEnabled(View view) {
        Assertions.assertCondition(this.mRemoveClippedSubviews);
        Assertions.assertNotNull(this.mClippingRect);
        Assertions.assertNotNull(this.mAllChildren);
        view.removeOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
        view = indexOfChildInAllChildren(view);
        if (isChildInViewGroup(this.mAllChildren[view])) {
            int i = 0;
            for (int i2 = 0; i2 < view; i2++) {
                if (!isChildInViewGroup(this.mAllChildren[i2])) {
                    i++;
                }
            }
            super.removeViewsInLayout(view - i, 1);
        }
        removeFromArray(view);
    }

    void removeAllViewsWithSubviewClippingEnabled() {
        Assertions.assertCondition(this.mRemoveClippedSubviews);
        Assertions.assertNotNull(this.mAllChildren);
        for (int i = 0; i < this.mAllChildrenCount; i++) {
            this.mAllChildren[i].removeOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
        }
        removeAllViewsInLayout();
        this.mAllChildrenCount = 0;
    }

    void startViewTransitionWithSubviewClippingEnabled(View view) {
        if (this.mTransitioningViews == null) {
            this.mTransitioningViews = new ArrayList();
        }
        this.mTransitioningViews.add(view);
        startViewTransition(view);
    }

    void endViewTransitionWithSubviewClippingEnabled(View view) {
        if (this.mTransitioningViews != null) {
            this.mTransitioningViews.remove(view);
        }
        endViewTransition(view);
    }

    private int indexOfChildInAllChildren(View view) {
        int i = this.mAllChildrenCount;
        View[] viewArr = (View[]) Assertions.assertNotNull(this.mAllChildren);
        for (int i2 = 0; i2 < i; i2++) {
            if (viewArr[i2] == view) {
                return i2;
            }
        }
        return -1;
    }

    private void addInArray(View view, int i) {
        View[] viewArr = (View[]) Assertions.assertNotNull(this.mAllChildren);
        int i2 = this.mAllChildrenCount;
        int length = viewArr.length;
        if (i == i2) {
            if (length == i2) {
                this.mAllChildren = new View[(length + 12)];
                System.arraycopy(viewArr, 0, this.mAllChildren, 0, length);
                viewArr = this.mAllChildren;
            }
            i = this.mAllChildrenCount;
            this.mAllChildrenCount = i + 1;
            viewArr[i] = view;
        } else if (i < i2) {
            if (length == i2) {
                this.mAllChildren = new View[(length + 12)];
                System.arraycopy(viewArr, 0, this.mAllChildren, 0, i);
                System.arraycopy(viewArr, i, this.mAllChildren, i + 1, i2 - i);
                viewArr = this.mAllChildren;
            } else {
                System.arraycopy(viewArr, i, viewArr, i + 1, i2 - i);
            }
            viewArr[i] = view;
            this.mAllChildrenCount++;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("index=");
            stringBuilder.append(i);
            stringBuilder.append(" count=");
            stringBuilder.append(i2);
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        }
    }

    private void removeFromArray(int i) {
        View[] viewArr = (View[]) Assertions.assertNotNull(this.mAllChildren);
        int i2 = this.mAllChildrenCount;
        if (i == i2 - 1) {
            i = this.mAllChildrenCount - 1;
            this.mAllChildrenCount = i;
            viewArr[i] = null;
        } else if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException();
        } else {
            System.arraycopy(viewArr, i + 1, viewArr, i, (i2 - i) - 1);
            i = this.mAllChildrenCount - 1;
            this.mAllChildrenCount = i;
            viewArr[i] = null;
        }
    }

    @VisibleForTesting
    public int getBackgroundColor() {
        return getBackground() != null ? ((ReactViewBackgroundDrawable) getBackground()).getColor() : 0;
    }

    private ReactViewBackgroundDrawable getOrCreateReactViewBackground() {
        if (this.mReactBackgroundDrawable == null) {
            this.mReactBackgroundDrawable = new ReactViewBackgroundDrawable(getContext());
            Drawable background = getBackground();
            updateBackgroundDrawable(null);
            if (background == null) {
                updateBackgroundDrawable(this.mReactBackgroundDrawable);
            } else {
                updateBackgroundDrawable(new LayerDrawable(new Drawable[]{this.mReactBackgroundDrawable, background}));
            }
            if (VERSION.SDK_INT >= 17) {
                this.mLayoutDirection = I18nUtil.getInstance().isRTL(getContext());
                this.mReactBackgroundDrawable.setResolvedLayoutDirection(this.mLayoutDirection);
            }
        }
        return this.mReactBackgroundDrawable;
    }

    public Rect getHitSlopRect() {
        return this.mHitSlopRect;
    }

    public void setHitSlopRect(Rect rect) {
        this.mHitSlopRect = rect;
    }

    public void setOverflow(String str) {
        this.mOverflow = str;
        invalidate();
    }

    public String getOverflow() {
        return this.mOverflow;
    }

    private void updateBackgroundDrawable(Drawable drawable) {
        if (VERSION.SDK_INT >= 16) {
            super.setBackground(drawable);
        } else {
            super.setBackgroundDrawable(drawable);
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        try {
            dispatchOverflowDraw(canvas);
            super.dispatchDraw(canvas);
        } catch (Canvas canvas2) {
            RootView rootView = RootViewUtil.getRootView(this);
            if (rootView != null) {
                rootView.handleException(canvas2);
            } else if (getContext() instanceof ReactContext) {
                ((ReactContext) getContext()).handleException(new IllegalViewOperationException("StackOverflowException", this, canvas2));
            } else {
                throw canvas2;
            }
        }
    }

    private void dispatchOverflowDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        if (this.mOverflow != null) {
            String str = r0.mOverflow;
            Object obj = -1;
            int hashCode = str.hashCode();
            if (hashCode != -1217487446) {
                if (hashCode == 466743410) {
                    if (str.equals(ViewProps.VISIBLE)) {
                        obj = null;
                    }
                }
            } else if (str.equals("hidden")) {
                obj = 1;
            }
            switch (obj) {
                case null:
                    if (r0.mPath != null) {
                        r0.mPath.rewind();
                        return;
                    }
                    return;
                case 1:
                    float f;
                    float f2;
                    int i;
                    float width = (float) getWidth();
                    float height = (float) getHeight();
                    float f3 = 0.0f;
                    if (r0.mReactBackgroundDrawable != null) {
                        float fullBorderRadius;
                        float borderRadiusOrDefaultTo;
                        float borderRadiusOrDefaultTo2;
                        float borderRadiusOrDefaultTo3;
                        Object obj2;
                        float borderRadius;
                        float borderRadius2;
                        float f4;
                        float f5;
                        Path path;
                        RectF rectF;
                        float[] fArr;
                        RectF directionAwareBorderInsets = r0.mReactBackgroundDrawable.getDirectionAwareBorderInsets();
                        if (directionAwareBorderInsets.top <= 0.0f && directionAwareBorderInsets.left <= 0.0f && directionAwareBorderInsets.bottom <= 0.0f) {
                            if (directionAwareBorderInsets.right <= 0.0f) {
                                f = 0.0f;
                                f2 = 0.0f;
                                fullBorderRadius = r0.mReactBackgroundDrawable.getFullBorderRadius();
                                borderRadiusOrDefaultTo = r0.mReactBackgroundDrawable.getBorderRadiusOrDefaultTo(fullBorderRadius, BorderRadiusLocation.TOP_LEFT);
                                borderRadiusOrDefaultTo2 = r0.mReactBackgroundDrawable.getBorderRadiusOrDefaultTo(fullBorderRadius, BorderRadiusLocation.TOP_RIGHT);
                                borderRadiusOrDefaultTo3 = r0.mReactBackgroundDrawable.getBorderRadiusOrDefaultTo(fullBorderRadius, BorderRadiusLocation.BOTTOM_LEFT);
                                fullBorderRadius = r0.mReactBackgroundDrawable.getBorderRadiusOrDefaultTo(fullBorderRadius, BorderRadiusLocation.BOTTOM_RIGHT);
                                if (VERSION.SDK_INT < 17) {
                                    obj2 = r0.mLayoutDirection != 1 ? 1 : null;
                                    borderRadius = r0.mReactBackgroundDrawable.getBorderRadius(BorderRadiusLocation.TOP_START);
                                    borderRadius2 = r0.mReactBackgroundDrawable.getBorderRadius(BorderRadiusLocation.TOP_END);
                                    f3 = r0.mReactBackgroundDrawable.getBorderRadius(BorderRadiusLocation.BOTTOM_START);
                                    f4 = fullBorderRadius;
                                    fullBorderRadius = r0.mReactBackgroundDrawable.getBorderRadius(BorderRadiusLocation.BOTTOM_END);
                                    f5 = borderRadiusOrDefaultTo;
                                    if (I18nUtil.getInstance().doLeftAndRightSwapInRTL(getContext())) {
                                        borderRadiusOrDefaultTo = obj2 == null ? borderRadius2 : borderRadius;
                                        if (obj2 != null) {
                                            borderRadius2 = borderRadius;
                                        }
                                        borderRadius = obj2 == null ? fullBorderRadius : f3;
                                        if (obj2 != null) {
                                            fullBorderRadius = f3;
                                        }
                                        if (!YogaConstants.isUndefined(borderRadiusOrDefaultTo)) {
                                            borderRadiusOrDefaultTo = f5;
                                        }
                                        if (!YogaConstants.isUndefined(borderRadius2)) {
                                            borderRadiusOrDefaultTo2 = borderRadius2;
                                        }
                                        if (!YogaConstants.isUndefined(borderRadius)) {
                                            borderRadiusOrDefaultTo3 = borderRadius;
                                        }
                                        if (!YogaConstants.isUndefined(fullBorderRadius)) {
                                        }
                                        f3 = 0.0f;
                                    } else {
                                        if (YogaConstants.isUndefined(borderRadius)) {
                                            f5 = borderRadius;
                                        }
                                        if (YogaConstants.isUndefined(borderRadius2)) {
                                            borderRadius2 = borderRadiusOrDefaultTo2;
                                        }
                                        if (YogaConstants.isUndefined(f3)) {
                                            f3 = borderRadiusOrDefaultTo3;
                                        }
                                        if (YogaConstants.isUndefined(fullBorderRadius)) {
                                            f4 = fullBorderRadius;
                                        }
                                        borderRadiusOrDefaultTo = obj2 == null ? borderRadius2 : f5;
                                        borderRadiusOrDefaultTo2 = obj2 == null ? f5 : borderRadius2;
                                        borderRadiusOrDefaultTo3 = obj2 == null ? f4 : f3;
                                        fullBorderRadius = obj2 == null ? f3 : f4;
                                    }
                                    f4 = fullBorderRadius;
                                    f3 = 0.0f;
                                } else {
                                    f4 = fullBorderRadius;
                                    f5 = borderRadiusOrDefaultTo;
                                }
                                if (borderRadiusOrDefaultTo > f3 || borderRadiusOrDefaultTo2 > f3 || f4 > f3 || borderRadiusOrDefaultTo3 > f3) {
                                    if (r0.mPath == null) {
                                        r0.mPath = new Path();
                                    }
                                    r0.mPath.rewind();
                                    path = r0.mPath;
                                    rectF = new RectF(f, f2, width, height);
                                    fArr = new float[8];
                                    i = 1;
                                    fArr[1] = Math.max(borderRadiusOrDefaultTo - directionAwareBorderInsets.top, 0.0f);
                                    fArr[2] = Math.max(borderRadiusOrDefaultTo2 - directionAwareBorderInsets.right, 0.0f);
                                    fArr[3] = Math.max(borderRadiusOrDefaultTo2 - directionAwareBorderInsets.top, 0.0f);
                                    fArr[4] = Math.max(f4 - directionAwareBorderInsets.right, 0.0f);
                                    fArr[5] = Math.max(f4 - directionAwareBorderInsets.bottom, 0.0f);
                                    fArr[6] = Math.max(borderRadiusOrDefaultTo3 - directionAwareBorderInsets.left, 0.0f);
                                    fArr[7] = Math.max(borderRadiusOrDefaultTo3 - directionAwareBorderInsets.bottom, 0.0f);
                                    path.addRoundRect(rectF, fArr, Direction.CW);
                                    canvas2.clipPath(r0.mPath);
                                    if (i != 0) {
                                        canvas2.clipRect(new RectF(f, f2, width, height));
                                        return;
                                    }
                                    return;
                                }
                            }
                        }
                        f = directionAwareBorderInsets.left + 0.0f;
                        f2 = directionAwareBorderInsets.top + 0.0f;
                        width -= directionAwareBorderInsets.right;
                        height -= directionAwareBorderInsets.bottom;
                        fullBorderRadius = r0.mReactBackgroundDrawable.getFullBorderRadius();
                        borderRadiusOrDefaultTo = r0.mReactBackgroundDrawable.getBorderRadiusOrDefaultTo(fullBorderRadius, BorderRadiusLocation.TOP_LEFT);
                        borderRadiusOrDefaultTo2 = r0.mReactBackgroundDrawable.getBorderRadiusOrDefaultTo(fullBorderRadius, BorderRadiusLocation.TOP_RIGHT);
                        borderRadiusOrDefaultTo3 = r0.mReactBackgroundDrawable.getBorderRadiusOrDefaultTo(fullBorderRadius, BorderRadiusLocation.BOTTOM_LEFT);
                        fullBorderRadius = r0.mReactBackgroundDrawable.getBorderRadiusOrDefaultTo(fullBorderRadius, BorderRadiusLocation.BOTTOM_RIGHT);
                        if (VERSION.SDK_INT < 17) {
                            f4 = fullBorderRadius;
                            f5 = borderRadiusOrDefaultTo;
                        } else {
                            if (r0.mLayoutDirection != 1) {
                            }
                            borderRadius = r0.mReactBackgroundDrawable.getBorderRadius(BorderRadiusLocation.TOP_START);
                            borderRadius2 = r0.mReactBackgroundDrawable.getBorderRadius(BorderRadiusLocation.TOP_END);
                            f3 = r0.mReactBackgroundDrawable.getBorderRadius(BorderRadiusLocation.BOTTOM_START);
                            f4 = fullBorderRadius;
                            fullBorderRadius = r0.mReactBackgroundDrawable.getBorderRadius(BorderRadiusLocation.BOTTOM_END);
                            f5 = borderRadiusOrDefaultTo;
                            if (I18nUtil.getInstance().doLeftAndRightSwapInRTL(getContext())) {
                                if (obj2 == null) {
                                }
                                if (obj2 != null) {
                                    borderRadius2 = borderRadius;
                                }
                                if (obj2 == null) {
                                }
                                if (obj2 != null) {
                                    fullBorderRadius = f3;
                                }
                                if (!YogaConstants.isUndefined(borderRadiusOrDefaultTo)) {
                                    borderRadiusOrDefaultTo = f5;
                                }
                                if (YogaConstants.isUndefined(borderRadius2)) {
                                    borderRadiusOrDefaultTo2 = borderRadius2;
                                }
                                if (YogaConstants.isUndefined(borderRadius)) {
                                    borderRadiusOrDefaultTo3 = borderRadius;
                                }
                                if (YogaConstants.isUndefined(fullBorderRadius)) {
                                }
                                f3 = 0.0f;
                            } else {
                                if (YogaConstants.isUndefined(borderRadius)) {
                                    f5 = borderRadius;
                                }
                                if (YogaConstants.isUndefined(borderRadius2)) {
                                    borderRadius2 = borderRadiusOrDefaultTo2;
                                }
                                if (YogaConstants.isUndefined(f3)) {
                                    f3 = borderRadiusOrDefaultTo3;
                                }
                                if (YogaConstants.isUndefined(fullBorderRadius)) {
                                    f4 = fullBorderRadius;
                                }
                                if (obj2 == null) {
                                }
                                if (obj2 == null) {
                                }
                                if (obj2 == null) {
                                }
                                if (obj2 == null) {
                                }
                            }
                            f4 = fullBorderRadius;
                            f3 = 0.0f;
                        }
                        if (r0.mPath == null) {
                            r0.mPath = new Path();
                        }
                        r0.mPath.rewind();
                        path = r0.mPath;
                        rectF = new RectF(f, f2, width, height);
                        fArr = new float[8];
                        i = 1;
                        fArr[1] = Math.max(borderRadiusOrDefaultTo - directionAwareBorderInsets.top, 0.0f);
                        fArr[2] = Math.max(borderRadiusOrDefaultTo2 - directionAwareBorderInsets.right, 0.0f);
                        fArr[3] = Math.max(borderRadiusOrDefaultTo2 - directionAwareBorderInsets.top, 0.0f);
                        fArr[4] = Math.max(f4 - directionAwareBorderInsets.right, 0.0f);
                        fArr[5] = Math.max(f4 - directionAwareBorderInsets.bottom, 0.0f);
                        fArr[6] = Math.max(borderRadiusOrDefaultTo3 - directionAwareBorderInsets.left, 0.0f);
                        fArr[7] = Math.max(borderRadiusOrDefaultTo3 - directionAwareBorderInsets.bottom, 0.0f);
                        path.addRoundRect(rectF, fArr, Direction.CW);
                        canvas2.clipPath(r0.mPath);
                        if (i != 0) {
                            canvas2.clipRect(new RectF(f, f2, width, height));
                            return;
                        }
                        return;
                    }
                    f = 0.0f;
                    f2 = 0.0f;
                    i = 0;
                    if (i != 0) {
                        canvas2.clipRect(new RectF(f, f2, width, height));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
