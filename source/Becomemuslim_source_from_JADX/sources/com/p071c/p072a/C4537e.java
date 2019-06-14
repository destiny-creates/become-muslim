package com.p071c.p072a;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import p289e.C5974e.C7335a;
import p289e.C5982f;
import p289e.C7367k;
import p289e.p291b.C5913a;
import p289e.p291b.C5914b;
import p289e.p291b.C5916d;
import p289e.p303i.C5987e;

/* compiled from: RelaySubscriptionManager */
/* renamed from: com.c.a.e */
final class C4537e<T> extends AtomicReference<C1111b<T>> implements C7335a<T> {
    /* renamed from: a */
    volatile Object f12268a;
    /* renamed from: b */
    boolean f12269b = true;
    /* renamed from: c */
    C5914b<C3457a<T>> f12270c = C5916d.a();
    /* renamed from: d */
    C5914b<C3457a<T>> f12271d = C5916d.a();

    /* compiled from: RelaySubscriptionManager */
    /* renamed from: com.c.a.e$b */
    static final class C1111b<T> {
        /* renamed from: a */
        static final C1111b f3126a = new C1111b(new C3457a[0]);
        /* renamed from: b */
        final C3457a[] f3127b;

        C1111b(C3457a[] c3457aArr) {
            this.f3127b = c3457aArr;
        }

        /* renamed from: a */
        C1111b m3939a(C3457a c3457a) {
            int length = this.f3127b.length;
            Object obj = new C3457a[(length + 1)];
            System.arraycopy(this.f3127b, 0, obj, 0, length);
            obj[length] = c3457a;
            return new C1111b(obj);
        }

        /* renamed from: b */
        C1111b m3940b(C3457a c3457a) {
            C3457a[] c3457aArr = this.f3127b;
            if (r1 == 1 && c3457aArr[0] == c3457a) {
                return f3126a;
            }
            if (r1 == 0) {
                return this;
            }
            int i = r1 - 1;
            C3457a c3457a2 = new C3457a[i];
            int i2 = 0;
            for (C3457a c3457a3 : c3457aArr) {
                if (c3457a3 != c3457a) {
                    if (i2 == i) {
                        return this;
                    }
                    int i3 = i2 + 1;
                    c3457a2[i2] = c3457a3;
                    i2 = i3;
                }
            }
            if (i2 == 0) {
                return f3126a;
            }
            if (i2 < i) {
                c3457a = new C3457a[i2];
                System.arraycopy(c3457a2, 0, c3457a, 0, i2);
            } else {
                c3457a = c3457a2;
            }
            return new C1111b(c3457a);
        }
    }

    /* compiled from: RelaySubscriptionManager */
    /* renamed from: com.c.a.e$a */
    static final class C3457a<T> implements C5982f<T> {
        /* renamed from: a */
        final C5982f<? super T> f9238a;
        /* renamed from: b */
        boolean f9239b = true;
        /* renamed from: c */
        boolean f9240c;
        /* renamed from: d */
        List<Object> f9241d;
        /* renamed from: e */
        boolean f9242e;

        C3457a(C5982f<? super T> c5982f) {
            this.f9238a = c5982f;
        }

        /* renamed from: a */
        public void m11106a(T t) {
            this.f9238a.a(t);
        }

        /* renamed from: a */
        public void m11107a(Throwable th) {
            throw new AssertionError();
        }

        public void L_() {
            throw new AssertionError();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: b */
        void m11108b(java.lang.Object r2) {
            /*
            r1 = this;
            r0 = r1.f9242e;
            if (r0 != 0) goto L_0x0026;
        L_0x0004:
            monitor-enter(r1);
            r0 = 0;
            r1.f9239b = r0;	 Catch:{ all -> 0x0023 }
            r0 = r1.f9240c;	 Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x001e;
        L_0x000c:
            r0 = r1.f9241d;	 Catch:{ all -> 0x0023 }
            if (r0 != 0) goto L_0x0017;
        L_0x0010:
            r0 = new java.util.ArrayList;	 Catch:{ all -> 0x0023 }
            r0.<init>();	 Catch:{ all -> 0x0023 }
            r1.f9241d = r0;	 Catch:{ all -> 0x0023 }
        L_0x0017:
            r0 = r1.f9241d;	 Catch:{ all -> 0x0023 }
            r0.add(r2);	 Catch:{ all -> 0x0023 }
            monitor-exit(r1);	 Catch:{ all -> 0x0023 }
            return;
        L_0x001e:
            monitor-exit(r1);	 Catch:{ all -> 0x0023 }
            r0 = 1;
            r1.f9242e = r0;
            goto L_0x0026;
        L_0x0023:
            r2 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0023 }
            throw r2;
        L_0x0026:
            r0 = r1.f9238a;
            com.p071c.p072a.C1110b.m3937a(r0, r2);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.c.a.e.a.b(java.lang.Object):void");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: c */
        void m11109c(java.lang.Object r2) {
            /*
            r1 = this;
            monitor-enter(r1);
            r0 = r1.f9239b;	 Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x001a;
        L_0x0005:
            r0 = r1.f9240c;	 Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x000a;
        L_0x0009:
            goto L_0x001a;
        L_0x000a:
            r0 = 0;
            r1.f9239b = r0;	 Catch:{ all -> 0x001c }
            if (r2 == 0) goto L_0x0010;
        L_0x000f:
            r0 = 1;
        L_0x0010:
            r1.f9240c = r0;	 Catch:{ all -> 0x001c }
            monitor-exit(r1);	 Catch:{ all -> 0x001c }
            if (r2 == 0) goto L_0x0019;
        L_0x0015:
            r0 = 0;
            r1.m11104a(r0, r2);
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
            throw new UnsupportedOperationException("Method not decompiled: com.c.a.e.a.c(java.lang.Object):void");
        }

        /* renamed from: a */
        private void m11104a(List<Object> list, Object obj) {
            Object obj2 = 1;
            Object obj3 = 1;
            while (true) {
                if (list != null) {
                    try {
                        for (Object d : list) {
                            m11105d(d);
                        }
                    } catch (Throwable th) {
                        list = th;
                        obj2 = null;
                    }
                }
                if (obj3 != null) {
                    m11105d(obj);
                    obj3 = null;
                }
                synchronized (this) {
                    try {
                        list = this.f9241d;
                        this.f9241d = null;
                        if (list == null) {
                            this.f9240c = false;
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
                    this.f9240c = false;
                }
            }
            throw list;
        }

        /* renamed from: d */
        private void m11105d(Object obj) {
            if (obj != null) {
                C1110b.m3937a(this.f9238a, obj);
            }
        }
    }

    /* renamed from: b */
    public /* synthetic */ void m15440b(Object obj) {
        m15438a((C7367k) obj);
    }

    C4537e() {
        super(C1111b.f3126a);
    }

    /* renamed from: a */
    public void m15438a(C7367k<? super T> c7367k) {
        C3457a c3457a = new C3457a(c7367k);
        m15434a(c7367k, c3457a);
        this.f12270c.b(c3457a);
        if (!c7367k.b()) {
            m15435b(c3457a);
            if (c7367k.b() != null) {
                m15437a(c3457a);
            }
        }
    }

    /* renamed from: a */
    private void m15434a(C7367k<? super T> c7367k, final C3457a<T> c3457a) {
        c7367k.a(C5987e.a(new C5913a(this) {
            /* renamed from: b */
            final /* synthetic */ C4537e f9237b;

            /* renamed from: a */
            public void m11103a() {
                this.f9237b.m15437a(c3457a);
            }
        }));
    }

    /* renamed from: a */
    void m15439a(Object obj) {
        this.f12268a = obj;
    }

    /* renamed from: a */
    Object m15436a() {
        return this.f12268a;
    }

    /* renamed from: b */
    C3457a<T>[] m15441b() {
        return ((C1111b) get()).f3127b;
    }

    /* renamed from: b */
    private void m15435b(C3457a<T> c3457a) {
        C1111b c1111b;
        do {
            c1111b = (C1111b) get();
        } while (!compareAndSet(c1111b, c1111b.m3939a(c3457a)));
        this.f12271d.b(c3457a);
    }

    /* renamed from: a */
    void m15437a(C3457a<T> c3457a) {
        C1111b c1111b;
        C1111b b;
        do {
            c1111b = (C1111b) get();
            b = c1111b.m3940b(c3457a);
            if (b == c1111b) {
                return;
            }
        } while (!compareAndSet(c1111b, b));
    }

    /* renamed from: c */
    C3457a<T>[] m15442c(Object obj) {
        m15439a(obj);
        return ((C1111b) get()).f3127b;
    }
}
