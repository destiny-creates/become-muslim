package com.google.android.gms.iid;

final /* synthetic */ class ag implements Runnable {
    /* renamed from: a */
    private final ad f7814a;

    ag(ad adVar) {
        this.f7814a = adVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r8 = this;
        r0 = r8.f7814a;
    L_0x0002:
        monitor-enter(r0);
        r1 = r0.f7806a;	 Catch:{ all -> 0x00c7 }
        r2 = 2;
        if (r1 == r2) goto L_0x000a;
    L_0x0008:
        monitor-exit(r0);	 Catch:{ all -> 0x00c7 }
        return;
    L_0x000a:
        r1 = r0.f7809d;	 Catch:{ all -> 0x00c7 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x00c7 }
        if (r1 == 0) goto L_0x0017;
    L_0x0012:
        r0.m8947a();	 Catch:{ all -> 0x00c7 }
        monitor-exit(r0);	 Catch:{ all -> 0x00c7 }
        return;
    L_0x0017:
        r1 = r0.f7809d;	 Catch:{ all -> 0x00c7 }
        r1 = r1.poll();	 Catch:{ all -> 0x00c7 }
        r1 = (com.google.android.gms.iid.aj) r1;	 Catch:{ all -> 0x00c7 }
        r3 = r0.f7810e;	 Catch:{ all -> 0x00c7 }
        r4 = r1.f7819a;	 Catch:{ all -> 0x00c7 }
        r3.put(r4, r1);	 Catch:{ all -> 0x00c7 }
        r3 = r0.f7811f;	 Catch:{ all -> 0x00c7 }
        r3 = r3.f7803b;	 Catch:{ all -> 0x00c7 }
        r4 = new com.google.android.gms.iid.ah;	 Catch:{ all -> 0x00c7 }
        r4.<init>(r0, r1);	 Catch:{ all -> 0x00c7 }
        r5 = 30;
        r7 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ all -> 0x00c7 }
        r3.schedule(r4, r5, r7);	 Catch:{ all -> 0x00c7 }
        monitor-exit(r0);	 Catch:{ all -> 0x00c7 }
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
        r3 = r0.f7811f;
        r3 = r3.f7802a;
        r4 = r0.f7807b;
        r5 = android.os.Message.obtain();
        r6 = r1.f7821c;
        r5.what = r6;
        r6 = r1.f7819a;
        r5.arg1 = r6;
        r5.replyTo = r4;
        r4 = new android.os.Bundle;
        r4.<init>();
        r6 = "oneWay";
        r7 = r1.mo2603a();
        r4.putBoolean(r6, r7);
        r6 = "pkg";
        r3 = r3.getPackageName();
        r4.putString(r6, r3);
        r3 = "data";
        r1 = r1.f7822d;
        r4.putBundle(r3, r1);
        r5.setData(r4);
        r1 = r0.f7808c;	 Catch:{ RemoteException -> 0x00bd }
        r3 = r1.f7817a;	 Catch:{ RemoteException -> 0x00bd }
        if (r3 == 0) goto L_0x00aa;
    L_0x00a3:
        r1 = r1.f7817a;	 Catch:{ RemoteException -> 0x00bd }
        r1.send(r5);	 Catch:{ RemoteException -> 0x00bd }
        goto L_0x0002;
    L_0x00aa:
        r3 = r1.f7818b;	 Catch:{ RemoteException -> 0x00bd }
        if (r3 == 0) goto L_0x00b5;
    L_0x00ae:
        r1 = r1.f7818b;	 Catch:{ RemoteException -> 0x00bd }
        r1.m14712a(r5);	 Catch:{ RemoteException -> 0x00bd }
        goto L_0x0002;
    L_0x00b5:
        r1 = new java.lang.IllegalStateException;	 Catch:{ RemoteException -> 0x00bd }
        r3 = "Both messengers are null";
        r1.<init>(r3);	 Catch:{ RemoteException -> 0x00bd }
        throw r1;	 Catch:{ RemoteException -> 0x00bd }
    L_0x00bd:
        r1 = move-exception;
        r1 = r1.getMessage();
        r0.m8949a(r2, r1);
        goto L_0x0002;
    L_0x00c7:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x00c7 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.iid.ag.run():void");
    }
}
