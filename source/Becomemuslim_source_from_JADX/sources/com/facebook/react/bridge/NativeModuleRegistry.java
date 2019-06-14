package com.facebook.react.bridge;

import com.facebook.systrace.Systrace;
import expolib_v1.com.facebook.infer.annotation.Assertions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class NativeModuleRegistry {
    private final Map<String, ModuleHolder> mModules;
    private final ReactApplicationContext mReactApplicationContext;

    public NativeModuleRegistry(ReactApplicationContext reactApplicationContext, Map<String, ModuleHolder> map) {
        this.mReactApplicationContext = reactApplicationContext;
        this.mModules = map;
    }

    private Map<String, ModuleHolder> getModuleMap() {
        return this.mModules;
    }

    private ReactApplicationContext getReactApplicationContext() {
        return this.mReactApplicationContext;
    }

    Collection<JavaModuleWrapper> getJavaModules(JSInstance jSInstance) {
        Collection arrayList = new ArrayList();
        for (Entry entry : this.mModules.entrySet()) {
            String str = (String) entry.getKey();
            if (!((ModuleHolder) entry.getValue()).isCxxModule()) {
                arrayList.add(new JavaModuleWrapper(jSInstance, str, (ModuleHolder) entry.getValue()));
            }
        }
        return arrayList;
    }

    Collection<ModuleHolder> getCxxModules() {
        Collection arrayList = new ArrayList();
        for (Entry entry : this.mModules.entrySet()) {
            if (((ModuleHolder) entry.getValue()).isCxxModule()) {
                arrayList.add(entry.getValue());
            }
        }
        return arrayList;
    }

    void registerModules(NativeModuleRegistry nativeModuleRegistry) {
        Assertions.assertCondition(this.mReactApplicationContext.equals(nativeModuleRegistry.getReactApplicationContext()), "Extending native modules with non-matching application contexts.");
        for (Entry entry : nativeModuleRegistry.getModuleMap().entrySet()) {
            String str = (String) entry.getKey();
            if (!this.mModules.containsKey(str)) {
                this.mModules.put(str, (ModuleHolder) entry.getValue());
            }
        }
    }

    void notifyJSInstanceDestroy() {
        this.mReactApplicationContext.assertOnNativeModulesQueueThread();
        Systrace.beginSection(0, "NativeModuleRegistry_notifyJSInstanceDestroy");
        try {
            for (ModuleHolder destroy : this.mModules.values()) {
                destroy.destroy();
            }
        } finally {
            Systrace.endSection(0);
        }
    }

    void notifyJSInstanceInitialized() {
        this.mReactApplicationContext.assertOnNativeModulesQueueThread("From version React Native v0.44, native modules are explicitly not initialized on the UI thread. See https://github.com/facebook/react-native/wiki/Breaking-Changes#d4611211-reactnativeandroidbreaking-move-nativemodule-initialization-off-ui-thread---aaachiuuu  for more details.");
        ReactMarker.logMarker(ReactMarkerConstants.NATIVE_MODULE_INITIALIZE_START);
        Systrace.beginSection(0, "NativeModuleRegistry_notifyJSInstanceInitialized");
        try {
            for (ModuleHolder markInitializable : this.mModules.values()) {
                markInitializable.markInitializable();
            }
        } finally {
            Systrace.endSection(0);
            ReactMarker.logMarker(ReactMarkerConstants.NATIVE_MODULE_INITIALIZE_END);
        }
    }

    public void onBatchComplete() {
        ModuleHolder moduleHolder = (ModuleHolder) this.mModules.get("com.facebook.react.uimanager.UIManagerModule");
        if (moduleHolder != null && moduleHolder.hasInstance()) {
            ((OnBatchCompleteListener) moduleHolder.getModule()).onBatchComplete();
        }
    }

    public <T extends NativeModule> boolean hasModule(Class<T> cls) {
        return this.mModules.containsKey(cls.getName());
    }

    public <T extends NativeModule> T getModule(Class<T> cls) {
        return ((ModuleHolder) Assertions.assertNotNull(this.mModules.get(cls.getName()), cls.getSimpleName())).getModule();
    }

    public List<NativeModule> getAllModules() {
        List<NativeModule> arrayList = new ArrayList();
        for (ModuleHolder module : this.mModules.values()) {
            arrayList.add(module.getModule());
        }
        return arrayList;
    }
}
