package com.google.android.exoplayer2.p137e.p142g;

import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p137e.C2320g;
import com.google.android.exoplayer2.p137e.C2325j;
import com.google.android.exoplayer2.p137e.C2329m;
import com.google.android.exoplayer2.p137e.p142g.C2319w.C2318d;
import com.google.android.exoplayer2.p164l.C2529l;

/* compiled from: MpegAudioReader */
/* renamed from: com.google.android.exoplayer2.e.g.n */
public final class C4140n implements C2305h {
    /* renamed from: a */
    private final C2529l f10709a;
    /* renamed from: b */
    private final C2325j f10710b;
    /* renamed from: c */
    private final String f10711c;
    /* renamed from: d */
    private String f10712d;
    /* renamed from: e */
    private C2329m f10713e;
    /* renamed from: f */
    private int f10714f;
    /* renamed from: g */
    private int f10715g;
    /* renamed from: h */
    private boolean f10716h;
    /* renamed from: i */
    private boolean f10717i;
    /* renamed from: j */
    private long f10718j;
    /* renamed from: k */
    private int f10719k;
    /* renamed from: l */
    private long f10720l;

    /* renamed from: b */
    public void mo2212b() {
    }

    public C4140n() {
        this(null);
    }

    public C4140n(String str) {
        this.f10714f = 0;
        this.f10709a = new C2529l(4);
        this.f10709a.f6441a[0] = (byte) -1;
        this.f10710b = new C2325j();
        this.f10711c = str;
    }

    /* renamed from: a */
    public void mo2208a() {
        this.f10714f = 0;
        this.f10715g = 0;
        this.f10717i = false;
    }

    /* renamed from: a */
    public void mo2210a(C2320g c2320g, C2318d c2318d) {
        c2318d.m6431a();
        this.f10712d = c2318d.m6433c();
        this.f10713e = c2320g.mo2231a(c2318d.m6432b(), 1);
    }

    /* renamed from: a */
    public void mo2209a(long j, boolean z) {
        this.f10720l = j;
    }

    /* renamed from: a */
    public void mo2211a(C2529l c2529l) {
        while (c2529l.m7093b() > 0) {
            switch (this.f10714f) {
                case 0:
                    m13142b(c2529l);
                    break;
                case 1:
                    m13143c(c2529l);
                    break;
                case 2:
                    m13144d(c2529l);
                    break;
                default:
                    break;
            }
        }
    }

    /* renamed from: b */
    private void m13142b(C2529l c2529l) {
        byte[] bArr = c2529l.f6441a;
        int c = c2529l.m7095c();
        for (int d = c2529l.m7097d(); d < c; d++) {
            boolean z = (bArr[d] & JfifUtil.MARKER_FIRST_BYTE) == JfifUtil.MARKER_FIRST_BYTE;
            Object obj = (this.f10717i && (bArr[d] & 224) == 224) ? 1 : null;
            this.f10717i = z;
            if (obj != null) {
                c2529l.m7096c(d + 1);
                this.f10717i = false;
                this.f10709a.f6441a[1] = bArr[d];
                this.f10715g = 2;
                this.f10714f = 1;
                return;
            }
        }
        c2529l.m7096c(c);
    }

    /* renamed from: c */
    private void m13143c(C2529l c2529l) {
        int min = Math.min(c2529l.m7093b(), 4 - this.f10715g);
        c2529l.m7092a(this.f10709a.f6441a, this.f10715g, min);
        this.f10715g += min;
        if (this.f10715g >= 4) {
            r0.f10709a.m7096c(0);
            if (C2325j.m6450a(r0.f10709a.m7111o(), r0.f10710b)) {
                r0.f10719k = r0.f10710b.f5771c;
                if (!r0.f10716h) {
                    r0.f10718j = (((long) r0.f10710b.f5775g) * 1000000) / ((long) r0.f10710b.f5772d);
                    r0.f10713e.mo2199a(C2515k.m6988a(r0.f10712d, r0.f10710b.f5770b, null, -1, 4096, r0.f10710b.f5773e, r0.f10710b.f5772d, null, null, 0, r0.f10711c));
                    r0.f10716h = true;
                }
                r0.f10709a.m7096c(0);
                r0.f10713e.mo2200a(r0.f10709a, 4);
                r0.f10714f = 2;
                return;
            }
            r0.f10715g = 0;
            r0.f10714f = 1;
        }
    }

    /* renamed from: d */
    private void m13144d(C2529l c2529l) {
        int min = Math.min(c2529l.m7093b(), this.f10719k - this.f10715g);
        this.f10713e.mo2200a(c2529l, min);
        this.f10715g += min;
        if (this.f10715g >= this.f10719k) {
            this.f10713e.mo2198a(this.f10720l, 1, this.f10719k, 0, null);
            this.f10720l += this.f10718j;
            this.f10715g = 0;
            this.f10714f = 0;
        }
    }
}
