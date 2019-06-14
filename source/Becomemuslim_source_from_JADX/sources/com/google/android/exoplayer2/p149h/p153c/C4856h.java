package com.google.android.exoplayer2.p149h.p153c;

import android.util.Pair;
import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p136c.C2255a;
import com.google.android.exoplayer2.p137e.C2303e;
import com.google.android.exoplayer2.p137e.C2304f;
import com.google.android.exoplayer2.p137e.C2320g;
import com.google.android.exoplayer2.p137e.C4102b;
import com.google.android.exoplayer2.p145g.C2344a.C2342a;
import com.google.android.exoplayer2.p145g.p147b.C4162g;
import com.google.android.exoplayer2.p145g.p147b.C4701i;
import com.google.android.exoplayer2.p149h.p150a.C4712l;
import com.google.android.exoplayer2.p149h.p153c.p154a.C4190a.C2394a;
import com.google.android.exoplayer2.p163k.C2498g;
import com.google.android.exoplayer2.p163k.C2501j;
import com.google.android.exoplayer2.p164l.C2529l;
import com.google.android.exoplayer2.p164l.C2537s;
import com.google.android.exoplayer2.p164l.C2541v;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: HlsMediaChunk */
/* renamed from: com.google.android.exoplayer2.h.c.h */
final class C4856h extends C4712l {
    /* renamed from: m */
    private static final AtomicInteger f13831m = new AtomicInteger();
    /* renamed from: A */
    private int f13832A;
    /* renamed from: B */
    private boolean f13833B;
    /* renamed from: C */
    private boolean f13834C;
    /* renamed from: D */
    private volatile boolean f13835D;
    /* renamed from: E */
    private volatile boolean f13836E;
    /* renamed from: j */
    public final int f13837j;
    /* renamed from: k */
    public final int f13838k;
    /* renamed from: l */
    public final C2394a f13839l;
    /* renamed from: n */
    private final C2498g f13840n;
    /* renamed from: o */
    private final C2501j f13841o;
    /* renamed from: p */
    private final boolean f13842p = (this.h instanceof C4195a);
    /* renamed from: q */
    private final boolean f13843q;
    /* renamed from: r */
    private final C2537s f13844r;
    /* renamed from: s */
    private final boolean f13845s;
    /* renamed from: t */
    private final C2303e f13846t;
    /* renamed from: u */
    private final boolean f13847u;
    /* renamed from: v */
    private final boolean f13848v;
    /* renamed from: w */
    private final C4162g f13849w;
    /* renamed from: x */
    private final C2529l f13850x;
    /* renamed from: y */
    private C4201l f13851y;
    /* renamed from: z */
    private int f13852z;

    public C4856h(C2406f c2406f, C2498g c2498g, C2501j c2501j, C2501j c2501j2, C2394a c2394a, List<C2515k> list, int i, Object obj, long j, long j2, int i2, int i3, boolean z, C2537s c2537s, C4856h c4856h, C2255a c2255a, byte[] bArr, byte[] bArr2) {
        C2303e c2303e;
        C2501j c2501j3;
        C2501j c2501j4 = c2501j2;
        C2394a c2394a2 = c2394a;
        int i4 = i3;
        C4856h c4856h2 = c4856h;
        super(C4856h.m17297a(c2498g, bArr, bArr2), c2501j, c2394a2.f5898b, i, obj, j, j2, i2);
        this.f13838k = i4;
        this.f13841o = c2501j4;
        this.f13839l = c2394a2;
        this.f13843q = z;
        this.f13844r = c2537s;
        boolean z2 = true;
        if (c4856h2 != null) {
            C2303e c2303e2;
            r11.f13845s = c4856h2.f13839l != c2394a2;
            if (c4856h2.f13838k == i4) {
                if (!r11.f13845s) {
                    c2303e2 = c4856h2.f13846t;
                    c2303e = c2303e2;
                    c2501j3 = c2501j;
                }
            }
            c2303e2 = null;
            c2303e = c2303e2;
            c2501j3 = c2501j;
        } else {
            r11.f13845s = false;
            c2501j3 = c2501j;
            c2303e = null;
        }
        Pair a = c2406f.mo2272a(c2303e, c2501j3.f6349a, r11.c, list, c2255a, c2537s);
        r11.f13846t = (C2303e) a.first;
        r11.f13847u = ((Boolean) a.second).booleanValue();
        r11.f13848v = r11.f13846t == c2303e;
        if (!r11.f13848v || c2501j4 == null) {
            z2 = false;
        }
        r11.f13834C = z2;
        if (r11.f13847u) {
            r11.f13849w = c4856h2 != null ? c4856h2.f13849w : new C4162g();
            r11.f13850x = c4856h2 != null ? c4856h2.f13850x : new C2529l(10);
        } else {
            r11.f13849w = null;
            r11.f13850x = null;
        }
        r11.f13840n = c2498g;
        r11.f13837j = f13831m.getAndIncrement();
    }

    /* renamed from: a */
    public void m17301a(C4201l c4201l) {
        this.f13851y = c4201l;
        c4201l.m13547a(this.f13837j, this.f13845s);
        if (!this.f13848v) {
            this.f13846t.mo2164a((C2320g) c4201l);
        }
    }

    /* renamed from: h */
    public boolean mo3423h() {
        return this.f13836E;
    }

    /* renamed from: f */
    public long mo3197f() {
        return (long) this.f13832A;
    }

    /* renamed from: a */
    public void mo2282a() {
        this.f13835D = true;
    }

    /* renamed from: b */
    public boolean mo2283b() {
        return this.f13835D;
    }

    /* renamed from: c */
    public void mo2284c() {
        m17298d();
        if (!this.f13835D) {
            m17299i();
        }
    }

    /* renamed from: d */
    private void m17298d() {
        C2304f c4102b;
        if (!this.f13834C) {
            if (this.f13841o != null) {
                C2501j a = this.f13841o.m6956a((long) this.f13852z);
                try {
                    c4102b = new C4102b(this.f13840n, a.f6351c, this.f13840n.mo2268a(a));
                    int i = 0;
                    while (i == 0) {
                        if (this.f13835D) {
                            break;
                        }
                        i = this.f13846t.mo2162a(c4102b, null);
                    }
                    this.f13852z = (int) (c4102b.mo2189c() - this.f13841o.f6351c);
                    C2541v.m7174a(this.h);
                    this.f13834C = true;
                } catch (Throwable th) {
                    C2541v.m7174a(this.h);
                }
            }
        }
    }

    /* renamed from: i */
    private void m17299i() {
        Object obj;
        int i = 0;
        C2501j c2501j;
        C2304f c4102b;
        if (this.f13842p) {
            c2501j = this.a;
            if (this.f13832A != 0) {
                obj = 1;
                if (!this.f13843q) {
                    this.f13844r.m7153e();
                } else if (this.f13844r.m7146a() == Clock.MAX_TIME) {
                    this.f13844r.m7147a(this.f);
                }
                c4102b = new C4102b(this.h, c2501j.f6351c, this.h.mo2268a(c2501j));
                if (this.f13847u && !this.f13833B) {
                    long a = m17296a(c4102b);
                    this.f13833B = true;
                    this.f13851y.m13562b(a == -9223372036854775807L ? this.f13844r.m7149b(a) : this.f);
                }
                if (obj != null) {
                    c4102b.mo2186b(this.f13832A);
                }
                while (i == 0) {
                    if (!this.f13835D) {
                        break;
                    }
                    i = this.f13846t.mo2162a(c4102b, null);
                }
                this.f13832A = (int) (c4102b.mo2189c() - this.a.f6351c);
                C2541v.m7174a(this.h);
                this.f13836E = true;
            }
        }
        c2501j = this.a.m6956a((long) this.f13832A);
        obj = null;
        if (!this.f13843q) {
            this.f13844r.m7153e();
        } else if (this.f13844r.m7146a() == Clock.MAX_TIME) {
            this.f13844r.m7147a(this.f);
        }
        try {
            c4102b = new C4102b(this.h, c2501j.f6351c, this.h.mo2268a(c2501j));
            long a2 = m17296a(c4102b);
            this.f13833B = true;
            if (a2 == -9223372036854775807L) {
            }
            this.f13851y.m13562b(a2 == -9223372036854775807L ? this.f13844r.m7149b(a2) : this.f);
            if (obj != null) {
                c4102b.mo2186b(this.f13832A);
            }
            while (i == 0) {
                if (!this.f13835D) {
                    break;
                }
                i = this.f13846t.mo2162a(c4102b, null);
            }
            this.f13832A = (int) (c4102b.mo2189c() - this.a.f6351c);
            C2541v.m7174a(this.h);
            this.f13836E = true;
        } catch (Throwable th) {
            C2541v.m7174a(this.h);
        }
    }

    /* renamed from: a */
    private long m17296a(C2304f c2304f) {
        c2304f.mo2183a();
        if (!c2304f.mo2188b(this.f13850x.f6441a, 0, 10, true)) {
            return -9223372036854775807L;
        }
        this.f13850x.m7089a(10);
        if (this.f13850x.m7107k() != C4162g.f10796a) {
            return -9223372036854775807L;
        }
        this.f13850x.m7098d(3);
        int t = this.f13850x.m7116t();
        int i = t + 10;
        if (i > this.f13850x.m7099e()) {
            Object obj = this.f13850x.f6441a;
            this.f13850x.m7089a(i);
            System.arraycopy(obj, 0, this.f13850x.f6441a, 0, 10);
        }
        if (c2304f.mo2188b(this.f13850x.f6441a, 10, t, true) == null) {
            return -9223372036854775807L;
        }
        c2304f = this.f13849w.m13254a(this.f13850x.f6441a, t);
        if (c2304f == null) {
            return -9223372036854775807L;
        }
        t = c2304f.m6504a();
        for (int i2 = 0; i2 < t; i2++) {
            C2342a a = c2304f.m6505a(i2);
            if (a instanceof C4701i) {
                C4701i c4701i = (C4701i) a;
                if ("com.apple.streaming.transportStreamTimestamp".equals(c4701i.f12703a)) {
                    System.arraycopy(c4701i.f12704b, 0, this.f13850x.f6441a, 0, 8);
                    this.f13850x.m7089a(8);
                    return this.f13850x.m7113q() & 8589934591L;
                }
            }
        }
        return -9223372036854775807L;
    }

    /* renamed from: a */
    private static C2498g m17297a(C2498g c2498g, byte[] bArr, byte[] bArr2) {
        return bArr != null ? new C4195a(c2498g, bArr, bArr2) : c2498g;
    }
}
