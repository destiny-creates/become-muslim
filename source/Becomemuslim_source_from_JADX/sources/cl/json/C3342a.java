package cl.json;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: RNSharePackage */
/* renamed from: cl.json.a */
public class C3342a implements ReactPackage {
    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new NativeModule[]{new RNShareModule(reactApplicationContext)});
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }
}
