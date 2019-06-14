package com.google.android.gms.p186f;

import java.util.ArrayDeque;
import java.util.Queue;

/* renamed from: com.google.android.gms.f.x */
final class C2966x<TResult> {
    /* renamed from: a */
    private final Object f7606a = new Object();
    /* renamed from: b */
    private Queue<C2965w<TResult>> f7607b;
    /* renamed from: c */
    private boolean f7608c;

    C2966x() {
    }

    /* renamed from: a */
    public final void m8797a(C2965w<TResult> c2965w) {
        synchronized (this.f7606a) {
            if (this.f7607b == null) {
                this.f7607b = new ArrayDeque();
            }
            this.f7607b.add(c2965w);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void m8796a(com.google.android.gms.p186f.C2954g<TResult> r3) {
        /*
        r2 = this;
        r0 = r2.f7606a;
        monitor-enter(r0);
        r1 = r2.f7607b;	 Catch:{ all -> 0x002c }
        if (r1 == 0) goto L_0x002a;
    L_0x0007:
        r1 = r2.f7608c;	 Catch:{ all -> 0x002c }
        if (r1 == 0) goto L_0x000c;
    L_0x000b:
        goto L_0x002a;
    L_0x000c:
        r1 = 1;
        r2.f7608c = r1;	 Catch:{ all -> 0x002c }
        monitor-exit(r0);	 Catch:{ all -> 0x002c }
    L_0x0010:
        r1 = r2.f7606a;
        monitor-enter(r1);
        r0 = r2.f7607b;	 Catch:{ all -> 0x0027 }
        r0 = r0.poll();	 Catch:{ all -> 0x0027 }
        r0 = (com.google.android.gms.p186f.C2965w) r0;	 Catch:{ all -> 0x0027 }
        if (r0 != 0) goto L_0x0022;
    L_0x001d:
        r3 = 0;
        r2.f7608c = r3;	 Catch:{ all -> 0x0027 }
        monitor-exit(r1);	 Catch:{ all -> 0x0027 }
        return;
    L_0x0022:
        monitor-exit(r1);	 Catch:{ all -> 0x0027 }
        r0.mo2574a(r3);
        goto L_0x0010;
    L_0x0027:
        r3 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0027 }
        throw r3;
    L_0x002a:
        monitor-exit(r0);	 Catch:{ all -> 0x002c }
        return;
    L_0x002c:
        r3 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x002c }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.f.x.a(com.google.android.gms.f.g):void");
    }
}
