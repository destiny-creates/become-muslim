package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.p213l.bw;
import com.google.android.gms.internal.p213l.bz;

public final class AppMeasurementInstallReferrerReceiver extends BroadcastReceiver implements bz {
    /* renamed from: a */
    private bw f24658a;

    /* renamed from: a */
    public final PendingResult mo4853a() {
        return goAsync();
    }

    /* renamed from: a */
    public final void mo4854a(Context context, Intent intent) {
    }

    public final void onReceive(Context context, Intent intent) {
        if (this.f24658a == null) {
            this.f24658a = new bw(this);
        }
        this.f24658a.m21332a(context, intent);
    }
}
