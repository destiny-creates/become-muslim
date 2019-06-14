package com.geektime.rnonesignalandroid;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ReactNativeOneSignalPackage */
/* renamed from: com.geektime.rnonesignalandroid.b */
public class C3980b implements ReactPackage {
    /* renamed from: a */
    RNOneSignal f9989a;

    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        List<NativeModule> arrayList = new ArrayList();
        this.f9989a = new RNOneSignal(reactApplicationContext);
        arrayList.add(this.f9989a);
        return arrayList;
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return new ArrayList();
    }
}
