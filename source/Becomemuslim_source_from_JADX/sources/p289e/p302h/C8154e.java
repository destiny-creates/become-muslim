package p289e.p302h;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import p289e.C5974e.C7335a;
import p289e.C5982f;
import p289e.C7367k;
import p289e.p291b.C5913a;
import p289e.p291b.C5914b;
import p289e.p291b.C5916d;
import p289e.p292c.p293a.C5937h;
import p289e.p303i.C5987e;

/* compiled from: SubjectSubscriptionManager */
/* renamed from: e.h.e */
final class C8154e<T> extends AtomicReference<C5985a<T>> implements C7335a<T> {
    private static final long serialVersionUID = 6035251036011671568L;
    /* renamed from: a */
    volatile Object f30320a;
    /* renamed from: b */
    boolean f30321b = true;
    /* renamed from: c */
    C5914b<C7358b<T>> f30322c = C5916d.m24828a();
    /* renamed from: d */
    C5914b<C7358b<T>> f30323d = C5916d.m24828a();
    /* renamed from: e */
    C5914b<C7358b<T>> f30324e = C5916d.m24828a();

    /* compiled from: SubjectSubscriptionManager */
    /* renamed from: e.h.e$a */
    protected static final class C5985a<T> {
        /* renamed from: c */
        static final C7358b[] f19780c = new C7358b[0];
        /* renamed from: d */
        static final C5985a f19781d = new C5985a(true, f19780c);
        /* renamed from: e */
        static final C5985a f19782e = new C5985a(false, f19780c);
        /* renamed from: a */
        final boolean f19783a;
        /* renamed from: b */
        final C7358b[] f19784b;

        public C5985a(boolean z, C7358b[] c7358bArr) {
            this.f19783a = z;
            this.f19784b = c7358bArr;
        }

        /* renamed from: a */
        public C5985a m25113a(C7358b c7358b) {
            int length = this.f19784b.length;
            Object obj = new C7358b[(length + 1)];
            System.arraycopy(this.f19784b, 0, obj, 0, length);
            obj[length] = c7358b;
            return new C5985a(this.f19783a, obj);
        }

        /* renamed from: b */
        public C5985a m25114b(C7358b c7358b) {
            C7358b[] c7358bArr = this.f19784b;
            if (r1 == 1 && c7358bArr[0] == c7358b) {
                return f19782e;
            }
            if (r1 == 0) {
                return this;
            }
            int i = r1 - 1;
            C7358b c7358b2 = new C7358b[i];
            int i2 = 0;
            for (C7358b c7358b3 : c7358bArr) {
                if (c7358b3 != c7358b) {
                    if (i2 == i) {
                        return this;
                    }
                    int i3 = i2 + 1;
                    c7358b2[i2] = c7358b3;
                    i2 = i3;
                }
            }
            if (i2 == 0) {
                return f19782e;
            }
            if (i2 < i) {
                c7358b = new C7358b[i2];
                System.arraycopy(c7358b2, 0, c7358b, 0, i2);
            } else {
                c7358b = c7358b2;
            }
            return new C5985a(this.f19783a, c7358b);
        }
    }

    /* compiled from: SubjectSubscriptionManager */
    /* renamed from: e.h.e$b */
    protected static final class C7358b<T> implements C5982f<T> {
        /* renamed from: a */
        final C7367k<? super T> f25756a;
        /* renamed from: b */
        boolean f25757b = true;
        /* renamed from: c */
        boolean f25758c;
        /* renamed from: d */
        List<Object> f25759d;
        /* renamed from: e */
        boolean f25760e;

        public C7358b(C7367k<? super T> c7367k) {
            this.f25756a = c7367k;
        }

        /* renamed from: a */
        public void mo5000a(T t) {
            this.f25756a.mo5000a((Object) t);
        }

        /* renamed from: a */
        public void mo5001a(Throwable th) {
            this.f25756a.mo5001a(th);
        }

        public void L_() {
            this.f25756a.L_();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: b */
        void m33757b(java.lang.Object r2) {
            /*
            r1 = this;
            r0 = r1.f25760e;
            if (r0 != 0) goto L_0x0026;
        L_0x0004:
            monitor-enter(r1);
            r0 = 0;
            r1.f25757b = r0;	 Catch:{ all -> 0x0023 }
            r0 = r1.f25758c;	 Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x001e;
        L_0x000c:
            r0 = r1.f25759d;	 Catch:{ all -> 0x0023 }
            if (r0 != 0) goto L_0x0017;
        L_0x0010:
            r0 = new java.util.ArrayList;	 Catch:{ all -> 0x0023 }
            r0.<init>();	 Catch:{ all -> 0x0023 }
            r1.f25759d = r0;	 Catch:{ all -> 0x0023 }
        L_0x0017:
            r0 = r1.f25759d;	 Catch:{ all -> 0x0023 }
            r0.add(r2);	 Catch:{ all -> 0x0023 }
            monitor-exit(r1);	 Catch:{ all -> 0x0023 }
            return;
        L_0x001e:
            monitor-exit(r1);	 Catch:{ all -> 0x0023 }
            r0 = 1;
            r1.f25760e = r0;
            goto L_0x0026;
        L_0x0023:
            r2 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0023 }
            throw r2;
        L_0x0026:
            r0 = r1.f25756a;
            p289e.p292c.p293a.C5937h.m24850a(r0, r2);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: e.h.e.b.b(java.lang.Object):void");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: c */
        void m33758c(java.lang.Object r2) {
            /*
            r1 = this;
            monitor-enter(r1);
            r0 = r1.f25757b;	 Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x001a;
        L_0x0005:
            r0 = r1.f25758c;	 Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x000a;
        L_0x0009:
            goto L_0x001a;
        L_0x000a:
            r0 = 0;
            r1.f25757b = r0;	 Catch:{ all -> 0x001c }
            if (r2 == 0) goto L_0x0010;
        L_0x000f:
            r0 = 1;
        L_0x0010:
            r1.f25758c = r0;	 Catch:{ all -> 0x001c }
            monitor-exit(r1);	 Catch:{ all -> 0x001c }
            if (r2 == 0) goto L_0x0019;
        L_0x0015:
            r0 = 0;
            r1.m33756a(r0, r2);
        L_0x0019:
            return;
        L_0x001a:
            monitor-exit(r1);	 Catch:{ all -> 0x001c }
            return;
        L_0x001c:
            r2 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x001c }
            throw r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: e.h.e.b.c(java.lang.Object):void");
        }

        /* renamed from: a */
        void m33756a(List<Object> list, Object obj) {
            Object obj2 = 1;
            Object obj3 = 1;
            while (true) {
                if (list != null) {
                    try {
                        for (Object d : list) {
                            m33759d(d);
                        }
                    } catch (Throwable th) {
                        list = th;
                        obj2 = null;
                    }
                }
                if (obj3 != null) {
                    m33759d(obj);
                    obj3 = null;
                }
                synchronized (this) {
                    try {
                        list = this.f25759d;
                        this.f25759d = null;
                        if (list == null) {
                            this.f25758c = false;
                            try {
                                return;
                            } catch (Throwable th2) {
                                list = th2;
                                try {
                                    throw list;
                                } catch (Throwable th3) {
                                    list = th3;
                                }
                            }
                        }
                    } catch (Throwable th4) {
                        list = th4;
                        obj2 = null;
                    }
                }
            }
            if (obj2 == null) {
                synchronized (this) {
                    this.f25758c = false;
                }
            }
            throw list;
        }

        /* renamed from: d */
        void m33759d(Object obj) {
            if (obj != null) {
                C5937h.m24850a(this.f25756a, obj);
            }
        }
    }

    /* renamed from: b */
    public /* synthetic */ void mo4974b(Object obj) {
        m39552a((C7367k) obj);
    }

    public C8154e() {
        super(C5985a.f19782e);
    }

    /* renamed from: a */
    public void m39552a(C7367k<? super T> c7367k) {
        C7358b c7358b = new C7358b(c7367k);
        m39553a(c7367k, c7358b);
        this.f30322c.mo4974b(c7358b);
        if (!c7367k.mo5121b() && m39555a(c7358b) && c7367k.mo5121b() != null) {
            m39556b(c7358b);
        }
    }

    /* renamed from: a */
    void m39553a(C7367k<? super T> c7367k, final C7358b<T> c7358b) {
        c7367k.m33781a(C5987e.m25118a(new C5913a(this) {
            /* renamed from: b */
            final /* synthetic */ C8154e f25755b;

            /* renamed from: a */
            public void mo4985a() {
                this.f25755b.m39556b(c7358b);
            }
        }));
    }

    /* renamed from: a */
    void m39554a(Object obj) {
        this.f30320a = obj;
    }

    /* renamed from: a */
    Object m39551a() {
        return this.f30320a;
    }

    /* renamed from: a */
    boolean m39555a(C7358b<T> c7358b) {
        C5985a c5985a;
        do {
            c5985a = (C5985a) get();
            if (c5985a.f19783a) {
                this.f30324e.mo4974b(c7358b);
                return null;
            }
        } while (!compareAndSet(c5985a, c5985a.m25113a(c7358b)));
        this.f30323d.mo4974b(c7358b);
        return true;
    }

    /* renamed from: b */
    void m39556b(C7358b<T> c7358b) {
        C5985a c5985a;
        C5985a b;
        do {
            c5985a = (C5985a) get();
            if (!c5985a.f19783a) {
                b = c5985a.m25114b(c7358b);
                if (b == c5985a) {
                    break;
                }
            } else {
                return;
            }
        } while (!compareAndSet(c5985a, b));
    }

    /* renamed from: c */
    C7358b<T>[] m39558c(Object obj) {
        m39554a(obj);
        return ((C5985a) get()).f19784b;
    }

    /* renamed from: d */
    C7358b<T>[] m39559d(Object obj) {
        m39554a(obj);
        this.f30321b = null;
        if (((C5985a) get()).f19783a != null) {
            return C5985a.f19780c;
        }
        return ((C5985a) getAndSet(C5985a.f19781d)).f19784b;
    }
}
