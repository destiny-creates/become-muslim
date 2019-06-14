package com.google.android.gms.internal.p210i;

import java.nio.ByteBuffer;

/* renamed from: com.google.android.gms.internal.i.ip */
final class ip extends im {
    ip() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    final int mo4617a(int r18, byte[] r19, int r20, int r21) {
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
        r3 = com.google.android.gms.internal.p210i.ih.m20808a(r0, r11);
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
        r7 = com.google.android.gms.internal.p210i.ih.m20808a(r0, r7);
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
        r7 = com.google.android.gms.internal.p210i.ih.m20808a(r0, r7);
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
        r0 = com.google.android.gms.internal.p210i.ip.m31758a(r0, r2, r7, r1);
        return r0;
    L_0x0071:
        r1 = r1 + -2;
        r13 = r7 + r9;
        r7 = com.google.android.gms.internal.p210i.ih.m20808a(r0, r7);
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
        r2 = com.google.android.gms.internal.p210i.ih.m20808a(r0, r13);
        if (r2 <= r11) goto L_0x0031;
    L_0x0090:
        return r12;
    L_0x0091:
        if (r1 >= r5) goto L_0x0098;
    L_0x0093:
        r0 = com.google.android.gms.internal.p210i.ip.m31758a(r0, r2, r7, r1);
        return r0;
    L_0x0098:
        r1 = r1 + -3;
        r13 = r7 + r9;
        r3 = com.google.android.gms.internal.p210i.ih.m20808a(r0, r7);
        if (r3 > r11) goto L_0x00bb;
    L_0x00a2:
        r2 = r2 << 28;
        r3 = r3 + 112;
        r2 = r2 + r3;
        r2 = r2 >> 30;
        if (r2 != 0) goto L_0x00bb;
    L_0x00ab:
        r2 = r13 + r9;
        r7 = com.google.android.gms.internal.p210i.ih.m20808a(r0, r13);
        if (r7 > r11) goto L_0x00bb;
    L_0x00b3:
        r7 = r2 + r9;
        r2 = com.google.android.gms.internal.p210i.ih.m20808a(r0, r2);
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.ip.a(int, byte[], int, int):int");
    }

    /* renamed from: b */
    final String mo4620b(byte[] bArr, int i, int i2) {
        if (((i | i2) | ((bArr.length - i) - i2)) >= 0) {
            int i3;
            int i4 = i + i2;
            i2 = new char[i2];
            int i5 = 0;
            while (i < i4) {
                byte a = ih.m20808a(bArr, (long) i);
                if (!il.m20878d(a)) {
                    break;
                }
                i++;
                i3 = i5 + 1;
                il.m20875b(a, i2, i5);
                i5 = i3;
            }
            int i6 = i5;
            while (i < i4) {
                i5 = i + 1;
                byte a2 = ih.m20808a(bArr, (long) i);
                int i7;
                if (il.m20878d(a2)) {
                    i7 = i6 + 1;
                    il.m20875b(a2, i2, i6);
                    while (i5 < i4) {
                        i = ih.m20808a(bArr, (long) i5);
                        if (!il.m20878d(i)) {
                            break;
                        }
                        i5++;
                        i3 = i7 + 1;
                        il.m20875b(i, i2, i7);
                        i7 = i3;
                    }
                    i = i5;
                    i6 = i7;
                } else if (il.m20879e(a2)) {
                    if (i5 < i4) {
                        i7 = i5 + 1;
                        i3 = i6 + 1;
                        il.m20874b(a2, ih.m20808a(bArr, (long) i5), i2, i6);
                        i = i7;
                        i6 = i3;
                    } else {
                        throw fs.m20575h();
                    }
                } else if (il.m20880f(a2)) {
                    if (i5 < i4 - 1) {
                        i7 = i5 + 1;
                        i3 = i7 + 1;
                        int i8 = i6 + 1;
                        il.m20873b(a2, ih.m20808a(bArr, (long) i5), ih.m20808a(bArr, (long) i7), i2, i6);
                        i = i3;
                        i6 = i8;
                    } else {
                        throw fs.m20575h();
                    }
                } else if (i5 < i4 - 2) {
                    i7 = i5 + 1;
                    byte a3 = ih.m20808a(bArr, (long) i5);
                    i5 = i7 + 1;
                    int i9 = i5 + 1;
                    int i10 = i6 + 1;
                    il.m20872b(a2, a3, ih.m20808a(bArr, (long) i7), ih.m20808a(bArr, (long) i5), i2, i6);
                    i = i9;
                    i6 = i10 + 1;
                } else {
                    throw fs.m20575h();
                }
            }
            return new String(i2, 0, i6);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
    }

    /* renamed from: a */
    final int mo4618a(CharSequence charSequence, byte[] bArr, int i, int i2) {
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
            ih.m20822a(bArr2, j, (byte) charAt2);
            i3++;
            j = j3;
        }
        if (i3 == length) {
            return (int) j;
        }
        while (i3 < length) {
            long j4;
            charAt2 = charSequence2.charAt(i3);
            if (charAt2 < '' && j < j2) {
                j4 = j + 1;
                ih.m20822a(bArr2, j, (byte) charAt2);
            } else if (charAt2 < 'ࠀ' && j <= j2 - 2) {
                j4 = j + 1;
                ih.m20822a(bArr2, j, (byte) ((charAt2 >>> 6) | 960));
                j = j4 + 1;
                ih.m20822a(bArr2, j4, (byte) ((charAt2 & 63) | 128));
                i3++;
            } else if ((charAt2 < '?' || '?' < charAt2) && j <= j2 - 3) {
                j4 = j + 1;
                ih.m20822a(bArr2, j, (byte) ((charAt2 >>> 12) | 480));
                j = j4 + 1;
                ih.m20822a(bArr2, j4, (byte) (((charAt2 >>> 6) & 63) | 128));
                j4 = j + 1;
                ih.m20822a(bArr2, j, (byte) ((charAt2 & 63) | 128));
            } else if (j <= j2 - 4) {
                int i5 = i3 + 1;
                if (i5 != length) {
                    char charAt3 = charSequence2.charAt(i5);
                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                        i3 = Character.toCodePoint(charAt2, charAt3);
                        long j5 = j + 1;
                        ih.m20822a(bArr2, j, (byte) ((i3 >>> 18) | 240));
                        j = j5 + 1;
                        ih.m20822a(bArr2, j5, (byte) (((i3 >>> 12) & 63) | 128));
                        j5 = j + 1;
                        ih.m20822a(bArr2, j, (byte) (((i3 >>> 6) & 63) | 128));
                        j = j5 + 1;
                        ih.m20822a(bArr2, j5, (byte) ((i3 & 63) | 128));
                        i3 = i5;
                        i3++;
                    }
                } else {
                    i5 = i3;
                }
                throw new io(i5 - 1, length);
            } else {
                if ('?' <= charAt2 && charAt2 <= '?') {
                    int i6 = i3 + 1;
                    if (i6 == length || !Character.isSurrogatePair(charAt2, charSequence2.charAt(i6))) {
                        throw new io(i3, length);
                    }
                }
                StringBuilder stringBuilder2 = new StringBuilder(46);
                stringBuilder2.append("Failed writing ");
                stringBuilder2.append(charAt2);
                stringBuilder2.append(" at index ");
                stringBuilder2.append(j);
                throw new ArrayIndexOutOfBoundsException(stringBuilder2.toString());
            }
            j = j4;
            i3++;
        }
        return (int) j;
    }

    /* renamed from: a */
    final void mo4619a(CharSequence charSequence, ByteBuffer byteBuffer) {
        CharSequence charSequence2 = charSequence;
        ByteBuffer byteBuffer2 = byteBuffer;
        long a = ih.m20811a(byteBuffer);
        long position = ((long) byteBuffer.position()) + a;
        long limit = ((long) byteBuffer.limit()) + a;
        int length = charSequence.length();
        int i;
        if (((long) length) <= limit - position) {
            char c;
            long j;
            char charAt;
            int i2 = 0;
            while (true) {
                c = '';
                j = 1;
                if (i2 >= length) {
                    break;
                }
                charAt = charSequence2.charAt(i2);
                if (charAt >= '') {
                    break;
                }
                long j2 = position + 1;
                ih.m20814a(position, (byte) charAt);
                i2++;
                position = j2;
            }
            if (i2 == length) {
                byteBuffer2.position((int) (position - a));
                return;
            }
            while (i2 < length) {
                long j3;
                charAt = charSequence2.charAt(i2);
                if (charAt < c && position < limit) {
                    j3 = position + j;
                    ih.m20814a(position, (byte) charAt);
                } else if (charAt < 'ࠀ' && position <= limit - 2) {
                    j3 = position + j;
                    ih.m20814a(position, (byte) ((charAt >>> 6) | 960));
                    position = j3 + j;
                    ih.m20814a(j3, (byte) ((charAt & 63) | 128));
                    j3 = position;
                } else if ((charAt < '?' || '?' < charAt) && position <= limit - 3) {
                    j3 = position + j;
                    ih.m20814a(position, (byte) ((charAt >>> 12) | 480));
                    position = j3 + j;
                    ih.m20814a(j3, (byte) (((charAt >>> 6) & 63) | 128));
                    long j4 = position + 1;
                    ih.m20814a(position, (byte) ((charAt & 63) | 128));
                    j3 = j4;
                    position = 1;
                    i2++;
                    j = position;
                    position = j3;
                    c = '';
                } else if (position <= limit - 4) {
                    int i3 = i2 + 1;
                    if (i3 != length) {
                        char charAt2 = charSequence2.charAt(i3);
                        if (Character.isSurrogatePair(charAt, charAt2)) {
                            i2 = Character.toCodePoint(charAt, charAt2);
                            long j5 = position + 1;
                            ih.m20814a(position, (byte) ((i2 >>> 18) | 240));
                            position = j5 + 1;
                            ih.m20814a(j5, (byte) (((i2 >>> 12) & 63) | 128));
                            j3 = position + 1;
                            ih.m20814a(position, (byte) (((i2 >>> 6) & 63) | 128));
                            position = 1;
                            long j6 = j3 + 1;
                            ih.m20814a(j3, (byte) ((i2 & 63) | 128));
                            i2 = i3;
                            j3 = j6;
                            i2++;
                            j = position;
                            position = j3;
                            c = '';
                        } else {
                            i2 = i3;
                        }
                    }
                    throw new io(i2 - 1, length);
                } else {
                    if ('?' <= charAt && charAt <= '?') {
                        i = i2 + 1;
                        if (i == length || !Character.isSurrogatePair(charAt, charSequence2.charAt(i))) {
                            throw new io(i2, length);
                        }
                    }
                    StringBuilder stringBuilder = new StringBuilder(46);
                    stringBuilder.append("Failed writing ");
                    stringBuilder.append(charAt);
                    stringBuilder.append(" at index ");
                    stringBuilder.append(position);
                    throw new ArrayIndexOutOfBoundsException(stringBuilder.toString());
                }
                position = j;
                i2++;
                j = position;
                position = j3;
                c = '';
            }
            byteBuffer2.position((int) (position - a));
            return;
        }
        char charAt3 = charSequence2.charAt(length - 1);
        i = byteBuffer.limit();
        StringBuilder stringBuilder2 = new StringBuilder(37);
        stringBuilder2.append("Failed writing ");
        stringBuilder2.append(charAt3);
        stringBuilder2.append(" at index ");
        stringBuilder2.append(i);
        throw new ArrayIndexOutOfBoundsException(stringBuilder2.toString());
    }

    /* renamed from: a */
    private static int m31758a(byte[] bArr, int i, long j, int i2) {
        switch (i2) {
            case 0:
                return ij.m20861b(i);
            case 1:
                return ij.m20862b(i, ih.m20808a(bArr, j));
            case 2:
                return ij.m20863b(i, ih.m20808a(bArr, j), ih.m20808a(bArr, j + 1));
            default:
                throw new AssertionError();
        }
    }
}
