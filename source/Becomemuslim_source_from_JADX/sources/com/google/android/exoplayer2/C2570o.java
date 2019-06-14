package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.C2589y.C2587a;
import com.google.android.exoplayer2.C2589y.C2588b;
import com.google.android.exoplayer2.p149h.C2423i.C2422b;

/* compiled from: MediaPeriodInfoSequence */
/* renamed from: com.google.android.exoplayer2.o */
final class C2570o {
    /* renamed from: a */
    private final C2587a f6559a = new C2587a();
    /* renamed from: b */
    private final C2588b f6560b = new C2588b();
    /* renamed from: c */
    private C2589y f6561c;
    /* renamed from: d */
    private int f6562d;
    /* renamed from: e */
    private boolean f6563e;

    /* compiled from: MediaPeriodInfoSequence */
    /* renamed from: com.google.android.exoplayer2.o$a */
    public static final class C2569a {
        /* renamed from: a */
        public final C2422b f6552a;
        /* renamed from: b */
        public final long f6553b;
        /* renamed from: c */
        public final long f6554c;
        /* renamed from: d */
        public final long f6555d;
        /* renamed from: e */
        public final long f6556e;
        /* renamed from: f */
        public final boolean f6557f;
        /* renamed from: g */
        public final boolean f6558g;

        private C2569a(C2422b c2422b, long j, long j2, long j3, long j4, boolean z, boolean z2) {
            this.f6552a = c2422b;
            this.f6553b = j;
            this.f6554c = j2;
            this.f6555d = j3;
            this.f6556e = j4;
            this.f6557f = z;
            this.f6558g = z2;
        }

        /* renamed from: a */
        public C2569a m7252a(int i) {
            return new C2569a(this.f6552a.m6656a(i), this.f6553b, this.f6554c, this.f6555d, this.f6556e, this.f6557f, this.f6558g);
        }

        /* renamed from: a */
        public C2569a m7253a(long j) {
            return new C2569a(this.f6552a, j, this.f6554c, this.f6555d, this.f6556e, this.f6557f, this.f6558g);
        }
    }

    /* renamed from: a */
    public void m7266a(C2589y c2589y) {
        this.f6561c = c2589y;
    }

    /* renamed from: a */
    public void m7265a(int i) {
        this.f6562d = i;
    }

    /* renamed from: a */
    public void m7267a(boolean z) {
        this.f6563e = z;
    }

    /* renamed from: a */
    public C2569a m7264a(C2572q c2572q) {
        return m7256a(c2572q.f6566c, c2572q.f6568e, c2572q.f6567d);
    }

    /* renamed from: a */
    public C2569a m7263a(C2569a c2569a, long j, long j2) {
        C2570o c2570o = this;
        C2569a c2569a2 = c2569a;
        C2569a c2569a3 = null;
        long j3;
        if (c2569a2.f6557f) {
            int a = c2570o.f6561c.m7321a(c2569a2.f6552a.f5978b, c2570o.f6559a, c2570o.f6560b, c2570o.f6562d, c2570o.f6563e);
            if (a == -1) {
                return null;
            }
            int i = c2570o.f6561c.m7326a(a, c2570o.f6559a).f6619c;
            j3 = 0;
            if (c2570o.f6561c.m7328a(i, c2570o.f6560b).f6633f == a) {
                Pair a2 = c2570o.f6561c.m7325a(c2570o.f6560b, c2570o.f6559a, i, -9223372036854775807L, Math.max(0, (j + c2569a2.f6556e) - j2));
                if (a2 == null) {
                    return null;
                }
                a = ((Integer) a2.first).intValue();
                j3 = ((Long) a2.second).longValue();
            }
            return m7256a(m7260a(a, j3), j3, j3);
        }
        C2422b c2422b = c2569a2.f6552a;
        int i2;
        int d;
        if (c2422b.m6657a()) {
            i2 = c2422b.f5979c;
            c2570o.f6561c.m7326a(c2422b.f5978b, c2570o.f6559a);
            d = c2570o.f6559a.m7314d(i2);
            if (d == -1) {
                return null;
            }
            int i3 = c2422b.f5980d + 1;
            if (i3 < d) {
                if (c2570o.f6559a.m7307a(i2, i3)) {
                    c2569a3 = m7254a(c2422b.f5978b, i2, i3, c2569a2.f6555d);
                }
                return c2569a3;
            }
            int b = c2570o.f6559a.m7309b(c2569a2.f6555d);
            if (b == -1) {
                j3 = Long.MIN_VALUE;
            } else {
                j3 = c2570o.f6559a.m7304a(b);
            }
            return m7255a(c2422b.f5978b, c2569a2.f6555d, j3);
        } else if (c2569a2.f6554c != Long.MIN_VALUE) {
            i2 = c2570o.f6559a.m7302a(c2569a2.f6554c);
            if (c2570o.f6559a.m7307a(i2, 0)) {
                c2569a3 = m7254a(c2422b.f5978b, i2, 0, c2569a2.f6554c);
            }
            return c2569a3;
        } else {
            int c = c2570o.f6559a.m7312c();
            if (c != 0) {
                d = c - 1;
                if (c2570o.f6559a.m7304a(d) == Long.MIN_VALUE && !c2570o.f6559a.m7313c(d)) {
                    if (c2570o.f6559a.m7307a(d, 0)) {
                        return m7254a(c2422b.f5978b, d, 0, c2570o.f6559a.m7303a());
                    }
                }
            }
            return null;
        }
    }

    /* renamed from: a */
    public C2422b m7260a(int i, long j) {
        this.f6561c.m7326a(i, this.f6559a);
        int a = this.f6559a.m7302a(j);
        if (a == -1) {
            return new C2422b(i);
        }
        return new C2422b(i, a, this.f6559a.m7308b(a));
    }

    /* renamed from: a */
    public C2569a m7261a(C2569a c2569a) {
        return m7257a(c2569a, c2569a.f6552a);
    }

    /* renamed from: a */
    public C2569a m7262a(C2569a c2569a, int i) {
        return m7257a(c2569a, c2569a.f6552a.m6656a(i));
    }

    /* renamed from: a */
    private C2569a m7257a(C2569a c2569a, C2422b c2422b) {
        long b;
        long j;
        C2569a c2569a2 = c2569a;
        C2422b c2422b2 = c2422b;
        long j2 = c2569a2.f6553b;
        long j3 = c2569a2.f6554c;
        boolean a = m7258a(c2422b2, j3);
        boolean a2 = m7259a(c2422b2, a);
        this.f6561c.m7326a(c2422b2.f5978b, this.f6559a);
        if (c2422b.m6657a()) {
            b = r0.f6559a.m7311b(c2422b2.f5979c, c2422b2.f5980d);
        } else if (j3 == Long.MIN_VALUE) {
            b = r0.f6559a.m7303a();
        } else {
            j = j3;
            return new C2569a(c2422b, j2, j3, c2569a2.f6555d, j, a, a2);
        }
        j = b;
        return new C2569a(c2422b, j2, j3, c2569a2.f6555d, j, a, a2);
    }

    /* renamed from: a */
    private C2569a m7256a(C2422b c2422b, long j, long j2) {
        this.f6561c.m7326a(c2422b.f5978b, this.f6559a);
        if (!c2422b.m6657a()) {
            int b = this.f6559a.m7309b(j2);
            if (b == -1) {
                j = Long.MIN_VALUE;
            } else {
                j = this.f6559a.m7304a(b);
            }
            return m7255a(c2422b.f5978b, j2, j);
        } else if (this.f6559a.m7307a(c2422b.f5979c, c2422b.f5980d) == null) {
            return null;
        } else {
            return m7254a(c2422b.f5978b, c2422b.f5979c, c2422b.f5980d, j);
        }
    }

    /* renamed from: a */
    private C2569a m7254a(int i, int i2, int i3, long j) {
        int i4 = i2;
        int i5 = i3;
        C2422b c2422b = new C2422b(i, i4, i5);
        boolean a = m7258a(c2422b, Long.MIN_VALUE);
        boolean a2 = m7259a(c2422b, a);
        return new C2569a(c2422b, i5 == this.f6559a.m7308b(i4) ? r0.f6559a.m7315d() : 0, Long.MIN_VALUE, j, this.f6561c.m7326a(c2422b.f5978b, this.f6559a).m7311b(c2422b.f5979c, c2422b.f5980d), a, a2);
    }

    /* renamed from: a */
    private C2569a m7255a(int i, long j, long j2) {
        long j3 = j2;
        C2422b c2422b = new C2422b(i);
        boolean a = m7258a(c2422b, j3);
        boolean a2 = m7259a(c2422b, a);
        this.f6561c.m7326a(c2422b.f5978b, this.f6559a);
        return new C2569a(c2422b, j, j2, -9223372036854775807L, j3 == Long.MIN_VALUE ? r0.f6559a.m7303a() : j3, a, a2);
    }

    /* renamed from: a */
    private boolean m7258a(C2422b c2422b, long j) {
        int c = this.f6561c.m7326a(c2422b.f5978b, this.f6559a).m7312c();
        boolean z = true;
        if (c == 0) {
            return true;
        }
        c--;
        boolean a = c2422b.m6657a();
        if (this.f6559a.m7304a(c) != Long.MIN_VALUE) {
            if (a || j != Long.MIN_VALUE) {
                z = false;
            }
            return z;
        }
        j = this.f6559a.m7314d(c);
        if (j == -1) {
            return false;
        }
        c2422b = (a && c2422b.f5979c == c && c2422b.f5980d == j - 1) ? true : null;
        if (c2422b == null) {
            if (a || this.f6559a.m7308b(c) != j) {
                z = false;
            }
        }
        return z;
    }

    /* renamed from: a */
    private boolean m7259a(C2422b c2422b, boolean z) {
        return (this.f6561c.m7328a(this.f6561c.m7326a(c2422b.f5978b, this.f6559a).f6619c, this.f6560b).f6632e || this.f6561c.m7334b(c2422b.f5978b, this.f6559a, this.f6560b, this.f6562d, this.f6563e) == null || !z) ? null : true;
    }
}
