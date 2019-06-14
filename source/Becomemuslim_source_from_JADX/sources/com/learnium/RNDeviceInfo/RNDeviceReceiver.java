package com.learnium.RNDeviceInfo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class RNDeviceReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("com.android.vending.INSTALL_REFERRER")) {
            context = context.getSharedPreferences("react-native-device-info", 0).edit();
            context.putString("installReferrer", intent.getStringExtra("referrer"));
            context.commit();
        }
    }
}
