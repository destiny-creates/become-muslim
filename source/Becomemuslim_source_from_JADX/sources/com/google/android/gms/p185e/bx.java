package com.google.android.gms.p185e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: com.google.android.gms.e.bx */
class bx extends BroadcastReceiver {
    /* renamed from: a */
    private static final String f7482a = "com.google.android.gms.e.bx";
    /* renamed from: b */
    private final dx f7483b;

    bx(dx dxVar) {
        this.f7483b = dxVar;
    }

    public void onReceive(Context context, Intent intent) {
        context = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(context)) {
            context = intent.getExtras();
            Boolean bool = Boolean.FALSE;
            if (context != null) {
                bool = Boolean.valueOf(intent.getExtras().getBoolean("noConnectivity"));
            }
            this.f7483b.mo2550a(bool.booleanValue() ^ 1);
            return;
        }
        if ("com.google.analytics.RADIO_POWERED".equals(context) != null && intent.hasExtra(f7482a) == null) {
            this.f7483b.mo2551b();
        }
    }

    /* renamed from: a */
    public static void m8599a(Context context) {
        Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
        intent.addCategory(context.getPackageName());
        intent.putExtra(f7482a, true);
        context.sendBroadcast(intent);
    }
}
