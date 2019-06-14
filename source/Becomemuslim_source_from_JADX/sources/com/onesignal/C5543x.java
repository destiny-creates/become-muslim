package com.onesignal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.onesignal.am.C5464i;

/* compiled from: NotificationSummaryManager */
/* renamed from: com.onesignal.x */
class C5543x {
    /* renamed from: a */
    static void m23582a(Context context, SQLiteDatabase sQLiteDatabase, int i) {
        String[] strArr = new String[]{"group_id"};
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("android_notification_id = ");
        stringBuilder.append(i);
        String stringBuilder2 = stringBuilder.toString();
        i = sQLiteDatabase.query("notification", strArr, stringBuilder2, null, null, null, null);
        if (i.moveToFirst()) {
            String string = i.getString(i.getColumnIndex("group_id"));
            i.close();
            if (string != null) {
                C5543x.m23583a(context, sQLiteDatabase, string, 1);
                return;
            }
            return;
        }
        i.close();
    }

    /* renamed from: a */
    static void m23583a(Context context, SQLiteDatabase sQLiteDatabase, String str, boolean z) {
        try {
            context = C5543x.m23585b(context, sQLiteDatabase, str, z);
            if (context != null && context.isClosed() == null) {
                context.close();
            }
        } catch (Throwable th) {
            am.m23161a(C5464i.ERROR, "Error running updateSummaryNotificationAfterChildRemoved!", th);
        }
    }

    /* renamed from: b */
    private static android.database.Cursor m23585b(android.content.Context r9, android.database.sqlite.SQLiteDatabase r10, java.lang.String r11, boolean r12) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = "notification";
        r0 = "android_notification_id";
        r2 = "created_time";
        r2 = new java.lang.String[]{r0, r2};
        r3 = "group_id = ? AND dismissed = 0 AND opened = 0 AND is_summary = 0";
        r8 = 1;
        r4 = new java.lang.String[r8];
        r0 = 0;
        r4[r0] = r11;
        r7 = "_id DESC";
        r5 = 0;
        r6 = 0;
        r0 = r10;
        r0 = r0.query(r1, r2, r3, r4, r5, r6, r7);
        r1 = r0.getCount();
        if (r1 != 0) goto L_0x0065;
    L_0x0021:
        r0.close();
        r11 = com.onesignal.C5543x.m23581a(r10, r11);
        if (r11 != 0) goto L_0x002b;
    L_0x002a:
        return r0;
    L_0x002b:
        r1 = "notification";
        r9 = r9.getSystemService(r1);
        r9 = (android.app.NotificationManager) r9;
        r1 = r11.intValue();
        r9.cancel(r1);
        r9 = new android.content.ContentValues;
        r9.<init>();
        if (r12 == 0) goto L_0x0044;
    L_0x0041:
        r12 = "dismissed";
        goto L_0x0046;
    L_0x0044:
        r12 = "opened";
    L_0x0046:
        r1 = java.lang.Integer.valueOf(r8);
        r9.put(r12, r1);
        r12 = "notification";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "android_notification_id = ";
        r1.append(r2);
        r1.append(r11);
        r11 = r1.toString();
        r1 = 0;
        r10.update(r12, r9, r11, r1);
        return r0;
    L_0x0065:
        if (r1 != r8) goto L_0x0075;
    L_0x0067:
        r0.close();
        r10 = com.onesignal.C5543x.m23581a(r10, r11);
        if (r10 != 0) goto L_0x0071;
    L_0x0070:
        return r0;
    L_0x0071:
        com.onesignal.C5543x.m23584a(r9, r11);
        return r0;
    L_0x0075:
        r0.moveToFirst();	 Catch:{ JSONException -> 0x00a8 }
        r12 = "created_time";	 Catch:{ JSONException -> 0x00a8 }
        r12 = r0.getColumnIndex(r12);	 Catch:{ JSONException -> 0x00a8 }
        r1 = r0.getLong(r12);	 Catch:{ JSONException -> 0x00a8 }
        r12 = java.lang.Long.valueOf(r1);	 Catch:{ JSONException -> 0x00a8 }
        r0.close();	 Catch:{ JSONException -> 0x00a8 }
        r10 = com.onesignal.C5543x.m23581a(r10, r11);	 Catch:{ JSONException -> 0x00a8 }
        if (r10 != 0) goto L_0x0090;	 Catch:{ JSONException -> 0x00a8 }
    L_0x008f:
        return r0;	 Catch:{ JSONException -> 0x00a8 }
    L_0x0090:
        r10 = new com.onesignal.t;	 Catch:{ JSONException -> 0x00a8 }
        r10.<init>(r9);	 Catch:{ JSONException -> 0x00a8 }
        r10.f18578c = r8;	 Catch:{ JSONException -> 0x00a8 }
        r10.f18580e = r12;	 Catch:{ JSONException -> 0x00a8 }
        r9 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x00a8 }
        r9.<init>();	 Catch:{ JSONException -> 0x00a8 }
        r12 = "grp";	 Catch:{ JSONException -> 0x00a8 }
        r9.put(r12, r11);	 Catch:{ JSONException -> 0x00a8 }
        r10.f18577b = r9;	 Catch:{ JSONException -> 0x00a8 }
        com.onesignal.C5512l.m23480b(r10);	 Catch:{ JSONException -> 0x00a8 }
    L_0x00a8:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.x.b(android.content.Context, android.database.sqlite.SQLiteDatabase, java.lang.String, boolean):android.database.Cursor");
    }

    /* renamed from: a */
    private static void m23584a(Context context, String str) {
        Throwable th;
        String[] strArr = new String[]{str};
        str = null;
        try {
            Cursor query = ao.m23264a(context).m23267b().query("notification", C5542w.f18589a, "group_id = ? AND dismissed = 0 AND opened = 0 AND is_summary = 0", strArr, null, null, null);
            try {
                C5542w.m23577a(context, query, 0);
                if (query != null && query.isClosed() == null) {
                    query.close();
                }
            } catch (Throwable th2) {
                context = th2;
                str = query;
                str.close();
                throw context;
            }
        } catch (Throwable th3) {
            th = th3;
            am.m23161a(C5464i.ERROR, "Error restoring notification records! ", th);
            if (str != null) {
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static java.lang.Integer m23581a(android.database.sqlite.SQLiteDatabase r10, java.lang.String r11) {
        /*
        r0 = 0;
        r2 = "notification";
        r1 = "android_notification_id";
        r3 = new java.lang.String[]{r1};	 Catch:{ Throwable -> 0x005c }
        r4 = "group_id = ? AND dismissed = 0 AND opened = 0 AND is_summary = 1";
        r1 = 1;
        r5 = new java.lang.String[r1];	 Catch:{ Throwable -> 0x005c }
        r1 = 0;
        r5[r1] = r11;	 Catch:{ Throwable -> 0x005c }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r1 = r10;
        r10 = r1.query(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ Throwable -> 0x005c }
        r1 = r10.moveToFirst();	 Catch:{ Throwable -> 0x0055, all -> 0x0052 }
        if (r1 != 0) goto L_0x002e;
    L_0x001f:
        r10.close();	 Catch:{ Throwable -> 0x0055, all -> 0x0052 }
        if (r10 == 0) goto L_0x002d;
    L_0x0024:
        r11 = r10.isClosed();
        if (r11 != 0) goto L_0x002d;
    L_0x002a:
        r10.close();
    L_0x002d:
        return r0;
    L_0x002e:
        r1 = "android_notification_id";
        r1 = r10.getColumnIndex(r1);	 Catch:{ Throwable -> 0x0055, all -> 0x0052 }
        r1 = r10.getInt(r1);	 Catch:{ Throwable -> 0x0055, all -> 0x0052 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Throwable -> 0x0055, all -> 0x0052 }
        r10.close();	 Catch:{ Throwable -> 0x004c, all -> 0x0052 }
        if (r10 == 0) goto L_0x004a;
    L_0x0041:
        r11 = r10.isClosed();
        if (r11 != 0) goto L_0x004a;
    L_0x0047:
        r10.close();
    L_0x004a:
        r10 = r1;
        goto L_0x007f;
    L_0x004c:
        r0 = move-exception;
        r9 = r0;
        r0 = r10;
        r10 = r1;
        r1 = r9;
        goto L_0x005e;
    L_0x0052:
        r11 = move-exception;
        r0 = r10;
        goto L_0x0080;
    L_0x0055:
        r1 = move-exception;
        r9 = r0;
        r0 = r10;
        r10 = r9;
        goto L_0x005e;
    L_0x005a:
        r11 = move-exception;
        goto L_0x0080;
    L_0x005c:
        r1 = move-exception;
        r10 = r0;
    L_0x005e:
        r2 = com.onesignal.am.C5464i.ERROR;	 Catch:{ all -> 0x005a }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x005a }
        r3.<init>();	 Catch:{ all -> 0x005a }
        r4 = "Error getting android notification id for summary notification group: ";
        r3.append(r4);	 Catch:{ all -> 0x005a }
        r3.append(r11);	 Catch:{ all -> 0x005a }
        r11 = r3.toString();	 Catch:{ all -> 0x005a }
        com.onesignal.am.m23161a(r2, r11, r1);	 Catch:{ all -> 0x005a }
        if (r0 == 0) goto L_0x007f;
    L_0x0076:
        r11 = r0.isClosed();
        if (r11 != 0) goto L_0x007f;
    L_0x007c:
        r0.close();
    L_0x007f:
        return r10;
    L_0x0080:
        if (r0 == 0) goto L_0x008b;
    L_0x0082:
        r10 = r0.isClosed();
        if (r10 != 0) goto L_0x008b;
    L_0x0088:
        r0.close();
    L_0x008b:
        throw r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.x.a(android.database.sqlite.SQLiteDatabase, java.lang.String):java.lang.Integer");
    }
}
