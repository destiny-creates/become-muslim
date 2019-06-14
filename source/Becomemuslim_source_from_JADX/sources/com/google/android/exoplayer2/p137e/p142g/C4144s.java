package com.google.android.exoplayer2.p137e.p142g;

import com.google.android.exoplayer2.p137e.C2320g;
import com.google.android.exoplayer2.p137e.p142g.C2319w.C2318d;
import com.google.android.exoplayer2.p164l.C2529l;
import com.google.android.exoplayer2.p164l.C2537s;
import com.google.android.exoplayer2.p164l.C2541v;

/* compiled from: SectionReader */
/* renamed from: com.google.android.exoplayer2.e.g.s */
public final class C4144s implements C2319w {
    /* renamed from: a */
    private final C2313r f10741a;
    /* renamed from: b */
    private final C2529l f10742b = new C2529l(32);
    /* renamed from: c */
    private int f10743c;
    /* renamed from: d */
    private int f10744d;
    /* renamed from: e */
    private boolean f10745e;
    /* renamed from: f */
    private boolean f10746f;

    public C4144s(C2313r c2313r) {
        this.f10741a = c2313r;
    }

    /* renamed from: a */
    public void mo2217a(C2537s c2537s, C2320g c2320g, C2318d c2318d) {
        this.f10741a.mo2219a(c2537s, c2320g, c2318d);
        this.f10746f = true;
    }

    /* renamed from: a */
    public void mo2215a() {
        this.f10746f = true;
    }

    /* renamed from: a */
    public void mo2216a(C2529l c2529l, boolean z) {
        int g = z ? c2529l.m7103g() + c2529l.m7097d() : -1;
        if (this.f10746f) {
            if (z) {
                this.f10746f = false;
                c2529l.m7096c(g);
                this.f10744d = 0;
            } else {
                return;
            }
        }
        while (c2529l.m7093b() <= false) {
            boolean z2 = true;
            if (this.f10744d < true) {
                if (!this.f10744d) {
                    z = c2529l.m7103g();
                    c2529l.m7096c(c2529l.m7097d() - 1);
                    if (z) {
                        this.f10746f = true;
                        return;
                    }
                }
                z = Math.min(c2529l.m7093b(), 3 - this.f10744d);
                c2529l.m7092a(this.f10742b.f6441a, this.f10744d, z);
                this.f10744d += z;
                if (this.f10744d) {
                    this.f10742b.m7089a(3);
                    this.f10742b.m7098d(1);
                    z = this.f10742b.m7103g();
                    int g2 = this.f10742b.m7103g();
                    if ((z & 128) == 0) {
                        z2 = false;
                    }
                    this.f10745e = z2;
                    this.f10743c = (((z & 15) << 8) | g2) + true;
                    if (this.f10742b.m7099e() < this.f10743c) {
                        z = this.f10742b.f6441a;
                        this.f10742b.m7089a(Math.min(4098, Math.max(this.f10743c, z.length * 2)));
                        System.arraycopy(z, 0, this.f10742b.f6441a, 0, 3);
                    }
                }
            } else {
                z = Math.min(c2529l.m7093b(), this.f10743c - this.f10744d);
                c2529l.m7092a(this.f10742b.f6441a, this.f10744d, z);
                this.f10744d += z;
                if (this.f10744d != this.f10743c) {
                    continue;
                } else {
                    if (!this.f10745e) {
                        this.f10742b.m7089a(this.f10743c);
                    } else if (C2541v.m7166a(this.f10742b.f6441a, 0, this.f10743c, -1)) {
                        this.f10746f = true;
                        return;
                    } else {
                        this.f10742b.m7089a(this.f10743c - 4);
                    }
                    this.f10741a.mo2218a(this.f10742b);
                    this.f10744d = 0;
                }
            }
        }
    }
}
