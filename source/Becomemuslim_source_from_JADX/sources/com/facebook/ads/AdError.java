package com.facebook.ads;

import android.text.TextUtils;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.C1481a;

public class AdError {
    public static final AdError AD_ASSETS_UNSUPPORTED_TYPE_ERROR = new AdError(AD_ASSETS_UNSUPPORTED_TYPE_ERROR_CODE, "unsupported type of ad assets");
    public static final int AD_ASSETS_UNSUPPORTED_TYPE_ERROR_CODE = 6003;
    public static final AdError BROKEN_MEDIA_ERROR = new AdError(BROKEN_MEDIA_ERROR_CODE, "Native ad failed to load its media");
    public static final int BROKEN_MEDIA_ERROR_CODE = 2100;
    public static final AdError CACHE_ERROR = new AdError(CACHE_ERROR_CODE, "Cache Error");
    public static final int CACHE_ERROR_CODE = 2002;
    public static final int ICONVIEW_MISSING_ERROR_CODE = 6002;
    public static final AdError INTERNAL_ERROR = new AdError(INTERNAL_ERROR_CODE, "Internal Error");
    public static final int INTERNAL_ERROR_CODE = 2001;
    public static final AdError LOAD_TOO_FREQUENTLY = new AdError(1002, "Ad was re-loaded too frequently");
    public static final int LOAD_TOO_FREQUENTLY_ERROR_CODE = 1002;
    public static final AdError MEDIATION_ERROR = new AdError(MEDIATION_ERROR_CODE, "Mediation Error");
    public static final int MEDIATION_ERROR_CODE = 3001;
    public static final int MEDIAVIEW_MISSING_ERROR_CODE = 6001;
    @Deprecated
    public static final AdError MISSING_PROPERTIES = new AdError(CACHE_ERROR_CODE, "Native ad failed to load due to missing properties");
    public static final AdError NETWORK_ERROR = new AdError(1000, "Network Error");
    public static final int NETWORK_ERROR_CODE = 1000;
    public static final AdError NO_FILL = new AdError(NO_FILL_ERROR_CODE, "No Fill");
    public static final int NO_FILL_ERROR_CODE = 1001;
    public static final AdError SERVER_ERROR = new AdError(SERVER_ERROR_CODE, "Server Error");
    public static final int SERVER_ERROR_CODE = 2000;
    /* renamed from: a */
    private final int f3645a;
    /* renamed from: b */
    private final String f3646b;

    public AdError(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "unknown error";
        }
        this.f3645a = i;
        this.f3646b = str;
    }

    public static AdError getAdErrorFromWrapper(C1481a c1481a) {
        return c1481a.m5243a().isPublicError() ? new AdError(c1481a.m5243a().getErrorCode(), c1481a.m5244b()) : new AdError(AdErrorType.UNKNOWN_ERROR.getErrorCode(), AdErrorType.UNKNOWN_ERROR.getDefaultErrorMessage());
    }

    public int getErrorCode() {
        return this.f3645a;
    }

    public String getErrorMessage() {
        return this.f3646b;
    }
}
