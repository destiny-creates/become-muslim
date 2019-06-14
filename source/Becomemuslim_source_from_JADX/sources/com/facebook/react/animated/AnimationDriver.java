package com.facebook.react.animated;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReadableMap;

abstract class AnimationDriver {
    ValueAnimatedNode mAnimatedValue;
    Callback mEndCallback;
    boolean mHasFinished = false;
    int mId;

    public abstract void runAnimationStep(long j);

    AnimationDriver() {
    }

    public void resetConfig(ReadableMap readableMap) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Animation config for ");
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append(" cannot be reset");
        throw new JSApplicationCausedNativeException(stringBuilder.toString());
    }
}
