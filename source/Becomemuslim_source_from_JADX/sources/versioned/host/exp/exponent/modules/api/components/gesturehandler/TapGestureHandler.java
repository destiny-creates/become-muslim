package versioned.host.exp.exponent.modules.api.components.gesturehandler;

import android.os.Handler;
import android.view.MotionEvent;

public class TapGestureHandler extends GestureHandler<TapGestureHandler> {
    private static final long DEFAULT_MAX_DELAY_MS = 500;
    private static final long DEFAULT_MAX_DURATION_MS = 500;
    private static final int DEFAULT_MIN_NUMBER_OF_POINTERS = 1;
    private static final int DEFAULT_NUMBER_OF_TAPS = 1;
    private static float MAX_VALUE_IGNORE = Float.MIN_VALUE;
    private final Runnable mFailDelayed = new C67351();
    private Handler mHandler;
    private float mLastX;
    private float mLastY;
    private long mMaxDelayMs = 500;
    private float mMaxDeltaX = MAX_VALUE_IGNORE;
    private float mMaxDeltaY = MAX_VALUE_IGNORE;
    private float mMaxDistSq = MAX_VALUE_IGNORE;
    private long mMaxDurationMs = 500;
    private int mMinNumberOfPointers = 1;
    private int mNumberOfPointers = 1;
    private int mNumberOfTaps = 1;
    private float mOffsetX;
    private float mOffsetY;
    private float mStartX;
    private float mStartY;
    private int mTapsSoFar;

    /* renamed from: versioned.host.exp.exponent.modules.api.components.gesturehandler.TapGestureHandler$1 */
    class C67351 implements Runnable {
        C67351() {
        }

        public void run() {
            TapGestureHandler.this.fail();
        }
    }

    public TapGestureHandler setNumberOfTaps(int i) {
        this.mNumberOfTaps = i;
        return this;
    }

    public TapGestureHandler setMaxDelayMs(long j) {
        this.mMaxDelayMs = j;
        return this;
    }

    public TapGestureHandler setMaxDurationMs(long j) {
        this.mMaxDurationMs = j;
        return this;
    }

    public TapGestureHandler setMaxDx(float f) {
        this.mMaxDeltaX = f;
        return this;
    }

    public TapGestureHandler setMaxDy(float f) {
        this.mMaxDeltaY = f;
        return this;
    }

    public TapGestureHandler setMaxDist(float f) {
        this.mMaxDistSq = f * f;
        return this;
    }

    public TapGestureHandler setMinNumberOfPointers(int i) {
        this.mMinNumberOfPointers = i;
        return this;
    }

    public TapGestureHandler() {
        setShouldCancelWhenOutside(true);
    }

    private void startTap() {
        if (this.mHandler == null) {
            this.mHandler = new Handler();
        } else {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        this.mHandler.postDelayed(this.mFailDelayed, this.mMaxDurationMs);
    }

    private void endTap() {
        if (this.mHandler == null) {
            this.mHandler = new Handler();
        } else {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        int i = this.mTapsSoFar + 1;
        this.mTapsSoFar = i;
        if (i != this.mNumberOfTaps || this.mNumberOfPointers < this.mMinNumberOfPointers) {
            this.mHandler.postDelayed(this.mFailDelayed, this.mMaxDelayMs);
            return;
        }
        activate();
        end();
    }

    private boolean shouldFail() {
        float f = (this.mLastX - this.mStartX) + this.mOffsetX;
        boolean z = true;
        if (this.mMaxDeltaX != MAX_VALUE_IGNORE && Math.abs(f) > this.mMaxDeltaX) {
            return true;
        }
        float f2 = (this.mLastY - this.mStartY) + this.mOffsetY;
        if (this.mMaxDeltaY != MAX_VALUE_IGNORE && Math.abs(f2) > this.mMaxDeltaY) {
            return true;
        }
        f2 = (f2 * f2) + (f * f);
        if (this.mMaxDistSq == MAX_VALUE_IGNORE || f2 <= this.mMaxDistSq) {
            z = false;
        }
        return z;
    }

    protected void onHandle(MotionEvent motionEvent) {
        int state = getState();
        int actionMasked = motionEvent.getActionMasked();
        if (state == 0) {
            this.mOffsetX = 0.0f;
            this.mOffsetY = 0.0f;
            this.mStartX = motionEvent.getRawX();
            this.mStartY = motionEvent.getRawY();
        }
        if (actionMasked != 6) {
            if (actionMasked != 5) {
                this.mLastX = GestureUtils.getLastPointerX(motionEvent, true);
                this.mLastY = GestureUtils.getLastPointerY(motionEvent, true);
                if (this.mNumberOfPointers < motionEvent.getPointerCount()) {
                    this.mNumberOfPointers = motionEvent.getPointerCount();
                }
                if (shouldFail() != null) {
                    fail();
                } else if (state == 0) {
                    if (actionMasked == 0) {
                        begin();
                    }
                    startTap();
                } else if (state != 2) {
                } else {
                    if (actionMasked == 1) {
                        endTap();
                    } else if (actionMasked == 0) {
                        startTap();
                    }
                }
            }
        }
        this.mOffsetX += this.mLastX - this.mStartX;
        this.mOffsetY += this.mLastY - this.mStartY;
        this.mLastX = GestureUtils.getLastPointerX(motionEvent, true);
        this.mLastY = GestureUtils.getLastPointerY(motionEvent, true);
        this.mStartX = this.mLastX;
        this.mStartY = this.mLastY;
        if (this.mNumberOfPointers < motionEvent.getPointerCount()) {
            this.mNumberOfPointers = motionEvent.getPointerCount();
        }
        if (shouldFail() != null) {
            fail();
        } else if (state == 0) {
            if (actionMasked == 0) {
                begin();
            }
            startTap();
        } else if (state != 2) {
            if (actionMasked == 1) {
                endTap();
            } else if (actionMasked == 0) {
                startTap();
            }
        }
    }

    protected void onCancel() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    protected void onReset() {
        this.mTapsSoFar = 0;
        this.mNumberOfPointers = 0;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }
}
