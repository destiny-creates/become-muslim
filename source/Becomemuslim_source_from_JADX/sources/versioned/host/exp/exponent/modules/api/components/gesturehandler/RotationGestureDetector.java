package versioned.host.exp.exponent.modules.api.components.gesturehandler;

import android.view.MotionEvent;

public class RotationGestureDetector {
    private float mAnchorX;
    private float mAnchorY;
    private double mAngleDiff;
    private long mCurrTime;
    private boolean mInProgress;
    private OnRotationGestureListener mListener;
    private int[] mPointerIds = new int[2];
    private double mPrevAngle;
    private long mPrevTime;

    public interface OnRotationGestureListener {
        boolean onRotation(RotationGestureDetector rotationGestureDetector);

        boolean onRotationBegin(RotationGestureDetector rotationGestureDetector);

        void onRotationEnd(RotationGestureDetector rotationGestureDetector);
    }

    public RotationGestureDetector(OnRotationGestureListener onRotationGestureListener) {
        this.mListener = onRotationGestureListener;
    }

    private void updateCurrent(MotionEvent motionEvent) {
        this.mPrevTime = this.mCurrTime;
        this.mCurrTime = motionEvent.getEventTime();
        int findPointerIndex = motionEvent.findPointerIndex(this.mPointerIds[0]);
        int findPointerIndex2 = motionEvent.findPointerIndex(this.mPointerIds[1]);
        float x = motionEvent.getX(findPointerIndex);
        float y = motionEvent.getY(findPointerIndex);
        float x2 = motionEvent.getX(findPointerIndex2);
        motionEvent = motionEvent.getY(findPointerIndex2);
        float f = x2 - x;
        float f2 = motionEvent - y;
        this.mAnchorX = (x + x2) * 0.5f;
        this.mAnchorY = (y + motionEvent) * 0.5f;
        double d = -Math.atan2((double) f2, (double) f);
        if (Double.isNaN(this.mPrevAngle) != null) {
            this.mAngleDiff = 0.0d;
        } else {
            this.mAngleDiff = this.mPrevAngle - d;
        }
        this.mPrevAngle = d;
        if (this.mAngleDiff > 3.141592653589793d) {
            this.mAngleDiff -= 3.141592653589793d;
        } else if (this.mAngleDiff < -3.141592653589793d) {
            this.mAngleDiff += 3.141592653589793d;
        }
        if (this.mAngleDiff > 1.5707963267948966d) {
            this.mAngleDiff -= 3.141592653589793d;
        } else if (this.mAngleDiff < -1.5707963267948966d) {
            this.mAngleDiff += 3.141592653589793d;
        }
    }

    private void finish() {
        if (this.mInProgress) {
            this.mInProgress = false;
            if (this.mListener != null) {
                this.mListener.onRotationEnd(this);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.mInProgress = false;
                this.mPointerIds[0] = motionEvent.getPointerId(motionEvent.getActionIndex());
                this.mPointerIds[1] = -1;
                break;
            case 1:
                finish();
                break;
            case 2:
                if (this.mInProgress) {
                    updateCurrent(motionEvent);
                    if (this.mListener != null) {
                        this.mListener.onRotation(this);
                        break;
                    }
                }
                break;
            case 5:
                if (!this.mInProgress) {
                    this.mPointerIds[1] = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.mInProgress = true;
                    this.mPrevTime = motionEvent.getEventTime();
                    this.mPrevAngle = Double.NaN;
                    updateCurrent(motionEvent);
                    if (this.mListener != null) {
                        this.mListener.onRotationBegin(this);
                        break;
                    }
                }
                break;
            case 6:
                if (this.mInProgress) {
                    motionEvent = motionEvent.getPointerId(motionEvent.getActionIndex());
                    if (motionEvent == this.mPointerIds[0] || motionEvent == this.mPointerIds[1]) {
                        finish();
                        break;
                    }
                }
                break;
            default:
                break;
        }
        return true;
    }

    public double getRotation() {
        return this.mAngleDiff;
    }

    public long getTimeDelta() {
        return this.mCurrTime - this.mPrevTime;
    }

    public float getAnchorX() {
        return this.mAnchorX;
    }

    public float getAnchorY() {
        return this.mAnchorY;
    }
}
