package com.google.android.exoplayer2.p137e.p142g;

import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p134a.C2241i;
import com.google.android.exoplayer2.p137e.C2320g;
import com.google.android.exoplayer2.p137e.C2329m;
import com.google.android.exoplayer2.p137e.p142g.C2319w.C2318d;
import com.google.android.exoplayer2.p164l.C2529l;

/* compiled from: DtsReader */
/* renamed from: com.google.android.exoplayer2.e.g.f */
public final class C4133f implements C2305h {
    /* renamed from: a */
    private final C2529l f10623a = new C2529l(new byte[15]);
    /* renamed from: b */
    private final String f10624b;
    /* renamed from: c */
    private String f10625c;
    /* renamed from: d */
    private C2329m f10626d;
    /* renamed from: e */
    private int f10627e;
    /* renamed from: f */
    private int f10628f;
    /* renamed from: g */
    private int f10629g;
    /* renamed from: h */
    private long f10630h;
    /* renamed from: i */
    private C2515k f10631i;
    /* renamed from: j */
    private int f10632j;
    /* renamed from: k */
    private long f10633k;

    /* renamed from: b */
    public void mo2212b() {
    }

    public C4133f(String str) {
        this.f10623a.f6441a[0] = Byte.MAX_VALUE;
        this.f10623a.f6441a[1] = (byte) -2;
        this.f10623a.f6441a[2] = Byte.MIN_VALUE;
        this.f10623a.f6441a[3] = (byte) 1;
        this.f10627e = 0;
        this.f10624b = str;
    }

    /* renamed from: a */
    public void mo2208a() {
        this.f10627e = 0;
        this.f10628f = 0;
        this.f10629g = 0;
    }

    /* renamed from: a */
    public void mo2210a(C2320g c2320g, C2318d c2318d) {
        c2318d.m6431a();
        this.f10625c = c2318d.m6433c();
        this.f10626d = c2320g.mo2231a(c2318d.m6432b(), 1);
    }

    /* renamed from: a */
    public void mo2209a(long j, boolean z) {
        this.f10633k = j;
    }

    /* renamed from: a */
    public void mo2211a(C2529l c2529l) {
        while (c2529l.m7093b() > 0) {
            switch (this.f10627e) {
                case 0:
                    if (!m13086b(c2529l)) {
                        break;
                    }
                    this.f10628f = 4;
                    this.f10627e = 1;
                    break;
                case 1:
                    if (!m13085a(c2529l, this.f10623a.f6441a, 15)) {
                        break;
                    }
                    m13087c();
                    this.f10623a.m7096c(0);
                    this.f10626d.mo2200a(this.f10623a, 15);
                    this.f10627e = 2;
                    break;
                case 2:
                    int min = Math.min(c2529l.m7093b(), this.f10632j - this.f10628f);
                    this.f10626d.mo2200a(c2529l, min);
                    this.f10628f += min;
                    if (this.f10628f != this.f10632j) {
                        break;
                    }
                    this.f10626d.mo2198a(this.f10633k, 1, this.f10632j, 0, null);
                    this.f10633k += this.f10630h;
                    this.f10627e = 0;
                    break;
                default:
                    break;
            }
        }
    }

    /* renamed from: a */
    private boolean m13085a(C2529l c2529l, byte[] bArr, int i) {
        int min = Math.min(c2529l.m7093b(), i - this.f10628f);
        c2529l.m7092a(bArr, this.f10628f, min);
        this.f10628f += min;
        return this.f10628f == i ? true : null;
    }

    /* renamed from: b */
    private boolean m13086b(C2529l c2529l) {
        while (c2529l.m7093b() > 0) {
            this.f10629g <<= 8;
            this.f10629g |= c2529l.m7103g();
            if (this.f10629g == 2147385345) {
                this.f10629g = 0;
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    private void m13087c() {
        byte[] bArr = this.f10623a.f6441a;
        if (this.f10631i == null) {
            this.f10631i = C2241i.m6179a(bArr, this.f10625c, this.f10624b, null);
            this.f10626d.mo2199a(this.f10631i);
        }
        this.f10632j = C2241i.m6180b(bArr);
        this.f10630h = (long) ((int) ((((long) C2241i.m6178a(bArr)) * 1000000) / ((long) this.f10631i.f6393s)));
    }
}
