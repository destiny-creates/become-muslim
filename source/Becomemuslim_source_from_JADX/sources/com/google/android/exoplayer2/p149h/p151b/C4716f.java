package com.google.android.exoplayer2.p149h.p151b;

import android.net.Uri;
import android.os.SystemClock;
import com.google.android.exoplayer2.C2251b;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p137e.C2327l;
import com.google.android.exoplayer2.p137e.C4097a;
import com.google.android.exoplayer2.p137e.p139b.C4101d;
import com.google.android.exoplayer2.p137e.p140d.C4112e;
import com.google.android.exoplayer2.p137e.p197f.C4125a;
import com.google.android.exoplayer2.p149h.C2393b;
import com.google.android.exoplayer2.p149h.p150a.C2371e;
import com.google.android.exoplayer2.p149h.p150a.C2373h;
import com.google.android.exoplayer2.p149h.p150a.C4168c;
import com.google.android.exoplayer2.p149h.p150a.C4170d;
import com.google.android.exoplayer2.p149h.p150a.C4711k;
import com.google.android.exoplayer2.p149h.p150a.C4712l;
import com.google.android.exoplayer2.p149h.p150a.C4897i;
import com.google.android.exoplayer2.p149h.p150a.C4898m;
import com.google.android.exoplayer2.p149h.p151b.C4180a.C2374a;
import com.google.android.exoplayer2.p149h.p151b.p152a.C2375a;
import com.google.android.exoplayer2.p149h.p151b.p152a.C2376b;
import com.google.android.exoplayer2.p149h.p151b.p152a.C2380f;
import com.google.android.exoplayer2.p149h.p151b.p152a.C2382g;
import com.google.android.exoplayer2.p162j.C2484f;
import com.google.android.exoplayer2.p163k.C2498g;
import com.google.android.exoplayer2.p163k.C2498g.C2497a;
import com.google.android.exoplayer2.p163k.C2501j;
import com.google.android.exoplayer2.p163k.C2512t;
import com.google.android.exoplayer2.p163k.C4250r.C4249e;
import com.google.android.exoplayer2.p164l.C2524i;
import com.google.android.exoplayer2.p164l.C2541v;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: DefaultDashChunkSource */
/* renamed from: com.google.android.exoplayer2.h.b.f */
public class C4716f implements C4180a {
    /* renamed from: a */
    protected final C2392b[] f12753a;
    /* renamed from: b */
    private final C2512t f12754b;
    /* renamed from: c */
    private final int[] f12755c;
    /* renamed from: d */
    private final C2484f f12756d;
    /* renamed from: e */
    private final int f12757e;
    /* renamed from: f */
    private final C2498g f12758f;
    /* renamed from: g */
    private final long f12759g;
    /* renamed from: h */
    private final int f12760h;
    /* renamed from: i */
    private C2376b f12761i;
    /* renamed from: j */
    private int f12762j;
    /* renamed from: k */
    private IOException f12763k;
    /* renamed from: l */
    private boolean f12764l;
    /* renamed from: m */
    private long f12765m = -9223372036854775807L;

    /* compiled from: DefaultDashChunkSource */
    /* renamed from: com.google.android.exoplayer2.h.b.f$b */
    protected static final class C2392b {
        /* renamed from: a */
        final C4170d f5892a;
        /* renamed from: b */
        public C2382g f5893b;
        /* renamed from: c */
        public C2391d f5894c;
        /* renamed from: d */
        private long f5895d;
        /* renamed from: e */
        private int f5896e;

        C2392b(long j, int i, C2382g c2382g, boolean z, boolean z2) {
            this.f5895d = j;
            this.f5893b = c2382g;
            String str = c2382g.f5865c.f6379e;
            if (C2392b.m6596b(str)) {
                this.f5892a = null;
            } else {
                if ("application/x-rawcc".equals(str)) {
                    j = new C4125a(c2382g.f5865c);
                } else if (C2392b.m6595a(str) != null) {
                    j = new C4101d(1);
                } else {
                    int i2 = z ? 4 : 0;
                    if (z2) {
                        j = Collections.singletonList(C2515k.m6981a(null, "application/cea-608", 0, null));
                    } else {
                        j = Collections.emptyList();
                    }
                    C4112e c4112e = new C4112e(i2, null, null, null, j);
                }
                this.f5892a = new C4170d(j, i, c2382g.f5865c);
            }
            this.f5894c = c2382g.mo2254e();
        }

        /* renamed from: a */
        void m6600a(long j, C2382g c2382g) {
            C2391d e = this.f5893b.mo2254e();
            C2391d e2 = c2382g.mo2254e();
            this.f5895d = j;
            this.f5893b = c2382g;
            if (e != null) {
                this.f5894c = e2;
                if (e.mo2252b() != null) {
                    j = e.mo2247a(this.f5895d);
                    if (j != null) {
                        int a = (e.mo2246a() + j) - 1;
                        long a2 = e.mo2249a(a) + e.mo2250a(a, this.f5895d);
                        int a3 = e2.mo2246a();
                        long a4 = e2.mo2249a(a3);
                        c2382g = (a2 > a4 ? 1 : (a2 == a4 ? 0 : -1));
                        if (c2382g == null) {
                            this.f5896e += (a + 1) - a3;
                        } else if (c2382g >= null) {
                            this.f5896e += e.mo2248a(a4, this.f5895d) - a3;
                        } else {
                            throw new C2393b();
                        }
                    }
                }
            }
        }

        /* renamed from: a */
        public int m6597a() {
            return this.f5894c.mo2246a() + this.f5896e;
        }

        /* renamed from: b */
        public int m6601b() {
            return this.f5894c.mo2247a(this.f5895d);
        }

        /* renamed from: a */
        public long m6599a(int i) {
            return this.f5894c.mo2249a(i - this.f5896e);
        }

        /* renamed from: b */
        public long m6602b(int i) {
            return m6599a(i) + this.f5894c.mo2250a(i - this.f5896e, this.f5895d);
        }

        /* renamed from: a */
        public int m6598a(long j) {
            return this.f5894c.mo2248a(j, this.f5895d) + this.f5896e;
        }

        /* renamed from: c */
        public C2380f m6603c(int i) {
            return this.f5894c.mo2251b(i - this.f5896e);
        }

        /* renamed from: a */
        private static boolean m6595a(String str) {
            if (!(str.startsWith("video/webm") || str.startsWith("audio/webm"))) {
                if (str.startsWith("application/webm") == null) {
                    return null;
                }
            }
            return true;
        }

        /* renamed from: b */
        private static boolean m6596b(String str) {
            if (!C2524i.m7052c(str)) {
                if ("application/ttml+xml".equals(str) == null) {
                    return null;
                }
            }
            return true;
        }
    }

    /* compiled from: DefaultDashChunkSource */
    /* renamed from: com.google.android.exoplayer2.h.b.f$a */
    public static final class C4188a implements C2374a {
        /* renamed from: a */
        private final C2497a f10898a;
        /* renamed from: b */
        private final int f10899b;

        public C4188a(C2497a c2497a) {
            this(c2497a, 1);
        }

        public C4188a(C2497a c2497a, int i) {
            this.f10898a = c2497a;
            this.f10899b = i;
        }

        /* renamed from: a */
        public C4180a mo2266a(C2512t c2512t, C2376b c2376b, int i, int[] iArr, C2484f c2484f, int i2, long j, boolean z, boolean z2) {
            return new C4716f(c2512t, c2376b, i, iArr, c2484f, i2, this.f10898a.createDataSource(), j, this.f10899b, z, z2);
        }
    }

    public C4716f(C2512t c2512t, C2376b c2376b, int i, int[] iArr, C2484f c2484f, int i2, C2498g c2498g, long j, int i3, boolean z, boolean z2) {
        C2484f c2484f2 = c2484f;
        this.f12754b = c2512t;
        this.f12761i = c2376b;
        this.f12755c = iArr;
        this.f12756d = c2484f2;
        this.f12757e = i2;
        this.f12758f = c2498g;
        this.f12762j = i;
        this.f12759g = j;
        this.f12760h = i3;
        long c = c2376b.m6571c(i);
        List b = m16100b();
        this.f12753a = new C2392b[c2484f.mo2306g()];
        for (int i4 = 0; i4 < r0.f12753a.length; i4++) {
            r0.f12753a[i4] = new C2392b(c, i2, (C2382g) b.get(c2484f2.mo2301b(i4)), z, z2);
        }
    }

    /* renamed from: a */
    public void mo3213a(C2376b c2376b, int i) {
        try {
            this.f12761i = c2376b;
            this.f12762j = i;
            c2376b = this.f12761i.m6571c(this.f12762j);
            List b = m16100b();
            for (int i2 = 0; i2 < this.f12753a.length; i2++) {
                this.f12753a[i2].m6600a(c2376b, (C2382g) b.get(this.f12756d.mo2301b(i2)));
            }
        } catch (C2376b c2376b2) {
            this.f12763k = c2376b2;
        }
    }

    /* renamed from: a */
    public void mo3210a() {
        if (this.f12763k == null) {
            this.f12754b.mo2322d();
            return;
        }
        throw this.f12763k;
    }

    /* renamed from: a */
    public void mo3212a(C4712l c4712l, long j, long j2, C2371e c2371e) {
        if (this.f12763k == null) {
            this.f12756d.mo3216a(j, j2 - j, m16096a(j));
            C2392b c2392b = this.f12753a[this.f12756d.mo3215a()];
            if (c2392b.f5892a != null) {
                j = c2392b.f5893b;
                C2380f c = c2392b.f5892a.m13273c() == null ? j.m6578c() : null;
                C2380f d = c2392b.f5894c == null ? j.mo2253d() : null;
                if (!(c == null && d == null)) {
                    c2371e.f5828a = C4716f.m16098a(c2392b, this.f12758f, this.f12756d.mo2307h(), this.f12756d.mo3217b(), this.f12756d.mo3218c(), c, d);
                    return;
                }
            }
            j = c2392b.m6601b();
            boolean z = false;
            if (j == null) {
                if (this.f12761i.f5838d == null || this.f12762j < this.f12761i.m6568a() - 1) {
                    z = true;
                }
                c2371e.f5829b = z;
                return;
            }
            int a;
            int a2 = c2392b.m6597a();
            if (j == -1) {
                long c2 = (m16101c() - C2251b.m6222b(this.f12761i.f5835a)) - C2251b.m6222b(this.f12761i.m6569a(this.f12762j).f5857b);
                if (this.f12761i.f5840f != -9223372036854775807L) {
                    a2 = Math.max(a2, c2392b.m6598a(c2 - C2251b.m6222b(this.f12761i.f5840f)));
                }
                a = c2392b.m6598a(c2) - 1;
            } else {
                a = (j + a2) - 1;
            }
            m16099a(c2392b, a);
            if (c4712l == null) {
                c4712l = C2541v.m7164a(c2392b.m6598a(j2), a2, a);
            } else {
                c4712l = c4712l.mo3525g();
                if (c4712l < a2) {
                    this.f12763k = new C2393b();
                    return;
                }
            }
            int i = c4712l;
            if (i <= a) {
                if (this.f12764l == null || i < a) {
                    c2371e.f5828a = C4716f.m16097a(c2392b, this.f12758f, this.f12757e, this.f12756d.mo2307h(), this.f12756d.mo3217b(), this.f12756d.mo3218c(), i, Math.min(this.f12760h, (a - i) + 1));
                    return;
                }
            }
            if (this.f12761i.f5838d == null || this.f12762j < this.f12761i.m6568a() - 1) {
                z = true;
            }
            c2371e.f5829b = z;
        }
    }

    /* renamed from: a */
    public void mo3211a(C4168c c4168c) {
        if (c4168c instanceof C4711k) {
            c4168c = this.f12753a[this.f12756d.mo2298a(((C4711k) c4168c).c)];
            if (c4168c.f5894c == null) {
                C2327l b = c4168c.f5892a.m13272b();
                if (b != null) {
                    c4168c.f5894c = new C4187e((C4097a) b);
                }
            }
        }
    }

    /* renamed from: a */
    public boolean mo3214a(C4168c c4168c, boolean z, Exception exception) {
        if (!z) {
            return null;
        }
        if (!this.f12761i.f5838d && (c4168c instanceof C4712l) && (exception instanceof C4249e) && ((C4249e) exception).f11212c) {
            z = this.f12753a[this.f12756d.mo2298a(c4168c.f10806c)];
            int b = z.m6601b();
            if (!(b == -1 || b == 0 || ((C4712l) c4168c).mo3525g() <= (z.m6597a() + b) - true)) {
                this.f12764l = true;
                return true;
            }
        }
        return C2373h.m6564a(this.f12756d, this.f12756d.mo2298a(c4168c.f10806c), exception);
    }

    /* renamed from: b */
    private ArrayList<C2382g> m16100b() {
        List list = this.f12761i.m6569a(this.f12762j).f5858c;
        ArrayList<C2382g> arrayList = new ArrayList();
        for (int i : this.f12755c) {
            arrayList.addAll(((C2375a) list.get(i)).f5832c);
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m16099a(C2392b c2392b, int i) {
        this.f12765m = this.f12761i.f5838d ? c2392b.m6602b(i) : 1;
    }

    /* renamed from: c */
    private long m16101c() {
        if (this.f12759g != 0) {
            return (SystemClock.elapsedRealtime() + this.f12759g) * 1000;
        }
        return System.currentTimeMillis() * 1000;
    }

    /* renamed from: a */
    private long m16096a(long j) {
        Object obj = (!this.f12761i.f5838d || this.f12765m == -9223372036854775807L) ? null : 1;
        if (obj != null) {
            return this.f12765m - j;
        }
        return -9223372036854775807L;
    }

    /* renamed from: a */
    protected static C4168c m16098a(C2392b c2392b, C2498g c2498g, C2515k c2515k, int i, Object obj, C2380f c2380f, C2380f c2380f2) {
        String str = c2392b.f5893b.f5866d;
        if (c2380f != null) {
            c2380f2 = c2380f.m6574a(c2380f2, str);
            if (c2380f2 == null) {
                c2380f2 = c2380f;
            }
        }
        return new C4711k(c2498g, new C2501j(c2380f2.m6573a(str), c2380f2.f5859a, c2380f2.f5860b, c2392b.f5893b.mo2255f()), c2515k, i, obj, c2392b.f5892a);
    }

    /* renamed from: a */
    protected static C4168c m16097a(C2392b c2392b, C2498g c2498g, int i, C2515k c2515k, int i2, Object obj, int i3, int i4) {
        C2392b c2392b2 = c2392b;
        int i5 = i3;
        C2382g c2382g = c2392b2.f5893b;
        long a = c2392b2.m6599a(i5);
        C2380f c = c2392b2.m6603c(i5);
        String str = c2382g.f5866d;
        if (c2392b2.f5892a == null) {
            return new C4898m(c2498g, new C2501j(c.m6573a(str), c.f5859a, c.f5860b, c2382g.mo2255f()), c2515k, i2, obj, a, c2392b2.m6602b(i5), i3, i, c2515k);
        }
        C2380f c2380f = c;
        int i6 = 1;
        int i7 = 1;
        int i8 = i4;
        while (i6 < i8) {
            C2380f a2 = c2380f.m6574a(c2392b2.m6603c(i5 + i6), str);
            if (a2 == null) {
                break;
            }
            i7++;
            i6++;
            c2380f = a2;
        }
        long b = c2392b2.m6602b((i5 + i7) - 1);
        Uri a3 = c2380f.m6573a(str);
        long j = c2380f.f5859a;
        return new C4897i(c2498g, new C2501j(a3, j, c2380f.f5860b, c2382g.mo2255f()), c2515k, i2, obj, a, b, i3, i7, -c2382g.f5867e, c2392b2.f5892a);
    }
}
