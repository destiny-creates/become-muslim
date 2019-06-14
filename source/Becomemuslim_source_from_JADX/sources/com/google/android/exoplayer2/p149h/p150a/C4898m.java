package com.google.android.exoplayer2.p149h.p150a;

import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p137e.C2304f;
import com.google.android.exoplayer2.p137e.C2329m;
import com.google.android.exoplayer2.p137e.C4102b;
import com.google.android.exoplayer2.p163k.C2498g;
import com.google.android.exoplayer2.p163k.C2501j;
import com.google.android.exoplayer2.p164l.C2541v;

/* compiled from: SingleSampleMediaChunk */
/* renamed from: com.google.android.exoplayer2.h.a.m */
public final class C4898m extends C4854a {
    /* renamed from: j */
    private final int f14046j;
    /* renamed from: k */
    private final C2515k f14047k;
    /* renamed from: l */
    private volatile int f14048l;
    /* renamed from: m */
    private volatile boolean f14049m;
    /* renamed from: n */
    private volatile boolean f14050n;

    public C4898m(C2498g c2498g, C2501j c2501j, C2515k c2515k, int i, Object obj, long j, long j2, int i2, int i3, C2515k c2515k2) {
        super(c2498g, c2501j, c2515k, i, obj, j, j2, i2);
        this.f14046j = i3;
        this.f14047k = c2515k2;
    }

    /* renamed from: h */
    public boolean mo3423h() {
        return this.f14050n;
    }

    /* renamed from: f */
    public long mo3197f() {
        return (long) this.f14048l;
    }

    /* renamed from: a */
    public void mo2282a() {
        this.f14049m = true;
    }

    /* renamed from: b */
    public boolean mo2283b() {
        return this.f14049m;
    }

    /* renamed from: c */
    public void mo2284c() {
        try {
            long a = this.h.mo2268a(this.a.m6956a((long) this.f14048l));
            if (a != -1) {
                a += (long) this.f14048l;
            }
            C2304f c4102b = new C4102b(this.h, (long) this.f14048l, a);
            C4167b d = m17293d();
            d.m13259a(0);
            int i = 0;
            C2329m a2 = d.mo2230a(0, this.f14046j);
            a2.mo2199a(this.f14047k);
            while (i != -1) {
                this.f14048l += i;
                i = a2.mo2197a(c4102b, Integer.MAX_VALUE, true);
            }
            a2.mo2198a(this.f, 1, this.f14048l, 0, null);
            this.f14050n = true;
        } finally {
            C2541v.m7174a(this.h);
        }
    }
}
