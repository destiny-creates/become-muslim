package org.apache.p378b.p379a.p382d;

import com.facebook.stetho.server.http.HttpStatus;
import java.util.Collection;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.apache.p378b.p379a.C6649a;
import org.apache.p378b.p379a.C6661d;
import org.apache.p378b.p379a.p380a.C6647b;
import org.apache.p378b.p379a.p381c.C8192a;
import org.apache.p378b.p379a.p383e.C6666b;
import org.apache.p378b.p379a.p389b.C8276a;

/* compiled from: StatusLogger */
/* renamed from: org.apache.b.a.d.c */
public final class C8277c extends C8192a {
    /* renamed from: h */
    private static final C6666b f32462h = new C6666b("log4j2.StatusLogger.properties");
    /* renamed from: i */
    private static final int f32463i = f32462h.m27119a("log4j2.status.entries", (int) HttpStatus.HTTP_OK);
    /* renamed from: j */
    private static final String f32464j = f32462h.m27120a("log4j2.StatusLogger.level");
    /* renamed from: k */
    private static final C8277c f32465k = new C8277c();
    private static final long serialVersionUID = 2;
    /* renamed from: l */
    private final C8276a f32466l = new C8276a("StatusLogger", C6649a.f21366c, false, true, false, false, "", null, f32462h, System.err);
    /* renamed from: m */
    private final Collection<C6659b> f32467m = new CopyOnWriteArrayList();
    /* renamed from: n */
    private final ReadWriteLock f32468n = new ReentrantReadWriteLock();
    /* renamed from: o */
    private final Queue<C6658a> f32469o = new C6660a(this, f32463i);
    /* renamed from: p */
    private final Lock f32470p = new ReentrantLock();
    /* renamed from: q */
    private int f32471q = C6649a.m27070a(f32464j, C6649a.f21367d).m27071a();

    /* compiled from: StatusLogger */
    /* renamed from: org.apache.b.a.d.c$a */
    private class C6660a<E> extends ConcurrentLinkedQueue<E> {
        private static final long serialVersionUID = -3945953719763255337L;
        /* renamed from: a */
        final /* synthetic */ C8277c f21403a;
        /* renamed from: b */
        private final int f21404b;

        public C6660a(C8277c c8277c, int i) {
            this.f21403a = c8277c;
            this.f21404b = i;
        }

        public boolean add(E e) {
            while (this.f21403a.f32469o.size() > this.f21404b) {
                this.f21403a.f32469o.poll();
            }
            return super.add(e);
        }
    }

    private C8277c() {
    }

    /* renamed from: c */
    public static C8277c m42922c() {
        return f32465k;
    }

    /* renamed from: a */
    public void mo6782a(String str, C6649a c6649a, C6661d c6661d, C6647b c6647b, Throwable th) {
        C6658a c6658a = new C6658a(str != null ? m42920a(str, Thread.currentThread().getStackTrace()) : null, c6649a, c6647b, th);
        this.f32470p.lock();
        try {
            this.f32469o.add(c6658a);
            if (this.f32467m.size() > 0) {
                for (C6659b c6659b : this.f32467m) {
                    if (c6658a.m27103a().m27072a(c6659b.m27104a()) != null) {
                        c6659b.m27105a(c6658a);
                    }
                }
                return;
            }
            this.f32466l.mo6782a(str, c6649a, c6661d, c6647b, th);
        } finally {
            c6649a = this.f32470p;
            c6649a.unlock();
        }
    }

    /* renamed from: a */
    private StackTraceElement m42920a(String str, StackTraceElement[] stackTraceElementArr) {
        if (str == null) {
            return null;
        }
        Object obj = null;
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            String className = stackTraceElement.getClassName();
            if (obj != null && !str.equals(className)) {
                return stackTraceElement;
            }
            if (str.equals(className)) {
                obj = 1;
            } else if ("?".equals(className)) {
                break;
            }
        }
        return null;
    }

    /* renamed from: a */
    public boolean mo6784a(C6649a c6649a, C6661d c6661d, String str, Throwable th) {
        return mo6786a(c6649a, c6661d);
    }

    /* renamed from: a */
    public boolean mo6785a(C6649a c6649a, C6661d c6661d, String str, Object... objArr) {
        return mo6786a(c6649a, c6661d);
    }

    /* renamed from: a */
    public boolean mo6783a(C6649a c6649a, C6661d c6661d, Object obj, Throwable th) {
        return mo6786a(c6649a, c6661d);
    }

    /* renamed from: a */
    public boolean mo6786a(C6649a c6649a, C6661d c6661d) {
        if (this.f32467m.size() <= 0) {
            return this.f32466l.mo6786a(c6649a, c6661d);
        }
        return this.f32471q >= c6649a.m27071a() ? true : null;
    }
}
