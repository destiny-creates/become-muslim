package com.google.android.gms.iid;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.util.p183a.C2888b;
import com.google.android.gms.internal.p209h.C4980d;
import com.google.android.gms.p186f.C2954g;
import java.util.concurrent.ScheduledExecutorService;

public final class ab {
    /* renamed from: a */
    private final Context f7802a;
    /* renamed from: b */
    private final ScheduledExecutorService f7803b;
    /* renamed from: c */
    private ad f7804c;
    /* renamed from: d */
    private int f7805d;

    public ab(Context context) {
        this(context, C4980d.a().a(1, new C2888b("MessengerIpcClient"), 9));
    }

    private ab(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f7804c = new ad();
        this.f7805d = 1;
        this.f7802a = context.getApplicationContext();
        this.f7803b = scheduledExecutorService;
    }

    /* renamed from: a */
    public final C2954g<Bundle> m8945a(int i, Bundle bundle) {
        return m8943a(new C4429d(m8941a(), 1, bundle));
    }

    /* renamed from: a */
    private final synchronized <T> C2954g<T> m8943a(aj<T> ajVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(ajVar);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 9);
            stringBuilder.append("Queueing ");
            stringBuilder.append(valueOf);
            Log.d("MessengerIpcClient", stringBuilder.toString());
        }
        if (!this.f7804c.m8951a((aj) ajVar)) {
            this.f7804c = new ad();
            this.f7804c.m8951a((aj) ajVar);
        }
        return ajVar.f7820b.m8783a();
    }

    /* renamed from: a */
    private final synchronized int m8941a() {
        int i;
        i = this.f7805d;
        this.f7805d = i + 1;
        return i;
    }
}
