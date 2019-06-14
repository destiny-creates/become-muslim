package com.google.android.gms.internal.p213l;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.l.ah */
public final class ah {
    /* renamed from: a */
    private static Set<String> m21235a(SQLiteDatabase sQLiteDatabase, String str) {
        Object hashSet = new HashSet();
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 22);
        stringBuilder.append("SELECT * FROM ");
        stringBuilder.append(str);
        stringBuilder.append(" LIMIT 0");
        Cursor rawQuery = sQLiteDatabase.rawQuery(stringBuilder.toString(), null);
        try {
            Collections.addAll(hashSet, rawQuery.getColumnNames());
            return hashSet;
        } finally {
            rawQuery.close();
        }
    }

    /* renamed from: a */
    static void m21236a(bb bbVar, SQLiteDatabase sQLiteDatabase) {
        if (bbVar != null) {
            File file = new File(sQLiteDatabase.getPath());
            if (!file.setReadable(false, false)) {
                bbVar.m42565i().m21307a("Failed to turn off database read permission");
            }
            if (!file.setWritable(false, false)) {
                bbVar.m42565i().m21307a("Failed to turn off database write permission");
            }
            if (!file.setReadable(true, true)) {
                bbVar.m42565i().m21307a("Failed to turn on database read permission for owner");
            }
            if (!file.setWritable(true, true)) {
                bbVar.m42565i().m21307a("Failed to turn on database write permission for owner");
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Monitor must not be null");
    }

    /* renamed from: a */
    static void m21237a(bb bbVar, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) {
        if (bbVar != null) {
            if (!ah.m21238a(bbVar, sQLiteDatabase, str)) {
                sQLiteDatabase.execSQL(str2);
            }
            if (bbVar != null) {
                try {
                    Iterable a = ah.m21235a(sQLiteDatabase, str);
                    String[] split = str3.split(",");
                    int length = split.length;
                    int i = 0;
                    while (i < length) {
                        String str4 = split[i];
                        if (a.remove(str4)) {
                            i++;
                        } else {
                            StringBuilder stringBuilder = new StringBuilder((String.valueOf(str).length() + 35) + String.valueOf(str4).length());
                            stringBuilder.append("Table ");
                            stringBuilder.append(str);
                            stringBuilder.append(" is missing required column: ");
                            stringBuilder.append(str4);
                            throw new SQLiteException(stringBuilder.toString());
                        }
                    }
                    if (strArr != null) {
                        for (int i2 = 0; i2 < strArr.length; i2 += 2) {
                            if (!a.remove(strArr[i2])) {
                                sQLiteDatabase.execSQL(strArr[i2 + 1]);
                            }
                        }
                    }
                    if (!a.isEmpty()) {
                        bbVar.m42565i().m21309a("Table has extra columns. table, columns", str, TextUtils.join(", ", a));
                        return;
                    }
                    return;
                } catch (SQLiteException e) {
                    bbVar.I_().m21308a("Failed to verify columns on table that was just created", str);
                    throw e;
                }
            }
            throw new IllegalArgumentException("Monitor must not be null");
        }
        throw new IllegalArgumentException("Monitor must not be null");
    }

    /* renamed from: a */
    private static boolean m21238a(bb bbVar, SQLiteDatabase sQLiteDatabase, String str) {
        Object obj;
        Throwable th;
        if (bbVar != null) {
            Cursor cursor = null;
            try {
                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                Cursor query = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                try {
                    boolean moveToFirst = query.moveToFirst();
                    if (query != null) {
                        query.close();
                    }
                    return moveToFirst;
                } catch (SQLiteException e) {
                    SQLiteException sQLiteException = e;
                    cursor = query;
                    obj = sQLiteException;
                    try {
                        bbVar.m42565i().m21309a("Error querying for table", str, obj);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e2) {
                obj = e2;
                bbVar.m42565i().m21309a("Error querying for table", str, obj);
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            }
        }
        throw new IllegalArgumentException("Monitor must not be null");
    }
}
