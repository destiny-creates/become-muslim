package com.google.android.exoplayer2.p134a;

import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p136c.C2255a;
import com.google.android.exoplayer2.p164l.C2528k;
import com.google.android.exoplayer2.p164l.C2529l;
import java.nio.ByteBuffer;

/* compiled from: Ac3Util */
/* renamed from: com.google.android.exoplayer2.a.a */
public final class C2216a {
    /* renamed from: a */
    private static final int[] f5269a = new int[]{1, 2, 3, 6};
    /* renamed from: b */
    private static final int[] f5270b = new int[]{48000, 44100, 32000};
    /* renamed from: c */
    private static final int[] f5271c = new int[]{24000, 22050, 16000};
    /* renamed from: d */
    private static final int[] f5272d = new int[]{2, 1, 2, 3, 3, 4, 4, 5};
    /* renamed from: e */
    private static final int[] f5273e = new int[]{32, 40, 48, 56, 64, 80, 96, 112, 128, 160, JfifUtil.MARKER_SOFn, 224, 256, 320, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, 448, 512, 576, 640};
    /* renamed from: f */
    private static final int[] f5274f = new int[]{69, 87, 104, 121, 139, 174, JfifUtil.MARKER_RST0, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    /* compiled from: Ac3Util */
    /* renamed from: com.google.android.exoplayer2.a.a$a */
    public static final class C2215a {
        /* renamed from: a */
        public final String f5263a;
        /* renamed from: b */
        public final int f5264b;
        /* renamed from: c */
        public final int f5265c;
        /* renamed from: d */
        public final int f5266d;
        /* renamed from: e */
        public final int f5267e;
        /* renamed from: f */
        public final int f5268f;

        private C2215a(String str, int i, int i2, int i3, int i4, int i5) {
            this.f5263a = str;
            this.f5264b = i;
            this.f5266d = i2;
            this.f5265c = i3;
            this.f5267e = i4;
            this.f5268f = i5;
        }
    }

    /* renamed from: a */
    public static int m6107a() {
        return 1536;
    }

    /* renamed from: a */
    public static C2515k m6112a(C2529l c2529l, String str, String str2, C2255a c2255a) {
        int i = f5270b[(c2529l.m7103g() & JfifUtil.MARKER_SOFn) >> 6];
        int g = c2529l.m7103g();
        int i2 = f5272d[(g & 56) >> 3];
        if ((g & 4) != 0) {
            i2++;
        }
        return C2515k.m6988a(str, "audio/ac3", null, -1, -1, i2, i, null, c2255a, 0, str2);
    }

    /* renamed from: b */
    public static C2515k m6113b(C2529l c2529l, String str, String str2, C2255a c2255a) {
        C2529l c2529l2 = c2529l;
        c2529l.m7098d(2);
        int i = f5270b[(c2529l.m7103g() & JfifUtil.MARKER_SOFn) >> 6];
        int g = c2529l.m7103g();
        int i2 = f5272d[(g & 14) >> 1];
        if ((g & 1) != 0) {
            i2++;
        }
        if (((c2529l.m7103g() & 30) >> 1) > 0 && (2 & c2529l.m7103g()) != 0) {
            i2 += 2;
        }
        int i3 = i2;
        String str3 = "audio/eac3";
        if (c2529l.m7093b() > 0 && (c2529l.m7103g() & 1) != 0) {
            str3 = "audio/eac3-joc";
        }
        return C2515k.m6988a(str, str3, null, -1, -1, i3, i, null, c2255a, 0, str2);
    }

    /* renamed from: a */
    public static C2215a m6111a(C2528k c2528k) {
        int c;
        int i;
        String str;
        int i2;
        int i3;
        int i4;
        C2528k c2528k2 = c2528k;
        int b = c2528k.m7077b();
        c2528k2.m7078b(40);
        Object obj = c2528k2.m7081c(5) == 16 ? 1 : null;
        c2528k2.m7073a(b);
        int c2;
        int c3;
        int c4;
        String str2;
        if (obj != null) {
            int i5;
            int i6;
            int i7;
            c2528k2.m7078b(16);
            b = c2528k2.m7081c(2);
            c2528k2.m7078b(3);
            c2 = (c2528k2.m7081c(11) + 1) * 2;
            c = c2528k2.m7081c(2);
            if (c == 3) {
                i5 = f5271c[c2528k2.m7081c(2)];
                i6 = 3;
                i7 = 6;
            } else {
                i6 = c2528k2.m7081c(2);
                i7 = f5269a[i6];
                i5 = f5270b[c];
            }
            int i8 = i7 * 256;
            c3 = c2528k2.m7081c(3);
            boolean e = c2528k.m7084e();
            int i9 = f5272d[c3] + e;
            c2528k2.m7078b(10);
            if (c2528k.m7084e()) {
                c2528k2.m7078b(8);
            }
            if (c3 == 0) {
                c2528k2.m7078b(5);
                if (c2528k.m7084e()) {
                    c2528k2.m7078b(8);
                }
            }
            if (b == 1 && c2528k.m7084e()) {
                c2528k2.m7078b(16);
            }
            if (c2528k.m7084e()) {
                if (c3 > 2) {
                    c2528k2.m7078b(2);
                }
                if ((c3 & 1) != 0 && c3 > 2) {
                    c2528k2.m7078b(6);
                }
                if ((c3 & 4) != 0) {
                    c2528k2.m7078b(6);
                }
                if (e && c2528k.m7084e()) {
                    c2528k2.m7078b(5);
                }
                if (b == 0) {
                    if (c2528k.m7084e()) {
                        c2528k2.m7078b(6);
                    }
                    if (c3 == 0 && c2528k.m7084e()) {
                        c2528k2.m7078b(6);
                    }
                    if (c2528k.m7084e()) {
                        c2528k2.m7078b(6);
                    }
                    c4 = c2528k2.m7081c(2);
                    if (c4 == 1) {
                        c2528k2.m7078b(5);
                    } else if (c4 == 2) {
                        c2528k2.m7078b(12);
                    } else if (c4 == 3) {
                        c4 = c2528k2.m7081c(5);
                        if (c2528k.m7084e()) {
                            c2528k2.m7078b(5);
                            if (c2528k.m7084e()) {
                                c2528k2.m7078b(4);
                            }
                            if (c2528k.m7084e()) {
                                c2528k2.m7078b(4);
                            }
                            if (c2528k.m7084e()) {
                                c2528k2.m7078b(4);
                            }
                            if (c2528k.m7084e()) {
                                c2528k2.m7078b(4);
                            }
                            if (c2528k.m7084e()) {
                                c2528k2.m7078b(4);
                            }
                            if (c2528k.m7084e()) {
                                c2528k2.m7078b(4);
                            }
                            if (c2528k.m7084e()) {
                                c2528k2.m7078b(4);
                            }
                            if (c2528k.m7084e()) {
                                if (c2528k.m7084e()) {
                                    c2528k2.m7078b(4);
                                }
                                if (c2528k.m7084e()) {
                                    c2528k2.m7078b(4);
                                }
                            }
                        }
                        if (c2528k.m7084e()) {
                            c2528k2.m7078b(5);
                            if (c2528k.m7084e()) {
                                c2528k2.m7078b(7);
                                if (c2528k.m7084e()) {
                                    c2528k2.m7078b(8);
                                }
                            }
                        }
                        c2528k2.m7078b((c4 + 2) * 8);
                        c2528k.m7085f();
                    }
                    if (c3 < 2) {
                        if (c2528k.m7084e()) {
                            c2528k2.m7078b(14);
                        }
                        if (c3 == 0 && c2528k.m7084e()) {
                            c2528k2.m7078b(14);
                        }
                    }
                    if (c2528k.m7084e()) {
                        if (i6 == 0) {
                            c2528k2.m7078b(5);
                        } else {
                            for (c4 = 0; c4 < i7; c4++) {
                                if (c2528k.m7084e()) {
                                    c2528k2.m7078b(5);
                                }
                            }
                        }
                    }
                }
            }
            int i10;
            if (c2528k.m7084e()) {
                c2528k2.m7078b(5);
                if (c3 == 2) {
                    c2528k2.m7078b(4);
                }
                if (c3 >= 6) {
                    c2528k2.m7078b(2);
                }
                if (c2528k.m7084e()) {
                    c2528k2.m7078b(8);
                }
                if (c3 == 0 && c2528k.m7084e()) {
                    c2528k2.m7078b(8);
                }
                i10 = 3;
                if (c < 3) {
                    c2528k.m7082d();
                }
            } else {
                i10 = 3;
            }
            if (b == 0 && i6 != r2) {
                c2528k.m7082d();
            }
            if (b == 2 && (i6 == r2 || c2528k.m7084e())) {
                c2528k2.m7078b(6);
            }
            str2 = "audio/eac3";
            if (c2528k.m7084e() && c2528k2.m7081c(6) == 1 && c2528k2.m7081c(8) == 1) {
                str2 = "audio/eac3-joc";
            }
            i = b;
            str = str2;
            i2 = c2;
            i3 = i5;
            c = i8;
            i4 = i9;
        } else {
            str2 = "audio/ac3";
            c2528k2.m7078b(32);
            c2 = c2528k2.m7081c(2);
            c3 = C2216a.m6108a(c2, c2528k2.m7081c(6));
            c2528k2.m7078b(8);
            c4 = c2528k2.m7081c(3);
            if (!((c4 & 1) == 0 || c4 == 1)) {
                c2528k2.m7078b(2);
            }
            if ((c4 & 4) != 0) {
                c2528k2.m7078b(2);
            }
            if (c4 == 2) {
                c2528k2.m7078b(2);
            }
            str = str2;
            i2 = c3;
            i3 = f5270b[c2];
            i4 = f5272d[c4] + c2528k.m7084e();
            i = -1;
            c = 1536;
        }
        return new C2215a(str, i, i4, i3, i2, c);
    }

    /* renamed from: a */
    public static int m6110a(byte[] bArr) {
        if (bArr.length < 5) {
            return -1;
        }
        return C2216a.m6108a((bArr[4] & JfifUtil.MARKER_SOFn) >> 6, bArr[4] & 63);
    }

    /* renamed from: a */
    public static int m6109a(ByteBuffer byteBuffer) {
        int i = 6;
        if (((byteBuffer.get(byteBuffer.position() + 4) & JfifUtil.MARKER_SOFn) >> 6) != 3) {
            i = f5269a[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4];
        }
        return i * 256;
    }

    /* renamed from: a */
    private static int m6108a(int i, int i2) {
        int i3 = i2 / 2;
        if (i >= 0 && i < f5270b.length && i2 >= 0) {
            if (i3 < f5274f.length) {
                i = f5270b[i];
                if (i == 44100) {
                    return (f5274f[i3] + (i2 % 2)) * 2;
                }
                i2 = f5273e[i3];
                return i == 32000 ? i2 * 6 : i2 * 4;
            }
        }
        return -1;
    }
}
