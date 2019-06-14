package com.google.android.exoplayer2.p137e.p142g;

import android.util.Log;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p137e.C2320g;
import com.google.android.exoplayer2.p137e.C2329m;
import com.google.android.exoplayer2.p137e.p142g.C2319w.C2318d;
import com.google.android.exoplayer2.p164l.C2527j;
import com.google.android.exoplayer2.p164l.C2529l;
import com.google.android.exoplayer2.p164l.C2530m;
import java.util.Collections;

/* compiled from: H265Reader */
/* renamed from: com.google.android.exoplayer2.e.g.k */
public final class C4137k implements C2305h {
    /* renamed from: a */
    private final C2314t f10668a;
    /* renamed from: b */
    private String f10669b;
    /* renamed from: c */
    private C2329m f10670c;
    /* renamed from: d */
    private C2310a f10671d;
    /* renamed from: e */
    private boolean f10672e;
    /* renamed from: f */
    private final boolean[] f10673f = new boolean[3];
    /* renamed from: g */
    private final C2311o f10674g = new C2311o(32, 128);
    /* renamed from: h */
    private final C2311o f10675h = new C2311o(33, 128);
    /* renamed from: i */
    private final C2311o f10676i = new C2311o(34, 128);
    /* renamed from: j */
    private final C2311o f10677j = new C2311o(39, 128);
    /* renamed from: k */
    private final C2311o f10678k = new C2311o(40, 128);
    /* renamed from: l */
    private long f10679l;
    /* renamed from: m */
    private long f10680m;
    /* renamed from: n */
    private final C2529l f10681n = new C2529l();

    /* compiled from: H265Reader */
    /* renamed from: com.google.android.exoplayer2.e.g.k$a */
    private static final class C2310a {
        /* renamed from: a */
        private final C2329m f5716a;
        /* renamed from: b */
        private long f5717b;
        /* renamed from: c */
        private boolean f5718c;
        /* renamed from: d */
        private int f5719d;
        /* renamed from: e */
        private long f5720e;
        /* renamed from: f */
        private boolean f5721f;
        /* renamed from: g */
        private boolean f5722g;
        /* renamed from: h */
        private boolean f5723h;
        /* renamed from: i */
        private boolean f5724i;
        /* renamed from: j */
        private boolean f5725j;
        /* renamed from: k */
        private long f5726k;
        /* renamed from: l */
        private long f5727l;
        /* renamed from: m */
        private boolean f5728m;

        public C2310a(C2329m c2329m) {
            this.f5716a = c2329m;
        }

        /* renamed from: a */
        public void m6411a() {
            this.f5721f = false;
            this.f5722g = false;
            this.f5723h = false;
            this.f5724i = false;
            this.f5725j = false;
        }

        /* renamed from: a */
        public void m6413a(long j, int i, int i2, long j2) {
            this.f5722g = false;
            this.f5723h = false;
            this.f5720e = j2;
            this.f5719d = 0;
            this.f5717b = j;
            j = 1;
            if (i2 >= 32) {
                if (!this.f5725j && this.f5724i) {
                    m6410a(i);
                    this.f5724i = false;
                }
                if (i2 <= 34) {
                    this.f5723h = this.f5725j ^ true;
                    this.f5725j = true;
                }
            }
            boolean z = i2 >= 16 && i2 <= 21;
            this.f5718c = z;
            if (!this.f5718c) {
                if (i2 > 9) {
                    j = null;
                }
            }
            this.f5721f = j;
        }

        /* renamed from: a */
        public void m6414a(byte[] bArr, int i, int i2) {
            if (this.f5721f) {
                int i3 = (i + 2) - this.f5719d;
                if (i3 < i2) {
                    this.f5722g = (bArr[i3] & 128) != null ? 1 : null;
                    this.f5721f = false;
                    return;
                }
                this.f5719d += i2 - i;
            }
        }

        /* renamed from: a */
        public void m6412a(long j, int i) {
            if (this.f5725j && this.f5722g) {
                this.f5728m = this.f5718c;
                this.f5725j = 0;
            } else if (this.f5723h || this.f5722g) {
                if (this.f5724i) {
                    m6410a(i + ((int) (j - this.f5717b)));
                }
                this.f5726k = this.f5717b;
                this.f5727l = this.f5720e;
                this.f5724i = 1;
                this.f5728m = this.f5718c;
            }
        }

        /* renamed from: a */
        private void m6410a(int i) {
            this.f5716a.mo2198a(this.f5727l, this.f5728m, (int) (this.f5717b - this.f5726k), i, null);
        }
    }

    /* renamed from: b */
    public void mo2212b() {
    }

    public C4137k(C2314t c2314t) {
        this.f10668a = c2314t;
    }

    /* renamed from: a */
    public void mo2208a() {
        C2527j.m7065a(this.f10673f);
        this.f10674g.m6415a();
        this.f10675h.m6415a();
        this.f10676i.m6415a();
        this.f10677j.m6415a();
        this.f10678k.m6415a();
        this.f10671d.m6411a();
        this.f10679l = 0;
    }

    /* renamed from: a */
    public void mo2210a(C2320g c2320g, C2318d c2318d) {
        c2318d.m6431a();
        this.f10669b = c2318d.m6433c();
        this.f10670c = c2320g.mo2231a(c2318d.m6432b(), 2);
        this.f10671d = new C2310a(this.f10670c);
        this.f10668a.m6427a(c2320g, c2318d);
    }

    /* renamed from: a */
    public void mo2209a(long j, boolean z) {
        this.f10680m = j;
    }

    /* renamed from: a */
    public void mo2211a(C2529l c2529l) {
        C4137k c4137k = this;
        C2529l c2529l2 = c2529l;
        while (c2529l.m7093b() > 0) {
            int d = c2529l.m7097d();
            int c = c2529l.m7095c();
            byte[] bArr = c2529l2.f6441a;
            c4137k.f10679l += (long) c2529l.m7093b();
            c4137k.f10670c.mo2200a(c2529l2, c2529l.m7093b());
            while (d < c) {
                int a = C2527j.m7061a(bArr, d, c, c4137k.f10673f);
                if (a == c) {
                    m13116a(bArr, d, c);
                    return;
                }
                int c2 = C2527j.m7069c(bArr, a);
                int i = a - d;
                if (i > 0) {
                    m13116a(bArr, d, a);
                }
                int i2 = c - a;
                long j = c4137k.f10679l - ((long) i2);
                int i3 = i < 0 ? -i : 0;
                long j2 = j;
                int i4 = i2;
                m13117b(j2, i4, i3, c4137k.f10680m);
                m13114a(j2, i4, c2, c4137k.f10680m);
                d = a + 3;
            }
        }
    }

    /* renamed from: a */
    private void m13114a(long j, int i, int i2, long j2) {
        if (this.f10672e) {
            this.f10671d.m6413a(j, i, i2, j2);
        } else {
            this.f10674g.m6416a(i2);
            this.f10675h.m6416a(i2);
            this.f10676i.m6416a(i2);
        }
        this.f10677j.m6416a(i2);
        this.f10678k.m6416a(i2);
    }

    /* renamed from: a */
    private void m13116a(byte[] bArr, int i, int i2) {
        if (this.f10672e) {
            this.f10671d.m6414a(bArr, i, i2);
        } else {
            this.f10674g.m6417a(bArr, i, i2);
            this.f10675h.m6417a(bArr, i, i2);
            this.f10676i.m6417a(bArr, i, i2);
        }
        this.f10677j.m6417a(bArr, i, i2);
        this.f10678k.m6417a(bArr, i, i2);
    }

    /* renamed from: b */
    private void m13117b(long j, int i, int i2, long j2) {
        if (this.f10672e) {
            this.f10671d.m6412a(j, i);
        } else {
            this.f10674g.m6419b(i2);
            this.f10675h.m6419b(i2);
            this.f10676i.m6419b(i2);
            if (!(this.f10674g.m6418b() == null || this.f10675h.m6418b() == null || this.f10676i.m6418b() == null)) {
                this.f10670c.mo2199a(C4137k.m13113a(this.f10669b, this.f10674g, this.f10675h, this.f10676i));
                this.f10672e = 1;
            }
        }
        if (this.f10677j.m6419b(i2) != null) {
            this.f10681n.m7091a(this.f10677j.f5729a, C2527j.m7060a(this.f10677j.f5729a, this.f10677j.f5730b));
            this.f10681n.m7098d(5);
            this.f10668a.m6426a(j2, this.f10681n);
        }
        if (this.f10678k.m6419b(i2) != null) {
            this.f10681n.m7091a(this.f10678k.f5729a, C2527j.m7060a(this.f10678k.f5729a, this.f10678k.f5730b));
            this.f10681n.m7098d(5);
            this.f10668a.m6426a(j2, this.f10681n);
        }
    }

    /* renamed from: a */
    private static C2515k m13113a(String str, C2311o c2311o, C2311o c2311o2, C2311o c2311o3) {
        float f;
        C2311o c2311o4 = c2311o;
        C2311o c2311o5 = c2311o2;
        C2311o c2311o6 = c2311o3;
        Object obj = new byte[((c2311o4.f5730b + c2311o5.f5730b) + c2311o6.f5730b)];
        int i = 0;
        System.arraycopy(c2311o4.f5729a, 0, obj, 0, c2311o4.f5730b);
        System.arraycopy(c2311o5.f5729a, 0, obj, c2311o4.f5730b, c2311o5.f5730b);
        System.arraycopy(c2311o6.f5729a, 0, obj, c2311o4.f5730b + c2311o5.f5730b, c2311o6.f5730b);
        C2530m c2530m = new C2530m(c2311o5.f5729a, 0, c2311o5.f5730b);
        c2530m.m7127a(44);
        int c = c2530m.m7131c(3);
        c2530m.m7126a();
        c2530m.m7127a(88);
        c2530m.m7127a(8);
        int i2 = 0;
        for (int i3 = 0; i3 < c; i3++) {
            if (c2530m.m7129b()) {
                i2 += 89;
            }
            if (c2530m.m7129b()) {
                i2 += 8;
            }
        }
        c2530m.m7127a(i2);
        if (c > 0) {
            c2530m.m7127a((8 - c) * 2);
        }
        c2530m.m7133d();
        i2 = c2530m.m7133d();
        if (i2 == 3) {
            c2530m.m7126a();
        }
        int d = c2530m.m7133d();
        int d2 = c2530m.m7133d();
        if (c2530m.m7129b()) {
            int i4;
            int d3 = c2530m.m7133d();
            int d4 = c2530m.m7133d();
            int d5 = c2530m.m7133d();
            int d6 = c2530m.m7133d();
            if (i2 != 1) {
                if (i2 != 2) {
                    i4 = 1;
                    d -= i4 * (d3 + d4);
                    d2 -= (i2 != 1 ? 2 : 1) * (d5 + d6);
                }
            }
            i4 = 2;
            if (i2 != 1) {
            }
            d -= i4 * (d3 + d4);
            d2 -= (i2 != 1 ? 2 : 1) * (d5 + d6);
        }
        int i5 = d;
        int i6 = d2;
        c2530m.m7133d();
        c2530m.m7133d();
        d = c2530m.m7133d();
        i2 = c2530m.m7129b() ? 0 : c;
        while (i2 <= c) {
            c2530m.m7133d();
            c2530m.m7133d();
            c2530m.m7133d();
            i2++;
        }
        c2530m.m7133d();
        c2530m.m7133d();
        c2530m.m7133d();
        c2530m.m7133d();
        c2530m.m7133d();
        c2530m.m7133d();
        if (c2530m.m7129b() && c2530m.m7129b()) {
            C4137k.m13115a(c2530m);
        }
        c2530m.m7127a(2);
        if (c2530m.m7129b()) {
            c2530m.m7127a(8);
            c2530m.m7133d();
            c2530m.m7133d();
            c2530m.m7126a();
        }
        C4137k.m13118b(c2530m);
        if (c2530m.m7129b()) {
            while (i < c2530m.m7133d()) {
                c2530m.m7127a((d + 4) + 1);
                i++;
            }
        }
        c2530m.m7127a(2);
        float f2 = 1.0f;
        if (c2530m.m7129b() && c2530m.m7129b()) {
            c = c2530m.m7131c(8);
            if (c == JfifUtil.MARKER_FIRST_BYTE) {
                int c2 = c2530m.m7131c(16);
                int c3 = c2530m.m7131c(16);
                if (!(c2 == 0 || c3 == 0)) {
                    f2 = ((float) c2) / ((float) c3);
                }
                f = f2;
            } else if (c < C2527j.f6434b.length) {
                f = C2527j.f6434b[c];
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected aspect_ratio_idc value: ");
                stringBuilder.append(c);
                Log.w("H265Reader", stringBuilder.toString());
            }
            return C2515k.m6984a(str, "video/hevc", null, -1, -1, i5, i6, -1.0f, Collections.singletonList(obj), -1, f, null);
        }
        f = 1.0f;
        return C2515k.m6984a(str, "video/hevc", null, -1, -1, i5, i6, -1.0f, Collections.singletonList(obj), -1, f, null);
    }

    /* renamed from: a */
    private static void m13115a(C2530m c2530m) {
        for (int i = 0; i < 4; i++) {
            int i2 = 0;
            while (i2 < 6) {
                int min;
                if (c2530m.m7129b()) {
                    min = Math.min(64, 1 << ((i << 1) + 4));
                    if (i > 1) {
                        c2530m.m7134e();
                    }
                    for (int i3 = 0; i3 < min; i3++) {
                        c2530m.m7134e();
                    }
                } else {
                    c2530m.m7133d();
                }
                min = 3;
                if (i != 3) {
                    min = 1;
                }
                i2 += min;
            }
        }
    }

    /* renamed from: b */
    private static void m13118b(C2530m c2530m) {
        int d = c2530m.m7133d();
        boolean z = false;
        int i = 0;
        for (int i2 = 0; i2 < d; i2++) {
            if (i2 != 0) {
                z = c2530m.m7129b();
            }
            int i3;
            if (z) {
                c2530m.m7126a();
                c2530m.m7133d();
                for (i3 = 0; i3 <= i; i3++) {
                    if (c2530m.m7129b()) {
                        c2530m.m7126a();
                    }
                }
            } else {
                i = c2530m.m7133d();
                i3 = c2530m.m7133d();
                int i4 = i + i3;
                for (int i5 = 0; i5 < i; i5++) {
                    c2530m.m7133d();
                    c2530m.m7126a();
                }
                for (i = 0; i < i3; i++) {
                    c2530m.m7133d();
                    c2530m.m7126a();
                }
                i = i4;
            }
        }
    }
}
