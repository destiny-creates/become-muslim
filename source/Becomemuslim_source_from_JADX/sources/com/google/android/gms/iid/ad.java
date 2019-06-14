package com.google.android.gms.iid;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.stats.C2882a;
import com.google.android.gms.internal.p209h.C4982g;
import java.util.ArrayDeque;
import java.util.Queue;

final class ad implements ServiceConnection {
    /* renamed from: a */
    int f7806a;
    /* renamed from: b */
    final Messenger f7807b;
    /* renamed from: c */
    ai f7808c;
    /* renamed from: d */
    final Queue<aj<?>> f7809d;
    /* renamed from: e */
    final SparseArray<aj<?>> f7810e;
    /* renamed from: f */
    final /* synthetic */ ab f7811f;

    private ad(ab abVar) {
        this.f7811f = abVar;
        this.f7806a = null;
        this.f7807b = new Messenger(new C4982g(Looper.getMainLooper(), new ae(this)));
        this.f7809d = new ArrayDeque();
        this.f7810e = new SparseArray();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    final synchronized boolean m8951a(com.google.android.gms.iid.aj r6) {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = r5.f7806a;	 Catch:{ all -> 0x008e }
        r1 = 0;
        r2 = 1;
        switch(r0) {
            case 0: goto L_0x001e;
            case 1: goto L_0x0017;
            case 2: goto L_0x000d;
            case 3: goto L_0x000b;
            case 4: goto L_0x000b;
            default: goto L_0x0008;
        };	 Catch:{ all -> 0x008e }
    L_0x0008:
        r6 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x008e }
        goto L_0x0075;
    L_0x000b:
        monitor-exit(r5);
        return r1;
    L_0x000d:
        r0 = r5.f7809d;	 Catch:{ all -> 0x008e }
        r0.add(r6);	 Catch:{ all -> 0x008e }
        r5.m8946c();	 Catch:{ all -> 0x008e }
        monitor-exit(r5);
        return r2;
    L_0x0017:
        r0 = r5.f7809d;	 Catch:{ all -> 0x008e }
        r0.add(r6);	 Catch:{ all -> 0x008e }
        monitor-exit(r5);
        return r2;
    L_0x001e:
        r0 = r5.f7809d;	 Catch:{ all -> 0x008e }
        r0.add(r6);	 Catch:{ all -> 0x008e }
        r6 = r5.f7806a;	 Catch:{ all -> 0x008e }
        if (r6 != 0) goto L_0x0029;
    L_0x0027:
        r6 = 1;
        goto L_0x002a;
    L_0x0029:
        r6 = 0;
    L_0x002a:
        com.google.android.gms.common.internal.C2872v.m8386a(r6);	 Catch:{ all -> 0x008e }
        r6 = "MessengerIpcClient";
        r0 = 2;
        r6 = android.util.Log.isLoggable(r6, r0);	 Catch:{ all -> 0x008e }
        if (r6 == 0) goto L_0x003d;
    L_0x0036:
        r6 = "MessengerIpcClient";
        r0 = "Starting bind to GmsCore";
        android.util.Log.v(r6, r0);	 Catch:{ all -> 0x008e }
    L_0x003d:
        r5.f7806a = r2;	 Catch:{ all -> 0x008e }
        r6 = new android.content.Intent;	 Catch:{ all -> 0x008e }
        r0 = "com.google.android.c2dm.intent.REGISTER";
        r6.<init>(r0);	 Catch:{ all -> 0x008e }
        r0 = "com.google.android.gms";
        r6.setPackage(r0);	 Catch:{ all -> 0x008e }
        r0 = com.google.android.gms.common.stats.C2882a.m8407a();	 Catch:{ all -> 0x008e }
        r3 = r5.f7811f;	 Catch:{ all -> 0x008e }
        r3 = r3.f7802a;	 Catch:{ all -> 0x008e }
        r6 = r0.m8409a(r3, r6, r5, r2);	 Catch:{ all -> 0x008e }
        if (r6 != 0) goto L_0x0061;
    L_0x005b:
        r6 = "Unable to bind to service";
        r5.m8949a(r1, r6);	 Catch:{ all -> 0x008e }
        goto L_0x0073;
    L_0x0061:
        r6 = r5.f7811f;	 Catch:{ all -> 0x008e }
        r6 = r6.f7803b;	 Catch:{ all -> 0x008e }
        r0 = new com.google.android.gms.iid.af;	 Catch:{ all -> 0x008e }
        r0.<init>(r5);	 Catch:{ all -> 0x008e }
        r3 = 30;
        r1 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ all -> 0x008e }
        r6.schedule(r0, r3, r1);	 Catch:{ all -> 0x008e }
    L_0x0073:
        monitor-exit(r5);
        return r2;
    L_0x0075:
        r0 = r5.f7806a;	 Catch:{ all -> 0x008e }
        r1 = 26;
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008e }
        r2.<init>(r1);	 Catch:{ all -> 0x008e }
        r1 = "Unknown state: ";
        r2.append(r1);	 Catch:{ all -> 0x008e }
        r2.append(r0);	 Catch:{ all -> 0x008e }
        r0 = r2.toString();	 Catch:{ all -> 0x008e }
        r6.<init>(r0);	 Catch:{ all -> 0x008e }
        throw r6;	 Catch:{ all -> 0x008e }
    L_0x008e:
        r6 = move-exception;
        monitor-exit(r5);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.iid.ad.a(com.google.android.gms.iid.aj):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    final boolean m8950a(android.os.Message r5) {
        /*
        r4 = this;
        r0 = r5.arg1;
        r1 = "MessengerIpcClient";
        r2 = 3;
        r1 = android.util.Log.isLoggable(r1, r2);
        if (r1 == 0) goto L_0x0023;
    L_0x000b:
        r1 = "MessengerIpcClient";
        r2 = 41;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r2);
        r2 = "Received response to request: ";
        r3.append(r2);
        r3.append(r0);
        r2 = r3.toString();
        android.util.Log.d(r1, r2);
    L_0x0023:
        monitor-enter(r4);
        r1 = r4.f7810e;	 Catch:{ all -> 0x006f }
        r1 = r1.get(r0);	 Catch:{ all -> 0x006f }
        r1 = (com.google.android.gms.iid.aj) r1;	 Catch:{ all -> 0x006f }
        r2 = 1;
        if (r1 != 0) goto L_0x0049;
    L_0x002f:
        r5 = "MessengerIpcClient";
        r1 = 50;
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x006f }
        r3.<init>(r1);	 Catch:{ all -> 0x006f }
        r1 = "Received response for unknown request: ";
        r3.append(r1);	 Catch:{ all -> 0x006f }
        r3.append(r0);	 Catch:{ all -> 0x006f }
        r0 = r3.toString();	 Catch:{ all -> 0x006f }
        android.util.Log.w(r5, r0);	 Catch:{ all -> 0x006f }
        monitor-exit(r4);	 Catch:{ all -> 0x006f }
        return r2;
    L_0x0049:
        r3 = r4.f7810e;	 Catch:{ all -> 0x006f }
        r3.remove(r0);	 Catch:{ all -> 0x006f }
        r4.m8947a();	 Catch:{ all -> 0x006f }
        monitor-exit(r4);	 Catch:{ all -> 0x006f }
        r5 = r5.getData();
        r0 = "unsupported";
        r3 = 0;
        r0 = r5.getBoolean(r0, r3);
        if (r0 == 0) goto L_0x006b;
    L_0x005f:
        r5 = new com.google.android.gms.iid.c;
        r0 = 4;
        r3 = "Not supported by GmsCore";
        r5.<init>(r0, r3);
        r1.m8954a(r5);
        goto L_0x006e;
    L_0x006b:
        r1.mo2602a(r5);
    L_0x006e:
        return r2;
    L_0x006f:
        r5 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x006f }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.iid.ad.a(android.os.Message):boolean");
    }

    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2) != null) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        if (iBinder == null) {
            m8949a(0, "Null service connection");
            return;
        }
        try {
            this.f7808c = new ai(iBinder);
            this.f7806a = 2;
            m8946c();
        } catch (IBinder iBinder2) {
            m8949a(0, iBinder2.getMessage());
        }
    }

    /* renamed from: c */
    private final void m8946c() {
        this.f7811f.f7803b.execute(new ag(this));
    }

    public final synchronized void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2) != null) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        m8949a(2, "Service disconnected");
    }

    /* renamed from: a */
    final synchronized void m8949a(int i, String str) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String str2 = "MessengerIpcClient";
            String str3 = "Disconnected: ";
            String valueOf = String.valueOf(str);
            Log.d(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        }
        switch (this.f7806a) {
            case 0:
                throw new IllegalStateException();
            case 1:
            case 2:
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Unbinding service");
                }
                this.f7806a = 4;
                C2882a.m8407a().m8408a(this.f7811f.f7802a, this);
                C3061c c3061c = new C3061c(i, str);
                for (aj a : this.f7809d) {
                    a.m8954a(c3061c);
                }
                this.f7809d.clear();
                for (i = 0; i < this.f7810e.size(); i++) {
                    ((aj) this.f7810e.valueAt(i)).m8954a(c3061c);
                }
                this.f7810e.clear();
                return;
            case 3:
                this.f7806a = 4;
                return;
            case 4:
                return;
            default:
                str = this.f7806a;
                StringBuilder stringBuilder = new StringBuilder(26);
                stringBuilder.append("Unknown state: ");
                stringBuilder.append(str);
                throw new IllegalStateException(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    final synchronized void m8947a() {
        if (this.f7806a == 2 && this.f7809d.isEmpty() && this.f7810e.size() == 0) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
            }
            this.f7806a = 3;
            C2882a.m8407a().m8408a(this.f7811f.f7802a, this);
        }
    }

    /* renamed from: b */
    final synchronized void m8952b() {
        if (this.f7806a == 1) {
            m8949a(1, "Timed out while binding");
        }
    }

    /* renamed from: a */
    final synchronized void m8948a(int i) {
        aj ajVar = (aj) this.f7810e.get(i);
        if (ajVar != null) {
            StringBuilder stringBuilder = new StringBuilder(31);
            stringBuilder.append("Timing out request: ");
            stringBuilder.append(i);
            Log.w("MessengerIpcClient", stringBuilder.toString());
            this.f7810e.remove(i);
            ajVar.m8954a(new C3061c(3, "Timed out waiting for response"));
            m8947a();
        }
    }
}
