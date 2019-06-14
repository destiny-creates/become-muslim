package expolib_v1.p321a;

import expolib_v1.p321a.C7492y.C7491a;
import expolib_v1.p321a.p322a.C6165c;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Dispatcher */
/* renamed from: expolib_v1.a.n */
public final class C6230n {
    /* renamed from: a */
    private int f20281a = 64;
    /* renamed from: b */
    private int f20282b = 5;
    /* renamed from: c */
    private Runnable f20283c;
    /* renamed from: d */
    private ExecutorService f20284d;
    /* renamed from: e */
    private final Deque<C7491a> f20285e = new ArrayDeque();
    /* renamed from: f */
    private final Deque<C7491a> f20286f = new ArrayDeque();
    /* renamed from: g */
    private final Deque<C7492y> f20287g = new ArrayDeque();

    /* renamed from: a */
    public synchronized ExecutorService m25691a() {
        if (this.f20284d == null) {
            this.f20284d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), C6165c.m25313a("OkHttp Dispatcher", false));
        }
        return this.f20284d;
    }

    /* renamed from: a */
    synchronized void m25692a(C7491a c7491a) {
        if (this.f20286f.size() >= this.f20281a || m25689c(c7491a) >= this.f20282b) {
            this.f20285e.add(c7491a);
        } else {
            this.f20286f.add(c7491a);
            m25691a().execute(c7491a);
        }
    }

    /* renamed from: e */
    private void m25690e() {
        if (this.f20286f.size() < this.f20281a && !this.f20285e.isEmpty()) {
            Iterator it = this.f20285e.iterator();
            while (it.hasNext()) {
                C7491a c7491a = (C7491a) it.next();
                if (m25689c(c7491a) < this.f20282b) {
                    it.remove();
                    this.f20286f.add(c7491a);
                    m25691a().execute(c7491a);
                }
                if (this.f20286f.size() >= this.f20281a) {
                    return;
                }
            }
        }
    }

    /* renamed from: c */
    private int m25689c(C7491a c7491a) {
        int i = 0;
        for (C7491a a : this.f20286f) {
            if (a.m33996a().equals(c7491a.m33996a())) {
                i++;
            }
        }
        return i;
    }

    /* renamed from: a */
    synchronized void m25693a(C7492y c7492y) {
        this.f20287g.add(c7492y);
    }

    /* renamed from: b */
    void m25695b(C7491a c7491a) {
        m25688a(this.f20286f, c7491a, true);
    }

    /* renamed from: b */
    void m25696b(C7492y c7492y) {
        m25688a(this.f20287g, c7492y, false);
    }

    /* renamed from: a */
    private <T> void m25688a(Deque<T> deque, T t, boolean z) {
        synchronized (this) {
            if (deque.remove(t) != null) {
                if (z) {
                    m25690e();
                }
                deque = m25698d();
                t = this.f20283c;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (deque == null && t != null) {
            t.run();
        }
    }

    /* renamed from: b */
    public synchronized List<C6216e> m25694b() {
        List arrayList;
        arrayList = new ArrayList();
        for (C7491a b : this.f20285e) {
            arrayList.add(b.m33997b());
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: c */
    public synchronized List<C6216e> m25697c() {
        List arrayList;
        arrayList = new ArrayList();
        arrayList.addAll(this.f20287g);
        for (C7491a b : this.f20286f) {
            arrayList.add(b.m33997b());
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: d */
    public synchronized int m25698d() {
        return this.f20286f.size() + this.f20287g.size();
    }
}
