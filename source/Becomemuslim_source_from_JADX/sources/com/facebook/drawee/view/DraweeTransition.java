package com.facebook.drawee.view;

import android.annotation.TargetApi;
import android.graphics.PointF;
import android.graphics.Rect;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.transition.TransitionValues;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;

@TargetApi(19)
public class DraweeTransition extends Transition {
    private static final String PROPNAME_BOUNDS = "draweeTransition:bounds";
    private final PointF mFromFocusPoint;
    private final ScaleType mFromScale;
    private final PointF mToFocusPoint;
    private final ScaleType mToScale;

    public static TransitionSet createTransitionSet(ScaleType scaleType, ScaleType scaleType2) {
        return createTransitionSet(scaleType, scaleType2, null, null);
    }

    public static TransitionSet createTransitionSet(ScaleType scaleType, ScaleType scaleType2, PointF pointF, PointF pointF2) {
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(new ChangeBounds());
        transitionSet.addTransition(new DraweeTransition(scaleType, scaleType2, pointF, pointF2));
        return transitionSet;
    }

    public DraweeTransition(ScaleType scaleType, ScaleType scaleType2, PointF pointF, PointF pointF2) {
        this.mFromScale = scaleType;
        this.mToScale = scaleType2;
        this.mFromFocusPoint = pointF;
        this.mToFocusPoint = pointF2;
    }

    public DraweeTransition(ScaleType scaleType, ScaleType scaleType2) {
        this(scaleType, scaleType2, null, null);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.animation.Animator createAnimator(android.view.ViewGroup r9, android.transition.TransitionValues r10, android.transition.TransitionValues r11) {
        /*
        r8 = this;
        r9 = 0;
        if (r10 == 0) goto L_0x0065;
    L_0x0003:
        if (r11 != 0) goto L_0x0006;
    L_0x0005:
        goto L_0x0065;
    L_0x0006:
        r0 = r10.values;
        r1 = "draweeTransition:bounds";
        r0 = r0.get(r1);
        r4 = r0;
        r4 = (android.graphics.Rect) r4;
        r11 = r11.values;
        r0 = "draweeTransition:bounds";
        r11 = r11.get(r0);
        r5 = r11;
        r5 = (android.graphics.Rect) r5;
        if (r4 == 0) goto L_0x0064;
    L_0x001e:
        if (r5 != 0) goto L_0x0021;
    L_0x0020:
        goto L_0x0064;
    L_0x0021:
        r11 = r8.mFromScale;
        r0 = r8.mToScale;
        if (r11 != r0) goto L_0x002e;
    L_0x0027:
        r11 = r8.mFromFocusPoint;
        r0 = r8.mToFocusPoint;
        if (r11 != r0) goto L_0x002e;
    L_0x002d:
        return r9;
    L_0x002e:
        r9 = r10.view;
        r9 = (com.facebook.drawee.view.GenericDraweeView) r9;
        r10 = new com.facebook.drawee.drawable.ScalingUtils$InterpolatingScaleType;
        r2 = r8.mFromScale;
        r3 = r8.mToScale;
        r6 = r8.mFromFocusPoint;
        r7 = r8.mToFocusPoint;
        r1 = r10;
        r1.<init>(r2, r3, r4, r5, r6, r7);
        r11 = r9.getHierarchy();
        r11 = (com.facebook.drawee.generic.GenericDraweeHierarchy) r11;
        r11.setActualImageScaleType(r10);
        r11 = 2;
        r11 = new float[r11];
        r11 = {0, 1065353216};
        r11 = android.animation.ValueAnimator.ofFloat(r11);
        r0 = new com.facebook.drawee.view.DraweeTransition$1;
        r0.<init>(r10);
        r11.addUpdateListener(r0);
        r10 = new com.facebook.drawee.view.DraweeTransition$2;
        r10.<init>(r9);
        r11.addListener(r10);
        return r11;
    L_0x0064:
        return r9;
    L_0x0065:
        return r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.view.DraweeTransition.createAnimator(android.view.ViewGroup, android.transition.TransitionValues, android.transition.TransitionValues):android.animation.Animator");
    }

    private void captureValues(TransitionValues transitionValues) {
        if (transitionValues.view instanceof GenericDraweeView) {
            transitionValues.values.put(PROPNAME_BOUNDS, new Rect(0, 0, transitionValues.view.getWidth(), transitionValues.view.getHeight()));
        }
    }
}
