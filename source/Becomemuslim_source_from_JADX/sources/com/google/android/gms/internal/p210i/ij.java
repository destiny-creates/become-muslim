package com.google.android.gms.internal.p210i;

import com.facebook.internal.NativeProtocol;
import java.nio.ByteBuffer;

/* renamed from: com.google.android.gms.internal.i.ij */
final class ij {
    /* renamed from: a */
    private static final im f16726a;

    /* renamed from: a */
    public static boolean m20859a(byte[] bArr) {
        return f16726a.m20886a(bArr, 0, bArr.length);
    }

    /* renamed from: b */
    private static int m20861b(int i) {
        return i > -12 ? -1 : i;
    }

    /* renamed from: b */
    private static int m20862b(int i, int i2) {
        if (i <= -12) {
            if (i2 <= -65) {
                return i ^ (i2 << 8);
            }
        }
        return -1;
    }

    /* renamed from: b */
    private static int m20863b(int i, int i2, int i3) {
        if (i <= -12 && i2 <= -65) {
            if (i3 <= -65) {
                return (i ^ (i2 << 8)) ^ (i3 << 16);
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static boolean m20860a(byte[] bArr, int i, int i2) {
        return f16726a.m20886a(bArr, i, i2);
    }

    /* renamed from: d */
    private static int m20866d(byte[] bArr, int i, int i2) {
        int i3 = bArr[i - 1];
        switch (i2 - i) {
            case 0:
                return ij.m20861b(i3);
            case 1:
                return ij.m20862b(i3, bArr[i]);
            case 2:
                return ij.m20863b(i3, bArr[i], bArr[i + 1]);
            default:
                throw new AssertionError();
        }
    }

    /* renamed from: a */
    static int m20856a(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < '') {
            i2++;
        }
        int i3 = length;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            if (charAt < 'ࠀ') {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 'ࠀ') {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if ('?' <= charAt2 && charAt2 <= '?') {
                            if (Character.codePointAt(charSequence, i2) >= NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) {
                                i2++;
                            } else {
                                throw new io(i2, length2);
                            }
                        }
                    }
                    i2++;
                }
                i3 += i;
                if (i3 >= length) {
                    return i3;
                }
                long j = ((long) i3) + 4294967296L;
                StringBuilder stringBuilder = new StringBuilder(54);
                stringBuilder.append("UTF-8 length does not fit in int: ");
                stringBuilder.append(j);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        if (i3 >= length) {
            return i3;
        }
        long j2 = ((long) i3) + 4294967296L;
        StringBuilder stringBuilder2 = new StringBuilder(54);
        stringBuilder2.append("UTF-8 length does not fit in int: ");
        stringBuilder2.append(j2);
        throw new IllegalArgumentException(stringBuilder2.toString());
    }

    /* renamed from: a */
    static int m20857a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        return f16726a.mo4618a(charSequence, bArr, i, i2);
    }

    /* renamed from: b */
    static String m20864b(byte[] bArr, int i, int i2) {
        return f16726a.mo4620b(bArr, i, i2);
    }

    /* renamed from: a */
    static void m20858a(CharSequence charSequence, ByteBuffer byteBuffer) {
        im imVar = f16726a;
        if (byteBuffer.hasArray()) {
            int arrayOffset = byteBuffer.arrayOffset();
            byteBuffer.position(ij.m20857a(charSequence, byteBuffer.array(), byteBuffer.position() + arrayOffset, byteBuffer.remaining()) - arrayOffset);
        } else if (byteBuffer.isDirect()) {
            imVar.mo4619a(charSequence, byteBuffer);
        } else {
            im.m20882b(charSequence, byteBuffer);
        }
    }

    static {
        im inVar;
        Object obj = (ih.m20824a() && ih.m20829b()) ? 1 : null;
        if (obj == null || dv.m20447a()) {
            inVar = new in();
        } else {
            inVar = new ip();
        }
        f16726a = inVar;
    }
}
