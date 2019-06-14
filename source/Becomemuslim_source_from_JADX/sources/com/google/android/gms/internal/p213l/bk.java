package com.google.android.gms.internal.p213l;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.C2872v;

/* renamed from: com.google.android.gms.internal.l.bk */
class bk extends BroadcastReceiver {
    /* renamed from: a */
    private static final String f16984a = "com.google.android.gms.internal.l.bk";
    /* renamed from: b */
    private final fm f16985b;
    /* renamed from: c */
    private boolean f16986c;
    /* renamed from: d */
    private boolean f16987d;

    bk(fm fmVar) {
        C2872v.a(fmVar);
        this.f16985b = fmVar;
    }

    /* renamed from: a */
    public final void m21314a() {
        this.f16985b.m32069i();
        this.f16985b.mo4753q().mo6210d();
        if (!this.f16986c) {
            this.f16985b.mo4752n().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f16987d = this.f16985b.m32061c().m44022f();
            this.f16985b.mo4754r().m42579w().m21308a("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.f16987d));
            this.f16986c = true;
        }
    }

    /* renamed from: b */
    public final void m21315b() {
        this.f16985b.m32069i();
        this.f16985b.mo4753q().mo6210d();
        this.f16985b.mo4753q().mo6210d();
        if (this.f16986c) {
            this.f16985b.mo4754r().m42579w().m21307a("Unregistering connectivity change receiver");
            this.f16986c = false;
            this.f16987d = false;
            try {
                this.f16985b.mo4752n().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.f16985b.mo4754r().I_().m21308a("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        this.f16985b.m32069i();
        String action = intent.getAction();
        this.f16985b.mo4754r().m42579w().m21308a("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean f = this.f16985b.m32061c().m44022f();
            if (this.f16987d != f) {
                this.f16987d = f;
                this.f16985b.mo4753q().m42612a(new bl(this, f));
            }
            return;
        }
        this.f16985b.mo4754r().m42565i().m21308a("NetworkBroadcastReceiver received unknown action", action);
    }
}
