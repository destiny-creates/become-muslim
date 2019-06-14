package com.facebook.react.modules.core;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.JavascriptException;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.util.JSStackTrace;

@ReactModule(name = "ExceptionsManager")
public class ExceptionsManagerModule extends BaseJavaModule {
    public static final String NAME = "ExceptionsManager";
    public final DevSupportManager mDevSupportManager;

    public String getName() {
        return NAME;
    }

    public ExceptionsManagerModule(DevSupportManager devSupportManager) {
        this.mDevSupportManager = devSupportManager;
    }

    @ReactMethod
    public void reportFatalException(String str, ReadableArray readableArray, int i) {
        if (this.mDevSupportManager.getDevSupportEnabled()) {
            showOrThrowError(str, readableArray, i);
            return;
        }
        try {
            Class.forName("host.exp.exponent.ReactNativeStaticHelpers").getMethod("handleReactNativeError", new Class[]{Throwable.class, String.class, Object.class, Integer.class, Boolean.class}).invoke(null, new Object[]{null, str, readableArray, Integer.valueOf(i), Boolean.valueOf(true)});
        } catch (String str2) {
            str2.printStackTrace();
        }
    }

    @ReactMethod
    public void reportSoftException(String str, ReadableArray readableArray, int i) {
        if (!this.mDevSupportManager.getDevSupportEnabled()) {
            try {
                Class.forName("host.exp.exponent.ReactNativeStaticHelpers").getMethod("handleReactNativeError", new Class[]{Throwable.class, String.class, Object.class, Integer.class, Boolean.class}).invoke(null, new Object[]{null, str, readableArray, Integer.valueOf(i), Boolean.valueOf(false)});
            } catch (String str2) {
                str2.printStackTrace();
            }
        } else if (this.mDevSupportManager.getDevSupportEnabled()) {
            this.mDevSupportManager.showNewJSError(str2, readableArray, i);
        } else {
            FLog.m5674e(ReactConstants.TAG, JSStackTrace.format(str2, readableArray));
        }
    }

    private void showOrThrowError(String str, ReadableArray readableArray, int i) {
        if (this.mDevSupportManager.getDevSupportEnabled()) {
            this.mDevSupportManager.showNewJSError(str, readableArray, i);
            return;
        }
        throw new JavascriptException(JSStackTrace.format(str, readableArray));
    }

    @ReactMethod
    public void updateExceptionMessage(String str, ReadableArray readableArray, int i) {
        if (!this.mDevSupportManager.getDevSupportEnabled()) {
            try {
                Class.forName("host.exp.exponent.ReactNativeStaticHelpers").getMethod("handleReactNativeError", new Class[]{Throwable.class, String.class, Object.class, Integer.class, Boolean.class}).invoke(null, new Object[]{null, str, readableArray, Integer.valueOf(i), Boolean.valueOf(false)});
            } catch (String str2) {
                str2.printStackTrace();
            }
        } else if (this.mDevSupportManager.getDevSupportEnabled()) {
            this.mDevSupportManager.updateJSError(str2, readableArray, i);
        }
    }

    @ReactMethod
    public void dismissRedbox() {
        if (this.mDevSupportManager.getDevSupportEnabled()) {
            this.mDevSupportManager.hideRedboxDialog();
        }
    }
}
