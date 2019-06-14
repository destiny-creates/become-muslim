package com.facebook.react.devsupport;

import android.util.JsonReader;
import android.util.JsonToken;
import android.util.JsonWriter;
import com.facebook.common.logging.FLog;
import com.facebook.react.common.JavascriptException;
import expolib_v1.com.facebook.infer.annotation.Assertions;
import expolib_v1.p321a.C6246z.C6245a;
import expolib_v1.p321a.C7490w;
import expolib_v1.p321a.C7490w.C6243a;
import expolib_v1.p321a.ab;
import expolib_v1.p321a.af;
import expolib_v1.p321a.ag;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class JSDebuggerWebSocketClient extends ag {
    private static final String TAG = "JSDebuggerWebSocketClient";
    private final ConcurrentHashMap<Integer, JSDebuggerCallback> mCallbacks = new ConcurrentHashMap();
    private JSDebuggerCallback mConnectCallback;
    private C7490w mHttpClient;
    private final AtomicInteger mRequestID = new AtomicInteger();
    private af mWebSocket;

    public interface JSDebuggerCallback {
        void onFailure(Throwable th);

        void onSuccess(String str);
    }

    public void connect(String str, JSDebuggerCallback jSDebuggerCallback) {
        if (this.mHttpClient == null) {
            this.mConnectCallback = jSDebuggerCallback;
            this.mHttpClient = new C6243a().a(10, TimeUnit.SECONDS).c(10, TimeUnit.SECONDS).b(0, TimeUnit.MINUTES).a();
            this.mHttpClient.a(new C6245a().a(str).b(), this);
            return;
        }
        throw new IllegalStateException("JSDebuggerWebSocketClient is already initialized.");
    }

    public void prepareJSRuntime(JSDebuggerCallback jSDebuggerCallback) {
        int andIncrement = this.mRequestID.getAndIncrement();
        this.mCallbacks.put(Integer.valueOf(andIncrement), jSDebuggerCallback);
        try {
            jSDebuggerCallback = new StringWriter();
            new JsonWriter(jSDebuggerCallback).beginObject().name("id").value((long) andIncrement).name("method").value("prepareJSRuntime").endObject().close();
            sendMessage(andIncrement, jSDebuggerCallback.toString());
        } catch (JSDebuggerCallback jSDebuggerCallback2) {
            triggerRequestFailure(andIncrement, jSDebuggerCallback2);
        }
    }

    public void loadApplicationScript(String str, HashMap<String, String> hashMap, JSDebuggerCallback jSDebuggerCallback) {
        int andIncrement = this.mRequestID.getAndIncrement();
        this.mCallbacks.put(Integer.valueOf(andIncrement), jSDebuggerCallback);
        try {
            jSDebuggerCallback = new StringWriter();
            str = new JsonWriter(jSDebuggerCallback).beginObject().name("id").value((long) andIncrement).name("method").value("executeApplicationScript").name("url").value(str).name("inject").beginObject();
            for (String str2 : hashMap.keySet()) {
                str.name(str2).value((String) hashMap.get(str2));
            }
            str.endObject().endObject().close();
            sendMessage(andIncrement, jSDebuggerCallback.toString());
        } catch (String str3) {
            triggerRequestFailure(andIncrement, str3);
        }
    }

    public void executeJSCall(String str, String str2, JSDebuggerCallback jSDebuggerCallback) {
        int andIncrement = this.mRequestID.getAndIncrement();
        this.mCallbacks.put(Integer.valueOf(andIncrement), jSDebuggerCallback);
        try {
            jSDebuggerCallback = new StringWriter();
            JsonWriter jsonWriter = new JsonWriter(jSDebuggerCallback);
            jsonWriter.beginObject().name("id").value((long) andIncrement).name("method").value(str);
            jSDebuggerCallback.append(",\"arguments\":").append(str2);
            jsonWriter.endObject().close();
            sendMessage(andIncrement, jSDebuggerCallback.toString());
        } catch (String str3) {
            triggerRequestFailure(andIncrement, str3);
        }
    }

    public void closeQuietly() {
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.devsupport.JSDebuggerWebSocketClient.closeQuietly():void");
    }

    private void sendMessage(int i, String str) {
        if (this.mWebSocket == null) {
            triggerRequestFailure(i, new IllegalStateException("WebSocket connection no longer valid"));
            return;
        }
        try {
            this.mWebSocket.a(str);
        } catch (String str2) {
            triggerRequestFailure(i, str2);
        }
    }

    private void triggerRequestFailure(int i, Throwable th) {
        JSDebuggerCallback jSDebuggerCallback = (JSDebuggerCallback) this.mCallbacks.get(Integer.valueOf(i));
        if (jSDebuggerCallback != null) {
            this.mCallbacks.remove(Integer.valueOf(i));
            jSDebuggerCallback.onFailure(th);
        }
    }

    private void triggerRequestSuccess(int i, String str) {
        JSDebuggerCallback jSDebuggerCallback = (JSDebuggerCallback) this.mCallbacks.get(Integer.valueOf(i));
        if (jSDebuggerCallback != null) {
            this.mCallbacks.remove(Integer.valueOf(i));
            jSDebuggerCallback.onSuccess(str);
        }
    }

    public void onMessage(af afVar, String str) {
        afVar = null;
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            jsonReader.beginObject();
            str = afVar;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (JsonToken.NULL == jsonReader.peek()) {
                    jsonReader.skipValue();
                } else if ("replyID".equals(nextName)) {
                    afVar = Integer.valueOf(jsonReader.nextInt());
                } else if ("result".equals(nextName)) {
                    str = jsonReader.nextString();
                } else if ("error".equals(nextName)) {
                    nextName = jsonReader.nextString();
                    abort(nextName, new JavascriptException(nextName));
                }
            }
            if (afVar != null) {
                triggerRequestSuccess(afVar.intValue(), str);
            }
        } catch (String str2) {
            if (afVar != null) {
                triggerRequestFailure(afVar.intValue(), str2);
            } else {
                abort("Parsing response message from websocket failed", str2);
            }
        }
    }

    public void onFailure(af afVar, Throwable th, ab abVar) {
        abort("Websocket exception", th);
    }

    public void onOpen(af afVar, ab abVar) {
        this.mWebSocket = afVar;
        ((JSDebuggerCallback) Assertions.assertNotNull(this.mConnectCallback)).onSuccess(null);
        this.mConnectCallback = null;
    }

    public void onClosed(af afVar, int i, String str) {
        this.mWebSocket = null;
    }

    private void abort(String str, Throwable th) {
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Error occurred, shutting down websocket connection: ");
        stringBuilder.append(str);
        FLog.m5675e(str2, stringBuilder.toString(), th);
        closeQuietly();
        if (this.mConnectCallback != null) {
            this.mConnectCallback.onFailure(th);
            this.mConnectCallback = null;
        }
        for (JSDebuggerCallback onFailure : this.mCallbacks.values()) {
            onFailure.onFailure(th);
        }
        this.mCallbacks.clear();
    }
}
