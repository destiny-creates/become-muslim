package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;

/* renamed from: com.google.android.gms.common.util.i */
public final class C2898i {
    /* renamed from: a */
    private static Boolean f7385a;
    /* renamed from: b */
    private static Boolean f7386b;
    /* renamed from: c */
    private static Boolean f7387c;

    @TargetApi(20)
    /* renamed from: a */
    public static boolean m8442a(Context context) {
        if (f7385a == null) {
            context = (!C2904o.m8462h() || context.getPackageManager().hasSystemFeature("android.hardware.type.watch") == null) ? null : true;
            f7385a = Boolean.valueOf(context);
        }
        return f7385a.booleanValue();
    }

    @TargetApi(26)
    /* renamed from: b */
    public static boolean m8443b(Context context) {
        return (!C2898i.m8442a(context) || (C2904o.m8465k() && (C2898i.m8444c(context) == null || C2904o.m8466l() != null))) ? null : true;
    }

    @TargetApi(21)
    /* renamed from: c */
    public static boolean m8444c(Context context) {
        if (f7386b == null) {
            context = (!C2904o.m8463i() || context.getPackageManager().hasSystemFeature("cn.google") == null) ? null : true;
            f7386b = Boolean.valueOf(context);
        }
        return f7386b.booleanValue();
    }

    /* renamed from: d */
    public static boolean m8445d(Context context) {
        if (f7387c == null) {
            if (!context.getPackageManager().hasSystemFeature("android.hardware.type.iot")) {
                if (context.getPackageManager().hasSystemFeature("android.hardware.type.embedded") == null) {
                    context = null;
                    f7387c = Boolean.valueOf(context);
                }
            }
            context = true;
            f7387c = Boolean.valueOf(context);
        }
        return f7387c.booleanValue();
    }

    /* renamed from: a */
    public static boolean m8441a() {
        return "user".equals(Build.TYPE);
    }
}
