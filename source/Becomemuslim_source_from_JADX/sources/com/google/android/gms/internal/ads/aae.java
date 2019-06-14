package com.google.android.gms.internal.ads;

import com.facebook.imageutils.JfifUtil;

final class aae {
    /* renamed from: a */
    static int m17815a(int i, byte[] bArr, int i2, int i3, aaf aaf) {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 5) {
                return i2 + 4;
            }
            switch (i4) {
                case 0:
                    return m17822b(bArr, i2, aaf);
                case 1:
                    return i2 + 8;
                case 2:
                    return m17820a(bArr, i2, aaf) + aaf.f14129a;
                case 3:
                    i = (i & -8) | 4;
                    i4 = 0;
                    while (i2 < i3) {
                        i2 = m17820a(bArr, i2, aaf);
                        i4 = aaf.f14129a;
                        if (i4 != i) {
                            i2 = m17815a(i4, bArr, i2, i3, aaf);
                        } else if (i2 > i3 && r0 == i) {
                            return i2;
                        } else {
                            throw abw.m17951g();
                        }
                    }
                    if (i2 > i3) {
                    }
                    throw abw.m17951g();
                default:
                    throw abw.m17948d();
            }
        }
        throw abw.m17948d();
    }

    /* renamed from: a */
    static int m17816a(int i, byte[] bArr, int i2, int i3, abv<?> abv, aaf aaf) {
        abr abr = (abr) abv;
        i2 = m17820a(bArr, i2, aaf);
        while (true) {
            abr.m36717c(aaf.f14129a);
            if (i2 >= i3) {
                break;
            }
            int a = m17820a(bArr, i2, aaf);
            if (i != aaf.f14129a) {
                break;
            }
            i2 = m17820a(bArr, a, aaf);
        }
        return i2;
    }

    /* renamed from: a */
    static int m17817a(int i, byte[] bArr, int i2, int i3, aek aek, aaf aaf) {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 != 5) {
                switch (i4) {
                    case 0:
                        int b = m17822b(bArr, i2, aaf);
                        aek.m18199a(i, Long.valueOf(aaf.f14130b));
                        return b;
                    case 1:
                        aek.m18199a(i, Long.valueOf(m17823b(bArr, i2)));
                        return i2 + 8;
                    case 2:
                        i2 = m17820a(bArr, i2, aaf);
                        i3 = aaf.f14129a;
                        aek.m18199a(i, i3 == 0 ? aai.f14132a : aai.m17832a(bArr, i2, i3));
                        return i2 + i3;
                    case 3:
                        Object b2 = aek.m18198b();
                        int i5 = (i & -8) | 4;
                        i4 = 0;
                        while (i2 < i3) {
                            int a = m17820a(bArr, i2, aaf);
                            i2 = aaf.f14129a;
                            if (i2 != i5) {
                                i4 = i2;
                                i2 = m17817a(i2, bArr, a, i3, (aek) b2, aaf);
                            } else {
                                i4 = i2;
                                i2 = a;
                                if (i2 <= i3 || r0 != i5) {
                                    throw abw.m17951g();
                                }
                                aek.m18199a(i, b2);
                                return i2;
                            }
                        }
                        if (i2 <= i3) {
                        }
                        throw abw.m17951g();
                    default:
                        throw abw.m17948d();
                }
            }
            aek.m18199a(i, Integer.valueOf(m17819a(bArr, i2)));
            return i2 + 4;
        }
        throw abw.m17948d();
    }

    /* renamed from: a */
    static int m17818a(int i, byte[] bArr, int i2, aaf aaf) {
        int i3;
        i &= 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= (byte) 0) {
            i3 = b << 7;
        } else {
            i |= (b & 127) << 7;
            i2 = i4 + 1;
            byte b2 = bArr[i4];
            if (b2 >= (byte) 0) {
                i3 = b2 << 14;
            } else {
                i |= (b2 & 127) << 14;
                i4 = i2 + 1;
                b = bArr[i2];
                if (b >= (byte) 0) {
                    i3 = b << 21;
                } else {
                    i |= (b & 127) << 21;
                    i2 = i4 + 1;
                    b2 = bArr[i4];
                    if (b2 >= (byte) 0) {
                        i3 = b2 << 28;
                    } else {
                        i |= (b2 & 127) << 28;
                        while (true) {
                            i4 = i2 + 1;
                            if (bArr[i2] >= (byte) 0) {
                                aaf.f14129a = i;
                                return i4;
                            }
                            i2 = i4;
                        }
                    }
                }
            }
            aaf.f14129a = i | i3;
            return i2;
        }
        aaf.f14129a = i | i3;
        return i4;
    }

    /* renamed from: a */
    static int m17819a(byte[] bArr, int i) {
        return ((bArr[i + 3] & JfifUtil.MARKER_FIRST_BYTE) << 24) | (((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) | ((bArr[i + 1] & JfifUtil.MARKER_FIRST_BYTE) << 8)) | ((bArr[i + 2] & JfifUtil.MARKER_FIRST_BYTE) << 16));
    }

    /* renamed from: a */
    static int m17820a(byte[] bArr, int i, aaf aaf) {
        int i2 = i + 1;
        i = bArr[i];
        if (i < (byte) 0) {
            return m17818a(i, bArr, i2, aaf);
        }
        aaf.f14129a = i;
        return i2;
    }

    /* renamed from: a */
    static int m17821a(byte[] bArr, int i, abv<?> abv, aaf aaf) {
        abr abr = (abr) abv;
        i = m17820a(bArr, i, aaf);
        int i2 = aaf.f14129a + i;
        while (i < i2) {
            i = m17820a(bArr, i, aaf);
            abr.m36717c(aaf.f14129a);
        }
        if (i == i2) {
            return i;
        }
        throw abw.m17945a();
    }

    /* renamed from: b */
    static int m17822b(byte[] bArr, int i, aaf aaf) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j >= 0) {
            aaf.f14130b = j;
            return i2;
        }
        j &= 127;
        i = i2 + 1;
        byte b = bArr[i2];
        long j2 = j | (((long) (b & 127)) << 7);
        int i3 = 7;
        while (b < (byte) 0) {
            i2 = i + 1;
            byte b2 = bArr[i];
            i3 += 7;
            j2 |= ((long) (b2 & 127)) << i3;
            int i4 = i2;
            b = b2;
            i = i4;
        }
        aaf.f14130b = j2;
        return i;
    }

    /* renamed from: b */
    static long m17823b(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((((((((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8)) | ((((long) bArr[i + 2]) & 255) << 16)) | ((((long) bArr[i + 3]) & 255) << 24)) | ((((long) bArr[i + 4]) & 255) << 32)) | ((((long) bArr[i + 5]) & 255) << 40)) | ((((long) bArr[i + 6]) & 255) << 48));
    }

    /* renamed from: c */
    static double m17824c(byte[] bArr, int i) {
        return Double.longBitsToDouble(m17823b(bArr, i));
    }

    /* renamed from: c */
    static int m17825c(byte[] bArr, int i, aaf aaf) {
        i = m17820a(bArr, i, aaf);
        int i2 = aaf.f14129a;
        if (i2 == 0) {
            aaf.f14131c = "";
            return i;
        }
        aaf.f14131c = new String(bArr, i, i2, abs.f14236a);
        return i + i2;
    }

    /* renamed from: d */
    static float m17826d(byte[] bArr, int i) {
        return Float.intBitsToFloat(m17819a(bArr, i));
    }

    /* renamed from: d */
    static int m17827d(byte[] bArr, int i, aaf aaf) {
        i = m17820a(bArr, i, aaf);
        int i2 = aaf.f14129a;
        if (i2 == 0) {
            aaf.f14131c = "";
            return i;
        }
        int i3 = i + i2;
        if (aer.m18268a(bArr, i, i3)) {
            aaf.f14131c = new String(bArr, i, i2, abs.f14236a);
            return i3;
        }
        throw abw.m17952h();
    }

    /* renamed from: e */
    static int m17828e(byte[] bArr, int i, aaf aaf) {
        i = m17820a(bArr, i, aaf);
        int i2 = aaf.f14129a;
        if (i2 == 0) {
            aaf.f14131c = aai.f14132a;
            return i;
        }
        aaf.f14131c = aai.m17832a(bArr, i, i2);
        return i + i2;
    }
}
