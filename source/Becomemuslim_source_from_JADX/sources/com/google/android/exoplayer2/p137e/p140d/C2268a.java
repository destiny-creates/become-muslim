package com.google.android.exoplayer2.p137e.p140d;

import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.p164l.C2529l;
import com.google.android.exoplayer2.p164l.C2541v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: Atom */
/* renamed from: com.google.android.exoplayer2.e.d.a */
abstract class C2268a {
    /* renamed from: A */
    public static final int f5441A = C2541v.m7193g("sidx");
    /* renamed from: B */
    public static final int f5442B = C2541v.m7193g("moov");
    /* renamed from: C */
    public static final int f5443C = C2541v.m7193g("mvhd");
    /* renamed from: D */
    public static final int f5444D = C2541v.m7193g("trak");
    /* renamed from: E */
    public static final int f5445E = C2541v.m7193g("mdia");
    /* renamed from: F */
    public static final int f5446F = C2541v.m7193g("minf");
    /* renamed from: G */
    public static final int f5447G = C2541v.m7193g("stbl");
    /* renamed from: H */
    public static final int f5448H = C2541v.m7193g("avcC");
    /* renamed from: I */
    public static final int f5449I = C2541v.m7193g("hvcC");
    /* renamed from: J */
    public static final int f5450J = C2541v.m7193g("esds");
    /* renamed from: K */
    public static final int f5451K = C2541v.m7193g("moof");
    /* renamed from: L */
    public static final int f5452L = C2541v.m7193g("traf");
    /* renamed from: M */
    public static final int f5453M = C2541v.m7193g("mvex");
    /* renamed from: N */
    public static final int f5454N = C2541v.m7193g("mehd");
    /* renamed from: O */
    public static final int f5455O = C2541v.m7193g("tkhd");
    /* renamed from: P */
    public static final int f5456P = C2541v.m7193g("edts");
    /* renamed from: Q */
    public static final int f5457Q = C2541v.m7193g("elst");
    /* renamed from: R */
    public static final int f5458R = C2541v.m7193g("mdhd");
    /* renamed from: S */
    public static final int f5459S = C2541v.m7193g("hdlr");
    /* renamed from: T */
    public static final int f5460T = C2541v.m7193g("stsd");
    /* renamed from: U */
    public static final int f5461U = C2541v.m7193g("pssh");
    /* renamed from: V */
    public static final int f5462V = C2541v.m7193g("sinf");
    /* renamed from: W */
    public static final int f5463W = C2541v.m7193g("schm");
    /* renamed from: X */
    public static final int f5464X = C2541v.m7193g("schi");
    /* renamed from: Y */
    public static final int f5465Y = C2541v.m7193g("tenc");
    /* renamed from: Z */
    public static final int f5466Z = C2541v.m7193g("encv");
    /* renamed from: a */
    public static final int f5467a = C2541v.m7193g("ftyp");
    public static final int aA = C2541v.m7193g("udta");
    public static final int aB = C2541v.m7193g("meta");
    public static final int aC = C2541v.m7193g("ilst");
    public static final int aD = C2541v.m7193g("mean");
    public static final int aE = C2541v.m7193g("name");
    public static final int aF = C2541v.m7193g("data");
    public static final int aG = C2541v.m7193g("emsg");
    public static final int aH = C2541v.m7193g("st3d");
    public static final int aI = C2541v.m7193g("sv3d");
    public static final int aJ = C2541v.m7193g("proj");
    public static final int aK = C2541v.m7193g("vp08");
    public static final int aL = C2541v.m7193g("vp09");
    public static final int aM = C2541v.m7193g("vpcC");
    public static final int aN = C2541v.m7193g("camm");
    public static final int aO = C2541v.m7193g("alac");
    public static final int aa = C2541v.m7193g("enca");
    public static final int ab = C2541v.m7193g("frma");
    public static final int ac = C2541v.m7193g("saiz");
    public static final int ad = C2541v.m7193g("saio");
    public static final int ae = C2541v.m7193g("sbgp");
    public static final int af = C2541v.m7193g("sgpd");
    public static final int ag = C2541v.m7193g("uuid");
    public static final int ah = C2541v.m7193g("senc");
    public static final int ai = C2541v.m7193g("pasp");
    public static final int aj = C2541v.m7193g("TTML");
    public static final int ak = C2541v.m7193g("vmhd");
    public static final int al = C2541v.m7193g("mp4v");
    public static final int am = C2541v.m7193g("stts");
    public static final int an = C2541v.m7193g("stss");
    public static final int ao = C2541v.m7193g("ctts");
    public static final int ap = C2541v.m7193g("stsc");
    public static final int aq = C2541v.m7193g("stsz");
    public static final int ar = C2541v.m7193g("stz2");
    public static final int as = C2541v.m7193g("stco");
    public static final int at = C2541v.m7193g("co64");
    public static final int au = C2541v.m7193g("tx3g");
    public static final int av = C2541v.m7193g("wvtt");
    public static final int aw = C2541v.m7193g("stpp");
    public static final int ax = C2541v.m7193g("c608");
    public static final int ay = C2541v.m7193g("samr");
    public static final int az = C2541v.m7193g("sawb");
    /* renamed from: b */
    public static final int f5468b = C2541v.m7193g("avc1");
    /* renamed from: c */
    public static final int f5469c = C2541v.m7193g("avc3");
    /* renamed from: d */
    public static final int f5470d = C2541v.m7193g("hvc1");
    /* renamed from: e */
    public static final int f5471e = C2541v.m7193g("hev1");
    /* renamed from: f */
    public static final int f5472f = C2541v.m7193g("s263");
    /* renamed from: g */
    public static final int f5473g = C2541v.m7193g("d263");
    /* renamed from: h */
    public static final int f5474h = C2541v.m7193g("mdat");
    /* renamed from: i */
    public static final int f5475i = C2541v.m7193g("mp4a");
    /* renamed from: j */
    public static final int f5476j = C2541v.m7193g(".mp3");
    /* renamed from: k */
    public static final int f5477k = C2541v.m7193g("wave");
    /* renamed from: l */
    public static final int f5478l = C2541v.m7193g("lpcm");
    /* renamed from: m */
    public static final int f5479m = C2541v.m7193g("sowt");
    /* renamed from: n */
    public static final int f5480n = C2541v.m7193g("ac-3");
    /* renamed from: o */
    public static final int f5481o = C2541v.m7193g("dac3");
    /* renamed from: p */
    public static final int f5482p = C2541v.m7193g("ec-3");
    /* renamed from: q */
    public static final int f5483q = C2541v.m7193g("dec3");
    /* renamed from: r */
    public static final int f5484r = C2541v.m7193g("dtsc");
    /* renamed from: s */
    public static final int f5485s = C2541v.m7193g("dtsh");
    /* renamed from: t */
    public static final int f5486t = C2541v.m7193g("dtsl");
    /* renamed from: u */
    public static final int f5487u = C2541v.m7193g("dtse");
    /* renamed from: v */
    public static final int f5488v = C2541v.m7193g("ddts");
    /* renamed from: w */
    public static final int f5489w = C2541v.m7193g("tfdt");
    /* renamed from: x */
    public static final int f5490x = C2541v.m7193g("tfhd");
    /* renamed from: y */
    public static final int f5491y = C2541v.m7193g("trex");
    /* renamed from: z */
    public static final int f5492z = C2541v.m7193g("trun");
    public final int aP;

    /* compiled from: Atom */
    /* renamed from: com.google.android.exoplayer2.e.d.a$a */
    static final class C4107a extends C2268a {
        public final long aQ;
        public final List<C4108b> aR = new ArrayList();
        public final List<C4107a> aS = new ArrayList();

        public C4107a(int i, long j) {
            super(i);
            this.aQ = j;
        }

        /* renamed from: a */
        public void m12909a(C4108b c4108b) {
            this.aR.add(c4108b);
        }

        /* renamed from: a */
        public void m12908a(C4107a c4107a) {
            this.aS.add(c4107a);
        }

        /* renamed from: d */
        public C4108b m12910d(int i) {
            int size = this.aR.size();
            for (int i2 = 0; i2 < size; i2++) {
                C4108b c4108b = (C4108b) this.aR.get(i2);
                if (c4108b.aP == i) {
                    return c4108b;
                }
            }
            return 0;
        }

        /* renamed from: e */
        public C4107a m12911e(int i) {
            int size = this.aS.size();
            for (int i2 = 0; i2 < size; i2++) {
                C4107a c4107a = (C4107a) this.aS.get(i2);
                if (c4107a.aP == i) {
                    return c4107a;
                }
            }
            return 0;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(C2268a.m6271c(this.aP));
            stringBuilder.append(" leaves: ");
            stringBuilder.append(Arrays.toString(this.aR.toArray()));
            stringBuilder.append(" containers: ");
            stringBuilder.append(Arrays.toString(this.aS.toArray()));
            return stringBuilder.toString();
        }
    }

    /* compiled from: Atom */
    /* renamed from: com.google.android.exoplayer2.e.d.a$b */
    static final class C4108b extends C2268a {
        public final C2529l aQ;

        public C4108b(int i, C2529l c2529l) {
            super(i);
            this.aQ = c2529l;
        }
    }

    /* renamed from: a */
    public static int m6269a(int i) {
        return (i >> 24) & JfifUtil.MARKER_FIRST_BYTE;
    }

    /* renamed from: b */
    public static int m6270b(int i) {
        return i & 16777215;
    }

    public C2268a(int i) {
        this.aP = i;
    }

    public String toString() {
        return C2268a.m6271c(this.aP);
    }

    /* renamed from: c */
    public static String m6271c(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append((char) ((i >> 24) & JfifUtil.MARKER_FIRST_BYTE));
        stringBuilder.append((char) ((i >> 16) & JfifUtil.MARKER_FIRST_BYTE));
        stringBuilder.append((char) ((i >> 8) & JfifUtil.MARKER_FIRST_BYTE));
        stringBuilder.append((char) (i & JfifUtil.MARKER_FIRST_BYTE));
        return stringBuilder.toString();
    }
}
