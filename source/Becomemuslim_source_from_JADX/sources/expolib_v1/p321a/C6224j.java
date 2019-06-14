package expolib_v1.p321a;

import expolib_v1.p321a.p322a.C6165c;
import expolib_v1.p321a.p322a.p324b.C6150d;
import expolib_v1.p321a.p322a.p324b.C6154g;
import expolib_v1.p321a.p322a.p324b.C6154g.C6153a;
import expolib_v1.p321a.p322a.p324b.C7439c;
import expolib_v1.p321a.p322a.p329g.C6192e;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ConnectionPool */
/* renamed from: expolib_v1.a.j */
public final class C6224j {
    /* renamed from: c */
    static final /* synthetic */ boolean f20238c = (C6224j.class.desiredAssertionStatus() ^ true);
    /* renamed from: d */
    private static final Executor f20239d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), C6165c.m25313a("OkHttp ConnectionPool", true));
    /* renamed from: a */
    final C6150d f20240a;
    /* renamed from: b */
    boolean f20241b;
    /* renamed from: e */
    private final int f20242e;
    /* renamed from: f */
    private final long f20243f;
    /* renamed from: g */
    private final Runnable f20244g;
    /* renamed from: h */
    private final Deque<C7439c> f20245h;

    /* compiled from: ConnectionPool */
    /* renamed from: expolib_v1.a.j$1 */
    class C62231 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C6224j f20237a;

        C62231(C6224j c6224j) {
            this.f20237a = c6224j;
        }

        public void run() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r6 = this;
        L_0x0000:
            r0 = r6.f20237a;
            r1 = java.lang.System.nanoTime();
            r0 = r0.m25651a(r1);
            r2 = -1;
            r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
            if (r2 != 0) goto L_0x0011;
        L_0x0010:
            return;
        L_0x0011:
            r2 = 0;
            r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
            if (r2 <= 0) goto L_0x0000;
        L_0x0017:
            r2 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
            r4 = r0 / r2;
            r2 = r2 * r4;
            r0 = r0 - r2;
            r2 = r6.f20237a;
            monitor-enter(r2);
            r3 = r6.f20237a;	 Catch:{ InterruptedException -> 0x002b }
            r0 = (int) r0;	 Catch:{ InterruptedException -> 0x002b }
            r3.wait(r4, r0);	 Catch:{ InterruptedException -> 0x002b }
            goto L_0x002b;
        L_0x0029:
            r0 = move-exception;
            goto L_0x002d;
        L_0x002b:
            monitor-exit(r2);	 Catch:{ all -> 0x0029 }
            goto L_0x0000;	 Catch:{ all -> 0x0029 }
        L_0x002d:
            monitor-exit(r2);	 Catch:{ all -> 0x0029 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.j.1.run():void");
        }
    }

    public C6224j() {
        this(5, 5, TimeUnit.MINUTES);
    }

    public C6224j(int i, long j, TimeUnit timeUnit) {
        this.f20244g = new C62231(this);
        this.f20245h = new ArrayDeque();
        this.f20240a = new C6150d();
        this.f20242e = i;
        this.f20243f = timeUnit.toNanos(j);
        if (j <= 0) {
            timeUnit = new StringBuilder();
            timeUnit.append("keepAliveDuration <= 0: ");
            timeUnit.append(j);
            throw new IllegalArgumentException(timeUnit.toString());
        }
    }

    /* renamed from: a */
    C7439c m25652a(C6207a c6207a, C6154g c6154g) {
        if (!f20238c) {
            if (!Thread.holdsLock(this)) {
                throw new AssertionError();
            }
        }
        for (C7439c c7439c : this.f20245h) {
            if (c7439c.m33810a(c6207a)) {
                c6154g.m25258a(c7439c);
                return c7439c;
            }
        }
        return null;
    }

    /* renamed from: b */
    Socket m25654b(C6207a c6207a, C6154g c6154g) {
        if (!f20238c) {
            if (!Thread.holdsLock(this)) {
                throw new AssertionError();
            }
        }
        for (C7439c c7439c : this.f20245h) {
            if (c7439c.m33810a(c6207a) && c7439c.m33815e() && c7439c != c6154g.m25261b()) {
                return c6154g.m25262b(c7439c);
            }
        }
        return null;
    }

    /* renamed from: a */
    void m25653a(C7439c c7439c) {
        if (!f20238c) {
            if (!Thread.holdsLock(this)) {
                throw new AssertionError();
            }
        }
        if (!this.f20241b) {
            this.f20241b = true;
            f20239d.execute(this.f20244g);
        }
        this.f20245h.add(c7439c);
    }

    /* renamed from: b */
    boolean m25655b(C7439c c7439c) {
        if (!f20238c) {
            if (!Thread.holdsLock(this)) {
                throw new AssertionError();
            }
        }
        if (!c7439c.f25798a) {
            if (this.f20242e != 0) {
                notifyAll();
                return null;
            }
        }
        this.f20245h.remove(c7439c);
        return true;
    }

    /* renamed from: a */
    long m25651a(long j) {
        synchronized (this) {
            long j2 = Long.MIN_VALUE;
            C7439c c7439c = null;
            int i = 0;
            int i2 = 0;
            for (C7439c c7439c2 : this.f20245h) {
                if (m25650a(c7439c2, j) > 0) {
                    i2++;
                } else {
                    i++;
                    long j3 = j - c7439c2.f25802e;
                    if (j3 > j2) {
                        c7439c = c7439c2;
                        j2 = j3;
                    }
                }
            }
            if (j2 < this.f20243f) {
                if (i <= this.f20242e) {
                    if (i > 0) {
                        j = this.f20243f - j2;
                        return j;
                    } else if (i2 > 0) {
                        j = this.f20243f;
                        return j;
                    } else {
                        this.f20241b = false;
                        return -1;
                    }
                }
            }
            this.f20245h.remove(c7439c);
            C6165c.m25316a(c7439c.m33813c());
            return 0;
        }
    }

    /* renamed from: a */
    private int m25650a(C7439c c7439c, long j) {
        List list = c7439c.f25801d;
        int i = 0;
        while (i < list.size()) {
            Reference reference = (Reference) list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                C6153a c6153a = (C6153a) reference;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("A connection to ");
                stringBuilder.append(c7439c.mo5249a().m25591a().m25547a());
                stringBuilder.append(" was leaked. Did you forget to close a response body?");
                C6192e.m25495b().mo5297a(stringBuilder.toString(), c6153a.f19885a);
                list.remove(i);
                c7439c.f25798a = true;
                if (list.isEmpty()) {
                    c7439c.f25802e = j - this.f20243f;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
