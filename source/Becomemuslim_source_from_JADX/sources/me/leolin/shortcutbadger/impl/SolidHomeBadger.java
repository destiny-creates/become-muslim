package me.leolin.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.Arrays;
import java.util.List;
import me.leolin.shortcutbadger.C6563a;

public class SolidHomeBadger implements C6563a {
    /* renamed from: a */
    public void mo5508a(Context context, ComponentName componentName, int i) {
        Intent intent = new Intent("com.majeur.launcher.intent.action.UPDATE_BADGE");
        intent.putExtra("com.majeur.launcher.intent.extra.BADGE_PACKAGE", componentName.getPackageName());
        intent.putExtra("com.majeur.launcher.intent.extra.BADGE_COUNT", i);
        intent.putExtra("com.majeur.launcher.intent.extra.BADGE_CLASS", componentName.getClassName());
        context.sendBroadcast(intent);
    }

    /* renamed from: a */
    public List<String> mo5507a() {
        return Arrays.asList(new String[]{"com.majeur.launcher"});
    }
}
