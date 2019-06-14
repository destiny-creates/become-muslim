package p289e.p292c.p293a;

import com.facebook.common.time.Clock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import p289e.C5974e;
import p289e.C5974e.C7336b;
import p289e.C5984g;
import p289e.C5989l;
import p289e.C7367k;
import p289e.p290a.C5902a;
import p289e.p290a.C5904c;
import p289e.p290a.C5910g;
import p289e.p292c.p295e.C7322j;
import p289e.p292c.p295e.C7328l;
import p289e.p292c.p295e.p296a.C5953e;
import p289e.p292c.p295e.p296a.C5955h;
import p289e.p292c.p295e.p296a.C7309d;
import p289e.p292c.p295e.p297b.C5958h;
import p289e.p292c.p295e.p297b.C8364q;
import p289e.p292c.p295e.p297b.ae;
import p289e.p303i.C7362b;

/* compiled from: OperatorMerge */
/* renamed from: e.c.a.ap */
public final class ap<T> implements C7336b<T, C5974e<? extends T>> {
    /* renamed from: a */
    final boolean f30012a;
    /* renamed from: b */
    final int f30013b;

    /* compiled from: OperatorMerge */
    /* renamed from: e.c.a.ap$a */
    static final class C5926a {
        /* renamed from: a */
        static final ap<Object> f19647a = new ap(true, Integer.MAX_VALUE);
    }

    /* compiled from: OperatorMerge */
    /* renamed from: e.c.a.ap$b */
    static final class C5927b {
        /* renamed from: a */
        static final ap<Object> f19648a = new ap(false, Integer.MAX_VALUE);
    }

    /* compiled from: OperatorMerge */
    /* renamed from: e.c.a.ap$d */
    static final class C7245d<T> extends AtomicLong implements C5984g {
        private static final long serialVersionUID = -1214379189873595503L;
        /* renamed from: a */
        final C8065e<T> f25536a;

        public C7245d(C8065e<T> c8065e) {
            this.f25536a = c8065e;
        }

        /* renamed from: a */
        public void mo5119a(long j) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i > 0) {
                if (get() != Clock.MAX_TIME) {
                    C5923a.m24836a((AtomicLong) this, j);
                    this.f25536a.m39203g();
                }
            } else if (i < 0) {
                throw new IllegalArgumentException("n >= 0 required");
            }
        }

        /* renamed from: a */
        public long m33517a(int i) {
            return addAndGet((long) (-i));
        }
    }

    /* compiled from: OperatorMerge */
    /* renamed from: e.c.a.ap$c */
    static final class C8064c<T> extends C7367k<T> {
        /* renamed from: f */
        static final int f29988f = (C7322j.f25717b / 4);
        /* renamed from: a */
        final C8065e<T> f29989a;
        /* renamed from: b */
        final long f29990b;
        /* renamed from: c */
        volatile boolean f29991c;
        /* renamed from: d */
        volatile C7322j f29992d;
        /* renamed from: e */
        int f29993e;

        public C8064c(C8065e<T> c8065e, long j) {
            this.f29989a = c8065e;
            this.f29990b = j;
        }

        /* renamed from: c */
        public void mo6323c() {
            this.f29993e = C7322j.f25717b;
            m33779a((long) C7322j.f25717b);
        }

        /* renamed from: a */
        public void mo5000a(T t) {
            this.f29989a.m39189a(this, (Object) t);
        }

        /* renamed from: a */
        public void mo5001a(Throwable th) {
            this.f29991c = true;
            this.f29989a.m39200d().offer(th);
            this.f29989a.m39203g();
        }

        public void L_() {
            this.f29991c = true;
            this.f29989a.m39203g();
        }

        /* renamed from: b */
        public void mo6325b(long j) {
            int i = this.f29993e - ((int) j);
            if (i > f29988f) {
                this.f29993e = i;
                return;
            }
            this.f29993e = C7322j.f25717b;
            j = C7322j.f25717b - i;
            if (j > null) {
                m33779a((long) j);
            }
        }
    }

    /* compiled from: OperatorMerge */
    /* renamed from: e.c.a.ap$e */
    static final class C8065e<T> extends C7367k<C5974e<? extends T>> {
        /* renamed from: p */
        static final C8064c<?>[] f29994p = new C8064c[0];
        /* renamed from: a */
        final C7367k<? super T> f29995a;
        /* renamed from: b */
        final boolean f29996b;
        /* renamed from: c */
        final int f29997c;
        /* renamed from: d */
        C7245d<T> f29998d;
        /* renamed from: e */
        volatile Queue<Object> f29999e;
        /* renamed from: f */
        volatile C7362b f30000f;
        /* renamed from: g */
        volatile ConcurrentLinkedQueue<Throwable> f30001g;
        /* renamed from: h */
        volatile boolean f30002h;
        /* renamed from: i */
        boolean f30003i;
        /* renamed from: j */
        boolean f30004j;
        /* renamed from: k */
        final Object f30005k = new Object();
        /* renamed from: l */
        volatile C8064c<?>[] f30006l = f29994p;
        /* renamed from: m */
        long f30007m;
        /* renamed from: n */
        long f30008n;
        /* renamed from: o */
        int f30009o;
        /* renamed from: q */
        final int f30010q;
        /* renamed from: r */
        int f30011r;

        public C8065e(C7367k<? super T> c7367k, boolean z, int i) {
            this.f29995a = c7367k;
            this.f29996b = z;
            this.f29997c = i;
            if (i == Integer.MAX_VALUE) {
                this.f30010q = Integer.MAX_VALUE;
                m33779a((long) -1);
                return;
            }
            this.f30010q = Math.max(true, i >> 1);
            m33779a((long) (long) i);
        }

        /* renamed from: d */
        Queue<Throwable> m39200d() {
            Queue<Throwable> queue = this.f30001g;
            if (queue == null) {
                synchronized (this) {
                    queue = this.f30001g;
                    if (queue == null) {
                        queue = new ConcurrentLinkedQueue();
                        this.f30001g = queue;
                    }
                }
            }
            return queue;
        }

        /* renamed from: e */
        C7362b m39201e() {
            C7362b c7362b = this.f30000f;
            if (c7362b != null) {
                return c7362b;
            }
            C5989l c5989l;
            Object obj = null;
            synchronized (this) {
                c5989l = this.f30000f;
                if (c5989l == null) {
                    c7362b = new C7362b();
                    this.f30000f = c7362b;
                    c5989l = c7362b;
                    obj = 1;
                }
            }
            if (obj != null) {
                m33781a(c5989l);
            }
            return c5989l;
        }

        /* renamed from: a */
        public void m39191a(C5974e<? extends T> c5974e) {
            if (c5974e != null) {
                if (c5974e == C5974e.m24988f()) {
                    m39202f();
                } else if (c5974e instanceof C7328l) {
                    m39198b(((C7328l) c5974e).m33689a());
                } else {
                    long j = this.f30007m;
                    this.f30007m = 1 + j;
                    C7367k c8064c = new C8064c(this, j);
                    m39188a((C8064c) c8064c);
                    c5974e.m25007a(c8064c);
                    m39203g();
                }
            }
        }

        /* renamed from: f */
        void m39202f() {
            int i = this.f30011r + 1;
            if (i == this.f30010q) {
                this.f30011r = 0;
                mo6325b((long) i);
                return;
            }
            this.f30011r = i;
        }

        /* renamed from: j */
        private void m39187j() {
            Collection arrayList = new ArrayList(this.f30001g);
            if (arrayList.size() == 1) {
                this.f29995a.mo5001a((Throwable) arrayList.get(0));
            } else {
                this.f29995a.mo5001a(new C5902a(arrayList));
            }
        }

        /* renamed from: a */
        public void mo5001a(Throwable th) {
            m39200d().offer(th);
            this.f30002h = true;
            m39203g();
        }

        public void L_() {
            this.f30002h = true;
            m39203g();
        }

        /* renamed from: a */
        void m39188a(C8064c<T> c8064c) {
            m39201e().m33765a((C5989l) c8064c);
            synchronized (this.f30005k) {
                Object obj = this.f30006l;
                int length = obj.length;
                Object obj2 = new C8064c[(length + 1)];
                System.arraycopy(obj, 0, obj2, 0, length);
                obj2[length] = c8064c;
                this.f30006l = obj2;
            }
        }

        /* renamed from: b */
        void m39196b(C8064c<T> c8064c) {
            C7322j c7322j = c8064c.f29992d;
            if (c7322j != null) {
                c7322j.m33676d();
            }
            this.f30000f.m33766b(c8064c);
            synchronized (this.f30005k) {
                Object obj = this.f30006l;
                int length = obj.length;
                int i = -1;
                for (int i2 = 0; i2 < length; i2++) {
                    if (c8064c.equals(obj[i2])) {
                        i = i2;
                        break;
                    }
                }
                if (i < 0) {
                } else if (length == 1) {
                    this.f30006l = f29994p;
                } else {
                    Object obj2 = new C8064c[(length - 1)];
                    System.arraycopy(obj, 0, obj2, 0, i);
                    System.arraycopy(obj, i + 1, obj2, i, (length - i) - 1);
                    this.f30006l = obj2;
                }
            }
        }

        /* renamed from: a */
        void m39189a(C8064c<T> c8064c, T t) {
            long j = this.f29998d.get();
            Object obj = null;
            if (j != 0) {
                synchronized (this) {
                    j = this.f29998d.get();
                    if (!(this.f30003i || j == 0)) {
                        this.f30003i = true;
                        obj = 1;
                    }
                }
            }
            if (obj != null) {
                C7322j c7322j = c8064c.f29992d;
                if (c7322j != null) {
                    if (!c7322j.m33677e()) {
                        m39197b(c8064c, t);
                        m39204h();
                        return;
                    }
                }
                m39190a(c8064c, t, j);
                return;
            }
            m39197b(c8064c, t);
            m39203g();
        }

        /* renamed from: b */
        protected void m39197b(C8064c<T> c8064c, T t) {
            C7322j c7322j = c8064c.f29992d;
            if (c7322j == null) {
                c7322j = C7322j.m33673c();
                c8064c.m33781a((C5989l) c7322j);
                c8064c.f29992d = c7322j;
            }
            try {
                c7322j.m33674a(C5937h.m24848a((Object) t));
            } catch (Throwable e) {
                c8064c.U_();
                c8064c.mo5001a(e);
            } catch (Throwable e2) {
                if (!c8064c.mo5121b()) {
                    c8064c.U_();
                    c8064c.mo5001a(e2);
                }
            }
        }

        /* renamed from: a */
        protected void m39190a(C8064c<T> c8064c, T t, long j) {
            int i = 1;
            try {
                this.f29995a.mo5000a((Object) t);
            } catch (Throwable th) {
                c8064c = th;
            }
            if (j != Clock.MAX_TIME) {
                this.f29998d.m33517a(1);
            }
            c8064c.mo6325b(1);
            synchronized (this) {
                if (this.f30004j == null) {
                    this.f30003i = false;
                    return;
                }
                this.f30004j = false;
                m39204h();
                return;
            }
            if (i == 0) {
                synchronized (this) {
                    this.f30003i = false;
                }
            }
            throw c8064c;
        }

        /* renamed from: b */
        public void mo6325b(long j) {
            m33779a(j);
        }

        /* renamed from: b */
        void m39198b(T t) {
            long j = this.f29998d.get();
            Object obj = null;
            if (j != 0) {
                synchronized (this) {
                    j = this.f29998d.get();
                    if (!(this.f30003i || j == 0)) {
                        this.f30003i = true;
                        obj = 1;
                    }
                }
            }
            if (obj != null) {
                Queue queue = this.f29999e;
                if (queue != null) {
                    if (!queue.isEmpty()) {
                        m39199c(t);
                        m39204h();
                        return;
                    }
                }
                m39193a((Object) t, j);
                return;
            }
            m39199c(t);
            m39203g();
        }

        /* renamed from: c */
        protected void m39199c(T t) {
            Queue queue = this.f29999e;
            if (queue == null) {
                int i = this.f29997c;
                if (i == Integer.MAX_VALUE) {
                    queue = new C5955h(C7322j.f25717b);
                } else {
                    C8364q c5953e;
                    if (!C5958h.m24925b(i)) {
                        c5953e = new C5953e(i);
                    } else if (ae.m24923a()) {
                        c5953e = new C8364q(i);
                    } else {
                        c5953e = new C7309d(i);
                    }
                    queue = c5953e;
                }
                this.f29999e = queue;
            }
            if (!queue.offer(C5937h.m24848a((Object) t))) {
                U_();
                mo5001a(C5910g.m24799a(new C5904c(), t));
            }
        }

        /* renamed from: a */
        protected void m39193a(T t, long j) {
            int i = 1;
            try {
                this.f29995a.mo5000a((Object) t);
            } catch (Throwable th) {
                t = th;
            }
            if (j != Clock.MAX_TIME) {
                this.f29998d.m33517a(1);
            }
            t = this.f30011r + 1;
            if (t == this.f30010q) {
                this.f30011r = 0;
                mo6325b((long) t);
            } else {
                this.f30011r = t;
            }
            synchronized (this) {
                if (this.f30004j == null) {
                    this.f30003i = false;
                    return;
                }
                this.f30004j = false;
                m39204h();
                return;
            }
            if (i == 0) {
                synchronized (this) {
                    this.f30003i = false;
                }
            }
            throw t;
        }

        /* renamed from: g */
        void m39203g() {
            synchronized (this) {
                if (this.f30003i) {
                    this.f30004j = true;
                    return;
                }
                this.f30003i = true;
                m39204h();
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: h */
        void m39204h() {
            /*
            r20 = this;
            r1 = r20;
            r4 = r1.f29995a;	 Catch:{ all -> 0x01c4 }
        L_0x0004:
            r0 = r20.m39205i();	 Catch:{ all -> 0x01c4 }
            if (r0 == 0) goto L_0x000b;
        L_0x000a:
            return;
        L_0x000b:
            r5 = r1.f29999e;	 Catch:{ all -> 0x01c4 }
            r0 = r1.f29998d;	 Catch:{ all -> 0x01c4 }
            r6 = r0.get();	 Catch:{ all -> 0x01c4 }
            r8 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
            r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
            if (r0 != 0) goto L_0x001e;
        L_0x001c:
            r10 = 1;
            goto L_0x001f;
        L_0x001e:
            r10 = 0;
        L_0x001f:
            r11 = 1;
            r14 = 0;
            if (r5 == 0) goto L_0x0092;
        L_0x0025:
            r0 = 0;
        L_0x0026:
            r16 = r0;
            r0 = 0;
            r2 = 0;
        L_0x002a:
            r17 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1));
            if (r17 <= 0) goto L_0x0073;
        L_0x002e:
            r17 = r5.poll();	 Catch:{ all -> 0x01c4 }
            r0 = r20.m39205i();	 Catch:{ all -> 0x01c4 }
            if (r0 == 0) goto L_0x0039;
        L_0x0038:
            return;
        L_0x0039:
            if (r17 != 0) goto L_0x003e;
        L_0x003b:
            r0 = r17;
            goto L_0x0073;
        L_0x003e:
            r0 = p289e.p292c.p293a.C5937h.m24853d(r17);	 Catch:{ all -> 0x01c4 }
            r4.mo5000a(r0);	 Catch:{ Throwable -> 0x0046 }
            goto L_0x0066;
        L_0x0046:
            r0 = move-exception;
            r18 = r0;
            r0 = r1.f29996b;	 Catch:{ all -> 0x01c4 }
            if (r0 != 0) goto L_0x005d;
        L_0x004d:
            p289e.p290a.C5903b.m24794b(r18);	 Catch:{ all -> 0x01c4 }
            r20.U_();	 Catch:{ all -> 0x0059 }
            r2 = r18;
            r4.mo5001a(r2);	 Catch:{ all -> 0x0059 }
            return;
        L_0x0059:
            r0 = move-exception;
            r3 = 1;
            goto L_0x01c6;
        L_0x005d:
            r8 = r18;
            r0 = r20.m39200d();	 Catch:{ all -> 0x01c4 }
            r0.offer(r8);	 Catch:{ all -> 0x01c4 }
        L_0x0066:
            r16 = r16 + 1;
            r2 = r2 + 1;
            r6 = r6 - r11;
            r0 = r17;
            r8 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
            goto L_0x002a;
        L_0x0073:
            if (r2 <= 0) goto L_0x0083;
        L_0x0075:
            if (r10 == 0) goto L_0x007d;
        L_0x0077:
            r6 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
            goto L_0x0083;
        L_0x007d:
            r6 = r1.f29998d;	 Catch:{ all -> 0x01c4 }
            r6 = r6.m33517a(r2);	 Catch:{ all -> 0x01c4 }
        L_0x0083:
            r2 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1));
            if (r2 == 0) goto L_0x0094;
        L_0x0087:
            if (r0 != 0) goto L_0x008a;
        L_0x0089:
            goto L_0x0094;
        L_0x008a:
            r0 = r16;
            r8 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
            goto L_0x0026;
        L_0x0092:
            r16 = 0;
        L_0x0094:
            r0 = r1.f30002h;	 Catch:{ all -> 0x01c4 }
            r2 = r1.f29999e;	 Catch:{ all -> 0x01c4 }
            r5 = r1.f30006l;	 Catch:{ all -> 0x01c4 }
            r8 = r5.length;	 Catch:{ all -> 0x01c4 }
            if (r0 == 0) goto L_0x00ba;
        L_0x009d:
            if (r2 == 0) goto L_0x00a5;
        L_0x009f:
            r0 = r2.isEmpty();	 Catch:{ all -> 0x01c4 }
            if (r0 == 0) goto L_0x00ba;
        L_0x00a5:
            if (r8 != 0) goto L_0x00ba;
        L_0x00a7:
            r0 = r1.f30001g;	 Catch:{ all -> 0x01c4 }
            if (r0 == 0) goto L_0x00b6;
        L_0x00ab:
            r0 = r0.isEmpty();	 Catch:{ all -> 0x01c4 }
            if (r0 == 0) goto L_0x00b2;
        L_0x00b1:
            goto L_0x00b6;
        L_0x00b2:
            r20.m39187j();	 Catch:{ all -> 0x01c4 }
            goto L_0x00b9;
        L_0x00b6:
            r4.L_();	 Catch:{ all -> 0x01c4 }
        L_0x00b9:
            return;
        L_0x00ba:
            if (r8 <= 0) goto L_0x019a;
        L_0x00bc:
            r11 = r1.f30008n;	 Catch:{ all -> 0x01c4 }
            r0 = r1.f30009o;	 Catch:{ all -> 0x01c4 }
            if (r8 <= r0) goto L_0x00cd;
        L_0x00c2:
            r2 = r5[r0];	 Catch:{ all -> 0x01c4 }
            r19 = r4;
            r3 = r2.f29990b;	 Catch:{ all -> 0x01c4 }
            r2 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1));
            if (r2 == 0) goto L_0x00f2;
        L_0x00cc:
            goto L_0x00cf;
        L_0x00cd:
            r19 = r4;
        L_0x00cf:
            if (r8 > r0) goto L_0x00d2;
        L_0x00d1:
            r0 = 0;
        L_0x00d2:
            r2 = r0;
            r0 = 0;
        L_0x00d4:
            if (r0 >= r8) goto L_0x00e9;
        L_0x00d6:
            r3 = r5[r2];	 Catch:{ all -> 0x01c4 }
            r3 = r3.f29990b;	 Catch:{ all -> 0x01c4 }
            r3 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1));
            if (r3 != 0) goto L_0x00df;
        L_0x00de:
            goto L_0x00e9;
        L_0x00df:
            r3 = r2 + 1;
            if (r3 != r8) goto L_0x00e5;
        L_0x00e3:
            r2 = 0;
            goto L_0x00e6;
        L_0x00e5:
            r2 = r3;
        L_0x00e6:
            r0 = r0 + 1;
            goto L_0x00d4;
        L_0x00e9:
            r1.f30009o = r2;	 Catch:{ all -> 0x01c4 }
            r0 = r5[r2];	 Catch:{ all -> 0x01c4 }
            r3 = r0.f29990b;	 Catch:{ all -> 0x01c4 }
            r1.f30008n = r3;	 Catch:{ all -> 0x01c4 }
            r0 = r2;
        L_0x00f2:
            r2 = r0;
            r0 = 0;
            r3 = 0;
        L_0x00f5:
            if (r0 >= r8) goto L_0x018d;
        L_0x00f7:
            r4 = r20.m39205i();	 Catch:{ all -> 0x01c4 }
            if (r4 == 0) goto L_0x00fe;
        L_0x00fd:
            return;
        L_0x00fe:
            r4 = r5[r2];	 Catch:{ all -> 0x01c4 }
            r9 = 0;
        L_0x0101:
            r11 = r9;
            r9 = 0;
        L_0x0103:
            r12 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1));
            if (r12 <= 0) goto L_0x0119;
        L_0x0107:
            r12 = r20.m39205i();	 Catch:{ all -> 0x01c4 }
            if (r12 == 0) goto L_0x010e;
        L_0x010d:
            return;
        L_0x010e:
            r12 = r4.f29992d;	 Catch:{ all -> 0x01c4 }
            if (r12 != 0) goto L_0x0113;
        L_0x0112:
            goto L_0x0119;
        L_0x0113:
            r11 = r12.m33678f();	 Catch:{ all -> 0x01c4 }
            if (r11 != 0) goto L_0x011e;
        L_0x0119:
            r13 = r19;
            r17 = 1;
            goto L_0x0143;
        L_0x011e:
            r12 = p289e.p292c.p293a.C5937h.m24853d(r11);	 Catch:{ all -> 0x01c4 }
            r13 = r19;
            r13.mo5000a(r12);	 Catch:{ Throwable -> 0x0131 }
            r12 = 0;
            r17 = 1;
            r6 = r6 - r17;
            r9 = r9 + 1;
            r19 = r13;
            goto L_0x0103;
        L_0x0131:
            r0 = move-exception;
            r2 = r0;
            p289e.p290a.C5903b.m24794b(r2);	 Catch:{ all -> 0x0059 }
            r13.mo5001a(r2);	 Catch:{ all -> 0x013d }
            r20.U_();	 Catch:{ all -> 0x0059 }
            return;
        L_0x013d:
            r0 = move-exception;
            r2 = r0;
            r20.U_();	 Catch:{ all -> 0x0059 }
            throw r2;	 Catch:{ all -> 0x0059 }
        L_0x0143:
            if (r9 <= 0) goto L_0x0159;
        L_0x0145:
            if (r10 != 0) goto L_0x014e;
        L_0x0147:
            r6 = r1.f29998d;	 Catch:{ all -> 0x01c4 }
            r6 = r6.m33517a(r9);	 Catch:{ all -> 0x01c4 }
            goto L_0x0153;
        L_0x014e:
            r6 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        L_0x0153:
            r14 = (long) r9;	 Catch:{ all -> 0x01c4 }
            r4.mo6325b(r14);	 Catch:{ all -> 0x01c4 }
            r14 = 0;
        L_0x0159:
            r9 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1));
            if (r9 == 0) goto L_0x0164;
        L_0x015d:
            if (r11 != 0) goto L_0x0160;
        L_0x015f:
            goto L_0x0164;
        L_0x0160:
            r9 = r11;
            r19 = r13;
            goto L_0x0101;
        L_0x0164:
            r11 = r4.f29991c;	 Catch:{ all -> 0x01c4 }
            r12 = r4.f29992d;	 Catch:{ all -> 0x01c4 }
            if (r11 == 0) goto L_0x017f;
        L_0x016a:
            if (r12 == 0) goto L_0x0172;
        L_0x016c:
            r11 = r12.m33677e();	 Catch:{ all -> 0x01c4 }
            if (r11 == 0) goto L_0x017f;
        L_0x0172:
            r1.m39196b(r4);	 Catch:{ all -> 0x01c4 }
            r3 = r20.m39205i();	 Catch:{ all -> 0x01c4 }
            if (r3 == 0) goto L_0x017c;
        L_0x017b:
            return;
        L_0x017c:
            r16 = r16 + 1;
            r3 = 1;
        L_0x017f:
            if (r9 != 0) goto L_0x0182;
        L_0x0181:
            goto L_0x018f;
        L_0x0182:
            r2 = r2 + 1;
            if (r2 != r8) goto L_0x0187;
        L_0x0186:
            r2 = 0;
        L_0x0187:
            r0 = r0 + 1;
            r19 = r13;
            goto L_0x00f5;
        L_0x018d:
            r13 = r19;
        L_0x018f:
            r1.f30009o = r2;	 Catch:{ all -> 0x01c4 }
            r0 = r5[r2];	 Catch:{ all -> 0x01c4 }
            r4 = r0.f29990b;	 Catch:{ all -> 0x01c4 }
            r1.f30008n = r4;	 Catch:{ all -> 0x01c4 }
            r0 = r16;
            goto L_0x019e;
        L_0x019a:
            r13 = r4;
            r0 = r16;
            r3 = 0;
        L_0x019e:
            if (r0 <= 0) goto L_0x01a4;
        L_0x01a0:
            r4 = (long) r0;	 Catch:{ all -> 0x01c4 }
            r1.m33779a(r4);	 Catch:{ all -> 0x01c4 }
        L_0x01a4:
            if (r3 == 0) goto L_0x01a9;
        L_0x01a6:
            r4 = r13;
            goto L_0x0004;
        L_0x01a9:
            monitor-enter(r20);	 Catch:{ all -> 0x01c4 }
            r0 = r1.f30004j;	 Catch:{ all -> 0x01bb }
            if (r0 != 0) goto L_0x01b6;
        L_0x01ae:
            r2 = 0;
            r1.f30003i = r2;	 Catch:{ all -> 0x01b3 }
            monitor-exit(r20);	 Catch:{ all -> 0x01b3 }
            return;
        L_0x01b3:
            r0 = move-exception;
            r2 = 1;
            goto L_0x01bd;
        L_0x01b6:
            r2 = 0;
            r1.f30004j = r2;	 Catch:{ all -> 0x01bb }
            monitor-exit(r20);	 Catch:{ all -> 0x01bb }
            goto L_0x01a6;
        L_0x01bb:
            r0 = move-exception;
            r2 = 0;
        L_0x01bd:
            monitor-exit(r20);	 Catch:{ all -> 0x01c2 }
            throw r0;	 Catch:{ all -> 0x01bf }
        L_0x01bf:
            r0 = move-exception;
            r3 = r2;
            goto L_0x01c6;
        L_0x01c2:
            r0 = move-exception;
            goto L_0x01bd;
        L_0x01c4:
            r0 = move-exception;
            r3 = 0;
        L_0x01c6:
            if (r3 != 0) goto L_0x01d1;
        L_0x01c8:
            monitor-enter(r20);
            r2 = 0;
            r1.f30003i = r2;	 Catch:{ all -> 0x01ce }
            monitor-exit(r20);	 Catch:{ all -> 0x01ce }
            goto L_0x01d1;
        L_0x01ce:
            r0 = move-exception;
            monitor-exit(r20);	 Catch:{ all -> 0x01ce }
            throw r0;
        L_0x01d1:
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: e.c.a.ap.e.h():void");
        }

        /* renamed from: i */
        boolean m39205i() {
            if (this.f29995a.mo5121b()) {
                return true;
            }
            Queue queue = this.f30001g;
            if (this.f29996b || queue == null || queue.isEmpty()) {
                return false;
            }
            try {
                m39187j();
                return true;
            } finally {
                U_();
            }
        }
    }

    /* renamed from: a */
    public static <T> ap<T> m39206a(boolean z) {
        if (z) {
            return C5926a.f19647a;
        }
        return C5927b.f19648a;
    }

    ap(boolean z, int i) {
        this.f30012a = z;
        this.f30013b = i;
    }

    /* renamed from: a */
    public C7367k<C5974e<? extends T>> m39207a(C7367k<? super T> c7367k) {
        C5989l c8065e = new C8065e(c7367k, this.f30012a, this.f30013b);
        C5984g c7245d = new C7245d(c8065e);
        c8065e.f29998d = c7245d;
        c7367k.m33781a(c8065e);
        c7367k.mo6324a(c7245d);
        return c8065e;
    }
}
