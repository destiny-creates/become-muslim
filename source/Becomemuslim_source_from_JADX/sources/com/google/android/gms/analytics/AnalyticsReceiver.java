package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.p210i.bs;

public final class AnalyticsReceiver extends BroadcastReceiver {
    /* renamed from: a */
    private bs f6950a;

    public final void onReceive(Context context, Intent intent) {
        if (this.f6950a == null) {
            this.f6950a = new bs();
        }
        bs.a(context, intent);
    }
}
