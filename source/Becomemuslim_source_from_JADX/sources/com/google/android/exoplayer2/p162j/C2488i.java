package com.google.android.exoplayer2.p162j;

import com.google.android.exoplayer2.C2583v;
import com.google.android.exoplayer2.p149h.C2439q;
import com.google.android.exoplayer2.p164l.C2541v;

/* compiled from: TrackSelectorResult */
/* renamed from: com.google.android.exoplayer2.j.i */
public final class C2488i {
    /* renamed from: a */
    public final C2439q f6333a;
    /* renamed from: b */
    public final boolean[] f6334b;
    /* renamed from: c */
    public final C2485g f6335c;
    /* renamed from: d */
    public final Object f6336d;
    /* renamed from: e */
    public final C2583v[] f6337e;

    public C2488i(C2439q c2439q, boolean[] zArr, C2485g c2485g, Object obj, C2583v[] c2583vArr) {
        this.f6333a = c2439q;
        this.f6334b = zArr;
        this.f6335c = c2485g;
        this.f6336d = obj;
        this.f6337e = c2583vArr;
    }

    /* renamed from: a */
    public boolean m6936a(C2488i c2488i) {
        if (c2488i == null) {
            return false;
        }
        for (int i = 0; i < this.f6335c.f6329a; i++) {
            if (!m6937a(c2488i, i)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public boolean m6937a(C2488i c2488i, int i) {
        boolean z = false;
        if (c2488i == null) {
            return false;
        }
        if (this.f6334b[i] == c2488i.f6334b[i] && C2541v.m7179a(this.f6335c.m6931a(i), c2488i.f6335c.m6931a(i)) && C2541v.m7179a(this.f6337e[i], c2488i.f6337e[i]) != null) {
            z = true;
        }
        return z;
    }
}
