package com.google.firebase.iid;

/* renamed from: com.google.firebase.iid.j */
final /* synthetic */ class C5361j implements Runnable {
    /* renamed from: a */
    private final C5358g f18107a;

    C5361j(C5358g c5358g) {
        this.f18107a = c5358g;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r8 = this;
        r0 = r8.f18107a;
    L_0x0002:
        monitor-enter(r0);
        r1 = r0.f18099a;	 Catch:{ all -> 0x00ae }
        r2 = 2;
        if (r1 == r2) goto L_0x000a;
    L_0x0008:
        monitor-exit(r0);	 Catch:{ all -> 0x00ae }
        return;
    L_0x000a:
        r1 = r0.f18102d;	 Catch:{ all -> 0x00ae }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x00ae }
        if (r1 == 0) goto L_0x0017;
    L_0x0012:
        r0.m22766a();	 Catch:{ all -> 0x00ae }
        monitor-exit(r0);	 Catch:{ all -> 0x00ae }
        return;
    L_0x0017:
        r1 = r0.f18102d;	 Catch:{ all -> 0x00ae }
        r1 = r1.poll();	 Catch:{ all -> 0x00ae }
        r1 = (com.google.firebase.iid.C5364n) r1;	 Catch:{ all -> 0x00ae }
        r3 = r0.f18103e;	 Catch:{ all -> 0x00ae }
        r4 = r1.f18112a;	 Catch:{ all -> 0x00ae }
        r3.put(r4, r1);	 Catch:{ all -> 0x00ae }
        r3 = r0.f18104f;	 Catch:{ all -> 0x00ae }
        r3 = r3.f18096c;	 Catch:{ all -> 0x00ae }
        r4 = new com.google.firebase.iid.k;	 Catch:{ all -> 0x00ae }
        r4.<init>(r0, r1);	 Catch:{ all -> 0x00ae }
        r5 = 30;
        r7 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ all -> 0x00ae }
        r3.schedule(r4, r5, r7);	 Catch:{ all -> 0x00ae }
        monitor-exit(r0);	 Catch:{ all -> 0x00ae }
        r3 = "MessengerIpcClient";
        r4 = 3;
        r3 = android.util.Log.isLoggable(r3, r4);
        if (r3 == 0) goto L_0x0066;
    L_0x0042:
        r3 = "MessengerIpcClient";
        r4 = java.lang.String.valueOf(r1);
        r5 = java.lang.String.valueOf(r4);
        r5 = r5.length();
        r5 = r5 + 8;
        r6 = new java.lang.StringBuilder;
        r6.<init>(r5);
        r5 = "Sending ";
        r6.append(r5);
        r6.append(r4);
        r4 = r6.toString();
        android.util.Log.d(r3, r4);
    L_0x0066:
        r3 = r0.f18104f;
        r3 = r3.f18095b;
        r4 = r0.f18100b;
        r5 = android.os.Message.obtain();
        r6 = r1.f18114c;
        r5.what = r6;
        r6 = r1.f18112a;
        r5.arg1 = r6;
        r5.replyTo = r4;
        r4 = new android.os.Bundle;
        r4.<init>();
        r6 = "oneWay";
        r7 = r1.mo4895a();
        r4.putBoolean(r6, r7);
        r6 = "pkg";
        r3 = r3.getPackageName();
        r4.putString(r6, r3);
        r3 = "data";
        r1 = r1.f18115d;
        r4.putBundle(r3, r1);
        r5.setData(r4);
        r1 = r0.f18101c;	 Catch:{ RemoteException -> 0x00a4 }
        r1.m22772a(r5);	 Catch:{ RemoteException -> 0x00a4 }
        goto L_0x0002;
    L_0x00a4:
        r1 = move-exception;
        r1 = r1.getMessage();
        r0.m22768a(r2, r1);
        goto L_0x0002;
    L_0x00ae:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x00ae }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.j.run():void");
    }
}
