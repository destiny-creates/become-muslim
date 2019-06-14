package com.google.android.exoplayer2.p162j;

import android.os.SystemClock;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p149h.C2438p;
import com.google.android.exoplayer2.p164l.C2516a;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: BaseTrackSelection */
/* renamed from: com.google.android.exoplayer2.j.b */
public abstract class C4236b implements C2484f {
    /* renamed from: a */
    protected final C2438p f11150a;
    /* renamed from: b */
    protected final int f11151b;
    /* renamed from: c */
    protected final int[] f11152c;
    /* renamed from: d */
    private final C2515k[] f11153d;
    /* renamed from: e */
    private final long[] f11154e;
    /* renamed from: f */
    private int f11155f;

    /* compiled from: BaseTrackSelection */
    /* renamed from: com.google.android.exoplayer2.j.b$a */
    private static final class C2477a implements Comparator<C2515k> {
        private C2477a() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m6912a((C2515k) obj, (C2515k) obj2);
        }

        /* renamed from: a */
        public int m6912a(C2515k c2515k, C2515k c2515k2) {
            return c2515k2.f6376b - c2515k.f6376b;
        }
    }

    /* renamed from: d */
    public void mo2303d() {
    }

    /* renamed from: e */
    public void mo2304e() {
    }

    public C4236b(C2438p c2438p, int... iArr) {
        C2516a.m7019b(iArr.length > 0);
        this.f11150a = (C2438p) C2516a.m7015a((Object) c2438p);
        this.f11151b = iArr.length;
        this.f11153d = new C2515k[this.f11151b];
        for (int i = 0; i < iArr.length; i++) {
            this.f11153d[i] = c2438p.m6712a(iArr[i]);
        }
        Arrays.sort(this.f11153d, new C2477a());
        this.f11152c = new int[this.f11151b];
        for (int i2 = 0; i2 < this.f11151b; i2++) {
            this.f11152c[i2] = c2438p.m6711a(this.f11153d[i2]);
        }
        this.f11154e = new long[this.f11151b];
    }

    /* renamed from: f */
    public final C2438p mo2305f() {
        return this.f11150a;
    }

    /* renamed from: g */
    public final int mo2306g() {
        return this.f11152c.length;
    }

    /* renamed from: a */
    public final C2515k mo2299a(int i) {
        return this.f11153d[i];
    }

    /* renamed from: b */
    public final int mo2301b(int i) {
        return this.f11152c[i];
    }

    /* renamed from: a */
    public final int mo2298a(C2515k c2515k) {
        for (int i = 0; i < this.f11151b; i++) {
            if (this.f11153d[i] == c2515k) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: c */
    public final int mo2302c(int i) {
        for (int i2 = 0; i2 < this.f11151b; i2++) {
            if (this.f11152c[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: h */
    public final C2515k mo2307h() {
        return this.f11153d[mo3215a()];
    }

    /* renamed from: i */
    public final int mo2308i() {
        return this.f11152c[mo3215a()];
    }

    /* renamed from: a */
    public final boolean mo2300a(int i, long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean b = m13733b(i, elapsedRealtime);
        int i2 = 0;
        while (i2 < this.f11151b && !b) {
            b = (i2 == i || m13733b(i2, elapsedRealtime)) ? false : true;
            i2++;
        }
        if (!b) {
            return false;
        }
        this.f11154e[i] = Math.max(this.f11154e[i], elapsedRealtime + j);
        return true;
    }

    /* renamed from: b */
    protected final boolean m13733b(int i, long j) {
        return this.f11154e[i] > j;
    }

    public int hashCode() {
        if (this.f11155f == 0) {
            this.f11155f = (System.identityHashCode(this.f11150a) * 31) + Arrays.hashCode(this.f11152c);
        }
        return this.f11155f;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                C4236b c4236b = (C4236b) obj;
                if (this.f11150a != c4236b.f11150a || Arrays.equals(this.f11152c, c4236b.f11152c) == null) {
                    z = false;
                }
                return z;
            }
        }
        return false;
    }
}
