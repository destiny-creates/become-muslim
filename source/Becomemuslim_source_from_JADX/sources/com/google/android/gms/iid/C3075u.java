package com.google.android.gms.iid;

import android.content.BroadcastReceiver.PendingResult;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.util.p183a.C2888b;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* renamed from: com.google.android.gms.iid.u */
public final class C3075u implements ServiceConnection {
    /* renamed from: a */
    private final Context f7860a;
    /* renamed from: b */
    private final Intent f7861b;
    /* renamed from: c */
    private final ScheduledExecutorService f7862c;
    /* renamed from: d */
    private final Queue<C3071q> f7863d;
    /* renamed from: e */
    private C3073s f7864e;
    /* renamed from: f */
    private boolean f7865f;

    public C3075u(Context context, String str) {
        this(context, str, new ScheduledThreadPoolExecutor(0, new C2888b("EnhancedIntentService")));
    }

    private C3075u(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        this.f7863d = new ArrayDeque();
        this.f7865f = false;
        this.f7860a = context.getApplicationContext();
        this.f7861b = new Intent(str).setPackage(this.f7860a.getPackageName());
        this.f7862c = scheduledExecutorService;
    }

    /* renamed from: a */
    public final synchronized void m8995a(Intent intent, PendingResult pendingResult) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "new intent queued in the bind-strategy delivery");
        }
        this.f7863d.add(new C3071q(intent, pendingResult, this.f7862c));
        m8993a();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private final synchronized void m8993a() {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = "EnhancedIntentService";
        r1 = 3;
        r0 = android.util.Log.isLoggable(r0, r1);	 Catch:{ all -> 0x00a7 }
        if (r0 == 0) goto L_0x0011;
    L_0x000a:
        r0 = "EnhancedIntentService";
        r2 = "flush queue called";
        android.util.Log.d(r0, r2);	 Catch:{ all -> 0x00a7 }
    L_0x0011:
        r0 = r5.f7863d;	 Catch:{ all -> 0x00a7 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x00a7 }
        if (r0 != 0) goto L_0x00a5;
    L_0x0019:
        r0 = "EnhancedIntentService";
        r0 = android.util.Log.isLoggable(r0, r1);	 Catch:{ all -> 0x00a7 }
        if (r0 == 0) goto L_0x0028;
    L_0x0021:
        r0 = "EnhancedIntentService";
        r2 = "found intent to be delivered";
        android.util.Log.d(r0, r2);	 Catch:{ all -> 0x00a7 }
    L_0x0028:
        r0 = r5.f7864e;	 Catch:{ all -> 0x00a7 }
        if (r0 == 0) goto L_0x0051;
    L_0x002c:
        r0 = r5.f7864e;	 Catch:{ all -> 0x00a7 }
        r0 = r0.isBinderAlive();	 Catch:{ all -> 0x00a7 }
        if (r0 == 0) goto L_0x0051;
    L_0x0034:
        r0 = "EnhancedIntentService";
        r0 = android.util.Log.isLoggable(r0, r1);	 Catch:{ all -> 0x00a7 }
        if (r0 == 0) goto L_0x0043;
    L_0x003c:
        r0 = "EnhancedIntentService";
        r2 = "binder is alive, sending the intent.";
        android.util.Log.d(r0, r2);	 Catch:{ all -> 0x00a7 }
    L_0x0043:
        r0 = r5.f7863d;	 Catch:{ all -> 0x00a7 }
        r0 = r0.poll();	 Catch:{ all -> 0x00a7 }
        r0 = (com.google.android.gms.iid.C3071q) r0;	 Catch:{ all -> 0x00a7 }
        r2 = r5.f7864e;	 Catch:{ all -> 0x00a7 }
        r2.m8992a(r0);	 Catch:{ all -> 0x00a7 }
        goto L_0x0011;
    L_0x0051:
        r0 = "EnhancedIntentService";
        r0 = android.util.Log.isLoggable(r0, r1);	 Catch:{ all -> 0x00a7 }
        r1 = 1;
        if (r0 == 0) goto L_0x0075;
    L_0x005a:
        r0 = "EnhancedIntentService";
        r2 = r5.f7865f;	 Catch:{ all -> 0x00a7 }
        r2 = r2 ^ r1;
        r3 = 39;
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00a7 }
        r4.<init>(r3);	 Catch:{ all -> 0x00a7 }
        r3 = "binder is dead. start connection? ";
        r4.append(r3);	 Catch:{ all -> 0x00a7 }
        r4.append(r2);	 Catch:{ all -> 0x00a7 }
        r2 = r4.toString();	 Catch:{ all -> 0x00a7 }
        android.util.Log.d(r0, r2);	 Catch:{ all -> 0x00a7 }
    L_0x0075:
        r0 = r5.f7865f;	 Catch:{ all -> 0x00a7 }
        if (r0 != 0) goto L_0x00a3;
    L_0x0079:
        r5.f7865f = r1;	 Catch:{ all -> 0x00a7 }
        r0 = com.google.android.gms.common.stats.C2882a.m8407a();	 Catch:{ SecurityException -> 0x0095 }
        r1 = r5.f7860a;	 Catch:{ SecurityException -> 0x0095 }
        r2 = r5.f7861b;	 Catch:{ SecurityException -> 0x0095 }
        r3 = 65;
        r0 = r0.m8409a(r1, r2, r5, r3);	 Catch:{ SecurityException -> 0x0095 }
        if (r0 == 0) goto L_0x008d;
    L_0x008b:
        monitor-exit(r5);
        return;
    L_0x008d:
        r0 = "EnhancedIntentService";
        r1 = "binding to the service failed";
        android.util.Log.e(r0, r1);	 Catch:{ SecurityException -> 0x0095 }
        goto L_0x009d;
    L_0x0095:
        r0 = move-exception;
        r1 = "EnhancedIntentService";
        r2 = "Exception while binding the service";
        android.util.Log.e(r1, r2, r0);	 Catch:{ all -> 0x00a7 }
    L_0x009d:
        r0 = 0;
        r5.f7865f = r0;	 Catch:{ all -> 0x00a7 }
        r5.m8994b();	 Catch:{ all -> 0x00a7 }
    L_0x00a3:
        monitor-exit(r5);
        return;
    L_0x00a5:
        monitor-exit(r5);
        return;
    L_0x00a7:
        r0 = move-exception;
        monitor-exit(r5);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.iid.u.a():void");
    }

    /* renamed from: b */
    private final void m8994b() {
        while (!this.f7863d.isEmpty()) {
            ((C3071q) this.f7863d.poll()).m8990a();
        }
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this) {
            this.f7865f = false;
            this.f7864e = (C3073s) iBinder;
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                componentName = String.valueOf(componentName);
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(componentName).length() + 20);
                stringBuilder.append("onServiceConnected: ");
                stringBuilder.append(componentName);
                Log.d("EnhancedIntentService", stringBuilder.toString());
            }
            if (iBinder == null) {
                Log.e("EnhancedIntentService", "Null service connection");
                m8994b();
            } else {
                m8993a();
            }
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            componentName = String.valueOf(componentName);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(componentName).length() + 23);
            stringBuilder.append("onServiceDisconnected: ");
            stringBuilder.append(componentName);
            Log.d("EnhancedIntentService", stringBuilder.toString());
        }
        m8993a();
    }
}
