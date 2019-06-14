package versioned.host.exp.exponent.modules.universal;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import expo.adapters.react.C7370b;
import expo.adapters.react.C7372e;
import expo.adapters.react.C8157d;
import expo.adapters.react.ModuleRegistryReadyNotifier;
import expo.adapters.react.NativeModulesProxy;
import expo.p304a.C6007d;
import expo.p304a.p305a.C5998e;
import expo.p304a.p305a.C6001h;
import host.exp.exponent.p339f.C6330b;
import host.exp.exponent.p346j.C6393j;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import versioned.host.exp.exponent.modules.universal.sensors.ScopedAccelerometerService;
import versioned.host.exp.exponent.modules.universal.sensors.ScopedGravitySensorService;
import versioned.host.exp.exponent.modules.universal.sensors.ScopedGyroscopeService;
import versioned.host.exp.exponent.modules.universal.sensors.ScopedLinearAccelerationSensorService;
import versioned.host.exp.exponent.modules.universal.sensors.ScopedMagnetometerService;
import versioned.host.exp.exponent.modules.universal.sensors.ScopedMagnetometerUncalibratedService;
import versioned.host.exp.exponent.modules.universal.sensors.ScopedRotationVectorSensorService;

public class ExpoModuleRegistryAdapter extends C7370b implements ScopedModuleRegistryAdapter {
    protected C8157d mReactAdapterPackage = new C8157d();

    public ExpoModuleRegistryAdapter(C7372e c7372e) {
        super(c7372e);
    }

    public List<NativeModule> createNativeModules(C6393j c6393j, C6330b c6330b, Map<String, Object> map, JSONObject jSONObject, List<NativeModule> list) {
        C6007d a = this.mModuleRegistryProvider.mo5139a(c6393j);
        a.m25136a(new ScopedAccelerometerService(c6330b));
        a.m25136a(new ScopedGravitySensorService(c6330b));
        a.m25136a(new ScopedGyroscopeService(c6330b));
        a.m25136a(new ScopedLinearAccelerationSensorService(c6330b));
        a.m25136a(new ScopedMagnetometerService(c6330b));
        a.m25136a(new ScopedMagnetometerUncalibratedService(c6330b));
        a.m25136a(new ScopedRotationVectorSensorService(c6330b));
        a.m25136a(new PermissionsServiceBinding(c6393j, c6330b));
        a.m25136a(new ConstantsBinding(c6393j, map, jSONObject));
        a.m25136a(new ScopedFilePermissionModule(c6393j));
        a.m25139a(new ScopedFileSystemModule(c6393j));
        ReactApplicationContext reactApplicationContext = (ReactApplicationContext) c6393j.m26224a();
        map = this.mReactAdapterPackage.createInternalModules(reactApplicationContext).iterator();
        while (map.hasNext()) {
            a.m25136a((C5998e) map.next());
        }
        a.m25136a(new ScopedUIManagerModuleWrapper(reactApplicationContext, c6330b, jSONObject.optString("name")));
        for (NativeModule nativeModule : list) {
            if ((nativeModule instanceof C6001h) != null) {
                a.m25137a((C6001h) nativeModule);
            }
        }
        return getNativeModulesFromModuleRegistry(reactApplicationContext, a);
    }

    protected List<NativeModule> getNativeModulesFromModuleRegistry(ReactApplicationContext reactApplicationContext, C6007d c6007d) {
        List<NativeModule> arrayList = new ArrayList(2);
        arrayList.add(new NativeModulesProxy(reactApplicationContext, c6007d));
        arrayList.add(new ModuleRegistryReadyNotifier(c6007d));
        return arrayList;
    }

    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        throw new RuntimeException("Use createNativeModules(ReactApplicationContext, ExperienceId, JSONObject, List<NativeModule>) to get a list of native modules.");
    }
}
