package versioned.host.exp.exponent.modules.api.components.gesturehandler;

import android.os.Handler;
import android.view.MotionEvent;

public class FlingGestureHandler extends GestureHandler<FlingGestureHandler> {
    private static final int DEFAULT_DIRECTION = 1;
    private static final long DEFAULT_MAX_DURATION_MS = 800;
    private static final long DEFAULT_MIN_ACCEPTABLE_DELTA = 160;
    private static final int DEFAULT_NUMBER_OF_TOUCHES_REQUIRED = 1;
    private int mDirection = 1;
    private final Runnable mFailDelayed = new C67311();
    private Handler mHandler;
    private long mMaxDurationMs = DEFAULT_MAX_DURATION_MS;
    private int mMaxNumberOfPointersSimultaneously;
    private long mMinAcceptableDelta = DEFAULT_MIN_ACCEPTABLE_DELTA;
    private int mNumberOfPointersRequired = 1;
    private float mStartX;
    private float mStartY;

    /* renamed from: versioned.host.exp.exponent.modules.api.components.gesturehandler.FlingGestureHandler$1 */
    class C67311 implements Runnable {
        C67311() {
        }

        public void run() {
            FlingGestureHandler.this.fail();
        }
    }

    public void setNumberOfPointersRequired(int i) {
        this.mNumberOfPointersRequired = i;
    }

    public void setDirection(int i) {
        this.mDirection = i;
    }

    private void startFling(MotionEvent motionEvent) {
        this.mStartX = motionEvent.getRawX();
        this.mStartY = motionEvent.getRawY();
        begin();
        this.mMaxNumberOfPointersSimultaneously = 1;
        if (this.mHandler == null) {
            this.mHandler = new Handler();
        } else {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        this.mHandler.postDelayed(this.mFailDelayed, this.mMaxDurationMs);
    }

    private boolean tryEndFling(MotionEvent motionEvent) {
        if (this.mMaxNumberOfPointersSimultaneously != this.mNumberOfPointersRequired || (((this.mDirection & 1) == 0 || motionEvent.getRawX() - this.mStartX <= ((float) this.mMinAcceptableDelta)) && (((this.mDirection & 2) == 0 || this.mStartX - motionEvent.getRawX() <= ((float) this.mMinAcceptableDelta)) && (((this.mDirection & 4) == 0 || this.mStartY - motionEvent.getRawY() <= ((float) this.mMinAcceptableDelta)) && ((this.mDirection & 8) == 0 || motionEvent.getRawY() - this.mStartY <= ((float) this.mMinAcceptableDelta)))))) {
            return null;
        }
        this.mHandler.removeCallbacksAndMessages(null);
        activate();
        end();
        return true;
    }

    private void endFling(MotionEvent motionEvent) {
        if (tryEndFling(motionEvent) == null) {
            fail();
        }
    }

    protected void onHandle(MotionEvent motionEvent) {
        int state = getState();
        if (state == 0) {
            startFling(motionEvent);
        }
        if (state == 2) {
            tryEndFling(motionEvent);
            if (motionEvent.getPointerCount() > this.mMaxNumberOfPointersSimultaneously) {
                this.mMaxNumberOfPointersSimultaneously = motionEvent.getPointerCount();
            }
            if (motionEvent.getActionMasked() == 1) {
                endFling(motionEvent);
            }
        }
    }

    protected void onCancel() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    protected void onReset() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }
}
