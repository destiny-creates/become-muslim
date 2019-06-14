package com.google.android.exoplayer2.p162j;

import android.os.SystemClock;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p149h.C2438p;
import com.google.android.exoplayer2.p162j.C2484f.C2483a;
import com.google.android.exoplayer2.p163k.C2495d;

/* compiled from: AdaptiveTrackSelection */
/* renamed from: com.google.android.exoplayer2.j.a */
public class C4729a extends C4236b {
    /* renamed from: d */
    private final C2495d f12909d;
    /* renamed from: e */
    private final int f12910e;
    /* renamed from: f */
    private final long f12911f;
    /* renamed from: g */
    private final long f12912g;
    /* renamed from: h */
    private final long f12913h;
    /* renamed from: i */
    private final float f12914i;
    /* renamed from: j */
    private final float f12915j;
    /* renamed from: k */
    private int f12916k = m16331a(0);
    /* renamed from: l */
    private int f12917l = 1;

    /* compiled from: AdaptiveTrackSelection */
    /* renamed from: com.google.android.exoplayer2.j.a$a */
    public static final class C4235a implements C2483a {
        /* renamed from: a */
        private final C2495d f11143a;
        /* renamed from: b */
        private final int f11144b;
        /* renamed from: c */
        private final int f11145c;
        /* renamed from: d */
        private final int f11146d;
        /* renamed from: e */
        private final int f11147e;
        /* renamed from: f */
        private final float f11148f;
        /* renamed from: g */
        private final float f11149g;

        /* renamed from: b */
        public /* synthetic */ C2484f mo2297b(C2438p c2438p, int[] iArr) {
            return m13727a(c2438p, iArr);
        }

        public C4235a(C2495d c2495d) {
            this(c2495d, 800000, 10000, 25000, 25000, 0.75f, 0.75f);
        }

        public C4235a(C2495d c2495d, int i, int i2, int i3, int i4, float f, float f2) {
            this.f11143a = c2495d;
            this.f11144b = i;
            this.f11145c = i2;
            this.f11146d = i3;
            this.f11147e = i4;
            this.f11148f = f;
            this.f11149g = f2;
        }

        /* renamed from: a */
        public C4729a m13727a(C2438p c2438p, int... iArr) {
            return new C4729a(c2438p, iArr, this.f11143a, this.f11144b, (long) this.f11145c, (long) this.f11146d, (long) this.f11147e, this.f11148f, this.f11149g);
        }
    }

    /* renamed from: c */
    public Object mo3218c() {
        return null;
    }

    public C4729a(C2438p c2438p, int[] iArr, C2495d c2495d, int i, long j, long j2, long j3, float f, float f2) {
        super(c2438p, iArr);
        this.f12909d = c2495d;
        this.f12910e = i;
        this.f12911f = j * 1000;
        this.f12912g = j2 * 1000;
        this.f12913h = j3 * 1000;
        this.f12914i = f;
        this.f12915j = f2;
    }

    /* renamed from: a */
    public void mo3216a(long j, long j2, long j3) {
        j = SystemClock.elapsedRealtime();
        int i = this.f12916k;
        this.f12916k = m16331a(j);
        if (this.f12916k != i) {
            if (m13733b(i, j) == null) {
                j = mo2299a(i);
                C2515k a = mo2299a(this.f12916k);
                if (a.f6376b > j.f6376b && j2 < m16332b(j3)) {
                    this.f12916k = i;
                } else if (a.f6376b < j.f6376b && j2 >= this.f12912g) {
                    this.f12916k = i;
                }
            }
            if (this.f12916k != i) {
                this.f12917l = 3;
            }
        }
    }

    /* renamed from: a */
    public int mo3215a() {
        return this.f12916k;
    }

    /* renamed from: b */
    public int mo3217b() {
        return this.f12917l;
    }

    /* renamed from: a */
    private int m16331a(long j) {
        long a = this.f12909d.mo2316a();
        a = a == -1 ? (long) this.f12910e : (long) (((float) a) * this.f12914i);
        int i = 0;
        int i2 = 0;
        while (i < this.b) {
            if (j == Long.MIN_VALUE || !m13733b(i, j)) {
                if (((long) mo2299a(i).f6376b) <= a) {
                    return i;
                }
                i2 = i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: b */
    private long m16332b(long j) {
        Object obj = (j == -9223372036854775807L || j > this.f12911f) ? null : 1;
        return obj != null ? (long) (((float) j) * this.f12915j) : this.f12911f;
    }
}
