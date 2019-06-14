package com.facebook.react.bridge;

import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.util.Log;
import com.facebook.common.logging.FLog;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.queue.MessageQueueThread;
import com.facebook.react.bridge.queue.QueueThreadExceptionHandler;
import com.facebook.react.bridge.queue.ReactQueueConfiguration;
import com.facebook.react.bridge.queue.ReactQueueConfigurationImpl;
import com.facebook.react.bridge.queue.ReactQueueConfigurationSpec;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.TraceListener;
import expolib_v1.com.facebook.infer.annotation.Assertions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@DoNotStrip
public class CatalystInstanceImpl implements CatalystInstance {
    private static final AtomicInteger sNextInstanceIdForTrace = new AtomicInteger(1);
    private volatile boolean mAcceptCalls;
    private final CopyOnWriteArrayList<NotThreadSafeBridgeIdleDebugListener> mBridgeIdleListeners;
    private volatile boolean mDestroyed;
    private final HybridData mHybridData;
    private boolean mInitialized;
    private boolean mJSBundleHasLoaded;
    private final JSBundleLoader mJSBundleLoader;
    private final ArrayList<PendingJSCall> mJSCallsPendingInit;
    private final Object mJSCallsPendingInitLock;
    private final JSIModuleRegistry mJSIModuleRegistry;
    private final JavaScriptModuleRegistry mJSModuleRegistry;
    private JavaScriptContextHolder mJavaScriptContextHolder;
    private final String mJsPendingCallsTitleForTrace;
    private final NativeModuleCallExceptionHandler mNativeModuleCallExceptionHandler;
    private final NativeModuleRegistry mNativeModuleRegistry;
    private final MessageQueueThread mNativeModulesQueueThread;
    private final AtomicInteger mPendingJSCalls;
    private final ReactQueueConfigurationImpl mReactQueueConfiguration;
    private String mSourceURL;
    private final TraceListener mTraceListener;

    /* renamed from: com.facebook.react.bridge.CatalystInstanceImpl$1 */
    class C18801 implements Runnable {

        /* renamed from: com.facebook.react.bridge.CatalystInstanceImpl$1$1 */
        class C18791 implements Runnable {
            C18791() {
            }

            public void run() {
                CatalystInstanceImpl.this.mJavaScriptContextHolder.clear();
                CatalystInstanceImpl.this.mHybridData.resetNative();
                CatalystInstanceImpl.this.getReactQueueConfiguration().destroy();
                Log.d(ReactConstants.TAG, "CatalystInstanceImpl.destroy() end");
                ReactMarker.logMarker(ReactMarkerConstants.DESTROY_CATALYST_INSTANCE_END);
            }
        }

        C18801() {
        }

        public void run() {
            CatalystInstanceImpl.this.mNativeModuleRegistry.notifyJSInstanceDestroy();
            CatalystInstanceImpl.this.mJSIModuleRegistry.notifyJSInstanceDestroy();
            int i = 0;
            if (CatalystInstanceImpl.this.mPendingJSCalls.getAndSet(0) == 0) {
                i = 1;
            }
            if (!CatalystInstanceImpl.this.mBridgeIdleListeners.isEmpty()) {
                Iterator it = CatalystInstanceImpl.this.mBridgeIdleListeners.iterator();
                while (it.hasNext()) {
                    NotThreadSafeBridgeIdleDebugListener notThreadSafeBridgeIdleDebugListener = (NotThreadSafeBridgeIdleDebugListener) it.next();
                    if (i == 0) {
                        notThreadSafeBridgeIdleDebugListener.onTransitionToBridgeIdle();
                    }
                    notThreadSafeBridgeIdleDebugListener.onBridgeDestroyed();
                }
            }
            AsyncTask.execute(new C18791());
        }
    }

    /* renamed from: com.facebook.react.bridge.CatalystInstanceImpl$2 */
    class C18812 implements Runnable {
        C18812() {
        }

        public void run() {
            CatalystInstanceImpl.this.mNativeModuleRegistry.notifyJSInstanceInitialized();
        }
    }

    /* renamed from: com.facebook.react.bridge.CatalystInstanceImpl$3 */
    class C18823 implements Runnable {
        C18823() {
        }

        public void run() {
            Iterator it = CatalystInstanceImpl.this.mBridgeIdleListeners.iterator();
            while (it.hasNext()) {
                ((NotThreadSafeBridgeIdleDebugListener) it.next()).onTransitionToBridgeBusy();
            }
        }
    }

    /* renamed from: com.facebook.react.bridge.CatalystInstanceImpl$4 */
    class C18834 implements Runnable {
        C18834() {
        }

        public void run() {
            Iterator it = CatalystInstanceImpl.this.mBridgeIdleListeners.iterator();
            while (it.hasNext()) {
                ((NotThreadSafeBridgeIdleDebugListener) it.next()).onTransitionToBridgeIdle();
            }
        }
    }

    /* renamed from: com.facebook.react.bridge.CatalystInstanceImpl$5 */
    class C18845 implements Runnable {
        C18845() {
        }

        public void run() {
            CatalystInstanceImpl.this.destroy();
        }
    }

    public static class Builder {
        private JSBundleLoader mJSBundleLoader;
        private JavaScriptExecutor mJSExecutor;
        private NativeModuleCallExceptionHandler mNativeModuleCallExceptionHandler;
        private ReactQueueConfigurationSpec mReactQueueConfigurationSpec;
        private NativeModuleRegistry mRegistry;

        public Builder setReactQueueConfigurationSpec(ReactQueueConfigurationSpec reactQueueConfigurationSpec) {
            this.mReactQueueConfigurationSpec = reactQueueConfigurationSpec;
            return this;
        }

        public Builder setRegistry(NativeModuleRegistry nativeModuleRegistry) {
            this.mRegistry = nativeModuleRegistry;
            return this;
        }

        public Builder setJSBundleLoader(JSBundleLoader jSBundleLoader) {
            this.mJSBundleLoader = jSBundleLoader;
            return this;
        }

        public Builder setJSExecutor(JavaScriptExecutor javaScriptExecutor) {
            this.mJSExecutor = javaScriptExecutor;
            return this;
        }

        public Builder setNativeModuleCallExceptionHandler(NativeModuleCallExceptionHandler nativeModuleCallExceptionHandler) {
            this.mNativeModuleCallExceptionHandler = nativeModuleCallExceptionHandler;
            return this;
        }

        public CatalystInstanceImpl build() {
            return new CatalystInstanceImpl((ReactQueueConfigurationSpec) Assertions.assertNotNull(this.mReactQueueConfigurationSpec), (JavaScriptExecutor) Assertions.assertNotNull(this.mJSExecutor), (NativeModuleRegistry) Assertions.assertNotNull(this.mRegistry), (JSBundleLoader) Assertions.assertNotNull(this.mJSBundleLoader), (NativeModuleCallExceptionHandler) Assertions.assertNotNull(this.mNativeModuleCallExceptionHandler));
        }
    }

    public static class PendingJSCall {
        public NativeArray mArguments;
        public String mMethod;
        public String mModule;

        public PendingJSCall(String str, String str2, NativeArray nativeArray) {
            this.mModule = str;
            this.mMethod = str2;
            this.mArguments = nativeArray;
        }

        void call(CatalystInstanceImpl catalystInstanceImpl) {
            catalystInstanceImpl.jniCallJSFunction(this.mModule, this.mMethod, this.mArguments != null ? this.mArguments : new WritableNativeArray());
        }

        public String toString() {
            String str;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.mModule);
            stringBuilder.append(".");
            stringBuilder.append(this.mMethod);
            stringBuilder.append("(");
            if (this.mArguments == null) {
                str = "";
            } else {
                str = this.mArguments.toString();
            }
            stringBuilder.append(str);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    private static class BridgeCallback implements ReactCallback {
        private final WeakReference<CatalystInstanceImpl> mOuter;

        BridgeCallback(CatalystInstanceImpl catalystInstanceImpl) {
            this.mOuter = new WeakReference(catalystInstanceImpl);
        }

        public void onBatchComplete() {
            CatalystInstanceImpl catalystInstanceImpl = (CatalystInstanceImpl) this.mOuter.get();
            if (catalystInstanceImpl != null) {
                catalystInstanceImpl.mNativeModuleRegistry.onBatchComplete();
            }
        }

        public void incrementPendingJSCalls() {
            CatalystInstanceImpl catalystInstanceImpl = (CatalystInstanceImpl) this.mOuter.get();
            if (catalystInstanceImpl != null) {
                catalystInstanceImpl.incrementPendingJSCalls();
            }
        }

        public void decrementPendingJSCalls() {
            CatalystInstanceImpl catalystInstanceImpl = (CatalystInstanceImpl) this.mOuter.get();
            if (catalystInstanceImpl != null) {
                catalystInstanceImpl.decrementPendingJSCalls();
            }
        }
    }

    private static class JSProfilerTraceListener implements TraceListener {
        private final WeakReference<CatalystInstanceImpl> mOuter;

        public JSProfilerTraceListener(CatalystInstanceImpl catalystInstanceImpl) {
            this.mOuter = new WeakReference(catalystInstanceImpl);
        }

        public void onTraceStarted() {
            CatalystInstanceImpl catalystInstanceImpl = (CatalystInstanceImpl) this.mOuter.get();
            if (catalystInstanceImpl != null) {
                ((Systrace) catalystInstanceImpl.getJSModule(Systrace.class)).setEnabled(true);
            }
        }

        public void onTraceStopped() {
            CatalystInstanceImpl catalystInstanceImpl = (CatalystInstanceImpl) this.mOuter.get();
            if (catalystInstanceImpl != null) {
                ((Systrace) catalystInstanceImpl.getJSModule(Systrace.class)).setEnabled(false);
            }
        }
    }

    private class NativeExceptionHandler implements QueueThreadExceptionHandler {
        private NativeExceptionHandler() {
        }

        public void handleException(Exception exception) {
            CatalystInstanceImpl.this.onNativeException(exception);
        }
    }

    private native long getJavaScriptContext();

    private static native HybridData initHybrid();

    private native void initializeBridge(ReactCallback reactCallback, JavaScriptExecutor javaScriptExecutor, MessageQueueThread messageQueueThread, MessageQueueThread messageQueueThread2, Collection<JavaModuleWrapper> collection, Collection<ModuleHolder> collection2);

    private native void jniCallJSCallback(int i, NativeArray nativeArray);

    private native void jniCallJSFunction(String str, String str2, NativeArray nativeArray);

    private native void jniExtendNativeModules(Collection<JavaModuleWrapper> collection, Collection<ModuleHolder> collection2);

    private native void jniHandleMemoryPressure(int i);

    private native void jniLoadScriptFromAssets(AssetManager assetManager, String str, boolean z);

    private native void jniLoadScriptFromDeltaBundle(String str, NativeDeltaClient nativeDeltaClient, boolean z);

    private native void jniLoadScriptFromFile(String str, String str2, boolean z);

    private native void jniLoadScriptFromString(String str, String str2, boolean z);

    private native void jniRegisterSegment(int i, String str);

    private native void jniSetSourceURL(String str);

    public native void setGlobalVariable(String str, String str2);

    static {
        ReactBridge.staticInit();
    }

    private CatalystInstanceImpl(ReactQueueConfigurationSpec reactQueueConfigurationSpec, JavaScriptExecutor javaScriptExecutor, NativeModuleRegistry nativeModuleRegistry, JSBundleLoader jSBundleLoader, NativeModuleCallExceptionHandler nativeModuleCallExceptionHandler) {
        this.mPendingJSCalls = new AtomicInteger(0);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("pending_js_calls_instance");
        stringBuilder.append(sNextInstanceIdForTrace.getAndIncrement());
        this.mJsPendingCallsTitleForTrace = stringBuilder.toString();
        this.mDestroyed = false;
        this.mJSCallsPendingInit = new ArrayList();
        this.mJSCallsPendingInitLock = new Object();
        this.mJSIModuleRegistry = new JSIModuleRegistry();
        this.mInitialized = false;
        this.mAcceptCalls = false;
        Log.d(ReactConstants.TAG, "Initializing React Xplat Bridge.");
        this.mHybridData = initHybrid();
        this.mReactQueueConfiguration = ReactQueueConfigurationImpl.create(reactQueueConfigurationSpec, new NativeExceptionHandler());
        this.mBridgeIdleListeners = new CopyOnWriteArrayList();
        this.mNativeModuleRegistry = nativeModuleRegistry;
        this.mJSModuleRegistry = new JavaScriptModuleRegistry();
        this.mJSBundleLoader = jSBundleLoader;
        this.mNativeModuleCallExceptionHandler = nativeModuleCallExceptionHandler;
        this.mNativeModulesQueueThread = this.mReactQueueConfiguration.getNativeModulesQueueThread();
        this.mTraceListener = new JSProfilerTraceListener(this);
        Log.d(ReactConstants.TAG, "Initializing React Xplat Bridge before initializeBridge");
        initializeBridge(new BridgeCallback(this), javaScriptExecutor, this.mReactQueueConfiguration.getJSQueueThread(), this.mNativeModulesQueueThread, this.mNativeModuleRegistry.getJavaModules(this), this.mNativeModuleRegistry.getCxxModules());
        Log.d(ReactConstants.TAG, "Initializing React Xplat Bridge after initializeBridge");
        this.mJavaScriptContextHolder = new JavaScriptContextHolder(getJavaScriptContext());
    }

    public void extendNativeModules(NativeModuleRegistry nativeModuleRegistry) {
        this.mNativeModuleRegistry.registerModules(nativeModuleRegistry);
        jniExtendNativeModules(nativeModuleRegistry.getJavaModules(this), nativeModuleRegistry.getCxxModules());
    }

    void setSourceURLs(String str, String str2) {
        this.mSourceURL = str;
        jniSetSourceURL(str2);
    }

    public void registerSegment(int i, String str) {
        jniRegisterSegment(i, str);
    }

    void loadScriptFromAssets(AssetManager assetManager, String str, boolean z) {
        this.mSourceURL = str;
        jniLoadScriptFromAssets(assetManager, str, z);
    }

    void loadScriptFromFile(java.lang.String r7, java.lang.String r8, boolean r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r6 = this;
        r6.mSourceURL = r8;
        r0 = "host.exp.exponent.ReactNativeStaticHelpers";	 Catch:{ Exception -> 0x004c }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Exception -> 0x004c }
        r1 = "getBundleSourceForPath";	 Catch:{ Exception -> 0x004c }
        r2 = 1;	 Catch:{ Exception -> 0x004c }
        r3 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x004c }
        r4 = java.lang.String.class;	 Catch:{ Exception -> 0x004c }
        r5 = 0;	 Catch:{ Exception -> 0x004c }
        r3[r5] = r4;	 Catch:{ Exception -> 0x004c }
        r0 = r0.getMethod(r1, r3);	 Catch:{ Exception -> 0x004c }
        r1 = 0;	 Catch:{ Exception -> 0x004c }
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x004c }
        r2[r5] = r7;	 Catch:{ Exception -> 0x004c }
        r0 = r0.invoke(r1, r2);	 Catch:{ Exception -> 0x004c }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x004c }
        if (r0 != 0) goto L_0x002e;	 Catch:{ Exception -> 0x004c }
    L_0x0023:
        r0 = "CatalystInstanceImpl";	 Catch:{ Exception -> 0x004c }
        r1 = "Loading script from file";	 Catch:{ Exception -> 0x004c }
        android.util.Log.d(r0, r1);	 Catch:{ Exception -> 0x004c }
        r6.jniLoadScriptFromFile(r7, r8, r9);	 Catch:{ Exception -> 0x004c }
        goto L_0x0056;	 Catch:{ Exception -> 0x004c }
    L_0x002e:
        r1 = "CatalystInstanceImpl";	 Catch:{ Exception -> 0x004c }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x004c }
        r2.<init>();	 Catch:{ Exception -> 0x004c }
        r3 = "Loading script from string. Length: ";	 Catch:{ Exception -> 0x004c }
        r2.append(r3);	 Catch:{ Exception -> 0x004c }
        r3 = r0.length();	 Catch:{ Exception -> 0x004c }
        r2.append(r3);	 Catch:{ Exception -> 0x004c }
        r2 = r2.toString();	 Catch:{ Exception -> 0x004c }
        android.util.Log.d(r1, r2);	 Catch:{ Exception -> 0x004c }
        r6.jniLoadScriptFromString(r0, r8, r9);	 Catch:{ Exception -> 0x004c }
        goto L_0x0056;
    L_0x004c:
        r0 = "CatalystInstanceImpl";
        r1 = "Loading script from file";
        android.util.Log.d(r0, r1);
        r6.jniLoadScriptFromFile(r7, r8, r9);
    L_0x0056:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.bridge.CatalystInstanceImpl.loadScriptFromFile(java.lang.String, java.lang.String, boolean):void");
    }

    void loadScriptFromDeltaBundle(String str, NativeDeltaClient nativeDeltaClient, boolean z) {
        this.mSourceURL = str;
        jniLoadScriptFromDeltaBundle(str, nativeDeltaClient, z);
    }

    public void runJSBundle() {
        Log.d(ReactConstants.TAG, "CatalystInstanceImpl.runJSBundle()");
        Assertions.assertCondition(this.mJSBundleHasLoaded ^ true, "JS bundle was already loaded!");
        this.mJSBundleLoader.loadScript(this);
        synchronized (this.mJSCallsPendingInitLock) {
            this.mAcceptCalls = true;
            Iterator it = this.mJSCallsPendingInit.iterator();
            while (it.hasNext()) {
                ((PendingJSCall) it.next()).call(this);
            }
            this.mJSCallsPendingInit.clear();
            this.mJSBundleHasLoaded = true;
        }
        Systrace.registerListener(this.mTraceListener);
    }

    public boolean hasRunJSBundle() {
        boolean z;
        synchronized (this.mJSCallsPendingInitLock) {
            z = this.mJSBundleHasLoaded && this.mAcceptCalls;
        }
        return z;
    }

    public String getSourceURL() {
        return this.mSourceURL;
    }

    public void callFunction(String str, String str2, NativeArray nativeArray) {
        callFunction(new PendingJSCall(str, str2, nativeArray));
    }

    public void callFunction(PendingJSCall pendingJSCall) {
        if (this.mDestroyed) {
            pendingJSCall = pendingJSCall.toString();
            String str = ReactConstants.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Calling JS function after bridge has been destroyed: ");
            stringBuilder.append(pendingJSCall);
            FLog.m5714w(str, stringBuilder.toString());
            return;
        }
        if (!this.mAcceptCalls) {
            synchronized (this.mJSCallsPendingInitLock) {
                if (!this.mAcceptCalls) {
                    this.mJSCallsPendingInit.add(pendingJSCall);
                    return;
                }
            }
        }
        pendingJSCall.call(this);
    }

    public void invokeCallback(int i, NativeArray nativeArray) {
        if (this.mDestroyed) {
            FLog.m5714w(ReactConstants.TAG, "Invoking JS callback after bridge has been destroyed.");
        } else {
            jniCallJSCallback(i, nativeArray);
        }
    }

    public void destroy() {
        Log.d(ReactConstants.TAG, "CatalystInstanceImpl.destroy() start");
        UiThreadUtil.assertOnUiThread();
        if (!this.mDestroyed) {
            ReactMarker.logMarker(ReactMarkerConstants.DESTROY_CATALYST_INSTANCE_START);
            this.mDestroyed = true;
            this.mNativeModulesQueueThread.runOnQueue(new C18801());
            Systrace.unregisterListener(this.mTraceListener);
        }
    }

    public boolean isDestroyed() {
        return this.mDestroyed;
    }

    @VisibleForTesting
    public void initialize() {
        Log.d(ReactConstants.TAG, "CatalystInstanceImpl.initialize()");
        Assertions.assertCondition(this.mInitialized ^ true, "This catalyst instance has already been initialized");
        Assertions.assertCondition(this.mAcceptCalls, "RunJSBundle hasn't completed.");
        this.mInitialized = true;
        this.mNativeModulesQueueThread.runOnQueue(new C18812());
    }

    public ReactQueueConfiguration getReactQueueConfiguration() {
        return this.mReactQueueConfiguration;
    }

    public <T extends JavaScriptModule> T getJSModule(Class<T> cls) {
        return this.mJSModuleRegistry.getJavaScriptModule(this, cls);
    }

    public <T extends NativeModule> boolean hasNativeModule(Class<T> cls) {
        return this.mNativeModuleRegistry.hasModule(cls);
    }

    public <T extends NativeModule> T getNativeModule(Class<T> cls) {
        return this.mNativeModuleRegistry.getModule(cls);
    }

    public Collection<NativeModule> getNativeModules() {
        return this.mNativeModuleRegistry.getAllModules();
    }

    public void handleMemoryPressure(int i) {
        if (!this.mDestroyed) {
            jniHandleMemoryPressure(i);
        }
    }

    public void addBridgeIdleDebugListener(NotThreadSafeBridgeIdleDebugListener notThreadSafeBridgeIdleDebugListener) {
        this.mBridgeIdleListeners.add(notThreadSafeBridgeIdleDebugListener);
    }

    public void removeBridgeIdleDebugListener(NotThreadSafeBridgeIdleDebugListener notThreadSafeBridgeIdleDebugListener) {
        this.mBridgeIdleListeners.remove(notThreadSafeBridgeIdleDebugListener);
    }

    public JavaScriptContextHolder getJavaScriptContextHolder() {
        return this.mJavaScriptContextHolder;
    }

    public void addJSIModules(List<JSIModuleSpec> list) {
        this.mJSIModuleRegistry.registerModules(list);
    }

    public <T extends JSIModule> T getJSIModule(Class<T> cls) {
        return this.mJSIModuleRegistry.getModule(cls);
    }

    private void incrementPendingJSCalls() {
        int andIncrement = this.mPendingJSCalls.getAndIncrement();
        Object obj = andIncrement == 0 ? 1 : null;
        Systrace.traceCounter(0, this.mJsPendingCallsTitleForTrace, andIncrement + 1);
        if (obj != null && !this.mBridgeIdleListeners.isEmpty()) {
            this.mNativeModulesQueueThread.runOnQueue(new C18823());
        }
    }

    private void decrementPendingJSCalls() {
        int decrementAndGet = this.mPendingJSCalls.decrementAndGet();
        Object obj = decrementAndGet == 0 ? 1 : null;
        Systrace.traceCounter(0, this.mJsPendingCallsTitleForTrace, decrementAndGet);
        if (obj != null && !this.mBridgeIdleListeners.isEmpty()) {
            this.mNativeModulesQueueThread.runOnQueue(new C18834());
        }
    }

    private void onNativeException(Exception exception) {
        this.mNativeModuleCallExceptionHandler.handleException(exception);
        this.mReactQueueConfiguration.getUIQueueThread().runOnQueue(new C18845());
    }
}
