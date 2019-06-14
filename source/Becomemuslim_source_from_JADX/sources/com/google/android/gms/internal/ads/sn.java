package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.http.SslError;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

@cm
final class sn extends WebViewClient {
    /* renamed from: a */
    private final sr f16012a;
    /* renamed from: b */
    private final sw f16013b;
    /* renamed from: c */
    private final st f16014c;
    /* renamed from: d */
    private final sv f16015d;
    /* renamed from: e */
    private final sx f16016e = new sx();

    sn(sr srVar, sw swVar, st stVar, sv svVar) {
        this.f16012a = srVar;
        this.f16013b = swVar;
        this.f16014c = stVar;
        this.f16015d = svVar;
    }

    /* renamed from: a */
    private final boolean m20097a(so soVar) {
        return this.f16012a.mo4086c(soVar);
    }

    /* renamed from: b */
    private final WebResourceResponse m20098b(so soVar) {
        return this.f16013b.mo4355d(soVar);
    }

    public final void onLoadResource(WebView webView, String str) {
        if (str != null) {
            String str2 = "Loading resource: ";
            String valueOf = String.valueOf(str);
            jn.m30864a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            this.f16014c.mo4087b(new so(str));
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        if (str != null) {
            this.f16015d.mo4088a(new so(str));
        }
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        this.f16016e.m20107a(i, str2);
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        this.f16016e.m20108a(sslError);
    }

    @TargetApi(24)
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest != null) {
            if (webResourceRequest.getUrl() != null) {
                return m20098b(new so(webResourceRequest));
            }
        }
        return null;
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return str == null ? null : m20098b(new so(str));
    }

    public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (!(keyCode == 79 || keyCode == 222)) {
            switch (keyCode) {
                case 85:
                case 86:
                case 87:
                case 88:
                case 89:
                case 90:
                case 91:
                    break;
                default:
                    switch (keyCode) {
                        case 126:
                        case 127:
                        case 128:
                        case 129:
                        case 130:
                            break;
                        default:
                            return false;
                    }
            }
        }
        return true;
    }

    @TargetApi(24)
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest != null) {
            if (webResourceRequest.getUrl() != null) {
                return m20097a(new so(webResourceRequest));
            }
        }
        return false;
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return str == null ? false : m20097a(new so(str));
    }
}
