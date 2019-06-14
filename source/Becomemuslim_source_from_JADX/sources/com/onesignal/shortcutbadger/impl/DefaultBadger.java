package com.onesignal.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.onesignal.shortcutbadger.C5534a;
import com.onesignal.shortcutbadger.C5535b;
import com.onesignal.shortcutbadger.p253a.C5532a;
import java.util.ArrayList;
import java.util.List;

public class DefaultBadger implements C5534a {
    /* renamed from: a */
    public void mo4971a(Context context, ComponentName componentName, int i) {
        Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        intent.putExtra("badge_count", i);
        intent.putExtra("badge_count_package_name", componentName.getPackageName());
        intent.putExtra("badge_count_class_name", componentName.getClassName());
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
        return new ArrayList(0);
    }

    /* renamed from: a */
    boolean m32701a(Context context) {
        return C5532a.m23555a(context, new Intent("android.intent.action.BADGE_COUNT_UPDATE"));
    }
}
