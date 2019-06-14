package p289e;

import java.util.concurrent.TimeUnit;
import p289e.p291b.C5913a;
import p289e.p292c.p294c.C5947i;

/* compiled from: Scheduler */
/* renamed from: e.h */
public abstract class C5986h {

    /* compiled from: Scheduler */
    /* renamed from: e.h$a */
    public static abstract class C7353a implements C5989l {
        /* renamed from: a */
        public abstract C5989l mo6332a(C5913a c5913a);

        /* renamed from: a */
        public abstract C5989l mo6333a(C5913a c5913a, long j, TimeUnit timeUnit);

        /* renamed from: a */
        public C5989l m33744a(C5913a c5913a, long j, long j2, TimeUnit timeUnit) {
            return C5947i.m24868a(this, c5913a, j, j2, timeUnit, null);
        }

        public long T_() {
            return System.currentTimeMillis();
        }
    }

    /* renamed from: a */
    public abstract C7353a mo5127a();

    /* renamed from: b */
    public long m25116b() {
        return System.currentTimeMillis();
    }
}
