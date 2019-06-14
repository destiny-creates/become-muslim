package com.onesignal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build.VERSION;
import com.facebook.react.uimanager.UIManagerModuleConstants;
import com.facebook.stetho.server.http.HttpStatus;
import com.onesignal.am.C5464i;

/* compiled from: NotificationRestorer */
/* renamed from: com.onesignal.w */
class C5542w {
    /* renamed from: a */
    static final String[] f18589a = new String[]{"android_notification_id", "full_data", "created_time"};
    /* renamed from: b */
    public static boolean f18590b;

    /* renamed from: a */
    static void m23576a(final Context context) {
        new Thread(new Runnable() {
            public void run() {
                Thread.currentThread().setPriority(10);
                C5542w.m23579b(context);
            }
        }, "OS_RESTORE_NOTIFS").start();
    }

    /* renamed from: b */
    public static void m23579b(Context context) {
        SQLiteDatabase a;
        Throwable th;
        long currentTimeMillis;
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2;
        C5464i c5464i;
        StringBuilder stringBuilder3;
        Cursor query;
        Throwable th2;
        if (!f18590b) {
            f18590b = true;
            am.m23187b(C5464i.INFO, "Restoring notifications");
            ao a2 = ao.m23264a(context);
            Cursor cursor = null;
            try {
                a = a2.m23266a();
                try {
                    a.beginTransaction();
                    C5529q.m23535a(a);
                    a.setTransactionSuccessful();
                    if (a != null) {
                        try {
                            a.endTransaction();
                        } catch (Throwable th3) {
                            am.m23161a(C5464i.ERROR, "Error closing transaction! ", th3);
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    try {
                        am.m23161a(C5464i.ERROR, "Error deleting old notification records! ", th);
                        if (a != null) {
                            a.endTransaction();
                        }
                        currentTimeMillis = (System.currentTimeMillis() / 1000) - 604800;
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("created_time > ");
                        stringBuilder.append(currentTimeMillis);
                        stringBuilder.append(" AND ");
                        stringBuilder.append(UIManagerModuleConstants.ACTION_DISMISSED);
                        stringBuilder.append(" = 0 AND ");
                        stringBuilder.append("opened");
                        stringBuilder.append(" = 0 AND ");
                        stringBuilder.append("is_summary");
                        stringBuilder.append(" = 0");
                        stringBuilder2 = new StringBuilder(stringBuilder.toString());
                        C5542w.m23578a(context, stringBuilder2);
                        c5464i = C5464i.INFO;
                        stringBuilder3 = new StringBuilder();
                        stringBuilder3.append("Querying DB for notifs to restore: ");
                        stringBuilder3.append(stringBuilder2.toString());
                        am.m23187b(c5464i, stringBuilder3.toString());
                        query = a2.m23267b().query("notification", f18589a, stringBuilder2.toString(), null, null, null, "_id DESC", "49");
                        C5542w.m23577a(context, query, HttpStatus.HTTP_OK);
                        query.close();
                    } catch (Throwable th5) {
                        context = th5;
                        if (a != null) {
                            try {
                                a.endTransaction();
                            } catch (Throwable th6) {
                                am.m23161a(C5464i.ERROR, "Error closing transaction! ", th6);
                            }
                        }
                        throw context;
                    }
                }
            } catch (Throwable th7) {
                context = th7;
                a = null;
                if (a != null) {
                    a.endTransaction();
                }
                throw context;
            }
            currentTimeMillis = (System.currentTimeMillis() / 1000) - 604800;
            stringBuilder = new StringBuilder();
            stringBuilder.append("created_time > ");
            stringBuilder.append(currentTimeMillis);
            stringBuilder.append(" AND ");
            stringBuilder.append(UIManagerModuleConstants.ACTION_DISMISSED);
            stringBuilder.append(" = 0 AND ");
            stringBuilder.append("opened");
            stringBuilder.append(" = 0 AND ");
            stringBuilder.append("is_summary");
            stringBuilder.append(" = 0");
            stringBuilder2 = new StringBuilder(stringBuilder.toString());
            C5542w.m23578a(context, stringBuilder2);
            c5464i = C5464i.INFO;
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Querying DB for notifs to restore: ");
            stringBuilder3.append(stringBuilder2.toString());
            am.m23187b(c5464i, stringBuilder3.toString());
            try {
                query = a2.m23267b().query("notification", f18589a, stringBuilder2.toString(), null, null, null, "_id DESC", "49");
                try {
                    C5542w.m23577a(context, query, HttpStatus.HTTP_OK);
                    if (query != null && query.isClosed() == null) {
                        query.close();
                    }
                } catch (Throwable th8) {
                    context = th8;
                    cursor = query;
                    if (!(cursor == null || cursor.isClosed())) {
                        cursor.close();
                    }
                    throw context;
                }
            } catch (Throwable th9) {
                th2 = th9;
                am.m23161a(C5464i.ERROR, "Error restoring notification records! ", th2);
                cursor.close();
            }
        }
    }

    /* renamed from: a */
    private static void m23578a(android.content.Context r4, java.lang.StringBuilder r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 23;
        if (r0 >= r1) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = "notification";
        r4 = r4.getSystemService(r0);
        r4 = (android.app.NotificationManager) r4;
        if (r4 != 0) goto L_0x0012;
    L_0x0011:
        return;
    L_0x0012:
        r4 = r4.getActiveNotifications();	 Catch:{ Throwable -> 0x0046 }
        r0 = r4.length;	 Catch:{ Throwable -> 0x0046 }
        if (r0 != 0) goto L_0x001a;	 Catch:{ Throwable -> 0x0046 }
    L_0x0019:
        return;	 Catch:{ Throwable -> 0x0046 }
    L_0x001a:
        r0 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x0046 }
        r0.<init>();	 Catch:{ Throwable -> 0x0046 }
        r1 = r4.length;	 Catch:{ Throwable -> 0x0046 }
        r2 = 0;	 Catch:{ Throwable -> 0x0046 }
    L_0x0021:
        if (r2 >= r1) goto L_0x0033;	 Catch:{ Throwable -> 0x0046 }
    L_0x0023:
        r3 = r4[r2];	 Catch:{ Throwable -> 0x0046 }
        r3 = r3.getId();	 Catch:{ Throwable -> 0x0046 }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Throwable -> 0x0046 }
        r0.add(r3);	 Catch:{ Throwable -> 0x0046 }
        r2 = r2 + 1;	 Catch:{ Throwable -> 0x0046 }
        goto L_0x0021;	 Catch:{ Throwable -> 0x0046 }
    L_0x0033:
        r4 = " AND android_notification_id NOT IN (";	 Catch:{ Throwable -> 0x0046 }
        r5.append(r4);	 Catch:{ Throwable -> 0x0046 }
        r4 = ",";	 Catch:{ Throwable -> 0x0046 }
        r4 = android.text.TextUtils.join(r4, r0);	 Catch:{ Throwable -> 0x0046 }
        r5.append(r4);	 Catch:{ Throwable -> 0x0046 }
        r4 = ")";	 Catch:{ Throwable -> 0x0046 }
        r5.append(r4);	 Catch:{ Throwable -> 0x0046 }
    L_0x0046:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.w.a(android.content.Context, java.lang.StringBuilder):void");
    }

    /* renamed from: a */
    static void m23577a(Context context, Cursor cursor, int i) {
        if (cursor.moveToFirst()) {
            Object obj = C6965s.m32688a(context) != null ? 1 : null;
            do {
                if (obj != null) {
                    Intent a = C6965s.m32688a(context);
                    C5542w.m23575a(a, cursor);
                    JobIntentService.m23026a(context, a.getComponent(), 2071862121, a, false);
                } else {
                    JobIntentService.m23026a(context, new ComponentName(context, RestoreJobService.class), 2071862122, C5542w.m23575a(new Intent(), cursor), false);
                }
                if (i > 0) {
                    al.m23089a(i);
                }
            } while (cursor.moveToNext());
        }
    }

    /* renamed from: a */
    private static Intent m23575a(Intent intent, Cursor cursor) {
        int i = cursor.getInt(cursor.getColumnIndex("android_notification_id"));
        String string = cursor.getString(cursor.getColumnIndex("full_data"));
        intent.putExtra("json_payload", string).putExtra("android_notif_id", i).putExtra("restoring", true).putExtra("timestamp", Long.valueOf(cursor.getLong(cursor.getColumnIndex("created_time"))));
        return intent;
    }

    /* renamed from: c */
    static void m23580c(Context context) {
        if (VERSION.SDK_INT >= 26) {
            am.m23187b(C5464i.INFO, "scheduleRestoreKickoffJob");
            ((JobScheduler) context.getSystemService("jobscheduler")).schedule(new Builder(2071862120, new ComponentName(context, RestoreKickoffJobService.class)).setOverrideDeadline(15000).setMinimumLatency(15000).build());
            return;
        }
        am.m23187b(C5464i.INFO, "scheduleRestoreKickoffAlarmTask");
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context.getPackageName(), NotificationRestoreService.class.getName()));
        long currentTimeMillis = System.currentTimeMillis() + 15000;
        ((AlarmManager) context.getSystemService("alarm")).set(1, currentTimeMillis, PendingIntent.getService(context, 2071862120, intent, 268435456));
    }
}
