package com.facebook.react;

import android.app.Application;
import com.facebook.react.bridge.JSIModulePackage;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.devsupport.RedBoxHandler;
import expolib_v1.com.facebook.infer.annotation.Assertions;
import java.util.List;

public abstract class ReactNativeHost {
    private final Application mApplication;
    private ReactInstanceManager mReactInstanceManager;

    protected String getBundleAssetName() {
        return "index.android.bundle";
    }

    protected String getJSBundleFile() {
        return null;
    }

    protected JSIModulePackage getJSIModulePackage() {
        return null;
    }

    protected String getJSMainModuleName() {
        return "index.android";
    }

    protected JavaScriptExecutorFactory getJavaScriptExecutorFactory() {
        return null;
    }

    protected abstract List<ReactPackage> getPackages();

    protected RedBoxHandler getRedBoxHandler() {
        return null;
    }

    public abstract boolean getUseDeveloperSupport();

    protected ReactNativeHost(Application application) {
        this.mApplication = application;
    }

    public ReactInstanceManager getReactInstanceManager() {
        if (this.mReactInstanceManager == null) {
            ReactMarker.logMarker(ReactMarkerConstants.GET_REACT_INSTANCE_MANAGER_START);
            this.mReactInstanceManager = createReactInstanceManager();
            ReactMarker.logMarker(ReactMarkerConstants.GET_REACT_INSTANCE_MANAGER_END);
        }
        return this.mReactInstanceManager;
    }

    public boolean hasInstance() {
        return this.mReactInstanceManager != null;
    }

    public void clear() {
        if (this.mReactInstanceManager != null) {
            this.mReactInstanceManager.destroy();
            this.mReactInstanceManager = null;
        }
    }

    protected ReactInstanceManager createReactInstanceManager() {
        ReactMarker.logMarker(ReactMarkerConstants.BUILD_REACT_INSTANCE_MANAGER_START);
        ReactInstanceManagerBuilder initialLifecycleState = ReactInstanceManager.builder().setApplication(this.mApplication).setJSMainModulePath(getJSMainModuleName()).setUseDeveloperSupport(getUseDeveloperSupport()).setRedBoxHandler(getRedBoxHandler()).setJavaScriptExecutorFactory(getJavaScriptExecutorFactory()).setJSIModulesPackage(getJSIModulePackage()).setInitialLifecycleState(LifecycleState.BEFORE_CREATE);
        for (ReactPackage addPackage : getPackages()) {
            initialLifecycleState.addPackage(addPackage);
        }
        String jSBundleFile = getJSBundleFile();
        if (jSBundleFile != null) {
            initialLifecycleState.setJSBundleFile(jSBundleFile);
        } else {
            initialLifecycleState.setBundleAssetName((String) Assertions.assertNotNull(getBundleAssetName()));
        }
        ReactInstanceManager build = initialLifecycleState.build();
        ReactMarker.logMarker(ReactMarkerConstants.BUILD_REACT_INSTANCE_MANAGER_END);
        return build;
    }

    protected final Application getApplication() {
        return this.mApplication;
    }
}
