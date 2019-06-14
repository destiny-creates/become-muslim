package com.google.android.exoplayer2.p164l;

import android.util.Log;
import com.facebook.imageutils.JfifUtil;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: NalUnitUtil */
/* renamed from: com.google.android.exoplayer2.l.j */
public final class C2527j {
    /* renamed from: a */
    public static final byte[] f6433a = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 1};
    /* renamed from: b */
    public static final float[] f6434b = new float[]{1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    /* renamed from: c */
    private static final Object f6435c = new Object();
    /* renamed from: d */
    private static int[] f6436d = new int[10];

    /* compiled from: NalUnitUtil */
    /* renamed from: com.google.android.exoplayer2.l.j$a */
    public static final class C2525a {
        /* renamed from: a */
        public final int f6420a;
        /* renamed from: b */
        public final int f6421b;
        /* renamed from: c */
        public final boolean f6422c;

        public C2525a(int i, int i2, boolean z) {
            this.f6420a = i;
            this.f6421b = i2;
            this.f6422c = z;
        }
    }

    /* compiled from: NalUnitUtil */
    /* renamed from: com.google.android.exoplayer2.l.j$b */
    public static final class C2526b {
        /* renamed from: a */
        public final int f6423a;
        /* renamed from: b */
        public final int f6424b;
        /* renamed from: c */
        public final int f6425c;
        /* renamed from: d */
        public final float f6426d;
        /* renamed from: e */
        public final boolean f6427e;
        /* renamed from: f */
        public final boolean f6428f;
        /* renamed from: g */
        public final int f6429g;
        /* renamed from: h */
        public final int f6430h;
        /* renamed from: i */
        public final int f6431i;
        /* renamed from: j */
        public final boolean f6432j;

        public C2526b(int i, int i2, int i3, float f, boolean z, boolean z2, int i4, int i5, int i6, boolean z3) {
            this.f6423a = i;
            this.f6424b = i2;
            this.f6425c = i3;
            this.f6426d = f;
            this.f6427e = z;
            this.f6428f = z2;
            this.f6429g = i4;
            this.f6430h = i5;
            this.f6431i = i6;
            this.f6432j = z3;
        }
    }

    /* renamed from: a */
    public static int m7060a(byte[] bArr, int i) {
        synchronized (f6435c) {
            int i2;
            int i3 = 0;
            int i4 = 0;
            while (i3 < i) {
                i3 = C2527j.m7070c(bArr, i3, i);
                if (i3 < i) {
                    if (f6436d.length <= i4) {
                        f6436d = Arrays.copyOf(f6436d, f6436d.length * 2);
                    }
                    i2 = i4 + 1;
                    f6436d[i4] = i3;
                    i3 += 3;
                    i4 = i2;
                }
            }
            i -= i4;
            int i5 = 0;
            i2 = 0;
            for (i3 = 0; i3 < i4; i3++) {
                int i6 = f6436d[i3] - i2;
                System.arraycopy(bArr, i2, bArr, i5, i6);
                i5 += i6;
                int i7 = i5 + 1;
                bArr[i5] = (byte) 0;
                i5 = i7 + 1;
                bArr[i7] = (byte) 0;
                i2 += i6 + 3;
            }
            System.arraycopy(bArr, i2, bArr, i5, i - i5);
        }
        return i;
    }

    /* renamed from: a */
    public static void m7064a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i + 1;
            if (i3 < position) {
                int i4 = byteBuffer.get(i) & JfifUtil.MARKER_FIRST_BYTE;
                if (i2 == 3) {
                    if (i4 == 1 && (byteBuffer.get(i3) & 31) == 7) {
                        ByteBuffer duplicate = byteBuffer.duplicate();
                        duplicate.position(i - 3);
                        duplicate.limit(position);
                        byteBuffer.position(0);
                        byteBuffer.put(duplicate);
                        return;
                    }
                } else if (i4 == 0) {
                    i2++;
                }
                if (i4 != 0) {
                    i2 = 0;
                }
                i = i3;
            } else {
                byteBuffer.clear();
                return;
            }
        }
    }

    /* renamed from: a */
    public static boolean m7066a(String str, byte b) {
        if ("video/avc".equals(str) && (b & 31) == 6) {
            return true;
        }
        if ("video/hevc".equals(str) == null || ((b & 126) >> 1) != (byte) 39) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    public static int m7067b(byte[] bArr, int i) {
        return bArr[i + 3] & 31;
    }

    /* renamed from: c */
    public static int m7069c(byte[] bArr, int i) {
        return (bArr[i + 3] & 126) >> 1;
    }

    /* renamed from: a */
    public static C2526b m7062a(byte[] bArr, int i, int i2) {
        boolean z;
        int d;
        int d2;
        int i3;
        int d3;
        boolean b;
        long d4;
        int i4;
        boolean z2;
        int d5;
        boolean b2;
        int i5;
        int d6;
        int d7;
        int d8;
        int i6;
        int i7;
        float f;
        int c;
        int c2;
        float f2;
        StringBuilder stringBuilder;
        C2530m c2530m = new C2530m(bArr, i, i2);
        c2530m.m7127a(8);
        int c3 = c2530m.m7131c(8);
        c2530m.m7127a(16);
        int d9 = c2530m.m7133d();
        int i8 = 1;
        if (!(c3 == 100 || c3 == 110 || c3 == 122 || c3 == 244 || c3 == 44 || c3 == 83 || c3 == 86 || c3 == 118 || c3 == 128)) {
            if (c3 != 138) {
                c3 = 1;
                z = false;
                d = c2530m.m7133d() + 4;
                d2 = c2530m.m7133d();
                if (d2 == 0) {
                    i3 = d9;
                    d3 = c2530m.m7133d() + 4;
                } else if (d2 != 1) {
                    b = c2530m.m7129b();
                    c2530m.m7134e();
                    c2530m.m7134e();
                    d4 = (long) c2530m.m7133d();
                    i3 = d9;
                    for (i4 = 0; ((long) i4) < d4; i4++) {
                        c2530m.m7133d();
                    }
                    z2 = b;
                    d3 = 0;
                    c2530m.m7133d();
                    c2530m.m7126a();
                    d5 = c2530m.m7133d() + 1;
                    d9 = c2530m.m7133d() + 1;
                    b2 = c2530m.m7129b();
                    i5 = (2 - b2) * d9;
                    if (!b2) {
                        c2530m.m7126a();
                    }
                    c2530m.m7126a();
                    d5 *= 16;
                    i5 *= 16;
                    if (c2530m.m7129b()) {
                        d9 = c2530m.m7133d();
                        d6 = c2530m.m7133d();
                        d7 = c2530m.m7133d();
                        d8 = c2530m.m7133d();
                        if (c3 != 0) {
                            i6 = 2 - b2;
                            i7 = 1;
                        } else {
                            i7 = c3 != 3 ? 1 : 2;
                            if (c3 == 1) {
                                i8 = 2;
                            }
                            i6 = (2 - b2) * i8;
                        }
                        d5 -= (d9 + d6) * i7;
                        i5 -= (d7 + d8) * i6;
                    }
                    i6 = d5;
                    i8 = i5;
                    f = 1.0f;
                    if (c2530m.m7129b() && c2530m.m7129b()) {
                        c = c2530m.m7131c(8);
                        if (c != JfifUtil.MARKER_FIRST_BYTE) {
                            c = c2530m.m7131c(16);
                            c2 = c2530m.m7131c(16);
                            if (!(c == 0 || c2 == 0)) {
                                f = ((float) c) / ((float) c2);
                            }
                            f2 = f;
                        } else if (c >= f6434b.length) {
                            f2 = f6434b[c];
                        } else {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("Unexpected aspect_ratio_idc value: ");
                            stringBuilder.append(c);
                            Log.w("NalUnitUtil", stringBuilder.toString());
                        }
                        return new C2526b(i3, i6, i8, f2, z, b2, d, d2, d3, z2);
                    }
                    f2 = 1.0f;
                    return new C2526b(i3, i6, i8, f2, z, b2, d, d2, d3, z2);
                } else {
                    i3 = d9;
                    d3 = 0;
                }
                z2 = false;
                c2530m.m7133d();
                c2530m.m7126a();
                d5 = c2530m.m7133d() + 1;
                d9 = c2530m.m7133d() + 1;
                b2 = c2530m.m7129b();
                i5 = (2 - b2) * d9;
                if (b2) {
                    c2530m.m7126a();
                }
                c2530m.m7126a();
                d5 *= 16;
                i5 *= 16;
                if (c2530m.m7129b()) {
                    d9 = c2530m.m7133d();
                    d6 = c2530m.m7133d();
                    d7 = c2530m.m7133d();
                    d8 = c2530m.m7133d();
                    if (c3 != 0) {
                        if (c3 != 3) {
                        }
                        if (c3 == 1) {
                            i8 = 2;
                        }
                        i6 = (2 - b2) * i8;
                    } else {
                        i6 = 2 - b2;
                        i7 = 1;
                    }
                    d5 -= (d9 + d6) * i7;
                    i5 -= (d7 + d8) * i6;
                }
                i6 = d5;
                i8 = i5;
                f = 1.0f;
                c = c2530m.m7131c(8);
                if (c != JfifUtil.MARKER_FIRST_BYTE) {
                    c = c2530m.m7131c(16);
                    c2 = c2530m.m7131c(16);
                    f = ((float) c) / ((float) c2);
                    f2 = f;
                } else if (c >= f6434b.length) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Unexpected aspect_ratio_idc value: ");
                    stringBuilder.append(c);
                    Log.w("NalUnitUtil", stringBuilder.toString());
                    f2 = 1.0f;
                } else {
                    f2 = f6434b[c];
                }
                return new C2526b(i3, i6, i8, f2, z, b2, d, d2, d3, z2);
            }
        }
        c3 = c2530m.m7133d();
        b = c3 == 3 ? c2530m.m7129b() : false;
        c2530m.m7133d();
        c2530m.m7133d();
        c2530m.m7126a();
        if (c2530m.m7129b()) {
            int i9 = c3 != 3 ? 8 : 12;
            i4 = 0;
            while (i4 < i9) {
                if (c2530m.m7129b()) {
                    C2527j.m7063a(c2530m, i4 < 6 ? 16 : 64);
                }
                i4++;
            }
        }
        z = b;
        d = c2530m.m7133d() + 4;
        d2 = c2530m.m7133d();
        if (d2 == 0) {
            i3 = d9;
            d3 = c2530m.m7133d() + 4;
        } else if (d2 != 1) {
            i3 = d9;
            d3 = 0;
        } else {
            b = c2530m.m7129b();
            c2530m.m7134e();
            c2530m.m7134e();
            d4 = (long) c2530m.m7133d();
            i3 = d9;
            for (i4 = 0; ((long) i4) < d4; i4++) {
                c2530m.m7133d();
            }
            z2 = b;
            d3 = 0;
            c2530m.m7133d();
            c2530m.m7126a();
            d5 = c2530m.m7133d() + 1;
            d9 = c2530m.m7133d() + 1;
            b2 = c2530m.m7129b();
            i5 = (2 - b2) * d9;
            if (b2) {
                c2530m.m7126a();
            }
            c2530m.m7126a();
            d5 *= 16;
            i5 *= 16;
            if (c2530m.m7129b()) {
                d9 = c2530m.m7133d();
                d6 = c2530m.m7133d();
                d7 = c2530m.m7133d();
                d8 = c2530m.m7133d();
                if (c3 != 0) {
                    i6 = 2 - b2;
                    i7 = 1;
                } else {
                    if (c3 != 3) {
                    }
                    if (c3 == 1) {
                        i8 = 2;
                    }
                    i6 = (2 - b2) * i8;
                }
                d5 -= (d9 + d6) * i7;
                i5 -= (d7 + d8) * i6;
            }
            i6 = d5;
            i8 = i5;
            f = 1.0f;
            c = c2530m.m7131c(8);
            if (c != JfifUtil.MARKER_FIRST_BYTE) {
                c = c2530m.m7131c(16);
                c2 = c2530m.m7131c(16);
                f = ((float) c) / ((float) c2);
                f2 = f;
            } else if (c >= f6434b.length) {
                f2 = f6434b[c];
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected aspect_ratio_idc value: ");
                stringBuilder.append(c);
                Log.w("NalUnitUtil", stringBuilder.toString());
                f2 = 1.0f;
            }
            return new C2526b(i3, i6, i8, f2, z, b2, d, d2, d3, z2);
        }
        z2 = false;
        c2530m.m7133d();
        c2530m.m7126a();
        d5 = c2530m.m7133d() + 1;
        d9 = c2530m.m7133d() + 1;
        b2 = c2530m.m7129b();
        i5 = (2 - b2) * d9;
        if (b2) {
            c2530m.m7126a();
        }
        c2530m.m7126a();
        d5 *= 16;
        i5 *= 16;
        if (c2530m.m7129b()) {
            d9 = c2530m.m7133d();
            d6 = c2530m.m7133d();
            d7 = c2530m.m7133d();
            d8 = c2530m.m7133d();
            if (c3 != 0) {
                if (c3 != 3) {
                }
                if (c3 == 1) {
                    i8 = 2;
                }
                i6 = (2 - b2) * i8;
            } else {
                i6 = 2 - b2;
                i7 = 1;
            }
            d5 -= (d9 + d6) * i7;
            i5 -= (d7 + d8) * i6;
        }
        i6 = d5;
        i8 = i5;
        f = 1.0f;
        c = c2530m.m7131c(8);
        if (c != JfifUtil.MARKER_FIRST_BYTE) {
            c = c2530m.m7131c(16);
            c2 = c2530m.m7131c(16);
            f = ((float) c) / ((float) c2);
            f2 = f;
        } else if (c >= f6434b.length) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected aspect_ratio_idc value: ");
            stringBuilder.append(c);
            Log.w("NalUnitUtil", stringBuilder.toString());
            f2 = 1.0f;
        } else {
            f2 = f6434b[c];
        }
        return new C2526b(i3, i6, i8, f2, z, b2, d, d2, d3, z2);
    }

    /* renamed from: b */
    public static C2525a m7068b(byte[] bArr, int i, int i2) {
        C2530m c2530m = new C2530m(bArr, i, i2);
        c2530m.m7127a(8);
        bArr = c2530m.m7133d();
        i = c2530m.m7133d();
        c2530m.m7126a();
        return new C2525a(bArr, i, c2530m.m7129b());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static int m7061a(byte[] r7, int r8, int r9, boolean[] r10) {
        /*
        r0 = r9 - r8;
        r1 = 0;
        r2 = 1;
        if (r0 < 0) goto L_0x0008;
    L_0x0006:
        r3 = 1;
        goto L_0x0009;
    L_0x0008:
        r3 = 0;
    L_0x0009:
        com.google.android.exoplayer2.p164l.C2516a.m7019b(r3);
        if (r0 != 0) goto L_0x000f;
    L_0x000e:
        return r9;
    L_0x000f:
        r3 = 2;
        if (r10 == 0) goto L_0x0040;
    L_0x0012:
        r4 = r10[r1];
        if (r4 == 0) goto L_0x001c;
    L_0x0016:
        com.google.android.exoplayer2.p164l.C2527j.m7065a(r10);
        r8 = r8 + -3;
        return r8;
    L_0x001c:
        if (r0 <= r2) goto L_0x002b;
    L_0x001e:
        r4 = r10[r2];
        if (r4 == 0) goto L_0x002b;
    L_0x0022:
        r4 = r7[r8];
        if (r4 != r2) goto L_0x002b;
    L_0x0026:
        com.google.android.exoplayer2.p164l.C2527j.m7065a(r10);
        r8 = r8 - r3;
        return r8;
    L_0x002b:
        if (r0 <= r3) goto L_0x0040;
    L_0x002d:
        r4 = r10[r3];
        if (r4 == 0) goto L_0x0040;
    L_0x0031:
        r4 = r7[r8];
        if (r4 != 0) goto L_0x0040;
    L_0x0035:
        r4 = r8 + 1;
        r4 = r7[r4];
        if (r4 != r2) goto L_0x0040;
    L_0x003b:
        com.google.android.exoplayer2.p164l.C2527j.m7065a(r10);
        r8 = r8 - r2;
        return r8;
    L_0x0040:
        r4 = r9 + -1;
        r8 = r8 + r3;
    L_0x0043:
        if (r8 >= r4) goto L_0x0067;
    L_0x0045:
        r5 = r7[r8];
        r5 = r5 & 254;
        if (r5 == 0) goto L_0x004c;
    L_0x004b:
        goto L_0x0064;
    L_0x004c:
        r5 = r8 + -2;
        r6 = r7[r5];
        if (r6 != 0) goto L_0x0062;
    L_0x0052:
        r6 = r8 + -1;
        r6 = r7[r6];
        if (r6 != 0) goto L_0x0062;
    L_0x0058:
        r6 = r7[r8];
        if (r6 != r2) goto L_0x0062;
    L_0x005c:
        if (r10 == 0) goto L_0x0061;
    L_0x005e:
        com.google.android.exoplayer2.p164l.C2527j.m7065a(r10);
    L_0x0061:
        return r5;
    L_0x0062:
        r8 = r8 + -2;
    L_0x0064:
        r8 = r8 + 3;
        goto L_0x0043;
    L_0x0067:
        if (r10 == 0) goto L_0x00bd;
    L_0x0069:
        if (r0 <= r3) goto L_0x007f;
    L_0x006b:
        r8 = r9 + -3;
        r8 = r7[r8];
        if (r8 != 0) goto L_0x007d;
    L_0x0071:
        r8 = r9 + -2;
        r8 = r7[r8];
        if (r8 != 0) goto L_0x007d;
    L_0x0077:
        r8 = r7[r4];
        if (r8 != r2) goto L_0x007d;
    L_0x007b:
        r8 = 1;
        goto L_0x0099;
    L_0x007d:
        r8 = 0;
        goto L_0x0099;
    L_0x007f:
        if (r0 != r3) goto L_0x0090;
    L_0x0081:
        r8 = r10[r3];
        if (r8 == 0) goto L_0x007d;
    L_0x0085:
        r8 = r9 + -2;
        r8 = r7[r8];
        if (r8 != 0) goto L_0x007d;
    L_0x008b:
        r8 = r7[r4];
        if (r8 != r2) goto L_0x007d;
    L_0x008f:
        goto L_0x007b;
    L_0x0090:
        r8 = r10[r2];
        if (r8 == 0) goto L_0x007d;
    L_0x0094:
        r8 = r7[r4];
        if (r8 != r2) goto L_0x007d;
    L_0x0098:
        goto L_0x007b;
    L_0x0099:
        r10[r1] = r8;
        if (r0 <= r2) goto L_0x00ab;
    L_0x009d:
        r8 = r9 + -2;
        r8 = r7[r8];
        if (r8 != 0) goto L_0x00a9;
    L_0x00a3:
        r8 = r7[r4];
        if (r8 != 0) goto L_0x00a9;
    L_0x00a7:
        r8 = 1;
        goto L_0x00b4;
    L_0x00a9:
        r8 = 0;
        goto L_0x00b4;
    L_0x00ab:
        r8 = r10[r3];
        if (r8 == 0) goto L_0x00a9;
    L_0x00af:
        r8 = r7[r4];
        if (r8 != 0) goto L_0x00a9;
    L_0x00b3:
        goto L_0x00a7;
    L_0x00b4:
        r10[r2] = r8;
        r7 = r7[r4];
        if (r7 != 0) goto L_0x00bb;
    L_0x00ba:
        r1 = 1;
    L_0x00bb:
        r10[r3] = r1;
    L_0x00bd:
        return r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.l.j.a(byte[], int, int, boolean[]):int");
    }

    /* renamed from: a */
    public static void m7065a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    /* renamed from: c */
    private static int m7070c(byte[] bArr, int i, int i2) {
        while (i < i2 - 2) {
            if (bArr[i] == (byte) 0 && bArr[i + 1] == (byte) 0 && bArr[i + 2] == (byte) 3) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: a */
    private static void m7063a(C2530m c2530m, int i) {
        int i2 = 8;
        int i3 = 8;
        for (int i4 = 0; i4 < i; i4++) {
            if (i2 != 0) {
                i2 = ((c2530m.m7134e() + i3) + 256) % 256;
            }
            if (i2 != 0) {
                i3 = i2;
            }
        }
    }
}
