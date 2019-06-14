package com.google.p217b.p222b;

import com.facebook.imageutils.JfifUtil;
import com.google.p217b.C5254e;
import java.nio.charset.Charset;
import java.util.Map;

/* compiled from: StringUtils */
/* renamed from: com.google.b.b.l */
public final class C5209l {
    /* renamed from: a */
    private static final String f17597a = Charset.defaultCharset().name();
    /* renamed from: b */
    private static final boolean f17598b;

    static {
        boolean z;
        if (!"SJIS".equalsIgnoreCase(f17597a)) {
            if (!"EUC_JP".equalsIgnoreCase(f17597a)) {
                z = false;
                f17598b = z;
            }
        }
        z = true;
        f17598b = z;
    }

    /* renamed from: a */
    public static String m22045a(byte[] bArr, Map<C5254e, ?> map) {
        byte[] bArr2 = bArr;
        Map<C5254e, ?> map2 = map;
        if (map2 != null && map2.containsKey(C5254e.CHARACTER_SET)) {
            return map2.get(C5254e.CHARACTER_SET).toString();
        }
        int length = bArr2.length;
        int i = 0;
        Object obj = (bArr2.length > 3 && bArr2[0] == (byte) -17 && bArr2[1] == (byte) -69 && bArr2[2] == (byte) -65) ? 1 : null;
        int i2 = 0;
        int i3 = 0;
        Object obj2 = 1;
        Object obj3 = 1;
        Object obj4 = 1;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i3 < length && (obj2 != null || obj3 != null || obj4 != null)) {
            int i13 = bArr2[i3] & JfifUtil.MARKER_FIRST_BYTE;
            if (obj4 != null) {
                if (i4 > 0) {
                    if ((i13 & 128) != 0) {
                        i4--;
                    }
                } else if ((i13 & 128) != 0) {
                    if ((i13 & 64) != 0) {
                        i4++;
                        if ((i13 & 32) == 0) {
                            i6++;
                        } else {
                            i4++;
                            if ((i13 & 16) == 0) {
                                i7++;
                            } else {
                                i4++;
                                if ((i13 & 8) == 0) {
                                    i8++;
                                }
                            }
                        }
                    }
                }
                obj4 = null;
            }
            if (obj2 != null) {
                if (i13 > 127 && i13 < 160) {
                    obj2 = null;
                } else if (i13 > 159 && (i13 < JfifUtil.MARKER_SOFn || i13 == JfifUtil.MARKER_RST7 || i13 == 247)) {
                    i10++;
                }
            }
            if (obj3 != null) {
                if (i5 > 0) {
                    if (i13 >= 64 && i13 != 127) {
                        if (i13 <= 252) {
                            i5--;
                        }
                    }
                } else if (!(i13 == 128 || i13 == 160)) {
                    if (i13 <= 239) {
                        int i14;
                        if (i13 > 160 && i13 < 224) {
                            i2++;
                            i14 = i11 + 1;
                            if (i14 > i9) {
                                i9 = i14;
                                i11 = i9;
                            } else {
                                i11 = i14;
                            }
                        } else if (i13 > 127) {
                            i5++;
                            i14 = i12 + 1;
                            if (i14 > i) {
                                i = i14;
                                i12 = i;
                            } else {
                                i12 = i14;
                            }
                            i11 = 0;
                        } else {
                            i11 = 0;
                        }
                        i12 = 0;
                    }
                }
                obj3 = null;
            }
            i3++;
            bArr2 = bArr;
        }
        if (obj4 != null && i4 > 0) {
            obj4 = null;
        }
        Object obj5 = (obj3 == null || i5 <= 0) ? obj3 : null;
        if (obj4 != null && (obj != null || (i6 + i7) + i8 > 0)) {
            return "UTF8";
        }
        if (obj5 != null && (f17598b || i9 >= 3 || i >= 3)) {
            return "SJIS";
        }
        if (obj2 != null && obj5 != null) {
            return (!(i9 == 2 && i2 == 2) && i10 * 10 < length) ? "ISO8859_1" : "SJIS";
        } else {
            if (obj2 != null) {
                return "ISO8859_1";
            }
            if (obj5 != null) {
                return "SJIS";
            }
            return obj4 != null ? "UTF8" : f17597a;
        }
    }
}
