package com.google.android.gms.analytics;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.internal.p210i.bt;
import com.google.android.gms.internal.p210i.bx;

public final class AnalyticsService extends Service implements bx {
    /* renamed from: a */
    private bt<AnalyticsService> f11352a;

    /* renamed from: a */
    private final bt<AnalyticsService> m13964a() {
        if (this.f11352a == null) {
            this.f11352a = new bt(this);
        }
        return this.f11352a;
    }

    public final void onCreate() {
        super.onCreate();
        m13964a().a();
    }

    public final void onDestroy() {
        m13964a().b();
        super.onDestroy();
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        return m13964a().a(intent, i, i2);
    }

    public final IBinder onBind(Intent intent) {
        m13964a();
        return null;
    }

    /* renamed from: a */
    public final boolean m13966a(int i) {
        return stopSelfResult(i);
    }

    /* renamed from: a */
    public final void m13965a(JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }
}
