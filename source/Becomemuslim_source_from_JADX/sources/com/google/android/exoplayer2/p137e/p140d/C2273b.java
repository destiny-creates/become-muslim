package com.google.android.exoplayer2.p137e.p140d;

import android.util.Log;
import android.util.Pair;
import com.facebook.common.time.Clock;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.NativeProtocol;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.C2571p;
import com.google.android.exoplayer2.p134a.C2216a;
import com.google.android.exoplayer2.p136c.C2255a;
import com.google.android.exoplayer2.p137e.C2324i;
import com.google.android.exoplayer2.p137e.p140d.C2268a.C4107a;
import com.google.android.exoplayer2.p137e.p140d.C2268a.C4108b;
import com.google.android.exoplayer2.p137e.p140d.C2277d.C2276a;
import com.google.android.exoplayer2.p145g.C2344a;
import com.google.android.exoplayer2.p145g.C2344a.C2342a;
import com.google.android.exoplayer2.p164l.C2516a;
import com.google.android.exoplayer2.p164l.C2518c;
import com.google.android.exoplayer2.p164l.C2529l;
import com.google.android.exoplayer2.p164l.C2541v;
import com.google.android.exoplayer2.p165m.C2544a;
import com.google.android.exoplayer2.p165m.C2550d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: AtomParsers */
/* renamed from: com.google.android.exoplayer2.e.d.b */
final class C2273b {
    /* renamed from: a */
    private static final int f5509a = C2541v.m7193g("vide");
    /* renamed from: b */
    private static final int f5510b = C2541v.m7193g("soun");
    /* renamed from: c */
    private static final int f5511c = C2541v.m7193g("text");
    /* renamed from: d */
    private static final int f5512d = C2541v.m7193g("sbtl");
    /* renamed from: e */
    private static final int f5513e = C2541v.m7193g("subt");
    /* renamed from: f */
    private static final int f5514f = C2541v.m7193g("clcp");
    /* renamed from: g */
    private static final int f5515g = C2541v.m7193g("cenc");
    /* renamed from: h */
    private static final int f5516h = C2541v.m7193g("meta");

    /* compiled from: AtomParsers */
    /* renamed from: com.google.android.exoplayer2.e.d.b$a */
    private static final class C2269a {
        /* renamed from: a */
        public final int f5493a;
        /* renamed from: b */
        public int f5494b;
        /* renamed from: c */
        public int f5495c;
        /* renamed from: d */
        public long f5496d;
        /* renamed from: e */
        private final boolean f5497e;
        /* renamed from: f */
        private final C2529l f5498f;
        /* renamed from: g */
        private final C2529l f5499g;
        /* renamed from: h */
        private int f5500h;
        /* renamed from: i */
        private int f5501i;

        public C2269a(C2529l c2529l, C2529l c2529l2, boolean z) {
            this.f5499g = c2529l;
            this.f5498f = c2529l2;
            this.f5497e = z;
            c2529l2.m7096c(12);
            this.f5493a = c2529l2.m7117u();
            c2529l.m7096c(12);
            this.f5501i = c2529l.m7117u();
            c2529l2 = true;
            if (c2529l.m7111o() != 1) {
                c2529l2 = null;
            }
            C2516a.m7020b(c2529l2, "first_chunk must be 1");
            this.f5494b = -1;
        }

        /* renamed from: a */
        public boolean m6272a() {
            int i = this.f5494b + 1;
            this.f5494b = i;
            if (i == this.f5493a) {
                return false;
            }
            long w;
            if (this.f5497e) {
                w = this.f5498f.m7119w();
            } else {
                w = this.f5498f.m7109m();
            }
            this.f5496d = w;
            if (this.f5494b == this.f5500h) {
                this.f5495c = this.f5499g.m7117u();
                this.f5499g.m7098d(4);
                i = this.f5501i - 1;
                this.f5501i = i;
                this.f5500h = i > 0 ? this.f5499g.m7117u() - 1 : -1;
            }
            return true;
        }
    }

    /* compiled from: AtomParsers */
    /* renamed from: com.google.android.exoplayer2.e.d.b$b */
    private interface C2270b {
        /* renamed from: a */
        int mo2194a();

        /* renamed from: b */
        int mo2195b();

        /* renamed from: c */
        boolean mo2196c();
    }

    /* compiled from: AtomParsers */
    /* renamed from: com.google.android.exoplayer2.e.d.b$c */
    private static final class C2271c {
        /* renamed from: a */
        public final C2286k[] f5502a;
        /* renamed from: b */
        public C2515k f5503b;
        /* renamed from: c */
        public int f5504c;
        /* renamed from: d */
        public int f5505d = 0;

        public C2271c(int i) {
            this.f5502a = new C2286k[i];
        }
    }

    /* compiled from: AtomParsers */
    /* renamed from: com.google.android.exoplayer2.e.d.b$f */
    private static final class C2272f {
        /* renamed from: a */
        private final int f5506a;
        /* renamed from: b */
        private final long f5507b;
        /* renamed from: c */
        private final int f5508c;

        public C2272f(int i, long j, int i2) {
            this.f5506a = i;
            this.f5507b = j;
            this.f5508c = i2;
        }
    }

    /* compiled from: AtomParsers */
    /* renamed from: com.google.android.exoplayer2.e.d.b$d */
    static final class C4109d implements C2270b {
        /* renamed from: a */
        private final int f10476a = this.f10478c.m7117u();
        /* renamed from: b */
        private final int f10477b = this.f10478c.m7117u();
        /* renamed from: c */
        private final C2529l f10478c;

        public C4109d(C4108b c4108b) {
            this.f10478c = c4108b.aQ;
            this.f10478c.m7096c(12);
        }

        /* renamed from: a */
        public int mo2194a() {
            return this.f10477b;
        }

        /* renamed from: b */
        public int mo2195b() {
            return this.f10476a == 0 ? this.f10478c.m7117u() : this.f10476a;
        }

        /* renamed from: c */
        public boolean mo2196c() {
            return this.f10476a != 0;
        }
    }

    /* compiled from: AtomParsers */
    /* renamed from: com.google.android.exoplayer2.e.d.b$e */
    static final class C4110e implements C2270b {
        /* renamed from: a */
        private final C2529l f10479a;
        /* renamed from: b */
        private final int f10480b = this.f10479a.m7117u();
        /* renamed from: c */
        private final int f10481c = (this.f10479a.m7117u() & JfifUtil.MARKER_FIRST_BYTE);
        /* renamed from: d */
        private int f10482d;
        /* renamed from: e */
        private int f10483e;

        /* renamed from: c */
        public boolean mo2196c() {
            return false;
        }

        public C4110e(C4108b c4108b) {
            this.f10479a = c4108b.aQ;
            this.f10479a.m7096c(12);
        }

        /* renamed from: a */
        public int mo2194a() {
            return this.f10480b;
        }

        /* renamed from: b */
        public int mo2195b() {
            if (this.f10481c == 8) {
                return this.f10479a.m7103g();
            }
            if (this.f10481c == 16) {
                return this.f10479a.m7104h();
            }
            int i = this.f10482d;
            this.f10482d = i + 1;
            if (i % 2 != 0) {
                return this.f10483e & 15;
            }
            this.f10483e = this.f10479a.m7103g();
            return (this.f10483e & 240) >> 4;
        }
    }

    /* renamed from: a */
    public static C2285j m6283a(C4107a c4107a, C4108b c4108b, long j, C2255a c2255a, boolean z, boolean z2) {
        C4107a c4107a2 = c4107a;
        C4107a e = c4107a2.m12911e(C2268a.f5445E);
        int c = C2273b.m6295c(e.m12910d(C2268a.f5459S).aQ);
        if (c == -1) {
            return null;
        }
        long a;
        C4108b c4108b2;
        long[] jArr;
        long[] jArr2;
        C2285j c2285j;
        C2272f b = C2273b.m6292b(c4107a2.m12910d(C2268a.f5455O).aQ);
        long j2 = -9223372036854775807L;
        if (j == -9223372036854775807L) {
            a = b.f5507b;
            c4108b2 = c4108b;
        } else {
            c4108b2 = c4108b;
            a = j;
        }
        long a2 = C2273b.m6279a(c4108b2.aQ);
        if (a != -9223372036854775807L) {
            j2 = C2541v.m7185b(a, 1000000, a2);
        }
        long j3 = j2;
        C4107a e2 = e.m12911e(C2268a.f5446F).m12911e(C2268a.f5447G);
        Pair d = C2273b.m6297d(e.m12910d(C2268a.f5458R).aQ);
        C2271c a3 = C2273b.m6282a(e2.m12910d(C2268a.f5460T).aQ, b.f5506a, b.f5508c, (String) d.second, c2255a, z2);
        if (z) {
            jArr = null;
            jArr2 = jArr;
        } else {
            Pair a4 = C2273b.m6280a(c4107a2.m12911e(C2268a.f5456P));
            jArr2 = (long[]) a4.second;
            jArr = (long[]) a4.first;
        }
        if (a3.f5503b == null) {
            c2285j = null;
        } else {
            int b2 = b.f5506a;
            j2 = ((Long) d.first).longValue();
            C2515k c2515k = a3.f5503b;
            int i = a3.f5505d;
            C2286k[] c2286kArr = a3.f5502a;
            int i2 = a3.f5504c;
            C2285j c2285j2 = new C2285j(b2, c, j2, a2, j3, c2515k, i, c2286kArr, i2, jArr, jArr2);
        }
        return c2285j;
    }

    /* renamed from: a */
    public static C2288m m6285a(C2285j c2285j, C4107a c4107a, C2324i c2324i) {
        C2270b c4109d;
        C2285j c2285j2 = c2285j;
        C4107a c4107a2 = c4107a;
        C2324i c2324i2 = c2324i;
        C4108b d = c4107a2.m12910d(C2268a.aq);
        if (d != null) {
            c4109d = new C4109d(d);
        } else {
            d = c4107a2.m12910d(C2268a.ar);
            if (d != null) {
                c4109d = new C4110e(d);
            } else {
                throw new C2571p("Track has no sample table size information");
            }
        }
        int a = c4109d.mo2194a();
        if (a == 0) {
            return new C2288m(new long[0], new int[0], 0, new long[0], new int[0]);
        }
        boolean z;
        int u;
        int u2;
        Object obj;
        long[] jArr;
        Object obj2;
        int i;
        int i2;
        int i3;
        long j;
        int i4;
        Object obj3;
        Object obj4;
        Object obj5;
        C4108b d2 = c4107a2.m12910d(C2268a.as);
        if (d2 == null) {
            d2 = c4107a2.m12910d(C2268a.at);
            z = true;
        } else {
            z = false;
        }
        C2529l c2529l = d2.aQ;
        C2529l c2529l2 = c4107a2.m12910d(C2268a.ap).aQ;
        C2529l c2529l3 = c4107a2.m12910d(C2268a.am).aQ;
        C4108b d3 = c4107a2.m12910d(C2268a.an);
        C2529l c2529l4 = d3 != null ? d3.aQ : null;
        C4108b d4 = c4107a2.m12910d(C2268a.ao);
        C2529l c2529l5 = d4 != null ? d4.aQ : null;
        C2269a c2269a = new C2269a(c2529l2, c2529l, z);
        c2529l3.m7096c(12);
        int u3 = c2529l3.m7117u() - 1;
        int u4 = c2529l3.m7117u();
        int u5 = c2529l3.m7117u();
        if (c2529l5 != null) {
            c2529l5.m7096c(12);
            u = c2529l5.m7117u();
        } else {
            u = 0;
        }
        int i5 = -1;
        if (c2529l4 != null) {
            c2529l4.m7096c(12);
            u2 = c2529l4.m7117u();
            if (u2 > 0) {
                i5 = c2529l4.m7117u() - 1;
            } else {
                c2529l4 = null;
            }
        } else {
            u2 = 0;
        }
        Object obj6 = (c4109d.mo2196c() && "audio/raw".equals(c2285j2.f5578f.f6380f) && u3 == 0 && u == 0 && u2 == 0) ? 1 : null;
        long j2 = 0;
        C2270b c2270b;
        if (obj6 == null) {
            int i6;
            obj6 = new long[a];
            obj = new int[a];
            jArr = new long[a];
            int i7 = u2;
            obj2 = new int[a];
            C2529l c2529l6 = c2529l3;
            i = i5;
            long j3 = 0;
            long j4 = j3;
            int i8 = i7;
            i5 = 0;
            int i9 = 0;
            int i10 = 0;
            i2 = u3;
            i7 = u;
            u3 = 0;
            u = 0;
            int i11 = u5;
            u5 = u4;
            u4 = i11;
            while (u3 < a) {
                int i12;
                while (i9 == 0) {
                    C2516a.m7019b(c2269a.m6272a());
                    i12 = u4;
                    i6 = i2;
                    long j5 = c2269a.f5496d;
                    i9 = c2269a.f5495c;
                    u4 = i12;
                    i2 = i6;
                    j3 = j5;
                }
                i12 = u4;
                i6 = i2;
                if (c2529l5 != null) {
                    while (i10 == 0 && i7 > 0) {
                        i10 = c2529l5.m7117u();
                        i5 = c2529l5.m7111o();
                        i7--;
                    }
                    i10--;
                }
                u4 = i5;
                obj6[u3] = j3;
                obj[u3] = c4109d.mo2195b();
                if (obj[u3] > u) {
                    i3 = a;
                    c2270b = c4109d;
                    u = obj[u3];
                } else {
                    i3 = a;
                    c2270b = c4109d;
                }
                jArr[u3] = j4 + ((long) u4);
                obj2[u3] = c2529l4 == null ? 1 : 0;
                if (u3 == i) {
                    obj2[u3] = 1;
                    i8--;
                    if (i8 > 0) {
                        i = c2529l4.m7117u() - 1;
                    }
                }
                int i13 = i8;
                int i14 = i;
                i8 = i12;
                j4 += (long) i8;
                u5--;
                if (u5 != 0 || i6 <= 0) {
                    i2 = i6;
                } else {
                    i2 = i6 - 1;
                    u5 = c2529l6.m7117u();
                    i8 = c2529l6.m7111o();
                }
                j3 += (long) obj[u3];
                i9--;
                u3++;
                i5 = u4;
                c4109d = c2270b;
                a = i3;
                i = i14;
                u4 = i8;
                i8 = i13;
            }
            i3 = a;
            i6 = i2;
            C2516a.m7017a(i10 == 0);
            while (i7 > 0) {
                C2516a.m7017a(c2529l5.m7117u() == 0);
                c2529l5.m7111o();
                i7--;
            }
            if (i8 == 0 && u5 == 0 && i9 == 0) {
                if (i6 == 0) {
                    c2285j2 = c2285j;
                    j = j4;
                    i4 = u;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Inconsistent stbl box for track ");
            a = i8;
            c2285j2 = c2285j;
            stringBuilder.append(c2285j2.f5573a);
            stringBuilder.append(": remainingSynchronizationSamples ");
            stringBuilder.append(a);
            stringBuilder.append(", remainingSamplesAtTimestampDelta ");
            stringBuilder.append(u5);
            stringBuilder.append(", remainingSamplesInChunk ");
            stringBuilder.append(i9);
            stringBuilder.append(", remainingTimestampDeltaChanges ");
            stringBuilder.append(i6);
            Log.w("AtomParsers", stringBuilder.toString());
            j = j4;
            i4 = u;
        } else {
            i3 = a;
            c2270b = c4109d;
            long[] jArr2 = new long[c2269a.f5493a];
            int[] iArr = new int[c2269a.f5493a];
            while (c2269a.m6272a()) {
                jArr2[c2269a.f5494b] = c2269a.f5496d;
                iArr[c2269a.f5494b] = c2269a.f5495c;
            }
            C2276a a2 = C2277d.m6301a(c2270b.mo2195b(), jArr2, iArr, (long) u5);
            obj6 = a2.f5521a;
            obj = a2.f5522b;
            i = a2.f5523c;
            jArr = a2.f5524d;
            obj2 = a2.f5525e;
            i4 = i;
            j = 0;
        }
        if (c2285j2.f5580h != null) {
            if (!c2324i.m6445a()) {
                long j6;
                long b;
                Object obj7;
                long[] jArr3;
                Object obj8;
                Object obj9;
                if (c2285j2.f5580h.length == 1 && c2285j2.f5574b == 1 && jArr.length >= 2) {
                    j6 = c2285j2.f5581i[0];
                    long b2 = C2541v.m7185b(c2285j2.f5580h[0], c2285j2.f5575c, c2285j2.f5576d) + j6;
                    if (jArr[0] <= j6 && j6 < jArr[1] && jArr[jArr.length - 1] < b2 && b2 <= j) {
                        long j7 = j - b2;
                        j = C2541v.m7185b(j6 - jArr[0], (long) c2285j2.f5578f.f6393s, c2285j2.f5575c);
                        b = C2541v.m7185b(j7, (long) c2285j2.f5578f.f6393s, c2285j2.f5575c);
                        if (!(j == 0 && b == 0) && j <= 2147483647L && b <= 2147483647L) {
                            c2324i2 = c2324i;
                            c2324i2.f5760b = (int) j;
                            c2324i2.f5761c = (int) b;
                            C2541v.m7176a(jArr, 1000000, c2285j2.f5575c);
                            return new C2288m(obj6, obj, i4, jArr, obj2);
                        }
                    }
                }
                if (c2285j2.f5580h.length == 1) {
                    int i15 = 0;
                    if (c2285j2.f5580h[0] == 0) {
                        int i16 = 0;
                        while (i16 < jArr.length) {
                            jArr[i16] = C2541v.m7185b(jArr[i16] - c2285j2.f5581i[i15], 1000000, c2285j2.f5575c);
                            i16++;
                            i15 = 0;
                        }
                        return new C2288m(obj6, obj, i4, jArr, obj2);
                    }
                }
                boolean z2 = c2285j2.f5574b == 1;
                i = 0;
                a = 0;
                int i17 = 0;
                u3 = 0;
                while (i < c2285j2.f5580h.length) {
                    long j8 = c2285j2.f5581i[i];
                    if (j8 != -1) {
                        obj7 = obj;
                        long b3 = C2541v.m7185b(c2285j2.f5580h[i], c2285j2.f5575c, c2285j2.f5576d);
                        int b4 = C2541v.m7184b(jArr, j8, true, true);
                        i2 = C2541v.m7184b(jArr, j8 + b3, z2, false);
                        i17 += i2 - b4;
                        a |= u3 != b4 ? 1 : 0;
                        u3 = i2;
                    } else {
                        obj7 = obj;
                    }
                    i++;
                    obj = obj7;
                }
                obj7 = obj;
                i = (i17 != i3 ? 1 : 0) | a;
                Object obj10 = i != 0 ? new long[i17] : obj6;
                obj = i != 0 ? new int[i17] : obj7;
                u3 = i != 0 ? 0 : i4;
                Object obj11 = i != 0 ? new int[i17] : obj2;
                long[] jArr4 = new long[i17];
                int i18 = u3;
                u3 = 0;
                int i19 = 0;
                while (u3 < c2285j2.f5580h.length) {
                    int i20;
                    boolean z3;
                    j6 = c2285j2.f5581i[u3];
                    long j9 = c2285j2.f5580h[u3];
                    if (j6 != -1) {
                        i20 = u3;
                        Object obj12 = obj11;
                        Object obj13 = obj10;
                        jArr3 = jArr4;
                        b = C2541v.m7185b(j9, c2285j2.f5575c, c2285j2.f5576d) + j6;
                        u4 = C2541v.m7184b(jArr, j6, true, true);
                        a = C2541v.m7184b(jArr, b, z2, false);
                        if (i != 0) {
                            i17 = a - u4;
                            obj8 = obj13;
                            System.arraycopy(obj6, u4, obj8, i19, i17);
                            obj3 = obj7;
                            System.arraycopy(obj3, u4, obj, i19, i17);
                            z3 = z2;
                            obj9 = obj12;
                            System.arraycopy(obj2, u4, obj9, i19, i17);
                        } else {
                            z3 = z2;
                            obj3 = obj7;
                            obj9 = obj12;
                            obj8 = obj13;
                        }
                        i17 = i18;
                        while (u4 < a) {
                            obj4 = obj6;
                            obj5 = obj2;
                            long j10 = j6;
                            jArr3[i19] = C2541v.m7185b(j2, 1000000, c2285j2.f5576d) + C2541v.m7185b(jArr[u4] - j6, 1000000, c2285j2.f5575c);
                            if (i != 0 && obj[i19] > i17) {
                                i17 = obj3[u4];
                            }
                            i19++;
                            u4++;
                            obj6 = obj4;
                            obj2 = obj5;
                            j6 = j10;
                        }
                        obj4 = obj6;
                        obj5 = obj2;
                        i18 = i17;
                    } else {
                        z3 = z2;
                        obj8 = obj10;
                        jArr3 = jArr4;
                        obj4 = obj6;
                        obj5 = obj2;
                        i20 = u3;
                        obj9 = obj11;
                        obj3 = obj7;
                    }
                    j2 += j9;
                    obj11 = obj9;
                    obj7 = obj3;
                    j6 = -1;
                    jArr4 = jArr3;
                    z2 = z3;
                    obj6 = obj4;
                    obj2 = obj5;
                    u3 = i20 + 1;
                    obj10 = obj8;
                }
                obj8 = obj10;
                jArr3 = jArr4;
                obj4 = obj6;
                obj5 = obj2;
                obj9 = obj11;
                obj3 = obj7;
                a = 0;
                for (i = 0; i < obj9.length && a == 0; i++) {
                    a |= (obj9[i] & 1) != 0 ? 1 : 0;
                }
                if (a != 0) {
                    return new C2288m(obj8, obj, i18, jArr3, obj9);
                }
                Log.w("AtomParsers", "Ignoring edit list: Edited sample sequence does not contain a sync sample.");
                C2541v.m7176a(jArr, 1000000, c2285j2.f5575c);
                return new C2288m(obj4, obj3, i4, jArr, obj5);
            }
        }
        obj4 = obj6;
        obj5 = obj2;
        obj3 = obj;
        C2541v.m7176a(jArr, 1000000, c2285j2.f5575c);
        return new C2288m(obj4, obj3, i4, jArr, obj5);
    }

    /* renamed from: a */
    public static C2344a m6286a(C4108b c4108b, boolean z) {
        if (z) {
            return null;
        }
        C2529l c2529l = c4108b.aQ;
        c2529l.m7096c(8);
        while (c2529l.m7093b() >= 8) {
            int d = c2529l.m7097d();
            int o = c2529l.m7111o();
            if (c2529l.m7111o() == C2268a.aB) {
                c2529l.m7096c(d);
                return C2273b.m6287a(c2529l, d + o);
            }
            c2529l.m7098d(o - 8);
        }
        return null;
    }

    /* renamed from: a */
    private static C2344a m6287a(C2529l c2529l, int i) {
        c2529l.m7098d(12);
        while (c2529l.m7097d() < i) {
            int d = c2529l.m7097d();
            int o = c2529l.m7111o();
            if (c2529l.m7111o() == C2268a.aC) {
                c2529l.m7096c(d);
                return C2273b.m6293b(c2529l, d + o);
            }
            c2529l.m7098d(o - 8);
        }
        return null;
    }

    /* renamed from: b */
    private static C2344a m6293b(C2529l c2529l, int i) {
        c2529l.m7098d(8);
        List arrayList = new ArrayList();
        while (c2529l.m7097d() < i) {
            C2342a a = C2280f.m6305a(c2529l);
            if (a != null) {
                arrayList.add(a);
            }
        }
        return arrayList.isEmpty() != null ? null : new C2344a(arrayList);
    }

    /* renamed from: a */
    private static long m6279a(C2529l c2529l) {
        int i = 8;
        c2529l.m7096c(8);
        if (C2268a.m6269a(c2529l.m7111o()) != 0) {
            i = 16;
        }
        c2529l.m7098d(i);
        return c2529l.m7109m();
    }

    /* renamed from: b */
    private static C2272f m6292b(C2529l c2529l) {
        Object obj;
        int i = 8;
        c2529l.m7096c(8);
        int a = C2268a.m6269a(c2529l.m7111o());
        c2529l.m7098d(a == 0 ? 8 : 16);
        int o = c2529l.m7111o();
        c2529l.m7098d(4);
        int d = c2529l.m7097d();
        if (a == 0) {
            i = 4;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (c2529l.f6441a[d + i3] != (byte) -1) {
                obj = null;
                break;
            }
        }
        obj = 1;
        long j = -9223372036854775807L;
        if (obj != null) {
            c2529l.m7098d(i);
        } else {
            long m = a == 0 ? c2529l.m7109m() : c2529l.m7119w();
            if (m != 0) {
                j = m;
            }
        }
        c2529l.m7098d(16);
        i = c2529l.m7111o();
        a = c2529l.m7111o();
        c2529l.m7098d(4);
        int o2 = c2529l.m7111o();
        c2529l = c2529l.m7111o();
        if (i == 0 && a == NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST && o2 == -65536 && c2529l == null) {
            i2 = 90;
        } else if (i == 0 && a == -65536 && o2 == NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST && c2529l == null) {
            i2 = RotationOptions.ROTATE_270;
        } else if (i == -65536 && a == 0 && o2 == 0 && c2529l == -65536) {
            i2 = RotationOptions.ROTATE_180;
        }
        return new C2272f(o, j, i2);
    }

    /* renamed from: c */
    private static int m6295c(C2529l c2529l) {
        c2529l.m7096c(16);
        c2529l = c2529l.m7111o();
        if (c2529l == f5510b) {
            return 1;
        }
        if (c2529l == f5509a) {
            return 2;
        }
        if (!(c2529l == f5511c || c2529l == f5512d || c2529l == f5513e)) {
            if (c2529l != f5514f) {
                return c2529l == f5516h ? 4 : -1;
            }
        }
        return 3;
    }

    /* renamed from: d */
    private static Pair<Long, String> m6297d(C2529l c2529l) {
        int i = 8;
        c2529l.m7096c(8);
        int a = C2268a.m6269a(c2529l.m7111o());
        c2529l.m7098d(a == 0 ? 8 : 16);
        long m = c2529l.m7109m();
        if (a == 0) {
            i = 4;
        }
        c2529l.m7098d(i);
        c2529l = c2529l.m7104h();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append((char) (((c2529l >> 10) & 31) + 96));
        stringBuilder.append((char) (((c2529l >> 5) & 31) + 96));
        stringBuilder.append((char) ((c2529l & 31) + 96));
        return Pair.create(Long.valueOf(m), stringBuilder.toString());
    }

    /* renamed from: a */
    private static C2271c m6282a(C2529l c2529l, int i, int i2, String str, C2255a c2255a, boolean z) {
        C2529l c2529l2 = c2529l;
        c2529l2.m7096c(12);
        int o = c2529l.m7111o();
        C2271c c2271c = new C2271c(o);
        for (int i3 = 0; i3 < o; i3++) {
            int d = c2529l.m7097d();
            int o2 = c2529l.m7111o();
            C2516a.m7018a(o2 > 0, "childAtomSize should be positive");
            int o3 = c2529l.m7111o();
            if (!(o3 == C2268a.f5468b || o3 == C2268a.f5469c || o3 == C2268a.f5466Z || o3 == C2268a.al || o3 == C2268a.f5470d || o3 == C2268a.f5471e || o3 == C2268a.f5472f || o3 == C2268a.aK)) {
                if (o3 != C2268a.aL) {
                    if (!(o3 == C2268a.f5475i || o3 == C2268a.aa || o3 == C2268a.f5480n || o3 == C2268a.f5482p || o3 == C2268a.f5484r || o3 == C2268a.f5487u || o3 == C2268a.f5485s || o3 == C2268a.f5486t || o3 == C2268a.ay || o3 == C2268a.az || o3 == C2268a.f5478l || o3 == C2268a.f5479m || o3 == C2268a.f5476j)) {
                        if (o3 != C2268a.aO) {
                            if (!(o3 == C2268a.aj || o3 == C2268a.au || o3 == C2268a.av || o3 == C2268a.aw)) {
                                if (o3 != C2268a.ax) {
                                    if (o3 == C2268a.aN) {
                                        c2271c.f5503b = C2515k.m6992a(Integer.toString(i), "application/x-camera-motion", null, -1, null);
                                    }
                                    c2529l2.m7096c(d + o2);
                                }
                            }
                            C2273b.m6289a(c2529l, o3, d, o2, i, str, c2271c);
                            c2529l2.m7096c(d + o2);
                        }
                    }
                    C2273b.m6290a(c2529l, o3, d, o2, i, str, z, c2255a, c2271c, i3);
                    c2529l2.m7096c(d + o2);
                }
            }
            C2273b.m6288a(c2529l, o3, d, o2, i, i2, c2255a, c2271c, i3);
            c2529l2.m7096c(d + o2);
        }
        return c2271c;
    }

    /* renamed from: a */
    private static void m6289a(C2529l c2529l, int i, int i2, int i3, int i4, String str, C2271c c2271c) {
        String str2;
        String str3;
        C2529l c2529l2 = c2529l;
        int i5 = i;
        C2271c c2271c2 = c2271c;
        c2529l2.m7096c((i2 + 8) + 8);
        int i6 = C2268a.aj;
        List list = null;
        long j = Clock.MAX_TIME;
        if (i5 == i6) {
            str2 = "application/ttml+xml";
        } else if (i5 == C2268a.au) {
            i6 = (i3 - 8) - 8;
            Object obj = new byte[i6];
            c2529l2.m7092a(obj, 0, i6);
            list = Collections.singletonList(obj);
            str3 = "application/x-quicktime-tx3g";
            c2271c2.f5503b = C2515k.m6990a(Integer.toString(i4), str3, null, -1, 0, str, -1, null, j, list);
        } else if (i5 == C2268a.av) {
            str2 = "application/x-mp4-vtt";
        } else if (i5 == C2268a.aw) {
            str2 = "application/ttml+xml";
            j = 0;
        } else if (i5 == C2268a.ax) {
            str2 = "application/x-mp4-cea-608";
            c2271c2.f5505d = 1;
        } else {
            throw new IllegalStateException();
        }
        str3 = str2;
        c2271c2.f5503b = C2515k.m6990a(Integer.toString(i4), str3, null, -1, 0, str, -1, null, j, list);
    }

    /* renamed from: a */
    private static void m6288a(C2529l c2529l, int i, int i2, int i3, int i4, int i5, C2255a c2255a, C2271c c2271c, int i6) {
        Pair c;
        C2529l c2529l2 = c2529l;
        int i7 = i2;
        int i8 = i3;
        C2255a c2255a2 = c2255a;
        C2271c c2271c2 = c2271c;
        c2529l2.m7096c((i7 + 8) + 8);
        c2529l2.m7098d(16);
        int h = c2529l.m7104h();
        int h2 = c2529l.m7104h();
        c2529l2.m7098d(50);
        int d = c2529l.m7097d();
        String str = null;
        int i9 = i;
        if (i9 == C2268a.f5466Z) {
            c = C2273b.m6296c(c2529l2, i7, i8);
            if (c != null) {
                i9 = ((Integer) c.first).intValue();
                if (c2255a2 == null) {
                    c2255a2 = null;
                } else {
                    c2255a2 = c2255a2.m6233a(((C2286k) c.second).f5585b);
                }
                c2271c2.f5502a[i6] = (C2286k) c.second;
            }
            c2529l2.m7096c(d);
        }
        C2255a c2255a3 = c2255a2;
        List list = null;
        byte[] bArr = list;
        Object obj = null;
        float f = 1.0f;
        int i10 = -1;
        while (d - i7 < i8) {
            c2529l2.m7096c(d);
            int d2 = c2529l.m7097d();
            int o = c2529l.m7111o();
            if (o != 0 || c2529l.m7097d() - i7 != i8) {
                C2516a.m7018a(o > 0, "childAtomSize should be positive");
                int o2 = c2529l.m7111o();
                if (o2 == C2268a.f5448H) {
                    C2516a.m7019b(str == null);
                    str = "video/avc";
                    c2529l2.m7096c(d2 + 8);
                    C2544a a = C2544a.m7201a(c2529l);
                    list = a.f6477a;
                    c2271c2.f5504c = a.f6478b;
                    if (obj == null) {
                        f = a.f6481e;
                    }
                } else if (o2 == C2268a.f5449I) {
                    C2516a.m7019b(str == null);
                    str = "video/hevc";
                    c2529l2.m7096c(d2 + 8);
                    C2550d a2 = C2550d.m7213a(c2529l);
                    list = a2.f6501a;
                    c2271c2.f5504c = a2.f6502b;
                } else if (o2 == C2268a.aM) {
                    C2516a.m7019b(str == null);
                    str = i9 == C2268a.aK ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                } else if (o2 == C2268a.f5473g) {
                    C2516a.m7019b(str == null);
                    str = "video/3gpp";
                } else if (o2 == C2268a.f5450J) {
                    C2516a.m7019b(str == null);
                    c = C2273b.m6298d(c2529l2, d2);
                    str = (String) c.first;
                    list = Collections.singletonList(c.second);
                } else if (o2 == C2268a.ai) {
                    f = C2273b.m6294c(c2529l2, d2);
                    obj = 1;
                } else if (o2 == C2268a.aI) {
                    bArr = C2273b.m6299d(c2529l2, d2, o);
                } else if (o2 == C2268a.aH) {
                    o2 = c2529l.m7103g();
                    c2529l2.m7098d(3);
                    if (o2 == 0) {
                        switch (c2529l.m7103g()) {
                            case 0:
                                i10 = 0;
                                break;
                            case 1:
                                i10 = 1;
                                break;
                            case 2:
                                i10 = 2;
                                break;
                            case 3:
                                i10 = 3;
                                break;
                            default:
                                break;
                        }
                    }
                }
                d += o;
            } else if (str == null) {
                c2271c2.f5503b = C2515k.m6985a(Integer.toString(i4), str, null, -1, -1, h, h2, -1.0f, list, i5, f, bArr, i10, null, c2255a3);
            }
        }
        if (str == null) {
            c2271c2.f5503b = C2515k.m6985a(Integer.toString(i4), str, null, -1, -1, h, h2, -1.0f, list, i5, f, bArr, i10, null, c2255a3);
        }
    }

    /* renamed from: a */
    private static Pair<long[], long[]> m6280a(C4107a c4107a) {
        if (c4107a != null) {
            c4107a = c4107a.m12910d(C2268a.f5457Q);
            if (c4107a != null) {
                c4107a = c4107a.aQ;
                c4107a.m7096c(8);
                int a = C2268a.m6269a(c4107a.m7111o());
                int u = c4107a.m7117u();
                Object obj = new long[u];
                Object obj2 = new long[u];
                int i = 0;
                while (i < u) {
                    obj[i] = a == 1 ? c4107a.m7119w() : c4107a.m7109m();
                    obj2[i] = a == 1 ? c4107a.m7113q() : (long) c4107a.m7111o();
                    if (c4107a.m7106j() == (short) 1) {
                        c4107a.m7098d(2);
                        i++;
                    } else {
                        throw new IllegalArgumentException("Unsupported media rate.");
                    }
                }
                return Pair.create(obj, obj2);
            }
        }
        return Pair.create(null, null);
    }

    /* renamed from: c */
    private static float m6294c(C2529l c2529l, int i) {
        c2529l.m7096c(i + 8);
        return ((float) c2529l.m7117u()) / ((float) c2529l.m7117u());
    }

    /* renamed from: a */
    private static void m6290a(C2529l c2529l, int i, int i2, int i3, int i4, String str, boolean z, C2255a c2255a, C2271c c2271c, int i5) {
        int h;
        int round;
        int i6;
        int i7;
        Pair c;
        C2255a c2255a2;
        String str2;
        int i8;
        int i9;
        Object obj;
        String str3;
        int o;
        int o2;
        int i10;
        String str4;
        int i11;
        C2255a c2255a3;
        C2271c c2271c2;
        Pair d;
        String str5;
        List list;
        C2529l c2529l2 = c2529l;
        int i12 = i2;
        int i13 = i3;
        String str6 = str;
        C2255a c2255a4 = c2255a;
        C2271c c2271c3 = c2271c;
        c2529l2.m7096c((i12 + 8) + 8);
        if (z) {
            h = c2529l.m7104h();
            c2529l2.m7098d(6);
        } else {
            c2529l2.m7098d(8);
            h = 0;
        }
        if (h != 0) {
            if (h != 1) {
                if (h == 2) {
                    c2529l2.m7098d(16);
                    round = (int) Math.round(c2529l.m7120x());
                    h = c2529l.m7117u();
                    c2529l2.m7098d(20);
                    i6 = h;
                    h = c2529l.m7097d();
                    i7 = i;
                    if (i7 == C2268a.aa) {
                        c = C2273b.m6296c(c2529l2, i12, i13);
                        if (c != null) {
                            i7 = ((Integer) c.first).intValue();
                            if (c2255a4 != null) {
                                c2255a4 = null;
                            } else {
                                c2255a4 = c2255a4.m6233a(((C2286k) c.second).f5585b);
                            }
                            c2271c3.f5502a[i5] = (C2286k) c.second;
                        }
                        c2529l2.m7096c(h);
                    }
                    c2255a2 = c2255a4;
                    if (i7 == C2268a.f5480n) {
                        str2 = "audio/ac3";
                    } else if (i7 == C2268a.f5482p) {
                        str2 = "audio/eac3";
                    } else if (i7 != C2268a.f5484r) {
                        str2 = "audio/vnd.dts";
                    } else {
                        if (i7 != C2268a.f5485s) {
                            if (i7 == C2268a.f5486t) {
                                if (i7 == C2268a.f5487u) {
                                    str2 = "audio/vnd.dts.hd;profile=lbr";
                                } else if (i7 == C2268a.ay) {
                                    str2 = "audio/3gpp";
                                } else if (i7 != C2268a.az) {
                                    str2 = "audio/amr-wb";
                                } else {
                                    if (i7 != C2268a.f5478l) {
                                        if (i7 == C2268a.f5479m) {
                                            str2 = i7 != C2268a.f5476j ? "audio/mpeg" : i7 != C2268a.aO ? "audio/alac" : null;
                                        }
                                    }
                                    str2 = "audio/raw";
                                }
                            }
                        }
                        str2 = "audio/vnd.dts.hd";
                    }
                    i8 = round;
                    i7 = h;
                    i9 = i6;
                    obj = null;
                    str3 = str2;
                    while (i7 - i12 < i13) {
                        c2529l2.m7096c(i7);
                        o = c2529l.m7111o();
                        C2516a.m7018a(o <= 0, "childAtomSize should be positive");
                        o2 = c2529l.m7111o();
                        if (o2 != C2268a.f5450J) {
                            if (z || o2 != C2268a.f5477k) {
                                if (o2 == C2268a.f5481o) {
                                    c2529l2.m7096c(i7 + 8);
                                    c2271c3.f5503b = C2216a.m6112a(c2529l2, Integer.toString(i4), str6, c2255a2);
                                } else if (o2 != C2268a.f5483q) {
                                    c2529l2.m7096c(i7 + 8);
                                    c2271c3.f5503b = C2216a.m6113b(c2529l2, Integer.toString(i4), str6, c2255a2);
                                } else {
                                    if (o2 != C2268a.f5488v) {
                                        i10 = o;
                                        str4 = str3;
                                        i11 = i7;
                                        c2255a3 = c2255a2;
                                        c2271c2 = c2271c3;
                                        c2271c2.f5503b = C2515k.m6988a(Integer.toString(i4), str3, null, -1, -1, i9, i8, null, c2255a3, 0, str);
                                    } else {
                                        i10 = o;
                                        str4 = str3;
                                        i11 = i7;
                                        c2255a3 = c2255a2;
                                        c2271c2 = c2271c3;
                                        if (o2 == C2268a.aO) {
                                            h = i10;
                                            Object obj2 = new byte[h];
                                            o = i11;
                                            c2529l2.m7096c(o);
                                            c2529l2.m7092a(obj2, 0, h);
                                            obj = obj2;
                                            i7 = o + h;
                                            c2271c3 = c2271c2;
                                            c2255a2 = c2255a3;
                                            str3 = str4;
                                            i13 = i3;
                                        }
                                    }
                                    h = i10;
                                    o = i11;
                                    i7 = o + h;
                                    c2271c3 = c2271c2;
                                    c2255a2 = c2255a3;
                                    str3 = str4;
                                    i13 = i3;
                                }
                                h = o;
                                str4 = str3;
                                o = i7;
                                c2255a3 = c2255a2;
                                c2271c2 = c2271c3;
                                i7 = o + h;
                                c2271c3 = c2271c2;
                                c2255a2 = c2255a3;
                                str3 = str4;
                                i13 = i3;
                            }
                        }
                        h = o;
                        str4 = str3;
                        o = i7;
                        c2255a3 = c2255a2;
                        c2271c2 = c2271c3;
                        if (o2 != C2268a.f5450J) {
                            i7 = o;
                        } else {
                            i7 = C2273b.m6291b(c2529l2, o, h);
                        }
                        if (i7 == -1) {
                            d = C2273b.m6298d(c2529l2, i7);
                            str5 = (String) d.first;
                            obj = (byte[]) d.second;
                            if ("audio/mp4a-latm".equals(str5)) {
                                d = C2518c.m7025a((byte[]) obj);
                                i8 = ((Integer) d.first).intValue();
                                i9 = ((Integer) d.second).intValue();
                            }
                        } else {
                            str5 = str4;
                        }
                        str4 = str5;
                        i7 = o + h;
                        c2271c3 = c2271c2;
                        c2255a2 = c2255a3;
                        str3 = str4;
                        i13 = i3;
                    }
                    str4 = str3;
                    c2255a3 = c2255a2;
                    c2271c2 = c2271c3;
                    if (c2271c2.f5503b == null) {
                        str2 = str4;
                        if (str2 != null) {
                            i6 = "audio/raw".equals(str2) ? 2 : -1;
                            String num = Integer.toString(i4);
                            if (obj != null) {
                                list = null;
                            } else {
                                list = Collections.singletonList(obj);
                            }
                            c2271c2.f5503b = C2515k.m6987a(num, str2, null, -1, -1, i9, i8, i6, list, c2255a3, 0, str);
                        }
                    }
                }
                return;
            }
        }
        i6 = c2529l.m7104h();
        c2529l2.m7098d(6);
        round = c2529l.m7115s();
        if (h == 1) {
            c2529l2.m7098d(16);
        }
        h = c2529l.m7097d();
        i7 = i;
        if (i7 == C2268a.aa) {
            c = C2273b.m6296c(c2529l2, i12, i13);
            if (c != null) {
                i7 = ((Integer) c.first).intValue();
                if (c2255a4 != null) {
                    c2255a4 = c2255a4.m6233a(((C2286k) c.second).f5585b);
                } else {
                    c2255a4 = null;
                }
                c2271c3.f5502a[i5] = (C2286k) c.second;
            }
            c2529l2.m7096c(h);
        }
        c2255a2 = c2255a4;
        if (i7 == C2268a.f5480n) {
            str2 = "audio/ac3";
        } else if (i7 == C2268a.f5482p) {
            str2 = "audio/eac3";
        } else if (i7 != C2268a.f5484r) {
            if (i7 != C2268a.f5485s) {
                if (i7 == C2268a.f5486t) {
                    if (i7 == C2268a.f5487u) {
                        str2 = "audio/vnd.dts.hd;profile=lbr";
                    } else if (i7 == C2268a.ay) {
                        str2 = "audio/3gpp";
                    } else if (i7 != C2268a.az) {
                        if (i7 != C2268a.f5478l) {
                            if (i7 == C2268a.f5479m) {
                                if (i7 != C2268a.f5476j) {
                                    if (i7 != C2268a.aO) {
                                    }
                                }
                            }
                        }
                        str2 = "audio/raw";
                    } else {
                        str2 = "audio/amr-wb";
                    }
                }
            }
            str2 = "audio/vnd.dts.hd";
        } else {
            str2 = "audio/vnd.dts";
        }
        i8 = round;
        i7 = h;
        i9 = i6;
        obj = null;
        str3 = str2;
        while (i7 - i12 < i13) {
            c2529l2.m7096c(i7);
            o = c2529l.m7111o();
            if (o <= 0) {
            }
            C2516a.m7018a(o <= 0, "childAtomSize should be positive");
            o2 = c2529l.m7111o();
            if (o2 != C2268a.f5450J) {
                if (z) {
                }
                if (o2 == C2268a.f5481o) {
                    c2529l2.m7096c(i7 + 8);
                    c2271c3.f5503b = C2216a.m6112a(c2529l2, Integer.toString(i4), str6, c2255a2);
                } else if (o2 != C2268a.f5483q) {
                    if (o2 != C2268a.f5488v) {
                        i10 = o;
                        str4 = str3;
                        i11 = i7;
                        c2255a3 = c2255a2;
                        c2271c2 = c2271c3;
                        if (o2 == C2268a.aO) {
                            h = i10;
                            Object obj22 = new byte[h];
                            o = i11;
                            c2529l2.m7096c(o);
                            c2529l2.m7092a(obj22, 0, h);
                            obj = obj22;
                            i7 = o + h;
                            c2271c3 = c2271c2;
                            c2255a2 = c2255a3;
                            str3 = str4;
                            i13 = i3;
                        }
                    } else {
                        i10 = o;
                        str4 = str3;
                        i11 = i7;
                        c2255a3 = c2255a2;
                        c2271c2 = c2271c3;
                        c2271c2.f5503b = C2515k.m6988a(Integer.toString(i4), str3, null, -1, -1, i9, i8, null, c2255a3, 0, str);
                    }
                    h = i10;
                    o = i11;
                    i7 = o + h;
                    c2271c3 = c2271c2;
                    c2255a2 = c2255a3;
                    str3 = str4;
                    i13 = i3;
                } else {
                    c2529l2.m7096c(i7 + 8);
                    c2271c3.f5503b = C2216a.m6113b(c2529l2, Integer.toString(i4), str6, c2255a2);
                }
                h = o;
                str4 = str3;
                o = i7;
                c2255a3 = c2255a2;
                c2271c2 = c2271c3;
                i7 = o + h;
                c2271c3 = c2271c2;
                c2255a2 = c2255a3;
                str3 = str4;
                i13 = i3;
            }
            h = o;
            str4 = str3;
            o = i7;
            c2255a3 = c2255a2;
            c2271c2 = c2271c3;
            if (o2 != C2268a.f5450J) {
                i7 = C2273b.m6291b(c2529l2, o, h);
            } else {
                i7 = o;
            }
            if (i7 == -1) {
                str5 = str4;
            } else {
                d = C2273b.m6298d(c2529l2, i7);
                str5 = (String) d.first;
                obj = (byte[]) d.second;
                if ("audio/mp4a-latm".equals(str5)) {
                    d = C2518c.m7025a((byte[]) obj);
                    i8 = ((Integer) d.first).intValue();
                    i9 = ((Integer) d.second).intValue();
                }
            }
            str4 = str5;
            i7 = o + h;
            c2271c3 = c2271c2;
            c2255a2 = c2255a3;
            str3 = str4;
            i13 = i3;
        }
        str4 = str3;
        c2255a3 = c2255a2;
        c2271c2 = c2271c3;
        if (c2271c2.f5503b == null) {
            str2 = str4;
            if (str2 != null) {
                if ("audio/raw".equals(str2)) {
                }
                String num2 = Integer.toString(i4);
                if (obj != null) {
                    list = Collections.singletonList(obj);
                } else {
                    list = null;
                }
                c2271c2.f5503b = C2515k.m6987a(num2, str2, null, -1, -1, i9, i8, i6, list, c2255a3, 0, str);
            }
        }
    }

    /* renamed from: b */
    private static int m6291b(C2529l c2529l, int i, int i2) {
        int d = c2529l.m7097d();
        while (d - i < i2) {
            c2529l.m7096c(d);
            int o = c2529l.m7111o();
            C2516a.m7018a(o > 0, "childAtomSize should be positive");
            if (c2529l.m7111o() == C2268a.f5450J) {
                return d;
            }
            d += o;
        }
        return -1;
    }

    /* renamed from: d */
    private static Pair<String, byte[]> m6298d(C2529l c2529l, int i) {
        c2529l.m7096c((i + 8) + 4);
        c2529l.m7098d(1);
        C2273b.m6300e(c2529l);
        c2529l.m7098d(2);
        int g = c2529l.m7103g();
        if ((g & 128) != 0) {
            c2529l.m7098d(2);
        }
        if ((g & 64) != 0) {
            c2529l.m7098d(c2529l.m7104h());
        }
        if ((g & 32) != 0) {
            c2529l.m7098d(2);
        }
        c2529l.m7098d(1);
        C2273b.m6300e(c2529l);
        Object obj = null;
        switch (c2529l.m7103g()) {
            case 32:
                obj = "video/mp4v-es";
                break;
            case 33:
                obj = "video/avc";
                break;
            case 35:
                obj = "video/hevc";
                break;
            case 64:
            case 102:
            case 103:
            case 104:
                obj = "audio/mp4a-latm";
                break;
            case 96:
            case 97:
                obj = "video/mpeg2";
                break;
            case 107:
                return Pair.create("audio/mpeg", null);
            case 165:
                obj = "audio/ac3";
                break;
            case 166:
                obj = "audio/eac3";
                break;
            case 169:
            case 172:
                return Pair.create("audio/vnd.dts", null);
            case 170:
            case 171:
                return Pair.create("audio/vnd.dts.hd", null);
            default:
                break;
        }
        c2529l.m7098d(12);
        c2529l.m7098d(1);
        i = C2273b.m6300e(c2529l);
        Object obj2 = new byte[i];
        c2529l.m7092a(obj2, 0, i);
        return Pair.create(obj, obj2);
    }

    /* renamed from: c */
    private static Pair<Integer, C2286k> m6296c(C2529l c2529l, int i, int i2) {
        int d = c2529l.m7097d();
        while (d - i < i2) {
            c2529l.m7096c(d);
            int o = c2529l.m7111o();
            C2516a.m7018a(o > 0, "childAtomSize should be positive");
            if (c2529l.m7111o() == C2268a.f5462V) {
                Pair<Integer, C2286k> a = C2273b.m6281a(c2529l, d, o);
                if (a != null) {
                    return a;
                }
            }
            d += o;
        }
        return null;
    }

    /* renamed from: a */
    static Pair<Integer, C2286k> m6281a(C2529l c2529l, int i, int i2) {
        int i3 = i + 8;
        String str = null;
        Object obj = str;
        int i4 = -1;
        int i5 = 0;
        while (i3 - i < i2) {
            c2529l.m7096c(i3);
            int o = c2529l.m7111o();
            int o2 = c2529l.m7111o();
            if (o2 == C2268a.ab) {
                obj = Integer.valueOf(c2529l.m7111o());
            } else if (o2 == C2268a.f5463W) {
                c2529l.m7098d(4);
                str = c2529l.m7100e(4);
            } else if (o2 == C2268a.f5464X) {
                i4 = i3;
                i5 = o;
            }
            i3 += o;
        }
        if ("cenc".equals(str) == 0 && "cbc1".equals(str) == 0 && "cens".equals(str) == 0) {
            if ("cbcs".equals(str) == 0) {
                return null;
            }
        }
        i = 1;
        C2516a.m7018a(obj != null ? 1 : 0, "frma atom is mandatory");
        C2516a.m7018a(i4 != -1 ? 1 : 0, "schi atom is mandatory");
        c2529l = C2273b.m6284a(c2529l, i4, i5, str);
        if (c2529l == null) {
            i = 0;
        }
        C2516a.m7018a(i, "tenc atom is mandatory");
        return Pair.create(obj, c2529l);
    }

    /* renamed from: a */
    private static C2286k m6284a(C2529l c2529l, int i, int i2, String str) {
        C2286k c2286k;
        int i3;
        int i4;
        int i5 = i + 8;
        while (true) {
            c2286k = null;
            if (i5 - i >= i2) {
                return null;
            }
            c2529l.m7096c(i5);
            int o = c2529l.m7111o();
            if (c2529l.m7111o() == C2268a.f5465Y) {
                break;
            }
            i5 += o;
        }
        i = C2268a.m6269a(c2529l.m7111o());
        c2529l.m7098d(1);
        if (i == 0) {
            c2529l.m7098d(1);
            i3 = 0;
            i4 = 0;
        } else {
            i = c2529l.m7103g();
            i4 = i & 15;
            i3 = (i & 240) >> 4;
        }
        boolean z = c2529l.m7103g() == 1;
        int g = c2529l.m7103g();
        byte[] bArr = new byte[16];
        c2529l.m7092a(bArr, 0, bArr.length);
        if (z && g == 0) {
            i = c2529l.m7103g();
            c2286k = new byte[i];
            c2529l.m7092a(c2286k, 0, i);
        }
        return new C2286k(z, str, g, bArr, i3, i4, c2286k);
    }

    /* renamed from: d */
    private static byte[] m6299d(C2529l c2529l, int i, int i2) {
        int i3 = i + 8;
        while (i3 - i < i2) {
            c2529l.m7096c(i3);
            int o = c2529l.m7111o();
            if (c2529l.m7111o() == C2268a.aJ) {
                return Arrays.copyOfRange(c2529l.f6441a, i3, o + i3);
            }
            i3 += o;
        }
        return null;
    }

    /* renamed from: e */
    private static int m6300e(C2529l c2529l) {
        int g = c2529l.m7103g();
        int i = g & 127;
        while ((g & 128) == 128) {
            g = c2529l.m7103g();
            i = (i << 7) | (g & 127);
        }
        return i;
    }
}
