package p289e.p292c.p293a;

import java.util.concurrent.TimeUnit;
import p289e.C5974e.C7335a;
import p289e.C5986h;
import p289e.C5989l;
import p289e.C7367k;
import p289e.p290a.C5903b;
import p289e.p291b.C5913a;

/* compiled from: OnSubscribeTimerPeriodically */
/* renamed from: e.c.a.ag */
public final class ag implements C7335a<Long> {
    /* renamed from: a */
    final long f29916a;
    /* renamed from: b */
    final long f29917b;
    /* renamed from: c */
    final TimeUnit f29918c;
    /* renamed from: d */
    final C5986h f29919d;

    /* renamed from: b */
    public /* synthetic */ void mo4974b(Object obj) {
        m39127a((C7367k) obj);
    }

    public ag(long j, long j2, TimeUnit timeUnit, C5986h c5986h) {
        this.f29916a = j;
        this.f29917b = j2;
        this.f29918c = timeUnit;
        this.f29919d = c5986h;
    }

    /* renamed from: a */
    public void m39127a(final C7367k<? super Long> c7367k) {
        final C5989l a = this.f29919d.mo5127a();
        c7367k.m33781a(a);
        a.m33744a(new C5913a(this) {
            /* renamed from: a */
            long f25521a;
            /* renamed from: d */
            final /* synthetic */ ag f25524d;

            /* renamed from: a */
            public void mo4985a() {
                try {
                    C7367k c7367k = c7367k;
                    long j = this.f25521a;
                    this.f25521a = 1 + j;
                    c7367k.mo5000a((Object) Long.valueOf(j));
                } catch (Throwable th) {
                    a.U_();
                } finally {
                    C5903b.m24789a(th, c7367k);
                }
            }
        }, this.f29916a, this.f29917b, this.f29918c);
    }
}
