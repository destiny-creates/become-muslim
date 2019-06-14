package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.stats.C2882a;
import com.google.android.gms.internal.p207f.C4964a;
import java.util.ArrayDeque;
import java.util.Queue;

/* renamed from: com.google.firebase.iid.g */
final class C5358g implements ServiceConnection {
    /* renamed from: a */
    int f18099a;
    /* renamed from: b */
    final Messenger f18100b;
    /* renamed from: c */
    C5363l f18101c;
    /* renamed from: d */
    final Queue<C5364n<?>> f18102d;
    /* renamed from: e */
    final SparseArray<C5364n<?>> f18103e;
    /* renamed from: f */
    final /* synthetic */ C5356e f18104f;

    private C5358g(C5356e c5356e) {
        this.f18104f = c5356e;
        this.f18099a = null;
        this.f18100b = new Messenger(new C4964a(Looper.getMainLooper(), new C5359h(this)));
        this.f18102d = new ArrayDeque();
        this.f18103e = new SparseArray();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    final synchronized boolean m22770a(com.google.firebase.iid.C5364n r6) {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = r5.f18099a;	 Catch:{ all -> 0x008e }
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
        r0 = r5.f18102d;	 Catch:{ all -> 0x008e }
        r0.add(r6);	 Catch:{ all -> 0x008e }
        r5.m22765c();	 Catch:{ all -> 0x008e }
        monitor-exit(r5);
        return r2;
    L_0x0017:
        r0 = r5.f18102d;	 Catch:{ all -> 0x008e }
        r0.add(r6);	 Catch:{ all -> 0x008e }
        monitor-exit(r5);
        return r2;
    L_0x001e:
        r0 = r5.f18102d;	 Catch:{ all -> 0x008e }
        r0.add(r6);	 Catch:{ all -> 0x008e }
        r6 = r5.f18099a;	 Catch:{ all -> 0x008e }
        if (r6 != 0) goto L_0x0029;
    L_0x0027:
        r6 = 1;
        goto L_0x002a;
    L_0x0029:
        r6 = 0;
    L_0x002a:
        com.google.android.gms.common.internal.C2872v.a(r6);	 Catch:{ all -> 0x008e }
        r6 = "MessengerIpcClient";
        r0 = 2;
        r6 = android.util.Log.isLoggable(r6, r0);	 Catch:{ all -> 0x008e }
        if (r6 == 0) goto L_0x003d;
    L_0x0036:
        r6 = "MessengerIpcClient";
        r0 = "Starting bind to GmsCore";
        android.util.Log.v(r6, r0);	 Catch:{ all -> 0x008e }
    L_0x003d:
        r5.f18099a = r2;	 Catch:{ all -> 0x008e }
        r6 = new android.content.Intent;	 Catch:{ all -> 0x008e }
        r0 = "com.google.android.c2dm.intent.REGISTER";
        r6.<init>(r0);	 Catch:{ all -> 0x008e }
        r0 = "com.google.android.gms";
        r6.setPackage(r0);	 Catch:{ all -> 0x008e }
        r0 = com.google.android.gms.common.stats.C2882a.a();	 Catch:{ all -> 0x008e }
        r3 = r5.f18104f;	 Catch:{ all -> 0x008e }
        r3 = r3.f18095b;	 Catch:{ all -> 0x008e }
        r6 = r0.a(r3, r6, r5, r2);	 Catch:{ all -> 0x008e }
        if (r6 != 0) goto L_0x0061;
    L_0x005b:
        r6 = "Unable to bind to service";
        r5.m22768a(r1, r6);	 Catch:{ all -> 0x008e }
        goto L_0x0073;
    L_0x0061:
        r6 = r5.f18104f;	 Catch:{ all -> 0x008e }
        r6 = r6.f18096c;	 Catch:{ all -> 0x008e }
        r0 = new com.google.firebase.iid.i;	 Catch:{ all -> 0x008e }
        r0.<init>(r5);	 Catch:{ all -> 0x008e }
        r3 = 30;
        r1 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ all -> 0x008e }
        r6.schedule(r0, r3, r1);	 Catch:{ all -> 0x008e }
    L_0x0073:
        monitor-exit(r5);
        return r2;
    L_0x0075:
        r0 = r5.f18099a;	 Catch:{ all -> 0x008e }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.g.a(com.google.firebase.iid.n):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    final boolean m22769a(android.os.Message r5) {
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
        r1 = r4.f18103e;	 Catch:{ all -> 0x006f }
        r1 = r1.get(r0);	 Catch:{ all -> 0x006f }
        r1 = (com.google.firebase.iid.C5364n) r1;	 Catch:{ all -> 0x006f }
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
        r3 = r4.f18103e;	 Catch:{ all -> 0x006f }
        r3.remove(r0);	 Catch:{ all -> 0x006f }
        r4.m22766a();	 Catch:{ all -> 0x006f }
        monitor-exit(r4);	 Catch:{ all -> 0x006f }
        r5 = r5.getData();
        r0 = "unsupported";
        r3 = 0;
        r0 = r5.getBoolean(r0, r3);
        if (r0 == 0) goto L_0x006b;
    L_0x005f:
        r5 = new com.google.firebase.iid.o;
        r0 = 4;
        r3 = "Not supported by GmsCore";
        r5.<init>(r0, r3);
        r1.m22774a(r5);
        goto L_0x006e;
    L_0x006b:
        r1.mo4894a(r5);
    L_0x006e:
        return r2;
    L_0x006f:
        r5 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x006f }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.g.a(android.os.Message):boolean");
    }

    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2) != null) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        if (iBinder == null) {
            m22768a(0, "Null service connection");
            return;
        }
        try {
            this.f18101c = new C5363l(iBinder);
            this.f18099a = 2;
            m22765c();
        } catch (IBinder iBinder2) {
            m22768a(0, iBinder2.getMessage());
        }
    }

    /* renamed from: c */
    private final void m22765c() {
        this.f18104f.f18096c.execute(new C5361j(this));
    }

    public final synchronized void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2) != null) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        m22768a(2, "Service disconnected");
    }

    /* renamed from: a */
    final synchronized void m22768a(int i, String str) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String str2 = "MessengerIpcClient";
            String str3 = "Disconnected: ";
            String valueOf = String.valueOf(str);
            Log.d(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        }
        switch (this.f18099a) {
            case 0:
                throw new IllegalStateException();
            case 1:
            case 2:
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Unbinding service");
                }
                this.f18099a = 4;
                C2882a.a().a(this.f18104f.f18095b, this);
                C5365o c5365o = new C5365o(i, str);
                for (C5364n a : this.f18102d) {
                    a.m22774a(c5365o);
                }
                this.f18102d.clear();
                for (i = 0; i < this.f18103e.size(); i++) {
                    ((C5364n) this.f18103e.valueAt(i)).m22774a(c5365o);
                }
                this.f18103e.clear();
                return;
            case 3:
                this.f18099a = 4;
                return;
            case 4:
                return;
            default:
                str = this.f18099a;
                StringBuilder stringBuilder = new StringBuilder(26);
                stringBuilder.append("Unknown state: ");
                stringBuilder.append(str);
                throw new IllegalStateException(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    final synchronized void m22766a() {
        if (this.f18099a == 2 && this.f18102d.isEmpty() && this.f18103e.size() == 0) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
            }
            this.f18099a = 3;
            C2882a.a().a(this.f18104f.f18095b, this);
        }
    }

    /* renamed from: b */
    final synchronized void m22771b() {
        if (this.f18099a == 1) {
            m22768a(1, "Timed out while binding");
        }
    }

    /* renamed from: a */
    final synchronized void m22767a(int i) {
        C5364n c5364n = (C5364n) this.f18103e.get(i);
        if (c5364n != null) {
            StringBuilder stringBuilder = new StringBuilder(31);
            stringBuilder.append("Timing out request: ");
            stringBuilder.append(i);
            Log.w("MessengerIpcClient", stringBuilder.toString());
            this.f18103e.remove(i);
            c5364n.m22774a(new C5365o(3, "Timed out waiting for response"));
            m22766a();
        }
    }
}
