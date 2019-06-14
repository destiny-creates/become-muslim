package com.google.android.exoplayer2;

import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.facebook.internal.NativeProtocol;
import com.google.android.exoplayer2.p149h.C2439q;
import com.google.android.exoplayer2.p162j.C2485g;
import com.google.android.exoplayer2.p163k.C2492b;
import com.google.android.exoplayer2.p163k.C4241k;
import com.google.android.exoplayer2.p164l.C2532o;
import com.google.android.exoplayer2.p164l.C2541v;

/* compiled from: DefaultLoadControl */
/* renamed from: com.google.android.exoplayer2.c */
public final class C4089c implements C2567n {
    /* renamed from: a */
    private final C4241k f10338a;
    /* renamed from: b */
    private final long f10339b;
    /* renamed from: c */
    private final long f10340c;
    /* renamed from: d */
    private final long f10341d;
    /* renamed from: e */
    private final long f10342e;
    /* renamed from: f */
    private final int f10343f;
    /* renamed from: g */
    private final boolean f10344g;
    /* renamed from: h */
    private final C2532o f10345h;
    /* renamed from: i */
    private int f10346i;
    /* renamed from: j */
    private boolean f10347j;

    public C4089c() {
        this(new C4241k(true, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST));
    }

    public C4089c(C4241k c4241k) {
        this(c4241k, 15000, HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT, 5000, 2500, -1, true);
    }

    public C4089c(C4241k c4241k, int i, int i2, int i3, int i4, int i5, boolean z) {
        this(c4241k, i, i2, i3, i4, i5, z, null);
    }

    public C4089c(C4241k c4241k, int i, int i2, int i3, int i4, int i5, boolean z, C2532o c2532o) {
        this.f10338a = c4241k;
        this.f10339b = ((long) i) * 1000;
        this.f10340c = ((long) i2) * 1000;
        this.f10343f = i5;
        this.f10341d = ((long) i3) * 1000;
        this.f10342e = ((long) i4) * 1000;
        this.f10344g = z;
        this.f10345h = c2532o;
    }

    /* renamed from: a */
    public void mo2151a() {
        m12780a(false);
    }

    /* renamed from: a */
    public void mo2152a(C4256t[] c4256tArr, C2439q c2439q, C2485g c2485g) {
        this.f10346i = this.f10343f == -1 ? m12781a(c4256tArr, c2485g) : this.f10343f;
        this.f10338a.m13764a(this.f10346i);
    }

    /* renamed from: b */
    public void mo2155b() {
        m12780a(true);
    }

    /* renamed from: c */
    public void mo2156c() {
        m12780a(true);
    }

    /* renamed from: d */
    public C2492b mo2157d() {
        return this.f10338a;
    }

    /* renamed from: a */
    public boolean mo2154a(long j, boolean z) {
        long j2 = z ? this.f10342e : this.f10341d;
        if (j2 > 0 && j < j2) {
            if (this.f10344g != null || this.f10338a.m13770e() < this.f10346i) {
                return 0;
            }
        }
        return 1;
    }

    /* renamed from: a */
    public boolean mo2153a(long j) {
        boolean z = true;
        Object obj = this.f10338a.m13770e() >= this.f10346i ? 1 : null;
        boolean z2 = this.f10347j;
        if (this.f10344g) {
            if (j >= this.f10339b) {
                if (j > this.f10340c || this.f10347j == null || obj != null) {
                    z = false;
                }
            }
            this.f10347j = z;
        } else {
            if (obj == null) {
                if (j >= this.f10339b) {
                    if (j <= this.f10340c && this.f10347j != null) {
                    }
                }
                this.f10347j = z;
            }
            z = false;
            this.f10347j = z;
        }
        if (!(this.f10345h == null || this.f10347j == z2)) {
            if (this.f10347j != null) {
                this.f10345h.m7136a(0);
            } else {
                this.f10345h.m7137b(0);
            }
        }
        return this.f10347j;
    }

    /* renamed from: a */
    protected int m12781a(C4256t[] c4256tArr, C2485g c2485g) {
        int i = 0;
        for (int i2 = 0; i2 < c4256tArr.length; i2++) {
            if (c2485g.m6931a(i2) != null) {
                i += C2541v.m7189d(c4256tArr[i2].mo3177a());
            }
        }
        return i;
    }

    /* renamed from: a */
    private void m12780a(boolean z) {
        this.f10346i = 0;
        if (this.f10345h != null && this.f10347j) {
            this.f10345h.m7137b(0);
        }
        this.f10347j = false;
        if (z) {
            this.f10338a.m13769d();
        }
    }
}
