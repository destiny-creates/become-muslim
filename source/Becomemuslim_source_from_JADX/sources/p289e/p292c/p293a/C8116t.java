package p289e.p292c.p293a;

import com.facebook.common.time.Clock;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import p289e.C5974e.C7335a;
import p289e.C5982f;
import p289e.C5984g;
import p289e.C7367k;
import p289e.p290a.C5903b;

/* compiled from: OnSubscribeFromIterable */
/* renamed from: e.c.a.t */
public final class C8116t<T> implements C7335a<T> {
    /* renamed from: a */
    final Iterable<? extends T> f30223a;

    /* compiled from: OnSubscribeFromIterable */
    /* renamed from: e.c.a.t$a */
    static final class C7274a<T> extends AtomicLong implements C5984g {
        private static final long serialVersionUID = -8730475647105475802L;
        /* renamed from: a */
        private final C7367k<? super T> f25600a;
        /* renamed from: b */
        private final Iterator<? extends T> f25601b;

        C7274a(C7367k<? super T> c7367k, Iterator<? extends T> it) {
            this.f25600a = c7367k;
            this.f25601b = it;
        }

        /* renamed from: a */
        public void mo5119a(long j) {
            if (get() != Clock.MAX_TIME) {
                if (j == Clock.MAX_TIME && compareAndSet(0, Clock.MAX_TIME)) {
                    m33581a();
                } else if (j > 0 && C5923a.m24836a((AtomicLong) this, j) == 0) {
                    m33583b(j);
                }
            }
        }

        /* renamed from: b */
        void m33583b(long j) {
            C5982f c5982f = this.f25600a;
            Iterator it = this.f25601b;
            long j2 = j;
            loop0:
            do {
                j = 0;
                while (true) {
                    if (j == j2) {
                        j2 = get();
                        if (j == j2) {
                            j2 = C5923a.m24838b(this, j);
                        }
                    } else if (!c5982f.mo5121b()) {
                        try {
                            c5982f.mo5000a(it.next());
                            if (!c5982f.mo5121b()) {
                                try {
                                    if (!it.hasNext()) {
                                        break loop0;
                                    }
                                    j++;
                                } catch (Throwable th) {
                                    C5903b.m24789a(th, c5982f);
                                    return;
                                }
                            }
                            return;
                        } catch (Throwable th2) {
                            C5903b.m24789a(th2, c5982f);
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (c5982f.mo5121b() == null) {
                    c5982f.L_();
                }
                return;
            } while (j2 != 0);
        }

        /* renamed from: a */
        void m33581a() {
            C5982f c5982f = this.f25600a;
            Iterator it = this.f25601b;
            while (!c5982f.mo5121b()) {
                try {
                    c5982f.mo5000a(it.next());
                    if (!c5982f.mo5121b()) {
                        try {
                            if (!it.hasNext()) {
                                if (!c5982f.mo5121b()) {
                                    c5982f.L_();
                                }
                                return;
                            }
                        } catch (Throwable th) {
                            C5903b.m24789a(th, c5982f);
                            return;
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    C5903b.m24789a(th2, c5982f);
                    return;
                }
            }
        }
    }

    /* renamed from: b */
    public /* synthetic */ void mo4974b(Object obj) {
        m39432a((C7367k) obj);
    }

    public C8116t(Iterable<? extends T> iterable) {
        if (iterable != null) {
            this.f30223a = iterable;
            return;
        }
        throw new NullPointerException("iterable must not be null");
    }

    /* renamed from: a */
    public void m39432a(C7367k<? super T> c7367k) {
        try {
            Iterator it = this.f30223a.iterator();
            boolean hasNext = it.hasNext();
            if (!c7367k.mo5121b()) {
                if (hasNext) {
                    c7367k.mo6324a(new C7274a(c7367k, it));
                } else {
                    c7367k.L_();
                }
            }
        } catch (Throwable th) {
            C5903b.m24789a(th, (C5982f) c7367k);
        }
    }
}
