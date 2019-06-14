package com.google.android.exoplayer2;

import com.google.android.exoplayer2.p149h.C2423i.C2422b;

/* compiled from: PlaybackInfo */
/* renamed from: com.google.android.exoplayer2.q */
final class C2572q {
    /* renamed from: a */
    public final C2589y f6564a;
    /* renamed from: b */
    public final Object f6565b;
    /* renamed from: c */
    public final C2422b f6566c;
    /* renamed from: d */
    public final long f6567d;
    /* renamed from: e */
    public final long f6568e;
    /* renamed from: f */
    public volatile long f6569f;
    /* renamed from: g */
    public volatile long f6570g;

    public C2572q(C2589y c2589y, Object obj, int i, long j) {
        this(c2589y, obj, new C2422b(i), j, -9223372036854775807L);
    }

    public C2572q(C2589y c2589y, Object obj, C2422b c2422b, long j, long j2) {
        this.f6564a = c2589y;
        this.f6565b = obj;
        this.f6566c = c2422b;
        this.f6567d = j;
        this.f6568e = j2;
        this.f6569f = j;
        this.f6570g = j;
    }

    /* renamed from: a */
    public C2572q m7270a(int i, long j, long j2) {
        return m7271a(new C2422b(i), j, j2);
    }

    /* renamed from: a */
    public C2572q m7271a(C2422b c2422b, long j, long j2) {
        return new C2572q(this.f6564a, this.f6565b, c2422b, j, j2);
    }

    /* renamed from: a */
    public C2572q m7269a(int i) {
        C2572q c2572q = new C2572q(this.f6564a, this.f6565b, this.f6566c.m6656a(i), this.f6567d, this.f6568e);
        C2572q.m7268a(this, c2572q);
        return c2572q;
    }

    /* renamed from: a */
    public C2572q m7272a(C2589y c2589y, Object obj) {
        C2572q c2572q = new C2572q(c2589y, obj, this.f6566c, this.f6567d, this.f6568e);
        C2572q.m7268a(this, c2572q);
        return c2572q;
    }

    /* renamed from: a */
    private static void m7268a(C2572q c2572q, C2572q c2572q2) {
        c2572q2.f6569f = c2572q.f6569f;
        c2572q2.f6570g = c2572q.f6570g;
    }
}
