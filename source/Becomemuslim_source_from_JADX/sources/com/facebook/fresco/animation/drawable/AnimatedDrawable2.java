package com.facebook.fresco.animation.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.common.logging.FLog;
import com.facebook.drawable.base.DrawableWithCaches;
import com.facebook.drawee.drawable.DrawableProperties;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.frame.DropFramesFrameScheduler;
import com.facebook.fresco.animation.frame.FrameScheduler;

public class AnimatedDrawable2 extends Drawable implements Animatable, DrawableWithCaches {
    private static final int DEFAULT_FRAME_SCHEDULING_DELAY_MS = 8;
    private static final int DEFAULT_FRAME_SCHEDULING_OFFSET_MS = 0;
    private static final AnimationListener NO_OP_LISTENER = new BaseAnimationListener();
    private static final Class<?> TAG = AnimatedDrawable2.class;
    private AnimationBackend mAnimationBackend;
    private volatile AnimationListener mAnimationListener;
    private volatile DrawListener mDrawListener;
    private DrawableProperties mDrawableProperties;
    private int mDroppedFrames;
    private long mExpectedRenderTimeMs;
    private FrameScheduler mFrameScheduler;
    private long mFrameSchedulingDelayMs;
    private long mFrameSchedulingOffsetMs;
    private final Runnable mInvalidateRunnable;
    private volatile boolean mIsRunning;
    private int mLastDrawnFrameNumber;
    private long mLastFrameAnimationTimeMs;
    private long mStartTimeMs;

    /* renamed from: com.facebook.fresco.animation.drawable.AnimatedDrawable2$1 */
    class C17531 implements Runnable {
        C17531() {
        }

        public void run() {
            AnimatedDrawable2.this.unscheduleSelf(AnimatedDrawable2.this.mInvalidateRunnable);
            AnimatedDrawable2.this.invalidateSelf();
        }
    }

    public interface DrawListener {
        void onDraw(AnimatedDrawable2 animatedDrawable2, FrameScheduler frameScheduler, int i, boolean z, boolean z2, long j, long j2, long j3, long j4, long j5, long j6, long j7);
    }

    public int getOpacity() {
        return -3;
    }

    public AnimatedDrawable2() {
        this(null);
    }

    public AnimatedDrawable2(AnimationBackend animationBackend) {
        this.mFrameSchedulingDelayMs = 8;
        this.mFrameSchedulingOffsetMs = 0;
        this.mAnimationListener = NO_OP_LISTENER;
        this.mDrawListener = null;
        this.mInvalidateRunnable = new C17531();
        this.mAnimationBackend = animationBackend;
        this.mFrameScheduler = createSchedulerForBackendAndDelayMethod(this.mAnimationBackend);
    }

    public int getIntrinsicWidth() {
        if (this.mAnimationBackend == null) {
            return super.getIntrinsicWidth();
        }
        return this.mAnimationBackend.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        if (this.mAnimationBackend == null) {
            return super.getIntrinsicHeight();
        }
        return this.mAnimationBackend.getIntrinsicHeight();
    }

    public void start() {
        if (!(this.mIsRunning || this.mAnimationBackend == null)) {
            if (this.mAnimationBackend.getFrameCount() > 1) {
                this.mIsRunning = true;
                this.mStartTimeMs = now();
                this.mExpectedRenderTimeMs = this.mStartTimeMs;
                this.mLastFrameAnimationTimeMs = -1;
                this.mLastDrawnFrameNumber = -1;
                invalidateSelf();
                this.mAnimationListener.onAnimationStart(this);
            }
        }
    }

    public void stop() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            this.mStartTimeMs = 0;
            this.mExpectedRenderTimeMs = this.mStartTimeMs;
            this.mLastFrameAnimationTimeMs = -1;
            this.mLastDrawnFrameNumber = -1;
            unscheduleSelf(this.mInvalidateRunnable);
            this.mAnimationListener.onAnimationStop(this);
        }
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.mAnimationBackend != null) {
            this.mAnimationBackend.setBounds(rect);
        }
    }

    public void draw(Canvas canvas) {
        if (this.mAnimationBackend != null) {
            if (r14.mFrameScheduler != null) {
                long j;
                long j2;
                long j3;
                long j4;
                long now = now();
                if (r14.mIsRunning) {
                    j = (now - r14.mStartTimeMs) + r14.mFrameSchedulingOffsetMs;
                } else {
                    j = Math.max(r14.mLastFrameAnimationTimeMs, 0);
                }
                long j5 = j;
                int frameNumberToRender = r14.mFrameScheduler.getFrameNumberToRender(j5, r14.mLastFrameAnimationTimeMs);
                if (frameNumberToRender == -1) {
                    frameNumberToRender = r14.mAnimationBackend.getFrameCount() - 1;
                    r14.mAnimationListener.onAnimationStop(r14);
                    r14.mIsRunning = false;
                } else if (frameNumberToRender == 0 && r14.mLastDrawnFrameNumber != -1 && now >= r14.mExpectedRenderTimeMs) {
                    r14.mAnimationListener.onAnimationRepeat(r14);
                }
                int i = frameNumberToRender;
                boolean drawFrame = r14.mAnimationBackend.drawFrame(r14, canvas, i);
                if (drawFrame) {
                    r14.mAnimationListener.onAnimationFrame(r14, i);
                    r14.mLastDrawnFrameNumber = i;
                }
                if (!drawFrame) {
                    onFrameDropped();
                }
                long now2 = now();
                if (r14.mIsRunning) {
                    long targetRenderTimeForNextFrameMs = r14.mFrameScheduler.getTargetRenderTimeForNextFrameMs(now2 - r14.mStartTimeMs);
                    if (targetRenderTimeForNextFrameMs != -1) {
                        j = r14.mFrameSchedulingDelayMs + targetRenderTimeForNextFrameMs;
                        scheduleNextFrame(j);
                        j2 = j;
                    } else {
                        j2 = -1;
                    }
                    j3 = targetRenderTimeForNextFrameMs;
                } else {
                    j3 = -1;
                    j2 = j3;
                }
                DrawListener drawListener = r14.mDrawListener;
                if (drawListener != null) {
                    long j6 = j5;
                    drawListener.onDraw(this, r14.mFrameScheduler, i, drawFrame, r14.mIsRunning, r14.mStartTimeMs, j5, r14.mLastFrameAnimationTimeMs, now, now2, j3, j2);
                    j4 = j6;
                } else {
                    j4 = j5;
                }
                this.mLastFrameAnimationTimeMs = j4;
                return;
            }
        }
        Drawable drawable = r14;
    }

    public void setAlpha(int i) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new DrawableProperties();
        }
        this.mDrawableProperties.setAlpha(i);
        if (this.mAnimationBackend != null) {
            this.mAnimationBackend.setAlpha(i);
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mDrawableProperties == null) {
            this.mDrawableProperties = new DrawableProperties();
        }
        this.mDrawableProperties.setColorFilter(colorFilter);
        if (this.mAnimationBackend != null) {
            this.mAnimationBackend.setColorFilter(colorFilter);
        }
    }

    public void setAnimationBackend(AnimationBackend animationBackend) {
        this.mAnimationBackend = animationBackend;
        if (this.mAnimationBackend != null) {
            this.mFrameScheduler = new DropFramesFrameScheduler(this.mAnimationBackend);
            this.mAnimationBackend.setBounds(getBounds());
            if (this.mDrawableProperties != null) {
                this.mDrawableProperties.applyTo(this);
            }
        }
        this.mFrameScheduler = createSchedulerForBackendAndDelayMethod(this.mAnimationBackend);
        stop();
    }

    public AnimationBackend getAnimationBackend() {
        return this.mAnimationBackend;
    }

    public long getDroppedFrames() {
        return (long) this.mDroppedFrames;
    }

    public long getStartTimeMs() {
        return this.mStartTimeMs;
    }

    public boolean isInfiniteAnimation() {
        return this.mFrameScheduler != null && this.mFrameScheduler.isInfiniteAnimation();
    }

    public void jumpToFrame(int i) {
        if (this.mAnimationBackend != null) {
            if (this.mFrameScheduler != null) {
                this.mLastFrameAnimationTimeMs = this.mFrameScheduler.getTargetRenderTimeMs(i);
                this.mStartTimeMs = now() - this.mLastFrameAnimationTimeMs;
                this.mExpectedRenderTimeMs = this.mStartTimeMs;
                invalidateSelf();
            }
        }
    }

    public long getLoopDurationMs() {
        if (this.mAnimationBackend == null) {
            return 0;
        }
        if (this.mFrameScheduler != null) {
            return this.mFrameScheduler.getLoopDurationMs();
        }
        int i = 0;
        for (int i2 = 0; i2 < this.mAnimationBackend.getFrameCount(); i2++) {
            i += this.mAnimationBackend.getFrameDurationMs(i2);
        }
        return (long) i;
    }

    public int getFrameCount() {
        return this.mAnimationBackend == null ? 0 : this.mAnimationBackend.getFrameCount();
    }

    public int getLoopCount() {
        if (this.mAnimationBackend == null) {
            return 0;
        }
        return this.mAnimationBackend.getLoopCount();
    }

    public void setFrameSchedulingDelayMs(long j) {
        this.mFrameSchedulingDelayMs = j;
    }

    public void setFrameSchedulingOffsetMs(long j) {
        this.mFrameSchedulingOffsetMs = j;
    }

    public void setAnimationListener(AnimationListener animationListener) {
        if (animationListener == null) {
            animationListener = NO_OP_LISTENER;
        }
        this.mAnimationListener = animationListener;
    }

    public void setDrawListener(DrawListener drawListener) {
        this.mDrawListener = drawListener;
    }

    private void scheduleNextFrame(long j) {
        this.mExpectedRenderTimeMs = this.mStartTimeMs + j;
        scheduleSelf(this.mInvalidateRunnable, this.mExpectedRenderTimeMs);
    }

    private void onFrameDropped() {
        this.mDroppedFrames++;
        if (FLog.isLoggable(2)) {
            FLog.m5695v(TAG, "Dropped a frame. Count: %s", Integer.valueOf(this.mDroppedFrames));
        }
    }

    private long now() {
        return SystemClock.uptimeMillis();
    }

    private static FrameScheduler createSchedulerForBackendAndDelayMethod(AnimationBackend animationBackend) {
        return animationBackend == null ? null : new DropFramesFrameScheduler(animationBackend);
    }

    protected boolean onLevelChange(int i) {
        if (this.mIsRunning) {
            return false;
        }
        long j = (long) i;
        if (this.mLastFrameAnimationTimeMs == j) {
            return false;
        }
        this.mLastFrameAnimationTimeMs = j;
        invalidateSelf();
        return true;
    }

    public void dropCaches() {
        if (this.mAnimationBackend != null) {
            this.mAnimationBackend.clear();
        }
    }
}
