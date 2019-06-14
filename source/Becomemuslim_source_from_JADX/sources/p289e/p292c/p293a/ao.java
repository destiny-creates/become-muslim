package p289e.p292c.p293a;

import com.facebook.common.time.Clock;
import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p289e.C5974e.C7335a;
import p289e.C5974e.C7336b;
import p289e.C5982f;
import p289e.C5984g;
import p289e.C5989l;
import p289e.C7367k;
import p289e.p290a.C5903b;
import p289e.p291b.C5913a;
import p289e.p291b.C5914b;
import p289e.p291b.C5919g;
import p289e.p292c.p295e.C5967n;
import p289e.p292c.p295e.C7322j;
import p289e.p292c.p386b.C7284a;
import p289e.p298d.C7334c;
import p289e.p299e.C5973e;
import p289e.p300f.C5977c;
import p289e.p303i.C5987e;

/* compiled from: OperatorGroupBy */
/* renamed from: e.c.a.ao */
public final class ao<T, K, V> implements C7336b<C7334c<K, V>, T> {
    /* renamed from: a */
    final C5919g<? super T, ? extends K> f29983a;
    /* renamed from: b */
    final C5919g<? super T, ? extends V> f29984b;
    /* renamed from: c */
    final int f29985c;
    /* renamed from: d */
    final boolean f29986d;
    /* renamed from: e */
    final C5919g<C5914b<K>, Map<K, Object>> f29987e;

    /* compiled from: OperatorGroupBy */
    /* renamed from: e.c.a.ao$a */
    public static final class C7243a implements C5984g {
        /* renamed from: a */
        final C8061b<?, ?, ?> f25534a;

        public C7243a(C8061b<?, ?, ?> c8061b) {
            this.f25534a = c8061b;
        }

        /* renamed from: a */
        public void mo5119a(long j) {
            this.f25534a.mo6325b(j);
        }
    }

    /* compiled from: OperatorGroupBy */
    /* renamed from: e.c.a.ao$b */
    public static final class C8061b<T, K, V> extends C7367k<T> {
        /* renamed from: j */
        static final Object f29955j = new Object();
        /* renamed from: a */
        final C7367k<? super C7334c<K, V>> f29956a;
        /* renamed from: b */
        final C5919g<? super T, ? extends K> f29957b;
        /* renamed from: c */
        final C5919g<? super T, ? extends V> f29958c;
        /* renamed from: d */
        final int f29959d;
        /* renamed from: e */
        final boolean f29960e;
        /* renamed from: f */
        final Map<Object, C8062c<K, V>> f29961f;
        /* renamed from: g */
        final Queue<C7334c<K, V>> f29962g = new ConcurrentLinkedQueue();
        /* renamed from: h */
        final C7243a f29963h;
        /* renamed from: i */
        final Queue<K> f29964i;
        /* renamed from: k */
        final C7284a f29965k = new C7284a();
        /* renamed from: l */
        final AtomicBoolean f29966l;
        /* renamed from: m */
        final AtomicLong f29967m;
        /* renamed from: n */
        final AtomicInteger f29968n;
        /* renamed from: o */
        Throwable f29969o;
        /* renamed from: p */
        volatile boolean f29970p;
        /* renamed from: q */
        final AtomicInteger f29971q;

        /* compiled from: OperatorGroupBy */
        /* renamed from: e.c.a.ao$b$a */
        static class C7244a<K> implements C5914b<K> {
            /* renamed from: a */
            final Queue<K> f25535a;

            C7244a(Queue<K> queue) {
                this.f25535a = queue;
            }

            /* renamed from: b */
            public void mo4974b(K k) {
                this.f25535a.offer(k);
            }
        }

        public C8061b(C7367k<? super C7334c<K, V>> c7367k, C5919g<? super T, ? extends K> c5919g, C5919g<? super T, ? extends V> c5919g2, int i, boolean z, C5919g<C5914b<K>, Map<K, Object>> c5919g3) {
            this.f29956a = c7367k;
            this.f29957b = c5919g;
            this.f29958c = c5919g2;
            this.f29959d = i;
            this.f29960e = z;
            this.f29965k.mo5119a((long) i);
            this.f29963h = new C7243a(this);
            this.f29966l = new AtomicBoolean();
            this.f29967m = new AtomicLong();
            this.f29968n = new AtomicInteger(1);
            this.f29971q = new AtomicInteger();
            if (c5919g3 == null) {
                this.f29961f = new ConcurrentHashMap();
                this.f29964i = null;
                return;
            }
            this.f29964i = new ConcurrentLinkedQueue();
            this.f29961f = m39158a(c5919g3, new C7244a(this.f29964i));
        }

        /* renamed from: a */
        private Map<Object, C8062c<K, V>> m39158a(C5919g<C5914b<K>, Map<K, Object>> c5919g, C5914b<K> c5914b) {
            return (Map) c5919g.mo4976a(c5914b);
        }

        /* renamed from: a */
        public void mo6324a(C5984g c5984g) {
            this.f29965k.m33599a(c5984g);
        }

        /* renamed from: a */
        public void mo5000a(T t) {
            if (!this.f29970p) {
                Queue queue = this.f29962g;
                C7367k c7367k = this.f29956a;
                try {
                    Object obj;
                    Object a = this.f29957b.mo4976a(t);
                    Object obj2 = null;
                    if (a != null) {
                        obj = a;
                    } else {
                        obj = f29955j;
                    }
                    C8062c c8062c = (C8062c) this.f29961f.get(obj);
                    if (c8062c == null) {
                        if (!this.f29966l.get()) {
                            c8062c = C8062c.m39168a(a, this.f29959d, this, this.f29960e);
                            this.f29961f.put(obj, c8062c);
                            this.f29968n.getAndIncrement();
                            obj2 = 1;
                        } else {
                            return;
                        }
                    }
                    try {
                        c8062c.m39170a(this.f29958c.mo4976a(t));
                        if (this.f29964i != null) {
                            while (true) {
                                t = this.f29964i.poll();
                                if (t == null) {
                                    break;
                                }
                                C8062c c8062c2 = (C8062c) this.f29961f.get(t);
                                if (c8062c2 != null) {
                                    c8062c2.m39169a();
                                }
                            }
                        }
                        if (obj2 != null) {
                            queue.offer(c8062c);
                            m39167e();
                        }
                    } catch (T t2) {
                        U_();
                        m39160a(c7367k, queue, t2);
                    }
                } catch (T t22) {
                    U_();
                    m39160a(c7367k, queue, t22);
                }
            }
        }

        /* renamed from: a */
        public void mo5001a(Throwable th) {
            if (this.f29970p) {
                C5977c.m25068a(th);
                return;
            }
            this.f29969o = th;
            this.f29970p = true;
            this.f29968n.decrementAndGet();
            m39167e();
        }

        public void L_() {
            if (!this.f29970p) {
                for (C8062c a : this.f29961f.values()) {
                    a.m39169a();
                }
                this.f29961f.clear();
                if (this.f29964i != null) {
                    this.f29964i.clear();
                }
                this.f29970p = true;
                this.f29968n.decrementAndGet();
                m39167e();
            }
        }

        /* renamed from: b */
        public void mo6325b(long j) {
            if (j >= 0) {
                C5923a.m24836a(this.f29967m, j);
                m39167e();
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("n >= 0 required but it was ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        /* renamed from: d */
        public void m39166d() {
            if (this.f29966l.compareAndSet(false, true) && this.f29968n.decrementAndGet() == 0) {
                U_();
            }
        }

        /* renamed from: b */
        public void m39165b(K k) {
            if (k == null) {
                k = f29955j;
            }
            if (this.f29961f.remove(k) != null && this.f29968n.decrementAndGet() == null) {
                U_();
            }
        }

        /* renamed from: e */
        void m39167e() {
            if (this.f29971q.getAndIncrement() == 0) {
                Queue queue = this.f29962g;
                C7367k c7367k = this.f29956a;
                int i = 1;
                while (!m39163a(this.f29970p, queue.isEmpty(), c7367k, queue)) {
                    long j = this.f29967m.get();
                    long j2 = 0;
                    while (j2 != j) {
                        boolean z = this.f29970p;
                        C7334c c7334c = (C7334c) queue.poll();
                        boolean z2 = c7334c == null;
                        if (!m39163a(z, z2, c7367k, queue)) {
                            if (z2) {
                                break;
                            }
                            c7367k.mo5000a((Object) c7334c);
                            j2++;
                        } else {
                            return;
                        }
                    }
                    if (j2 != 0) {
                        if (j != Clock.MAX_TIME) {
                            C5923a.m24838b(this.f29967m, j2);
                        }
                        this.f29965k.mo5119a(j2);
                    }
                    i = this.f29971q.addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        /* renamed from: a */
        void m39160a(C7367k<? super C7334c<K, V>> c7367k, Queue<?> queue, Throwable th) {
            queue.clear();
            queue = new ArrayList(this.f29961f.values());
            this.f29961f.clear();
            if (this.f29964i != null) {
                this.f29964i.clear();
            }
            queue = queue.iterator();
            while (queue.hasNext()) {
                ((C8062c) queue.next()).m39171a(th);
            }
            c7367k.mo5001a(th);
        }

        /* renamed from: a */
        boolean m39163a(boolean z, boolean z2, C7367k<? super C7334c<K, V>> c7367k, Queue<?> queue) {
            if (z) {
                z = this.f29969o;
                if (z) {
                    m39160a(c7367k, queue, z);
                    return true;
                } else if (z2) {
                    this.f29956a.L_();
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: OperatorGroupBy */
    /* renamed from: e.c.a.ao$c */
    static final class C8062c<K, T> extends C7334c<K, T> {
        /* renamed from: b */
        final C8063d<T, K> f29972b;

        /* renamed from: a */
        public static <T, K> C8062c<K, T> m39168a(K k, int i, C8061b<?, K, T> c8061b, boolean z) {
            return new C8062c(k, new C8063d(i, c8061b, k, z));
        }

        protected C8062c(K k, C8063d<T, K> c8063d) {
            super(k, c8063d);
            this.f29972b = c8063d;
        }

        /* renamed from: a */
        public void m39170a(T t) {
            this.f29972b.m39174a((Object) t);
        }

        /* renamed from: a */
        public void m39171a(Throwable th) {
            this.f29972b.m39175a(th);
        }

        /* renamed from: a */
        public void m39169a() {
            this.f29972b.m39179c();
        }
    }

    /* compiled from: OperatorGroupBy */
    /* renamed from: e.c.a.ao$d */
    static final class C8063d<T, K> extends AtomicInteger implements C7335a<T>, C5984g, C5989l {
        private static final long serialVersionUID = -3852313036005250360L;
        /* renamed from: a */
        final K f29973a;
        /* renamed from: b */
        final Queue<Object> f29974b = new ConcurrentLinkedQueue();
        /* renamed from: c */
        final C8061b<?, K, T> f29975c;
        /* renamed from: d */
        final boolean f29976d;
        /* renamed from: e */
        final AtomicLong f29977e;
        /* renamed from: f */
        volatile boolean f29978f;
        /* renamed from: g */
        Throwable f29979g;
        /* renamed from: h */
        final AtomicBoolean f29980h;
        /* renamed from: i */
        final AtomicReference<C7367k<? super T>> f29981i;
        /* renamed from: j */
        final AtomicBoolean f29982j;

        /* renamed from: b */
        public /* synthetic */ void mo4974b(Object obj) {
            m39173a((C7367k) obj);
        }

        public C8063d(int i, C8061b<?, K, T> c8061b, K k, boolean z) {
            this.f29975c = c8061b;
            this.f29973a = k;
            this.f29976d = z;
            this.f29980h = new AtomicBoolean();
            this.f29981i = new AtomicReference();
            this.f29982j = new AtomicBoolean();
            this.f29977e = new AtomicLong();
        }

        /* renamed from: a */
        public void mo5119a(long j) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i < 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("n >= required but it was ");
                stringBuilder.append(j);
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (i != 0) {
                C5923a.m24836a(this.f29977e, j);
                m39180d();
            }
        }

        /* renamed from: b */
        public boolean mo5121b() {
            return this.f29980h.get();
        }

        public void U_() {
            if (this.f29980h.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.f29975c.m39165b(this.f29973a);
            }
        }

        /* renamed from: a */
        public void m39173a(C7367k<? super T> c7367k) {
            if (this.f29982j.compareAndSet(false, true)) {
                c7367k.m33781a((C5989l) this);
                c7367k.mo6324a((C5984g) this);
                this.f29981i.lazySet(c7367k);
                m39180d();
                return;
            }
            c7367k.mo5001a(new IllegalStateException("Only one Subscriber allowed!"));
        }

        /* renamed from: a */
        public void m39174a(T t) {
            if (t == null) {
                this.f29979g = new NullPointerException();
                this.f29978f = true;
            } else {
                this.f29974b.offer(C5937h.m24848a((Object) t));
            }
            m39180d();
        }

        /* renamed from: a */
        public void m39175a(Throwable th) {
            this.f29979g = th;
            this.f29978f = true;
            m39180d();
        }

        /* renamed from: c */
        public void m39179c() {
            this.f29978f = true;
            m39180d();
        }

        /* renamed from: d */
        void m39180d() {
            if (getAndIncrement() == 0) {
                Queue queue = this.f29974b;
                boolean z = this.f29976d;
                C7367k c7367k = (C7367k) this.f29981i.get();
                int i = 1;
                while (true) {
                    if (c7367k != null) {
                        if (!m39176a(this.f29978f, queue.isEmpty(), c7367k, z)) {
                            long j = this.f29977e.get();
                            long j2 = 0;
                            while (j2 != j) {
                                boolean z2 = this.f29978f;
                                Object poll = queue.poll();
                                boolean z3 = poll == null;
                                if (!m39176a(z2, z3, c7367k, z)) {
                                    if (z3) {
                                        break;
                                    }
                                    c7367k.mo5000a(C5937h.m24853d(poll));
                                    j2++;
                                } else {
                                    return;
                                }
                            }
                            if (j2 != 0) {
                                if (j != Clock.MAX_TIME) {
                                    C5923a.m24838b(this.f29977e, j2);
                                }
                                this.f29975c.f29965k.mo5119a(j2);
                            }
                        } else {
                            return;
                        }
                    }
                    i = addAndGet(-i);
                    if (i != 0) {
                        if (c7367k == null) {
                            c7367k = (C7367k) this.f29981i.get();
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        /* renamed from: a */
        boolean m39176a(boolean z, boolean z2, C7367k<? super T> c7367k, boolean z3) {
            if (this.f29980h.get()) {
                this.f29974b.clear();
                this.f29975c.m39165b(this.f29973a);
                return true;
            }
            if (z) {
                if (!z3) {
                    z = this.f29979g;
                    if (z) {
                        this.f29974b.clear();
                        c7367k.mo5001a((Throwable) z);
                        return true;
                    } else if (z2) {
                        c7367k.L_();
                        return true;
                    }
                } else if (z2) {
                    z = this.f29979g;
                    if (z) {
                        c7367k.mo5001a((Throwable) z);
                    } else {
                        c7367k.L_();
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public ao(C5919g<? super T, ? extends K> c5919g) {
        this(c5919g, C5967n.m24947b(), C7322j.f25717b, false, null);
    }

    public ao(C5919g<? super T, ? extends K> c5919g, C5919g<? super T, ? extends V> c5919g2, int i, boolean z, C5919g<C5914b<K>, Map<K, Object>> c5919g3) {
        this.f29983a = c5919g;
        this.f29984b = c5919g2;
        this.f29985c = i;
        this.f29986d = z;
        this.f29987e = c5919g3;
    }

    /* renamed from: a */
    public C7367k<? super T> m39181a(C7367k<? super C7334c<K, V>> c7367k) {
        try {
            final C7367k c8061b = new C8061b(c7367k, this.f29983a, this.f29984b, this.f29985c, this.f29986d, this.f29987e);
            c7367k.m33781a(C5987e.m25118a(new C5913a(this) {
                /* renamed from: b */
                final /* synthetic */ ao f25533b;

                /* renamed from: a */
                public void mo4985a() {
                    c8061b.m39166d();
                }
            }));
            c7367k.mo6324a(c8061b.f29963h);
            return c8061b;
        } catch (Throwable th) {
            C5903b.m24789a(th, (C5982f) c7367k);
            c7367k = C5973e.m24964a();
            c7367k.U_();
            return c7367k;
        }
    }
}
