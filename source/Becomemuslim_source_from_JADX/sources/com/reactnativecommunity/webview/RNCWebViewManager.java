package com.reactnativecommunity.webview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.DownloadManager.Request;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JavascriptInterface;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.common.util.UriUtil;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.ContentSizeChangeEvent;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.TouchesHelper;
import com.facebook.react.views.scroll.ReactScrollViewHelper;
import com.reactnativecommunity.webview.p283a.C7144a;
import com.reactnativecommunity.webview.p283a.C7145b;
import com.reactnativecommunity.webview.p283a.C7146c;
import com.reactnativecommunity.webview.p283a.C7147d;
import com.reactnativecommunity.webview.p283a.C7148e;
import com.reactnativecommunity.webview.p283a.C7149f;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import org.json.JSONObject;

@ReactModule(name = "RNCWebView")
public class RNCWebViewManager extends SimpleViewManager<WebView> {
    protected static final String BLANK_URL = "about:blank";
    public static final int COMMAND_GO_BACK = 1;
    public static final int COMMAND_GO_FORWARD = 2;
    public static final int COMMAND_INJECT_JAVASCRIPT = 6;
    public static final int COMMAND_LOAD_URL = 7;
    public static final int COMMAND_POST_MESSAGE = 5;
    public static final int COMMAND_RELOAD = 3;
    public static final int COMMAND_STOP_LOADING = 4;
    protected static final String HTML_ENCODING = "UTF-8";
    protected static final String HTML_MIME_TYPE = "text/html";
    protected static final String HTTP_METHOD_POST = "POST";
    protected static final String JAVASCRIPT_INTERFACE = "ReactNativeWebView";
    protected static final String REACT_CLASS = "RNCWebView";
    protected C5710b mWebViewConfig;

    /* renamed from: com.reactnativecommunity.webview.RNCWebViewManager$b */
    protected static class C5703b extends WebViewClient {
        /* renamed from: a */
        protected boolean f19019a = false;
        /* renamed from: b */
        protected ReadableArray f19020b;

        protected C5703b() {
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (!this.f19019a) {
                ((C7142a) webView).m33200a();
                m24152a(webView, str);
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            this.f19019a = null;
            RNCWebViewManager.dispatchEvent(webView, new C7147d(webView.getId(), m24154b(webView, str)));
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            RNCWebViewManager.dispatchEvent(webView, new C7149f(webView.getId(), m24154b(webView, str)));
            return true;
        }

        @TargetApi(24)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return shouldOverrideUrlLoading(webView, webResourceRequest.getUrl().toString());
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            this.f19019a = true;
            m24152a(webView, str2);
            str2 = m24154b(webView, str2);
            str2.putDouble("code", (double) i);
            str2.putString("description", str);
            RNCWebViewManager.dispatchEvent(webView, new C7144a(webView.getId(), str2));
        }

        /* renamed from: a */
        protected void m24152a(WebView webView, String str) {
            RNCWebViewManager.dispatchEvent(webView, new C7145b(webView.getId(), m24154b(webView, str)));
        }

        /* renamed from: b */
        protected WritableMap m24154b(WebView webView, String str) {
            WritableMap createMap = Arguments.createMap();
            createMap.putDouble(TouchesHelper.TARGET_KEY, (double) webView.getId());
            createMap.putString("url", str);
            str = "loading";
            boolean z = (this.f19019a || webView.getProgress() == 100) ? false : true;
            createMap.putBoolean(str, z);
            createMap.putString("title", webView.getTitle());
            createMap.putBoolean("canGoBack", webView.canGoBack());
            createMap.putBoolean("canGoForward", webView.canGoForward());
            return createMap;
        }

        /* renamed from: a */
        public void m24153a(ReadableArray readableArray) {
            this.f19020b = readableArray;
        }
    }

    /* renamed from: com.reactnativecommunity.webview.RNCWebViewManager$1 */
    class C71411 implements C5710b {
        /* renamed from: a */
        final /* synthetic */ RNCWebViewManager f25286a;

        /* renamed from: a */
        public void mo5064a(WebView webView) {
        }

        C71411(RNCWebViewManager rNCWebViewManager) {
            this.f25286a = rNCWebViewManager;
        }
    }

    /* renamed from: com.reactnativecommunity.webview.RNCWebViewManager$a */
    protected static class C7142a extends WebView implements LifecycleEventListener {
        /* renamed from: a */
        protected String f25287a;
        /* renamed from: b */
        protected boolean f25288b = false;
        /* renamed from: c */
        protected C5703b f25289c;
        /* renamed from: d */
        protected boolean f25290d = false;

        /* renamed from: com.reactnativecommunity.webview.RNCWebViewManager$a$a */
        protected class C5702a {
            /* renamed from: a */
            C7142a f19017a;
            /* renamed from: b */
            final /* synthetic */ C7142a f19018b;

            C5702a(C7142a c7142a, C7142a c7142a2) {
                this.f19018b = c7142a;
                this.f19017a = c7142a2;
            }

            @JavascriptInterface
            public void postMessage(String str) {
                this.f19017a.m33203b(str);
            }
        }

        public void onHostPause() {
        }

        public void onHostResume() {
        }

        public C7142a(ThemedReactContext themedReactContext) {
            super(themedReactContext);
        }

        public void setSendContentSizeChangeEvents(boolean z) {
            this.f25290d = z;
        }

        public void onHostDestroy() {
            m33202b();
        }

        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            if (this.f25290d != 0) {
                RNCWebViewManager.dispatchEvent(this, new ContentSizeChangeEvent(getId(), i, i2));
            }
        }

        public void setWebViewClient(WebViewClient webViewClient) {
            super.setWebViewClient(webViewClient);
            this.f25289c = (C5703b) webViewClient;
        }

        public C5703b getRNCWebViewClient() {
            return this.f25289c;
        }

        public void setInjectedJavaScript(String str) {
            this.f25287a = str;
        }

        /* renamed from: a */
        protected C5702a m33199a(C7142a c7142a) {
            return new C5702a(this, c7142a);
        }

        @SuppressLint({"AddJavascriptInterface"})
        public void setMessagingEnabled(boolean z) {
            if (this.f25288b != z) {
                this.f25288b = z;
                if (z) {
                    addJavascriptInterface(m33199a(this), RNCWebViewManager.JAVASCRIPT_INTERFACE);
                } else {
                    removeJavascriptInterface(RNCWebViewManager.JAVASCRIPT_INTERFACE);
                }
            }
        }

        /* renamed from: a */
        protected void m33201a(String str) {
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

        /* renamed from: a */
        public void m33200a() {
            if (getSettings().getJavaScriptEnabled() && this.f25287a != null && !TextUtils.isEmpty(this.f25287a)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("(function() {\n");
                stringBuilder.append(this.f25287a);
                stringBuilder.append(";\n})();");
                m33201a(stringBuilder.toString());
            }
        }

        /* renamed from: b */
        public void m33203b(String str) {
            RNCWebViewManager.dispatchEvent(this, new C7148e(getId(), str));
        }

        /* renamed from: b */
        protected void m33202b() {
            setWebViewClient(null);
            destroy();
        }
    }

    public String getName() {
        return "RNCWebView";
    }

    public RNCWebViewManager() {
        this.mWebViewConfig = new C71411(this);
    }

    public RNCWebViewManager(C5710b c5710b) {
        this.mWebViewConfig = c5710b;
    }

    protected static void dispatchEvent(WebView webView, Event event) {
        ((UIManagerModule) ((ReactContext) webView.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(event);
    }

    protected C7142a createRNCWebViewInstance(ThemedReactContext themedReactContext) {
        return new C7142a(themedReactContext);
    }

    @TargetApi(21)
    protected WebView createViewInstance(final ThemedReactContext themedReactContext) {
        WebView createRNCWebViewInstance = createRNCWebViewInstance(themedReactContext);
        createRNCWebViewInstance.setWebChromeClient(new WebChromeClient(this) {
            /* renamed from: b */
            final /* synthetic */ RNCWebViewManager f19014b;

            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                return true;
            }

            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                WritableMap createMap = Arguments.createMap();
                createMap.putDouble(TouchesHelper.TARGET_KEY, (double) webView.getId());
                createMap.putString("title", webView.getTitle());
                createMap.putBoolean("canGoBack", webView.canGoBack());
                createMap.putBoolean("canGoForward", webView.canGoForward());
                createMap.putDouble("progress", (double) (((float) i) / 1120403456));
                RNCWebViewManager.dispatchEvent(webView, new C7146c(webView.getId(), createMap));
            }

            public void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
                callback.invoke(str, true, false);
            }

            @TargetApi(21)
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
                webView = fileChooserParams.getAcceptTypes();
                boolean z = true;
                if (fileChooserParams.getMode() != 1) {
                    z = false;
                }
                return this.f19014b.getModule(themedReactContext).startPhotoPickerIntent(valueCallback, fileChooserParams.createIntent(), webView, z);
            }
        });
        themedReactContext.addLifecycleEventListener(createRNCWebViewInstance);
        this.mWebViewConfig.mo5064a(createRNCWebViewInstance);
        WebSettings settings = createRNCWebViewInstance.getSettings();
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        if (VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(false);
            setAllowUniversalAccessFromFileURLs(createRNCWebViewInstance, false);
        }
        setMixedContentMode(createRNCWebViewInstance, ReactScrollViewHelper.OVER_SCROLL_NEVER);
        createRNCWebViewInstance.setLayoutParams(new LayoutParams(-1, -1));
        setGeolocationEnabled(createRNCWebViewInstance, Boolean.valueOf(false));
        createRNCWebViewInstance.setDownloadListener(new DownloadListener(this) {
            /* renamed from: b */
            final /* synthetic */ RNCWebViewManager f19016b;

            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                j = this.f19016b.getModule(themedReactContext);
                Request request = new Request(Uri.parse(str));
                str3 = URLUtil.guessFileName(str, str3, str4);
                str4 = new StringBuilder();
                str4.append("Downloading ");
                str4.append(str3);
                str4 = str4.toString();
                PrintStream printStream;
                StringBuilder stringBuilder;
                try {
                    URL url = new URL(str);
                    str = new StringBuilder();
                    str.append(url.getProtocol());
                    str.append("://");
                    str.append(url.getHost());
                    str = CookieManager.getInstance().getCookie(str.toString());
                    request.addRequestHeader("Cookie", str);
                    printStream = System.out;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Got cookie for DownloadManager: ");
                    stringBuilder.append(str);
                    printStream.println(stringBuilder.toString());
                } catch (String str5) {
                    printStream = System.out;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Error getting cookie for DownloadManager: ");
                    stringBuilder.append(str5.toString());
                    printStream.println(stringBuilder.toString());
                    str5.printStackTrace();
                }
                request.addRequestHeader("User-Agent", str2);
                request.setTitle(str3);
                request.setDescription(str4);
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(1);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, str3);
                j.setDownloadRequest(request);
                if (j.grantFileDownloaderPermissions() != null) {
                    j.downloadFile();
                }
            }
        });
        return createRNCWebViewInstance;
    }

    @ReactProp(name = "javaScriptEnabled")
    public void setJavaScriptEnabled(WebView webView, boolean z) {
        webView.getSettings().setJavaScriptEnabled(z);
    }

    @ReactProp(name = "showsHorizontalScrollIndicator")
    public void setShowsHorizontalScrollIndicator(WebView webView, boolean z) {
        webView.setHorizontalScrollBarEnabled(z);
    }

    @ReactProp(name = "showsVerticalScrollIndicator")
    public void setShowsVerticalScrollIndicator(WebView webView, boolean z) {
        webView.setVerticalScrollBarEnabled(z);
    }

    @ReactProp(name = "cacheEnabled")
    public void setCacheEnabled(WebView webView, boolean z) {
        if (z) {
            z = webView.getContext();
            if (z) {
                webView.getSettings().setAppCachePath(z.getCacheDir().getAbsolutePath());
                webView.getSettings().setCacheMode(-1);
                webView.getSettings().setAppCacheEnabled(true);
                return;
            }
            return;
        }
        webView.getSettings().setCacheMode(2);
        webView.getSettings().setAppCacheEnabled(false);
    }

    @ReactProp(name = "androidHardwareAccelerationDisabled")
    public void setHardwareAccelerationDisabled(WebView webView, boolean z) {
        if (z) {
            webView.setLayerType(true, null);
        }
    }

    @ReactProp(name = "overScrollMode")
    public void setOverScrollMode(WebView webView, String str) {
        int hashCode = str.hashCode();
        if (hashCode != -1414557169) {
            if (hashCode != 104712844) {
                if (hashCode == 951530617) {
                    if (str.equals(UriUtil.LOCAL_CONTENT_SCHEME) != null) {
                        str = true;
                        switch (str) {
                            case null:
                                str = Integer.valueOf(2);
                                break;
                            case 1:
                                str = Integer.valueOf(1);
                                break;
                            default:
                                str = Integer.valueOf(0);
                                break;
                        }
                        webView.setOverScrollMode(str.intValue());
                    }
                }
            } else if (str.equals(ReactScrollViewHelper.OVER_SCROLL_NEVER) != null) {
                str = null;
                switch (str) {
                    case null:
                        str = Integer.valueOf(2);
                        break;
                    case 1:
                        str = Integer.valueOf(1);
                        break;
                    default:
                        str = Integer.valueOf(0);
                        break;
                }
                webView.setOverScrollMode(str.intValue());
            }
        } else if (str.equals(ReactScrollViewHelper.OVER_SCROLL_ALWAYS) != null) {
            str = 2;
            switch (str) {
                case null:
                    str = Integer.valueOf(2);
                    break;
                case 1:
                    str = Integer.valueOf(1);
                    break;
                default:
                    str = Integer.valueOf(0);
                    break;
            }
            webView.setOverScrollMode(str.intValue());
        }
        str = -1;
        switch (str) {
            case null:
                str = Integer.valueOf(2);
                break;
            case 1:
                str = Integer.valueOf(1);
                break;
            default:
                str = Integer.valueOf(0);
                break;
        }
        webView.setOverScrollMode(str.intValue());
    }

    @ReactProp(name = "thirdPartyCookiesEnabled")
    public void setThirdPartyCookiesEnabled(WebView webView, boolean z) {
        if (VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(webView, z);
        }
    }

    @ReactProp(name = "textZoom")
    public void setTextZoom(WebView webView, int i) {
        webView.getSettings().setTextZoom(i);
    }

    @ReactProp(name = "scalesPageToFit")
    public void setScalesPageToFit(WebView webView, boolean z) {
        webView.getSettings().setLoadWithOverviewMode(z);
        webView.getSettings().setUseWideViewPort(z);
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
    @TargetApi(17)
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
        ((C7142a) webView).setInjectedJavaScript(str);
    }

    @ReactProp(name = "messagingEnabled")
    public void setMessagingEnabled(WebView webView, boolean z) {
        ((C7142a) webView).setMessagingEnabled(z);
    }

    @com.facebook.react.uimanager.annotations.ReactProp(name = "source")
    public void setSource(android.webkit.WebView r8, com.facebook.react.bridge.ReadableMap r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        if (r9 == 0) goto L_0x00ce;
    L_0x0002:
        r0 = "html";
        r0 = r9.hasKey(r0);
        if (r0 == 0) goto L_0x002d;
    L_0x000a:
        r0 = "html";
        r3 = r9.getString(r0);
        r0 = "baseUrl";
        r0 = r9.hasKey(r0);
        if (r0 == 0) goto L_0x0020;
    L_0x0018:
        r0 = "baseUrl";
        r9 = r9.getString(r0);
    L_0x001e:
        r2 = r9;
        goto L_0x0023;
    L_0x0020:
        r9 = "";
        goto L_0x001e;
    L_0x0023:
        r4 = "text/html";
        r5 = "UTF-8";
        r6 = 0;
        r1 = r8;
        r1.loadDataWithBaseURL(r2, r3, r4, r5, r6);
        return;
    L_0x002d:
        r0 = "uri";
        r0 = r9.hasKey(r0);
        if (r0 == 0) goto L_0x00ce;
    L_0x0035:
        r0 = "uri";
        r0 = r9.getString(r0);
        r1 = r8.getUrl();
        if (r1 == 0) goto L_0x0048;
    L_0x0041:
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0048;
    L_0x0047:
        return;
    L_0x0048:
        r1 = "method";
        r1 = r9.hasKey(r1);
        if (r1 == 0) goto L_0x0081;
    L_0x0050:
        r1 = "method";
        r1 = r9.getString(r1);
        r2 = "POST";
        r1 = r1.equalsIgnoreCase(r2);
        if (r1 == 0) goto L_0x0081;
    L_0x005e:
        r1 = 0;
        r2 = "body";
        r2 = r9.hasKey(r2);
        if (r2 == 0) goto L_0x0078;
    L_0x0067:
        r1 = "body";
        r9 = r9.getString(r1);
        r1 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x0074 }
        r1 = r9.getBytes(r1);	 Catch:{ UnsupportedEncodingException -> 0x0074 }
        goto L_0x0078;
    L_0x0074:
        r1 = r9.getBytes();
    L_0x0078:
        if (r1 != 0) goto L_0x007d;
    L_0x007a:
        r9 = 0;
        r1 = new byte[r9];
    L_0x007d:
        r8.postUrl(r0, r1);
        return;
    L_0x0081:
        r1 = new java.util.HashMap;
        r1.<init>();
        r2 = "headers";
        r2 = r9.hasKey(r2);
        if (r2 == 0) goto L_0x00ca;
    L_0x008e:
        r2 = "headers";
        r9 = r9.getMap(r2);
        r2 = r9.keySetIterator();
    L_0x0098:
        r3 = r2.hasNextKey();
        if (r3 == 0) goto L_0x00ca;
    L_0x009e:
        r3 = r2.nextKey();
        r4 = "user-agent";
        r5 = java.util.Locale.ENGLISH;
        r5 = r3.toLowerCase(r5);
        r4 = r4.equals(r5);
        if (r4 == 0) goto L_0x00c2;
    L_0x00b0:
        r4 = r8.getSettings();
        if (r4 == 0) goto L_0x0098;
    L_0x00b6:
        r4 = r8.getSettings();
        r3 = r9.getString(r3);
        r4.setUserAgentString(r3);
        goto L_0x0098;
    L_0x00c2:
        r4 = r9.getString(r3);
        r1.put(r3, r4);
        goto L_0x0098;
    L_0x00ca:
        r8.loadUrl(r0, r1);
        return;
    L_0x00ce:
        r9 = "about:blank";
        r8.loadUrl(r9);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativecommunity.webview.RNCWebViewManager.setSource(android.webkit.WebView, com.facebook.react.bridge.ReadableMap):void");
    }

    @ReactProp(name = "onContentSizeChange")
    public void setOnContentSizeChange(WebView webView, boolean z) {
        ((C7142a) webView).setSendContentSizeChangeEvents(z);
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
        webView = ((C7142a) webView).getRNCWebViewClient();
        if (webView != null && readableArray != null) {
            webView.m24153a(readableArray);
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

    protected void addEventEmitters(ThemedReactContext themedReactContext, WebView webView) {
        webView.setWebViewClient(new C5703b());
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        Map exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = MapBuilder.newHashMap();
        }
        exportedCustomDirectEventTypeConstants.put("topLoadingProgress", MapBuilder.of("registrationName", "onLoadingProgress"));
        exportedCustomDirectEventTypeConstants.put("topShouldStartLoadWithRequest", MapBuilder.of("registrationName", "onShouldStartLoadWithRequest"));
        return exportedCustomDirectEventTypeConstants;
    }

    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("goBack", Integer.valueOf(1), "goForward", Integer.valueOf(2), "reload", Integer.valueOf(3), "stopLoading", Integer.valueOf(4), "postMessage", Integer.valueOf(5), "injectJavaScript", Integer.valueOf(6), "loadUrl", Integer.valueOf(7));
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
                    C7142a c7142a = (C7142a) webView;
                    i = new JSONObject();
                    i.put("data", readableArray.getString(0));
                    readableArray = new StringBuilder();
                    readableArray.append("(function () {var event;var data = ");
                    readableArray.append(i.toString());
                    readableArray.append(";try {event = new MessageEvent('message', data);} catch (e) {event = document.createEvent('MessageEvent');event.initMessageEvent('message', true, true, data.data, data.origin, data.lastEventId, data.source);}document.dispatchEvent(event);})();");
                    c7142a.m33201a(readableArray.toString());
                    return;
                } catch (WebView webView2) {
                    throw new RuntimeException(webView2);
                }
            case 6:
                ((C7142a) webView2).m33201a(readableArray.getString(0));
                return;
            case 7:
                if (readableArray != null) {
                    webView2.loadUrl(readableArray.getString(0));
                    return;
                }
                throw new RuntimeException("Arguments for loading an url are null!");
            default:
                return;
        }
    }

    public void onDropViewInstance(WebView webView) {
        super.onDropViewInstance(webView);
        C7142a c7142a = (C7142a) webView;
        ((ThemedReactContext) webView.getContext()).removeLifecycleEventListener(c7142a);
        c7142a.m33202b();
    }

    public RNCWebViewModule getModule(ReactContext reactContext) {
        return (RNCWebViewModule) reactContext.getNativeModule(RNCWebViewModule.class);
    }
}
