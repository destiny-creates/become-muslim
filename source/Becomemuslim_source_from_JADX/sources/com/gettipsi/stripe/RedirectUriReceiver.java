package com.gettipsi.stripe;

import android.app.Activity;
import android.os.Bundle;

public class RedirectUriReceiver extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (StripeModule.getInstance() == null) {
            m5761a(null);
        }
        StripeModule.getInstance().processRedirect(getIntent().getData());
        m5761a(-1);
    }

    /* renamed from: a */
    private void m5761a(int i) {
        setResult(i);
        finish();
    }
}
