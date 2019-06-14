package com.facebook.react.devsupport;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Inspector;
import com.facebook.react.bridge.Inspector.LocalConnection;
import com.facebook.react.bridge.Inspector.Page;
import com.facebook.react.bridge.Inspector.RemoteConnection;
import com.facebook.share.internal.MessengerShareContentUtility;
import expolib_v1.p321a.C6246z.C6245a;
import expolib_v1.p321a.C7490w;
import expolib_v1.p321a.C7490w.C6243a;
import expolib_v1.p321a.ab;
import expolib_v1.p321a.af;
import expolib_v1.p321a.ag;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public class InspectorPackagerConnection {
    private static final String TAG = "InspectorPackagerConnection";
    private BundleStatusProvider mBundleStatusProvider;
    private final Connection mConnection;
    private final Map<String, LocalConnection> mInspectorConnections = new HashMap();
    private final String mPackageName;

    public static class BundleStatus {
        public Boolean isLastDownloadSucess;
        public long updateTimestamp;

        public BundleStatus(Boolean bool, long j) {
            this.updateTimestamp = -1;
            this.isLastDownloadSucess = bool;
            this.updateTimestamp = j;
        }

        public BundleStatus() {
            this(Boolean.valueOf(false), -1);
        }
    }

    public interface BundleStatusProvider {
        BundleStatus getBundleStatus();
    }

    private class Connection extends ag {
        private static final int RECONNECT_DELAY_MS = 2000;
        private boolean mClosed;
        private final Handler mHandler = new Handler(Looper.getMainLooper());
        private C7490w mHttpClient;
        private boolean mSuppressConnectionErrors;
        private final String mUrl;
        private af mWebSocket;

        /* renamed from: com.facebook.react.devsupport.InspectorPackagerConnection$Connection$1 */
        class C19181 implements Runnable {
            C19181() {
            }

            public void run() {
                if (!Connection.this.mClosed) {
                    Connection.this.connect();
                }
            }
        }

        public Connection(String str) {
            this.mUrl = str;
        }

        public void onOpen(af afVar, ab abVar) {
            this.mWebSocket = afVar;
        }

        public void onFailure(af afVar, Throwable th, ab abVar) {
            if (this.mWebSocket != null) {
                abort("Websocket exception", th);
            }
            if (this.mClosed == null) {
                reconnect();
            }
        }

        public void onMessage(af afVar, String str) {
            try {
                InspectorPackagerConnection.this.handleProxyMessage(new JSONObject(str));
            } catch (af afVar2) {
                throw new RuntimeException(afVar2);
            }
        }

        public void onClosed(af afVar, int i, String str) {
            this.mWebSocket = null;
            InspectorPackagerConnection.this.closeAllConnections();
            if (this.mClosed == null) {
                reconnect();
            }
        }

        public void connect() {
            if (this.mClosed) {
                throw new IllegalStateException("Can't connect closed client");
            }
            if (this.mHttpClient == null) {
                this.mHttpClient = new C6243a().a(10, TimeUnit.SECONDS).c(10, TimeUnit.SECONDS).b(0, TimeUnit.MINUTES).a();
            }
            this.mHttpClient.a(new C6245a().a(this.mUrl).b(), this);
        }

        private void reconnect() {
            if (this.mClosed) {
                throw new IllegalStateException("Can't reconnect closed client");
            }
            if (!this.mSuppressConnectionErrors) {
                FLog.m5714w(InspectorPackagerConnection.TAG, "Couldn't connect to packager, will silently retry");
                this.mSuppressConnectionErrors = true;
            }
            this.mHandler.postDelayed(new C19181(), 2000);
        }

        public void close() {
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
            r0 = 1;
            r3.mClosed = r0;
            r0 = r3.mWebSocket;
            if (r0 == 0) goto L_0x0013;
        L_0x0007:
            r0 = r3.mWebSocket;	 Catch:{ Exception -> 0x0010 }
            r1 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ Exception -> 0x0010 }
            r2 = "End of session";	 Catch:{ Exception -> 0x0010 }
            r0.a(r1, r2);	 Catch:{ Exception -> 0x0010 }
        L_0x0010:
            r0 = 0;
            r3.mWebSocket = r0;
        L_0x0013:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.devsupport.InspectorPackagerConnection.Connection.close():void");
        }

        public void send(final JSONObject jSONObject) {
            new AsyncTask<af, Void, Void>() {
                protected Void doInBackground(af... afVarArr) {
                    if (afVarArr != null) {
                        if (afVarArr.length != 0) {
                            try {
                                afVarArr[0].a(jSONObject.toString());
                            } catch (Throwable e) {
                                FLog.m5715w(InspectorPackagerConnection.TAG, "Couldn't send event to packager", e);
                            }
                            return null;
                        }
                    }
                    return null;
                }
            }.execute(new af[]{this.mWebSocket});
        }

        private void abort(String str, Throwable th) {
            String str2 = InspectorPackagerConnection.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error occurred, shutting down websocket connection: ");
            stringBuilder.append(str);
            FLog.m5675e(str2, stringBuilder.toString(), th);
            InspectorPackagerConnection.this.closeAllConnections();
            closeWebSocketQuietly();
        }

        private void closeWebSocketQuietly() {
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
            r0 = r3.mWebSocket;
            if (r0 == 0) goto L_0x0010;
        L_0x0004:
            r0 = r3.mWebSocket;	 Catch:{ Exception -> 0x000d }
            r1 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ Exception -> 0x000d }
            r2 = "End of session";	 Catch:{ Exception -> 0x000d }
            r0.a(r1, r2);	 Catch:{ Exception -> 0x000d }
        L_0x000d:
            r0 = 0;
            r3.mWebSocket = r0;
        L_0x0010:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.devsupport.InspectorPackagerConnection.Connection.closeWebSocketQuietly():void");
        }
    }

    public InspectorPackagerConnection(String str, String str2, BundleStatusProvider bundleStatusProvider) {
        this.mConnection = new Connection(str);
        this.mPackageName = str2;
        this.mBundleStatusProvider = bundleStatusProvider;
    }

    public void connect() {
        this.mConnection.connect();
    }

    public void closeQuietly() {
        this.mConnection.close();
    }

    public void sendEventToAllConnections(String str) {
        for (Entry value : this.mInspectorConnections.entrySet()) {
            ((LocalConnection) value.getValue()).sendMessage(str);
        }
    }

    void handleProxyMessage(JSONObject jSONObject) {
        Object obj;
        StringBuilder stringBuilder;
        String string = jSONObject.getString("event");
        int hashCode = string.hashCode();
        if (hashCode != 530405532) {
            if (hashCode != 951351530) {
                if (hashCode != 1328613653) {
                    if (hashCode == 1962251790) {
                        if (string.equals("getPages")) {
                            obj = null;
                            switch (obj) {
                                case null:
                                    sendEvent("getPages", getPages());
                                    return;
                                case 1:
                                    handleWrappedEvent(jSONObject.getJSONObject(MessengerShareContentUtility.ATTACHMENT_PAYLOAD));
                                    return;
                                case 2:
                                    handleConnect(jSONObject.getJSONObject(MessengerShareContentUtility.ATTACHMENT_PAYLOAD));
                                    return;
                                case 3:
                                    handleDisconnect(jSONObject.getJSONObject(MessengerShareContentUtility.ATTACHMENT_PAYLOAD));
                                    return;
                                default:
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append("Unknown event: ");
                                    stringBuilder.append(string);
                                    throw new IllegalArgumentException(stringBuilder.toString());
                            }
                        }
                    }
                } else if (string.equals("wrappedEvent")) {
                    obj = 1;
                    switch (obj) {
                        case null:
                            sendEvent("getPages", getPages());
                            return;
                        case 1:
                            handleWrappedEvent(jSONObject.getJSONObject(MessengerShareContentUtility.ATTACHMENT_PAYLOAD));
                            return;
                        case 2:
                            handleConnect(jSONObject.getJSONObject(MessengerShareContentUtility.ATTACHMENT_PAYLOAD));
                            return;
                        case 3:
                            handleDisconnect(jSONObject.getJSONObject(MessengerShareContentUtility.ATTACHMENT_PAYLOAD));
                            return;
                        default:
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("Unknown event: ");
                            stringBuilder.append(string);
                            throw new IllegalArgumentException(stringBuilder.toString());
                    }
                }
            } else if (string.equals("connect")) {
                obj = 2;
                switch (obj) {
                    case null:
                        sendEvent("getPages", getPages());
                        return;
                    case 1:
                        handleWrappedEvent(jSONObject.getJSONObject(MessengerShareContentUtility.ATTACHMENT_PAYLOAD));
                        return;
                    case 2:
                        handleConnect(jSONObject.getJSONObject(MessengerShareContentUtility.ATTACHMENT_PAYLOAD));
                        return;
                    case 3:
                        handleDisconnect(jSONObject.getJSONObject(MessengerShareContentUtility.ATTACHMENT_PAYLOAD));
                        return;
                    default:
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Unknown event: ");
                        stringBuilder.append(string);
                        throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
        } else if (string.equals("disconnect")) {
            obj = 3;
            switch (obj) {
                case null:
                    sendEvent("getPages", getPages());
                    return;
                case 1:
                    handleWrappedEvent(jSONObject.getJSONObject(MessengerShareContentUtility.ATTACHMENT_PAYLOAD));
                    return;
                case 2:
                    handleConnect(jSONObject.getJSONObject(MessengerShareContentUtility.ATTACHMENT_PAYLOAD));
                    return;
                case 3:
                    handleDisconnect(jSONObject.getJSONObject(MessengerShareContentUtility.ATTACHMENT_PAYLOAD));
                    return;
                default:
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown event: ");
                    stringBuilder.append(string);
                    throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        obj = -1;
        switch (obj) {
            case null:
                sendEvent("getPages", getPages());
                return;
            case 1:
                handleWrappedEvent(jSONObject.getJSONObject(MessengerShareContentUtility.ATTACHMENT_PAYLOAD));
                return;
            case 2:
                handleConnect(jSONObject.getJSONObject(MessengerShareContentUtility.ATTACHMENT_PAYLOAD));
                return;
            case 3:
                handleDisconnect(jSONObject.getJSONObject(MessengerShareContentUtility.ATTACHMENT_PAYLOAD));
                return;
            default:
                stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown event: ");
                stringBuilder.append(string);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    void closeAllConnections() {
        for (Entry value : this.mInspectorConnections.entrySet()) {
            ((LocalConnection) value.getValue()).disconnect();
        }
        this.mInspectorConnections.clear();
    }

    private void handleConnect(JSONObject jSONObject) {
        jSONObject = jSONObject.getString("pageId");
        if (((LocalConnection) this.mInspectorConnections.remove(jSONObject)) == null) {
            try {
                this.mInspectorConnections.put(jSONObject, Inspector.connect(Integer.parseInt(jSONObject), new RemoteConnection() {
                    public void onMessage(String str) {
                        try {
                            InspectorPackagerConnection.this.sendWrappedEvent(jSONObject, str);
                        } catch (Throwable e) {
                            FLog.m5715w(InspectorPackagerConnection.TAG, "Couldn't send event to packager", e);
                        }
                    }

                    public void onDisconnect() {
                        try {
                            InspectorPackagerConnection.this.mInspectorConnections.remove(jSONObject);
                            InspectorPackagerConnection.this.sendEvent("disconnect", InspectorPackagerConnection.this.makePageIdPayload(jSONObject));
                        } catch (Throwable e) {
                            FLog.m5715w(InspectorPackagerConnection.TAG, "Couldn't send event to packager", e);
                        }
                    }
                }));
                return;
            } catch (Throwable e) {
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to open page: ");
                stringBuilder.append(jSONObject);
                FLog.m5715w(str, stringBuilder.toString(), e);
                sendEvent("disconnect", makePageIdPayload(jSONObject));
                return;
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Already connected: ");
        stringBuilder2.append(jSONObject);
        throw new IllegalStateException(stringBuilder2.toString());
    }

    private void handleDisconnect(JSONObject jSONObject) {
        LocalConnection localConnection = (LocalConnection) this.mInspectorConnections.remove(jSONObject.getString("pageId"));
        if (localConnection != null) {
            localConnection.disconnect();
        }
    }

    private void handleWrappedEvent(JSONObject jSONObject) {
        String string = jSONObject.getString("pageId");
        jSONObject = jSONObject.getString("wrappedEvent");
        LocalConnection localConnection = (LocalConnection) this.mInspectorConnections.get(string);
        if (localConnection != null) {
            localConnection.sendMessage(jSONObject);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Not connected: ");
        stringBuilder.append(string);
        throw new IllegalStateException(stringBuilder.toString());
    }

    private JSONArray getPages() {
        List<Page> pages = Inspector.getPages();
        JSONArray jSONArray = new JSONArray();
        BundleStatus bundleStatus = this.mBundleStatusProvider.getBundleStatus();
        for (Page page : pages) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", String.valueOf(page.getId()));
            jSONObject.put("title", page.getTitle());
            jSONObject.put("app", this.mPackageName);
            jSONObject.put("vm", page.getVM());
            jSONObject.put("isLastBundleDownloadSuccess", bundleStatus.isLastDownloadSucess);
            jSONObject.put("bundleUpdateTimestamp", bundleStatus.updateTimestamp);
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    private void sendWrappedEvent(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pageId", str);
        jSONObject.put("wrappedEvent", str2);
        sendEvent("wrappedEvent", jSONObject);
    }

    private void sendEvent(String str, Object obj) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("event", str);
        jSONObject.put(MessengerShareContentUtility.ATTACHMENT_PAYLOAD, obj);
        this.mConnection.send(jSONObject);
    }

    private JSONObject makePageIdPayload(String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pageId", str);
        return jSONObject;
    }
}
