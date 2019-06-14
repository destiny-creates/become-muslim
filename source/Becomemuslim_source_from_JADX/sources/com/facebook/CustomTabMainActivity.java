package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.C0373d;
import com.facebook.internal.CustomTab;

public class CustomTabMainActivity extends Activity {
    public static final String EXTRA_CHROME_PACKAGE;
    public static final String EXTRA_PARAMS;
    public static final String EXTRA_URL;
    private static final String OAUTH_DIALOG = "oauth";
    public static final String REFRESH_ACTION;
    private BroadcastReceiver redirectReceiver;
    private boolean shouldCloseCustomTab = true;

    /* renamed from: com.facebook.CustomTabMainActivity$1 */
    class C12601 extends BroadcastReceiver {
        C12601() {
        }

        public void onReceive(Context context, Intent intent) {
            context = new Intent(CustomTabMainActivity.this, CustomTabMainActivity.class);
            context.setAction(CustomTabMainActivity.REFRESH_ACTION);
            context.putExtra(CustomTabMainActivity.EXTRA_URL, intent.getStringExtra(CustomTabMainActivity.EXTRA_URL));
            context.addFlags(603979776);
            CustomTabMainActivity.this.startActivity(context);
        }
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CustomTabMainActivity.class.getSimpleName());
        stringBuilder.append(".extra_params");
        EXTRA_PARAMS = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(CustomTabMainActivity.class.getSimpleName());
        stringBuilder.append(".extra_chromePackage");
        EXTRA_CHROME_PACKAGE = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(CustomTabMainActivity.class.getSimpleName());
        stringBuilder.append(".extra_url");
        EXTRA_URL = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(CustomTabMainActivity.class.getSimpleName());
        stringBuilder.append(".action_refresh");
        REFRESH_ACTION = stringBuilder.toString();
    }

    public static final String getRedirectUrl() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fb");
        stringBuilder.append(FacebookSdk.getApplicationId());
        stringBuilder.append("://authorize");
        return stringBuilder.toString();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION.equals(getIntent().getAction())) {
            setResult(0);
            finish();
            return;
        }
        if (bundle == null) {
            bundle = getIntent().getBundleExtra(EXTRA_PARAMS);
            new CustomTab(OAUTH_DIALOG, bundle).openCustomTab(this, getIntent().getStringExtra(EXTRA_CHROME_PACKAGE));
            this.shouldCloseCustomTab = false;
            this.redirectReceiver = new C12601();
            C0373d.m1138a((Context) this).m1142a(this.redirectReceiver, new IntentFilter(CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION));
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (REFRESH_ACTION.equals(intent.getAction())) {
            C0373d.m1138a((Context) this).m1143a(new Intent(CustomTabActivity.DESTROY_ACTION));
            sendResult(-1, intent);
        } else if (CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION.equals(intent.getAction())) {
            sendResult(-1, intent);
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.shouldCloseCustomTab) {
            sendResult(0, null);
        }
        this.shouldCloseCustomTab = true;
    }

    private void sendResult(int i, Intent intent) {
        C0373d.m1138a((Context) this).m1141a(this.redirectReceiver);
        if (intent != null) {
            setResult(i, intent);
        } else {
            setResult(i);
        }
        finish();
    }
}
