package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;

/* renamed from: com.google.android.gms.common.util.v */
public final class C2911v {
    /* renamed from: a */
    private static final IntentFilter f7404a = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    /* renamed from: b */
    private static long f7405b;
    /* renamed from: c */
    private static float f7406c = Float.NaN;

    @TargetApi(20)
    /* renamed from: a */
    public static int m8490a(Context context) {
        if (context != null) {
            if (context.getApplicationContext() != null) {
                int i;
                Intent registerReceiver = context.getApplicationContext().registerReceiver(null, f7404a);
                int i2 = 0;
                if (registerReceiver == null) {
                    i = 0;
                } else {
                    i = registerReceiver.getIntExtra("plugged", 0);
                }
                i = (i & 7) != 0 ? 1 : 0;
                PowerManager powerManager = (PowerManager) context.getSystemService("power");
                if (powerManager == null) {
                    return -1;
                }
                if (C2904o.m8462h()) {
                    context = powerManager.isInteractive();
                } else {
                    context = powerManager.isScreenOn();
                }
                if (context != null) {
                    i2 = 1;
                }
                return (i2 << 1) | i;
            }
        }
        return -1;
    }

    /* renamed from: b */
    public static synchronized float m8491b(Context context) {
        synchronized (C2911v.class) {
            if (SystemClock.elapsedRealtime() - f7405b >= 60000 || Float.isNaN(f7406c)) {
                context = context.getApplicationContext().registerReceiver(null, f7404a);
                if (context != null) {
                    f7406c = ((float) context.getIntExtra("level", -1)) / ((float) context.getIntExtra("scale", -1));
                }
                f7405b = SystemClock.elapsedRealtime();
                context = f7406c;
                return context;
            }
            context = f7406c;
            return context;
        }
    }
}
