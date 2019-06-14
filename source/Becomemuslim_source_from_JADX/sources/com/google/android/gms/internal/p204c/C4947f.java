package com.google.android.gms.internal.p204c;

import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;

/* renamed from: com.google.android.gms.internal.c.f */
public enum C4947f {
    CLIENT_LOGIN_DISABLED("ClientLoginDisabled"),
    DEVICE_MANAGEMENT_REQUIRED("DeviceManagementRequiredOrSyncDisabled"),
    SOCKET_TIMEOUT("SocketTimeout"),
    SUCCESS("Ok"),
    UNKNOWN_ERROR("UNKNOWN_ERR"),
    NETWORK_ERROR(NativeProtocol.ERROR_NETWORK_ERROR),
    SERVICE_UNAVAILABLE("ServiceUnavailable"),
    INTNERNAL_ERROR("InternalError"),
    BAD_AUTHENTICATION("BadAuthentication"),
    EMPTY_CONSUMER_PKG_OR_SIG("EmptyConsumerPackageOrSig"),
    NEEDS_2F("InvalidSecondFactor"),
    NEEDS_POST_SIGN_IN_FLOW("PostSignInFlowRequired"),
    NEEDS_BROWSER("NeedsBrowser"),
    UNKNOWN(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN),
    NOT_VERIFIED("NotVerified"),
    TERMS_NOT_AGREED("TermsNotAgreed"),
    ACCOUNT_DISABLED("AccountDisabled"),
    CAPTCHA("CaptchaRequired"),
    ACCOUNT_DELETED("AccountDeleted"),
    SERVICE_DISABLED(NativeProtocol.ERROR_SERVICE_DISABLED),
    NEED_PERMISSION("NeedPermission"),
    NEED_REMOTE_CONSENT("NeedRemoteConsent"),
    INVALID_SCOPE("INVALID_SCOPE"),
    USER_CANCEL("UserCancel"),
    PERMISSION_DENIED(NativeProtocol.ERROR_PERMISSION_DENIED),
    INVALID_AUDIENCE("INVALID_AUDIENCE"),
    UNREGISTERED_ON_API_CONSOLE("UNREGISTERED_ON_API_CONSOLE"),
    THIRD_PARTY_DEVICE_MANAGEMENT_REQUIRED("ThirdPartyDeviceManagementRequired"),
    DM_INTERNAL_ERROR("DeviceManagementInternalError"),
    DM_SYNC_DISABLED("DeviceManagementSyncDisabled"),
    DM_ADMIN_BLOCKED("DeviceManagementAdminBlocked"),
    DM_ADMIN_PENDING_APPROVAL("DeviceManagementAdminPendingApproval"),
    DM_STALE_SYNC_REQUIRED("DeviceManagementStaleSyncRequired"),
    DM_DEACTIVATED("DeviceManagementDeactivated"),
    DM_SCREENLOCK_REQUIRED("DeviceManagementScreenlockRequired"),
    DM_REQUIRED("DeviceManagementRequired"),
    ALREADY_HAS_GMAIL("ALREADY_HAS_GMAIL"),
    BAD_PASSWORD("WeakPassword"),
    BAD_REQUEST("BadRequest"),
    BAD_USERNAME("BadUsername"),
    DELETED_GMAIL("DeletedGmail"),
    EXISTING_USERNAME("ExistingUsername"),
    LOGIN_FAIL("LoginFail"),
    NOT_LOGGED_IN("NotLoggedIn"),
    NO_GMAIL("NoGmail"),
    REQUEST_DENIED("RequestDenied"),
    SERVER_ERROR("ServerError"),
    USERNAME_UNAVAILABLE("UsernameUnavailable"),
    GPLUS_OTHER("GPlusOther"),
    GPLUS_NICKNAME("GPlusNickname"),
    GPLUS_INVALID_CHAR("GPlusInvalidChar"),
    GPLUS_INTERSTITIAL("GPlusInterstitial"),
    GPLUS_PROFILE_ERROR("ProfileUpgradeError");
    
    private final String ab;

    private C4947f(String str) {
        this.ab = str;
    }

    /* renamed from: a */
    public static final C4947f m20218a(String str) {
        C4947f c4947f = null;
        for (C4947f c4947f2 : C4947f.values()) {
            if (c4947f2.ab.equals(str)) {
                c4947f = c4947f2;
            }
        }
        return c4947f;
    }

    /* renamed from: a */
    public static boolean m20219a(C4947f c4947f) {
        if (!(BAD_AUTHENTICATION.equals(c4947f) || CAPTCHA.equals(c4947f) || NEED_PERMISSION.equals(c4947f) || NEED_REMOTE_CONSENT.equals(c4947f) || NEEDS_BROWSER.equals(c4947f) || USER_CANCEL.equals(c4947f) || DEVICE_MANAGEMENT_REQUIRED.equals(c4947f) || DM_INTERNAL_ERROR.equals(c4947f) || DM_SYNC_DISABLED.equals(c4947f) || DM_ADMIN_BLOCKED.equals(c4947f) || DM_ADMIN_PENDING_APPROVAL.equals(c4947f) || DM_STALE_SYNC_REQUIRED.equals(c4947f) || DM_DEACTIVATED.equals(c4947f) || DM_REQUIRED.equals(c4947f) || THIRD_PARTY_DEVICE_MANAGEMENT_REQUIRED.equals(c4947f))) {
            if (DM_SCREENLOCK_REQUIRED.equals(c4947f) == null) {
                return null;
            }
        }
        return true;
    }
}
