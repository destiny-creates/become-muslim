package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.ads.internal.bv;
import com.google.android.gms.ads.internal.overlay.C4740d;
import com.google.android.gms.common.util.C2904o;

@TargetApi(11)
@cm
public final class qg extends WebChromeClient {
    /* renamed from: a */
    private final qo f15948a;

    public qg(qo qoVar) {
        this.f15948a = qoVar;
    }

    /* renamed from: a */
    private static Context m20035a(WebView webView) {
        if (!(webView instanceof qo)) {
            return webView.getContext();
        }
        qo qoVar = (qo) webView;
        Context d = qoVar.mo6128d();
        return d != null ? d : qoVar.getContext();
    }

    /* renamed from: a */
    private final boolean m20036a(Context context, String str, String str2, String str3, String str4, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
        try {
            AlertDialog create;
            if (!(this.f15948a == null || this.f15948a.mo6718v() == null || this.f15948a.mo6718v().mo4338a() == null)) {
                bv a = this.f15948a.mo6718v().mo4338a();
                if (!(a == null || a.b())) {
                    StringBuilder stringBuilder = new StringBuilder((String.valueOf(str).length() + 11) + String.valueOf(str3).length());
                    stringBuilder.append("window.");
                    stringBuilder.append(str);
                    stringBuilder.append("('");
                    stringBuilder.append(str3);
                    stringBuilder.append("')");
                    a.a(stringBuilder.toString());
                    return false;
                }
            }
            Builder builder = new Builder(context);
            builder.setTitle(str2);
            if (z) {
                View linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                View textView = new TextView(context);
                textView.setText(str3);
                View editText = new EditText(context);
                editText.setText(str4);
                linearLayout.addView(textView);
                linearLayout.addView(editText);
                create = builder.setView(linearLayout).setPositiveButton(17039370, new qm(jsPromptResult, editText)).setNegativeButton(17039360, new ql(jsPromptResult)).setOnCancelListener(new qk(jsPromptResult)).create();
            } else {
                create = builder.setMessage(str3).setPositiveButton(17039370, new qj(jsResult)).setNegativeButton(17039360, new qi(jsResult)).setOnCancelListener(new qh(jsResult)).create();
            }
            create.show();
        } catch (Throwable e) {
            mt.m19921c("Fail to display Dialog.", e);
        }
        return true;
    }

    public final void onCloseWindow(WebView webView) {
        String str;
        if (webView instanceof qo) {
            C4740d r = ((qo) webView).mo6709r();
            if (r == null) {
                str = "Tried to close an AdWebView not associated with an overlay.";
            } else {
                r.a();
                return;
            }
        }
        str = "Tried to close a WebView that wasn't an AdWebView.";
        mt.m19924e(str);
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String message = consoleMessage.message();
        String sourceId = consoleMessage.sourceId();
        int lineNumber = consoleMessage.lineNumber();
        StringBuilder stringBuilder = new StringBuilder((String.valueOf(message).length() + 19) + String.valueOf(sourceId).length());
        stringBuilder.append("JS: ");
        stringBuilder.append(message);
        stringBuilder.append(" (");
        stringBuilder.append(sourceId);
        stringBuilder.append(":");
        stringBuilder.append(lineNumber);
        stringBuilder.append(")");
        message = stringBuilder.toString();
        if (message.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        switch (qn.f15956a[consoleMessage.messageLevel().ordinal()]) {
            case 1:
                mt.m19920c(message);
                break;
            case 2:
                mt.m19924e(message);
                break;
            case 5:
                mt.m19918b(message);
                break;
            default:
                mt.m19922d(message);
                break;
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebViewTransport webViewTransport = (WebViewTransport) message.obj;
        WebView webView2 = new WebView(webView.getContext());
        if (this.f15948a.mo6719w() != null) {
            webView2.setWebViewClient(this.f15948a.mo6719w());
        }
        webViewTransport.setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    public final void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, QuotaUpdater quotaUpdater) {
        long j4 = 5242880 - j3;
        if (j4 <= 0) {
            quotaUpdater.updateQuota(j);
            return;
        }
        if (j != 0) {
            if (j2 == 0) {
                j = Math.min(j + Math.min(131072, j4), 1048576);
            } else if (j2 <= Math.min(1048576 - j, j4)) {
                j += j2;
            }
            j2 = j;
        } else if (j2 > j4 || j2 > 1048576) {
            j2 = 0;
        }
        quotaUpdater.updateQuota(j2);
    }

    public final void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
        if (callback != null) {
            boolean z;
            ax.e();
            if (!jw.m19707a(this.f15948a.getContext(), "android.permission.ACCESS_FINE_LOCATION")) {
                ax.e();
                if (!jw.m19707a(this.f15948a.getContext(), "android.permission.ACCESS_COARSE_LOCATION")) {
                    z = false;
                    callback.invoke(str, z, true);
                }
            }
            z = true;
            callback.invoke(str, z, true);
        }
    }

    public final void onHideCustomView() {
        C4740d r = this.f15948a.mo6709r();
        if (r == null) {
            mt.m19924e("Could not get ad overlay when hiding custom view.");
        } else {
            r.b();
        }
    }

    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return m20036a(m20035a(webView), "alert", str, str2, null, jsResult, null, false);
    }

    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return m20036a(m20035a(webView), "onBeforeUnload", str, str2, null, jsResult, null, false);
    }

    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return m20036a(m20035a(webView), "confirm", str, str2, null, jsResult, null, false);
    }

    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return m20036a(m20035a(webView), "prompt", str, str2, str3, null, jsPromptResult, true);
    }

    @TargetApi(21)
    public final void onPermissionRequest(PermissionRequest permissionRequest) {
        if (C2904o.i()) {
            if (!((Boolean) aph.m18688f().m18889a(asp.aC)).booleanValue()) {
                if (!(this.f15948a == null || this.f15948a.mo6718v() == null)) {
                    if (this.f15948a.mo6718v().mo4353m() != null) {
                        String[] a = this.f15948a.mo6718v().mo4353m().mo4292a(permissionRequest.getResources());
                        if (a.length > 0) {
                            permissionRequest.grant(a);
                            return;
                        } else {
                            permissionRequest.deny();
                            return;
                        }
                    }
                }
                super.onPermissionRequest(permissionRequest);
                return;
            }
        }
        super.onPermissionRequest(permissionRequest);
    }

    public final void onReachedMaxAppCacheSize(long j, long j2, QuotaUpdater quotaUpdater) {
        j += 131072;
        if (5242880 - j2 < j) {
            quotaUpdater.updateQuota(0);
        } else {
            quotaUpdater.updateQuota(j);
        }
    }

    @Deprecated
    public final void onShowCustomView(View view, int i, CustomViewCallback customViewCallback) {
        C4740d r = this.f15948a.mo6709r();
        if (r == null) {
            mt.m19924e("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
            return;
        }
        r.a(view, customViewCallback);
        r.a(i);
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        onShowCustomView(view, -1, customViewCallback);
    }
}
