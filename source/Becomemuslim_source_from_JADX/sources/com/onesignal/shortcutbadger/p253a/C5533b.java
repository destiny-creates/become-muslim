package com.onesignal.shortcutbadger.p253a;

import android.database.Cursor;

/* compiled from: CloseHelper */
/* renamed from: com.onesignal.shortcutbadger.a.b */
public class C5533b {
    /* renamed from: a */
    public static void m23556a(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }

    /* renamed from: a */
    public static void m23557a(java.io.Closeable r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r0 == 0) goto L_0x0005;
    L_0x0002:
        r0.close();	 Catch:{ IOException -> 0x0005 }
    L_0x0005:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.shortcutbadger.a.b.a(java.io.Closeable):void");
    }
}
