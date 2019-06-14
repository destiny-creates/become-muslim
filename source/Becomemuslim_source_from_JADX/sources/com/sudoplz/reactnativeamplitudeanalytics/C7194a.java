package com.sudoplz.reactnativeamplitudeanalytics;

import android.app.Application;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: RNAmplitudeSDKPackage */
/* renamed from: com.sudoplz.reactnativeamplitudeanalytics.a */
public class C7194a implements ReactPackage {
    /* renamed from: a */
    private Application f25467a = null;

    public C7194a(Application application) {
        this.f25467a = application;
    }

    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        List<NativeModule> arrayList = new ArrayList();
        arrayList.add(new RNAmplitudeSDK(reactApplicationContext, this.f25467a));
        return arrayList;
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }
}
