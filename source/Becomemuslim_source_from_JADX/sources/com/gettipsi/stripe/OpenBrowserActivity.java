package com.gettipsi.stripe;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class OpenBrowserActivity extends Activity {
    /* renamed from: a */
    private String f5013a;
    /* renamed from: b */
    private boolean f5014b = true;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5014b = null;
        this.f5013a = getIntent().getStringExtra("url");
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.f5013a)).addFlags(1946157056));
    }

    protected void onResume() {
        super.onResume();
        if (this.f5014b) {
            StripeModule.getInstance().processRedirect(null);
            finish();
        }
        this.f5014b = true;
    }
}
