package com.facebook.react.modules.core;

import android.util.SparseArray;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.common.SystemClock;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.jstasks.HeadlessJsTaskContext;
import com.facebook.react.jstasks.HeadlessJsTaskEventListener;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.ChoreographerCompat.FrameCallback;
import com.facebook.react.modules.core.ReactChoreographer.CallbackType;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicBoolean;

@ReactModule(name = "Timing")
public final class Timing extends ReactContextBaseJavaModule implements LifecycleEventListener, HeadlessJsTaskEventListener {
    private static final float FRAME_DURATION_MS = 16.666666f;
    private static final float IDLE_CALLBACK_FRAME_DEADLINE_MS = 1.0f;
    protected static final String NAME = "Timing";
    private final AtomicBoolean isPaused = new AtomicBoolean(true);
    private final AtomicBoolean isRunningTasks = new AtomicBoolean(false);
    private IdleCallbackRunnable mCurrentIdleCallbackRunnable;
    private final DevSupportManager mDevSupportManager;
    private boolean mFrameCallbackPosted = false;
    private boolean mFrameIdleCallbackPosted = false;
    private final Object mIdleCallbackGuard = new Object();
    private final IdleFrameCallback mIdleFrameCallback = new IdleFrameCallback();
    private final ReactChoreographer mReactChoreographer;
    private boolean mSendIdleEvents = false;
    private final TimerFrameCallback mTimerFrameCallback = new TimerFrameCallback();
    private final Object mTimerGuard = new Object();
    private final SparseArray<Timer> mTimerIdsToTimers;
    private final PriorityQueue<Timer> mTimers;

    /* renamed from: com.facebook.react.modules.core.Timing$1 */
    class C19401 implements Comparator<Timer> {
        C19401() {
        }

        public int compare(Timer timer, Timer timer2) {
            timer = ((timer.mTargetTime - timer2.mTargetTime) > null ? 1 : ((timer.mTargetTime - timer2.mTargetTime) == null ? 0 : -1));
            if (timer == null) {
                return null;
            }
            return timer < null ? -1 : 1;
        }
    }

    private class IdleCallbackRunnable implements Runnable {
        private volatile boolean mCancelled = null;
        private final long mFrameStartTime;

        public IdleCallbackRunnable(long j) {
            this.mFrameStartTime = j;
        }

        public void run() {
            if (!this.mCancelled) {
                long uptimeMillis = SystemClock.uptimeMillis() - (this.mFrameStartTime / 1000000);
                long currentTimeMillis = SystemClock.currentTimeMillis() - uptimeMillis;
                if (Timing.FRAME_DURATION_MS - ((float) uptimeMillis) >= Timing.IDLE_CALLBACK_FRAME_DEADLINE_MS) {
                    boolean access$1400;
                    synchronized (Timing.this.mIdleCallbackGuard) {
                        access$1400 = Timing.this.mSendIdleEvents;
                    }
                    if (access$1400) {
                        ((JSTimers) Timing.this.getReactApplicationContext().getJSModule(JSTimers.class)).callIdleCallbacks((double) currentTimeMillis);
                    }
                    Timing.this.mCurrentIdleCallbackRunnable = null;
                }
            }
        }

        public void cancel() {
            this.mCancelled = true;
        }
    }

    private static class Timer {
        private final int mCallbackID;
        private final int mInterval;
        private final boolean mRepeat;
        private long mTargetTime;

        private Timer(int i, long j, int i2, boolean z) {
            this.mCallbackID = i;
            this.mTargetTime = j;
            this.mInterval = i2;
            this.mRepeat = z;
        }
    }

    private class IdleFrameCallback extends FrameCallback {
        private IdleFrameCallback() {
        }

        public void doFrame(long j) {
            if (!Timing.this.isPaused.get() || Timing.this.isRunningTasks.get()) {
                if (Timing.this.mCurrentIdleCallbackRunnable != null) {
                    Timing.this.mCurrentIdleCallbackRunnable.cancel();
                }
                Timing.this.mCurrentIdleCallbackRunnable = new IdleCallbackRunnable(j);
                Timing.this.getReactApplicationContext().runOnJSQueueThread(Timing.this.mCurrentIdleCallbackRunnable);
                Timing.this.mReactChoreographer.postFrameCallback(CallbackType.IDLE_EVENT, this);
            }
        }
    }

    private class TimerFrameCallback extends FrameCallback {
        private WritableArray mTimersToCall;

        private TimerFrameCallback() {
            this.mTimersToCall = null;
        }

        public void doFrame(long j) {
            if (!Timing.this.isPaused.get() || Timing.this.isRunningTasks.get()) {
                j /= 1000000;
                synchronized (Timing.this.mTimerGuard) {
                    while (!Timing.this.mTimers.isEmpty() && ((Timer) Timing.this.mTimers.peek()).mTargetTime < j) {
                        Timer timer = (Timer) Timing.this.mTimers.poll();
                        if (this.mTimersToCall == null) {
                            this.mTimersToCall = Arguments.createArray();
                        }
                        this.mTimersToCall.pushInt(timer.mCallbackID);
                        if (timer.mRepeat) {
                            timer.mTargetTime = ((long) timer.mInterval) + j;
                            Timing.this.mTimers.add(timer);
                        } else {
                            Timing.this.mTimerIdsToTimers.remove(timer.mCallbackID);
                        }
                    }
                }
                if (this.mTimersToCall != null) {
                    ((JSTimers) Timing.this.getReactApplicationContext().getJSModule(JSTimers.class)).callTimers(this.mTimersToCall);
                    this.mTimersToCall = 0;
                }
                Timing.this.mReactChoreographer.postFrameCallback(CallbackType.TIMERS_EVENTS, this);
            }
        }
    }

    public String getName() {
        return NAME;
    }

    public Timing(ReactApplicationContext reactApplicationContext, DevSupportManager devSupportManager) {
        super(reactApplicationContext);
        this.mDevSupportManager = devSupportManager;
        this.mTimers = new PriorityQueue(11, new C19401());
        this.mTimerIdsToTimers = new SparseArray();
        this.mReactChoreographer = ReactChoreographer.getInstance();
    }

    public void initialize() {
        getReactApplicationContext().addLifecycleEventListener(this);
        HeadlessJsTaskContext.getInstance(getReactApplicationContext()).addTaskEventListener(this);
    }

    public void onHostPause() {
        this.isPaused.set(true);
        clearFrameCallback();
        maybeIdleCallback();
    }

    public void onHostDestroy() {
        clearFrameCallback();
        maybeIdleCallback();
    }

    public void onHostResume() {
        this.isPaused.set(false);
        setChoreographerCallback();
        maybeSetChoreographerIdleCallback();
    }

    public void onHeadlessJsTaskStart(int i) {
        if (this.isRunningTasks.getAndSet(true) == 0) {
            setChoreographerCallback();
            maybeSetChoreographerIdleCallback();
        }
    }

    public void onHeadlessJsTaskFinish(int i) {
        if (HeadlessJsTaskContext.getInstance(getReactApplicationContext()).hasActiveTasks() == 0) {
            this.isRunningTasks.set(false);
            clearFrameCallback();
            maybeIdleCallback();
        }
    }

    public void onCatalystInstanceDestroy() {
        clearFrameCallback();
        clearChoreographerIdleCallback();
        HeadlessJsTaskContext.getInstance(getReactApplicationContext()).removeTaskEventListener(this);
    }

    private void maybeSetChoreographerIdleCallback() {
        synchronized (this.mIdleCallbackGuard) {
            if (this.mSendIdleEvents) {
                setChoreographerIdleCallback();
            }
        }
    }

    private void maybeIdleCallback() {
        if (this.isPaused.get() && !this.isRunningTasks.get()) {
            clearFrameCallback();
        }
    }

    private void setChoreographerCallback() {
        if (!this.mFrameCallbackPosted) {
            this.mReactChoreographer.postFrameCallback(CallbackType.TIMERS_EVENTS, this.mTimerFrameCallback);
            this.mFrameCallbackPosted = true;
        }
    }

    private void clearFrameCallback() {
        HeadlessJsTaskContext instance = HeadlessJsTaskContext.getInstance(getReactApplicationContext());
        if (this.mFrameCallbackPosted && this.isPaused.get() && !instance.hasActiveTasks()) {
            this.mReactChoreographer.removeFrameCallback(CallbackType.TIMERS_EVENTS, this.mTimerFrameCallback);
            this.mFrameCallbackPosted = false;
        }
    }

    private void setChoreographerIdleCallback() {
        if (!this.mFrameIdleCallbackPosted) {
            this.mReactChoreographer.postFrameCallback(CallbackType.IDLE_EVENT, this.mIdleFrameCallback);
            this.mFrameIdleCallbackPosted = true;
        }
    }

    private void clearChoreographerIdleCallback() {
        if (this.mFrameIdleCallbackPosted) {
            this.mReactChoreographer.removeFrameCallback(CallbackType.IDLE_EVENT, this.mIdleFrameCallback);
            this.mFrameIdleCallbackPosted = false;
        }
    }

    @ReactMethod
    public void createTimer(int i, int i2, double d, boolean z) {
        long currentTimeMillis = SystemClock.currentTimeMillis();
        d = (long) d;
        if (this.mDevSupportManager.getDevSupportEnabled() && Math.abs(d - currentTimeMillis) > 60000) {
            ((JSTimers) getReactApplicationContext().getJSModule(JSTimers.class)).emitTimeDriftWarning("Debugger and device times have drifted by more than 60s. Please correct this by running adb shell \"date `date +%m%d%H%M%Y.%S`\" on your debugger machine.");
        }
        d = Math.max(0, (d - currentTimeMillis) + ((long) i2));
        if (i2 != 0 || z) {
            Timer timer = new Timer(i, (SystemClock.nanoTime() / 1000000) + d, i2, z);
            synchronized (this.mTimerGuard) {
                this.mTimers.add(timer);
                this.mTimerIdsToTimers.put(i, timer);
            }
            return;
        }
        i2 = Arguments.createArray();
        i2.pushInt(i);
        ((JSTimers) getReactApplicationContext().getJSModule(JSTimers.class)).callTimers(i2);
    }

    @ReactMethod
    public void deleteTimer(int i) {
        synchronized (this.mTimerGuard) {
            Timer timer = (Timer) this.mTimerIdsToTimers.get(i);
            if (timer == null) {
                return;
            }
            this.mTimerIdsToTimers.remove(i);
            this.mTimers.remove(timer);
        }
    }

    @ReactMethod
    public void setSendIdleEvents(final boolean z) {
        synchronized (this.mIdleCallbackGuard) {
            this.mSendIdleEvents = z;
        }
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                synchronized (Timing.this.mIdleCallbackGuard) {
                    if (z) {
                        Timing.this.setChoreographerIdleCallback();
                    } else {
                        Timing.this.clearChoreographerIdleCallback();
                    }
                }
            }
        });
    }
}
