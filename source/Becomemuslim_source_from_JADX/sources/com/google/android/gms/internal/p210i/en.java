package com.google.android.gms.internal.p210i;

import com.facebook.imageutils.JfifUtil;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.i.en */
final class en extends el {
    /* renamed from: d */
    private final byte[] f24473d;
    /* renamed from: e */
    private final boolean f24474e;
    /* renamed from: f */
    private int f24475f;
    /* renamed from: g */
    private int f24476g;
    /* renamed from: h */
    private int f24477h;
    /* renamed from: i */
    private int f24478i;
    /* renamed from: j */
    private int f24479j;
    /* renamed from: k */
    private int f24480k;

    private en(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.f24480k = Integer.MAX_VALUE;
        this.f24473d = bArr;
        this.f24475f = i2 + i;
        this.f24477h = i;
        this.f24478i = this.f24477h;
        this.f24474e = z;
    }

    /* renamed from: a */
    public final int mo4432a() {
        if (mo4457t()) {
            this.f24479j = 0;
            return 0;
        }
        this.f24479j = m31351v();
        if ((this.f24479j >>> 3) != 0) {
            return this.f24479j;
        }
        throw new fs("Protocol message contained an invalid tag (zero).");
    }

    /* renamed from: a */
    public final void mo4434a(int i) {
        if (this.f24479j != i) {
            throw fs.m20571d();
        }
    }

    /* renamed from: b */
    public final boolean mo4436b(int i) {
        int i2 = 0;
        switch (i & 7) {
            case 0:
                if (this.f24475f - this.f24477h >= 10) {
                    while (i2 < 10) {
                        i = this.f24473d;
                        int i3 = this.f24477h;
                        this.f24477h = i3 + 1;
                        if (i[i3] < 0) {
                            i2++;
                        }
                    }
                    throw fs.m20570c();
                }
                while (i2 < 10) {
                    if (m31350A() < 0) {
                        i2++;
                    }
                }
                throw fs.m20570c();
                return true;
            case 1:
                mo4443f(8);
                return true;
            case 2:
                mo4443f(m31351v());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                mo4443f(4);
                return true;
            default:
                throw fs.m20572e();
        }
        int a;
        do {
            a = mo4432a();
            if (a != 0) {
            }
            mo4434a(((i >>> 3) << 3) | 4);
            return true;
        } while (mo4436b(a));
        mo4434a(((i >>> 3) << 3) | 4);
        return true;
    }

    /* renamed from: b */
    public final double mo4435b() {
        return Double.longBitsToDouble(m31354y());
    }

    /* renamed from: c */
    public final float mo4437c() {
        return Float.intBitsToFloat(m31353x());
    }

    /* renamed from: d */
    public final long mo4439d() {
        return m31352w();
    }

    /* renamed from: e */
    public final long mo4440e() {
        return m31352w();
    }

    /* renamed from: f */
    public final int mo4442f() {
        return m31351v();
    }

    /* renamed from: g */
    public final long mo4444g() {
        return m31354y();
    }

    /* renamed from: h */
    public final int mo4445h() {
        return m31353x();
    }

    /* renamed from: i */
    public final boolean mo4446i() {
        return m31352w() != 0;
    }

    /* renamed from: j */
    public final String mo4447j() {
        int v = m31351v();
        if (v > 0 && v <= this.f24475f - this.f24477h) {
            String str = new String(this.f24473d, this.f24477h, v, fm.f16617a);
            this.f24477h += v;
            return str;
        } else if (v == 0) {
            return "";
        } else {
            if (v < 0) {
                throw fs.m20569b();
            }
            throw fs.m20568a();
        }
    }

    /* renamed from: k */
    public final String mo4448k() {
        int v = m31351v();
        if (v > 0 && v <= this.f24475f - this.f24477h) {
            String b = ij.m20864b(this.f24473d, this.f24477h, v);
            this.f24477h += v;
            return b;
        } else if (v == 0) {
            return "";
        } else {
            if (v <= 0) {
                throw fs.m20569b();
            }
            throw fs.m20568a();
        }
    }

    /* renamed from: a */
    public final <T extends gt> T mo4433a(hd<T> hdVar, ew ewVar) {
        int v = m31351v();
        if (this.a < this.b) {
            v = mo4438d(v);
            this.a++;
            gt gtVar = (gt) hdVar.mo6197a(this, ewVar);
            mo4434a(null);
            this.a--;
            mo4441e(v);
            return gtVar;
        }
        throw fs.m20573f();
    }

    /* renamed from: l */
    public final dy mo4449l() {
        int v = m31351v();
        if (v > 0 && v <= this.f24475f - this.f24477h) {
            dy a = dy.m20453a(this.f24473d, this.f24477h, v);
            this.f24477h += v;
            return a;
        } else if (v == 0) {
            return dy.f16513a;
        } else {
            byte[] copyOfRange;
            if (v > 0 && v <= this.f24475f - this.f24477h) {
                int i = this.f24477h;
                this.f24477h += v;
                copyOfRange = Arrays.copyOfRange(this.f24473d, i, this.f24477h);
            } else if (v > 0) {
                throw fs.m20568a();
            } else if (v == 0) {
                copyOfRange = fm.f16618b;
            } else {
                throw fs.m20569b();
            }
            return dy.m20452a(copyOfRange);
        }
    }

    /* renamed from: m */
    public final int mo4450m() {
        return m31351v();
    }

    /* renamed from: n */
    public final int mo4451n() {
        return m31351v();
    }

    /* renamed from: o */
    public final int mo4452o() {
        return m31353x();
    }

    /* renamed from: p */
    public final long mo4453p() {
        return m31354y();
    }

    /* renamed from: q */
    public final int mo4454q() {
        int v = m31351v();
        return (-(v & 1)) ^ (v >>> 1);
    }

    /* renamed from: r */
    public final long mo4455r() {
        long w = m31352w();
        return (-(w & 1)) ^ (w >>> 1);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: v */
    private final int m31351v() {
        /*
        r5 = this;
        r0 = r5.f24477h;
        r1 = r5.f24475f;
        if (r1 == r0) goto L_0x006d;
    L_0x0006:
        r1 = r5.f24473d;
        r2 = r0 + 1;
        r0 = r1[r0];
        if (r0 < 0) goto L_0x0011;
    L_0x000e:
        r5.f24477h = r2;
        return r0;
    L_0x0011:
        r3 = r5.f24475f;
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
        r5.f24477h = r3;
        return r0;
    L_0x006d:
        r0 = r5.mo4456s();
        r0 = (int) r0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.en.v():int");
    }

    /* renamed from: w */
    private final long m31352w() {
        int i = this.f24477h;
        if (this.f24475f != i) {
            byte[] bArr = this.f24473d;
            int i2 = i + 1;
            byte b = bArr[i];
            if (b >= (byte) 0) {
                this.f24477h = i2;
                return (long) b;
            } else if (this.f24475f - i2 >= 9) {
                long j;
                long j2;
                int i3 = i2 + 1;
                i = b ^ (bArr[i2] << 7);
                if (i < 0) {
                    j = (long) (i ^ -128);
                } else {
                    i2 = i3 + 1;
                    i ^= bArr[i3] << 14;
                    if (i >= 0) {
                        long j3 = (long) (i ^ 16256);
                        i = i2;
                        j2 = j3;
                    } else {
                        i3 = i2 + 1;
                        i ^= bArr[i2] << 21;
                        if (i < 0) {
                            j = (long) (i ^ -2080896);
                        } else {
                            long j4 = (long) i;
                            i = i3 + 1;
                            long j5 = (((long) bArr[i3]) << 28) ^ j4;
                            if (j5 >= 0) {
                                j2 = j5 ^ 266354560;
                            } else {
                                int i4 = i + 1;
                                j5 ^= ((long) bArr[i]) << 35;
                                if (j5 < 0) {
                                    j = -34093383808L ^ j5;
                                } else {
                                    i = i4 + 1;
                                    j5 ^= ((long) bArr[i4]) << 42;
                                    if (j5 >= 0) {
                                        j2 = j5 ^ 4363953127296L;
                                    } else {
                                        i4 = i + 1;
                                        j5 ^= ((long) bArr[i]) << 49;
                                        if (j5 < 0) {
                                            j = -558586000294016L ^ j5;
                                        } else {
                                            i = i4 + 1;
                                            j5 = (j5 ^ (((long) bArr[i4]) << 56)) ^ 71499008037633920L;
                                            if (j5 < 0) {
                                                i4 = i + 1;
                                                if (((long) bArr[i]) >= 0) {
                                                    j2 = j5;
                                                    i = i4;
                                                }
                                            } else {
                                                j2 = j5;
                                            }
                                        }
                                    }
                                }
                                j2 = j;
                                i = i4;
                            }
                        }
                    }
                    this.f24477h = i;
                    return j2;
                }
                j2 = j;
                i = i3;
                this.f24477h = i;
                return j2;
            }
        }
        return mo4456s();
    }

    /* renamed from: s */
    final long mo4456s() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte A = m31350A();
            j |= ((long) (A & 127)) << i;
            if ((A & 128) == 0) {
                return j;
            }
        }
        throw fs.m20570c();
    }

    /* renamed from: x */
    private final int m31353x() {
        int i = this.f24477h;
        if (this.f24475f - i >= 4) {
            byte[] bArr = this.f24473d;
            this.f24477h = i + 4;
            return ((bArr[i + 3] & JfifUtil.MARKER_FIRST_BYTE) << 24) | (((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) | ((bArr[i + 1] & JfifUtil.MARKER_FIRST_BYTE) << 8)) | ((bArr[i + 2] & JfifUtil.MARKER_FIRST_BYTE) << 16));
        }
        throw fs.m20568a();
    }

    /* renamed from: y */
    private final long m31354y() {
        int i = this.f24477h;
        if (this.f24475f - i >= 8) {
            byte[] bArr = this.f24473d;
            this.f24477h = i + 8;
            return ((((long) bArr[i + 7]) & 255) << 56) | (((((((((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8)) | ((((long) bArr[i + 2]) & 255) << 16)) | ((((long) bArr[i + 3]) & 255) << 24)) | ((((long) bArr[i + 4]) & 255) << 32)) | ((((long) bArr[i + 5]) & 255) << 40)) | ((((long) bArr[i + 6]) & 255) << 48));
        }
        throw fs.m20568a();
    }

    /* renamed from: d */
    public final int mo4438d(int i) {
        if (i >= 0) {
            i += mo4458u();
            int i2 = this.f24480k;
            if (i <= i2) {
                this.f24480k = i;
                m31355z();
                return i2;
            }
            throw fs.m20568a();
        }
        throw fs.m20569b();
    }

    /* renamed from: z */
    private final void m31355z() {
        this.f24475f += this.f24476g;
        int i = this.f24475f - this.f24478i;
        if (i > this.f24480k) {
            this.f24476g = i - this.f24480k;
            this.f24475f -= this.f24476g;
            return;
        }
        this.f24476g = 0;
    }

    /* renamed from: e */
    public final void mo4441e(int i) {
        this.f24480k = i;
        m31355z();
    }

    /* renamed from: t */
    public final boolean mo4457t() {
        return this.f24477h == this.f24475f;
    }

    /* renamed from: u */
    public final int mo4458u() {
        return this.f24477h - this.f24478i;
    }

    /* renamed from: A */
    private final byte m31350A() {
        if (this.f24477h != this.f24475f) {
            byte[] bArr = this.f24473d;
            int i = this.f24477h;
            this.f24477h = i + 1;
            return bArr[i];
        }
        throw fs.m20568a();
    }

    /* renamed from: f */
    public final void mo4443f(int i) {
        if (i >= 0 && i <= this.f24475f - this.f24477h) {
            this.f24477h += i;
        } else if (i < 0) {
            throw fs.m20569b();
        } else {
            throw fs.m20568a();
        }
    }
}
