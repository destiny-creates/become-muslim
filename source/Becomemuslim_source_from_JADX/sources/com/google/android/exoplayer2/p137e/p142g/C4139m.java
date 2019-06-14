package com.google.android.exoplayer2.p137e.p142g;

import android.util.Pair;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.C2571p;
import com.google.android.exoplayer2.p137e.C2320g;
import com.google.android.exoplayer2.p137e.C2329m;
import com.google.android.exoplayer2.p137e.p142g.C2319w.C2318d;
import com.google.android.exoplayer2.p164l.C2518c;
import com.google.android.exoplayer2.p164l.C2528k;
import com.google.android.exoplayer2.p164l.C2529l;
import java.util.Collections;

/* compiled from: LatmReader */
/* renamed from: com.google.android.exoplayer2.e.g.m */
public final class C4139m implements C2305h {
    /* renamed from: a */
    private final String f10688a;
    /* renamed from: b */
    private final C2529l f10689b = new C2529l(1024);
    /* renamed from: c */
    private final C2528k f10690c = new C2528k(this.f10689b.f6441a);
    /* renamed from: d */
    private C2329m f10691d;
    /* renamed from: e */
    private C2515k f10692e;
    /* renamed from: f */
    private String f10693f;
    /* renamed from: g */
    private int f10694g;
    /* renamed from: h */
    private int f10695h;
    /* renamed from: i */
    private int f10696i;
    /* renamed from: j */
    private int f10697j;
    /* renamed from: k */
    private long f10698k;
    /* renamed from: l */
    private boolean f10699l;
    /* renamed from: m */
    private int f10700m;
    /* renamed from: n */
    private int f10701n;
    /* renamed from: o */
    private int f10702o;
    /* renamed from: p */
    private int f10703p;
    /* renamed from: q */
    private boolean f10704q;
    /* renamed from: r */
    private long f10705r;
    /* renamed from: s */
    private int f10706s;
    /* renamed from: t */
    private long f10707t;
    /* renamed from: u */
    private int f10708u;

    /* renamed from: b */
    public void mo2212b() {
    }

    public C4139m(String str) {
        this.f10688a = str;
    }

    /* renamed from: a */
    public void mo2208a() {
        this.f10694g = 0;
        this.f10699l = false;
    }

    /* renamed from: a */
    public void mo2210a(C2320g c2320g, C2318d c2318d) {
        c2318d.m6431a();
        this.f10691d = c2320g.mo2231a(c2318d.m6432b(), 1);
        this.f10693f = c2318d.m6433c();
    }

    /* renamed from: a */
    public void mo2209a(long j, boolean z) {
        this.f10698k = j;
    }

    /* renamed from: a */
    public void mo2211a(C2529l c2529l) {
        while (c2529l.m7093b() > 0) {
            int g;
            switch (this.f10694g) {
                case 0:
                    if (c2529l.m7103g() != 86) {
                        break;
                    }
                    this.f10694g = 1;
                    break;
                case 1:
                    g = c2529l.m7103g();
                    if ((g & 224) != 224) {
                        if (g == 86) {
                            break;
                        }
                        this.f10694g = 0;
                        break;
                    }
                    this.f10697j = g;
                    this.f10694g = 2;
                    break;
                case 2:
                    this.f10696i = ((this.f10697j & -225) << 8) | c2529l.m7103g();
                    if (this.f10696i > this.f10689b.f6441a.length) {
                        m13129a(this.f10696i);
                    }
                    this.f10695h = 0;
                    this.f10694g = 3;
                    break;
                case 3:
                    g = Math.min(c2529l.m7093b(), this.f10696i - this.f10695h);
                    c2529l.m7092a(this.f10690c.f6437a, this.f10695h, g);
                    this.f10695h += g;
                    if (this.f10695h != this.f10696i) {
                        break;
                    }
                    this.f10690c.m7073a(0);
                    m13130a(this.f10690c);
                    this.f10694g = 0;
                    break;
                default:
                    break;
            }
        }
    }

    /* renamed from: a */
    private void m13130a(C2528k c2528k) {
        if (!c2528k.m7084e()) {
            this.f10699l = true;
            m13132b(c2528k);
        } else if (!this.f10699l) {
            return;
        }
        if (this.f10701n != 0) {
            throw new C2571p();
        } else if (this.f10702o == 0) {
            m13131a(c2528k, m13135e(c2528k));
            if (this.f10704q) {
                c2528k.m7078b((int) this.f10705r);
            }
        } else {
            throw new C2571p();
        }
    }

    /* renamed from: b */
    private void m13132b(C2528k c2528k) {
        C2528k c2528k2 = c2528k;
        this.f10700m = c2528k2.m7081c(1);
        r0.f10701n = this.f10700m == 1 ? c2528k2.m7081c(1) : 0;
        if (r0.f10701n == 0) {
            if (r0.f10700m == 1) {
                C4139m.m13136f(c2528k);
            }
            if (c2528k.m7084e()) {
                r0.f10702o = c2528k2.m7081c(6);
                int c = c2528k2.m7081c(4);
                int c2 = c2528k2.m7081c(3);
                if (c == 0 && c2 == 0) {
                    if (r0.f10700m == 0) {
                        c = c2528k.m7077b();
                        int d = m13134d(c2528k);
                        c2528k2.m7073a(c);
                        Object obj = new byte[((d + 7) / 8)];
                        c2528k2.m7076a(obj, 0, d);
                        C2515k a = C2515k.m6988a(r0.f10693f, "audio/mp4a-latm", null, -1, -1, r0.f10708u, r0.f10706s, Collections.singletonList(obj), null, 0, r0.f10688a);
                        if (!a.equals(r0.f10692e)) {
                            r0.f10692e = a;
                            r0.f10707t = 1024000000 / ((long) a.f6393s);
                            r0.f10691d.mo2199a(a);
                        }
                    } else {
                        c2528k2.m7078b(((int) C4139m.m13136f(c2528k)) - m13134d(c2528k));
                    }
                    m13133c(c2528k);
                    r0.f10704q = c2528k.m7084e();
                    r0.f10705r = 0;
                    if (r0.f10704q) {
                        if (r0.f10700m == 1) {
                            r0.f10705r = C4139m.m13136f(c2528k);
                        } else {
                            boolean e;
                            do {
                                e = c2528k.m7084e();
                                r0.f10705r = (r0.f10705r << 8) + ((long) c2528k2.m7081c(8));
                            } while (e);
                        }
                    }
                    if (c2528k.m7084e()) {
                        c2528k2.m7078b(8);
                        return;
                    }
                    return;
                }
                throw new C2571p();
            }
            throw new C2571p();
        }
        throw new C2571p();
    }

    /* renamed from: c */
    private void m13133c(C2528k c2528k) {
        this.f10703p = c2528k.m7081c(3);
        switch (this.f10703p) {
            case 0:
                c2528k.m7078b(8);
                return;
            case 1:
                c2528k.m7078b(9);
                return;
            case 3:
            case 4:
            case 5:
                c2528k.m7078b(6);
                return;
            case 6:
            case 7:
                c2528k.m7078b(1);
                return;
            default:
                return;
        }
    }

    /* renamed from: d */
    private int m13134d(C2528k c2528k) {
        int a = c2528k.m7072a();
        Pair a2 = C2518c.m7024a(c2528k, true);
        this.f10706s = ((Integer) a2.first).intValue();
        this.f10708u = ((Integer) a2.second).intValue();
        return a - c2528k.m7072a();
    }

    /* renamed from: e */
    private int m13135e(C2528k c2528k) {
        if (this.f10703p == 0) {
            int i = 0;
            int c;
            do {
                c = c2528k.m7081c(8);
                i += c;
            } while (c == JfifUtil.MARKER_FIRST_BYTE);
            return i;
        }
        throw new C2571p();
    }

    /* renamed from: a */
    private void m13131a(C2528k c2528k, int i) {
        int b = c2528k.m7077b();
        if ((b & 7) == 0) {
            this.f10689b.m7096c(b >> 3);
        } else {
            c2528k.m7076a(this.f10689b.f6441a, 0, i * 8);
            this.f10689b.m7096c(0);
        }
        this.f10691d.mo2200a(this.f10689b, i);
        this.f10691d.mo2198a(this.f10698k, 1, i, 0, null);
        this.f10698k += this.f10707t;
    }

    /* renamed from: a */
    private void m13129a(int i) {
        this.f10689b.m7089a(i);
        this.f10690c.m7074a(this.f10689b.f6441a);
    }

    /* renamed from: f */
    private static long m13136f(C2528k c2528k) {
        return (long) c2528k.m7081c((c2528k.m7081c(2) + 1) * 8);
    }
}
