package com.google.p217b.p235f.p236a;

import com.google.p217b.C6891h;
import com.google.p217b.p222b.C5204d;
import com.google.p217b.p222b.C5205e;
import com.google.p217b.p235f.C5280c;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* compiled from: DecodedBitStreamParser */
/* renamed from: com.google.b.f.a.e */
final class C5264e {
    /* renamed from: a */
    private static final char[] f17770a = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
    /* renamed from: b */
    private static final char[] f17771b = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
    /* renamed from: c */
    private static final BigInteger[] f17772c;

    /* compiled from: DecodedBitStreamParser */
    /* renamed from: com.google.b.f.a.e$a */
    private enum C5263a {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        f17772c = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900);
        f17772c[1] = valueOf;
        for (int i = 2; i < f17772c.length; i++) {
            BigInteger[] bigIntegerArr2 = f17772c;
            bigIntegerArr2[i] = bigIntegerArr2[i - 1].multiply(valueOf);
        }
    }

    /* renamed from: a */
    static C5205e m22298a(int[] iArr, String str) {
        StringBuilder stringBuilder = new StringBuilder(iArr.length << 1);
        Charset charset = StandardCharsets.ISO_8859_1;
        int i = iArr[1];
        Object c5280c = new C5280c();
        int i2 = 2;
        while (i2 < iArr[0]) {
            if (i != 913) {
                switch (i) {
                    case 900:
                        i = C5264e.m22297a(iArr, i2, stringBuilder);
                        break;
                    case 901:
                        i = C5264e.m22295a(i, iArr, charset, i2, stringBuilder);
                        break;
                    case 902:
                        i = C5264e.m22301b(iArr, i2, stringBuilder);
                        break;
                    default:
                        switch (i) {
                            case 922:
                            case 923:
                                throw C6891h.m32342a();
                            case 924:
                                break;
                            case 925:
                                i = i2 + 1;
                                break;
                            case 926:
                                i = i2 + 2;
                                break;
                            case 927:
                                i = i2 + 1;
                                charset = Charset.forName(C5204d.m22017a(iArr[i2]).name());
                                break;
                            case 928:
                                i = C5264e.m22296a(iArr, i2, (C5280c) c5280c);
                                break;
                            default:
                                i = C5264e.m22297a(iArr, i2 - 1, stringBuilder);
                                break;
                        }
                        i = C5264e.m22295a(i, iArr, charset, i2, stringBuilder);
                        break;
                }
            }
            i = i2 + 1;
            stringBuilder.append((char) iArr[i2]);
            if (i < iArr.length) {
                i2 = i + 1;
                i = iArr[i];
            } else {
                throw C6891h.m32342a();
            }
        }
        if (stringBuilder.length() != null) {
            iArr = new C5205e(null, stringBuilder.toString(), null, str);
            iArr.m22022a(c5280c);
            return iArr;
        }
        throw C6891h.m32342a();
    }

    /* renamed from: a */
    static int m22296a(int[] iArr, int i, C5280c c5280c) {
        if (i + 2 <= iArr[0]) {
            int[] iArr2 = new int[2];
            int i2 = i;
            i = 0;
            while (i < 2) {
                iArr2[i] = iArr[i2];
                i++;
                i2++;
            }
            c5280c.m22401a(Integer.parseInt(C5264e.m22299a(iArr2, 2)));
            StringBuilder stringBuilder = new StringBuilder();
            int a = C5264e.m22297a(iArr, i2, stringBuilder);
            c5280c.m22403a(stringBuilder.toString());
            i = iArr[a] == 923 ? a + 1 : -1;
            while (a < iArr[0]) {
                switch (iArr[a]) {
                    case 922:
                        a++;
                        c5280c.m22404a(true);
                        break;
                    case 923:
                        a++;
                        StringBuilder stringBuilder2;
                        switch (iArr[a]) {
                            case 0:
                                stringBuilder2 = new StringBuilder();
                                a = C5264e.m22297a(iArr, a + 1, stringBuilder2);
                                c5280c.m22412d(stringBuilder2.toString());
                                break;
                            case 1:
                                stringBuilder2 = new StringBuilder();
                                a = C5264e.m22301b(iArr, a + 1, stringBuilder2);
                                c5280c.m22407b(Integer.parseInt(stringBuilder2.toString()));
                                break;
                            case 2:
                                stringBuilder2 = new StringBuilder();
                                a = C5264e.m22301b(iArr, a + 1, stringBuilder2);
                                c5280c.m22408b(Long.parseLong(stringBuilder2.toString()));
                                break;
                            case 3:
                                stringBuilder2 = new StringBuilder();
                                a = C5264e.m22297a(iArr, a + 1, stringBuilder2);
                                c5280c.m22409b(stringBuilder2.toString());
                                break;
                            case 4:
                                stringBuilder2 = new StringBuilder();
                                a = C5264e.m22297a(iArr, a + 1, stringBuilder2);
                                c5280c.m22411c(stringBuilder2.toString());
                                break;
                            case 5:
                                stringBuilder2 = new StringBuilder();
                                a = C5264e.m22301b(iArr, a + 1, stringBuilder2);
                                c5280c.m22402a(Long.parseLong(stringBuilder2.toString()));
                                break;
                            case 6:
                                stringBuilder2 = new StringBuilder();
                                a = C5264e.m22301b(iArr, a + 1, stringBuilder2);
                                c5280c.m22410c(Integer.parseInt(stringBuilder2.toString()));
                                break;
                            default:
                                throw C6891h.m32342a();
                        }
                    default:
                        throw C6891h.m32342a();
                }
            }
            if (i != -1) {
                int i3 = a - i;
                if (c5280c.m22406a()) {
                    i3--;
                }
                c5280c.m22405a(Arrays.copyOfRange(iArr, i, i3 + i));
            }
            return a;
        }
        throw C6891h.m32342a();
    }

    /* renamed from: a */
    private static int m22297a(int[] iArr, int i, StringBuilder stringBuilder) {
        int[] iArr2 = new int[((iArr[0] - i) << 1)];
        int[] iArr3 = new int[((iArr[0] - i) << 1)];
        Object obj = null;
        int i2 = 0;
        while (i < iArr[0] && r4 == null) {
            int i3 = i + 1;
            i = iArr[i];
            if (i < 900) {
                iArr2[i2] = i / 30;
                iArr2[i2 + 1] = i % 30;
                i2 += 2;
            } else if (i != 913) {
                if (i != 928) {
                    switch (i) {
                        case 900:
                            i = i2 + 1;
                            iArr2[i2] = 900;
                            i2 = i;
                            break;
                        case 901:
                        case 902:
                            break;
                        default:
                            switch (i) {
                                case 922:
                                case 923:
                                case 924:
                                    break;
                                default:
                                    break;
                            }
                    }
                }
                i = i3 - 1;
                obj = 1;
            } else {
                iArr2[i2] = 913;
                i = i3 + 1;
                iArr3[i2] = iArr[i3];
                i2++;
            }
            i = i3;
        }
        C5264e.m22300a(iArr2, iArr3, i2, stringBuilder);
        return i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static void m22300a(int[] r12, int[] r13, int r14, java.lang.StringBuilder r15) {
        /*
        r0 = com.google.p217b.p235f.p236a.C5264e.C5263a.ALPHA;
        r1 = com.google.p217b.p235f.p236a.C5264e.C5263a.ALPHA;
        r2 = 0;
        r3 = r1;
        r1 = r0;
        r0 = 0;
    L_0x0008:
        if (r0 >= r14) goto L_0x00f5;
    L_0x000a:
        r4 = r12[r0];
        r5 = com.google.p217b.p235f.p236a.C5264e.C52621.f17762a;
        r6 = r1.ordinal();
        r5 = r5[r6];
        r6 = 32;
        r7 = 29;
        r8 = 26;
        r9 = 913; // 0x391 float:1.28E-42 double:4.51E-321;
        r10 = 900; // 0x384 float:1.261E-42 double:4.447E-321;
        switch(r5) {
            case 1: goto L_0x00c4;
            case 2: goto L_0x00a3;
            case 3: goto L_0x0077;
            case 4: goto L_0x0057;
            case 5: goto L_0x0042;
            case 6: goto L_0x0023;
            default: goto L_0x0021;
        };
    L_0x0021:
        goto L_0x00eb;
    L_0x0023:
        if (r4 >= r7) goto L_0x002a;
    L_0x0025:
        r1 = f17770a;
        r1 = r1[r4];
        goto L_0x0047;
    L_0x002a:
        if (r4 == r7) goto L_0x003e;
    L_0x002c:
        if (r4 == r10) goto L_0x003a;
    L_0x002e:
        if (r4 == r9) goto L_0x0031;
    L_0x0030:
        goto L_0x0037;
    L_0x0031:
        r1 = r13[r0];
        r1 = (char) r1;
        r15.append(r1);
    L_0x0037:
        r1 = r3;
        goto L_0x00eb;
    L_0x003a:
        r1 = com.google.p217b.p235f.p236a.C5264e.C5263a.ALPHA;
        goto L_0x00eb;
    L_0x003e:
        r1 = com.google.p217b.p235f.p236a.C5264e.C5263a.ALPHA;
        goto L_0x00eb;
    L_0x0042:
        if (r4 >= r8) goto L_0x004b;
    L_0x0044:
        r4 = r4 + 65;
        r1 = (char) r4;
    L_0x0047:
        r4 = r1;
        r1 = r3;
        goto L_0x00ec;
    L_0x004b:
        if (r4 == r8) goto L_0x0054;
    L_0x004d:
        if (r4 == r10) goto L_0x0050;
    L_0x004f:
        goto L_0x0037;
    L_0x0050:
        r1 = com.google.p217b.p235f.p236a.C5264e.C5263a.ALPHA;
        goto L_0x00eb;
    L_0x0054:
        r1 = r3;
        goto L_0x00df;
    L_0x0057:
        if (r4 >= r7) goto L_0x005f;
    L_0x0059:
        r5 = f17770a;
        r4 = r5[r4];
        goto L_0x00ec;
    L_0x005f:
        if (r4 == r7) goto L_0x0073;
    L_0x0061:
        if (r4 == r10) goto L_0x006f;
    L_0x0063:
        if (r4 == r9) goto L_0x0067;
    L_0x0065:
        goto L_0x00eb;
    L_0x0067:
        r4 = r13[r0];
        r4 = (char) r4;
        r15.append(r4);
        goto L_0x00eb;
    L_0x006f:
        r1 = com.google.p217b.p235f.p236a.C5264e.C5263a.ALPHA;
        goto L_0x00eb;
    L_0x0073:
        r1 = com.google.p217b.p235f.p236a.C5264e.C5263a.ALPHA;
        goto L_0x00eb;
    L_0x0077:
        r5 = 25;
        if (r4 >= r5) goto L_0x0081;
    L_0x007b:
        r5 = f17771b;
        r4 = r5[r4];
        goto L_0x00ec;
    L_0x0081:
        if (r4 == r10) goto L_0x00a0;
    L_0x0083:
        if (r4 == r9) goto L_0x0099;
    L_0x0085:
        switch(r4) {
            case 25: goto L_0x0095;
            case 26: goto L_0x00df;
            case 27: goto L_0x0091;
            case 28: goto L_0x008d;
            case 29: goto L_0x008a;
            default: goto L_0x0088;
        };
    L_0x0088:
        goto L_0x00eb;
    L_0x008a:
        r3 = com.google.p217b.p235f.p236a.C5264e.C5263a.PUNCT_SHIFT;
        goto L_0x00d4;
    L_0x008d:
        r1 = com.google.p217b.p235f.p236a.C5264e.C5263a.ALPHA;
        goto L_0x00eb;
    L_0x0091:
        r1 = com.google.p217b.p235f.p236a.C5264e.C5263a.LOWER;
        goto L_0x00eb;
    L_0x0095:
        r1 = com.google.p217b.p235f.p236a.C5264e.C5263a.PUNCT;
        goto L_0x00eb;
    L_0x0099:
        r4 = r13[r0];
        r4 = (char) r4;
        r15.append(r4);
        goto L_0x00eb;
    L_0x00a0:
        r1 = com.google.p217b.p235f.p236a.C5264e.C5263a.ALPHA;
        goto L_0x00eb;
    L_0x00a3:
        if (r4 >= r8) goto L_0x00a9;
    L_0x00a5:
        r4 = r4 + 97;
        r4 = (char) r4;
        goto L_0x00ec;
    L_0x00a9:
        if (r4 == r10) goto L_0x00c1;
    L_0x00ab:
        if (r4 == r9) goto L_0x00ba;
    L_0x00ad:
        switch(r4) {
            case 26: goto L_0x00df;
            case 27: goto L_0x00b7;
            case 28: goto L_0x00b4;
            case 29: goto L_0x00b1;
            default: goto L_0x00b0;
        };
    L_0x00b0:
        goto L_0x00eb;
    L_0x00b1:
        r3 = com.google.p217b.p235f.p236a.C5264e.C5263a.PUNCT_SHIFT;
        goto L_0x00d4;
    L_0x00b4:
        r1 = com.google.p217b.p235f.p236a.C5264e.C5263a.MIXED;
        goto L_0x00eb;
    L_0x00b7:
        r3 = com.google.p217b.p235f.p236a.C5264e.C5263a.ALPHA_SHIFT;
        goto L_0x00d4;
    L_0x00ba:
        r4 = r13[r0];
        r4 = (char) r4;
        r15.append(r4);
        goto L_0x00eb;
    L_0x00c1:
        r1 = com.google.p217b.p235f.p236a.C5264e.C5263a.ALPHA;
        goto L_0x00eb;
    L_0x00c4:
        if (r4 >= r8) goto L_0x00ca;
    L_0x00c6:
        r4 = r4 + 65;
        r4 = (char) r4;
        goto L_0x00ec;
    L_0x00ca:
        if (r4 == r10) goto L_0x00e9;
    L_0x00cc:
        if (r4 == r9) goto L_0x00e2;
    L_0x00ce:
        switch(r4) {
            case 26: goto L_0x00df;
            case 27: goto L_0x00dc;
            case 28: goto L_0x00d9;
            case 29: goto L_0x00d2;
            default: goto L_0x00d1;
        };
    L_0x00d1:
        goto L_0x00eb;
    L_0x00d2:
        r3 = com.google.p217b.p235f.p236a.C5264e.C5263a.PUNCT_SHIFT;
    L_0x00d4:
        r4 = 0;
        r11 = r3;
        r3 = r1;
        r1 = r11;
        goto L_0x00ec;
    L_0x00d9:
        r1 = com.google.p217b.p235f.p236a.C5264e.C5263a.MIXED;
        goto L_0x00eb;
    L_0x00dc:
        r1 = com.google.p217b.p235f.p236a.C5264e.C5263a.LOWER;
        goto L_0x00eb;
    L_0x00df:
        r4 = 32;
        goto L_0x00ec;
    L_0x00e2:
        r4 = r13[r0];
        r4 = (char) r4;
        r15.append(r4);
        goto L_0x00eb;
    L_0x00e9:
        r1 = com.google.p217b.p235f.p236a.C5264e.C5263a.ALPHA;
    L_0x00eb:
        r4 = 0;
    L_0x00ec:
        if (r4 == 0) goto L_0x00f1;
    L_0x00ee:
        r15.append(r4);
    L_0x00f1:
        r0 = r0 + 1;
        goto L_0x0008;
    L_0x00f5:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.b.f.a.e.a(int[], int[], int, java.lang.StringBuilder):void");
    }

    /* renamed from: a */
    private static int m22295a(int i, int[] iArr, Charset charset, int i2, StringBuilder stringBuilder) {
        int i3;
        int i4 = i;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        long j = 900;
        int i5 = 0;
        int i6;
        if (i4 == 901) {
            int[] iArr2 = new int[6];
            i6 = i2 + 1;
            int i7 = iArr[i2];
            Object obj = null;
            while (true) {
                int i8;
                int i9 = 0;
                long j2 = 0;
                while (i6 < iArr[0] && r2 == null) {
                    int i10 = i9 + 1;
                    iArr2[i9] = i7;
                    j2 = (j2 * 900) + ((long) i7);
                    i9 = i6 + 1;
                    i7 = iArr[i6];
                    if (i7 != 928) {
                        switch (i7) {
                            case 900:
                            case 901:
                            case 902:
                                break;
                            default:
                                switch (i7) {
                                    case 922:
                                    case 923:
                                    case 924:
                                        break;
                                    default:
                                        if (i10 % 5 != 0 || i10 <= 0) {
                                            i6 = i9;
                                            i9 = i10;
                                            break;
                                        }
                                        for (i6 = 0; i6 < 6; i6++) {
                                            byteArrayOutputStream.write((byte) ((int) (j2 >> ((5 - i6) * 8))));
                                        }
                                        i6 = i9;
                                        break;
                                }
                        }
                    }
                    i6 = i9 - 1;
                    i9 = i10;
                    obj = 1;
                }
                if (i6 != iArr[0] || i7 >= 900) {
                    i8 = i9;
                } else {
                    i8 = i9 + 1;
                    iArr2[i9] = i7;
                }
                while (i5 < i8) {
                    byteArrayOutputStream.write((byte) iArr2[i5]);
                    i5++;
                }
                i3 = i6;
            }
        } else if (i4 != 924) {
            i3 = i2;
        } else {
            i3 = i2;
            Object obj2 = null;
            i6 = 0;
            long j3 = 0;
            while (i3 < iArr[0] && r0 == null) {
                int i11 = i3 + 1;
                i3 = iArr[i3];
                if (i3 < 900) {
                    i6++;
                    j3 = (j3 * j) + ((long) i3);
                } else {
                    if (i3 != 928) {
                        switch (i3) {
                            case 900:
                            case 901:
                            case 902:
                                break;
                            default:
                                switch (i3) {
                                    case 922:
                                    case 923:
                                    case 924:
                                        break;
                                    default:
                                        break;
                                }
                        }
                    }
                    i3 = i11 - 1;
                    obj2 = 1;
                    if (i6 % 5 == 0 && i6 > 0) {
                        for (i6 = 0; i6 < 6; i6++) {
                            byteArrayOutputStream.write((byte) ((int) (j3 >> ((5 - i6) * 8))));
                        }
                        i6 = 0;
                        j3 = 0;
                    }
                    j = 900;
                }
                i3 = i11;
                for (i6 = 0; i6 < 6; i6++) {
                    byteArrayOutputStream.write((byte) ((int) (j3 >> ((5 - i6) * 8))));
                }
                i6 = 0;
                j3 = 0;
                j = 900;
            }
        }
        stringBuilder.append(new String(byteArrayOutputStream.toByteArray(), charset));
        return i3;
    }

    /* renamed from: b */
    private static int m22301b(int[] iArr, int i, StringBuilder stringBuilder) {
        int[] iArr2 = new int[15];
        Object obj = null;
        int i2 = 0;
        while (i < iArr[0] && r2 == null) {
            int i3 = i + 1;
            i = iArr[i];
            if (i3 == iArr[0]) {
                obj = 1;
            }
            if (i < 900) {
                iArr2[i2] = i;
                i2++;
            } else {
                if (i != 928) {
                    switch (i) {
                        case 900:
                        case 901:
                            break;
                        default:
                            switch (i) {
                                case 922:
                                case 923:
                                case 924:
                                    break;
                                default:
                                    break;
                            }
                    }
                }
                i3--;
                obj = 1;
            }
            if ((i2 % 15 == 0 || i == 902 || r2 != null) && i2 > 0) {
                stringBuilder.append(C5264e.m22299a(iArr2, i2));
                i2 = 0;
            }
            i = i3;
        }
        return i;
    }

    /* renamed from: a */
    private static String m22299a(int[] iArr, int i) {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i2 = 0; i2 < i; i2++) {
            bigInteger = bigInteger.add(f17772c[(i - i2) - 1].multiply(BigInteger.valueOf((long) iArr[i2])));
        }
        iArr = bigInteger.toString();
        if (iArr.charAt(0) == 49) {
            return iArr.substring(1);
        }
        throw C6891h.m32342a();
    }
}
