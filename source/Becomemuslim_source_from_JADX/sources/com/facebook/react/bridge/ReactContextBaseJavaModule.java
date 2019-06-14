package com.facebook.react.bridge;

import android.app.Activity;

public abstract class ReactContextBaseJavaModule extends BaseJavaModule {
    private final ReactApplicationContext mReactApplicationContext;

    public ReactContextBaseJavaModule(ReactApplicationContext reactApplicationContext) {
        this.mReactApplicationContext = reactApplicationContext;
    }

    protected final ReactApplicationContext getReactApplicationContext() {
        return this.mReactApplicationContext;
    }

    protected final Activity getCurrentActivity() {
        return this.mReactApplicationContext.getCurrentActivity();
    }
}
