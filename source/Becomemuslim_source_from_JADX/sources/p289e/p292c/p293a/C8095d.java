package p289e.p292c.p293a;

import com.facebook.common.time.Clock;
import java.util.concurrent.atomic.AtomicInteger;
import p289e.C5974e;
import p289e.C5984g;
import p289e.C5989l;
import p289e.C7367k;

/* compiled from: DeferredScalarSubscriber */
/* renamed from: e.c.a.d */
public abstract class C8095d<T, R> extends C7367k<T> {
    /* renamed from: a */
    protected final C7367k<? super R> f30164a;
    /* renamed from: b */
    protected boolean f30165b;
    /* renamed from: c */
    protected R f30166c;
    /* renamed from: d */
    final AtomicInteger f30167d = new AtomicInteger();

    /* compiled from: DeferredScalarSubscriber */
    /* renamed from: e.c.a.d$a */
    static final class C7268a implements C5984g {
        /* renamed from: a */
        final C8095d<?, ?> f25587a;

        public C7268a(C8095d<?, ?> c8095d) {
            this.f25587a = c8095d;
        }

        /* renamed from: a */
        public void mo5119a(long j) {
            this.f25587a.mo6325b(j);
        }
    }

    public C8095d(C7367k<? super R> c7367k) {
        this.f30164a = c7367k;
    }

    /* renamed from: a */
    public void mo5001a(Throwable th) {
        this.f30166c = null;
        this.f30164a.mo5001a(th);
    }

    public void L_() {
        if (this.f30165b) {
            m39367b(this.f30166c);
        } else {
            m39368d();
        }
    }

    /* renamed from: d */
    protected final void m39368d() {
        this.f30164a.L_();
    }

    /* renamed from: b */
    protected final void m39367b(R r) {
        C7367k c7367k = this.f30164a;
        do {
            int i = this.f30167d.get();
            if (!(i == 2 || i == 3)) {
                if (!c7367k.mo5121b()) {
                    if (i == 1) {
                        c7367k.mo5000a((Object) r);
                        if (c7367k.mo5121b() == null) {
                            c7367k.L_();
                        }
                        this.f30167d.lazySet(3);
                        return;
                    }
                    this.f30166c = r;
                }
            }
            return;
        } while (!this.f30167d.compareAndSet(0, 2));
    }

    /* renamed from: b */
    final void mo6325b(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("n >= 0 required but it was ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (i != 0) {
            j = this.f30164a;
            do {
                int i2 = this.f30167d.get();
                if (!(i2 == 1 || i2 == 3)) {
                    if (!j.mo5121b()) {
                        if (i2 == 2) {
                            if (this.f30167d.compareAndSet(2, 3)) {
                                j.mo5000a(this.f30166c);
                                if (!j.mo5121b()) {
                                    j.L_();
                                }
                            }
                            return;
                        }
                    }
                }
                return;
            } while (!this.f30167d.compareAndSet(0, 1));
        }
    }

    /* renamed from: a */
    public final void mo6324a(C5984g c5984g) {
        c5984g.mo5119a(Clock.MAX_TIME);
    }

    /* renamed from: a */
    public final void m39363a(C5974e<? extends T> c5974e) {
        m39369e();
        c5974e.m25007a((C7367k) this);
    }

    /* renamed from: e */
    final void m39369e() {
        C7367k c7367k = this.f30164a;
        c7367k.m33781a((C5989l) this);
        c7367k.mo6324a(new C7268a(this));
    }
}
