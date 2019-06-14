package com.onesignal.shortcutbadger.impl;

import android.content.AsyncQueryHandler;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import com.onesignal.shortcutbadger.C5534a;
import java.util.Arrays;
import java.util.List;

public class SonyHomeBadger implements C5534a {
    /* renamed from: a */
    private final Uri f24848a = Uri.parse("content://com.sonymobile.home.resourceprovider/badge");
    /* renamed from: b */
    private AsyncQueryHandler f24849b;

    /* renamed from: a */
    public void mo4971a(Context context, ComponentName componentName, int i) {
        if (m32726a(context)) {
            m32728c(context, componentName, i);
        } else {
            m32727b(context, componentName, i);
        }
    }

    /* renamed from: a */
    public List<String> mo4970a() {
        return Arrays.asList(new String[]{"com.sonyericsson.home", "com.sonymobile.home"});
    }

    /* renamed from: b */
    private static void m32727b(Context context, ComponentName componentName, int i) {
        Intent intent = new Intent("com.sonyericsson.home.action.UPDATE_BADGE");
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME", componentName.getPackageName());
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME", componentName.getClassName());
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.MESSAGE", String.valueOf(i));
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", i > 0 ? 1 : 0);
        context.sendBroadcast(intent);
    }

    /* renamed from: c */
    private void m32728c(Context context, ComponentName componentName, int i) {
        if (i >= 0) {
            ContentValues a = m32723a(i, componentName);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                if (this.f24849b == 0) {
                    this.f24849b = new AsyncQueryHandler(this, context.getApplicationContext().getContentResolver()) {
                        /* renamed from: a */
                        final /* synthetic */ SonyHomeBadger f18575a;
                    };
                }
                m32724a(a);
            } else {
                m32725a(context, a);
            }
        }
    }

    /* renamed from: a */
    private void m32724a(ContentValues contentValues) {
        this.f24849b.startInsert(0, null, this.f24848a, contentValues);
    }

    /* renamed from: a */
    private void m32725a(Context context, ContentValues contentValues) {
        context.getApplicationContext().getContentResolver().insert(this.f24848a, contentValues);
    }

    /* renamed from: a */
    private ContentValues m32723a(int i, ComponentName componentName) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("badge_count", Integer.valueOf(i));
        contentValues.put("package_name", componentName.getPackageName());
        contentValues.put("activity_name", componentName.getClassName());
        return contentValues;
    }

    /* renamed from: a */
    private static boolean m32726a(Context context) {
        return context.getPackageManager().resolveContentProvider("com.sonymobile.home.resourceprovider", 0) != null;
    }
}
