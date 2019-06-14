package expo.modules.location.utils;

import android.os.Handler;

public class TimeoutObject {
    private boolean mIsDone = false;
    private TimeoutListener mListener;
    private Long mTimeout;

    /* renamed from: expo.modules.location.utils.TimeoutObject$1 */
    class C61121 implements Runnable {
        C61121() {
        }

        public void run() {
            synchronized (this) {
                if (!(TimeoutObject.this.mIsDone || TimeoutObject.this.mListener == null)) {
                    TimeoutObject.this.mListener.onTimeout();
                }
                TimeoutObject.this.mIsDone = true;
            }
        }
    }

    public interface TimeoutListener {
        void onTimeout();
    }

    public TimeoutObject(Long l) {
        this.mTimeout = l;
    }

    public void onTimeout(TimeoutListener timeoutListener) {
        this.mListener = timeoutListener;
    }

    public void start() {
        if (this.mTimeout != null) {
            new Handler().postDelayed(new C61121(), this.mTimeout.longValue());
        }
    }

    public boolean markDoneIfNotTimedOut() {
        synchronized (this) {
            if (this.mIsDone) {
                return false;
            }
            this.mIsDone = true;
            return true;
        }
    }
}
