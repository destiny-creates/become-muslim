package com.google.android.exoplayer2.p157i.p158a;

import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.facebook.imageutils.JfifUtil;
import com.facebook.stetho.server.http.HttpStatus;
import com.google.android.exoplayer2.p157i.C2458b;
import com.google.android.exoplayer2.p157i.C2464e;
import com.google.android.exoplayer2.p157i.C4726i;
import com.google.android.exoplayer2.p157i.C4727j;
import com.google.android.exoplayer2.p164l.C2529l;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Cea608Decoder */
/* renamed from: com.google.android.exoplayer2.i.a.a */
public final class C4857a extends C4724d {
    /* renamed from: a */
    private static final int[] f13853a = new int[]{11, 1, 3, 12, 14, 5, 7, 9};
    /* renamed from: b */
    private static final int[] f13854b = new int[]{0, 4, 8, 12, 16, 20, 24, 28};
    /* renamed from: c */
    private static final int[] f13855c = new int[]{-1, -16711936, -16776961, -16711681, -65536, -256, -65281};
    /* renamed from: d */
    private static final int[] f13856d = new int[]{32, 33, 34, 35, 36, 37, 38, 39, 40, 41, JfifUtil.MARKER_APP1, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632};
    /* renamed from: e */
    private static final int[] f13857e = new int[]{174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
    /* renamed from: f */
    private static final int[] f13858f = new int[]{193, 201, 211, JfifUtil.MARKER_SOS, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, JfifUtil.MARKER_SOFn, 194, 199, HttpStatus.HTTP_OK, 202, 203, 235, 206, 207, 239, 212, JfifUtil.MARKER_EOI, 249, 219, 171, 187};
    /* renamed from: g */
    private static final int[] f13859g = new int[]{195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, JfifUtil.MARKER_SOI, 248, 9484, 9488, 9492, 9496};
    /* renamed from: h */
    private final C2529l f13860h = new C2529l();
    /* renamed from: i */
    private final int f13861i;
    /* renamed from: j */
    private final int f13862j;
    /* renamed from: k */
    private final ArrayList<C2444a> f13863k = new ArrayList();
    /* renamed from: l */
    private C2444a f13864l = new C2444a(0, 4);
    /* renamed from: m */
    private List<C2458b> f13865m;
    /* renamed from: n */
    private List<C2458b> f13866n;
    /* renamed from: o */
    private int f13867o;
    /* renamed from: p */
    private int f13868p;
    /* renamed from: q */
    private boolean f13869q;
    /* renamed from: r */
    private byte f13870r;
    /* renamed from: s */
    private byte f13871s;

    /* compiled from: Cea608Decoder */
    /* renamed from: com.google.android.exoplayer2.i.a.a$a */
    private static class C2444a {
        /* renamed from: a */
        private final List<CharacterStyle> f6097a = new ArrayList();
        /* renamed from: b */
        private final List<C2443a> f6098b = new ArrayList();
        /* renamed from: c */
        private final List<SpannableString> f6099c = new ArrayList();
        /* renamed from: d */
        private final SpannableStringBuilder f6100d = new SpannableStringBuilder();
        /* renamed from: e */
        private int f6101e;
        /* renamed from: f */
        private int f6102f;
        /* renamed from: g */
        private int f6103g;
        /* renamed from: h */
        private int f6104h;
        /* renamed from: i */
        private int f6105i;
        /* renamed from: j */
        private int f6106j;

        /* compiled from: Cea608Decoder */
        /* renamed from: com.google.android.exoplayer2.i.a.a$a$a */
        private static class C2443a {
            /* renamed from: a */
            public final CharacterStyle f6094a;
            /* renamed from: b */
            public final int f6095b;
            /* renamed from: c */
            public final int f6096c;

            public C2443a(CharacterStyle characterStyle, int i, int i2) {
                this.f6094a = characterStyle;
                this.f6095b = i;
                this.f6096c = i2;
            }
        }

        public C2444a(int i, int i2) {
            m6733a(i);
            m6739b(i2);
        }

        /* renamed from: a */
        public void m6733a(int i) {
            this.f6104h = i;
            this.f6097a.clear();
            this.f6098b.clear();
            this.f6099c.clear();
            this.f6100d.clear();
            this.f6101e = 15;
            this.f6102f = 0;
            this.f6103g = 0;
            this.f6106j = -1;
        }

        /* renamed from: b */
        public void m6739b(int i) {
            this.f6105i = i;
        }

        /* renamed from: a */
        public boolean m6737a() {
            return this.f6097a.isEmpty() && this.f6098b.isEmpty() && this.f6099c.isEmpty() && this.f6100d.length() == 0;
        }

        /* renamed from: b */
        public void m6738b() {
            int length = this.f6100d.length();
            if (length > 0) {
                this.f6100d.delete(length - 1, length);
            }
        }

        /* renamed from: c */
        public int m6740c() {
            return this.f6101e;
        }

        /* renamed from: c */
        public void m6741c(int i) {
            this.f6101e = i;
        }

        /* renamed from: d */
        public void m6742d() {
            this.f6099c.add(m6744e());
            this.f6100d.clear();
            this.f6097a.clear();
            this.f6098b.clear();
            this.f6106j = -1;
            int min = Math.min(this.f6105i, this.f6101e);
            while (this.f6099c.size() >= min) {
                this.f6099c.remove(0);
            }
        }

        /* renamed from: d */
        public void m6743d(int i) {
            this.f6102f = i;
        }

        /* renamed from: e */
        public void m6745e(int i) {
            this.f6103g = i;
        }

        /* renamed from: a */
        public void m6734a(CharacterStyle characterStyle) {
            this.f6097a.add(characterStyle);
        }

        /* renamed from: a */
        public void m6735a(CharacterStyle characterStyle, int i) {
            this.f6098b.add(new C2443a(characterStyle, this.f6100d.length(), i));
        }

        /* renamed from: a */
        public void m6736a(boolean z) {
            if (z) {
                this.f6106j = this.f6100d.length();
            } else if (!this.f6106j) {
                this.f6100d.setSpan(new UnderlineSpan(), this.f6106j, this.f6100d.length(), 33);
                this.f6106j = -1;
            }
        }

        /* renamed from: a */
        public void m6732a(char c) {
            this.f6100d.append(c);
        }

        /* renamed from: e */
        public SpannableString m6744e() {
            int length = this.f6100d.length();
            int i = 0;
            for (int i2 = 0; i2 < this.f6097a.size(); i2++) {
                this.f6100d.setSpan(this.f6097a.get(i2), 0, length, 33);
            }
            while (i < this.f6098b.size()) {
                C2443a c2443a = (C2443a) this.f6098b.get(i);
                this.f6100d.setSpan(c2443a.f6094a, c2443a.f6095b, i < this.f6098b.size() - c2443a.f6096c ? ((C2443a) this.f6098b.get(c2443a.f6096c + i)).f6095b : length, 33);
                i++;
            }
            if (this.f6106j != -1) {
                this.f6100d.setSpan(new UnderlineSpan(), this.f6106j, length, 33);
            }
            return new SpannableString(this.f6100d);
        }

        /* renamed from: f */
        public C2458b m6746f() {
            int i;
            CharSequence spannableStringBuilder = new SpannableStringBuilder();
            for (i = 0; i < this.f6099c.size(); i++) {
                spannableStringBuilder.append((CharSequence) this.f6099c.get(i));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append(m6744e());
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            float f;
            int i2;
            int i3;
            i = this.f6102f + this.f6103g;
            int length = (32 - i) - spannableStringBuilder.length();
            int i4 = i - length;
            if (this.f6104h == 2 && (Math.abs(i4) < 3 || length < 0)) {
                f = 0.5f;
                i2 = 1;
            } else if (this.f6104h != 2 || i4 <= 0) {
                f = ((((float) i) / 32.0f) * 0.8f) + 0.1f;
                i2 = 0;
            } else {
                f = ((((float) (32 - length)) / 32.0f) * 0.8f) + 0.1f;
                i2 = 2;
            }
            if (this.f6104h != 1) {
                if (this.f6101e <= 7) {
                    i = this.f6101e;
                    i3 = 0;
                    return new C2458b(spannableStringBuilder, Alignment.ALIGN_NORMAL, (float) i, 1, i3, f, i2, Float.MIN_VALUE);
                }
            }
            i = (this.f6101e - 15) - 2;
            i3 = 2;
            return new C2458b(spannableStringBuilder, Alignment.ALIGN_NORMAL, (float) i, 1, i3, f, i2, Float.MIN_VALUE);
        }

        public String toString() {
            return this.f6100d.toString();
        }
    }

    /* renamed from: c */
    private static boolean m17313c(byte b, byte b2) {
        return (b & 247) == 17 && (b2 & 240) == 32;
    }

    /* renamed from: d */
    private static boolean m17315d(byte b, byte b2) {
        return (b & 240) == 16 && (b2 & JfifUtil.MARKER_SOFn) == 64;
    }

    /* renamed from: e */
    private static boolean m17317e(byte b, byte b2) {
        return (b & 247) == 23 && b2 >= Framer.ENTER_FRAME_PREFIX && b2 <= (byte) 35;
    }

    /* renamed from: f */
    private static boolean m17319f(byte b, byte b2) {
        return (b & 247) == 20 && (b2 & 240) == 32;
    }

    /* renamed from: g */
    private static boolean m17320g(byte b) {
        return (b & 240) == 16;
    }

    /* renamed from: d */
    public void mo2150d() {
    }

    /* renamed from: g */
    public /* bridge */ /* synthetic */ C4727j mo3428g() {
        return super.mo3428g();
    }

    /* renamed from: h */
    public /* bridge */ /* synthetic */ C4726i mo3429h() {
        return super.mo3429h();
    }

    public C4857a(String str, int i) {
        this.f13861i = "application/x-mp4-cea-608".equals(str) != null ? 2 : 3;
        switch (i) {
            case 3:
            case 4:
                this.f13862j = 2;
                break;
            default:
                this.f13862j = 1;
                break;
        }
        m17307a(0);
        m17322j();
    }

    /* renamed from: c */
    public void mo2149c() {
        super.mo2149c();
        this.f13865m = null;
        this.f13866n = null;
        m17307a(0);
        m17311b(4);
        m17322j();
        this.f13869q = false;
        this.f13870r = (byte) 0;
        this.f13871s = (byte) 0;
    }

    /* renamed from: e */
    protected boolean mo3426e() {
        return this.f13865m != this.f13866n;
    }

    /* renamed from: f */
    protected C2464e mo3427f() {
        this.f13866n = this.f13865m;
        return new C4224f(this.f13865m);
    }

    /* renamed from: a */
    protected void mo3424a(C4726i c4726i) {
        this.f13860h.m7091a(c4726i.b.array(), c4726i.b.limit());
        Object obj = null;
        boolean z = false;
        while (this.f13860h.m7093b() >= this.f13861i) {
            int i;
            if (this.f13861i == 2) {
                i = -4;
            } else {
                i = (byte) this.f13860h.m7103g();
            }
            byte g = (byte) (this.f13860h.m7103g() & 127);
            byte g2 = (byte) (this.f13860h.m7103g() & 127);
            if ((i & 6) == 4) {
                if (this.f13862j != 1 || (i & 1) == 0) {
                    if (this.f13862j != 2 || (i & 1) == 1) {
                        if (g != (byte) 0 || g2 != (byte) 0) {
                            if ((g & 247) == 17 && (g2 & 240) == 48) {
                                this.f13864l.m6732a(C4857a.m17314d(g2));
                            } else if ((g & 246) == 18 && (g2 & 224) == 32) {
                                this.f13864l.m6738b();
                                if ((g & 1) == 0) {
                                    this.f13864l.m6732a(C4857a.m17316e(g2));
                                } else {
                                    this.f13864l.m6732a(C4857a.m17318f(g2));
                                }
                            } else if ((g & 224) == 0) {
                                z = m17308a(g, g2);
                            } else {
                                this.f13864l.m6732a(C4857a.m17312c(g));
                                if ((g2 & 224) != 0) {
                                    this.f13864l.m6732a(C4857a.m17312c(g2));
                                }
                            }
                            obj = 1;
                        }
                    }
                }
            }
        }
        if (obj != null) {
            if (!z) {
                this.f13869q = null;
            }
            if (this.f13867o == 1 || this.f13867o == 3) {
                this.f13865m = m17321i();
            }
        }
    }

    /* renamed from: a */
    private boolean m17308a(byte b, byte b2) {
        boolean g = C4857a.m17320g(b);
        if (g) {
            if (this.f13869q && this.f13870r == b && this.f13871s == b2) {
                this.f13869q = false;
                return true;
            }
            this.f13869q = true;
            this.f13870r = b;
            this.f13871s = b2;
        }
        if (C4857a.m17313c(b, b2)) {
            m17306a(b2);
        } else if (C4857a.m17315d(b, b2)) {
            m17310b(b, b2);
        } else if (C4857a.m17317e(b, b2)) {
            this.f13864l.m6745e(b2 - 32);
        } else if (C4857a.m17319f(b, b2) != (byte) 0) {
            m17309b(b2);
        }
        return g;
    }

    /* renamed from: a */
    private void m17306a(byte b) {
        this.f13864l.m6736a((b & 1) == 1);
        b = (b >> (byte) 1) & 15;
        if (b == (byte) 7) {
            this.f13864l.m6735a(new StyleSpan(2), 2);
            this.f13864l.m6735a(new ForegroundColorSpan(-1), 1);
            return;
        }
        this.f13864l.m6735a(new ForegroundColorSpan(f13855c[b]), 1);
    }

    /* renamed from: b */
    private void m17310b(byte b, byte b2) {
        b = f13853a[b & (byte) 7];
        if (((b2 & 32) != 0 ? 1 : null) != null) {
            b++;
        }
        if (b != this.f13864l.m6740c()) {
            if (!(this.f13867o == 1 || this.f13864l.m6737a())) {
                this.f13864l = new C2444a(this.f13867o, this.f13868p);
                this.f13863k.add(this.f13864l);
            }
            this.f13864l.m6741c(b);
        }
        if ((b2 & 1) == (byte) 1) {
            this.f13864l.m6734a(new UnderlineSpan());
        }
        b = (b2 >> 1) & 15;
        if (b > (byte) 7) {
            this.f13864l.m6743d(f13854b[b & (byte) 7]);
        } else if (b == (byte) 7) {
            this.f13864l.m6734a(new StyleSpan(2));
            this.f13864l.m6734a(new ForegroundColorSpan(-1));
        } else {
            this.f13864l.m6734a(new ForegroundColorSpan(f13855c[b]));
        }
    }

    /* renamed from: b */
    private void m17309b(byte b) {
        if (b == (byte) 32) {
            m17307a(2);
        } else if (b != (byte) 41) {
            switch (b) {
                case (byte) 37:
                    m17307a(1);
                    m17311b(2);
                    return;
                case (byte) 38:
                    m17307a(1);
                    m17311b(3);
                    return;
                case (byte) 39:
                    m17307a(1);
                    m17311b((int) (byte) 4);
                    return;
                default:
                    if (this.f13867o != 0) {
                        if (b != Framer.ENTER_FRAME_PREFIX) {
                            if (b != (byte) 36) {
                                switch (b) {
                                    case (byte) 44:
                                        this.f13865m = (byte) 0;
                                        if (this.f13867o == (byte) 1 || this.f13867o == (byte) 3) {
                                            m17322j();
                                            break;
                                        }
                                    case (byte) 45:
                                        if (this.f13867o == (byte) 1 && this.f13864l.m6737a() == (byte) 0) {
                                            this.f13864l.m6742d();
                                            break;
                                        }
                                    case (byte) 46:
                                        m17322j();
                                        break;
                                    case (byte) 47:
                                        this.f13865m = m17321i();
                                        m17322j();
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                        this.f13864l.m6738b();
                        return;
                    }
                    return;
            }
        } else {
            m17307a(3);
        }
    }

    /* renamed from: i */
    private List<C2458b> m17321i() {
        List<C2458b> arrayList = new ArrayList();
        for (int i = 0; i < this.f13863k.size(); i++) {
            C2458b f = ((C2444a) this.f13863k.get(i)).m6746f();
            if (f != null) {
                arrayList.add(f);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m17307a(int i) {
        if (this.f13867o != i) {
            int i2 = this.f13867o;
            this.f13867o = i;
            m17322j();
            if (i2 == 3 || i == 1 || i == 0) {
                this.f13865m = 0;
            }
        }
    }

    /* renamed from: b */
    private void m17311b(int i) {
        this.f13868p = i;
        this.f13864l.m6739b(i);
    }

    /* renamed from: j */
    private void m17322j() {
        this.f13864l.m6733a(this.f13867o);
        this.f13863k.clear();
        this.f13863k.add(this.f13864l);
    }

    /* renamed from: c */
    private static char m17312c(byte b) {
        return (char) f13856d[(b & 127) - 32];
    }

    /* renamed from: d */
    private static char m17314d(byte b) {
        return (char) f13857e[b & 15];
    }

    /* renamed from: e */
    private static char m17316e(byte b) {
        return (char) f13858f[b & 31];
    }

    /* renamed from: f */
    private static char m17318f(byte b) {
        return (char) f13859g[b & 31];
    }
}
