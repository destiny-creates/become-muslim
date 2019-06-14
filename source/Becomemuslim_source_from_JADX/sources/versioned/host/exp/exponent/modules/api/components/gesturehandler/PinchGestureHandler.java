package versioned.host.exp.exponent.modules.api.components.gesturehandler;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.ViewConfiguration;

public class PinchGestureHandler extends GestureHandler<PinchGestureHandler> {
    private OnScaleGestureListener mGestureListener = new C67341();
    private double mLastScaleFactor;
    private double mLastVelocity;
    private ScaleGestureDetector mScaleGestureDetector;
    private float mSpanSlop;
    private float mStartingSpan;

    /* renamed from: versioned.host.exp.exponent.modules.api.components.gesturehandler.PinchGestureHandler$1 */
    class C67341 implements OnScaleGestureListener {
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }

        C67341() {
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            double access$000 = PinchGestureHandler.this.mLastScaleFactor;
            PinchGestureHandler.this.mLastScaleFactor = PinchGestureHandler.this.mLastScaleFactor * ((double) scaleGestureDetector.getScaleFactor());
            long timeDelta = scaleGestureDetector.getTimeDelta();
            if (timeDelta > 0) {
                PinchGestureHandler.this.mLastVelocity = (PinchGestureHandler.this.mLastScaleFactor - access$000) / ((double) timeDelta);
            }
            if (Math.abs(PinchGestureHandler.this.mStartingSpan - scaleGestureDetector.getCurrentSpan()) >= PinchGestureHandler.this.mSpanSlop && PinchGestureHandler.this.getState() == 2) {
                PinchGestureHandler.this.activate();
            }
            return true;
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            PinchGestureHandler.this.mStartingSpan = scaleGestureDetector.getCurrentSpan();
            return true;
        }
    }

    public PinchGestureHandler() {
        setShouldCancelWhenOutside(false);
    }

    protected void onHandle(MotionEvent motionEvent) {
        if (getState() == 0) {
            Context context = getView().getContext();
            this.mLastVelocity = 0.0d;
            this.mLastScaleFactor = 1.0d;
            this.mScaleGestureDetector = new ScaleGestureDetector(context, this.mGestureListener);
            this.mSpanSlop = (float) ViewConfiguration.get(context).getScaledTouchSlop();
            begin();
        }
        if (this.mScaleGestureDetector != null) {
            this.mScaleGestureDetector.onTouchEvent(motionEvent);
        }
        int pointerCount = motionEvent.getPointerCount();
        if (motionEvent.getActionMasked() == 6) {
            pointerCount--;
        }
        if (getState() == 4 && r0 < 2) {
            end();
        } else if (motionEvent.getActionMasked() == 1) {
            fail();
        }
    }

    protected void onReset() {
        this.mScaleGestureDetector = null;
        this.mLastVelocity = 0.0d;
        this.mLastScaleFactor = 1.0d;
    }

    public double getScale() {
        return this.mLastScaleFactor;
    }

    public double getVelocity() {
        return this.mLastVelocity;
    }

    public float getFocalPointX() {
        if (this.mScaleGestureDetector == null) {
            return Float.NaN;
        }
        return this.mScaleGestureDetector.getFocusX();
    }

    public float getFocalPointY() {
        if (this.mScaleGestureDetector == null) {
            return Float.NaN;
        }
        return this.mScaleGestureDetector.getFocusY();
    }
}
