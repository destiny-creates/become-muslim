package com.google.android.gms.internal.ads;

import com.facebook.imageutils.JfifUtil;
import java.util.Arrays;

final class zj {
    /* renamed from: a */
    private static long m20192a(byte[] bArr, int i) {
        return ((long) (((bArr[i + 3] & JfifUtil.MARKER_FIRST_BYTE) << 24) | (((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) | ((bArr[i + 1] & JfifUtil.MARKER_FIRST_BYTE) << 8)) | ((bArr[i + 2] & JfifUtil.MARKER_FIRST_BYTE) << 16)))) & 4294967295L;
    }

    /* renamed from: a */
    private static long m20193a(byte[] bArr, int i, int i2) {
        return (m20192a(bArr, i) >> i2) & 67108863;
    }

    /* renamed from: a */
    private static void m20194a(byte[] bArr, long j, int i) {
        int i2 = 0;
        while (i2 < 4) {
            bArr[i + i2] = (byte) ((int) (255 & j));
            i2++;
            j >>= 8;
        }
    }

    /* renamed from: a */
    static byte[] m20195a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = bArr;
        Object obj = bArr2;
        if (bArr3.length == 32) {
            long j;
            long a = m20193a(bArr3, 0, 0) & 67108863;
            int i = 2;
            int i2 = 3;
            long a2 = m20193a(bArr3, 3, 2) & 67108611;
            long a3 = m20193a(bArr3, 6, 4) & 67092735;
            long a4 = m20193a(bArr3, 9, 6) & 66076671;
            long a5 = m20193a(bArr3, 12, 8) & 1048575;
            long j2 = a2 * 5;
            long j3 = a3 * 5;
            long j4 = a4 * 5;
            long j5 = a5 * 5;
            byte[] bArr4 = new byte[17];
            long j6 = 0;
            long j7 = 0;
            long j8 = j7;
            long j9 = j8;
            long j10 = j9;
            int i3 = 0;
            while (i3 < obj.length) {
                int min = Math.min(16, obj.length - i3);
                System.arraycopy(obj, i3, bArr4, 0, min);
                bArr4[min] = (byte) 1;
                if (min != 16) {
                    Arrays.fill(bArr4, min + 1, 17, (byte) 0);
                }
                j10 += m20193a(bArr4, 0, 0);
                j6 += m20193a(bArr4, i2, i);
                j7 += m20193a(bArr4, 6, 4);
                j8 += m20193a(bArr4, 9, 6);
                j9 += m20193a(bArr4, 12, 8) | ((long) (bArr4[16] << 24));
                j = ((((j10 * a) + (j6 * j5)) + (j7 * j4)) + (j8 * j3)) + (j9 * j2);
                long j11 = ((((j10 * a3) + (j6 * a2)) + (j7 * a)) + (j8 * j5)) + (j9 * j4);
                long j12 = (((((j10 * a2) + (j6 * a)) + (j7 * j5)) + (j8 * j4)) + (j9 * j3)) + (j >> 26);
                j11 += j12 >> 26;
                long j13 = (((((j10 * a4) + (j6 * a3)) + (j7 * a2)) + (j8 * a)) + (j9 * j5)) + (j11 >> 26);
                j10 = (((((j10 * a5) + (j6 * a4)) + (j7 * a3)) + (j8 * a2)) + (j9 * a)) + (j13 >> 26);
                j = (j & 67108863) + ((j10 >> 26) * 5);
                j6 = (j12 & 67108863) + (j >> 26);
                i3 += 16;
                j7 = j11 & 67108863;
                j8 = j13 & 67108863;
                j9 = j10 & 67108863;
                j10 = j & 67108863;
                i = 2;
                i2 = 3;
            }
            j7 += j6 >> 26;
            long j14 = j7 & 67108863;
            j8 += j7 >> 26;
            long j15 = j8 & 67108863;
            j9 += j8 >> 26;
            long j16 = j9 & 67108863;
            j10 += (j9 >> 26) * 5;
            a3 = j10 & 67108863;
            long j17 = (j6 & 67108863) + (j10 >> 26);
            long j18 = a3 + 5;
            a4 = j18 & 67108863;
            long j19 = (j18 >> 26) + j17;
            a5 = j14 + (j19 >> 26);
            j18 = a5 >> 26;
            a5 &= 67108863;
            j18 = j15 + j18;
            long j20 = j18 & 67108863;
            j2 = (j16 + (j18 >> 26)) - 67108864;
            long j21 = j19 & 67108863;
            long j22 = j2 >> 63;
            a3 &= j22;
            a = j17 & j22;
            long j23 = j14 & j22;
            j = j15 & j22;
            a2 = j16 & j22;
            long j24 = ~j22;
            a3 |= a4 & j24;
            j19 = a | (j21 & j24);
            j17 = j23 | (a5 & j24);
            j14 = j | (j20 & j24);
            j19 = ((j19 >> 6) | (j17 << 20)) & 4294967295L;
            j17 = ((j17 >> 12) | (j14 << 14)) & 4294967295L;
            j24 = ((((j2 & j24) | a2) << 8) | (j14 >> 18)) & 4294967295L;
            j15 = (((j19 << 26) | a3) & 4294967295L) + m20192a(bArr3, 16);
            j14 = j15 & 4294967295L;
            j19 = (j19 + m20192a(bArr3, 20)) + (j15 >> 32);
            j15 = j19 & 4294967295L;
            j17 = (j17 + m20192a(bArr3, 24)) + (j19 >> 32);
            j19 = j17 & 4294967295L;
            long a6 = ((j24 + m20192a(bArr3, 28)) + (j17 >> 32)) & 4294967295L;
            byte[] bArr5 = new byte[16];
            m20194a(bArr5, j14, 0);
            m20194a(bArr5, j15, 4);
            m20194a(bArr5, j19, 8);
            m20194a(bArr5, a6, 12);
            return bArr5;
        }
        throw new IllegalArgumentException("The key length in bytes must be 32.");
    }
}
