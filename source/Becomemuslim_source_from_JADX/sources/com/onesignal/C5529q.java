package com.onesignal;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.facebook.ads.internal.p088c.C1354a;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.react.uimanager.UIManagerModuleConstants;
import com.facebook.share.internal.ShareConstants;
import com.onesignal.C6965s.C5531a;
import com.onesignal.ae.C5443a;
import com.onesignal.ae.C5444b;
import com.onesignal.am.C5464i;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: NotificationBundleProcessor */
/* renamed from: com.onesignal.q */
class C5529q {

    /* compiled from: NotificationBundleProcessor */
    /* renamed from: com.onesignal.q$a */
    static class C5528a {
        /* renamed from: a */
        boolean f18566a;
        /* renamed from: b */
        boolean f18567b;
        /* renamed from: c */
        boolean f18568c;

        C5528a() {
        }

        /* renamed from: a */
        boolean m23528a() {
            if (this.f18566a && !this.f18567b) {
                if (!this.f18568c) {
                    return false;
                }
            }
            return true;
        }
    }

    /* renamed from: a */
    static void m23534a(Context context, C5505g c5505g, C5531a c5531a) {
        am.m23152a(context);
        try {
            String a = c5505g.mo4962a("json_payload");
            if (a == null) {
                C5464i c5464i = C5464i.ERROR;
                c5531a = new StringBuilder();
                c5531a.append("json_payload key is nonexistent from mBundle passed to ProcessFromGCMIntentService: ");
                c5531a.append(c5505g);
                am.m23187b(c5464i, c5531a.toString());
                return;
            }
            C5538t c5538t = new C5538t(context);
            c5538t.f18578c = c5505g.mo4965a("restoring", false);
            c5538t.f18580e = c5505g.mo4967c("timestamp");
            c5538t.f18577b = new JSONObject(a);
            if (c5538t.f18578c || am.m23177a(context, c5538t.f18577b) == null) {
                if (c5505g.mo4968d("android_notif_id") != null) {
                    if (c5531a == null) {
                        c5531a = new C5531a();
                    }
                    c5531a.f18570b = c5505g.mo4966b("android_notif_id");
                }
                c5538t.f18587l = c5531a;
                C5529q.m23529a(c5538t);
                if (c5538t.f18578c != null) {
                    al.m23089a(100);
                }
            }
        } catch (Context context2) {
            context2.printStackTrace();
        }
    }

    /* renamed from: a */
    static int m23529a(com.onesignal.C5538t r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.onesignal.am.m23252p();
        r1 = 1;
        r2 = 0;
        if (r0 == 0) goto L_0x0010;
    L_0x0008:
        r0 = com.onesignal.am.m23257u();
        if (r0 == 0) goto L_0x0010;
    L_0x000e:
        r0 = 1;
        goto L_0x0011;
    L_0x0010:
        r0 = 0;
    L_0x0011:
        r4.f18579d = r0;
        com.onesignal.C5529q.m23546c(r4);
        r0 = r4.m23567e();
        if (r0 != 0) goto L_0x002d;
    L_0x001c:
        r0 = r4.f18577b;
        r3 = "alert";
        r0 = r0.optString(r3);
        r0 = com.onesignal.C5529q.m23541a(r0);
        if (r0 == 0) goto L_0x002b;
    L_0x002a:
        goto L_0x002d;
    L_0x002b:
        r0 = 0;
        goto L_0x002e;
    L_0x002d:
        r0 = 1;
    L_0x002e:
        if (r0 == 0) goto L_0x0033;
    L_0x0030:
        com.onesignal.C5512l.m23468a(r4);
    L_0x0033:
        r0 = r4.f18578c;
        if (r0 != 0) goto L_0x0057;
    L_0x0037:
        com.onesignal.C5529q.m23538a(r4, r2);
        r0 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0057 }
        r2 = r4.f18577b;	 Catch:{ Throwable -> 0x0057 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x0057 }
        r0.<init>(r2);	 Catch:{ Throwable -> 0x0057 }
        r2 = "notificationId";	 Catch:{ Throwable -> 0x0057 }
        r3 = r4.m23565c();	 Catch:{ Throwable -> 0x0057 }
        r0.put(r2, r3);	 Catch:{ Throwable -> 0x0057 }
        r0 = com.onesignal.C5529q.m23542b(r0);	 Catch:{ Throwable -> 0x0057 }
        r2 = r4.f18579d;	 Catch:{ Throwable -> 0x0057 }
        com.onesignal.am.m23171a(r0, r1, r2);	 Catch:{ Throwable -> 0x0057 }
    L_0x0057:
        r4 = r4.m23565c();
        r4 = r4.intValue();
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.q.a(com.onesignal.t):int");
    }

    /* renamed from: d */
    private static JSONArray m23547d(Bundle bundle) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(C5529q.m23532a(bundle));
        return jSONArray;
    }

    /* renamed from: a */
    private static void m23533a(Context context, Bundle bundle, boolean z, int i) {
        C5538t c5538t = new C5538t(context);
        c5538t.f18577b = C5529q.m23532a(bundle);
        c5538t.f18587l = new C5531a();
        c5538t.f18587l.f18570b = Integer.valueOf(i);
        C5529q.m23538a(c5538t, z);
    }

    /* renamed from: a */
    static void m23538a(C5538t c5538t, boolean z) {
        Throwable th;
        C5464i c5464i;
        String str;
        Context context = c5538t.f18576a;
        JSONObject jSONObject = c5538t.f18577b;
        try {
            JSONObject jSONObject2 = new JSONObject(c5538t.f18577b.optString("custom"));
            SQLiteDatabase sQLiteDatabase = null;
            try {
                SQLiteDatabase a = ao.m23264a(c5538t.f18576a).m23266a();
                try {
                    a.beginTransaction();
                    C5529q.m23535a(a);
                    if (c5538t.m23566d() != -1) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("android_notification_id = ");
                        stringBuilder.append(c5538t.m23566d());
                        String stringBuilder2 = stringBuilder.toString();
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(UIManagerModuleConstants.ACTION_DISMISSED, Integer.valueOf(1));
                        a.update("notification", contentValues, stringBuilder2, null);
                        C5504f.m23442a(a, context);
                    }
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("notification_id", jSONObject2.optString("i"));
                    if (jSONObject.has("grp")) {
                        contentValues2.put("group_id", jSONObject.optString("grp"));
                    }
                    if (jSONObject.has("collapse_key") && !"do_not_collapse".equals(jSONObject.optString("collapse_key"))) {
                        contentValues2.put("collapse_id", jSONObject.optString("collapse_key"));
                    }
                    contentValues2.put("opened", Integer.valueOf(z));
                    if (!z) {
                        contentValues2.put("android_notification_id", Integer.valueOf(c5538t.m23566d()));
                    }
                    if (c5538t.m23562a() != null) {
                        contentValues2.put("title", c5538t.m23562a().toString());
                    }
                    if (c5538t.m23564b() != null) {
                        contentValues2.put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, c5538t.m23564b().toString());
                    }
                    contentValues2.put("full_data", jSONObject.toString());
                    a.insertOrThrow("notification", null, contentValues2);
                    if (!z) {
                        C5504f.m23442a(a, context);
                    }
                    a.setTransactionSuccessful();
                    if (a != null) {
                        try {
                            a.endTransaction();
                        } catch (Throwable th2) {
                            th = th2;
                            c5464i = C5464i.ERROR;
                            str = "Error closing transaction! ";
                            am.m23161a(c5464i, str, th);
                        }
                    }
                } catch (Exception e) {
                    th = e;
                    sQLiteDatabase = a;
                    try {
                        am.m23161a(C5464i.ERROR, "Error saving notification record! ", th);
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.endTransaction();
                            } catch (Throwable th3) {
                                th = th3;
                                c5464i = C5464i.ERROR;
                                str = "Error closing transaction! ";
                                am.m23161a(c5464i, str, th);
                            }
                        }
                    } catch (Throwable th4) {
                        c5538t = th4;
                        a = sQLiteDatabase;
                        if (a != null) {
                            try {
                                a.endTransaction();
                            } catch (Throwable th5) {
                                am.m23161a(C5464i.ERROR, "Error closing transaction! ", th5);
                            }
                        }
                        throw c5538t;
                    }
                } catch (Throwable th6) {
                    c5538t = th6;
                    if (a != null) {
                        a.endTransaction();
                    }
                    throw c5538t;
                }
            } catch (Exception e2) {
                th = e2;
                am.m23161a(C5464i.ERROR, "Error saving notification record! ", th);
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
            }
        } catch (C5538t c5538t2) {
            c5538t2.printStackTrace();
        }
    }

    /* renamed from: b */
    static void m23543b(C5538t c5538t) {
        Throwable th;
        if (c5538t.m23566d() != -1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("android_notification_id = ");
            stringBuilder.append(c5538t.m23566d());
            String stringBuilder2 = stringBuilder.toString();
            SQLiteDatabase sQLiteDatabase = null;
            try {
                SQLiteDatabase a = ao.m23264a(c5538t.f18576a).m23266a();
                try {
                    a.beginTransaction();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(UIManagerModuleConstants.ACTION_DISMISSED, Integer.valueOf(1));
                    a.update("notification", contentValues, stringBuilder2, null);
                    C5504f.m23442a(a, c5538t.f18576a);
                    a.setTransactionSuccessful();
                    if (a != null) {
                        try {
                            a.endTransaction();
                        } catch (Throwable th2) {
                            am.m23161a(C5464i.ERROR, "Error closing transaction! ", th2);
                        }
                    }
                } catch (Exception e) {
                    th2 = e;
                    sQLiteDatabase = a;
                    try {
                        am.m23161a(C5464i.ERROR, "Error saving notification record! ", th2);
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.endTransaction();
                        }
                    } catch (Throwable th3) {
                        c5538t = th3;
                        a = sQLiteDatabase;
                        if (a != null) {
                            try {
                                a.endTransaction();
                            } catch (Throwable th4) {
                                am.m23161a(C5464i.ERROR, "Error closing transaction! ", th4);
                            }
                        }
                        throw c5538t;
                    }
                } catch (Throwable th5) {
                    c5538t = th5;
                    if (a != null) {
                        a.endTransaction();
                    }
                    throw c5538t;
                }
            } catch (Exception e2) {
                th2 = e2;
                am.m23161a(C5464i.ERROR, "Error saving notification record! ", th2);
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
            }
        }
    }

    /* renamed from: a */
    static void m23535a(SQLiteDatabase sQLiteDatabase) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("created_time < ");
        stringBuilder.append((System.currentTimeMillis() / 1000) - 604800);
        sQLiteDatabase.delete("notification", stringBuilder.toString(), null);
    }

    /* renamed from: a */
    static JSONObject m23532a(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            try {
                jSONObject.put(str, bundle.get(str));
            } catch (Throwable e) {
                C5464i c5464i = C5464i.ERROR;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("bundleAsJSONObject error for key: ");
                stringBuilder.append(str);
                am.m23161a(c5464i, stringBuilder.toString(), e);
            }
        }
        return jSONObject;
    }

    /* renamed from: e */
    private static void m23548e(Bundle bundle) {
        if (bundle.containsKey("o")) {
            try {
                JSONObject jSONObject;
                JSONObject jSONObject2 = new JSONObject(bundle.getString("custom"));
                if (jSONObject2.has(C1354a.f3934a)) {
                    jSONObject = jSONObject2.getJSONObject(C1354a.f3934a);
                } else {
                    jSONObject = new JSONObject();
                }
                JSONArray jSONArray = new JSONArray(bundle.getString("o"));
                bundle.remove("o");
                for (int i = 0; i < jSONArray.length(); i++) {
                    Object string;
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                    String string2 = jSONObject3.getString("n");
                    jSONObject3.remove("n");
                    if (jSONObject3.has("i")) {
                        string = jSONObject3.getString("i");
                        jSONObject3.remove("i");
                    } else {
                        string = string2;
                    }
                    jSONObject3.put("id", string);
                    jSONObject3.put("text", string2);
                    if (jSONObject3.has("p")) {
                        jSONObject3.put("icon", jSONObject3.getString("p"));
                        jSONObject3.remove("p");
                    }
                }
                jSONObject.put("actionButtons", jSONArray);
                jSONObject.put("actionSelected", "__DEFAULT__");
                if (!jSONObject2.has(C1354a.f3934a)) {
                    jSONObject2.put(C1354a.f3934a, jSONObject);
                }
                bundle.putString("custom", jSONObject2.toString());
            } catch (Bundle bundle2) {
                bundle2.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    static ae m23530a(JSONObject jSONObject) {
        ae aeVar = new ae();
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("custom"));
            aeVar.f18284a = jSONObject2.optString("i");
            aeVar.f18286c = jSONObject2.optString("ti");
            aeVar.f18285b = jSONObject2.optString("tn");
            aeVar.f18305v = jSONObject.toString();
            aeVar.f18289f = jSONObject2.optJSONObject(C1354a.f3934a);
            aeVar.f18294k = jSONObject2.optString("u", null);
            aeVar.f18288e = jSONObject.optString("alert", null);
            aeVar.f18287d = jSONObject.optString("title", null);
            aeVar.f18290g = jSONObject.optString("sicon", null);
            aeVar.f18292i = jSONObject.optString("bicon", null);
            aeVar.f18291h = jSONObject.optString("licon", null);
            aeVar.f18295l = jSONObject.optString("sound", null);
            aeVar.f18298o = jSONObject.optString("grp", null);
            aeVar.f18299p = jSONObject.optString("grp_msg", null);
            aeVar.f18293j = jSONObject.optString("bgac", null);
            aeVar.f18296m = jSONObject.optString("ledc", null);
            String optString = jSONObject.optString("vis", null);
            if (optString != null) {
                aeVar.f18297n = Integer.parseInt(optString);
            }
            aeVar.f18301r = jSONObject.optString("from", null);
            aeVar.f18304u = jSONObject.optInt("pri", 0);
            optString = jSONObject.optString("collapse_key", null);
            if (!"do_not_collapse".equals(optString)) {
                aeVar.f18303t = optString;
            }
            C5529q.m23536a(aeVar);
        } catch (Throwable th) {
            am.m23161a(C5464i.ERROR, "Error assigning OSNotificationPayload values!", th);
        }
        try {
            C5529q.m23537a(aeVar, jSONObject);
        } catch (Throwable th2) {
            am.m23161a(C5464i.ERROR, "Error assigning OSNotificationPayload.backgroundImageLayout values!", th2);
        }
        return aeVar;
    }

    /* renamed from: a */
    private static void m23536a(ae aeVar) {
        if (aeVar.f18289f != null && aeVar.f18289f.has("actionButtons")) {
            JSONArray jSONArray = aeVar.f18289f.getJSONArray("actionButtons");
            aeVar.f18300q = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                C5443a c5443a = new C5443a();
                c5443a.f18278a = jSONObject.optString("id", null);
                c5443a.f18279b = jSONObject.optString("text", null);
                c5443a.f18280c = jSONObject.optString("icon", null);
                aeVar.f18300q.add(c5443a);
            }
            aeVar.f18289f.remove("actionSelected");
            aeVar.f18289f.remove("actionButtons");
        }
    }

    /* renamed from: a */
    private static void m23537a(ae aeVar, JSONObject jSONObject) {
        jSONObject = jSONObject.optString("bg_img", null);
        if (jSONObject != null) {
            JSONObject jSONObject2 = new JSONObject(jSONObject);
            aeVar.f18302s = new C5444b();
            aeVar.f18302s.f18281a = jSONObject2.optString("img");
            aeVar.f18302s.f18282b = jSONObject2.optString("tc");
            aeVar.f18302s.f18283c = jSONObject2.optString("bc");
        }
    }

    /* renamed from: c */
    private static void m23546c(C5538t c5538t) {
        Throwable th;
        if (!c5538t.f18578c && c5538t.f18577b.has("collapse_key")) {
            if (!"do_not_collapse".equals(c5538t.f18577b.optString("collapse_key"))) {
                String optString = c5538t.f18577b.optString("collapse_key");
                Cursor cursor = null;
                try {
                    Cursor query = ao.m23264a(c5538t.f18576a).m23267b().query("notification", new String[]{"android_notification_id"}, "collapse_id = ? AND dismissed = 0 AND opened = 0 ", new String[]{optString}, null, null, null);
                    try {
                        if (query.moveToFirst()) {
                            c5538t.m23563a(Integer.valueOf(query.getInt(query.getColumnIndex("android_notification_id"))));
                        }
                        if (query != null && query.isClosed() == null) {
                            query.close();
                        }
                    } catch (Throwable th2) {
                        c5538t = th2;
                        cursor = query;
                        if (!(cursor == null || cursor.isClosed())) {
                            cursor.close();
                        }
                        throw c5538t;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    am.m23161a(C5464i.ERROR, "Could not read DB to find existing collapse_key!", th);
                    cursor.close();
                }
            }
        }
    }

    /* renamed from: a */
    static C5528a m23531a(Context context, final Bundle bundle) {
        C5528a c5528a = new C5528a();
        if (am.m23147a(bundle) == null) {
            return c5528a;
        }
        c5528a.f18566a = true;
        C5529q.m23548e(bundle);
        if (C5529q.m23539a(context, bundle, c5528a)) {
            return c5528a;
        }
        c5528a.f18568c = am.m23177a(context, C5529q.m23532a(bundle));
        if (!(c5528a.f18568c || C5529q.m23541a(bundle.getString("alert")))) {
            C5529q.m23533a(context, bundle, true, -1);
            new Thread(new Runnable() {
                public void run() {
                    am.m23171a(C5529q.m23547d(bundle), false, false);
                }
            }, "OS_PROC_BUNDLE").start();
        }
        return c5528a;
    }

    /* renamed from: a */
    private static boolean m23539a(Context context, Bundle bundle, C5528a c5528a) {
        Intent a = C6965s.m32688a(context);
        boolean z = false;
        if (a == null) {
            return false;
        }
        a.putExtra("json_payload", C5529q.m23532a(bundle).toString());
        a.putExtra("timestamp", System.currentTimeMillis() / 1000);
        if (Integer.parseInt(bundle.getString("pri", AppEventsConstants.EVENT_PARAM_VALUE_NO)) > 9) {
            z = true;
        }
        if (VERSION.SDK_INT >= 21) {
            JobIntentService.m23026a(context, (ComponentName) a.getComponent(), 2071862121, a, z);
        } else {
            context.startService(a);
        }
        c5528a.f18567b = true;
        return true;
    }

    /* renamed from: a */
    static boolean m23541a(String str) {
        str = (str == null || "".equals(str) != null) ? null : true;
        boolean p = am.m23252p();
        boolean u = am.m23257u();
        if (str != null) {
            if (am.m23250o() != null || p) {
                return true;
            }
            if (!u) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    static JSONArray m23542b(JSONObject jSONObject) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject);
        return jSONArray;
    }

    /* renamed from: b */
    static boolean m23544b(Bundle bundle) {
        if (!(C5529q.m23540a(bundle, "licon") || C5529q.m23540a(bundle, "bicon"))) {
            if (bundle.getString("bg_img", null) == null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m23540a(Bundle bundle, String str) {
        bundle = bundle.getString(str, "").trim();
        if (bundle.startsWith("http://") == null) {
            if (bundle.startsWith("https://") == null) {
                return null;
            }
        }
        return true;
    }
}
