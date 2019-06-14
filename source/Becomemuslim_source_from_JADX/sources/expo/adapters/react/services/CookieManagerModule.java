package expo.adapters.react.services;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.network.ForwardingCookieHandler;
import expo.p304a.p305a.C5998e;
import java.net.CookieHandler;
import java.util.Collections;
import java.util.List;

public class CookieManagerModule extends ForwardingCookieHandler implements NativeModule, C5998e {
    private static final String TAG = "CookieManagerModule";

    public boolean canOverrideExistingModule() {
        return false;
    }

    public String getName() {
        return null;
    }

    public void initialize() {
    }

    public void onCatalystInstanceDestroy() {
    }

    public CookieManagerModule(ReactContext reactContext) {
        super(reactContext);
    }

    public List<Class> getExportedInterfaces() {
        return Collections.singletonList(CookieHandler.class);
    }
}
