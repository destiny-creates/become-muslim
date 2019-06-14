package com.google.android.exoplayer2.p164l;

import android.os.SystemClock;
import com.google.android.exoplayer2.C2251b;
import com.google.android.exoplayer2.C2573r;

/* compiled from: StandaloneMediaClock */
/* renamed from: com.google.android.exoplayer2.l.q */
public final class C4254q implements C2523h {
    /* renamed from: a */
    private boolean f11225a;
    /* renamed from: b */
    private long f11226b;
    /* renamed from: c */
    private long f11227c;
    /* renamed from: d */
    private C2573r f11228d = C2573r.f6571a;

    /* renamed from: a */
    public void m13811a() {
        if (!this.f11225a) {
            this.f11227c = SystemClock.elapsedRealtime();
            this.f11225a = true;
        }
    }

    /* renamed from: b */
    public void m13813b() {
        if (this.f11225a) {
            m13812a(mo2324w());
            this.f11225a = false;
        }
    }

    /* renamed from: a */
    public void m13812a(long j) {
        this.f11226b = j;
        if (this.f11225a != null) {
            this.f11227c = SystemClock.elapsedRealtime();
        }
    }

    /* renamed from: w */
    public long mo2324w() {
        long j = this.f11226b;
        if (!this.f11225a) {
            return j;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f11227c;
        if (this.f11228d.f6572b == 1.0f) {
            return j + C2251b.m6222b(elapsedRealtime);
        }
        return j + this.f11228d.m7273a(elapsedRealtime);
    }

    /* renamed from: a */
    public C2573r mo2323a(C2573r c2573r) {
        if (this.f11225a) {
            m13812a(mo2324w());
        }
        this.f11228d = c2573r;
        return c2573r;
    }

    /* renamed from: x */
    public C2573r mo2325x() {
        return this.f11228d;
    }
}
