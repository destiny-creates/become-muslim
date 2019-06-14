package com.google.android.exoplayer2.p137e.p142g;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.facebook.imagepipeline.memory.DefaultFlexByteArrayPoolParams;
import com.facebook.internal.Utility;
import com.google.android.exoplayer2.p137e.C2303e;
import com.google.android.exoplayer2.p137e.C2304f;
import com.google.android.exoplayer2.p137e.C2320g;
import com.google.android.exoplayer2.p137e.C2323h;
import com.google.android.exoplayer2.p137e.C2326k;
import com.google.android.exoplayer2.p137e.C2327l.C4154a;
import com.google.android.exoplayer2.p137e.p142g.C2319w.C2315a;
import com.google.android.exoplayer2.p137e.p142g.C2319w.C2316b;
import com.google.android.exoplayer2.p137e.p142g.C2319w.C2317c;
import com.google.android.exoplayer2.p137e.p142g.C2319w.C2318d;
import com.google.android.exoplayer2.p164l.C2516a;
import com.google.android.exoplayer2.p164l.C2528k;
import com.google.android.exoplayer2.p164l.C2529l;
import com.google.android.exoplayer2.p164l.C2537s;
import com.google.android.exoplayer2.p164l.C2541v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: TsExtractor */
/* renamed from: com.google.android.exoplayer2.e.g.v */
public final class C4149v implements C2303e {
    /* renamed from: a */
    public static final C2323h f10757a = new C41461();
    /* renamed from: b */
    private static final long f10758b = ((long) C2541v.m7193g("AC-3"));
    /* renamed from: c */
    private static final long f10759c = ((long) C2541v.m7193g("EAC3"));
    /* renamed from: d */
    private static final long f10760d = ((long) C2541v.m7193g("HEVC"));
    /* renamed from: e */
    private final int f10761e;
    /* renamed from: f */
    private final List<C2537s> f10762f;
    /* renamed from: g */
    private final C2529l f10763g;
    /* renamed from: h */
    private final SparseIntArray f10764h;
    /* renamed from: i */
    private final C2317c f10765i;
    /* renamed from: j */
    private final SparseArray<C2319w> f10766j;
    /* renamed from: k */
    private final SparseBooleanArray f10767k;
    /* renamed from: l */
    private C2320g f10768l;
    /* renamed from: m */
    private int f10769m;
    /* renamed from: n */
    private boolean f10770n;
    /* renamed from: o */
    private C2319w f10771o;

    /* compiled from: TsExtractor */
    /* renamed from: com.google.android.exoplayer2.e.g.v$1 */
    static class C41461 implements C2323h {
        C41461() {
        }

        /* renamed from: a */
        public C2303e[] mo2161a() {
            return new C2303e[]{new C4149v()};
        }
    }

    /* compiled from: TsExtractor */
    /* renamed from: com.google.android.exoplayer2.e.g.v$a */
    private class C4147a implements C2313r {
        /* renamed from: a */
        final /* synthetic */ C4149v f10750a;
        /* renamed from: b */
        private final C2528k f10751b = new C2528k(new byte[4]);

        /* renamed from: a */
        public void mo2219a(C2537s c2537s, C2320g c2320g, C2318d c2318d) {
        }

        public C4147a(C4149v c4149v) {
            this.f10750a = c4149v;
        }

        /* renamed from: a */
        public void mo2218a(C2529l c2529l) {
            if (c2529l.m7103g() == 0) {
                c2529l.m7098d(7);
                int b = c2529l.m7093b() / 4;
                for (int i = 0; i < b; i++) {
                    c2529l.m7090a(this.f10751b, 4);
                    int c = this.f10751b.m7081c(16);
                    this.f10751b.m7078b(3);
                    if (c == 0) {
                        this.f10751b.m7078b(13);
                    } else {
                        c = this.f10751b.m7081c(13);
                        this.f10750a.f10766j.put(c, new C4144s(new C4148b(this.f10750a, c)));
                        this.f10750a.f10769m = this.f10750a.f10769m + 1;
                    }
                }
                if (this.f10750a.f10761e != 2) {
                    this.f10750a.f10766j.remove(0);
                }
            }
        }
    }

    /* compiled from: TsExtractor */
    /* renamed from: com.google.android.exoplayer2.e.g.v$b */
    private class C4148b implements C2313r {
        /* renamed from: a */
        final /* synthetic */ C4149v f10752a;
        /* renamed from: b */
        private final C2528k f10753b = new C2528k(new byte[5]);
        /* renamed from: c */
        private final SparseArray<C2319w> f10754c = new SparseArray();
        /* renamed from: d */
        private final SparseIntArray f10755d = new SparseIntArray();
        /* renamed from: e */
        private final int f10756e;

        /* renamed from: a */
        public void mo2219a(C2537s c2537s, C2320g c2320g, C2318d c2318d) {
        }

        public C4148b(C4149v c4149v, int i) {
            this.f10752a = c4149v;
            this.f10756e = i;
        }

        /* renamed from: a */
        public void mo2218a(C2529l c2529l) {
            C4148b c4148b = this;
            C2529l c2529l2 = c2529l;
            if (c2529l.m7103g() == 2) {
                C2537s c2537s;
                int h;
                int i;
                int i2;
                int b;
                int c;
                int c2;
                int c3;
                C2316b a;
                Object a2;
                int size;
                C2319w c2319w;
                C4149v c4149v;
                int i3 = 0;
                if (!(c4148b.f10752a.f10761e == 1 || c4148b.f10752a.f10761e == 2)) {
                    if (c4148b.f10752a.f10769m != 1) {
                        c2537s = new C2537s(((C2537s) c4148b.f10752a.f10762f.get(0)).m7146a());
                        c4148b.f10752a.f10762f.add(c2537s);
                        c2529l2.m7098d(2);
                        h = c2529l.m7104h();
                        i = 5;
                        c2529l2.m7098d(5);
                        c2529l2.m7090a(c4148b.f10753b, 2);
                        i2 = 4;
                        c4148b.f10753b.m7078b(4);
                        c2529l2.m7098d(c4148b.f10753b.m7081c(12));
                        if (c4148b.f10752a.f10761e == 2 && c4148b.f10752a.f10771o == null) {
                            c4148b.f10752a.f10771o = c4148b.f10752a.f10765i.mo2214a(21, new C2316b(21, null, null, new byte[0]));
                            c4148b.f10752a.f10771o.mo2217a(c2537s, c4148b.f10752a.f10768l, new C2318d(h, 21, Utility.DEFAULT_STREAM_BUFFER_SIZE));
                        }
                        c4148b.f10754c.clear();
                        c4148b.f10755d.clear();
                        b = c2529l.m7093b();
                        while (b > 0) {
                            c2529l2.m7090a(c4148b.f10753b, i);
                            c = c4148b.f10753b.m7081c(8);
                            c4148b.f10753b.m7078b(3);
                            c2 = c4148b.f10753b.m7081c(13);
                            c4148b.f10753b.m7078b(i2);
                            c3 = c4148b.f10753b.m7081c(12);
                            a = m13171a(c2529l2, c3);
                            if (c == 6) {
                                c = a.f5747a;
                            }
                            b -= c3 + 5;
                            i2 = c4148b.f10752a.f10761e != 2 ? c : c2;
                            if (c4148b.f10752a.f10767k.get(i2)) {
                                if (c4148b.f10752a.f10761e == 2 || c != 21) {
                                    a2 = c4148b.f10752a.f10765i.mo2214a(c, a);
                                } else {
                                    a2 = c4148b.f10752a.f10771o;
                                }
                                if (c4148b.f10752a.f10761e == 2 || c2 < c4148b.f10755d.get(i2, Utility.DEFAULT_STREAM_BUFFER_SIZE)) {
                                    c4148b.f10755d.put(i2, c2);
                                    c4148b.f10754c.put(i2, a2);
                                }
                            }
                            i = 5;
                            i2 = 4;
                        }
                        size = c4148b.f10755d.size();
                        for (i = 0; i < size; i++) {
                            b = c4148b.f10755d.keyAt(i);
                            c4148b.f10752a.f10767k.put(b, true);
                            c2319w = (C2319w) c4148b.f10754c.valueAt(i);
                            if (c2319w == null) {
                                if (c2319w != c4148b.f10752a.f10771o) {
                                    c2319w.mo2217a(c2537s, c4148b.f10752a.f10768l, new C2318d(h, b, Utility.DEFAULT_STREAM_BUFFER_SIZE));
                                }
                                c4148b.f10752a.f10766j.put(c4148b.f10755d.valueAt(i), c2319w);
                            }
                        }
                        if (c4148b.f10752a.f10761e == 2) {
                            c4148b.f10752a.f10766j.remove(c4148b.f10756e);
                            c4149v = c4148b.f10752a;
                            if (c4148b.f10752a.f10761e == 1) {
                                i3 = c4148b.f10752a.f10769m - 1;
                            }
                            c4149v.f10769m = i3;
                            if (c4148b.f10752a.f10769m == 0) {
                                c4148b.f10752a.f10768l.mo2232a();
                                c4148b.f10752a.f10770n = true;
                            }
                        } else if (!c4148b.f10752a.f10770n) {
                            c4148b.f10752a.f10768l.mo2232a();
                            c4148b.f10752a.f10769m = 0;
                            c4148b.f10752a.f10770n = true;
                        }
                    }
                }
                c2537s = (C2537s) c4148b.f10752a.f10762f.get(0);
                c2529l2.m7098d(2);
                h = c2529l.m7104h();
                i = 5;
                c2529l2.m7098d(5);
                c2529l2.m7090a(c4148b.f10753b, 2);
                i2 = 4;
                c4148b.f10753b.m7078b(4);
                c2529l2.m7098d(c4148b.f10753b.m7081c(12));
                c4148b.f10752a.f10771o = c4148b.f10752a.f10765i.mo2214a(21, new C2316b(21, null, null, new byte[0]));
                c4148b.f10752a.f10771o.mo2217a(c2537s, c4148b.f10752a.f10768l, new C2318d(h, 21, Utility.DEFAULT_STREAM_BUFFER_SIZE));
                c4148b.f10754c.clear();
                c4148b.f10755d.clear();
                b = c2529l.m7093b();
                while (b > 0) {
                    c2529l2.m7090a(c4148b.f10753b, i);
                    c = c4148b.f10753b.m7081c(8);
                    c4148b.f10753b.m7078b(3);
                    c2 = c4148b.f10753b.m7081c(13);
                    c4148b.f10753b.m7078b(i2);
                    c3 = c4148b.f10753b.m7081c(12);
                    a = m13171a(c2529l2, c3);
                    if (c == 6) {
                        c = a.f5747a;
                    }
                    b -= c3 + 5;
                    if (c4148b.f10752a.f10761e != 2) {
                    }
                    if (c4148b.f10752a.f10767k.get(i2)) {
                        if (c4148b.f10752a.f10761e == 2) {
                        }
                        a2 = c4148b.f10752a.f10765i.mo2214a(c, a);
                        if (c4148b.f10752a.f10761e == 2) {
                        }
                        c4148b.f10755d.put(i2, c2);
                        c4148b.f10754c.put(i2, a2);
                    }
                    i = 5;
                    i2 = 4;
                }
                size = c4148b.f10755d.size();
                for (i = 0; i < size; i++) {
                    b = c4148b.f10755d.keyAt(i);
                    c4148b.f10752a.f10767k.put(b, true);
                    c2319w = (C2319w) c4148b.f10754c.valueAt(i);
                    if (c2319w == null) {
                        if (c2319w != c4148b.f10752a.f10771o) {
                            c2319w.mo2217a(c2537s, c4148b.f10752a.f10768l, new C2318d(h, b, Utility.DEFAULT_STREAM_BUFFER_SIZE));
                        }
                        c4148b.f10752a.f10766j.put(c4148b.f10755d.valueAt(i), c2319w);
                    }
                }
                if (c4148b.f10752a.f10761e == 2) {
                    c4148b.f10752a.f10766j.remove(c4148b.f10756e);
                    c4149v = c4148b.f10752a;
                    if (c4148b.f10752a.f10761e == 1) {
                        i3 = c4148b.f10752a.f10769m - 1;
                    }
                    c4149v.f10769m = i3;
                    if (c4148b.f10752a.f10769m == 0) {
                        c4148b.f10752a.f10768l.mo2232a();
                        c4148b.f10752a.f10770n = true;
                    }
                } else if (c4148b.f10752a.f10770n) {
                    c4148b.f10752a.f10768l.mo2232a();
                    c4148b.f10752a.f10769m = 0;
                    c4148b.f10752a.f10770n = true;
                }
            }
        }

        /* renamed from: a */
        private C2316b m13171a(C2529l c2529l, int i) {
            int d = c2529l.m7097d();
            i += d;
            String str = null;
            int i2 = -1;
            List list = null;
            while (c2529l.m7097d() < i) {
                int g = c2529l.m7103g();
                int d2 = c2529l.m7097d() + c2529l.m7103g();
                if (g == 5) {
                    long m = c2529l.m7109m();
                    if (m != C4149v.f10758b) {
                        if (m == C4149v.f10759c) {
                            i2 = 135;
                            c2529l.m7098d(d2 - c2529l.m7097d());
                        } else {
                            if (m == C4149v.f10760d) {
                                i2 = 36;
                            }
                            c2529l.m7098d(d2 - c2529l.m7097d());
                        }
                    }
                } else if (g != 106) {
                    if (g != 122) {
                        if (g == 123) {
                            i2 = 138;
                        } else if (g == 10) {
                            str = c2529l.m7100e(3).trim();
                        } else if (g == 89) {
                            List arrayList = new ArrayList();
                            while (c2529l.m7097d() < d2) {
                                String trim = c2529l.m7100e(3).trim();
                                g = c2529l.m7103g();
                                byte[] bArr = new byte[4];
                                c2529l.m7092a(bArr, 0, 4);
                                arrayList.add(new C2315a(trim, g, bArr));
                            }
                            list = arrayList;
                            i2 = 89;
                        }
                        c2529l.m7098d(d2 - c2529l.m7097d());
                    }
                    i2 = 135;
                    c2529l.m7098d(d2 - c2529l.m7097d());
                }
                i2 = 129;
                c2529l.m7098d(d2 - c2529l.m7097d());
            }
            c2529l.m7096c(i);
            return new C2316b(i2, str, list, Arrays.copyOfRange(c2529l.f6441a, d, i));
        }
    }

    /* renamed from: c */
    public void mo2166c() {
    }

    public C4149v() {
        this(0);
    }

    public C4149v(int i) {
        this(1, i);
    }

    public C4149v(int i, int i2) {
        this(i, new C2537s(0), new C4132e(i2));
    }

    public C4149v(int i, C2537s c2537s, C2317c c2317c) {
        this.f10765i = (C2317c) C2516a.m7015a((Object) c2317c);
        this.f10761e = i;
        if (i != 1) {
            if (i != 2) {
                this.f10762f = new ArrayList();
                this.f10762f.add(c2537s);
                this.f10763g = new C2529l(9400);
                this.f10767k = new SparseBooleanArray();
                this.f10766j = new SparseArray();
                this.f10764h = new SparseIntArray();
                m13185e();
            }
        }
        this.f10762f = Collections.singletonList(c2537s);
        this.f10763g = new C2529l(9400);
        this.f10767k = new SparseBooleanArray();
        this.f10766j = new SparseArray();
        this.f10764h = new SparseIntArray();
        m13185e();
    }

    /* renamed from: a */
    public boolean mo2165a(C2304f c2304f) {
        byte[] bArr = this.f10763g.f6441a;
        c2304f.mo2191c(bArr, 0, 940);
        int i = 0;
        while (i < 188) {
            int i2 = 0;
            while (i2 != 5) {
                if (bArr[(i2 * 188) + i] != (byte) 71) {
                    i++;
                } else {
                    i2++;
                }
            }
            c2304f.mo2186b(i);
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public void mo2164a(C2320g c2320g) {
        this.f10768l = c2320g;
        c2320g.mo2233a(new C4154a(-9223372036854775807L));
    }

    /* renamed from: a */
    public void mo2163a(long j, long j2) {
        j = this.f10762f.size();
        for (int i = 0; i < j; i++) {
            ((C2537s) this.f10762f.get(i)).m7152d();
        }
        this.f10763g.m7088a();
        this.f10764h.clear();
        m13185e();
    }

    /* renamed from: a */
    public int mo2162a(C2304f c2304f, C2326k c2326k) {
        int b;
        byte[] bArr = this.f10763g.f6441a;
        if (9400 - this.f10763g.m7097d() < 188) {
            b = this.f10763g.m7093b();
            if (b > 0) {
                System.arraycopy(bArr, this.f10763g.m7097d(), bArr, 0, b);
            }
            this.f10763g.m7091a(bArr, b);
        }
        while (this.f10763g.m7093b() < 188) {
            b = this.f10763g.m7095c();
            int a = c2304f.mo2182a(bArr, b, 9400 - b);
            if (a == -1) {
                return -1;
            }
            this.f10763g.m7094b(b + a);
        }
        c2304f = this.f10763g.m7095c();
        b = this.f10763g.m7097d();
        while (b < c2304f && bArr[b] != (byte) 71) {
            b++;
        }
        this.f10763g.m7096c(b);
        b += 188;
        if (b > c2304f) {
            return 0;
        }
        c2326k = this.f10763g.m7111o();
        if ((8388608 & c2326k) != 0) {
            this.f10763g.m7096c(b);
            return 0;
        }
        boolean z = (DefaultFlexByteArrayPoolParams.DEFAULT_MAX_BYTE_ARRAY_SIZE & c2326k) != 0;
        int i = (2096896 & c2326k) >> 8;
        Object obj = (c2326k & 32) != 0 ? 1 : null;
        C2319w c2319w = ((c2326k & 16) != 0 ? 1 : null) != null ? (C2319w) this.f10766j.get(i) : null;
        if (c2319w == null) {
            this.f10763g.m7096c(b);
            return 0;
        }
        if (this.f10761e != 2) {
            c2326k &= 15;
            int i2 = this.f10764h.get(i, c2326k - 1);
            this.f10764h.put(i, c2326k);
            if (i2 == c2326k) {
                this.f10763g.m7096c(b);
                return 0;
            } else if (c2326k != ((i2 + 1) & 15)) {
                c2319w.mo2215a();
            }
        }
        if (obj != null) {
            this.f10763g.m7098d(this.f10763g.m7103g());
        }
        this.f10763g.m7094b(b);
        c2319w.mo2216a(this.f10763g, z);
        this.f10763g.m7094b(c2304f);
        this.f10763g.m7096c(b);
        return 0;
    }

    /* renamed from: e */
    private void m13185e() {
        this.f10767k.clear();
        this.f10766j.clear();
        SparseArray a = this.f10765i.mo2213a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            this.f10766j.put(a.keyAt(i), a.valueAt(i));
        }
        this.f10766j.put(0, new C4144s(new C4147a(this)));
        this.f10771o = null;
    }
}
