package com.google.android.gms.iid;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.content.C0383g;
import android.util.Log;
import com.google.android.gms.common.util.p183a.C2888b;
import com.google.android.gms.internal.p209h.C4980d;
import java.util.concurrent.ExecutorService;

/* renamed from: com.google.android.gms.iid.o */
public abstract class C3069o extends Service {
    /* renamed from: a */
    final ExecutorService f7843a = C4980d.a().a(new C2888b("EnhancedIntentService"), 9);
    /* renamed from: b */
    private Binder f7844b;
    /* renamed from: c */
    private final Object f7845c = new Object();
    /* renamed from: d */
    private int f7846d;
    /* renamed from: e */
    private int f7847e = 0;

    public abstract void handleIntent(Intent intent);

    public final synchronized IBinder onBind(Intent intent) {
        if (Log.isLoggable("EnhancedIntentService", 3) != null) {
            Log.d("EnhancedIntentService", "Service received bind request");
        }
        if (this.f7844b == null) {
            this.f7844b = new C3073s(this);
        }
        return this.f7844b;
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        synchronized (this.f7845c) {
            this.f7846d = i2;
            this.f7847e++;
        }
        if (intent == null) {
            m8988a(intent);
            return 2;
        }
        this.f7843a.execute(new C3070p(this, intent, intent));
        return 3;
    }

    /* renamed from: a */
    private final void m8988a(Intent intent) {
        if (intent != null) {
            C0383g.m1161a(intent);
        }
        synchronized (this.f7845c) {
            this.f7847e--;
            if (this.f7847e == 0) {
                stopSelfResult(this.f7846d);
            }
        }
    }
}
