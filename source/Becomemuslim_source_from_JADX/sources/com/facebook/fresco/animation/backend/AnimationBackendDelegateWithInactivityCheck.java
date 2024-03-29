package com.facebook.fresco.animation.backend;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.time.MonotonicClock;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AnimationBackendDelegateWithInactivityCheck<T extends AnimationBackend> extends AnimationBackendDelegate<T> {
    @VisibleForTesting
    static final long INACTIVITY_CHECK_POLLING_TIME_MS = 1000;
    @VisibleForTesting
    static final long INACTIVITY_THRESHOLD_MS = 2000;
    private long mInactivityCheckPollingTimeMs = INACTIVITY_CHECK_POLLING_TIME_MS;
    private boolean mInactivityCheckScheduled = null;
    private InactivityListener mInactivityListener;
    private long mInactivityThresholdMs = INACTIVITY_THRESHOLD_MS;
    private final Runnable mIsInactiveCheck = new C17521();
    private long mLastDrawnTimeMs;
    private final MonotonicClock mMonotonicClock;
    private final ScheduledExecutorService mScheduledExecutorServiceForUiThread;

    /* renamed from: com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck$1 */
    class C17521 implements Runnable {
        C17521() {
        }

        public void run() {
            synchronized (AnimationBackendDelegateWithInactivityCheck.this) {
                AnimationBackendDelegateWithInactivityCheck.this.mInactivityCheckScheduled = false;
                if (!AnimationBackendDelegateWithInactivityCheck.this.isInactive()) {
                    AnimationBackendDelegateWithInactivityCheck.this.maybeScheduleInactivityCheck();
                } else if (AnimationBackendDelegateWithInactivityCheck.this.mInactivityListener != null) {
                    AnimationBackendDelegateWithInactivityCheck.this.mInactivityListener.onInactive();
                }
            }
        }
    }

    public interface InactivityListener {
        void onInactive();
    }

    public static <T extends AnimationBackend & InactivityListener> AnimationBackendDelegate<T> createForBackend(T t, MonotonicClock monotonicClock, ScheduledExecutorService scheduledExecutorService) {
        return createForBackend(t, (InactivityListener) t, monotonicClock, scheduledExecutorService);
    }

    public static <T extends AnimationBackend> AnimationBackendDelegate<T> createForBackend(T t, InactivityListener inactivityListener, MonotonicClock monotonicClock, ScheduledExecutorService scheduledExecutorService) {
        return new AnimationBackendDelegateWithInactivityCheck(t, inactivityListener, monotonicClock, scheduledExecutorService);
    }

    private AnimationBackendDelegateWithInactivityCheck(T t, InactivityListener inactivityListener, MonotonicClock monotonicClock, ScheduledExecutorService scheduledExecutorService) {
        super(t);
        this.mInactivityListener = inactivityListener;
        this.mMonotonicClock = monotonicClock;
        this.mScheduledExecutorServiceForUiThread = scheduledExecutorService;
    }

    public boolean drawFrame(Drawable drawable, Canvas canvas, int i) {
        this.mLastDrawnTimeMs = this.mMonotonicClock.now();
        drawable = super.drawFrame(drawable, canvas, i);
        maybeScheduleInactivityCheck();
        return drawable;
    }

    public void setInactivityListener(InactivityListener inactivityListener) {
        this.mInactivityListener = inactivityListener;
    }

    public long getInactivityCheckPollingTimeMs() {
        return this.mInactivityCheckPollingTimeMs;
    }

    public void setInactivityCheckPollingTimeMs(long j) {
        this.mInactivityCheckPollingTimeMs = j;
    }

    public long getInactivityThresholdMs() {
        return this.mInactivityThresholdMs;
    }

    public void setInactivityThresholdMs(long j) {
        this.mInactivityThresholdMs = j;
    }

    private boolean isInactive() {
        return this.mMonotonicClock.now() - this.mLastDrawnTimeMs > this.mInactivityThresholdMs;
    }

    private synchronized void maybeScheduleInactivityCheck() {
        if (!this.mInactivityCheckScheduled) {
            this.mInactivityCheckScheduled = true;
            this.mScheduledExecutorServiceForUiThread.schedule(this.mIsInactiveCheck, this.mInactivityCheckPollingTimeMs, TimeUnit.MILLISECONDS);
        }
    }
}
