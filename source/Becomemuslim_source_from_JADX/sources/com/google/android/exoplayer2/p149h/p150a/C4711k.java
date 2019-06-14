package com.google.android.exoplayer2.p149h.p150a;

import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p137e.C2303e;
import com.google.android.exoplayer2.p137e.C2304f;
import com.google.android.exoplayer2.p137e.C4102b;
import com.google.android.exoplayer2.p163k.C2498g;
import com.google.android.exoplayer2.p163k.C2501j;
import com.google.android.exoplayer2.p164l.C2516a;
import com.google.android.exoplayer2.p164l.C2541v;

/* compiled from: InitializationChunk */
/* renamed from: com.google.android.exoplayer2.h.a.k */
public final class C4711k extends C4168c {
    /* renamed from: i */
    private final C4170d f12732i;
    /* renamed from: j */
    private volatile int f12733j;
    /* renamed from: k */
    private volatile boolean f12734k;

    public C4711k(C2498g c2498g, C2501j c2501j, C2515k c2515k, int i, Object obj, C4170d c4170d) {
        super(c2498g, c2501j, 2, c2515k, i, obj, -9223372036854775807L, -9223372036854775807L);
        this.f12732i = c4170d;
    }

    /* renamed from: f */
    public long mo3197f() {
        return (long) this.f12733j;
    }

    /* renamed from: a */
    public void mo2282a() {
        this.f12734k = true;
    }

    /* renamed from: b */
    public boolean mo2283b() {
        return this.f12734k;
    }

    /* renamed from: c */
    public void mo2284c() {
        C2501j a = this.a.m6956a((long) this.f12733j);
        C2304f c4102b;
        try {
            c4102b = new C4102b(this.h, a.f6351c, this.h.mo2268a(a));
            if (this.f12733j == 0) {
                this.f12732i.m13271a(null);
            }
            C2303e c2303e = this.f12732i.f10817a;
            int i = 0;
            while (i == 0 && !this.f12734k) {
                i = c2303e.mo2162a(c4102b, null);
            }
            boolean z = true;
            if (i == 1) {
                z = false;
            }
            C2516a.m7019b(z);
            this.f12733j = (int) (c4102b.mo2189c() - this.a.f6351c);
            C2541v.m7174a(this.h);
        } catch (Throwable th) {
            C2541v.m7174a(this.h);
        }
    }
}
