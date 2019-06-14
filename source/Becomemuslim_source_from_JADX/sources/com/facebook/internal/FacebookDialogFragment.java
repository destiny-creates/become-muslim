package com.facebook.internal;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.C4457h;
import android.support.v4.app.C4890j;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.WebDialog.Builder;
import com.facebook.internal.WebDialog.OnCompleteListener;

public class FacebookDialogFragment extends C4457h {
    public static final String TAG = "FacebookDialogFragment";
    private Dialog dialog;

    /* renamed from: com.facebook.internal.FacebookDialogFragment$1 */
    class C37671 implements OnCompleteListener {
        C37671() {
        }

        public void onComplete(Bundle bundle, FacebookException facebookException) {
            FacebookDialogFragment.this.onCompleteWebDialog(bundle, facebookException);
        }
    }

    /* renamed from: com.facebook.internal.FacebookDialogFragment$2 */
    class C37682 implements OnCompleteListener {
        C37682() {
        }

        public void onComplete(Bundle bundle, FacebookException facebookException) {
            FacebookDialogFragment.this.onCompleteWebFallbackDialog(bundle);
        }
    }

    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.dialog == null) {
            bundle = getActivity();
            Bundle methodArgumentsFromIntent = NativeProtocol.getMethodArgumentsFromIntent(bundle.getIntent());
            if (methodArgumentsFromIntent.getBoolean(NativeProtocol.WEB_DIALOG_IS_FALLBACK, false)) {
                String string = methodArgumentsFromIntent.getString("url");
                if (Utility.isNullOrEmpty(string)) {
                    Utility.logd(TAG, "Cannot start a fallback WebDialog with an empty/missing 'url'");
                    bundle.finish();
                    return;
                }
                bundle = FacebookWebFallbackDialog.newInstance(bundle, string, String.format("fb%s://bridge/", new Object[]{FacebookSdk.getApplicationId()}));
                bundle.setOnCompleteListener(new C37682());
            } else {
                String string2 = methodArgumentsFromIntent.getString(NativeProtocol.WEB_DIALOG_ACTION);
                methodArgumentsFromIntent = methodArgumentsFromIntent.getBundle(NativeProtocol.WEB_DIALOG_PARAMS);
                if (Utility.isNullOrEmpty(string2)) {
                    Utility.logd(TAG, "Cannot start a WebDialog with an empty/missing 'actionName'");
                    bundle.finish();
                    return;
                }
                bundle = new Builder(bundle, string2, methodArgumentsFromIntent).setOnCompleteListener(new C37671()).build();
            }
            this.dialog = bundle;
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.dialog == null) {
            onCompleteWebDialog(null, null);
            setShowsDialog(null);
        }
        return this.dialog;
    }

    public void onResume() {
        super.onResume();
        if (this.dialog instanceof WebDialog) {
            ((WebDialog) this.dialog).resize();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if ((this.dialog instanceof WebDialog) != null && isResumed() != null) {
            ((WebDialog) this.dialog).resize();
        }
    }

    public void onDestroyView() {
        if (getDialog() != null && getRetainInstance()) {
            getDialog().setDismissMessage(null);
        }
        super.onDestroyView();
    }

    private void onCompleteWebDialog(Bundle bundle, FacebookException facebookException) {
        C4890j activity = getActivity();
        activity.setResult(facebookException == null ? -1 : null, NativeProtocol.createProtocolResultIntent(activity.getIntent(), bundle, facebookException));
        activity.finish();
    }

    private void onCompleteWebFallbackDialog(Bundle bundle) {
        C4890j activity = getActivity();
        Intent intent = new Intent();
        if (bundle == null) {
            bundle = new Bundle();
        }
        intent.putExtras(bundle);
        activity.setResult(-1, intent);
        activity.finish();
    }
}
