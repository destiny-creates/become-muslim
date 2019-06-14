package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.WebDialog;
import com.facebook.internal.WebDialog.Builder;
import com.facebook.internal.WebDialog.OnCompleteListener;
import com.facebook.login.LoginClient.Request;

class WebViewLoginMethodHandler extends WebLoginMethodHandler {
    public static final Creator<WebViewLoginMethodHandler> CREATOR = new C18342();
    private String e2e;
    private WebDialog loginDialog;

    /* renamed from: com.facebook.login.WebViewLoginMethodHandler$2 */
    static class C18342 implements Creator<WebViewLoginMethodHandler> {
        C18342() {
        }

        public WebViewLoginMethodHandler createFromParcel(Parcel parcel) {
            return new WebViewLoginMethodHandler(parcel);
        }

        public WebViewLoginMethodHandler[] newArray(int i) {
            return new WebViewLoginMethodHandler[i];
        }
    }

    static class AuthDialogBuilder extends Builder {
        private static final String OAUTH_DIALOG = "oauth";
        private String authType;
        private String e2e;
        private String redirect_uri = ServerProtocol.DIALOG_REDIRECT_URI;

        public AuthDialogBuilder setIsRerequest(boolean z) {
            return this;
        }

        public AuthDialogBuilder(Context context, String str, Bundle bundle) {
            super(context, str, OAUTH_DIALOG, bundle);
        }

        public AuthDialogBuilder setE2E(String str) {
            this.e2e = str;
            return this;
        }

        public AuthDialogBuilder setIsChromeOS(boolean z) {
            this.redirect_uri = z ? ServerProtocol.DIALOG_REDIRECT_CHROME_OS_URI : ServerProtocol.DIALOG_REDIRECT_URI;
            return this;
        }

        public AuthDialogBuilder setAuthType(String str) {
            this.authType = str;
            return this;
        }

        public WebDialog build() {
            Bundle parameters = getParameters();
            parameters.putString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, this.redirect_uri);
            parameters.putString("client_id", getApplicationId());
            parameters.putString("e2e", this.e2e);
            parameters.putString(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, ServerProtocol.DIALOG_RESPONSE_TYPE_TOKEN_AND_SIGNED_REQUEST);
            parameters.putString(ServerProtocol.DIALOG_PARAM_RETURN_SCOPES, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            parameters.putString(ServerProtocol.DIALOG_PARAM_AUTH_TYPE, this.authType);
            return WebDialog.newInstance(getContext(), OAUTH_DIALOG, parameters, getTheme(), getListener());
        }
    }

    public int describeContents() {
        return 0;
    }

    String getNameForLogging() {
        return "web_view";
    }

    boolean needsInternetPermission() {
        return true;
    }

    WebViewLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    AccessTokenSource getTokenSource() {
        return AccessTokenSource.WEB_VIEW;
    }

    void cancel() {
        if (this.loginDialog != null) {
            this.loginDialog.cancel();
            this.loginDialog = null;
        }
    }

    boolean tryAuthorize(final Request request) {
        Bundle parameters = getParameters(request);
        OnCompleteListener c37821 = new OnCompleteListener() {
            public void onComplete(Bundle bundle, FacebookException facebookException) {
                WebViewLoginMethodHandler.this.onWebDialogComplete(request, bundle, facebookException);
            }
        };
        this.e2e = LoginClient.getE2E();
        addLoggingExtra("e2e", this.e2e);
        Context activity = this.loginClient.getActivity();
        this.loginDialog = new AuthDialogBuilder(activity, request.getApplicationId(), parameters).setE2E(this.e2e).setIsChromeOS(Utility.isChromeOS(activity)).setAuthType(request.getAuthType()).setOnCompleteListener(c37821).build();
        request = new FacebookDialogFragment();
        request.setRetainInstance(true);
        request.setDialog(this.loginDialog);
        request.show(activity.getSupportFragmentManager(), FacebookDialogFragment.TAG);
        return true;
    }

    void onWebDialogComplete(Request request, Bundle bundle, FacebookException facebookException) {
        super.onComplete(request, bundle, facebookException);
    }

    WebViewLoginMethodHandler(Parcel parcel) {
        super(parcel);
        this.e2e = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.e2e);
    }
}
