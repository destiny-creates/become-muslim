package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.ax;
import java.io.File;
import java.util.Collections;
import java.util.Map;

@TargetApi(11)
@cm
public class rn extends qp {
    public rn(qo qoVar, boolean z) {
        super(qoVar, z);
    }

    /* renamed from: a */
    protected final WebResourceResponse m37650a(WebView webView, String str, Map<String, String> map) {
        if (webView instanceof qo) {
            qo qoVar = (qo) webView;
            if (this.a != null) {
                this.a.mo4291a(str, map, 1);
            }
            if ("mraid.js".equalsIgnoreCase(new File(str).getName())) {
                if (qoVar.mo6718v() != null) {
                    qoVar.mo6718v().mo4354n();
                }
                asf asf = qoVar.mo6135t().m20093d() ? asp.f14920K : qoVar.mo6137z() ? asp.f14919J : asp.f14918I;
                str = (String) aph.m18688f().m18889a(asf);
                ax.e();
                return jw.m19717c(qoVar.getContext(), qoVar.mo6133k().f28709a, str);
            }
            Map emptyMap;
            if (map == null) {
                emptyMap = Collections.emptyMap();
            }
            return super.m31011a(str, emptyMap);
        }
        mt.m19924e("Tried to intercept request from a WebView that wasn't an AdWebView.");
        return null;
    }
}
