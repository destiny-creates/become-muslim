package com.facebook.react.modules.core;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.modules.core.ChoreographerCompat.FrameCallback;
import expolib_v1.com.facebook.infer.annotation.Assertions;
import java.util.ArrayDeque;

public class ReactChoreographer {
    private static ReactChoreographer sInstance;
    private final ArrayDeque<FrameCallback>[] mCallbackQueues = new ArrayDeque[CallbackType.values().length];
    private final ChoreographerCompat mChoreographer = ChoreographerCompat.getInstance();
    private boolean mHasPostedCallback = false;
    private final ReactChoreographerDispatcher mReactChoreographerDispatcher = new ReactChoreographerDispatcher();
    private int mTotalCallbacks = 0;

    public enum CallbackType {
        PERF_MARKERS(0),
        DISPATCH_UI(1),
        NATIVE_ANIMATED_MODULE(2),
        TIMERS_EVENTS(3),
        IDLE_EVENT(4);
        
        private final int mOrder;

        private CallbackType(int i) {
            this.mOrder = i;
        }

        int getOrder() {
            return this.mOrder;
        }
    }

    private class ReactChoreographerDispatcher extends FrameCallback {
        private ReactChoreographerDispatcher() {
        }

        public void doFrame(long j) {
            synchronized (ReactChoreographer.this) {
                ReactChoreographer.this.mHasPostedCallback = false;
                for (int i = 0; i < ReactChoreographer.this.mCallbackQueues.length; i++) {
                    int size = ReactChoreographer.this.mCallbackQueues[i].size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((FrameCallback) ReactChoreographer.this.mCallbackQueues[i].removeFirst()).doFrame(j);
                        ReactChoreographer.this.mTotalCallbacks = ReactChoreographer.this.mTotalCallbacks - 1;
                    }
                }
                ReactChoreographer.this.maybeRemoveFrameCallback();
            }
        }
    }

    public static void initialize() {
        if (sInstance == null) {
            UiThreadUtil.assertOnUiThread();
            sInstance = new ReactChoreographer();
        }
    }

    public static ReactChoreographer getInstance() {
        Assertions.assertNotNull(sInstance, "ReactChoreographer needs to be initialized.");
        return sInstance;
    }

    private ReactChoreographer() {
        int i = 0;
        while (i < this.mCallbackQueues.length) {
            this.mCallbackQueues[i] = new ArrayDeque();
            i++;
        }
    }

    public synchronized void postFrameCallback(CallbackType callbackType, FrameCallback frameCallback) {
        this.mCallbackQueues[callbackType.getOrder()].addLast(frameCallback);
        this.mTotalCallbacks += 1;
        Assertions.assertCondition(this.mTotalCallbacks > null ? true : null);
        if (this.mHasPostedCallback == null) {
            this.mChoreographer.postFrameCallback(this.mReactChoreographerDispatcher);
            this.mHasPostedCallback = true;
        }
    }

    public synchronized void removeFrameCallback(CallbackType callbackType, FrameCallback frameCallback) {
        if (this.mCallbackQueues[callbackType.getOrder()].removeFirstOccurrence(frameCallback) != null) {
            this.mTotalCallbacks--;
            maybeRemoveFrameCallback();
        } else {
            FLog.m5674e(ReactConstants.TAG, "Tried to remove non-existent frame callback");
        }
    }

    private void maybeRemoveFrameCallback() {
        Assertions.assertCondition(this.mTotalCallbacks >= 0);
        if (this.mTotalCallbacks == 0 && this.mHasPostedCallback) {
            this.mChoreographer.removeFrameCallback(this.mReactChoreographerDispatcher);
            this.mHasPostedCallback = false;
        }
    }
}
