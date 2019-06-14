package p286d;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* compiled from: AsyncTimeout */
/* renamed from: d.a */
public class C7202a extends C5877u {
    private static final long IDLE_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(60);
    private static final long IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(IDLE_TIMEOUT_MILLIS);
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    static C7202a head;
    private boolean inQueue;
    private C7202a next;
    private long timeoutAt;

    /* compiled from: AsyncTimeout */
    /* renamed from: d.a$a */
    private static final class C5865a extends Thread {
        C5865a() {
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
            r0 = p286d.C7202a.class;	 Catch:{ InterruptedException -> 0x0000 }
            monitor-enter(r0);	 Catch:{ InterruptedException -> 0x0000 }
            r1 = p286d.C7202a.awaitTimeout();	 Catch:{ all -> 0x0019 }
            if (r1 != 0) goto L_0x000b;	 Catch:{ all -> 0x0019 }
        L_0x0009:
            monitor-exit(r0);	 Catch:{ all -> 0x0019 }
            goto L_0x0000;	 Catch:{ all -> 0x0019 }
        L_0x000b:
            r2 = p286d.C7202a.head;	 Catch:{ all -> 0x0019 }
            if (r1 != r2) goto L_0x0014;	 Catch:{ all -> 0x0019 }
        L_0x000f:
            r1 = 0;	 Catch:{ all -> 0x0019 }
            p286d.C7202a.head = r1;	 Catch:{ all -> 0x0019 }
            monitor-exit(r0);	 Catch:{ all -> 0x0019 }
            return;	 Catch:{ all -> 0x0019 }
        L_0x0014:
            monitor-exit(r0);	 Catch:{ all -> 0x0019 }
            r1.timedOut();	 Catch:{ InterruptedException -> 0x0000 }
            goto L_0x0000;
        L_0x0019:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0019 }
            throw r1;	 Catch:{ InterruptedException -> 0x0000 }
            */
            throw new UnsupportedOperationException("Method not decompiled: d.a.a.run():void");
        }
    }

    protected void timedOut() {
    }

    public final void enter() {
        if (this.inQueue) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long timeoutNanos = timeoutNanos();
        boolean hasDeadline = hasDeadline();
        if (timeoutNanos != 0 || hasDeadline) {
            this.inQueue = true;
            C7202a.scheduleTimeout(this, timeoutNanos, hasDeadline);
        }
    }

    private static synchronized void scheduleTimeout(C7202a c7202a, long j, boolean z) {
        synchronized (C7202a.class) {
            if (head == null) {
                head = new C7202a();
                new C5865a().start();
            }
            long nanoTime = System.nanoTime();
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i != 0 && z) {
                c7202a.timeoutAt = Math.min(j, c7202a.deadlineNanoTime() - nanoTime) + nanoTime;
            } else if (i != 0) {
                c7202a.timeoutAt = j + nanoTime;
            } else if (z) {
                c7202a.timeoutAt = c7202a.deadlineNanoTime();
            } else {
                throw new AssertionError();
            }
            j = c7202a.remainingNanos(nanoTime);
            z = head;
            while (z.next != null) {
                if (j < z.next.remainingNanos(nanoTime)) {
                    break;
                }
                z = z.next;
            }
            c7202a.next = z.next;
            z.next = c7202a;
            if (z == head) {
                C7202a.class.notify();
            }
        }
    }

    public final boolean exit() {
        if (!this.inQueue) {
            return false;
        }
        this.inQueue = false;
        return C7202a.cancelScheduledTimeout(this);
    }

    private static synchronized boolean cancelScheduledTimeout(C7202a c7202a) {
        synchronized (C7202a.class) {
            for (C7202a c7202a2 = head; c7202a2 != null; c7202a2 = c7202a2.next) {
                if (c7202a2.next == c7202a) {
                    c7202a2.next = c7202a.next;
                    c7202a.next = null;
                    return null;
                }
            }
            return true;
        }
    }

    private long remainingNanos(long j) {
        return this.timeoutAt - j;
    }

    public final C5875s sink(final C5875s c5875s) {
        return new C5875s(this) {
            /* renamed from: b */
            final /* synthetic */ C7202a f25471b;

            public void write(C8037c c8037c, long j) {
                C5878v.m24746a(c8037c.f29839b, 0, j);
                while (true) {
                    long j2 = 0;
                    if (j > 0) {
                        C5873p c5873p = c8037c.f29838a;
                        while (j2 < 65536) {
                            j2 += (long) (c5873p.f19541c - c5873p.f19540b);
                            if (j2 >= j) {
                                j2 = j;
                                break;
                            }
                            c5873p = c5873p.f19544f;
                        }
                        this.f25471b.enter();
                        try {
                            c5875s.write(c8037c, j2);
                            j -= j2;
                            this.f25471b.exit(true);
                        } catch (IOException e) {
                            throw this.f25471b.exit(e);
                        } catch (Throwable th) {
                            this.f25471b.exit(false);
                        }
                    } else {
                        return;
                    }
                }
            }

            public void flush() {
                this.f25471b.enter();
                try {
                    c5875s.flush();
                    this.f25471b.exit(true);
                } catch (IOException e) {
                    throw this.f25471b.exit(e);
                } catch (Throwable th) {
                    this.f25471b.exit(false);
                }
            }

            public void close() {
                this.f25471b.enter();
                try {
                    c5875s.close();
                    this.f25471b.exit(true);
                } catch (IOException e) {
                    throw this.f25471b.exit(e);
                } catch (Throwable th) {
                    this.f25471b.exit(false);
                }
            }

            public C5877u timeout() {
                return this.f25471b;
            }

            public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("AsyncTimeout.sink(");
                stringBuilder.append(c5875s);
                stringBuilder.append(")");
                return stringBuilder.toString();
            }
        };
    }

    public final C5876t source(final C5876t c5876t) {
        return new C5876t(this) {
            /* renamed from: b */
            final /* synthetic */ C7202a f25473b;

            public long read(C8037c c8037c, long j) {
                this.f25473b.enter();
                try {
                    c8037c = c5876t.read(c8037c, j);
                    this.f25473b.exit(true);
                    return c8037c;
                } catch (IOException e) {
                    throw this.f25473b.exit(e);
                } catch (Throwable th) {
                    this.f25473b.exit(false);
                }
            }

            public void close() {
                try {
                    c5876t.close();
                    this.f25473b.exit(true);
                } catch (IOException e) {
                    throw this.f25473b.exit(e);
                } catch (Throwable th) {
                    this.f25473b.exit(false);
                }
            }

            public C5877u timeout() {
                return this.f25473b;
            }

            public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("AsyncTimeout.source(");
                stringBuilder.append(c5876t);
                stringBuilder.append(")");
                return stringBuilder.toString();
            }
        };
    }

    final void exit(boolean z) {
        if (!exit()) {
            return;
        }
        if (z) {
            throw newTimeoutException(false);
        }
    }

    final IOException exit(IOException iOException) {
        if (exit()) {
            return newTimeoutException(iOException);
        }
        return iOException;
    }

    protected IOException newTimeoutException(IOException iOException) {
        IOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    static C7202a awaitTimeout() {
        C7202a c7202a = head.next;
        C7202a c7202a2 = null;
        if (c7202a == null) {
            long nanoTime = System.nanoTime();
            C7202a.class.wait(IDLE_TIMEOUT_MILLIS);
            if (head.next == null && System.nanoTime() - nanoTime >= IDLE_TIMEOUT_NANOS) {
                c7202a2 = head;
            }
            return c7202a2;
        }
        nanoTime = c7202a.remainingNanos(System.nanoTime());
        if (nanoTime > 0) {
            long j = nanoTime / 1000000;
            C7202a.class.wait(j, (int) (nanoTime - (1000000 * j)));
            return null;
        }
        head.next = c7202a.next;
        c7202a.next = null;
        return c7202a;
    }
}
