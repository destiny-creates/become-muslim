package com.facebook.ads.internal.protocol;

import com.facebook.stetho.server.http.HttpStatus;

/* renamed from: com.facebook.ads.internal.protocol.f */
public enum C1487f {
    UNKNOWN(0),
    WEBVIEW_BANNER_LEGACY(4),
    WEBVIEW_BANNER_50(5),
    WEBVIEW_BANNER_90(6),
    WEBVIEW_BANNER_250(7),
    WEBVIEW_INTERSTITIAL_UNKNOWN(100),
    WEBVIEW_INTERSTITIAL_HORIZONTAL(101),
    WEBVIEW_INTERSTITIAL_VERTICAL(102),
    WEBVIEW_INTERSTITIAL_TABLET(103),
    NATIVE_UNKNOWN(HttpStatus.HTTP_OK),
    NATIVE_BANNER(HttpStatus.HTTP_INTERNAL_SERVER_ERROR),
    NATIVE_250(201),
    REWARDED_VIDEO(400),
    INSTREAM_VIDEO(300);
    
    /* renamed from: o */
    private final int f4399o;

    private C1487f(int i) {
        this.f4399o = i;
    }

    /* renamed from: a */
    public int m5253a() {
        return this.f4399o;
    }
}
