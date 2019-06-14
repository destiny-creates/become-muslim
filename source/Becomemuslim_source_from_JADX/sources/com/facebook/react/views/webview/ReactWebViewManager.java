package com.facebook.react.views.webview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Picture;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebView.PictureListener;
import android.webkit.WebViewClient;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.ContentSizeChangeEvent;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.TouchesHelper;
import com.facebook.react.views.scroll.ReactScrollViewHelper;
import com.facebook.react.views.webview.events.TopLoadingErrorEvent;
import com.facebook.react.views.webview.events.TopLoadingFinishEvent;
import com.facebook.react.views.webview.events.TopLoadingStartEvent;
import com.facebook.react.views.webview.events.TopMessageEvent;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONObject;

@ReactModule(name = "RCTWebView")
public class ReactWebViewManager extends SimpleViewManager<WebView> {
    protected static final String BLANK_URL = "about:blank";
    protected static final String BRIDGE_NAME = "__REACT_WEB_VIEW_BRIDGE";
    public static final int COMMAND_GO_BACK = 1;
    public static final int COMMAND_GO_FORWARD = 2;
    public static final int COMMAND_INJECT_JAVASCRIPT = 6;
    public static final int COMMAND_POST_MESSAGE = 5;
    public static final int COMMAND_RELOAD = 3;
    public static final int COMMAND_STOP_LOADING = 4;
    protected static final String HTML_ENCODING = "UTF-8";
    protected static final String HTML_MIME_TYPE = "text/html";
    protected static final String HTTP_METHOD_POST = "POST";
    protected static final String REACT_CLASS = "RCTWebView";
    protected PictureListener mPictureListener;
    protected WebViewConfig mWebViewConfig;

    /* renamed from: com.facebook.react.views.webview.ReactWebViewManager$2 */
    class C20002 extends WebChromeClient {
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return true;
        }

        C20002() {
        }

        public void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
            callback.invoke(str, true, false);
        }
    }

    /* renamed from: com.facebook.react.views.webview.ReactWebViewManager$3 */
    class C20013 implements PictureListener {
        C20013() {
        }

        public void onNewPicture(WebView webView, Picture picture) {
            ReactWebViewManager.dispatchEvent(webView, new ContentSizeChangeEvent(webView.getId(), webView.getWidth(), webView.getContentHeight()));
        }
    }

    protected static class ReactWebViewClient extends WebViewClient {
        protected boolean mLastLoadFailed = false;
        protected List<Pattern> mOriginWhitelist;
        protected ReadableArray mUrlPrefixesForDefaultIntent;

        protected ReactWebViewClient() {
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (!this.mLastLoadFailed) {
                ReactWebView reactWebView = (ReactWebView) webView;
                reactWebView.callInjectedJavaScript();
                reactWebView.linkBridge();
                emitFinishEvent(webView, str);
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            this.mLastLoadFailed = null;
            ReactWebViewManager.dispatchEvent(webView, new TopLoadingStartEvent(webView.getId(), createWebViewEvent(webView, str)));
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.equals(ReactWebViewManager.BLANK_URL)) {
                return false;
            }
            if (this.mUrlPrefixesForDefaultIntent != null && this.mUrlPrefixesForDefaultIntent.size() > 0) {
                Iterator it = this.mUrlPrefixesForDefaultIntent.toArrayList().iterator();
                while (it.hasNext()) {
                    if (str.startsWith((String) it.next())) {
                        launchIntent(webView.getContext(), str);
                        return true;
                    }
                }
            }
            if (this.mOriginWhitelist != null && shouldHandleURL(this.mOriginWhitelist, str)) {
                return false;
            }
            launchIntent(webView.getContext(), str);
            return true;
        }

        private void launchIntent(Context context, String str) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.setFlags(268435456);
                intent.addCategory("android.intent.category.BROWSABLE");
                context.startActivity(intent);
            } catch (Throwable e) {
                String str2 = ReactConstants.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("activity not found to handle uri scheme for: ");
                stringBuilder.append(str);
                FLog.m5715w(str2, stringBuilder.toString(), e);
            }
        }

        private boolean shouldHandleURL(List<Pattern> list, String str) {
            str = Uri.parse(str);
            String scheme = str.getScheme() != null ? str.getScheme() : "";
            str = str.getAuthority() != null ? str.getAuthority() : "";
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(scheme);
            stringBuilder.append("://");
            stringBuilder.append(str);
            str = stringBuilder.toString();
            for (Pattern matcher : list) {
                if (matcher.matcher(str).matches()) {
                    return true;
                }
            }
            return null;
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            this.mLastLoadFailed = true;
            emitFinishEvent(webView, str2);
            str2 = createWebViewEvent(webView, str2);
            str2.putDouble("code", (double) i);
            str2.putString("description", str);
            ReactWebViewManager.dispatchEvent(webView, new TopLoadingErrorEvent(webView.getId(), str2));
        }

        protected void emitFinishEvent(WebView webView, String str) {
            ReactWebViewManager.dispatchEvent(webView, new TopLoadingFinishEvent(webView.getId(), createWebViewEvent(webView, str)));
        }

        protected WritableMap createWebViewEvent(WebView webView, String str) {
            WritableMap createMap = Arguments.createMap();
            createMap.putDouble(TouchesHelper.TARGET_KEY, (double) webView.getId());
            createMap.putString("url", str);
            str = "loading";
            boolean z = (this.mLastLoadFailed || webView.getProgress() == 100) ? false : true;
            createMap.putBoolean(str, z);
            createMap.putString("title", webView.getTitle());
            createMap.putBoolean("canGoBack", webView.canGoBack());
            createMap.putBoolean("canGoForward", webView.canGoForward());
            return createMap;
        }

        public void setUrlPrefixesForDefaultIntent(ReadableArray readableArray) {
            this.mUrlPrefixesForDefaultIntent = readableArray;
        }

        public void setOriginWhitelist(List<Pattern> list) {
            this.mOriginWhitelist = list;
        }
    }

    /* renamed from: com.facebook.react.views.webview.ReactWebViewManager$1 */
    class C38961 implements WebViewConfig {
        public void configWebView(WebView webView) {
        }

        C38961() {
        }
    }

    protected static class ReactWebView extends WebView implements LifecycleEventListener {
        protected String injectedJS;
        protected ReactWebViewClient mReactWebViewClient;
        protected boolean messagingEnabled = null;

        protected class ReactWebViewBridge {
            ReactWebView mContext;

            ReactWebViewBridge(ReactWebView reactWebView) {
                this.mContext = reactWebView;
            }

            @JavascriptInterface
            public void postMessage(String str) {
                this.mContext.onMessage(str);
            }
        }

        public void onHostPause() {
        }

        public void onHostResume() {
        }

        public ReactWebView(ThemedReactContext themedReactContext) {
            super(themedReactContext);
        }

        public void onHostDestroy() {
            cleanupCallbacksAndDestroy();
        }

        public void setWebViewClient(WebViewClient webViewClient) {
            super.setWebViewClient(webViewClient);
            this.mReactWebViewClient = (ReactWebViewClient) webViewClient;
        }

        public ReactWebViewClient getReactWebViewClient() {
            return this.mReactWebViewClient;
        }

        public void setInjectedJavaScript(String str) {
            this.injectedJS = str;
        }

        protected ReactWebViewBridge createReactWebViewBridge(ReactWebView reactWebView) {
            return new ReactWebViewBridge(reactWebView);
        }

        public void setMessagingEnabled(boolean z) {
            if (this.messagingEnabled != z) {
                this.messagingEnabled = z;
                if (z) {
                    addJavascriptInterface(createReactWebViewBridge(this), ReactWebViewManager.BRIDGE_NAME);
                    linkBridge();
                } else {
                    removeJavascriptInterface(ReactWebViewManager.BRIDGE_NAME);
                }
            }
        }

        protected void evaluateJavascriptWithFallback(String str) {
            if (VERSION.SDK_INT >= 19) {
                evaluateJavascript(str, null);
                return;
            }
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("javascript:");
                stringBuilder.append(URLEncoder.encode(str, "UTF-8"));
                loadUrl(stringBuilder.toString());
            } catch (String str2) {
                throw new RuntimeException(str2);
            }
        }

        public void callInjectedJavaScript() {
            if (getSettings().getJavaScriptEnabled() && this.injectedJS != null && !TextUtils.isEmpty(this.injectedJS)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("(function() {\n");
                stringBuilder.append(this.injectedJS);
                stringBuilder.append(";\n})();");
                evaluateJavascriptWithFallback(stringBuilder.toString());
            }
        }

        public void linkBridge() {
            if (this.messagingEnabled) {
                evaluateJavascriptWithFallback("(window.originalPostMessage = window.postMessage,window.postMessage = function(data) {__REACT_WEB_VIEW_BRIDGE.postMessage(String(data));})");
            }
        }

        public void onMessage(String str) {
            ReactWebViewManager.dispatchEvent(this, new TopMessageEvent(getId(), str));
        }

        protected void cleanupCallbacksAndDestroy() {
            setWebViewClient(null);
            destroy();
        }
    }

    public String getName() {
        return REACT_CLASS;
    }

    public ReactWebViewManager() {
        this.mWebViewConfig = new C38961();
    }

    public ReactWebViewManager(WebViewConfig webViewConfig) {
        this.mWebViewConfig = webViewConfig;
    }

    protected ReactWebView createReactWebViewInstance(ThemedReactContext themedReactContext) {
        return new ReactWebView(themedReactContext);
    }

    @TargetApi(21)
    protected WebView createViewInstance(ThemedReactContext themedReactContext) {
        WebView createReactWebViewInstance = createReactWebViewInstance(themedReactContext);
        createReactWebViewInstance.setWebChromeClient(new C20002());
        themedReactContext.addLifecycleEventListener(createReactWebViewInstance);
        this.mWebViewConfig.configWebView(createReactWebViewInstance);
        themedReactContext = createReactWebViewInstance.getSettings();
        themedReactContext.setBuiltInZoomControls(true);
        themedReactContext.setDisplayZoomControls(false);
        themedReactContext.setDomStorageEnabled(true);
        themedReactContext.setAllowFileAccess(false);
        themedReactContext.setAllowContentAccess(false);
        if (VERSION.SDK_INT >= 16) {
            themedReactContext.setAllowFileAccessFromFileURLs(false);
            setAllowUniversalAccessFromFileURLs(createReactWebViewInstance, false);
        }
        setMixedContentMode(createReactWebViewInstance, ReactScrollViewHelper.OVER_SCROLL_NEVER);
        createReactWebViewInstance.setLayoutParams(new LayoutParams(-1, -1));
        setGeolocationEnabled(createReactWebViewInstance, Boolean.valueOf(false));
        return createReactWebViewInstance;
    }

    @ReactProp(name = "javaScriptEnabled")
    public void setJavaScriptEnabled(WebView webView, boolean z) {
        webView.getSettings().setJavaScriptEnabled(z);
    }

    @ReactProp(name = "thirdPartyCookiesEnabled")
    public void setThirdPartyCookiesEnabled(WebView webView, boolean z) {
        if (VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(webView, z);
        }
    }

    @ReactProp(name = "scalesPageToFit")
    public void setScalesPageToFit(WebView webView, boolean z) {
        webView.getSettings().setUseWideViewPort(z ^ 1);
    }

    @ReactProp(name = "domStorageEnabled")
    public void setDomStorageEnabled(WebView webView, boolean z) {
        webView.getSettings().setDomStorageEnabled(z);
    }

    @ReactProp(name = "userAgent")
    public void setUserAgent(WebView webView, String str) {
        if (str != null) {
            webView.getSettings().setUserAgentString(str);
        }
    }

    @ReactProp(name = "mediaPlaybackRequiresUserAction")
    public void setMediaPlaybackRequiresUserAction(WebView webView, boolean z) {
        webView.getSettings().setMediaPlaybackRequiresUserGesture(z);
    }

    @ReactProp(name = "allowUniversalAccessFromFileURLs")
    public void setAllowUniversalAccessFromFileURLs(WebView webView, boolean z) {
        webView.getSettings().setAllowUniversalAccessFromFileURLs(z);
    }

    @ReactProp(name = "saveFormDataDisabled")
    public void setSaveFormDataDisabled(WebView webView, boolean z) {
        webView.getSettings().setSaveFormData(z ^ 1);
    }

    @ReactProp(name = "injectedJavaScript")
    public void setInjectedJavaScript(WebView webView, String str) {
        ((ReactWebView) webView).setInjectedJavaScript(str);
    }

    @ReactProp(name = "messagingEnabled")
    public void setMessagingEnabled(WebView webView, boolean z) {
        ((ReactWebView) webView).setMessagingEnabled(z);
    }

    @com.facebook.react.uimanager.annotations.ReactProp(name = "source")
    public void setSource(android.webkit.WebView r8, com.facebook.react.bridge.ReadableMap r9) {
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
        r7 = this;
        if (r9 == 0) goto L_0x00d1;
    L_0x0002:
        r0 = "html";
        r0 = r9.hasKey(r0);
        if (r0 == 0) goto L_0x0030;
    L_0x000a:
        r0 = "html";
        r3 = r9.getString(r0);
        r0 = "baseUrl";
        r0 = r9.hasKey(r0);
        if (r0 == 0) goto L_0x0028;
    L_0x0018:
        r0 = "baseUrl";
        r2 = r9.getString(r0);
        r4 = "text/html";
        r5 = "UTF-8";
        r6 = 0;
        r1 = r8;
        r1.loadDataWithBaseURL(r2, r3, r4, r5, r6);
        goto L_0x002f;
    L_0x0028:
        r9 = "text/html";
        r0 = "UTF-8";
        r8.loadData(r3, r9, r0);
    L_0x002f:
        return;
    L_0x0030:
        r0 = "uri";
        r0 = r9.hasKey(r0);
        if (r0 == 0) goto L_0x00d1;
    L_0x0038:
        r0 = "uri";
        r0 = r9.getString(r0);
        r1 = r8.getUrl();
        if (r1 == 0) goto L_0x004b;
    L_0x0044:
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x004b;
    L_0x004a:
        return;
    L_0x004b:
        r1 = "method";
        r1 = r9.hasKey(r1);
        if (r1 == 0) goto L_0x0084;
    L_0x0053:
        r1 = "method";
        r1 = r9.getString(r1);
        r2 = "POST";
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x0084;
    L_0x0061:
        r1 = 0;
        r2 = "body";
        r2 = r9.hasKey(r2);
        if (r2 == 0) goto L_0x007b;
    L_0x006a:
        r1 = "body";
        r9 = r9.getString(r1);
        r1 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x0077 }
        r1 = r9.getBytes(r1);	 Catch:{ UnsupportedEncodingException -> 0x0077 }
        goto L_0x007b;
    L_0x0077:
        r1 = r9.getBytes();
    L_0x007b:
        if (r1 != 0) goto L_0x0080;
    L_0x007d:
        r9 = 0;
        r1 = new byte[r9];
    L_0x0080:
        r8.postUrl(r0, r1);
        return;
    L_0x0084:
        r1 = new java.util.HashMap;
        r1.<init>();
        r2 = "headers";
        r2 = r9.hasKey(r2);
        if (r2 == 0) goto L_0x00cd;
    L_0x0091:
        r2 = "headers";
        r9 = r9.getMap(r2);
        r2 = r9.keySetIterator();
    L_0x009b:
        r3 = r2.hasNextKey();
        if (r3 == 0) goto L_0x00cd;
    L_0x00a1:
        r3 = r2.nextKey();
        r4 = "user-agent";
        r5 = java.util.Locale.ENGLISH;
        r5 = r3.toLowerCase(r5);
        r4 = r4.equals(r5);
        if (r4 == 0) goto L_0x00c5;
    L_0x00b3:
        r4 = r8.getSettings();
        if (r4 == 0) goto L_0x009b;
    L_0x00b9:
        r4 = r8.getSettings();
        r3 = r9.getString(r3);
        r4.setUserAgentString(r3);
        goto L_0x009b;
    L_0x00c5:
        r4 = r9.getString(r3);
        r1.put(r3, r4);
        goto L_0x009b;
    L_0x00cd:
        r8.loadUrl(r0, r1);
        return;
    L_0x00d1:
        r9 = "about:blank";
        r8.loadUrl(r9);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.webview.ReactWebViewManager.setSource(android.webkit.WebView, com.facebook.react.bridge.ReadableMap):void");
    }

    @ReactProp(name = "onContentSizeChange")
    public void setOnContentSizeChange(WebView webView, boolean z) {
        if (z) {
            webView.setPictureListener(getPictureListener());
        } else {
            webView.setPictureListener(false);
        }
    }

    @ReactProp(name = "mixedContentMode")
    public void setMixedContentMode(WebView webView, String str) {
        if (VERSION.SDK_INT >= 21) {
            if (str != null) {
                if (!ReactScrollViewHelper.OVER_SCROLL_NEVER.equals(str)) {
                    if (ReactScrollViewHelper.OVER_SCROLL_ALWAYS.equals(str)) {
                        webView.getSettings().setMixedContentMode(null);
                        return;
                    } else if ("compatibility".equals(str) != null) {
                        webView.getSettings().setMixedContentMode(2);
                        return;
                    } else {
                        return;
                    }
                }
            }
            webView.getSettings().setMixedContentMode(1);
        }
    }

    @ReactProp(name = "urlPrefixesForDefaultIntent")
    public void setUrlPrefixesForDefaultIntent(WebView webView, ReadableArray readableArray) {
        webView = ((ReactWebView) webView).getReactWebViewClient();
        if (webView != null && readableArray != null) {
            webView.setUrlPrefixesForDefaultIntent(readableArray);
        }
    }

    @ReactProp(name = "allowFileAccess")
    public void setAllowFileAccess(WebView webView, Boolean bool) {
        webView = webView.getSettings();
        bool = (bool == null || bool.booleanValue() == null) ? null : true;
        webView.setAllowFileAccess(bool);
    }

    @ReactProp(name = "geolocationEnabled")
    public void setGeolocationEnabled(WebView webView, Boolean bool) {
        webView = webView.getSettings();
        bool = (bool == null || bool.booleanValue() == null) ? null : true;
        webView.setGeolocationEnabled(bool);
    }

    @ReactProp(name = "originWhitelist")
    public void setOriginWhitelist(WebView webView, ReadableArray readableArray) {
        webView = ((ReactWebView) webView).getReactWebViewClient();
        if (webView != null && readableArray != null) {
            List linkedList = new LinkedList();
            for (int i = 0; i < readableArray.size(); i++) {
                linkedList.add(Pattern.compile(readableArray.getString(i)));
            }
            webView.setOriginWhitelist(linkedList);
        }
    }

    protected void addEventEmitters(ThemedReactContext themedReactContext, WebView webView) {
        webView.setWebViewClient(new ReactWebViewClient());
    }

    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("goBack", Integer.valueOf(1), "goForward", Integer.valueOf(2), "reload", Integer.valueOf(3), "stopLoading", Integer.valueOf(4), "postMessage", Integer.valueOf(5), "injectJavaScript", Integer.valueOf(6));
    }

    public void receiveCommand(WebView webView, int i, ReadableArray readableArray) {
        switch (i) {
            case 1:
                webView.goBack();
                return;
            case 2:
                webView.goForward();
                return;
            case 3:
                webView.reload();
                return;
            case 4:
                webView.stopLoading();
                return;
            case 5:
                try {
                    ReactWebView reactWebView = (ReactWebView) webView;
                    i = new JSONObject();
                    i.put("data", readableArray.getString(0));
                    readableArray = new StringBuilder();
                    readableArray.append("(function () {var event;var data = ");
                    readableArray.append(i.toString());
                    readableArray.append(";try {event = new MessageEvent('message', data);} catch (e) {event = document.createEvent('MessageEvent');event.initMessageEvent('message', true, true, data.data, data.origin, data.lastEventId, data.source);}document.dispatchEvent(event);})();");
                    reactWebView.evaluateJavascriptWithFallback(readableArray.toString());
                    return;
                } catch (WebView webView2) {
                    throw new RuntimeException(webView2);
                }
            case 6:
                ((ReactWebView) webView2).evaluateJavascriptWithFallback(readableArray.getString(0));
                return;
            default:
                return;
        }
    }

    public void onDropViewInstance(WebView webView) {
        super.onDropViewInstance(webView);
        ReactWebView reactWebView = (ReactWebView) webView;
        ((ThemedReactContext) webView.getContext()).removeLifecycleEventListener(reactWebView);
        reactWebView.cleanupCallbacksAndDestroy();
    }

    protected PictureListener getPictureListener() {
        if (this.mPictureListener == null) {
            this.mPictureListener = new C20013();
        }
        return this.mPictureListener;
    }

    protected static void dispatchEvent(WebView webView, Event event) {
        ((UIManagerModule) ((ReactContext) webView.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(event);
    }
}
