package p289e.p292c.p293a;

import com.facebook.common.time.Clock;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: BackpressureUtils */
/* renamed from: e.c.a.a */
public final class C5923a {
    /* renamed from: a */
    public static long m24835a(long j, long j2) {
        j += j2;
        return j < 0 ? Clock.MAX_TIME : j;
    }

    /* renamed from: a */
    public static long m24836a(AtomicLong atomicLong, long j) {
        long j2;
        do {
            j2 = atomicLong.get();
        } while (!atomicLong.compareAndSet(j2, C5923a.m24835a(j2, j)));
        return j2;
    }

    /* renamed from: b */
    public static long m24838b(AtomicLong atomicLong, long j) {
        long j2;
        long j3;
        do {
            j3 = atomicLong.get();
            if (j3 == Clock.MAX_TIME) {
                return Clock.MAX_TIME;
            }
            j2 = j3 - j;
            if (j2 < 0) {
                j = new StringBuilder();
                j.append("More produced than requested: ");
                j.append(j2);
                throw new IllegalStateException(j.toString());
            }
        } while (!atomicLong.compareAndSet(j3, j2));
        return j2;
    }

    /* renamed from: a */
    public static boolean m24837a(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i >= 0) {
            return i != 0 ? 1 : 0;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("n >= 0 required but it was ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}
