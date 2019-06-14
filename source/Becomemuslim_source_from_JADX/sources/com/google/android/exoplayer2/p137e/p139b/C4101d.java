package com.google.android.exoplayer2.p137e.p139b;

import android.support.v7.widget.LinearLayoutManager;
import android.util.SparseArray;
import com.facebook.imageutils.JfifUtil;
import com.facebook.stetho.server.http.HttpStatus;
import com.google.android.exoplayer2.C2251b;
import com.google.android.exoplayer2.C2571p;
import com.google.android.exoplayer2.p136c.C2255a;
import com.google.android.exoplayer2.p136c.C2255a.C2254a;
import com.google.android.exoplayer2.p137e.C2303e;
import com.google.android.exoplayer2.p137e.C2304f;
import com.google.android.exoplayer2.p137e.C2320g;
import com.google.android.exoplayer2.p137e.C2323h;
import com.google.android.exoplayer2.p137e.C2326k;
import com.google.android.exoplayer2.p137e.C2327l;
import com.google.android.exoplayer2.p137e.C2327l.C4154a;
import com.google.android.exoplayer2.p137e.C2329m;
import com.google.android.exoplayer2.p137e.C2329m.C2328a;
import com.google.android.exoplayer2.p137e.C4097a;
import com.google.android.exoplayer2.p164l.C2522g;
import com.google.android.exoplayer2.p164l.C2527j;
import com.google.android.exoplayer2.p164l.C2529l;
import com.google.android.exoplayer2.p164l.C2541v;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;

/* compiled from: MatroskaExtractor */
/* renamed from: com.google.android.exoplayer2.e.b.d */
public final class C4101d implements C2303e {
    /* renamed from: a */
    public static final C2323h f10393a = new C40991();
    /* renamed from: b */
    private static final byte[] f10394b = new byte[]{Framer.STDOUT_FRAME_PREFIX, (byte) 10, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 44, (byte) 48, (byte) 48, (byte) 48, (byte) 32, Framer.STDIN_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX, (byte) 62, (byte) 32, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 44, (byte) 48, (byte) 48, (byte) 48, (byte) 10};
    /* renamed from: c */
    private static final byte[] f10395c = new byte[]{(byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32};
    /* renamed from: d */
    private static final byte[] f10396d = C2541v.m7188c("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    /* renamed from: e */
    private static final byte[] f10397e = new byte[]{(byte) 68, (byte) 105, (byte) 97, (byte) 108, (byte) 111, (byte) 103, (byte) 117, (byte) 101, (byte) 58, (byte) 32, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 44, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 44};
    /* renamed from: f */
    private static final byte[] f10398f = new byte[]{(byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32};
    /* renamed from: g */
    private static final UUID f10399g = new UUID(72057594037932032L, -9223371306706625679L);
    /* renamed from: A */
    private C2265b f10400A;
    /* renamed from: B */
    private boolean f10401B;
    /* renamed from: C */
    private int f10402C;
    /* renamed from: D */
    private long f10403D;
    /* renamed from: E */
    private boolean f10404E;
    /* renamed from: F */
    private long f10405F;
    /* renamed from: G */
    private long f10406G;
    /* renamed from: H */
    private long f10407H;
    /* renamed from: I */
    private C2522g f10408I;
    /* renamed from: J */
    private C2522g f10409J;
    /* renamed from: K */
    private boolean f10410K;
    /* renamed from: L */
    private int f10411L;
    /* renamed from: M */
    private long f10412M;
    /* renamed from: N */
    private long f10413N;
    /* renamed from: O */
    private int f10414O;
    /* renamed from: P */
    private int f10415P;
    /* renamed from: Q */
    private int[] f10416Q;
    /* renamed from: R */
    private int f10417R;
    /* renamed from: S */
    private int f10418S;
    /* renamed from: T */
    private int f10419T;
    /* renamed from: U */
    private int f10420U;
    /* renamed from: V */
    private boolean f10421V;
    /* renamed from: W */
    private boolean f10422W;
    /* renamed from: X */
    private boolean f10423X;
    /* renamed from: Y */
    private boolean f10424Y;
    /* renamed from: Z */
    private byte f10425Z;
    private int aa;
    private int ab;
    private int ac;
    private boolean ad;
    private boolean ae;
    private C2320g af;
    /* renamed from: h */
    private final C2263b f10426h;
    /* renamed from: i */
    private final C2267f f10427i;
    /* renamed from: j */
    private final SparseArray<C2265b> f10428j;
    /* renamed from: k */
    private final boolean f10429k;
    /* renamed from: l */
    private final C2529l f10430l;
    /* renamed from: m */
    private final C2529l f10431m;
    /* renamed from: n */
    private final C2529l f10432n;
    /* renamed from: o */
    private final C2529l f10433o;
    /* renamed from: p */
    private final C2529l f10434p;
    /* renamed from: q */
    private final C2529l f10435q;
    /* renamed from: r */
    private final C2529l f10436r;
    /* renamed from: s */
    private final C2529l f10437s;
    /* renamed from: t */
    private final C2529l f10438t;
    /* renamed from: u */
    private ByteBuffer f10439u;
    /* renamed from: v */
    private long f10440v;
    /* renamed from: w */
    private long f10441w;
    /* renamed from: x */
    private long f10442x;
    /* renamed from: y */
    private long f10443y;
    /* renamed from: z */
    private long f10444z;

    /* compiled from: MatroskaExtractor */
    /* renamed from: com.google.android.exoplayer2.e.b.d$b */
    private static final class C2265b {
        /* renamed from: A */
        public float f5393A;
        /* renamed from: B */
        public float f5394B;
        /* renamed from: C */
        public float f5395C;
        /* renamed from: D */
        public float f5396D;
        /* renamed from: E */
        public float f5397E;
        /* renamed from: F */
        public float f5398F;
        /* renamed from: G */
        public int f5399G;
        /* renamed from: H */
        public int f5400H;
        /* renamed from: I */
        public int f5401I;
        /* renamed from: J */
        public long f5402J;
        /* renamed from: K */
        public long f5403K;
        /* renamed from: L */
        public boolean f5404L;
        /* renamed from: M */
        public boolean f5405M;
        /* renamed from: N */
        public C2329m f5406N;
        /* renamed from: O */
        public int f5407O;
        /* renamed from: P */
        private String f5408P;
        /* renamed from: a */
        public String f5409a;
        /* renamed from: b */
        public int f5410b;
        /* renamed from: c */
        public int f5411c;
        /* renamed from: d */
        public int f5412d;
        /* renamed from: e */
        public boolean f5413e;
        /* renamed from: f */
        public byte[] f5414f;
        /* renamed from: g */
        public C2328a f5415g;
        /* renamed from: h */
        public byte[] f5416h;
        /* renamed from: i */
        public C2255a f5417i;
        /* renamed from: j */
        public int f5418j;
        /* renamed from: k */
        public int f5419k;
        /* renamed from: l */
        public int f5420l;
        /* renamed from: m */
        public int f5421m;
        /* renamed from: n */
        public int f5422n;
        /* renamed from: o */
        public byte[] f5423o;
        /* renamed from: p */
        public int f5424p;
        /* renamed from: q */
        public boolean f5425q;
        /* renamed from: r */
        public int f5426r;
        /* renamed from: s */
        public int f5427s;
        /* renamed from: t */
        public int f5428t;
        /* renamed from: u */
        public int f5429u;
        /* renamed from: v */
        public int f5430v;
        /* renamed from: w */
        public float f5431w;
        /* renamed from: x */
        public float f5432x;
        /* renamed from: y */
        public float f5433y;
        /* renamed from: z */
        public float f5434z;

        private C2265b() {
            this.f5418j = -1;
            this.f5419k = -1;
            this.f5420l = -1;
            this.f5421m = -1;
            this.f5422n = 0;
            this.f5423o = null;
            this.f5424p = -1;
            this.f5425q = false;
            this.f5426r = -1;
            this.f5427s = -1;
            this.f5428t = -1;
            this.f5429u = 1000;
            this.f5430v = HttpStatus.HTTP_OK;
            this.f5431w = -1.0f;
            this.f5432x = -1.0f;
            this.f5433y = -1.0f;
            this.f5434z = -1.0f;
            this.f5393A = -1.0f;
            this.f5394B = -1.0f;
            this.f5395C = -1.0f;
            this.f5396D = -1.0f;
            this.f5397E = -1.0f;
            this.f5398F = -1.0f;
            this.f5399G = 1;
            this.f5400H = -1;
            this.f5401I = 8000;
            this.f5402J = 0;
            this.f5403K = 0;
            this.f5405M = true;
            this.f5408P = "eng";
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public void m6261a(com.google.android.exoplayer2.p137e.C2320g r27, int r28) {
            /*
            r26 = this;
            r0 = r26;
            r1 = r0.f5409a;
            r2 = r1.hashCode();
            r3 = 4;
            r4 = 8;
            r5 = 1;
            r6 = 0;
            r7 = 2;
            r8 = 3;
            r9 = -1;
            switch(r2) {
                case -2095576542: goto L_0x0156;
                case -2095575984: goto L_0x014c;
                case -1985379776: goto L_0x0141;
                case -1784763192: goto L_0x0136;
                case -1730367663: goto L_0x012b;
                case -1482641358: goto L_0x0120;
                case -1482641357: goto L_0x0115;
                case -1373388978: goto L_0x010a;
                case -933872740: goto L_0x00ff;
                case -538363189: goto L_0x00f4;
                case -538363109: goto L_0x00e9;
                case -425012669: goto L_0x00dd;
                case -356037306: goto L_0x00d1;
                case 62923557: goto L_0x00c5;
                case 62923603: goto L_0x00b9;
                case 62927045: goto L_0x00ad;
                case 82338133: goto L_0x00a2;
                case 82338134: goto L_0x0097;
                case 99146302: goto L_0x008b;
                case 444813526: goto L_0x007f;
                case 542569478: goto L_0x0073;
                case 725957860: goto L_0x0067;
                case 738597099: goto L_0x005b;
                case 855502857: goto L_0x0050;
                case 1422270023: goto L_0x0044;
                case 1809237540: goto L_0x0039;
                case 1950749482: goto L_0x002d;
                case 1950789798: goto L_0x0021;
                case 1951062397: goto L_0x0015;
                default: goto L_0x0013;
            };
        L_0x0013:
            goto L_0x0160;
        L_0x0015:
            r2 = "A_OPUS";
            r1 = r1.equals(r2);
            if (r1 == 0) goto L_0x0160;
        L_0x001d:
            r1 = 11;
            goto L_0x0161;
        L_0x0021:
            r2 = "A_FLAC";
            r1 = r1.equals(r2);
            if (r1 == 0) goto L_0x0160;
        L_0x0029:
            r1 = 21;
            goto L_0x0161;
        L_0x002d:
            r2 = "A_EAC3";
            r1 = r1.equals(r2);
            if (r1 == 0) goto L_0x0160;
        L_0x0035:
            r1 = 16;
            goto L_0x0161;
        L_0x0039:
            r2 = "V_MPEG2";
            r1 = r1.equals(r2);
            if (r1 == 0) goto L_0x0160;
        L_0x0041:
            r1 = 2;
            goto L_0x0161;
        L_0x0044:
            r2 = "S_TEXT/UTF8";
            r1 = r1.equals(r2);
            if (r1 == 0) goto L_0x0160;
        L_0x004c:
            r1 = 24;
            goto L_0x0161;
        L_0x0050:
            r2 = "V_MPEGH/ISO/HEVC";
            r1 = r1.equals(r2);
            if (r1 == 0) goto L_0x0160;
        L_0x0058:
            r1 = 7;
            goto L_0x0161;
        L_0x005b:
            r2 = "S_TEXT/ASS";
            r1 = r1.equals(r2);
            if (r1 == 0) goto L_0x0160;
        L_0x0063:
            r1 = 25;
            goto L_0x0161;
        L_0x0067:
            r2 = "A_PCM/INT/LIT";
            r1 = r1.equals(r2);
            if (r1 == 0) goto L_0x0160;
        L_0x006f:
            r1 = 23;
            goto L_0x0161;
        L_0x0073:
            r2 = "A_DTS/EXPRESS";
            r1 = r1.equals(r2);
            if (r1 == 0) goto L_0x0160;
        L_0x007b:
            r1 = 19;
            goto L_0x0161;
        L_0x007f:
            r2 = "V_THEORA";
            r1 = r1.equals(r2);
            if (r1 == 0) goto L_0x0160;
        L_0x0087:
            r1 = 9;
            goto L_0x0161;
        L_0x008b:
            r2 = "S_HDMV/PGS";
            r1 = r1.equals(r2);
            if (r1 == 0) goto L_0x0160;
        L_0x0093:
            r1 = 27;
            goto L_0x0161;
        L_0x0097:
            r2 = "V_VP9";
            r1 = r1.equals(r2);
            if (r1 == 0) goto L_0x0160;
        L_0x009f:
            r1 = 1;
            goto L_0x0161;
        L_0x00a2:
            r2 = "V_VP8";
            r1 = r1.equals(r2);
            if (r1 == 0) goto L_0x0160;
        L_0x00aa:
            r1 = 0;
            goto L_0x0161;
        L_0x00ad:
            r2 = "A_DTS";
            r1 = r1.equals(r2);
            if (r1 == 0) goto L_0x0160;
        L_0x00b5:
            r1 = 18;
            goto L_0x0161;
        L_0x00b9:
            r2 = "A_AC3";
            r1 = r1.equals(r2);
            if (r1 == 0) goto L_0x0160;
        L_0x00c1:
            r1 = 15;
            goto L_0x0161;
        L_0x00c5:
            r2 = "A_AAC";
            r1 = r1.equals(r2);
            if (r1 == 0) goto L_0x0160;
        L_0x00cd:
            r1 = 12;
            goto L_0x0161;
        L_0x00d1:
            r2 = "A_DTS/LOSSLESS";
            r1 = r1.equals(r2);
            if (r1 == 0) goto L_0x0160;
        L_0x00d9:
            r1 = 20;
            goto L_0x0161;
        L_0x00dd:
            r2 = "S_VOBSUB";
            r1 = r1.equals(r2);
            if (r1 == 0) goto L_0x0160;
        L_0x00e5:
            r1 = 26;
            goto L_0x0161;
        L_0x00e9:
            r2 = "V_MPEG4/ISO/AVC";
            r1 = r1.equals(r2);
            if (r1 == 0) goto L_0x0160;
        L_0x00f1:
            r1 = 6;
            goto L_0x0161;
        L_0x00f4:
            r2 = "V_MPEG4/ISO/ASP";
            r1 = r1.equals(r2);
            if (r1 == 0) goto L_0x0160;
        L_0x00fc:
            r1 = 4;
            goto L_0x0161;
        L_0x00ff:
            r2 = "S_DVBSUB";
            r1 = r1.equals(r2);
            if (r1 == 0) goto L_0x0160;
        L_0x0107:
            r1 = 28;
            goto L_0x0161;
        L_0x010a:
            r2 = "V_MS/VFW/FOURCC";
            r1 = r1.equals(r2);
            if (r1 == 0) goto L_0x0160;
        L_0x0112:
            r1 = 8;
            goto L_0x0161;
        L_0x0115:
            r2 = "A_MPEG/L3";
            r1 = r1.equals(r2);
            if (r1 == 0) goto L_0x0160;
        L_0x011d:
            r1 = 14;
            goto L_0x0161;
        L_0x0120:
            r2 = "A_MPEG/L2";
            r1 = r1.equals(r2);
            if (r1 == 0) goto L_0x0160;
        L_0x0128:
            r1 = 13;
            goto L_0x0161;
        L_0x012b:
            r2 = "A_VORBIS";
            r1 = r1.equals(r2);
            if (r1 == 0) goto L_0x0160;
        L_0x0133:
            r1 = 10;
            goto L_0x0161;
        L_0x0136:
            r2 = "A_TRUEHD";
            r1 = r1.equals(r2);
            if (r1 == 0) goto L_0x0160;
        L_0x013e:
            r1 = 17;
            goto L_0x0161;
        L_0x0141:
            r2 = "A_MS/ACM";
            r1 = r1.equals(r2);
            if (r1 == 0) goto L_0x0160;
        L_0x0149:
            r1 = 22;
            goto L_0x0161;
        L_0x014c:
            r2 = "V_MPEG4/ISO/SP";
            r1 = r1.equals(r2);
            if (r1 == 0) goto L_0x0160;
        L_0x0154:
            r1 = 3;
            goto L_0x0161;
        L_0x0156:
            r2 = "V_MPEG4/ISO/AP";
            r1 = r1.equals(r2);
            if (r1 == 0) goto L_0x0160;
        L_0x015e:
            r1 = 5;
            goto L_0x0161;
        L_0x0160:
            r1 = -1;
        L_0x0161:
            r2 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
            r10 = 0;
            switch(r1) {
                case 0: goto L_0x031d;
                case 1: goto L_0x031a;
                case 2: goto L_0x0317;
                case 3: goto L_0x0306;
                case 4: goto L_0x0306;
                case 5: goto L_0x0306;
                case 6: goto L_0x02f0;
                case 7: goto L_0x02dc;
                case 8: goto L_0x02bd;
                case 9: goto L_0x02ba;
                case 10: goto L_0x02aa;
                case 11: goto L_0x0264;
                case 12: goto L_0x0259;
                case 13: goto L_0x0251;
                case 14: goto L_0x024e;
                case 15: goto L_0x024a;
                case 16: goto L_0x0246;
                case 17: goto L_0x0242;
                case 18: goto L_0x023e;
                case 19: goto L_0x023e;
                case 20: goto L_0x023a;
                case 21: goto L_0x0231;
                case 22: goto L_0x01dc;
                case 23: goto L_0x01a7;
                case 24: goto L_0x01a3;
                case 25: goto L_0x019f;
                case 26: goto L_0x0195;
                case 27: goto L_0x0191;
                case 28: goto L_0x016f;
                default: goto L_0x0167;
            };
        L_0x0167:
            r1 = new com.google.android.exoplayer2.p;
            r2 = "Unrecognized codec identifier.";
            r1.<init>(r2);
            throw r1;
        L_0x016f:
            r1 = "application/dvbsubs";
            r2 = new byte[r3];
            r3 = r0.f5416h;
            r3 = r3[r6];
            r2[r6] = r3;
            r3 = r0.f5416h;
            r3 = r3[r5];
            r2[r5] = r3;
            r3 = r0.f5416h;
            r3 = r3[r7];
            r2[r7] = r3;
            r3 = r0.f5416h;
            r3 = r3[r8];
            r2[r8] = r3;
            r2 = java.util.Collections.singletonList(r2);
            goto L_0x0261;
        L_0x0191:
            r1 = "application/pgs";
            goto L_0x031f;
        L_0x0195:
            r1 = "application/vobsub";
            r2 = r0.f5416h;
            r2 = java.util.Collections.singletonList(r2);
            goto L_0x0261;
        L_0x019f:
            r1 = "text/x-ssa";
            goto L_0x031f;
        L_0x01a3:
            r1 = "application/x-subrip";
            goto L_0x031f;
        L_0x01a7:
            r1 = "audio/raw";
            r2 = r0.f5400H;
            r2 = com.google.android.exoplayer2.p164l.C2541v.m7182b(r2);
            if (r2 != 0) goto L_0x01d5;
        L_0x01b1:
            r1 = "audio/x-unknown";
            r2 = "MatroskaExtractor";
            r3 = new java.lang.StringBuilder;
            r3.<init>();
            r4 = "Unsupported PCM bit depth: ";
            r3.append(r4);
            r4 = r0.f5400H;
            r3.append(r4);
            r4 = ". Setting mimeType to ";
            r3.append(r4);
            r3.append(r1);
            r3 = r3.toString();
            android.util.Log.w(r2, r3);
            goto L_0x031f;
        L_0x01d5:
            r12 = r1;
            r18 = r2;
            r2 = r10;
            r15 = -1;
            goto L_0x0324;
        L_0x01dc:
            r1 = "audio/raw";
            r2 = new com.google.android.exoplayer2.l.l;
            r3 = r0.f5416h;
            r2.<init>(r3);
            r2 = com.google.android.exoplayer2.p137e.p139b.C4101d.C2265b.m6260b(r2);
            if (r2 == 0) goto L_0x0217;
        L_0x01eb:
            r2 = r0.f5400H;
            r2 = com.google.android.exoplayer2.p164l.C2541v.m7182b(r2);
            if (r2 != 0) goto L_0x01d5;
        L_0x01f3:
            r1 = "audio/x-unknown";
            r2 = "MatroskaExtractor";
            r3 = new java.lang.StringBuilder;
            r3.<init>();
            r4 = "Unsupported PCM bit depth: ";
            r3.append(r4);
            r4 = r0.f5400H;
            r3.append(r4);
            r4 = ". Setting mimeType to ";
            r3.append(r4);
            r3.append(r1);
            r3 = r3.toString();
            android.util.Log.w(r2, r3);
            goto L_0x031f;
        L_0x0217:
            r1 = "audio/x-unknown";
            r2 = "MatroskaExtractor";
            r3 = new java.lang.StringBuilder;
            r3.<init>();
            r4 = "Non-PCM MS/ACM is unsupported. Setting mimeType to ";
            r3.append(r4);
            r3.append(r1);
            r3 = r3.toString();
            android.util.Log.w(r2, r3);
            goto L_0x031f;
        L_0x0231:
            r1 = "audio/flac";
            r2 = r0.f5416h;
            r2 = java.util.Collections.singletonList(r2);
            goto L_0x0261;
        L_0x023a:
            r1 = "audio/vnd.dts.hd";
            goto L_0x031f;
        L_0x023e:
            r1 = "audio/vnd.dts";
            goto L_0x031f;
        L_0x0242:
            r1 = "audio/true-hd";
            goto L_0x031f;
        L_0x0246:
            r1 = "audio/eac3";
            goto L_0x031f;
        L_0x024a:
            r1 = "audio/ac3";
            goto L_0x031f;
        L_0x024e:
            r1 = "audio/mpeg";
            goto L_0x0253;
        L_0x0251:
            r1 = "audio/mpeg-L2";
        L_0x0253:
            r12 = r1;
            r2 = r10;
            r15 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
            goto L_0x0322;
        L_0x0259:
            r1 = "audio/mp4a-latm";
            r2 = r0.f5416h;
            r2 = java.util.Collections.singletonList(r2);
        L_0x0261:
            r12 = r1;
            goto L_0x0321;
        L_0x0264:
            r1 = "audio/opus";
            r2 = 5760; // 0x1680 float:8.071E-42 double:2.846E-320;
            r3 = new java.util.ArrayList;
            r3.<init>(r8);
            r11 = r0.f5416h;
            r3.add(r11);
            r11 = java.nio.ByteBuffer.allocate(r4);
            r12 = java.nio.ByteOrder.nativeOrder();
            r11 = r11.order(r12);
            r12 = r0.f5402J;
            r11 = r11.putLong(r12);
            r11 = r11.array();
            r3.add(r11);
            r4 = java.nio.ByteBuffer.allocate(r4);
            r11 = java.nio.ByteOrder.nativeOrder();
            r4 = r4.order(r11);
            r11 = r0.f5403K;
            r4 = r4.putLong(r11);
            r4 = r4.array();
            r3.add(r4);
            r12 = r1;
            r2 = r3;
            r15 = 5760; // 0x1680 float:8.071E-42 double:2.846E-320;
            goto L_0x0322;
        L_0x02aa:
            r1 = "audio/vorbis";
            r2 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
            r3 = r0.f5416h;
            r3 = com.google.android.exoplayer2.p137e.p139b.C4101d.C2265b.m6258a(r3);
            r12 = r1;
            r2 = r3;
            r15 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
            goto L_0x0322;
        L_0x02ba:
            r1 = "video/x-unknown";
            goto L_0x031f;
        L_0x02bd:
            r1 = new com.google.android.exoplayer2.l.l;
            r2 = r0.f5416h;
            r1.<init>(r2);
            r1 = com.google.android.exoplayer2.p137e.p139b.C4101d.C2265b.m6257a(r1);
            if (r1 == 0) goto L_0x02d2;
        L_0x02ca:
            r2 = "video/wvc1";
        L_0x02cc:
            r12 = r2;
            r15 = -1;
            r18 = -1;
            r2 = r1;
            goto L_0x0324;
        L_0x02d2:
            r2 = "MatroskaExtractor";
            r3 = "Unsupported FourCC. Setting mimeType to video/x-unknown";
            android.util.Log.w(r2, r3);
            r2 = "video/x-unknown";
            goto L_0x02cc;
        L_0x02dc:
            r1 = "video/hevc";
            r2 = new com.google.android.exoplayer2.l.l;
            r3 = r0.f5416h;
            r2.<init>(r3);
            r2 = com.google.android.exoplayer2.p165m.C2550d.m7213a(r2);
            r3 = r2.f6501a;
            r2 = r2.f6502b;
            r0.f5407O = r2;
            goto L_0x0303;
        L_0x02f0:
            r1 = "video/avc";
            r2 = new com.google.android.exoplayer2.l.l;
            r3 = r0.f5416h;
            r2.<init>(r3);
            r2 = com.google.android.exoplayer2.p165m.C2544a.m7201a(r2);
            r3 = r2.f6477a;
            r2 = r2.f6478b;
            r0.f5407O = r2;
        L_0x0303:
            r12 = r1;
            r2 = r3;
            goto L_0x0321;
        L_0x0306:
            r1 = "video/mp4v-es";
            r2 = r0.f5416h;
            if (r2 != 0) goto L_0x030f;
        L_0x030c:
            r2 = r10;
            goto L_0x0261;
        L_0x030f:
            r2 = r0.f5416h;
            r2 = java.util.Collections.singletonList(r2);
            goto L_0x0261;
        L_0x0317:
            r1 = "video/mpeg2";
            goto L_0x031f;
        L_0x031a:
            r1 = "video/x-vnd.on2.vp9";
            goto L_0x031f;
        L_0x031d:
            r1 = "video/x-vnd.on2.vp8";
        L_0x031f:
            r12 = r1;
            r2 = r10;
        L_0x0321:
            r15 = -1;
        L_0x0322:
            r18 = -1;
        L_0x0324:
            r1 = r0.f5405M;
            r1 = r1 | r6;
            r3 = r0.f5404L;
            if (r3 == 0) goto L_0x032c;
        L_0x032b:
            r6 = 2;
        L_0x032c:
            r1 = r1 | r6;
            r3 = com.google.android.exoplayer2.p164l.C2524i.m7050a(r12);
            if (r3 == 0) goto L_0x0354;
        L_0x0333:
            r11 = java.lang.Integer.toString(r28);
            r13 = 0;
            r14 = -1;
            r3 = r0.f5399G;
            r4 = r0.f5401I;
            r6 = r0.f5417i;
            r7 = r0.f5408P;
            r16 = r3;
            r17 = r4;
            r19 = r2;
            r20 = r6;
            r21 = r1;
            r22 = r7;
            r1 = com.google.android.exoplayer2.C2515k.m6987a(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
            r8 = 1;
            goto L_0x044d;
        L_0x0354:
            r3 = com.google.android.exoplayer2.p164l.C2524i.m7051b(r12);
            if (r3 == 0) goto L_0x03ce;
        L_0x035a:
            r1 = r0.f5422n;
            if (r1 != 0) goto L_0x0374;
        L_0x035e:
            r1 = r0.f5420l;
            if (r1 != r9) goto L_0x0365;
        L_0x0362:
            r1 = r0.f5418j;
            goto L_0x0367;
        L_0x0365:
            r1 = r0.f5420l;
        L_0x0367:
            r0.f5420l = r1;
            r1 = r0.f5421m;
            if (r1 != r9) goto L_0x0370;
        L_0x036d:
            r1 = r0.f5419k;
            goto L_0x0372;
        L_0x0370:
            r1 = r0.f5421m;
        L_0x0372:
            r0.f5421m = r1;
        L_0x0374:
            r1 = -1082130432; // 0xffffffffbf800000 float:-1.0 double:NaN;
            r3 = r0.f5420l;
            if (r3 == r9) goto L_0x0390;
        L_0x037a:
            r3 = r0.f5421m;
            if (r3 == r9) goto L_0x0390;
        L_0x037e:
            r1 = r0.f5419k;
            r3 = r0.f5420l;
            r1 = r1 * r3;
            r1 = (float) r1;
            r3 = r0.f5418j;
            r4 = r0.f5421m;
            r3 = r3 * r4;
            r3 = (float) r3;
            r1 = r1 / r3;
            r21 = r1;
            goto L_0x0392;
        L_0x0390:
            r21 = -1082130432; // 0xffffffffbf800000 float:-1.0 double:NaN;
        L_0x0392:
            r1 = r0.f5425q;
            if (r1 == 0) goto L_0x03a5;
        L_0x0396:
            r1 = r26.m6259a();
            r10 = new com.google.android.exoplayer2.m.b;
            r3 = r0.f5426r;
            r4 = r0.f5428t;
            r5 = r0.f5427s;
            r10.<init>(r3, r4, r5, r1);
        L_0x03a5:
            r24 = r10;
            r11 = java.lang.Integer.toString(r28);
            r13 = 0;
            r14 = -1;
            r1 = r0.f5418j;
            r3 = r0.f5419k;
            r18 = -1082130432; // 0xffffffffbf800000 float:-1.0 double:NaN;
            r20 = -1;
            r4 = r0.f5423o;
            r5 = r0.f5424p;
            r6 = r0.f5417i;
            r16 = r1;
            r17 = r3;
            r19 = r2;
            r22 = r4;
            r23 = r5;
            r25 = r6;
            r1 = com.google.android.exoplayer2.C2515k.m6985a(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25);
            r8 = 2;
            goto L_0x044d;
        L_0x03ce:
            r3 = "application/x-subrip";
            r3 = r3.equals(r12);
            if (r3 == 0) goto L_0x03e3;
        L_0x03d6:
            r2 = java.lang.Integer.toString(r28);
            r3 = r0.f5408P;
            r4 = r0.f5417i;
            r1 = com.google.android.exoplayer2.C2515k.m6982a(r2, r12, r1, r3, r4);
            goto L_0x044d;
        L_0x03e3:
            r3 = "text/x-ssa";
            r3 = r3.equals(r12);
            if (r3 == 0) goto L_0x0419;
        L_0x03eb:
            r2 = new java.util.ArrayList;
            r2.<init>(r7);
            r3 = com.google.android.exoplayer2.p137e.p139b.C4101d.f10396d;
            r2.add(r3);
            r3 = r0.f5416h;
            r2.add(r3);
            r11 = java.lang.Integer.toString(r28);
            r13 = 0;
            r14 = -1;
            r3 = r0.f5408P;
            r17 = -1;
            r4 = r0.f5417i;
            r19 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
            r15 = r1;
            r16 = r3;
            r18 = r4;
            r21 = r2;
            r1 = com.google.android.exoplayer2.C2515k.m6990a(r11, r12, r13, r14, r15, r16, r17, r18, r19, r21);
            goto L_0x044d;
        L_0x0419:
            r1 = "application/vobsub";
            r1 = r1.equals(r12);
            if (r1 != 0) goto L_0x043a;
        L_0x0421:
            r1 = "application/pgs";
            r1 = r1.equals(r12);
            if (r1 != 0) goto L_0x043a;
        L_0x0429:
            r1 = "application/dvbsubs";
            r1 = r1.equals(r12);
            if (r1 == 0) goto L_0x0432;
        L_0x0431:
            goto L_0x043a;
        L_0x0432:
            r1 = new com.google.android.exoplayer2.p;
            r2 = "Unexpected MIME type.";
            r1.<init>(r2);
            throw r1;
        L_0x043a:
            r11 = java.lang.Integer.toString(r28);
            r13 = 0;
            r14 = -1;
            r1 = r0.f5408P;
            r3 = r0.f5417i;
            r15 = r2;
            r16 = r1;
            r17 = r3;
            r1 = com.google.android.exoplayer2.C2515k.m6993a(r11, r12, r13, r14, r15, r16, r17);
        L_0x044d:
            r2 = r0.f5410b;
            r3 = r27;
            r2 = r3.mo2231a(r2, r8);
            r0.f5406N = r2;
            r2 = r0.f5406N;
            r2.mo2199a(r1);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.b.d.b.a(com.google.android.exoplayer2.e.g, int):void");
        }

        /* renamed from: a */
        private byte[] m6259a() {
            if (!(this.f5431w == -1.0f || this.f5432x == -1.0f || this.f5433y == -1.0f || this.f5434z == -1.0f || this.f5393A == -1.0f || this.f5394B == -1.0f || this.f5395C == -1.0f || this.f5396D == -1.0f || this.f5397E == -1.0f)) {
                if (this.f5398F != -1.0f) {
                    byte[] bArr = new byte[25];
                    ByteBuffer wrap = ByteBuffer.wrap(bArr);
                    wrap.put((byte) 0);
                    wrap.putShort((short) ((int) ((this.f5431w * 50000.0f) + 0.5f)));
                    wrap.putShort((short) ((int) ((this.f5432x * 50000.0f) + 0.5f)));
                    wrap.putShort((short) ((int) ((this.f5433y * 50000.0f) + 0.5f)));
                    wrap.putShort((short) ((int) ((this.f5434z * 50000.0f) + 0.5f)));
                    wrap.putShort((short) ((int) ((this.f5393A * 50000.0f) + 0.5f)));
                    wrap.putShort((short) ((int) ((this.f5394B * 50000.0f) + 0.5f)));
                    wrap.putShort((short) ((int) ((this.f5395C * 50000.0f) + 0.5f)));
                    wrap.putShort((short) ((int) ((this.f5396D * 50000.0f) + 0.5f)));
                    wrap.putShort((short) ((int) (this.f5397E + 0.5f)));
                    wrap.putShort((short) ((int) (this.f5398F + 0.5f)));
                    wrap.putShort((short) this.f5429u);
                    wrap.putShort((short) this.f5430v);
                    return bArr;
                }
            }
            return null;
        }

        /* renamed from: a */
        private static java.util.List<byte[]> m6257a(com.google.android.exoplayer2.p164l.C2529l r4) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r0 = 16;
            r4.m7098d(r0);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004d }
            r0 = r4.m7110n();	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004d }
            r2 = 826496599; // 0x31435657 float:2.8425313E-9 double:4.08343576E-315;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004d }
            r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004d }
            if (r0 == 0) goto L_0x0012;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004d }
        L_0x0010:
            r4 = 0;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004d }
            return r4;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004d }
        L_0x0012:
            r0 = r4.m7097d();	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004d }
            r0 = r0 + 20;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004d }
            r4 = r4.f6441a;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004d }
        L_0x001a:
            r1 = r4.length;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004d }
            r1 = r1 + -4;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004d }
            if (r0 >= r1) goto L_0x0045;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004d }
        L_0x001f:
            r1 = r4[r0];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004d }
            if (r1 != 0) goto L_0x0042;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004d }
        L_0x0023:
            r1 = r0 + 1;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004d }
            r1 = r4[r1];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004d }
            if (r1 != 0) goto L_0x0042;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004d }
        L_0x0029:
            r1 = r0 + 2;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004d }
            r1 = r4[r1];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004d }
            r2 = 1;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004d }
            if (r1 != r2) goto L_0x0042;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004d }
        L_0x0030:
            r1 = r0 + 3;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004d }
            r1 = r4[r1];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004d }
            r2 = 15;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004d }
            if (r1 != r2) goto L_0x0042;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004d }
        L_0x0038:
            r1 = r4.length;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004d }
            r4 = java.util.Arrays.copyOfRange(r4, r0, r1);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004d }
            r4 = java.util.Collections.singletonList(r4);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004d }
            return r4;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004d }
        L_0x0042:
            r0 = r0 + 1;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004d }
            goto L_0x001a;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004d }
        L_0x0045:
            r4 = new com.google.android.exoplayer2.p;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004d }
            r0 = "Failed to find FourCC VC1 initialization data";	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004d }
            r4.<init>(r0);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004d }
            throw r4;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x004d }
        L_0x004d:
            r4 = new com.google.android.exoplayer2.p;
            r0 = "Error parsing FourCC VC1 codec private";
            r4.<init>(r0);
            throw r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.b.d.b.a(com.google.android.exoplayer2.l.l):java.util.List<byte[]>");
        }

        /* renamed from: a */
        private static java.util.List<byte[]> m6258a(byte[] r8) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r0 = 0;
            r1 = r8[r0];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r2 = 2;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            if (r1 != r2) goto L_0x0069;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
        L_0x0006:
            r1 = 1;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r3 = 1;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r4 = 0;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
        L_0x0009:
            r5 = r8[r3];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r6 = -1;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            if (r5 != r6) goto L_0x0013;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
        L_0x000e:
            r4 = r4 + 255;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r3 = r3 + 1;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            goto L_0x0009;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
        L_0x0013:
            r5 = r3 + 1;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r3 = r8[r3];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r4 = r4 + r3;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r3 = 0;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
        L_0x0019:
            r7 = r8[r5];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            if (r7 != r6) goto L_0x0022;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
        L_0x001d:
            r3 = r3 + 255;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r5 = r5 + 1;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            goto L_0x0019;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
        L_0x0022:
            r6 = r5 + 1;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r5 = r8[r5];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r3 = r3 + r5;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r5 = r8[r6];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            if (r5 != r1) goto L_0x0061;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
        L_0x002b:
            r1 = new byte[r4];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            java.lang.System.arraycopy(r8, r6, r1, r0, r4);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r6 = r6 + r4;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r4 = r8[r6];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r5 = 3;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            if (r4 != r5) goto L_0x0059;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
        L_0x0036:
            r6 = r6 + r3;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r3 = r8[r6];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r4 = 5;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            if (r3 != r4) goto L_0x0051;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
        L_0x003c:
            r3 = r8.length;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r3 = r3 - r6;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r3 = new byte[r3];	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r4 = r8.length;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r4 = r4 - r6;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            java.lang.System.arraycopy(r8, r6, r3, r0, r4);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r8 = new java.util.ArrayList;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r8.<init>(r2);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r8.add(r1);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r8.add(r3);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            return r8;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
        L_0x0051:
            r8 = new com.google.android.exoplayer2.p;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r0 = "Error parsing vorbis codec private";	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r8.<init>(r0);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            throw r8;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
        L_0x0059:
            r8 = new com.google.android.exoplayer2.p;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r0 = "Error parsing vorbis codec private";	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r8.<init>(r0);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            throw r8;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
        L_0x0061:
            r8 = new com.google.android.exoplayer2.p;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r0 = "Error parsing vorbis codec private";	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r8.<init>(r0);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            throw r8;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
        L_0x0069:
            r8 = new com.google.android.exoplayer2.p;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r0 = "Error parsing vorbis codec private";	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            r8.<init>(r0);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
            throw r8;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0071 }
        L_0x0071:
            r8 = new com.google.android.exoplayer2.p;
            r0 = "Error parsing vorbis codec private";
            r8.<init>(r0);
            throw r8;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.b.d.b.a(byte[]):java.util.List<byte[]>");
        }

        /* renamed from: b */
        private static boolean m6260b(com.google.android.exoplayer2.p164l.C2529l r8) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r0 = r8.m7105i();	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0037 }
            r1 = 1;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0037 }
            if (r0 != r1) goto L_0x0008;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0037 }
        L_0x0007:
            return r1;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0037 }
        L_0x0008:
            r2 = 65534; // 0xfffe float:9.1833E-41 double:3.2378E-319;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0037 }
            r3 = 0;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0037 }
            if (r0 != r2) goto L_0x0036;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0037 }
        L_0x000e:
            r0 = 24;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0037 }
            r8.m7096c(r0);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0037 }
            r4 = r8.m7113q();	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0037 }
            r0 = com.google.android.exoplayer2.p137e.p139b.C4101d.f10399g;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0037 }
            r6 = r0.getMostSignificantBits();	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0037 }
            r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0037 }
            if (r0 != 0) goto L_0x0034;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0037 }
        L_0x0023:
            r4 = r8.m7113q();	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0037 }
            r8 = com.google.android.exoplayer2.p137e.p139b.C4101d.f10399g;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0037 }
            r6 = r8.getLeastSignificantBits();	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0037 }
            r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
            if (r8 != 0) goto L_0x0034;
        L_0x0033:
            goto L_0x0035;
        L_0x0034:
            r1 = 0;
        L_0x0035:
            return r1;
        L_0x0036:
            return r3;
        L_0x0037:
            r8 = new com.google.android.exoplayer2.p;
            r0 = "Error parsing MS/ACM codec private";
            r8.<init>(r0);
            throw r8;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.b.d.b.b(com.google.android.exoplayer2.l.l):boolean");
        }
    }

    /* compiled from: MatroskaExtractor */
    /* renamed from: com.google.android.exoplayer2.e.b.d$1 */
    static class C40991 implements C2323h {
        C40991() {
        }

        /* renamed from: a */
        public C2303e[] mo2161a() {
            return new C2303e[]{new C4101d()};
        }
    }

    /* compiled from: MatroskaExtractor */
    /* renamed from: com.google.android.exoplayer2.e.b.d$a */
    private final class C4100a implements C2264c {
        /* renamed from: a */
        final /* synthetic */ C4101d f10392a;

        private C4100a(C4101d c4101d) {
            this.f10392a = c4101d;
        }

        /* renamed from: a */
        public int mo2173a(int i) {
            return this.f10392a.m12860a(i);
        }

        /* renamed from: b */
        public boolean mo2179b(int i) {
            return this.f10392a.m12870b(i);
        }

        /* renamed from: a */
        public void mo2177a(int i, long j, long j2) {
            this.f10392a.m12865a(i, j, j2);
        }

        /* renamed from: c */
        public void mo2180c(int i) {
            this.f10392a.m12872c(i);
        }

        /* renamed from: a */
        public void mo2176a(int i, long j) {
            this.f10392a.m12864a(i, j);
        }

        /* renamed from: a */
        public void mo2174a(int i, double d) {
            this.f10392a.m12862a(i, d);
        }

        /* renamed from: a */
        public void mo2178a(int i, String str) {
            this.f10392a.m12866a(i, str);
        }

        /* renamed from: a */
        public void mo2175a(int i, int i2, C2304f c2304f) {
            this.f10392a.m12863a(i, i2, c2304f);
        }
    }

    /* renamed from: a */
    int m12860a(int i) {
        switch (i) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case JfifUtil.MARKER_RST7 /*215*/:
            case 231:
            case 241:
            case 251:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 22186:
            case 22203:
            case 25188:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case 17026:
            case 2274716:
                return 3;
            case 160:
            case 174:
            case 183:
            case 187:
            case 224:
            case JfifUtil.MARKER_APP1 /*225*/:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
                return 5;
            default:
                return 0;
        }
    }

    /* renamed from: b */
    boolean m12870b(int i) {
        if (!(i == 357149030 || i == 524531317 || i == 475249515)) {
            if (i != 374648427) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    public void mo2166c() {
    }

    public C4101d() {
        this(0);
    }

    public C4101d(int i) {
        this(new C4098a(), i);
    }

    C4101d(C2263b c2263b, int i) {
        this.f10441w = -1;
        this.f10442x = -9223372036854775807L;
        this.f10443y = -9223372036854775807L;
        this.f10444z = -9223372036854775807L;
        this.f10405F = -1;
        this.f10406G = -1;
        this.f10407H = -9223372036854775807L;
        this.f10426h = c2263b;
        this.f10426h.mo2171a(new C4100a());
        c2263b = true;
        if ((i & 1) != 0) {
            c2263b = null;
        }
        this.f10429k = c2263b;
        this.f10427i = new C2267f();
        this.f10428j = new SparseArray();
        this.f10432n = new C2529l(4);
        this.f10433o = new C2529l(ByteBuffer.allocate(4).putInt(-1).array());
        this.f10434p = new C2529l(4);
        this.f10430l = new C2529l(C2527j.f6433a);
        this.f10431m = new C2529l(4);
        this.f10435q = new C2529l();
        this.f10436r = new C2529l();
        this.f10437s = new C2529l(8);
        this.f10438t = new C2529l();
    }

    /* renamed from: a */
    public boolean mo2165a(C2304f c2304f) {
        return new C2266e().m6263a(c2304f);
    }

    /* renamed from: a */
    public void mo2164a(C2320g c2320g) {
        this.af = c2320g;
    }

    /* renamed from: a */
    public void mo2163a(long j, long j2) {
        this.f10407H = -9223372036854775807L;
        this.f10411L = 0;
        this.f10426h.mo2170a();
        this.f10427i.m6267a();
        m12858d();
    }

    /* renamed from: a */
    public int mo2162a(C2304f c2304f, C2326k c2326k) {
        int i = 0;
        this.ad = false;
        boolean z = true;
        while (z && !this.ad) {
            z = this.f10426h.mo2172a(c2304f);
            if (z && m12853a(c2326k, c2304f.mo2189c())) {
                return 1;
            }
        }
        if (!z) {
            i = -1;
        }
        return i;
    }

    /* renamed from: a */
    void m12865a(int i, long j, long j2) {
        if (i == 160) {
            this.ae = false;
        } else if (i == 174) {
            this.f10400A = new C2265b();
        } else if (i == 187) {
            this.f10410K = false;
        } else if (i == 19899) {
            this.f10402C = -1;
            this.f10403D = -1;
        } else if (i == 20533) {
            this.f10400A.f5413e = true;
        } else if (i == 21968) {
            this.f10400A.f5425q = true;
        } else if (i == 25152) {
        } else {
            if (i == 408125543) {
                if (this.f10441w != -1) {
                    if (this.f10441w != j) {
                        throw new C2571p("Multiple Segment elements not supported");
                    }
                }
                this.f10441w = j;
                this.f10440v = j2;
            } else if (i == 475249515) {
                this.f10408I = new C2522g();
                this.f10409J = new C2522g();
            } else if (i == 524531317) {
                if (this.f10401B != 0) {
                    return;
                }
                if (this.f10429k == 0 || this.f10405F == -1) {
                    this.af.mo2233a(new C4154a(this.f10444z));
                    this.f10401B = true;
                    return;
                }
                this.f10404E = true;
            }
        }
    }

    /* renamed from: c */
    void m12872c(int i) {
        if (i != 160) {
            if (i == 174) {
                if (C4101d.m12854a(this.f10400A.f5409a) != 0) {
                    this.f10400A.m6261a(this.af, this.f10400A.f5410b);
                    this.f10428j.put(this.f10400A.f5410b, this.f10400A);
                }
                this.f10400A = 0;
            } else if (i != 19899) {
                if (i != 25152) {
                    if (i != 28032) {
                        if (i == 357149030) {
                            if (this.f10442x == -9223372036854775807L) {
                                this.f10442x = 1000000;
                            }
                            if (this.f10443y != -9223372036854775807L) {
                                this.f10444z = m12845a(this.f10443y);
                            }
                        } else if (i != 374648427) {
                            if (i == 475249515) {
                                if (this.f10401B == 0) {
                                    this.af.mo2233a(m12859e());
                                    this.f10401B = true;
                                }
                            }
                        } else if (this.f10428j.size() != 0) {
                            this.af.mo2232a();
                        } else {
                            throw new C2571p("No valid tracks were found");
                        }
                    } else if (this.f10400A.f5413e != 0) {
                        if (this.f10400A.f5414f != 0) {
                            throw new C2571p("Combining encryption and compression is not supported");
                        }
                    }
                } else if (this.f10400A.f5413e != 0) {
                    if (this.f10400A.f5415g != 0) {
                        this.f10400A.f5417i = new C2255a(new C2254a(C2251b.f5376b, "video/webm", this.f10400A.f5415g.f5778b));
                    } else {
                        throw new C2571p("Encrypted Track found but ContentEncKeyID was not found");
                    }
                }
            } else if (this.f10402C == -1 || this.f10403D == -1) {
                throw new C2571p("Mandatory element SeekID or SeekPosition not found");
            } else if (this.f10402C == 475249515) {
                this.f10405F = this.f10403D;
            }
        } else if (this.f10411L == 2) {
            if (this.ae == 0) {
                this.f10419T |= 1;
            }
            m12846a((C2265b) this.f10428j.get(this.f10417R), this.f10412M);
            this.f10411L = 0;
        }
    }

    /* renamed from: a */
    void m12864a(int i, long j) {
        boolean z = false;
        StringBuilder stringBuilder;
        switch (i) {
            case 131:
                this.f10400A.f5411c = (int) j;
                return;
            case 136:
                i = this.f10400A;
                if (j == 1) {
                    z = true;
                }
                i.f5404L = z;
                return;
            case 155:
                this.f10413N = m12845a(j);
                return;
            case 159:
                this.f10400A.f5399G = (int) j;
                return;
            case 176:
                this.f10400A.f5418j = (int) j;
                return;
            case 179:
                this.f10408I.m7045a(m12845a(j));
                return;
            case 186:
                this.f10400A.f5419k = (int) j;
                return;
            case JfifUtil.MARKER_RST7 /*215*/:
                this.f10400A.f5410b = (int) j;
                return;
            case 231:
                this.f10407H = m12845a(j);
                return;
            case 241:
                if (this.f10410K == 0) {
                    this.f10409J.m7045a(j);
                    this.f10410K = true;
                    return;
                }
                return;
            case 251:
                this.ae = true;
                return;
            case 16980:
                if (j != 3) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("ContentCompAlgo ");
                    stringBuilder.append(j);
                    stringBuilder.append(" not supported");
                    throw new C2571p(stringBuilder.toString());
                }
                return;
            case 17029:
                if (j < 1 || j > 2) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("DocTypeReadVersion ");
                    stringBuilder.append(j);
                    stringBuilder.append(" not supported");
                    throw new C2571p(stringBuilder.toString());
                }
                return;
            case 17143:
                if (j != 1) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("EBMLReadVersion ");
                    stringBuilder.append(j);
                    stringBuilder.append(" not supported");
                    throw new C2571p(stringBuilder.toString());
                }
                return;
            case 18401:
                if (j != 5) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("ContentEncAlgo ");
                    stringBuilder.append(j);
                    stringBuilder.append(" not supported");
                    throw new C2571p(stringBuilder.toString());
                }
                return;
            case 18408:
                if (j != 1) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("AESSettingsCipherMode ");
                    stringBuilder.append(j);
                    stringBuilder.append(" not supported");
                    throw new C2571p(stringBuilder.toString());
                }
                return;
            case 20529:
                if (j != 0) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("ContentEncodingOrder ");
                    stringBuilder.append(j);
                    stringBuilder.append(" not supported");
                    throw new C2571p(stringBuilder.toString());
                }
                return;
            case 20530:
                if (j != 1) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("ContentEncodingScope ");
                    stringBuilder.append(j);
                    stringBuilder.append(" not supported");
                    throw new C2571p(stringBuilder.toString());
                }
                return;
            case 21420:
                this.f10403D = j + this.f10441w;
                return;
            case 21432:
                i = (int) j;
                if (i == 3) {
                    this.f10400A.f5424p = 1;
                    return;
                } else if (i != 15) {
                    switch (i) {
                        case 0:
                            this.f10400A.f5424p = 0;
                            return;
                        case 1:
                            this.f10400A.f5424p = 2;
                            return;
                        default:
                            return;
                    }
                } else {
                    this.f10400A.f5424p = 3;
                    return;
                }
            case 21680:
                this.f10400A.f5420l = (int) j;
                return;
            case 21682:
                this.f10400A.f5422n = (int) j;
                return;
            case 21690:
                this.f10400A.f5421m = (int) j;
                return;
            case 21930:
                i = this.f10400A;
                if (j == 1) {
                    z = true;
                }
                i.f5405M = z;
                return;
            case 21945:
                switch ((int) j) {
                    case 1:
                        this.f10400A.f5428t = 2;
                        return;
                    case 2:
                        this.f10400A.f5428t = 1;
                        return;
                    default:
                        return;
                }
            case 21946:
                i = (int) j;
                if (i != 1) {
                    if (i == 16) {
                        this.f10400A.f5427s = 6;
                        return;
                    } else if (i != 18) {
                        switch (i) {
                            case 6:
                            case 7:
                                break;
                            default:
                                return;
                        }
                    } else {
                        this.f10400A.f5427s = 7;
                        return;
                    }
                }
                this.f10400A.f5427s = 3;
                return;
            case 21947:
                this.f10400A.f5425q = true;
                i = (int) j;
                if (i == 1) {
                    this.f10400A.f5426r = 1;
                    return;
                } else if (i != 9) {
                    switch (i) {
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                            this.f10400A.f5426r = 2;
                            return;
                        default:
                            return;
                    }
                } else {
                    this.f10400A.f5426r = 6;
                    return;
                }
            case 21948:
                this.f10400A.f5429u = (int) j;
                return;
            case 21949:
                this.f10400A.f5430v = (int) j;
                return;
            case 22186:
                this.f10400A.f5402J = j;
                return;
            case 22203:
                this.f10400A.f5403K = j;
                return;
            case 25188:
                this.f10400A.f5400H = (int) j;
                return;
            case 2352003:
                this.f10400A.f5412d = (int) j;
                return;
            case 2807729:
                this.f10442x = j;
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    void m12862a(int i, double d) {
        if (i == 181) {
            this.f10400A.f5401I = (int) d;
        } else if (i != 17545) {
            switch (i) {
                case 21969:
                    this.f10400A.f5431w = (float) d;
                    return;
                case 21970:
                    this.f10400A.f5432x = (float) d;
                    return;
                case 21971:
                    this.f10400A.f5433y = (float) d;
                    return;
                case 21972:
                    this.f10400A.f5434z = (float) d;
                    return;
                case 21973:
                    this.f10400A.f5393A = (float) d;
                    return;
                case 21974:
                    this.f10400A.f5394B = (float) d;
                    return;
                case 21975:
                    this.f10400A.f5395C = (float) d;
                    return;
                case 21976:
                    this.f10400A.f5396D = (float) d;
                    return;
                case 21977:
                    this.f10400A.f5397E = (float) d;
                    return;
                case 21978:
                    this.f10400A.f5398F = (float) d;
                    return;
                default:
                    return;
            }
        } else {
            this.f10443y = (long) d;
        }
    }

    /* renamed from: a */
    void m12866a(int i, String str) {
        if (i == 134) {
            this.f10400A.f5409a = str;
        } else if (i != 17026) {
            if (i == 2274716) {
                this.f10400A.f5408P = str;
            }
        } else if ("webm".equals(str) != 0) {
        } else {
            if ("matroska".equals(str) == 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("DocType ");
                stringBuilder.append(str);
                stringBuilder.append(" not supported");
                throw new C2571p(stringBuilder.toString());
            }
        }
    }

    /* renamed from: a */
    void m12863a(int i, int i2, C2304f c2304f) {
        C4101d c4101d = this;
        int i3 = i;
        int i4 = i2;
        C2304f c2304f2 = c2304f;
        boolean z = false;
        int i5 = 1;
        if (i3 == 161 || i3 == 163) {
            long j = 8;
            if (c4101d.f10411L == 0) {
                c4101d.f10417R = (int) c4101d.f10427i.m6266a(c2304f2, false, true, 8);
                c4101d.f10418S = c4101d.f10427i.m6268b();
                c4101d.f10413N = -9223372036854775807L;
                c4101d.f10411L = 1;
                c4101d.f10432n.m7088a();
            }
            C2265b c2265b = (C2265b) c4101d.f10428j.get(c4101d.f10417R);
            if (c2265b == null) {
                c2304f2.mo2186b(i4 - c4101d.f10418S);
                c4101d.f10411L = 0;
                return;
            }
            if (c4101d.f10411L == 1) {
                int i6;
                m12848a(c2304f2, 3);
                int i7 = (c4101d.f10432n.f6441a[2] & 6) >> 1;
                if (i7 == 0) {
                    c4101d.f10415P = 1;
                    c4101d.f10416Q = C4101d.m12856a(c4101d.f10416Q, 1);
                    c4101d.f10416Q[0] = (i4 - c4101d.f10418S) - 3;
                } else if (i3 == 163) {
                    m12848a(c2304f2, 4);
                    c4101d.f10415P = (c4101d.f10432n.f6441a[3] & JfifUtil.MARKER_FIRST_BYTE) + 1;
                    c4101d.f10416Q = C4101d.m12856a(c4101d.f10416Q, c4101d.f10415P);
                    if (i7 == 2) {
                        Arrays.fill(c4101d.f10416Q, 0, c4101d.f10415P, ((i4 - c4101d.f10418S) - 4) / c4101d.f10415P);
                    } else if (i7 == 1) {
                        r10 = 4;
                        i7 = 0;
                        for (r6 = 0; r6 < c4101d.f10415P - 1; r6++) {
                            c4101d.f10416Q[r6] = 0;
                            do {
                                r10++;
                                m12848a(c2304f2, r10);
                                r14 = c4101d.f10432n.f6441a[r10 - 1] & JfifUtil.MARKER_FIRST_BYTE;
                                int[] iArr = c4101d.f10416Q;
                                iArr[r6] = iArr[r6] + r14;
                            } while (r14 == JfifUtil.MARKER_FIRST_BYTE);
                            i7 += c4101d.f10416Q[r6];
                        }
                        c4101d.f10416Q[c4101d.f10415P - 1] = ((i4 - c4101d.f10418S) - r10) - i7;
                    } else if (i7 == 3) {
                        r6 = 0;
                        r10 = 4;
                        i7 = 0;
                        while (r6 < c4101d.f10415P - i5) {
                            c4101d.f10416Q[r6] = z;
                            r10++;
                            m12848a(c2304f2, r10);
                            int i8 = r10 - 1;
                            if (c4101d.f10432n.f6441a[i8] != (byte) 0) {
                                long j2;
                                r14 = 0;
                                while (r14 < j) {
                                    i6 = i5 << (7 - r14);
                                    if ((c4101d.f10432n.f6441a[i8] & i6) != 0) {
                                        r10 += r14;
                                        m12848a(c2304f2, r10);
                                        j2 = (long) ((~i6) & (c4101d.f10432n.f6441a[i8] & JfifUtil.MARKER_FIRST_BYTE));
                                        i6 = i8 + 1;
                                        long j3 = j2;
                                        while (i6 < r10) {
                                            j3 = (j3 << j) | ((long) (c4101d.f10432n.f6441a[i6] & JfifUtil.MARKER_FIRST_BYTE));
                                            i6++;
                                            r10 = r10;
                                            j = 8;
                                        }
                                        int i9 = r10;
                                        if (r6 > 0) {
                                            j3 -= (1 << ((r14 * 7) + 6)) - 1;
                                        }
                                        j2 = j3;
                                        r10 = i9;
                                        if (j2 >= -2147483648L || j2 > 2147483647L) {
                                            throw new C2571p("EBML lacing sample size out of range.");
                                        }
                                        i6 = (int) j2;
                                        int[] iArr2 = c4101d.f10416Q;
                                        if (r6 != 0) {
                                            i6 += c4101d.f10416Q[r6 - 1];
                                        }
                                        iArr2[r6] = i6;
                                        i7 += c4101d.f10416Q[r6];
                                        r6++;
                                        z = false;
                                        i5 = 1;
                                        j = 8;
                                    } else {
                                        r14++;
                                        i5 = 1;
                                        j = 8;
                                    }
                                }
                                j2 = 0;
                                if (j2 >= -2147483648L) {
                                }
                                throw new C2571p("EBML lacing sample size out of range.");
                            }
                            throw new C2571p("No valid varint length mask found");
                        }
                        c4101d.f10416Q[c4101d.f10415P - 1] = ((i4 - c4101d.f10418S) - r10) - i7;
                    } else {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unexpected lacing value: ");
                        stringBuilder.append(i7);
                        throw new C2571p(stringBuilder.toString());
                    }
                } else {
                    throw new C2571p("Lacing only supported in SimpleBlocks.");
                }
                c4101d.f10412M = c4101d.f10407H + m12845a((long) ((c4101d.f10432n.f6441a[0] << 8) | (c4101d.f10432n.f6441a[1] & JfifUtil.MARKER_FIRST_BYTE)));
                Object obj = (c4101d.f10432n.f6441a[2] & 8) == 8 ? 1 : null;
                if (c2265b.f5411c != 2) {
                    if (i3 != 163 || (c4101d.f10432n.f6441a[2] & 128) != 128) {
                        i6 = 0;
                        c4101d.f10419T = i6 | (obj == null ? LinearLayoutManager.INVALID_OFFSET : 0);
                        c4101d.f10411L = 2;
                        c4101d.f10414O = 0;
                    }
                }
                i6 = 1;
                if (obj == null) {
                }
                c4101d.f10419T = i6 | (obj == null ? LinearLayoutManager.INVALID_OFFSET : 0);
                c4101d.f10411L = 2;
                c4101d.f10414O = 0;
            }
            if (i3 == 163) {
                while (c4101d.f10414O < c4101d.f10415P) {
                    m12849a(c2304f2, c2265b, c4101d.f10416Q[c4101d.f10414O]);
                    m12846a(c2265b, c4101d.f10412M + ((long) ((c4101d.f10414O * c2265b.f5412d) / 1000)));
                    c4101d.f10414O++;
                }
                c4101d.f10411L = 0;
            } else {
                m12849a(c2304f2, c2265b, c4101d.f10416Q[0]);
            }
        } else if (i3 == 16981) {
            c4101d.f10400A.f5414f = new byte[i4];
            c2304f2.mo2187b(c4101d.f10400A.f5414f, 0, i4);
        } else if (i3 == 18402) {
            byte[] bArr = new byte[i4];
            c2304f2.mo2187b(bArr, 0, i4);
            c4101d.f10400A.f5415g = new C2328a(1, bArr, 0, 0);
        } else if (i3 == 21419) {
            Arrays.fill(c4101d.f10434p.f6441a, (byte) 0);
            c2304f2.mo2187b(c4101d.f10434p.f6441a, 4 - i4, i4);
            c4101d.f10434p.m7096c(0);
            c4101d.f10402C = (int) c4101d.f10434p.m7109m();
        } else if (i3 == 25506) {
            c4101d.f10400A.f5416h = new byte[i4];
            c2304f2.mo2187b(c4101d.f10400A.f5416h, 0, i4);
        } else if (i3 == 30322) {
            c4101d.f10400A.f5423o = new byte[i4];
            c2304f2.mo2187b(c4101d.f10400A.f5423o, 0, i4);
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Unexpected id: ");
            stringBuilder2.append(i3);
            throw new C2571p(stringBuilder2.toString());
        }
    }

    /* renamed from: a */
    private void m12846a(C2265b c2265b, long j) {
        C4101d c4101d = this;
        C2265b c2265b2 = c2265b;
        if ("S_TEXT/UTF8".equals(c2265b2.f5409a)) {
            m12847a(c2265b, "%02d:%02d:%02d,%03d", 19, 1000, f10395c);
        } else if ("S_TEXT/ASS".equals(c2265b2.f5409a)) {
            m12847a(c2265b, "%01d:%02d:%02d:%02d", 21, 10000, f10398f);
        }
        c2265b2.f5406N.mo2198a(j, c4101d.f10419T, c4101d.ac, 0, c2265b2.f5415g);
        c4101d.ad = true;
        m12858d();
    }

    /* renamed from: d */
    private void m12858d() {
        this.f10420U = 0;
        this.ac = 0;
        this.ab = 0;
        this.f10421V = false;
        this.f10422W = false;
        this.f10424Y = false;
        this.aa = 0;
        this.f10425Z = (byte) 0;
        this.f10423X = false;
        this.f10435q.m7088a();
    }

    /* renamed from: a */
    private void m12848a(C2304f c2304f, int i) {
        if (this.f10432n.m7095c() < i) {
            if (this.f10432n.m7099e() < i) {
                this.f10432n.m7091a(Arrays.copyOf(this.f10432n.f6441a, Math.max(this.f10432n.f6441a.length * 2, i)), this.f10432n.m7095c());
            }
            c2304f.mo2187b(this.f10432n.f6441a, this.f10432n.m7095c(), i - this.f10432n.m7095c());
            this.f10432n.m7094b(i);
        }
    }

    /* renamed from: a */
    private void m12849a(C2304f c2304f, C2265b c2265b, int i) {
        if ("S_TEXT/UTF8".equals(c2265b.f5409a)) {
            m12850a(c2304f, f10394b, i);
        } else if ("S_TEXT/ASS".equals(c2265b.f5409a)) {
            m12850a(c2304f, f10397e, i);
        } else {
            C2329m c2329m = c2265b.f5406N;
            if (!this.f10421V) {
                if (c2265b.f5413e) {
                    this.f10419T &= -1073741825;
                    int i2 = 128;
                    if (!this.f10422W) {
                        c2304f.mo2187b(this.f10432n.f6441a, 0, 1);
                        this.f10420U++;
                        if ((this.f10432n.f6441a[0] & 128) != 128) {
                            this.f10425Z = this.f10432n.f6441a[0];
                            this.f10422W = true;
                        } else {
                            throw new C2571p("Extension bit is set in signal byte");
                        }
                    }
                    if (((this.f10425Z & 1) == 1 ? 1 : null) != null) {
                        Object obj = (this.f10425Z & 2) == 2 ? 1 : null;
                        this.f10419T |= 1073741824;
                        if (!this.f10423X) {
                            c2304f.mo2187b(this.f10437s.f6441a, 0, 8);
                            this.f10420U += 8;
                            this.f10423X = true;
                            byte[] bArr = this.f10432n.f6441a;
                            if (obj == null) {
                                i2 = 0;
                            }
                            bArr[0] = (byte) (i2 | 8);
                            this.f10432n.m7096c(0);
                            c2329m.mo2200a(this.f10432n, 1);
                            this.ac++;
                            this.f10437s.m7096c(0);
                            c2329m.mo2200a(this.f10437s, 8);
                            this.ac += 8;
                        }
                        if (obj != null) {
                            if (!this.f10424Y) {
                                c2304f.mo2187b(this.f10432n.f6441a, 0, 1);
                                this.f10420U++;
                                this.f10432n.m7096c(0);
                                this.aa = this.f10432n.m7103g();
                                this.f10424Y = true;
                            }
                            int i3 = this.aa * 4;
                            this.f10432n.m7089a(i3);
                            c2304f.mo2187b(this.f10432n.f6441a, 0, i3);
                            this.f10420U += i3;
                            short s = (short) ((this.aa / 2) + 1);
                            i2 = (s * 6) + 2;
                            if (this.f10439u == null || this.f10439u.capacity() < i2) {
                                this.f10439u = ByteBuffer.allocate(i2);
                            }
                            this.f10439u.position(0);
                            this.f10439u.putShort(s);
                            i3 = 0;
                            int i4 = 0;
                            while (i3 < this.aa) {
                                int u = this.f10432n.m7117u();
                                if (i3 % 2 == 0) {
                                    this.f10439u.putShort((short) (u - i4));
                                } else {
                                    this.f10439u.putInt(u - i4);
                                }
                                i3++;
                                i4 = u;
                            }
                            i3 = (i - this.f10420U) - i4;
                            if (this.aa % 2 == 1) {
                                this.f10439u.putInt(i3);
                            } else {
                                this.f10439u.putShort((short) i3);
                                this.f10439u.putInt(0);
                            }
                            this.f10438t.m7091a(this.f10439u.array(), i2);
                            c2329m.mo2200a(this.f10438t, i2);
                            this.ac += i2;
                        }
                    }
                } else if (c2265b.f5414f != null) {
                    this.f10435q.m7091a(c2265b.f5414f, c2265b.f5414f.length);
                }
                this.f10421V = true;
            }
            i += this.f10435q.m7095c();
            if (!"V_MPEG4/ISO/AVC".equals(c2265b.f5409a)) {
                if (!"V_MPEGH/ISO/HEVC".equals(c2265b.f5409a)) {
                    while (this.f10420U < i) {
                        m12844a(c2304f, c2329m, i - this.f10420U);
                    }
                    if ("A_VORBIS".equals(c2265b.f5409a) != null) {
                        this.f10433o.m7096c(0);
                        c2329m.mo2200a(this.f10433o, 4);
                        this.ac += 4;
                    }
                }
            }
            byte[] bArr2 = this.f10431m.f6441a;
            bArr2[0] = (byte) 0;
            bArr2[1] = (byte) 0;
            bArr2[2] = (byte) 0;
            int i5 = c2265b.f5407O;
            int i6 = 4 - c2265b.f5407O;
            while (this.f10420U < i) {
                if (this.ab == 0) {
                    m12851a(c2304f, bArr2, i6, i5);
                    this.f10431m.m7096c(0);
                    this.ab = this.f10431m.m7117u();
                    this.f10430l.m7096c(0);
                    c2329m.mo2200a(this.f10430l, 4);
                    this.ac += 4;
                } else {
                    this.ab -= m12844a(c2304f, c2329m, this.ab);
                }
            }
            if ("A_VORBIS".equals(c2265b.f5409a) != null) {
                this.f10433o.m7096c(0);
                c2329m.mo2200a(this.f10433o, 4);
                this.ac += 4;
            }
        }
    }

    /* renamed from: a */
    private void m12850a(C2304f c2304f, byte[] bArr, int i) {
        int length = bArr.length + i;
        if (this.f10436r.m7099e() < length) {
            this.f10436r.f6441a = Arrays.copyOf(bArr, length + i);
        } else {
            System.arraycopy(bArr, 0, this.f10436r.f6441a, 0, bArr.length);
        }
        c2304f.mo2187b(this.f10436r.f6441a, bArr.length, i);
        this.f10436r.m7089a(length);
    }

    /* renamed from: a */
    private void m12847a(C2265b c2265b, String str, int i, long j, byte[] bArr) {
        C4101d.m12852a(this.f10436r.f6441a, this.f10413N, str, i, j, bArr);
        c2265b.f5406N.mo2200a(this.f10436r, this.f10436r.m7095c());
        this.ac += this.f10436r.m7095c();
    }

    /* renamed from: a */
    private static void m12852a(byte[] bArr, long j, String str, int i, long j2, byte[] bArr2) {
        if (j == -9223372036854775807L) {
            j = bArr2;
        } else {
            j -= ((long) (((int) (j / 3600000000L)) * 3600)) * 1000000;
            j -= ((long) (((int) (j / 60000000)) * 60)) * 1000000;
            j = (int) ((j - (((long) ((int) (j / 1000000))) * 1000000)) / j2);
            j = C2541v.m7188c(String.format(Locale.US, str, new Object[]{Integer.valueOf(r1), Integer.valueOf(r2), Integer.valueOf(r3), Integer.valueOf(j)}));
        }
        System.arraycopy(j, 0, bArr, i, bArr2.length);
    }

    /* renamed from: a */
    private void m12851a(C2304f c2304f, byte[] bArr, int i, int i2) {
        int min = Math.min(i2, this.f10435q.m7093b());
        c2304f.mo2187b(bArr, i + min, i2 - min);
        if (min > 0) {
            this.f10435q.m7092a(bArr, i, min);
        }
        this.f10420U += i2;
    }

    /* renamed from: a */
    private int m12844a(C2304f c2304f, C2329m c2329m, int i) {
        int b = this.f10435q.m7093b();
        if (b > 0) {
            c2304f = Math.min(i, b);
            c2329m.mo2200a(this.f10435q, c2304f);
        } else {
            c2304f = c2329m.mo2197a(c2304f, i, false);
        }
        this.f10420U += c2304f;
        this.ac += c2304f;
        return c2304f;
    }

    /* renamed from: e */
    private C2327l m12859e() {
        if (!(this.f10441w == -1 || this.f10444z == -9223372036854775807L || this.f10408I == null || this.f10408I.m7043a() == 0 || this.f10409J == null)) {
            if (this.f10409J.m7043a() == this.f10408I.m7043a()) {
                int i;
                int a = this.f10408I.m7043a();
                int[] iArr = new int[a];
                long[] jArr = new long[a];
                long[] jArr2 = new long[a];
                long[] jArr3 = new long[a];
                int i2 = 0;
                for (i = 0; i < a; i++) {
                    jArr3[i] = this.f10408I.m7044a(i);
                    jArr[i] = this.f10441w + this.f10409J.m7044a(i);
                }
                while (true) {
                    i = a - 1;
                    if (i2 < i) {
                        i = i2 + 1;
                        iArr[i2] = (int) (jArr[i] - jArr[i2]);
                        jArr2[i2] = jArr3[i] - jArr3[i2];
                        i2 = i;
                    } else {
                        iArr[i] = (int) ((this.f10441w + this.f10440v) - jArr[i]);
                        jArr2[i] = this.f10444z - jArr3[i];
                        this.f10408I = null;
                        this.f10409J = null;
                        return new C4097a(iArr, jArr, jArr2, jArr3);
                    }
                }
            }
        }
        this.f10408I = null;
        this.f10409J = null;
        return new C4154a(this.f10444z);
    }

    /* renamed from: a */
    private boolean m12853a(C2326k c2326k, long j) {
        if (this.f10404E) {
            this.f10406G = j;
            c2326k.f5776a = this.f10405F;
            this.f10404E = false;
            return true;
        } else if (this.f10401B == null || this.f10406G == -1) {
            return false;
        } else {
            c2326k.f5776a = this.f10406G;
            this.f10406G = -1;
            return true;
        }
    }

    /* renamed from: a */
    private long m12845a(long j) {
        if (this.f10442x != -9223372036854775807L) {
            return C2541v.m7185b(j, this.f10442x, 1000);
        }
        throw new C2571p("Can't scale timecode prior to timecodeScale being set.");
    }

    /* renamed from: a */
    private static boolean m12854a(String str) {
        if (!("V_VP8".equals(str) || "V_VP9".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L2".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_TEXT/ASS".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str))) {
            if ("S_DVBSUB".equals(str) == null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static int[] m12856a(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        if (iArr.length >= i) {
            return iArr;
        }
        return new int[Math.max(iArr.length * 2, i)];
    }
}
