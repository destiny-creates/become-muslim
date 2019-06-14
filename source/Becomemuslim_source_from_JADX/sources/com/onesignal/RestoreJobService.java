package com.onesignal;

import android.content.Intent;
import android.os.IBinder;
import com.onesignal.C6965s.C5531a;

public class RestoreJobService extends JobIntentService {
    /* renamed from: a */
    public /* bridge */ /* synthetic */ boolean mo4931a() {
        return super.mo4931a();
    }

    public /* bridge */ /* synthetic */ IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    public /* bridge */ /* synthetic */ void onCreate() {
        super.onCreate();
    }

    public /* bridge */ /* synthetic */ void onDestroy() {
        super.onDestroy();
    }

    public /* bridge */ /* synthetic */ int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    /* renamed from: a */
    protected final void mo4930a(Intent intent) {
        if (intent != null) {
            intent = intent.getExtras();
            if (intent != null) {
                C5529q.m23534a(getApplicationContext(), new C6961h(intent), (C5531a) null);
            }
        }
    }
}
