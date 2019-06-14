package com.idehub.GoogleAnalyticsBridge;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.google.android.gms.p185e.C4391b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: GoogleAnalyticsBridgePackage */
/* renamed from: com.idehub.GoogleAnalyticsBridge.c */
public class C6932c implements ReactPackage {
    /* renamed from: a */
    private C4391b f24795a;
    /* renamed from: b */
    private String f24796b;

    public C6932c(C4391b c4391b, String str) {
        this.f24795a = null;
        this.f24795a = c4391b;
        this.f24796b = str;
    }

    public C6932c() {
        this(null, null);
    }

    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        List<NativeModule> arrayList = new ArrayList();
        arrayList.add(new GoogleAnalyticsBridge(reactApplicationContext, this.f24796b));
        arrayList.add(new GoogleAnalyticsSettings(reactApplicationContext));
        arrayList.add(new GoogleTagManagerBridge(reactApplicationContext, this.f24795a));
        return arrayList;
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new ViewManager[null]);
    }
}
