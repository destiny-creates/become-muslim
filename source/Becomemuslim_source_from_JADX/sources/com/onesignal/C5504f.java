package com.onesignal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.onesignal.am.C5464i;

/* compiled from: BadgeCountUpdater */
/* renamed from: com.onesignal.f */
class C5504f {
    /* renamed from: a */
    private static int f18518a = -1;

    /* renamed from: a */
    private static boolean m23443a(Context context) {
        boolean z = false;
        if (f18518a != -1) {
            if (f18518a == 1) {
                z = true;
            }
            return z;
        }
        try {
            context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (context != null) {
                f18518a = "DISABLE".equals(context.getString("com.onesignal.BadgeCount")) ^ 1;
            } else {
                f18518a = 1;
            }
        } catch (Throwable th) {
            f18518a = 0;
            am.m23161a(C5464i.ERROR, "Error reading meta-data tag 'com.onesignal.BadgeCount'. Disabling badge setting.", th);
        }
        if (f18518a == 1) {
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    private static boolean m23444b(Context context) {
        return (!C5504f.m23443a(context) || al.m23092a(context) == null) ? null : true;
    }

    /* renamed from: a */
    static void m23442a(SQLiteDatabase sQLiteDatabase, Context context) {
        if (C5504f.m23444b(context)) {
            sQLiteDatabase = sQLiteDatabase.query("notification", null, "dismissed = 0 AND opened = 0 AND is_summary = 0 ", null, null, null, null);
            C5504f.m23441a(sQLiteDatabase.getCount(), context);
            sQLiteDatabase.close();
        }
    }

    /* renamed from: a */
    static void m23441a(int r1, android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.onesignal.C5504f.m23443a(r2);
        if (r0 != 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        com.onesignal.shortcutbadger.C5536c.m23560a(r2, r1);	 Catch:{ Throwable -> 0x000a }
    L_0x000a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.f.a(int, android.content.Context):void");
    }
}
