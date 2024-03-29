package com.facebook.react.modules.core;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;

public class ChoreographerCompat {
    private static final ChoreographerCompat INSTANCE = new ChoreographerCompat();
    private static final boolean IS_JELLYBEAN_OR_HIGHER = (VERSION.SDK_INT >= 16);
    private static final long ONE_FRAME_MILLIS = 17;
    private Choreographer mChoreographer;
    private Handler mHandler;

    public static abstract class FrameCallback {
        private android.view.Choreographer.FrameCallback mFrameCallback;
        private Runnable mRunnable;

        /* renamed from: com.facebook.react.modules.core.ChoreographerCompat$FrameCallback$1 */
        class C19361 implements android.view.Choreographer.FrameCallback {
            C19361() {
            }

            public void doFrame(long j) {
                FrameCallback.this.doFrame(j);
            }
        }

        /* renamed from: com.facebook.react.modules.core.ChoreographerCompat$FrameCallback$2 */
        class C19372 implements Runnable {
            C19372() {
            }

            public void run() {
                FrameCallback.this.doFrame(System.nanoTime());
            }
        }

        public abstract void doFrame(long j);

        @TargetApi(16)
        android.view.Choreographer.FrameCallback getFrameCallback() {
            if (this.mFrameCallback == null) {
                this.mFrameCallback = new C19361();
            }
            return this.mFrameCallback;
        }

        Runnable getRunnable() {
            if (this.mRunnable == null) {
                this.mRunnable = new C19372();
            }
            return this.mRunnable;
        }
    }

    public static ChoreographerCompat getInstance() {
        return INSTANCE;
    }

    private ChoreographerCompat() {
        if (IS_JELLYBEAN_OR_HIGHER) {
            this.mChoreographer = getChoreographer();
        } else {
            this.mHandler = new Handler(Looper.getMainLooper());
        }
    }

    public void postFrameCallback(FrameCallback frameCallback) {
        if (IS_JELLYBEAN_OR_HIGHER) {
            choreographerPostFrameCallback(frameCallback.getFrameCallback());
        } else {
            this.mHandler.postDelayed(frameCallback.getRunnable(), 0);
        }
    }

    public void postFrameCallbackDelayed(FrameCallback frameCallback, long j) {
        if (IS_JELLYBEAN_OR_HIGHER) {
            choreographerPostFrameCallbackDelayed(frameCallback.getFrameCallback(), j);
        } else {
            this.mHandler.postDelayed(frameCallback.getRunnable(), j + ONE_FRAME_MILLIS);
        }
    }

    public void removeFrameCallback(FrameCallback frameCallback) {
        if (IS_JELLYBEAN_OR_HIGHER) {
            choreographerRemoveFrameCallback(frameCallback.getFrameCallback());
        } else {
            this.mHandler.removeCallbacks(frameCallback.getRunnable());
        }
    }

    @TargetApi(16)
    private Choreographer getChoreographer() {
        return Choreographer.getInstance();
    }

    @TargetApi(16)
    private void choreographerPostFrameCallback(android.view.Choreographer.FrameCallback frameCallback) {
        this.mChoreographer.postFrameCallback(frameCallback);
    }

    @TargetApi(16)
    private void choreographerPostFrameCallbackDelayed(android.view.Choreographer.FrameCallback frameCallback, long j) {
        this.mChoreographer.postFrameCallbackDelayed(frameCallback, j);
    }

    @TargetApi(16)
    private void choreographerRemoveFrameCallback(android.view.Choreographer.FrameCallback frameCallback) {
        this.mChoreographer.removeFrameCallback(frameCallback);
    }
}
