package com.onesignal;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.C0383g;

public class NotificationRestoreService extends IntentService {
    public NotificationRestoreService() {
        super("NotificationRestoreService");
    }

    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            Thread.currentThread().setPriority(10);
            am.m23152a((Context) this);
            C5542w.m23579b(this);
            C0383g.a(intent);
        }
    }
}
