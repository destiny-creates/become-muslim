package com.google.p217b.p225c.p226a;

import com.facebook.imageutils.JfifUtil;
import com.google.p217b.C6891h;
import com.google.p217b.p222b.C5203c;
import com.google.p217b.p222b.C5205e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: DecodedBitStreamParser */
/* renamed from: com.google.b.c.a.c */
final class C5215c {
    /* renamed from: a */
    private static final char[] f17614a = new char[]{'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    /* renamed from: b */
    private static final char[] f17615b = new char[]{'!', '\"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_'};
    /* renamed from: c */
    private static final char[] f17616c = new char[]{'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    /* renamed from: d */
    private static final char[] f17617d = f17615b;
    /* renamed from: e */
    private static final char[] f17618e = new char[]{'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', ''};

    /* compiled from: DecodedBitStreamParser */
    /* renamed from: com.google.b.c.a.c$a */
    private enum C5214a {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE
    }

    /* renamed from: a */
    static C5205e m22066a(byte[] bArr) {
        String stringBuilder;
        C5203c c5203c = new C5203c(bArr);
        StringBuilder stringBuilder2 = new StringBuilder(100);
        StringBuilder stringBuilder3 = new StringBuilder(0);
        List arrayList = new ArrayList(1);
        C5214a c5214a = C5214a.ASCII_ENCODE;
        do {
            if (c5214a == C5214a.ASCII_ENCODE) {
                c5214a = C5215c.m22067a(c5203c, stringBuilder2, stringBuilder3);
            } else {
                switch (c5214a) {
                    case C40_ENCODE:
                        C5215c.m22069a(c5203c, stringBuilder2);
                        break;
                    case TEXT_ENCODE:
                        C5215c.m22071b(c5203c, stringBuilder2);
                        break;
                    case ANSIX12_ENCODE:
                        C5215c.m22072c(c5203c, stringBuilder2);
                        break;
                    case EDIFACT_ENCODE:
                        C5215c.m22073d(c5203c, stringBuilder2);
                        break;
                    case BASE256_ENCODE:
                        C5215c.m22070a(c5203c, stringBuilder2, (Collection) arrayList);
                        break;
                    default:
                        throw C6891h.m32342a();
                }
                c5214a = C5214a.ASCII_ENCODE;
            }
            if (c5214a != C5214a.PAD_ENCODE) {
            }
            if (stringBuilder3.length() > 0) {
                stringBuilder2.append(stringBuilder3);
            }
            stringBuilder = stringBuilder2.toString();
            if (arrayList.isEmpty()) {
                arrayList = null;
            }
            return new C5205e(bArr, stringBuilder, arrayList, null);
        } while (c5203c.m22016c() > 0);
        if (stringBuilder3.length() > 0) {
            stringBuilder2.append(stringBuilder3);
        }
        stringBuilder = stringBuilder2.toString();
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return new C5205e(bArr, stringBuilder, arrayList, null);
    }

    /* renamed from: a */
    private static C5214a m22067a(C5203c c5203c, StringBuilder stringBuilder, StringBuilder stringBuilder2) {
        Object obj = null;
        do {
            int a = c5203c.m22014a(8);
            if (a != 0) {
                if (a > 128) {
                    if (a != 129) {
                        if (a > 229) {
                            switch (a) {
                                case 230:
                                    return C5214a.C40_ENCODE;
                                case 231:
                                    return C5214a.BASE256_ENCODE;
                                case 232:
                                    stringBuilder.append('\u001d');
                                    break;
                                case 233:
                                case 234:
                                case 241:
                                    break;
                                case 235:
                                    obj = 1;
                                    break;
                                case 236:
                                    stringBuilder.append("[)>\u001e05\u001d");
                                    stringBuilder2.insert(0, "\u001e\u0004");
                                    break;
                                case 237:
                                    stringBuilder.append("[)>\u001e06\u001d");
                                    stringBuilder2.insert(0, "\u001e\u0004");
                                    break;
                                case 238:
                                    return C5214a.ANSIX12_ENCODE;
                                case 239:
                                    return C5214a.TEXT_ENCODE;
                                case 240:
                                    return C5214a.EDIFACT_ENCODE;
                                default:
                                    if (a == 254 && c5203c.m22016c() == 0) {
                                        break;
                                    }
                                    throw C6891h.m32342a();
                            }
                        }
                        a -= 130;
                        if (a < 10) {
                            stringBuilder.append('0');
                        }
                        stringBuilder.append(a);
                    } else {
                        return C5214a.PAD_ENCODE;
                    }
                }
                if (obj != null) {
                    a += 128;
                }
                stringBuilder.append((char) (a - 1));
                return C5214a.ASCII_ENCODE;
            }
            throw C6891h.m32342a();
        } while (c5203c.m22016c() > 0);
        return C5214a.ASCII_ENCODE;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static void m22069a(com.google.p217b.p222b.C5203c r8, java.lang.StringBuilder r9) {
        /*
        r0 = 3;
        r1 = new int[r0];
        r2 = 0;
        r3 = 0;
        r4 = 0;
    L_0x0006:
        r5 = r8.m22016c();
        r6 = 8;
        if (r5 != r6) goto L_0x000f;
    L_0x000e:
        return;
    L_0x000f:
        r5 = r8.m22014a(r6);
        r7 = 254; // 0xfe float:3.56E-43 double:1.255E-321;
        if (r5 != r7) goto L_0x0018;
    L_0x0017:
        return;
    L_0x0018:
        r6 = r8.m22014a(r6);
        com.google.p217b.p225c.p226a.C5215c.m22068a(r5, r6, r1);
        r5 = r3;
        r3 = 0;
    L_0x0021:
        if (r3 >= r0) goto L_0x009e;
    L_0x0023:
        r6 = r1[r3];
        switch(r4) {
            case 0: goto L_0x007b;
            case 1: goto L_0x006c;
            case 2: goto L_0x003e;
            case 3: goto L_0x002d;
            default: goto L_0x0028;
        };
    L_0x0028:
        r8 = com.google.p217b.C6891h.m32342a();
        throw r8;
    L_0x002d:
        if (r5 == 0) goto L_0x0037;
    L_0x002f:
        r6 = r6 + 224;
        r4 = (char) r6;
        r9.append(r4);
    L_0x0035:
        r5 = 0;
        goto L_0x0079;
    L_0x0037:
        r6 = r6 + 96;
        r4 = (char) r6;
        r9.append(r4);
        goto L_0x0079;
    L_0x003e:
        r4 = f17615b;
        r4 = r4.length;
        if (r6 >= r4) goto L_0x0055;
    L_0x0043:
        r4 = f17615b;
        r4 = r4[r6];
        if (r5 == 0) goto L_0x0051;
    L_0x0049:
        r4 = r4 + 128;
        r4 = (char) r4;
        r9.append(r4);
        r4 = 0;
        goto L_0x006a;
    L_0x0051:
        r9.append(r4);
        goto L_0x0069;
    L_0x0055:
        r4 = 27;
        if (r6 == r4) goto L_0x0064;
    L_0x0059:
        r4 = 30;
        if (r6 != r4) goto L_0x005f;
    L_0x005d:
        r4 = 1;
        goto L_0x006a;
    L_0x005f:
        r8 = com.google.p217b.C6891h.m32342a();
        throw r8;
    L_0x0064:
        r4 = 29;
        r9.append(r4);
    L_0x0069:
        r4 = r5;
    L_0x006a:
        r5 = r4;
        goto L_0x0079;
    L_0x006c:
        if (r5 == 0) goto L_0x0075;
    L_0x006e:
        r6 = r6 + 128;
        r4 = (char) r6;
        r9.append(r4);
        goto L_0x0035;
    L_0x0075:
        r4 = (char) r6;
        r9.append(r4);
    L_0x0079:
        r4 = 0;
        goto L_0x0096;
    L_0x007b:
        if (r6 >= r0) goto L_0x0080;
    L_0x007d:
        r4 = r6 + 1;
        goto L_0x0096;
    L_0x0080:
        r7 = f17614a;
        r7 = r7.length;
        if (r6 >= r7) goto L_0x0099;
    L_0x0085:
        r7 = f17614a;
        r6 = r7[r6];
        if (r5 == 0) goto L_0x0093;
    L_0x008b:
        r6 = r6 + 128;
        r5 = (char) r6;
        r9.append(r5);
        r5 = 0;
        goto L_0x0096;
    L_0x0093:
        r9.append(r6);
    L_0x0096:
        r3 = r3 + 1;
        goto L_0x0021;
    L_0x0099:
        r8 = com.google.p217b.C6891h.m32342a();
        throw r8;
    L_0x009e:
        r3 = r8.m22016c();
        if (r3 > 0) goto L_0x00a5;
    L_0x00a4:
        return;
    L_0x00a5:
        r3 = r5;
        goto L_0x0006;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.b.c.a.c.a(com.google.b.b.c, java.lang.StringBuilder):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private static void m22071b(com.google.p217b.p222b.C5203c r8, java.lang.StringBuilder r9) {
        /*
        r0 = 3;
        r1 = new int[r0];
        r2 = 0;
        r3 = 0;
        r4 = 0;
    L_0x0006:
        r5 = r8.m22016c();
        r6 = 8;
        if (r5 != r6) goto L_0x000f;
    L_0x000e:
        return;
    L_0x000f:
        r5 = r8.m22014a(r6);
        r7 = 254; // 0xfe float:3.56E-43 double:1.255E-321;
        if (r5 != r7) goto L_0x0018;
    L_0x0017:
        return;
    L_0x0018:
        r6 = r8.m22014a(r6);
        com.google.p217b.p225c.p226a.C5215c.m22068a(r5, r6, r1);
        r5 = r3;
        r3 = 0;
    L_0x0021:
        if (r3 >= r0) goto L_0x00aa;
    L_0x0023:
        r6 = r1[r3];
        switch(r4) {
            case 0: goto L_0x0086;
            case 1: goto L_0x0077;
            case 2: goto L_0x0049;
            case 3: goto L_0x002d;
            default: goto L_0x0028;
        };
    L_0x0028:
        r8 = com.google.p217b.C6891h.m32342a();
        throw r8;
    L_0x002d:
        r4 = f17618e;
        r4 = r4.length;
        if (r6 >= r4) goto L_0x0044;
    L_0x0032:
        r4 = f17618e;
        r4 = r4[r6];
        if (r5 == 0) goto L_0x0040;
    L_0x0038:
        r4 = r4 + 128;
        r4 = (char) r4;
        r9.append(r4);
    L_0x003e:
        r5 = 0;
        goto L_0x0084;
    L_0x0040:
        r9.append(r4);
        goto L_0x0084;
    L_0x0044:
        r8 = com.google.p217b.C6891h.m32342a();
        throw r8;
    L_0x0049:
        r4 = f17617d;
        r4 = r4.length;
        if (r6 >= r4) goto L_0x0060;
    L_0x004e:
        r4 = f17617d;
        r4 = r4[r6];
        if (r5 == 0) goto L_0x005c;
    L_0x0054:
        r4 = r4 + 128;
        r4 = (char) r4;
        r9.append(r4);
        r4 = 0;
        goto L_0x0075;
    L_0x005c:
        r9.append(r4);
        goto L_0x0074;
    L_0x0060:
        r4 = 27;
        if (r6 == r4) goto L_0x006f;
    L_0x0064:
        r4 = 30;
        if (r6 != r4) goto L_0x006a;
    L_0x0068:
        r4 = 1;
        goto L_0x0075;
    L_0x006a:
        r8 = com.google.p217b.C6891h.m32342a();
        throw r8;
    L_0x006f:
        r4 = 29;
        r9.append(r4);
    L_0x0074:
        r4 = r5;
    L_0x0075:
        r5 = r4;
        goto L_0x0084;
    L_0x0077:
        if (r5 == 0) goto L_0x0080;
    L_0x0079:
        r6 = r6 + 128;
        r4 = (char) r6;
        r9.append(r4);
        goto L_0x003e;
    L_0x0080:
        r4 = (char) r6;
        r9.append(r4);
    L_0x0084:
        r4 = 0;
        goto L_0x00a1;
    L_0x0086:
        if (r6 >= r0) goto L_0x008b;
    L_0x0088:
        r4 = r6 + 1;
        goto L_0x00a1;
    L_0x008b:
        r7 = f17616c;
        r7 = r7.length;
        if (r6 >= r7) goto L_0x00a5;
    L_0x0090:
        r7 = f17616c;
        r6 = r7[r6];
        if (r5 == 0) goto L_0x009e;
    L_0x0096:
        r6 = r6 + 128;
        r5 = (char) r6;
        r9.append(r5);
        r5 = 0;
        goto L_0x00a1;
    L_0x009e:
        r9.append(r6);
    L_0x00a1:
        r3 = r3 + 1;
        goto L_0x0021;
    L_0x00a5:
        r8 = com.google.p217b.C6891h.m32342a();
        throw r8;
    L_0x00aa:
        r3 = r8.m22016c();
        if (r3 > 0) goto L_0x00b1;
    L_0x00b0:
        return;
    L_0x00b1:
        r3 = r5;
        goto L_0x0006;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.b.c.a.c.b(com.google.b.b.c, java.lang.StringBuilder):void");
    }

    /* renamed from: c */
    private static void m22072c(C5203c c5203c, StringBuilder stringBuilder) {
        int[] iArr = new int[3];
        while (c5203c.m22016c() != 8) {
            int a = c5203c.m22014a(8);
            if (a != 254) {
                C5215c.m22068a(a, c5203c.m22014a(8), iArr);
                for (a = 0; a < 3; a++) {
                    int i = iArr[a];
                    switch (i) {
                        case 0:
                            stringBuilder.append('\r');
                            break;
                        case 1:
                            stringBuilder.append('*');
                            break;
                        case 2:
                            stringBuilder.append('>');
                            break;
                        case 3:
                            stringBuilder.append(' ');
                            break;
                        default:
                            if (i < 14) {
                                stringBuilder.append((char) (i + 44));
                                break;
                            } else if (i < 40) {
                                stringBuilder.append((char) (i + 51));
                                break;
                            } else {
                                throw C6891h.m32342a();
                            }
                    }
                }
                if (c5203c.m22016c() <= 0) {
                    return;
                }
            }
            return;
        }
    }

    /* renamed from: a */
    private static void m22068a(int i, int i2, int[] iArr) {
        i = ((i << 8) + i2) - 1;
        int i3 = i / 1600;
        iArr[0] = i3;
        i -= i3 * 1600;
        i3 = i / 40;
        iArr[1] = i3;
        iArr[2] = i - (i3 * 40);
    }

    /* renamed from: d */
    private static void m22073d(C5203c c5203c, StringBuilder stringBuilder) {
        while (c5203c.m22016c() > 16) {
            for (int i = 0; i < 4; i++) {
                int a = c5203c.m22014a(6);
                if (a == 31) {
                    stringBuilder = 8 - c5203c.m22013a();
                    if (stringBuilder != 8) {
                        c5203c.m22014a(stringBuilder);
                    }
                    return;
                }
                if ((a & 32) == 0) {
                    a |= 64;
                }
                stringBuilder.append((char) a);
            }
            if (c5203c.m22016c() <= 0) {
                return;
            }
        }
    }

    /* renamed from: a */
    private static void m22070a(C5203c c5203c, StringBuilder stringBuilder, Collection<byte[]> collection) {
        int b = c5203c.m22015b() + 1;
        int i = b + 1;
        b = C5215c.m22065a(c5203c.m22014a(8), b);
        if (b == 0) {
            b = c5203c.m22016c() / 8;
        } else if (b >= 250) {
            b = ((b - 249) * 250) + C5215c.m22065a(c5203c.m22014a(8), i);
            i++;
        }
        if (b >= 0) {
            Object obj = new byte[b];
            int i2 = 0;
            while (i2 < b) {
                if (c5203c.m22016c() >= 8) {
                    int i3 = i + 1;
                    obj[i2] = (byte) C5215c.m22065a(c5203c.m22014a(8), i);
                    i2++;
                    i = i3;
                } else {
                    throw C6891h.m32342a();
                }
            }
            collection.add(obj);
            try {
                stringBuilder.append(new String(obj, "ISO8859_1"));
                return;
            } catch (C5203c c5203c2) {
                throw new IllegalStateException("Platform does not support required encoding: ".concat(String.valueOf(c5203c2)));
            }
        }
        throw C6891h.m32342a();
    }

    /* renamed from: a */
    private static int m22065a(int i, int i2) {
        i -= ((i2 * 149) % JfifUtil.MARKER_FIRST_BYTE) + 1;
        return i >= 0 ? i : i + 256;
    }
}
