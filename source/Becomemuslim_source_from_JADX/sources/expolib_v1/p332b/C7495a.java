package expolib_v1.p332b;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* compiled from: AsyncTimeout */
/* renamed from: expolib_v1.b.a */
public class C7495a extends C6259t {
    /* renamed from: a */
    private static final long f26031a = TimeUnit.SECONDS.toMillis(60);
    /* renamed from: b */
    static C7495a f26032b;
    /* renamed from: d */
    private static final long f26033d = TimeUnit.MILLISECONDS.toNanos(f26031a);
    /* renamed from: e */
    private boolean f26034e;
    /* renamed from: f */
    private C7495a f26035f;
    /* renamed from: g */
    private long f26036g;

    /* compiled from: AsyncTimeout */
    /* renamed from: expolib_v1.b.a$a */
    private static final class C6247a extends Thread {
        C6247a() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        public void run() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r3 = this;
        L_0x0000:
            r0 = expolib_v1.p332b.C7495a.class;	 Catch:{ InterruptedException -> 0x0000 }
            monitor-enter(r0);	 Catch:{ InterruptedException -> 0x0000 }
            r1 = expolib_v1.p332b.C7495a.m34014e();	 Catch:{ all -> 0x0019 }
            if (r1 != 0) goto L_0x000b;	 Catch:{ all -> 0x0019 }
        L_0x0009:
            monitor-exit(r0);	 Catch:{ all -> 0x0019 }
            goto L_0x0000;	 Catch:{ all -> 0x0019 }
        L_0x000b:
            r2 = expolib_v1.p332b.C7495a.f26032b;	 Catch:{ all -> 0x0019 }
            if (r1 != r2) goto L_0x0014;	 Catch:{ all -> 0x0019 }
        L_0x000f:
            r1 = 0;	 Catch:{ all -> 0x0019 }
            expolib_v1.p332b.C7495a.f26032b = r1;	 Catch:{ all -> 0x0019 }
            monitor-exit(r0);	 Catch:{ all -> 0x0019 }
            return;	 Catch:{ all -> 0x0019 }
        L_0x0014:
            monitor-exit(r0);	 Catch:{ all -> 0x0019 }
            r1.mo6364a();	 Catch:{ InterruptedException -> 0x0000 }
            goto L_0x0000;
        L_0x0019:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0019 }
            throw r1;	 Catch:{ InterruptedException -> 0x0000 }
            */
            throw new UnsupportedOperationException("Method not decompiled: expolib_v1.b.a.a.run():void");
        }
    }

    /* renamed from: a */
    protected void mo6364a() {
    }

    /* renamed from: c */
    public final void m34021c() {
        if (this.f26034e) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long N_ = N_();
        boolean O_ = O_();
        if (N_ != 0 || O_) {
            this.f26034e = true;
            C7495a.m34011a(this, N_, O_);
        }
    }

    /* renamed from: a */
    private static synchronized void m34011a(C7495a c7495a, long j, boolean z) {
        synchronized (C7495a.class) {
            if (f26032b == null) {
                f26032b = new C7495a();
                new C6247a().start();
            }
            long nanoTime = System.nanoTime();
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i != 0 && z) {
                c7495a.f26036g = Math.min(j, c7495a.mo5350d() - nanoTime) + nanoTime;
            } else if (i != 0) {
                c7495a.f26036g = j + nanoTime;
            } else if (z) {
                c7495a.f26036g = c7495a.mo5350d();
            } else {
                throw new AssertionError();
            }
            j = c7495a.m34013b(nanoTime);
            z = f26032b;
            while (z.f26035f != null) {
                if (j < z.f26035f.m34013b(nanoTime)) {
                    break;
                }
                z = z.f26035f;
            }
            c7495a.f26035f = z.f26035f;
            z.f26035f = c7495a;
            if (z == f26032b) {
                C7495a.class.notify();
            }
        }
    }

    public final boolean M_() {
        if (!this.f26034e) {
            return false;
        }
        this.f26034e = false;
        return C7495a.m34012a(this);
    }

    /* renamed from: a */
    private static synchronized boolean m34012a(C7495a c7495a) {
        synchronized (C7495a.class) {
            for (C7495a c7495a2 = f26032b; c7495a2 != null; c7495a2 = c7495a2.f26035f) {
                if (c7495a2.f26035f == c7495a) {
                    c7495a2.f26035f = c7495a.f26035f;
                    c7495a.f26035f = null;
                    return null;
                }
            }
            return true;
        }
    }

    /* renamed from: b */
    private long m34013b(long j) {
        return this.f26036g - j;
    }

    /* renamed from: a */
    public final C6257r m34015a(final C6257r c6257r) {
        return new C6257r(this) {
            /* renamed from: b */
            final /* synthetic */ C7495a f26028b;

            /* renamed from: a */
            public void mo5257a(C8170c c8170c, long j) {
                C6260u.m25887a(c8170c.f30353b, 0, j);
                while (true) {
                    long j2 = 0;
                    if (j > 0) {
                        C6255o c6255o = c8170c.f30352a;
                        while (j2 < 65536) {
                            j2 += (long) (c8170c.f30352a.f20387c - c8170c.f30352a.f20386b);
                            if (j2 >= j) {
                                j2 = j;
                                break;
                            }
                            c6255o = c6255o.f20390f;
                        }
                        this.f26028b.m34021c();
                        try {
                            c6257r.mo5257a(c8170c, j2);
                            j -= j2;
                            this.f26028b.m34019a(true);
                        } catch (IOException e) {
                            throw this.f26028b.m34020b(e);
                        } catch (Throwable th) {
                            this.f26028b.m34019a(false);
                        }
                    } else {
                        return;
                    }
                }
            }

            public void flush() {
                this.f26028b.m34021c();
                try {
                    c6257r.flush();
                    this.f26028b.m34019a(true);
                } catch (IOException e) {
                    throw this.f26028b.m34020b(e);
                } catch (Throwable th) {
                    this.f26028b.m34019a(false);
                }
            }

            public void close() {
                this.f26028b.m34021c();
                try {
                    c6257r.close();
                    this.f26028b.m34019a(true);
                } catch (IOException e) {
                    throw this.f26028b.m34020b(e);
                } catch (Throwable th) {
                    this.f26028b.m34019a(false);
                }
            }

            public C6259t timeout() {
                return this.f26028b;
            }

            public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("AsyncTimeout.sink(");
                stringBuilder.append(c6257r);
                stringBuilder.append(")");
                return stringBuilder.toString();
            }
        };
    }

    /* renamed from: a */
    public final C6258s m34016a(final C6258s c6258s) {
        return new C6258s(this) {
            /* renamed from: b */
            final /* synthetic */ C7495a f26030b;

            public long read(C8170c c8170c, long j) {
                this.f26030b.m34021c();
                try {
                    c8170c = c6258s.read(c8170c, j);
                    this.f26030b.m34019a(true);
                    return c8170c;
                } catch (IOException e) {
                    throw this.f26030b.m34020b(e);
                } catch (Throwable th) {
                    this.f26030b.m34019a(false);
                }
            }

            public void close() {
                try {
                    c6258s.close();
                    this.f26030b.m34019a(true);
                } catch (IOException e) {
                    throw this.f26030b.m34020b(e);
                } catch (Throwable th) {
                    this.f26030b.m34019a(false);
                }
            }

            public C6259t timeout() {
                return this.f26030b;
            }

            public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("AsyncTimeout.source(");
                stringBuilder.append(c6258s);
                stringBuilder.append(")");
                return stringBuilder.toString();
            }
        };
    }

    /* renamed from: a */
    final void m34019a(boolean z) {
        if (!M_()) {
            return;
        }
        if (z) {
            throw mo6363a((IOException) false);
        }
    }

    /* renamed from: b */
    final IOException m34020b(IOException iOException) {
        if (M_()) {
            return mo6363a(iOException);
        }
        return iOException;
    }

    /* renamed from: a */
    protected IOException mo6363a(IOException iOException) {
        IOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* renamed from: e */
    static C7495a m34014e() {
        C7495a c7495a = f26032b.f26035f;
        C7495a c7495a2 = null;
        if (c7495a == null) {
            long nanoTime = System.nanoTime();
            C7495a.class.wait(f26031a);
            if (f26032b.f26035f == null && System.nanoTime() - nanoTime >= f26033d) {
                c7495a2 = f26032b;
            }
            return c7495a2;
        }
        nanoTime = c7495a.m34013b(System.nanoTime());
        if (nanoTime > 0) {
            long j = nanoTime / 1000000;
            C7495a.class.wait(j, (int) (nanoTime - (1000000 * j)));
            return null;
        }
        f26032b.f26035f = c7495a.f26035f;
        c7495a.f26035f = null;
        return c7495a;
    }
}
