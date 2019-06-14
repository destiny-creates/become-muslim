package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

@cm
public final class me {
    /* renamed from: a */
    private final BroadcastReceiver f15780a = new mf(this);
    /* renamed from: b */
    private final Map<BroadcastReceiver, IntentFilter> f15781b = new WeakHashMap();
    /* renamed from: c */
    private boolean f15782c = false;
    /* renamed from: d */
    private boolean f15783d;
    /* renamed from: e */
    private Context f15784e;

    /* renamed from: a */
    private final synchronized void m19849a(Context context, Intent intent) {
        for (Entry entry : this.f15781b.entrySet()) {
            if (((IntentFilter) entry.getValue()).hasAction(intent.getAction())) {
                ((BroadcastReceiver) entry.getKey()).onReceive(context, intent);
            }
        }
    }

    /* renamed from: a */
    public final synchronized void m19851a(Context context) {
        if (!this.f15782c) {
            this.f15784e = context.getApplicationContext();
            if (this.f15784e == null) {
                this.f15784e = context;
            }
            asp.m18892a(this.f15784e);
            this.f15783d = ((Boolean) aph.m18688f().m18889a(asp.ch)).booleanValue();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.f15784e.registerReceiver(this.f15780a, intentFilter);
            this.f15782c = true;
        }
    }

    /* renamed from: a */
    public final synchronized void m19852a(Context context, BroadcastReceiver broadcastReceiver) {
        if (this.f15783d) {
            this.f15781b.remove(broadcastReceiver);
        } else {
            context.unregisterReceiver(broadcastReceiver);
        }
    }

    /* renamed from: a */
    public final synchronized void m19853a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (this.f15783d) {
            this.f15781b.put(broadcastReceiver, intentFilter);
        } else {
            context.registerReceiver(broadcastReceiver, intentFilter);
        }
    }
}
