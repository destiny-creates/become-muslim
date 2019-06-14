package p289e.p292c.p293a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import p289e.C5974e;
import p289e.C5974e.C7335a;
import p289e.C5984g;
import p289e.C7367k;
import p289e.p291b.C5913a;
import p289e.p303i.C5987e;

/* compiled from: OnSubscribeAmb */
/* renamed from: e.c.a.i */
public final class C8099i<T> implements C7335a<T> {
    /* renamed from: a */
    final Iterable<? extends C5974e<? extends T>> f30177a;

    /* compiled from: OnSubscribeAmb */
    /* renamed from: e.c.a.i$b */
    static final class C5938b<T> extends AtomicReference<C8098a<T>> {
        /* renamed from: a */
        final Collection<C8098a<T>> f19658a = new ConcurrentLinkedQueue();

        C5938b() {
        }

        /* renamed from: a */
        public void m24855a() {
            C8098a c8098a = (C8098a) get();
            if (c8098a != null) {
                m24856a(c8098a);
            }
        }

        /* renamed from: a */
        public void m24856a(C8098a<T> c8098a) {
            for (C8098a<T> c8098a2 : this.f19658a) {
                if (c8098a2 != c8098a) {
                    c8098a2.U_();
                }
            }
            this.f19658a.clear();
        }
    }

    /* compiled from: OnSubscribeAmb */
    /* renamed from: e.c.a.i$a */
    static final class C8098a<T> extends C7367k<T> {
        /* renamed from: a */
        private final C7367k<? super T> f30174a;
        /* renamed from: b */
        private final C5938b<T> f30175b;
        /* renamed from: c */
        private boolean f30176c;

        C8098a(long j, C7367k<? super T> c7367k, C5938b<T> c5938b) {
            this.f30174a = c7367k;
            this.f30175b = c5938b;
            m33779a(j);
        }

        /* renamed from: b */
        private void m39377b(long j) {
            m33779a(j);
        }

        /* renamed from: a */
        public void mo5000a(T t) {
            if (m39378d()) {
                this.f30174a.mo5000a((Object) t);
            }
        }

        public void L_() {
            if (m39378d()) {
                this.f30174a.L_();
            }
        }

        /* renamed from: a */
        public void mo5001a(Throwable th) {
            if (m39378d()) {
                this.f30174a.mo5001a(th);
            }
        }

        /* renamed from: d */
        private boolean m39378d() {
            if (this.f30176c) {
                return true;
            }
            if (this.f30175b.get() == this) {
                this.f30176c = true;
                return true;
            } else if (this.f30175b.compareAndSet(null, this)) {
                this.f30175b.m24856a(this);
                this.f30176c = true;
                return true;
            } else {
                this.f30175b.m24855a();
                return false;
            }
        }
    }

    /* renamed from: b */
    public /* synthetic */ void mo4974b(Object obj) {
        m39384a((C7367k) obj);
    }

    /* renamed from: a */
    public static <T> C7335a<T> m39381a(C5974e<? extends T> c5974e, C5974e<? extends T> c5974e2) {
        Iterable arrayList = new ArrayList();
        arrayList.add(c5974e);
        arrayList.add(c5974e2);
        return C8099i.m39382a(arrayList);
    }

    /* renamed from: a */
    public static <T> C7335a<T> m39382a(Iterable<? extends C5974e<? extends T>> iterable) {
        return new C8099i(iterable);
    }

    private C8099i(Iterable<? extends C5974e<? extends T>> iterable) {
        this.f30177a = iterable;
    }

    /* renamed from: a */
    public void m39384a(C7367k<? super T> c7367k) {
        final C5938b c5938b = new C5938b();
        c7367k.m33781a(C5987e.m25118a(new C5913a(this) {
            /* renamed from: b */
            final /* synthetic */ C8099i f25589b;

            /* renamed from: a */
            public void mo4985a() {
                C8098a c8098a = (C8098a) c5938b.get();
                if (c8098a != null) {
                    c8098a.U_();
                }
                C8099i.m39383a(c5938b.f19658a);
            }
        }));
        for (C5974e c5974e : this.f30177a) {
            if (c7367k.mo5121b()) {
                break;
            }
            C7367k c8098a = new C8098a(0, c7367k, c5938b);
            c5938b.f19658a.add(c8098a);
            C8098a c8098a2 = (C8098a) c5938b.get();
            if (c8098a2 != null) {
                c5938b.m24856a(c8098a2);
                return;
            }
            c5974e.m25007a(c8098a);
        }
        if (c7367k.mo5121b()) {
            C8099i.m39383a(c5938b.f19658a);
        }
        c7367k.mo6324a(new C5984g(this) {
            /* renamed from: b */
            final /* synthetic */ C8099i f25591b;

            /* renamed from: a */
            public void mo5119a(long j) {
                C8098a c8098a = (C8098a) c5938b.get();
                if (c8098a != null) {
                    c8098a.m39377b(j);
                } else {
                    for (C8098a c8098a2 : c5938b.f19658a) {
                        if (!c8098a2.mo5121b()) {
                            if (c5938b.get() == c8098a2) {
                                c8098a2.m39377b(j);
                                return;
                            }
                            c8098a2.m39377b(j);
                        }
                    }
                }
            }
        });
    }

    /* renamed from: a */
    static <T> void m39383a(Collection<C8098a<T>> collection) {
        if (!collection.isEmpty()) {
            for (C8098a U_ : collection) {
                U_.U_();
            }
            collection.clear();
        }
    }
}
