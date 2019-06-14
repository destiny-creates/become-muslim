package com.p064b.p065a.p066a;

import io.p347a.p348a.p349a.p350a.p353c.p354a.C6453a;
import java.util.Random;

/* compiled from: RandomBackoff */
/* renamed from: com.b.a.a.l */
class C3407l implements C6453a {
    /* renamed from: a */
    final C6453a f9065a;
    /* renamed from: b */
    final Random f9066b;
    /* renamed from: c */
    final double f9067c;

    public C3407l(C6453a c6453a, double d) {
        this(c6453a, d, new Random());
    }

    public C3407l(C6453a c6453a, double d, Random random) {
        if (d < 0.0d || d > 1.0d) {
            throw new IllegalArgumentException("jitterPercent must be between 0.0 and 1.0");
        } else if (c6453a == null) {
            throw new NullPointerException("backoff must not be null");
        } else if (random != null) {
            this.f9065a = c6453a;
            this.f9067c = d;
            this.f9066b = random;
        } else {
            throw new NullPointerException("random must not be null");
        }
    }

    /* renamed from: a */
    public long m10857a(int i) {
        return (long) (m10856a() * ((double) this.f9065a.a(i)));
    }

    /* renamed from: a */
    double m10856a() {
        double d = 1.0d - this.f9067c;
        return d + (((this.f9067c + 1.0d) - d) * this.f9066b.nextDouble());
    }
}
