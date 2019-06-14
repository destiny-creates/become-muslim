package com.onesignal.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import com.onesignal.shortcutbadger.C5534a;
import com.onesignal.shortcutbadger.p253a.C5533b;
import expo.modules.contacts.EXColumns;
import java.util.Arrays;
import java.util.List;

public class SamsungHomeBadger implements C5534a {
    /* renamed from: a */
    private static final String[] f24846a = new String[]{EXColumns.ID, "class"};
    /* renamed from: b */
    private DefaultBadger f24847b;

    public SamsungHomeBadger() {
        if (VERSION.SDK_INT >= 21) {
            this.f24847b = new DefaultBadger();
        }
    }

    /* renamed from: a */
    public void mo4971a(Context context, ComponentName componentName, int i) {
        if (this.f24847b == null || !this.f24847b.m32701a(context)) {
            Uri parse = Uri.parse("content://com.sec.badge/apps?notify=true");
            context = context.getContentResolver();
            Cursor query;
            try {
                Context context2 = context;
                Uri uri = parse;
                query = context2.query(uri, f24846a, "package=?", new String[]{componentName.getPackageName()}, null);
                if (query != null) {
                    try {
                        String className = componentName.getClassName();
                        Object obj = null;
                        while (query.moveToNext()) {
                            int i2 = query.getInt(0);
                            context.update(parse, m32720a(componentName, i, false), "_id=?", new String[]{String.valueOf(i2)});
                            if (className.equals(query.getString(query.getColumnIndex("class")))) {
                                obj = 1;
                            }
                        }
                        if (obj == null) {
                            context.insert(parse, m32720a(componentName, i, true));
                        }
                    } catch (Throwable th) {
                        context = th;
                        C5533b.m23556a(query);
                        throw context;
                    }
                }
                C5533b.m23556a(query);
                return;
            } catch (Throwable th2) {
                context = th2;
                query = null;
                C5533b.m23556a(query);
                throw context;
            }
        }
        this.f24847b.mo4971a(context, componentName, i);
    }

    /* renamed from: a */
    private ContentValues m32720a(ComponentName componentName, int i, boolean z) {
        ContentValues contentValues = new ContentValues();
        if (z) {
            contentValues.put("package", componentName.getPackageName());
            contentValues.put("class", componentName.getClassName());
        }
        contentValues.put("badgecount", Integer.valueOf(i));
        return contentValues;
    }

    /* renamed from: a */
    public List<String> mo4970a() {
        return Arrays.asList(new String[]{"com.sec.android.app.launcher", "com.sec.android.app.twlauncher"});
    }
}
