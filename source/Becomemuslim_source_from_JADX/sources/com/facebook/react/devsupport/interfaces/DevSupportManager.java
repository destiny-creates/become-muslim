package com.facebook.react.devsupport.interfaces;

import com.facebook.react.bridge.NativeModuleCallExceptionHandler;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import java.io.File;

public interface DevSupportManager extends NativeModuleCallExceptionHandler {
    void addCustomDevOption(String str, DevOptionHandler devOptionHandler);

    File downloadBundleResourceFromUrlSync(String str, File file);

    DeveloperSettings getDevSettings();

    boolean getDevSupportEnabled();

    String getDownloadedJSBundleFile();

    String getJSBundleURLForRemoteDebugging();

    StackFrame[] getLastErrorStack();

    String getLastErrorTitle();

    String getSourceMapUrl();

    String getSourceUrl();

    void handleReloadJS();

    boolean hasUpToDateJSBundleInCache();

    void hideRedboxDialog();

    void isPackagerRunning(PackagerStatusCallback packagerStatusCallback);

    void onNewReactContextCreated(ReactContext reactContext);

    void onReactInstanceDestroyed(ReactContext reactContext);

    void registerErrorCustomizer(ErrorCustomizer errorCustomizer);

    void reloadJSFromServer(String str);

    void reloadSettings();

    void setDevSupportEnabled(boolean z);

    void showDevOptionsDialog();

    void showNewJSError(String str, ReadableArray readableArray, int i);

    void showNewJavaError(String str, Throwable th);

    void startInspector();

    void stopInspector();

    void updateJSError(String str, ReadableArray readableArray, int i);
}
