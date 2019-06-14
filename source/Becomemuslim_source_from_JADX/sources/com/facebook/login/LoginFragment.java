package com.facebook.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.C3178i;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.C1729R;
import com.facebook.login.LoginClient.OnCompletedListener;
import com.facebook.login.LoginClient.Request;
import com.facebook.login.LoginClient.Result;

public class LoginFragment extends C3178i {
    static final String EXTRA_REQUEST = "request";
    private static final String NULL_CALLING_PKG_ERROR_MSG = "Cannot call LoginFragment with a null calling package. This can occur if the launchMode of the caller is singleInstance.";
    static final String REQUEST_KEY = "com.facebook.LoginFragment:Request";
    static final String RESULT_KEY = "com.facebook.LoginFragment:Result";
    private static final String SAVED_LOGIN_CLIENT = "loginClient";
    private static final String TAG = "LoginFragment";
    private String callingPackage;
    private LoginClient loginClient;
    private Request request;

    /* renamed from: com.facebook.login.LoginFragment$1 */
    class C37771 implements OnCompletedListener {
        C37771() {
        }

        public void onCompleted(Result result) {
            LoginFragment.this.onLoginClientCompleted(result);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.loginClient = (LoginClient) bundle.getParcelable(SAVED_LOGIN_CLIENT);
            this.loginClient.setFragment(this);
        } else {
            this.loginClient = createLoginClient();
        }
        this.loginClient.setOnCompletedListener(new C37771());
        bundle = getActivity();
        if (bundle != null) {
            initializeCallingPackage(bundle);
            bundle = bundle.getIntent();
            if (bundle != null) {
                bundle = bundle.getBundleExtra(REQUEST_KEY);
                if (bundle != null) {
                    this.request = (Request) bundle.getParcelable("request");
                }
            }
        }
    }

    protected LoginClient createLoginClient() {
        return new LoginClient((C3178i) this);
    }

    public void onDestroy() {
        this.loginClient.cancelCurrentHandler();
        super.onDestroy();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = layoutInflater.inflate(getLayoutResId(), viewGroup, false);
        viewGroup = layoutInflater.findViewById(C1729R.id.com_facebook_login_fragment_progress_bar);
        this.loginClient.setBackgroundProcessingListener(new BackgroundProcessingListener() {
            public void onBackgroundProcessingStarted() {
                viewGroup.setVisibility(0);
            }

            public void onBackgroundProcessingStopped() {
                viewGroup.setVisibility(8);
            }
        });
        return layoutInflater;
    }

    protected int getLayoutResId() {
        return C1729R.layout.com_facebook_login_fragment;
    }

    private void onLoginClientCompleted(Result result) {
        this.request = null;
        int i = result.code == Code.CANCEL ? 0 : -1;
        Bundle bundle = new Bundle();
        bundle.putParcelable(RESULT_KEY, result);
        result = new Intent();
        result.putExtras(bundle);
        if (isAdded()) {
            getActivity().setResult(i, result);
            getActivity().finish();
        }
    }

    public void onResume() {
        super.onResume();
        if (this.callingPackage == null) {
            Log.e(TAG, NULL_CALLING_PKG_ERROR_MSG);
            getActivity().finish();
            return;
        }
        this.loginClient.startOrContinueAuth(this.request);
    }

    public void onPause() {
        View view;
        super.onPause();
        if (getView() == null) {
            view = null;
        } else {
            view = getView().findViewById(C1729R.id.com_facebook_login_fragment_progress_bar);
        }
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.loginClient.onActivityResult(i, i2, intent);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(SAVED_LOGIN_CLIENT, this.loginClient);
    }

    private void initializeCallingPackage(Activity activity) {
        activity = activity.getCallingActivity();
        if (activity != null) {
            this.callingPackage = activity.getPackageName();
        }
    }

    LoginClient getLoginClient() {
        return this.loginClient;
    }
}
