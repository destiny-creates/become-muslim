package com.google.android.exoplayer2.p164l;

import com.facebook.common.time.Clock;

/* compiled from: TimestampAdjuster */
/* renamed from: com.google.android.exoplayer2.l.s */
public final class C2537s {
    /* renamed from: a */
    private long f6463a;
    /* renamed from: b */
    private long f6464b;
    /* renamed from: c */
    private volatile long f6465c = -9223372036854775807L;

    public C2537s(long j) {
        m7147a(j);
    }

    /* renamed from: a */
    public synchronized void m7147a(long j) {
        C2516a.m7019b(this.f6465c == -9223372036854775807L);
        this.f6463a = j;
    }

    /* renamed from: a */
    public long m7146a() {
        return this.f6463a;
    }

    /* renamed from: b */
    public long m7148b() {
        if (this.f6465c != -9223372036854775807L) {
            return this.f6465c;
        }
        return this.f6463a != Clock.MAX_TIME ? this.f6463a : -9223372036854775807L;
    }

    /* renamed from: c */
    public long m7150c() {
        if (this.f6463a == Clock.MAX_TIME) {
            return 0;
        }
        return this.f6465c == -9223372036854775807L ? -9223372036854775807L : this.f6464b;
    }

    /* renamed from: d */
    public void m7152d() {
        this.f6465c = -9223372036854775807L;
    }

    /* renamed from: b */
    public long m7149b(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.f6465c != -9223372036854775807L) {
            long e = C2537s.m7145e(this.f6465c);
            long j2 = (4294967296L + e) / 8589934592L;
            long j3 = ((j2 - 1) * 8589934592L) + j;
            j += j2 * 8589934592L;
            if (Math.abs(j3 - e) < Math.abs(j - e)) {
                j = j3;
            }
        }
        return m7151c(C2537s.m7144d(j));
    }

    /* renamed from: c */
    public long m7151c(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.f6465c != -9223372036854775807L) {
            this.f6465c = j;
        } else {
            if (this.f6463a != Clock.MAX_TIME) {
                this.f6464b = this.f6463a - j;
            }
            synchronized (this) {
                this.f6465c = j;
                notifyAll();
            }
        }
        return j + this.f6464b;
    }

    /* renamed from: e */
    public synchronized void m7153e() {
        while (this.f6465c == -9223372036854775807L) {
            wait();
        }
    }

    /* renamed from: d */
    public static long m7144d(long j) {
        return (j * 1000000) / 90000;
    }

    /* renamed from: e */
    public static long m7145e(long j) {
        return (j * 90000) / 1000000;
    }
}
