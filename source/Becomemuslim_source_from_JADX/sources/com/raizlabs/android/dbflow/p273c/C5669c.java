package com.raizlabs.android.dbflow.p273c;

import com.raizlabs.android.dbflow.p273c.p274a.C5664b;
import java.util.concurrent.PriorityBlockingQueue;

/* compiled from: DBTransactionQueue */
/* renamed from: com.raizlabs.android.dbflow.c.c */
public class C5669c extends Thread {
    /* renamed from: a */
    private final PriorityBlockingQueue<C5664b> f18939a;
    /* renamed from: b */
    private boolean f18940b = null;
    /* renamed from: c */
    private C5673e f18941c;

    public C5669c(String str, C5673e c5673e) {
        super(str);
        this.f18941c = c5673e;
        this.f18939a = new PriorityBlockingQueue();
    }

    public void run() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        android.os.Looper.prepare();
        r0 = 10;
        android.os.Process.setThreadPriority(r0);
    L_0x0008:
        r0 = r4.f18939a;	 Catch:{ InterruptedException -> 0x0039 }
        monitor-enter(r0);	 Catch:{ InterruptedException -> 0x0039 }
        r1 = r4.f18939a;	 Catch:{ all -> 0x0036 }
        r1 = r1.take();	 Catch:{ all -> 0x0036 }
        r1 = (com.raizlabs.android.dbflow.p273c.p274a.C5664b) r1;	 Catch:{ all -> 0x0036 }
        monitor-exit(r0);	 Catch:{ all -> 0x0036 }
        r0 = r1.mo5046a();	 Catch:{ Throwable -> 0x002f }
        if (r0 == 0) goto L_0x0008;	 Catch:{ Throwable -> 0x002f }
    L_0x001a:
        r0 = r1.mo6273b();	 Catch:{ Throwable -> 0x002f }
        r2 = r1.mo5047a(r0);	 Catch:{ Throwable -> 0x002f }
        if (r2 == 0) goto L_0x0008;	 Catch:{ Throwable -> 0x002f }
    L_0x0024:
        r2 = r4.f18941c;	 Catch:{ Throwable -> 0x002f }
        r3 = new com.raizlabs.android.dbflow.c.c$1;	 Catch:{ Throwable -> 0x002f }
        r3.<init>(r4, r1, r0);	 Catch:{ Throwable -> 0x002f }
        r2.m24051a(r3);	 Catch:{ Throwable -> 0x002f }
        goto L_0x0008;
    L_0x002f:
        r0 = move-exception;
        r1 = new java.lang.RuntimeException;
        r1.<init>(r0);
        throw r1;
    L_0x0036:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0036 }
        throw r1;	 Catch:{ InterruptedException -> 0x0039 }
        r0 = r4.f18940b;
        if (r0 == 0) goto L_0x0008;
    L_0x003e:
        r0 = r4.f18939a;
        monitor-enter(r0);
        r1 = r4.f18939a;	 Catch:{ all -> 0x0048 }
        r1.clear();	 Catch:{ all -> 0x0048 }
        monitor-exit(r0);	 Catch:{ all -> 0x0048 }
        return;	 Catch:{ all -> 0x0048 }
    L_0x0048:
        r1 = move-exception;	 Catch:{ all -> 0x0048 }
        monitor-exit(r0);	 Catch:{ all -> 0x0048 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.raizlabs.android.dbflow.c.c.run():void");
    }

    /* renamed from: a */
    public void m24040a(C5664b c5664b) {
        if (!this.f18939a.contains(c5664b)) {
            this.f18939a.add(c5664b);
        }
    }
}
