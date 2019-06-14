package com.google.android.gms.internal.p210i;

import java.nio.ByteBuffer;

/* renamed from: com.google.android.gms.internal.i.in */
final class in extends im {
    in() {
    }

    /* renamed from: a */
    final int mo4617a(int i, byte[] bArr, int i2, int i3) {
        while (i2 < i3 && bArr[i2] >= 0) {
            i2++;
        }
        if (i2 >= i3) {
            return 0;
        }
        while (i2 < i3) {
            int i4 = i2 + 1;
            i2 = bArr[i2];
            if (i2 < 0) {
                if (i2 < -32) {
                    if (i4 >= i3) {
                        return i2;
                    }
                    if (i2 >= -62) {
                        i2 = i4 + 1;
                        if (bArr[i4] > (byte) -65) {
                        }
                    }
                    return -1;
                } else if (i2 < -16) {
                    if (i4 >= i3 - 1) {
                        return ij.m20866d(bArr, i4, i3);
                    }
                    int i5 = i4 + 1;
                    r0 = bArr[i4];
                    if (r0 <= (byte) -65 && ((i2 != -32 || r0 >= (byte) -96) && (i2 != -19 || r0 < (byte) -96))) {
                        i2 = i5 + 1;
                        if (bArr[i5] > (byte) -65) {
                        }
                    }
                    return -1;
                } else if (i4 >= i3 - 2) {
                    return ij.m20866d(bArr, i4, i3);
                } else {
                    int i6 = i4 + 1;
                    r0 = bArr[i4];
                    if (r0 <= (byte) -65 && (((i2 << 28) + (r0 + 112)) >> 30) == 0) {
                        i2 = i6 + 1;
                        if (bArr[i6] <= (byte) -65) {
                            i4 = i2 + 1;
                            if (bArr[i2] > -65) {
                            }
                        }
                    }
                    return -1;
                }
            }
            i2 = i4;
        }
        return 0;
    }

    /* renamed from: b */
    final String mo4620b(byte[] bArr, int i, int i2) {
        if (((i | i2) | ((bArr.length - i) - i2)) >= 0) {
            int i3;
            int i4 = i + i2;
            i2 = new char[i2];
            int i5 = 0;
            while (i < i4) {
                byte b = bArr[i];
                if (!il.m20878d(b)) {
                    break;
                }
                i++;
                i3 = i5 + 1;
                il.m20875b(b, i2, i5);
                i5 = i3;
            }
            int i6 = i5;
            while (i < i4) {
                i5 = i + 1;
                byte b2 = bArr[i];
                int i7;
                if (il.m20878d(b2)) {
                    i7 = i6 + 1;
                    il.m20875b(b2, i2, i6);
                    while (i5 < i4) {
                        i = bArr[i5];
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
                } else if (il.m20879e(b2)) {
                    if (i5 < i4) {
                        i7 = i5 + 1;
                        i3 = i6 + 1;
                        il.m20874b(b2, bArr[i5], i2, i6);
                        i = i7;
                        i6 = i3;
                    } else {
                        throw fs.m20575h();
                    }
                } else if (il.m20880f(b2)) {
                    if (i5 < i4 - 1) {
                        i7 = i5 + 1;
                        i3 = i7 + 1;
                        int i8 = i6 + 1;
                        il.m20873b(b2, bArr[i5], bArr[i7], i2, i6);
                        i = i3;
                        i6 = i8;
                    } else {
                        throw fs.m20575h();
                    }
                } else if (i5 < i4 - 2) {
                    i7 = i5 + 1;
                    byte b3 = bArr[i5];
                    i5 = i7 + 1;
                    int i9 = i5 + 1;
                    int i10 = i6 + 1;
                    il.m20872b(b2, b3, bArr[i7], bArr[i5], i2, i6);
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
        int length = charSequence.length();
        i2 += i;
        int i3 = 0;
        while (i3 < length) {
            int i4 = i3 + i;
            if (i4 >= i2) {
                break;
            }
            char charAt = charSequence.charAt(i3);
            if (charAt >= '') {
                break;
            }
            bArr[i4] = (byte) charAt;
            i3++;
        }
        if (i3 == length) {
            return i + length;
        }
        i += i3;
        while (i3 < length) {
            int i5;
            char charAt2 = charSequence.charAt(i3);
            if (charAt2 < '' && i < i2) {
                i5 = i + 1;
                bArr[i] = (byte) charAt2;
            } else if (charAt2 < 'ࠀ' && i <= i2 - 2) {
                i5 = i + 1;
                bArr[i] = (byte) ((charAt2 >>> 6) | 960);
                i = i5 + 1;
                bArr[i5] = (byte) ((charAt2 & 63) | 128);
                i3++;
            } else if ((charAt2 < '?' || '?' < charAt2) && i <= i2 - 3) {
                i5 = i + 1;
                bArr[i] = (byte) ((charAt2 >>> 12) | 480);
                i = i5 + 1;
                bArr[i5] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i5 = i + 1;
                bArr[i] = (byte) ((charAt2 & 63) | 128);
            } else if (i <= i2 - 4) {
                i5 = i3 + 1;
                if (i5 != charSequence.length()) {
                    char charAt3 = charSequence.charAt(i5);
                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                        i3 = Character.toCodePoint(charAt2, charAt3);
                        i4 = i + 1;
                        bArr[i] = (byte) ((i3 >>> 18) | 240);
                        i = i4 + 1;
                        bArr[i4] = (byte) (((i3 >>> 12) & 63) | 128);
                        i4 = i + 1;
                        bArr[i] = (byte) (((i3 >>> 6) & 63) | 128);
                        i = i4 + 1;
                        bArr[i4] = (byte) ((i3 & 63) | 128);
                        i3 = i5;
                        i3++;
                    } else {
                        i3 = i5;
                    }
                }
                throw new io(i3 - 1, length);
            } else {
                if ('?' <= charAt2 && charAt2 <= '?') {
                    bArr = i3 + 1;
                    if (bArr == charSequence.length() || Character.isSurrogatePair(charAt2, charSequence.charAt(bArr)) == null) {
                        throw new io(i3, length);
                    }
                }
                i2 = new StringBuilder(37);
                i2.append("Failed writing ");
                i2.append(charAt2);
                i2.append(" at index ");
                i2.append(i);
                throw new ArrayIndexOutOfBoundsException(i2.toString());
            }
            i = i5;
            i3++;
        }
        return i;
    }

    /* renamed from: a */
    final void mo4619a(CharSequence charSequence, ByteBuffer byteBuffer) {
        im.m20882b(charSequence, byteBuffer);
    }
}
