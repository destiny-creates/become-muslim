package com.facebook.react.devsupport;

import android.annotation.TargetApi;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.common.logging.FLog;
import com.facebook.react.C1864R;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.modules.core.ChoreographerCompat;
import com.facebook.react.modules.debug.FpsDebugFrameCallback;
import java.util.Locale;

@TargetApi(16)
public class FpsView extends FrameLayout {
    private static final int UPDATE_INTERVAL_MS = 500;
    private final FPSMonitorRunnable mFPSMonitorRunnable;
    private final FpsDebugFrameCallback mFrameCallback;
    private final TextView mTextView = ((TextView) findViewById(C1864R.id.fps_text));

    private class FPSMonitorRunnable implements Runnable {
        private boolean mShouldStop;
        private int mTotal4PlusFrameStutters;
        private int mTotalFramesDropped;

        private FPSMonitorRunnable() {
            this.mShouldStop = false;
            this.mTotalFramesDropped = 0;
            this.mTotal4PlusFrameStutters = 0;
        }

        public void run() {
            if (!this.mShouldStop) {
                this.mTotalFramesDropped += FpsView.this.mFrameCallback.getExpectedNumFrames() - FpsView.this.mFrameCallback.getNumFrames();
                this.mTotal4PlusFrameStutters += FpsView.this.mFrameCallback.get4PlusFrameStutters();
                FpsView.this.setCurrentFPS(FpsView.this.mFrameCallback.getFPS(), FpsView.this.mFrameCallback.getJSFPS(), this.mTotalFramesDropped, this.mTotal4PlusFrameStutters);
                FpsView.this.mFrameCallback.reset();
                FpsView.this.postDelayed(this, 500);
            }
        }

        public void start() {
            this.mShouldStop = false;
            FpsView.this.post(this);
        }

        public void stop() {
            this.mShouldStop = true;
        }
    }

    public FpsView(ReactContext reactContext) {
        super(reactContext);
        inflate(reactContext, C1864R.layout.fps_view, this);
        this.mFrameCallback = new FpsDebugFrameCallback(ChoreographerCompat.getInstance(), reactContext);
        this.mFPSMonitorRunnable = new FPSMonitorRunnable();
        setCurrentFPS(0.0d, 0.0d, 0, 0);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFrameCallback.reset();
        this.mFrameCallback.start();
        this.mFPSMonitorRunnable.start();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFrameCallback.stop();
        this.mFPSMonitorRunnable.stop();
    }

    private void setCurrentFPS(double d, double d2, int i, int i2) {
        String format = String.format(Locale.US, "UI: %.1f fps\n%d dropped so far\n%d stutters (4+) so far\nJS: %.1f fps", new Object[]{Double.valueOf(d), Integer.valueOf(i), Integer.valueOf(i2), Double.valueOf(d2)});
        this.mTextView.setText(format);
        FLog.m5662d(ReactConstants.TAG, format);
    }
}
