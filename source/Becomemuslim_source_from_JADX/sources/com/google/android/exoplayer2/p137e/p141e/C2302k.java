package com.google.android.exoplayer2.p137e.p141e;

import android.util.Log;
import com.google.android.exoplayer2.C2571p;
import com.google.android.exoplayer2.p164l.C2529l;
import java.util.Arrays;

/* compiled from: VorbisUtil */
/* renamed from: com.google.android.exoplayer2.e.e.k */
final class C2302k {

    /* compiled from: VorbisUtil */
    /* renamed from: com.google.android.exoplayer2.e.e.k$a */
    public static final class C2298a {
        /* renamed from: a */
        public final int f5655a;
        /* renamed from: b */
        public final int f5656b;
        /* renamed from: c */
        public final long[] f5657c;
        /* renamed from: d */
        public final int f5658d;
        /* renamed from: e */
        public final boolean f5659e;

        public C2298a(int i, int i2, long[] jArr, int i3, boolean z) {
            this.f5655a = i;
            this.f5656b = i2;
            this.f5657c = jArr;
            this.f5658d = i3;
            this.f5659e = z;
        }
    }

    /* compiled from: VorbisUtil */
    /* renamed from: com.google.android.exoplayer2.e.e.k$b */
    public static final class C2299b {
        /* renamed from: a */
        public final String f5660a;
        /* renamed from: b */
        public final String[] f5661b;
        /* renamed from: c */
        public final int f5662c;

        public C2299b(String str, String[] strArr, int i) {
            this.f5660a = str;
            this.f5661b = strArr;
            this.f5662c = i;
        }
    }

    /* compiled from: VorbisUtil */
    /* renamed from: com.google.android.exoplayer2.e.e.k$c */
    public static final class C2300c {
        /* renamed from: a */
        public final boolean f5663a;
        /* renamed from: b */
        public final int f5664b;
        /* renamed from: c */
        public final int f5665c;
        /* renamed from: d */
        public final int f5666d;

        public C2300c(boolean z, int i, int i2, int i3) {
            this.f5663a = z;
            this.f5664b = i;
            this.f5665c = i2;
            this.f5666d = i3;
        }
    }

    /* compiled from: VorbisUtil */
    /* renamed from: com.google.android.exoplayer2.e.e.k$d */
    public static final class C2301d {
        /* renamed from: a */
        public final long f5667a;
        /* renamed from: b */
        public final int f5668b;
        /* renamed from: c */
        public final long f5669c;
        /* renamed from: d */
        public final int f5670d;
        /* renamed from: e */
        public final int f5671e;
        /* renamed from: f */
        public final int f5672f;
        /* renamed from: g */
        public final int f5673g;
        /* renamed from: h */
        public final int f5674h;
        /* renamed from: i */
        public final boolean f5675i;
        /* renamed from: j */
        public final byte[] f5676j;

        public C2301d(long j, int i, long j2, int i2, int i3, int i4, int i5, int i6, boolean z, byte[] bArr) {
            this.f5667a = j;
            this.f5668b = i;
            this.f5669c = j2;
            this.f5670d = i2;
            this.f5671e = i3;
            this.f5672f = i4;
            this.f5673g = i5;
            this.f5674h = i6;
            this.f5675i = z;
            this.f5676j = bArr;
        }
    }

    /* renamed from: a */
    public static int m6360a(int i) {
        int i2 = 0;
        while (i > 0) {
            i2++;
            i >>>= 1;
        }
        return i2;
    }

    /* renamed from: a */
    public static C2301d m6362a(C2529l c2529l) {
        C2529l c2529l2 = c2529l;
        C2302k.m6364a(1, c2529l2, false);
        long n = c2529l.m7110n();
        int g = c2529l.m7103g();
        long n2 = c2529l.m7110n();
        int p = c2529l.m7112p();
        int p2 = c2529l.m7112p();
        int p3 = c2529l.m7112p();
        int g2 = c2529l.m7103g();
        return new C2301d(n, g, n2, p, p2, p3, (int) Math.pow(2.0d, (double) (g2 & 15)), (int) Math.pow(2.0d, (double) ((g2 & 240) >> 4)), (c2529l.m7103g() & 1) > 0, Arrays.copyOf(c2529l2.f6441a, c2529l.m7095c()));
    }

    /* renamed from: b */
    public static C2299b m6367b(C2529l c2529l) {
        int i = 0;
        C2302k.m6364a(3, c2529l, false);
        String e = c2529l.m7100e((int) c2529l.m7110n());
        int length = 11 + e.length();
        long n = c2529l.m7110n();
        String[] strArr = new String[((int) n)];
        length += 4;
        while (((long) i) < n) {
            length += 4;
            strArr[i] = c2529l.m7100e((int) c2529l.m7110n());
            length += strArr[i].length();
            i++;
        }
        if ((c2529l.m7103g() & 1) != null) {
            return new C2299b(e, strArr, length + 1);
        }
        throw new C2571p("framing bit expected to be set");
    }

    /* renamed from: a */
    public static boolean m6364a(int i, C2529l c2529l, boolean z) {
        if (c2529l.m7093b() < 7) {
            if (z) {
                return false;
            }
            z = new StringBuilder();
            z.append("too short header: ");
            z.append(c2529l.m7093b());
            throw new C2571p(z.toString());
        } else if (c2529l.m7103g() == i) {
            if (c2529l.m7103g() == 118 && c2529l.m7103g() == 111 && c2529l.m7103g() == 114 && c2529l.m7103g() == 98 && c2529l.m7103g() == 105) {
                if (c2529l.m7103g() == 115) {
                    return true;
                }
            }
            if (z) {
                return false;
            }
            throw new C2571p("expected characters 'vorbis'");
        } else if (z) {
            return false;
        } else {
            z = new StringBuilder();
            z.append("expected header type ");
            z.append(Integer.toHexString(i));
            throw new C2571p(z.toString());
        }
    }

    /* renamed from: a */
    public static C2300c[] m6366a(C2529l c2529l, int i) {
        int i2 = 0;
        C2302k.m6364a(5, c2529l, false);
        int g = c2529l.m7103g() + 1;
        C2296i c2296i = new C2296i(c2529l.f6441a);
        c2296i.m6359b(c2529l.m7097d() * 8);
        for (c2529l = null; c2529l < g; c2529l++) {
            C2302k.m6370d(c2296i);
        }
        c2529l = c2296i.m6356a(6) + 1;
        while (i2 < c2529l) {
            if (c2296i.m6356a(16) == 0) {
                i2++;
            } else {
                throw new C2571p("placeholder of time domain transforms not zeroed out");
            }
        }
        C2302k.m6369c(c2296i);
        C2302k.m6368b(c2296i);
        C2302k.m6363a(i, c2296i);
        c2529l = C2302k.m6365a(c2296i);
        if (c2296i.m6357a() != 0) {
            return c2529l;
        }
        throw new C2571p("framing bit after modes not set as expected");
    }

    /* renamed from: a */
    private static C2300c[] m6365a(C2296i c2296i) {
        int a = c2296i.m6356a(6) + 1;
        C2300c[] c2300cArr = new C2300c[a];
        for (int i = 0; i < a; i++) {
            c2300cArr[i] = new C2300c(c2296i.m6357a(), c2296i.m6356a(16), c2296i.m6356a(16), c2296i.m6356a(8));
        }
        return c2300cArr;
    }

    /* renamed from: a */
    private static void m6363a(int i, C2296i c2296i) {
        int a = c2296i.m6356a(6) + 1;
        for (int i2 = 0; i2 < a; i2++) {
            int a2 = c2296i.m6356a(16);
            if (a2 != 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("mapping type other than 0 not supported: ");
                stringBuilder.append(a2);
                Log.e("VorbisUtil", stringBuilder.toString());
            } else {
                int a3;
                a2 = c2296i.m6357a() ? c2296i.m6356a(4) + 1 : 1;
                if (c2296i.m6357a()) {
                    a3 = c2296i.m6356a(8) + 1;
                    for (int i3 = 0; i3 < a3; i3++) {
                        int i4 = i - 1;
                        c2296i.m6359b(C2302k.m6360a(i4));
                        c2296i.m6359b(C2302k.m6360a(i4));
                    }
                }
                if (c2296i.m6356a(2) == 0) {
                    if (a2 > 1) {
                        for (a3 = 0; a3 < i; a3++) {
                            c2296i.m6359b(4);
                        }
                    }
                    for (int i5 = 0; i5 < a2; i5++) {
                        c2296i.m6359b(8);
                        c2296i.m6359b(8);
                        c2296i.m6359b(8);
                    }
                } else {
                    throw new C2571p("to reserved bits must be zero after mapping coupling steps");
                }
            }
        }
    }

    /* renamed from: b */
    private static void m6368b(C2296i c2296i) {
        int a = c2296i.m6356a(6) + 1;
        int i = 0;
        while (i < a) {
            if (c2296i.m6356a(16) <= 2) {
                int i2;
                c2296i.m6359b(24);
                c2296i.m6359b(24);
                c2296i.m6359b(24);
                int a2 = c2296i.m6356a(6) + 1;
                c2296i.m6359b(8);
                int[] iArr = new int[a2];
                for (i2 = 0; i2 < a2; i2++) {
                    iArr[i2] = ((c2296i.m6357a() ? c2296i.m6356a(5) : 0) * 8) + c2296i.m6356a(3);
                }
                for (i2 = 0; i2 < a2; i2++) {
                    for (int i3 = 0; i3 < 8; i3++) {
                        if ((iArr[i2] & (1 << i3)) != 0) {
                            c2296i.m6359b(8);
                        }
                    }
                }
                i++;
            } else {
                throw new C2571p("residueType greater than 2 is not decodable");
            }
        }
    }

    /* renamed from: c */
    private static void m6369c(C2296i c2296i) {
        int a = c2296i.m6356a(6) + 1;
        for (int i = 0; i < a; i++) {
            int a2 = c2296i.m6356a(16);
            int a3;
            switch (a2) {
                case 0:
                    c2296i.m6359b(8);
                    c2296i.m6359b(16);
                    c2296i.m6359b(16);
                    c2296i.m6359b(6);
                    c2296i.m6359b(8);
                    a3 = c2296i.m6356a(4) + 1;
                    for (a2 = 0; a2 < a3; a2++) {
                        c2296i.m6359b(8);
                    }
                    break;
                case 1:
                    int a4;
                    a3 = c2296i.m6356a(5);
                    int[] iArr = new int[a3];
                    int i2 = -1;
                    for (a2 = 0; a2 < a3; a2++) {
                        iArr[a2] = c2296i.m6356a(4);
                        if (iArr[a2] > i2) {
                            i2 = iArr[a2];
                        }
                    }
                    int[] iArr2 = new int[(i2 + 1)];
                    for (i2 = 0; i2 < iArr2.length; i2++) {
                        iArr2[i2] = c2296i.m6356a(3) + 1;
                        a4 = c2296i.m6356a(2);
                        if (a4 > 0) {
                            c2296i.m6359b(8);
                        }
                        for (int i3 = 0; i3 < (1 << a4); i3++) {
                            c2296i.m6359b(8);
                        }
                    }
                    c2296i.m6359b(2);
                    int a5 = c2296i.m6356a(4);
                    i2 = 0;
                    a4 = 0;
                    for (int i4 = 0; i4 < a3; i4++) {
                        i2 += iArr2[iArr[i4]];
                        while (a4 < i2) {
                            c2296i.m6359b(a5);
                            a4++;
                        }
                    }
                    break;
                default:
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("floor type greater than 1 not decodable: ");
                    stringBuilder.append(a2);
                    throw new C2571p(stringBuilder.toString());
            }
        }
    }

    /* renamed from: d */
    private static C2298a m6370d(C2296i c2296i) {
        if (c2296i.m6356a(24) == 5653314) {
            int i;
            int i2;
            int a = c2296i.m6356a(16);
            int a2 = c2296i.m6356a(24);
            long[] jArr = new long[a2];
            boolean a3 = c2296i.m6357a();
            long j = 0;
            if (a3) {
                int a4 = c2296i.m6356a(5) + 1;
                i = 0;
                while (i < jArr.length) {
                    int a5 = c2296i.m6356a(C2302k.m6360a(a2 - i));
                    int i3 = i;
                    for (i = 0; i < a5 && i3 < jArr.length; i++) {
                        jArr[i3] = (long) a4;
                        i3++;
                    }
                    a4++;
                    i = i3;
                }
            } else {
                boolean a6 = c2296i.m6357a();
                for (i2 = 0; i2 < jArr.length; i2++) {
                    if (!a6) {
                        jArr[i2] = (long) (c2296i.m6356a(5) + 1);
                    } else if (c2296i.m6357a()) {
                        jArr[i2] = (long) (c2296i.m6356a(5) + 1);
                    } else {
                        jArr[i2] = 0;
                    }
                }
            }
            i2 = c2296i.m6356a(4);
            if (i2 <= 2) {
                if (i2 == 1 || i2 == 2) {
                    c2296i.m6359b(32);
                    c2296i.m6359b(32);
                    i = c2296i.m6356a(4) + 1;
                    c2296i.m6359b(1);
                    if (i2 != 1) {
                        j = (long) (a2 * a);
                    } else if (a != 0) {
                        j = C2302k.m6361a((long) a2, (long) a);
                    }
                    c2296i.m6359b((int) (j * ((long) i)));
                }
                return new C2298a(a, a2, jArr, i2, a3);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("lookup type greater than 2 not decodable: ");
            stringBuilder.append(i2);
            throw new C2571p(stringBuilder.toString());
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("expected code book to start with [0x56, 0x43, 0x42] at ");
        stringBuilder2.append(c2296i.m6358b());
        throw new C2571p(stringBuilder2.toString());
    }

    /* renamed from: a */
    private static long m6361a(long j, long j2) {
        return (long) Math.floor(Math.pow((double) j, 1.0d / ((double) j2)));
    }
}
