package com.facebook.ads.internal.protocol;

/* renamed from: com.facebook.ads.internal.protocol.c */
public enum C1484c {
    UNKNOWN,
    BANNER,
    INTERSTITIAL,
    NATIVE,
    REWARDED_VIDEO;

    /* renamed from: a */
    public static C1484c m5247a(C1487f c1487f) {
        switch (c1487f) {
            case NATIVE_UNKNOWN:
                return NATIVE;
            case WEBVIEW_BANNER_50:
            case WEBVIEW_BANNER_90:
            case WEBVIEW_BANNER_LEGACY:
            case WEBVIEW_BANNER_250:
                return BANNER;
            case WEBVIEW_INTERSTITIAL_HORIZONTAL:
            case WEBVIEW_INTERSTITIAL_VERTICAL:
            case WEBVIEW_INTERSTITIAL_TABLET:
            case WEBVIEW_INTERSTITIAL_UNKNOWN:
                return INTERSTITIAL;
            case REWARDED_VIDEO:
                return REWARDED_VIDEO;
            default:
                return UNKNOWN;
        }
    }

    /* renamed from: a */
    public AdPlacementType m5248a() {
        switch (this) {
            case INTERSTITIAL:
                return AdPlacementType.INTERSTITIAL;
            case BANNER:
                return AdPlacementType.BANNER;
            case NATIVE:
                return AdPlacementType.NATIVE;
            case REWARDED_VIDEO:
                return AdPlacementType.REWARDED_VIDEO;
            default:
                return AdPlacementType.UNKNOWN;
        }
    }
}
