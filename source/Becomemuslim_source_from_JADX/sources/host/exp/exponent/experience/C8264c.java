package host.exp.exponent.experience;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import expo.adapters.react.C7372e;
import expo.p304a.C6007d;
import expo.p304a.p305a.C5998e;
import expo.p304a.p305a.C6001h;
import host.exp.exponent.p339f.C6330b;
import host.exp.exponent.p346j.C6393j;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import versioned.host.exp.exponent.modules.universal.ConstantsBinding;
import versioned.host.exp.exponent.modules.universal.ExpoModuleRegistryAdapter;
import versioned.host.exp.exponent.modules.universal.ScopedFileSystemModule;
import versioned.host.exp.exponent.modules.universal.ScopedUIManagerModuleWrapper;

/* compiled from: DetachedModuleRegistryAdapter */
/* renamed from: host.exp.exponent.experience.c */
public class C8264c extends ExpoModuleRegistryAdapter {
    /* renamed from: a */
    protected void m42871a(C6007d c6007d, ReactApplicationContext reactApplicationContext) {
    }

    public C8264c(C7372e c7372e) {
        super(c7372e);
    }

    public List<NativeModule> createNativeModules(C6393j c6393j, C6330b c6330b, Map<String, Object> map, JSONObject jSONObject, List<NativeModule> list) {
        ReactApplicationContext reactApplicationContext = (ReactApplicationContext) c6393j.m26224a();
        C6007d a = this.mModuleRegistryProvider.mo5139a(c6393j);
        a.m25136a(new ConstantsBinding(c6393j, map, jSONObject));
        ReactApplicationContext reactApplicationContext2 = (ReactApplicationContext) c6393j.m26224a();
        for (C5998e a2 : this.mReactAdapterPackage.createInternalModules(reactApplicationContext2)) {
            a.m25136a(a2);
        }
        a.m25136a(new ScopedUIManagerModuleWrapper(reactApplicationContext2, c6330b, jSONObject.optString("name")));
        a.m25139a(new ScopedFileSystemModule(c6393j));
        for (NativeModule nativeModule : list) {
            if ((nativeModule instanceof C6001h) != null) {
                a.m25137a((C6001h) nativeModule);
            }
        }
        m42871a(a, reactApplicationContext);
        return getNativeModulesFromModuleRegistry(reactApplicationContext, a);
    }
}
