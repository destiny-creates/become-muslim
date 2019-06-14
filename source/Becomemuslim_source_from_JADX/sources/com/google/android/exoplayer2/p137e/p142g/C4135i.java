package com.google.android.exoplayer2.p137e.p142g;

import android.util.Pair;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p137e.C2320g;
import com.google.android.exoplayer2.p137e.C2329m;
import com.google.android.exoplayer2.p137e.p142g.C2319w.C2318d;
import com.google.android.exoplayer2.p164l.C2527j;
import com.google.android.exoplayer2.p164l.C2529l;
import java.util.Arrays;
import java.util.Collections;

/* compiled from: H262Reader */
/* renamed from: com.google.android.exoplayer2.e.g.i */
public final class C4135i implements C2305h {
    /* renamed from: c */
    private static final double[] f10640c = new double[]{23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    /* renamed from: a */
    private String f10641a;
    /* renamed from: b */
    private C2329m f10642b;
    /* renamed from: d */
    private boolean f10643d;
    /* renamed from: e */
    private long f10644e;
    /* renamed from: f */
    private final boolean[] f10645f = new boolean[4];
    /* renamed from: g */
    private final C2306a f10646g = new C2306a(128);
    /* renamed from: h */
    private long f10647h;
    /* renamed from: i */
    private boolean f10648i;
    /* renamed from: j */
    private long f10649j;
    /* renamed from: k */
    private long f10650k;
    /* renamed from: l */
    private long f10651l;
    /* renamed from: m */
    private boolean f10652m;
    /* renamed from: n */
    private boolean f10653n;

    /* compiled from: H262Reader */
    /* renamed from: com.google.android.exoplayer2.e.g.i$a */
    private static final class C2306a {
        /* renamed from: d */
        private static final byte[] f5677d = new byte[]{(byte) 0, (byte) 0, (byte) 1};
        /* renamed from: a */
        public int f5678a;
        /* renamed from: b */
        public int f5679b;
        /* renamed from: c */
        public byte[] f5680c;
        /* renamed from: e */
        private boolean f5681e;

        public C2306a(int i) {
            this.f5680c = new byte[i];
        }

        /* renamed from: a */
        public void m6393a() {
            this.f5681e = false;
            this.f5678a = 0;
            this.f5679b = 0;
        }

        /* renamed from: a */
        public boolean m6395a(int i, int i2) {
            if (this.f5681e) {
                this.f5678a -= i2;
                if (this.f5679b == 0 && i == 181) {
                    this.f5679b = this.f5678a;
                } else {
                    this.f5681e = false;
                    return true;
                }
            } else if (i == 179) {
                this.f5681e = true;
            }
            m6394a(f5677d, 0, f5677d.length);
            return false;
        }

        /* renamed from: a */
        public void m6394a(byte[] bArr, int i, int i2) {
            if (this.f5681e) {
                i2 -= i;
                if (this.f5680c.length < this.f5678a + i2) {
                    this.f5680c = Arrays.copyOf(this.f5680c, (this.f5678a + i2) * 2);
                }
                System.arraycopy(bArr, i, this.f5680c, this.f5678a, i2);
                this.f5678a += i2;
            }
        }
    }

    /* renamed from: b */
    public void mo2212b() {
    }

    /* renamed from: a */
    public void mo2208a() {
        C2527j.m7065a(this.f10645f);
        this.f10646g.m6393a();
        this.f10647h = 0;
        this.f10648i = false;
    }

    /* renamed from: a */
    public void mo2210a(C2320g c2320g, C2318d c2318d) {
        c2318d.m6431a();
        this.f10641a = c2318d.m6433c();
        this.f10642b = c2320g.mo2231a(c2318d.m6432b(), 2);
    }

    /* renamed from: a */
    public void mo2209a(long j, boolean z) {
        this.f10649j = j;
    }

    /* renamed from: a */
    public void mo2211a(C2529l c2529l) {
        C2529l c2529l2 = c2529l;
        int d = c2529l.m7097d();
        int c = c2529l.m7095c();
        byte[] bArr = c2529l2.f6441a;
        this.f10647h += (long) c2529l.m7093b();
        this.f10642b.mo2200a(c2529l2, c2529l.m7093b());
        while (true) {
            int a = C2527j.m7061a(bArr, d, c, r0.f10645f);
            if (a == c) {
                break;
            }
            boolean z;
            int i = a + 3;
            int i2 = c2529l2.f6441a[i] & JfifUtil.MARKER_FIRST_BYTE;
            if (!r0.f10643d) {
                int i3 = a - d;
                if (i3 > 0) {
                    r0.f10646g.m6394a(bArr, d, a);
                }
                if (r0.f10646g.m6395a(i2, i3 < 0 ? -i3 : 0)) {
                    Pair a2 = C4135i.m13099a(r0.f10646g, r0.f10641a);
                    r0.f10642b.mo2199a((C2515k) a2.first);
                    r0.f10644e = ((Long) a2.second).longValue();
                    r0.f10643d = true;
                }
            }
            if (i2 != 0) {
                if (i2 != 179) {
                    if (i2 == 184) {
                        r0.f10652m = true;
                    }
                    d = i;
                }
            }
            d = c - a;
            if (r0.f10648i && r0.f10653n && r0.f10643d) {
                r0.f10642b.mo2198a(r0.f10651l, r0.f10652m, ((int) (r0.f10647h - r0.f10650k)) - d, d, null);
            }
            if (r0.f10648i) {
                if (!r0.f10653n) {
                    z = false;
                    if (i2 == 0) {
                        z = true;
                    }
                    r0.f10653n = z;
                    d = i;
                }
            }
            r0.f10650k = r0.f10647h - ((long) d);
            long j = r0.f10649j != -9223372036854775807L ? r0.f10649j : r0.f10648i ? r0.f10651l + r0.f10644e : 0;
            r0.f10651l = j;
            z = false;
            r0.f10652m = false;
            r0.f10649j = -9223372036854775807L;
            r0.f10648i = true;
            if (i2 == 0) {
                z = true;
            }
            r0.f10653n = z;
            d = i;
        }
        if (!r0.f10643d) {
            r0.f10646g.m6394a(bArr, d, c);
        }
    }

    /* renamed from: a */
    private static Pair<C2515k, Long> m13099a(C2306a c2306a, String str) {
        float f;
        float f2;
        C2306a c2306a2 = c2306a;
        Object copyOf = Arrays.copyOf(c2306a2.f5680c, c2306a2.f5678a);
        int i = copyOf[5] & JfifUtil.MARKER_FIRST_BYTE;
        int i2 = ((copyOf[4] & JfifUtil.MARKER_FIRST_BYTE) << 4) | (i >> 4);
        int i3 = ((i & 15) << 8) | (copyOf[6] & JfifUtil.MARKER_FIRST_BYTE);
        switch ((copyOf[7] & 240) >> 4) {
            case 2:
                f = ((float) (i3 * 4)) / ((float) (i2 * 3));
                break;
            case 3:
                f = ((float) (i3 * 16)) / ((float) (i2 * 9));
                break;
            case 4:
                f = ((float) (i3 * 121)) / ((float) (i2 * 100));
                break;
            default:
                f2 = 1.0f;
                break;
        }
        f2 = f;
        C2515k a = C2515k.m6984a(str, "video/mpeg2", null, -1, -1, i2, i3, -1.0f, Collections.singletonList(copyOf), -1, f2, null);
        long j = 0;
        int i4 = (copyOf[7] & 15) - 1;
        if (i4 >= 0 && i4 < f10640c.length) {
            double d = f10640c[i4];
            int i5 = c2306a2.f5679b + 9;
            i4 = (copyOf[i5] & 96) >> 5;
            i5 = copyOf[i5] & 31;
            if (i4 != i5) {
                d *= (((double) i4) + 1.0d) / ((double) (i5 + 1));
            }
            j = (long) (1000000.0d / d);
        }
        return Pair.create(a, Long.valueOf(j));
    }
}
