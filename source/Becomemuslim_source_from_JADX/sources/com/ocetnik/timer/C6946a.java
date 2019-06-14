package com.ocetnik.timer;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: BackgroundTimerPackage */
/* renamed from: com.ocetnik.timer.a */
public class C6946a implements ReactPackage {
    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        List<NativeModule> arrayList = new ArrayList();
        arrayList.add(new BackgroundTimerModule(reactApplicationContext));
        return arrayList;
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }
}
