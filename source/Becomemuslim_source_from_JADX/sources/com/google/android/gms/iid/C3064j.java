package com.google.android.gms.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* renamed from: com.google.android.gms.iid.j */
final class C3064j extends BroadcastReceiver {
    /* renamed from: a */
    private final /* synthetic */ C3063h f7837a;

    C3064j(C3063h c3063h) {
        this.f7837a = c3063h;
    }

    public final void onReceive(Context context, Intent intent) {
        if (Log.isLoggable("InstanceID", 3) != null) {
            Log.d("InstanceID", "Received GSF callback via dynamic receiver");
        }
        this.f7837a.m8970a(intent);
    }
}
