package com.google.android.exoplayer2.p137e.p142g;

import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p134a.C2216a;
import com.google.android.exoplayer2.p134a.C2216a.C2215a;
import com.google.android.exoplayer2.p137e.C2320g;
import com.google.android.exoplayer2.p137e.C2329m;
import com.google.android.exoplayer2.p137e.p142g.C2319w.C2318d;
import com.google.android.exoplayer2.p164l.C2528k;
import com.google.android.exoplayer2.p164l.C2529l;

/* compiled from: Ac3Reader */
/* renamed from: com.google.android.exoplayer2.e.g.b */
public final class C4128b implements C2305h {
    /* renamed from: a */
    private final C2528k f10585a;
    /* renamed from: b */
    private final C2529l f10586b;
    /* renamed from: c */
    private final String f10587c;
    /* renamed from: d */
    private String f10588d;
    /* renamed from: e */
    private C2329m f10589e;
    /* renamed from: f */
    private int f10590f;
    /* renamed from: g */
    private int f10591g;
    /* renamed from: h */
    private boolean f10592h;
    /* renamed from: i */
    private long f10593i;
    /* renamed from: j */
    private C2515k f10594j;
    /* renamed from: k */
    private int f10595k;
    /* renamed from: l */
    private long f10596l;

    /* renamed from: b */
    public void mo2212b() {
    }

    public C4128b() {
        this(null);
    }

    public C4128b(String str) {
        this.f10585a = new C2528k(new byte[128]);
        this.f10586b = new C2529l(this.f10585a.f6437a);
        this.f10590f = 0;
        this.f10587c = str;
    }

    /* renamed from: a */
    public void mo2208a() {
        this.f10590f = 0;
        this.f10591g = 0;
        this.f10592h = false;
    }

    /* renamed from: a */
    public void mo2210a(C2320g c2320g, C2318d c2318d) {
        c2318d.m6431a();
        this.f10588d = c2318d.m6433c();
        this.f10589e = c2320g.mo2231a(c2318d.m6432b(), 1);
    }

    /* renamed from: a */
    public void mo2209a(long j, boolean z) {
        this.f10596l = j;
    }

    /* renamed from: a */
    public void mo2211a(C2529l c2529l) {
        while (c2529l.m7093b() > 0) {
            switch (this.f10590f) {
                case 0:
                    if (!m13054b(c2529l)) {
                        break;
                    }
                    this.f10590f = 1;
                    this.f10586b.f6441a[0] = (byte) 11;
                    this.f10586b.f6441a[1] = (byte) 119;
                    this.f10591g = 2;
                    break;
                case 1:
                    if (!m13053a(c2529l, this.f10586b.f6441a, 128)) {
                        break;
                    }
                    m13055c();
                    this.f10586b.m7096c(0);
                    this.f10589e.mo2200a(this.f10586b, 128);
                    this.f10590f = 2;
                    break;
                case 2:
                    int min = Math.min(c2529l.m7093b(), this.f10595k - this.f10591g);
                    this.f10589e.mo2200a(c2529l, min);
                    this.f10591g += min;
                    if (this.f10591g != this.f10595k) {
                        break;
                    }
                    this.f10589e.mo2198a(this.f10596l, 1, this.f10595k, 0, null);
                    this.f10596l += this.f10593i;
                    this.f10590f = 0;
                    break;
                default:
                    break;
            }
        }
    }

    /* renamed from: a */
    private boolean m13053a(C2529l c2529l, byte[] bArr, int i) {
        int min = Math.min(c2529l.m7093b(), i - this.f10591g);
        c2529l.m7092a(bArr, this.f10591g, min);
        this.f10591g += min;
        return this.f10591g == i ? true : null;
    }

    /* renamed from: b */
    private boolean m13054b(C2529l c2529l) {
        while (true) {
            boolean z = false;
            if (c2529l.m7093b() <= 0) {
                return false;
            }
            if (this.f10592h) {
                int g = c2529l.m7103g();
                if (g == 119) {
                    this.f10592h = false;
                    return true;
                }
                if (g == 11) {
                    z = true;
                }
                this.f10592h = z;
            } else {
                if (c2529l.m7103g() == 11) {
                    z = true;
                }
                this.f10592h = z;
            }
        }
    }

    /* renamed from: c */
    private void m13055c() {
        this.f10585a.m7073a(0);
        C2215a a = C2216a.m6111a(this.f10585a);
        if (!(this.f10594j != null && a.f5266d == this.f10594j.f6392r && a.f5265c == this.f10594j.f6393s && a.f5263a == this.f10594j.f6380f)) {
            this.f10594j = C2515k.m6988a(this.f10588d, a.f5263a, null, -1, -1, a.f5266d, a.f5265c, null, null, 0, this.f10587c);
            this.f10589e.mo2199a(this.f10594j);
        }
        this.f10595k = a.f5267e;
        this.f10593i = (((long) a.f5268f) * 1000000) / ((long) this.f10594j.f6393s);
    }
}
