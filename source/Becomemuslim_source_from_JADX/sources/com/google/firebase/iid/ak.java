package com.google.firebase.iid;

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

public final class ak implements ServiceConnection {
    /* renamed from: a */
    private final Context f18073a;
    /* renamed from: b */
    private final Intent f18074b;
    /* renamed from: c */
    private final ScheduledExecutorService f18075c;
    /* renamed from: d */
    private final Queue<ag> f18076d;
    /* renamed from: e */
    private ai f18077e;
    /* renamed from: f */
    private boolean f18078f;

    public ak(Context context, String str) {
        this(context, str, new ScheduledThreadPoolExecutor(0, new C2888b("Firebase-FirebaseInstanceIdServiceConnection")));
    }

    private ak(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        this.f18076d = new ArrayDeque();
        this.f18078f = false;
        this.f18073a = context.getApplicationContext();
        this.f18074b = new Intent(str).setPackage(this.f18073a.getPackageName());
        this.f18075c = scheduledExecutorService;
    }

    /* renamed from: a */
    public final synchronized void m22720a(Intent intent, PendingResult pendingResult) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "new intent queued in the bind-strategy delivery");
        }
        this.f18076d.add(new ag(intent, pendingResult, this.f18075c));
        m22718a();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private final synchronized void m22718a() {
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
        r0 = r5.f18076d;	 Catch:{ all -> 0x00a7 }
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
        r0 = r5.f18077e;	 Catch:{ all -> 0x00a7 }
        if (r0 == 0) goto L_0x0051;
    L_0x002c:
        r0 = r5.f18077e;	 Catch:{ all -> 0x00a7 }
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
        r0 = r5.f18076d;	 Catch:{ all -> 0x00a7 }
        r0 = r0.poll();	 Catch:{ all -> 0x00a7 }
        r0 = (com.google.firebase.iid.ag) r0;	 Catch:{ all -> 0x00a7 }
        r2 = r5.f18077e;	 Catch:{ all -> 0x00a7 }
        r2.m22717a(r0);	 Catch:{ all -> 0x00a7 }
        goto L_0x0011;
    L_0x0051:
        r0 = "EnhancedIntentService";
        r0 = android.util.Log.isLoggable(r0, r1);	 Catch:{ all -> 0x00a7 }
        r1 = 1;
        if (r0 == 0) goto L_0x0075;
    L_0x005a:
        r0 = "EnhancedIntentService";
        r2 = r5.f18078f;	 Catch:{ all -> 0x00a7 }
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
        r0 = r5.f18078f;	 Catch:{ all -> 0x00a7 }
        if (r0 != 0) goto L_0x00a3;
    L_0x0079:
        r5.f18078f = r1;	 Catch:{ all -> 0x00a7 }
        r0 = com.google.android.gms.common.stats.C2882a.a();	 Catch:{ SecurityException -> 0x0095 }
        r1 = r5.f18073a;	 Catch:{ SecurityException -> 0x0095 }
        r2 = r5.f18074b;	 Catch:{ SecurityException -> 0x0095 }
        r3 = 65;
        r0 = r0.a(r1, r2, r5, r3);	 Catch:{ SecurityException -> 0x0095 }
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
        r5.f18078f = r0;	 Catch:{ all -> 0x00a7 }
        r5.m22719b();	 Catch:{ all -> 0x00a7 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.ak.a():void");
    }

    /* renamed from: b */
    private final void m22719b() {
        while (!this.f18076d.isEmpty()) {
            ((ag) this.f18076d.poll()).m22715a();
        }
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this) {
            this.f18078f = false;
            this.f18077e = (ai) iBinder;
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                componentName = String.valueOf(componentName);
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(componentName).length() + 20);
                stringBuilder.append("onServiceConnected: ");
                stringBuilder.append(componentName);
                Log.d("EnhancedIntentService", stringBuilder.toString());
            }
            if (iBinder == null) {
                Log.e("EnhancedIntentService", "Null service connection");
                m22719b();
            } else {
                m22718a();
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
        m22718a();
    }
}
