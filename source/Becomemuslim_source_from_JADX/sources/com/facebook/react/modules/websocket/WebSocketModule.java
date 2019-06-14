package com.facebook.react.modules.websocket;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.react.modules.network.ForwardingCookieHandler;
import com.facebook.share.internal.ShareConstants;
import expolib_v1.p321a.C6246z.C6245a;
import expolib_v1.p321a.C7490w;
import expolib_v1.p321a.C7490w.C6243a;
import expolib_v1.p321a.ab;
import expolib_v1.p321a.af;
import expolib_v1.p321a.ag;
import expolib_v1.p332b.C6251f;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@ReactModule(hasConstants = false, name = "WebSocketModule")
public final class WebSocketModule extends ReactContextBaseJavaModule {
    private final Map<Integer, ContentHandler> mContentHandlers = new ConcurrentHashMap();
    private ForwardingCookieHandler mCookieHandler;
    private ReactContext mReactContext;
    private final Map<Integer, af> mWebSocketConnections = new ConcurrentHashMap();

    public interface ContentHandler {
        void onMessage(C6251f c6251f, WritableMap writableMap);

        void onMessage(String str, WritableMap writableMap);
    }

    public String getName() {
        return "WebSocketModule";
    }

    public WebSocketModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mReactContext = reactApplicationContext;
        this.mCookieHandler = new ForwardingCookieHandler(reactApplicationContext);
    }

    private void sendEvent(String str, WritableMap writableMap) {
        ((RCTDeviceEventEmitter) this.mReactContext.getJSModule(RCTDeviceEventEmitter.class)).emit(str, writableMap);
    }

    public void setContentHandler(int i, ContentHandler contentHandler) {
        if (contentHandler != null) {
            this.mContentHandlers.put(Integer.valueOf(i), contentHandler);
        } else {
            this.mContentHandlers.remove(Integer.valueOf(i));
        }
    }

    @ReactMethod
    public void connect(String str, ReadableArray readableArray, ReadableMap readableMap, final int i) {
        C7490w a = new C6243a().a(10, TimeUnit.SECONDS).c(10, TimeUnit.SECONDS).b(0, TimeUnit.MINUTES).a();
        C6245a a2 = new C6245a().a(Integer.valueOf(i)).a(str);
        String cookie = getCookie(str);
        if (cookie != null) {
            a2.b("Cookie", cookie);
        }
        if (readableMap != null && readableMap.hasKey("headers") && readableMap.getType("headers").equals(ReadableType.Map)) {
            readableMap = readableMap.getMap("headers");
            ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
            if (!readableMap.hasKey("origin")) {
                a2.b("origin", getDefaultOrigin(str));
            }
            while (keySetIterator.hasNextKey() != null) {
                str = keySetIterator.nextKey();
                if (ReadableType.String.equals(readableMap.getType(str))) {
                    a2.b(str, readableMap.getString(str));
                } else {
                    String str2 = ReactConstants.TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Ignoring: requested ");
                    stringBuilder.append(str);
                    stringBuilder.append(", value not a string");
                    FLog.m5714w(str2, stringBuilder.toString());
                }
            }
        } else {
            a2.b("origin", getDefaultOrigin(str));
        }
        if (readableArray != null && readableArray.size() > null) {
            str = new StringBuilder("");
            for (readableMap = null; readableMap < readableArray.size(); readableMap++) {
                cookie = readableArray.getString(readableMap).trim();
                if (!(cookie.isEmpty() || cookie.contains(","))) {
                    str.append(cookie);
                    str.append(",");
                }
            }
            if (str.length() > null) {
                str.replace(str.length() - 1, str.length(), "");
                a2.b("Sec-WebSocket-Protocol", str.toString());
            }
        }
        a.a(a2.b(), new ag() {
            public void onOpen(af afVar, ab abVar) {
                WebSocketModule.this.mWebSocketConnections.put(Integer.valueOf(i), afVar);
                afVar = Arguments.createMap();
                afVar.putInt("id", i);
                WebSocketModule.this.sendEvent("websocketOpen", afVar);
            }

            public void onClosed(af afVar, int i, String str) {
                afVar = Arguments.createMap();
                afVar.putInt("id", i);
                afVar.putInt("code", i);
                afVar.putString("reason", str);
                WebSocketModule.this.sendEvent("websocketClosed", afVar);
            }

            public void onFailure(af afVar, Throwable th, ab abVar) {
                WebSocketModule.this.notifyWebSocketFailed(i, th.getMessage());
            }

            public void onMessage(af afVar, String str) {
                WritableMap createMap = Arguments.createMap();
                createMap.putInt("id", i);
                createMap.putString("type", "text");
                ContentHandler contentHandler = (ContentHandler) WebSocketModule.this.mContentHandlers.get(Integer.valueOf(i));
                if (contentHandler != null) {
                    contentHandler.onMessage(str, createMap);
                } else {
                    createMap.putString("data", str);
                }
                WebSocketModule.this.sendEvent("websocketMessage", createMap);
            }

            public void onMessage(af afVar, C6251f c6251f) {
                WritableMap createMap = Arguments.createMap();
                createMap.putInt("id", i);
                createMap.putString("type", "binary");
                ContentHandler contentHandler = (ContentHandler) WebSocketModule.this.mContentHandlers.get(Integer.valueOf(i));
                if (contentHandler != null) {
                    contentHandler.onMessage(c6251f, createMap);
                } else {
                    createMap.putString("data", c6251f.b());
                }
                WebSocketModule.this.sendEvent("websocketMessage", createMap);
            }
        });
        a.t().a().shutdown();
    }

    @ReactMethod
    public void close(int i, String str, int i2) {
        af afVar = (af) this.mWebSocketConnections.get(Integer.valueOf(i2));
        if (afVar != null) {
            try {
                afVar.a(i, str);
                this.mWebSocketConnections.remove(Integer.valueOf(i2));
                this.mContentHandlers.remove(Integer.valueOf(i2));
            } catch (Throwable e) {
                str = ReactConstants.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Could not close WebSocket connection for id ");
                stringBuilder.append(i2);
                FLog.m5675e(str, stringBuilder.toString(), e);
            }
        }
    }

    @ReactMethod
    public void send(String str, int i) {
        af afVar = (af) this.mWebSocketConnections.get(Integer.valueOf(i));
        if (afVar == null) {
            str = Arguments.createMap();
            str.putInt("id", i);
            str.putString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "client is null");
            sendEvent("websocketFailed", str);
            str = Arguments.createMap();
            str.putInt("id", i);
            str.putInt("code", 0);
            str.putString("reason", "client is null");
            sendEvent("websocketClosed", str);
            this.mWebSocketConnections.remove(Integer.valueOf(i));
            this.mContentHandlers.remove(Integer.valueOf(i));
            return;
        }
        try {
            afVar.a(str);
        } catch (String str2) {
            notifyWebSocketFailed(i, str2.getMessage());
        }
    }

    @ReactMethod
    public void sendBinary(String str, int i) {
        af afVar = (af) this.mWebSocketConnections.get(Integer.valueOf(i));
        if (afVar == null) {
            str = Arguments.createMap();
            str.putInt("id", i);
            str.putString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "client is null");
            sendEvent("websocketFailed", str);
            str = Arguments.createMap();
            str.putInt("id", i);
            str.putInt("code", 0);
            str.putString("reason", "client is null");
            sendEvent("websocketClosed", str);
            this.mWebSocketConnections.remove(Integer.valueOf(i));
            this.mContentHandlers.remove(Integer.valueOf(i));
            return;
        }
        try {
            afVar.a(C6251f.b(str));
        } catch (String str2) {
            notifyWebSocketFailed(i, str2.getMessage());
        }
    }

    public void sendBinary(C6251f c6251f, int i) {
        af afVar = (af) this.mWebSocketConnections.get(Integer.valueOf(i));
        if (afVar == null) {
            c6251f = Arguments.createMap();
            c6251f.putInt("id", i);
            c6251f.putString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "client is null");
            sendEvent("websocketFailed", c6251f);
            c6251f = Arguments.createMap();
            c6251f.putInt("id", i);
            c6251f.putInt("code", 0);
            c6251f.putString("reason", "client is null");
            sendEvent("websocketClosed", c6251f);
            this.mWebSocketConnections.remove(Integer.valueOf(i));
            this.mContentHandlers.remove(Integer.valueOf(i));
            return;
        }
        try {
            afVar.a(c6251f);
        } catch (C6251f c6251f2) {
            notifyWebSocketFailed(i, c6251f2.getMessage());
        }
    }

    @ReactMethod
    public void ping(int i) {
        af afVar = (af) this.mWebSocketConnections.get(Integer.valueOf(i));
        if (afVar == null) {
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("id", i);
            createMap.putString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "client is null");
            sendEvent("websocketFailed", createMap);
            createMap = Arguments.createMap();
            createMap.putInt("id", i);
            createMap.putInt("code", 0);
            createMap.putString("reason", "client is null");
            sendEvent("websocketClosed", createMap);
            this.mWebSocketConnections.remove(Integer.valueOf(i));
            this.mContentHandlers.remove(Integer.valueOf(i));
            return;
        }
        try {
            afVar.a(C6251f.f20378b);
        } catch (Exception e) {
            notifyWebSocketFailed(i, e.getMessage());
        }
    }

    private void notifyWebSocketFailed(int i, String str) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("id", i);
        createMap.putString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, str);
        sendEvent("websocketFailed", createMap);
    }

    private static java.lang.String getDefaultOrigin(java.lang.String r7) {
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
        r0 = "";	 Catch:{ URISyntaxException -> 0x00a5 }
        r1 = new java.net.URI;	 Catch:{ URISyntaxException -> 0x00a5 }
        r1.<init>(r7);	 Catch:{ URISyntaxException -> 0x00a5 }
        r2 = r1.getScheme();	 Catch:{ URISyntaxException -> 0x00a5 }
        r3 = "wss";	 Catch:{ URISyntaxException -> 0x00a5 }
        r2 = r2.equals(r3);	 Catch:{ URISyntaxException -> 0x00a5 }
        if (r2 == 0) goto L_0x0025;	 Catch:{ URISyntaxException -> 0x00a5 }
    L_0x0013:
        r2 = new java.lang.StringBuilder;	 Catch:{ URISyntaxException -> 0x00a5 }
        r2.<init>();	 Catch:{ URISyntaxException -> 0x00a5 }
        r2.append(r0);	 Catch:{ URISyntaxException -> 0x00a5 }
        r0 = "https";	 Catch:{ URISyntaxException -> 0x00a5 }
        r2.append(r0);	 Catch:{ URISyntaxException -> 0x00a5 }
        r0 = r2.toString();	 Catch:{ URISyntaxException -> 0x00a5 }
        goto L_0x006e;	 Catch:{ URISyntaxException -> 0x00a5 }
    L_0x0025:
        r2 = r1.getScheme();	 Catch:{ URISyntaxException -> 0x00a5 }
        r3 = "ws";	 Catch:{ URISyntaxException -> 0x00a5 }
        r2 = r2.equals(r3);	 Catch:{ URISyntaxException -> 0x00a5 }
        if (r2 == 0) goto L_0x0043;	 Catch:{ URISyntaxException -> 0x00a5 }
    L_0x0031:
        r2 = new java.lang.StringBuilder;	 Catch:{ URISyntaxException -> 0x00a5 }
        r2.<init>();	 Catch:{ URISyntaxException -> 0x00a5 }
        r2.append(r0);	 Catch:{ URISyntaxException -> 0x00a5 }
        r0 = "http";	 Catch:{ URISyntaxException -> 0x00a5 }
        r2.append(r0);	 Catch:{ URISyntaxException -> 0x00a5 }
        r0 = r2.toString();	 Catch:{ URISyntaxException -> 0x00a5 }
        goto L_0x006e;	 Catch:{ URISyntaxException -> 0x00a5 }
    L_0x0043:
        r2 = r1.getScheme();	 Catch:{ URISyntaxException -> 0x00a5 }
        r3 = "http";	 Catch:{ URISyntaxException -> 0x00a5 }
        r2 = r2.equals(r3);	 Catch:{ URISyntaxException -> 0x00a5 }
        if (r2 != 0) goto L_0x005b;	 Catch:{ URISyntaxException -> 0x00a5 }
    L_0x004f:
        r2 = r1.getScheme();	 Catch:{ URISyntaxException -> 0x00a5 }
        r3 = "https";	 Catch:{ URISyntaxException -> 0x00a5 }
        r2 = r2.equals(r3);	 Catch:{ URISyntaxException -> 0x00a5 }
        if (r2 == 0) goto L_0x006e;	 Catch:{ URISyntaxException -> 0x00a5 }
    L_0x005b:
        r2 = new java.lang.StringBuilder;	 Catch:{ URISyntaxException -> 0x00a5 }
        r2.<init>();	 Catch:{ URISyntaxException -> 0x00a5 }
        r2.append(r0);	 Catch:{ URISyntaxException -> 0x00a5 }
        r0 = r1.getScheme();	 Catch:{ URISyntaxException -> 0x00a5 }
        r2.append(r0);	 Catch:{ URISyntaxException -> 0x00a5 }
        r0 = r2.toString();	 Catch:{ URISyntaxException -> 0x00a5 }
    L_0x006e:
        r2 = r1.getPort();	 Catch:{ URISyntaxException -> 0x00a5 }
        r3 = -1;	 Catch:{ URISyntaxException -> 0x00a5 }
        r4 = 1;	 Catch:{ URISyntaxException -> 0x00a5 }
        r5 = 0;	 Catch:{ URISyntaxException -> 0x00a5 }
        r6 = 2;	 Catch:{ URISyntaxException -> 0x00a5 }
        if (r2 == r3) goto L_0x0094;	 Catch:{ URISyntaxException -> 0x00a5 }
    L_0x0078:
        r2 = "%s://%s:%s";	 Catch:{ URISyntaxException -> 0x00a5 }
        r3 = 3;	 Catch:{ URISyntaxException -> 0x00a5 }
        r3 = new java.lang.Object[r3];	 Catch:{ URISyntaxException -> 0x00a5 }
        r3[r5] = r0;	 Catch:{ URISyntaxException -> 0x00a5 }
        r0 = r1.getHost();	 Catch:{ URISyntaxException -> 0x00a5 }
        r3[r4] = r0;	 Catch:{ URISyntaxException -> 0x00a5 }
        r0 = r1.getPort();	 Catch:{ URISyntaxException -> 0x00a5 }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ URISyntaxException -> 0x00a5 }
        r3[r6] = r0;	 Catch:{ URISyntaxException -> 0x00a5 }
        r0 = java.lang.String.format(r2, r3);	 Catch:{ URISyntaxException -> 0x00a5 }
        goto L_0x00a4;	 Catch:{ URISyntaxException -> 0x00a5 }
    L_0x0094:
        r2 = "%s://%s/";	 Catch:{ URISyntaxException -> 0x00a5 }
        r3 = new java.lang.Object[r6];	 Catch:{ URISyntaxException -> 0x00a5 }
        r3[r5] = r0;	 Catch:{ URISyntaxException -> 0x00a5 }
        r0 = r1.getHost();	 Catch:{ URISyntaxException -> 0x00a5 }
        r3[r4] = r0;	 Catch:{ URISyntaxException -> 0x00a5 }
        r0 = java.lang.String.format(r2, r3);	 Catch:{ URISyntaxException -> 0x00a5 }
    L_0x00a4:
        return r0;
    L_0x00a5:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Unable to set ";
        r1.append(r2);
        r1.append(r7);
        r7 = " as default origin header";
        r1.append(r7);
        r7 = r1.toString();
        r0.<init>(r7);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.websocket.WebSocketModule.getDefaultOrigin(java.lang.String):java.lang.String");
    }

    private java.lang.String getCookie(java.lang.String r4) {
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
        r3 = this;
        r0 = new java.net.URI;	 Catch:{ URISyntaxException -> 0x002f, URISyntaxException -> 0x002f }
        r1 = getDefaultOrigin(r4);	 Catch:{ URISyntaxException -> 0x002f, URISyntaxException -> 0x002f }
        r0.<init>(r1);	 Catch:{ URISyntaxException -> 0x002f, URISyntaxException -> 0x002f }
        r1 = r3.mCookieHandler;	 Catch:{ URISyntaxException -> 0x002f, URISyntaxException -> 0x002f }
        r2 = new java.util.HashMap;	 Catch:{ URISyntaxException -> 0x002f, URISyntaxException -> 0x002f }
        r2.<init>();	 Catch:{ URISyntaxException -> 0x002f, URISyntaxException -> 0x002f }
        r0 = r1.get(r0, r2);	 Catch:{ URISyntaxException -> 0x002f, URISyntaxException -> 0x002f }
        r1 = "Cookie";	 Catch:{ URISyntaxException -> 0x002f, URISyntaxException -> 0x002f }
        r0 = r0.get(r1);	 Catch:{ URISyntaxException -> 0x002f, URISyntaxException -> 0x002f }
        r0 = (java.util.List) r0;	 Catch:{ URISyntaxException -> 0x002f, URISyntaxException -> 0x002f }
        if (r0 == 0) goto L_0x002d;	 Catch:{ URISyntaxException -> 0x002f, URISyntaxException -> 0x002f }
    L_0x001e:
        r1 = r0.isEmpty();	 Catch:{ URISyntaxException -> 0x002f, URISyntaxException -> 0x002f }
        if (r1 == 0) goto L_0x0025;	 Catch:{ URISyntaxException -> 0x002f, URISyntaxException -> 0x002f }
    L_0x0024:
        goto L_0x002d;	 Catch:{ URISyntaxException -> 0x002f, URISyntaxException -> 0x002f }
    L_0x0025:
        r1 = 0;	 Catch:{ URISyntaxException -> 0x002f, URISyntaxException -> 0x002f }
        r0 = r0.get(r1);	 Catch:{ URISyntaxException -> 0x002f, URISyntaxException -> 0x002f }
        r0 = (java.lang.String) r0;	 Catch:{ URISyntaxException -> 0x002f, URISyntaxException -> 0x002f }
        return r0;
    L_0x002d:
        r4 = 0;
        return r4;
    L_0x002f:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Unable to get cookie from ";
        r1.append(r2);
        r1.append(r4);
        r4 = r1.toString();
        r0.<init>(r4);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.websocket.WebSocketModule.getCookie(java.lang.String):java.lang.String");
    }
}
