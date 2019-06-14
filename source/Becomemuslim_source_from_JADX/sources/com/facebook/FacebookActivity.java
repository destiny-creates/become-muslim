package com.facebook;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.C0309n;
import android.support.v4.app.C3178i;
import android.support.v4.app.C4890j;
import com.facebook.common.C1729R;
import com.facebook.common.util.UriUtil;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginFragment;
import com.facebook.share.internal.DeviceShareDialogFragment;
import com.facebook.share.model.ShareContent;

public class FacebookActivity extends C4890j {
    private static String FRAGMENT_TAG = "SingleFragment";
    public static String PASS_THROUGH_CANCEL_ACTION = "PassThrough";
    private static final String TAG = "com.facebook.FacebookActivity";
    private C3178i singleFragment;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = getIntent();
        if (!FacebookSdk.isInitialized()) {
            Utility.logd(TAG, "Facebook SDK not initialized. Make sure you call sdkInitialize inside your Application's onCreate method.");
            FacebookSdk.sdkInitialize(getApplicationContext());
        }
        setContentView(C1729R.layout.com_facebook_activity_layout);
        if (PASS_THROUGH_CANCEL_ACTION.equals(bundle.getAction()) != null) {
            handlePassThroughError();
        } else {
            this.singleFragment = getFragment();
        }
    }

    protected C3178i getFragment() {
        Intent intent = getIntent();
        C0309n supportFragmentManager = getSupportFragmentManager();
        C3178i a = supportFragmentManager.mo200a(FRAGMENT_TAG);
        if (a != null) {
            return a;
        }
        if (FacebookDialogFragment.TAG.equals(intent.getAction())) {
            a = new FacebookDialogFragment();
            a.setRetainInstance(true);
            a.show(supportFragmentManager, FRAGMENT_TAG);
            return a;
        } else if (DeviceShareDialogFragment.TAG.equals(intent.getAction())) {
            a = new DeviceShareDialogFragment();
            a.setRetainInstance(true);
            a.setShareContent((ShareContent) intent.getParcelableExtra(UriUtil.LOCAL_CONTENT_SCHEME));
            a.show(supportFragmentManager, FRAGMENT_TAG);
            return a;
        } else {
            a = new LoginFragment();
            a.setRetainInstance(true);
            supportFragmentManager.mo201a().mo183a(C1729R.id.com_facebook_fragment_container, a, FRAGMENT_TAG).mo189c();
            return a;
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.singleFragment != null) {
            this.singleFragment.onConfigurationChanged(configuration);
        }
    }

    public C3178i getCurrentFragment() {
        return this.singleFragment;
    }

    private void handlePassThroughError() {
        setResult(0, NativeProtocol.createProtocolResultIntent(getIntent(), null, NativeProtocol.getExceptionFromErrorData(NativeProtocol.getMethodArgumentsFromIntent(getIntent()))));
        finish();
    }
}
