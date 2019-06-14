package com.google.android.exoplayer2.p137e.p140d;

import android.util.Log;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.p145g.C2344a.C2342a;
import com.google.android.exoplayer2.p145g.p147b.C4163h;
import com.google.android.exoplayer2.p145g.p147b.C4695a;
import com.google.android.exoplayer2.p145g.p147b.C4699e;
import com.google.android.exoplayer2.p145g.p147b.C4702j;
import com.google.android.exoplayer2.p164l.C2529l;
import com.google.android.exoplayer2.p164l.C2541v;

/* compiled from: MetadataUtil */
/* renamed from: com.google.android.exoplayer2.e.d.f */
final class C2280f {
    /* renamed from: A */
    private static final int f5535A = C2541v.m7193g("sosn");
    /* renamed from: B */
    private static final int f5536B = C2541v.m7193g("tvsh");
    /* renamed from: C */
    private static final int f5537C = C2541v.m7193g("----");
    /* renamed from: D */
    private static final String[] f5538D = new String[]{"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};
    /* renamed from: a */
    private static final int f5539a = C2541v.m7193g("nam");
    /* renamed from: b */
    private static final int f5540b = C2541v.m7193g("trk");
    /* renamed from: c */
    private static final int f5541c = C2541v.m7193g("cmt");
    /* renamed from: d */
    private static final int f5542d = C2541v.m7193g("day");
    /* renamed from: e */
    private static final int f5543e = C2541v.m7193g("ART");
    /* renamed from: f */
    private static final int f5544f = C2541v.m7193g("too");
    /* renamed from: g */
    private static final int f5545g = C2541v.m7193g("alb");
    /* renamed from: h */
    private static final int f5546h = C2541v.m7193g("com");
    /* renamed from: i */
    private static final int f5547i = C2541v.m7193g("wrt");
    /* renamed from: j */
    private static final int f5548j = C2541v.m7193g("lyr");
    /* renamed from: k */
    private static final int f5549k = C2541v.m7193g("gen");
    /* renamed from: l */
    private static final int f5550l = C2541v.m7193g("covr");
    /* renamed from: m */
    private static final int f5551m = C2541v.m7193g("gnre");
    /* renamed from: n */
    private static final int f5552n = C2541v.m7193g("grp");
    /* renamed from: o */
    private static final int f5553o = C2541v.m7193g("disk");
    /* renamed from: p */
    private static final int f5554p = C2541v.m7193g("trkn");
    /* renamed from: q */
    private static final int f5555q = C2541v.m7193g("tmpo");
    /* renamed from: r */
    private static final int f5556r = C2541v.m7193g("cpil");
    /* renamed from: s */
    private static final int f5557s = C2541v.m7193g("aART");
    /* renamed from: t */
    private static final int f5558t = C2541v.m7193g("sonm");
    /* renamed from: u */
    private static final int f5559u = C2541v.m7193g("soal");
    /* renamed from: v */
    private static final int f5560v = C2541v.m7193g("soar");
    /* renamed from: w */
    private static final int f5561w = C2541v.m7193g("soaa");
    /* renamed from: x */
    private static final int f5562x = C2541v.m7193g("soco");
    /* renamed from: y */
    private static final int f5563y = C2541v.m7193g("rtng");
    /* renamed from: z */
    private static final int f5564z = C2541v.m7193g("pgap");

    /* renamed from: a */
    public static C2342a m6305a(C2529l c2529l) {
        C2342a b;
        int d = c2529l.m7097d() + c2529l.m7111o();
        int o = c2529l.m7111o();
        int i = (o >> 24) & JfifUtil.MARKER_FIRST_BYTE;
        if (i != 169) {
            if (i != 65533) {
                try {
                    if (o == f5551m) {
                        b = C2280f.m6311b(c2529l);
                        return b;
                    } else if (o == f5553o) {
                        b = C2280f.m6310b(o, "TPOS", c2529l);
                        c2529l.m7096c(d);
                        return b;
                    } else if (o == f5554p) {
                        b = C2280f.m6310b(o, "TRCK", c2529l);
                        c2529l.m7096c(d);
                        return b;
                    } else if (o == f5555q) {
                        b = C2280f.m6307a(o, "TBPM", c2529l, true, false);
                        c2529l.m7096c(d);
                        return b;
                    } else if (o == f5556r) {
                        b = C2280f.m6307a(o, "TCMP", c2529l, true, true);
                        c2529l.m7096c(d);
                        return b;
                    } else if (o == f5550l) {
                        b = C2280f.m6312c(c2529l);
                        c2529l.m7096c(d);
                        return b;
                    } else if (o == f5557s) {
                        b = C2280f.m6309a(o, "TPE2", c2529l);
                        c2529l.m7096c(d);
                        return b;
                    } else if (o == f5558t) {
                        b = C2280f.m6309a(o, "TSOT", c2529l);
                        c2529l.m7096c(d);
                        return b;
                    } else if (o == f5559u) {
                        b = C2280f.m6309a(o, "TSO2", c2529l);
                        c2529l.m7096c(d);
                        return b;
                    } else if (o == f5560v) {
                        b = C2280f.m6309a(o, "TSOA", c2529l);
                        c2529l.m7096c(d);
                        return b;
                    } else if (o == f5561w) {
                        b = C2280f.m6309a(o, "TSOP", c2529l);
                        c2529l.m7096c(d);
                        return b;
                    } else if (o == f5562x) {
                        b = C2280f.m6309a(o, "TSOC", c2529l);
                        c2529l.m7096c(d);
                        return b;
                    } else if (o == f5563y) {
                        b = C2280f.m6307a(o, "ITUNESADVISORY", c2529l, false, false);
                        c2529l.m7096c(d);
                        return b;
                    } else if (o == f5564z) {
                        b = C2280f.m6307a(o, "ITUNESGAPLESS", c2529l, false, true);
                        c2529l.m7096c(d);
                        return b;
                    } else if (o == f5535A) {
                        b = C2280f.m6309a(o, "TVSHOWSORT", c2529l);
                        c2529l.m7096c(d);
                        return b;
                    } else if (o == f5536B) {
                        b = C2280f.m6309a(o, "TVSHOW", c2529l);
                        c2529l.m7096c(d);
                        return b;
                    } else {
                        if (o == f5537C) {
                            b = C2280f.m6308a(c2529l, d);
                            c2529l.m7096c(d);
                            return b;
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Skipped unknown metadata entry: ");
                        stringBuilder.append(C2268a.m6271c(o));
                        Log.d("MetadataUtil", stringBuilder.toString());
                        c2529l.m7096c(d);
                        return null;
                    }
                } finally {
                    c2529l.m7096c(d);
                }
            }
        }
        i = 16777215 & o;
        if (i == f5541c) {
            b = C2280f.m6306a(o, c2529l);
            c2529l.m7096c(d);
            return b;
        }
        if (i != f5539a) {
            if (i != f5540b) {
                if (i != f5546h) {
                    if (i != f5547i) {
                        if (i == f5542d) {
                            b = C2280f.m6309a(o, "TDRC", c2529l);
                            c2529l.m7096c(d);
                            return b;
                        } else if (i == f5543e) {
                            b = C2280f.m6309a(o, "TPE1", c2529l);
                            c2529l.m7096c(d);
                            return b;
                        } else if (i == f5544f) {
                            b = C2280f.m6309a(o, "TSSE", c2529l);
                            c2529l.m7096c(d);
                            return b;
                        } else if (i == f5545g) {
                            b = C2280f.m6309a(o, "TALB", c2529l);
                            c2529l.m7096c(d);
                            return b;
                        } else if (i == f5548j) {
                            b = C2280f.m6309a(o, "USLT", c2529l);
                            c2529l.m7096c(d);
                            return b;
                        } else if (i == f5549k) {
                            b = C2280f.m6309a(o, "TCON", c2529l);
                            c2529l.m7096c(d);
                            return b;
                        } else {
                            if (i == f5552n) {
                                b = C2280f.m6309a(o, "TIT1", c2529l);
                                c2529l.m7096c(d);
                                return b;
                            }
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append("Skipped unknown metadata entry: ");
                            stringBuilder2.append(C2268a.m6271c(o));
                            Log.d("MetadataUtil", stringBuilder2.toString());
                            c2529l.m7096c(d);
                            return null;
                        }
                    }
                }
                b = C2280f.m6309a(o, "TCOM", c2529l);
                c2529l.m7096c(d);
                return b;
            }
        }
        b = C2280f.m6309a(o, "TIT2", c2529l);
        c2529l.m7096c(d);
        return b;
    }

    /* renamed from: a */
    private static C4702j m6309a(int i, String str, C2529l c2529l) {
        int o = c2529l.m7111o();
        if (c2529l.m7111o() == C2268a.aF) {
            c2529l.m7098d(8);
            return new C4702j(str, null, c2529l.m7102f(o - 16));
        }
        c2529l = new StringBuilder();
        c2529l.append("Failed to parse text attribute: ");
        c2529l.append(C2268a.m6271c(i));
        Log.w("MetadataUtil", c2529l.toString());
        return null;
    }

    /* renamed from: a */
    private static C4699e m6306a(int i, C2529l c2529l) {
        int o = c2529l.m7111o();
        if (c2529l.m7111o() == C2268a.aF) {
            c2529l.m7098d(8);
            i = c2529l.m7102f(o - 16);
            return new C4699e("und", i, i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to parse comment attribute: ");
        stringBuilder.append(C2268a.m6271c(i));
        Log.w("MetadataUtil", stringBuilder.toString());
        return 0;
    }

    /* renamed from: a */
    private static C4163h m6307a(int i, String str, C2529l c2529l, boolean z, boolean z2) {
        c2529l = C2280f.m6313d(c2529l);
        if (z2) {
            c2529l = Math.min(true, c2529l);
        }
        if (c2529l >= null) {
            if (z) {
                i = new C4702j(str, null, Integer.toString(c2529l));
            } else {
                i = new C4699e("und", str, Integer.toString(c2529l));
            }
            return i;
        }
        c2529l = new StringBuilder();
        c2529l.append("Failed to parse uint8 attribute: ");
        c2529l.append(C2268a.m6271c(i));
        Log.w("MetadataUtil", c2529l.toString());
        return null;
    }

    /* renamed from: b */
    private static C4702j m6310b(int i, String str, C2529l c2529l) {
        int o = c2529l.m7111o();
        if (c2529l.m7111o() == C2268a.aF && o >= 22) {
            c2529l.m7098d(10);
            o = c2529l.m7104h();
            if (o > 0) {
                i = new StringBuilder();
                i.append("");
                i.append(o);
                i = i.toString();
                c2529l = c2529l.m7104h();
                if (c2529l > null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(i);
                    stringBuilder.append("/");
                    stringBuilder.append(c2529l);
                    i = stringBuilder.toString();
                }
                return new C4702j(str, null, i);
            }
        }
        c2529l = new StringBuilder();
        c2529l.append("Failed to parse index/count attribute: ");
        c2529l.append(C2268a.m6271c(i));
        Log.w("MetadataUtil", c2529l.toString());
        return null;
    }

    /* renamed from: b */
    private static C4702j m6311b(C2529l c2529l) {
        c2529l = C2280f.m6313d(c2529l);
        c2529l = (c2529l <= null || c2529l > f5538D.length) ? null : f5538D[c2529l - 1];
        if (c2529l != null) {
            return new C4702j("TCON", null, c2529l);
        }
        Log.w("MetadataUtil", "Failed to parse standard genre code");
        return null;
    }

    /* renamed from: c */
    private static C4695a m6312c(C2529l c2529l) {
        int o = c2529l.m7111o();
        if (c2529l.m7111o() == C2268a.aF) {
            int b = C2268a.m6270b(c2529l.m7111o());
            String str = b == 13 ? "image/jpeg" : b == 14 ? "image/png" : null;
            if (str == null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unrecognized cover art flags: ");
                stringBuilder.append(b);
                Log.w("MetadataUtil", stringBuilder.toString());
                return null;
            }
            c2529l.m7098d(4);
            byte[] bArr = new byte[(o - 16)];
            c2529l.m7092a(bArr, 0, bArr.length);
            return new C4695a(str, null, 3, bArr);
        }
        Log.w("MetadataUtil", "Failed to parse cover art attribute");
        return null;
    }

    /* renamed from: a */
    private static C4163h m6308a(C2529l c2529l, int i) {
        Object obj = null;
        String str = obj;
        int i2 = -1;
        int i3 = -1;
        while (c2529l.m7097d() < i) {
            int d = c2529l.m7097d();
            int o = c2529l.m7111o();
            int o2 = c2529l.m7111o();
            c2529l.m7098d(4);
            if (o2 == C2268a.aD) {
                obj = c2529l.m7102f(o - 12);
            } else if (o2 == C2268a.aE) {
                str = c2529l.m7102f(o - 12);
            } else {
                if (o2 == C2268a.aF) {
                    i2 = d;
                    i3 = o;
                }
                c2529l.m7098d(o - 12);
            }
        }
        if (!("com.apple.iTunes".equals(obj) == 0 || "iTunSMPB".equals(str) == 0)) {
            if (i2 != -1) {
                c2529l.m7096c(i2);
                c2529l.m7098d(16);
                return new C4699e("und", str, c2529l.m7102f(i3 - 16));
            }
        }
        return null;
    }

    /* renamed from: d */
    private static int m6313d(C2529l c2529l) {
        c2529l.m7098d(4);
        if (c2529l.m7111o() == C2268a.aF) {
            c2529l.m7098d(8);
            return c2529l.m7103g();
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }
}
