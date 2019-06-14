package com.facebook.react.devsupport;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.widget.Toast;
import com.facebook.common.logging.FLog;
import com.facebook.react.C1864R;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.common.network.OkHttpCallUtil;
import com.facebook.react.devsupport.BundleDeltaClient.ClientType;
import com.facebook.react.devsupport.BundleDownloader.BundleInfo;
import com.facebook.react.devsupport.InspectorPackagerConnection.BundleStatusProvider;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.devsupport.interfaces.PackagerStatusCallback;
import com.facebook.react.devsupport.interfaces.StackFrame;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import com.facebook.react.packagerconnection.FileIoHandler;
import com.facebook.react.packagerconnection.JSPackagerClient;
import com.facebook.react.packagerconnection.NotificationOnlyHandler;
import com.facebook.react.packagerconnection.ReconnectingWebSocket.ConnectionCallback;
import com.facebook.react.packagerconnection.RequestHandler;
import com.facebook.react.packagerconnection.RequestOnlyHandler;
import com.facebook.react.packagerconnection.Responder;
import expolib_v1.com.facebook.infer.annotation.Assertions;
import expolib_v1.p321a.C6216e;
import expolib_v1.p321a.C6217f;
import expolib_v1.p321a.C6224j;
import expolib_v1.p321a.C6240u;
import expolib_v1.p321a.C6246z.C6245a;
import expolib_v1.p321a.C7490w;
import expolib_v1.p321a.C7490w.C6243a;
import expolib_v1.p321a.aa;
import expolib_v1.p321a.ab;
import expolib_v1.p332b.C6252l;
import expolib_v1.p332b.C6257r;
import java.io.File;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public class DevServerHelper {
    public static String DEBUGGER_MSG_DISABLE = "{ \"id\":1,\"method\":\"Debugger.disable\" }";
    public static int HTTP_CONNECT_TIMEOUT_MS = 5000;
    public static int LONG_POLL_FAILURE_DELAY_MS = 5000;
    public static int LONG_POLL_KEEP_ALIVE_DURATION_MS = 120000;
    public static String PACKAGER_OK_STATUS = "packager-status:running";
    public static String RELOAD_APP_EXTRA_JS_PROXY = "jsproxy";
    public final BundleDownloader mBundleDownloader = new BundleDownloader(this.mClient);
    public BundleStatusProvider mBundlerStatusProvider;
    public final C7490w mClient = new C6243a().a((long) HTTP_CONNECT_TIMEOUT_MS, TimeUnit.MILLISECONDS).b(0, TimeUnit.MILLISECONDS).c(0, TimeUnit.MILLISECONDS).a();
    public InspectorPackagerConnection mInspectorPackagerConnection;
    public C7490w mOnChangePollingClient;
    public boolean mOnChangePollingEnabled;
    public OnServerContentChangeListener mOnServerContentChangeListener;
    public final String mPackageName;
    public JSPackagerClient mPackagerClient;
    public final Handler mRestartOnChangePollingHandler = new Handler();
    public final DevInternalSettings mSettings;

    /* renamed from: com.facebook.react.devsupport.DevServerHelper$2 */
    class C19062 extends AsyncTask<Void, Void, Void> {
        C19062() {
        }

        protected Void doInBackground(Void... voidArr) {
            if (DevServerHelper.this.mPackagerClient != null) {
                DevServerHelper.this.mPackagerClient.close();
                DevServerHelper.this.mPackagerClient = null;
            }
            return null;
        }
    }

    /* renamed from: com.facebook.react.devsupport.DevServerHelper$3 */
    class C19073 extends AsyncTask<Void, Void, Void> {
        C19073() {
        }

        protected Void doInBackground(Void... voidArr) {
            DevServerHelper.this.mInspectorPackagerConnection = new InspectorPackagerConnection(DevServerHelper.this.getInspectorDeviceUrl(), DevServerHelper.this.mPackageName, DevServerHelper.this.mBundlerStatusProvider);
            DevServerHelper.this.mInspectorPackagerConnection.connect();
            return null;
        }
    }

    /* renamed from: com.facebook.react.devsupport.DevServerHelper$4 */
    class C19084 extends AsyncTask<Void, Void, Void> {
        C19084() {
        }

        protected Void doInBackground(Void... voidArr) {
            if (DevServerHelper.this.mInspectorPackagerConnection != null) {
                DevServerHelper.this.mInspectorPackagerConnection.closeQuietly();
                DevServerHelper.this.mInspectorPackagerConnection = null;
            }
            return null;
        }
    }

    /* renamed from: com.facebook.react.devsupport.DevServerHelper$9 */
    class C19109 implements Runnable {
        C19109() {
        }

        public void run() {
            if (DevServerHelper.this.mOnServerContentChangeListener != null) {
                DevServerHelper.this.mOnServerContentChangeListener.onServerContentChanged();
            }
        }
    }

    private enum BundleType {
        BUNDLE("bundle"),
        DELTA("delta"),
        MAP("map");
        
        public final String mTypeID;

        private BundleType(String str) {
            this.mTypeID = str;
        }

        public String typeID() {
            return this.mTypeID;
        }
    }

    public interface OnServerContentChangeListener {
        void onServerContentChanged();
    }

    public interface PackagerCommandListener {
        Map<String, RequestHandler> customCommandHandlers();

        void onCaptureHeapCommand(Responder responder);

        void onPackagerConnected();

        void onPackagerDevMenuCommand();

        void onPackagerDisconnected();

        void onPackagerReloadCommand();
    }

    public interface PackagerCustomCommandProvider {
    }

    public interface SymbolicationListener {
        void onSymbolicationComplete(Iterable<StackFrame> iterable);
    }

    /* renamed from: com.facebook.react.devsupport.DevServerHelper$7 */
    class C38337 implements C6217f {
        public void onResponse(C6216e c6216e, ab abVar) {
        }

        C38337() {
        }

        public void onFailure(C6216e c6216e, IOException iOException) {
            String str = ReactConstants.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Got IOException when attempting to open stack frame: ");
            stringBuilder.append(iOException.getMessage());
            FLog.m5714w(str, stringBuilder.toString());
        }
    }

    public DevServerHelper(DevInternalSettings devInternalSettings, String str, BundleStatusProvider bundleStatusProvider) {
        this.mSettings = devInternalSettings;
        this.mBundlerStatusProvider = bundleStatusProvider;
        this.mPackageName = str;
    }

    public void openPackagerConnection(final String str, final PackagerCommandListener packagerCommandListener) {
        if (this.mPackagerClient != null) {
            FLog.m5714w(ReactConstants.TAG, "Packager connection already open, nooping.");
        } else {
            new AsyncTask<Void, Void, Void>() {

                /* renamed from: com.facebook.react.devsupport.DevServerHelper$1$4 */
                class C38314 implements ConnectionCallback {
                    C38314() {
                    }

                    public void onConnected() {
                        packagerCommandListener.onPackagerConnected();
                    }

                    public void onDisconnected() {
                        packagerCommandListener.onPackagerDisconnected();
                    }
                }

                /* renamed from: com.facebook.react.devsupport.DevServerHelper$1$1 */
                class C46671 extends NotificationOnlyHandler {
                    C46671() {
                    }

                    public void onNotification(Object obj) {
                        packagerCommandListener.onPackagerReloadCommand();
                    }
                }

                /* renamed from: com.facebook.react.devsupport.DevServerHelper$1$2 */
                class C46682 extends NotificationOnlyHandler {
                    C46682() {
                    }

                    public void onNotification(Object obj) {
                        packagerCommandListener.onPackagerDevMenuCommand();
                    }
                }

                /* renamed from: com.facebook.react.devsupport.DevServerHelper$1$3 */
                class C46693 extends RequestOnlyHandler {
                    C46693() {
                    }

                    public void onRequest(Object obj, Responder responder) {
                        packagerCommandListener.onCaptureHeapCommand(responder);
                    }
                }

                protected Void doInBackground(Void... voidArr) {
                    voidArr = new HashMap();
                    voidArr.put("reload", new C46671());
                    voidArr.put("devMenu", new C46682());
                    voidArr.put("captureHeap", new C46693());
                    Map customCommandHandlers = packagerCommandListener.customCommandHandlers();
                    if (customCommandHandlers != null) {
                        voidArr.putAll(customCommandHandlers);
                    }
                    voidArr.putAll(new FileIoHandler().handlers());
                    ConnectionCallback c38314 = new C38314();
                    DevServerHelper.this.mPackagerClient = new JSPackagerClient(str, DevServerHelper.this.mSettings.getPackagerConnectionSettings(), voidArr, c38314);
                    DevServerHelper.this.mPackagerClient.init();
                    return null;
                }
            }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[null]);
        }
    }

    public void closePackagerConnection() {
        new C19062().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void openInspectorConnection() {
        if (this.mInspectorPackagerConnection != null) {
            FLog.m5714w(ReactConstants.TAG, "Inspector connection already open, nooping.");
        } else {
            new C19073().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public void disableDebugger() {
        if (this.mInspectorPackagerConnection != null) {
            this.mInspectorPackagerConnection.sendEventToAllConnections(DEBUGGER_MSG_DISABLE);
        }
    }

    public void closeInspectorConnection() {
        new C19084().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void attachDebugger(final Context context, final String str) {
        new AsyncTask<Void, String, Boolean>() {
            protected Boolean doInBackground(Void... voidArr) {
                return Boolean.valueOf(doSync());
            }

            public boolean doSync() {
                try {
                    new C7490w().a(new C6245a().a(DevServerHelper.this.getInspectorAttachUrl(str)).b()).b();
                    return true;
                } catch (Throwable e) {
                    FLog.m5675e(ReactConstants.TAG, "Failed to send attach request to Inspector", e);
                    return false;
                }
            }

            protected void onPostExecute(Boolean bool) {
                if (bool.booleanValue() == null) {
                    Toast.makeText(context, context.getString(C1864R.string.catalyst_debugjs_nuclide_failure), 1).show();
                }
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[null]);
    }

    public void symbolicateStackTrace(Iterable<StackFrame> iterable, final SymbolicationListener symbolicationListener) {
        try {
            String createSymbolicateURL = createSymbolicateURL(this.mSettings.getPackagerConnectionSettings().getDebugServerHost());
            JSONArray jSONArray = new JSONArray();
            for (StackFrame toJSON : iterable) {
                jSONArray.put(toJSON.toJSON());
            }
            ((C6216e) Assertions.assertNotNull(this.mClient.a(new C6245a().a(createSymbolicateURL).a(aa.create(C6240u.a("application/json"), new JSONObject().put("stack", jSONArray).toString())).b()))).a(new C6217f() {
                public void onFailure(C6216e c6216e, IOException iOException) {
                    String str = ReactConstants.TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Got IOException when attempting symbolicate stack trace: ");
                    stringBuilder.append(iOException.getMessage());
                    FLog.m5714w(str, stringBuilder.toString());
                    symbolicationListener.onSymbolicationComplete(null);
                }

                public void onResponse(expolib_v1.p321a.C6216e r2, expolib_v1.p321a.ab r3) {
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
                    r1 = this;
                    r2 = r6;	 Catch:{ JSONException -> 0x0021 }
                    r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0021 }
                    r3 = r3.h();	 Catch:{ JSONException -> 0x0021 }
                    r3 = r3.string();	 Catch:{ JSONException -> 0x0021 }
                    r0.<init>(r3);	 Catch:{ JSONException -> 0x0021 }
                    r3 = "stack";	 Catch:{ JSONException -> 0x0021 }
                    r3 = r0.getJSONArray(r3);	 Catch:{ JSONException -> 0x0021 }
                    r3 = com.facebook.react.devsupport.StackTraceHelper.convertJsStackTrace(r3);	 Catch:{ JSONException -> 0x0021 }
                    r3 = java.util.Arrays.asList(r3);	 Catch:{ JSONException -> 0x0021 }
                    r2.onSymbolicationComplete(r3);	 Catch:{ JSONException -> 0x0021 }
                    goto L_0x0027;
                L_0x0021:
                    r2 = r6;
                    r3 = 0;
                    r2.onSymbolicationComplete(r3);
                L_0x0027:
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.devsupport.DevServerHelper.6.onResponse(expolib_v1.a.e, expolib_v1.a.ab):void");
                }
            });
        } catch (Iterable<StackFrame> iterable2) {
            String str = ReactConstants.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Got JSONException when attempting symbolicate stack trace: ");
            stringBuilder.append(iterable2.getMessage());
            FLog.m5714w(str, stringBuilder.toString());
        }
    }

    public void openStackFrameCall(StackFrame stackFrame) {
        ((C6216e) Assertions.assertNotNull(this.mClient.a(new C6245a().a(createOpenStackFrameURL(this.mSettings.getPackagerConnectionSettings().getDebugServerHost())).a(aa.create(C6240u.a("application/json"), stackFrame.toJSON().toString())).b()))).a(new C38337());
    }

    public String getWebsocketProxyURL() {
        return String.format(Locale.US, "ws://%s/debugger-proxy?role=client", new Object[]{this.mSettings.getPackagerConnectionSettings().getDebugServerHost()});
    }

    private String getInspectorDeviceUrl() {
        return String.format(Locale.US, "http://%s/inspector/device?name=%s&app=%s", new Object[]{this.mSettings.getPackagerConnectionSettings().getInspectorServerHost(), AndroidInfoHelpers.getFriendlyDeviceName(), this.mPackageName});
    }

    private String getInspectorAttachUrl(String str) {
        return String.format(Locale.US, "http://%s/nuclide/attach-debugger-nuclide?title=%s&app=%s&device=%s", new Object[]{AndroidInfoHelpers.getServerHost(), str, this.mPackageName, AndroidInfoHelpers.getFriendlyDeviceName()});
    }

    public void downloadBundleFromURL(DevBundleDownloadListener devBundleDownloadListener, File file, String str, BundleInfo bundleInfo) {
        this.mBundleDownloader.downloadBundleFromURL(devBundleDownloadListener, file, str, bundleInfo, getDeltaClientType());
    }

    public void downloadBundleFromURL(DevBundleDownloadListener devBundleDownloadListener, File file, String str, BundleInfo bundleInfo, C6245a c6245a) {
        this.mBundleDownloader.downloadBundleFromURL(devBundleDownloadListener, file, str, bundleInfo, getDeltaClientType(), c6245a);
    }

    private ClientType getDeltaClientType() {
        if (this.mSettings.isBundleDeltasCppEnabled()) {
            return ClientType.NATIVE;
        }
        if (this.mSettings.isBundleDeltasEnabled()) {
            return ClientType.DEV_SUPPORT;
        }
        return ClientType.NONE;
    }

    private String getHostForJSProxy() {
        String str = (String) Assertions.assertNotNull(this.mSettings.getPackagerConnectionSettings().getDebugServerHost());
        int lastIndexOf = str.lastIndexOf(58);
        if (lastIndexOf <= -1) {
            return AndroidInfoHelpers.DEVICE_LOCALHOST;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("localhost");
        stringBuilder.append(str.substring(lastIndexOf));
        return stringBuilder.toString();
    }

    private boolean getDevMode() {
        return this.mSettings.isJSDevModeEnabled();
    }

    private boolean getJSMinifyMode() {
        return this.mSettings.isJSMinifyEnabled();
    }

    private String createBundleURL(String str, BundleType bundleType, String str2) {
        try {
            return (String) Class.forName("host.exp.exponent.ReactNativeStaticHelpers").getMethod("getBundleUrlForActivityId", new Class[]{Integer.TYPE, String.class, String.class, String.class, Boolean.TYPE, Boolean.TYPE}).invoke(null, new Object[]{Integer.valueOf(this.mSettings.exponentActivityId), str, bundleType.typeID(), str2, Boolean.valueOf(getDevMode()), Boolean.valueOf(getJSMinifyMode())});
        } catch (String str3) {
            str3.printStackTrace();
            return null;
        }
    }

    private String createBundleURL(String str, BundleType bundleType) {
        return createBundleURL(str, bundleType, this.mSettings.getPackagerConnectionSettings().getDebugServerHost());
    }

    private static String createResourceURL(String str, String str2) {
        return String.format(Locale.US, "http://%s/%s", new Object[]{str, str2});
    }

    private static String createSymbolicateURL(String str) {
        return String.format(Locale.US, "http://%s/symbolicate", new Object[]{str});
    }

    private static String createOpenStackFrameURL(String str) {
        return String.format(Locale.US, "http://%s/open-stack-frame", new Object[]{str});
    }

    public String getDevServerBundleURL(String str) {
        return createBundleURL(str, this.mSettings.isBundleDeltasEnabled() ? BundleType.DELTA : BundleType.BUNDLE, this.mSettings.getPackagerConnectionSettings().getDebugServerHost());
    }

    public void isPackagerRunning(final PackagerStatusCallback packagerStatusCallback) {
        this.mClient.a(new C6245a().a(createPackagerStatusURL(this.mSettings.getPackagerConnectionSettings().getDebugServerHost())).b()).a(new C6217f() {
            public void onFailure(C6216e c6216e, IOException iOException) {
                String str = ReactConstants.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The packager does not seem to be running as we got an IOException requesting its status: ");
                stringBuilder.append(iOException.getMessage());
                FLog.m5714w(str, stringBuilder.toString());
                packagerStatusCallback.onPackagerStatusFetched(null);
            }

            public void onResponse(C6216e c6216e, ab abVar) {
                if (abVar.d() == null) {
                    String str = ReactConstants.TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Got non-success http code from packager when requesting status: ");
                    stringBuilder.append(abVar.c());
                    FLog.m5674e(str, stringBuilder.toString());
                    packagerStatusCallback.onPackagerStatusFetched(false);
                    return;
                }
                c6216e = abVar.h();
                if (c6216e == null) {
                    FLog.m5674e(ReactConstants.TAG, "Got null body response from packager when requesting status");
                    packagerStatusCallback.onPackagerStatusFetched(false);
                    return;
                }
                c6216e = c6216e.string();
                if (DevServerHelper.PACKAGER_OK_STATUS.equals(c6216e) == null) {
                    String str2 = ReactConstants.TAG;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Got unexpected response from packager when requesting status: ");
                    stringBuilder.append(c6216e);
                    FLog.m5674e(str2, stringBuilder.toString());
                    packagerStatusCallback.onPackagerStatusFetched(false);
                    return;
                }
                packagerStatusCallback.onPackagerStatusFetched(true);
            }
        });
    }

    private static String createPackagerStatusURL(String str) {
        return String.format(Locale.US, "http://%s/status", new Object[]{str});
    }

    public void stopPollingOnChangeEndpoint() {
        this.mOnChangePollingEnabled = false;
        this.mRestartOnChangePollingHandler.removeCallbacksAndMessages(null);
        if (this.mOnChangePollingClient != null) {
            OkHttpCallUtil.cancelTag(this.mOnChangePollingClient, this);
            this.mOnChangePollingClient = null;
        }
        this.mOnServerContentChangeListener = null;
    }

    public void startPollingOnChangeEndpoint(OnServerContentChangeListener onServerContentChangeListener) {
        if (!this.mOnChangePollingEnabled) {
            this.mOnChangePollingEnabled = true;
            this.mOnServerContentChangeListener = onServerContentChangeListener;
            this.mOnChangePollingClient = new C6243a().a(new C6224j(1, (long) LONG_POLL_KEEP_ALIVE_DURATION_MS, TimeUnit.MILLISECONDS)).a((long) HTTP_CONNECT_TIMEOUT_MS, TimeUnit.MILLISECONDS).a();
            enqueueOnChangeEndpointLongPolling();
        }
    }

    private void handleOnChangePollingResponse(boolean z) {
        if (this.mOnChangePollingEnabled) {
            if (z) {
                UiThreadUtil.runOnUiThread(new C19109());
            }
            enqueueOnChangeEndpointLongPolling();
        }
    }

    private void enqueueOnChangeEndpointLongPolling() {
        ((C7490w) Assertions.assertNotNull(this.mOnChangePollingClient)).a(new C6245a().a(createOnChangeEndpointUrl()).a(this).b()).a(new C6217f() {

            /* renamed from: com.facebook.react.devsupport.DevServerHelper$10$1 */
            class C19041 implements Runnable {
                C19041() {
                }

                public void run() {
                    DevServerHelper.this.handleOnChangePollingResponse(false);
                }
            }

            public void onFailure(C6216e c6216e, IOException iOException) {
                if (DevServerHelper.this.mOnChangePollingEnabled != null) {
                    FLog.m5667d(ReactConstants.TAG, "Error while requesting /onchange endpoint", (Throwable) iOException);
                    DevServerHelper.this.mRestartOnChangePollingHandler.postDelayed(new C19041(), (long) ((iOException instanceof SocketTimeoutException) != null ? null : DevServerHelper.LONG_POLL_FAILURE_DELAY_MS));
                }
            }

            public void onResponse(C6216e c6216e, ab abVar) {
                DevServerHelper.this.handleOnChangePollingResponse(abVar.c() == 205 ? true : null);
            }
        });
    }

    private String createOnChangeEndpointUrl() {
        return String.format(Locale.US, "http://%s/onchange", new Object[]{this.mSettings.getPackagerConnectionSettings().getDebugServerHost()});
    }

    private String createLaunchJSDevtoolsCommandUrl() {
        return String.format(Locale.US, "http://%s/launch-js-devtools", new Object[]{this.mSettings.getPackagerConnectionSettings().getDebugServerHost()});
    }

    public void launchJSDevtools() {
        this.mClient.a(new C6245a().a(createLaunchJSDevtoolsCommandUrl()).b()).a(new C6217f() {
            public void onFailure(C6216e c6216e, IOException iOException) {
            }

            public void onResponse(C6216e c6216e, ab abVar) {
            }
        });
    }

    public String getSourceMapUrl(String str) {
        return createBundleURL(str, BundleType.MAP);
    }

    public String getSourceUrl(String str) {
        return createBundleURL(str, this.mSettings.isBundleDeltasEnabled() ? BundleType.DELTA : BundleType.BUNDLE);
    }

    public String getJSBundleURLForRemoteDebugging(String str) {
        return createBundleURL(str, BundleType.BUNDLE, getHostForJSProxy());
    }

    public File downloadBundleResourceFromUrlSync(String str, File file) {
        Throwable th;
        try {
            Throwable th2;
            ab b = this.mClient.a(new C6245a().a(createResourceURL(this.mSettings.getPackagerConnectionSettings().getDebugServerHost(), str)).b()).b();
            try {
                if (b.d()) {
                    C6257r b2;
                    try {
                        b2 = C6252l.b(file);
                        try {
                            C6252l.a(b.h().source()).a(b2);
                            if (b2 != null) {
                                b2.close();
                            }
                            if (b != null) {
                                b.close();
                            }
                            return file;
                        } catch (Throwable th3) {
                            th = th3;
                            if (b2 != null) {
                                b2.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        b2 = null;
                        if (b2 != null) {
                            b2.close();
                        }
                        throw th;
                    }
                }
                if (b != null) {
                    b.close();
                }
                return null;
            } catch (Throwable th5) {
                Throwable th6 = th5;
                th5 = th2;
                th2 = th6;
            }
            if (b != null) {
                if (th5 != null) {
                    try {
                        b.close();
                    } catch (Throwable th7) {
                        th5.addSuppressed(th7);
                    }
                } else {
                    b.close();
                }
            }
            throw th2;
            throw th2;
        } catch (Exception e) {
            FLog.m5676e(ReactConstants.TAG, "Failed to fetch resource synchronously - resourcePath: \"%s\", outputFile: \"%s\"", str, file.getAbsolutePath(), e);
            return null;
        }
    }
}
