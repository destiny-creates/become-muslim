package p289e.p292c.p294c;

import java.util.concurrent.TimeUnit;
import p289e.C5986h.C7353a;
import p289e.C5989l;
import p289e.p291b.C5913a;
import p289e.p292c.p387d.C7307b;

/* compiled from: SchedulePeriodicHelper */
/* renamed from: e.c.c.i */
public final class C5947i {
    /* renamed from: a */
    public static final long f19674a = TimeUnit.MINUTES.toNanos(Long.getLong("rx.scheduler.drift-tolerance", 15).longValue());

    /* compiled from: SchedulePeriodicHelper */
    /* renamed from: e.c.c.i$a */
    public interface C5946a {
        /* renamed from: a */
        long m24867a();
    }

    /* renamed from: a */
    public static C5989l m24868a(C7353a c7353a, C5913a c5913a, long j, long j2, TimeUnit timeUnit, C5946a c5946a) {
        long j3 = j;
        TimeUnit timeUnit2 = timeUnit;
        final long toNanos = timeUnit2.toNanos(j2);
        final long a = c5946a != null ? c5946a.m24867a() : TimeUnit.MILLISECONDS.toNanos(c7353a.T_());
        final long toNanos2 = timeUnit2.toNanos(j3) + a;
        Object c7307b = new C7307b();
        C7307b c7307b2 = new C7307b(c7307b);
        final C5913a c5913a2 = c5913a;
        final C7307b c7307b3 = c7307b2;
        final C5946a c5946a2 = c5946a;
        C7307b c7307b4 = c7307b2;
        C72981 c72981 = r3;
        final C7353a c7353a2 = c7353a;
        C72981 c729812 = new C5913a() {
            /* renamed from: a */
            long f25672a;
            /* renamed from: b */
            long f25673b = a;
            /* renamed from: c */
            long f25674c = toNanos2;

            /* renamed from: a */
            public void mo4985a() {
                c5913a2.mo4985a();
                if (!c7307b3.mo5121b()) {
                    long j;
                    long j2;
                    long a = c5946a2 != null ? c5946a2.m24867a() : TimeUnit.MILLISECONDS.toNanos(c7353a2.T_());
                    if (C5947i.f19674a + a >= this.f25673b) {
                        if (a < (this.f25673b + toNanos) + C5947i.f19674a) {
                            j = this.f25674c;
                            j2 = this.f25672a + 1;
                            this.f25672a = j2;
                            j += j2 * toNanos;
                            this.f25673b = a;
                            c7307b3.m33639b(c7353a2.mo6333a(this, j - a, TimeUnit.NANOSECONDS));
                        }
                    }
                    j = toNanos + a;
                    j2 = toNanos;
                    long j3 = this.f25672a + 1;
                    this.f25672a = j3;
                    this.f25674c = j - (j2 * j3);
                    this.f25673b = a;
                    c7307b3.m33639b(c7353a2.mo6333a(this, j - a, TimeUnit.NANOSECONDS));
                }
            }
        };
        c7307b.m33639b(c7353a.mo6333a(c72981, j3, timeUnit2));
        return c7307b4;
    }
}
