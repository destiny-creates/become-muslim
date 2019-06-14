package com.onesignal.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.onesignal.shortcutbadger.C5534a;
import java.util.Arrays;
import java.util.List;

public class NovaHomeBadger implements C5534a {
    /* renamed from: a */
    public void mo4971a(Context context, ComponentName componentName, int i) {
        ContentValues contentValues = new ContentValues();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(componentName.getPackageName());
        stringBuilder.append("/");
        stringBuilder.append(componentName.getClassName());
        contentValues.put("tag", stringBuilder.toString());
        contentValues.put("count", Integer.valueOf(i));
        context.getContentResolver().insert(Uri.parse("content://com.teslacoilsw.notifier/unread_count"), contentValues);
    }

    /* renamed from: a */
    public List<String> mo4970a() {
        return Arrays.asList(new String[]{"com.teslacoilsw.launcher"});
    }
}
