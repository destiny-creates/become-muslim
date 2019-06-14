package com.google.android.gms.internal.ads;

final class aev extends aes {
    aev() {
    }

    /* renamed from: a */
    private static int m29898a(byte[] bArr, int i, long j, int i2) {
        switch (i2) {
            case 0:
                return aer.m18269b(i);
            case 1:
                return aer.m18270b(i, aep.m18219a(bArr, j));
            case 2:
                return aer.m18271b(i, aep.m18219a(bArr, j), aep.m18219a(bArr, j + 1));
            default:
                throw new AssertionError();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    final int mo3801a(int r18, byte[] r19, int r20, int r21) {
        /*
        r17 = this;
        r0 = r19;
        r1 = r20;
        r2 = r21;
        r3 = r1 | r2;
        r4 = r0.length;
        r4 = r4 - r2;
        r3 = r3 | r4;
        r4 = 2;
        r5 = 3;
        r6 = 0;
        if (r3 < 0) goto L_0x00bc;
    L_0x0010:
        r7 = (long) r1;
        r1 = (long) r2;
        r1 = r1 - r7;
        r1 = (int) r1;
        r2 = 16;
        r9 = 1;
        if (r1 >= r2) goto L_0x001c;
    L_0x001a:
        r2 = 0;
        goto L_0x002e;
    L_0x001c:
        r11 = r7;
        r2 = 0;
    L_0x001e:
        if (r2 >= r1) goto L_0x002d;
    L_0x0020:
        r13 = r11 + r9;
        r3 = com.google.android.gms.internal.ads.aep.m18219a(r0, r11);
        if (r3 >= 0) goto L_0x0029;
    L_0x0028:
        goto L_0x002e;
    L_0x0029:
        r2 = r2 + 1;
        r11 = r13;
        goto L_0x001e;
    L_0x002d:
        r2 = r1;
    L_0x002e:
        r1 = r1 - r2;
        r2 = (long) r2;
        r7 = r7 + r2;
    L_0x0031:
        r2 = 0;
    L_0x0032:
        if (r1 <= 0) goto L_0x0045;
    L_0x0034:
        r2 = r7 + r9;
        r7 = com.google.android.gms.internal.ads.aep.m18219a(r0, r7);
        if (r7 < 0) goto L_0x0042;
    L_0x003c:
        r1 = r1 + -1;
        r15 = r2;
        r2 = r7;
        r7 = r15;
        goto L_0x0032;
    L_0x0042:
        r15 = r2;
        r2 = r7;
        r7 = r15;
    L_0x0045:
        if (r1 != 0) goto L_0x0048;
    L_0x0047:
        return r6;
    L_0x0048:
        r1 = r1 + -1;
        r3 = -32;
        r11 = -65;
        r12 = -1;
        if (r2 >= r3) goto L_0x0066;
    L_0x0051:
        if (r1 != 0) goto L_0x0054;
    L_0x0053:
        return r2;
    L_0x0054:
        r1 = r1 + -1;
        r3 = -62;
        if (r2 < r3) goto L_0x0065;
    L_0x005a:
        r2 = r7 + r9;
        r7 = com.google.android.gms.internal.ads.aep.m18219a(r0, r7);
        if (r7 <= r11) goto L_0x0063;
    L_0x0062:
        goto L_0x0065;
    L_0x0063:
        r7 = r2;
        goto L_0x0031;
    L_0x0065:
        return r12;
    L_0x0066:
        r13 = -16;
        if (r2 >= r13) goto L_0x0091;
    L_0x006a:
        if (r1 >= r4) goto L_0x0071;
    L_0x006c:
        r0 = m29898a(r0, r2, r7, r1);
        return r0;
    L_0x0071:
        r1 = r1 + -2;
        r13 = r7 + r9;
        r7 = com.google.android.gms.internal.ads.aep.m18219a(r0, r7);
        if (r7 > r11) goto L_0x0090;
    L_0x007b:
        r8 = -96;
        if (r2 != r3) goto L_0x0081;
    L_0x007f:
        if (r7 < r8) goto L_0x0090;
    L_0x0081:
        r3 = -19;
        if (r2 != r3) goto L_0x0087;
    L_0x0085:
        if (r7 >= r8) goto L_0x0090;
    L_0x0087:
        r2 = 0;
        r7 = r13 + r9;
        r2 = com.google.android.gms.internal.ads.aep.m18219a(r0, r13);
        if (r2 <= r11) goto L_0x0031;
    L_0x0090:
        return r12;
    L_0x0091:
        if (r1 >= r5) goto L_0x0098;
    L_0x0093:
        r0 = m29898a(r0, r2, r7, r1);
        return r0;
    L_0x0098:
        r1 = r1 + -3;
        r13 = r7 + r9;
        r3 = com.google.android.gms.internal.ads.aep.m18219a(r0, r7);
        if (r3 > r11) goto L_0x00bb;
    L_0x00a2:
        r2 = r2 << 28;
        r3 = r3 + 112;
        r2 = r2 + r3;
        r2 = r2 >> 30;
        if (r2 != 0) goto L_0x00bb;
    L_0x00ab:
        r2 = r13 + r9;
        r7 = com.google.android.gms.internal.ads.aep.m18219a(r0, r13);
        if (r7 > r11) goto L_0x00bb;
    L_0x00b3:
        r7 = r2 + r9;
        r2 = com.google.android.gms.internal.ads.aep.m18219a(r0, r2);
        if (r2 <= r11) goto L_0x0031;
    L_0x00bb:
        return r12;
    L_0x00bc:
        r3 = new java.lang.ArrayIndexOutOfBoundsException;
        r5 = new java.lang.Object[r5];
        r0 = r0.length;
        r0 = java.lang.Integer.valueOf(r0);
        r5[r6] = r0;
        r0 = java.lang.Integer.valueOf(r20);
        r1 = 1;
        r5[r1] = r0;
        r0 = java.lang.Integer.valueOf(r21);
        r5[r4] = r0;
        r0 = "Array length=%d, index=%d, limit=%d";
        r0 = java.lang.String.format(r0, r5);
        r3.<init>(r0);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aev.a(int, byte[], int, int):int");
    }

    /* renamed from: a */
    final int mo3802a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        CharSequence charSequence2 = charSequence;
        byte[] bArr2 = bArr;
        int i3 = i;
        int i4 = i2;
        long j = (long) i3;
        long j2 = ((long) i4) + j;
        int length = charSequence.length();
        if (length > i4 || bArr2.length - i4 < i3) {
            char charAt = charSequence2.charAt(length - 1);
            i3 += i4;
            StringBuilder stringBuilder = new StringBuilder(37);
            stringBuilder.append("Failed writing ");
            stringBuilder.append(charAt);
            stringBuilder.append(" at index ");
            stringBuilder.append(i3);
            throw new ArrayIndexOutOfBoundsException(stringBuilder.toString());
        }
        i3 = 0;
        while (i3 < length) {
            char charAt2 = charSequence2.charAt(i3);
            if (charAt2 >= '') {
                break;
            }
            long j3 = 1 + j;
            aep.m18231a(bArr2, j, (byte) charAt2);
            i3++;
            j = j3;
        }
        if (i3 == length) {
            return (int) j;
        }
        while (i3 < length) {
            long j4;
            int charAt3 = charSequence2.charAt(i3);
            if (charAt3 < 128 && j < j2) {
                j4 = j + 1;
            } else if (charAt3 < 2048 && j <= j2 - 2) {
                j4 = j + 1;
                aep.m18231a(bArr2, j, (byte) ((charAt3 >>> 6) | 960));
                j = j4 + 1;
                aep.m18231a(bArr2, j4, (byte) ((charAt3 & 63) | 128));
                i3++;
            } else if ((charAt3 < 55296 || 57343 < charAt3) && j <= j2 - 3) {
                j4 = j + 1;
                aep.m18231a(bArr2, j, (byte) ((charAt3 >>> 12) | 480));
                j = j4 + 1;
                aep.m18231a(bArr2, j4, (byte) (((charAt3 >>> 6) & 63) | 128));
                j4 = j + 1;
                charAt3 = (charAt3 & 63) | 128;
            } else if (j <= j2 - 4) {
                int i5 = i3 + 1;
                if (i5 != length) {
                    char charAt4 = charSequence2.charAt(i5);
                    if (Character.isSurrogatePair(charAt3, charAt4)) {
                        i3 = Character.toCodePoint(charAt3, charAt4);
                        long j5 = j + 1;
                        aep.m18231a(bArr2, j, (byte) ((i3 >>> 18) | 240));
                        j = j5 + 1;
                        aep.m18231a(bArr2, j5, (byte) (((i3 >>> 12) & 63) | 128));
                        j5 = j + 1;
                        aep.m18231a(bArr2, j, (byte) (((i3 >>> 6) & 63) | 128));
                        j = j5 + 1;
                        aep.m18231a(bArr2, j5, (byte) ((i3 & 63) | 128));
                        i3 = i5;
                        i3++;
                    }
                } else {
                    i5 = i3;
                }
                throw new aeu(i5 - 1, length);
            } else {
                if (55296 <= charAt3 && charAt3 <= 57343) {
                    int i6 = i3 + 1;
                    if (i6 == length || !Character.isSurrogatePair(charAt3, charSequence2.charAt(i6))) {
                        throw new aeu(i3, length);
                    }
                }
                StringBuilder stringBuilder2 = new StringBuilder(46);
                stringBuilder2.append("Failed writing ");
                stringBuilder2.append(charAt3);
                stringBuilder2.append(" at index ");
                stringBuilder2.append(j);
                throw new ArrayIndexOutOfBoundsException(stringBuilder2.toString());
            }
            aep.m18231a(bArr2, j, (byte) charAt3);
            j = j4;
            i3++;
        }
        return (int) j;
    }
}
