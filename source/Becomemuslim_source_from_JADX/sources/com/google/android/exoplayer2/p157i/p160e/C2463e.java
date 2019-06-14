package com.google.android.exoplayer2.p157i.p160e;

import android.text.Layout.Alignment;
import com.google.android.exoplayer2.p164l.C2516a;

/* compiled from: TtmlStyle */
/* renamed from: com.google.android.exoplayer2.i.e.e */
final class C2463e {
    /* renamed from: a */
    private String f6239a;
    /* renamed from: b */
    private int f6240b;
    /* renamed from: c */
    private boolean f6241c;
    /* renamed from: d */
    private int f6242d;
    /* renamed from: e */
    private boolean f6243e;
    /* renamed from: f */
    private int f6244f = -1;
    /* renamed from: g */
    private int f6245g = -1;
    /* renamed from: h */
    private int f6246h = -1;
    /* renamed from: i */
    private int f6247i = -1;
    /* renamed from: j */
    private int f6248j = -1;
    /* renamed from: k */
    private float f6249k;
    /* renamed from: l */
    private String f6250l;
    /* renamed from: m */
    private C2463e f6251m;
    /* renamed from: n */
    private Alignment f6252n;

    /* renamed from: a */
    public int m6809a() {
        if (this.f6246h == -1 && this.f6247i == -1) {
            return -1;
        }
        int i = 0;
        int i2 = this.f6246h == 1 ? 1 : 0;
        if (this.f6247i == 1) {
            i = 2;
        }
        return i2 | i;
    }

    /* renamed from: b */
    public boolean m6819b() {
        return this.f6244f == 1;
    }

    /* renamed from: a */
    public C2463e m6815a(boolean z) {
        C2516a.m7019b(this.f6251m == null);
        this.f6244f = z;
        return this;
    }

    /* renamed from: c */
    public boolean m6822c() {
        return this.f6245g == 1;
    }

    /* renamed from: b */
    public C2463e m6818b(boolean z) {
        C2516a.m7019b(this.f6251m == null);
        this.f6245g = z;
        return this;
    }

    /* renamed from: c */
    public C2463e m6821c(boolean z) {
        C2516a.m7019b(this.f6251m == null);
        this.f6246h = z;
        return this;
    }

    /* renamed from: d */
    public C2463e m6823d(boolean z) {
        C2516a.m7019b(this.f6251m == null);
        this.f6247i = z;
        return this;
    }

    /* renamed from: d */
    public String m6824d() {
        return this.f6239a;
    }

    /* renamed from: a */
    public C2463e m6814a(String str) {
        C2516a.m7019b(this.f6251m == null);
        this.f6239a = str;
        return this;
    }

    /* renamed from: e */
    public int m6825e() {
        if (this.f6241c) {
            return this.f6240b;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    /* renamed from: a */
    public C2463e m6811a(int i) {
        C2516a.m7019b(this.f6251m == null);
        this.f6240b = i;
        this.f6241c = true;
        return this;
    }

    /* renamed from: f */
    public boolean m6826f() {
        return this.f6241c;
    }

    /* renamed from: g */
    public int m6827g() {
        if (this.f6243e) {
            return this.f6242d;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    /* renamed from: b */
    public C2463e m6816b(int i) {
        this.f6242d = i;
        this.f6243e = true;
        return this;
    }

    /* renamed from: h */
    public boolean m6828h() {
        return this.f6243e;
    }

    /* renamed from: a */
    public C2463e m6813a(C2463e c2463e) {
        return m6808a(c2463e, true);
    }

    /* renamed from: a */
    private C2463e m6808a(C2463e c2463e, boolean z) {
        if (c2463e != null) {
            if (!this.f6241c && c2463e.f6241c) {
                m6811a(c2463e.f6240b);
            }
            if (this.f6246h == -1) {
                this.f6246h = c2463e.f6246h;
            }
            if (this.f6247i == -1) {
                this.f6247i = c2463e.f6247i;
            }
            if (this.f6239a == null) {
                this.f6239a = c2463e.f6239a;
            }
            if (this.f6244f == -1) {
                this.f6244f = c2463e.f6244f;
            }
            if (this.f6245g == -1) {
                this.f6245g = c2463e.f6245g;
            }
            if (this.f6252n == null) {
                this.f6252n = c2463e.f6252n;
            }
            if (this.f6248j == -1) {
                this.f6248j = c2463e.f6248j;
                this.f6249k = c2463e.f6249k;
            }
            if (z && !this.f6243e && c2463e.f6243e) {
                m6816b(c2463e.f6242d);
            }
        }
        return this;
    }

    /* renamed from: b */
    public C2463e m6817b(String str) {
        this.f6250l = str;
        return this;
    }

    /* renamed from: i */
    public String m6829i() {
        return this.f6250l;
    }

    /* renamed from: j */
    public Alignment m6830j() {
        return this.f6252n;
    }

    /* renamed from: a */
    public C2463e m6812a(Alignment alignment) {
        this.f6252n = alignment;
        return this;
    }

    /* renamed from: a */
    public C2463e m6810a(float f) {
        this.f6249k = f;
        return this;
    }

    /* renamed from: c */
    public C2463e m6820c(int i) {
        this.f6248j = i;
        return this;
    }

    /* renamed from: k */
    public int m6831k() {
        return this.f6248j;
    }

    /* renamed from: l */
    public float m6832l() {
        return this.f6249k;
    }
}
