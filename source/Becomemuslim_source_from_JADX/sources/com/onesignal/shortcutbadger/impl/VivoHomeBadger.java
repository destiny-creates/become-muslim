package com.onesignal.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.onesignal.shortcutbadger.C5534a;
import java.util.Arrays;
import java.util.List;

public class VivoHomeBadger implements C5534a {
    /* renamed from: a */
    public void mo4971a(Context context, ComponentName componentName, int i) {
        Intent intent = new Intent("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
        intent.putExtra("packageName", context.getPackageName());
        intent.putExtra("className", componentName.getClassName());
        intent.putExtra("notificationNum", i);
        context.sendBroadcast(intent);
    }

    /* renamed from: a */
    public List<String> mo4970a() {
        return Arrays.asList(new String[]{"com.vivo.launcher"});
    }
}
