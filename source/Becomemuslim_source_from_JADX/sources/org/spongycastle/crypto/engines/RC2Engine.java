package org.spongycastle.crypto.engines;

import com.facebook.imageutils.JfifUtil;
import com.facebook.soloader.MinElf;
import com.facebook.stetho.dumpapp.Framer;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.RC2Parameters;

public class RC2Engine implements BlockCipher {
    /* renamed from: a */
    private static byte[] f26699a = new byte[]{(byte) -39, Framer.EXIT_FRAME_PREFIX, (byte) -7, (byte) -60, (byte) 25, (byte) -35, (byte) -75, (byte) -19, (byte) 40, (byte) -23, (byte) -3, (byte) 121, (byte) 74, (byte) -96, (byte) -40, (byte) -99, (byte) -58, (byte) 126, (byte) 55, (byte) -125, (byte) 43, (byte) 118, (byte) 83, (byte) -114, (byte) 98, (byte) 76, (byte) 100, (byte) -120, (byte) 68, (byte) -117, (byte) -5, (byte) -94, (byte) 23, (byte) -102, (byte) 89, (byte) -11, (byte) -121, (byte) -77, (byte) 79, (byte) 19, (byte) 97, (byte) 69, (byte) 109, (byte) -115, (byte) 9, (byte) -127, (byte) 125, Framer.STDERR_FRAME_PREFIX, (byte) -67, (byte) -113, (byte) 64, (byte) -21, (byte) -122, (byte) -73, (byte) 123, (byte) 11, (byte) -16, (byte) -107, Framer.ENTER_FRAME_PREFIX, (byte) 34, (byte) 92, (byte) 107, (byte) 78, (byte) -126, (byte) 84, (byte) -42, (byte) 101, (byte) -109, (byte) -50, (byte) 96, (byte) -78, (byte) 28, (byte) 115, (byte) 86, (byte) -64, (byte) 20, (byte) -89, (byte) -116, (byte) -15, (byte) -36, (byte) 18, (byte) 117, (byte) -54, (byte) 31, (byte) 59, (byte) -66, (byte) -28, (byte) -47, (byte) 66, (byte) 61, (byte) -44, (byte) 48, (byte) -93, (byte) 60, (byte) -74, (byte) 38, (byte) 111, (byte) -65, (byte) 14, (byte) -38, (byte) 70, (byte) 105, (byte) 7, (byte) 87, (byte) 39, (byte) -14, (byte) 29, (byte) -101, (byte) -68, (byte) -108, (byte) 67, (byte) 3, (byte) -8, (byte) 17, (byte) -57, (byte) -10, (byte) -112, (byte) -17, (byte) 62, (byte) -25, (byte) 6, (byte) -61, (byte) -43, (byte) 47, (byte) -56, (byte) 102, (byte) 30, (byte) -41, (byte) 8, (byte) -24, (byte) -22, (byte) -34, Byte.MIN_VALUE, (byte) 82, (byte) -18, (byte) -9, (byte) -124, (byte) -86, (byte) 114, (byte) -84, (byte) 53, (byte) 77, (byte) 106, (byte) 42, (byte) -106, (byte) 26, (byte) -46, (byte) 113, (byte) 90, (byte) 21, (byte) 73, (byte) 116, (byte) 75, (byte) -97, (byte) -48, (byte) 94, (byte) 4, (byte) 24, (byte) -92, (byte) -20, (byte) -62, (byte) -32, (byte) 65, (byte) 110, (byte) 15, (byte) 81, (byte) -53, (byte) -52, (byte) 36, (byte) -111, (byte) -81, (byte) 80, (byte) -95, (byte) -12, (byte) 112, (byte) 57, (byte) -103, (byte) 124, (byte) 58, (byte) -123, (byte) 35, (byte) -72, (byte) -76, (byte) 122, (byte) -4, (byte) 2, (byte) 54, (byte) 91, (byte) 37, (byte) 85, (byte) -105, Framer.STDOUT_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX, (byte) 93, (byte) -6, (byte) -104, (byte) -29, (byte) -118, (byte) -110, (byte) -82, (byte) 5, (byte) -33, (byte) 41, (byte) 16, (byte) 103, (byte) 108, (byte) -70, (byte) -55, (byte) -45, (byte) 0, (byte) -26, (byte) -49, (byte) -31, (byte) -98, (byte) -88, (byte) 44, (byte) 99, (byte) 22, (byte) 1, (byte) 63, (byte) 88, (byte) -30, (byte) -119, (byte) -87, (byte) 13, (byte) 56, (byte) 52, (byte) 27, (byte) -85, (byte) 51, (byte) -1, (byte) -80, (byte) -69, (byte) 72, (byte) 12, Framer.STDIN_REQUEST_FRAME_PREFIX, (byte) -71, (byte) -79, (byte) -51, (byte) 46, (byte) -59, (byte) -13, (byte) -37, (byte) 71, (byte) -27, (byte) -91, (byte) -100, (byte) 119, (byte) 10, (byte) -90, (byte) 32, (byte) 104, (byte) -2, Byte.MAX_VALUE, (byte) -63, (byte) -83};
    /* renamed from: b */
    private int[] f26700b;
    /* renamed from: c */
    private boolean f26701c;

    /* renamed from: a */
    private int m35054a(int i, int i2) {
        i &= MinElf.PN_XNUM;
        return (i >> (16 - i2)) | (i << i2);
    }

    /* renamed from: a */
    public String mo5741a() {
        return "RC2";
    }

    /* renamed from: b */
    public int mo5743b() {
        return 8;
    }

    /* renamed from: c */
    public void mo5744c() {
    }

    /* renamed from: a */
    private int[] m35055a(byte[] bArr, int i) {
        int i2;
        int[] iArr = new int[128];
        for (i2 = 0; i2 != bArr.length; i2++) {
            iArr[i2] = bArr[i2] & JfifUtil.MARKER_FIRST_BYTE;
        }
        bArr = bArr.length;
        if (bArr < 128) {
            i2 = iArr[bArr - 1];
            int i3 = bArr;
            bArr = null;
            while (true) {
                int i4 = bArr + 1;
                i2 = f26699a[(i2 + iArr[bArr]) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE;
                bArr = i3 + 1;
                iArr[i3] = i2;
                if (bArr >= 128) {
                    break;
                }
                i3 = bArr;
                bArr = i4;
            }
        }
        bArr = (i + 7) >> 3;
        int i5 = 128 - bArr;
        i = f26699a[(JfifUtil.MARKER_FIRST_BYTE >> ((-i) & 7)) & iArr[i5]] & JfifUtil.MARKER_FIRST_BYTE;
        iArr[i5] = i;
        for (i5--; i5 >= 0; i5--) {
            i = f26699a[i ^ iArr[i5 + bArr]] & JfifUtil.MARKER_FIRST_BYTE;
            iArr[i5] = i;
        }
        bArr = new int[64];
        for (int i6 = 0; i6 != bArr.length; i6++) {
            i = i6 * 2;
            bArr[i6] = iArr[i] + (iArr[i + 1] << 8);
        }
        return bArr;
    }

    /* renamed from: a */
    public void mo5742a(boolean z, CipherParameters cipherParameters) {
        this.f26701c = z;
        if (cipherParameters instanceof RC2Parameters) {
            RC2Parameters rC2Parameters = (RC2Parameters) cipherParameters;
            this.f26700b = m35055a(rC2Parameters.m35685a(), rC2Parameters.m40799b());
        } else if (cipherParameters instanceof KeyParameter) {
            byte[] a = ((KeyParameter) cipherParameters).m35685a();
            this.f26700b = m35055a(a, a.length * 8);
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("invalid parameter passed to RC2 init - ");
            stringBuilder.append(cipherParameters.getClass().getName());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    public final int mo5740a(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.f26700b == null) {
            throw new IllegalStateException("RC2 engine not initialised");
        } else if (i + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 8 <= bArr2.length) {
            if (this.f26701c) {
                m35056b(bArr, i, bArr2, i2);
            } else {
                m35057c(bArr, i, bArr2, i2);
            }
            return 8;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    /* renamed from: b */
    private void m35056b(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = ((bArr[i + 7] & JfifUtil.MARKER_FIRST_BYTE) << 8) + (bArr[i + 6] & JfifUtil.MARKER_FIRST_BYTE);
        int i4 = ((bArr[i + 5] & JfifUtil.MARKER_FIRST_BYTE) << 8) + (bArr[i + 4] & JfifUtil.MARKER_FIRST_BYTE);
        int i5 = ((bArr[i + 3] & JfifUtil.MARKER_FIRST_BYTE) << 8) + (bArr[i + 2] & JfifUtil.MARKER_FIRST_BYTE);
        int i6 = 0;
        int i7 = ((bArr[i + 1] & JfifUtil.MARKER_FIRST_BYTE) << 8) + (bArr[i + 0] & JfifUtil.MARKER_FIRST_BYTE);
        while (i6 <= 16) {
            i7 = m35054a(((i7 + ((~i3) & i5)) + (i4 & i3)) + this.f26700b[i6], 1);
            i5 = m35054a(((i5 + ((~i7) & i4)) + (i3 & i7)) + this.f26700b[i6 + 1], 2);
            i4 = m35054a(((i4 + ((~i5) & i3)) + (i7 & i5)) + this.f26700b[i6 + 2], 3);
            i3 = m35054a(((i3 + ((~i4) & i7)) + (i5 & i4)) + this.f26700b[i6 + 3], 5);
            i6 += 4;
        }
        i7 += this.f26700b[i3 & 63];
        i5 += this.f26700b[i7 & 63];
        i4 += this.f26700b[i5 & 63];
        i3 += this.f26700b[i4 & 63];
        for (bArr = 20; bArr <= 40; bArr += 4) {
            i7 = m35054a(((i7 + ((~i3) & i5)) + (i4 & i3)) + this.f26700b[bArr], 1);
            i5 = m35054a(((i5 + ((~i7) & i4)) + (i3 & i7)) + this.f26700b[bArr + 1], 2);
            i4 = m35054a(((i4 + ((~i5) & i3)) + (i7 & i5)) + this.f26700b[bArr + 2], 3);
            i3 = m35054a(((i3 + ((~i4) & i7)) + (i5 & i4)) + this.f26700b[bArr + 3], 5);
        }
        i7 += this.f26700b[i3 & 63];
        i5 += this.f26700b[i7 & 63];
        i4 += this.f26700b[i5 & 63];
        i3 += this.f26700b[i4 & 63];
        for (bArr = 44; bArr < 64; bArr += 4) {
            i7 = m35054a(((i7 + ((~i3) & i5)) + (i4 & i3)) + this.f26700b[bArr], 1);
            i5 = m35054a(((i5 + ((~i7) & i4)) + (i3 & i7)) + this.f26700b[bArr + 1], 2);
            i4 = m35054a(((i4 + ((~i5) & i3)) + (i7 & i5)) + this.f26700b[bArr + 2], 3);
            i3 = m35054a(((i3 + ((~i4) & i7)) + (i5 & i4)) + this.f26700b[bArr + 3], 5);
        }
        bArr2[i2 + 0] = (byte) i7;
        bArr2[i2 + 1] = (byte) (i7 >> 8);
        bArr2[i2 + 2] = (byte) i5;
        bArr2[i2 + 3] = (byte) (i5 >> 8);
        bArr2[i2 + 4] = (byte) i4;
        bArr2[i2 + 5] = (byte) (i4 >> 8);
        bArr2[i2 + 6] = (byte) i3;
        bArr2[i2 + 7] = (byte) (i3 >> 8);
    }

    /* renamed from: c */
    private void m35057c(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = ((bArr[i + 7] & JfifUtil.MARKER_FIRST_BYTE) << 8) + (bArr[i + 6] & JfifUtil.MARKER_FIRST_BYTE);
        int i4 = ((bArr[i + 5] & JfifUtil.MARKER_FIRST_BYTE) << 8) + (bArr[i + 4] & JfifUtil.MARKER_FIRST_BYTE);
        int i5 = ((bArr[i + 3] & JfifUtil.MARKER_FIRST_BYTE) << 8) + (bArr[i + 2] & JfifUtil.MARKER_FIRST_BYTE);
        int i6 = ((bArr[i + 1] & JfifUtil.MARKER_FIRST_BYTE) << 8) + (bArr[i + 0] & JfifUtil.MARKER_FIRST_BYTE);
        for (bArr = 60; bArr >= 44; bArr -= 4) {
            i3 = m35054a(i3, 11) - ((((~i4) & i6) + (i5 & i4)) + this.f26700b[bArr + 3]);
            i4 = m35054a(i4, 13) - ((((~i5) & i3) + (i6 & i5)) + this.f26700b[bArr + 2]);
            i5 = m35054a(i5, 14) - ((((~i6) & i4) + (i3 & i6)) + this.f26700b[bArr + 1]);
            i6 = m35054a(i6, 15) - ((((~i3) & i5) + (i4 & i3)) + this.f26700b[bArr]);
        }
        i3 -= this.f26700b[i4 & 63];
        i4 -= this.f26700b[i5 & 63];
        i5 -= this.f26700b[i6 & 63];
        i6 -= this.f26700b[i3 & 63];
        for (bArr = 40; bArr >= 20; bArr -= 4) {
            i3 = m35054a(i3, 11) - ((((~i4) & i6) + (i5 & i4)) + this.f26700b[bArr + 3]);
            i4 = m35054a(i4, 13) - ((((~i5) & i3) + (i6 & i5)) + this.f26700b[bArr + 2]);
            i5 = m35054a(i5, 14) - ((((~i6) & i4) + (i3 & i6)) + this.f26700b[bArr + 1]);
            i6 = m35054a(i6, 15) - ((((~i3) & i5) + (i4 & i3)) + this.f26700b[bArr]);
        }
        i3 -= this.f26700b[i4 & 63];
        i4 -= this.f26700b[i5 & 63];
        i5 -= this.f26700b[i6 & 63];
        i6 -= this.f26700b[i3 & 63];
        for (bArr = 16; bArr >= null; bArr -= 4) {
            i3 = m35054a(i3, 11) - ((((~i4) & i6) + (i5 & i4)) + this.f26700b[bArr + 3]);
            i4 = m35054a(i4, 13) - ((((~i5) & i3) + (i6 & i5)) + this.f26700b[bArr + 2]);
            i5 = m35054a(i5, 14) - ((((~i6) & i4) + (i3 & i6)) + this.f26700b[bArr + 1]);
            i6 = m35054a(i6, 15) - ((((~i3) & i5) + (i4 & i3)) + this.f26700b[bArr]);
        }
        bArr2[i2 + 0] = (byte) i6;
        bArr2[i2 + 1] = (byte) (i6 >> 8);
        bArr2[i2 + 2] = (byte) i5;
        bArr2[i2 + 3] = (byte) (i5 >> 8);
        bArr2[i2 + 4] = (byte) i4;
        bArr2[i2 + 5] = (byte) (i4 >> 8);
        bArr2[i2 + 6] = (byte) i3;
        bArr2[i2 + 7] = (byte) (i3 >> 8);
    }
}
