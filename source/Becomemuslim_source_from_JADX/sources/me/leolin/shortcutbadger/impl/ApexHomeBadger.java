package me.leolin.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.Arrays;
import java.util.List;
import me.leolin.shortcutbadger.C6563a;

public class ApexHomeBadger implements C6563a {
    /* renamed from: a */
    public void mo5508a(Context context, ComponentName componentName, int i) {
        Intent intent = new Intent("com.anddoes.launcher.COUNTER_CHANGED");
        intent.putExtra("package", componentName.getPackageName());
        intent.putExtra("count", i);
        intent.putExtra("class", componentName.getClassName());
        context.sendBroadcast(intent);
    }

    /* renamed from: a */
    public List<String> mo5507a() {
        return Arrays.asList(new String[]{"com.anddoes.launcher"});
    }
}
