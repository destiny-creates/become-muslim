package versioned.host.exp.exponent.modules.api.components.gesturehandler;

import android.content.Context;
import android.os.Handler;
import android.view.MotionEvent;

public class LongPressGestureHandler extends GestureHandler<LongPressGestureHandler> {
    private static float DEFAULT_MAX_DIST_DP = 10.0f;
    private static final long DEFAULT_MIN_DURATION_MS = 500;
    private Handler mHandler;
    private float mMaxDistSq;
    private long mMinDurationMs = DEFAULT_MIN_DURATION_MS;
    private float mStartX;
    private float mStartY;

    /* renamed from: versioned.host.exp.exponent.modules.api.components.gesturehandler.LongPressGestureHandler$1 */
    class C67331 implements Runnable {
        C67331() {
        }

        public void run() {
            LongPressGestureHandler.this.activate();
        }
    }

    public LongPressGestureHandler(Context context) {
        setShouldCancelWhenOutside(true);
        this.mMaxDistSq = DEFAULT_MAX_DIST_DP * context.getResources().getDisplayMetrics().density;
    }

    public void setMinDurationMs(long j) {
        this.mMinDurationMs = j;
    }

    public LongPressGestureHandler setMaxDist(float f) {
        this.mMaxDistSq = f * f;
        return this;
    }

    protected void onHandle(MotionEvent motionEvent) {
        if (getState() == 0) {
            begin();
            this.mStartX = motionEvent.getRawX();
            this.mStartY = motionEvent.getRawY();
            this.mHandler = new Handler();
            this.mHandler.postDelayed(new C67331(), this.mMinDurationMs);
        }
        if (motionEvent.getActionMasked() == 1) {
            if (this.mHandler != null) {
                this.mHandler.removeCallbacksAndMessages(null);
                this.mHandler = null;
            }
            if (getState() == 4) {
                end();
                return;
            } else {
                fail();
                return;
            }
        }
        float rawX = motionEvent.getRawX() - this.mStartX;
        motionEvent = motionEvent.getRawY() - this.mStartY;
        if ((rawX * rawX) + (motionEvent * motionEvent) <= this.mMaxDistSq) {
            return;
        }
        if (getState() == 4) {
            cancel();
        } else {
            fail();
        }
    }

    protected void onStateChange(int i, int i2) {
        if (this.mHandler != 0) {
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
    }
}
