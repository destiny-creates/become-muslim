package com.google.android.exoplayer2.p157i.p158a;

import android.graphics.Color;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.p157i.C2458b;
import com.google.android.exoplayer2.p157i.C2464e;
import com.google.android.exoplayer2.p157i.C4726i;
import com.google.android.exoplayer2.p157i.C4727j;
import com.google.android.exoplayer2.p164l.C2516a;
import com.google.android.exoplayer2.p164l.C2528k;
import com.google.android.exoplayer2.p164l.C2529l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* compiled from: Cea708Decoder */
/* renamed from: com.google.android.exoplayer2.i.a.c */
public final class C4858c extends C4724d {
    /* renamed from: a */
    private final C2529l f13872a = new C2529l();
    /* renamed from: b */
    private final C2528k f13873b = new C2528k();
    /* renamed from: c */
    private final int f13874c;
    /* renamed from: d */
    private final C2445a[] f13875d;
    /* renamed from: e */
    private C2445a f13876e;
    /* renamed from: f */
    private List<C2458b> f13877f;
    /* renamed from: g */
    private List<C2458b> f13878g;
    /* renamed from: h */
    private C2446b f13879h;
    /* renamed from: i */
    private int f13880i;

    /* compiled from: Cea708Decoder */
    /* renamed from: com.google.android.exoplayer2.i.a.c$a */
    private static final class C2445a {
        /* renamed from: a */
        public static final int f6107a = C2445a.m6747a(2, 2, 2, 0);
        /* renamed from: b */
        public static final int f6108b = C2445a.m6747a(0, 0, 0, 0);
        /* renamed from: c */
        public static final int f6109c = C2445a.m6747a(0, 0, 0, 3);
        /* renamed from: d */
        private static final int[] f6110d = new int[]{0, 0, 0, 0, 0, 2, 0};
        /* renamed from: e */
        private static final int[] f6111e = new int[]{0, 0, 0, 0, 0, 0, 2};
        /* renamed from: f */
        private static final int[] f6112f = new int[]{3, 3, 3, 3, 3, 3, 1};
        /* renamed from: g */
        private static final boolean[] f6113g = new boolean[]{false, false, false, true, true, true, false};
        /* renamed from: h */
        private static final int[] f6114h = new int[]{f6108b, f6109c, f6108b, f6108b, f6109c, f6108b, f6108b};
        /* renamed from: i */
        private static final int[] f6115i = new int[]{0, 1, 2, 3, 4, 3, 4};
        /* renamed from: j */
        private static final int[] f6116j = new int[]{0, 0, 0, 0, 0, 3, 3};
        /* renamed from: k */
        private static final int[] f6117k = new int[]{f6108b, f6108b, f6108b, f6108b, f6108b, f6109c, f6109c};
        /* renamed from: A */
        private int f6118A;
        /* renamed from: B */
        private int f6119B;
        /* renamed from: C */
        private int f6120C;
        /* renamed from: D */
        private int f6121D;
        /* renamed from: E */
        private int f6122E;
        /* renamed from: F */
        private int f6123F;
        /* renamed from: G */
        private int f6124G;
        /* renamed from: l */
        private final List<SpannableString> f6125l = new LinkedList();
        /* renamed from: m */
        private final SpannableStringBuilder f6126m = new SpannableStringBuilder();
        /* renamed from: n */
        private boolean f6127n;
        /* renamed from: o */
        private boolean f6128o;
        /* renamed from: p */
        private int f6129p;
        /* renamed from: q */
        private boolean f6130q;
        /* renamed from: r */
        private int f6131r;
        /* renamed from: s */
        private int f6132s;
        /* renamed from: t */
        private int f6133t;
        /* renamed from: u */
        private int f6134u;
        /* renamed from: v */
        private boolean f6135v;
        /* renamed from: w */
        private int f6136w;
        /* renamed from: x */
        private int f6137x;
        /* renamed from: y */
        private int f6138y;
        /* renamed from: z */
        private int f6139z;

        public C2445a() {
            m6757b();
        }

        /* renamed from: a */
        public boolean m6756a() {
            if (m6759d()) {
                if (!this.f6125l.isEmpty() || this.f6126m.length() != 0) {
                    return false;
                }
            }
            return true;
        }

        /* renamed from: b */
        public void m6757b() {
            m6758c();
            this.f6127n = false;
            this.f6128o = false;
            this.f6129p = 4;
            this.f6130q = false;
            this.f6131r = 0;
            this.f6132s = 0;
            this.f6133t = 0;
            this.f6134u = 15;
            this.f6135v = true;
            this.f6136w = 0;
            this.f6137x = 0;
            this.f6138y = 0;
            this.f6139z = f6108b;
            this.f6121D = f6107a;
            this.f6123F = f6108b;
        }

        /* renamed from: c */
        public void m6758c() {
            this.f6125l.clear();
            this.f6126m.clear();
            this.f6118A = -1;
            this.f6119B = -1;
            this.f6120C = -1;
            this.f6122E = -1;
            this.f6124G = 0;
        }

        /* renamed from: d */
        public boolean m6759d() {
            return this.f6127n;
        }

        /* renamed from: a */
        public void m6754a(boolean z) {
            this.f6128o = z;
        }

        /* renamed from: e */
        public boolean m6760e() {
            return this.f6128o;
        }

        /* renamed from: a */
        public void m6755a(boolean z, boolean z2, boolean z3, int i, boolean z4, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            boolean z5 = z2;
            int i9 = i7;
            int i10 = i8;
            this.f6127n = true;
            this.f6128o = z;
            this.f6135v = z5;
            this.f6129p = i;
            this.f6130q = z4;
            this.f6131r = i2;
            this.f6132s = i3;
            this.f6133t = i6;
            int i11 = i4 + 1;
            if (this.f6134u != i11) {
                r0.f6134u = i11;
                while (true) {
                    if ((!z5 || r0.f6125l.size() < r0.f6134u) && r0.f6125l.size() < 15) {
                        break;
                    }
                    r0.f6125l.remove(0);
                }
            }
            if (!(i9 == 0 || r0.f6137x == i9)) {
                r0.f6137x = i9;
                int i12 = i9 - 1;
                m6753a((int) f6114h[i12], (int) f6109c, f6113g[i12], (int) false, f6111e[i12], f6112f[i12], f6110d[i12]);
            }
            if (i10 != 0 && r0.f6138y != i10) {
                r0.f6138y = i10;
                i12 = i10 - 1;
                m6752a((int) false, (int) true, 1, false, false, f6116j[i12], f6115i[i12]);
                m6751a(f6107a, f6117k[i12], f6108b);
            }
        }

        /* renamed from: a */
        public void m6753a(int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
            this.f6139z = i;
            this.f6136w = i6;
        }

        /* renamed from: a */
        public void m6752a(int i, int i2, int i3, boolean z, boolean z2, int i4, int i5) {
            if (this.f6118A != -1) {
                if (!z) {
                    this.f6126m.setSpan(new StyleSpan(2), this.f6118A, this.f6126m.length(), 33);
                    this.f6118A = -1;
                }
            } else if (z) {
                this.f6118A = this.f6126m.length();
            }
            if (this.f6119B != -1) {
                if (!z2) {
                    this.f6126m.setSpan(new UnderlineSpan(), this.f6119B, this.f6126m.length(), 33);
                    this.f6119B = -1;
                }
            } else if (z2) {
                this.f6119B = this.f6126m.length();
            }
        }

        /* renamed from: a */
        public void m6751a(int i, int i2, int i3) {
            if (!(this.f6120C == -1 || this.f6121D == i)) {
                this.f6126m.setSpan(new ForegroundColorSpan(this.f6121D), this.f6120C, this.f6126m.length(), 33);
            }
            if (i != f6107a) {
                this.f6120C = this.f6126m.length();
                this.f6121D = i;
            }
            if (!(this.f6122E == -1 || this.f6123F == i2)) {
                this.f6126m.setSpan(new BackgroundColorSpan(this.f6123F), this.f6122E, this.f6126m.length(), 33);
            }
            if (i2 != f6108b) {
                this.f6122E = this.f6126m.length();
                this.f6123F = i2;
            }
        }

        /* renamed from: a */
        public void m6750a(int i, int i2) {
            if (this.f6124G != i) {
                m6749a((char) 10);
            }
            this.f6124G = i;
        }

        /* renamed from: f */
        public void m6761f() {
            int length = this.f6126m.length();
            if (length > 0) {
                this.f6126m.delete(length - 1, length);
            }
        }

        /* renamed from: a */
        public void m6749a(char c) {
            if (c == '\n') {
                this.f6125l.add(m6762g());
                this.f6126m.clear();
                if (this.f6118A != '￿') {
                    this.f6118A = 0;
                }
                if (this.f6119B != '￿') {
                    this.f6119B = 0;
                }
                if (this.f6120C != '￿') {
                    this.f6120C = 0;
                }
                if (this.f6122E != '￿') {
                    this.f6122E = 0;
                }
                while (true) {
                    if ((this.f6135v != '\u0000' && this.f6125l.size() >= this.f6134u) || this.f6125l.size() >= '\u000f') {
                        this.f6125l.remove(0);
                    } else {
                        return;
                    }
                }
            }
            this.f6126m.append(c);
        }

        /* renamed from: g */
        public SpannableString m6762g() {
            CharSequence spannableStringBuilder = new SpannableStringBuilder(this.f6126m);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.f6118A != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.f6118A, length, 33);
                }
                if (this.f6119B != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.f6119B, length, 33);
                }
                if (this.f6120C != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f6121D), this.f6120C, length, 33);
                }
                if (this.f6122E != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f6123F), this.f6122E, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        /* renamed from: h */
        public C4223b m6763h() {
            if (m6756a()) {
                return null;
            }
            Alignment alignment;
            float f;
            float f2;
            CharSequence spannableStringBuilder = new SpannableStringBuilder();
            for (int i = 0; i < this.f6125l.size(); i++) {
                spannableStringBuilder.append((CharSequence) this.f6125l.get(i));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append(m6762g());
            switch (this.f6136w) {
                case 0:
                case 3:
                    alignment = Alignment.ALIGN_NORMAL;
                    break;
                case 1:
                    alignment = Alignment.ALIGN_OPPOSITE;
                    break;
                case 2:
                    alignment = Alignment.ALIGN_CENTER;
                    break;
                default:
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unexpected justification value: ");
                    stringBuilder.append(this.f6136w);
                    throw new IllegalArgumentException(stringBuilder.toString());
            }
            Alignment alignment2 = alignment;
            if (this.f6130q) {
                f = ((float) this.f6132s) / 99.0f;
                f2 = ((float) this.f6131r) / 99.0f;
            } else {
                f = ((float) this.f6132s) / 209.0f;
                f2 = ((float) this.f6131r) / 74.0f;
            }
            float f3 = (f * 0.9f) + 0.05f;
            float f4 = (f2 * 0.9f) + 0.05f;
            int i2 = this.f6133t % 3 == 0 ? 0 : this.f6133t % 3 == 1 ? 1 : 2;
            int i3 = this.f6133t / 3 == 0 ? 0 : this.f6133t / 3 == 1 ? 1 : 2;
            return new C4223b(spannableStringBuilder, alignment2, f4, 0, i2, f3, i3, Float.MIN_VALUE, this.f6139z != f6108b, this.f6139z, this.f6129p);
        }

        /* renamed from: b */
        public static int m6748b(int i, int i2, int i3) {
            return C2445a.m6747a(i, i2, i3, 0);
        }

        /* renamed from: a */
        public static int m6747a(int i, int i2, int i3, int i4) {
            C2516a.m7014a(i, 0, 4);
            C2516a.m7014a(i2, 0, 4);
            C2516a.m7014a(i3, 0, 4);
            C2516a.m7014a(i4, 0, 4);
            int i5 = JfifUtil.MARKER_FIRST_BYTE;
            switch (i4) {
                case 2:
                    i4 = 127;
                    break;
                case 3:
                    i4 = 0;
                    break;
                default:
                    i4 = JfifUtil.MARKER_FIRST_BYTE;
                    break;
            }
            i = i > 1 ? JfifUtil.MARKER_FIRST_BYTE : 0;
            i2 = i2 > 1 ? JfifUtil.MARKER_FIRST_BYTE : 0;
            if (i3 <= 1) {
                i5 = 0;
            }
            return Color.argb(i4, i, i2, i5);
        }
    }

    /* compiled from: Cea708Decoder */
    /* renamed from: com.google.android.exoplayer2.i.a.c$b */
    private static final class C2446b {
        /* renamed from: a */
        public final int f6140a;
        /* renamed from: b */
        public final int f6141b;
        /* renamed from: c */
        public final byte[] f6142c;
        /* renamed from: d */
        int f6143d = 0;

        public C2446b(int i, int i2) {
            this.f6140a = i;
            this.f6141b = i2;
            this.f6142c = new byte[((i2 * 2) - 1)];
        }
    }

    /* renamed from: d */
    public /* bridge */ /* synthetic */ void mo2150d() {
        super.mo2150d();
    }

    /* renamed from: g */
    public /* bridge */ /* synthetic */ C4727j mo3428g() {
        return super.mo3428g();
    }

    /* renamed from: h */
    public /* bridge */ /* synthetic */ C4726i mo3429h() {
        return super.mo3429h();
    }

    public C4858c(int i) {
        if (i == -1) {
            i = 1;
        }
        this.f13874c = i;
        this.f13875d = new C2445a[8];
        for (int i2 = 0; i2 < 8; i2++) {
            this.f13875d[i2] = new C2445a();
        }
        this.f13876e = this.f13875d[0];
        m17348p();
    }

    /* renamed from: c */
    public void mo2149c() {
        super.mo2149c();
        this.f13877f = null;
        this.f13878g = null;
        this.f13880i = 0;
        this.f13876e = this.f13875d[this.f13880i];
        m17348p();
        this.f13879h = null;
    }

    /* renamed from: e */
    protected boolean mo3426e() {
        return this.f13877f != this.f13878g;
    }

    /* renamed from: f */
    protected C2464e mo3427f() {
        this.f13878g = this.f13877f;
        return new C4224f(this.f13877f);
    }

    /* renamed from: a */
    protected void mo3424a(C4726i c4726i) {
        this.f13872a.m7091a(c4726i.b.array(), c4726i.b.limit());
        while (this.f13872a.m7093b() >= 3) {
            c4726i = this.f13872a.m7103g() & 7;
            int i = c4726i & 3;
            boolean z = false;
            c4726i = (c4726i & 4) == 4 ? true : null;
            byte g = (byte) this.f13872a.m7103g();
            byte g2 = (byte) this.f13872a.m7103g();
            if (i == 2 || i == 3) {
                if (c4726i != null) {
                    C2446b c2446b;
                    if (i == 3) {
                        m17340i();
                        c4726i = (g & JfifUtil.MARKER_SOFn) >> 6;
                        int i2 = g & 63;
                        if (i2 == 0) {
                            i2 = 64;
                        }
                        this.f13879h = new C2446b(c4726i, i2);
                        c4726i = this.f13879h.f6142c;
                        c2446b = this.f13879h;
                        i = c2446b.f6143d;
                        c2446b.f6143d = i + 1;
                        c4726i[i] = g2;
                    } else {
                        if (i == 2) {
                            z = true;
                        }
                        C2516a.m7017a(z);
                        if (this.f13879h == null) {
                            Log.e("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            c4726i = this.f13879h.f6142c;
                            c2446b = this.f13879h;
                            i = c2446b.f6143d;
                            c2446b.f6143d = i + 1;
                            c4726i[i] = g;
                            c4726i = this.f13879h.f6142c;
                            c2446b = this.f13879h;
                            i = c2446b.f6143d;
                            c2446b.f6143d = i + 1;
                            c4726i[i] = g2;
                        }
                    }
                    if (this.f13879h.f6143d == (this.f13879h.f6141b * 2) - 1) {
                        m17340i();
                    }
                }
            }
        }
    }

    /* renamed from: i */
    private void m17340i() {
        if (this.f13879h != null) {
            m17342j();
            this.f13879h = null;
        }
    }

    /* renamed from: j */
    private void m17342j() {
        if (this.f13879h.f6143d != (this.f13879h.f6141b * 2) - 1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("DtvCcPacket ended prematurely; size is ");
            stringBuilder.append((this.f13879h.f6141b * 2) - 1);
            stringBuilder.append(", but current index is ");
            stringBuilder.append(this.f13879h.f6143d);
            stringBuilder.append(" (sequence number ");
            stringBuilder.append(this.f13879h.f6140a);
            stringBuilder.append("); ignoring packet");
            Log.w("Cea708Decoder", stringBuilder.toString());
            return;
        }
        this.f13873b.m7075a(this.f13879h.f6142c, this.f13879h.f6143d);
        int c = this.f13873b.m7081c(3);
        int c2 = this.f13873b.m7081c(5);
        if (c == 7) {
            this.f13873b.m7078b(2);
            c += this.f13873b.m7081c(6);
        }
        if (c2 == 0) {
            if (c != 0) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("serviceNumber is non-zero (");
                stringBuilder2.append(c);
                stringBuilder2.append(") when blockSize is 0");
                Log.w("Cea708Decoder", stringBuilder2.toString());
            }
        } else if (c == this.f13874c) {
            Object obj = null;
            while (this.f13873b.m7072a() > 0) {
                c2 = this.f13873b.m7081c(8);
                StringBuilder stringBuilder3;
                if (c2 == 16) {
                    c2 = this.f13873b.m7081c(8);
                    if (c2 <= 31) {
                        m17334c(c2);
                    } else if (c2 <= 127) {
                        m17338g(c2);
                    } else if (c2 <= 159) {
                        m17335d(c2);
                    } else if (c2 <= JfifUtil.MARKER_FIRST_BYTE) {
                        m17339h(c2);
                    } else {
                        stringBuilder3 = new StringBuilder();
                        stringBuilder3.append("Invalid extended command: ");
                        stringBuilder3.append(c2);
                        Log.w("Cea708Decoder", stringBuilder3.toString());
                    }
                } else if (c2 <= 31) {
                    m17332a(c2);
                } else if (c2 <= 127) {
                    m17336e(c2);
                } else if (c2 <= 159) {
                    m17333b(c2);
                } else if (c2 <= JfifUtil.MARKER_FIRST_BYTE) {
                    m17337f(c2);
                } else {
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("Invalid base command: ");
                    stringBuilder3.append(c2);
                    Log.w("Cea708Decoder", stringBuilder3.toString());
                }
                obj = 1;
            }
            if (obj != null) {
                this.f13877f = m17347o();
            }
        }
    }

    /* renamed from: a */
    private void m17332a(int i) {
        if (i == 0) {
            return;
        }
        if (i == 3) {
            this.f13877f = m17347o();
        } else if (i != 8) {
            switch (i) {
                case 12:
                    m17348p();
                    return;
                case 13:
                    this.f13876e.m6749a('\n');
                    return;
                case 14:
                    return;
                default:
                    if (i >= 17 && i <= 23) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Currently unsupported COMMAND_EXT1 Command: ");
                        stringBuilder.append(i);
                        Log.w("Cea708Decoder", stringBuilder.toString());
                        this.f13873b.m7078b(8);
                        return;
                    } else if (i < 24 || i > 31) {
                        r1 = new StringBuilder();
                        r1.append("Invalid C0 command: ");
                        r1.append(i);
                        Log.w("Cea708Decoder", r1.toString());
                        return;
                    } else {
                        r1 = new StringBuilder();
                        r1.append("Currently unsupported COMMAND_P16 Command: ");
                        r1.append(i);
                        Log.w("Cea708Decoder", r1.toString());
                        this.f13873b.m7078b(16);
                        return;
                    }
            }
        } else {
            this.f13876e.m6761f();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private void m17333b(int r5) {
        /*
        r4 = this;
        r0 = 16;
        r1 = 8;
        r2 = 1;
        switch(r5) {
            case 128: goto L_0x010c;
            case 129: goto L_0x010c;
            case 130: goto L_0x010c;
            case 131: goto L_0x010c;
            case 132: goto L_0x010c;
            case 133: goto L_0x010c;
            case 134: goto L_0x010c;
            case 135: goto L_0x010c;
            case 136: goto L_0x00f6;
            case 137: goto L_0x00df;
            case 138: goto L_0x00c8;
            case 139: goto L_0x00ac;
            case 140: goto L_0x0096;
            case 141: goto L_0x008f;
            case 142: goto L_0x011a;
            case 143: goto L_0x008a;
            case 144: goto L_0x0076;
            case 145: goto L_0x0060;
            case 146: goto L_0x004c;
            default: goto L_0x0008;
        };
    L_0x0008:
        switch(r5) {
            case 151: goto L_0x0036;
            case 152: goto L_0x0023;
            case 153: goto L_0x0023;
            case 154: goto L_0x0023;
            case 155: goto L_0x0023;
            case 156: goto L_0x0023;
            case 157: goto L_0x0023;
            case 158: goto L_0x0023;
            case 159: goto L_0x0023;
            default: goto L_0x000b;
        };
    L_0x000b:
        r0 = "Cea708Decoder";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Invalid C1 command: ";
        r1.append(r2);
        r1.append(r5);
        r5 = r1.toString();
        android.util.Log.w(r0, r5);
        goto L_0x011a;
    L_0x0023:
        r5 = r5 + -152;
        r4.m17341i(r5);
        r0 = r4.f13880i;
        if (r0 == r5) goto L_0x011a;
    L_0x002c:
        r4.f13880i = r5;
        r0 = r4.f13875d;
        r5 = r0[r5];
        r4.f13876e = r5;
        goto L_0x011a;
    L_0x0036:
        r5 = r4.f13876e;
        r5 = r5.m6759d();
        if (r5 != 0) goto L_0x0047;
    L_0x003e:
        r5 = r4.f13873b;
        r0 = 32;
        r5.m7078b(r0);
        goto L_0x011a;
    L_0x0047:
        r4.m17346n();
        goto L_0x011a;
    L_0x004c:
        r5 = r4.f13876e;
        r5 = r5.m6759d();
        if (r5 != 0) goto L_0x005b;
    L_0x0054:
        r5 = r4.f13873b;
        r5.m7078b(r0);
        goto L_0x011a;
    L_0x005b:
        r4.m17345m();
        goto L_0x011a;
    L_0x0060:
        r5 = r4.f13876e;
        r5 = r5.m6759d();
        if (r5 != 0) goto L_0x0071;
    L_0x0068:
        r5 = r4.f13873b;
        r0 = 24;
        r5.m7078b(r0);
        goto L_0x011a;
    L_0x0071:
        r4.m17344l();
        goto L_0x011a;
    L_0x0076:
        r5 = r4.f13876e;
        r5 = r5.m6759d();
        if (r5 != 0) goto L_0x0085;
    L_0x007e:
        r5 = r4.f13873b;
        r5.m7078b(r0);
        goto L_0x011a;
    L_0x0085:
        r4.m17343k();
        goto L_0x011a;
    L_0x008a:
        r4.m17348p();
        goto L_0x011a;
    L_0x008f:
        r5 = r4.f13873b;
        r5.m7078b(r1);
        goto L_0x011a;
    L_0x0096:
        if (r2 > r1) goto L_0x011a;
    L_0x0098:
        r5 = r4.f13873b;
        r5 = r5.m7084e();
        if (r5 == 0) goto L_0x00a9;
    L_0x00a0:
        r5 = r4.f13875d;
        r0 = 8 - r2;
        r5 = r5[r0];
        r5.m6757b();
    L_0x00a9:
        r2 = r2 + 1;
        goto L_0x0096;
    L_0x00ac:
        r5 = 1;
    L_0x00ad:
        if (r5 > r1) goto L_0x011a;
    L_0x00af:
        r0 = r4.f13873b;
        r0 = r0.m7084e();
        if (r0 == 0) goto L_0x00c5;
    L_0x00b7:
        r0 = r4.f13875d;
        r3 = 8 - r5;
        r0 = r0[r3];
        r3 = r0.m6760e();
        r3 = r3 ^ r2;
        r0.m6754a(r3);
    L_0x00c5:
        r5 = r5 + 1;
        goto L_0x00ad;
    L_0x00c8:
        if (r2 > r1) goto L_0x011a;
    L_0x00ca:
        r5 = r4.f13873b;
        r5 = r5.m7084e();
        if (r5 == 0) goto L_0x00dc;
    L_0x00d2:
        r5 = r4.f13875d;
        r0 = 8 - r2;
        r5 = r5[r0];
        r0 = 0;
        r5.m6754a(r0);
    L_0x00dc:
        r2 = r2 + 1;
        goto L_0x00c8;
    L_0x00df:
        r5 = 1;
    L_0x00e0:
        if (r5 > r1) goto L_0x011a;
    L_0x00e2:
        r0 = r4.f13873b;
        r0 = r0.m7084e();
        if (r0 == 0) goto L_0x00f3;
    L_0x00ea:
        r0 = r4.f13875d;
        r3 = 8 - r5;
        r0 = r0[r3];
        r0.m6754a(r2);
    L_0x00f3:
        r5 = r5 + 1;
        goto L_0x00e0;
    L_0x00f6:
        if (r2 > r1) goto L_0x011a;
    L_0x00f8:
        r5 = r4.f13873b;
        r5 = r5.m7084e();
        if (r5 == 0) goto L_0x0109;
    L_0x0100:
        r5 = r4.f13875d;
        r0 = 8 - r2;
        r5 = r5[r0];
        r5.m6758c();
    L_0x0109:
        r2 = r2 + 1;
        goto L_0x00f6;
    L_0x010c:
        r5 = r5 + -128;
        r0 = r4.f13880i;
        if (r0 == r5) goto L_0x011a;
    L_0x0112:
        r4.f13880i = r5;
        r0 = r4.f13875d;
        r5 = r0[r5];
        r4.f13876e = r5;
    L_0x011a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.i.a.c.b(int):void");
    }

    /* renamed from: c */
    private void m17334c(int i) {
        if (i > 7) {
            if (i <= 15) {
                this.f13873b.m7078b(8);
            } else if (i <= 23) {
                this.f13873b.m7078b(16);
            } else if (i <= 31) {
                this.f13873b.m7078b(24);
            }
        }
    }

    /* renamed from: d */
    private void m17335d(int i) {
        if (i <= 135) {
            this.f13873b.m7078b(32);
        } else if (i <= 143) {
            this.f13873b.m7078b(40);
        } else if (i <= 159) {
            this.f13873b.m7078b(2);
            this.f13873b.m7078b(this.f13873b.m7081c(6) * 8);
        }
    }

    /* renamed from: e */
    private void m17336e(int i) {
        if (i == 127) {
            this.f13876e.m6749a('♫');
        } else {
            this.f13876e.m6749a((char) (i & JfifUtil.MARKER_FIRST_BYTE));
        }
    }

    /* renamed from: f */
    private void m17337f(int i) {
        this.f13876e.m6749a((char) (i & JfifUtil.MARKER_FIRST_BYTE));
    }

    /* renamed from: g */
    private void m17338g(int i) {
        if (i == 37) {
            this.f13876e.m6749a('…');
        } else if (i == 42) {
            this.f13876e.m6749a('Š');
        } else if (i == 44) {
            this.f13876e.m6749a('Œ');
        } else if (i != 63) {
            switch (i) {
                case 32:
                    this.f13876e.m6749a(' ');
                    return;
                case 33:
                    this.f13876e.m6749a(' ');
                    return;
                default:
                    switch (i) {
                        case 48:
                            this.f13876e.m6749a('█');
                            return;
                        case 49:
                            this.f13876e.m6749a('‘');
                            return;
                        case 50:
                            this.f13876e.m6749a('’');
                            return;
                        case 51:
                            this.f13876e.m6749a('“');
                            return;
                        case 52:
                            this.f13876e.m6749a('”');
                            return;
                        case 53:
                            this.f13876e.m6749a('•');
                            return;
                        default:
                            switch (i) {
                                case 57:
                                    this.f13876e.m6749a('™');
                                    return;
                                case 58:
                                    this.f13876e.m6749a('š');
                                    return;
                                default:
                                    switch (i) {
                                        case 60:
                                            this.f13876e.m6749a('œ');
                                            return;
                                        case 61:
                                            this.f13876e.m6749a('℠');
                                            return;
                                        default:
                                            switch (i) {
                                                case 118:
                                                    this.f13876e.m6749a('⅛');
                                                    return;
                                                case 119:
                                                    this.f13876e.m6749a('⅜');
                                                    return;
                                                case 120:
                                                    this.f13876e.m6749a('⅝');
                                                    return;
                                                case 121:
                                                    this.f13876e.m6749a('⅞');
                                                    return;
                                                case 122:
                                                    this.f13876e.m6749a('│');
                                                    return;
                                                case 123:
                                                    this.f13876e.m6749a('┐');
                                                    return;
                                                case 124:
                                                    this.f13876e.m6749a('└');
                                                    return;
                                                case 125:
                                                    this.f13876e.m6749a('─');
                                                    return;
                                                case 126:
                                                    this.f13876e.m6749a('┘');
                                                    return;
                                                case 127:
                                                    this.f13876e.m6749a('┌');
                                                    return;
                                                default:
                                                    StringBuilder stringBuilder = new StringBuilder();
                                                    stringBuilder.append("Invalid G2 character: ");
                                                    stringBuilder.append(i);
                                                    Log.w("Cea708Decoder", stringBuilder.toString());
                                                    return;
                                            }
                                    }
                            }
                    }
            }
        } else {
            this.f13876e.m6749a('Ÿ');
        }
    }

    /* renamed from: h */
    private void m17339h(int i) {
        if (i == 160) {
            this.f13876e.m6749a('㏄');
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid G3 character: ");
        stringBuilder.append(i);
        Log.w("Cea708Decoder", stringBuilder.toString());
        this.f13876e.m6749a('_');
    }

    /* renamed from: k */
    private void m17343k() {
        this.f13876e.m6752a(this.f13873b.m7081c(4), this.f13873b.m7081c(2), this.f13873b.m7081c(2), this.f13873b.m7084e(), this.f13873b.m7084e(), this.f13873b.m7081c(3), this.f13873b.m7081c(3));
    }

    /* renamed from: l */
    private void m17344l() {
        int a = C2445a.m6747a(this.f13873b.m7081c(2), this.f13873b.m7081c(2), this.f13873b.m7081c(2), this.f13873b.m7081c(2));
        int a2 = C2445a.m6747a(this.f13873b.m7081c(2), this.f13873b.m7081c(2), this.f13873b.m7081c(2), this.f13873b.m7081c(2));
        this.f13873b.m7078b(2);
        this.f13876e.m6751a(a, a2, C2445a.m6748b(this.f13873b.m7081c(2), this.f13873b.m7081c(2), this.f13873b.m7081c(2)));
    }

    /* renamed from: m */
    private void m17345m() {
        this.f13873b.m7078b(4);
        int c = this.f13873b.m7081c(4);
        this.f13873b.m7078b(2);
        this.f13876e.m6750a(c, this.f13873b.m7081c(6));
    }

    /* renamed from: n */
    private void m17346n() {
        int a = C2445a.m6747a(this.f13873b.m7081c(2), this.f13873b.m7081c(2), this.f13873b.m7081c(2), this.f13873b.m7081c(2));
        int c = this.f13873b.m7081c(2);
        int b = C2445a.m6748b(this.f13873b.m7081c(2), this.f13873b.m7081c(2), this.f13873b.m7081c(2));
        if (this.f13873b.m7084e()) {
            c |= 4;
        }
        int i = c;
        boolean e = this.f13873b.m7084e();
        int c2 = this.f13873b.m7081c(2);
        int c3 = this.f13873b.m7081c(2);
        int c4 = this.f13873b.m7081c(2);
        this.f13873b.m7078b(8);
        this.f13876e.m6753a(a, b, e, i, c2, c3, c4);
    }

    /* renamed from: i */
    private void m17341i(int i) {
        C2445a c2445a = this.f13875d[i];
        this.f13873b.m7078b(2);
        boolean e = this.f13873b.m7084e();
        boolean e2 = this.f13873b.m7084e();
        boolean e3 = this.f13873b.m7084e();
        i = this.f13873b.m7081c(3);
        boolean e4 = this.f13873b.m7084e();
        int c = this.f13873b.m7081c(7);
        int c2 = this.f13873b.m7081c(8);
        int c3 = this.f13873b.m7081c(4);
        int c4 = this.f13873b.m7081c(4);
        this.f13873b.m7078b(2);
        int c5 = this.f13873b.m7081c(6);
        this.f13873b.m7078b(2);
        c2445a.m6755a(e, e2, e3, i, e4, c, c2, c4, c5, c3, this.f13873b.m7081c(3), this.f13873b.m7081c(3));
    }

    /* renamed from: o */
    private List<C2458b> m17347o() {
        List arrayList = new ArrayList();
        int i = 0;
        while (i < 8) {
            if (!this.f13875d[i].m6756a() && this.f13875d[i].m6760e()) {
                arrayList.add(this.f13875d[i].m6763h());
            }
            i++;
        }
        Collections.sort(arrayList);
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: p */
    private void m17348p() {
        for (int i = 0; i < 8; i++) {
            this.f13875d[i].m6757b();
        }
    }
}
