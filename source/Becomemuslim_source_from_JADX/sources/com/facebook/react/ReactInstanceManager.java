package com.facebook.react;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Process;
import android.support.v4.view.C0517s;
import android.util.Log;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.facebook.common.logging.FLog;
import com.facebook.debug.holder.PrinterHolder;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.internal.ServerProtocol;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.CatalystInstanceImpl.Builder;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.JSIModulePackage;
import com.facebook.react.bridge.JavaJSExecutor.Factory;
import com.facebook.react.bridge.JavaScriptExecutor;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.NativeDeltaClient;
import com.facebook.react.bridge.NativeModuleCallExceptionHandler;
import com.facebook.react.bridge.NativeModuleRegistry;
import com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener;
import com.facebook.react.bridge.ProxyJavaScriptExecutor;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.queue.ReactQueueConfigurationSpec;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.devsupport.DevSupportManagerFactory;
import com.facebook.react.devsupport.ReactInstanceManagerDevHelper;
import com.facebook.react.devsupport.RedBoxHandler;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.PackagerStatusCallback;
import com.facebook.react.modules.appregistry.AppRegistry;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import com.facebook.react.modules.fabric.ReactFabric;
import com.facebook.react.packagerconnection.RequestHandler;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.views.imagehelper.ResourceDrawableIdHelper;
import com.facebook.soloader.SoLoader;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import expolib_v1.com.facebook.infer.annotation.Assertions;
import expolib_v1.com.facebook.infer.annotation.ThreadConfined;
import expolib_v1.com.facebook.infer.annotation.ThreadSafe;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@ThreadSafe
public class ReactInstanceManager {
    private static final String TAG = "ReactInstanceManager";
    private final Context mApplicationContext;
    private final List<ReactRootView> mAttachedRootViews = Collections.synchronizedList(new ArrayList());
    private final NotThreadSafeBridgeIdleDebugListener mBridgeIdleDebugListener;
    private final JSBundleLoader mBundleLoader;
    private volatile Thread mCreateReactContextThread;
    private Activity mCurrentActivity;
    private volatile ReactContext mCurrentReactContext;
    @ThreadConfined("UI")
    private DefaultHardwareBackBtnHandler mDefaultBackButtonImpl;
    private final DevSupportManager mDevSupportManager;
    private volatile boolean mHasStartedCreatingInitialContext = false;
    private volatile Boolean mHasStartedDestroying = Boolean.valueOf(false);
    private final JSIModulePackage mJSIModulePackage;
    private final String mJSMainModulePath;
    private final JavaScriptExecutorFactory mJavaScriptExecutorFactory;
    private volatile LifecycleState mLifecycleState;
    private final MemoryPressureRouter mMemoryPressureRouter;
    private final NativeModuleCallExceptionHandler mNativeModuleCallExceptionHandler;
    private final List<ReactPackage> mPackages;
    @ThreadConfined("UI")
    private ReactContextInitParams mPendingReactContextInitParams;
    private final Object mReactContextLock = new Object();
    private final Collection<ReactInstanceEventListener> mReactInstanceEventListeners = Collections.synchronizedSet(new HashSet());
    private final boolean mUseDeveloperSupport;
    private List<ViewManager> mViewManagers;

    /* renamed from: com.facebook.react.ReactInstanceManager$7 */
    class C18717 implements Runnable {
        C18717() {
        }

        public void run() {
            Process.setThreadPriority(0);
        }
    }

    /* renamed from: com.facebook.react.ReactInstanceManager$8 */
    class C18728 implements Runnable {
        C18728() {
        }

        public void run() {
            Process.setThreadPriority(0);
        }
    }

    private class ReactContextInitParams {
        private final JSBundleLoader mJsBundleLoader;
        private final JavaScriptExecutorFactory mJsExecutorFactory;

        public ReactContextInitParams(JavaScriptExecutorFactory javaScriptExecutorFactory, JSBundleLoader jSBundleLoader) {
            this.mJsExecutorFactory = (JavaScriptExecutorFactory) Assertions.assertNotNull(javaScriptExecutorFactory);
            this.mJsBundleLoader = (JSBundleLoader) Assertions.assertNotNull(jSBundleLoader);
        }

        public JavaScriptExecutorFactory getJsExecutorFactory() {
            return this.mJsExecutorFactory;
        }

        public JSBundleLoader getJsBundleLoader() {
            return this.mJsBundleLoader;
        }
    }

    public interface ReactInstanceEventListener {
        void onReactContextInitialized(ReactContext reactContext);
    }

    /* renamed from: com.facebook.react.ReactInstanceManager$1 */
    class C38021 implements DefaultHardwareBackBtnHandler {
        C38021() {
        }

        public void invokeDefaultOnBackPressed() {
            ReactInstanceManager.this.invokeDefaultOnBackPressed();
        }
    }

    /* renamed from: com.facebook.react.ReactInstanceManager$2 */
    class C38032 implements ReactInstanceManagerDevHelper {
        C38032() {
        }

        public void onReloadWithJSDebugger(Factory factory) {
            ReactInstanceManager.this.onReloadWithJSDebugger(factory);
        }

        public void onJSBundleLoadedFromServer(NativeDeltaClient nativeDeltaClient) {
            ReactInstanceManager.this.onJSBundleLoadedFromServer(nativeDeltaClient);
        }

        public void toggleElementInspector() {
            ReactInstanceManager.this.toggleElementInspector();
        }

        public Activity getCurrentActivity() {
            return ReactInstanceManager.this.mCurrentActivity;
        }
    }

    public static ReactInstanceManagerBuilder builder() {
        return new ReactInstanceManagerBuilder();
    }

    ReactInstanceManager(Context context, Activity activity, DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler, JavaScriptExecutorFactory javaScriptExecutorFactory, JSBundleLoader jSBundleLoader, String str, List<ReactPackage> list, boolean z, NotThreadSafeBridgeIdleDebugListener notThreadSafeBridgeIdleDebugListener, LifecycleState lifecycleState, NativeModuleCallExceptionHandler nativeModuleCallExceptionHandler, RedBoxHandler redBoxHandler, boolean z2, DevBundleDownloadListener devBundleDownloadListener, int i, int i2, JSIModulePackage jSIModulePackage, Map<String, RequestHandler> map) {
        Context context2 = context;
        Log.d(ReactConstants.TAG, "ReactInstanceManager.ctor()");
        initializeSoLoaderIfNecessary(context);
        DisplayMetricsHolder.initDisplayMetricsIfNotInitialized(context);
        this.mApplicationContext = context2;
        this.mCurrentActivity = activity;
        this.mDefaultBackButtonImpl = defaultHardwareBackBtnHandler;
        this.mJavaScriptExecutorFactory = javaScriptExecutorFactory;
        this.mBundleLoader = jSBundleLoader;
        this.mJSMainModulePath = str;
        this.mPackages = new ArrayList();
        boolean z3 = z;
        this.mUseDeveloperSupport = z3;
        this.mDevSupportManager = DevSupportManagerFactory.create(context, createDevHelperInterface(), this.mJSMainModulePath, z3, redBoxHandler, devBundleDownloadListener, i, map);
        this.mBridgeIdleDebugListener = notThreadSafeBridgeIdleDebugListener;
        this.mLifecycleState = lifecycleState;
        this.mMemoryPressureRouter = new MemoryPressureRouter(context);
        this.mNativeModuleCallExceptionHandler = nativeModuleCallExceptionHandler;
        synchronized (this.mPackages) {
            PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.RN_CORE, "RNCore: Use Split Packages");
            r1.mPackages.add(new CoreModulesPackage(this, new C38021(), z2, i2));
            if (r1.mUseDeveloperSupport) {
                r1.mPackages.add(new DebugCorePackage());
            }
            r1.mPackages.addAll(list);
        }
        r1.mJSIModulePackage = jSIModulePackage;
        ReactChoreographer.initialize();
        if (r1.mUseDeveloperSupport) {
            r1.mDevSupportManager.startInspector();
        }
    }

    private ReactInstanceManagerDevHelper createDevHelperInterface() {
        return new C38032();
    }

    public DevSupportManager getDevSupportManager() {
        return this.mDevSupportManager;
    }

    public MemoryPressureRouter getMemoryPressureRouter() {
        return this.mMemoryPressureRouter;
    }

    private static void initializeSoLoaderIfNecessary(Context context) {
        SoLoader.init(context, false);
    }

    @ThreadConfined("UI")
    public void createReactContextInBackground() {
        Log.d(ReactConstants.TAG, "ReactInstanceManager.createReactContextInBackground()");
        Assertions.assertCondition(this.mHasStartedCreatingInitialContext ^ true, "createReactContextInBackground should only be called when creating the react application for the first time. When reloading JS, e.g. from a new file, explicitlyuse recreateReactContextInBackground");
        this.mHasStartedCreatingInitialContext = true;
        recreateReactContextInBackgroundInner();
    }

    @ThreadConfined("UI")
    public void recreateReactContextInBackground() {
        Assertions.assertCondition(this.mHasStartedCreatingInitialContext, "recreateReactContextInBackground should only be called after the initial createReactContextInBackground call.");
        recreateReactContextInBackgroundInner();
    }

    @ThreadConfined("UI")
    private void recreateReactContextInBackgroundInner() {
        Log.d(ReactConstants.TAG, "ReactInstanceManager.recreateReactContextInBackgroundInner()");
        PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.RN_CORE, "RNCore: recreateReactContextInBackground");
        UiThreadUtil.assertOnUiThread();
        if (!this.mUseDeveloperSupport || this.mJSMainModulePath == null || Systrace.isTracing(0)) {
            recreateReactContextInBackgroundFromBundleLoader();
            return;
        }
        final DeveloperSettings devSettings = this.mDevSupportManager.getDevSettings();
        if (this.mDevSupportManager.hasUpToDateJSBundleInCache() && !devSettings.isRemoteJSDebugEnabled()) {
            onJSBundleLoadedFromServer(null);
        } else if (this.mBundleLoader == null) {
            this.mDevSupportManager.handleReloadJS();
        } else {
            this.mDevSupportManager.isPackagerRunning(new PackagerStatusCallback() {
                public void onPackagerStatusFetched(final boolean z) {
                    UiThreadUtil.runOnUiThread(new Runnable() {
                        public void run() {
                            if (z) {
                                ReactInstanceManager.this.mDevSupportManager.handleReloadJS();
                                return;
                            }
                            devSettings.setRemoteJSDebugEnabled(false);
                            ReactInstanceManager.this.recreateReactContextInBackgroundFromBundleLoader();
                        }
                    });
                }
            });
        }
    }

    @ThreadConfined("UI")
    private void recreateReactContextInBackgroundFromBundleLoader() {
        Log.d(ReactConstants.TAG, "ReactInstanceManager.recreateReactContextInBackgroundFromBundleLoader()");
        PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.RN_CORE, "RNCore: load from BundleLoader");
        recreateReactContextInBackground(this.mJavaScriptExecutorFactory, this.mBundleLoader);
    }

    public boolean hasStartedCreatingInitialContext() {
        return this.mHasStartedCreatingInitialContext;
    }

    public void onBackPressed() {
        UiThreadUtil.assertOnUiThread();
        ReactContext reactContext = this.mCurrentReactContext;
        if (reactContext == null) {
            FLog.m5714w(ReactConstants.TAG, "Instance detached from instance manager");
            invokeDefaultOnBackPressed();
            return;
        }
        ((DeviceEventManagerModule) reactContext.getNativeModule(DeviceEventManagerModule.class)).emitHardwareBackPressed();
    }

    private void invokeDefaultOnBackPressed() {
        UiThreadUtil.assertOnUiThread();
        if (this.mDefaultBackButtonImpl != null) {
            this.mDefaultBackButtonImpl.invokeDefaultOnBackPressed();
        }
    }

    @ThreadConfined("UI")
    public void onNewIntent(Intent intent) {
        UiThreadUtil.assertOnUiThread();
        ReactContext currentReactContext = getCurrentReactContext();
        if (currentReactContext == null) {
            FLog.m5714w(ReactConstants.TAG, "Instance detached from instance manager");
            return;
        }
        String action = intent.getAction();
        Uri data = intent.getData();
        if ("android.intent.action.VIEW".equals(action) && data != null) {
            ((DeviceEventManagerModule) currentReactContext.getNativeModule(DeviceEventManagerModule.class)).emitNewIntentReceived(data);
        }
        currentReactContext.onNewIntent(this.mCurrentActivity, intent);
    }

    private void toggleElementInspector() {
        ReactContext currentReactContext = getCurrentReactContext();
        if (currentReactContext != null) {
            ((RCTDeviceEventEmitter) currentReactContext.getJSModule(RCTDeviceEventEmitter.class)).emit("toggleElementInspector", null);
        }
    }

    @ThreadConfined("UI")
    public void onHostPause() {
        UiThreadUtil.assertOnUiThread();
        this.mDefaultBackButtonImpl = null;
        if (this.mUseDeveloperSupport) {
            this.mDevSupportManager.setDevSupportEnabled(false);
        }
        moveToBeforeResumeLifecycleState();
    }

    @ThreadConfined("UI")
    public void onHostPause(Activity activity) {
        Assertions.assertNotNull(this.mCurrentActivity);
        boolean z = activity == this.mCurrentActivity;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Pausing an activity that is not the current activity, this is incorrect! Current activity: ");
        stringBuilder.append(this.mCurrentActivity.getClass().getSimpleName());
        stringBuilder.append(" Paused activity: ");
        stringBuilder.append(activity.getClass().getSimpleName());
        Assertions.assertCondition(z, stringBuilder.toString());
        onHostPause();
    }

    @ThreadConfined("UI")
    public void onHostResume(Activity activity, DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler) {
        UiThreadUtil.assertOnUiThread();
        this.mDefaultBackButtonImpl = defaultHardwareBackBtnHandler;
        onHostResume(activity);
    }

    @ThreadConfined("UI")
    public void onHostResume(Activity activity) {
        UiThreadUtil.assertOnUiThread();
        this.mCurrentActivity = activity;
        if (this.mUseDeveloperSupport != null) {
            activity = this.mCurrentActivity.getWindow().getDecorView();
            if (C0517s.m1683A(activity)) {
                this.mDevSupportManager.setDevSupportEnabled(true);
            } else {
                activity.addOnAttachStateChangeListener(new OnAttachStateChangeListener() {
                    public void onViewDetachedFromWindow(View view) {
                    }

                    public void onViewAttachedToWindow(View view) {
                        activity.removeOnAttachStateChangeListener(this);
                        ReactInstanceManager.this.mDevSupportManager.setDevSupportEnabled(true);
                    }
                });
            }
        }
        moveToResumedLifecycleState(null);
    }

    @ThreadConfined("UI")
    public void onHostDestroy() {
        UiThreadUtil.assertOnUiThread();
        if (this.mUseDeveloperSupport) {
            this.mDevSupportManager.setDevSupportEnabled(false);
        }
        moveToBeforeCreateLifecycleState();
        this.mCurrentActivity = null;
    }

    @ThreadConfined("UI")
    public void onHostDestroy(Activity activity) {
        if (activity == this.mCurrentActivity) {
            onHostDestroy();
        }
    }

    @ThreadConfined("UI")
    public void destroy() {
        UiThreadUtil.assertOnUiThread();
        PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.RN_CORE, "RNCore: Destroy");
        this.mHasStartedDestroying = Boolean.valueOf(true);
        if (this.mUseDeveloperSupport) {
            this.mDevSupportManager.setDevSupportEnabled(false);
            this.mDevSupportManager.stopInspector();
        }
        moveToBeforeCreateLifecycleState();
        if (this.mCreateReactContextThread != null) {
            this.mCreateReactContextThread = null;
        }
        this.mMemoryPressureRouter.destroy(this.mApplicationContext);
        synchronized (this.mReactContextLock) {
            if (this.mCurrentReactContext != null) {
                this.mCurrentReactContext.destroy();
                this.mCurrentReactContext = null;
            }
        }
        this.mHasStartedCreatingInitialContext = false;
        this.mCurrentActivity = null;
        ResourceDrawableIdHelper.getInstance().clear();
        this.mHasStartedDestroying = Boolean.valueOf(false);
        synchronized (this.mHasStartedDestroying) {
            this.mHasStartedDestroying.notifyAll();
        }
    }

    private synchronized void moveToResumedLifecycleState(boolean z) {
        ReactContext currentReactContext = getCurrentReactContext();
        if (currentReactContext != null && (z || this.mLifecycleState == LifecycleState.BEFORE_RESUME || this.mLifecycleState == LifecycleState.BEFORE_CREATE)) {
            currentReactContext.onHostResume(this.mCurrentActivity);
        }
        this.mLifecycleState = LifecycleState.RESUMED;
    }

    private synchronized void moveToBeforeResumeLifecycleState() {
        ReactContext currentReactContext = getCurrentReactContext();
        if (currentReactContext != null) {
            if (this.mLifecycleState == LifecycleState.BEFORE_CREATE) {
                currentReactContext.onHostResume(this.mCurrentActivity);
                currentReactContext.onHostPause();
            } else if (this.mLifecycleState == LifecycleState.RESUMED) {
                currentReactContext.onHostPause();
            }
        }
        this.mLifecycleState = LifecycleState.BEFORE_RESUME;
    }

    private synchronized void moveToBeforeCreateLifecycleState() {
        ReactContext currentReactContext = getCurrentReactContext();
        if (currentReactContext != null) {
            if (this.mLifecycleState == LifecycleState.RESUMED) {
                currentReactContext.onHostPause();
                this.mLifecycleState = LifecycleState.BEFORE_RESUME;
            }
            if (this.mLifecycleState == LifecycleState.BEFORE_RESUME) {
                currentReactContext.onHostDestroy();
            }
        }
        this.mLifecycleState = LifecycleState.BEFORE_CREATE;
    }

    private synchronized void moveReactContextToCurrentLifecycleState() {
        if (this.mLifecycleState == LifecycleState.RESUMED) {
            moveToResumedLifecycleState(true);
        }
    }

    @ThreadConfined("UI")
    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        ReactContext currentReactContext = getCurrentReactContext();
        if (currentReactContext != null) {
            currentReactContext.onActivityResult(activity, i, i2, intent);
        }
    }

    @ThreadConfined("UI")
    public void showDevOptionsDialog() {
        UiThreadUtil.assertOnUiThread();
        this.mDevSupportManager.showDevOptionsDialog();
    }

    @ThreadConfined("UI")
    public void attachRootView(ReactRootView reactRootView) {
        UiThreadUtil.assertOnUiThread();
        this.mAttachedRootViews.add(reactRootView);
        reactRootView.removeAllViews();
        reactRootView.setId(-1);
        ReactContext currentReactContext = getCurrentReactContext();
        if (this.mCreateReactContextThread == null && currentReactContext != null) {
            attachRootViewToInstance(reactRootView, currentReactContext.getCatalystInstance());
        }
    }

    @ThreadConfined("UI")
    public void detachRootView(ReactRootView reactRootView) {
        UiThreadUtil.assertOnUiThread();
        if (this.mAttachedRootViews.remove(reactRootView)) {
            ReactContext currentReactContext = getCurrentReactContext();
            if (currentReactContext != null && currentReactContext.hasActiveCatalystInstance()) {
                detachViewFromInstance(reactRootView, currentReactContext.getCatalystInstance());
            }
        }
    }

    public List<ViewManager> getOrCreateViewManagers(ReactApplicationContext reactApplicationContext) {
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_VIEW_MANAGERS_START);
        Systrace.beginSection(0, "createAllViewManagers");
        try {
            if (this.mViewManagers == null) {
                synchronized (this.mPackages) {
                    if (this.mViewManagers == null) {
                        this.mViewManagers = new ArrayList();
                        for (ReactPackage createViewManagers : this.mPackages) {
                            this.mViewManagers.addAll(createViewManagers.createViewManagers(reactApplicationContext));
                        }
                        reactApplicationContext = this.mViewManagers;
                        Systrace.endSection(0);
                        ReactMarker.logMarker(ReactMarkerConstants.CREATE_VIEW_MANAGERS_END);
                        return reactApplicationContext;
                    }
                }
            }
            reactApplicationContext = this.mViewManagers;
            Systrace.endSection(0);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_VIEW_MANAGERS_END);
            return reactApplicationContext;
        } catch (Throwable th) {
            Systrace.endSection(0);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_VIEW_MANAGERS_END);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.facebook.react.uimanager.ViewManager createViewManager(java.lang.String r7) {
        /*
        r6 = this;
        r0 = r6.mReactContextLock;
        monitor-enter(r0);
        r1 = r6.getCurrentReactContext();	 Catch:{ all -> 0x003e }
        r1 = (com.facebook.react.bridge.ReactApplicationContext) r1;	 Catch:{ all -> 0x003e }
        r2 = 0;
        if (r1 == 0) goto L_0x003c;
    L_0x000c:
        r3 = r1.hasActiveCatalystInstance();	 Catch:{ all -> 0x003e }
        if (r3 != 0) goto L_0x0013;
    L_0x0012:
        goto L_0x003c;
    L_0x0013:
        monitor-exit(r0);	 Catch:{ all -> 0x003e }
        r3 = r6.mPackages;
        monitor-enter(r3);
        r0 = r6.mPackages;	 Catch:{ all -> 0x0039 }
        r0 = r0.iterator();	 Catch:{ all -> 0x0039 }
    L_0x001d:
        r4 = r0.hasNext();	 Catch:{ all -> 0x0039 }
        if (r4 == 0) goto L_0x0037;
    L_0x0023:
        r4 = r0.next();	 Catch:{ all -> 0x0039 }
        r4 = (com.facebook.react.ReactPackage) r4;	 Catch:{ all -> 0x0039 }
        r5 = r4 instanceof com.facebook.react.ViewManagerOnDemandReactPackage;	 Catch:{ all -> 0x0039 }
        if (r5 == 0) goto L_0x001d;
    L_0x002d:
        r4 = (com.facebook.react.ViewManagerOnDemandReactPackage) r4;	 Catch:{ all -> 0x0039 }
        r4 = r4.createViewManager(r1, r7);	 Catch:{ all -> 0x0039 }
        if (r4 == 0) goto L_0x001d;
    L_0x0035:
        monitor-exit(r3);	 Catch:{ all -> 0x0039 }
        return r4;
    L_0x0037:
        monitor-exit(r3);	 Catch:{ all -> 0x0039 }
        return r2;
    L_0x0039:
        r7 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0039 }
        throw r7;
    L_0x003c:
        monitor-exit(r0);	 Catch:{ all -> 0x003e }
        return r2;
    L_0x003e:
        r7 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x003e }
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.ReactInstanceManager.createViewManager(java.lang.String):com.facebook.react.uimanager.ViewManager");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.lang.String> getViewManagerNames() {
        /*
        r6 = this;
        r0 = r6.mReactContextLock;
        monitor-enter(r0);
        r1 = r6.getCurrentReactContext();	 Catch:{ all -> 0x004a }
        r1 = (com.facebook.react.bridge.ReactApplicationContext) r1;	 Catch:{ all -> 0x004a }
        if (r1 == 0) goto L_0x0047;
    L_0x000b:
        r2 = r1.hasActiveCatalystInstance();	 Catch:{ all -> 0x004a }
        if (r2 != 0) goto L_0x0012;
    L_0x0011:
        goto L_0x0047;
    L_0x0012:
        monitor-exit(r0);	 Catch:{ all -> 0x004a }
        r2 = r6.mPackages;
        monitor-enter(r2);
        r0 = new java.util.HashSet;	 Catch:{ all -> 0x0044 }
        r0.<init>();	 Catch:{ all -> 0x0044 }
        r3 = r6.mPackages;	 Catch:{ all -> 0x0044 }
        r3 = r3.iterator();	 Catch:{ all -> 0x0044 }
    L_0x0021:
        r4 = r3.hasNext();	 Catch:{ all -> 0x0044 }
        if (r4 == 0) goto L_0x003d;
    L_0x0027:
        r4 = r3.next();	 Catch:{ all -> 0x0044 }
        r4 = (com.facebook.react.ReactPackage) r4;	 Catch:{ all -> 0x0044 }
        r5 = r4 instanceof com.facebook.react.ViewManagerOnDemandReactPackage;	 Catch:{ all -> 0x0044 }
        if (r5 == 0) goto L_0x0021;
    L_0x0031:
        r4 = (com.facebook.react.ViewManagerOnDemandReactPackage) r4;	 Catch:{ all -> 0x0044 }
        r4 = r4.getViewManagerNames(r1);	 Catch:{ all -> 0x0044 }
        if (r4 == 0) goto L_0x0021;
    L_0x0039:
        r0.addAll(r4);	 Catch:{ all -> 0x0044 }
        goto L_0x0021;
    L_0x003d:
        r1 = new java.util.ArrayList;	 Catch:{ all -> 0x0044 }
        r1.<init>(r0);	 Catch:{ all -> 0x0044 }
        monitor-exit(r2);	 Catch:{ all -> 0x0044 }
        return r1;
    L_0x0044:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0044 }
        throw r0;
    L_0x0047:
        r1 = 0;
        monitor-exit(r0);	 Catch:{ all -> 0x004a }
        return r1;
    L_0x004a:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x004a }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.ReactInstanceManager.getViewManagerNames():java.util.List<java.lang.String>");
    }

    public void addReactInstanceEventListener(ReactInstanceEventListener reactInstanceEventListener) {
        this.mReactInstanceEventListeners.add(reactInstanceEventListener);
    }

    public void removeReactInstanceEventListener(ReactInstanceEventListener reactInstanceEventListener) {
        this.mReactInstanceEventListeners.remove(reactInstanceEventListener);
    }

    @VisibleForTesting
    public ReactContext getCurrentReactContext() {
        ReactContext reactContext;
        synchronized (this.mReactContextLock) {
            reactContext = this.mCurrentReactContext;
        }
        return reactContext;
    }

    public LifecycleState getLifecycleState() {
        return this.mLifecycleState;
    }

    @ThreadConfined("UI")
    private void onReloadWithJSDebugger(Factory factory) {
        Log.d(ReactConstants.TAG, "ReactInstanceManager.onReloadWithJSDebugger()");
        recreateReactContextInBackground(new ProxyJavaScriptExecutor.Factory(factory), JSBundleLoader.createRemoteDebuggerBundleLoader(this.mDevSupportManager.getJSBundleURLForRemoteDebugging(), this.mDevSupportManager.getSourceUrl()));
    }

    @ThreadConfined("UI")
    private void onJSBundleLoadedFromServer(NativeDeltaClient nativeDeltaClient) {
        Log.d(ReactConstants.TAG, "ReactInstanceManager.onJSBundleLoadedFromServer()");
        if (nativeDeltaClient == null) {
            nativeDeltaClient = JSBundleLoader.createCachedBundleFromNetworkLoader(this.mDevSupportManager.getSourceUrl(), this.mDevSupportManager.getDownloadedJSBundleFile());
        } else {
            nativeDeltaClient = JSBundleLoader.createDeltaFromNetworkLoader(this.mDevSupportManager.getSourceUrl(), nativeDeltaClient);
        }
        recreateReactContextInBackground(this.mJavaScriptExecutorFactory, nativeDeltaClient);
    }

    @ThreadConfined("UI")
    private void recreateReactContextInBackground(JavaScriptExecutorFactory javaScriptExecutorFactory, JSBundleLoader jSBundleLoader) {
        Log.d(ReactConstants.TAG, "ReactInstanceManager.recreateReactContextInBackground()");
        UiThreadUtil.assertOnUiThread();
        ReactContextInitParams reactContextInitParams = new ReactContextInitParams(javaScriptExecutorFactory, jSBundleLoader);
        if (this.mCreateReactContextThread == null) {
            runCreateReactContextOnNewThread(reactContextInitParams);
        } else {
            this.mPendingReactContextInitParams = reactContextInitParams;
        }
    }

    @ThreadConfined("UI")
    private void runCreateReactContextOnNewThread(final ReactContextInitParams reactContextInitParams) {
        Log.d(ReactConstants.TAG, "ReactInstanceManager.runCreateReactContextOnNewThread()");
        UiThreadUtil.assertOnUiThread();
        synchronized (this.mReactContextLock) {
            if (this.mCurrentReactContext != null) {
                tearDownReactContext(this.mCurrentReactContext);
                this.mCurrentReactContext = null;
            }
        }
        this.mCreateReactContextThread = new Thread(new Runnable() {

            /* renamed from: com.facebook.react.ReactInstanceManager$5$1 */
            class C18671 implements Runnable {
                C18671() {
                }

                public void run() {
                    if (ReactInstanceManager.this.mPendingReactContextInitParams != null) {
                        ReactInstanceManager.this.runCreateReactContextOnNewThread(ReactInstanceManager.this.mPendingReactContextInitParams);
                        ReactInstanceManager.this.mPendingReactContextInitParams = null;
                    }
                }
            }

            public void run() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
                /*
                r3 = this;
                r0 = com.facebook.react.bridge.ReactMarkerConstants.REACT_CONTEXT_THREAD_END;
                com.facebook.react.bridge.ReactMarker.logMarker(r0);
                r0 = com.facebook.react.ReactInstanceManager.this;
                r0 = r0.mHasStartedDestroying;
                monitor-enter(r0);
            L_0x000c:
                r1 = com.facebook.react.ReactInstanceManager.this;	 Catch:{ all -> 0x006a }
                r1 = r1.mHasStartedDestroying;	 Catch:{ all -> 0x006a }
                r1 = r1.booleanValue();	 Catch:{ all -> 0x006a }
                if (r1 == 0) goto L_0x0022;
            L_0x0018:
                r1 = com.facebook.react.ReactInstanceManager.this;	 Catch:{ InterruptedException -> 0x000c }
                r1 = r1.mHasStartedDestroying;	 Catch:{ InterruptedException -> 0x000c }
                r1.wait();	 Catch:{ InterruptedException -> 0x000c }
                goto L_0x000c;
            L_0x0022:
                monitor-exit(r0);	 Catch:{ all -> 0x006a }
                r0 = com.facebook.react.ReactInstanceManager.this;
                r1 = 1;
                r0.mHasStartedCreatingInitialContext = r1;
                r0 = -4;
                android.os.Process.setThreadPriority(r0);	 Catch:{ Exception -> 0x005f }
                r0 = com.facebook.react.ReactInstanceManager.this;	 Catch:{ Exception -> 0x005f }
                r1 = r3;	 Catch:{ Exception -> 0x005f }
                r1 = r1.getJsExecutorFactory();	 Catch:{ Exception -> 0x005f }
                r1 = r1.create();	 Catch:{ Exception -> 0x005f }
                r2 = r3;	 Catch:{ Exception -> 0x005f }
                r2 = r2.getJsBundleLoader();	 Catch:{ Exception -> 0x005f }
                r0 = r0.createReactContext(r1, r2);	 Catch:{ Exception -> 0x005f }
                r1 = com.facebook.react.ReactInstanceManager.this;	 Catch:{ Exception -> 0x005f }
                r2 = 0;	 Catch:{ Exception -> 0x005f }
                r1.mCreateReactContextThread = r2;	 Catch:{ Exception -> 0x005f }
                r1 = com.facebook.react.bridge.ReactMarkerConstants.PRE_SETUP_REACT_CONTEXT_START;	 Catch:{ Exception -> 0x005f }
                com.facebook.react.bridge.ReactMarker.logMarker(r1);	 Catch:{ Exception -> 0x005f }
                r1 = new com.facebook.react.ReactInstanceManager$5$1;	 Catch:{ Exception -> 0x005f }
                r1.<init>();	 Catch:{ Exception -> 0x005f }
                r2 = new com.facebook.react.ReactInstanceManager$5$2;	 Catch:{ Exception -> 0x005f }
                r2.<init>(r0);	 Catch:{ Exception -> 0x005f }
                r0.runOnNativeModulesQueueThread(r2);	 Catch:{ Exception -> 0x005f }
                com.facebook.react.bridge.UiThreadUtil.runOnUiThread(r1);	 Catch:{ Exception -> 0x005f }
                goto L_0x0069;
            L_0x005f:
                r0 = move-exception;
                r1 = com.facebook.react.ReactInstanceManager.this;
                r1 = r1.mDevSupportManager;
                r1.handleException(r0);
            L_0x0069:
                return;
            L_0x006a:
                r1 = move-exception;
                monitor-exit(r0);	 Catch:{ all -> 0x006a }
                throw r1;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.ReactInstanceManager.5.run():void");
            }
        });
        ReactMarker.logMarker(ReactMarkerConstants.REACT_CONTEXT_THREAD_START);
        this.mCreateReactContextThread.start();
    }

    private void setupReactContext(final ReactApplicationContext reactApplicationContext) {
        Log.d(ReactConstants.TAG, "ReactInstanceManager.setupReactContext()");
        ReactMarker.logMarker(ReactMarkerConstants.PRE_SETUP_REACT_CONTEXT_END);
        ReactMarker.logMarker(ReactMarkerConstants.SETUP_REACT_CONTEXT_START);
        Systrace.beginSection(0, "setupReactContext");
        synchronized (this.mReactContextLock) {
            this.mCurrentReactContext = (ReactContext) Assertions.assertNotNull(reactApplicationContext);
        }
        CatalystInstance catalystInstance = (CatalystInstance) Assertions.assertNotNull(reactApplicationContext.getCatalystInstance());
        catalystInstance.initialize();
        this.mDevSupportManager.onNewReactContextCreated(reactApplicationContext);
        this.mMemoryPressureRouter.addMemoryPressureListener(catalystInstance);
        moveReactContextToCurrentLifecycleState();
        ReactMarker.logMarker(ReactMarkerConstants.ATTACH_MEASURED_ROOT_VIEWS_START);
        synchronized (this.mAttachedRootViews) {
            for (ReactRootView attachRootViewToInstance : this.mAttachedRootViews) {
                attachRootViewToInstance(attachRootViewToInstance, catalystInstance);
            }
        }
        ReactMarker.logMarker(ReactMarkerConstants.ATTACH_MEASURED_ROOT_VIEWS_END);
        final ReactInstanceEventListener[] reactInstanceEventListenerArr = (ReactInstanceEventListener[]) this.mReactInstanceEventListeners.toArray(new ReactInstanceEventListener[this.mReactInstanceEventListeners.size()]);
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                for (ReactInstanceEventListener onReactContextInitialized : reactInstanceEventListenerArr) {
                    onReactContextInitialized.onReactContextInitialized(reactApplicationContext);
                }
            }
        });
        Systrace.endSection(0);
        ReactMarker.logMarker(ReactMarkerConstants.SETUP_REACT_CONTEXT_END);
        reactApplicationContext.runOnJSQueueThread(new C18717());
        reactApplicationContext.runOnNativeModulesQueueThread(new C18728());
    }

    private void attachRootViewToInstance(final ReactRootView reactRootView, CatalystInstance catalystInstance) {
        Log.d(ReactConstants.TAG, "ReactInstanceManager.attachRootViewToInstance()");
        Systrace.beginSection(0, "attachRootViewToInstance");
        catalystInstance = UIManagerHelper.getUIManager(this.mCurrentReactContext, reactRootView.getUIManagerType()).addRootView(reactRootView);
        reactRootView.setRootViewTag(catalystInstance);
        reactRootView.runApplication();
        Systrace.beginAsyncSection(0, "pre_rootView.onAttachedToReactInstance", catalystInstance);
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                Systrace.endAsyncSection(0, "pre_rootView.onAttachedToReactInstance", catalystInstance);
                reactRootView.onAttachedToReactInstance();
            }
        });
        Systrace.endSection(0);
    }

    private void detachViewFromInstance(ReactRootView reactRootView, CatalystInstance catalystInstance) {
        Log.d(ReactConstants.TAG, "ReactInstanceManager.detachViewFromInstance()");
        UiThreadUtil.assertOnUiThread();
        if (reactRootView.getUIManagerType() == 2) {
            ((ReactFabric) catalystInstance.getJSModule(ReactFabric.class)).unmountComponentAtNode(reactRootView.getId());
        } else {
            ((AppRegistry) catalystInstance.getJSModule(AppRegistry.class)).unmountApplicationComponentAtRootTag(reactRootView.getId());
        }
    }

    private void tearDownReactContext(ReactContext reactContext) {
        Log.d(ReactConstants.TAG, "ReactInstanceManager.tearDownReactContext()");
        UiThreadUtil.assertOnUiThread();
        if (this.mLifecycleState == LifecycleState.RESUMED) {
            reactContext.onHostPause();
        }
        synchronized (this.mAttachedRootViews) {
            for (ReactRootView reactRootView : this.mAttachedRootViews) {
                reactRootView.removeAllViews();
                reactRootView.setId(-1);
            }
        }
        reactContext.destroy();
        this.mDevSupportManager.onReactInstanceDestroyed(reactContext);
        this.mMemoryPressureRouter.removeMemoryPressureListener(reactContext.getCatalystInstance());
    }

    private ReactApplicationContext createReactContext(JavaScriptExecutor javaScriptExecutor, JSBundleLoader jSBundleLoader) {
        Log.d(ReactConstants.TAG, "ReactInstanceManager.createReactContext()");
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_REACT_CONTEXT_START, javaScriptExecutor.getName());
        ReactApplicationContext reactApplicationContext = new ReactApplicationContext(this.mApplicationContext);
        NativeModuleCallExceptionHandler nativeModuleCallExceptionHandler = this.mNativeModuleCallExceptionHandler != null ? this.mNativeModuleCallExceptionHandler : this.mDevSupportManager;
        reactApplicationContext.setNativeModuleCallExceptionHandler(nativeModuleCallExceptionHandler);
        javaScriptExecutor = new Builder().setReactQueueConfigurationSpec(ReactQueueConfigurationSpec.createDefault()).setJSExecutor(javaScriptExecutor).setRegistry(processPackages(reactApplicationContext, this.mPackages, false)).setJSBundleLoader(jSBundleLoader).setNativeModuleCallExceptionHandler(nativeModuleCallExceptionHandler);
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_CATALYST_INSTANCE_START);
        Systrace.beginSection(0, "createCatalystInstance");
        try {
            javaScriptExecutor = javaScriptExecutor.build();
            if (this.mJSIModulePackage != null) {
                javaScriptExecutor.addJSIModules(this.mJSIModulePackage.getJSIModules(reactApplicationContext, javaScriptExecutor.getJavaScriptContextHolder()));
            }
            if (this.mBridgeIdleDebugListener != null) {
                javaScriptExecutor.addBridgeIdleDebugListener(this.mBridgeIdleDebugListener);
            }
            if (Systrace.isTracing(0) != null) {
                javaScriptExecutor.setGlobalVariable("__RCTProfileIsProfiling", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            }
            ReactMarker.logMarker(ReactMarkerConstants.PRE_RUN_JS_BUNDLE_START);
            javaScriptExecutor.runJSBundle();
            reactApplicationContext.initializeWithInstance(javaScriptExecutor);
            return reactApplicationContext;
        } finally {
            Systrace.endSection(0);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_CATALYST_INSTANCE_END);
        }
    }

    private NativeModuleRegistry processPackages(ReactApplicationContext reactApplicationContext, List<ReactPackage> list, boolean z) {
        NativeModuleRegistryBuilder nativeModuleRegistryBuilder = new NativeModuleRegistryBuilder(reactApplicationContext, this);
        ReactMarker.logMarker(ReactMarkerConstants.PROCESS_PACKAGES_START);
        synchronized (this.mPackages) {
            for (ReactPackage reactPackage : list) {
                if (!z || !this.mPackages.contains(reactPackage)) {
                    Systrace.beginSection(0, "createAndProcessCustomReactPackage");
                    if (z) {
                        try {
                            this.mPackages.add(reactPackage);
                        } catch (Throwable th) {
                            Systrace.endSection(0);
                        }
                    }
                    processPackage(reactPackage, nativeModuleRegistryBuilder);
                    Systrace.endSection(0);
                }
            }
        }
        ReactMarker.logMarker(ReactMarkerConstants.PROCESS_PACKAGES_END);
        ReactMarker.logMarker(ReactMarkerConstants.BUILD_NATIVE_MODULE_REGISTRY_START);
        Systrace.beginSection(0, "buildNativeModuleRegistry");
        try {
            reactApplicationContext = nativeModuleRegistryBuilder.build();
            return reactApplicationContext;
        } finally {
            Systrace.endSection(0);
            ReactMarker.logMarker(ReactMarkerConstants.BUILD_NATIVE_MODULE_REGISTRY_END);
        }
    }

    private void processPackage(ReactPackage reactPackage, NativeModuleRegistryBuilder nativeModuleRegistryBuilder) {
        SystraceMessage.beginSection(0, "processPackage").arg("className", reactPackage.getClass().getSimpleName()).flush();
        boolean z = reactPackage instanceof ReactPackageLogger;
        if (z) {
            ((ReactPackageLogger) reactPackage).startProcessPackage();
        }
        nativeModuleRegistryBuilder.processPackage(reactPackage);
        if (z) {
            ((ReactPackageLogger) reactPackage).endProcessPackage();
        }
        SystraceMessage.endSection(0).flush();
    }
}
