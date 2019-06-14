package com.facebook.stetho.websocket;

import android.util.Base64;
import com.facebook.stetho.common.Utf8Charset;
import com.facebook.stetho.server.SocketLike;
import com.facebook.stetho.server.http.HttpHandler;
import com.facebook.stetho.server.http.HttpStatus;
import com.facebook.stetho.server.http.LightHttpBody;
import com.facebook.stetho.server.http.LightHttpMessage;
import com.facebook.stetho.server.http.LightHttpRequest;
import com.facebook.stetho.server.http.LightHttpResponse;
import com.facebook.stetho.server.http.LightHttpServer;
import com.facebook.stetho.server.http.LightHttpServer.HttpMessageWriter;
import java.io.BufferedOutputStream;
import java.security.MessageDigest;

public class WebSocketHandler implements HttpHandler {
    private static final String HEADER_CONNECTION = "Connection";
    private static final String HEADER_CONNECTION_UPGRADE = "Upgrade";
    private static final String HEADER_SEC_WEBSOCKET_ACCEPT = "Sec-WebSocket-Accept";
    private static final String HEADER_SEC_WEBSOCKET_KEY = "Sec-WebSocket-Key";
    private static final String HEADER_SEC_WEBSOCKET_PROTOCOL = "Sec-WebSocket-Protocol";
    private static final String HEADER_SEC_WEBSOCKET_VERSION = "Sec-WebSocket-Version";
    private static final String HEADER_SEC_WEBSOCKET_VERSION_13 = "13";
    private static final String HEADER_UPGRADE = "Upgrade";
    private static final String HEADER_UPGRADE_WEBSOCKET = "websocket";
    private static final String SERVER_KEY_GUID = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    private final SimpleEndpoint mEndpoint;

    public WebSocketHandler(SimpleEndpoint simpleEndpoint) {
        this.mEndpoint = simpleEndpoint;
    }

    public boolean handleRequest(SocketLike socketLike, LightHttpRequest lightHttpRequest, LightHttpResponse lightHttpResponse) {
        if (isSupportableUpgradeRequest(lightHttpRequest)) {
            doUpgrade(socketLike, lightHttpRequest, lightHttpResponse);
            return null;
        }
        lightHttpResponse.code = HttpStatus.HTTP_NOT_IMPLEMENTED;
        lightHttpResponse.reasonPhrase = "Not Implemented";
        lightHttpResponse.body = LightHttpBody.create("Not a supported WebSocket upgrade request\n", "text/plain");
        return true;
    }

    private static boolean isSupportableUpgradeRequest(LightHttpRequest lightHttpRequest) {
        return (HEADER_UPGRADE_WEBSOCKET.equalsIgnoreCase(getFirstHeaderValue(lightHttpRequest, "Upgrade")) && "Upgrade".equals(getFirstHeaderValue(lightHttpRequest, HEADER_CONNECTION)) && HEADER_SEC_WEBSOCKET_VERSION_13.equals(getFirstHeaderValue(lightHttpRequest, HEADER_SEC_WEBSOCKET_VERSION)) != null) ? true : null;
    }

    private void doUpgrade(SocketLike socketLike, LightHttpRequest lightHttpRequest, LightHttpResponse lightHttpResponse) {
        lightHttpResponse.code = 101;
        lightHttpResponse.reasonPhrase = "Switching Protocols";
        lightHttpResponse.addHeader("Upgrade", HEADER_UPGRADE_WEBSOCKET);
        lightHttpResponse.addHeader(HEADER_CONNECTION, "Upgrade");
        lightHttpResponse.body = null;
        lightHttpRequest = getFirstHeaderValue(lightHttpRequest, HEADER_SEC_WEBSOCKET_KEY);
        if (lightHttpRequest != null) {
            lightHttpResponse.addHeader(HEADER_SEC_WEBSOCKET_ACCEPT, generateServerKey(lightHttpRequest));
        }
        lightHttpRequest = socketLike.getInput();
        socketLike = socketLike.getOutput();
        LightHttpServer.writeResponseMessage(lightHttpResponse, new HttpMessageWriter(new BufferedOutputStream(socketLike)));
        new WebSocketSession(lightHttpRequest, socketLike, this.mEndpoint).handle();
    }

    private static String generateServerKey(String str) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(SERVER_KEY_GUID);
            str = stringBuilder.toString();
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(Utf8Charset.encodeUTF8(str));
            return Base64.encodeToString(instance.digest(), 2);
        } catch (String str2) {
            throw new RuntimeException(str2);
        }
    }

    private static String getFirstHeaderValue(LightHttpMessage lightHttpMessage, String str) {
        return lightHttpMessage.getFirstHeaderValue(str);
    }
}
