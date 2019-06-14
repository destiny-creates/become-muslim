package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

@TargetApi(21)
@cm
public final class ro extends rn {
    public ro(qo qoVar, boolean z) {
        super(qoVar, z);
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest != null) {
            if (webResourceRequest.getUrl() != null) {
                return m37650a(webView, webResourceRequest.getUrl().toString(), webResourceRequest.getRequestHeaders());
            }
        }
        return null;
    }
}
