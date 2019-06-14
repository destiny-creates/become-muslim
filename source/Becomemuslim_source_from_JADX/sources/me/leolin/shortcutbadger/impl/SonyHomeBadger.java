package me.leolin.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.Arrays;
import java.util.List;
import me.leolin.shortcutbadger.C6563a;

public class SonyHomeBadger implements C6563a {
    /* renamed from: a */
    public void mo5508a(Context context, ComponentName componentName, int i) {
        Intent intent = new Intent("com.sonyericsson.home.action.UPDATE_BADGE");
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME", componentName.getPackageName());
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME", componentName.getClassName());
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.MESSAGE", String.valueOf(i));
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", i > 0 ? 1 : 0);
        context.sendBroadcast(intent);
    }

    /* renamed from: a */
    public List<String> mo5507a() {
        return Arrays.asList(new String[]{"com.sonyericsson.home"});
    }
}
