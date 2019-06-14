package com.google.android.exoplayer2.p137e.p196c;

import android.util.Log;
import com.google.android.exoplayer2.p137e.C2325j;
import com.google.android.exoplayer2.p137e.p196c.C4105b.C4104a;
import com.google.android.exoplayer2.p164l.C2529l;
import com.google.android.exoplayer2.p164l.C2541v;

/* compiled from: XingSeeker */
/* renamed from: com.google.android.exoplayer2.e.c.d */
final class C4694d implements C4104a {
    /* renamed from: a */
    private final long f12675a;
    /* renamed from: b */
    private final int f12676b;
    /* renamed from: c */
    private final long f12677c;
    /* renamed from: d */
    private final long f12678d;
    /* renamed from: e */
    private final long[] f12679e;

    /* renamed from: a */
    public static C4694d m16046a(long j, long j2, C2325j c2325j, C2529l c2529l) {
        long j3 = j;
        C2325j c2325j2 = c2325j;
        int i = c2325j2.f5775g;
        int i2 = c2325j2.f5772d;
        int o = c2529l.m7111o();
        if ((o & 1) == 1) {
            int u = c2529l.m7117u();
            if (u != 0) {
                long b = C2541v.m7185b((long) u, ((long) i) * 1000000, (long) i2);
                if ((o & 6) != 6) {
                    return new C4694d(j2, c2325j2.f5771c, b);
                }
                long u2 = (long) c2529l.m7117u();
                long[] jArr = new long[100];
                for (int i3 = 0; i3 < 100; i3++) {
                    jArr[i3] = (long) c2529l.m7103g();
                }
                if (j3 != -1) {
                    long j4 = j2 + u2;
                    if (j3 != j4) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("XING data size mismatch: ");
                        stringBuilder.append(j3);
                        stringBuilder.append(", ");
                        stringBuilder.append(j4);
                        Log.w("XingSeeker", stringBuilder.toString());
                    }
                }
                return new C4694d(j2, c2325j2.f5771c, b, u2, jArr);
            }
        }
        return null;
    }

    private C4694d(long j, int i, long j2) {
        this(j, i, j2, -1, null);
    }

    private C4694d(long j, int i, long j2, long j3, long[] jArr) {
        this.f12675a = j;
        this.f12676b = i;
        this.f12677c = j2;
        this.f12678d = j3;
        this.f12679e = jArr;
    }

    /* renamed from: a */
    public boolean mo2167a() {
        return this.f12679e != null;
    }

    /* renamed from: b */
    public long mo2169b(long j) {
        if (!mo2167a()) {
            return this.f12675a + ((long) this.f12676b);
        }
        j = (((double) j) * 4636737291354636288L) / ((double) this.f12677c);
        double d = 0.0d;
        if (j > 0) {
            if (j >= 4636737291354636288L) {
                d = 256.0d;
            } else {
                double d2;
                int i = (int) j;
                double d3 = (double) this.f12679e[i];
                if (i == 99) {
                    d2 = 256.0d;
                } else {
                    d2 = (double) this.f12679e[i + 1];
                }
                d = d3 + ((j - ((double) i)) * (d2 - d3));
            }
        }
        return this.f12675a + C2541v.m7169a(Math.round((d / 256.0d) * ((double) this.f12678d)), (long) this.f12676b, this.f12678d - 1);
    }

    /* renamed from: a */
    public long mo3195a(long j) {
        j -= this.f12675a;
        if (mo2167a()) {
            if (j > ((long) this.f12676b)) {
                long j2;
                j = (((double) j) * 4643211215818981376L) / ((double) this.f12678d);
                int a = C2541v.m7167a(this.f12679e, (long) j, true, true);
                long a2 = m16045a(a);
                long j3 = this.f12679e[a];
                int i = a + 1;
                long a3 = m16045a(i);
                if (a == 99) {
                    j2 = 256;
                } else {
                    j2 = this.f12679e[i];
                }
                return a2 + Math.round((j3 == j2 ? 0 : (j - ((double) j3)) / ((double) (j2 - j3))) * ((double) (a3 - a2)));
            }
        }
        return 0;
    }

    /* renamed from: b */
    public long mo2168b() {
        return this.f12677c;
    }

    /* renamed from: a */
    private long m16045a(int i) {
        return (this.f12677c * ((long) i)) / 100;
    }
}
