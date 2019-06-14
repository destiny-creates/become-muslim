package com.google.android.exoplayer2.p137e.p142g;

import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p137e.C2320g;
import com.google.android.exoplayer2.p137e.C2329m;
import com.google.android.exoplayer2.p137e.p142g.C2319w.C2315a;
import com.google.android.exoplayer2.p137e.p142g.C2319w.C2318d;
import com.google.android.exoplayer2.p164l.C2529l;
import java.util.Collections;
import java.util.List;

/* compiled from: DvbSubtitleReader */
/* renamed from: com.google.android.exoplayer2.e.g.g */
public final class C4134g implements C2305h {
    /* renamed from: a */
    private final List<C2315a> f10634a;
    /* renamed from: b */
    private final C2329m[] f10635b;
    /* renamed from: c */
    private boolean f10636c;
    /* renamed from: d */
    private int f10637d;
    /* renamed from: e */
    private int f10638e;
    /* renamed from: f */
    private long f10639f;

    public C4134g(List<C2315a> list) {
        this.f10634a = list;
        this.f10635b = new C2329m[list.size()];
    }

    /* renamed from: a */
    public void mo2208a() {
        this.f10636c = false;
    }

    /* renamed from: a */
    public void mo2210a(C2320g c2320g, C2318d c2318d) {
        for (int i = 0; i < this.f10635b.length; i++) {
            C2315a c2315a = (C2315a) this.f10634a.get(i);
            c2318d.m6431a();
            C2329m a = c2320g.mo2231a(c2318d.m6432b(), 3);
            a.mo2199a(C2515k.m6993a(c2318d.m6433c(), "application/dvbsubs", null, -1, Collections.singletonList(c2315a.f5746c), c2315a.f5744a, null));
            this.f10635b[i] = a;
        }
    }

    /* renamed from: a */
    public void mo2209a(long j, boolean z) {
        if (z) {
            this.f10636c = true;
            this.f10639f = j;
            this.f10638e = 0;
            this.f10637d = 2;
        }
    }

    /* renamed from: b */
    public void mo2212b() {
        if (this.f10636c) {
            for (C2329m a : this.f10635b) {
                a.mo2198a(this.f10639f, 1, this.f10638e, 0, null);
            }
            this.f10636c = false;
        }
    }

    /* renamed from: a */
    public void mo2211a(C2529l c2529l) {
        if (this.f10636c && (this.f10637d != 2 || m13093a(c2529l, 32))) {
            int i = 0;
            if (this.f10637d != 1 || m13093a(c2529l, 0)) {
                int d = c2529l.m7097d();
                int b = c2529l.m7093b();
                C2329m[] c2329mArr = this.f10635b;
                int length = c2329mArr.length;
                while (i < length) {
                    C2329m c2329m = c2329mArr[i];
                    c2529l.m7096c(d);
                    c2329m.mo2200a(c2529l, b);
                    i++;
                }
                this.f10638e += b;
            }
        }
    }

    /* renamed from: a */
    private boolean m13093a(C2529l c2529l, int i) {
        if (c2529l.m7093b() == 0) {
            return false;
        }
        if (c2529l.m7103g() != i) {
            this.f10636c = false;
        }
        this.f10637d--;
        return this.f10636c;
    }
}
