package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.common.C4775b;
import com.google.android.gms.common.internal.C2850d.C2844a;
import com.google.android.gms.common.internal.C2850d.C2845b;

@cm
public final class dj extends de implements C2844a, C2845b {
    /* renamed from: a */
    private Context f28513a;
    /* renamed from: b */
    private mv f28514b;
    /* renamed from: c */
    private ob<dl> f28515c;
    /* renamed from: d */
    private final dc f28516d;
    /* renamed from: e */
    private final Object f28517e = new Object();
    /* renamed from: f */
    private dk f28518f;

    public dj(Context context, mv mvVar, ob<dl> obVar, dc dcVar) {
        super(obVar, dcVar);
        this.f28513a = context;
        this.f28514b = mvVar;
        this.f28515c = obVar;
        this.f28516d = dcVar;
        this.f28518f = new dk(context, ((Boolean) aph.m18688f().m18889a(asp.f14916G)).booleanValue() ? ax.t().m19837a() : context.getMainLooper(), this, this);
        this.f28518f.q();
    }

    /* renamed from: a */
    public final void mo6093a() {
        synchronized (this.f28517e) {
            if (this.f28518f.h() || this.f28518f.i()) {
                this.f28518f.g();
            }
            Binder.flushPendingCommands();
        }
    }

    /* renamed from: a */
    public final void m37454a(int i) {
        mt.m19918b("Disconnected from remote ad request service.");
    }

    /* renamed from: a */
    public final void m37455a(Bundle bundle) {
        mo3819c();
    }

    /* renamed from: a */
    public final void m37456a(C4775b c4775b) {
        mt.m19918b("Cannot connect to remote service, fallback to local instance.");
        new di(this.f28513a, this.f28515c, this.f28516d).mo3819c();
        Bundle bundle = new Bundle();
        bundle.putString(NativeProtocol.WEB_DIALOG_ACTION, "gms_connection_failed_fallback_to_local");
        ax.e().m19745b(this.f28513a, this.f28514b.f28709a, "gmob-apps", bundle, true);
    }

    /* renamed from: d */
    public final com.google.android.gms.internal.ads.dt mo6094d() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.f28517e;
        monitor-enter(r0);
        r1 = r2.f28518f;	 Catch:{ IllegalStateException -> 0x000d, IllegalStateException -> 0x000d }
        r1 = r1.m30705e();	 Catch:{ IllegalStateException -> 0x000d, IllegalStateException -> 0x000d }
        monitor-exit(r0);	 Catch:{ all -> 0x000b }
        return r1;	 Catch:{ all -> 0x000b }
    L_0x000b:
        r1 = move-exception;	 Catch:{ all -> 0x000b }
        goto L_0x0010;	 Catch:{ all -> 0x000b }
    L_0x000d:
        r1 = 0;	 Catch:{ all -> 0x000b }
        monitor-exit(r0);	 Catch:{ all -> 0x000b }
        return r1;	 Catch:{ all -> 0x000b }
    L_0x0010:
        monitor-exit(r0);	 Catch:{ all -> 0x000b }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.dj.d():com.google.android.gms.internal.ads.dt");
    }
}
