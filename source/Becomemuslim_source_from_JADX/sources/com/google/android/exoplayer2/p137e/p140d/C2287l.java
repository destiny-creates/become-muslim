package com.google.android.exoplayer2.p137e.p140d;

import com.google.android.exoplayer2.p137e.C2304f;
import com.google.android.exoplayer2.p164l.C2529l;

/* compiled from: TrackFragment */
/* renamed from: com.google.android.exoplayer2.e.d.l */
final class C2287l {
    /* renamed from: a */
    public C2274c f5589a;
    /* renamed from: b */
    public long f5590b;
    /* renamed from: c */
    public long f5591c;
    /* renamed from: d */
    public long f5592d;
    /* renamed from: e */
    public int f5593e;
    /* renamed from: f */
    public int f5594f;
    /* renamed from: g */
    public long[] f5595g;
    /* renamed from: h */
    public int[] f5596h;
    /* renamed from: i */
    public int[] f5597i;
    /* renamed from: j */
    public int[] f5598j;
    /* renamed from: k */
    public long[] f5599k;
    /* renamed from: l */
    public boolean[] f5600l;
    /* renamed from: m */
    public boolean f5601m;
    /* renamed from: n */
    public boolean[] f5602n;
    /* renamed from: o */
    public C2286k f5603o;
    /* renamed from: p */
    public int f5604p;
    /* renamed from: q */
    public C2529l f5605q;
    /* renamed from: r */
    public boolean f5606r;
    /* renamed from: s */
    public long f5607s;

    C2287l() {
    }

    /* renamed from: a */
    public void m6325a() {
        this.f5593e = 0;
        this.f5607s = 0;
        this.f5601m = false;
        this.f5606r = false;
        this.f5603o = null;
    }

    /* renamed from: a */
    public void m6327a(int i, int i2) {
        this.f5593e = i;
        this.f5594f = i2;
        if (this.f5596h == null || this.f5596h.length < i) {
            this.f5595g = new long[i];
            this.f5596h = new int[i];
        }
        if (this.f5597i == 0 || this.f5597i.length < i2) {
            i2 = (i2 * 125) / 100;
            this.f5597i = new int[i2];
            this.f5598j = new int[i2];
            this.f5599k = new long[i2];
            this.f5600l = new boolean[i2];
            this.f5602n = new boolean[i2];
        }
    }

    /* renamed from: a */
    public void m6326a(int i) {
        if (this.f5605q == null || this.f5605q.m7095c() < i) {
            this.f5605q = new C2529l(i);
        }
        this.f5604p = i;
        this.f5601m = true;
        this.f5606r = true;
    }

    /* renamed from: a */
    public void m6328a(C2304f c2304f) {
        c2304f.mo2187b(this.f5605q.f6441a, 0, this.f5604p);
        this.f5605q.m7096c(0);
        this.f5606r = false;
    }

    /* renamed from: a */
    public void m6329a(C2529l c2529l) {
        c2529l.m7092a(this.f5605q.f6441a, 0, this.f5604p);
        this.f5605q.m7096c(0);
        this.f5606r = false;
    }

    /* renamed from: b */
    public long m6330b(int i) {
        return this.f5599k[i] + ((long) this.f5598j[i]);
    }
}
