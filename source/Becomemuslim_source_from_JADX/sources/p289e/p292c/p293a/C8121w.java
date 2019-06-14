package p289e.p292c.p293a;

import com.facebook.common.time.Clock;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import p289e.C5974e.C7335a;
import p289e.C5982f;
import p289e.C5984g;
import p289e.C5989l;
import p289e.C7367k;
import p289e.p290a.C5904c;
import p289e.p292c.p295e.p296a.C7309d;
import p289e.p292c.p295e.p297b.C8364q;
import p289e.p292c.p295e.p297b.ae;

/* compiled from: OnSubscribePublishMulticast */
/* renamed from: e.c.a.w */
public final class C8121w<T> extends AtomicInteger implements C7335a<T>, C5982f<T>, C5989l {
    /* renamed from: i */
    static final C7275b<?>[] f30232i = new C7275b[0];
    /* renamed from: j */
    static final C7275b<?>[] f30233j = new C7275b[0];
    private static final long serialVersionUID = -3741892510772238743L;
    /* renamed from: a */
    final Queue<T> f30234a;
    /* renamed from: b */
    final int f30235b;
    /* renamed from: c */
    final boolean f30236c;
    /* renamed from: d */
    final C8120a<T> f30237d;
    /* renamed from: e */
    volatile boolean f30238e;
    /* renamed from: f */
    Throwable f30239f;
    /* renamed from: g */
    volatile C5984g f30240g;
    /* renamed from: h */
    volatile C7275b<T>[] f30241h;

    /* compiled from: OnSubscribePublishMulticast */
    /* renamed from: e.c.a.w$b */
    static final class C7275b<T> extends AtomicLong implements C5984g, C5989l {
        private static final long serialVersionUID = 960704844171597367L;
        /* renamed from: a */
        final C7367k<? super T> f25602a;
        /* renamed from: b */
        final C8121w<T> f25603b;
        /* renamed from: c */
        final AtomicBoolean f25604c = new AtomicBoolean();

        public C7275b(C7367k<? super T> c7367k, C8121w<T> c8121w) {
            this.f25602a = c7367k;
            this.f25603b = c8121w;
        }

        /* renamed from: a */
        public void mo5119a(long j) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i < 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("n >= 0 required but it was ");
                stringBuilder.append(j);
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (i != 0) {
                C5923a.m24836a((AtomicLong) this, j);
                this.f25603b.m39453c();
            }
        }

        /* renamed from: b */
        public boolean mo5121b() {
            return this.f25604c.get();
        }

        public void U_() {
            if (this.f25604c.compareAndSet(false, true)) {
                this.f25603b.m39450b(this);
            }
        }
    }

    /* compiled from: OnSubscribePublishMulticast */
    /* renamed from: e.c.a.w$a */
    static final class C8120a<T> extends C7367k<T> {
        /* renamed from: a */
        final C8121w<T> f30231a;

        public C8120a(C8121w<T> c8121w) {
            this.f30231a = c8121w;
        }

        /* renamed from: a */
        public void mo5000a(T t) {
            this.f30231a.mo5000a((Object) t);
        }

        /* renamed from: a */
        public void mo5001a(Throwable th) {
            this.f30231a.mo5001a(th);
        }

        public void L_() {
            this.f30231a.L_();
        }

        /* renamed from: a */
        public void mo6324a(C5984g c5984g) {
            this.f30231a.m39444a(c5984g);
        }
    }

    /* renamed from: b */
    public /* synthetic */ void mo4974b(Object obj) {
        m39445a((C7367k) obj);
    }

    public C8121w(int i, boolean z) {
        if (i > 0) {
            this.f30235b = i;
            this.f30236c = z;
            if (ae.m24923a()) {
                this.f30234a = new C8364q(i);
            } else {
                this.f30234a = new C7309d(i);
            }
            this.f30241h = (C7275b[]) f30232i;
            this.f30237d = new C8120a(this);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("prefetch > 0 required but it was ");
        stringBuilder.append(i);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public void m39445a(C7367k<? super T> c7367k) {
        C7275b c7275b = new C7275b(c7367k, this);
        c7367k.m33781a((C5989l) c7275b);
        c7367k.mo6324a((C5984g) c7275b);
        if (!m39448a(c7275b)) {
            Throwable th = this.f30239f;
            if (th != null) {
                c7367k.mo5001a(th);
            } else {
                c7367k.L_();
            }
        } else if (c7275b.mo5121b() != null) {
            m39450b(c7275b);
        } else {
            m39453c();
        }
    }

    /* renamed from: a */
    public void mo5000a(T t) {
        if (this.f30234a.offer(t) == null) {
            this.f30237d.U_();
            this.f30239f = new C5904c("Queue full?!");
            this.f30238e = true;
        }
        m39453c();
    }

    /* renamed from: a */
    public void mo5001a(Throwable th) {
        this.f30239f = th;
        this.f30238e = true;
        m39453c();
    }

    public void L_() {
        this.f30238e = true;
        m39453c();
    }

    /* renamed from: a */
    void m39444a(C5984g c5984g) {
        this.f30240g = c5984g;
        c5984g.mo5119a((long) this.f30235b);
    }

    /* renamed from: c */
    void m39453c() {
        if (getAndIncrement() == 0) {
            Queue queue = this.f30234a;
            int i = 0;
            do {
                C7275b[] c7275bArr = this.f30241h;
                int length = c7275bArr.length;
                long j = Clock.MAX_TIME;
                for (C7275b c7275b : c7275bArr) {
                    j = Math.min(j, c7275b.get());
                }
                if (length != 0) {
                    int i2;
                    long j2 = 0;
                    while (true) {
                        i2 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        }
                        boolean z = this.f30238e;
                        Object poll = queue.poll();
                        boolean z2 = poll == null;
                        if (!m39449a(z, z2)) {
                            if (z2) {
                                break;
                            }
                            for (C7275b c7275b2 : c7275bArr) {
                                c7275b2.f25602a.mo5000a(poll);
                            }
                            j2++;
                        } else {
                            return;
                        }
                    }
                    if (i2 != 0 || !m39449a(this.f30238e, queue.isEmpty())) {
                        if (j2 != 0) {
                            C5984g c5984g = this.f30240g;
                            if (c5984g != null) {
                                c5984g.mo5119a(j2);
                            }
                            for (AtomicLong b : c7275bArr) {
                                C5923a.m24838b(b, j2);
                            }
                        }
                    } else {
                        return;
                    }
                }
                i = addAndGet(-i);
            } while (i != 0);
        }
    }

    /* renamed from: a */
    boolean m39449a(boolean z, boolean z2) {
        boolean z3 = false;
        if (z) {
            int length;
            int i;
            if (!this.f30236c) {
                z = this.f30239f;
                if (z) {
                    this.f30234a.clear();
                    z2 = m39454d();
                    length = z2.length;
                    while (i < length) {
                        z2[i].f25602a.mo5001a((Throwable) z);
                        i++;
                    }
                    return true;
                } else if (z2) {
                    z = m39454d();
                    z2 = z.length;
                    while (z3 < z2) {
                        z[z3].f25602a.L_();
                        z3++;
                    }
                    return true;
                }
            } else if (z2) {
                z = m39454d();
                z2 = this.f30239f;
                if (z2) {
                    length = z.length;
                    while (i < length) {
                        z[i].f25602a.mo5001a((Throwable) z2);
                        i++;
                    }
                } else {
                    z2 = z.length;
                    while (z3 < z2) {
                        z[z3].f25602a.L_();
                        z3++;
                    }
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: d */
    C7275b<T>[] m39454d() {
        C7275b<T>[] c7275bArr = this.f30241h;
        if (c7275bArr != f30233j) {
            synchronized (this) {
                c7275bArr = this.f30241h;
                if (c7275bArr != f30233j) {
                    this.f30241h = f30233j;
                }
            }
        }
        return c7275bArr;
    }

    /* renamed from: a */
    boolean m39448a(C7275b<T> c7275b) {
        if (this.f30241h == f30233j) {
            return false;
        }
        synchronized (this) {
            Object obj = this.f30241h;
            if (obj == f30233j) {
                return false;
            }
            int length = obj.length;
            Object obj2 = new C7275b[(length + 1)];
            System.arraycopy(obj, 0, obj2, 0, length);
            obj2[length] = c7275b;
            this.f30241h = obj2;
            return true;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    void m39450b(p289e.p292c.p293a.C8121w.C7275b<T> r7) {
        /*
        r6 = this;
        r0 = r6.f30241h;
        r1 = f30233j;
        if (r0 == r1) goto L_0x004a;
    L_0x0006:
        r1 = f30232i;
        if (r0 != r1) goto L_0x000b;
    L_0x000a:
        goto L_0x004a;
    L_0x000b:
        monitor-enter(r6);
        r0 = r6.f30241h;	 Catch:{ all -> 0x0047 }
        r1 = f30233j;	 Catch:{ all -> 0x0047 }
        if (r0 == r1) goto L_0x0045;
    L_0x0012:
        r1 = f30232i;	 Catch:{ all -> 0x0047 }
        if (r0 != r1) goto L_0x0017;
    L_0x0016:
        goto L_0x0045;
    L_0x0017:
        r1 = -1;
        r2 = r0.length;	 Catch:{ all -> 0x0047 }
        r3 = 0;
        r4 = 0;
    L_0x001b:
        if (r4 >= r2) goto L_0x0026;
    L_0x001d:
        r5 = r0[r4];	 Catch:{ all -> 0x0047 }
        if (r5 != r7) goto L_0x0023;
    L_0x0021:
        r1 = r4;
        goto L_0x0026;
    L_0x0023:
        r4 = r4 + 1;
        goto L_0x001b;
    L_0x0026:
        if (r1 >= 0) goto L_0x002a;
    L_0x0028:
        monitor-exit(r6);	 Catch:{ all -> 0x0047 }
        return;
    L_0x002a:
        r7 = 1;
        if (r2 != r7) goto L_0x0032;
    L_0x002d:
        r7 = f30232i;	 Catch:{ all -> 0x0047 }
        r7 = (p289e.p292c.p293a.C8121w.C7275b[]) r7;	 Catch:{ all -> 0x0047 }
        goto L_0x0041;
    L_0x0032:
        r4 = r2 + -1;
        r4 = new p289e.p292c.p293a.C8121w.C7275b[r4];	 Catch:{ all -> 0x0047 }
        java.lang.System.arraycopy(r0, r3, r4, r3, r1);	 Catch:{ all -> 0x0047 }
        r3 = r1 + 1;
        r2 = r2 - r1;
        r2 = r2 - r7;
        java.lang.System.arraycopy(r0, r3, r4, r1, r2);	 Catch:{ all -> 0x0047 }
        r7 = r4;
    L_0x0041:
        r6.f30241h = r7;	 Catch:{ all -> 0x0047 }
        monitor-exit(r6);	 Catch:{ all -> 0x0047 }
        return;
    L_0x0045:
        monitor-exit(r6);	 Catch:{ all -> 0x0047 }
        return;
    L_0x0047:
        r7 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0047 }
        throw r7;
    L_0x004a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.w.b(e.c.a.w$b):void");
    }

    /* renamed from: e */
    public C7367k<T> m39455e() {
        return this.f30237d;
    }

    public void U_() {
        this.f30237d.U_();
    }

    /* renamed from: b */
    public boolean mo5121b() {
        return this.f30237d.mo5121b();
    }
}
