package com.google.android.exoplayer2.p149h.p155d;

import android.net.Uri;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p137e.p140d.C2285j;
import com.google.android.exoplayer2.p137e.p140d.C2286k;
import com.google.android.exoplayer2.p137e.p140d.C4112e;
import com.google.android.exoplayer2.p149h.C2393b;
import com.google.android.exoplayer2.p149h.p150a.C2371e;
import com.google.android.exoplayer2.p149h.p150a.C2373h;
import com.google.android.exoplayer2.p149h.p150a.C4168c;
import com.google.android.exoplayer2.p149h.p150a.C4170d;
import com.google.android.exoplayer2.p149h.p150a.C4712l;
import com.google.android.exoplayer2.p149h.p150a.C4897i;
import com.google.android.exoplayer2.p149h.p155d.C4210b.C2414a;
import com.google.android.exoplayer2.p149h.p155d.p156a.C2412a;
import com.google.android.exoplayer2.p149h.p155d.p156a.C2412a.C2411b;
import com.google.android.exoplayer2.p162j.C2484f;
import com.google.android.exoplayer2.p163k.C2498g;
import com.google.android.exoplayer2.p163k.C2498g.C2497a;
import com.google.android.exoplayer2.p163k.C2501j;
import com.google.android.exoplayer2.p163k.C2512t;
import java.io.IOException;

/* compiled from: DefaultSsChunkSource */
/* renamed from: com.google.android.exoplayer2.h.d.a */
public class C4720a implements C4210b {
    /* renamed from: a */
    private final C2512t f12788a;
    /* renamed from: b */
    private final int f12789b;
    /* renamed from: c */
    private final C2484f f12790c;
    /* renamed from: d */
    private final C4170d[] f12791d;
    /* renamed from: e */
    private final C2498g f12792e;
    /* renamed from: f */
    private C2412a f12793f;
    /* renamed from: g */
    private int f12794g;
    /* renamed from: h */
    private IOException f12795h;

    /* compiled from: DefaultSsChunkSource */
    /* renamed from: com.google.android.exoplayer2.h.d.a$a */
    public static final class C4203a implements C2414a {
        /* renamed from: a */
        private final C2497a f11028a;

        public C4203a(C2497a c2497a) {
            this.f11028a = c2497a;
        }

        /* renamed from: a */
        public C4210b mo2275a(C2512t c2512t, C2412a c2412a, int i, C2484f c2484f, C2286k[] c2286kArr) {
            return new C4720a(c2512t, c2412a, i, c2484f, this.f11028a.createDataSource(), c2286kArr);
        }
    }

    /* renamed from: a */
    public void mo3211a(C4168c c4168c) {
    }

    public C4720a(C2512t c2512t, C2412a c2412a, int i, C2484f c2484f, C2498g c2498g, C2286k[] c2286kArr) {
        C2412a c2412a2 = c2412a;
        int i2 = i;
        C2484f c2484f2 = c2484f;
        this.f12788a = c2512t;
        this.f12793f = c2412a2;
        this.f12789b = i2;
        this.f12790c = c2484f2;
        this.f12792e = c2498g;
        C2411b c2411b = c2412a2.f5964f[i2];
        this.f12791d = new C4170d[c2484f.mo2306g()];
        int i3 = 0;
        while (i3 < r0.f12791d.length) {
            int b = c2484f2.mo2301b(i3);
            C2515k c2515k = c2411b.f5952j[b];
            int i4 = i3;
            C2285j c2285j = r7;
            C2285j c2285j2 = new C2285j(b, c2411b.f5943a, c2411b.f5945c, -9223372036854775807L, c2412a2.f5965g, c2515k, 0, c2286kArr, c2411b.f5943a == 2 ? 4 : 0, null, null);
            r0.f12791d[i4] = new C4170d(new C4112e(3, null, c2285j, null), c2411b.f5943a, c2515k);
            i3 = i4 + 1;
        }
    }

    /* renamed from: a */
    public void mo3224a(C2412a c2412a) {
        C2411b c2411b = this.f12793f.f5964f[this.f12789b];
        int i = c2411b.f5953k;
        C2411b c2411b2 = c2412a.f5964f[this.f12789b];
        if (i != 0) {
            if (c2411b2.f5953k != 0) {
                int i2 = i - 1;
                long a = c2411b.m6632a(i2) + c2411b.m6634b(i2);
                long a2 = c2411b2.m6632a(0);
                if (a <= a2) {
                    this.f12794g += i;
                } else {
                    this.f12794g += c2411b.m6631a(a2);
                }
                this.f12793f = c2412a;
            }
        }
        this.f12794g += i;
        this.f12793f = c2412a;
    }

    /* renamed from: a */
    public void mo3210a() {
        if (this.f12795h == null) {
            this.f12788a.mo2322d();
            return;
        }
        throw this.f12795h;
    }

    /* renamed from: a */
    public final void mo3212a(C4712l c4712l, long j, long j2, C2371e c2371e) {
        long j3 = j;
        long j4 = j2;
        C2371e c2371e2 = c2371e;
        if (this.f12795h == null) {
            C2411b c2411b = r0.f12793f.f5964f[r0.f12789b];
            if (c2411b.f5953k == 0) {
                c2371e2.f5829b = r0.f12793f.f5962d ^ 1;
                return;
            }
            int a;
            if (c4712l == null) {
                a = c2411b.m6631a(j4);
            } else {
                a = c4712l.mo3525g() - r0.f12794g;
                if (a < 0) {
                    r0.f12795h = new C2393b();
                    return;
                }
            }
            int i = a;
            if (i >= c2411b.f5953k) {
                c2371e2.f5829b = r0.f12793f.f5962d ^ 1;
                return;
            }
            r0.f12790c.mo3216a(j, j4 - j3, m16145a(j3));
            long a2 = c2411b.m6632a(i);
            long b = a2 + c2411b.m6634b(i);
            int i2 = i + r0.f12794g;
            a = r0.f12790c.mo3215a();
            C4170d c4170d = r0.f12791d[a];
            c2371e2.f5828a = C4720a.m16146a(r0.f12790c.mo2307h(), r0.f12792e, c2411b.m6633a(r0.f12790c.mo2301b(a), i), null, i2, a2, b, r0.f12790c.mo3217b(), r0.f12790c.mo3218c(), c4170d);
        }
    }

    /* renamed from: a */
    public boolean mo3214a(C4168c c4168c, boolean z, Exception exception) {
        return (!z || C2373h.m6564a(this.f12790c, this.f12790c.mo2298a(c4168c.f10806c), exception) == null) ? null : true;
    }

    /* renamed from: a */
    private static C4712l m16146a(C2515k c2515k, C2498g c2498g, Uri uri, String str, int i, long j, long j2, int i2, Object obj, C4170d c4170d) {
        return new C4897i(c2498g, new C2501j(uri, 0, -1, str), c2515k, i2, obj, j, j2, i, 1, j, c4170d);
    }

    /* renamed from: a */
    private long m16145a(long j) {
        if (!this.f12793f.f5962d) {
            return -9223372036854775807L;
        }
        C2411b c2411b = this.f12793f.f5964f[this.f12789b];
        int i = c2411b.f5953k - 1;
        return (c2411b.m6632a(i) + c2411b.m6634b(i)) - j;
    }
}
