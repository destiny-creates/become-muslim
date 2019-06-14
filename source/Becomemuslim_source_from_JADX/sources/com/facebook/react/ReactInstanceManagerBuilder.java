package com.facebook.react;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.JSCJavaScriptExecutorFactory;
import com.facebook.react.bridge.JSIModulePackage;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.NativeModuleCallExceptionHandler;
import com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.devsupport.RedBoxHandler;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import com.facebook.react.packagerconnection.RequestHandler;
import expolib_v1.com.facebook.infer.annotation.Assertions;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReactInstanceManagerBuilder {
    private Application mApplication;
    private NotThreadSafeBridgeIdleDebugListener mBridgeIdleDebugListener;
    private Activity mCurrentActivity;
    private Map<String, RequestHandler> mCustomPackagerCommandHandlers;
    private DefaultHardwareBackBtnHandler mDefaultHardwareBackBtnHandler;
    private DevBundleDownloadListener mDevBundleDownloadListener;
    private LifecycleState mInitialLifecycleState;
    private String mJSBundleAssetUrl;
    private JSBundleLoader mJSBundleLoader;
    private JSIModulePackage mJSIModulesPackage;
    private String mJSMainModulePath;
    private JavaScriptExecutorFactory mJavaScriptExecutorFactory;
    private boolean mLazyViewManagersEnabled;
    private int mMinNumShakes = 1;
    private int mMinTimeLeftInFrameForNonBatchedOperationMs = -1;
    private NativeModuleCallExceptionHandler mNativeModuleCallExceptionHandler;
    private final List<ReactPackage> mPackages = new ArrayList();
    private RedBoxHandler mRedBoxHandler;
    private boolean mUseDeveloperSupport;

    ReactInstanceManagerBuilder() {
    }

    public ReactInstanceManagerBuilder setJSIModulesPackage(JSIModulePackage jSIModulePackage) {
        this.mJSIModulesPackage = jSIModulePackage;
        return this;
    }

    public ReactInstanceManagerBuilder setJavaScriptExecutorFactory(JavaScriptExecutorFactory javaScriptExecutorFactory) {
        this.mJavaScriptExecutorFactory = javaScriptExecutorFactory;
        return this;
    }

    public ReactInstanceManagerBuilder setBundleAssetName(String str) {
        if (str == null) {
            str = null;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("assets://");
            stringBuilder.append(str);
            str = stringBuilder.toString();
        }
        this.mJSBundleAssetUrl = str;
        this.mJSBundleLoader = null;
        return this;
    }

    public ReactInstanceManagerBuilder setJSBundleFile(String str) {
        if (!str.startsWith("assets://")) {
            return setJSBundleLoader(JSBundleLoader.createFileLoader(str));
        }
        this.mJSBundleAssetUrl = str;
        this.mJSBundleLoader = null;
        return this;
    }

    public ReactInstanceManagerBuilder setJSBundleLoader(JSBundleLoader jSBundleLoader) {
        this.mJSBundleLoader = jSBundleLoader;
        this.mJSBundleAssetUrl = null;
        return this;
    }

    public ReactInstanceManagerBuilder setJSMainModulePath(String str) {
        this.mJSMainModulePath = str;
        return this;
    }

    public ReactInstanceManagerBuilder addPackage(ReactPackage reactPackage) {
        this.mPackages.add(reactPackage);
        return this;
    }

    public ReactInstanceManagerBuilder addPackages(List<ReactPackage> list) {
        this.mPackages.addAll(list);
        return this;
    }

    public ReactInstanceManagerBuilder setBridgeIdleDebugListener(NotThreadSafeBridgeIdleDebugListener notThreadSafeBridgeIdleDebugListener) {
        this.mBridgeIdleDebugListener = notThreadSafeBridgeIdleDebugListener;
        return this;
    }

    public ReactInstanceManagerBuilder setApplication(Application application) {
        this.mApplication = application;
        return this;
    }

    public ReactInstanceManagerBuilder setCurrentActivity(Activity activity) {
        this.mCurrentActivity = activity;
        return this;
    }

    public ReactInstanceManagerBuilder setDefaultHardwareBackBtnHandler(DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler) {
        this.mDefaultHardwareBackBtnHandler = defaultHardwareBackBtnHandler;
        return this;
    }

    public ReactInstanceManagerBuilder setUseDeveloperSupport(boolean z) {
        this.mUseDeveloperSupport = z;
        return this;
    }

    public ReactInstanceManagerBuilder setInitialLifecycleState(LifecycleState lifecycleState) {
        this.mInitialLifecycleState = lifecycleState;
        return this;
    }

    public ReactInstanceManagerBuilder setNativeModuleCallExceptionHandler(NativeModuleCallExceptionHandler nativeModuleCallExceptionHandler) {
        this.mNativeModuleCallExceptionHandler = nativeModuleCallExceptionHandler;
        return this;
    }

    public ReactInstanceManagerBuilder setRedBoxHandler(RedBoxHandler redBoxHandler) {
        this.mRedBoxHandler = redBoxHandler;
        return this;
    }

    public ReactInstanceManagerBuilder setLazyViewManagersEnabled(boolean z) {
        this.mLazyViewManagersEnabled = z;
        return this;
    }

    public ReactInstanceManagerBuilder setDevBundleDownloadListener(DevBundleDownloadListener devBundleDownloadListener) {
        this.mDevBundleDownloadListener = devBundleDownloadListener;
        return this;
    }

    public ReactInstanceManagerBuilder setMinNumShakes(int i) {
        this.mMinNumShakes = i;
        return this;
    }

    public ReactInstanceManagerBuilder setMinTimeLeftInFrameForNonBatchedOperationMs(int i) {
        this.mMinTimeLeftInFrameForNonBatchedOperationMs = i;
        return this;
    }

    public ReactInstanceManagerBuilder setCustomPackagerCommandHandlers(Map<String, RequestHandler> map) {
        this.mCustomPackagerCommandHandlers = map;
        return this;
    }

    public ReactInstanceManager build() {
        boolean z;
        String packageName;
        String friendlyDeviceName;
        Context context;
        Activity activity;
        DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler;
        JavaScriptExecutorFactory jSCJavaScriptExecutorFactory;
        JSBundleLoader createAssetLoader;
        Assertions.assertNotNull(this.mApplication, "Application property has not been set with this builder");
        boolean z2 = true;
        if (!this.mUseDeveloperSupport && r0.mJSBundleAssetUrl == null) {
            if (r0.mJSBundleLoader == null) {
                z = false;
                Assertions.assertCondition(z, "JS Bundle File or Asset URL has to be provided when dev support is disabled");
                if (r0.mJSMainModulePath == null && r0.mJSBundleAssetUrl == null) {
                    if (r0.mJSBundleLoader != null) {
                        z2 = false;
                    }
                }
                Assertions.assertCondition(z2, "Either MainModulePath or JS Bundle File needs to be provided");
                packageName = r0.mApplication.getPackageName();
                friendlyDeviceName = AndroidInfoHelpers.getFriendlyDeviceName();
                context = r0.mApplication;
                activity = r0.mCurrentActivity;
                defaultHardwareBackBtnHandler = r0.mDefaultHardwareBackBtnHandler;
                jSCJavaScriptExecutorFactory = r0.mJavaScriptExecutorFactory != null ? new JSCJavaScriptExecutorFactory(packageName, friendlyDeviceName) : r0.mJavaScriptExecutorFactory;
                createAssetLoader = (r0.mJSBundleLoader == null || r0.mJSBundleAssetUrl == null) ? r0.mJSBundleLoader : JSBundleLoader.createAssetLoader(r0.mApplication, r0.mJSBundleAssetUrl, false);
                return new ReactInstanceManager(context, activity, defaultHardwareBackBtnHandler, jSCJavaScriptExecutorFactory, createAssetLoader, r0.mJSMainModulePath, r0.mPackages, r0.mUseDeveloperSupport, r0.mBridgeIdleDebugListener, (LifecycleState) Assertions.assertNotNull(r0.mInitialLifecycleState, "Initial lifecycle state was not set"), r0.mNativeModuleCallExceptionHandler, r0.mRedBoxHandler, r0.mLazyViewManagersEnabled, r0.mDevBundleDownloadListener, r0.mMinNumShakes, r0.mMinTimeLeftInFrameForNonBatchedOperationMs, r0.mJSIModulesPackage, r0.mCustomPackagerCommandHandlers);
            }
        }
        z = true;
        Assertions.assertCondition(z, "JS Bundle File or Asset URL has to be provided when dev support is disabled");
        if (r0.mJSBundleLoader != null) {
            z2 = false;
        }
        Assertions.assertCondition(z2, "Either MainModulePath or JS Bundle File needs to be provided");
        packageName = r0.mApplication.getPackageName();
        friendlyDeviceName = AndroidInfoHelpers.getFriendlyDeviceName();
        context = r0.mApplication;
        activity = r0.mCurrentActivity;
        defaultHardwareBackBtnHandler = r0.mDefaultHardwareBackBtnHandler;
        if (r0.mJavaScriptExecutorFactory != null) {
        }
        if (r0.mJSBundleLoader == null) {
        }
        return new ReactInstanceManager(context, activity, defaultHardwareBackBtnHandler, jSCJavaScriptExecutorFactory, createAssetLoader, r0.mJSMainModulePath, r0.mPackages, r0.mUseDeveloperSupport, r0.mBridgeIdleDebugListener, (LifecycleState) Assertions.assertNotNull(r0.mInitialLifecycleState, "Initial lifecycle state was not set"), r0.mNativeModuleCallExceptionHandler, r0.mRedBoxHandler, r0.mLazyViewManagersEnabled, r0.mDevBundleDownloadListener, r0.mMinNumShakes, r0.mMinTimeLeftInFrameForNonBatchedOperationMs, r0.mJSIModulesPackage, r0.mCustomPackagerCommandHandlers);
    }
}
