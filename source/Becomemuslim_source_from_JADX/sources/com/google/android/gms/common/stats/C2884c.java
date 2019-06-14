package com.google.android.gms.common.stats;

import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.text.TextUtils;

/* renamed from: com.google.android.gms.common.stats.c */
public class C2884c {
    /* renamed from: a */
    public static String m8411a(WakeLock wakeLock, String str) {
        wakeLock = String.valueOf(String.valueOf((((long) Process.myPid()) << 32) | ((long) System.identityHashCode(wakeLock))));
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        str = String.valueOf(str);
        return str.length() != 0 ? wakeLock.concat(str) : new String(wakeLock);
    }
}
