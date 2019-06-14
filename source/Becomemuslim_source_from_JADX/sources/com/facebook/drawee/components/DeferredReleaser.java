package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.Preconditions;
import java.util.HashSet;
import java.util.Set;

public class DeferredReleaser {
    private static DeferredReleaser sInstance;
    private final Set<Releasable> mPendingReleasables = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());
    private final Runnable releaseRunnable = new C17471();

    /* renamed from: com.facebook.drawee.components.DeferredReleaser$1 */
    class C17471 implements Runnable {
        C17471() {
        }

        public void run() {
            DeferredReleaser.ensureOnUiThread();
            for (Releasable release : DeferredReleaser.this.mPendingReleasables) {
                release.release();
            }
            DeferredReleaser.this.mPendingReleasables.clear();
        }
    }

    public interface Releasable {
        void release();
    }

    public static synchronized DeferredReleaser getInstance() {
        DeferredReleaser deferredReleaser;
        synchronized (DeferredReleaser.class) {
            if (sInstance == null) {
                sInstance = new DeferredReleaser();
            }
            deferredReleaser = sInstance;
        }
        return deferredReleaser;
    }

    public void scheduleDeferredRelease(Releasable releasable) {
        ensureOnUiThread();
        if (this.mPendingReleasables.add(releasable) != null && this.mPendingReleasables.size() == 1) {
            this.mUiHandler.post(this.releaseRunnable);
        }
    }

    public void cancelDeferredRelease(Releasable releasable) {
        ensureOnUiThread();
        this.mPendingReleasables.remove(releasable);
    }

    private static void ensureOnUiThread() {
        Preconditions.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
