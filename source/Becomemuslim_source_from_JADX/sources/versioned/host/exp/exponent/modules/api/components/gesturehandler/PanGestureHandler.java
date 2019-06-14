package versioned.host.exp.exponent.modules.api.components.gesturehandler;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public class PanGestureHandler extends GestureHandler<PanGestureHandler> {
    private static int DEFAULT_MAX_POINTERS = 10;
    private static int DEFAULT_MIN_POINTERS = 1;
    private static float MAX_VALUE_IGNORE = Float.MIN_VALUE;
    private static float MIN_VALUE_IGNORE = Float.MAX_VALUE;
    private float mActiveOffsetXEnd = MAX_VALUE_IGNORE;
    private float mActiveOffsetXStart = MIN_VALUE_IGNORE;
    private float mActiveOffsetYEnd = MAX_VALUE_IGNORE;
    private float mActiveOffsetYStart = MIN_VALUE_IGNORE;
    private boolean mAverageTouches;
    private float mFailOffsetXEnd = MIN_VALUE_IGNORE;
    private float mFailOffsetXStart = MAX_VALUE_IGNORE;
    private float mFailOffsetYEnd = MIN_VALUE_IGNORE;
    private float mFailOffsetYStart = MAX_VALUE_IGNORE;
    private float mLastVelocityX;
    private float mLastVelocityY;
    private float mLastX;
    private float mLastY;
    private int mMaxPointers = DEFAULT_MAX_POINTERS;
    private float mMinDistSq = MAX_VALUE_IGNORE;
    private int mMinPointers = DEFAULT_MIN_POINTERS;
    private float mMinVelocitySq = MIN_VALUE_IGNORE;
    private float mMinVelocityX = MIN_VALUE_IGNORE;
    private float mMinVelocityY = MIN_VALUE_IGNORE;
    private float mOffsetX;
    private float mOffsetY;
    private float mStartX;
    private float mStartY;
    private VelocityTracker mVelocityTracker;

    public PanGestureHandler(Context context) {
        context = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mMinDistSq = (float) (context * context);
    }

    public PanGestureHandler setActiveOffsetXStart(float f) {
        this.mActiveOffsetXStart = f;
        return this;
    }

    public PanGestureHandler setActiveOffsetXEnd(float f) {
        this.mActiveOffsetXEnd = f;
        return this;
    }

    public PanGestureHandler setFailOffsetXStart(float f) {
        this.mFailOffsetXStart = f;
        return this;
    }

    public PanGestureHandler setFailOffsetXEnd(float f) {
        this.mFailOffsetXEnd = f;
        return this;
    }

    public PanGestureHandler setActiveOffsetYStart(float f) {
        this.mActiveOffsetYStart = f;
        return this;
    }

    public PanGestureHandler setActiveOffsetYEnd(float f) {
        this.mActiveOffsetYEnd = f;
        return this;
    }

    public PanGestureHandler setFailOffsetYStart(float f) {
        this.mFailOffsetYStart = f;
        return this;
    }

    public PanGestureHandler setFailOffsetYEnd(float f) {
        this.mFailOffsetYEnd = f;
        return this;
    }

    public PanGestureHandler setMinDist(float f) {
        this.mMinDistSq = f * f;
        return this;
    }

    public PanGestureHandler setMinPointers(int i) {
        this.mMinPointers = i;
        return this;
    }

    public PanGestureHandler setMaxPointers(int i) {
        this.mMaxPointers = i;
        return this;
    }

    public PanGestureHandler setAverageTouches(boolean z) {
        this.mAverageTouches = z;
        return this;
    }

    public PanGestureHandler setMinVelocity(float f) {
        this.mMinVelocitySq = f * f;
        return this;
    }

    public PanGestureHandler setMinVelocityX(float f) {
        this.mMinVelocityX = f;
        return this;
    }

    public PanGestureHandler setMinVelocityY(float f) {
        this.mMinVelocityY = f;
        return this;
    }

    private boolean shouldActivate() {
        float f = (this.mLastX - this.mStartX) + this.mOffsetX;
        if (this.mActiveOffsetXStart != MIN_VALUE_IGNORE && f < this.mActiveOffsetXStart) {
            return true;
        }
        if (this.mActiveOffsetXEnd != MAX_VALUE_IGNORE && f > this.mActiveOffsetXEnd) {
            return true;
        }
        float f2 = (this.mLastY - this.mStartY) + this.mOffsetY;
        if (this.mActiveOffsetYStart != MIN_VALUE_IGNORE && f2 < this.mActiveOffsetYStart) {
            return true;
        }
        if (this.mActiveOffsetYEnd != MAX_VALUE_IGNORE && f2 > this.mActiveOffsetYEnd) {
            return true;
        }
        f = (f * f) + (f2 * f2);
        if (this.mMinDistSq != MIN_VALUE_IGNORE && f >= this.mMinDistSq) {
            return true;
        }
        f = this.mLastVelocityX;
        if (this.mMinVelocityX != MIN_VALUE_IGNORE && ((this.mMinVelocityX < 0.0f && f <= this.mMinVelocityX) || (this.mMinVelocityX >= 0.0f && f >= this.mMinVelocityX))) {
            return true;
        }
        f2 = this.mLastVelocityY;
        if (this.mMinVelocityY != MIN_VALUE_IGNORE && ((this.mMinVelocityY < 0.0f && f <= this.mMinVelocityY) || (this.mMinVelocityY >= 0.0f && f >= this.mMinVelocityY))) {
            return true;
        }
        f = (f * f) + (f2 * f2);
        if (this.mMinVelocitySq == MIN_VALUE_IGNORE || f < this.mMinVelocitySq) {
            return false;
        }
        return true;
    }

    private boolean shouldFail() {
        float f = (this.mLastX - this.mStartX) + this.mOffsetX;
        if (this.mFailOffsetXStart != MAX_VALUE_IGNORE && f < this.mFailOffsetXStart) {
            return true;
        }
        if (this.mFailOffsetXEnd != MIN_VALUE_IGNORE && f > this.mFailOffsetXEnd) {
            return true;
        }
        f = (this.mLastY - this.mStartY) + this.mOffsetY;
        if (this.mFailOffsetYStart != MAX_VALUE_IGNORE && f < this.mFailOffsetYStart) {
            return true;
        }
        if (this.mFailOffsetYEnd == MIN_VALUE_IGNORE || f <= this.mFailOffsetYEnd) {
            return false;
        }
        return true;
    }

    protected void onHandle(MotionEvent motionEvent) {
        int state = getState();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 6) {
            if (actionMasked != 5) {
                this.mLastX = GestureUtils.getLastPointerX(motionEvent, this.mAverageTouches);
                this.mLastY = GestureUtils.getLastPointerY(motionEvent, this.mAverageTouches);
                if (state != 0 && motionEvent.getPointerCount() >= this.mMinPointers) {
                    this.mStartX = this.mLastX;
                    this.mStartY = this.mLastY;
                    this.mOffsetX = 0.0f;
                    this.mOffsetY = 0.0f;
                    this.mVelocityTracker = VelocityTracker.obtain();
                    addVelocityMovement(this.mVelocityTracker, motionEvent);
                    begin();
                } else if (this.mVelocityTracker != null) {
                    addVelocityMovement(this.mVelocityTracker, motionEvent);
                    this.mVelocityTracker.computeCurrentVelocity(1000);
                    this.mLastVelocityX = this.mVelocityTracker.getXVelocity();
                    this.mLastVelocityY = this.mVelocityTracker.getYVelocity();
                }
                if (actionMasked != 1) {
                    if (state != 4) {
                        end();
                    } else {
                        fail();
                    }
                } else if (actionMasked == 5 || motionEvent.getPointerCount() <= this.mMaxPointers) {
                    if (actionMasked != 6 && state == 4 && motionEvent.getPointerCount() < this.mMinPointers) {
                        fail();
                        return;
                    } else if (state != 2) {
                    } else {
                        if (shouldFail() != null) {
                            fail();
                        } else if (shouldActivate() != null) {
                            this.mStartX = this.mLastX;
                            this.mStartY = this.mLastY;
                            activate();
                        }
                    }
                } else if (state == 4) {
                    cancel();
                    return;
                } else {
                    fail();
                    return;
                }
            }
        }
        this.mOffsetX += this.mLastX - this.mStartX;
        this.mOffsetY += this.mLastY - this.mStartY;
        this.mLastX = GestureUtils.getLastPointerX(motionEvent, this.mAverageTouches);
        this.mLastY = GestureUtils.getLastPointerY(motionEvent, this.mAverageTouches);
        this.mStartX = this.mLastX;
        this.mStartY = this.mLastY;
        if (state != 0) {
        }
        if (this.mVelocityTracker != null) {
            addVelocityMovement(this.mVelocityTracker, motionEvent);
            this.mVelocityTracker.computeCurrentVelocity(1000);
            this.mLastVelocityX = this.mVelocityTracker.getXVelocity();
            this.mLastVelocityY = this.mVelocityTracker.getYVelocity();
        }
        if (actionMasked != 1) {
            if (actionMasked == 5) {
            }
            if (actionMasked != 6) {
            }
            if (state != 2) {
                if (shouldFail() != null) {
                    fail();
                } else if (shouldActivate() != null) {
                    this.mStartX = this.mLastX;
                    this.mStartY = this.mLastY;
                    activate();
                }
            }
        } else if (state != 4) {
            fail();
        } else {
            end();
        }
    }

    protected void onReset() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public float getTranslationX() {
        return (this.mLastX - this.mStartX) + this.mOffsetX;
    }

    public float getTranslationY() {
        return (this.mLastY - this.mStartY) + this.mOffsetY;
    }

    public float getVelocityX() {
        return this.mLastVelocityX;
    }

    public float getVelocityY() {
        return this.mLastVelocityY;
    }

    private static void addVelocityMovement(VelocityTracker velocityTracker, MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX() - motionEvent.getX();
        float rawY = motionEvent.getRawY() - motionEvent.getY();
        motionEvent.offsetLocation(rawX, rawY);
        velocityTracker.addMovement(motionEvent);
        motionEvent.offsetLocation(-rawX, -rawY);
    }
}
