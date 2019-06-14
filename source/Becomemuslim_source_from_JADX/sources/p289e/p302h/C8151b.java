package p289e.p302h;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p289e.C5974e.C7335a;
import p289e.C5982f;
import p289e.C5984g;
import p289e.C5989l;
import p289e.C7367k;
import p289e.p290a.C5903b;
import p289e.p290a.C5904c;
import p289e.p292c.p293a.C5923a;

/* compiled from: PublishSubject */
/* renamed from: e.h.b */
public final class C8151b<T> extends C7356d<T, T> {
    /* renamed from: b */
    final C8150b<T> f30316b;

    /* compiled from: PublishSubject */
    /* renamed from: e.h.b$a */
    static final class C7355a<T> extends AtomicLong implements C5982f<T>, C5984g, C5989l {
        private static final long serialVersionUID = 6451806817170721536L;
        /* renamed from: a */
        final C8150b<T> f25751a;
        /* renamed from: b */
        final C7367k<? super T> f25752b;
        /* renamed from: c */
        long f25753c;

        public C7355a(C8150b<T> c8150b, C7367k<? super T> c7367k) {
            this.f25751a = c8150b;
            this.f25752b = c7367k;
        }

        /* renamed from: a */
        public void mo5119a(long j) {
            if (C5923a.m24837a(j)) {
                long j2;
                do {
                    j2 = get();
                    if (j2 == Long.MIN_VALUE) {
                        return;
                    }
                } while (!compareAndSet(j2, C5923a.m24835a(j2, j)));
            }
        }

        /* renamed from: b */
        public boolean mo5121b() {
            return get() == Long.MIN_VALUE;
        }

        public void U_() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.f25751a.m39542b(this);
            }
        }

        /* renamed from: a */
        public void mo5000a(T t) {
            long j = get();
            if (j != Long.MIN_VALUE) {
                long j2 = this.f25753c;
                if (j != j2) {
                    this.f25753c = j2 + 1;
                    this.f25752b.mo5000a((Object) t);
                    return;
                }
                U_();
                this.f25752b.mo5001a(new C5904c("PublishSubject: could not emit value due to lack of requests"));
            }
        }

        /* renamed from: a */
        public void mo5001a(Throwable th) {
            if (get() != Long.MIN_VALUE) {
                this.f25752b.mo5001a(th);
            }
        }

        public void L_() {
            if (get() != Long.MIN_VALUE) {
                this.f25752b.L_();
            }
        }
    }

    /* compiled from: PublishSubject */
    /* renamed from: e.h.b$b */
    static final class C8150b<T> extends AtomicReference<C7355a<T>[]> implements C7335a<T>, C5982f<T> {
        /* renamed from: a */
        static final C7355a[] f30313a = new C7355a[0];
        /* renamed from: b */
        static final C7355a[] f30314b = new C7355a[0];
        private static final long serialVersionUID = -7568940796666027140L;
        /* renamed from: c */
        Throwable f30315c;

        /* renamed from: b */
        public /* synthetic */ void mo4974b(Object obj) {
            m39538a((C7367k) obj);
        }

        public C8150b() {
            lazySet(f30313a);
        }

        /* renamed from: a */
        public void m39538a(C7367k<? super T> c7367k) {
            C7355a c7355a = new C7355a(this, c7367k);
            c7367k.m33781a((C5989l) c7355a);
            c7367k.mo6324a((C5984g) c7355a);
            if (!m39541a(c7355a)) {
                Throwable th = this.f30315c;
                if (th != null) {
                    c7367k.mo5001a(th);
                } else {
                    c7367k.L_();
                }
            } else if (c7355a.mo5121b() != null) {
                m39542b(c7355a);
            }
        }

        /* renamed from: a */
        boolean m39541a(C7355a<T> c7355a) {
            C7355a[] c7355aArr;
            Object obj;
            do {
                c7355aArr = (C7355a[]) get();
                if (c7355aArr == f30314b) {
                    return false;
                }
                int length = c7355aArr.length;
                obj = new C7355a[(length + 1)];
                System.arraycopy(c7355aArr, 0, obj, 0, length);
                obj[length] = c7355a;
            } while (!compareAndSet(c7355aArr, obj));
            return true;
        }

        /* renamed from: b */
        void m39542b(C7355a<T> c7355a) {
            C7355a[] c7355aArr;
            Object obj;
            do {
                c7355aArr = (C7355a[]) get();
                if (c7355aArr != f30314b) {
                    if (c7355aArr != f30313a) {
                        int length = c7355aArr.length;
                        int i = -1;
                        for (int i2 = 0; i2 < length; i2++) {
                            if (c7355aArr[i2] == c7355a) {
                                i = i2;
                                break;
                            }
                        }
                        if (i >= 0) {
                            if (length == 1) {
                                obj = f30313a;
                            } else {
                                Object obj2 = new C7355a[(length - 1)];
                                System.arraycopy(c7355aArr, 0, obj2, 0, i);
                                System.arraycopy(c7355aArr, i + 1, obj2, i, (length - i) - 1);
                                obj = obj2;
                            }
                        } else {
                            return;
                        }
                    }
                }
                return;
            } while (!compareAndSet(c7355aArr, obj));
        }

        /* renamed from: a */
        public void mo5000a(T t) {
            for (C7355a a : (C7355a[]) get()) {
                a.mo5000a((Object) t);
            }
        }

        /* renamed from: a */
        public void mo5001a(Throwable th) {
            this.f30315c = th;
            List list = null;
            for (C7355a a : (C7355a[]) getAndSet(f30314b)) {
                try {
                    a.mo5001a(th);
                } catch (Throwable th2) {
                    if (list == null) {
                        list = new ArrayList(1);
                    }
                    list.add(th2);
                }
            }
            C5903b.m24793a(list);
        }

        public void L_() {
            for (C7355a L_ : (C7355a[]) getAndSet(f30314b)) {
                L_.L_();
            }
        }
    }

    /* renamed from: b */
    public static <T> C8151b<T> m39544b() {
        return new C8151b(new C8150b());
    }

    protected C8151b(C8150b<T> c8150b) {
        super(c8150b);
        this.f30316b = c8150b;
    }

    /* renamed from: a */
    public void mo5000a(T t) {
        this.f30316b.mo5000a((Object) t);
    }

    /* renamed from: a */
    public void mo5001a(Throwable th) {
        this.f30316b.mo5001a(th);
    }

    public void L_() {
        this.f30316b.L_();
    }
}
