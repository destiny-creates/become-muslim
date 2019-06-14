package versioned.host.exp.exponent.modules.api.components.svg;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

class SvgViewModule extends ReactContextBaseJavaModule {
    public String getName() {
        return "RNSVGSvgViewManager";
    }

    SvgViewModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void toDataURL(int i, Callback callback) {
        if (SvgViewManager.getSvgViewByTag(i) != 0) {
            callback.invoke(new Object[]{SvgViewManager.getSvgViewByTag(i).toDataURL()});
        }
    }
}
