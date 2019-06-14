package com.google.firebase.iid;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.content.C0383g;
import android.util.Log;
import com.google.android.gms.common.util.p183a.C2888b;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class ad extends Service {
    /* renamed from: a */
    final ExecutorService f18053a;
    /* renamed from: b */
    private Binder f18054b;
    /* renamed from: c */
    private final Object f18055c;
    /* renamed from: d */
    private int f18056d;
    /* renamed from: e */
    private int f18057e;

    public ad() {
        String str = "Firebase-";
        String valueOf = String.valueOf(getClass().getSimpleName());
        this.f18053a = Executors.newSingleThreadExecutor(new C2888b(valueOf.length() != 0 ? str.concat(valueOf) : new String(str)));
        this.f18055c = new Object();
        this.f18057e = 0;
    }

    /* renamed from: a */
    protected Intent mo4882a(Intent intent) {
        return intent;
    }

    /* renamed from: b */
    public abstract void mo4883b(Intent intent);

    /* renamed from: c */
    public boolean mo4896c(Intent intent) {
        return false;
    }

    public final synchronized IBinder onBind(Intent intent) {
        if (Log.isLoggable("EnhancedIntentService", 3) != null) {
            Log.d("EnhancedIntentService", "Service received bind request");
        }
        if (this.f18054b == null) {
            this.f18054b = new ai(this);
        }
        return this.f18054b;
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        synchronized (this.f18055c) {
            this.f18056d = i2;
            this.f18057e++;
        }
        i = mo4882a(intent);
        if (i == 0) {
            m22706d(intent);
            return 2;
        } else if (mo4896c(i)) {
            m22706d(intent);
            return 2;
        } else {
            this.f18053a.execute(new af(this, i, intent));
            return 3;
        }
    }

    /* renamed from: d */
    private final void m22706d(Intent intent) {
        if (intent != null) {
            C0383g.a(intent);
        }
        synchronized (this.f18055c) {
            this.f18057e--;
            if (this.f18057e == 0) {
                stopSelfResult(this.f18056d);
            }
        }
    }
}
