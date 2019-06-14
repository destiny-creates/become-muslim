package com.facebook.react.devsupport;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Pair;
import android.widget.Toast;
import com.facebook.common.logging.FLog;
import com.facebook.debug.holder.PrinterHolder;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.react.C1864R;
import com.facebook.react.bridge.DefaultNativeModuleCallExceptionHandler;
import com.facebook.react.bridge.JavaJSExecutor;
import com.facebook.react.bridge.JavaJSExecutor.Factory;
import com.facebook.react.bridge.NativeDeltaClient;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.DebugServerException;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.common.ShakeDetector;
import com.facebook.react.common.ShakeDetector.ShakeListener;
import com.facebook.react.common.futures.SimpleSettableFuture;
import com.facebook.react.devsupport.BundleDownloader.BundleInfo;
import com.facebook.react.devsupport.DevInternalSettings.Listener;
import com.facebook.react.devsupport.DevServerHelper.OnServerContentChangeListener;
import com.facebook.react.devsupport.DevServerHelper.PackagerCommandListener;
import com.facebook.react.devsupport.InspectorPackagerConnection.BundleStatus;
import com.facebook.react.devsupport.InspectorPackagerConnection.BundleStatusProvider;
import com.facebook.react.devsupport.JSCHeapCapture.CaptureCallback;
import com.facebook.react.devsupport.JSCHeapCapture.CaptureException;
import com.facebook.react.devsupport.WebsocketJavaScriptExecutor.JSExecutorConnectCallback;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.devsupport.interfaces.DevOptionHandler;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.ErrorCustomizer;
import com.facebook.react.devsupport.interfaces.PackagerStatusCallback;
import com.facebook.react.devsupport.interfaces.StackFrame;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import com.facebook.react.packagerconnection.RequestHandler;
import com.facebook.react.packagerconnection.Responder;
import expolib_v1.com.facebook.infer.annotation.Assertions;
import expolib_v1.p321a.C6240u;
import expolib_v1.p321a.C6246z.C6245a;
import expolib_v1.p321a.C7490w;
import expolib_v1.p321a.aa;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@TargetApi(11)
public class DevSupportManagerImpl implements Listener, PackagerCommandListener, DevSupportManager {
    public static String EMOJI_FACE_WITH_NO_GOOD_GESTURE = " 🙅";
    public static String EMOJI_HUNDRED_POINTS_SYMBOL = " 💯";
    public static String EXOPACKAGE_LOCATION_FORMAT = "/data/local/tmp/exopackage/%s//secondary-dex";
    public static int JAVA_ERROR_COOKIE = -1;
    public static int JSEXCEPTION_ERROR_COOKIE = -1;
    public static String JS_BUNDLE_FILE_NAME = "ReactNativeDevBundle.js";
    public static String RELOAD_APP_ACTION_SUFFIX = ".RELOAD_APP_ACTION";
    public final Context mApplicationContext;
    public DevBundleDownloadListener mBundleDownloadListener;
    public BundleStatus mBundleStatus;
    public ReactContext mCurrentContext;
    public final LinkedHashMap<String, DevOptionHandler> mCustomDevOptions;
    public Map<String, RequestHandler> mCustomPackagerCommandHandlers;
    public DebugOverlayController mDebugOverlayController;
    public final DefaultNativeModuleCallExceptionHandler mDefaultNativeModuleCallExceptionHandler;
    public final DevLoadingViewController mDevLoadingViewController;
    public boolean mDevLoadingViewVisible;
    public AlertDialog mDevOptionsDialog;
    public final DevServerHelper mDevServerHelper;
    public DevInternalSettings mDevSettings;
    public List<ErrorCustomizer> mErrorCustomizers;
    public final List<ExceptionLogger> mExceptionLoggers;
    public boolean mIsDevSupportEnabled;
    public boolean mIsReceiverRegistered;
    public boolean mIsShakeDetectorStarted;
    public final String mJSAppBundleName;
    public final File mJSBundleTempFile;
    public int mLastErrorCookie;
    public StackFrame[] mLastErrorStack;
    public String mLastErrorTitle;
    public ErrorType mLastErrorType;
    public final ReactInstanceManagerDevHelper mReactInstanceManagerHelper;
    public RedBoxDialog mRedBoxDialog;
    public RedBoxHandler mRedBoxHandler;
    public final BroadcastReceiver mReloadAppBroadcastReceiver;
    public final ShakeDetector mShakeDetector;

    /* renamed from: com.facebook.react.devsupport.DevSupportManagerImpl$3 */
    class C19133 extends BroadcastReceiver {
        C19133() {
        }

        public void onReceive(Context context, Intent intent) {
            if (DevSupportManagerImpl.getReloadAppAction(context).equals(intent.getAction()) != null) {
                if (intent.getBooleanExtra(DevServerHelper.RELOAD_APP_EXTRA_JS_PROXY, false) != null) {
                    DevSupportManagerImpl.this.mDevSettings.setRemoteJSDebugEnabled(true);
                    DevSupportManagerImpl.this.mDevServerHelper.launchJSDevtools();
                } else {
                    DevSupportManagerImpl.this.mDevSettings.setRemoteJSDebugEnabled(false);
                }
                DevSupportManagerImpl.this.handleReloadJS();
            }
        }
    }

    private enum ErrorType {
        JS,
        NATIVE
    }

    private interface ExceptionLogger {
        void log(Exception exception);
    }

    private static class JscProfileTask extends AsyncTask<String, Void, Void> {
        public static C6240u JSON = C6240u.a("application/json; charset=utf-8");
        public final String mSourceUrl;

        private JscProfileTask(String str) {
            this.mSourceUrl = str;
        }

        protected Void doInBackground(String... strArr) {
            try {
                String uri = Uri.parse(this.mSourceUrl).buildUpon().path("/jsc-profile").query(null).build().toString();
                C7490w c7490w = new C7490w();
                for (String create : strArr) {
                    c7490w.a(new C6245a().a(uri).a(aa.create(JSON, create)).b()).b();
                }
            } catch (Throwable e) {
                FLog.m5675e(ReactConstants.TAG, "Failed not talk to server", e);
            }
            return null;
        }
    }

    /* renamed from: com.facebook.react.devsupport.DevSupportManagerImpl$1 */
    class C38351 implements BundleStatusProvider {
        C38351() {
        }

        public BundleStatus getBundleStatus() {
            return DevSupportManagerImpl.this.mBundleStatus;
        }
    }

    /* renamed from: com.facebook.react.devsupport.DevSupportManagerImpl$2 */
    class C38362 implements ShakeListener {
        C38362() {
        }

        public void onShake() {
            DevSupportManagerImpl.this.showDevOptionsDialog();
        }
    }

    /* renamed from: com.facebook.react.devsupport.DevSupportManagerImpl$6 */
    class C38376 implements DevOptionHandler {
        C38376() {
        }

        public void onOptionSelected() {
            DevSupportManagerImpl.this.handleReloadJS();
        }
    }

    /* renamed from: com.facebook.react.devsupport.DevSupportManagerImpl$7 */
    class C38387 implements DevOptionHandler {
        C38387() {
        }

        public void onOptionSelected() {
            DevSupportManagerImpl.this.mDevServerHelper.attachDebugger(DevSupportManagerImpl.this.mApplicationContext, ReactConstants.TAG);
        }
    }

    /* renamed from: com.facebook.react.devsupport.DevSupportManagerImpl$8 */
    class C38398 implements DevOptionHandler {
        C38398() {
        }

        public void onOptionSelected() {
            DevSupportManagerImpl.this.mDevSettings.setRemoteJSDebugEnabled(DevSupportManagerImpl.this.mDevSettings.isRemoteJSDebugEnabled() ^ 1);
            DevSupportManagerImpl.this.handleReloadJS();
        }
    }

    /* renamed from: com.facebook.react.devsupport.DevSupportManagerImpl$9 */
    class C38409 implements DevOptionHandler {
        C38409() {
        }

        public void onOptionSelected() {
            DevSupportManagerImpl.this.mDevSettings.setReloadOnJSChangeEnabled(DevSupportManagerImpl.this.mDevSettings.isReloadOnJSChangeEnabled() ^ 1);
        }
    }

    private class JSExceptionLogger implements ExceptionLogger {
        private JSExceptionLogger() {
        }

        public void log(Exception exception) {
            StringBuilder stringBuilder = new StringBuilder(exception.getMessage());
            for (Throwable cause = exception.getCause(); cause != null; cause = cause.getCause()) {
                stringBuilder.append("\n\n");
                stringBuilder.append(cause.getMessage());
            }
            if (exception instanceof JSException) {
                FLog.m5675e(ReactConstants.TAG, "Exception in native call from JS", (Throwable) exception);
                exception = ((JSException) exception).getStack();
                stringBuilder.append("\n\n");
                stringBuilder.append(exception);
                DevSupportManagerImpl.this.showNewError(stringBuilder.toString(), new StackFrame[0], DevSupportManagerImpl.JSEXCEPTION_ERROR_COOKIE, ErrorType.JS);
                return;
            }
            DevSupportManagerImpl.this.showNewJavaError(stringBuilder.toString(), exception);
        }
    }

    public boolean hasUpToDateJSBundleInCache() {
        return false;
    }

    public void onPackagerConnected() {
    }

    public void onPackagerDisconnected() {
    }

    public DevSupportManagerImpl(Context context, ReactInstanceManagerDevHelper reactInstanceManagerDevHelper, String str, boolean z, int i) {
        this(context, reactInstanceManagerDevHelper, str, z, null, null, i, null);
    }

    public DevSupportManagerImpl(Context context, ReactInstanceManagerDevHelper reactInstanceManagerDevHelper, String str, boolean z, RedBoxHandler redBoxHandler, DevBundleDownloadListener devBundleDownloadListener, int i, Map<String, RequestHandler> map) {
        this.mExceptionLoggers = new ArrayList();
        this.mCustomDevOptions = new LinkedHashMap();
        this.mDevLoadingViewVisible = false;
        this.mIsReceiverRegistered = false;
        this.mIsShakeDetectorStarted = false;
        this.mIsDevSupportEnabled = false;
        this.mLastErrorCookie = 0;
        this.mReactInstanceManagerHelper = reactInstanceManagerDevHelper;
        this.mApplicationContext = context;
        this.mJSAppBundleName = str;
        this.mDevSettings = new DevInternalSettings(context, this);
        this.mBundleStatus = new BundleStatus();
        this.mDevServerHelper = new DevServerHelper(this.mDevSettings, this.mApplicationContext.getPackageName(), new C38351());
        this.mBundleDownloadListener = devBundleDownloadListener;
        this.mShakeDetector = new ShakeDetector(new C38362(), i);
        this.mCustomPackagerCommandHandlers = map;
        this.mReloadAppBroadcastReceiver = new C19133();
        this.mJSBundleTempFile = new File(context.getFilesDir(), JS_BUNDLE_FILE_NAME);
        this.mDefaultNativeModuleCallExceptionHandler = new DefaultNativeModuleCallExceptionHandler();
        setDevSupportEnabled(z);
        this.mRedBoxHandler = redBoxHandler;
        this.mDevLoadingViewController = new DevLoadingViewController(context, reactInstanceManagerDevHelper);
        this.mExceptionLoggers.add(new JSExceptionLogger());
    }

    public void handleException(Exception exception) {
        try {
            if (this.mIsDevSupportEnabled) {
                for (ExceptionLogger log : this.mExceptionLoggers) {
                    log.log(exception);
                }
                return;
            }
            this.mDefaultNativeModuleCallExceptionHandler.handleException(exception);
        } catch (Exception exception2) {
            try {
                Class.forName("host.exp.exponent.ReactNativeStaticHelpers").getMethod("handleReactNativeError", new Class[]{Throwable.class, String.class, Object.class, Integer.class, Boolean.class}).invoke(null, new Object[]{exception2, exception2.getMessage(), null, Integer.valueOf(-1), Boolean.valueOf(true)});
            } catch (Exception exception22) {
                exception22.printStackTrace();
            }
        }
    }

    public void showNewJavaError(String str, Throwable th) {
        FLog.m5675e(ReactConstants.TAG, "Exception in native call", th);
        showNewError(str, StackTraceHelper.convertJavaStackTrace(th), JAVA_ERROR_COOKIE, ErrorType.NATIVE);
    }

    public void addCustomDevOption(String str, DevOptionHandler devOptionHandler) {
        this.mCustomDevOptions.put(str, devOptionHandler);
    }

    public void showNewJSError(String str, ReadableArray readableArray, int i) {
        showNewError(str, StackTraceHelper.convertJsStackTrace(readableArray), i, ErrorType.JS);
    }

    public void registerErrorCustomizer(ErrorCustomizer errorCustomizer) {
        if (this.mErrorCustomizers == null) {
            this.mErrorCustomizers = new ArrayList();
        }
        this.mErrorCustomizers.add(errorCustomizer);
    }

    private Pair<String, StackFrame[]> processErrorCustomizers(Pair<String, StackFrame[]> pair) {
        if (this.mErrorCustomizers == null) {
            return pair;
        }
        for (ErrorCustomizer customizeErrorInfo : this.mErrorCustomizers) {
            Pair<String, StackFrame[]> customizeErrorInfo2 = customizeErrorInfo.customizeErrorInfo(pair);
            if (customizeErrorInfo2 != null) {
                pair = customizeErrorInfo2;
            }
        }
        return pair;
    }

    public void updateJSError(final String str, final ReadableArray readableArray, final int i) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (DevSupportManagerImpl.this.mRedBoxDialog != null && DevSupportManagerImpl.this.mRedBoxDialog.isShowing()) {
                    if (i == DevSupportManagerImpl.this.mLastErrorCookie) {
                        Object convertJsStackTrace = StackTraceHelper.convertJsStackTrace(readableArray);
                        Pair access$300 = DevSupportManagerImpl.this.processErrorCustomizers(Pair.create(str, convertJsStackTrace));
                        DevSupportManagerImpl.this.mRedBoxDialog.setExceptionDetails((String) access$300.first, (StackFrame[]) access$300.second);
                        DevSupportManagerImpl.this.updateLastErrorInfo(str, convertJsStackTrace, i, ErrorType.JS);
                        if (DevSupportManagerImpl.this.mRedBoxHandler != null) {
                            DevSupportManagerImpl.this.mRedBoxHandler.handleRedbox(str, convertJsStackTrace, com.facebook.react.devsupport.RedBoxHandler.ErrorType.JS);
                            DevSupportManagerImpl.this.mRedBoxDialog.resetReporting();
                        }
                        DevSupportManagerImpl.this.mRedBoxDialog.show();
                    }
                }
            }
        });
    }

    public void hideRedboxDialog() {
        if (this.mRedBoxDialog != null) {
            this.mRedBoxDialog.dismiss();
            this.mRedBoxDialog = null;
        }
    }

    private void hideDevOptionsDialog() {
        if (this.mDevOptionsDialog != null) {
            this.mDevOptionsDialog.dismiss();
            this.mDevOptionsDialog = null;
        }
    }

    private void showNewError(String str, StackFrame[] stackFrameArr, int i, ErrorType errorType) {
        final String str2 = str;
        final StackFrame[] stackFrameArr2 = stackFrameArr;
        final int i2 = i;
        final ErrorType errorType2 = errorType;
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (DevSupportManagerImpl.this.mRedBoxDialog == null) {
                    Context currentActivity = DevSupportManagerImpl.this.mReactInstanceManagerHelper.getCurrentActivity();
                    if (currentActivity != null) {
                        if (!currentActivity.isFinishing()) {
                            DevSupportManagerImpl.this.mRedBoxDialog = new RedBoxDialog(currentActivity, DevSupportManagerImpl.this, DevSupportManagerImpl.this.mRedBoxHandler);
                        }
                    }
                    String str = ReactConstants.TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unable to launch redbox because react activity is not available, here is the error that redbox would've displayed: ");
                    stringBuilder.append(str2);
                    FLog.m5674e(str, stringBuilder.toString());
                    return;
                }
                if (!DevSupportManagerImpl.this.mRedBoxDialog.isShowing()) {
                    Pair access$300 = DevSupportManagerImpl.this.processErrorCustomizers(Pair.create(str2, stackFrameArr2));
                    DevSupportManagerImpl.this.mRedBoxDialog.setExceptionDetails((String) access$300.first, (StackFrame[]) access$300.second);
                    DevSupportManagerImpl.this.updateLastErrorInfo(str2, stackFrameArr2, i2, errorType2);
                    if (DevSupportManagerImpl.this.mRedBoxHandler != null && errorType2 == ErrorType.NATIVE) {
                        DevSupportManagerImpl.this.mRedBoxHandler.handleRedbox(str2, stackFrameArr2, com.facebook.react.devsupport.RedBoxHandler.ErrorType.NATIVE);
                    }
                    DevSupportManagerImpl.this.mRedBoxDialog.resetReporting();
                    DevSupportManagerImpl.this.mRedBoxDialog.show();
                }
            }
        });
    }

    public void showDevOptionsDialog() {
        if (this.mDevOptionsDialog == null && this.mIsDevSupportEnabled) {
            if (!ActivityManager.isUserAMonkey()) {
                Context context;
                int i;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(this.mApplicationContext.getString(C1864R.string.catalyst_reloadjs), new C38376());
                if (this.mDevSettings.isNuclideJSDebugEnabled()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(this.mApplicationContext.getString(C1864R.string.catalyst_debugjs_nuclide));
                    stringBuilder.append(EMOJI_HUNDRED_POINTS_SYMBOL);
                    linkedHashMap.put(stringBuilder.toString(), new C38387());
                }
                if (this.mDevSettings.isRemoteJSDebugEnabled()) {
                    context = this.mApplicationContext;
                    i = C1864R.string.catalyst_debugjs_off;
                } else {
                    context = this.mApplicationContext;
                    i = C1864R.string.catalyst_debugjs;
                }
                Object string = context.getString(i);
                if (this.mDevSettings.isNuclideJSDebugEnabled()) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(string);
                    stringBuilder2.append(EMOJI_FACE_WITH_NO_GOOD_GESTURE);
                    string = stringBuilder2.toString();
                }
                linkedHashMap.put(string, new C38398());
                if (this.mDevSettings.isReloadOnJSChangeEnabled()) {
                    context = this.mApplicationContext;
                    i = C1864R.string.catalyst_live_reload_off;
                } else {
                    context = this.mApplicationContext;
                    i = C1864R.string.catalyst_live_reload;
                }
                linkedHashMap.put(context.getString(i), new C38409());
                if (this.mDevSettings.isHotModuleReplacementEnabled()) {
                    context = this.mApplicationContext;
                    i = C1864R.string.catalyst_hot_module_replacement_off;
                } else {
                    context = this.mApplicationContext;
                    i = C1864R.string.catalyst_hot_module_replacement;
                }
                linkedHashMap.put(context.getString(i), new DevOptionHandler() {
                    public void onOptionSelected() {
                        DevSupportManagerImpl.this.mDevSettings.setHotModuleReplacementEnabled(DevSupportManagerImpl.this.mDevSettings.isHotModuleReplacementEnabled() ^ 1);
                        DevSupportManagerImpl.this.handleReloadJS();
                    }
                });
                linkedHashMap.put(this.mApplicationContext.getString(C1864R.string.catalyst_element_inspector), new DevOptionHandler() {
                    public void onOptionSelected() {
                        DevSupportManagerImpl.this.mDevSettings.setElementInspectorEnabled(DevSupportManagerImpl.this.mDevSettings.isElementInspectorEnabled() ^ 1);
                        DevSupportManagerImpl.this.mReactInstanceManagerHelper.toggleElementInspector();
                    }
                });
                if (this.mDevSettings.isFpsDebugEnabled()) {
                    context = this.mApplicationContext;
                    i = C1864R.string.catalyst_perf_monitor_off;
                } else {
                    context = this.mApplicationContext;
                    i = C1864R.string.catalyst_perf_monitor;
                }
                linkedHashMap.put(context.getString(i), new DevOptionHandler() {
                    public void onOptionSelected() {
                        if (!DevSupportManagerImpl.this.mDevSettings.isFpsDebugEnabled()) {
                            Context currentActivity = DevSupportManagerImpl.this.mReactInstanceManagerHelper.getCurrentActivity();
                            if (currentActivity == null) {
                                FLog.m5674e(ReactConstants.TAG, "Unable to get reference to react activity");
                            } else {
                                DebugOverlayController.requestPermission(currentActivity);
                            }
                        }
                        DevSupportManagerImpl.this.mDevSettings.setFpsDebugEnabled(DevSupportManagerImpl.this.mDevSettings.isFpsDebugEnabled() ^ 1);
                    }
                });
                linkedHashMap.put(this.mApplicationContext.getString(C1864R.string.catalyst_poke_sampling_profiler), new DevOptionHandler() {
                    public void onOptionSelected() {
                        DevSupportManagerImpl.this.handlePokeSamplingProfiler();
                    }
                });
                if (this.mCustomDevOptions.size() > 0) {
                    linkedHashMap.putAll(this.mCustomDevOptions);
                }
                final DevOptionHandler[] devOptionHandlerArr = (DevOptionHandler[]) linkedHashMap.values().toArray(new DevOptionHandler[0]);
                Context currentActivity = this.mReactInstanceManagerHelper.getCurrentActivity();
                if (currentActivity != null) {
                    if (!currentActivity.isFinishing()) {
                        this.mDevOptionsDialog = new Builder(currentActivity).setItems((CharSequence[]) linkedHashMap.keySet().toArray(new String[0]), new OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                devOptionHandlerArr[i].onOptionSelected();
                                DevSupportManagerImpl.this.mDevOptionsDialog = 0;
                            }
                        }).setOnCancelListener(new OnCancelListener() {
                            public void onCancel(DialogInterface dialogInterface) {
                                DevSupportManagerImpl.this.mDevOptionsDialog = null;
                            }
                        }).create();
                        this.mDevOptionsDialog.show();
                        return;
                    }
                }
                FLog.m5674e(ReactConstants.TAG, "Unable to launch dev options menu because react activity isn't available");
            }
        }
    }

    public void setDevSupportEnabled(boolean z) {
        this.mIsDevSupportEnabled = z;
        reloadSettings();
    }

    public boolean getDevSupportEnabled() {
        return this.mIsDevSupportEnabled;
    }

    public DeveloperSettings getDevSettings() {
        return this.mDevSettings;
    }

    public void onNewReactContextCreated(ReactContext reactContext) {
        resetCurrentContext(reactContext);
    }

    public void onReactInstanceDestroyed(ReactContext reactContext) {
        if (reactContext == this.mCurrentContext) {
            resetCurrentContext(null);
        }
    }

    public String getSourceMapUrl() {
        if (this.mJSAppBundleName == null) {
            return "";
        }
        return this.mDevServerHelper.getSourceMapUrl((String) Assertions.assertNotNull(this.mJSAppBundleName));
    }

    public String getSourceUrl() {
        if (this.mJSAppBundleName == null) {
            return "";
        }
        return this.mDevServerHelper.getSourceUrl((String) Assertions.assertNotNull(this.mJSAppBundleName));
    }

    public String getJSBundleURLForRemoteDebugging() {
        return this.mDevServerHelper.getJSBundleURLForRemoteDebugging((String) Assertions.assertNotNull(this.mJSAppBundleName));
    }

    public String getDownloadedJSBundleFile() {
        return this.mJSBundleTempFile.getAbsolutePath();
    }

    public boolean hasBundleInAssets(java.lang.String r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r4 = this;
        r0 = 0;
        r1 = r4.mApplicationContext;	 Catch:{ IOException -> 0x001e }
        r1 = r1.getAssets();	 Catch:{ IOException -> 0x001e }
        r2 = "";	 Catch:{ IOException -> 0x001e }
        r1 = r1.list(r2);	 Catch:{ IOException -> 0x001e }
        r2 = 0;	 Catch:{ IOException -> 0x001e }
    L_0x000e:
        r3 = r1.length;	 Catch:{ IOException -> 0x001e }
        if (r2 >= r3) goto L_0x0025;	 Catch:{ IOException -> 0x001e }
    L_0x0011:
        r3 = r1[r2];	 Catch:{ IOException -> 0x001e }
        r3 = r3.equals(r5);	 Catch:{ IOException -> 0x001e }
        if (r3 == 0) goto L_0x001b;
    L_0x0019:
        r5 = 1;
        return r5;
    L_0x001b:
        r2 = r2 + 1;
        goto L_0x000e;
    L_0x001e:
        r5 = "ReactNative";
        r1 = "Error while loading assets list";
        com.facebook.common.logging.FLog.m5674e(r5, r1);
    L_0x0025:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.devsupport.DevSupportManagerImpl.hasBundleInAssets(java.lang.String):boolean");
    }

    private void resetCurrentContext(ReactContext reactContext) {
        if (this.mCurrentContext != reactContext) {
            this.mCurrentContext = reactContext;
            if (this.mDebugOverlayController != null) {
                this.mDebugOverlayController.setFpsDebugViewVisible(false);
            }
            if (reactContext != null) {
                this.mDebugOverlayController = new DebugOverlayController(reactContext);
            }
            if (!(this.mDevSettings.isHotModuleReplacementEnabled() == null || this.mCurrentContext == null)) {
                try {
                    reactContext = new URL(getSourceUrl());
                    ((HMRClient) this.mCurrentContext.getJSModule(HMRClient.class)).enable("android", reactContext.getPath().substring(1), reactContext.getHost(), reactContext.getPort());
                } catch (ReactContext reactContext2) {
                    showNewJavaError(reactContext2.getMessage(), reactContext2);
                }
            }
            reloadSettings();
        }
    }

    public void reloadSettings() {
        if (UiThreadUtil.isOnUiThread()) {
            reload();
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    DevSupportManagerImpl.this.reload();
                }
            });
        }
    }

    public void onInternalSettingsChanged() {
        reloadSettings();
    }

    public void handleReloadJS() {
        UiThreadUtil.assertOnUiThread();
        ReactMarker.logMarker(ReactMarkerConstants.RELOAD, this.mDevSettings.getPackagerConnectionSettings().getDebugServerHost());
        hideRedboxDialog();
        if (this.mDevSettings.isRemoteJSDebugEnabled()) {
            PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.RN_CORE, "RNCore: load from Proxy");
            this.mDevLoadingViewController.showForRemoteJSEnabled();
            this.mDevLoadingViewVisible = true;
            reloadJSInProxyMode();
            return;
        }
        PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.RN_CORE, "RNCore: load from Server");
        reloadJSFromServer(this.mDevServerHelper.getDevServerBundleURL((String) Assertions.assertNotNull(this.mJSAppBundleName)));
    }

    public void isPackagerRunning(PackagerStatusCallback packagerStatusCallback) {
        this.mDevServerHelper.isPackagerRunning(packagerStatusCallback);
    }

    public File downloadBundleResourceFromUrlSync(String str, File file) {
        return this.mDevServerHelper.downloadBundleResourceFromUrlSync(str, file);
    }

    public String getLastErrorTitle() {
        return this.mLastErrorTitle;
    }

    public StackFrame[] getLastErrorStack() {
        return this.mLastErrorStack;
    }

    public void onPackagerReloadCommand() {
        this.mDevServerHelper.disableDebugger();
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                DevSupportManagerImpl.this.handleReloadJS();
            }
        });
    }

    public void onPackagerDevMenuCommand() {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                DevSupportManagerImpl.this.showDevOptionsDialog();
            }
        });
    }

    public void onCaptureHeapCommand(final Responder responder) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                DevSupportManagerImpl.this.handleCaptureHeap(responder);
            }
        });
    }

    public Map<String, RequestHandler> customCommandHandlers() {
        return this.mCustomPackagerCommandHandlers;
    }

    private void handleCaptureHeap(final Responder responder) {
        if (this.mCurrentContext != null) {
            ((JSCHeapCapture) this.mCurrentContext.getNativeModule(JSCHeapCapture.class)).captureHeap(this.mApplicationContext.getCacheDir().getPath(), new CaptureCallback() {
                public void onSuccess(File file) {
                    responder.respond(file.toString());
                }

                public void onFailure(CaptureException captureException) {
                    responder.error(captureException.toString());
                }
            });
        }
    }

    private void handlePokeSamplingProfiler() {
        try {
            for (String str : JSCSamplingProfiler.poke(60000)) {
                Toast.makeText(this.mCurrentContext, str == null ? "Started JSC Sampling Profiler" : "Stopped JSC Sampling Profiler", 1).show();
                new JscProfileTask(getSourceUrl()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{str});
            }
        } catch (Throwable e) {
            showNewJavaError(e.getMessage(), e);
        }
    }

    private void updateLastErrorInfo(String str, StackFrame[] stackFrameArr, int i, ErrorType errorType) {
        this.mLastErrorTitle = str;
        this.mLastErrorStack = stackFrameArr;
        this.mLastErrorCookie = i;
        this.mLastErrorType = errorType;
    }

    private void reloadJSInProxyMode() {
        this.mDevServerHelper.launchJSDevtools();
        this.mReactInstanceManagerHelper.onReloadWithJSDebugger(new Factory() {
            public JavaJSExecutor create() {
                JavaJSExecutor websocketJavaScriptExecutor = new WebsocketJavaScriptExecutor();
                SimpleSettableFuture simpleSettableFuture = new SimpleSettableFuture();
                websocketJavaScriptExecutor.connect(DevSupportManagerImpl.this.mDevServerHelper.getWebsocketProxyURL(), DevSupportManagerImpl.this.getExecutorConnectCallback(simpleSettableFuture));
                try {
                    simpleSettableFuture.get(90, TimeUnit.SECONDS);
                    return websocketJavaScriptExecutor;
                } catch (ExecutionException e) {
                    throw ((Exception) e.getCause());
                } catch (Throwable e2) {
                    throw new RuntimeException(e2);
                }
            }
        });
    }

    private JSExecutorConnectCallback getExecutorConnectCallback(final SimpleSettableFuture<Boolean> simpleSettableFuture) {
        return new JSExecutorConnectCallback() {
            public void onSuccess() {
                simpleSettableFuture.set(Boolean.valueOf(true));
                DevSupportManagerImpl.this.mDevLoadingViewController.hide();
                DevSupportManagerImpl.this.mDevLoadingViewVisible = false;
            }

            public void onFailure(Throwable th) {
                DevSupportManagerImpl.this.mDevLoadingViewController.hide();
                DevSupportManagerImpl.this.mDevLoadingViewVisible = false;
                FLog.m5675e(ReactConstants.TAG, "Unable to connect to remote debugger", th);
                simpleSettableFuture.setException(new IOException(DevSupportManagerImpl.this.mApplicationContext.getString(C1864R.string.catalyst_remotedbg_error), th));
            }
        };
    }

    public void reloadJSFromServer(String str) {
        ReactMarker.logMarker(ReactMarkerConstants.DOWNLOAD_START);
        this.mDevLoadingViewController.showForUrl(str);
        this.mDevLoadingViewVisible = true;
        final BundleInfo bundleInfo = new BundleInfo();
        this.mDevServerHelper.downloadBundleFromURL(new DevBundleDownloadListener() {
            public void onSuccess(final NativeDeltaClient nativeDeltaClient) {
                DevSupportManagerImpl.this.mDevLoadingViewController.hide();
                DevSupportManagerImpl.this.mDevLoadingViewVisible = false;
                synchronized (DevSupportManagerImpl.this) {
                    DevSupportManagerImpl.this.mBundleStatus.isLastDownloadSucess = Boolean.valueOf(true);
                    DevSupportManagerImpl.this.mBundleStatus.updateTimestamp = System.currentTimeMillis();
                }
                if (DevSupportManagerImpl.this.mBundleDownloadListener != null) {
                    DevSupportManagerImpl.this.mBundleDownloadListener.onSuccess(nativeDeltaClient);
                }
                UiThreadUtil.runOnUiThread(new Runnable() {
                    public void run() {
                        ReactMarker.logMarker(ReactMarkerConstants.DOWNLOAD_END, bundleInfo.toJSONString());
                        DevSupportManagerImpl.this.mReactInstanceManagerHelper.onJSBundleLoadedFromServer(nativeDeltaClient);
                    }
                });
            }

            public void onProgress(String str, Integer num, Integer num2) {
                DevSupportManagerImpl.this.mDevLoadingViewController.updateProgress(str, num, num2);
                if (DevSupportManagerImpl.this.mBundleDownloadListener != null) {
                    DevSupportManagerImpl.this.mBundleDownloadListener.onProgress(str, num, num2);
                }
            }

            public void onFailure(final Exception exception) {
                DevSupportManagerImpl.this.mDevLoadingViewController.hide();
                DevSupportManagerImpl.this.mDevLoadingViewVisible = false;
                synchronized (DevSupportManagerImpl.this) {
                    DevSupportManagerImpl.this.mBundleStatus.isLastDownloadSucess = Boolean.valueOf(false);
                }
                if (DevSupportManagerImpl.this.mBundleDownloadListener != null) {
                    DevSupportManagerImpl.this.mBundleDownloadListener.onFailure(exception);
                }
                FLog.m5675e(ReactConstants.TAG, "Unable to download JS bundle", (Throwable) exception);
                UiThreadUtil.runOnUiThread(new Runnable() {
                    public void run() {
                        if (exception instanceof DebugServerException) {
                            DevSupportManagerImpl.this.showNewJavaError(((DebugServerException) exception).getMessage(), exception);
                            return;
                        }
                        DevSupportManagerImpl.this.showNewJavaError(DevSupportManagerImpl.this.mApplicationContext.getString(C1864R.string.catalyst_jsload_error), exception);
                    }
                });
            }
        }, this.mJSBundleTempFile, str, bundleInfo);
    }

    public void startInspector() {
        if (this.mIsDevSupportEnabled) {
            this.mDevServerHelper.openInspectorConnection();
        }
    }

    public void stopInspector() {
        this.mDevServerHelper.closeInspectorConnection();
    }

    private void reload() {
        UiThreadUtil.assertOnUiThread();
        if (this.mIsDevSupportEnabled) {
            if (this.mDebugOverlayController != null) {
                this.mDebugOverlayController.setFpsDebugViewVisible(this.mDevSettings.isFpsDebugEnabled());
            }
            if (!this.mIsShakeDetectorStarted) {
                this.mShakeDetector.start((SensorManager) this.mApplicationContext.getSystemService("sensor"));
                this.mIsShakeDetectorStarted = true;
            }
            if (!this.mIsReceiverRegistered) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(getReloadAppAction(this.mApplicationContext));
                this.mApplicationContext.registerReceiver(this.mReloadAppBroadcastReceiver, intentFilter);
                this.mIsReceiverRegistered = true;
            }
            if (this.mDevLoadingViewVisible) {
                this.mDevLoadingViewController.showMessage("Reloading...");
            }
            this.mDevServerHelper.openPackagerConnection(getClass().getSimpleName(), this);
            if (this.mDevSettings.isReloadOnJSChangeEnabled()) {
                this.mDevServerHelper.startPollingOnChangeEndpoint(new OnServerContentChangeListener() {
                    public void onServerContentChanged() {
                        DevSupportManagerImpl.this.handleReloadJS();
                    }
                });
                return;
            } else {
                this.mDevServerHelper.stopPollingOnChangeEndpoint();
                return;
            }
        }
        if (this.mDebugOverlayController != null) {
            this.mDebugOverlayController.setFpsDebugViewVisible(false);
        }
        if (this.mIsShakeDetectorStarted) {
            this.mShakeDetector.stop();
            this.mIsShakeDetectorStarted = false;
        }
        if (this.mIsReceiverRegistered) {
            this.mApplicationContext.unregisterReceiver(this.mReloadAppBroadcastReceiver);
            this.mIsReceiverRegistered = false;
        }
        hideRedboxDialog();
        hideDevOptionsDialog();
        this.mDevLoadingViewController.hide();
        this.mDevServerHelper.closePackagerConnection();
        this.mDevServerHelper.stopPollingOnChangeEndpoint();
    }

    private static String getReloadAppAction(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getPackageName());
        stringBuilder.append(RELOAD_APP_ACTION_SUFFIX);
        return stringBuilder.toString();
    }
}
