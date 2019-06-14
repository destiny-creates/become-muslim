package com.google.android.exoplayer2.p137e.p197f;

import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.C2571p;
import com.google.android.exoplayer2.p137e.C2303e;
import com.google.android.exoplayer2.p137e.C2304f;
import com.google.android.exoplayer2.p137e.C2320g;
import com.google.android.exoplayer2.p137e.C2326k;
import com.google.android.exoplayer2.p137e.C2327l.C4154a;
import com.google.android.exoplayer2.p137e.C2329m;
import com.google.android.exoplayer2.p164l.C2529l;
import com.google.android.exoplayer2.p164l.C2541v;
import java.io.IOException;

/* compiled from: RawCcExtractor */
/* renamed from: com.google.android.exoplayer2.e.f.a */
public final class C4125a implements C2303e {
    /* renamed from: a */
    private static final int f10570a = C2541v.m7193g("RCC\u0001");
    /* renamed from: b */
    private final C2515k f10571b;
    /* renamed from: c */
    private final C2529l f10572c = new C2529l(9);
    /* renamed from: d */
    private C2329m f10573d;
    /* renamed from: e */
    private int f10574e = null;
    /* renamed from: f */
    private int f10575f;
    /* renamed from: g */
    private long f10576g;
    /* renamed from: h */
    private int f10577h;
    /* renamed from: i */
    private int f10578i;

    /* renamed from: c */
    public void mo2166c() {
    }

    public C4125a(C2515k c2515k) {
        this.f10571b = c2515k;
    }

    /* renamed from: a */
    public void mo2164a(C2320g c2320g) {
        c2320g.mo2233a(new C4154a(-9223372036854775807L));
        this.f10573d = c2320g.mo2231a(0, 3);
        c2320g.mo2232a();
        this.f10573d.mo2199a(this.f10571b);
    }

    /* renamed from: a */
    public boolean mo2165a(C2304f c2304f) {
        this.f10572c.m7088a();
        c2304f.mo2191c(this.f10572c.f6441a, 0, 8);
        if (this.f10572c.m7111o() == f10570a) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public int mo2162a(C2304f c2304f, C2326k c2326k) {
        while (true) {
            switch (this.f10574e) {
                case null:
                    if (m13039b(c2304f) != null) {
                        this.f10574e = 1;
                        break;
                    }
                    return -1;
                case 1:
                    if (m13040c(c2304f) != null) {
                        this.f10574e = 2;
                        break;
                    }
                    this.f10574e = 0;
                    return -1;
                case 2:
                    m13041d(c2304f);
                    this.f10574e = 1;
                    return 0;
                default:
                    throw new IllegalStateException();
            }
        }
    }

    /* renamed from: a */
    public void mo2163a(long j, long j2) {
        this.f10574e = 0;
    }

    /* renamed from: b */
    private boolean m13039b(C2304f c2304f) {
        this.f10572c.m7088a();
        if (c2304f.mo2184a(this.f10572c.f6441a, 0, 8, true) == null) {
            return false;
        }
        if (this.f10572c.m7111o() == f10570a) {
            this.f10575f = this.f10572c.m7103g();
            return true;
        }
        throw new IOException("Input not RawCC");
    }

    /* renamed from: c */
    private boolean m13040c(C2304f c2304f) {
        this.f10572c.m7088a();
        if (this.f10575f == 0) {
            if (c2304f.mo2184a(this.f10572c.f6441a, 0, 5, true) == null) {
                return false;
            }
            this.f10576g = (this.f10572c.m7109m() * 1000) / 45;
        } else if (this.f10575f != 1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unsupported version number: ");
            stringBuilder.append(this.f10575f);
            throw new C2571p(stringBuilder.toString());
        } else if (c2304f.mo2184a(this.f10572c.f6441a, 0, 9, true) == null) {
            return false;
        } else {
            this.f10576g = this.f10572c.m7113q();
        }
        this.f10577h = this.f10572c.m7103g();
        this.f10578i = 0;
        return true;
    }

    /* renamed from: d */
    private void m13041d(C2304f c2304f) {
        while (this.f10577h > 0) {
            this.f10572c.m7088a();
            c2304f.mo2187b(this.f10572c.f6441a, 0, 3);
            this.f10573d.mo2200a(this.f10572c, 3);
            this.f10578i += 3;
            this.f10577h--;
        }
        if (this.f10578i > null) {
            this.f10573d.mo2198a(this.f10576g, 1, this.f10578i, 0, null);
        }
    }
}
