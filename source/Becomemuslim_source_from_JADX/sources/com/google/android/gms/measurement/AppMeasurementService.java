package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.internal.p213l.ex;
import com.google.android.gms.internal.p213l.fb;

public final class AppMeasurementService extends Service implements fb {
    /* renamed from: a */
    private ex<AppMeasurementService> f24661a;

    /* renamed from: a */
    private final ex<AppMeasurementService> m32221a() {
        if (this.f24661a == null) {
            this.f24661a = new ex(this);
        }
        return this.f24661a;
    }

    /* renamed from: a */
    public final void mo4855a(JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public final void mo4856a(Intent intent) {
        AppMeasurementReceiver.a(intent);
    }

    /* renamed from: a */
    public final boolean mo4857a(int i) {
        return stopSelfResult(i);
    }

    public final IBinder onBind(Intent intent) {
        return m32221a().m21349a(intent);
    }

    public final void onCreate() {
        super.onCreate();
        m32221a().m21350a();
    }

    public final void onDestroy() {
        m32221a().m21354b();
        super.onDestroy();
    }

    public final void onRebind(Intent intent) {
        m32221a().m21356c(intent);
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        return m32221a().m21348a(intent, i, i2);
    }

    public final boolean onUnbind(Intent intent) {
        return m32221a().m21355b(intent);
    }
}
