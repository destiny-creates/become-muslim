package com.facebook.react.uimanager;

import android.view.MotionEvent;
import android.view.ViewGroup;
import com.facebook.common.logging.FLog;
import com.facebook.imageutils.JfifUtil;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.TouchEvent;
import com.facebook.react.uimanager.events.TouchEventCoalescingKeyHelper;
import com.facebook.react.uimanager.events.TouchEventType;
import expolib_v1.com.facebook.infer.annotation.Assertions;

public class JSTouchDispatcher {
    private boolean mChildIsHandlingNativeGesture = false;
    private long mGestureStartTime = Long.MIN_VALUE;
    private final ViewGroup mRootViewGroup;
    private final float[] mTargetCoordinates = new float[2];
    private int mTargetTag = -1;
    private final TouchEventCoalescingKeyHelper mTouchEventCoalescingKeyHelper = new TouchEventCoalescingKeyHelper();

    public JSTouchDispatcher(ViewGroup viewGroup) {
        this.mRootViewGroup = viewGroup;
    }

    public void onChildStartedNativeGesture(MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        if (!this.mChildIsHandlingNativeGesture) {
            dispatchCancelEvent(motionEvent, eventDispatcher);
            this.mChildIsHandlingNativeGesture = true;
            this.mTargetTag = -1;
        }
    }

    public void handleTouchEvent(MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        JSTouchDispatcher jSTouchDispatcher = this;
        EventDispatcher eventDispatcher2 = eventDispatcher;
        int action = motionEvent.getAction() & JfifUtil.MARKER_FIRST_BYTE;
        if (action == 0) {
            if (jSTouchDispatcher.mTargetTag != -1) {
                FLog.m5674e(ReactConstants.TAG, "Got DOWN touch before receiving UP or CANCEL from last gesture");
            }
            jSTouchDispatcher.mChildIsHandlingNativeGesture = false;
            jSTouchDispatcher.mGestureStartTime = motionEvent.getEventTime();
            jSTouchDispatcher.mTargetTag = findTargetTagAndSetCoordinates(motionEvent);
            eventDispatcher2.dispatchEvent(TouchEvent.obtain(jSTouchDispatcher.mTargetTag, TouchEventType.START, motionEvent, jSTouchDispatcher.mGestureStartTime, jSTouchDispatcher.mTargetCoordinates[0], jSTouchDispatcher.mTargetCoordinates[1], jSTouchDispatcher.mTouchEventCoalescingKeyHelper));
        } else if (!jSTouchDispatcher.mChildIsHandlingNativeGesture) {
            if (jSTouchDispatcher.mTargetTag == -1) {
                FLog.m5674e(ReactConstants.TAG, "Unexpected state: received touch event but didn't get starting ACTION_DOWN for this gesture before");
            } else if (action == 1) {
                findTargetTagAndSetCoordinates(motionEvent);
                eventDispatcher2.dispatchEvent(TouchEvent.obtain(jSTouchDispatcher.mTargetTag, TouchEventType.END, motionEvent, jSTouchDispatcher.mGestureStartTime, jSTouchDispatcher.mTargetCoordinates[0], jSTouchDispatcher.mTargetCoordinates[1], jSTouchDispatcher.mTouchEventCoalescingKeyHelper));
                jSTouchDispatcher.mTargetTag = -1;
                jSTouchDispatcher.mGestureStartTime = Long.MIN_VALUE;
            } else if (action == 2) {
                findTargetTagAndSetCoordinates(motionEvent);
                eventDispatcher2.dispatchEvent(TouchEvent.obtain(jSTouchDispatcher.mTargetTag, TouchEventType.MOVE, motionEvent, jSTouchDispatcher.mGestureStartTime, jSTouchDispatcher.mTargetCoordinates[0], jSTouchDispatcher.mTargetCoordinates[1], jSTouchDispatcher.mTouchEventCoalescingKeyHelper));
            } else if (action == 5) {
                eventDispatcher2.dispatchEvent(TouchEvent.obtain(jSTouchDispatcher.mTargetTag, TouchEventType.START, motionEvent, jSTouchDispatcher.mGestureStartTime, jSTouchDispatcher.mTargetCoordinates[0], jSTouchDispatcher.mTargetCoordinates[1], jSTouchDispatcher.mTouchEventCoalescingKeyHelper));
            } else if (action == 6) {
                eventDispatcher2.dispatchEvent(TouchEvent.obtain(jSTouchDispatcher.mTargetTag, TouchEventType.END, motionEvent, jSTouchDispatcher.mGestureStartTime, jSTouchDispatcher.mTargetCoordinates[0], jSTouchDispatcher.mTargetCoordinates[1], jSTouchDispatcher.mTouchEventCoalescingKeyHelper));
            } else if (action == 3) {
                if (jSTouchDispatcher.mTouchEventCoalescingKeyHelper.hasCoalescingKey(motionEvent.getDownTime())) {
                    dispatchCancelEvent(motionEvent, eventDispatcher);
                } else {
                    FLog.m5674e(ReactConstants.TAG, "Received an ACTION_CANCEL touch event for which we have no corresponding ACTION_DOWN");
                }
                jSTouchDispatcher.mTargetTag = -1;
                jSTouchDispatcher.mGestureStartTime = Long.MIN_VALUE;
            } else {
                String str = ReactConstants.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Warning : touch event was ignored. Action=");
                stringBuilder.append(action);
                stringBuilder.append(" Target=");
                stringBuilder.append(jSTouchDispatcher.mTargetTag);
                FLog.m5714w(str, stringBuilder.toString());
            }
        }
    }

    private int findTargetTagAndSetCoordinates(MotionEvent motionEvent) {
        return TouchTargetHelper.findTargetTagAndCoordinatesForTouch(motionEvent.getX(), motionEvent.getY(), this.mRootViewGroup, this.mTargetCoordinates, null);
    }

    private void dispatchCancelEvent(MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        if (this.mTargetTag == -1) {
            FLog.m5714w(ReactConstants.TAG, "Can't cancel already finished gesture. Is a child View trying to start a gesture from an UP/CANCEL event?");
            return;
        }
        Assertions.assertCondition(this.mChildIsHandlingNativeGesture ^ true, "Expected to not have already sent a cancel for this gesture");
        ((EventDispatcher) Assertions.assertNotNull(eventDispatcher)).dispatchEvent(TouchEvent.obtain(this.mTargetTag, TouchEventType.CANCEL, motionEvent, this.mGestureStartTime, this.mTargetCoordinates[0], this.mTargetCoordinates[1], this.mTouchEventCoalescingKeyHelper));
    }
}
