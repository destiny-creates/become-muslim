package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.Animation;

class LayoutUpdateAnimation extends AbstractLayoutAnimation {
    private static final boolean USE_TRANSLATE_ANIMATION = false;

    LayoutUpdateAnimation() {
    }

    boolean isValid() {
        return this.mDurationMs > 0;
    }

    Animation createAnimationImpl(View view, int i, int i2, int i3, int i4) {
        Object obj;
        Object obj2 = null;
        if (view.getX() == ((float) i)) {
            if (view.getY() == ((float) i2)) {
                obj = null;
                if (!(view.getWidth() == i3 && view.getHeight() == i4)) {
                    obj2 = 1;
                }
                if (obj == null || r2 != null) {
                    return new PositionAndSizeAnimation(view, i, i2, i3, i4);
                }
                return null;
            }
        }
        obj = 1;
        obj2 = 1;
        if (obj == null) {
        }
        return new PositionAndSizeAnimation(view, i, i2, i3, i4);
    }
}
