package p289e.p292c.p293a;

import java.util.concurrent.TimeUnit;
import p289e.C5974e.C7335a;
import p289e.C5986h;
import p289e.C5989l;
import p289e.C7367k;
import p289e.p290a.C5903b;
import p289e.p291b.C5913a;

/* compiled from: OnSubscribeTimerOnce */
/* renamed from: e.c.a.af */
public final class af implements C7335a<Long> {
    /* renamed from: a */
    final long f29913a;
    /* renamed from: b */
    final TimeUnit f29914b;
    /* renamed from: c */
    final C5986h f29915c;

    /* renamed from: b */
    public /* synthetic */ void mo4974b(Object obj) {
        m39125a((C7367k) obj);
    }

    public af(long j, TimeUnit timeUnit, C5986h c5986h) {
        this.f29913a = j;
        this.f29914b = timeUnit;
        this.f29915c = c5986h;
    }

    /* renamed from: a */
    public void m39125a(final C7367k<? super Long> c7367k) {
        C5989l a = this.f29915c.mo5127a();
        c7367k.m33781a(a);
        a.mo6333a(new C5913a(this) {
            /* renamed from: b */
            final /* synthetic */ af f25520b;

            /* renamed from: a */
            public void mo4985a() {
                try {
                    c7367k.mo5000a((Object) Long.valueOf(0));
                    c7367k.L_();
                } catch (Throwable th) {
                    C5903b.m24789a(th, c7367k);
                }
            }
        }, this.f29913a, this.f29914b);
    }
}
