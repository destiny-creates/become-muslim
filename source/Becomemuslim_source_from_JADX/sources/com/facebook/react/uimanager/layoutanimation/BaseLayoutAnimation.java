package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.facebook.react.uimanager.IllegalViewOperationException;

abstract class BaseLayoutAnimation extends AbstractLayoutAnimation {
    abstract boolean isReverse();

    BaseLayoutAnimation() {
    }

    boolean isValid() {
        return this.mDurationMs > 0 && this.mAnimatedProperty != null;
    }

    Animation createAnimationImpl(View view, int i, int i2, int i3, int i4) {
        if (this.mAnimatedProperty != 0) {
            i3 = 0;
            switch (this.mAnimatedProperty) {
                case OPACITY:
                    i = isReverse() != 0 ? view.getAlpha() : 0;
                    if (isReverse() == 0) {
                        i3 = view.getAlpha();
                    }
                    return new OpacityAnimation(view, i, i3);
                case SCALE_XY:
                    float f = isReverse() != null ? 1.0f : 0.0f;
                    float f2 = isReverse() != null ? 0.0f : 1.0f;
                    return new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
                case SCALE_X:
                    return new ScaleAnimation(isReverse() != null ? 1.0f : 0.0f, isReverse() != null ? 0.0f : 1.0f, 1.0f, 1.0f, 1, 0.5f, 1, 0.0f);
                case SCALE_Y:
                    return new ScaleAnimation(1.0f, 1.0f, isReverse() != null ? 1.0f : 0.0f, isReverse() != null ? 0.0f : 1.0f, 1, 0.0f, 1, 0.5f);
                default:
                    i = new StringBuilder();
                    i.append("Missing animation for property : ");
                    i.append(this.mAnimatedProperty);
                    throw new IllegalViewOperationException(i.toString());
            }
        }
        throw new IllegalViewOperationException("Missing animated property from animation config");
    }
}
