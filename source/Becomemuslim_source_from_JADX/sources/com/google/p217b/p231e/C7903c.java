package com.google.p217b.p231e;

import com.google.p217b.C6894l;
import com.google.p217b.p222b.C5196a;

/* compiled from: Code128Reader */
/* renamed from: com.google.b.e.c */
public final class C7903c extends C6873r {
    /* renamed from: a */
    static final int[][] f29500a = new int[][]{new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};

    /* renamed from: a */
    private static int[] m38458a(C5196a c5196a) {
        int a = c5196a.m21954a();
        int c = c5196a.m21965c(0);
        Object obj = new int[6];
        int i = c;
        int i2 = 0;
        int i3 = 0;
        while (c < a) {
            if (c5196a.m21959a(c) != i2) {
                obj[i3] = obj[i3] + 1;
            } else {
                if (i3 == 5) {
                    int i4;
                    float f = 0.25f;
                    int i5 = -1;
                    for (i4 = 103; i4 <= 105; i4++) {
                        float a2 = C6873r.m32294a((int[]) obj, f29500a[i4], 0.7f);
                        if (a2 < f) {
                            i5 = i4;
                            f = a2;
                        }
                    }
                    if (i5 < 0 || !c5196a.m21960a(Math.max(0, i - ((c - i) / 2)), i, false)) {
                        i += obj[0] + obj[1];
                        i4 = i3 - 1;
                        System.arraycopy(obj, 2, obj, 0, i4);
                        obj[i4] = null;
                        obj[i3] = null;
                        i3--;
                    } else {
                        return new int[]{i, c, i5};
                    }
                }
                i3++;
                obj[i3] = 1;
                i2 ^= 1;
            }
            c++;
        }
        throw C6894l.m32349a();
    }

    /* renamed from: a */
    private static int m38457a(C5196a c5196a, int[] iArr, int i) {
        C6873r.m32295a(c5196a, i, iArr);
        c5196a = 1048576000;
        i = -1;
        for (int i2 = 0; i2 < f29500a.length; i2++) {
            float a = C6873r.m32294a(iArr, f29500a[i2], 0.7f);
            if (a < c5196a) {
                i = i2;
                c5196a = a;
            }
        }
        if (i >= 0) {
            return i;
        }
        throw C6894l.m32349a();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public com.google.p217b.C5314q mo6260a(int r23, com.google.p217b.p222b.C5196a r24, java.util.Map<com.google.p217b.C5254e, ?> r25) {
        /*
        r22 = this;
        r0 = r24;
        r1 = r25;
        r2 = 1;
        r3 = 0;
        if (r1 == 0) goto L_0x0012;
    L_0x0008:
        r4 = com.google.p217b.C5254e.ASSUME_GS1;
        r1 = r1.containsKey(r4);
        if (r1 == 0) goto L_0x0012;
    L_0x0010:
        r1 = 1;
        goto L_0x0013;
    L_0x0012:
        r1 = 0;
    L_0x0013:
        r4 = com.google.p217b.p231e.C7903c.m38458a(r24);
        r5 = 2;
        r6 = r4[r5];
        r7 = new java.util.ArrayList;
        r8 = 20;
        r7.<init>(r8);
        r9 = (byte) r6;
        r9 = java.lang.Byte.valueOf(r9);
        r7.add(r9);
        switch(r6) {
            case 103: goto L_0x0037;
            case 104: goto L_0x0034;
            case 105: goto L_0x0031;
            default: goto L_0x002c;
        };
    L_0x002c:
        r0 = com.google.p217b.C6891h.m32342a();
        throw r0;
    L_0x0031:
        r12 = 99;
        goto L_0x0039;
    L_0x0034:
        r12 = 100;
        goto L_0x0039;
    L_0x0037:
        r12 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
    L_0x0039:
        r13 = new java.lang.StringBuilder;
        r13.<init>(r8);
        r8 = r4[r3];
        r14 = r4[r2];
        r15 = 6;
        r2 = new int[r15];
        r16 = r6;
        r9 = r8;
        r3 = r12;
        r5 = 0;
        r6 = 0;
        r8 = 0;
        r11 = 0;
        r12 = 0;
        r17 = 0;
        r18 = 0;
        r19 = 1;
    L_0x0054:
        if (r6 != 0) goto L_0x01aa;
    L_0x0056:
        r9 = com.google.p217b.p231e.C7903c.m38457a(r0, r2, r14);
        r10 = (byte) r9;
        r10 = java.lang.Byte.valueOf(r10);
        r7.add(r10);
        r10 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        if (r9 == r10) goto L_0x0068;
    L_0x0066:
        r19 = 1;
    L_0x0068:
        if (r9 == r10) goto L_0x0070;
    L_0x006a:
        r17 = r17 + 1;
        r18 = r17 * r9;
        r16 = r16 + r18;
    L_0x0070:
        r18 = r14;
        r10 = 0;
    L_0x0073:
        if (r10 >= r15) goto L_0x007c;
    L_0x0075:
        r20 = r2[r10];
        r18 = r18 + r20;
        r10 = r10 + 1;
        goto L_0x0073;
    L_0x007c:
        switch(r9) {
            case 103: goto L_0x0088;
            case 104: goto L_0x0088;
            case 105: goto L_0x0088;
            default: goto L_0x007f;
        };
    L_0x007f:
        r10 = 96;
        switch(r3) {
            case 99: goto L_0x0150;
            case 100: goto L_0x00ed;
            case 101: goto L_0x008d;
            default: goto L_0x0084;
        };
    L_0x0084:
        r10 = 100;
        goto L_0x018d;
    L_0x0088:
        r0 = com.google.p217b.C6891h.m32342a();
        throw r0;
    L_0x008d:
        r15 = 64;
        if (r9 >= r15) goto L_0x00a4;
    L_0x0091:
        if (r5 != r11) goto L_0x009b;
    L_0x0093:
        r5 = r9 + 32;
        r5 = (char) r5;
        r13.append(r5);
        goto L_0x0100;
    L_0x009b:
        r5 = r9 + 32;
        r5 = r5 + 128;
        r5 = (char) r5;
        r13.append(r5);
        goto L_0x0100;
    L_0x00a4:
        if (r9 >= r10) goto L_0x00b6;
    L_0x00a6:
        if (r5 != r11) goto L_0x00af;
    L_0x00a8:
        r5 = r9 + -64;
        r5 = (char) r5;
        r13.append(r5);
        goto L_0x0100;
    L_0x00af:
        r5 = r9 + 64;
        r5 = (char) r5;
        r13.append(r5);
        goto L_0x0100;
    L_0x00b6:
        r10 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        if (r9 == r10) goto L_0x00bc;
    L_0x00ba:
        r19 = 0;
    L_0x00bc:
        if (r9 == r10) goto L_0x014a;
    L_0x00be:
        switch(r9) {
            case 96: goto L_0x014b;
            case 97: goto L_0x014b;
            case 98: goto L_0x00e8;
            case 99: goto L_0x0141;
            case 100: goto L_0x00e3;
            case 101: goto L_0x00d9;
            case 102: goto L_0x00c3;
            default: goto L_0x00c1;
        };
    L_0x00c1:
        goto L_0x014b;
    L_0x00c3:
        if (r1 == 0) goto L_0x014b;
    L_0x00c5:
        r10 = r13.length();
        if (r10 != 0) goto L_0x00d2;
    L_0x00cb:
        r10 = "]C1";
        r13.append(r10);
        goto L_0x014b;
    L_0x00d2:
        r10 = 29;
        r13.append(r10);
        goto L_0x014b;
    L_0x00d9:
        if (r11 != 0) goto L_0x00de;
    L_0x00db:
        if (r5 == 0) goto L_0x00de;
    L_0x00dd:
        goto L_0x012e;
    L_0x00de:
        if (r11 == 0) goto L_0x013c;
    L_0x00e0:
        if (r5 == 0) goto L_0x013c;
    L_0x00e2:
        goto L_0x0137;
    L_0x00e3:
        r15 = r5;
        r3 = 100;
        goto L_0x014c;
    L_0x00e8:
        r15 = r5;
        r3 = 100;
        goto L_0x0148;
    L_0x00ed:
        if (r9 >= r10) goto L_0x0106;
    L_0x00ef:
        if (r5 != r11) goto L_0x00f8;
    L_0x00f1:
        r5 = r9 + 32;
        r5 = (char) r5;
        r13.append(r5);
        goto L_0x0100;
    L_0x00f8:
        r5 = r9 + 32;
        r5 = r5 + 128;
        r5 = (char) r5;
        r13.append(r5);
    L_0x0100:
        r5 = 0;
        r10 = 100;
    L_0x0103:
        r15 = 0;
        goto L_0x018f;
    L_0x0106:
        r10 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        if (r9 == r10) goto L_0x010c;
    L_0x010a:
        r19 = 0;
    L_0x010c:
        if (r9 == r10) goto L_0x014a;
    L_0x010e:
        switch(r9) {
            case 96: goto L_0x014b;
            case 97: goto L_0x014b;
            case 98: goto L_0x0145;
            case 99: goto L_0x0141;
            case 100: goto L_0x012a;
            case 101: goto L_0x0126;
            case 102: goto L_0x0112;
            default: goto L_0x0111;
        };
    L_0x0111:
        goto L_0x014b;
    L_0x0112:
        if (r1 == 0) goto L_0x014b;
    L_0x0114:
        r10 = r13.length();
        if (r10 != 0) goto L_0x0120;
    L_0x011a:
        r10 = "]C1";
        r13.append(r10);
        goto L_0x014b;
    L_0x0120:
        r10 = 29;
        r13.append(r10);
        goto L_0x014b;
    L_0x0126:
        r15 = r5;
        r3 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        goto L_0x014c;
    L_0x012a:
        if (r11 != 0) goto L_0x0133;
    L_0x012c:
        if (r5 == 0) goto L_0x0133;
    L_0x012e:
        r5 = 0;
        r10 = 100;
        r11 = 1;
        goto L_0x0103;
    L_0x0133:
        if (r11 == 0) goto L_0x013c;
    L_0x0135:
        if (r5 == 0) goto L_0x013c;
    L_0x0137:
        r5 = 0;
        r10 = 100;
        r11 = 0;
        goto L_0x0103;
    L_0x013c:
        r5 = 0;
        r10 = 100;
        r15 = 1;
        goto L_0x018f;
    L_0x0141:
        r15 = r5;
        r3 = 99;
        goto L_0x014c;
    L_0x0145:
        r15 = r5;
        r3 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
    L_0x0148:
        r5 = 1;
        goto L_0x014d;
    L_0x014a:
        r6 = 1;
    L_0x014b:
        r15 = r5;
    L_0x014c:
        r5 = 0;
    L_0x014d:
        r10 = 100;
        goto L_0x018f;
    L_0x0150:
        r10 = 100;
        if (r9 >= r10) goto L_0x0161;
    L_0x0154:
        r15 = 10;
        if (r9 >= r15) goto L_0x015d;
    L_0x0158:
        r15 = 48;
        r13.append(r15);
    L_0x015d:
        r13.append(r9);
        goto L_0x018d;
    L_0x0161:
        r15 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        if (r9 == r15) goto L_0x0167;
    L_0x0165:
        r19 = 0;
    L_0x0167:
        if (r9 == r15) goto L_0x0189;
    L_0x0169:
        switch(r9) {
            case 100: goto L_0x0185;
            case 101: goto L_0x0181;
            case 102: goto L_0x016d;
            default: goto L_0x016c;
        };
    L_0x016c:
        goto L_0x018d;
    L_0x016d:
        if (r1 == 0) goto L_0x018d;
    L_0x016f:
        r15 = r13.length();
        if (r15 != 0) goto L_0x017b;
    L_0x0175:
        r15 = "]C1";
        r13.append(r15);
        goto L_0x018d;
    L_0x017b:
        r15 = 29;
        r13.append(r15);
        goto L_0x018d;
    L_0x0181:
        r15 = r5;
        r3 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        goto L_0x018e;
    L_0x0185:
        r15 = r5;
        r3 = 100;
        goto L_0x018e;
    L_0x0189:
        r15 = r5;
        r5 = 0;
        r6 = 1;
        goto L_0x018f;
    L_0x018d:
        r15 = r5;
    L_0x018e:
        r5 = 0;
    L_0x018f:
        if (r8 == 0) goto L_0x019b;
    L_0x0191:
        r8 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        if (r3 != r8) goto L_0x0198;
    L_0x0195:
        r3 = 100;
        goto L_0x019d;
    L_0x0198:
        r3 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        goto L_0x019d;
    L_0x019b:
        r8 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
    L_0x019d:
        r8 = r5;
        r5 = r15;
        r15 = 6;
        r21 = r12;
        r12 = r9;
        r9 = r14;
        r14 = r18;
        r18 = r21;
        goto L_0x0054;
    L_0x01aa:
        r1 = r14 - r9;
        r2 = r0.m21967d(r14);
        r5 = r24.m21954a();
        r6 = r2 - r9;
        r8 = 2;
        r6 = r6 / r8;
        r6 = r6 + r2;
        r5 = java.lang.Math.min(r5, r6);
        r6 = 0;
        r0 = r0.m21960a(r2, r5, r6);
        if (r0 == 0) goto L_0x023a;
    L_0x01c4:
        r12 = r18;
        r17 = r17 * r12;
        r16 = r16 - r17;
        r0 = r16 % 103;
        if (r0 != r12) goto L_0x0235;
    L_0x01ce:
        r0 = r13.length();
        if (r0 == 0) goto L_0x0230;
    L_0x01d4:
        if (r0 <= 0) goto L_0x01e7;
    L_0x01d6:
        if (r19 == 0) goto L_0x01e7;
    L_0x01d8:
        r2 = 99;
        if (r3 != r2) goto L_0x01e2;
    L_0x01dc:
        r2 = r0 + -2;
        r13.delete(r2, r0);
        goto L_0x01e7;
    L_0x01e2:
        r2 = r0 + -1;
        r13.delete(r2, r0);
    L_0x01e7:
        r0 = 1;
        r2 = r4[r0];
        r0 = 0;
        r3 = r4[r0];
        r2 = r2 + r3;
        r0 = (float) r2;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r0 = r0 / r2;
        r3 = (float) r9;
        r1 = (float) r1;
        r1 = r1 / r2;
        r3 = r3 + r1;
        r1 = r7.size();
        r2 = new byte[r1];
        r4 = 0;
    L_0x01fd:
        if (r4 >= r1) goto L_0x020e;
    L_0x01ff:
        r5 = r7.get(r4);
        r5 = (java.lang.Byte) r5;
        r5 = r5.byteValue();
        r2[r4] = r5;
        r4 = r4 + 1;
        goto L_0x01fd;
    L_0x020e:
        r1 = new com.google.b.q;
        r4 = r13.toString();
        r5 = 2;
        r5 = new com.google.p217b.C5316s[r5];
        r6 = new com.google.b.s;
        r7 = r23;
        r7 = (float) r7;
        r6.<init>(r0, r7);
        r0 = 0;
        r5[r0] = r6;
        r0 = new com.google.b.s;
        r0.<init>(r3, r7);
        r3 = 1;
        r5[r3] = r0;
        r0 = com.google.p217b.C5193a.CODE_128;
        r1.<init>(r4, r2, r5, r0);
        return r1;
    L_0x0230:
        r0 = com.google.p217b.C6894l.m32349a();
        throw r0;
    L_0x0235:
        r0 = com.google.p217b.C6866d.m32277a();
        throw r0;
    L_0x023a:
        r0 = com.google.p217b.C6894l.m32349a();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.b.e.c.a(int, com.google.b.b.a, java.util.Map):com.google.b.q");
    }
}
