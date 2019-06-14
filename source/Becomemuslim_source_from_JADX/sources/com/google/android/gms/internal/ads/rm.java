package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

@TargetApi(11)
@cm
public final class rm extends rn {
    public rm(qo qoVar, boolean z) {
        super(qoVar, z);
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return m37650a(webView, str, null);
    }
}
