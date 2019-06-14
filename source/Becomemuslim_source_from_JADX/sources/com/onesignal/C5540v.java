package com.onesignal;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.af;
import com.facebook.react.uimanager.UIManagerModuleConstants;
import com.onesignal.am.C5464i;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: NotificationOpenedProcessor */
/* renamed from: com.onesignal.v */
class C5540v {
    /* renamed from: a */
    static void m23568a(Context context, Intent intent) {
        if (C5540v.m23571a(intent)) {
            am.m23152a(context);
            C5540v.m23574c(context, intent);
            C5540v.m23573b(context, intent);
        }
    }

    /* renamed from: a */
    private static boolean m23571a(Intent intent) {
        if (!(intent.hasExtra("onesignal_data") || intent.hasExtra("summary"))) {
            if (intent.hasExtra("notificationId") == null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: c */
    private static void m23574c(Context context, Intent intent) {
        if (intent.getBooleanExtra("action_button", false)) {
            af.a(context).a(intent.getIntExtra("notificationId", 0));
            context.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        }
    }

    /* renamed from: b */
    static void m23573b(Context context, Intent intent) {
        JSONArray b;
        SQLiteDatabase a;
        Throwable th;
        String stringExtra = intent.getStringExtra("summary");
        boolean booleanExtra = intent.getBooleanExtra(UIManagerModuleConstants.ACTION_DISMISSED, false);
        SQLiteDatabase sQLiteDatabase = null;
        if (!booleanExtra) {
            try {
                JSONObject jSONObject = new JSONObject(intent.getStringExtra("onesignal_data"));
                jSONObject.put("notificationId", intent.getIntExtra("notificationId", 0));
                intent.putExtra("onesignal_data", jSONObject.toString());
                b = C5529q.m23542b(new JSONObject(intent.getStringExtra("onesignal_data")));
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            a = ao.m23264a(context).m23266a();
            try {
                a.beginTransaction();
                if (!(booleanExtra || stringExtra == null)) {
                    C5540v.m23570a(b, stringExtra, a);
                }
                C5540v.m23569a(context, intent, a);
                if (stringExtra == null) {
                    stringExtra = intent.getStringExtra("grp");
                    if (stringExtra != null) {
                        C5543x.m23583a(context, a, stringExtra, booleanExtra);
                    }
                }
                a.setTransactionSuccessful();
                if (a != null) {
                    try {
                        a.endTransaction();
                    } catch (Throwable th3) {
                        am.m23161a(C5464i.ERROR, "Error closing transaction! ", th3);
                    }
                }
            } catch (Exception e) {
                th3 = e;
                sQLiteDatabase = a;
                try {
                    am.m23161a(C5464i.ERROR, "Error processing notification open or dismiss record! ", th3);
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.endTransaction();
                    }
                    if (booleanExtra) {
                        am.m23154a(context, b, intent.getBooleanExtra("from_alert", false));
                    }
                } catch (Throwable th4) {
                    context = th4;
                    a = sQLiteDatabase;
                    if (a != null) {
                        try {
                            a.endTransaction();
                        } catch (Throwable th5) {
                            am.m23161a(C5464i.ERROR, "Error closing transaction! ", th5);
                        }
                    }
                    throw context;
                }
            } catch (Throwable th6) {
                context = th6;
                if (a != null) {
                    a.endTransaction();
                }
                throw context;
            }
            if (booleanExtra) {
                am.m23154a(context, b, intent.getBooleanExtra("from_alert", false));
            }
        }
        b = null;
        try {
            a = ao.m23264a(context).m23266a();
            a.beginTransaction();
            C5540v.m23570a(b, stringExtra, a);
            C5540v.m23569a(context, intent, a);
            if (stringExtra == null) {
                stringExtra = intent.getStringExtra("grp");
                if (stringExtra != null) {
                    C5543x.m23583a(context, a, stringExtra, booleanExtra);
                }
            }
            a.setTransactionSuccessful();
            if (a != null) {
                a.endTransaction();
            }
        } catch (Exception e2) {
            th3 = e2;
            am.m23161a(C5464i.ERROR, "Error processing notification open or dismiss record! ", th3);
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            if (booleanExtra) {
                am.m23154a(context, b, intent.getBooleanExtra("from_alert", false));
            }
        }
        if (booleanExtra) {
            am.m23154a(context, b, intent.getBooleanExtra("from_alert", false));
        }
    }

    /* renamed from: a */
    private static void m23570a(org.json.JSONArray r9, java.lang.String r10, android.database.sqlite.SQLiteDatabase r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "full_data";
        r3 = new java.lang.String[]{r0};
        r0 = 1;
        r5 = new java.lang.String[r0];
        r1 = 0;
        r5[r1] = r10;
        r2 = "notification";
        r4 = "group_id = ? AND dismissed = 0 AND opened = 0 AND is_summary = 0";
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r1 = r11;
        r11 = r1.query(r2, r3, r4, r5, r6, r7, r8);
        r1 = r11.getCount();
        if (r1 <= r0) goto L_0x0050;
    L_0x001e:
        r11.moveToFirst();
    L_0x0021:
        r0 = "full_data";	 Catch:{ Throwable -> 0x0034 }
        r0 = r11.getColumnIndex(r0);	 Catch:{ Throwable -> 0x0034 }
        r0 = r11.getString(r0);	 Catch:{ Throwable -> 0x0034 }
        r1 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0034 }
        r1.<init>(r0);	 Catch:{ Throwable -> 0x0034 }
        r9.put(r1);	 Catch:{ Throwable -> 0x0034 }
        goto L_0x004a;
    L_0x0034:
        r0 = com.onesignal.am.C5464i.ERROR;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Could not parse JSON of sub notification in group: ";
        r1.append(r2);
        r1.append(r10);
        r1 = r1.toString();
        com.onesignal.am.m23187b(r0, r1);
    L_0x004a:
        r0 = r11.moveToNext();
        if (r0 != 0) goto L_0x0021;
    L_0x0050:
        r11.close();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.v.a(org.json.JSONArray, java.lang.String, android.database.sqlite.SQLiteDatabase):void");
    }

    /* renamed from: a */
    private static void m23569a(Context context, Intent intent, SQLiteDatabase sQLiteDatabase) {
        String str;
        String[] strArr;
        if (intent.getStringExtra("summary") != null) {
            str = "group_id = ?";
            strArr = new String[]{intent.getStringExtra("summary")};
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("android_notification_id = ");
            stringBuilder.append(intent.getIntExtra("notificationId", 0));
            str = stringBuilder.toString();
            strArr = null;
        }
        sQLiteDatabase.update("notification", C5540v.m23572b(intent), str, strArr);
        C5504f.m23442a(sQLiteDatabase, context);
    }

    /* renamed from: b */
    private static ContentValues m23572b(Intent intent) {
        ContentValues contentValues = new ContentValues();
        if (intent.getBooleanExtra(UIManagerModuleConstants.ACTION_DISMISSED, false) != null) {
            contentValues.put(UIManagerModuleConstants.ACTION_DISMISSED, Integer.valueOf(1));
        } else {
            contentValues.put("opened", Integer.valueOf(1));
        }
        return contentValues;
    }
}
