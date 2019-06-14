package com.facebook.react.bridge;

public interface JSIModuleSpec<T extends JSIModule> {
    Class<? extends JSIModule> getJSIModuleClass();

    JSIModuleProvider<T> getJSIModuleProvider();
}
