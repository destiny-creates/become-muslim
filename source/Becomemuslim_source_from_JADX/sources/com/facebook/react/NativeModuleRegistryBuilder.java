package com.facebook.react;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ModuleHolder;
import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.NativeModuleRegistry;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.module.model.ReactModuleInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class NativeModuleRegistryBuilder {
    private final Map<String, ModuleHolder> mModules = new HashMap();
    private final ReactApplicationContext mReactApplicationContext;
    private final ReactInstanceManager mReactInstanceManager;
    private final Map<String, String> namesToType = new HashMap();

    public NativeModuleRegistryBuilder(ReactApplicationContext reactApplicationContext, ReactInstanceManager reactInstanceManager) {
        this.mReactApplicationContext = reactApplicationContext;
        this.mReactInstanceManager = reactInstanceManager;
    }

    public void processPackage(ReactPackage reactPackage) {
        if (reactPackage instanceof LazyReactPackage) {
            LazyReactPackage lazyReactPackage = (LazyReactPackage) reactPackage;
            List nativeModules = lazyReactPackage.getNativeModules(this.mReactApplicationContext);
            reactPackage = lazyReactPackage.getReactModuleInfoProvider().getReactModuleInfos();
            Iterator it = nativeModules.iterator();
            while (it.hasNext()) {
                ModuleHolder moduleHolder;
                NativeModule nativeModule = (ModuleSpec) it.next();
                String className = nativeModule.getClassName();
                ReactModuleInfo reactModuleInfo = (ReactModuleInfo) reactPackage.get(className);
                if (reactModuleInfo == null) {
                    ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_START, nativeModule.getClassName());
                    try {
                        nativeModule = (NativeModule) nativeModule.getProvider().get();
                        moduleHolder = new ModuleHolder(nativeModule);
                    } finally {
                        it = ReactMarkerConstants.CREATE_MODULE_END;
                        ReactMarker.logMarker((ReactMarkerConstants) it);
                    }
                } else {
                    moduleHolder = new ModuleHolder(reactModuleInfo, nativeModule.getProvider());
                }
                putModuleTypeAndHolderToModuleMaps(className, moduleHolder.getName(), moduleHolder);
            }
            return;
        }
        String str = ReactConstants.TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(reactPackage.getClass().getSimpleName());
        stringBuilder.append(" is not a LazyReactPackage, falling back to old version.");
        FLog.m5662d(str, stringBuilder.toString());
        if (reactPackage instanceof ReactInstancePackage) {
            reactPackage = ((ReactInstancePackage) reactPackage).createNativeModules(this.mReactApplicationContext, this.mReactInstanceManager);
        } else {
            reactPackage = reactPackage.createNativeModules(this.mReactApplicationContext);
        }
        for (NativeModule addNativeModule : r6) {
            addNativeModule(addNativeModule);
        }
    }

    public void addNativeModule(NativeModule nativeModule) {
        putModuleTypeAndHolderToModuleMaps(nativeModule.getClass().getName(), nativeModule.getName(), new ModuleHolder(nativeModule));
    }

    private void putModuleTypeAndHolderToModuleMaps(String str, String str2, ModuleHolder moduleHolder) {
        if (this.namesToType.containsKey(str2)) {
            String str3 = (String) this.namesToType.get(str2);
            if (moduleHolder.getCanOverrideExistingModule()) {
                this.mModules.remove(str3);
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Native module ");
                stringBuilder.append(str);
                stringBuilder.append(" tried to override ");
                stringBuilder.append(str3);
                stringBuilder.append(" for module name ");
                stringBuilder.append(str2);
                stringBuilder.append(". Check the getPackages() method in MainApplication.java, it might be that module is being created twice. If this was your intention, set canOverrideExistingModule=true");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
        this.namesToType.put(str2, str);
        this.mModules.put(str, moduleHolder);
    }

    public NativeModuleRegistry build() {
        return new NativeModuleRegistry(this.mReactApplicationContext, this.mModules);
    }
}
