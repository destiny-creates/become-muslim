package com.facebook.react.packagerconnection;

import android.net.Uri.Builder;
import com.facebook.common.logging.FLog;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import com.facebook.react.packagerconnection.ReconnectingWebSocket.ConnectionCallback;
import com.facebook.react.packagerconnection.ReconnectingWebSocket.MessageCallback;
import com.facebook.share.internal.ShareConstants;
import expolib_v1.p332b.C6251f;
import java.util.Map;
import org.json.JSONObject;

public final class JSPackagerClient implements MessageCallback {
    private static final String PACKAGER_CONNECTION_URL_FORMAT = "ws://%s/message?device=%s&app=%s&context=%s";
    private static final int PROTOCOL_VERSION = 2;
    private static final String TAG = "JSPackagerClient";
    private Map<String, RequestHandler> mRequestHandlers;
    private ReconnectingWebSocket mWebSocket;

    private class ResponderImpl implements Responder {
        private Object mId;

        public ResponderImpl(Object obj) {
            this.mId = obj;
        }

        public void respond(Object obj) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, 2);
                jSONObject.put("id", this.mId);
                jSONObject.put("result", obj);
                JSPackagerClient.this.mWebSocket.sendMessage(jSONObject.toString());
            } catch (Throwable e) {
                FLog.m5675e(JSPackagerClient.TAG, "Responding failed", e);
            }
        }

        public void error(Object obj) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, 2);
                jSONObject.put("id", this.mId);
                jSONObject.put("error", obj);
                JSPackagerClient.this.mWebSocket.sendMessage(jSONObject.toString());
            } catch (Throwable e) {
                FLog.m5675e(JSPackagerClient.TAG, "Responding with error failed", e);
            }
        }
    }

    public JSPackagerClient(String str, PackagerConnectionSettings packagerConnectionSettings, Map<String, RequestHandler> map) {
        this(str, packagerConnectionSettings, map, null);
    }

    public JSPackagerClient(String str, PackagerConnectionSettings packagerConnectionSettings, Map<String, RequestHandler> map, ConnectionCallback connectionCallback) {
        Builder builder = new Builder();
        builder.scheme("ws").encodedAuthority(packagerConnectionSettings.getDebugServerHost()).appendPath(ShareConstants.WEB_DIALOG_PARAM_MESSAGE).appendQueryParameter("device", AndroidInfoHelpers.getFriendlyDeviceName()).appendQueryParameter("app", packagerConnectionSettings.getPackageName()).appendQueryParameter("clientid", str);
        this.mWebSocket = new ReconnectingWebSocket(builder.build().toString(), this, connectionCallback);
        this.mRequestHandlers = map;
    }

    public void init() {
        this.mWebSocket.connect();
    }

    public void close() {
        this.mWebSocket.closeQuietly();
    }

    public void onMessage(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            str = jSONObject.optInt(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION);
            String optString = jSONObject.optString("method");
            Object opt = jSONObject.opt("id");
            Object opt2 = jSONObject.opt(NativeProtocol.WEB_DIALOG_PARAMS);
            if (str != 2) {
                String str2 = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Message with incompatible or missing version of protocol received: ");
                stringBuilder.append(str);
                FLog.m5674e(str2, stringBuilder.toString());
            } else if (optString == null) {
                abortOnMessage(opt, "No method provided");
            } else {
                RequestHandler requestHandler = (RequestHandler) this.mRequestHandlers.get(optString);
                if (requestHandler == null) {
                    str = new StringBuilder();
                    str.append("No request handler for method: ");
                    str.append(optString);
                    abortOnMessage(opt, str.toString());
                    return;
                }
                if (opt == null) {
                    requestHandler.onNotification(opt2);
                } else {
                    requestHandler.onRequest(opt2, new ResponderImpl(opt));
                }
            }
        } catch (Throwable e) {
            FLog.m5675e(TAG, "Handling the message failed", e);
        }
    }

    public void onMessage(C6251f c6251f) {
        FLog.m5714w(TAG, "Websocket received message with payload of unexpected type binary");
    }

    private void abortOnMessage(Object obj, String str) {
        if (obj != null) {
            new ResponderImpl(obj).error(str);
        }
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Handling the message failed with reason: ");
        stringBuilder.append(str);
        FLog.m5674e(str2, stringBuilder.toString());
    }
}
