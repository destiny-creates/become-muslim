package com.google.android.gms.measurement;

import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.C0383g;
import com.google.android.gms.internal.p213l.bw;
import com.google.android.gms.internal.p213l.bz;

public final class AppMeasurementReceiver extends C0383g implements bz {
    /* renamed from: a */
    private bw f24660a;

    /* renamed from: a */
    public final PendingResult mo4853a() {
        return goAsync();
    }

    /* renamed from: a */
    public final void mo4854a(Context context, Intent intent) {
        a_(context, intent);
    }

    public final void onReceive(Context context, Intent intent) {
        if (this.f24660a == null) {
            this.f24660a = new bw(this);
        }
        this.f24660a.m21332a(context, intent);
    }
}
