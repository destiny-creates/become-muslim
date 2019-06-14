package com.facebook.stetho.inspector;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri.Builder;
import com.facebook.common.util.UriUtil;
import com.facebook.stetho.common.ProcessUtil;
import com.facebook.stetho.server.SocketLike;
import com.facebook.stetho.server.http.ExactPathMatcher;
import com.facebook.stetho.server.http.HandlerRegistry;
import com.facebook.stetho.server.http.HttpHandler;
import com.facebook.stetho.server.http.HttpStatus;
import com.facebook.stetho.server.http.LightHttpBody;
import com.facebook.stetho.server.http.LightHttpRequest;
import com.facebook.stetho.server.http.LightHttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;

public class ChromeDiscoveryHandler implements HttpHandler {
    private static final String PAGE_ID = "1";
    private static final String PATH_ACTIVATE = "/json/activate/1";
    private static final String PATH_PAGE_LIST = "/json";
    private static final String PATH_VERSION = "/json/version";
    private static final String PROTOCOL_VERSION = "1.1";
    private static final String USER_AGENT = "Stetho";
    private static final String WEBKIT_REV = "@188492";
    private static final String WEBKIT_VERSION = "537.36 (@188492)";
    private final Context mContext;
    private final String mInspectorPath;
    private LightHttpBody mPageListResponse;
    private LightHttpBody mVersionResponse;

    public ChromeDiscoveryHandler(Context context, String str) {
        this.mContext = context;
        this.mInspectorPath = str;
    }

    public void register(HandlerRegistry handlerRegistry) {
        handlerRegistry.register(new ExactPathMatcher(PATH_PAGE_LIST), this);
        handlerRegistry.register(new ExactPathMatcher(PATH_VERSION), this);
        handlerRegistry.register(new ExactPathMatcher(PATH_ACTIVATE), this);
    }

    public boolean handleRequest(SocketLike socketLike, LightHttpRequest lightHttpRequest, LightHttpResponse lightHttpResponse) {
        socketLike = lightHttpRequest.uri.getPath();
        try {
            if (PATH_VERSION.equals(socketLike) != null) {
                handleVersion(lightHttpResponse);
            } else if (PATH_PAGE_LIST.equals(socketLike) != null) {
                handlePageList(lightHttpResponse);
            } else if (PATH_ACTIVATE.equals(socketLike) != null) {
                handleActivate(lightHttpResponse);
            } else {
                lightHttpResponse.code = HttpStatus.HTTP_NOT_IMPLEMENTED;
                lightHttpResponse.reasonPhrase = "Not implemented";
                lightHttpRequest = new StringBuilder();
                lightHttpRequest.append("No support for ");
                lightHttpRequest.append(socketLike);
                lightHttpRequest.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
                lightHttpResponse.body = LightHttpBody.create(lightHttpRequest.toString(), "text/plain");
            }
        } catch (SocketLike socketLike2) {
            lightHttpResponse.code = HttpStatus.HTTP_INTERNAL_SERVER_ERROR;
            lightHttpResponse.reasonPhrase = "Internal server error";
            lightHttpRequest = new StringBuilder();
            lightHttpRequest.append(socketLike2.toString());
            lightHttpRequest.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            lightHttpResponse.body = LightHttpBody.create(lightHttpRequest.toString(), "text/plain");
        }
        return true;
    }

    private void handleVersion(LightHttpResponse lightHttpResponse) {
        if (this.mVersionResponse == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("WebKit-Version", WEBKIT_VERSION);
            jSONObject.put("User-Agent", USER_AGENT);
            jSONObject.put("Protocol-Version", PROTOCOL_VERSION);
            jSONObject.put("Browser", getAppLabelAndVersion());
            jSONObject.put("Android-Package", this.mContext.getPackageName());
            this.mVersionResponse = LightHttpBody.create(jSONObject.toString(), "application/json");
        }
        setSuccessfulResponse(lightHttpResponse, this.mVersionResponse);
    }

    private void handlePageList(LightHttpResponse lightHttpResponse) {
        if (this.mPageListResponse == null) {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "app");
            jSONObject.put("title", makeTitle());
            jSONObject.put("id", "1");
            jSONObject.put("description", "");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ws://");
            stringBuilder.append(this.mInspectorPath);
            jSONObject.put("webSocketDebuggerUrl", stringBuilder.toString());
            jSONObject.put("devtoolsFrontendUrl", new Builder().scheme(UriUtil.HTTP_SCHEME).authority("chrome-devtools-frontend.appspot.com").appendEncodedPath("serve_rev").appendEncodedPath(WEBKIT_REV).appendEncodedPath("devtools.html").appendQueryParameter("ws", this.mInspectorPath).build().toString());
            jSONArray.put(jSONObject);
            this.mPageListResponse = LightHttpBody.create(jSONArray.toString(), "application/json");
        }
        setSuccessfulResponse(lightHttpResponse, this.mPageListResponse);
    }

    private String makeTitle() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getAppLabel());
        stringBuilder.append(" (powered by Stetho)");
        String processName = ProcessUtil.getProcessName();
        int indexOf = processName.indexOf(58);
        if (indexOf >= 0) {
            stringBuilder.append(processName.substring(indexOf));
        }
        return stringBuilder.toString();
    }

    private void handleActivate(LightHttpResponse lightHttpResponse) {
        setSuccessfulResponse(lightHttpResponse, LightHttpBody.create("Target activation ignored\n", "text/plain"));
    }

    private static void setSuccessfulResponse(LightHttpResponse lightHttpResponse, LightHttpBody lightHttpBody) {
        lightHttpResponse.code = HttpStatus.HTTP_OK;
        lightHttpResponse.reasonPhrase = "OK";
        lightHttpResponse.body = lightHttpBody;
    }

    private String getAppLabelAndVersion() {
        StringBuilder stringBuilder = new StringBuilder();
        PackageManager packageManager = this.mContext.getPackageManager();
        stringBuilder.append(getAppLabel());
        stringBuilder.append('/');
        try {
            stringBuilder.append(packageManager.getPackageInfo(this.mContext.getPackageName(), 0).versionName);
            return stringBuilder.toString();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private CharSequence getAppLabel() {
        return this.mContext.getPackageManager().getApplicationLabel(this.mContext.getApplicationInfo());
    }
}
