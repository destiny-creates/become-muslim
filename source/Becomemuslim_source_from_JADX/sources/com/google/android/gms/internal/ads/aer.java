package com.google.android.gms.internal.ads;

import com.facebook.internal.NativeProtocol;

final class aer {
    /* renamed from: a */
    private static final aes f14373a;

    static {
        Object obj = (aep.m18232a() && aep.m18238b()) ? 1 : null;
        f14373a = obj != null ? new aev() : new aet();
    }

    /* renamed from: a */
    static int m18265a(CharSequence charSequence) {
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
                                throw new aeu(i2, length2);
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
    static int m18266a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        return f14373a.mo3802a(charSequence, bArr, i, i2);
    }

    /* renamed from: a */
    public static boolean m18267a(byte[] bArr) {
        return f14373a.m18276a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public static boolean m18268a(byte[] bArr, int i, int i2) {
        return f14373a.m18276a(bArr, i, i2);
    }

    /* renamed from: b */
    private static int m18269b(int i) {
        return i > -12 ? -1 : i;
    }

    /* renamed from: b */
    private static int m18270b(int i, int i2) {
        if (i <= -12) {
            if (i2 <= -65) {
                return i ^ (i2 << 8);
            }
        }
        return -1;
    }

    /* renamed from: b */
    private static int m18271b(int i, int i2, int i3) {
        if (i <= -12 && i2 <= -65) {
            if (i3 <= -65) {
                return (i ^ (i2 << 8)) ^ (i3 << 16);
            }
        }
        return -1;
    }

    /* renamed from: c */
    private static int m18273c(byte[] bArr, int i, int i2) {
        int i3 = bArr[i - 1];
        switch (i2 - i) {
            case 0:
                return m18269b(i3);
            case 1:
                return m18270b(i3, bArr[i]);
            case 2:
                return m18271b(i3, bArr[i], bArr[i + 1]);
            default:
                throw new AssertionError();
        }
    }
}
