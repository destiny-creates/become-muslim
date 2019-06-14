package com.facebook.react.uimanager;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.touch.ReactHitSlopView;

public class TouchTargetHelper {
    private static final float[] mEventCoords = new float[2];
    private static final Matrix mInverseMatrix = new Matrix();
    private static final float[] mMatrixTransformCoords = new float[2];
    private static final PointF mTempPoint = new PointF();

    public static int findTargetTagForTouch(float f, float f2, ViewGroup viewGroup) {
        return findTargetTagAndCoordinatesForTouch(f, f2, viewGroup, mEventCoords, null);
    }

    public static int findTargetTagForTouch(float f, float f2, ViewGroup viewGroup, int[] iArr) {
        return findTargetTagAndCoordinatesForTouch(f, f2, viewGroup, mEventCoords, iArr);
    }

    public static int findTargetTagAndCoordinatesForTouch(float f, float f2, ViewGroup viewGroup, float[] fArr, int[] iArr) {
        UiThreadUtil.assertOnUiThread();
        int id = viewGroup.getId();
        fArr[0] = f;
        fArr[1] = f2;
        f2 = findTouchTargetView(fArr, viewGroup);
        if (f2 == null) {
            return id;
        }
        f2 = findClosestReactAncestor(f2);
        if (f2 == null) {
            return id;
        }
        if (iArr != null) {
            iArr[0] = f2.getId();
        }
        return getTouchTargetForView(f2, fArr[0], fArr[1]);
    }

    private static View findClosestReactAncestor(View view) {
        while (view != null && view.getId() <= 0) {
            view = (View) view.getParent();
        }
        return view;
    }

    private static View findTouchTargetView(float[] fArr, ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        ReactZIndexedViewGroup reactZIndexedViewGroup = viewGroup instanceof ReactZIndexedViewGroup ? (ReactZIndexedViewGroup) viewGroup : null;
        childCount--;
        while (childCount >= 0) {
            View childAt = viewGroup.getChildAt(reactZIndexedViewGroup != null ? reactZIndexedViewGroup.getZIndexMappedChildIndex(childCount) : childCount);
            PointF pointF = mTempPoint;
            if (isTransformedTouchPointInView(fArr[0], fArr[1], viewGroup, childAt, pointF)) {
                float f = fArr[0];
                float f2 = fArr[1];
                fArr[0] = pointF.x;
                fArr[1] = pointF.y;
                childAt = findTouchTargetViewWithPointerEvents(fArr, childAt);
                if (childAt != null) {
                    return childAt;
                }
                fArr[0] = f;
                fArr[1] = f2;
            }
            childCount--;
        }
        return viewGroup;
    }

    private static boolean isTransformedTouchPointInView(float f, float f2, ViewGroup viewGroup, View view, PointF pointF) {
        f = (f + ((float) viewGroup.getScrollX())) - ((float) view.getLeft());
        f2 = (f2 + ((float) viewGroup.getScrollY())) - ((float) view.getTop());
        viewGroup = view.getMatrix();
        if (!viewGroup.isIdentity()) {
            float[] fArr = mMatrixTransformCoords;
            fArr[0] = f;
            fArr[1] = f2;
            f = mInverseMatrix;
            viewGroup.invert(f);
            f.mapPoints(fArr);
            f = fArr[0];
            f2 = fArr[1];
        }
        if ((view instanceof ReactHitSlopView) != null) {
            ReactHitSlopView reactHitSlopView = (ReactHitSlopView) view;
            if (reactHitSlopView.getHitSlopRect() != null) {
                viewGroup = reactHitSlopView.getHitSlopRect();
                if (f < ((float) (-viewGroup.left)) || f >= ((float) ((view.getRight() - view.getLeft()) + viewGroup.right)) || f2 < ((float) (-viewGroup.top)) || f2 >= ((float) ((view.getBottom() - view.getTop()) + viewGroup.bottom))) {
                    return false;
                }
                pointF.set(f, f2);
                return true;
            }
        }
        if (f < 0.0f || f >= ((float) (view.getRight() - view.getLeft())) || f2 < 0.0f || f2 >= ((float) (view.getBottom() - view.getTop()))) {
            return false;
        }
        pointF.set(f, f2);
        return true;
    }

    private static View findTouchTargetViewWithPointerEvents(float[] fArr, View view) {
        PointerEvents pointerEvents = view instanceof ReactPointerEventsView ? ((ReactPointerEventsView) view).getPointerEvents() : PointerEvents.AUTO;
        if (!view.isEnabled()) {
            if (pointerEvents == PointerEvents.AUTO) {
                pointerEvents = PointerEvents.BOX_NONE;
            } else if (pointerEvents == PointerEvents.BOX_ONLY) {
                pointerEvents = PointerEvents.NONE;
            }
        }
        if (pointerEvents == PointerEvents.NONE) {
            return null;
        }
        if (pointerEvents == PointerEvents.BOX_ONLY) {
            return view;
        }
        if (pointerEvents == PointerEvents.BOX_NONE) {
            if (view instanceof ViewGroup) {
                View findTouchTargetView = findTouchTargetView(fArr, (ViewGroup) view);
                if (findTouchTargetView != view) {
                    return findTouchTargetView;
                }
                if (!(view instanceof ReactCompoundView) || ((ReactCompoundView) view).reactTagForTouch(fArr[0], fArr[1]) == view.getId()) {
                    return null;
                }
                return view;
            }
            return null;
        } else if (pointerEvents == PointerEvents.AUTO) {
            return (!((view instanceof ReactCompoundViewGroup) && ((ReactCompoundViewGroup) view).interceptsTouchEvent(fArr[0], fArr[1])) && (view instanceof ViewGroup)) ? findTouchTargetView(fArr, (ViewGroup) view) : view;
        } else {
            view = new StringBuilder();
            view.append("Unknown pointer event type: ");
            view.append(pointerEvents.toString());
            throw new JSApplicationIllegalArgumentException(view.toString());
        }
    }

    private static int getTouchTargetForView(View view, float f, float f2) {
        if (view instanceof ReactCompoundView) {
            return ((ReactCompoundView) view).reactTagForTouch(f, f2);
        }
        return view.getId();
    }
}
