package versioned.host.exp.exponent.modules.api.components.lottie;

import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.C0517s;
import android.util.Log;
import android.widget.ImageView.ScaleType;
import com.facebook.places.model.PlaceFields;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.p050a.p051a.C4530e;
import java.util.Map;
import org.json.JSONObject;

class LottieAnimationViewManager extends SimpleViewManager<C4530e> {
    private static final int COMMAND_PLAY = 1;
    private static final int COMMAND_RESET = 2;
    private static final String REACT_CLASS = "LottieAnimationView";
    private static final String TAG = "LottieAnimationViewManager";
    private static final int VERSION = 1;

    public String getName() {
        return REACT_CLASS;
    }

    LottieAnimationViewManager() {
    }

    public Map<String, Object> getExportedViewConstants() {
        return MapBuilder.builder().put("VERSION", Integer.valueOf(1)).build();
    }

    public C4530e createViewInstance(ThemedReactContext themedReactContext) {
        C4530e c4530e = new C4530e(themedReactContext);
        c4530e.setScaleType(ScaleType.CENTER_INSIDE);
        return c4530e;
    }

    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("play", Integer.valueOf(1), "reset", Integer.valueOf(2));
    }

    public void receiveCommand(final C4530e c4530e, int i, final ReadableArray readableArray) {
        switch (i) {
            case 1:
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        int i = readableArray.getInt(0);
                        int i2 = readableArray.getInt(1);
                        if (!(i == -1 || i2 == -1)) {
                            c4530e.a(readableArray.getInt(0), readableArray.getInt(1));
                        }
                        if (C0517s.A(c4530e)) {
                            c4530e.setProgress(0.0f);
                            c4530e.b();
                        }
                    }
                });
                return;
            case 2:
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        if (C0517s.A(c4530e)) {
                            c4530e.d();
                            c4530e.setProgress(0.0f);
                        }
                    }
                });
                return;
            default:
                return;
        }
    }

    @ReactProp(name = "sourceName")
    public void setSourceName(C4530e c4530e, String str) {
        c4530e.setAnimation(str);
    }

    @ReactProp(name = "sourceJson")
    public void setSourceJson(C4530e c4530e, String str) {
        try {
            c4530e.setAnimation(new JSONObject(str));
        } catch (C4530e c4530e2) {
            Log.e(TAG, "setSourceJsonError", c4530e2);
        }
    }

    @ReactProp(name = "resizeMode")
    public void setResizeMode(C4530e c4530e, String str) {
        if (PlaceFields.COVER.equals(str)) {
            c4530e.setScaleType(ScaleType.CENTER_CROP);
        } else if ("contain".equals(str)) {
            c4530e.setScaleType(ScaleType.CENTER_INSIDE);
        } else if ("center".equals(str) != null) {
            c4530e.setScaleType(ScaleType.CENTER);
        }
    }

    @ReactProp(name = "progress")
    public void setProgress(C4530e c4530e, float f) {
        c4530e.setProgress(f);
    }

    @ReactProp(name = "speed")
    public void setSpeed(C4530e c4530e, double d) {
        c4530e.setSpeed((float) d);
    }

    @ReactProp(name = "loop")
    public void setLoop(C4530e c4530e, boolean z) {
        c4530e.c(z);
    }

    @ReactProp(name = "hardwareAccelerationAndroid")
    public void setHardwareAcceleration(C4530e c4530e, boolean z) {
        c4530e.b(z);
    }

    @ReactProp(name = "imageAssetsFolder")
    public void setImageAssetsFolder(C4530e c4530e, String str) {
        c4530e.setImageAssetsFolder(str);
    }

    @ReactProp(name = "enableMergePathsAndroidForKitKatAndAbove")
    public void setEnableMergePaths(C4530e c4530e, boolean z) {
        c4530e.a(z);
    }
}
