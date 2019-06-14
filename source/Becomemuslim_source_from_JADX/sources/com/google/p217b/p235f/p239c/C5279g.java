package com.google.p217b.p235f.p239c;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.imageutils.JfifUtil;
import com.facebook.stetho.dumpapp.Framer;
import com.google.p217b.C5319v;
import com.google.p217b.p222b.C5204d;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* compiled from: PDF417HighLevelEncoder */
/* renamed from: com.google.b.f.c.g */
final class C5279g {
    /* renamed from: a */
    private static final byte[] f17816a = new byte[]{(byte) 48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 38, (byte) 13, (byte) 9, (byte) 44, (byte) 58, (byte) 35, Framer.STDIN_FRAME_PREFIX, (byte) 46, (byte) 36, (byte) 47, (byte) 43, (byte) 37, (byte) 42, (byte) 61, (byte) 94, (byte) 0, (byte) 32, (byte) 0, (byte) 0, (byte) 0};
    /* renamed from: b */
    private static final byte[] f17817b = new byte[]{(byte) 59, (byte) 60, (byte) 62, (byte) 64, (byte) 91, (byte) 92, (byte) 93, Framer.STDIN_REQUEST_FRAME_PREFIX, (byte) 96, (byte) 126, Framer.ENTER_FRAME_PREFIX, (byte) 13, (byte) 9, (byte) 44, (byte) 58, (byte) 10, Framer.STDIN_FRAME_PREFIX, (byte) 46, (byte) 36, (byte) 47, (byte) 34, (byte) 124, (byte) 42, (byte) 40, (byte) 41, (byte) 63, (byte) 123, (byte) 125, (byte) 39, (byte) 0};
    /* renamed from: c */
    private static final byte[] f17818c = new byte[128];
    /* renamed from: d */
    private static final byte[] f17819d = new byte[128];
    /* renamed from: e */
    private static final Charset f17820e = StandardCharsets.ISO_8859_1;

    /* renamed from: a */
    private static boolean m22394a(char c) {
        return c >= '0' && c <= '9';
    }

    /* renamed from: b */
    private static boolean m22396b(char c) {
        if (c != ' ') {
            if (c < 'A' || c > 'Z') {
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    private static boolean m22397c(char c) {
        if (c != ' ') {
            if (c < 'a' || c > 'z') {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    private static boolean m22400f(char c) {
        if (!(c == '\t' || c == '\n' || c == '\r')) {
            if (c < ' ' || c > '~') {
                return false;
            }
        }
        return true;
    }

    static {
        Arrays.fill(f17818c, (byte) -1);
        for (int i = 0; i < f17816a.length; i++) {
            byte b = f17816a[i];
            if (b > (byte) 0) {
                f17818c[b] = (byte) i;
            }
        }
        Arrays.fill(f17819d, (byte) -1);
        for (int i2 = 0; i2 < f17817b.length; i2++) {
            byte b2 = f17817b[i2];
            if (b2 > (byte) 0) {
                f17819d[b2] = (byte) i2;
            }
        }
    }

    /* renamed from: a */
    static String m22390a(String str, C5274c c5274c, Charset charset) {
        StringBuilder stringBuilder = new StringBuilder(str.length());
        if (charset == null) {
            charset = f17820e;
        } else if (!f17820e.equals(charset)) {
            C5204d a = C5204d.m22018a(charset.name());
            if (a != null) {
                C5279g.m22391a(a.m22019a(), stringBuilder);
            }
        }
        int length = str.length();
        switch (c5274c) {
            case TEXT:
                C5279g.m22388a((CharSequence) str, 0, length, stringBuilder, 0);
                break;
            case BYTE:
                byte[] bytes = str.getBytes(charset);
                C5279g.m22393a(bytes, 0, bytes.length, 1, stringBuilder);
                break;
            case NUMERIC:
                stringBuilder.append('Ά');
                C5279g.m22392a(str, 0, length, stringBuilder);
                break;
            default:
                int i = null;
                int i2 = 0;
                while (true) {
                    int i3 = 0;
                    while (i < length) {
                        int a2 = C5279g.m22387a((CharSequence) str, i);
                        if (a2 >= 13) {
                            stringBuilder.append('Ά');
                            i2 = 2;
                            C5279g.m22392a(str, i, a2, stringBuilder);
                            i += a2;
                        } else {
                            int b = C5279g.m22395b(str, i);
                            if (b < 5) {
                                if (a2 != length) {
                                    a2 = C5279g.m22389a(str, i, charset);
                                    if (a2 == 0) {
                                        a2 = 1;
                                    }
                                    a2 += i;
                                    byte[] bytes2 = str.substring(i, a2).getBytes(charset);
                                    if (bytes2.length == 1 && i2 == 0) {
                                        C5279g.m22393a(bytes2, 0, 1, 0, stringBuilder);
                                    } else {
                                        C5279g.m22393a(bytes2, 0, bytes2.length, i2, stringBuilder);
                                        i2 = 1;
                                        i3 = 0;
                                    }
                                    i = a2;
                                }
                            }
                            if (i2 != 0) {
                                stringBuilder.append('΄');
                                i2 = 0;
                                i3 = 0;
                            }
                            i3 = C5279g.m22388a((CharSequence) str, i, b, stringBuilder, i3);
                            i += b;
                        }
                    }
                    break;
                }
                break;
        }
        return stringBuilder.toString();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static int m22388a(java.lang.CharSequence r16, int r17, int r18, java.lang.StringBuilder r19, int r20) {
        /*
        r0 = r16;
        r1 = r18;
        r2 = r19;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r1);
        r4 = 2;
        r6 = 0;
        r9 = r20;
        r8 = 0;
    L_0x0010:
        r10 = r17 + r8;
        r11 = r0.charAt(r10);
        r12 = 26;
        r13 = 32;
        r14 = 28;
        r15 = 27;
        r5 = 29;
        switch(r9) {
            case 0: goto L_0x00b4;
            case 1: goto L_0x007b;
            case 2: goto L_0x0033;
            default: goto L_0x0023;
        };
    L_0x0023:
        r10 = com.google.p217b.p235f.p239c.C5279g.m22399e(r11);
        if (r10 == 0) goto L_0x011d;
    L_0x0029:
        r10 = f17819d;
        r10 = r10[r11];
        r10 = (char) r10;
        r3.append(r10);
        goto L_0x00ea;
    L_0x0033:
        r12 = com.google.p217b.p235f.p239c.C5279g.m22398d(r11);
        if (r12 == 0) goto L_0x0043;
    L_0x0039:
        r10 = f17818c;
        r10 = r10[r11];
        r10 = (char) r10;
        r3.append(r10);
        goto L_0x00ea;
    L_0x0043:
        r12 = com.google.p217b.p235f.p239c.C5279g.m22396b(r11);
        if (r12 == 0) goto L_0x004e;
    L_0x0049:
        r3.append(r14);
        goto L_0x0120;
    L_0x004e:
        r12 = com.google.p217b.p235f.p239c.C5279g.m22397c(r11);
        if (r12 == 0) goto L_0x0059;
    L_0x0054:
        r3.append(r15);
        goto L_0x00d0;
    L_0x0059:
        r10 = r10 + 1;
        if (r10 >= r1) goto L_0x006e;
    L_0x005d:
        r10 = r0.charAt(r10);
        r10 = com.google.p217b.p235f.p239c.C5279g.m22399e(r10);
        if (r10 == 0) goto L_0x006e;
    L_0x0067:
        r9 = 3;
        r5 = 25;
        r3.append(r5);
        goto L_0x0010;
    L_0x006e:
        r3.append(r5);
        r10 = f17819d;
        r10 = r10[r11];
        r10 = (char) r10;
        r3.append(r10);
        goto L_0x00ea;
    L_0x007b:
        r10 = com.google.p217b.p235f.p239c.C5279g.m22397c(r11);
        if (r10 == 0) goto L_0x008e;
    L_0x0081:
        if (r11 != r13) goto L_0x0087;
    L_0x0083:
        r3.append(r12);
        goto L_0x00ea;
    L_0x0087:
        r11 = r11 + -97;
        r10 = (char) r11;
        r3.append(r10);
        goto L_0x00ea;
    L_0x008e:
        r10 = com.google.p217b.p235f.p239c.C5279g.m22396b(r11);
        if (r10 == 0) goto L_0x009e;
    L_0x0094:
        r3.append(r15);
        r11 = r11 + -65;
        r10 = (char) r11;
        r3.append(r10);
        goto L_0x00ea;
    L_0x009e:
        r10 = com.google.p217b.p235f.p239c.C5279g.m22398d(r11);
        if (r10 == 0) goto L_0x00a8;
    L_0x00a4:
        r3.append(r14);
        goto L_0x00dc;
    L_0x00a8:
        r3.append(r5);
        r10 = f17819d;
        r10 = r10[r11];
        r10 = (char) r10;
        r3.append(r10);
        goto L_0x00ea;
    L_0x00b4:
        r10 = com.google.p217b.p235f.p239c.C5279g.m22396b(r11);
        if (r10 == 0) goto L_0x00c7;
    L_0x00ba:
        if (r11 != r13) goto L_0x00c0;
    L_0x00bc:
        r3.append(r12);
        goto L_0x00ea;
    L_0x00c0:
        r11 = r11 + -65;
        r10 = (char) r11;
        r3.append(r10);
        goto L_0x00ea;
    L_0x00c7:
        r10 = com.google.p217b.p235f.p239c.C5279g.m22397c(r11);
        if (r10 == 0) goto L_0x00d3;
    L_0x00cd:
        r3.append(r15);
    L_0x00d0:
        r9 = 1;
        goto L_0x0010;
    L_0x00d3:
        r10 = com.google.p217b.p235f.p239c.C5279g.m22398d(r11);
        if (r10 == 0) goto L_0x00df;
    L_0x00d9:
        r3.append(r14);
    L_0x00dc:
        r9 = 2;
        goto L_0x0010;
    L_0x00df:
        r3.append(r5);
        r10 = f17819d;
        r10 = r10[r11];
        r10 = (char) r10;
        r3.append(r10);
    L_0x00ea:
        r8 = r8 + 1;
        if (r8 < r1) goto L_0x0010;
    L_0x00ee:
        r0 = r3.length();
        r1 = 0;
        r7 = 0;
    L_0x00f4:
        if (r1 >= r0) goto L_0x0112;
    L_0x00f6:
        r8 = r1 % 2;
        if (r8 == 0) goto L_0x00fc;
    L_0x00fa:
        r8 = 1;
        goto L_0x00fd;
    L_0x00fc:
        r8 = 0;
    L_0x00fd:
        if (r8 == 0) goto L_0x010b;
    L_0x00ff:
        r7 = r7 * 30;
        r8 = r3.charAt(r1);
        r7 = r7 + r8;
        r7 = (char) r7;
        r2.append(r7);
        goto L_0x010f;
    L_0x010b:
        r7 = r3.charAt(r1);
    L_0x010f:
        r1 = r1 + 1;
        goto L_0x00f4;
    L_0x0112:
        r0 = r0 % r4;
        if (r0 == 0) goto L_0x011c;
    L_0x0115:
        r7 = r7 * 30;
        r7 = r7 + r5;
        r0 = (char) r7;
        r2.append(r0);
    L_0x011c:
        return r9;
    L_0x011d:
        r3.append(r5);
    L_0x0120:
        r9 = 0;
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.b.f.c.g.a(java.lang.CharSequence, int, int, java.lang.StringBuilder, int):int");
    }

    /* renamed from: a */
    private static void m22393a(byte[] bArr, int i, int i2, int i3, StringBuilder stringBuilder) {
        int i4;
        if (i2 == 1 && i3 == 0) {
            stringBuilder.append(913);
        } else if (i2 % 6 == 0) {
            stringBuilder.append(924);
        } else {
            stringBuilder.append(901);
        }
        if (i2 >= 6) {
            char[] cArr = new char[5];
            i4 = i;
            while ((i + i2) - i4 >= 6) {
                int i5;
                long j = 0;
                for (i5 = 0; i5 < 6; i5++) {
                    j = (j << 8) + ((long) (bArr[i4 + i5] & JfifUtil.MARKER_FIRST_BYTE));
                }
                for (int i6 = 0; i6 < 5; i6++) {
                    cArr[i6] = (char) ((int) (j % 900));
                    j /= 900;
                }
                for (i5 = 4; i5 >= 0; i5--) {
                    stringBuilder.append(cArr[i5]);
                }
                i4 += 6;
            }
        } else {
            i4 = i;
        }
        while (i4 < i + i2) {
            stringBuilder.append((char) (bArr[i4] & JfifUtil.MARKER_FIRST_BYTE));
            i4++;
        }
    }

    /* renamed from: a */
    private static void m22392a(String str, int i, int i2, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder((i2 / 3) + 1);
        BigInteger valueOf = BigInteger.valueOf(900);
        BigInteger valueOf2 = BigInteger.valueOf(0);
        int i3 = 0;
        while (i3 < i2) {
            stringBuilder2.setLength(0);
            int min = Math.min(44, i2 - i3);
            StringBuilder stringBuilder3 = new StringBuilder(AppEventsConstants.EVENT_PARAM_VALUE_YES);
            int i4 = i + i3;
            stringBuilder3.append(str.substring(i4, i4 + min));
            BigInteger bigInteger = new BigInteger(stringBuilder3.toString());
            do {
                stringBuilder2.append((char) bigInteger.mod(valueOf).intValue());
                bigInteger = bigInteger.divide(valueOf);
            } while (!bigInteger.equals(valueOf2));
            for (int length = stringBuilder2.length() - 1; length >= 0; length--) {
                stringBuilder.append(stringBuilder2.charAt(length));
            }
            i3 += min;
        }
    }

    /* renamed from: d */
    private static boolean m22398d(char c) {
        return f17818c[c] != '￿';
    }

    /* renamed from: e */
    private static boolean m22399e(char c) {
        return f17819d[c] != '￿';
    }

    /* renamed from: a */
    private static int m22387a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        if (i < length) {
            char charAt = charSequence.charAt(i);
            while (C5279g.m22394a(charAt) && i < length) {
                i2++;
                i++;
                if (i < length) {
                    charAt = charSequence.charAt(i);
                }
            }
        }
        return i2;
    }

    /* renamed from: b */
    private static int m22395b(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = i;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            int i3 = 0;
            while (i3 < 13 && C5279g.m22394a(r2) && i2 < length) {
                i3++;
                i2++;
                if (i2 < length) {
                    charAt = charSequence.charAt(i2);
                }
            }
            if (i3 < 13) {
                if (i3 <= 0) {
                    if (!C5279g.m22400f(charSequence.charAt(i2))) {
                        break;
                    }
                    i2++;
                }
            } else {
                return (i2 - i) - i3;
            }
        }
        return i2 - i;
    }

    /* renamed from: a */
    private static int m22389a(String str, int i, Charset charset) {
        charset = charset.newEncoder();
        int length = str.length();
        int i2 = i;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            int i3 = 0;
            while (i3 < 13 && C5279g.m22394a(r2)) {
                i3++;
                int i4 = i2 + i3;
                if (i4 >= length) {
                    break;
                }
                charAt = str.charAt(i4);
            }
            if (i3 >= 13) {
                return i2 - i;
            }
            charAt = str.charAt(i2);
            if (charset.canEncode(charAt)) {
                i2++;
            } else {
                i = new StringBuilder("Non-encodable character detected: ");
                i.append(charAt);
                i.append(" (Unicode: ");
                i.append(charAt);
                i.append(')');
                throw new C5319v(i.toString());
            }
        }
        return i2 - i;
    }

    /* renamed from: a */
    private static void m22391a(int i, StringBuilder stringBuilder) {
        if (i >= 0 && i < 900) {
            stringBuilder.append('Ο');
            stringBuilder.append((char) i);
        } else if (i < 810900) {
            stringBuilder.append('Ξ');
            stringBuilder.append((char) ((i / 900) - 1));
            stringBuilder.append((char) (i % 900));
        } else if (i < 811800) {
            stringBuilder.append('Ν');
            stringBuilder.append((char) (810900 - i));
        } else {
            throw new C5319v("ECI number not in valid range from 0..811799, but was ".concat(String.valueOf(i)));
        }
    }
}
