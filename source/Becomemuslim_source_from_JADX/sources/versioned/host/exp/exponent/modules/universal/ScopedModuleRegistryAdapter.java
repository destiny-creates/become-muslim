package versioned.host.exp.exponent.modules.universal;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import host.exp.exponent.p339f.C6330b;
import host.exp.exponent.p346j.C6393j;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public interface ScopedModuleRegistryAdapter {
    List<NativeModule> createNativeModules(C6393j c6393j, C6330b c6330b, Map<String, Object> map, JSONObject jSONObject, List<NativeModule> list);

    List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext);
}
