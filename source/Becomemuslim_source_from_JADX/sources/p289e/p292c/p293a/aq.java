package p289e.p292c.p293a;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import p289e.C5974e.C7336b;
import p289e.C5984g;
import p289e.C5986h;
import p289e.C5986h.C7353a;
import p289e.C5989l;
import p289e.C7367k;
import p289e.p290a.C5904c;
import p289e.p291b.C5913a;
import p289e.p292c.p294c.C7296f;
import p289e.p292c.p294c.C7305m;
import p289e.p292c.p295e.C7322j;
import p289e.p292c.p295e.p296a.C7309d;
import p289e.p292c.p295e.p297b.C8364q;
import p289e.p292c.p295e.p297b.ae;
import p289e.p300f.C5977c;

/* compiled from: OperatorObserveOn */
/* renamed from: e.c.a.aq */
public final class aq<T> implements C7336b<T, T> {
    /* renamed from: a */
    private final C5986h f30024a;
    /* renamed from: b */
    private final boolean f30025b;
    /* renamed from: c */
    private final int f30026c;

    /* compiled from: OperatorObserveOn */
    /* renamed from: e.c.a.aq$a */
    static final class C8066a<T> extends C7367k<T> implements C5913a {
        /* renamed from: a */
        final C7367k<? super T> f30014a;
        /* renamed from: b */
        final C7353a f30015b;
        /* renamed from: c */
        final boolean f30016c;
        /* renamed from: d */
        final Queue<Object> f30017d;
        /* renamed from: e */
        final int f30018e;
        /* renamed from: f */
        volatile boolean f30019f;
        /* renamed from: g */
        final AtomicLong f30020g = new AtomicLong();
        /* renamed from: h */
        final AtomicLong f30021h = new AtomicLong();
        /* renamed from: i */
        Throwable f30022i;
        /* renamed from: j */
        long f30023j;

        /* compiled from: OperatorObserveOn */
        /* renamed from: e.c.a.aq$a$1 */
        class C72461 implements C5984g {
            /* renamed from: a */
            final /* synthetic */ C8066a f25537a;

            C72461(C8066a c8066a) {
                this.f25537a = c8066a;
            }

            /* renamed from: a */
            public void mo5119a(long j) {
                if (j > 0) {
                    C5923a.m24836a(this.f25537a.f30020g, j);
                    this.f25537a.m39214e();
                }
            }
        }

        public C8066a(C5986h c5986h, C7367k<? super T> c7367k, boolean z, int i) {
            this.f30014a = c7367k;
            this.f30015b = c5986h.mo5127a();
            this.f30016c = z;
            if (i <= 0) {
                i = C7322j.f25717b;
            }
            this.f30018e = i - (i >> 2);
            if (ae.m24923a() != null) {
                this.f30017d = new C8364q(i);
            } else {
                this.f30017d = new C7309d(i);
            }
            m33779a((long) (long) i);
        }

        /* renamed from: d */
        void m39213d() {
            C7367k c7367k = this.f30014a;
            c7367k.mo6324a(new C72461(this));
            c7367k.m33781a(this.f30015b);
            c7367k.m33781a((C5989l) this);
        }

        /* renamed from: a */
        public void mo5000a(T t) {
            if (!mo5121b()) {
                if (!this.f30019f) {
                    if (this.f30017d.offer(C5937h.m24848a((Object) t)) == null) {
                        mo5001a(new C5904c());
                    } else {
                        m39214e();
                    }
                }
            }
        }

        public void L_() {
            if (!mo5121b()) {
                if (!this.f30019f) {
                    this.f30019f = true;
                    m39214e();
                }
            }
        }

        /* renamed from: a */
        public void mo5001a(Throwable th) {
            if (!mo5121b()) {
                if (!this.f30019f) {
                    this.f30022i = th;
                    this.f30019f = true;
                    m39214e();
                    return;
                }
            }
            C5977c.m25068a(th);
        }

        /* renamed from: e */
        protected void m39214e() {
            if (this.f30021h.getAndIncrement() == 0) {
                this.f30015b.mo6332a(this);
            }
        }

        /* renamed from: a */
        public void mo4985a() {
            long j = this.f30023j;
            Queue queue = this.f30017d;
            C7367k c7367k = this.f30014a;
            long j2 = j;
            j = 1;
            do {
                long j3 = r0.f30020g.get();
                while (true) {
                    int i = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                    if (i == 0) {
                        break;
                    }
                    boolean z = r0.f30019f;
                    Object poll = queue.poll();
                    boolean z2 = poll == null;
                    if (!m39212a(z, z2, c7367k, queue)) {
                        if (z2) {
                            break;
                        }
                        c7367k.mo5000a(C5937h.m24853d(poll));
                        j2++;
                        if (j2 == ((long) r0.f30018e)) {
                            j3 = C5923a.m24838b(r0.f30020g, j2);
                            m33779a(j2);
                            j2 = 0;
                        }
                    } else {
                        return;
                    }
                }
                if (i != 0 || !m39212a(r0.f30019f, queue.isEmpty(), c7367k, queue)) {
                    r0.f30023j = j2;
                    j = r0.f30021h.addAndGet(-j);
                } else {
                    return;
                }
            } while (j != 0);
        }

        /* renamed from: a */
        boolean m39212a(boolean z, boolean z2, C7367k<? super T> c7367k, Queue<Object> queue) {
            if (c7367k.mo5121b()) {
                queue.clear();
                return true;
            }
            if (z) {
                if (!this.f30016c) {
                    z = this.f30022i;
                    if (z) {
                        queue.clear();
                        try {
                            c7367k.mo5001a((Throwable) z);
                            return true;
                        } finally {
                            this.f30015b.U_();
                        }
                    } else if (z2) {
                        try {
                            c7367k.L_();
                            return true;
                        } finally {
                            this.f30015b.U_();
                        }
                    }
                } else if (z2) {
                    z = this.f30022i;
                    if (z) {
                        try {
                            c7367k.mo5001a((Throwable) z);
                        } catch (Throwable th) {
                            this.f30015b.U_();
                        }
                    } else {
                        c7367k.L_();
                    }
                    this.f30015b.U_();
                }
            }
            return false;
        }
    }

    public aq(C5986h c5986h, boolean z, int i) {
        this.f30024a = c5986h;
        this.f30025b = z;
        if (i <= 0) {
            i = C7322j.f25717b;
        }
        this.f30026c = i;
    }

    /* renamed from: a */
    public C7367k<? super T> m39215a(C7367k<? super T> c7367k) {
        if ((this.f30024a instanceof C7296f) || (this.f30024a instanceof C7305m)) {
            return c7367k;
        }
        C7367k c8066a = new C8066a(this.f30024a, c7367k, this.f30025b, this.f30026c);
        c8066a.m39213d();
        return c8066a;
    }
}
