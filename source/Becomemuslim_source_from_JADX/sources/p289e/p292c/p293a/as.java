package p289e.p292c.p293a;

import com.facebook.common.time.Clock;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p289e.C5974e;
import p289e.C5974e.C7335a;
import p289e.C5984g;
import p289e.C5989l;
import p289e.C7367k;
import p289e.p291b.C5913a;
import p289e.p291b.C5918f;
import p289e.p292c.p295e.C5963h;
import p289e.p298d.C7333b;
import p289e.p303i.C5987e;

/* compiled from: OperatorReplay */
/* renamed from: e.c.a.as */
public final class as<T> extends C7333b<T> implements C5989l {
    /* renamed from: e */
    static final C5918f f30065e = new C72491();
    /* renamed from: b */
    final C5974e<? extends T> f30066b;
    /* renamed from: c */
    final AtomicReference<C8072e<T>> f30067c;
    /* renamed from: d */
    final C5918f<? extends C5929d<T>> f30068d;

    /* compiled from: OperatorReplay */
    /* renamed from: e.c.a.as$c */
    static final class C5928c extends AtomicReference<C5928c> {
        private static final long serialVersionUID = 245354315435971818L;
        /* renamed from: a */
        final Object f19649a;
        /* renamed from: b */
        final long f19650b;

        public C5928c(Object obj, long j) {
            this.f19649a = obj;
            this.f19650b = j;
        }
    }

    /* compiled from: OperatorReplay */
    /* renamed from: e.c.a.as$d */
    interface C5929d<T> {
        /* renamed from: a */
        void mo5122a(C7252b<T> c7252b);

        /* renamed from: a */
        void mo5123a(T t);

        /* renamed from: a */
        void mo5124a(Throwable th);

        /* renamed from: c */
        void mo5125c();
    }

    /* compiled from: OperatorReplay */
    /* renamed from: e.c.a.as$1 */
    static class C72491 implements C5918f {
        C72491() {
        }

        public Object call() {
            return new C7254g(16);
        }
    }

    /* compiled from: OperatorReplay */
    /* renamed from: e.c.a.as$a */
    static class C7251a<T> extends AtomicReference<C5928c> implements C5929d<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        /* renamed from: a */
        C5928c f25542a;
        /* renamed from: b */
        int f25543b;
        /* renamed from: c */
        long f25544c;

        /* renamed from: b */
        Object m33531b(Object obj) {
            return obj;
        }

        /* renamed from: c */
        Object m33533c(Object obj) {
            return obj;
        }

        /* renamed from: d */
        void mo6327d() {
        }

        /* renamed from: e */
        void m33536e() {
        }

        public C7251a() {
            C5928c c5928c = new C5928c(null, 0);
            this.f25542a = c5928c;
            set(c5928c);
        }

        /* renamed from: a */
        final void m33527a(C5928c c5928c) {
            this.f25542a.set(c5928c);
            this.f25542a = c5928c;
            this.f25543b++;
        }

        /* renamed from: a */
        final void m33525a() {
            C5928c c5928c = (C5928c) ((C5928c) get()).get();
            if (c5928c != null) {
                this.f25543b--;
                m33532b(c5928c);
                return;
            }
            throw new IllegalStateException("Empty list!");
        }

        /* renamed from: b */
        final void m33532b(C5928c c5928c) {
            set(c5928c);
        }

        /* renamed from: b */
        C5928c m33530b() {
            return (C5928c) get();
        }

        /* renamed from: a */
        public final void mo5123a(T t) {
            t = m33531b(C5937h.m24848a((Object) t));
            long j = this.f25544c + 1;
            this.f25544c = j;
            m33527a(new C5928c(t, j));
            mo6327d();
        }

        /* renamed from: a */
        public final void mo5124a(Throwable th) {
            th = m33531b(C5937h.m24849a(th));
            long j = this.f25544c + 1;
            this.f25544c = j;
            m33527a(new C5928c(th, j));
            m33536e();
        }

        /* renamed from: c */
        public final void mo5125c() {
            Object b = m33531b(C5937h.m24847a());
            long j = this.f25544c + 1;
            this.f25544c = j;
            m33527a(new C5928c(b, j));
            m33536e();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final void mo5122a(p289e.p292c.p293a.as.C7252b<T> r12) {
            /*
            r11 = this;
            monitor-enter(r12);
            r0 = r12.f25549e;	 Catch:{ all -> 0x00a7 }
            r1 = 1;
            if (r0 == 0) goto L_0x000a;
        L_0x0006:
            r12.f25550f = r1;	 Catch:{ all -> 0x00a7 }
            monitor-exit(r12);	 Catch:{ all -> 0x00a7 }
            return;
        L_0x000a:
            r12.f25549e = r1;	 Catch:{ all -> 0x00a7 }
            monitor-exit(r12);	 Catch:{ all -> 0x00a7 }
        L_0x000d:
            r0 = r12.mo5121b();
            if (r0 == 0) goto L_0x0014;
        L_0x0013:
            return;
        L_0x0014:
            r0 = r12.m33541c();
            r0 = (p289e.p292c.p293a.as.C5928c) r0;
            if (r0 != 0) goto L_0x0027;
        L_0x001c:
            r0 = r11.m33530b();
            r12.f25547c = r0;
            r1 = r0.f19650b;
            r12.m33538b(r1);
        L_0x0027:
            r1 = r12.mo5121b();
            if (r1 == 0) goto L_0x002e;
        L_0x002d:
            return;
        L_0x002e:
            r1 = r12.f25546b;
            if (r1 != 0) goto L_0x0033;
        L_0x0032:
            return;
        L_0x0033:
            r2 = r12.get();
            r4 = 0;
            r6 = r4;
        L_0x003a:
            r8 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
            if (r8 == 0) goto L_0x0083;
        L_0x003e:
            r8 = r0.get();
            r8 = (p289e.p292c.p293a.as.C5928c) r8;
            if (r8 == 0) goto L_0x0083;
        L_0x0046:
            r0 = r8.f19649a;
            r0 = r11.m33533c(r0);
            r9 = 0;
            r10 = p289e.p292c.p293a.C5937h.m24850a(r1, r0);	 Catch:{ Throwable -> 0x0062 }
            if (r10 == 0) goto L_0x0056;
        L_0x0053:
            r12.f25547c = r9;	 Catch:{ Throwable -> 0x0062 }
            return;
        L_0x0056:
            r9 = 1;
            r6 = r6 + r9;
            r0 = r12.mo5121b();
            if (r0 == 0) goto L_0x0060;
        L_0x005f:
            return;
        L_0x0060:
            r0 = r8;
            goto L_0x003a;
        L_0x0062:
            r2 = move-exception;
            r12.f25547c = r9;
            p289e.p290a.C5903b.m24794b(r2);
            r12.U_();
            r12 = p289e.p292c.p293a.C5937h.m24852c(r0);
            if (r12 != 0) goto L_0x0082;
        L_0x0071:
            r12 = p289e.p292c.p293a.C5937h.m24851b(r0);
            if (r12 != 0) goto L_0x0082;
        L_0x0077:
            r12 = p289e.p292c.p293a.C5937h.m24853d(r0);
            r12 = p289e.p290a.C5910g.m24799a(r2, r12);
            r1.mo5001a(r12);
        L_0x0082:
            return;
        L_0x0083:
            r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));
            if (r1 == 0) goto L_0x0095;
        L_0x0087:
            r12.f25547c = r0;
            r0 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
            r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1));
            if (r0 == 0) goto L_0x0095;
        L_0x0092:
            r12.m33540c(r6);
        L_0x0095:
            monitor-enter(r12);
            r0 = r12.f25550f;	 Catch:{ all -> 0x00a4 }
            r1 = 0;
            if (r0 != 0) goto L_0x009f;
        L_0x009b:
            r12.f25549e = r1;	 Catch:{ all -> 0x00a4 }
            monitor-exit(r12);	 Catch:{ all -> 0x00a4 }
            return;
        L_0x009f:
            r12.f25550f = r1;	 Catch:{ all -> 0x00a4 }
            monitor-exit(r12);	 Catch:{ all -> 0x00a4 }
            goto L_0x000d;
        L_0x00a4:
            r0 = move-exception;
            monitor-exit(r12);	 Catch:{ all -> 0x00a4 }
            throw r0;
        L_0x00a7:
            r0 = move-exception;
            monitor-exit(r12);	 Catch:{ all -> 0x00a7 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: e.c.a.as.a.a(e.c.a.as$b):void");
        }
    }

    /* compiled from: OperatorReplay */
    /* renamed from: e.c.a.as$b */
    static final class C7252b<T> extends AtomicLong implements C5984g, C5989l {
        private static final long serialVersionUID = -4453897557930727610L;
        /* renamed from: a */
        final C8072e<T> f25545a;
        /* renamed from: b */
        C7367k<? super T> f25546b;
        /* renamed from: c */
        Object f25547c;
        /* renamed from: d */
        final AtomicLong f25548d = new AtomicLong();
        /* renamed from: e */
        boolean f25549e;
        /* renamed from: f */
        boolean f25550f;

        public C7252b(C8072e<T> c8072e, C7367k<? super T> c7367k) {
            this.f25545a = c8072e;
            this.f25546b = c7367k;
        }

        /* renamed from: a */
        public void mo5119a(long j) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i >= 0) {
                long j2;
                long j3;
                do {
                    j2 = get();
                    if (j2 != Long.MIN_VALUE) {
                        if (j2 < 0 || i != 0) {
                            j3 = j2 + j;
                            if (j3 < 0) {
                                j3 = Clock.MAX_TIME;
                            }
                        } else {
                            return;
                        }
                    }
                    return;
                } while (!compareAndSet(j2, j3));
                m33538b(j);
                this.f25545a.m39244c(this);
                this.f25545a.f30049a.mo5122a(this);
            }
        }

        /* renamed from: b */
        void m33538b(long j) {
            long j2;
            long j3;
            do {
                j2 = this.f25548d.get();
                j3 = j2 + j;
                if (j3 < 0) {
                    j3 = Clock.MAX_TIME;
                }
            } while (!this.f25548d.compareAndSet(j2, j3));
        }

        /* renamed from: c */
        public long m33540c(long j) {
            if (j > 0) {
                long j2;
                long j3;
                do {
                    j3 = get();
                    if (j3 == Long.MIN_VALUE) {
                        return Long.MIN_VALUE;
                    }
                    j2 = j3 - j;
                    if (j2 < 0) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("More produced (");
                        stringBuilder.append(j);
                        stringBuilder.append(") than requested (");
                        stringBuilder.append(j3);
                        stringBuilder.append(")");
                        throw new IllegalStateException(stringBuilder.toString());
                    }
                } while (!compareAndSet(j3, j2));
                return j2;
            }
            throw new IllegalArgumentException("Cant produce zero or less");
        }

        /* renamed from: b */
        public boolean mo5121b() {
            return get() == Long.MIN_VALUE;
        }

        public void U_() {
            if (get() != Long.MIN_VALUE && getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.f25545a.m39243b(this);
                this.f25545a.m39244c(this);
                this.f25546b = null;
            }
        }

        /* renamed from: c */
        <U> U m33541c() {
            return this.f25547c;
        }
    }

    /* compiled from: OperatorReplay */
    /* renamed from: e.c.a.as$g */
    static final class C7254g<T> extends ArrayList<Object> implements C5929d<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        /* renamed from: a */
        volatile int f25552a;

        public C7254g(int i) {
            super(i);
        }

        /* renamed from: a */
        public void mo5123a(T t) {
            add(C5937h.m24848a((Object) t));
            this.f25552a++;
        }

        /* renamed from: a */
        public void mo5124a(Throwable th) {
            add(C5937h.m24849a(th));
            this.f25552a++;
        }

        /* renamed from: c */
        public void mo5125c() {
            add(C5937h.m24847a());
            this.f25552a++;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public void mo5122a(p289e.p292c.p293a.as.C7252b<T> r13) {
            /*
            r12 = this;
            monitor-enter(r13);
            r0 = r13.f25549e;	 Catch:{ all -> 0x0095 }
            r1 = 1;
            if (r0 == 0) goto L_0x000a;
        L_0x0006:
            r13.f25550f = r1;	 Catch:{ all -> 0x0095 }
            monitor-exit(r13);	 Catch:{ all -> 0x0095 }
            return;
        L_0x000a:
            r13.f25549e = r1;	 Catch:{ all -> 0x0095 }
            monitor-exit(r13);	 Catch:{ all -> 0x0095 }
        L_0x000d:
            r0 = r13.mo5121b();
            if (r0 == 0) goto L_0x0014;
        L_0x0013:
            return;
        L_0x0014:
            r0 = r12.f25552a;
            r1 = r13.m33541c();
            r1 = (java.lang.Integer) r1;
            r2 = 0;
            if (r1 == 0) goto L_0x0024;
        L_0x001f:
            r1 = r1.intValue();
            goto L_0x0025;
        L_0x0024:
            r1 = 0;
        L_0x0025:
            r3 = r13.f25546b;
            if (r3 != 0) goto L_0x002a;
        L_0x0029:
            return;
        L_0x002a:
            r4 = r13.get();
            r6 = 0;
            r8 = r6;
        L_0x0031:
            r10 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1));
            if (r10 == 0) goto L_0x006e;
        L_0x0035:
            if (r1 >= r0) goto L_0x006e;
        L_0x0037:
            r10 = r12.get(r1);
            r11 = p289e.p292c.p293a.C5937h.m24850a(r3, r10);	 Catch:{ Throwable -> 0x004f }
            if (r11 == 0) goto L_0x0042;
        L_0x0041:
            return;
        L_0x0042:
            r10 = r13.mo5121b();
            if (r10 == 0) goto L_0x0049;
        L_0x0048:
            return;
        L_0x0049:
            r1 = r1 + 1;
            r10 = 1;
            r8 = r8 + r10;
            goto L_0x0031;
        L_0x004f:
            r0 = move-exception;
            p289e.p290a.C5903b.m24794b(r0);
            r13.U_();
            r13 = p289e.p292c.p293a.C5937h.m24852c(r10);
            if (r13 != 0) goto L_0x006d;
        L_0x005c:
            r13 = p289e.p292c.p293a.C5937h.m24851b(r10);
            if (r13 != 0) goto L_0x006d;
        L_0x0062:
            r13 = p289e.p292c.p293a.C5937h.m24853d(r10);
            r13 = p289e.p290a.C5910g.m24799a(r0, r13);
            r3.mo5001a(r13);
        L_0x006d:
            return;
        L_0x006e:
            r0 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));
            if (r0 == 0) goto L_0x0084;
        L_0x0072:
            r0 = java.lang.Integer.valueOf(r1);
            r13.f25547c = r0;
            r0 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
            r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
            if (r0 == 0) goto L_0x0084;
        L_0x0081:
            r13.m33540c(r8);
        L_0x0084:
            monitor-enter(r13);
            r0 = r13.f25550f;	 Catch:{ all -> 0x0092 }
            if (r0 != 0) goto L_0x008d;
        L_0x0089:
            r13.f25549e = r2;	 Catch:{ all -> 0x0092 }
            monitor-exit(r13);	 Catch:{ all -> 0x0092 }
            return;
        L_0x008d:
            r13.f25550f = r2;	 Catch:{ all -> 0x0092 }
            monitor-exit(r13);	 Catch:{ all -> 0x0092 }
            goto L_0x000d;
        L_0x0092:
            r0 = move-exception;
            monitor-exit(r13);	 Catch:{ all -> 0x0092 }
            throw r0;
        L_0x0095:
            r0 = move-exception;
            monitor-exit(r13);	 Catch:{ all -> 0x0095 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: e.c.a.as.g.a(e.c.a.as$b):void");
        }
    }

    /* compiled from: OperatorReplay */
    /* renamed from: e.c.a.as$e */
    static final class C8072e<T> extends C7367k<T> implements C5989l {
        /* renamed from: c */
        static final C7252b[] f30047c = new C7252b[0];
        /* renamed from: d */
        static final C7252b[] f30048d = new C7252b[0];
        /* renamed from: a */
        final C5929d<T> f30049a;
        /* renamed from: b */
        boolean f30050b;
        /* renamed from: e */
        volatile boolean f30051e;
        /* renamed from: f */
        final C5963h<C7252b<T>> f30052f = new C5963h();
        /* renamed from: g */
        C7252b<T>[] f30053g = f30047c;
        /* renamed from: h */
        volatile long f30054h;
        /* renamed from: i */
        long f30055i;
        /* renamed from: j */
        final AtomicBoolean f30056j = new AtomicBoolean();
        /* renamed from: k */
        boolean f30057k;
        /* renamed from: l */
        boolean f30058l;
        /* renamed from: m */
        long f30059m;
        /* renamed from: n */
        long f30060n;
        /* renamed from: o */
        volatile C5984g f30061o;
        /* renamed from: p */
        List<C7252b<T>> f30062p;
        /* renamed from: q */
        boolean f30063q;

        /* compiled from: OperatorReplay */
        /* renamed from: e.c.a.as$e$1 */
        class C72531 implements C5913a {
            /* renamed from: a */
            final /* synthetic */ C8072e f25551a;

            C72531(C8072e c8072e) {
                this.f25551a = c8072e;
            }

            /* renamed from: a */
            public void mo4985a() {
                if (!this.f25551a.f30051e) {
                    synchronized (this.f25551a.f30052f) {
                        if (!this.f25551a.f30051e) {
                            this.f25551a.f30052f.m24936a();
                            C8072e c8072e = this.f25551a;
                            c8072e.f30054h++;
                            this.f25551a.f30051e = true;
                        }
                    }
                }
            }
        }

        public C8072e(C5929d<T> c5929d) {
            this.f30049a = c5929d;
            m33779a(0);
        }

        /* renamed from: d */
        void m39245d() {
            m33781a(C5987e.m25118a(new C72531(this)));
        }

        /* renamed from: a */
        boolean m39242a(C7252b<T> c7252b) {
            if (c7252b == null) {
                throw new NullPointerException();
            } else if (this.f30051e) {
                return false;
            } else {
                synchronized (this.f30052f) {
                    if (this.f30051e) {
                        return false;
                    }
                    this.f30052f.m24938a((Object) c7252b);
                    this.f30054h++;
                    return true;
                }
            }
        }

        /* renamed from: b */
        void m39243b(C7252b<T> c7252b) {
            if (!this.f30051e) {
                synchronized (this.f30052f) {
                    if (this.f30051e) {
                        return;
                    }
                    this.f30052f.m24940b(c7252b);
                    if (this.f30052f.m24941c() != null) {
                        this.f30053g = f30047c;
                    }
                    this.f30054h++;
                }
            }
        }

        /* renamed from: a */
        public void mo6324a(C5984g c5984g) {
            if (this.f30061o == null) {
                this.f30061o = c5984g;
                m39244c(null);
                m39247f();
                return;
            }
            throw new IllegalStateException("Only a single producer can be set on a Subscriber.");
        }

        /* renamed from: a */
        public void mo5000a(T t) {
            if (!this.f30050b) {
                this.f30049a.mo5123a((Object) t);
                m39247f();
            }
        }

        /* renamed from: a */
        public void mo5001a(Throwable th) {
            if (!this.f30050b) {
                this.f30050b = true;
                try {
                    this.f30049a.mo5124a(th);
                    m39247f();
                } finally {
                    U_();
                }
            }
        }

        public void L_() {
            if (!this.f30050b) {
                this.f30050b = true;
                try {
                    this.f30049a.mo5125c();
                    m39247f();
                } finally {
                    U_();
                }
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: c */
        void m39244c(p289e.p292c.p293a.as.C7252b<T> r10) {
            /*
            r9 = this;
            r0 = r9.mo5121b();
            if (r0 == 0) goto L_0x0007;
        L_0x0006:
            return;
        L_0x0007:
            monitor-enter(r9);
            r0 = r9.f30057k;	 Catch:{ all -> 0x00b4 }
            r1 = 1;
            if (r0 == 0) goto L_0x0024;
        L_0x000d:
            if (r10 == 0) goto L_0x001e;
        L_0x000f:
            r0 = r9.f30062p;	 Catch:{ all -> 0x00b4 }
            if (r0 != 0) goto L_0x001a;
        L_0x0013:
            r0 = new java.util.ArrayList;	 Catch:{ all -> 0x00b4 }
            r0.<init>();	 Catch:{ all -> 0x00b4 }
            r9.f30062p = r0;	 Catch:{ all -> 0x00b4 }
        L_0x001a:
            r0.add(r10);	 Catch:{ all -> 0x00b4 }
            goto L_0x0020;
        L_0x001e:
            r9.f30063q = r1;	 Catch:{ all -> 0x00b4 }
        L_0x0020:
            r9.f30058l = r1;	 Catch:{ all -> 0x00b4 }
            monitor-exit(r9);	 Catch:{ all -> 0x00b4 }
            return;
        L_0x0024:
            r9.f30057k = r1;	 Catch:{ all -> 0x00b4 }
            monitor-exit(r9);	 Catch:{ all -> 0x00b4 }
            r0 = r9.f30059m;
            r2 = 0;
            if (r10 == 0) goto L_0x0037;
        L_0x002c:
            r10 = r10.f25548d;
            r3 = r10.get();
            r3 = java.lang.Math.max(r0, r3);
            goto L_0x0052;
        L_0x0037:
            r10 = r9.m39246e();
            r3 = r10.length;
            r5 = r0;
            r4 = 0;
        L_0x003e:
            if (r4 >= r3) goto L_0x0051;
        L_0x0040:
            r7 = r10[r4];
            if (r7 == 0) goto L_0x004e;
        L_0x0044:
            r7 = r7.f25548d;
            r7 = r7.get();
            r5 = java.lang.Math.max(r5, r7);
        L_0x004e:
            r4 = r4 + 1;
            goto L_0x003e;
        L_0x0051:
            r3 = r5;
        L_0x0052:
            r9.m39238a(r3, r0);
        L_0x0055:
            r10 = r9.mo5121b();
            if (r10 == 0) goto L_0x005c;
        L_0x005b:
            return;
        L_0x005c:
            monitor-enter(r9);
            r10 = r9.f30058l;	 Catch:{ all -> 0x00b1 }
            if (r10 != 0) goto L_0x0065;
        L_0x0061:
            r9.f30057k = r2;	 Catch:{ all -> 0x00b1 }
            monitor-exit(r9);	 Catch:{ all -> 0x00b1 }
            return;
        L_0x0065:
            r9.f30058l = r2;	 Catch:{ all -> 0x00b1 }
            r10 = r9.f30062p;	 Catch:{ all -> 0x00b1 }
            r0 = 0;
            r9.f30062p = r0;	 Catch:{ all -> 0x00b1 }
            r0 = r9.f30063q;	 Catch:{ all -> 0x00b1 }
            r9.f30063q = r2;	 Catch:{ all -> 0x00b1 }
            monitor-exit(r9);	 Catch:{ all -> 0x00b1 }
            r3 = r9.f30059m;
            if (r10 == 0) goto L_0x0091;
        L_0x0075:
            r10 = r10.iterator();
            r5 = r3;
        L_0x007a:
            r1 = r10.hasNext();
            if (r1 == 0) goto L_0x0092;
        L_0x0080:
            r1 = r10.next();
            r1 = (p289e.p292c.p293a.as.C7252b) r1;
            r1 = r1.f25548d;
            r7 = r1.get();
            r5 = java.lang.Math.max(r5, r7);
            goto L_0x007a;
        L_0x0091:
            r5 = r3;
        L_0x0092:
            if (r0 == 0) goto L_0x00ad;
        L_0x0094:
            r10 = r9.m39246e();
            r0 = r10.length;
            r1 = 0;
        L_0x009a:
            if (r1 >= r0) goto L_0x00ad;
        L_0x009c:
            r7 = r10[r1];
            if (r7 == 0) goto L_0x00aa;
        L_0x00a0:
            r7 = r7.f25548d;
            r7 = r7.get();
            r5 = java.lang.Math.max(r5, r7);
        L_0x00aa:
            r1 = r1 + 1;
            goto L_0x009a;
        L_0x00ad:
            r9.m39238a(r5, r3);
            goto L_0x0055;
        L_0x00b1:
            r10 = move-exception;
            monitor-exit(r9);	 Catch:{ all -> 0x00b1 }
            throw r10;
        L_0x00b4:
            r10 = move-exception;
            monitor-exit(r9);	 Catch:{ all -> 0x00b4 }
            throw r10;
            */
            throw new UnsupportedOperationException("Method not decompiled: e.c.a.as.e.c(e.c.a.as$b):void");
        }

        /* renamed from: e */
        C7252b<T>[] m39246e() {
            Object obj;
            synchronized (this.f30052f) {
                Object d = this.f30052f.m24942d();
                int length = d.length;
                obj = new C7252b[length];
                System.arraycopy(d, 0, obj, 0, length);
            }
            return obj;
        }

        /* renamed from: a */
        void m39238a(long j, long j2) {
            long j3 = this.f30060n;
            C5984g c5984g = this.f30061o;
            j2 = j - j2;
            if (j2 != 0) {
                this.f30059m = j;
                if (c5984g == null) {
                    j3 += j2;
                    if (j3 < 0) {
                        j3 = Clock.MAX_TIME;
                    }
                    this.f30060n = j3;
                } else if (j3 != 0) {
                    this.f30060n = 0;
                    c5984g.mo5119a(j3 + j2);
                } else {
                    c5984g.mo5119a(j2);
                }
            } else if (j3 != 0 && c5984g != null) {
                this.f30060n = 0;
                c5984g.mo5119a(j3);
            }
        }

        /* renamed from: f */
        void m39247f() {
            C7252b[] c7252bArr = this.f30053g;
            int i = 0;
            if (this.f30055i != this.f30054h) {
                synchronized (this.f30052f) {
                    c7252bArr = this.f30053g;
                    Object d = this.f30052f.m24942d();
                    int length = d.length;
                    if (c7252bArr.length != length) {
                        c7252bArr = new C7252b[length];
                        this.f30053g = c7252bArr;
                    }
                    System.arraycopy(d, 0, c7252bArr, 0, length);
                    this.f30055i = this.f30054h;
                }
            }
            C5929d c5929d = this.f30049a;
            int length2 = c7252bArr.length;
            while (i < length2) {
                C7252b c7252b = c7252bArr[i];
                if (c7252b != null) {
                    c5929d.mo5122a(c7252b);
                }
                i++;
            }
        }
    }

    /* compiled from: OperatorReplay */
    /* renamed from: e.c.a.as$f */
    static final class C8073f<T> extends C7251a<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        /* renamed from: d */
        final int f30064d;

        public C8073f(int i) {
            this.f30064d = i;
        }

        /* renamed from: d */
        void mo6327d() {
            if (this.b > this.f30064d) {
                m33525a();
            }
        }
    }

    /* renamed from: h */
    public static <T> C7333b<T> m39251h(C5974e<? extends T> c5974e) {
        return as.m39250a((C5974e) c5974e, f30065e);
    }

    /* renamed from: a */
    public static <T> C7333b<T> m39249a(C5974e<? extends T> c5974e, final int i) {
        if (i == Integer.MAX_VALUE) {
            return as.m39251h(c5974e);
        }
        return as.m39250a((C5974e) c5974e, new C5918f<C5929d<T>>() {
            public /* synthetic */ Object call() {
                return m33524a();
            }

            /* renamed from: a */
            public C5929d<T> m33524a() {
                return new C8073f(i);
            }
        });
    }

    /* renamed from: a */
    static <T> C7333b<T> m39250a(C5974e<? extends T> c5974e, final C5918f<? extends C5929d<T>> c5918f) {
        final AtomicReference atomicReference = new AtomicReference();
        return new as(new C7335a<T>() {
            /* renamed from: b */
            public /* synthetic */ void mo4974b(Object obj) {
                m39236a((C7367k) obj);
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            /* renamed from: a */
            public void m39236a(p289e.C7367k<? super T> r4) {
                /*
                r3 = this;
            L_0x0000:
                r0 = r0;
                r0 = r0.get();
                r0 = (p289e.p292c.p293a.as.C8072e) r0;
                if (r0 != 0) goto L_0x0024;
            L_0x000a:
                r1 = new e.c.a.as$e;
                r2 = r4;
                r2 = r2.call();
                r2 = (p289e.p292c.p293a.as.C5929d) r2;
                r1.<init>(r2);
                r1.m39245d();
                r2 = r0;
                r0 = r2.compareAndSet(r0, r1);
                if (r0 != 0) goto L_0x0023;
            L_0x0022:
                goto L_0x0000;
            L_0x0023:
                r0 = r1;
            L_0x0024:
                r1 = new e.c.a.as$b;
                r1.<init>(r0, r4);
                r0.m39242a(r1);
                r4.m33781a(r1);
                r0 = r0.f30049a;
                r0.mo5122a(r1);
                r4.mo6324a(r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: e.c.a.as.3.a(e.k):void");
            }
        }, c5974e, atomicReference, c5918f);
    }

    private as(C7335a<T> c7335a, C5974e<? extends T> c5974e, AtomicReference<C8072e<T>> atomicReference, C5918f<? extends C5929d<T>> c5918f) {
        super(c7335a);
        this.f30066b = c5974e;
        this.f30067c = atomicReference;
        this.f30068d = c5918f;
    }

    public void U_() {
        this.f30067c.lazySet(null);
    }

    /* renamed from: b */
    public boolean mo5121b() {
        C8072e c8072e = (C8072e) this.f30067c.get();
        if (c8072e != null) {
            if (!c8072e.mo5121b()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: d */
    public void mo6326d(p289e.p291b.C5914b<? super p289e.C5989l> r5) {
        /*
        r4 = this;
    L_0x0000:
        r0 = r4.f30067c;
        r0 = r0.get();
        r0 = (p289e.p292c.p293a.as.C8072e) r0;
        if (r0 == 0) goto L_0x0010;
    L_0x000a:
        r1 = r0.mo5121b();
        if (r1 == 0) goto L_0x002a;
    L_0x0010:
        r1 = new e.c.a.as$e;
        r2 = r4.f30068d;
        r2 = r2.call();
        r2 = (p289e.p292c.p293a.as.C5929d) r2;
        r1.<init>(r2);
        r1.m39245d();
        r2 = r4.f30067c;
        r0 = r2.compareAndSet(r0, r1);
        if (r0 != 0) goto L_0x0029;
    L_0x0028:
        goto L_0x0000;
    L_0x0029:
        r0 = r1;
    L_0x002a:
        r1 = r0.f30056j;
        r1 = r1.get();
        r2 = 1;
        r3 = 0;
        if (r1 != 0) goto L_0x003d;
    L_0x0034:
        r1 = r0.f30056j;
        r1 = r1.compareAndSet(r3, r2);
        if (r1 == 0) goto L_0x003d;
    L_0x003c:
        goto L_0x003e;
    L_0x003d:
        r2 = 0;
    L_0x003e:
        r5.mo4974b(r0);
        if (r2 == 0) goto L_0x0048;
    L_0x0043:
        r5 = r4.f30066b;
        r5.m25007a(r0);
    L_0x0048:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.as.d(e.b.b):void");
    }
}
