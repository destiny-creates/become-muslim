package com.facebook.react;

import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.ExceptionsManagerModule;
import com.facebook.react.modules.core.HeadlessJsTaskSupportModule;
import com.facebook.react.modules.core.Timing;
import com.facebook.react.modules.debug.SourceCodeModule;
import com.facebook.react.modules.deviceinfo.DeviceInfoModule;
import com.facebook.react.modules.systeminfo.AndroidInfoModule;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.UIManagerModule.ViewManagerResolver;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.systrace.Systrace;
import java.util.Arrays;
import java.util.List;
import javax.inject.Provider;

class CoreModulesPackage extends LazyReactPackage implements ReactPackageLogger {
    private final DefaultHardwareBackBtnHandler mHardwareBackBtnHandler;
    private final boolean mLazyViewManagersEnabled;
    private final int mMinTimeLeftInFrameForNonBatchedOperationMs;
    private final ReactInstanceManager mReactInstanceManager;

    /* renamed from: com.facebook.react.CoreModulesPackage$3 */
    class C37903 implements Provider<NativeModule> {
        C37903() {
        }

        public NativeModule get() {
            return new ExceptionsManagerModule(CoreModulesPackage.this.mReactInstanceManager.getDevSupportManager());
        }
    }

    /* renamed from: com.facebook.react.CoreModulesPackage$9 */
    class C37969 implements ViewManagerResolver {
        C37969() {
        }

        public ViewManager getViewManager(String str) {
            return CoreModulesPackage.this.mReactInstanceManager.createViewManager(str);
        }

        public List<String> getViewManagerNames() {
            return CoreModulesPackage.this.mReactInstanceManager.getViewManagerNames();
        }
    }

    CoreModulesPackage(ReactInstanceManager reactInstanceManager, DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler, boolean z, int i) {
        this.mReactInstanceManager = reactInstanceManager;
        this.mHardwareBackBtnHandler = defaultHardwareBackBtnHandler;
        this.mLazyViewManagersEnabled = z;
        this.mMinTimeLeftInFrameForNonBatchedOperationMs = i;
    }

    public List<ModuleSpec> getNativeModules(final ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new ModuleSpec[]{ModuleSpec.nativeModuleSpec(AndroidInfoModule.class, new Provider<NativeModule>() {
            public NativeModule get() {
                return new AndroidInfoModule(reactApplicationContext);
            }
        }), ModuleSpec.nativeModuleSpec(DeviceEventManagerModule.class, new Provider<NativeModule>() {
            public NativeModule get() {
                return new DeviceEventManagerModule(reactApplicationContext, CoreModulesPackage.this.mHardwareBackBtnHandler);
            }
        }), ModuleSpec.nativeModuleSpec(ExceptionsManagerModule.class, new C37903()), ModuleSpec.nativeModuleSpec(HeadlessJsTaskSupportModule.class, new Provider<NativeModule>() {
            public NativeModule get() {
                return new HeadlessJsTaskSupportModule(reactApplicationContext);
            }
        }), ModuleSpec.nativeModuleSpec(SourceCodeModule.class, new Provider<NativeModule>() {
            public NativeModule get() {
                return new SourceCodeModule(reactApplicationContext);
            }
        }), ModuleSpec.nativeModuleSpec(Timing.class, new Provider<NativeModule>() {
            public NativeModule get() {
                return new Timing(reactApplicationContext, CoreModulesPackage.this.mReactInstanceManager.getDevSupportManager());
            }
        }), ModuleSpec.nativeModuleSpec(UIManagerModule.class, new Provider<NativeModule>() {
            public NativeModule get() {
                return CoreModulesPackage.this.createUIManager(reactApplicationContext);
            }
        }), ModuleSpec.nativeModuleSpec(DeviceInfoModule.class, new Provider<NativeModule>() {
            public NativeModule get() {
                return new DeviceInfoModule(reactApplicationContext);
            }
        })});
    }

    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        return LazyReactPackage.getReactModuleInfoProviderViaReflection(this);
    }

    private UIManagerModule createUIManager(ReactApplicationContext reactApplicationContext) {
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_START);
        Systrace.beginSection(0, "createUIManagerModule");
        try {
            UIManagerModule uIManagerModule;
            if (this.mLazyViewManagersEnabled) {
                uIManagerModule = new UIManagerModule(reactApplicationContext, new C37969(), this.mMinTimeLeftInFrameForNonBatchedOperationMs);
                return uIManagerModule;
            }
            uIManagerModule = this.mReactInstanceManager.getOrCreateViewManagers(reactApplicationContext);
            UIManagerModule uIManagerModule2 = new UIManagerModule(reactApplicationContext, (List) uIManagerModule, this.mMinTimeLeftInFrameForNonBatchedOperationMs);
            Systrace.endSection(0);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_END);
            return uIManagerModule2;
        } finally {
            Systrace.endSection(0);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_END);
        }
    }

    public void startProcessPackage() {
        ReactMarker.logMarker(ReactMarkerConstants.PROCESS_CORE_REACT_PACKAGE_START);
    }

    public void endProcessPackage() {
        ReactMarker.logMarker(ReactMarkerConstants.PROCESS_CORE_REACT_PACKAGE_END);
    }
}
