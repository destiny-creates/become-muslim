package com.github.yamill.orientation;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.Arrays;
import java.util.List;

/* compiled from: OrientationPackage */
/* renamed from: com.github.yamill.orientation.a */
public class C3990a implements ReactPackage {
    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new NativeModule[]{new OrientationModule(reactApplicationContext)});
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new ViewManager[null]);
    }
}
