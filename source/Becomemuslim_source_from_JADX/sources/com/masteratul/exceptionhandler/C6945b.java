package com.masteratul.exceptionhandler;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: ReactNativeExceptionHandlerPackage */
/* renamed from: com.masteratul.exceptionhandler.b */
public class C6945b implements ReactPackage {
    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new NativeModule[]{new ReactNativeExceptionHandlerModule(reactApplicationContext)});
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }
}
