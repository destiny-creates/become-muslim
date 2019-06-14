package com.facebook.ads.internal.p101p.p103b;

import android.util.Log;
import java.lang.Thread.State;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.facebook.ads.internal.p.b.k */
class C1476k {
    /* renamed from: a */
    private final C1479n f4346a;
    /* renamed from: b */
    private final C1461a f4347b;
    /* renamed from: c */
    private final Object f4348c = new Object();
    /* renamed from: d */
    private final Object f4349d = new Object();
    /* renamed from: e */
    private final AtomicInteger f4350e;
    /* renamed from: f */
    private volatile Thread f4351f;
    /* renamed from: g */
    private volatile boolean f4352g;
    /* renamed from: h */
    private volatile int f4353h = -1;

    /* renamed from: com.facebook.ads.internal.p.b.k$a */
    private class C1475a implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C1476k f4345a;

        private C1475a(C1476k c1476k) {
            this.f4345a = c1476k;
        }

        public void run() {
            this.f4345a.m5218e();
        }
    }

    public C1476k(C1479n c1479n, C1461a c1461a) {
        this.f4346a = (C1479n) C1473j.m5210a(c1479n);
        this.f4347b = (C1461a) C1473j.m5210a(c1461a);
        this.f4350e = new AtomicInteger();
    }

    /* renamed from: b */
    private void m5214b() {
        int i = this.f4350e.get();
        if (i >= 1) {
            this.f4350e.set(0);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error reading source ");
            stringBuilder.append(i);
            stringBuilder.append(" times");
            throw new C1477l(stringBuilder.toString());
        }
    }

    /* renamed from: b */
    private void m5215b(long j, long j2) {
        m5225a(j, j2);
        synchronized (this.f4348c) {
            this.f4348c.notifyAll();
        }
    }

    /* renamed from: c */
    private synchronized void m5216c() {
        Object obj = (this.f4351f == null || this.f4351f.getState() == State.TERMINATED) ? null : 1;
        if (!(this.f4352g || this.f4347b.mo987d() || obj != null)) {
            Runnable c1475a = new C1475a();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Source reader for ");
            stringBuilder.append(this.f4346a);
            this.f4351f = new Thread(c1475a, stringBuilder.toString());
            this.f4351f.start();
        }
    }

    /* renamed from: d */
    private void m5217d() {
        synchronized (this.f4348c) {
            try {
                this.f4348c.wait(1000);
            } catch (Throwable e) {
                throw new C1477l("Waiting source data is interrupted!", e);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: e */
    private void m5218e() {
        /*
        r9 = this;
        r0 = -1;
        r1 = 0;
        r2 = r9.f4347b;	 Catch:{ Throwable -> 0x0062, all -> 0x005d }
        r2 = r2.mo982a();	 Catch:{ Throwable -> 0x0062, all -> 0x005d }
        r1 = r9.f4346a;	 Catch:{ Throwable -> 0x0059, all -> 0x0055 }
        r1.mo994a(r2);	 Catch:{ Throwable -> 0x0059, all -> 0x0055 }
        r1 = r9.f4346a;	 Catch:{ Throwable -> 0x0059, all -> 0x0055 }
        r1 = r1.mo992a();	 Catch:{ Throwable -> 0x0059, all -> 0x0055 }
        r3 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r3 = new byte[r3];	 Catch:{ Throwable -> 0x0050, all -> 0x004e }
    L_0x0017:
        r4 = r9.f4346a;	 Catch:{ Throwable -> 0x0050, all -> 0x004e }
        r4 = r4.mo993a(r3);	 Catch:{ Throwable -> 0x0050, all -> 0x004e }
        if (r4 == r0) goto L_0x0042;
    L_0x001f:
        r5 = r9.f4349d;	 Catch:{ Throwable -> 0x0050, all -> 0x004e }
        monitor-enter(r5);	 Catch:{ Throwable -> 0x0050, all -> 0x004e }
        r6 = r9.m5220g();	 Catch:{ all -> 0x003f }
        if (r6 == 0) goto L_0x0032;
    L_0x0028:
        monitor-exit(r5);	 Catch:{ all -> 0x003f }
        r9.m5221h();
        r2 = (long) r2;
        r0 = (long) r1;
        r9.m5215b(r2, r0);
        return;
    L_0x0032:
        r6 = r9.f4347b;	 Catch:{ all -> 0x003f }
        r6.mo984a(r3, r4);	 Catch:{ all -> 0x003f }
        monitor-exit(r5);	 Catch:{ all -> 0x003f }
        r2 = r2 + r4;
        r4 = (long) r2;
        r6 = (long) r1;
        r9.m5215b(r4, r6);	 Catch:{ Throwable -> 0x0050, all -> 0x004e }
        goto L_0x0017;
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x003f }
        throw r0;	 Catch:{ Throwable -> 0x0050, all -> 0x004e }
    L_0x0042:
        r9.m5219f();	 Catch:{ Throwable -> 0x0050, all -> 0x004e }
        r9.m5221h();
        r2 = (long) r2;
        r0 = (long) r1;
        r9.m5215b(r2, r0);
        goto L_0x0075;
    L_0x004e:
        r0 = move-exception;
        goto L_0x007a;
    L_0x0050:
        r0 = move-exception;
        r8 = r2;
        r2 = r1;
        r1 = r8;
        goto L_0x0065;
    L_0x0055:
        r1 = move-exception;
        r0 = r1;
        r1 = -1;
        goto L_0x007a;
    L_0x0059:
        r1 = move-exception;
        r0 = r1;
        r1 = r2;
        goto L_0x0064;
    L_0x005d:
        r2 = move-exception;
        r0 = r2;
        r1 = -1;
        r2 = 0;
        goto L_0x007a;
    L_0x0062:
        r2 = move-exception;
        r0 = r2;
    L_0x0064:
        r2 = -1;
    L_0x0065:
        r3 = r9.f4350e;	 Catch:{ all -> 0x0076 }
        r3.incrementAndGet();	 Catch:{ all -> 0x0076 }
        r9.m5226a(r0);	 Catch:{ all -> 0x0076 }
        r9.m5221h();
        r0 = (long) r1;
        r2 = (long) r2;
        r9.m5215b(r0, r2);
    L_0x0075:
        return;
    L_0x0076:
        r0 = move-exception;
        r8 = r2;
        r2 = r1;
        r1 = r8;
    L_0x007a:
        r9.m5221h();
        r2 = (long) r2;
        r4 = (long) r1;
        r9.m5215b(r2, r4);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.p.b.k.e():void");
    }

    /* renamed from: f */
    private void m5219f() {
        synchronized (this.f4349d) {
            if (!m5220g() && this.f4347b.mo982a() == this.f4346a.mo992a()) {
                this.f4347b.mo986c();
            }
        }
    }

    /* renamed from: g */
    private boolean m5220g() {
        if (!Thread.currentThread().isInterrupted()) {
            if (!this.f4352g) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: h */
    private void m5221h() {
        try {
            this.f4346a.mo995b();
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error closing source ");
            stringBuilder.append(this.f4346a);
            m5226a(new C1477l(stringBuilder.toString(), e));
        }
    }

    /* renamed from: a */
    public int m5222a(byte[] bArr, long j, int i) {
        C1478m.m5230a(bArr, j, i);
        while (!this.f4347b.mo987d() && ((long) this.f4347b.mo982a()) < ((long) i) + j && !this.f4352g) {
            m5216c();
            m5217d();
            m5214b();
        }
        int a = this.f4347b.mo983a(bArr, j, i);
        if (this.f4347b.mo987d() && this.f4353h != 100) {
            this.f4353h = 100;
            mo990a(100);
        }
        return a;
    }

    /* renamed from: a */
    public void m5223a() {
        synchronized (this.f4349d) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Shutdown proxy for ");
            stringBuilder.append(this.f4346a);
            Log.d("ProxyCache", stringBuilder.toString());
            try {
                this.f4352g = true;
                if (this.f4351f != null) {
                    this.f4351f.interrupt();
                }
                this.f4347b.mo985b();
            } catch (Throwable e) {
                m5226a(e);
            }
        }
    }

    /* renamed from: a */
    protected void mo990a(int i) {
    }

    /* renamed from: a */
    protected void m5225a(long j, long j2) {
        Object obj = null;
        int i = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        int i2 = (i == 0 ? 1 : null) != null ? 100 : (int) ((j * 100) / j2);
        Object obj2 = i2 != this.f4353h ? 1 : null;
        if (i >= 0) {
            obj = 1;
        }
        if (!(obj == null || obj2 == null)) {
            mo990a(i2);
        }
        this.f4353h = i2;
    }

    /* renamed from: a */
    protected final void m5226a(Throwable th) {
        if (th instanceof C3607i) {
            Log.d("ProxyCache", "ProxyCache is interrupted");
        } else {
            Log.e("ProxyCache", "ProxyCache error", th);
        }
    }
}
