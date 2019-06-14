package com.google.android.exoplayer2.p149h.p151b.p152a;

import com.google.android.exoplayer2.p164l.C2541v;
import java.util.List;

/* compiled from: SegmentBase */
/* renamed from: com.google.android.exoplayer2.h.b.a.h */
public abstract class C2384h {
    /* renamed from: a */
    final C2380f f5872a;
    /* renamed from: b */
    final long f5873b;
    /* renamed from: c */
    final long f5874c;

    /* compiled from: SegmentBase */
    /* renamed from: com.google.android.exoplayer2.h.b.a.h$d */
    public static class C2383d {
        /* renamed from: a */
        final long f5870a;
        /* renamed from: b */
        final long f5871b;

        public C2383d(long j, long j2) {
            this.f5870a = j;
            this.f5871b = j2;
        }
    }

    /* compiled from: SegmentBase */
    /* renamed from: com.google.android.exoplayer2.h.b.a.h$a */
    public static abstract class C4177a extends C2384h {
        /* renamed from: d */
        final int f10858d;
        /* renamed from: e */
        final long f10859e;
        /* renamed from: f */
        final List<C2383d> f10860f;

        /* renamed from: a */
        public abstract int mo3198a(long j);

        /* renamed from: a */
        public abstract C2380f mo3199a(C2382g c2382g, int i);

        public C4177a(C2380f c2380f, long j, long j2, int i, long j3, List<C2383d> list) {
            super(c2380f, j, j2);
            this.f10858d = i;
            this.f10859e = j3;
            this.f10860f = list;
        }

        /* renamed from: a */
        public int m13364a(long j, long j2) {
            int b = m13368b();
            j2 = mo3198a(j2);
            if (j2 == null) {
                return b;
            }
            if (this.f10860f == null) {
                j = ((int) (j / ((this.f10859e * 1000000) / this.b))) + this.f10858d;
                if (j >= b) {
                    if (j2 == -1) {
                        b = j;
                    } else {
                        b = Math.min(j, (b + j2) - 1);
                    }
                }
                return b;
            }
            int i = (j2 + b) - 1;
            j2 = b;
            while (j2 <= i) {
                int i2 = ((i - j2) / 2) + j2;
                int i3 = (m13365a(i2) > j ? 1 : (m13365a(i2) == j ? 0 : -1));
                if (i3 < 0) {
                    j2 = i2 + 1;
                } else if (i3 <= 0) {
                    return i2;
                } else {
                    i = i2 - 1;
                }
            }
            if (j2 != b) {
                j2 = i;
            }
            return j2;
        }

        /* renamed from: a */
        public final long m13366a(int i, long j) {
            if (this.f10860f != null) {
                return (((C2383d) this.f10860f.get(i - this.f10858d)).f5871b * 1000000) / this.b;
            }
            int a = mo3198a(j);
            j = (a == -1 || i != (m13368b() + a) - 1) ? (this.f10859e * 1000000) / this.b : j - m13365a(i);
            return j;
        }

        /* renamed from: a */
        public final long m13365a(int i) {
            long j;
            if (this.f10860f != null) {
                j = ((C2383d) this.f10860f.get(i - this.f10858d)).f5870a - this.c;
            } else {
                j = ((long) (i - this.f10858d)) * this.f10859e;
            }
            return C2541v.m7185b(j, 1000000, this.b);
        }

        /* renamed from: b */
        public int m13368b() {
            return this.f10858d;
        }

        /* renamed from: c */
        public boolean mo3200c() {
            return this.f10860f != null;
        }
    }

    /* compiled from: SegmentBase */
    /* renamed from: com.google.android.exoplayer2.h.b.a.h$e */
    public static class C4178e extends C2384h {
        /* renamed from: d */
        final long f10861d;
        /* renamed from: e */
        final long f10862e;

        public C4178e(C2380f c2380f, long j, long j2, long j3, long j4) {
            super(c2380f, j, j2);
            this.f10861d = j3;
            this.f10862e = j4;
        }

        public C4178e() {
            this(null, 1, 0, 0, 0);
        }

        /* renamed from: b */
        public C2380f m13370b() {
            return this.f10862e <= 0 ? null : new C2380f(null, this.f10861d, this.f10862e);
        }
    }

    /* compiled from: SegmentBase */
    /* renamed from: com.google.android.exoplayer2.h.b.a.h$b */
    public static class C4713b extends C4177a {
        /* renamed from: g */
        final List<C2380f> f12736g;

        /* renamed from: c */
        public boolean mo3200c() {
            return true;
        }

        public C4713b(C2380f c2380f, long j, long j2, int i, long j3, List<C2383d> list, List<C2380f> list2) {
            super(c2380f, j, j2, i, j3, list);
            this.f12736g = list2;
        }

        /* renamed from: a */
        public C2380f mo3199a(C2382g c2382g, int i) {
            return (C2380f) this.f12736g.get(i - this.d);
        }

        /* renamed from: a */
        public int mo3198a(long j) {
            return this.f12736g.size();
        }
    }

    /* compiled from: SegmentBase */
    /* renamed from: com.google.android.exoplayer2.h.b.a.h$c */
    public static class C4714c extends C4177a {
        /* renamed from: g */
        final C2385j f12737g;
        /* renamed from: h */
        final C2385j f12738h;

        public C4714c(C2380f c2380f, long j, long j2, int i, long j3, List<C2383d> list, C2385j c2385j, C2385j c2385j2) {
            super(c2380f, j, j2, i, j3, list);
            this.f12737g = c2385j;
            this.f12738h = c2385j2;
        }

        /* renamed from: a */
        public C2380f mo3201a(C2382g c2382g) {
            if (this.f12737g != null) {
                return new C2380f(this.f12737g.m6586a(c2382g.f5865c.f6375a, 0, c2382g.f5865c.f6376b, 0), 0, -1);
            }
            return super.mo3201a(c2382g);
        }

        /* renamed from: a */
        public C2380f mo3199a(C2382g c2382g, int i) {
            long j;
            C2382g c2382g2 = c2382g;
            if (this.f != null) {
                j = ((C2383d) r0.f.get(i - r0.d)).f5870a;
            } else {
                j = ((long) (i - r0.d)) * r0.e;
            }
            long j2 = j;
            return new C2380f(r0.f12738h.m6586a(c2382g2.f5865c.f6375a, i, c2382g2.f5865c.f6376b, j2), 0, -1);
        }

        /* renamed from: a */
        public int mo3198a(long j) {
            if (this.f != null) {
                return this.f.size();
            }
            return j != -9223372036854775807L ? (int) C2541v.m7168a(j, (this.e * 1000000) / this.b) : -1;
        }
    }

    public C2384h(C2380f c2380f, long j, long j2) {
        this.f5872a = c2380f;
        this.f5873b = j;
        this.f5874c = j2;
    }

    /* renamed from: a */
    public C2380f mo3201a(C2382g c2382g) {
        return this.f5872a;
    }

    /* renamed from: a */
    public long m6582a() {
        return C2541v.m7185b(this.f5874c, 1000000, this.f5873b);
    }
}
