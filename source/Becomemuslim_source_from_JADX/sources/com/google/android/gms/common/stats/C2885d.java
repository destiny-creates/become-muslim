package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.C2911v;
import java.util.List;

/* renamed from: com.google.android.gms.common.stats.d */
public class C2885d {
    /* renamed from: a */
    private static C2885d f7365a = new C2885d();
    /* renamed from: b */
    private static Boolean f7366b;
    /* renamed from: c */
    private static boolean f7367c = false;

    /* renamed from: a */
    public static C2885d m8412a() {
        return f7365a;
    }

    /* renamed from: a */
    public void m8413a(Context context, String str, int i, String str2, String str3, String str4, int i2, List<String> list) {
        m8414a(context, str, i, str2, str3, str4, i2, list, 0);
    }

    /* renamed from: a */
    public void m8414a(Context context, String str, int i, String str2, String str3, String str4, int i2, List<String> list, long j) {
        int i3 = i;
        List list2 = list;
        if (f7366b == null) {
            f7366b = Boolean.valueOf(false);
        }
        if (!f7366b.booleanValue()) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            String str5 = "WakeLockTracker";
            String str6 = "missing wakeLock key. ";
            String valueOf = String.valueOf(str);
            Log.e(str5, valueOf.length() != 0 ? str6.concat(valueOf) : new String(str6));
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (7 == i3 || 8 == i3 || 10 == i3 || 11 == i3) {
            if (list2 != null && list.size() == 1 && "com.google.android.gms".equals(list2.get(0))) {
                list2 = null;
            }
            List list3 = list2;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int a = C2911v.m8490a(context);
            str6 = context.getPackageName();
            WakeLockEvent wakeLockEvent = r1;
            WakeLockEvent wakeLockEvent2 = new WakeLockEvent(currentTimeMillis, i, str2, i2, list3, str, elapsedRealtime, a, str3, "com.google.android.gms".equals(str6) ? null : str6, C2911v.m8491b(context), j, str4);
            try {
                context.startService(new Intent().setComponent(C2883b.f7356a).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", wakeLockEvent));
            } catch (Throwable e) {
                Log.wtf("WakeLockTracker", e);
            }
        }
    }
}
