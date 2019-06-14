package com.onesignal.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.onesignal.shortcutbadger.C5534a;
import com.onesignal.shortcutbadger.C5535b;
import com.onesignal.shortcutbadger.p253a.C5532a;
import java.util.Arrays;
import java.util.List;

public class AdwHomeBadger implements C5534a {
    /* renamed from: a */
    public void mo4971a(Context context, ComponentName componentName, int i) {
        Intent intent = new Intent("org.adw.launcher.counter.SEND");
        intent.putExtra("PNAME", componentName.getPackageName());
        intent.putExtra("CNAME", componentName.getClassName());
        intent.putExtra("COUNT", i);
        if (C5532a.m23555a(context, intent) != null) {
            context.sendBroadcast(intent);
            return;
        }
        componentName = new StringBuilder();
        componentName.append("unable to resolve intent: ");
        componentName.append(intent.toString());
        throw new C5535b(componentName.toString());
    }

    /* renamed from: a */
    public List<String> mo4970a() {
        return Arrays.asList(new String[]{"org.adw.launcher", "org.adwfreak.launcher"});
    }
}
