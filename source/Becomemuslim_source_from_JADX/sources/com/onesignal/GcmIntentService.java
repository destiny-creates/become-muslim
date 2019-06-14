package com.onesignal;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class GcmIntentService extends IntentService {
    public GcmIntentService() {
        super("GcmIntentService");
        setIntentRedelivery(true);
    }

    protected void onHandleIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            C5529q.m23534a((Context) this, new C6961h(extras), null);
            GcmBroadcastReceiver.a(intent);
        }
    }
}
