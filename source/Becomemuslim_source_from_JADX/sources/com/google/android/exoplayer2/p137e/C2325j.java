package com.google.android.exoplayer2.p137e;

import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.facebook.imageutils.JfifUtil;

/* compiled from: MpegAudioHeader */
/* renamed from: com.google.android.exoplayer2.e.j */
public final class C2325j {
    /* renamed from: h */
    private static final String[] f5762h = new String[]{"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};
    /* renamed from: i */
    private static final int[] f5763i = new int[]{44100, 48000, 32000};
    /* renamed from: j */
    private static final int[] f5764j = new int[]{32, 64, 96, 128, 160, JfifUtil.MARKER_SOFn, 224, 256, 288, 320, 352, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, 416, 448};
    /* renamed from: k */
    private static final int[] f5765k = new int[]{32, 48, 56, 64, 80, 96, 112, 128, 144, 160, 176, JfifUtil.MARKER_SOFn, 224, 256};
    /* renamed from: l */
    private static final int[] f5766l = new int[]{32, 48, 56, 64, 80, 96, 112, 128, 160, JfifUtil.MARKER_SOFn, 224, 256, 320, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT};
    /* renamed from: m */
    private static final int[] f5767m = new int[]{32, 40, 48, 56, 64, 80, 96, 112, 128, 160, JfifUtil.MARKER_SOFn, 224, 256, 320};
    /* renamed from: n */
    private static final int[] f5768n = new int[]{8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160};
    /* renamed from: a */
    public int f5769a;
    /* renamed from: b */
    public String f5770b;
    /* renamed from: c */
    public int f5771c;
    /* renamed from: d */
    public int f5772d;
    /* renamed from: e */
    public int f5773e;
    /* renamed from: f */
    public int f5774f;
    /* renamed from: g */
    public int f5775g;

    /* renamed from: a */
    public static int m6448a(int i) {
        if ((i & -2097152) != -2097152) {
            return -1;
        }
        int i2 = (i >>> 19) & 3;
        if (i2 == 1) {
            return -1;
        }
        int i3 = (i >>> 17) & 3;
        if (i3 == 0) {
            return -1;
        }
        int i4 = (i >>> 12) & 15;
        if (i4 != 0) {
            if (i4 != 15) {
                int i5 = (i >>> 10) & 3;
                if (i5 == 3) {
                    return -1;
                }
                int i6 = f5763i[i5];
                if (i2 == 2) {
                    i6 /= 2;
                } else if (i2 == 0) {
                    i6 /= 4;
                }
                i = (i >>> 9) & 1;
                if (i3 == 3) {
                    return ((((i2 == 3 ? f5764j[i4 - 1] : f5765k[i4 - 1]) * 12000) / i6) + i) * 4;
                }
                i4 = i2 == 3 ? i3 == 2 ? f5766l[i4 - 1] : f5767m[i4 - 1] : f5768n[i4 - 1];
                i5 = 144000;
                if (i2 == 3) {
                    return ((i4 * 144000) / i6) + i;
                }
                if (i3 == 1) {
                    i5 = 72000;
                }
                return ((i5 * i4) / i6) + i;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static boolean m6450a(int i, C2325j c2325j) {
        if ((i & -2097152) != -2097152) {
            return false;
        }
        int i2 = (i >>> 19) & 3;
        if (i2 == 1) {
            return false;
        }
        int i3 = (i >>> 17) & 3;
        if (i3 == 0) {
            return false;
        }
        int i4 = (i >>> 12) & 15;
        if (i4 != 0) {
            if (i4 != 15) {
                int i5 = (i >>> 10) & 3;
                if (i5 == 3) {
                    return false;
                }
                int i6;
                int i7;
                int i8 = f5763i[i5];
                if (i2 == 2) {
                    i8 /= 2;
                } else if (i2 == 0) {
                    i8 /= 4;
                }
                int i9 = i8;
                i8 = (i >>> 9) & 1;
                int i10 = 1152;
                if (i3 == 3) {
                    i4 = i2 == 3 ? f5764j[i4 - 1] : f5765k[i4 - 1];
                    i6 = (((i4 * 12000) / i9) + i8) * 4;
                    i7 = BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT;
                } else {
                    i6 = 144000;
                    if (i2 == 3) {
                        i4 = i3 == 2 ? f5766l[i4 - 1] : f5767m[i4 - 1];
                        i6 = ((144000 * i4) / i9) + i8;
                        i7 = 1152;
                    } else {
                        i4 = f5768n[i4 - 1];
                        if (i3 == 1) {
                            i10 = 576;
                        }
                        if (i3 == 1) {
                            i6 = 72000;
                        }
                        i6 = ((i6 * i4) / i9) + i8;
                        i7 = i10;
                    }
                }
                c2325j.m6449a(i2, f5762h[3 - i3], i6, i9, ((i >> 6) & 3) == 3 ? 1 : 2, i4 * 1000, i7);
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m6449a(int i, String str, int i2, int i3, int i4, int i5, int i6) {
        this.f5769a = i;
        this.f5770b = str;
        this.f5771c = i2;
        this.f5772d = i3;
        this.f5773e = i4;
        this.f5774f = i5;
        this.f5775g = i6;
    }
}
