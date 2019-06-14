package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.p180d.C2829c;

public final class be {
    /* renamed from: a */
    private static Object f7254a = new Object();
    /* renamed from: b */
    private static boolean f7255b;
    /* renamed from: c */
    private static String f7256c;
    /* renamed from: d */
    private static int f7257d;

    /* renamed from: a */
    public static String m8240a(Context context) {
        m8242c(context);
        return f7256c;
    }

    /* renamed from: b */
    public static int m8241b(Context context) {
        m8242c(context);
        return f7257d;
    }

    /* renamed from: c */
    private static void m8242c(Context context) {
        synchronized (f7254a) {
            if (f7255b) {
                return;
            }
            f7255b = true;
            try {
                context = C2829c.m8131a(context).m8124a(context.getPackageName(), 128).metaData;
                if (context == null) {
                    return;
                } else {
                    f7256c = context.getString("com.google.app.id");
                    f7257d = context.getInt("com.google.android.gms.version");
                }
            } catch (Context context2) {
                Log.wtf("MetadataValueReader", "This should never happen.", context2);
            }
        }
    }
}
