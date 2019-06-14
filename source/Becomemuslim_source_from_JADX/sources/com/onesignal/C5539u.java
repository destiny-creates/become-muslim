package com.onesignal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/* compiled from: NotificationOpenedActivity */
/* renamed from: com.onesignal.u */
public class C5539u extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C5540v.m23568a(this, getIntent());
        finish();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        C5540v.m23568a(this, getIntent());
        finish();
    }
}
