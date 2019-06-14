package com.facebook.react.bridge;

import expolib_v1.com.facebook.infer.annotation.Assertions;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSIModuleRegistry {
    private final Map<Class, JSIModuleHolder> mModules = new HashMap();

    public <T extends JSIModule> T getModule(Class<T> cls) {
        JSIModuleHolder jSIModuleHolder = (JSIModuleHolder) this.mModules.get(cls);
        if (jSIModuleHolder != null) {
            return (JSIModule) Assertions.assertNotNull(jSIModuleHolder.getJSIModule());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to find JSIModule for class ");
        stringBuilder.append(cls);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public void registerModules(List<JSIModuleSpec> list) {
        for (JSIModuleSpec jSIModuleSpec : list) {
            this.mModules.put(jSIModuleSpec.getJSIModuleClass(), new JSIModuleHolder(jSIModuleSpec));
        }
    }

    public void notifyJSInstanceDestroy() {
        for (JSIModuleHolder notifyJSInstanceDestroy : this.mModules.values()) {
            notifyJSInstanceDestroy.notifyJSInstanceDestroy();
        }
    }
}
