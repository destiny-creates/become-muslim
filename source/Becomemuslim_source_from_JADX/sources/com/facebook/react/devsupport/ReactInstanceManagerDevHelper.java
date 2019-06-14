package com.facebook.react.devsupport;

import android.app.Activity;
import com.facebook.react.bridge.JavaJSExecutor.Factory;
import com.facebook.react.bridge.NativeDeltaClient;

public interface ReactInstanceManagerDevHelper {
    Activity getCurrentActivity();

    void onJSBundleLoadedFromServer(NativeDeltaClient nativeDeltaClient);

    void onReloadWithJSDebugger(Factory factory);

    void toggleElementInspector();
}
