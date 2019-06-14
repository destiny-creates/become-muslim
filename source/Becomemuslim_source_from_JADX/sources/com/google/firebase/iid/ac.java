package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

final class ac extends BroadcastReceiver {
    /* renamed from: a */
    private ab f18052a;

    public ac(ab abVar) {
        this.f18052a = abVar;
    }

    /* renamed from: a */
    public final void m22704a() {
        if (FirebaseInstanceId.m22672h()) {
            Log.d("FirebaseInstanceId", "Connectivity change received registered");
        }
        this.f18052a.m22702a().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public final void onReceive(Context context, Intent intent) {
        if (this.f18052a != null && this.f18052a.m22703b() != null) {
            if (FirebaseInstanceId.m22672h() != null) {
                Log.d("FirebaseInstanceId", "Connectivity changed. Starting background sync.");
            }
            FirebaseInstanceId.m22667a(this.f18052a, 0);
            this.f18052a.m22702a().unregisterReceiver(this);
            this.f18052a = null;
        }
    }
}
