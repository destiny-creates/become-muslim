package com.google.android.gms.internal.p213l;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* renamed from: com.google.android.gms.internal.l.bu */
final class bu implements ServiceConnection {
    /* renamed from: a */
    final /* synthetic */ bs f17013a;

    private bu(bs bsVar) {
        this.f17013a = bsVar;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            this.f17013a.f17011b.mo4754r().m42565i().m21307a("Install Referrer connection returned with null binder");
            return;
        }
        try {
            this.f17013a.f17010a = gw.m32081a(iBinder);
            if (this.f17013a.f17010a == null) {
                this.f17013a.f17011b.mo4754r().m42565i().m21307a("Install Referrer Service implementation was not found");
                return;
            }
            this.f17013a.f17011b.mo4754r().m42567k().m21307a("Install Referrer Service connected");
            this.f17013a.f17011b.mo4753q().m42612a(new bv(this));
        } catch (Exception e) {
            this.f17013a.f17011b.mo4754r().m42565i().m21308a("Exception occurred while calling Install Referrer API", e);
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.f17013a.f17010a = null;
        this.f17013a.f17011b.mo4754r().m42567k().m21307a("Install Referrer Service disconnected");
    }
}
