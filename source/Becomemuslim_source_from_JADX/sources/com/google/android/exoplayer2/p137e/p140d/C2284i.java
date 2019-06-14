package com.google.android.exoplayer2.p137e.p140d;

import com.google.android.exoplayer2.p137e.C2304f;
import com.google.android.exoplayer2.p164l.C2529l;
import com.google.android.exoplayer2.p164l.C2541v;

/* compiled from: Sniffer */
/* renamed from: com.google.android.exoplayer2.e.d.i */
final class C2284i {
    /* renamed from: a */
    private static final int[] f5572a = new int[]{C2541v.m7193g("isom"), C2541v.m7193g("iso2"), C2541v.m7193g("iso3"), C2541v.m7193g("iso4"), C2541v.m7193g("iso5"), C2541v.m7193g("iso6"), C2541v.m7193g("avc1"), C2541v.m7193g("hvc1"), C2541v.m7193g("hev1"), C2541v.m7193g("mp41"), C2541v.m7193g("mp42"), C2541v.m7193g("3g2a"), C2541v.m7193g("3g2b"), C2541v.m7193g("3gr6"), C2541v.m7193g("3gs6"), C2541v.m7193g("3ge6"), C2541v.m7193g("3gg6"), C2541v.m7193g("M4V "), C2541v.m7193g("M4A "), C2541v.m7193g("f4v "), C2541v.m7193g("kddi"), C2541v.m7193g("M4VP"), C2541v.m7193g("qt  "), C2541v.m7193g("MSNV")};

    /* renamed from: a */
    public static boolean m6320a(C2304f c2304f) {
        return C2284i.m6321a(c2304f, true);
    }

    /* renamed from: b */
    public static boolean m6322b(C2304f c2304f) {
        return C2284i.m6321a(c2304f, false);
    }

    /* renamed from: a */
    private static boolean m6321a(C2304f c2304f, boolean z) {
        boolean z2;
        C2304f c2304f2 = c2304f;
        long d = c2304f.mo2192d();
        long j = -1;
        if (d == -1 || d > 4096) {
            d = 4096;
        }
        int i = (int) d;
        C2529l c2529l = new C2529l(64);
        boolean z3 = false;
        int i2 = 0;
        Object obj = null;
        while (i2 < i) {
            long d2;
            c2529l.m7089a(8);
            c2304f2.mo2191c(c2529l.f6441a, 0, 8);
            long m = c2529l.m7109m();
            int o = c2529l.m7111o();
            int i3 = 16;
            if (m == 1) {
                c2304f2.mo2191c(c2529l.f6441a, 8, 8);
                c2529l.m7094b(16);
                m = c2529l.m7119w();
            } else {
                if (m == 0) {
                    d2 = c2304f.mo2192d();
                    if (d2 != j) {
                        m = ((long) 8) + (d2 - c2304f.mo2189c());
                    }
                }
                i3 = 8;
            }
            d2 = (long) i3;
            if (m >= d2) {
                i2 += i3;
                if (o != C2268a.f5442B) {
                    if (o != C2268a.f5451K) {
                        if (o != C2268a.f5453M) {
                            if ((((long) i2) + m) - d2 >= ((long) i)) {
                                break;
                            }
                            int i4 = (int) (m - d2);
                            i2 += i4;
                            if (o == C2268a.f5467a) {
                                if (i4 < 8) {
                                    return false;
                                }
                                c2529l.m7089a(i4);
                                c2304f2.mo2191c(c2529l.f6441a, 0, i4);
                                i4 /= 4;
                                for (int i5 = 0; i5 < i4; i5++) {
                                    if (i5 == 1) {
                                        c2529l.m7098d(4);
                                    } else if (C2284i.m6319a(c2529l.m7111o())) {
                                        obj = 1;
                                        break;
                                    }
                                }
                                if (obj == null) {
                                    return false;
                                }
                            } else if (i4 != 0) {
                                c2304f2.mo2190c(i4);
                            }
                            j = -1;
                        }
                    }
                    z2 = true;
                    break;
                }
            } else {
                return false;
            }
        }
        z2 = false;
        if (obj != null && z == r0) {
            z3 = true;
        }
        return z3;
    }

    /* renamed from: a */
    private static boolean m6319a(int i) {
        if ((i >>> 8) == C2541v.m7193g("3gp")) {
            return true;
        }
        for (int i2 : f5572a) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }
}
