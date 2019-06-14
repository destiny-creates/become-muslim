package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public final class bi extends BroadcastReceiver {
    /* renamed from: a */
    private Context f7138a;
    /* renamed from: b */
    private final bj f7139b;

    public bi(bj bjVar) {
        this.f7139b = bjVar;
    }

    /* renamed from: a */
    public final void m8006a(Context context) {
        this.f7138a = context;
    }

    /* renamed from: a */
    public final synchronized void m8005a() {
        if (this.f7138a != null) {
            this.f7138a.unregisterReceiver(this);
        }
        this.f7138a = null;
    }

    public final void onReceive(Context context, Intent intent) {
        context = intent.getData();
        if ("com.google.android.gms".equals(context != null ? context.getSchemeSpecificPart() : null) != null) {
            this.f7139b.mo2423a();
            m8005a();
        }
    }
}
