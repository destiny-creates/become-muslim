package com.facebook.react.modules.core;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.jstasks.HeadlessJsTaskContext;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = "HeadlessJsTaskSupport")
public class HeadlessJsTaskSupportModule extends ReactContextBaseJavaModule {
    protected static final String MODULE_NAME = "HeadlessJsTaskSupport";

    public String getName() {
        return MODULE_NAME;
    }

    public HeadlessJsTaskSupportModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void notifyTaskFinished(int i) {
        HeadlessJsTaskContext instance = HeadlessJsTaskContext.getInstance(getReactApplicationContext());
        if (instance.isTaskRunning(i)) {
            instance.finishTask(i);
            return;
        }
        FLog.m5712w(HeadlessJsTaskSupportModule.class, "Tried to finish non-active task with id %d. Did it time out?", Integer.valueOf(i));
    }
}
