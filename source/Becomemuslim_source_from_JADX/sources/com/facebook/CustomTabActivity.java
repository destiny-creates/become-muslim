package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.C0373d;

public class CustomTabActivity extends Activity {
    public static final String CUSTOM_TAB_REDIRECT_ACTION;
    private static final int CUSTOM_TAB_REDIRECT_REQUEST_CODE = 2;
    public static final String DESTROY_ACTION;
    private BroadcastReceiver closeReceiver;

    /* renamed from: com.facebook.CustomTabActivity$1 */
    class C12591 extends BroadcastReceiver {
        C12591() {
        }

        public void onReceive(Context context, Intent intent) {
            CustomTabActivity.this.finish();
        }
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CustomTabActivity.class.getSimpleName());
        stringBuilder.append(".action_customTabRedirect");
        CUSTOM_TAB_REDIRECT_ACTION = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(CustomTabActivity.class.getSimpleName());
        stringBuilder.append(".action_destroy");
        DESTROY_ACTION = stringBuilder.toString();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = new Intent(this, CustomTabMainActivity.class);
        bundle.setAction(CUSTOM_TAB_REDIRECT_ACTION);
        bundle.putExtra(CustomTabMainActivity.EXTRA_URL, getIntent().getDataString());
        bundle.addFlags(603979776);
        startActivityForResult(bundle, 2);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == 0) {
            Intent intent2 = new Intent(CUSTOM_TAB_REDIRECT_ACTION);
            intent2.putExtra(CustomTabMainActivity.EXTRA_URL, getIntent().getDataString());
            C0373d.m1138a((Context) this).m1143a(intent2);
            this.closeReceiver = new C12591();
            C0373d.m1138a((Context) this).m1142a(this.closeReceiver, new IntentFilter(DESTROY_ACTION));
        }
    }

    protected void onDestroy() {
        C0373d.m1138a((Context) this).m1141a(this.closeReceiver);
        super.onDestroy();
    }
}
