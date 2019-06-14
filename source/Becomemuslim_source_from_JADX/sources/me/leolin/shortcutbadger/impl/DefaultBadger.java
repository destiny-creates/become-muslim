package me.leolin.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.List;
import me.leolin.shortcutbadger.C6563a;

public class DefaultBadger implements C6563a {
    /* renamed from: a */
    public void mo5508a(Context context, ComponentName componentName, int i) {
        Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        intent.putExtra("badge_count", i);
        intent.putExtra("badge_count_package_name", componentName.getPackageName());
        intent.putExtra("badge_count_class_name", componentName.getClassName());
        context.sendBroadcast(intent);
    }

    /* renamed from: a */
    public List<String> mo5507a() {
        return new ArrayList(0);
    }
}
