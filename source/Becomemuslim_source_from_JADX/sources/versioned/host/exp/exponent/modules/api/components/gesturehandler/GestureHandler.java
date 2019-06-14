package versioned.host.exp.exponent.modules.api.components.gesturehandler;

import android.view.MotionEvent;
import android.view.MotionEvent.PointerCoords;
import android.view.MotionEvent.PointerProperties;
import android.view.View;
import java.util.Arrays;

public class GestureHandler<T extends GestureHandler> {
    public static final int DIRECTION_DOWN = 8;
    public static final int DIRECTION_LEFT = 2;
    public static final int DIRECTION_RIGHT = 1;
    public static final int DIRECTION_UP = 4;
    private static final int HIT_SLOP_BOTTOM_IDX = 3;
    private static final int HIT_SLOP_HEIGHT_IDX = 5;
    private static final int HIT_SLOP_LEFT_IDX = 0;
    public static final float HIT_SLOP_NONE = Float.NaN;
    private static final int HIT_SLOP_RIGHT_IDX = 2;
    private static final int HIT_SLOP_TOP_IDX = 1;
    private static final int HIT_SLOP_WIDTH_IDX = 4;
    private static int MAX_POINTERS_COUNT = 11;
    public static final int STATE_ACTIVE = 4;
    public static final int STATE_BEGAN = 2;
    public static final int STATE_CANCELLED = 3;
    public static final int STATE_END = 5;
    public static final int STATE_FAILED = 1;
    public static final int STATE_UNDETERMINED = 0;
    private static PointerCoords[] sPointerCoords;
    private static PointerProperties[] sPointerProps;
    int mActivationIndex;
    private boolean mEnabled = true;
    private float[] mHitSlop;
    private GestureHandlerInteractionController mInteractionController;
    boolean mIsActive;
    boolean mIsAwaiting;
    private float mLastEventOffsetX;
    private float mLastEventOffsetY;
    private float mLastX;
    private float mLastY;
    private OnTouchEventListener<T> mListener;
    private int mNumberOfPointers = 0;
    private GestureHandlerOrchestrator mOrchestrator;
    private boolean mShouldCancelWhenOutside;
    private int mState = 0;
    private int mTag;
    private final int[] mTrackedPointerIDs = new int[MAX_POINTERS_COUNT];
    private int mTrackedPointersCount = 0;
    private View mView;
    private boolean mWithinBounds;
    private float mX;
    private float mY;

    public static String stateToString(int i) {
        switch (i) {
            case 0:
                return "UNDETERMINED";
            case 1:
                return "FAILED";
            case 2:
                return "BEGIN";
            case 3:
                return "CANCELLED";
            case 4:
                return "ACTIVE";
            case 5:
                return "END";
            default:
                return null;
        }
    }

    protected void onCancel() {
    }

    protected void onReset() {
    }

    protected void onStateChange(int i, int i2) {
    }

    private static void initPointerProps(int i) {
        if (sPointerProps == null) {
            sPointerProps = new PointerProperties[MAX_POINTERS_COUNT];
            sPointerCoords = new PointerCoords[MAX_POINTERS_COUNT];
        }
        while (i > 0) {
            int i2 = i - 1;
            if (sPointerProps[i2] == null) {
                sPointerProps[i2] = new PointerProperties();
                sPointerCoords[i2] = new PointerCoords();
                i--;
            } else {
                return;
            }
        }
    }

    private static boolean hitSlopSet(float f) {
        return Float.isNaN(f) ^ 1;
    }

    void dispatchStateChange(int i, int i2) {
        if (this.mListener != null) {
            this.mListener.onStateChange(this, i, i2);
        }
    }

    void dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mListener != null) {
            this.mListener.onTouchEvent(this, motionEvent);
        }
    }

    public boolean hasCommonPointers(GestureHandler gestureHandler) {
        int i = 0;
        while (i < this.mTrackedPointerIDs.length) {
            if (this.mTrackedPointerIDs[i] != -1 && gestureHandler.mTrackedPointerIDs[i] != -1) {
                return true;
            }
            i++;
        }
        return false;
    }

    public T setShouldCancelWhenOutside(boolean z) {
        this.mShouldCancelWhenOutside = z;
        return this;
    }

    public T setEnabled(boolean z) {
        if (this.mView != null) {
            cancel();
        }
        this.mEnabled = z;
        return this;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public T setHitSlop(float f, float f2, float f3, float f4, float f5, float f6) {
        if (this.mHitSlop == null) {
            this.mHitSlop = new float[6];
        }
        this.mHitSlop[0] = f;
        this.mHitSlop[1] = f2;
        this.mHitSlop[2] = f3;
        this.mHitSlop[3] = f4;
        this.mHitSlop[4] = f5;
        this.mHitSlop[5] = f6;
        if (hitSlopSet(f5) && hitSlopSet(f)) {
            if (hitSlopSet(f3)) {
                throw new IllegalArgumentException("Cannot have all of left, right and width defined");
            }
        }
        if (hitSlopSet(f5) != null && hitSlopSet(f) == null) {
            if (hitSlopSet(f3) == null) {
                throw new IllegalArgumentException("When width is set one of left or right pads need to be defined");
            }
        }
        if (!(hitSlopSet(f6) == null || hitSlopSet(f4) == null)) {
            if (hitSlopSet(f2) != null) {
                throw new IllegalArgumentException("Cannot have all of top, bottom and height defined");
            }
        }
        if (hitSlopSet(f6) != null && hitSlopSet(f4) == null) {
            if (hitSlopSet(f2) == null) {
                throw new IllegalArgumentException("When height is set one of top or bottom pads need to be defined");
            }
        }
        return this;
    }

    public T setHitSlop(float f) {
        return setHitSlop(f, f, f, f, Float.NaN, Float.NaN);
    }

    public T setInteractionController(GestureHandlerInteractionController gestureHandlerInteractionController) {
        this.mInteractionController = gestureHandlerInteractionController;
        return this;
    }

    public void setTag(int i) {
        this.mTag = i;
    }

    public int getTag() {
        return this.mTag;
    }

    public View getView() {
        return this.mView;
    }

    public float getX() {
        return this.mX;
    }

    public float getY() {
        return this.mY;
    }

    public int getNumberOfPointers() {
        return this.mNumberOfPointers;
    }

    public boolean isWithinBounds() {
        return this.mWithinBounds;
    }

    public final void prepare(View view, GestureHandlerOrchestrator gestureHandlerOrchestrator) {
        if (this.mView == null && this.mOrchestrator == null) {
            Arrays.fill(this.mTrackedPointerIDs, -1);
            this.mTrackedPointersCount = 0;
            this.mState = 0;
            this.mView = view;
            this.mOrchestrator = gestureHandlerOrchestrator;
            return;
        }
        throw new IllegalStateException("Already prepared or hasn't been reset");
    }

    private int findNextLocalPointerId() {
        int i = 0;
        while (i < this.mTrackedPointersCount) {
            int i2 = 0;
            while (i2 < this.mTrackedPointerIDs.length) {
                if (this.mTrackedPointerIDs[i2] == i) {
                    break;
                }
                i2++;
            }
            if (i2 == this.mTrackedPointerIDs.length) {
                return i;
            }
            i++;
        }
        return i;
    }

    public void startTrackingPointer(int i) {
        if (this.mTrackedPointerIDs[i] == -1) {
            this.mTrackedPointerIDs[i] = findNextLocalPointerId();
            this.mTrackedPointersCount++;
        }
    }

    public void stopTrackingPointer(int i) {
        if (this.mTrackedPointerIDs[i] != -1) {
            this.mTrackedPointerIDs[i] = -1;
            this.mTrackedPointersCount--;
        }
    }

    private boolean needAdapt(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() != this.mTrackedPointersCount) {
            return true;
        }
        int i = 0;
        while (i < this.mTrackedPointerIDs.length) {
            if (this.mTrackedPointerIDs[i] != -1 && this.mTrackedPointerIDs[i] != i) {
                return true;
            }
            i++;
        }
        return null;
    }

    private MotionEvent adaptEvent(MotionEvent motionEvent) {
        GestureHandler gestureHandler = this;
        MotionEvent motionEvent2 = motionEvent;
        if (!needAdapt(motionEvent)) {
            return motionEvent2;
        }
        float x;
        float y;
        int pointerCount;
        int i;
        int i2;
        int i3;
        MotionEvent obtain;
        int actionMasked = motionEvent.getActionMasked();
        int i4 = 2;
        int i5 = 5;
        if (actionMasked != 0) {
            if (actionMasked != 5) {
                i5 = 6;
                if (actionMasked != 1) {
                    if (actionMasked != 6) {
                        i4 = actionMasked;
                        actionMasked = -1;
                        initPointerProps(gestureHandler.mTrackedPointersCount);
                        x = motionEvent.getX();
                        y = motionEvent.getY();
                        motionEvent2.setLocation(motionEvent.getRawX(), motionEvent.getRawY());
                        pointerCount = motionEvent.getPointerCount();
                        i = i4;
                        i2 = 0;
                        for (i3 = 0; i3 < pointerCount; i3++) {
                            i4 = motionEvent2.getPointerId(i3);
                            if (gestureHandler.mTrackedPointerIDs[i4] == -1) {
                                motionEvent2.getPointerProperties(i3, sPointerProps[i2]);
                                sPointerProps[i2].id = gestureHandler.mTrackedPointerIDs[i4];
                                motionEvent2.getPointerCoords(i3, sPointerCoords[i2]);
                                if (i3 == actionMasked) {
                                    i |= i2 << 8;
                                }
                                i2++;
                            }
                        }
                        obtain = MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), i, i2, sPointerProps, sPointerCoords, motionEvent.getMetaState(), motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
                        motionEvent2.setLocation(x, y);
                        obtain.setLocation(x, y);
                        return obtain;
                    }
                }
                actionMasked = motionEvent.getActionIndex();
                if (gestureHandler.mTrackedPointerIDs[motionEvent2.getPointerId(actionMasked)] != -1) {
                    if (gestureHandler.mTrackedPointersCount == 1) {
                        i5 = 1;
                    }
                    i4 = i5;
                }
                initPointerProps(gestureHandler.mTrackedPointersCount);
                x = motionEvent.getX();
                y = motionEvent.getY();
                motionEvent2.setLocation(motionEvent.getRawX(), motionEvent.getRawY());
                pointerCount = motionEvent.getPointerCount();
                i = i4;
                i2 = 0;
                for (i3 = 0; i3 < pointerCount; i3++) {
                    i4 = motionEvent2.getPointerId(i3);
                    if (gestureHandler.mTrackedPointerIDs[i4] == -1) {
                        motionEvent2.getPointerProperties(i3, sPointerProps[i2]);
                        sPointerProps[i2].id = gestureHandler.mTrackedPointerIDs[i4];
                        motionEvent2.getPointerCoords(i3, sPointerCoords[i2]);
                        if (i3 == actionMasked) {
                            i |= i2 << 8;
                        }
                        i2++;
                    }
                }
                obtain = MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), i, i2, sPointerProps, sPointerCoords, motionEvent.getMetaState(), motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
                motionEvent2.setLocation(x, y);
                obtain.setLocation(x, y);
                return obtain;
            }
        }
        actionMasked = motionEvent.getActionIndex();
        if (gestureHandler.mTrackedPointerIDs[motionEvent2.getPointerId(actionMasked)] != -1) {
            if (gestureHandler.mTrackedPointersCount == 1) {
                i5 = 0;
            }
            i4 = i5;
        }
        initPointerProps(gestureHandler.mTrackedPointersCount);
        x = motionEvent.getX();
        y = motionEvent.getY();
        motionEvent2.setLocation(motionEvent.getRawX(), motionEvent.getRawY());
        pointerCount = motionEvent.getPointerCount();
        i = i4;
        i2 = 0;
        for (i3 = 0; i3 < pointerCount; i3++) {
            i4 = motionEvent2.getPointerId(i3);
            if (gestureHandler.mTrackedPointerIDs[i4] == -1) {
                motionEvent2.getPointerProperties(i3, sPointerProps[i2]);
                sPointerProps[i2].id = gestureHandler.mTrackedPointerIDs[i4];
                motionEvent2.getPointerCoords(i3, sPointerCoords[i2]);
                if (i3 == actionMasked) {
                    i |= i2 << 8;
                }
                i2++;
            }
        }
        obtain = MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), i, i2, sPointerProps, sPointerCoords, motionEvent.getMetaState(), motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
        motionEvent2.setLocation(x, y);
        obtain.setLocation(x, y);
        return obtain;
    }

    public final void handle(MotionEvent motionEvent) {
        if (!(!this.mEnabled || this.mState == 3 || this.mState == 1 || this.mState == 5)) {
            if (this.mTrackedPointersCount >= 1) {
                MotionEvent adaptEvent = adaptEvent(motionEvent);
                this.mX = adaptEvent.getX();
                this.mY = adaptEvent.getY();
                this.mNumberOfPointers = adaptEvent.getPointerCount();
                this.mWithinBounds = isWithinBounds(this.mView, this.mX, this.mY);
                if (!this.mShouldCancelWhenOutside || this.mWithinBounds) {
                    this.mLastX = GestureUtils.getLastPointerX(adaptEvent, true);
                    this.mLastY = GestureUtils.getLastPointerY(adaptEvent, true);
                    this.mLastEventOffsetX = adaptEvent.getRawX() - adaptEvent.getX();
                    this.mLastEventOffsetY = adaptEvent.getRawY() - adaptEvent.getY();
                    onHandle(adaptEvent);
                    if (adaptEvent != motionEvent) {
                        adaptEvent.recycle();
                    }
                    return;
                }
                if (this.mState == 4) {
                    cancel();
                } else if (this.mState == 2) {
                    fail();
                }
            }
        }
    }

    private void moveToState(int i) {
        if (this.mState != i) {
            int i2 = this.mState;
            this.mState = i;
            this.mOrchestrator.onHandlerStateChange(this, i, i2);
            onStateChange(i, i2);
        }
    }

    public boolean wantEvents() {
        return (!this.mEnabled || this.mState == 1 || this.mState == 3 || this.mState == 5 || this.mTrackedPointersCount <= 0) ? false : true;
    }

    public int getState() {
        return this.mState;
    }

    public boolean shouldRequireToWaitForFailure(GestureHandler gestureHandler) {
        return (gestureHandler == this || this.mInteractionController == null) ? null : this.mInteractionController.shouldRequireHandlerToWaitForFailure(this, gestureHandler);
    }

    public boolean shouldWaitForHandlerFailure(GestureHandler gestureHandler) {
        return (gestureHandler == this || this.mInteractionController == null) ? null : this.mInteractionController.shouldWaitForHandlerFailure(this, gestureHandler);
    }

    public boolean shouldRecognizeSimultaneously(GestureHandler gestureHandler) {
        if (gestureHandler == this) {
            return true;
        }
        return this.mInteractionController != null ? this.mInteractionController.shouldRecognizeSimultaneously(this, gestureHandler) : null;
    }

    public boolean shouldBeCancelledBy(GestureHandler gestureHandler) {
        if (gestureHandler == this || this.mInteractionController == null) {
            return false;
        }
        return this.mInteractionController.shouldHandlerBeCancelledBy(this, gestureHandler);
    }

    public boolean isWithinBounds(View view, float f, float f2) {
        float f3;
        float width = (float) view.getWidth();
        view = (float) view.getHeight();
        float f4 = 0.0f;
        if (this.mHitSlop != null) {
            float f5 = this.mHitSlop[0];
            float f6 = this.mHitSlop[1];
            float f7 = this.mHitSlop[2];
            float f8 = this.mHitSlop[3];
            f3 = hitSlopSet(f5) ? 0.0f - f5 : 0.0f;
            if (hitSlopSet(f6)) {
                f4 = 0.0f - f8;
            }
            if (hitSlopSet(f7)) {
                width += f7;
            }
            if (hitSlopSet(f8)) {
                view += f8;
            }
            f6 = this.mHitSlop[4];
            f8 = this.mHitSlop[5];
            if (hitSlopSet(f6)) {
                if (!hitSlopSet(f5)) {
                    f3 = f7 - f6;
                } else if (!hitSlopSet(f7)) {
                    width = f5 + f6;
                }
            }
            if (hitSlopSet(f8)) {
                if (!hitSlopSet(f4)) {
                    f4 = view - f8;
                } else if (!hitSlopSet(view)) {
                    view = f4 + f8;
                }
            }
        } else {
            f3 = 0.0f;
        }
        if (f < f3 || f > r0 || f2 < r4 || f2 > r11) {
            return false;
        }
        return true;
    }

    public final void cancel() {
        if (this.mState == 4 || this.mState == 0 || this.mState == 2) {
            onCancel();
            moveToState(3);
        }
    }

    public final void fail() {
        if (this.mState == 4 || this.mState == 0 || this.mState == 2) {
            moveToState(1);
        }
    }

    public final void activate() {
        if (this.mState == 0 || this.mState == 2) {
            moveToState(4);
        }
    }

    public final void begin() {
        if (this.mState == 0) {
            moveToState(2);
        }
    }

    public final void end() {
        if (this.mState == 2 || this.mState == 4) {
            moveToState(5);
        }
    }

    protected void onHandle(MotionEvent motionEvent) {
        moveToState(1);
    }

    public final void reset() {
        this.mView = null;
        this.mOrchestrator = null;
        Arrays.fill(this.mTrackedPointerIDs, -1);
        this.mTrackedPointersCount = 0;
        onReset();
    }

    public GestureHandler setOnTouchEventListener(OnTouchEventListener<T> onTouchEventListener) {
        this.mListener = onTouchEventListener;
        return this;
    }

    public String toString() {
        String simpleName = this.mView == null ? null : this.mView.getClass().getSimpleName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append("@[");
        stringBuilder.append(this.mTag);
        stringBuilder.append("]:");
        stringBuilder.append(simpleName);
        return stringBuilder.toString();
    }

    public float getLastAbsolutePositionX() {
        return this.mLastX;
    }

    public float getLastAbsolutePositionY() {
        return this.mLastY;
    }

    public float getLastRelativePositionX() {
        return this.mLastX - this.mLastEventOffsetX;
    }

    public float getLastRelativePositionY() {
        return this.mLastY - this.mLastEventOffsetY;
    }
}
