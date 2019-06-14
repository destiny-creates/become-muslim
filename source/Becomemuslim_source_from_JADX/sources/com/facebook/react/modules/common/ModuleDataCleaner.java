package com.facebook.react.modules.common;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.common.ReactConstants;

public class ModuleDataCleaner {

    public interface Cleanable {
        void clearSensitiveData();
    }

    public static void cleanDataFromModules(CatalystInstance catalystInstance) {
        for (NativeModule nativeModule : catalystInstance.getNativeModules()) {
            if (nativeModule instanceof Cleanable) {
                String str = ReactConstants.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Cleaning data from ");
                stringBuilder.append(nativeModule.getName());
                FLog.m5662d(str, stringBuilder.toString());
                ((Cleanable) nativeModule).clearSensitiveData();
            }
        }
    }
}
