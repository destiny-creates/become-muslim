package com.facebook.fresco.animation.drawable;

import com.facebook.common.logging.FLog;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2.DrawListener;
import com.facebook.fresco.animation.frame.FrameScheduler;

public class AnimatedDrawable2DebugDrawListener implements DrawListener {
    private static final Class<?> TAG = AnimatedDrawable2DebugDrawListener.class;
    private int mDrawCalls;
    private int mDuplicateFrames;
    private int mLastFrameNumber = -1;
    private int mSkippedFrames;

    public void onDraw(AnimatedDrawable2 animatedDrawable2, FrameScheduler frameScheduler, int i, boolean z, boolean z2, long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        AnimatedDrawable2DebugDrawListener animatedDrawable2DebugDrawListener = this;
        int i2 = i;
        if (animatedDrawable2.getAnimationBackend() != null) {
            int frameCount = animatedDrawable2.getAnimationBackend().getFrameCount();
            long j8 = j2 - j3;
            animatedDrawable2DebugDrawListener.mDrawCalls++;
            int i3 = (animatedDrawable2DebugDrawListener.mLastFrameNumber + 1) % frameCount;
            if (i3 != i2) {
                if (animatedDrawable2DebugDrawListener.mLastFrameNumber == i2) {
                    animatedDrawable2DebugDrawListener.mDuplicateFrames++;
                } else {
                    i3 = (i2 - i3) % frameCount;
                    if (i3 < 0) {
                        i3 += frameCount;
                    }
                    animatedDrawable2DebugDrawListener.mSkippedFrames += i3;
                }
            }
            animatedDrawable2DebugDrawListener.mLastFrameNumber = i2;
            FLog.m5660d(TAG, "draw: frame: %2d, drawn: %b, delay: %3d ms, rendering: %3d ms, prev: %3d ms ago, duplicates: %3d, skipped: %3d, draw calls: %4d, anim time: %6d ms, next start: %6d ms, next scheduled: %6d ms", Integer.valueOf(i), Boolean.valueOf(z), Long.valueOf((j2 % frameScheduler.getLoopDurationMs()) - frameScheduler.getTargetRenderTimeMs(i)), Long.valueOf(j5 - j4), Long.valueOf(j8), Integer.valueOf(animatedDrawable2DebugDrawListener.mDuplicateFrames), Integer.valueOf(animatedDrawable2DebugDrawListener.mSkippedFrames), Integer.valueOf(animatedDrawable2DebugDrawListener.mDrawCalls), Long.valueOf(j2), Long.valueOf(j6), Long.valueOf(j7));
        }
    }
}
