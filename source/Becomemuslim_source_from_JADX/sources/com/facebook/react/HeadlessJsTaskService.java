package com.facebook.react;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.facebook.react.ReactInstanceManager.ReactInstanceEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.jstasks.HeadlessJsTaskConfig;
import com.facebook.react.jstasks.HeadlessJsTaskContext;
import com.facebook.react.jstasks.HeadlessJsTaskEventListener;
import expolib_v1.com.facebook.infer.annotation.Assertions;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public abstract class HeadlessJsTaskService extends Service implements HeadlessJsTaskEventListener {
    private static WakeLock sWakeLock;
    private final Set<Integer> mActiveTasks = new CopyOnWriteArraySet();

    protected HeadlessJsTaskConfig getTaskConfig(Intent intent) {
        return null;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onHeadlessJsTaskStart(int i) {
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        intent = getTaskConfig(intent);
        if (intent == null) {
            return 2;
        }
        startTask(intent);
        return 3;
    }

    public static void acquireWakeLockNow(Context context) {
        if (sWakeLock == null || !sWakeLock.isHeld()) {
            sWakeLock = ((PowerManager) Assertions.assertNotNull((PowerManager) context.getSystemService("power"))).newWakeLock(1, HeadlessJsTaskService.class.getSimpleName());
            sWakeLock.setReferenceCounted(false);
            sWakeLock.acquire();
        }
    }

    protected void startTask(final HeadlessJsTaskConfig headlessJsTaskConfig) {
        UiThreadUtil.assertOnUiThread();
        acquireWakeLockNow(this);
        final ReactInstanceManager reactInstanceManager = getReactNativeHost().getReactInstanceManager();
        ReactContext currentReactContext = reactInstanceManager.getCurrentReactContext();
        if (currentReactContext == null) {
            reactInstanceManager.addReactInstanceEventListener(new ReactInstanceEventListener() {
                public void onReactContextInitialized(ReactContext reactContext) {
                    HeadlessJsTaskService.this.invokeStartTask(reactContext, headlessJsTaskConfig);
                    reactInstanceManager.removeReactInstanceEventListener(this);
                }
            });
            if (reactInstanceManager.hasStartedCreatingInitialContext() == null) {
                reactInstanceManager.createReactContextInBackground();
                return;
            }
            return;
        }
        invokeStartTask(currentReactContext, headlessJsTaskConfig);
    }

    private void invokeStartTask(ReactContext reactContext, final HeadlessJsTaskConfig headlessJsTaskConfig) {
        reactContext = HeadlessJsTaskContext.getInstance(reactContext);
        reactContext.addTaskEventListener(this);
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                HeadlessJsTaskService.this.mActiveTasks.add(Integer.valueOf(reactContext.startTask(headlessJsTaskConfig)));
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
        if (getReactNativeHost().hasInstance()) {
            ReactContext currentReactContext = getReactNativeHost().getReactInstanceManager().getCurrentReactContext();
            if (currentReactContext != null) {
                HeadlessJsTaskContext.getInstance(currentReactContext).removeTaskEventListener(this);
            }
        }
        if (sWakeLock != null) {
            sWakeLock.release();
        }
    }

    public void onHeadlessJsTaskFinish(int i) {
        this.mActiveTasks.remove(Integer.valueOf(i));
        if (this.mActiveTasks.size() == 0) {
            stopSelf();
        }
    }

    protected ReactNativeHost getReactNativeHost() {
        return ((ReactApplication) getApplication()).getReactNativeHost();
    }
}
