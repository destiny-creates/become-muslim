package com.facebook.react.uimanager.events;

import android.support.v4.util.Pools.C4463b;
import android.view.MotionEvent;
import com.facebook.imageutils.JfifUtil;
import com.facebook.react.bridge.SoftAssertions;
import expolib_v1.com.facebook.infer.annotation.Assertions;

public class TouchEvent extends Event<TouchEvent> {
    private static final C4463b<TouchEvent> EVENTS_POOL = new C4463b(3);
    private static final int TOUCH_EVENTS_POOL_SIZE = 3;
    public static final long UNSET = Long.MIN_VALUE;
    private short mCoalescingKey;
    private MotionEvent mMotionEvent;
    private TouchEventType mTouchEventType;
    private float mViewX;
    private float mViewY;

    public static TouchEvent obtain(int i, TouchEventType touchEventType, MotionEvent motionEvent, long j, float f, float f2, TouchEventCoalescingKeyHelper touchEventCoalescingKeyHelper) {
        TouchEvent touchEvent = (TouchEvent) EVENTS_POOL.acquire();
        if (touchEvent == null) {
            touchEvent = new TouchEvent();
        }
        touchEvent.init(i, touchEventType, motionEvent, j, f, f2, touchEventCoalescingKeyHelper);
        return touchEvent;
    }

    private TouchEvent() {
    }

    private void init(int i, TouchEventType touchEventType, MotionEvent motionEvent, long j, float f, float f2, TouchEventCoalescingKeyHelper touchEventCoalescingKeyHelper) {
        super.init(i);
        i = 0;
        SoftAssertions.assertCondition(j != Long.MIN_VALUE, "Gesture start time must be initialized");
        int action = motionEvent.getAction() & JfifUtil.MARKER_FIRST_BYTE;
        switch (action) {
            case 0:
                touchEventCoalescingKeyHelper.addCoalescingKey(j);
                break;
            case 1:
                touchEventCoalescingKeyHelper.removeCoalescingKey(j);
                break;
            case 2:
                i = touchEventCoalescingKeyHelper.getCoalescingKey(j);
                break;
            case 3:
                touchEventCoalescingKeyHelper.removeCoalescingKey(j);
                break;
            case 5:
            case 6:
                touchEventCoalescingKeyHelper.incrementCoalescingKey(j);
                break;
            default:
                touchEventType = new StringBuilder();
                touchEventType.append("Unhandled MotionEvent action: ");
                touchEventType.append(action);
                throw new RuntimeException(touchEventType.toString());
        }
        this.mTouchEventType = touchEventType;
        this.mMotionEvent = MotionEvent.obtain(motionEvent);
        this.mCoalescingKey = i;
        this.mViewX = f;
        this.mViewY = f2;
    }

    public void onDispose() {
        ((MotionEvent) Assertions.assertNotNull(this.mMotionEvent)).recycle();
        this.mMotionEvent = null;
        EVENTS_POOL.release(this);
    }

    public String getEventName() {
        return ((TouchEventType) Assertions.assertNotNull(this.mTouchEventType)).getJSEventName();
    }

    public boolean canCoalesce() {
        switch ((TouchEventType) Assertions.assertNotNull(this.mTouchEventType)) {
            case START:
            case END:
            case CANCEL:
                return false;
            case MOVE:
                return true;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown touch event type: ");
                stringBuilder.append(this.mTouchEventType);
                throw new RuntimeException(stringBuilder.toString());
        }
    }

    public short getCoalescingKey() {
        return this.mCoalescingKey;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        TouchesHelper.sendTouchEvent(rCTEventEmitter, (TouchEventType) Assertions.assertNotNull(this.mTouchEventType), getViewTag(), this);
    }

    public MotionEvent getMotionEvent() {
        Assertions.assertNotNull(this.mMotionEvent);
        return this.mMotionEvent;
    }

    public float getViewX() {
        return this.mViewX;
    }

    public float getViewY() {
        return this.mViewY;
    }
}
