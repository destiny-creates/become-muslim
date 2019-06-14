package expolib_v1.p321a.p322a.p327e;

import expolib_v1.p332b.C6257r;
import expolib_v1.p332b.C6258s;
import expolib_v1.p332b.C6259t;
import expolib_v1.p332b.C7495a;
import expolib_v1.p332b.C7497e;
import expolib_v1.p332b.C8170c;
import java.io.EOFException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Http2Stream */
/* renamed from: expolib_v1.a.a.e.i */
public final class C6180i {
    /* renamed from: i */
    static final /* synthetic */ boolean f19999i = (C6180i.class.desiredAssertionStatus() ^ 1);
    /* renamed from: a */
    long f20000a = 0;
    /* renamed from: b */
    long f20001b;
    /* renamed from: c */
    final int f20002c;
    /* renamed from: d */
    final C6177g f20003d;
    /* renamed from: e */
    final C7463a f20004e;
    /* renamed from: f */
    final C8167c f20005f = new C8167c(this);
    /* renamed from: g */
    final C8167c f20006g = new C8167c(this);
    /* renamed from: h */
    C6169b f20007h = null;
    /* renamed from: j */
    private final List<C6170c> f20008j;
    /* renamed from: k */
    private List<C6170c> f20009k;
    /* renamed from: l */
    private boolean f20010l;
    /* renamed from: m */
    private final C7464b f20011m;

    /* compiled from: Http2Stream */
    /* renamed from: expolib_v1.a.a.e.i$a */
    final class C7463a implements C6257r {
        /* renamed from: c */
        static final /* synthetic */ boolean f25896c = (C6180i.class.desiredAssertionStatus() ^ 1);
        /* renamed from: a */
        boolean f25897a;
        /* renamed from: b */
        boolean f25898b;
        /* renamed from: d */
        final /* synthetic */ C6180i f25899d;
        /* renamed from: e */
        private final C8170c f25900e = new C8170c();

        C7463a(C6180i c6180i) {
            this.f25899d = c6180i;
        }

        /* renamed from: a */
        public void mo5257a(C8170c c8170c, long j) {
            if (!f25896c) {
                if (Thread.holdsLock(this.f25899d)) {
                    throw new AssertionError();
                }
            }
            this.f25900e.mo5257a(c8170c, j);
            while (this.f25900e.m39582a() >= 16384) {
                m33884a(null);
            }
        }

        /* renamed from: a */
        private void m33884a(boolean z) {
            synchronized (this.f25899d) {
                this.f25899d.f20006g.m34021c();
                while (this.f25899d.f20001b <= 0 && !this.f25898b && !this.f25897a && this.f25899d.f20007h == null) {
                    try {
                        this.f25899d.m25433l();
                    } finally {
                        this.f25899d.f20006g.m39578b();
                    }
                }
                this.f25899d.m25432k();
                long min = Math.min(this.f25899d.f20001b, this.f25900e.m39582a());
                C6180i c6180i = this.f25899d;
                c6180i.f20001b -= min;
            }
            this.f25899d.f20006g.m34021c();
            try {
                C6177g c6177g = this.f25899d.f20003d;
                int i = this.f25899d.f20002c;
                boolean z2 = z && min == this.f25900e.m39582a();
                c6177g.m25375a(i, z2, this.f25900e, min);
            } finally {
                this.f25899d.f20006g.m39578b();
            }
        }

        public void flush() {
            if (!f25896c) {
                if (Thread.holdsLock(this.f25899d)) {
                    throw new AssertionError();
                }
            }
            synchronized (this.f25899d) {
                this.f25899d.m25432k();
            }
            while (this.f25900e.m39582a() > 0) {
                m33884a(false);
                this.f25899d.f20003d.m25382b();
            }
        }

        public C6259t timeout() {
            return this.f25899d.f20006g;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void close() {
            /*
            r8 = this;
            r0 = f25896c;
            if (r0 != 0) goto L_0x0013;
        L_0x0004:
            r0 = r8.f25899d;
            r0 = java.lang.Thread.holdsLock(r0);
            if (r0 != 0) goto L_0x000d;
        L_0x000c:
            goto L_0x0013;
        L_0x000d:
            r0 = new java.lang.AssertionError;
            r0.<init>();
            throw r0;
        L_0x0013:
            r0 = r8.f25899d;
            monitor-enter(r0);
            r1 = r8.f25897a;	 Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x001c;
        L_0x001a:
            monitor-exit(r0);	 Catch:{ all -> 0x0065 }
            return;
        L_0x001c:
            monitor-exit(r0);	 Catch:{ all -> 0x0065 }
            r0 = r8.f25899d;
            r0 = r0.f20004e;
            r0 = r0.f25898b;
            r1 = 1;
            if (r0 != 0) goto L_0x004f;
        L_0x0026:
            r0 = r8.f25900e;
            r2 = r0.m39582a();
            r4 = 0;
            r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            if (r0 <= 0) goto L_0x0040;
        L_0x0032:
            r0 = r8.f25900e;
            r2 = r0.m39582a();
            r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            if (r0 <= 0) goto L_0x004f;
        L_0x003c:
            r8.m33884a(r1);
            goto L_0x0032;
        L_0x0040:
            r0 = r8.f25899d;
            r2 = r0.f20003d;
            r0 = r8.f25899d;
            r3 = r0.f20002c;
            r4 = 1;
            r5 = 0;
            r6 = 0;
            r2.m25375a(r3, r4, r5, r6);
        L_0x004f:
            r2 = r8.f25899d;
            monitor-enter(r2);
            r8.f25897a = r1;	 Catch:{ all -> 0x0062 }
            monitor-exit(r2);	 Catch:{ all -> 0x0062 }
            r0 = r8.f25899d;
            r0 = r0.f20003d;
            r0.m25382b();
            r0 = r8.f25899d;
            r0.m25431j();
            return;
        L_0x0062:
            r0 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x0062 }
            throw r0;
        L_0x0065:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0065 }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.e.i.a.close():void");
        }
    }

    /* compiled from: Http2Stream */
    /* renamed from: expolib_v1.a.a.e.i$b */
    private final class C7464b implements C6258s {
        /* renamed from: c */
        static final /* synthetic */ boolean f25901c = (C6180i.class.desiredAssertionStatus() ^ 1);
        /* renamed from: a */
        boolean f25902a;
        /* renamed from: b */
        boolean f25903b;
        /* renamed from: d */
        final /* synthetic */ C6180i f25904d;
        /* renamed from: e */
        private final C8170c f25905e = new C8170c();
        /* renamed from: f */
        private final C8170c f25906f = new C8170c();
        /* renamed from: g */
        private final long f25907g;

        C7464b(C6180i c6180i, long j) {
            this.f25904d = c6180i;
            this.f25907g = j;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long read(expolib_v1.p332b.C8170c r8, long r9) {
            /*
            r7 = this;
            r0 = 0;
            r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1));
            if (r2 < 0) goto L_0x00a0;
        L_0x0006:
            r2 = r7.f25904d;
            monitor-enter(r2);
            r7.m33886a();	 Catch:{ all -> 0x009d }
            r7.m33887b();	 Catch:{ all -> 0x009d }
            r3 = r7.f25906f;	 Catch:{ all -> 0x009d }
            r3 = r3.m39582a();	 Catch:{ all -> 0x009d }
            r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1));
            if (r3 != 0) goto L_0x001d;
        L_0x0019:
            r8 = -1;
            monitor-exit(r2);	 Catch:{ all -> 0x009d }
            return r8;
        L_0x001d:
            r3 = r7.f25906f;	 Catch:{ all -> 0x009d }
            r4 = r7.f25906f;	 Catch:{ all -> 0x009d }
            r4 = r4.m39582a();	 Catch:{ all -> 0x009d }
            r9 = java.lang.Math.min(r9, r4);	 Catch:{ all -> 0x009d }
            r8 = r3.read(r8, r9);	 Catch:{ all -> 0x009d }
            r10 = r7.f25904d;	 Catch:{ all -> 0x009d }
            r3 = r10.f20000a;	 Catch:{ all -> 0x009d }
            r5 = 0;
            r3 = r3 + r8;
            r10.f20000a = r3;	 Catch:{ all -> 0x009d }
            r10 = r7.f25904d;	 Catch:{ all -> 0x009d }
            r3 = r10.f20000a;	 Catch:{ all -> 0x009d }
            r10 = r7.f25904d;	 Catch:{ all -> 0x009d }
            r10 = r10.f20003d;	 Catch:{ all -> 0x009d }
            r10 = r10.f19984l;	 Catch:{ all -> 0x009d }
            r10 = r10.m25472d();	 Catch:{ all -> 0x009d }
            r10 = r10 / 2;
            r5 = (long) r10;	 Catch:{ all -> 0x009d }
            r10 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
            if (r10 < 0) goto L_0x005d;
        L_0x004a:
            r10 = r7.f25904d;	 Catch:{ all -> 0x009d }
            r10 = r10.f20003d;	 Catch:{ all -> 0x009d }
            r3 = r7.f25904d;	 Catch:{ all -> 0x009d }
            r3 = r3.f20002c;	 Catch:{ all -> 0x009d }
            r4 = r7.f25904d;	 Catch:{ all -> 0x009d }
            r4 = r4.f20000a;	 Catch:{ all -> 0x009d }
            r10.m25370a(r3, r4);	 Catch:{ all -> 0x009d }
            r10 = r7.f25904d;	 Catch:{ all -> 0x009d }
            r10.f20000a = r0;	 Catch:{ all -> 0x009d }
        L_0x005d:
            monitor-exit(r2);	 Catch:{ all -> 0x009d }
            r10 = r7.f25904d;
            r10 = r10.f20003d;
            monitor-enter(r10);
            r2 = r7.f25904d;	 Catch:{ all -> 0x009a }
            r2 = r2.f20003d;	 Catch:{ all -> 0x009a }
            r3 = r2.f19982j;	 Catch:{ all -> 0x009a }
            r5 = 0;
            r3 = r3 + r8;
            r2.f19982j = r3;	 Catch:{ all -> 0x009a }
            r2 = r7.f25904d;	 Catch:{ all -> 0x009a }
            r2 = r2.f20003d;	 Catch:{ all -> 0x009a }
            r2 = r2.f19982j;	 Catch:{ all -> 0x009a }
            r4 = r7.f25904d;	 Catch:{ all -> 0x009a }
            r4 = r4.f20003d;	 Catch:{ all -> 0x009a }
            r4 = r4.f19984l;	 Catch:{ all -> 0x009a }
            r4 = r4.m25472d();	 Catch:{ all -> 0x009a }
            r4 = r4 / 2;
            r4 = (long) r4;	 Catch:{ all -> 0x009a }
            r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            if (r2 < 0) goto L_0x0098;
        L_0x0084:
            r2 = r7.f25904d;	 Catch:{ all -> 0x009a }
            r2 = r2.f20003d;	 Catch:{ all -> 0x009a }
            r3 = 0;
            r4 = r7.f25904d;	 Catch:{ all -> 0x009a }
            r4 = r4.f20003d;	 Catch:{ all -> 0x009a }
            r4 = r4.f19982j;	 Catch:{ all -> 0x009a }
            r2.m25370a(r3, r4);	 Catch:{ all -> 0x009a }
            r2 = r7.f25904d;	 Catch:{ all -> 0x009a }
            r2 = r2.f20003d;	 Catch:{ all -> 0x009a }
            r2.f19982j = r0;	 Catch:{ all -> 0x009a }
        L_0x0098:
            monitor-exit(r10);	 Catch:{ all -> 0x009a }
            return r8;
        L_0x009a:
            r8 = move-exception;
            monitor-exit(r10);	 Catch:{ all -> 0x009a }
            throw r8;
        L_0x009d:
            r8 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x009d }
            throw r8;
        L_0x00a0:
            r8 = new java.lang.IllegalArgumentException;
            r0 = new java.lang.StringBuilder;
            r0.<init>();
            r1 = "byteCount < 0: ";
            r0.append(r1);
            r0.append(r9);
            r9 = r0.toString();
            r8.<init>(r9);
            throw r8;
            */
            throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.e.i.b.read(expolib_v1.b.c, long):long");
        }

        /* renamed from: a */
        private void m33886a() {
            this.f25904d.f20005f.m34021c();
            while (this.f25906f.m39582a() == 0 && !this.f25903b && !this.f25902a && this.f25904d.f20007h == null) {
                try {
                    this.f25904d.m25433l();
                } catch (Throwable th) {
                    this.f25904d.f20005f.m39578b();
                }
            }
            this.f25904d.f20005f.m39578b();
        }

        /* renamed from: a */
        void m33888a(C7497e c7497e, long j) {
            if (!f25901c) {
                if (Thread.holdsLock(this.f25904d)) {
                    throw new AssertionError();
                }
            }
            while (j > 0) {
                synchronized (this.f25904d) {
                    boolean z = this.f25903b;
                    Object obj = null;
                    Object obj2 = this.f25906f.m39582a() + j > this.f25907g ? 1 : null;
                }
                if (obj2 != null) {
                    c7497e.mo6387h(j);
                    this.f25904d.m25421b(C6169b.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    c7497e.mo6387h(j);
                    return;
                } else {
                    long read = c7497e.read(this.f25905e, j);
                    if (read != -1) {
                        j -= read;
                        synchronized (this.f25904d) {
                            if (this.f25906f.m39582a() == 0) {
                                obj = 1;
                            }
                            this.f25906f.mo6368a(this.f25905e);
                            if (obj != null) {
                                this.f25904d.notifyAll();
                            }
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
        }

        public C6259t timeout() {
            return this.f25904d.f20005f;
        }

        public void close() {
            synchronized (this.f25904d) {
                this.f25902a = true;
                this.f25906f.m39650u();
                this.f25904d.notifyAll();
            }
            this.f25904d.m25431j();
        }

        /* renamed from: b */
        private void m33887b() {
            if (this.f25902a) {
                throw new IOException("stream closed");
            } else if (this.f25904d.f20007h != null) {
                throw new C6187o(this.f25904d.f20007h);
            }
        }
    }

    /* compiled from: Http2Stream */
    /* renamed from: expolib_v1.a.a.e.i$c */
    class C8167c extends C7495a {
        /* renamed from: a */
        final /* synthetic */ C6180i f30345a;

        C8167c(C6180i c6180i) {
            this.f30345a = c6180i;
        }

        /* renamed from: a */
        protected void mo6364a() {
            this.f30345a.m25421b(C6169b.CANCEL);
        }

        /* renamed from: a */
        protected IOException mo6363a(IOException iOException) {
            IOException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        /* renamed from: b */
        public void m39578b() {
            if (M_()) {
                throw mo6363a(null);
            }
        }
    }

    C6180i(int i, C6177g c6177g, boolean z, boolean z2, List<C6170c> list) {
        if (c6177g == null) {
            throw new NullPointerException("connection == null");
        } else if (list != null) {
            this.f20002c = i;
            this.f20003d = c6177g;
            this.f20001b = (long) c6177g.f19985m.m25472d();
            this.f20011m = new C7464b(this, (long) c6177g.f19984l.m25472d());
            this.f20004e = new C7463a(this);
            this.f20011m.f25903b = z2;
            this.f20004e.f25898b = z;
            this.f20008j = list;
        } else {
            throw new NullPointerException("requestHeaders == null");
        }
    }

    /* renamed from: a */
    public int m25416a() {
        return this.f20002c;
    }

    /* renamed from: b */
    public synchronized boolean m25422b() {
        if (this.f20007h != null) {
            return false;
        }
        if ((this.f20011m.f25903b || this.f20011m.f25902a) && ((this.f20004e.f25898b || this.f20004e.f25897a) && this.f20010l)) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    public boolean m25424c() {
        if (this.f20003d.f19974b == ((this.f20002c & 1) == 1)) {
            return true;
        }
        return false;
    }

    /* renamed from: d */
    public synchronized List<C6170c> m25425d() {
        List<C6170c> list;
        if (m25424c()) {
            this.f20005f.m34021c();
            while (this.f20009k == null && this.f20007h == null) {
                try {
                    m25433l();
                } finally {
                    this.f20005f.m39578b();
                }
            }
            list = this.f20009k;
            if (list != null) {
                this.f20009k = null;
            } else {
                throw new C6187o(this.f20007h);
            }
        }
        throw new IllegalStateException("servers cannot read response headers");
        return list;
    }

    /* renamed from: e */
    public C6259t m25426e() {
        return this.f20005f;
    }

    /* renamed from: f */
    public C6259t m25427f() {
        return this.f20006g;
    }

    /* renamed from: g */
    public C6258s m25428g() {
        return this.f20011m;
    }

    /* renamed from: h */
    public C6257r m25429h() {
        synchronized (this) {
            if (!this.f20010l) {
                if (!m25424c()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            }
        }
        return this.f20004e;
    }

    /* renamed from: a */
    public void m25418a(C6169b c6169b) {
        if (m25415d(c6169b)) {
            this.f20003d.m25383b(this.f20002c, c6169b);
        }
    }

    /* renamed from: b */
    public void m25421b(C6169b c6169b) {
        if (m25415d(c6169b)) {
            this.f20003d.m25371a(this.f20002c, c6169b);
        }
    }

    /* renamed from: d */
    private boolean m25415d(C6169b c6169b) {
        if (!f19999i) {
            if (Thread.holdsLock(this)) {
                throw new AssertionError();
            }
        }
        synchronized (this) {
            if (this.f20007h != null) {
                return false;
            } else if (this.f20011m.f25903b && this.f20004e.f25898b) {
                return false;
            } else {
                this.f20007h = c6169b;
                notifyAll();
                this.f20003d.m25381b(this.f20002c);
                return true;
            }
        }
    }

    /* renamed from: a */
    void m25420a(List<C6170c> list) {
        if (!f19999i) {
            if (Thread.holdsLock(this)) {
                throw new AssertionError();
            }
        }
        synchronized (this) {
            boolean z = true;
            this.f20010l = true;
            if (this.f20009k == null) {
                this.f20009k = list;
                z = m25422b();
                notifyAll();
            } else {
                List arrayList = new ArrayList();
                arrayList.addAll(this.f20009k);
                arrayList.add(null);
                arrayList.addAll(list);
                this.f20009k = arrayList;
            }
        }
        if (!z) {
            this.f20003d.m25381b(this.f20002c);
        }
    }

    /* renamed from: a */
    void m25419a(C7497e c7497e, int i) {
        if (!f19999i) {
            if (Thread.holdsLock(this)) {
                throw new AssertionError();
            }
        }
        this.f20011m.m33888a(c7497e, (long) i);
    }

    /* renamed from: i */
    void m25430i() {
        if (!f19999i) {
            if (Thread.holdsLock(this)) {
                throw new AssertionError();
            }
        }
        synchronized (this) {
            this.f20011m.f25903b = true;
            boolean b = m25422b();
            notifyAll();
        }
        if (!b) {
            this.f20003d.m25381b(this.f20002c);
        }
    }

    /* renamed from: c */
    synchronized void m25423c(C6169b c6169b) {
        if (this.f20007h == null) {
            this.f20007h = c6169b;
            notifyAll();
        }
    }

    /* renamed from: j */
    void m25431j() {
        if (!f19999i) {
            if (Thread.holdsLock(this)) {
                throw new AssertionError();
            }
        }
        synchronized (this) {
            Object obj = (!this.f20011m.f25903b && this.f20011m.f25902a && (this.f20004e.f25898b || this.f20004e.f25897a)) ? 1 : null;
            boolean b = m25422b();
        }
        if (obj != null) {
            m25418a(C6169b.CANCEL);
        } else if (!b) {
            this.f20003d.m25381b(this.f20002c);
        }
    }

    /* renamed from: a */
    void m25417a(long j) {
        this.f20001b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* renamed from: k */
    void m25432k() {
        if (this.f20004e.f25897a) {
            throw new IOException("stream closed");
        } else if (this.f20004e.f25898b) {
            throw new IOException("stream finished");
        } else if (this.f20007h != null) {
            throw new C6187o(this.f20007h);
        }
    }

    /* renamed from: l */
    void m25433l() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r1.wait();	 Catch:{ InterruptedException -> 0x0004 }
        return;
    L_0x0004:
        r0 = new java.io.InterruptedIOException;
        r0.<init>();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.e.i.l():void");
    }
}
