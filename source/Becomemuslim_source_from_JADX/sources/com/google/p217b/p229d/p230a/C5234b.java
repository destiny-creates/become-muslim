package com.google.p217b.p229d.p230a;

import com.facebook.stetho.dumpapp.Framer;
import com.google.p217b.p222b.C5205e;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/* compiled from: DecodedBitStreamParser */
/* renamed from: com.google.b.d.a.b */
final class C5234b {
    /* renamed from: a */
    private static final String[] f17672a = new String[]{"\nABCDEFGHIJKLMNOPQRSTUVWXYZ￺\u001c\u001d\u001e￻ ￼\"#$%&'()*+,-./0123456789:￱￲￳￴￸", "`abcdefghijklmnopqrstuvwxyz￺\u001c\u001d\u001e￻{￼}~;<=>?[\\]^_ ,./:@!|￼￵￶￼￰￲￳￴￷", "ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚ￺\u001c\u001d\u001eÛÜÝÞßª¬±²³µ¹º¼½¾￷ ￹￳￴￸", "àáâãäåæçèéêëìíîïðñòóôõö÷øùú￺\u001c\u001d\u001e￻ûüýþÿ¡¨«¯°´·¸»¿￷ ￲￹￴￸", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a￺￼￼\u001b￻\u001c\u001d\u001e\u001f ¢£¤¥¦§©­®¶￷ ￲￳￹￸", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123456789:;<=>?"};

    /* renamed from: a */
    static C5205e m22171a(byte[] bArr, int i) {
        StringBuilder stringBuilder = new StringBuilder(144);
        switch (i) {
            case 2:
            case 3:
                String format;
                if (i == 2) {
                    format = new DecimalFormat("0000000000".substring(0, C5234b.m22174c(bArr))).format((long) C5234b.m22175d(bArr));
                } else {
                    format = C5234b.m22176e(bArr);
                }
                NumberFormat decimalFormat = new DecimalFormat("000");
                String format2 = decimalFormat.format((long) C5234b.m22169a(bArr));
                String format3 = decimalFormat.format((long) C5234b.m22173b(bArr));
                stringBuilder.append(C5234b.m22172a(bArr, 10, 84));
                StringBuilder stringBuilder2;
                if (!stringBuilder.toString().startsWith("[)>\u001e01\u001d")) {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(format);
                    stringBuilder2.append('\u001d');
                    stringBuilder2.append(format2);
                    stringBuilder2.append('\u001d');
                    stringBuilder2.append(format3);
                    stringBuilder2.append('\u001d');
                    stringBuilder.insert(0, stringBuilder2.toString());
                    break;
                }
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(format);
                stringBuilder2.append('\u001d');
                stringBuilder2.append(format2);
                stringBuilder2.append('\u001d');
                stringBuilder2.append(format3);
                stringBuilder2.append('\u001d');
                stringBuilder.insert(9, stringBuilder2.toString());
                break;
            case 4:
                stringBuilder.append(C5234b.m22172a(bArr, 1, 93));
                break;
            case 5:
                stringBuilder.append(C5234b.m22172a(bArr, 1, 77));
                break;
            default:
                break;
        }
        return new C5205e(bArr, stringBuilder.toString(), null, String.valueOf(i));
    }

    /* renamed from: a */
    private static int m22168a(int i, byte[] bArr) {
        i--;
        return ((1 << (5 - (i % 6))) & bArr[i / 6]) == 0 ? 0 : 1;
    }

    /* renamed from: a */
    private static int m22170a(byte[] bArr, byte[] bArr2) {
        if (bArr2.length != 0) {
            int i = 0;
            for (int i2 = 0; i2 < bArr2.length; i2++) {
                i += C5234b.m22168a(bArr2[i2], bArr) << ((bArr2.length - i2) - 1);
            }
            return i;
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: a */
    private static int m22169a(byte[] bArr) {
        return C5234b.m22170a(bArr, new byte[]{(byte) 53, (byte) 54, (byte) 43, (byte) 44, Framer.STDIN_FRAME_PREFIX, (byte) 46, (byte) 47, (byte) 48, (byte) 37, (byte) 38});
    }

    /* renamed from: b */
    private static int m22173b(byte[] bArr) {
        return C5234b.m22170a(bArr, new byte[]{(byte) 55, (byte) 56, (byte) 57, (byte) 58, (byte) 59, (byte) 60, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, (byte) 51, (byte) 52});
    }

    /* renamed from: c */
    private static int m22174c(byte[] bArr) {
        return C5234b.m22170a(bArr, new byte[]{(byte) 39, (byte) 40, (byte) 41, (byte) 42, (byte) 31, (byte) 32});
    }

    /* renamed from: d */
    private static int m22175d(byte[] bArr) {
        return C5234b.m22170a(bArr, new byte[]{Framer.ENTER_FRAME_PREFIX, (byte) 34, (byte) 35, (byte) 36, (byte) 25, (byte) 26, (byte) 27, (byte) 28, (byte) 29, (byte) 30, (byte) 19, (byte) 20, (byte) 21, (byte) 22, (byte) 23, (byte) 24, (byte) 13, (byte) 14, (byte) 15, (byte) 16, (byte) 17, (byte) 18, (byte) 7, (byte) 8, (byte) 9, (byte) 10, (byte) 11, (byte) 12, (byte) 1, (byte) 2});
    }

    /* renamed from: e */
    private static String m22176e(byte[] bArr) {
        return String.valueOf(new char[]{f17672a[0].charAt(C5234b.m22170a(bArr, new byte[]{(byte) 39, (byte) 40, (byte) 41, (byte) 42, (byte) 31, (byte) 32})), f17672a[0].charAt(C5234b.m22170a(bArr, new byte[]{Framer.ENTER_FRAME_PREFIX, (byte) 34, (byte) 35, (byte) 36, (byte) 25, (byte) 26})), f17672a[0].charAt(C5234b.m22170a(bArr, new byte[]{(byte) 27, (byte) 28, (byte) 29, (byte) 30, (byte) 19, (byte) 20})), f17672a[0].charAt(C5234b.m22170a(bArr, new byte[]{(byte) 21, (byte) 22, (byte) 23, (byte) 24, (byte) 13, (byte) 14})), f17672a[0].charAt(C5234b.m22170a(bArr, new byte[]{(byte) 15, (byte) 16, (byte) 17, (byte) 18, (byte) 7, (byte) 8})), f17672a[0].charAt(C5234b.m22170a(bArr, new byte[]{(byte) 9, (byte) 10, (byte) 11, (byte) 12, (byte) 1, (byte) 2}))});
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static java.lang.String m22172a(byte[] r12, int r13, int r14) {
        /*
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = 0;
        r2 = -1;
        r3 = r13;
        r4 = 0;
        r5 = -1;
        r6 = 0;
    L_0x000b:
        r7 = r13 + r14;
        r8 = 1;
        if (r3 >= r7) goto L_0x0068;
    L_0x0010:
        r7 = f17672a;
        r7 = r7[r4];
        r9 = r12[r3];
        r7 = r7.charAt(r9);
        switch(r7) {
            case 65520: goto L_0x0058;
            case 65521: goto L_0x0058;
            case 65522: goto L_0x0058;
            case 65523: goto L_0x0058;
            case 65524: goto L_0x0058;
            case 65525: goto L_0x0054;
            case 65526: goto L_0x0052;
            case 65527: goto L_0x004f;
            case 65528: goto L_0x004d;
            case 65529: goto L_0x0050;
            case 65530: goto L_0x001d;
            case 65531: goto L_0x0021;
            default: goto L_0x001d;
        };
    L_0x001d:
        r0.append(r7);
        goto L_0x0060;
    L_0x0021:
        r3 = r3 + 1;
        r7 = r12[r3];
        r7 = r7 << 24;
        r3 = r3 + r8;
        r9 = r12[r3];
        r9 = r9 << 18;
        r7 = r7 + r9;
        r3 = r3 + r8;
        r9 = r12[r3];
        r9 = r9 << 12;
        r7 = r7 + r9;
        r3 = r3 + r8;
        r9 = r12[r3];
        r9 = r9 << 6;
        r7 = r7 + r9;
        r3 = r3 + r8;
        r9 = r12[r3];
        r7 = r7 + r9;
        r9 = new java.text.DecimalFormat;
        r10 = "000000000";
        r9.<init>(r10);
        r10 = (long) r7;
        r7 = r9.format(r10);
        r0.append(r7);
        goto L_0x0060;
    L_0x004d:
        r4 = 1;
        goto L_0x0050;
    L_0x004f:
        r4 = 0;
    L_0x0050:
        r5 = -1;
        goto L_0x0060;
    L_0x0052:
        r5 = 3;
        goto L_0x0055;
    L_0x0054:
        r5 = 2;
    L_0x0055:
        r6 = r4;
        r4 = 0;
        goto L_0x0060;
    L_0x0058:
        r5 = 65520; // 0xfff0 float:9.1813E-41 double:3.2371E-319;
        r5 = r7 - r5;
        r6 = r4;
        r4 = r5;
        r5 = 1;
    L_0x0060:
        r7 = r5 + -1;
        if (r5 != 0) goto L_0x0065;
    L_0x0064:
        r4 = r6;
    L_0x0065:
        r3 = r3 + r8;
        r5 = r7;
        goto L_0x000b;
    L_0x0068:
        r12 = r0.length();
        if (r12 <= 0) goto L_0x0085;
    L_0x006e:
        r12 = r0.length();
        r12 = r12 - r8;
        r12 = r0.charAt(r12);
        r13 = 65532; // 0xfffc float:9.183E-41 double:3.2377E-319;
        if (r12 != r13) goto L_0x0085;
    L_0x007c:
        r12 = r0.length();
        r12 = r12 - r8;
        r0.setLength(r12);
        goto L_0x0068;
    L_0x0085:
        r12 = r0.toString();
        return r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.b.d.a.b.a(byte[], int, int):java.lang.String");
    }
}
