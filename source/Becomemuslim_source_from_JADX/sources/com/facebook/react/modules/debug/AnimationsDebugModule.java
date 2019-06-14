package com.facebook.react.modules.debug;

import android.widget.Toast;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.ChoreographerCompat;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import java.util.Locale;

@ReactModule(name = "AnimationsDebugModule")
public class AnimationsDebugModule extends ReactContextBaseJavaModule {
    protected static final String NAME = "AnimationsDebugModule";
    private final DeveloperSettings mCatalystSettings;
    private FpsDebugFrameCallback mFrameCallback;

    public String getName() {
        return NAME;
    }

    public AnimationsDebugModule(ReactApplicationContext reactApplicationContext, DeveloperSettings developerSettings) {
        super(reactApplicationContext);
        this.mCatalystSettings = developerSettings;
    }

    @ReactMethod
    public void startRecordingFps() {
        if (this.mCatalystSettings != null) {
            if (this.mCatalystSettings.isAnimationFpsDebugEnabled()) {
                if (this.mFrameCallback == null) {
                    this.mFrameCallback = new FpsDebugFrameCallback(ChoreographerCompat.getInstance(), getReactApplicationContext());
                    this.mFrameCallback.startAndRecordFpsAtEachFrame();
                    return;
                }
                throw new JSApplicationCausedNativeException("Already recording FPS!");
            }
        }
    }

    @ReactMethod
    public void stopRecordingFps(double d) {
        if (this.mFrameCallback != null) {
            this.mFrameCallback.stop();
            if (this.mFrameCallback.getFpsInfo((long) d) == null) {
                Toast.makeText(getReactApplicationContext(), "Unable to get FPS info", 1);
            } else {
                String format = String.format(Locale.US, "FPS: %.2f, %d frames (%d expected)", new Object[]{Double.valueOf(this.mFrameCallback.getFpsInfo((long) d).fps), Integer.valueOf(this.mFrameCallback.getFpsInfo((long) d).totalFrames), Integer.valueOf(this.mFrameCallback.getFpsInfo((long) d).totalExpectedFrames)});
                String format2 = String.format(Locale.US, "JS FPS: %.2f, %d frames (%d expected)", new Object[]{Double.valueOf(d.jsFps), Integer.valueOf(d.totalJsFrames), Integer.valueOf(d.totalExpectedFrames)});
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(format);
                stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
                stringBuilder.append(format2);
                stringBuilder.append("\nTotal Time MS: ");
                stringBuilder.append(String.format(Locale.US, "%d", new Object[]{Integer.valueOf(d.totalTimeMs)}));
                String stringBuilder2 = stringBuilder.toString();
                FLog.m5662d(ReactConstants.TAG, stringBuilder2);
                Toast.makeText(getReactApplicationContext(), stringBuilder2, 1).show();
            }
            this.mFrameCallback = 0.0d;
        }
    }

    public void onCatalystInstanceDestroy() {
        if (this.mFrameCallback != null) {
            this.mFrameCallback.stop();
            this.mFrameCallback = null;
        }
    }
}
