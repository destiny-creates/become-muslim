package p289e.p292c.p294c;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import p289e.C5986h;
import p289e.C5986h.C7353a;
import p289e.C5989l;
import p289e.p291b.C5913a;
import p289e.p303i.C5987e;
import p289e.p303i.C7361a;

/* compiled from: TrampolineScheduler */
/* renamed from: e.c.c.m */
public final class C7305m extends C5986h {
    /* renamed from: a */
    public static final C7305m f25695a = new C7305m();

    /* compiled from: TrampolineScheduler */
    /* renamed from: e.c.c.m$b */
    static final class C5949b implements Comparable<C5949b> {
        /* renamed from: a */
        final C5913a f19675a;
        /* renamed from: b */
        final Long f19676b;
        /* renamed from: c */
        final int f19677c;

        public /* synthetic */ int compareTo(Object obj) {
            return m24870a((C5949b) obj);
        }

        C5949b(C5913a c5913a, Long l, int i) {
            this.f19675a = c5913a;
            this.f19676b = l;
            this.f19677c = i;
        }

        /* renamed from: a */
        public int m24870a(C5949b c5949b) {
            int compareTo = this.f19676b.compareTo(c5949b.f19676b);
            return compareTo == 0 ? C7305m.m33634a(this.f19677c, c5949b.f19677c) : compareTo;
        }
    }

    /* compiled from: TrampolineScheduler */
    /* renamed from: e.c.c.m$a */
    static final class C8135a extends C7353a implements C5989l {
        /* renamed from: a */
        final AtomicInteger f30287a = new AtomicInteger();
        /* renamed from: b */
        final PriorityBlockingQueue<C5949b> f30288b = new PriorityBlockingQueue();
        /* renamed from: c */
        private final C7361a f30289c = new C7361a();
        /* renamed from: d */
        private final AtomicInteger f30290d = new AtomicInteger();

        C8135a() {
        }

        /* renamed from: a */
        public C5989l mo6332a(C5913a c5913a) {
            return m39509a(c5913a, T_());
        }

        /* renamed from: a */
        public C5989l mo6333a(C5913a c5913a, long j, TimeUnit timeUnit) {
            long T_ = T_() + timeUnit.toMillis(j);
            return m39509a(new C7303l(c5913a, this, T_), T_);
        }

        /* renamed from: a */
        private C5989l m39509a(C5913a c5913a, long j) {
            if (this.f30289c.mo5121b()) {
                return C5987e.m25119b();
            }
            final C5949b c5949b = new C5949b(c5913a, Long.valueOf(j), this.f30287a.incrementAndGet());
            this.f30288b.add(c5949b);
            if (this.f30290d.getAndIncrement() != null) {
                return C5987e.m25118a(new C5913a(this) {
                    /* renamed from: b */
                    final /* synthetic */ C8135a f25694b;

                    /* renamed from: a */
                    public void mo4985a() {
                        this.f25694b.f30288b.remove(c5949b);
                    }
                });
            }
            do {
                C5949b c5949b2 = (C5949b) this.f30288b.poll();
                if (c5949b2 != null) {
                    c5949b2.f19675a.mo4985a();
                }
            } while (this.f30290d.decrementAndGet() > null);
            return C5987e.m25119b();
        }

        public void U_() {
            this.f30289c.U_();
        }

        /* renamed from: b */
        public boolean mo5121b() {
            return this.f30289c.mo5121b();
        }
    }

    /* renamed from: a */
    static int m33634a(int i, int i2) {
        return i < i2 ? -1 : i == i2 ? 0 : 1;
    }

    /* renamed from: a */
    public C7353a mo5127a() {
        return new C8135a();
    }

    private C7305m() {
    }
}
