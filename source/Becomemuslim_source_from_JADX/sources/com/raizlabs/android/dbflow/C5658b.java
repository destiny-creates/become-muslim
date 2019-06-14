package com.raizlabs.android.dbflow;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build.VERSION;

/* compiled from: SQLiteCompatibilityUtils */
/* renamed from: com.raizlabs.android.dbflow.b */
public class C5658b {
    /* renamed from: a */
    public static long m24010a(SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues, String str2, String[] strArr, int i) {
        if (VERSION.SDK_INT >= 8) {
            return (long) sQLiteDatabase.updateWithOnConflict(str, contentValues, str2, strArr, i);
        }
        return (long) sQLiteDatabase.update(str, contentValues, str2, strArr);
    }
}
