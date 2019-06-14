package com.google.android.exoplayer2.p137e.p140d;

import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.C2571p;
import com.google.android.exoplayer2.p137e.C2303e;
import com.google.android.exoplayer2.p137e.C2304f;
import com.google.android.exoplayer2.p137e.C2320g;
import com.google.android.exoplayer2.p137e.C2323h;
import com.google.android.exoplayer2.p137e.C2324i;
import com.google.android.exoplayer2.p137e.C2326k;
import com.google.android.exoplayer2.p137e.C2327l;
import com.google.android.exoplayer2.p137e.C2329m;
import com.google.android.exoplayer2.p137e.p140d.C2268a.C4107a;
import com.google.android.exoplayer2.p137e.p140d.C2268a.C4108b;
import com.google.android.exoplayer2.p145g.C2344a;
import com.google.android.exoplayer2.p164l.C2516a;
import com.google.android.exoplayer2.p164l.C2527j;
import com.google.android.exoplayer2.p164l.C2529l;
import com.google.android.exoplayer2.p164l.C2541v;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* compiled from: Mp4Extractor */
/* renamed from: com.google.android.exoplayer2.e.d.g */
public final class C4114g implements C2303e, C2327l {
    /* renamed from: a */
    public static final C2323h f10520a = new C41131();
    /* renamed from: b */
    private static final int f10521b = C2541v.m7193g("qt  ");
    /* renamed from: c */
    private final int f10522c;
    /* renamed from: d */
    private final C2529l f10523d;
    /* renamed from: e */
    private final C2529l f10524e;
    /* renamed from: f */
    private final C2529l f10525f;
    /* renamed from: g */
    private final Stack<C4107a> f10526g;
    /* renamed from: h */
    private int f10527h;
    /* renamed from: i */
    private int f10528i;
    /* renamed from: j */
    private long f10529j;
    /* renamed from: k */
    private int f10530k;
    /* renamed from: l */
    private C2529l f10531l;
    /* renamed from: m */
    private int f10532m;
    /* renamed from: n */
    private int f10533n;
    /* renamed from: o */
    private C2320g f10534o;
    /* renamed from: p */
    private C2281a[] f10535p;
    /* renamed from: q */
    private long f10536q;
    /* renamed from: r */
    private boolean f10537r;

    /* compiled from: Mp4Extractor */
    /* renamed from: com.google.android.exoplayer2.e.d.g$a */
    private static final class C2281a {
        /* renamed from: a */
        public final C2285j f5565a;
        /* renamed from: b */
        public final C2288m f5566b;
        /* renamed from: c */
        public final C2329m f5567c;
        /* renamed from: d */
        public int f5568d;

        public C2281a(C2285j c2285j, C2288m c2288m, C2329m c2329m) {
            this.f5565a = c2285j;
            this.f5566b = c2288m;
            this.f5567c = c2329m;
        }
    }

    /* compiled from: Mp4Extractor */
    /* renamed from: com.google.android.exoplayer2.e.d.g$1 */
    static class C41131 implements C2323h {
        C41131() {
        }

        /* renamed from: a */
        public C2303e[] mo2161a() {
            return new C2303e[]{new C4114g()};
        }
    }

    /* renamed from: a */
    public boolean mo2167a() {
        return true;
    }

    /* renamed from: c */
    public void mo2166c() {
    }

    public C4114g() {
        this(0);
    }

    public C4114g(int i) {
        this.f10522c = i;
        this.f10525f = new C2529l(16);
        this.f10526g = new Stack();
        this.f10523d = new C2529l(C2527j.f6433a);
        this.f10524e = new C2529l(4);
    }

    /* renamed from: a */
    public boolean mo2165a(C2304f c2304f) {
        return C2284i.m6322b(c2304f);
    }

    /* renamed from: a */
    public void mo2164a(C2320g c2320g) {
        this.f10534o = c2320g;
    }

    /* renamed from: a */
    public void mo2163a(long j, long j2) {
        this.f10526g.clear();
        this.f10530k = 0;
        this.f10532m = 0;
        this.f10533n = 0;
        if (j == 0) {
            m12966d();
        } else if (this.f10535p != null) {
            m12965c(j2);
        }
    }

    /* renamed from: a */
    public int mo2162a(C2304f c2304f, C2326k c2326k) {
        while (true) {
            switch (this.f10527h) {
                case 0:
                    if (m12962b(c2304f)) {
                        break;
                    }
                    return -1;
                case 1:
                    if (!m12963b(c2304f, c2326k)) {
                        break;
                    }
                    return 1;
                case 2:
                    return m12964c(c2304f, c2326k);
                default:
                    throw new IllegalStateException();
            }
        }
    }

    /* renamed from: b */
    public long mo2168b() {
        return this.f10536q;
    }

    /* renamed from: b */
    public long mo2169b(long j) {
        long j2 = Clock.MAX_TIME;
        for (C2281a c2281a : this.f10535p) {
            C2288m c2288m = c2281a.f5566b;
            int a = c2288m.m6331a(j);
            if (a == -1) {
                a = c2288m.m6332b(j);
            }
            long j3 = c2288m.f5609b[a];
            if (j3 < j2) {
                j2 = j3;
            }
        }
        return j2;
    }

    /* renamed from: d */
    private void m12966d() {
        this.f10527h = 0;
        this.f10530k = 0;
    }

    /* renamed from: b */
    private boolean m12962b(C2304f c2304f) {
        if (this.f10530k == 0) {
            if (!c2304f.mo2184a(this.f10525f.f6441a, 0, 8, true)) {
                return false;
            }
            this.f10530k = 8;
            this.f10525f.m7096c(0);
            this.f10529j = this.f10525f.m7109m();
            this.f10528i = this.f10525f.m7111o();
        }
        if (this.f10529j == 1) {
            c2304f.mo2187b(this.f10525f.f6441a, 8, 8);
            this.f10530k += 8;
            this.f10529j = this.f10525f.m7119w();
        } else if (this.f10529j == 0) {
            long d = c2304f.mo2192d();
            if (d == -1 && !this.f10526g.isEmpty()) {
                d = ((C4107a) this.f10526g.peek()).aQ;
            }
            if (d != -1) {
                this.f10529j = (d - c2304f.mo2189c()) + ((long) this.f10530k);
            }
        }
        if (this.f10529j >= ((long) this.f10530k)) {
            if (C4114g.m12961b(this.f10528i)) {
                long c = (c2304f.mo2189c() + this.f10529j) - ((long) this.f10530k);
                this.f10526g.add(new C4107a(this.f10528i, c));
                if (this.f10529j == ((long) this.f10530k)) {
                    m12957a(c);
                } else {
                    m12966d();
                }
            } else if (C4114g.m12959a(this.f10528i) != null) {
                C2516a.m7019b(this.f10530k == 8 ? true : null);
                C2516a.m7019b(this.f10529j <= 2147483647L ? true : null);
                this.f10531l = new C2529l((int) this.f10529j);
                System.arraycopy(this.f10525f.f6441a, 0, this.f10531l.f6441a, 0, 8);
                this.f10527h = 1;
            } else {
                this.f10531l = null;
                this.f10527h = 1;
            }
            return true;
        }
        throw new C2571p("Atom size less than header length (unsupported).");
    }

    /* renamed from: b */
    private boolean m12963b(C2304f c2304f, C2326k c2326k) {
        long j = this.f10529j - ((long) this.f10530k);
        long c = c2304f.mo2189c() + j;
        if (this.f10531l != null) {
            c2304f.mo2187b(this.f10531l.f6441a, this.f10530k, (int) j);
            if (this.f10528i == C2268a.f5467a) {
                this.f10537r = C4114g.m12960a(this.f10531l);
            } else if (this.f10526g.isEmpty() == null) {
                ((C4107a) this.f10526g.peek()).m12909a(new C4108b(this.f10528i, this.f10531l));
            }
        } else if (j < 262144) {
            c2304f.mo2186b((int) j);
        } else {
            c2326k.f5776a = c2304f.mo2189c() + j;
            c2304f = true;
            m12957a(c);
            if (c2304f != null || this.f10527h == 2) {
                return false;
            }
            return true;
        }
        c2304f = null;
        m12957a(c);
        if (c2304f != null) {
        }
        return false;
    }

    /* renamed from: a */
    private void m12957a(long j) {
        while (!this.f10526g.isEmpty() && ((C4107a) this.f10526g.peek()).aQ == j) {
            C4107a c4107a = (C4107a) this.f10526g.pop();
            if (c4107a.aP == C2268a.f5442B) {
                m12958a(c4107a);
                this.f10526g.clear();
                this.f10527h = 2;
            } else if (!this.f10526g.isEmpty()) {
                ((C4107a) this.f10526g.peek()).m12908a(c4107a);
            }
        }
        if (this.f10527h != 2) {
            m12966d();
        }
    }

    /* renamed from: a */
    private static boolean m12960a(C2529l c2529l) {
        c2529l.m7096c(8);
        if (c2529l.m7111o() == f10521b) {
            return true;
        }
        c2529l.m7098d(4);
        while (c2529l.m7093b() > 0) {
            if (c2529l.m7111o() == f10521b) {
                return true;
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m12958a(C4107a c4107a) {
        C2344a a;
        C4114g c4114g = this;
        C4107a c4107a2 = c4107a;
        List arrayList = new ArrayList();
        C2324i c2324i = new C2324i();
        C4108b d = c4107a2.m12910d(C2268a.aA);
        if (d != null) {
            a = C2273b.m6286a(d, c4114g.f10537r);
            if (a != null) {
                c2324i.m6447a(a);
            }
        } else {
            a = null;
        }
        long j = Clock.MAX_TIME;
        long j2 = -9223372036854775807L;
        for (int i = 0; i < c4107a2.aS.size(); i++) {
            C4107a c4107a3 = (C4107a) c4107a2.aS.get(i);
            if (c4107a3.aP == C2268a.f5444D) {
                C2285j a2 = C2273b.m6283a(c4107a3, c4107a2.m12910d(C2268a.f5443C), -9223372036854775807L, null, (c4114g.f10522c & 1) != 0, c4114g.f10537r);
                if (a2 != null) {
                    C2288m a3 = C2273b.m6285a(a2, c4107a3.m12911e(C2268a.f5445E).m12911e(C2268a.f5446F).m12911e(C2268a.f5447G), c2324i);
                    if (a3.f5608a != 0) {
                        C2281a c2281a = new C2281a(a2, a3, c4114g.f10534o.mo2231a(i, a2.f5574b));
                        C2515k a4 = a2.f5578f.m7006a(a3.f5611d + 30);
                        if (a2.f5574b == 1) {
                            if (c2324i.m6445a()) {
                                a4 = a4.m7007a(c2324i.f5760b, c2324i.f5761c);
                            }
                            if (a != null) {
                                a4 = a4.m7010a(a);
                            }
                        }
                        c2281a.f5567c.mo2199a(a4);
                        j2 = Math.max(j2, a2.f5577e);
                        arrayList.add(c2281a);
                        long j3 = a3.f5609b[0];
                        if (j3 < j) {
                            j = j3;
                        }
                    }
                }
            }
        }
        c4114g.f10536q = j2;
        c4114g.f10535p = (C2281a[]) arrayList.toArray(new C2281a[arrayList.size()]);
        c4114g.f10534o.mo2232a();
        c4114g.f10534o.mo2233a(c4114g);
    }

    /* renamed from: c */
    private int m12964c(C2304f c2304f, C2326k c2326k) {
        int e = m12967e();
        if (e == -1) {
            return -1;
        }
        C2281a c2281a = this.f10535p[e];
        C2329m c2329m = c2281a.f5567c;
        int i = c2281a.f5568d;
        long j = c2281a.f5566b.f5609b[i];
        int i2 = c2281a.f5566b.f5610c[i];
        if (c2281a.f5565a.f5579g == 1) {
            j += 8;
            i2 -= 8;
        }
        long c = (j - c2304f.mo2189c()) + ((long) this.f10532m);
        if (c >= 0) {
            if (c < 262144) {
                c2304f.mo2186b((int) c);
                if (c2281a.f5565a.f5582j != null) {
                    c2326k = this.f10524e.f6441a;
                    c2326k[0] = null;
                    c2326k[1] = null;
                    c2326k[2] = null;
                    c2326k = c2281a.f5565a.f5582j;
                    int i3 = 4 - c2281a.f5565a.f5582j;
                    while (this.f10532m < i2) {
                        if (this.f10533n == 0) {
                            c2304f.mo2187b(this.f10524e.f6441a, i3, c2326k);
                            this.f10524e.m7096c(0);
                            this.f10533n = this.f10524e.m7117u();
                            this.f10523d.m7096c(0);
                            c2329m.mo2200a(this.f10523d, 4);
                            this.f10532m += 4;
                            i2 += i3;
                        } else {
                            int a = c2329m.mo2197a(c2304f, this.f10533n, false);
                            this.f10532m += a;
                            this.f10533n -= a;
                        }
                    }
                } else {
                    while (this.f10532m < i2) {
                        c2326k = c2329m.mo2197a(c2304f, i2 - this.f10532m, false);
                        this.f10532m += c2326k;
                        this.f10533n -= c2326k;
                    }
                }
                int i4 = i2;
                c2329m.mo2198a(c2281a.f5566b.f5612e[i], c2281a.f5566b.f5613f[i], i4, 0, null);
                c2281a.f5568d += 1;
                this.f10532m = 0;
                this.f10533n = 0;
                return 0;
            }
        }
        c2326k.f5776a = j;
        return 1;
    }

    /* renamed from: e */
    private int m12967e() {
        int i = -1;
        long j = Clock.MAX_TIME;
        for (int i2 = 0; i2 < this.f10535p.length; i2++) {
            C2281a c2281a = this.f10535p[i2];
            int i3 = c2281a.f5568d;
            if (i3 != c2281a.f5566b.f5608a) {
                long j2 = c2281a.f5566b.f5609b[i3];
                if (j2 < j) {
                    i = i2;
                    j = j2;
                }
            }
        }
        return i;
    }

    /* renamed from: c */
    private void m12965c(long j) {
        for (C2281a c2281a : this.f10535p) {
            C2288m c2288m = c2281a.f5566b;
            int a = c2288m.m6331a(j);
            if (a == -1) {
                a = c2288m.m6332b(j);
            }
            c2281a.f5568d = a;
        }
    }

    /* renamed from: a */
    private static boolean m12959a(int i) {
        if (!(i == C2268a.f5458R || i == C2268a.f5443C || i == C2268a.f5459S || i == C2268a.f5460T || i == C2268a.am || i == C2268a.an || i == C2268a.ao || i == C2268a.f5457Q || i == C2268a.ap || i == C2268a.aq || i == C2268a.ar || i == C2268a.as || i == C2268a.at || i == C2268a.f5455O || i == C2268a.f5467a)) {
            if (i != C2268a.aA) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    private static boolean m12961b(int i) {
        if (!(i == C2268a.f5442B || i == C2268a.f5444D || i == C2268a.f5445E || i == C2268a.f5446F || i == C2268a.f5447G)) {
            if (i != C2268a.f5456P) {
                return false;
            }
        }
        return true;
    }
}
