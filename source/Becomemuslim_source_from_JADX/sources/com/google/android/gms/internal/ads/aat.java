package com.google.android.gms.internal.ads;

import com.facebook.imageutils.JfifUtil;
import java.util.Arrays;

final class aat extends aar {
    /* renamed from: d */
    private final byte[] f23518d;
    /* renamed from: e */
    private final boolean f23519e;
    /* renamed from: f */
    private int f23520f;
    /* renamed from: g */
    private int f23521g;
    /* renamed from: h */
    private int f23522h;
    /* renamed from: i */
    private int f23523i;
    /* renamed from: j */
    private int f23524j;
    /* renamed from: k */
    private int f23525k;

    private aat(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.f23525k = Integer.MAX_VALUE;
        this.f23518d = bArr;
        this.f23520f = i2 + i;
        this.f23522h = i;
        this.f23523i = this.f23522h;
        this.f23519e = z;
    }

    /* renamed from: A */
    private final byte m29509A() {
        if (this.f23522h != this.f23520f) {
            byte[] bArr = this.f23518d;
            int i = this.f23522h;
            this.f23522h = i + 1;
            return bArr[i];
        }
        throw abw.m17945a();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: v */
    private final int m29510v() {
        /*
        r5 = this;
        r0 = r5.f23522h;
        r1 = r5.f23520f;
        if (r1 == r0) goto L_0x006d;
    L_0x0006:
        r1 = r5.f23518d;
        r2 = r0 + 1;
        r0 = r1[r0];
        if (r0 < 0) goto L_0x0011;
    L_0x000e:
        r5.f23522h = r2;
        return r0;
    L_0x0011:
        r3 = r5.f23520f;
        r3 = r3 - r2;
        r4 = 9;
        if (r3 < r4) goto L_0x006d;
    L_0x0018:
        r3 = r2 + 1;
        r2 = r1[r2];
        r2 = r2 << 7;
        r0 = r0 ^ r2;
        if (r0 >= 0) goto L_0x0024;
    L_0x0021:
        r0 = r0 ^ -128;
        goto L_0x006a;
    L_0x0024:
        r2 = r3 + 1;
        r3 = r1[r3];
        r3 = r3 << 14;
        r0 = r0 ^ r3;
        if (r0 < 0) goto L_0x0031;
    L_0x002d:
        r0 = r0 ^ 16256;
    L_0x002f:
        r3 = r2;
        goto L_0x006a;
    L_0x0031:
        r3 = r2 + 1;
        r2 = r1[r2];
        r2 = r2 << 21;
        r0 = r0 ^ r2;
        if (r0 >= 0) goto L_0x003f;
    L_0x003a:
        r1 = -2080896; // 0xffffffffffe03f80 float:NaN double:NaN;
        r0 = r0 ^ r1;
        goto L_0x006a;
    L_0x003f:
        r2 = r3 + 1;
        r3 = r1[r3];
        r4 = r3 << 28;
        r0 = r0 ^ r4;
        r4 = 266354560; // 0xfe03f80 float:2.2112565E-29 double:1.315966377E-315;
        r0 = r0 ^ r4;
        if (r3 >= 0) goto L_0x002f;
    L_0x004c:
        r3 = r2 + 1;
        r2 = r1[r2];
        if (r2 >= 0) goto L_0x006a;
    L_0x0052:
        r2 = r3 + 1;
        r3 = r1[r3];
        if (r3 >= 0) goto L_0x002f;
    L_0x0058:
        r3 = r2 + 1;
        r2 = r1[r2];
        if (r2 >= 0) goto L_0x006a;
    L_0x005e:
        r2 = r3 + 1;
        r3 = r1[r3];
        if (r3 >= 0) goto L_0x002f;
    L_0x0064:
        r3 = r2 + 1;
        r1 = r1[r2];
        if (r1 < 0) goto L_0x006d;
    L_0x006a:
        r5.f23522h = r3;
        return r0;
    L_0x006d:
        r0 = r5.mo3640s();
        r0 = (int) r0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aat.v():int");
    }

    /* renamed from: w */
    private final long m29511w() {
        int i = this.f23522h;
        if (this.f23520f != i) {
            byte[] bArr = this.f23518d;
            int i2 = i + 1;
            byte b = bArr[i];
            if (b >= (byte) 0) {
                this.f23522h = i2;
                return (long) b;
            } else if (this.f23520f - i2 >= 9) {
                long j;
                int i3 = i2 + 1;
                i = b ^ (bArr[i2] << 7);
                if (i < 0) {
                    i ^= -128;
                } else {
                    i2 = i3 + 1;
                    i ^= bArr[i3] << 14;
                    if (i >= 0) {
                        long j2 = (long) (i ^ 16256);
                        i = i2;
                        j = j2;
                    } else {
                        i3 = i2 + 1;
                        i ^= bArr[i2] << 21;
                        if (i < 0) {
                            i ^= -2080896;
                        } else {
                            long j3 = (long) i;
                            i = i3 + 1;
                            long j4 = (((long) bArr[i3]) << 28) ^ j3;
                            if (j4 >= 0) {
                                j3 = 266354560;
                            } else {
                                long j5;
                                int i4 = i + 1;
                                j4 ^= ((long) bArr[i]) << 35;
                                if (j4 < 0) {
                                    j5 = -34093383808L;
                                } else {
                                    i = i4 + 1;
                                    j4 ^= ((long) bArr[i4]) << 42;
                                    if (j4 >= 0) {
                                        j3 = 4363953127296L;
                                    } else {
                                        i4 = i + 1;
                                        j4 ^= ((long) bArr[i]) << 49;
                                        if (j4 < 0) {
                                            j5 = -558586000294016L;
                                        } else {
                                            i = i4 + 1;
                                            j4 = (j4 ^ (((long) bArr[i4]) << 56)) ^ 71499008037633920L;
                                            if (j4 < 0) {
                                                i4 = i + 1;
                                                if (((long) bArr[i]) >= 0) {
                                                    j = j4;
                                                    i = i4;
                                                }
                                            } else {
                                                j = j4;
                                            }
                                        }
                                    }
                                }
                                j = j5 ^ j4;
                                i = i4;
                            }
                            j = j4 ^ j3;
                        }
                    }
                    this.f23522h = i;
                    return j;
                }
                j = (long) i;
                i = i3;
                this.f23522h = i;
                return j;
            }
        }
        return mo3640s();
    }

    /* renamed from: x */
    private final int m29512x() {
        int i = this.f23522h;
        if (this.f23520f - i >= 4) {
            byte[] bArr = this.f23518d;
            this.f23522h = i + 4;
            return ((bArr[i + 3] & JfifUtil.MARKER_FIRST_BYTE) << 24) | (((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) | ((bArr[i + 1] & JfifUtil.MARKER_FIRST_BYTE) << 8)) | ((bArr[i + 2] & JfifUtil.MARKER_FIRST_BYTE) << 16));
        }
        throw abw.m17945a();
    }

    /* renamed from: y */
    private final long m29513y() {
        int i = this.f23522h;
        if (this.f23520f - i >= 8) {
            byte[] bArr = this.f23518d;
            this.f23522h = i + 8;
            return ((((long) bArr[i + 7]) & 255) << 56) | (((((((((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8)) | ((((long) bArr[i + 2]) & 255) << 16)) | ((((long) bArr[i + 3]) & 255) << 24)) | ((((long) bArr[i + 4]) & 255) << 32)) | ((((long) bArr[i + 5]) & 255) << 40)) | ((((long) bArr[i + 6]) & 255) << 48));
        }
        throw abw.m17945a();
    }

    /* renamed from: z */
    private final void m29514z() {
        this.f23520f += this.f23521g;
        int i = this.f23520f - this.f23523i;
        if (i > this.f23525k) {
            this.f23521g = i - this.f23525k;
            this.f23520f -= this.f23521g;
            return;
        }
        this.f23521g = 0;
    }

    /* renamed from: a */
    public final int mo3617a() {
        if (mo3641t()) {
            this.f23524j = 0;
            return 0;
        }
        this.f23524j = m29510v();
        if ((this.f23524j >>> 3) != 0) {
            return this.f23524j;
        }
        throw abw.m17948d();
    }

    /* renamed from: a */
    public final void mo3618a(int i) {
        if (this.f23524j != i) {
            throw abw.m17949e();
        }
    }

    /* renamed from: b */
    public final double mo3619b() {
        return Double.longBitsToDouble(m29513y());
    }

    /* renamed from: b */
    public final boolean mo3620b(int i) {
        int i2 = 0;
        switch (i & 7) {
            case 0:
                if (this.f23520f - this.f23522h >= 10) {
                    while (i2 < 10) {
                        byte[] bArr = this.f23518d;
                        int i3 = this.f23522h;
                        this.f23522h = i3 + 1;
                        if (bArr[i3] < (byte) 0) {
                            i2++;
                        }
                    }
                    throw abw.m17947c();
                }
                while (i2 < 10) {
                    if (m29509A() < (byte) 0) {
                        i2++;
                    }
                }
                throw abw.m17947c();
                return true;
            case 1:
                mo3626e(8);
                return true;
            case 2:
                mo3626e(m29510v());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                mo3626e(4);
                return true;
            default:
                throw abw.m17950f();
        }
        int a;
        do {
            a = mo3617a();
            if (a != 0) {
            }
            mo3618a(((i >>> 3) << 3) | 4);
            return true;
        } while (mo3620b(a));
        mo3618a(((i >>> 3) << 3) | 4);
        return true;
    }

    /* renamed from: c */
    public final float mo3621c() {
        return Float.intBitsToFloat(m29512x());
    }

    /* renamed from: c */
    public final int mo3622c(int i) {
        if (i >= 0) {
            i += mo3642u();
            int i2 = this.f23525k;
            if (i <= i2) {
                this.f23525k = i;
                m29514z();
                return i2;
            }
            throw abw.m17945a();
        }
        throw abw.m17946b();
    }

    /* renamed from: d */
    public final long mo3623d() {
        return m29511w();
    }

    /* renamed from: d */
    public final void mo3624d(int i) {
        this.f23525k = i;
        m29514z();
    }

    /* renamed from: e */
    public final long mo3625e() {
        return m29511w();
    }

    /* renamed from: e */
    public final void mo3626e(int i) {
        if (i >= 0 && i <= this.f23520f - this.f23522h) {
            this.f23522h += i;
        } else if (i < 0) {
            throw abw.m17946b();
        } else {
            throw abw.m17945a();
        }
    }

    /* renamed from: f */
    public final int mo3627f() {
        return m29510v();
    }

    /* renamed from: g */
    public final long mo3628g() {
        return m29513y();
    }

    /* renamed from: h */
    public final int mo3629h() {
        return m29512x();
    }

    /* renamed from: i */
    public final boolean mo3630i() {
        return m29511w() != 0;
    }

    /* renamed from: j */
    public final String mo3631j() {
        int v = m29510v();
        if (v > 0 && v <= this.f23520f - this.f23522h) {
            String str = new String(this.f23518d, this.f23522h, v, abs.f14236a);
            this.f23522h += v;
            return str;
        } else if (v == 0) {
            return "";
        } else {
            if (v < 0) {
                throw abw.m17946b();
            }
            throw abw.m17945a();
        }
    }

    /* renamed from: k */
    public final String mo3632k() {
        int v = m29510v();
        if (v <= 0 || v > this.f23520f - this.f23522h) {
            if (v == 0) {
                return "";
            }
            if (v <= 0) {
                throw abw.m17946b();
            }
            throw abw.m17945a();
        } else if (aer.m18268a(this.f23518d, this.f23522h, this.f23522h + v)) {
            int i = this.f23522h;
            this.f23522h += v;
            return new String(this.f23518d, i, v, abs.f14236a);
        } else {
            throw abw.m17952h();
        }
    }

    /* renamed from: l */
    public final aai mo3633l() {
        int v = m29510v();
        if (v > 0 && v <= this.f23520f - this.f23522h) {
            aai a = aai.m17832a(this.f23518d, this.f23522h, v);
            this.f23522h += v;
            return a;
        } else if (v == 0) {
            return aai.f14132a;
        } else {
            byte[] copyOfRange;
            if (v > 0 && v <= this.f23520f - this.f23522h) {
                int i = this.f23522h;
                this.f23522h += v;
                copyOfRange = Arrays.copyOfRange(this.f23518d, i, this.f23522h);
            } else if (v > 0) {
                throw abw.m17945a();
            } else if (v == 0) {
                copyOfRange = abs.f14237b;
            } else {
                throw abw.m17946b();
            }
            return aai.m17834b(copyOfRange);
        }
    }

    /* renamed from: m */
    public final int mo3634m() {
        return m29510v();
    }

    /* renamed from: n */
    public final int mo3635n() {
        return m29510v();
    }

    /* renamed from: o */
    public final int mo3636o() {
        return m29512x();
    }

    /* renamed from: p */
    public final long mo3637p() {
        return m29513y();
    }

    /* renamed from: q */
    public final int mo3638q() {
        return aar.m17854f(m29510v());
    }

    /* renamed from: r */
    public final long mo3639r() {
        return aar.m17852a(m29511w());
    }

    /* renamed from: s */
    final long mo3640s() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte A = m29509A();
            j |= ((long) (A & 127)) << i;
            if ((A & 128) == 0) {
                return j;
            }
        }
        throw abw.m17947c();
    }

    /* renamed from: t */
    public final boolean mo3641t() {
        return this.f23522h == this.f23520f;
    }

    /* renamed from: u */
    public final int mo3642u() {
        return this.f23522h - this.f23523i;
    }
}
