package com.reactnativecommunity.webview;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.Collections;
import java.util.List;

/* compiled from: RNCWebViewPackage */
/* renamed from: com.reactnativecommunity.webview.a */
public class C7150a implements ReactPackage {
    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        return Collections.singletonList(new RNCWebViewModule(reactApplicationContext));
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.singletonList(new RNCWebViewManager());
    }
}
