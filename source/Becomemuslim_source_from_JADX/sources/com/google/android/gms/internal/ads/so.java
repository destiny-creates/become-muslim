package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import java.util.Collections;
import java.util.Map;

@cm
public final class so {
    /* renamed from: a */
    public final String f16017a;
    /* renamed from: b */
    public final Uri f16018b;
    /* renamed from: c */
    public final Map<String, String> f16019c;
    /* renamed from: d */
    private final String f16020d;

    @TargetApi(21)
    public so(WebResourceRequest webResourceRequest) {
        this(webResourceRequest.getUrl().toString(), webResourceRequest.getUrl(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders());
    }

    public so(String str) {
        this(str, Uri.parse(str), null, null);
    }

    private so(String str, Uri uri, String str2, Map<String, String> map) {
        Map emptyMap;
        this.f16017a = str;
        this.f16018b = uri;
        if (str2 == null) {
            str2 = "GET";
        }
        this.f16020d = str2;
        if (map == null) {
            emptyMap = Collections.emptyMap();
        }
        this.f16019c = emptyMap;
    }
}
