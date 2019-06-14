package com.google.android.exoplayer2.p149h.p150a;

import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p137e.C2303e;
import com.google.android.exoplayer2.p137e.C2304f;
import com.google.android.exoplayer2.p137e.C4102b;
import com.google.android.exoplayer2.p149h.p150a.C4170d.C2370b;
import com.google.android.exoplayer2.p163k.C2498g;
import com.google.android.exoplayer2.p163k.C2501j;
import com.google.android.exoplayer2.p164l.C2516a;
import com.google.android.exoplayer2.p164l.C2541v;

/* compiled from: ContainerMediaChunk */
/* renamed from: com.google.android.exoplayer2.h.a.i */
public class C4897i extends C4854a {
    /* renamed from: j */
    private final int f14040j;
    /* renamed from: k */
    private final long f14041k;
    /* renamed from: l */
    private final C4170d f14042l;
    /* renamed from: m */
    private volatile int f14043m;
    /* renamed from: n */
    private volatile boolean f14044n;
    /* renamed from: o */
    private volatile boolean f14045o;

    public C4897i(C2498g c2498g, C2501j c2501j, C2515k c2515k, int i, Object obj, long j, long j2, int i2, int i3, long j3, C4170d c4170d) {
        super(c2498g, c2501j, c2515k, i, obj, j, j2, i2);
        this.f14040j = i3;
        this.f14041k = j3;
        this.f14042l = c4170d;
    }

    /* renamed from: g */
    public int mo3525g() {
        return this.i + this.f14040j;
    }

    /* renamed from: h */
    public boolean mo3423h() {
        return this.f14045o;
    }

    /* renamed from: f */
    public final long mo3197f() {
        return (long) this.f14043m;
    }

    /* renamed from: a */
    public final void mo2282a() {
        this.f14044n = true;
    }

    /* renamed from: b */
    public final boolean mo2283b() {
        return this.f14044n;
    }

    /* renamed from: c */
    public final void mo2284c() {
        C2501j a = this.a.m6956a((long) this.f14043m);
        C2304f c4102b;
        try {
            c4102b = new C4102b(this.h, a.f6351c, this.h.mo2268a(a));
            if (this.f14043m == 0) {
                C2370b d = m17293d();
                d.m13259a(this.f14041k);
                this.f14042l.m13271a(d);
            }
            C2303e c2303e = this.f14042l.f10817a;
            boolean z = false;
            int i = 0;
            while (i == 0 && !this.f14044n) {
                i = c2303e.mo2162a(c4102b, null);
            }
            if (i != 1) {
                z = true;
            }
            C2516a.m7019b(z);
            this.f14043m = (int) (c4102b.mo2189c() - this.a.f6351c);
            C2541v.m7174a(this.h);
            this.f14045o = true;
        } catch (Throwable th) {
            C2541v.m7174a(this.h);
        }
    }
}
