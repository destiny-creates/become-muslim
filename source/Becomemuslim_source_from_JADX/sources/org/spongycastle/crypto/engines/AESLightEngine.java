package org.spongycastle.crypto.engines;

import com.facebook.imageutils.JfifUtil;
import com.facebook.stetho.dumpapp.Framer;
import java.lang.reflect.Array;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;

public class AESLightEngine implements BlockCipher {
    /* renamed from: a */
    private static final byte[] f26545a = new byte[]{(byte) 99, (byte) 124, (byte) 119, (byte) 123, (byte) -14, (byte) 107, (byte) 111, (byte) -59, (byte) 48, (byte) 1, (byte) 103, (byte) 43, (byte) -2, (byte) -41, (byte) -85, (byte) 118, (byte) -54, (byte) -126, (byte) -55, (byte) 125, (byte) -6, (byte) 89, (byte) 71, (byte) -16, (byte) -83, (byte) -44, (byte) -94, (byte) -81, (byte) -100, (byte) -92, (byte) 114, (byte) -64, (byte) -73, (byte) -3, (byte) -109, (byte) 38, (byte) 54, (byte) 63, (byte) -9, (byte) -52, (byte) 52, (byte) -91, (byte) -27, (byte) -15, (byte) 113, (byte) -40, Framer.STDOUT_FRAME_PREFIX, (byte) 21, (byte) 4, (byte) -57, (byte) 35, (byte) -61, (byte) 24, (byte) -106, (byte) 5, (byte) -102, (byte) 7, (byte) 18, Byte.MIN_VALUE, (byte) -30, (byte) -21, (byte) 39, (byte) -78, (byte) 117, (byte) 9, (byte) -125, (byte) 44, (byte) 26, (byte) 27, (byte) 110, (byte) 90, (byte) -96, (byte) 82, (byte) 59, (byte) -42, (byte) -77, (byte) 41, (byte) -29, (byte) 47, (byte) -124, (byte) 83, (byte) -47, (byte) 0, (byte) -19, (byte) 32, (byte) -4, (byte) -79, (byte) 91, (byte) 106, (byte) -53, (byte) -66, (byte) 57, (byte) 74, (byte) 76, (byte) 88, (byte) -49, (byte) -48, (byte) -17, (byte) -86, (byte) -5, (byte) 67, (byte) 77, (byte) 51, (byte) -123, (byte) 69, (byte) -7, (byte) 2, Byte.MAX_VALUE, (byte) 80, (byte) 60, (byte) -97, (byte) -88, (byte) 81, (byte) -93, (byte) 64, (byte) -113, (byte) -110, (byte) -99, (byte) 56, (byte) -11, (byte) -68, (byte) -74, (byte) -38, Framer.ENTER_FRAME_PREFIX, (byte) 16, (byte) -1, (byte) -13, (byte) -46, (byte) -51, (byte) 12, (byte) 19, (byte) -20, Framer.STDIN_REQUEST_FRAME_PREFIX, (byte) -105, (byte) 68, (byte) 23, (byte) -60, (byte) -89, (byte) 126, (byte) 61, (byte) 100, (byte) 93, (byte) 25, (byte) 115, (byte) 96, (byte) -127, (byte) 79, (byte) -36, (byte) 34, (byte) 42, (byte) -112, (byte) -120, (byte) 70, (byte) -18, (byte) -72, (byte) 20, (byte) -34, (byte) 94, (byte) 11, (byte) -37, (byte) -32, Framer.STDERR_FRAME_PREFIX, (byte) 58, (byte) 10, (byte) 73, (byte) 6, (byte) 36, (byte) 92, (byte) -62, (byte) -45, (byte) -84, (byte) 98, (byte) -111, (byte) -107, (byte) -28, (byte) 121, (byte) -25, (byte) -56, (byte) 55, (byte) 109, (byte) -115, (byte) -43, (byte) 78, (byte) -87, (byte) 108, (byte) 86, (byte) -12, (byte) -22, (byte) 101, (byte) 122, (byte) -82, (byte) 8, (byte) -70, Framer.EXIT_FRAME_PREFIX, (byte) 37, (byte) 46, (byte) 28, (byte) -90, (byte) -76, (byte) -58, (byte) -24, (byte) -35, (byte) 116, (byte) 31, (byte) 75, (byte) -67, (byte) -117, (byte) -118, (byte) 112, (byte) 62, (byte) -75, (byte) 102, (byte) 72, (byte) 3, (byte) -10, (byte) 14, (byte) 97, (byte) 53, (byte) 87, (byte) -71, (byte) -122, (byte) -63, (byte) 29, (byte) -98, (byte) -31, (byte) -8, (byte) -104, (byte) 17, (byte) 105, (byte) -39, (byte) -114, (byte) -108, (byte) -101, (byte) 30, (byte) -121, (byte) -23, (byte) -50, (byte) 85, (byte) 40, (byte) -33, (byte) -116, (byte) -95, (byte) -119, (byte) 13, (byte) -65, (byte) -26, (byte) 66, (byte) 104, (byte) 65, (byte) -103, Framer.STDIN_FRAME_PREFIX, (byte) 15, (byte) -80, (byte) 84, (byte) -69, (byte) 22};
    /* renamed from: b */
    private static final byte[] f26546b = new byte[]{(byte) 82, (byte) 9, (byte) 106, (byte) -43, (byte) 48, (byte) 54, (byte) -91, (byte) 56, (byte) -65, (byte) 64, (byte) -93, (byte) -98, (byte) -127, (byte) -13, (byte) -41, (byte) -5, (byte) 124, (byte) -29, (byte) 57, (byte) -126, (byte) -101, (byte) 47, (byte) -1, (byte) -121, (byte) 52, (byte) -114, (byte) 67, (byte) 68, (byte) -60, (byte) -34, (byte) -23, (byte) -53, (byte) 84, (byte) 123, (byte) -108, Framer.STDERR_FRAME_PREFIX, (byte) -90, (byte) -62, (byte) 35, (byte) 61, (byte) -18, (byte) 76, (byte) -107, (byte) 11, (byte) 66, (byte) -6, (byte) -61, (byte) 78, (byte) 8, (byte) 46, (byte) -95, (byte) 102, (byte) 40, (byte) -39, (byte) 36, (byte) -78, (byte) 118, (byte) 91, (byte) -94, (byte) 73, (byte) 109, (byte) -117, (byte) -47, (byte) 37, (byte) 114, (byte) -8, (byte) -10, (byte) 100, (byte) -122, (byte) 104, (byte) -104, (byte) 22, (byte) -44, (byte) -92, (byte) 92, (byte) -52, (byte) 93, (byte) 101, (byte) -74, (byte) -110, (byte) 108, (byte) 112, (byte) 72, (byte) 80, (byte) -3, (byte) -19, (byte) -71, (byte) -38, (byte) 94, (byte) 21, (byte) 70, (byte) 87, (byte) -89, (byte) -115, (byte) -99, (byte) -124, (byte) -112, (byte) -40, (byte) -85, (byte) 0, (byte) -116, (byte) -68, (byte) -45, (byte) 10, (byte) -9, (byte) -28, (byte) 88, (byte) 5, (byte) -72, (byte) -77, (byte) 69, (byte) 6, (byte) -48, (byte) 44, (byte) 30, (byte) -113, (byte) -54, (byte) 63, (byte) 15, (byte) 2, (byte) -63, (byte) -81, (byte) -67, (byte) 3, (byte) 1, (byte) 19, (byte) -118, (byte) 107, (byte) 58, (byte) -111, (byte) 17, (byte) 65, (byte) 79, (byte) 103, (byte) -36, (byte) -22, (byte) -105, (byte) -14, (byte) -49, (byte) -50, (byte) -16, (byte) -76, (byte) -26, (byte) 115, (byte) -106, (byte) -84, (byte) 116, (byte) 34, (byte) -25, (byte) -83, (byte) 53, (byte) -123, (byte) -30, (byte) -7, (byte) 55, (byte) -24, (byte) 28, (byte) 117, (byte) -33, (byte) 110, (byte) 71, (byte) -15, (byte) 26, (byte) 113, (byte) 29, (byte) 41, (byte) -59, (byte) -119, (byte) 111, (byte) -73, (byte) 98, (byte) 14, (byte) -86, (byte) 24, (byte) -66, (byte) 27, (byte) -4, (byte) 86, (byte) 62, (byte) 75, (byte) -58, (byte) -46, (byte) 121, (byte) 32, (byte) -102, (byte) -37, (byte) -64, (byte) -2, Framer.EXIT_FRAME_PREFIX, (byte) -51, (byte) 90, (byte) -12, (byte) 31, (byte) -35, (byte) -88, (byte) 51, (byte) -120, (byte) 7, (byte) -57, Framer.STDOUT_FRAME_PREFIX, (byte) -79, (byte) 18, (byte) 16, (byte) 89, (byte) 39, Byte.MIN_VALUE, (byte) -20, Framer.STDIN_REQUEST_FRAME_PREFIX, (byte) 96, (byte) 81, Byte.MAX_VALUE, (byte) -87, (byte) 25, (byte) -75, (byte) 74, (byte) 13, Framer.STDIN_FRAME_PREFIX, (byte) -27, (byte) 122, (byte) -97, (byte) -109, (byte) -55, (byte) -100, (byte) -17, (byte) -96, (byte) -32, (byte) 59, (byte) 77, (byte) -82, (byte) 42, (byte) -11, (byte) -80, (byte) -56, (byte) -21, (byte) -69, (byte) 60, (byte) -125, (byte) 83, (byte) -103, (byte) 97, (byte) 23, (byte) 43, (byte) 4, (byte) 126, (byte) -70, (byte) 119, (byte) -42, (byte) 38, (byte) -31, (byte) 105, (byte) 20, (byte) 99, (byte) 85, Framer.ENTER_FRAME_PREFIX, (byte) 12, (byte) 125};
    /* renamed from: c */
    private static final int[] f26547c = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, JfifUtil.MARKER_SOI, 171, 77, 154, 47, 94, 188, 99, 198, 151, 53, 106, 212, 179, 125, 250, 239, 197, 145};
    /* renamed from: d */
    private int f26548d;
    /* renamed from: e */
    private int[][] f26549e = ((int[][]) null);
    /* renamed from: f */
    private int f26550f;
    /* renamed from: g */
    private int f26551g;
    /* renamed from: h */
    private int f26552h;
    /* renamed from: i */
    private int f26553i;
    /* renamed from: j */
    private boolean f26554j;

    /* renamed from: a */
    private static int m34836a(int i) {
        return (((i & -2139062144) >>> 7) * 27) ^ ((2139062143 & i) << 1);
    }

    /* renamed from: a */
    private static int m34837a(int i, int i2) {
        return (i << (-i2)) | (i >>> i2);
    }

    /* renamed from: b */
    private static int m34841b(int i) {
        i &= -1061109568;
        i ^= i >>> 1;
        return (i >>> 5) ^ (((1061109567 & i) << 2) ^ (i >>> 2));
    }

    /* renamed from: a */
    public String mo5741a() {
        return "AES";
    }

    /* renamed from: b */
    public int mo5743b() {
        return 16;
    }

    /* renamed from: c */
    public void mo5744c() {
    }

    /* renamed from: c */
    private static int m34844c(int i) {
        int a = m34837a(i, 8);
        i ^= a;
        return m34836a(i) ^ (a ^ m34837a(i, 16));
    }

    /* renamed from: d */
    private static int m34845d(int i) {
        int a = m34837a(i, 8) ^ i;
        i ^= m34836a(a);
        a ^= m34841b(i);
        return i ^ (a ^ m34837a(a, 16));
    }

    /* renamed from: e */
    private static int m34846e(int i) {
        return (f26545a[(i >> 24) & JfifUtil.MARKER_FIRST_BYTE] << 24) | (((f26545a[i & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) | ((f26545a[(i >> 8) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 8)) | ((f26545a[(i >> 16) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 16));
    }

    /* renamed from: a */
    private int[][] m34840a(byte[] bArr, boolean z) {
        int length = bArr.length / 4;
        if ((length == 4 || length == 6 || length == 8) && length * 4 == bArr.length) {
            this.f26548d = length + 6;
            int i = 1;
            int[][] iArr = (int[][]) Array.newInstance(int.class, new int[]{this.f26548d + 1, 4});
            int i2 = 0;
            int i3 = 0;
            while (i2 < bArr.length) {
                iArr[i3 >> 2][i3 & 3] = (((bArr[i2] & JfifUtil.MARKER_FIRST_BYTE) | ((bArr[i2 + 1] & JfifUtil.MARKER_FIRST_BYTE) << 8)) | ((bArr[i2 + 2] & JfifUtil.MARKER_FIRST_BYTE) << 16)) | (bArr[i2 + 3] << 24);
                i2 += 4;
                i3++;
            }
            bArr = (this.f26548d + 1) << 2;
            for (i2 = length; i2 < bArr; i2++) {
                i3 = i2 - 1;
                i3 = iArr[i3 >> 2][i3 & 3];
                int i4 = i2 % length;
                if (i4 == 0) {
                    i3 = m34846e(m34837a(i3, 8)) ^ f26547c[(i2 / length) - 1];
                } else if (length > 6 && i4 == 4) {
                    i3 = m34846e(i3);
                }
                int i5 = i2 - length;
                iArr[i2 >> 2][i2 & 3] = i3 ^ iArr[i5 >> 2][i5 & 3];
            }
            if (!z) {
                while (i < this.f26548d) {
                    for (bArr = null; bArr < 4; bArr++) {
                        iArr[i][bArr] = m34845d(iArr[i][bArr]);
                    }
                    i++;
                }
            }
            return iArr;
        }
        throw new IllegalArgumentException("Key length not 128/192/256 bits.");
    }

    /* renamed from: a */
    public void mo5742a(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.f26549e = m34840a(((KeyParameter) cipherParameters).m35685a(), z);
            this.f26554j = z;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("invalid parameter passed to AES init - ");
        stringBuilder.append(cipherParameters.getClass().getName());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public int mo5740a(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.f26549e == null) {
            throw new IllegalStateException("AES engine not initialised");
        } else if (i + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 16 <= bArr2.length) {
            if (this.f26554j) {
                m34838a(bArr, i);
                m34839a(this.f26549e);
                m34842b(bArr2, i2);
            } else {
                m34838a(bArr, i);
                m34843b(this.f26549e);
                m34842b(bArr2, i2);
            }
            return 16;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    /* renamed from: a */
    private void m34838a(byte[] bArr, int i) {
        int i2 = i + 1;
        this.f26550f = bArr[i] & JfifUtil.MARKER_FIRST_BYTE;
        int i3 = i2 + 1;
        this.f26550f |= (bArr[i2] & JfifUtil.MARKER_FIRST_BYTE) << 8;
        i2 = i3 + 1;
        this.f26550f |= (bArr[i3] & JfifUtil.MARKER_FIRST_BYTE) << 16;
        i3 = i2 + 1;
        this.f26550f |= bArr[i2] << 24;
        i = i3 + 1;
        this.f26551g = bArr[i3] & JfifUtil.MARKER_FIRST_BYTE;
        i3 = i + 1;
        this.f26551g = ((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) << 8) | this.f26551g;
        i2 = i3 + 1;
        this.f26551g |= (bArr[i3] & JfifUtil.MARKER_FIRST_BYTE) << 16;
        i3 = i2 + 1;
        this.f26551g |= bArr[i2] << 24;
        i = i3 + 1;
        this.f26552h = bArr[i3] & JfifUtil.MARKER_FIRST_BYTE;
        i3 = i + 1;
        this.f26552h = ((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) << 8) | this.f26552h;
        i2 = i3 + 1;
        this.f26552h |= (bArr[i3] & JfifUtil.MARKER_FIRST_BYTE) << 16;
        i3 = i2 + 1;
        this.f26552h |= bArr[i2] << 24;
        i = i3 + 1;
        this.f26553i = bArr[i3] & JfifUtil.MARKER_FIRST_BYTE;
        i3 = i + 1;
        this.f26553i = ((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) << 8) | this.f26553i;
        i2 = i3 + 1;
        this.f26553i |= (bArr[i3] & JfifUtil.MARKER_FIRST_BYTE) << 16;
        this.f26553i = (bArr[i2] << 24) | this.f26553i;
    }

    /* renamed from: b */
    private void m34842b(byte[] bArr, int i) {
        int i2 = i + 1;
        bArr[i] = (byte) this.f26550f;
        i = i2 + 1;
        bArr[i2] = (byte) (this.f26550f >> 8);
        i2 = i + 1;
        bArr[i] = (byte) (this.f26550f >> 16);
        i = i2 + 1;
        bArr[i2] = (byte) (this.f26550f >> 24);
        i2 = i + 1;
        bArr[i] = (byte) this.f26551g;
        i = i2 + 1;
        bArr[i2] = (byte) (this.f26551g >> 8);
        i2 = i + 1;
        bArr[i] = (byte) (this.f26551g >> 16);
        i = i2 + 1;
        bArr[i2] = (byte) (this.f26551g >> 24);
        i2 = i + 1;
        bArr[i] = (byte) this.f26552h;
        i = i2 + 1;
        bArr[i2] = (byte) (this.f26552h >> 8);
        i2 = i + 1;
        bArr[i] = (byte) (this.f26552h >> 16);
        i = i2 + 1;
        bArr[i2] = (byte) (this.f26552h >> 24);
        i2 = i + 1;
        bArr[i] = (byte) this.f26553i;
        i = i2 + 1;
        bArr[i2] = (byte) (this.f26553i >> 8);
        i2 = i + 1;
        bArr[i] = (byte) (this.f26553i >> 16);
        bArr[i2] = (byte) (this.f26553i >> 24);
    }

    /* renamed from: a */
    private void m34839a(int[][] iArr) {
        int c;
        int c2;
        int c3;
        int i = this.f26553i ^ iArr[0][3];
        int i2 = this.f26552h ^ iArr[0][2];
        int i3 = this.f26551g ^ iArr[0][1];
        int i4 = this.f26550f ^ iArr[0][0];
        int i5 = 1;
        while (i5 < this.f26548d - 1) {
            c = m34844c((((f26545a[i4 & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) ^ ((f26545a[(i3 >> 8) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 8)) ^ ((f26545a[(i2 >> 16) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 16)) ^ (f26545a[(i >> 24) & JfifUtil.MARKER_FIRST_BYTE] << 24)) ^ iArr[i5][0];
            c2 = m34844c((((f26545a[i3 & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) ^ ((f26545a[(i2 >> 8) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 8)) ^ ((f26545a[(i >> 16) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 16)) ^ (f26545a[(i4 >> 24) & JfifUtil.MARKER_FIRST_BYTE] << 24)) ^ iArr[i5][1];
            c3 = m34844c((((f26545a[i2 & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) ^ ((f26545a[(i >> 8) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 8)) ^ ((f26545a[(i4 >> 16) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 16)) ^ (f26545a[(i3 >> 24) & JfifUtil.MARKER_FIRST_BYTE] << 24)) ^ iArr[i5][2];
            i4 = m34844c(((((f26545a[(i4 >> 8) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 8) ^ (f26545a[i & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE)) ^ ((f26545a[(i3 >> 16) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 16)) ^ (f26545a[(i2 >> 24) & JfifUtil.MARKER_FIRST_BYTE] << 24));
            i3 = i5 + 1;
            i5 = iArr[i5][3] ^ i4;
            i4 = m34844c((((f26545a[c & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) ^ ((f26545a[(c2 >> 8) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 8)) ^ ((f26545a[(c3 >> 16) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 16)) ^ (f26545a[(i5 >> 24) & JfifUtil.MARKER_FIRST_BYTE] << 24)) ^ iArr[i3][0];
            i2 = m34844c((((f26545a[c2 & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) ^ ((f26545a[(c3 >> 8) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 8)) ^ ((f26545a[(i5 >> 16) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 16)) ^ (f26545a[(c >> 24) & JfifUtil.MARKER_FIRST_BYTE] << 24)) ^ iArr[i3][1];
            i = m34844c((((f26545a[c3 & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) ^ ((f26545a[(i5 >> 8) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 8)) ^ ((f26545a[(c >> 16) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 16)) ^ (f26545a[(c2 >> 24) & JfifUtil.MARKER_FIRST_BYTE] << 24)) ^ iArr[i3][2];
            c = i3 + 1;
            i5 = m34844c((((f26545a[i5 & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) ^ ((f26545a[(c >> 8) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 8)) ^ ((f26545a[(c2 >> 16) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 16)) ^ (f26545a[(c3 >> 24) & JfifUtil.MARKER_FIRST_BYTE] << 24)) ^ iArr[i3][3];
            i3 = i2;
            i2 = i;
            i = i5;
            i5 = c;
        }
        c = m34844c((((f26545a[i4 & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) ^ ((f26545a[(i3 >> 8) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 8)) ^ ((f26545a[(i2 >> 16) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 16)) ^ (f26545a[(i >> 24) & JfifUtil.MARKER_FIRST_BYTE] << 24)) ^ iArr[i5][0];
        c2 = m34844c((((f26545a[i3 & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) ^ ((f26545a[(i2 >> 8) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 8)) ^ ((f26545a[(i >> 16) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 16)) ^ (f26545a[(i4 >> 24) & JfifUtil.MARKER_FIRST_BYTE] << 24)) ^ iArr[i5][1];
        c3 = m34844c((((f26545a[i2 & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) ^ ((f26545a[(i >> 8) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 8)) ^ ((f26545a[(i4 >> 16) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 16)) ^ (f26545a[(i3 >> 24) & JfifUtil.MARKER_FIRST_BYTE] << 24)) ^ iArr[i5][2];
        i4 = m34844c(((((f26545a[(i4 >> 8) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 8) ^ (f26545a[i & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE)) ^ ((f26545a[(i3 >> 16) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 16)) ^ (f26545a[(i2 >> 24) & JfifUtil.MARKER_FIRST_BYTE] << 24));
        i3 = i5 + 1;
        i5 = iArr[i5][3] ^ i4;
        this.f26550f = iArr[i3][0] ^ ((((f26545a[c & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) ^ ((f26545a[(c2 >> 8) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 8)) ^ ((f26545a[(c3 >> 16) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 16)) ^ (f26545a[(i5 >> 24) & JfifUtil.MARKER_FIRST_BYTE] << 24));
        this.f26551g = ((((f26545a[c2 & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) ^ ((f26545a[(c3 >> 8) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 8)) ^ ((f26545a[(i5 >> 16) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 16)) ^ (f26545a[(c >> 24) & JfifUtil.MARKER_FIRST_BYTE] << 24)) ^ iArr[i3][1];
        this.f26552h = ((((f26545a[c3 & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) ^ ((f26545a[(i5 >> 8) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 8)) ^ ((f26545a[(c >> 16) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 16)) ^ (f26545a[(c2 >> 24) & JfifUtil.MARKER_FIRST_BYTE] << 24)) ^ iArr[i3][2];
        this.f26553i = iArr[i3][3] ^ ((((f26545a[i5 & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) ^ ((f26545a[(c >> 8) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 8)) ^ ((f26545a[(c2 >> 16) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 16)) ^ (f26545a[(c3 >> 24) & JfifUtil.MARKER_FIRST_BYTE] << 24));
    }

    /* renamed from: b */
    private void m34843b(int[][] iArr) {
        int d;
        int d2;
        int d3;
        int i = this.f26550f ^ iArr[this.f26548d][0];
        int i2 = this.f26551g ^ iArr[this.f26548d][1];
        int i3 = this.f26552h ^ iArr[this.f26548d][2];
        int i4 = this.f26548d - 1;
        int i5 = this.f26553i ^ iArr[this.f26548d][3];
        while (i4 > 1) {
            d = m34845d((((f26546b[i & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) ^ ((f26546b[(i5 >> 8) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 8)) ^ ((f26546b[(i3 >> 16) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 16)) ^ (f26546b[(i2 >> 24) & JfifUtil.MARKER_FIRST_BYTE] << 24)) ^ iArr[i4][0];
            d2 = m34845d((((f26546b[i2 & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) ^ ((f26546b[(i >> 8) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 8)) ^ ((f26546b[(i5 >> 16) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 16)) ^ (f26546b[(i3 >> 24) & JfifUtil.MARKER_FIRST_BYTE] << 24)) ^ iArr[i4][1];
            d3 = m34845d((((f26546b[i3 & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) ^ ((f26546b[(i2 >> 8) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 8)) ^ ((f26546b[(i >> 16) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 16)) ^ (f26546b[(i5 >> 24) & JfifUtil.MARKER_FIRST_BYTE] << 24)) ^ iArr[i4][2];
            i2 = ((f26546b[(i2 >> 16) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 16) ^ (((f26546b[(i3 >> 8) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 8) ^ (f26546b[i5 & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE));
            i2 = i4 - 1;
            i = m34845d((f26546b[(i >> 24) & JfifUtil.MARKER_FIRST_BYTE] << 24) ^ i2) ^ iArr[i4][3];
            i3 = m34845d((((f26546b[d & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) ^ ((f26546b[(i >> 8) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 8)) ^ ((f26546b[(d3 >> 16) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 16)) ^ (f26546b[(d2 >> 24) & JfifUtil.MARKER_FIRST_BYTE] << 24)) ^ iArr[i2][0];
            i4 = m34845d((((f26546b[d2 & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) ^ ((f26546b[(d >> 8) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 8)) ^ ((f26546b[(i >> 16) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 16)) ^ (f26546b[(d3 >> 24) & JfifUtil.MARKER_FIRST_BYTE] << 24)) ^ iArr[i2][1];
            i5 = m34845d((((f26546b[d3 & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) ^ ((f26546b[(d2 >> 8) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 8)) ^ ((f26546b[(d >> 16) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 16)) ^ (f26546b[(i >> 24) & JfifUtil.MARKER_FIRST_BYTE] << 24)) ^ iArr[i2][2];
            d = i2 - 1;
            i = m34845d((((f26546b[i & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) ^ ((f26546b[(d3 >> 8) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 8)) ^ ((f26546b[(d2 >> 16) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 16)) ^ (f26546b[(d >> 24) & JfifUtil.MARKER_FIRST_BYTE] << 24)) ^ iArr[i2][3];
            i2 = i4;
            i4 = d;
            int i6 = i5;
            i5 = i;
            i = i3;
            i3 = i6;
        }
        d = m34845d((((f26546b[i & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) ^ ((f26546b[(i5 >> 8) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 8)) ^ ((f26546b[(i3 >> 16) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 16)) ^ (f26546b[(i2 >> 24) & JfifUtil.MARKER_FIRST_BYTE] << 24)) ^ iArr[i4][0];
        d2 = m34845d((((f26546b[i2 & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) ^ ((f26546b[(i >> 8) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 8)) ^ ((f26546b[(i5 >> 16) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 16)) ^ (f26546b[(i3 >> 24) & JfifUtil.MARKER_FIRST_BYTE] << 24)) ^ iArr[i4][1];
        d3 = m34845d((((f26546b[i3 & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) ^ ((f26546b[(i2 >> 8) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 8)) ^ ((f26546b[(i >> 16) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 16)) ^ (f26546b[(i5 >> 24) & JfifUtil.MARKER_FIRST_BYTE] << 24)) ^ iArr[i4][2];
        i = m34845d((f26546b[(i >> 24) & JfifUtil.MARKER_FIRST_BYTE] << 24) ^ (((f26546b[(i2 >> 16) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 16) ^ (((f26546b[(i3 >> 8) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 8) ^ (f26546b[i5 & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE)))) ^ iArr[i4][3];
        r0.f26550f = ((((f26546b[d & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) ^ ((f26546b[(i >> 8) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 8)) ^ ((f26546b[(d3 >> 16) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 16)) ^ (f26546b[(d2 >> 24) & JfifUtil.MARKER_FIRST_BYTE] << 24)) ^ iArr[0][0];
        r0.f26551g = ((((f26546b[d2 & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) ^ ((f26546b[(d >> 8) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 8)) ^ ((f26546b[(i >> 16) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 16)) ^ (f26546b[(d3 >> 24) & JfifUtil.MARKER_FIRST_BYTE] << 24)) ^ iArr[0][1];
        r0.f26552h = ((((f26546b[d3 & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) ^ ((f26546b[(d2 >> 8) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 8)) ^ ((f26546b[(d >> 16) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 16)) ^ (f26546b[(i >> 24) & JfifUtil.MARKER_FIRST_BYTE] << 24)) ^ iArr[0][2];
        r0.f26553i = iArr[0][3] ^ ((((f26546b[i & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) ^ ((f26546b[(d3 >> 8) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 8)) ^ ((f26546b[(d2 >> 16) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 16)) ^ (f26546b[(d >> 24) & JfifUtil.MARKER_FIRST_BYTE] << 24));
    }
}
