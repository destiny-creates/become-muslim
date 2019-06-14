package com.facebook.ads.internal.protocol;

import com.facebook.ads.AdError;

public enum AdErrorType {
    UNKNOWN_ERROR(-1, "unknown error", false),
    NETWORK_ERROR(1000, "Network Error", true),
    NO_FILL(AdError.NO_FILL_ERROR_CODE, "No Fill", true),
    LOAD_TOO_FREQUENTLY(1002, "Ad was re-loaded too frequently", true),
    DISABLED_APP(1005, "App is disabled from making ad requests", true),
    SERVER_ERROR(AdError.SERVER_ERROR_CODE, "Server Error", true),
    INTERNAL_ERROR(AdError.INTERNAL_ERROR_CODE, "Internal Error", true),
    CACHE_FAILURE_ERROR(AdError.CACHE_ERROR_CODE, "Pre Caching failure", true),
    START_BEFORE_INIT(2004, "initAd must be called before startAd", true),
    BROKEN_MEDIA_ERROR(AdError.BROKEN_MEDIA_ERROR_CODE, "Failed to load Media for Native Ad", true),
    AD_REQUEST_FAILED(1111, "Facebook Ads SDK request for ads failed", false),
    AD_REQUEST_TIMEOUT(1112, "Facebook Ads SDK request for ads timed out", false),
    PARSER_FAILURE(1201, "Failed to parse Facebook Ads SDK delivery response", false),
    UNKNOWN_RESPONSE(1202, "Unknown Facebook Ads SDK delivery response type", false),
    ERROR_MESSAGE(1203, "Facebook Ads SDK delivery response Error message", true),
    NO_AD_PLACEMENT(1302, "Facebook Ads SDK returned no ad placements", false),
    MEDIATION_ERROR(AdError.MEDIATION_ERROR_CODE, "Mediation Error", true),
    BID_IMPRESSION_MISMATCH(4001, "Bid payload does not match placement", true),
    BID_PAYLOAD_ERROR(4002, "Invalid bid payload", false),
    NO_ADAPTER_ON_LOAD(5001, "Adapter is null onLoad Ad", false),
    NO_ADAPTER_ON_START(5002, "Adapter is null onStart Ad", false),
    INTERSTITIAL_CONTROLLER_IS_NULL(5003, "Interstitial Controller is null show Ad", false),
    NO_MEDIAVIEW_IN_NATIVEAD(AdError.MEDIAVIEW_MISSING_ERROR_CODE, "MediaView is missing in NativeAd", true),
    NO_ICONVIEW_IN_NATIVEBANNERAD(AdError.ICONVIEW_MISSING_ERROR_CODE, "IconView is missing in NativeBannerAd", true),
    UNSUPPORTED_AD_ASSET_NATIVEAD(AdError.AD_ASSETS_UNSUPPORTED_TYPE_ERROR_CODE, "unsupported type of ad assets", true),
    AD_ALREADY_STARTED(7001, "Ad already started", true),
    LOAD_CALLED_WHILE_SHOWING_AD(7002, "Ad cannot be loaded while being displayed", true);
    
    /* renamed from: a */
    private final int f4355a;
    /* renamed from: b */
    private final String f4356b;
    /* renamed from: c */
    private final boolean f4357c;

    private AdErrorType(int i, String str, boolean z) {
        this.f4355a = i;
        this.f4356b = str;
        this.f4357c = z;
    }

    public static AdErrorType adErrorTypeFromCode(int i) {
        return adErrorTypeFromCode(i, UNKNOWN_ERROR);
    }

    public static AdErrorType adErrorTypeFromCode(int i, AdErrorType adErrorType) {
        for (AdErrorType adErrorType2 : values()) {
            if (adErrorType2.getErrorCode() == i) {
                return adErrorType2;
            }
        }
        return adErrorType;
    }

    public String getDefaultErrorMessage() {
        return this.f4356b;
    }

    public int getErrorCode() {
        return this.f4355a;
    }

    public boolean isPublicError() {
        return this.f4357c;
    }
}
