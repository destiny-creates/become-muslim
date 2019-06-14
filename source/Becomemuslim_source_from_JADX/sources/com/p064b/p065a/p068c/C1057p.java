package com.p064b.p065a.p068c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.internal.AnalyticsEvents;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: DevicePowerStateListener */
/* renamed from: com.b.a.c.p */
class C1057p {
    /* renamed from: a */
    private static final IntentFilter f2945a = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    /* renamed from: b */
    private static final IntentFilter f2946b = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");
    /* renamed from: c */
    private static final IntentFilter f2947c = new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED");
    /* renamed from: d */
    private final AtomicBoolean f2948d;
    /* renamed from: e */
    private final Context f2949e;
    /* renamed from: f */
    private final BroadcastReceiver f2950f;
    /* renamed from: g */
    private final BroadcastReceiver f2951g;
    /* renamed from: h */
    private boolean f2952h;

    /* compiled from: DevicePowerStateListener */
    /* renamed from: com.b.a.c.p$1 */
    class C10551 extends BroadcastReceiver {
        /* renamed from: a */
        final /* synthetic */ C1057p f2943a;

        C10551(C1057p c1057p) {
            this.f2943a = c1057p;
        }

        public void onReceive(Context context, Intent intent) {
            this.f2943a.f2952h = true;
        }
    }

    /* compiled from: DevicePowerStateListener */
    /* renamed from: com.b.a.c.p$2 */
    class C10562 extends BroadcastReceiver {
        /* renamed from: a */
        final /* synthetic */ C1057p f2944a;

        C10562(C1057p c1057p) {
            this.f2944a = c1057p;
        }

        public void onReceive(Context context, Intent intent) {
            this.f2944a.f2952h = null;
        }
    }

    public C1057p(Context context) {
        boolean z;
        this.f2949e = context;
        Intent registerReceiver = context.registerReceiver(null, f2945a);
        int i = -1;
        if (registerReceiver != null) {
            i = registerReceiver.getIntExtra(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, -1);
        }
        if (i != 2) {
            if (i != 5) {
                z = false;
                this.f2952h = z;
                this.f2951g = new C10551(this);
                this.f2950f = new C10562(this);
                context.registerReceiver(this.f2951g, f2946b);
                context.registerReceiver(this.f2950f, f2947c);
                this.f2948d = new AtomicBoolean(true);
            }
        }
        z = true;
        this.f2952h = z;
        this.f2951g = new C10551(this);
        this.f2950f = new C10562(this);
        context.registerReceiver(this.f2951g, f2946b);
        context.registerReceiver(this.f2950f, f2947c);
        this.f2948d = new AtomicBoolean(true);
    }

    /* renamed from: a */
    public boolean m3636a() {
        return this.f2952h;
    }

    /* renamed from: b */
    public void m3637b() {
        if (this.f2948d.getAndSet(false)) {
            this.f2949e.unregisterReceiver(this.f2951g);
            this.f2949e.unregisterReceiver(this.f2950f);
        }
    }
}
