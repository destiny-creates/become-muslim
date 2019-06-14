package com.google.android.gms.common.util;

import android.content.Context;
import android.os.DropBoxManager;
import android.util.Log;
import com.google.android.gms.common.internal.C2872v;

/* renamed from: com.google.android.gms.common.util.g */
public final class C2897g {
    /* renamed from: a */
    private static final String[] f7379a = new String[]{"android.", "com.android.", "dalvik.", "java.", "javax."};
    /* renamed from: b */
    private static DropBoxManager f7380b = null;
    /* renamed from: c */
    private static boolean f7381c = false;
    /* renamed from: d */
    private static int f7382d = -1;
    /* renamed from: e */
    private static int f7383e = 0;
    /* renamed from: f */
    private static int f7384f = 0;

    /* renamed from: a */
    public static boolean m8439a(Context context, Throwable th) {
        return C2897g.m8440a(context, th, 536870912);
    }

    /* renamed from: a */
    private static boolean m8440a(Context context, Throwable th, int i) {
        try {
            C2872v.m8380a((Object) context);
            C2872v.m8380a((Object) th);
            return false;
        } catch (Context context2) {
            Log.e("CrashUtils", "Error adding exception to DropBox!", context2);
            return false;
        }
    }
}
