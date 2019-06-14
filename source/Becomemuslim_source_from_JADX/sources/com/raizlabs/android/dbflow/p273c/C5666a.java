package com.raizlabs.android.dbflow.p273c;

import com.amplitude.api.Constants;
import com.raizlabs.android.dbflow.p273c.p274a.C5664b;
import com.raizlabs.android.dbflow.p273c.p274a.C5665d;
import com.raizlabs.android.dbflow.p281e.C5698h;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DBBatchSaveQueue */
/* renamed from: com.raizlabs.android.dbflow.c.a */
public class C5666a extends Thread {
    /* renamed from: c */
    private static C5666a f18925c;
    /* renamed from: a */
    private int f18926a = 50;
    /* renamed from: b */
    private long f18927b = Constants.EVENT_UPLOAD_PERIOD_MILLIS;
    /* renamed from: d */
    private final ArrayList<C5698h> f18928d = new ArrayList();
    /* renamed from: e */
    private boolean f18929e = false;
    /* renamed from: f */
    private boolean f18930f = true;
    /* renamed from: g */
    private C5667b f18931g = C5667b.m24036a("Batch Saving Models");
    /* renamed from: h */
    private C5665d<List<C5698h>> f18932h;
    /* renamed from: i */
    private final C5665d<List<C5698h>> f18933i = new C71141(this);

    /* compiled from: DBBatchSaveQueue */
    /* renamed from: com.raizlabs.android.dbflow.c.a$1 */
    class C71141 implements C5665d<List<C5698h>> {
        /* renamed from: a */
        final /* synthetic */ C5666a f25253a;

        C71141(C5666a c5666a) {
            this.f25253a = c5666a;
        }

        /* renamed from: a */
        public void m33131a(List<C5698h> list) {
            if (this.f25253a.f18932h != null) {
                this.f25253a.f18932h.mo5042a((Object) list);
            }
            if (this.f25253a.f18930f != null) {
                synchronized (this.f25253a.f18928d) {
                    if (this.f25253a.f18928d.size() < 50) {
                        this.f25253a.m24034b();
                    }
                }
            }
        }

        /* renamed from: a */
        public boolean mo5043a(C5664b<List<C5698h>> c5664b) {
            if (this.f25253a.f18932h != null) {
                this.f25253a.f18932h.mo5043a((C5664b) c5664b);
            }
            return true;
        }

        /* renamed from: a */
        public boolean m33134a(C5664b<List<C5698h>> c5664b, List<C5698h> list) {
            if (this.f25253a.f18932h != null) {
                this.f25253a.f18932h.mo5044a(c5664b, list);
            }
            return true;
        }
    }

    private C5666a() {
        super("DBBatchSaveQueue");
    }

    /* renamed from: a */
    public static C5666a m24030a() {
        if (f18925c == null) {
            f18925c = new C5666a();
        }
        return f18925c;
    }

    public void run() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        super.run();
        android.os.Looper.prepare();
        r0 = 10;
        android.os.Process.setThreadPriority(r0);
    L_0x000b:
        r0 = r4.f18928d;
        monitor-enter(r0);
        r1 = new java.util.ArrayList;	 Catch:{ all -> 0x004f }
        r2 = r4.f18928d;	 Catch:{ all -> 0x004f }
        r1.<init>(r2);	 Catch:{ all -> 0x004f }
        r2 = r4.f18928d;	 Catch:{ all -> 0x004f }
        r2.clear();	 Catch:{ all -> 0x004f }
        monitor-exit(r0);	 Catch:{ all -> 0x004f }
        r0 = r1.size();
        if (r0 <= 0) goto L_0x003d;
    L_0x0021:
        r0 = com.raizlabs.android.dbflow.p273c.C5673e.m24047c();
        r2 = new com.raizlabs.android.dbflow.c.a.a.e;
        r1 = com.raizlabs.android.dbflow.p273c.p274a.p275a.C5662c.m24013a(r1);
        r3 = r4.f18933i;
        r1 = r1.m24014a(r3);
        r3 = r4.f18931g;
        r1 = r1.m24015a(r3);
        r2.<init>(r1);
        r0.m24049a(r2);
    L_0x003d:
        r0 = r4.f18927b;	 Catch:{ InterruptedException -> 0x0043 }
        java.lang.Thread.sleep(r0);	 Catch:{ InterruptedException -> 0x0043 }
        goto L_0x004a;
    L_0x0043:
        r0 = com.raizlabs.android.dbflow.config.C5679e.C5678a.I;
        r1 = "DBRequestQueue Batch interrupted to start saving";
        com.raizlabs.android.dbflow.config.C5679e.m24075a(r0, r1);
    L_0x004a:
        r0 = r4.f18929e;
        if (r0 == 0) goto L_0x000b;
    L_0x004e:
        return;
    L_0x004f:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x004f }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.raizlabs.android.dbflow.c.a.run():void");
    }

    /* renamed from: b */
    public void m24034b() {
        interrupt();
    }

    /* renamed from: a */
    public void m24033a(C5698h c5698h) {
        synchronized (this.f18928d) {
            this.f18928d.add(c5698h);
            if (this.f18928d.size() > this.f18926a) {
                interrupt();
            }
        }
    }
}
