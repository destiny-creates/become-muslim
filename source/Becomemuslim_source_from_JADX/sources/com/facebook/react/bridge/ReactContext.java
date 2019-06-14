package com.facebook.react.bridge;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import com.facebook.react.bridge.queue.MessageQueueThread;
import com.facebook.react.common.LifecycleState;
import expolib_v1.com.facebook.infer.annotation.Assertions;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class ReactContext extends ContextWrapper {
    private static final String EARLY_JS_ACCESS_EXCEPTION_MESSAGE = "Tried to access a JS module before the React instance was fully set up. Calls to ReactContext#getJSModule should only happen once initialize() has been called on your native module.";
    private final CopyOnWriteArraySet<ActivityEventListener> mActivityEventListeners = new CopyOnWriteArraySet();
    private CatalystInstance mCatalystInstance;
    private WeakReference<Activity> mCurrentActivity;
    private LayoutInflater mInflater;
    private MessageQueueThread mJSMessageQueueThread;
    private final CopyOnWriteArraySet<LifecycleEventListener> mLifecycleEventListeners = new CopyOnWriteArraySet();
    private LifecycleState mLifecycleState = LifecycleState.BEFORE_CREATE;
    private NativeModuleCallExceptionHandler mNativeModuleCallExceptionHandler;
    private MessageQueueThread mNativeModulesMessageQueueThread;
    private MessageQueueThread mUiMessageQueueThread;

    public ReactContext(Context context) {
        super(context);
    }

    public void initializeWithInstance(CatalystInstance catalystInstance) {
        if (catalystInstance == null) {
            throw new IllegalArgumentException("CatalystInstance cannot be null.");
        } else if (this.mCatalystInstance == null) {
            this.mCatalystInstance = catalystInstance;
            catalystInstance = catalystInstance.getReactQueueConfiguration();
            this.mUiMessageQueueThread = catalystInstance.getUIQueueThread();
            this.mNativeModulesMessageQueueThread = catalystInstance.getNativeModulesQueueThread();
            this.mJSMessageQueueThread = catalystInstance.getJSQueueThread();
        } else {
            throw new IllegalStateException("ReactContext has been already initialized");
        }
    }

    public void setNativeModuleCallExceptionHandler(NativeModuleCallExceptionHandler nativeModuleCallExceptionHandler) {
        this.mNativeModuleCallExceptionHandler = nativeModuleCallExceptionHandler;
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.mInflater == null) {
            this.mInflater = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.mInflater;
    }

    public <T extends JavaScriptModule> T getJSModule(Class<T> cls) {
        if (this.mCatalystInstance != null) {
            return this.mCatalystInstance.getJSModule(cls);
        }
        throw new RuntimeException(EARLY_JS_ACCESS_EXCEPTION_MESSAGE);
    }

    public <T extends NativeModule> boolean hasNativeModule(Class<T> cls) {
        if (this.mCatalystInstance != null) {
            return this.mCatalystInstance.hasNativeModule(cls);
        }
        throw new RuntimeException("Trying to call native module before CatalystInstance has been set!");
    }

    public <T extends NativeModule> T getNativeModule(Class<T> cls) {
        if (this.mCatalystInstance != null) {
            return this.mCatalystInstance.getNativeModule(cls);
        }
        throw new RuntimeException("Trying to call native module before CatalystInstance has been set!");
    }

    public CatalystInstance getCatalystInstance() {
        return (CatalystInstance) Assertions.assertNotNull(this.mCatalystInstance);
    }

    public boolean hasActiveCatalystInstance() {
        return (this.mCatalystInstance == null || this.mCatalystInstance.isDestroyed()) ? false : true;
    }

    public LifecycleState getLifecycleState() {
        return this.mLifecycleState;
    }

    public void addLifecycleEventListener(final LifecycleEventListener lifecycleEventListener) {
        this.mLifecycleEventListeners.add(lifecycleEventListener);
        if (hasActiveCatalystInstance()) {
            switch (this.mLifecycleState) {
                case BEFORE_CREATE:
                case BEFORE_RESUME:
                    return;
                case RESUMED:
                    runOnUiQueueThread(new Runnable() {
                        public void run() {
                            if (ReactContext.this.mLifecycleEventListeners.contains(lifecycleEventListener)) {
                                try {
                                    lifecycleEventListener.onHostResume();
                                } catch (Exception e) {
                                    ReactContext.this.handleException(e);
                                }
                            }
                        }
                    });
                    return;
                default:
                    throw new RuntimeException("Unhandled lifecycle state.");
            }
        }
    }

    public void removeLifecycleEventListener(LifecycleEventListener lifecycleEventListener) {
        this.mLifecycleEventListeners.remove(lifecycleEventListener);
    }

    public void addActivityEventListener(ActivityEventListener activityEventListener) {
        this.mActivityEventListeners.add(activityEventListener);
    }

    public void removeActivityEventListener(ActivityEventListener activityEventListener) {
        this.mActivityEventListeners.remove(activityEventListener);
    }

    public void onHostResume(Activity activity) {
        this.mLifecycleState = LifecycleState.RESUMED;
        this.mCurrentActivity = new WeakReference(activity);
        ReactMarker.logMarker(ReactMarkerConstants.ON_HOST_RESUME_START);
        activity = this.mLifecycleEventListeners.iterator();
        while (activity.hasNext()) {
            try {
                ((LifecycleEventListener) activity.next()).onHostResume();
            } catch (Exception e) {
                handleException(e);
            }
        }
        ReactMarker.logMarker(ReactMarkerConstants.ON_HOST_RESUME_END);
    }

    public void onNewIntent(Activity activity, Intent intent) {
        UiThreadUtil.assertOnUiThread();
        this.mCurrentActivity = new WeakReference(activity);
        activity = this.mActivityEventListeners.iterator();
        while (activity.hasNext()) {
            try {
                ((ActivityEventListener) activity.next()).onNewIntent(intent);
            } catch (Exception e) {
                handleException(e);
            }
        }
    }

    public void onHostPause() {
        this.mLifecycleState = LifecycleState.BEFORE_RESUME;
        ReactMarker.logMarker(ReactMarkerConstants.ON_HOST_PAUSE_START);
        Iterator it = this.mLifecycleEventListeners.iterator();
        while (it.hasNext()) {
            try {
                ((LifecycleEventListener) it.next()).onHostPause();
            } catch (Exception e) {
                handleException(e);
            }
        }
        ReactMarker.logMarker(ReactMarkerConstants.ON_HOST_PAUSE_END);
    }

    public void onHostDestroy() {
        UiThreadUtil.assertOnUiThread();
        this.mLifecycleState = LifecycleState.BEFORE_CREATE;
        Iterator it = this.mLifecycleEventListeners.iterator();
        while (it.hasNext()) {
            try {
                ((LifecycleEventListener) it.next()).onHostDestroy();
            } catch (Exception e) {
                handleException(e);
            }
        }
        this.mCurrentActivity = null;
    }

    public void destroy() {
        UiThreadUtil.assertOnUiThread();
        if (this.mCatalystInstance != null) {
            this.mCatalystInstance.destroy();
        }
    }

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        Iterator it = this.mActivityEventListeners.iterator();
        while (it.hasNext()) {
            try {
                ((ActivityEventListener) it.next()).onActivityResult(activity, i, i2, intent);
            } catch (Exception e) {
                handleException(e);
            }
        }
    }

    public void assertOnUiQueueThread() {
        ((MessageQueueThread) Assertions.assertNotNull(this.mUiMessageQueueThread)).assertIsOnThread();
    }

    public boolean isOnUiQueueThread() {
        return ((MessageQueueThread) Assertions.assertNotNull(this.mUiMessageQueueThread)).isOnThread();
    }

    public void runOnUiQueueThread(Runnable runnable) {
        ((MessageQueueThread) Assertions.assertNotNull(this.mUiMessageQueueThread)).runOnQueue(runnable);
    }

    public void assertOnNativeModulesQueueThread() {
        ((MessageQueueThread) Assertions.assertNotNull(this.mNativeModulesMessageQueueThread)).assertIsOnThread();
    }

    public void assertOnNativeModulesQueueThread(String str) {
        ((MessageQueueThread) Assertions.assertNotNull(this.mNativeModulesMessageQueueThread)).assertIsOnThread(str);
    }

    public boolean isOnNativeModulesQueueThread() {
        return ((MessageQueueThread) Assertions.assertNotNull(this.mNativeModulesMessageQueueThread)).isOnThread();
    }

    public void runOnNativeModulesQueueThread(Runnable runnable) {
        ((MessageQueueThread) Assertions.assertNotNull(this.mNativeModulesMessageQueueThread)).runOnQueue(runnable);
    }

    public void assertOnJSQueueThread() {
        ((MessageQueueThread) Assertions.assertNotNull(this.mJSMessageQueueThread)).assertIsOnThread();
    }

    public boolean isOnJSQueueThread() {
        return ((MessageQueueThread) Assertions.assertNotNull(this.mJSMessageQueueThread)).isOnThread();
    }

    public void runOnJSQueueThread(Runnable runnable) {
        ((MessageQueueThread) Assertions.assertNotNull(this.mJSMessageQueueThread)).runOnQueue(runnable);
    }

    public void handleException(Exception exception) {
        if (this.mCatalystInstance == null || this.mCatalystInstance.isDestroyed() || this.mNativeModuleCallExceptionHandler == null) {
            throw new RuntimeException(exception);
        }
        this.mNativeModuleCallExceptionHandler.handleException(exception);
    }

    public boolean hasCurrentActivity() {
        return (this.mCurrentActivity == null || this.mCurrentActivity.get() == null) ? false : true;
    }

    public boolean startActivityForResult(Intent intent, int i, Bundle bundle) {
        Activity currentActivity = getCurrentActivity();
        Assertions.assertNotNull(currentActivity);
        currentActivity.startActivityForResult(intent, i, bundle);
        return true;
    }

    public Activity getCurrentActivity() {
        if (this.mCurrentActivity == null) {
            return null;
        }
        return (Activity) this.mCurrentActivity.get();
    }

    public JavaScriptContextHolder getJavaScriptContextHolder() {
        return this.mCatalystInstance.getJavaScriptContextHolder();
    }
}
