package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class kb extends BroadcastReceiver {
    /* renamed from: a */
    private final /* synthetic */ jw f15701a;

    private kb(jw jwVar) {
        this.f15701a = jwVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            this.f15701a.f15693c = true;
            return;
        }
        if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            this.f15701a.f15693c = false;
        }
    }
}
