package com.onesignal.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.onesignal.shortcutbadger.C5534a;
import com.onesignal.shortcutbadger.C5535b;
import com.onesignal.shortcutbadger.p253a.C5532a;
import java.util.Arrays;
import java.util.List;

public class NewHtcHomeBadger implements C5534a {
    /* renamed from: a */
    public void mo4971a(Context context, ComponentName componentName, int i) {
        Intent intent = new Intent("com.htc.launcher.action.SET_NOTIFICATION");
        intent.putExtra("com.htc.launcher.extra.COMPONENT", componentName.flattenToShortString());
        intent.putExtra("com.htc.launcher.extra.COUNT", i);
        Intent intent2 = new Intent("com.htc.launcher.action.UPDATE_SHORTCUT");
        intent2.putExtra("packagename", componentName.getPackageName());
        intent2.putExtra("count", i);
        if (C5532a.m23555a(context, intent) == null) {
            if (C5532a.m23555a(context, intent2) == null) {
                componentName = new StringBuilder();
                componentName.append("unable to resolve intent: ");
                componentName.append(intent2.toString());
                throw new C5535b(componentName.toString());
            }
        }
        context.sendBroadcast(intent);
        context.sendBroadcast(intent2);
    }

    /* renamed from: a */
    public List<String> mo4970a() {
        return Arrays.asList(new String[]{"com.htc.launcher"});
    }
}
