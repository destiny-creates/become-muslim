package com.google.android.exoplayer2.p137e.p196c;

import android.util.Log;
import com.google.android.exoplayer2.p137e.C2325j;
import com.google.android.exoplayer2.p137e.p196c.C4105b.C4104a;
import com.google.android.exoplayer2.p164l.C2529l;
import com.google.android.exoplayer2.p164l.C2541v;

/* compiled from: VbriSeeker */
/* renamed from: com.google.android.exoplayer2.e.c.c */
final class C4693c implements C4104a {
    /* renamed from: a */
    private final long[] f12672a;
    /* renamed from: b */
    private final long[] f12673b;
    /* renamed from: c */
    private final long f12674c;

    /* renamed from: a */
    public boolean mo2167a() {
        return true;
    }

    /* renamed from: a */
    public static C4693c m16040a(long j, long j2, C2325j c2325j, C2529l c2529l) {
        long j3 = j;
        C2325j c2325j2 = c2325j;
        C2529l c2529l2 = c2529l;
        c2529l2.m7098d(10);
        int o = c2529l.m7111o();
        if (o <= 0) {
            return null;
        }
        long j4;
        int i = c2325j2.f5772d;
        long b = C2541v.m7185b((long) o, 1000000 * ((long) (i >= 32000 ? 1152 : 576)), (long) i);
        o = c2529l.m7104h();
        int h = c2529l.m7104h();
        int h2 = c2529l.m7104h();
        c2529l2.m7098d(2);
        long j5 = j2 + ((long) c2325j2.f5771c);
        long[] jArr = new long[o];
        long[] jArr2 = new long[o];
        int i2 = 0;
        long j6 = j2;
        while (i2 < o) {
            int g;
            j4 = b;
            jArr[i2] = (((long) i2) * b) / ((long) o);
            jArr2[i2] = Math.max(j6, j5);
            switch (h2) {
                case 1:
                    g = c2529l.m7103g();
                    break;
                case 2:
                    g = c2529l.m7104h();
                    break;
                case 3:
                    g = c2529l.m7107k();
                    break;
                case 4:
                    g = c2529l.m7117u();
                    break;
                default:
                    return null;
            }
            j6 += (long) (g * h);
            i2++;
            b = j4;
            j3 = j;
        }
        j4 = b;
        long j7 = j;
        if (!(j7 == -1 || j7 == j6)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("VBRI data size mismatch: ");
            stringBuilder.append(j7);
            stringBuilder.append(", ");
            stringBuilder.append(j6);
            Log.w("VbriSeeker", stringBuilder.toString());
        }
        return new C4693c(jArr, jArr2, j4);
    }

    private C4693c(long[] jArr, long[] jArr2, long j) {
        this.f12672a = jArr;
        this.f12673b = jArr2;
        this.f12674c = j;
    }

    /* renamed from: b */
    public long mo2169b(long j) {
        return this.f12673b[C2541v.m7167a(this.f12672a, j, true, true)];
    }

    /* renamed from: a */
    public long mo3195a(long j) {
        return this.f12672a[C2541v.m7167a(this.f12673b, j, true, true)];
    }

    /* renamed from: b */
    public long mo2168b() {
        return this.f12674c;
    }
}
