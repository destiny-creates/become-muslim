package com.google.android.exoplayer2.p137e.p142g;

import android.util.SparseArray;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p137e.C2320g;
import com.google.android.exoplayer2.p137e.C2329m;
import com.google.android.exoplayer2.p137e.p142g.C2319w.C2318d;
import com.google.android.exoplayer2.p164l.C2527j;
import com.google.android.exoplayer2.p164l.C2527j.C2525a;
import com.google.android.exoplayer2.p164l.C2527j.C2526b;
import com.google.android.exoplayer2.p164l.C2529l;
import com.google.android.exoplayer2.p164l.C2530m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: H264Reader */
/* renamed from: com.google.android.exoplayer2.e.g.j */
public final class C4136j implements C2305h {
    /* renamed from: a */
    private final C2314t f10654a;
    /* renamed from: b */
    private final boolean f10655b;
    /* renamed from: c */
    private final boolean f10656c;
    /* renamed from: d */
    private final C2311o f10657d = new C2311o(true, 128);
    /* renamed from: e */
    private final C2311o f10658e = new C2311o(true, 128);
    /* renamed from: f */
    private final C2311o f10659f = new C2311o(true, 128);
    /* renamed from: g */
    private long f10660g;
    /* renamed from: h */
    private final boolean[] f10661h = new boolean[3];
    /* renamed from: i */
    private String f10662i;
    /* renamed from: j */
    private C2329m f10663j;
    /* renamed from: k */
    private C2309a f10664k;
    /* renamed from: l */
    private boolean f10665l;
    /* renamed from: m */
    private long f10666m;
    /* renamed from: n */
    private final C2529l f10667n = new C2529l();

    /* compiled from: H264Reader */
    /* renamed from: com.google.android.exoplayer2.e.g.j$a */
    private static final class C2309a {
        /* renamed from: a */
        private final C2329m f5698a;
        /* renamed from: b */
        private final boolean f5699b;
        /* renamed from: c */
        private final boolean f5700c;
        /* renamed from: d */
        private final SparseArray<C2526b> f5701d = new SparseArray();
        /* renamed from: e */
        private final SparseArray<C2525a> f5702e = new SparseArray();
        /* renamed from: f */
        private final C2530m f5703f = new C2530m(this.f5704g, 0, 0);
        /* renamed from: g */
        private byte[] f5704g = new byte[128];
        /* renamed from: h */
        private int f5705h;
        /* renamed from: i */
        private int f5706i;
        /* renamed from: j */
        private long f5707j;
        /* renamed from: k */
        private boolean f5708k;
        /* renamed from: l */
        private long f5709l;
        /* renamed from: m */
        private C2308a f5710m = new C2308a();
        /* renamed from: n */
        private C2308a f5711n = new C2308a();
        /* renamed from: o */
        private boolean f5712o;
        /* renamed from: p */
        private long f5713p;
        /* renamed from: q */
        private long f5714q;
        /* renamed from: r */
        private boolean f5715r;

        /* compiled from: H264Reader */
        /* renamed from: com.google.android.exoplayer2.e.g.j$a$a */
        private static final class C2308a {
            /* renamed from: a */
            private boolean f5682a;
            /* renamed from: b */
            private boolean f5683b;
            /* renamed from: c */
            private C2526b f5684c;
            /* renamed from: d */
            private int f5685d;
            /* renamed from: e */
            private int f5686e;
            /* renamed from: f */
            private int f5687f;
            /* renamed from: g */
            private int f5688g;
            /* renamed from: h */
            private boolean f5689h;
            /* renamed from: i */
            private boolean f5690i;
            /* renamed from: j */
            private boolean f5691j;
            /* renamed from: k */
            private boolean f5692k;
            /* renamed from: l */
            private int f5693l;
            /* renamed from: m */
            private int f5694m;
            /* renamed from: n */
            private int f5695n;
            /* renamed from: o */
            private int f5696o;
            /* renamed from: p */
            private int f5697p;

            private C2308a() {
            }

            /* renamed from: a */
            public void m6398a() {
                this.f5683b = false;
                this.f5682a = false;
            }

            /* renamed from: a */
            public void m6399a(int i) {
                this.f5686e = i;
                this.f5683b = true;
            }

            /* renamed from: a */
            public void m6400a(C2526b c2526b, int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, int i5, int i6, int i7, int i8, int i9) {
                this.f5684c = c2526b;
                this.f5685d = i;
                this.f5686e = i2;
                this.f5687f = i3;
                this.f5688g = i4;
                this.f5689h = z;
                this.f5690i = z2;
                this.f5691j = z3;
                this.f5692k = z4;
                this.f5693l = i5;
                this.f5694m = i6;
                this.f5695n = i7;
                this.f5696o = i8;
                this.f5697p = i9;
                this.f5682a = true;
                this.f5683b = true;
            }

            /* renamed from: b */
            public boolean m6401b() {
                return this.f5683b && (this.f5686e == 7 || this.f5686e == 2);
            }

            /* renamed from: a */
            private boolean m6396a(C2308a c2308a) {
                if (this.f5682a) {
                    if (!c2308a.f5682a || this.f5687f != c2308a.f5687f || this.f5688g != c2308a.f5688g || this.f5689h != c2308a.f5689h) {
                        return true;
                    }
                    if (this.f5690i && c2308a.f5690i && this.f5691j != c2308a.f5691j) {
                        return true;
                    }
                    if (this.f5685d != c2308a.f5685d && (this.f5685d == 0 || c2308a.f5685d == 0)) {
                        return true;
                    }
                    if (this.f5684c.f6430h == 0 && c2308a.f5684c.f6430h == 0 && (this.f5694m != c2308a.f5694m || this.f5695n != c2308a.f5695n)) {
                        return true;
                    }
                    if ((this.f5684c.f6430h == 1 && c2308a.f5684c.f6430h == 1 && (this.f5696o != c2308a.f5696o || this.f5697p != c2308a.f5697p)) || this.f5692k != c2308a.f5692k) {
                        return true;
                    }
                    if (this.f5692k && c2308a.f5692k && this.f5693l != c2308a.f5693l) {
                        return true;
                    }
                }
                return false;
            }
        }

        public C2309a(C2329m c2329m, boolean z, boolean z2) {
            this.f5698a = c2329m;
            this.f5699b = z;
            this.f5700c = z2;
            m6409b();
        }

        /* renamed from: a */
        public boolean m6408a() {
            return this.f5700c;
        }

        /* renamed from: a */
        public void m6406a(C2526b c2526b) {
            this.f5701d.append(c2526b.f6423a, c2526b);
        }

        /* renamed from: a */
        public void m6405a(C2525a c2525a) {
            this.f5702e.append(c2525a.f6420a, c2525a);
        }

        /* renamed from: b */
        public void m6409b() {
            this.f5708k = false;
            this.f5712o = false;
            this.f5711n.m6398a();
        }

        /* renamed from: a */
        public void m6404a(long j, int i, long j2) {
            this.f5706i = i;
            this.f5709l = j2;
            this.f5707j = j;
            if (this.f5699b == null || this.f5706i != 1) {
                if (this.f5700c == null) {
                    return;
                }
                if (!(this.f5706i == 5 || this.f5706i == 1 || this.f5706i == 2)) {
                    return;
                }
            }
            j = this.f5710m;
            this.f5710m = this.f5711n;
            this.f5711n = j;
            this.f5711n.m6398a();
            this.f5705h = 0;
            this.f5708k = true;
        }

        /* renamed from: a */
        public void m6407a(byte[] bArr, int i, int i2) {
            int i3 = i;
            if (this.f5708k) {
                int i4 = i2 - i3;
                if (r0.f5704g.length < r0.f5705h + i4) {
                    r0.f5704g = Arrays.copyOf(r0.f5704g, (r0.f5705h + i4) * 2);
                }
                System.arraycopy(bArr, i3, r0.f5704g, r0.f5705h, i4);
                r0.f5705h += i4;
                r0.f5703f.m7128a(r0.f5704g, 0, r0.f5705h);
                if (r0.f5703f.m7130b(8)) {
                    r0.f5703f.m7126a();
                    int c = r0.f5703f.m7131c(2);
                    r0.f5703f.m7127a(5);
                    if (r0.f5703f.m7132c()) {
                        r0.f5703f.m7133d();
                        if (r0.f5703f.m7132c()) {
                            int d = r0.f5703f.m7133d();
                            if (!r0.f5700c) {
                                r0.f5708k = false;
                                r0.f5711n.m6399a(d);
                            } else if (r0.f5703f.m7132c()) {
                                int d2 = r0.f5703f.m7133d();
                                if (r0.f5702e.indexOfKey(d2) < 0) {
                                    r0.f5708k = false;
                                    return;
                                }
                                C2525a c2525a = (C2525a) r0.f5702e.get(d2);
                                C2526b c2526b = (C2526b) r0.f5701d.get(c2525a.f6421b);
                                if (c2526b.f6427e) {
                                    if (r0.f5703f.m7130b(2)) {
                                        r0.f5703f.m7127a(2);
                                    } else {
                                        return;
                                    }
                                }
                                if (r0.f5703f.m7130b(c2526b.f6429g)) {
                                    boolean z;
                                    boolean b;
                                    boolean z2;
                                    boolean z3;
                                    int i5;
                                    int i6;
                                    int e;
                                    int i7;
                                    int i8;
                                    int c2 = r0.f5703f.m7131c(c2526b.f6429g);
                                    if (c2526b.f6428f) {
                                        z = false;
                                    } else if (r0.f5703f.m7130b(1)) {
                                        boolean b2 = r0.f5703f.m7129b();
                                        if (!b2) {
                                            z = b2;
                                        } else if (r0.f5703f.m7130b(1)) {
                                            z = b2;
                                            b = r0.f5703f.m7129b();
                                            z2 = true;
                                            z3 = r0.f5706i != 5;
                                            if (z3) {
                                                i5 = 0;
                                            } else if (!r0.f5703f.m7132c()) {
                                                i5 = r0.f5703f.m7133d();
                                            } else {
                                                return;
                                            }
                                            if (c2526b.f6430h != 0) {
                                                if (!r0.f5703f.m7130b(c2526b.f6431i)) {
                                                    i4 = r0.f5703f.m7131c(c2526b.f6431i);
                                                    if (c2525a.f6422c || z) {
                                                        i6 = i4;
                                                    } else if (r0.f5703f.m7132c()) {
                                                        e = r0.f5703f.m7134e();
                                                        i6 = i4;
                                                        i7 = 0;
                                                        i8 = 0;
                                                        r0.f5711n.m6400a(c2526b, c, d, c2, d2, z, z2, b, z3, i5, i6, e, i7, i8);
                                                        r0.f5708k = false;
                                                    } else {
                                                        return;
                                                    }
                                                }
                                                return;
                                            } else if (c2526b.f6430h == 1 || c2526b.f6432j) {
                                                i6 = 0;
                                            } else if (r0.f5703f.m7132c()) {
                                                i4 = r0.f5703f.m7134e();
                                                if (!c2525a.f6422c || z) {
                                                    i7 = i4;
                                                    i6 = 0;
                                                    e = 0;
                                                    i8 = 0;
                                                    r0.f5711n.m6400a(c2526b, c, d, c2, d2, z, z2, b, z3, i5, i6, e, i7, i8);
                                                    r0.f5708k = false;
                                                } else if (r0.f5703f.m7132c()) {
                                                    i8 = r0.f5703f.m7134e();
                                                    i7 = i4;
                                                    i6 = 0;
                                                    e = 0;
                                                    r0.f5711n.m6400a(c2526b, c, d, c2, d2, z, z2, b, z3, i5, i6, e, i7, i8);
                                                    r0.f5708k = false;
                                                } else {
                                                    return;
                                                }
                                            } else {
                                                return;
                                            }
                                            e = 0;
                                            i7 = 0;
                                            i8 = 0;
                                            r0.f5711n.m6400a(c2526b, c, d, c2, d2, z, z2, b, z3, i5, i6, e, i7, i8);
                                            r0.f5708k = false;
                                        } else {
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                    z2 = false;
                                    b = false;
                                    if (r0.f5706i != 5) {
                                    }
                                    if (z3) {
                                        i5 = 0;
                                    } else if (!r0.f5703f.m7132c()) {
                                        i5 = r0.f5703f.m7133d();
                                    } else {
                                        return;
                                    }
                                    if (c2526b.f6430h != 0) {
                                        if (c2526b.f6430h == 1) {
                                        }
                                        i6 = 0;
                                    } else if (!r0.f5703f.m7130b(c2526b.f6431i)) {
                                        i4 = r0.f5703f.m7131c(c2526b.f6431i);
                                        if (c2525a.f6422c) {
                                        }
                                        i6 = i4;
                                    } else {
                                        return;
                                    }
                                    e = 0;
                                    i7 = 0;
                                    i8 = 0;
                                    r0.f5711n.m6400a(c2526b, c, d, c2, d2, z, z2, b, z3, i5, i6, e, i7, i8);
                                    r0.f5708k = false;
                                }
                            }
                        }
                    }
                }
            }
        }

        /* renamed from: a */
        public void m6403a(long j, int i) {
            int i2 = 0;
            if (this.f5706i == 9 || (this.f5700c && this.f5711n.m6396a(this.f5710m))) {
                if (this.f5712o) {
                    m6402a(i + ((int) (j - this.f5707j)));
                }
                this.f5713p = this.f5707j;
                this.f5714q = this.f5709l;
                this.f5715r = false;
                this.f5712o = true;
            }
            j = this.f5715r;
            if (this.f5706i == 5 || (this.f5699b && this.f5706i == 1 && this.f5711n.m6401b())) {
                i2 = 1;
            }
            this.f5715r = j | i2;
        }

        /* renamed from: a */
        private void m6402a(int i) {
            this.f5698a.mo2198a(this.f5714q, this.f5715r, (int) (this.f5707j - this.f5713p), i, null);
        }
    }

    /* renamed from: b */
    public void mo2212b() {
    }

    public C4136j(C2314t c2314t, boolean z, boolean z2) {
        this.f10654a = c2314t;
        this.f10655b = z;
        this.f10656c = z2;
    }

    /* renamed from: a */
    public void mo2208a() {
        C2527j.m7065a(this.f10661h);
        this.f10657d.m6415a();
        this.f10658e.m6415a();
        this.f10659f.m6415a();
        this.f10664k.m6409b();
        this.f10660g = 0;
    }

    /* renamed from: a */
    public void mo2210a(C2320g c2320g, C2318d c2318d) {
        c2318d.m6431a();
        this.f10662i = c2318d.m6433c();
        this.f10663j = c2320g.mo2231a(c2318d.m6432b(), 2);
        this.f10664k = new C2309a(this.f10663j, this.f10655b, this.f10656c);
        this.f10654a.m6427a(c2320g, c2318d);
    }

    /* renamed from: a */
    public void mo2209a(long j, boolean z) {
        this.f10666m = j;
    }

    /* renamed from: a */
    public void mo2211a(C2529l c2529l) {
        int d = c2529l.m7097d();
        int c = c2529l.m7095c();
        byte[] bArr = c2529l.f6441a;
        this.f10660g += (long) c2529l.m7093b();
        this.f10663j.mo2200a(c2529l, c2529l.m7093b());
        while (true) {
            int a = C2527j.m7061a(bArr, d, c, this.f10661h);
            if (a == c) {
                m13107a(bArr, d, c);
                return;
            }
            int b = C2527j.m7067b(bArr, a);
            int i = a - d;
            if (i > 0) {
                m13107a(bArr, d, a);
            }
            int i2 = c - a;
            long j = this.f10660g - ((long) i2);
            m13105a(j, i2, i < 0 ? -i : 0, this.f10666m);
            m13106a(j, b, this.f10666m);
            d = a + 3;
        }
    }

    /* renamed from: a */
    private void m13106a(long j, int i, long j2) {
        if (!this.f10665l || this.f10664k.m6408a()) {
            this.f10657d.m6416a(i);
            this.f10658e.m6416a(i);
        }
        this.f10659f.m6416a(i);
        this.f10664k.m6404a(j, i, j2);
    }

    /* renamed from: a */
    private void m13107a(byte[] bArr, int i, int i2) {
        if (!this.f10665l || this.f10664k.m6408a()) {
            this.f10657d.m6417a(bArr, i, i2);
            this.f10658e.m6417a(bArr, i, i2);
        }
        this.f10659f.m6417a(bArr, i, i2);
        this.f10664k.m6407a(bArr, i, i2);
    }

    /* renamed from: a */
    private void m13105a(long j, int i, int i2, long j2) {
        int i3 = i2;
        if (!this.f10665l || r0.f10664k.m6408a()) {
            r0.f10657d.m6419b(i3);
            r0.f10658e.m6419b(i3);
            if (r0.f10665l) {
                if (r0.f10657d.m6418b()) {
                    r0.f10664k.m6406a(C2527j.m7062a(r0.f10657d.f5729a, 3, r0.f10657d.f5730b));
                    r0.f10657d.m6415a();
                } else if (r0.f10658e.m6418b()) {
                    r0.f10664k.m6405a(C2527j.m7068b(r0.f10658e.f5729a, 3, r0.f10658e.f5730b));
                    r0.f10658e.m6415a();
                }
            } else if (r0.f10657d.m6418b() && r0.f10658e.m6418b()) {
                List arrayList = new ArrayList();
                arrayList.add(Arrays.copyOf(r0.f10657d.f5729a, r0.f10657d.f5730b));
                arrayList.add(Arrays.copyOf(r0.f10658e.f5729a, r0.f10658e.f5730b));
                C2526b a = C2527j.m7062a(r0.f10657d.f5729a, 3, r0.f10657d.f5730b);
                C2525a b = C2527j.m7068b(r0.f10658e.f5729a, 3, r0.f10658e.f5730b);
                r0.f10663j.mo2199a(C2515k.m6984a(r0.f10662i, "video/avc", null, -1, -1, a.f6424b, a.f6425c, -1.0f, arrayList, -1, a.f6426d, null));
                r0.f10665l = true;
                r0.f10664k.m6406a(a);
                r0.f10664k.m6405a(b);
                r0.f10657d.m6415a();
                r0.f10658e.m6415a();
            }
        }
        if (r0.f10659f.m6419b(i2)) {
            r0.f10667n.m7091a(r0.f10659f.f5729a, C2527j.m7060a(r0.f10659f.f5729a, r0.f10659f.f5730b));
            r0.f10667n.m7096c(4);
            r0.f10654a.m6426a(j2, r0.f10667n);
        }
        r0.f10664k.m6403a(j, i);
    }
}
