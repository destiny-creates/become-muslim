package com.onesignal.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.onesignal.shortcutbadger.C5534a;
import java.util.Arrays;
import java.util.List;

public class EverythingMeHomeBadger implements C5534a {
    /* renamed from: a */
    public void mo4971a(Context context, ComponentName componentName, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("package_name", componentName.getPackageName());
        contentValues.put("activity_name", componentName.getClassName());
        contentValues.put("count", Integer.valueOf(i));
        context.getContentResolver().insert(Uri.parse("content://me.everything.badger/apps"), contentValues);
    }

    /* renamed from: a */
    public List<String> mo4970a() {
        return Arrays.asList(new String[]{"me.everything.launcher"});
    }
}
