package com.google.firebase.iid;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.util.p183a.C2888b;
import com.google.android.gms.p186f.C2954g;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: com.google.firebase.iid.e */
public final class C5356e {
    /* renamed from: a */
    private static C5356e f18094a;
    /* renamed from: b */
    private final Context f18095b;
    /* renamed from: c */
    private final ScheduledExecutorService f18096c;
    /* renamed from: d */
    private C5358g f18097d = new C5358g();
    /* renamed from: e */
    private int f18098e = 1;

    /* renamed from: a */
    public static synchronized C5356e m22761a(Context context) {
        synchronized (C5356e.class) {
            if (f18094a == null) {
                f18094a = new C5356e(context, Executors.newSingleThreadScheduledExecutor(new C2888b("MessengerIpcClient")));
            }
            context = f18094a;
        }
        return context;
    }

    private C5356e(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f18096c = scheduledExecutorService;
        this.f18095b = context.getApplicationContext();
    }

    /* renamed from: a */
    public final C2954g<Void> m22763a(int i, Bundle bundle) {
        return m22760a(new C6911m(m22758a(), 2, bundle));
    }

    /* renamed from: b */
    public final C2954g<Bundle> m22764b(int i, Bundle bundle) {
        return m22760a(new C6912p(m22758a(), 1, bundle));
    }

    /* renamed from: a */
    private final synchronized <T> C2954g<T> m22760a(C5364n<T> c5364n) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(c5364n);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 9);
            stringBuilder.append("Queueing ");
            stringBuilder.append(valueOf);
            Log.d("MessengerIpcClient", stringBuilder.toString());
        }
        if (!this.f18097d.m22770a((C5364n) c5364n)) {
            this.f18097d = new C5358g();
            this.f18097d.m22770a((C5364n) c5364n);
        }
        return c5364n.f18113b.a();
    }

    /* renamed from: a */
    private final synchronized int m22758a() {
        int i;
        i = this.f18098e;
        this.f18098e = i + 1;
        return i;
    }
}
