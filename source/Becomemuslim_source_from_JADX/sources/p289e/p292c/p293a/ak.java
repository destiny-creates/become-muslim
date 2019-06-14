package p289e.p292c.p293a;

import java.util.concurrent.TimeUnit;
import p289e.C5974e.C7336b;
import p289e.C5986h;
import p289e.C5989l;
import p289e.C7367k;
import p289e.p291b.C5913a;

/* compiled from: OperatorDelay */
/* renamed from: e.c.a.ak */
public final class ak<T> implements C7336b<T, T> {
    /* renamed from: a */
    final long f29944a;
    /* renamed from: b */
    final TimeUnit f29945b;
    /* renamed from: c */
    final C5986h f29946c;

    public ak(long j, TimeUnit timeUnit, C5986h c5986h) {
        this.f29944a = j;
        this.f29945b = timeUnit;
        this.f29946c = c5986h;
    }

    /* renamed from: a */
    public C7367k<? super T> m39145a(final C7367k<? super T> c7367k) {
        final C5989l a = this.f29946c.mo5127a();
        c7367k.m33781a(a);
        return new C7367k<T>(this, c7367k) {
            /* renamed from: a */
            boolean f29940a;
            /* renamed from: d */
            final /* synthetic */ ak f29943d;

            /* compiled from: OperatorDelay */
            /* renamed from: e.c.a.ak$1$1 */
            class C72391 implements C5913a {
                /* renamed from: a */
                final /* synthetic */ C80591 f25527a;

                C72391(C80591 c80591) {
                    this.f25527a = c80591;
                }

                /* renamed from: a */
                public void mo4985a() {
                    if (!this.f25527a.f29940a) {
                        this.f25527a.f29940a = true;
                        c7367k.L_();
                    }
                }
            }

            public void L_() {
                a.mo6333a(new C72391(this), this.f29943d.f29944a, this.f29943d.f29945b);
            }

            /* renamed from: a */
            public void mo5001a(final Throwable th) {
                a.mo6332a(new C5913a(this) {
                    /* renamed from: b */
                    final /* synthetic */ C80591 f25529b;

                    /* renamed from: a */
                    public void mo4985a() {
                        if (!this.f25529b.f29940a) {
                            this.f25529b.f29940a = true;
                            c7367k.mo5001a(th);
                            a.U_();
                        }
                    }
                });
            }

            /* renamed from: a */
            public void mo5000a(final T t) {
                a.mo6333a(new C5913a(this) {
                    /* renamed from: b */
                    final /* synthetic */ C80591 f25531b;

                    /* renamed from: a */
                    public void mo4985a() {
                        if (!this.f25531b.f29940a) {
                            c7367k.mo5000a(t);
                        }
                    }
                }, this.f29943d.f29944a, this.f29943d.f29945b);
            }
        };
    }
}
