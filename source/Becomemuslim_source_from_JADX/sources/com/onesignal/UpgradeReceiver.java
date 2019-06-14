package com.onesignal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;

public class UpgradeReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (VERSION.SDK_INT != 24) {
            C5542w.m23580c(context);
        }
    }
}
