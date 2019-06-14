package org.spongycastle.crypto.engines;

import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imageutils.JfifUtil;
import com.facebook.stetho.dumpapp.Framer;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;

public final class TwofishEngine implements BlockCipher {
    /* renamed from: a */
    private static final byte[][] f26811a = new byte[][]{new byte[]{(byte) -87, (byte) 103, (byte) -77, (byte) -24, (byte) 4, (byte) -3, (byte) -93, (byte) 118, (byte) -102, (byte) -110, Byte.MIN_VALUE, Framer.EXIT_FRAME_PREFIX, (byte) -28, (byte) -35, (byte) -47, (byte) 56, (byte) 13, (byte) -58, (byte) 53, (byte) -104, (byte) 24, (byte) -9, (byte) -20, (byte) 108, (byte) 67, (byte) 117, (byte) 55, (byte) 38, (byte) -6, (byte) 19, (byte) -108, (byte) 72, (byte) -14, (byte) -48, (byte) -117, (byte) 48, (byte) -124, (byte) 84, (byte) -33, (byte) 35, (byte) 25, (byte) 91, (byte) 61, (byte) 89, (byte) -13, (byte) -82, (byte) -94, (byte) -126, (byte) 99, (byte) 1, (byte) -125, (byte) 46, (byte) -39, (byte) 81, (byte) -101, (byte) 124, (byte) -90, (byte) -21, (byte) -91, (byte) -66, (byte) 22, (byte) 12, (byte) -29, (byte) 97, (byte) -64, (byte) -116, (byte) 58, (byte) -11, (byte) 115, (byte) 44, (byte) 37, (byte) 11, (byte) -69, (byte) 78, (byte) -119, (byte) 107, (byte) 83, (byte) 106, (byte) -76, (byte) -15, (byte) -31, (byte) -26, (byte) -67, (byte) 69, (byte) -30, (byte) -12, (byte) -74, (byte) 102, (byte) -52, (byte) -107, (byte) 3, (byte) 86, (byte) -44, (byte) 28, (byte) 30, (byte) -41, (byte) -5, (byte) -61, (byte) -114, (byte) -75, (byte) -23, (byte) -49, (byte) -65, (byte) -70, (byte) -22, (byte) 119, (byte) 57, (byte) -81, (byte) 51, (byte) -55, (byte) 98, (byte) 113, (byte) -127, (byte) 121, (byte) 9, (byte) -83, (byte) 36, (byte) -51, (byte) -7, (byte) -40, (byte) -27, (byte) -59, (byte) -71, (byte) 77, (byte) 68, (byte) 8, (byte) -122, (byte) -25, (byte) -95, (byte) 29, (byte) -86, (byte) -19, (byte) 6, (byte) 112, (byte) -78, (byte) -46, (byte) 65, (byte) 123, (byte) -96, (byte) 17, Framer.STDOUT_FRAME_PREFIX, (byte) -62, (byte) 39, (byte) -112, (byte) 32, (byte) -10, (byte) 96, (byte) -1, (byte) -106, (byte) 92, (byte) -79, (byte) -85, (byte) -98, (byte) -100, (byte) 82, (byte) 27, Framer.STDIN_REQUEST_FRAME_PREFIX, (byte) -109, (byte) 10, (byte) -17, (byte) -111, (byte) -123, (byte) 73, (byte) -18, Framer.STDIN_FRAME_PREFIX, (byte) 79, (byte) -113, (byte) 59, (byte) 71, (byte) -121, (byte) 109, (byte) 70, (byte) -42, (byte) 62, (byte) 105, (byte) 100, (byte) 42, (byte) -50, (byte) -53, (byte) 47, (byte) -4, (byte) -105, (byte) 5, (byte) 122, (byte) -84, Byte.MAX_VALUE, (byte) -43, (byte) 26, (byte) 75, (byte) 14, (byte) -89, (byte) 90, (byte) 40, (byte) 20, (byte) 63, (byte) 41, (byte) -120, (byte) 60, (byte) 76, (byte) 2, (byte) -72, (byte) -38, (byte) -80, (byte) 23, (byte) 85, (byte) 31, (byte) -118, (byte) 125, (byte) 87, (byte) -57, (byte) -115, (byte) 116, (byte) -73, (byte) -60, (byte) -97, (byte) 114, (byte) 126, (byte) 21, (byte) 34, (byte) 18, (byte) 88, (byte) 7, (byte) -103, (byte) 52, (byte) 110, (byte) 80, (byte) -34, (byte) 104, (byte) 101, (byte) -68, (byte) -37, (byte) -8, (byte) -56, (byte) -88, (byte) 43, (byte) 64, (byte) -36, (byte) -2, Framer.STDERR_FRAME_PREFIX, (byte) -92, (byte) -54, (byte) 16, Framer.ENTER_FRAME_PREFIX, (byte) -16, (byte) -45, (byte) 93, (byte) 15, (byte) 0, (byte) 111, (byte) -99, (byte) 54, (byte) 66, (byte) 74, (byte) 94, (byte) -63, (byte) -32}, new byte[]{(byte) 117, (byte) -13, (byte) -58, (byte) -12, (byte) -37, (byte) 123, (byte) -5, (byte) -56, (byte) 74, (byte) -45, (byte) -26, (byte) 107, (byte) 69, (byte) 125, (byte) -24, (byte) 75, (byte) -42, Framer.STDERR_FRAME_PREFIX, (byte) -40, (byte) -3, (byte) 55, (byte) 113, (byte) -15, (byte) -31, (byte) 48, (byte) 15, (byte) -8, (byte) 27, (byte) -121, (byte) -6, (byte) 6, (byte) 63, (byte) 94, (byte) -70, (byte) -82, (byte) 91, (byte) -118, (byte) 0, (byte) -68, (byte) -99, (byte) 109, (byte) -63, (byte) -79, (byte) 14, Byte.MIN_VALUE, (byte) 93, (byte) -46, (byte) -43, (byte) -96, (byte) -124, (byte) 7, (byte) 20, (byte) -75, (byte) -112, (byte) 44, (byte) -93, (byte) -78, (byte) 115, (byte) 76, (byte) 84, (byte) -110, (byte) 116, (byte) 54, (byte) 81, (byte) 56, (byte) -80, (byte) -67, (byte) 90, (byte) -4, (byte) 96, (byte) 98, (byte) -106, (byte) 108, (byte) 66, (byte) -9, (byte) 16, (byte) 124, (byte) 40, (byte) 39, (byte) -116, (byte) 19, (byte) -107, (byte) -100, (byte) -57, (byte) 36, (byte) 70, (byte) 59, (byte) 112, (byte) -54, (byte) -29, (byte) -123, (byte) -53, (byte) 17, (byte) -48, (byte) -109, (byte) -72, (byte) -90, (byte) -125, (byte) 32, (byte) -1, (byte) -97, (byte) 119, (byte) -61, (byte) -52, (byte) 3, (byte) 111, (byte) 8, (byte) -65, (byte) 64, (byte) -25, (byte) 43, (byte) -30, (byte) 121, (byte) 12, (byte) -86, (byte) -126, (byte) 65, (byte) 58, (byte) -22, (byte) -71, (byte) -28, (byte) -102, (byte) -92, (byte) -105, (byte) 126, (byte) -38, (byte) 122, (byte) 23, (byte) 102, (byte) -108, (byte) -95, (byte) 29, (byte) 61, (byte) -16, (byte) -34, (byte) -77, (byte) 11, (byte) 114, (byte) -89, (byte) 28, (byte) -17, (byte) -47, (byte) 83, (byte) 62, (byte) -113, (byte) 51, (byte) 38, Framer.STDIN_REQUEST_FRAME_PREFIX, (byte) -20, (byte) 118, (byte) 42, (byte) 73, (byte) -127, (byte) -120, (byte) -18, Framer.ENTER_FRAME_PREFIX, (byte) -60, (byte) 26, (byte) -21, (byte) -39, (byte) -59, (byte) 57, (byte) -103, (byte) -51, (byte) -83, Framer.STDOUT_FRAME_PREFIX, (byte) -117, (byte) 1, (byte) 24, (byte) 35, (byte) -35, (byte) 31, (byte) 78, Framer.STDIN_FRAME_PREFIX, (byte) -7, (byte) 72, (byte) 79, (byte) -14, (byte) 101, (byte) -114, Framer.EXIT_FRAME_PREFIX, (byte) 92, (byte) 88, (byte) 25, (byte) -115, (byte) -27, (byte) -104, (byte) 87, (byte) 103, Byte.MAX_VALUE, (byte) 5, (byte) 100, (byte) -81, (byte) 99, (byte) -74, (byte) -2, (byte) -11, (byte) -73, (byte) 60, (byte) -91, (byte) -50, (byte) -23, (byte) 104, (byte) 68, (byte) -32, (byte) 77, (byte) 67, (byte) 105, (byte) 41, (byte) 46, (byte) -84, (byte) 21, (byte) 89, (byte) -88, (byte) 10, (byte) -98, (byte) 110, (byte) 71, (byte) -33, (byte) 52, (byte) 53, (byte) 106, (byte) -49, (byte) -36, (byte) 34, (byte) -55, (byte) -64, (byte) -101, (byte) -119, (byte) -44, (byte) -19, (byte) -85, (byte) 18, (byte) -94, (byte) 13, (byte) 82, (byte) -69, (byte) 2, (byte) 47, (byte) -87, (byte) -41, (byte) 97, (byte) 30, (byte) -76, (byte) 80, (byte) 4, (byte) -10, (byte) -62, (byte) 22, (byte) 37, (byte) -122, (byte) 86, (byte) 85, (byte) 9, (byte) -66, (byte) -111}};
    /* renamed from: b */
    private boolean f26812b = false;
    /* renamed from: c */
    private int[] f26813c = new int[256];
    /* renamed from: d */
    private int[] f26814d = new int[256];
    /* renamed from: e */
    private int[] f26815e = new int[256];
    /* renamed from: f */
    private int[] f26816f = new int[256];
    /* renamed from: g */
    private int[] f26817g;
    /* renamed from: h */
    private int[] f26818h;
    /* renamed from: i */
    private int f26819i = 0;
    /* renamed from: j */
    private byte[] f26820j = null;

    /* renamed from: a */
    private int m35278a(int i) {
        int i2 = (i >>> 24) & JfifUtil.MARKER_FIRST_BYTE;
        int i3 = 0;
        int i4 = ((i2 << 1) ^ ((i2 & 128) != 0 ? 333 : 0)) & JfifUtil.MARKER_FIRST_BYTE;
        int i5 = i2 >>> 1;
        if ((i2 & 1) != 0) {
            i3 = 166;
        }
        i5 = (i5 ^ i3) ^ i4;
        return ((((i << 8) ^ (i5 << 24)) ^ (i4 << 16)) ^ (i5 << 8)) ^ i2;
    }

    /* renamed from: b */
    private int m35284b(int i) {
        return ((i & 1) != 0 ? RotationOptions.ROTATE_180 : 0) ^ (i >> 1);
    }

    /* renamed from: c */
    private int m35286c(int i) {
        int i2 = 0;
        int i3 = (i >> 2) ^ ((i & 2) != 0 ? RotationOptions.ROTATE_180 : 0);
        if ((i & 1) != 0) {
            i2 = 90;
        }
        return i3 ^ i2;
    }

    /* renamed from: f */
    private int m35290f(int i) {
        return i & JfifUtil.MARKER_FIRST_BYTE;
    }

    /* renamed from: g */
    private int m35291g(int i) {
        return (i >>> 8) & JfifUtil.MARKER_FIRST_BYTE;
    }

    /* renamed from: h */
    private int m35292h(int i) {
        return (i >>> 16) & JfifUtil.MARKER_FIRST_BYTE;
    }

    /* renamed from: i */
    private int m35293i(int i) {
        return (i >>> 24) & JfifUtil.MARKER_FIRST_BYTE;
    }

    /* renamed from: a */
    public String mo5741a() {
        return "Twofish";
    }

    /* renamed from: b */
    public int mo5743b() {
        return 16;
    }

    public TwofishEngine() {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        int[] iArr3 = new int[2];
        for (int i = 0; i < 256; i++) {
            int i2 = f26811a[0][i] & JfifUtil.MARKER_FIRST_BYTE;
            iArr[0] = i2;
            iArr2[0] = m35288d(i2) & JfifUtil.MARKER_FIRST_BYTE;
            iArr3[0] = m35289e(i2) & JfifUtil.MARKER_FIRST_BYTE;
            i2 = f26811a[1][i] & JfifUtil.MARKER_FIRST_BYTE;
            iArr[1] = i2;
            iArr2[1] = m35288d(i2) & JfifUtil.MARKER_FIRST_BYTE;
            iArr3[1] = m35289e(i2) & JfifUtil.MARKER_FIRST_BYTE;
            this.f26813c[i] = ((iArr[1] | (iArr2[1] << 8)) | (iArr3[1] << 16)) | (iArr3[1] << 24);
            this.f26814d[i] = ((iArr3[0] | (iArr3[0] << 8)) | (iArr2[0] << 16)) | (iArr[0] << 24);
            this.f26815e[i] = (iArr3[1] << 24) | ((iArr2[1] | (iArr3[1] << 8)) | (iArr[1] << 16));
            this.f26816f[i] = ((iArr2[0] | (iArr[0] << 8)) | (iArr3[0] << 16)) | (iArr2[0] << 24);
        }
    }

    /* renamed from: a */
    public void mo5742a(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.f26812b = z;
            this.f26820j = ((KeyParameter) cipherParameters).m35685a();
            this.f26819i = this.f26820j.length / 8;
            m35283a(this.f26820j);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("invalid parameter passed to Twofish init - ");
        stringBuilder.append(cipherParameters.getClass().getName());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public int mo5740a(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.f26820j == null) {
            throw new IllegalStateException("Twofish not initialised");
        } else if (i + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 16 <= bArr2.length) {
            if (this.f26812b) {
                m35285b(bArr, i, bArr2, i2);
            } else {
                m35287c(bArr, i, bArr2, i2);
            }
            return 16;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    /* renamed from: c */
    public void mo5744c() {
        if (this.f26820j != null) {
            m35283a(this.f26820j);
        }
    }

    /* renamed from: a */
    private void m35283a(byte[] bArr) {
        byte[] bArr2 = bArr;
        int[] iArr = new int[4];
        int[] iArr2 = new int[4];
        int[] iArr3 = new int[4];
        this.f26817g = new int[40];
        if (this.f26819i < 1) {
            throw new IllegalArgumentException("Key size less than 64 bits");
        } else if (r0.f26819i <= 4) {
            int i;
            int i2;
            int i3;
            int i4;
            int i5;
            for (i = 0; i < r0.f26819i; i++) {
                i2 = i * 8;
                iArr[i] = m35281a(bArr2, i2);
                iArr2[i] = m35281a(bArr2, i2 + 4);
                iArr3[(r0.f26819i - 1) - i] = m35279a(iArr[i], iArr2[i]);
            }
            for (i3 = 0; i3 < 20; i3++) {
                i4 = 33686018 * i3;
                i = m35280a(i4, iArr);
                i4 = m35280a(i4 + 16843009, iArr2);
                i4 = (i4 >>> 24) | (i4 << 8);
                i += i4;
                i5 = i3 * 2;
                r0.f26817g[i5] = i;
                i += i4;
                r0.f26817g[i5 + 1] = (i >>> 23) | (i << 9);
            }
            i3 = iArr3[0];
            i4 = iArr3[1];
            int i6 = iArr3[2];
            int i7 = iArr3[3];
            r0.f26818h = new int[1024];
            for (i = 0; i < 256; i++) {
                int h;
                int i8;
                switch (r0.f26819i & 3) {
                    case 0:
                        i2 = (f26811a[1][i] & JfifUtil.MARKER_FIRST_BYTE) ^ m35290f(i7);
                        i5 = (f26811a[0][i] & JfifUtil.MARKER_FIRST_BYTE) ^ m35291g(i7);
                        h = (f26811a[0][i] & JfifUtil.MARKER_FIRST_BYTE) ^ m35292h(i7);
                        i8 = (f26811a[1][i] & JfifUtil.MARKER_FIRST_BYTE) ^ m35293i(i7);
                        break;
                    case 1:
                        i5 = i * 2;
                        r0.f26818h[i5] = r0.f26813c[(f26811a[0][i] & JfifUtil.MARKER_FIRST_BYTE) ^ m35290f(i3)];
                        r0.f26818h[i5 + 1] = r0.f26814d[(f26811a[0][i] & JfifUtil.MARKER_FIRST_BYTE) ^ m35291g(i3)];
                        r0.f26818h[i5 + 512] = r0.f26815e[(f26811a[1][i] & JfifUtil.MARKER_FIRST_BYTE) ^ m35292h(i3)];
                        r0.f26818h[i5 + 513] = r0.f26816f[(f26811a[1][i] & JfifUtil.MARKER_FIRST_BYTE) ^ m35293i(i3)];
                        continue;
                    case 2:
                        i2 = i;
                        i5 = i2;
                        h = i5;
                        i8 = h;
                        break;
                    case 3:
                        i2 = i;
                        i5 = i2;
                        h = i5;
                        i8 = h;
                        break;
                    default:
                        continue;
                }
                i2 = (f26811a[1][i2] & JfifUtil.MARKER_FIRST_BYTE) ^ m35290f(i6);
                i5 = (f26811a[1][i5] & JfifUtil.MARKER_FIRST_BYTE) ^ m35291g(i6);
                h = (f26811a[0][h] & JfifUtil.MARKER_FIRST_BYTE) ^ m35292h(i6);
                i8 = (f26811a[0][i8] & JfifUtil.MARKER_FIRST_BYTE) ^ m35293i(i6);
                int i9 = i * 2;
                r0.f26818h[i9] = r0.f26813c[(f26811a[0][(f26811a[0][i2] & JfifUtil.MARKER_FIRST_BYTE) ^ m35290f(i4)] & JfifUtil.MARKER_FIRST_BYTE) ^ m35290f(i3)];
                r0.f26818h[i9 + 1] = r0.f26814d[(f26811a[0][(f26811a[1][i5] & JfifUtil.MARKER_FIRST_BYTE) ^ m35291g(i4)] & JfifUtil.MARKER_FIRST_BYTE) ^ m35291g(i3)];
                r0.f26818h[i9 + 512] = r0.f26815e[(f26811a[1][(f26811a[0][h] & JfifUtil.MARKER_FIRST_BYTE) ^ m35292h(i4)] & JfifUtil.MARKER_FIRST_BYTE) ^ m35292h(i3)];
                r0.f26818h[i9 + 513] = r0.f26816f[(f26811a[1][(f26811a[1][i8] & JfifUtil.MARKER_FIRST_BYTE) ^ m35293i(i4)] & JfifUtil.MARKER_FIRST_BYTE) ^ m35293i(i3)];
            }
        } else {
            throw new IllegalArgumentException("Key size larger than 256 bits");
        }
    }

    /* renamed from: b */
    private void m35285b(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = 0;
        int a = m35281a(bArr, i) ^ this.f26817g[0];
        int a2 = m35281a(bArr, i + 4) ^ this.f26817g[1];
        int a3 = m35281a(bArr, i + 8) ^ this.f26817g[2];
        bArr = m35281a(bArr, i + 12) ^ this.f26817g[3];
        i = 8;
        while (i3 < 16) {
            int j = m35294j(a);
            int k = m35295k(a2);
            int i4 = i + 1;
            i = a3 ^ ((j + k) + this.f26817g[i]);
            a3 = (i >>> 1) | (i << 31);
            j += k * 2;
            k = i4 + 1;
            bArr = ((bArr >>> 31) | (bArr << 1)) ^ (j + this.f26817g[i4]);
            i = m35294j(a3);
            j = m35295k(bArr);
            i4 = k + 1;
            a ^= (i + j) + this.f26817g[k];
            a = (a << 31) | (a >>> 1);
            a2 = (a2 >>> 31) | (a2 << 1);
            a2 ^= (i + (j * 2)) + this.f26817g[i4];
            i3 += 2;
            i = i4 + 1;
        }
        m35282a(this.f26817g[4] ^ a3, bArr2, i2);
        m35282a(bArr ^ this.f26817g[5], bArr2, i2 + 4);
        m35282a(this.f26817g[6] ^ a, bArr2, i2 + 8);
        m35282a(this.f26817g[7] ^ a2, bArr2, i2 + 12);
    }

    /* renamed from: c */
    private void m35287c(byte[] bArr, int i, byte[] bArr2, int i2) {
        int a = m35281a(bArr, i) ^ this.f26817g[4];
        int a2 = m35281a(bArr, i + 4) ^ this.f26817g[5];
        int i3 = 39;
        int a3 = m35281a(bArr, i + 8) ^ this.f26817g[6];
        int a4 = m35281a(bArr, i + 12) ^ this.f26817g[7];
        bArr = null;
        while (bArr < 16) {
            int j = m35294j(a);
            int k = m35295k(a2);
            int i4 = i3 - 1;
            a4 ^= ((k * 2) + j) + this.f26817g[i3];
            j += k;
            k = i4 - 1;
            a3 = ((a3 << 1) | (a3 >>> 31)) ^ (j + this.f26817g[i4]);
            a4 = (a4 << 31) | (a4 >>> 1);
            i3 = m35294j(a3);
            j = m35295k(a4);
            i4 = k - 1;
            a2 ^= ((j * 2) + i3) + this.f26817g[k];
            a = (a >>> 31) | (a << 1);
            a ^= (i3 + j) + this.f26817g[i4];
            a2 = (a2 << 31) | (a2 >>> 1);
            bArr += 2;
            i3 = i4 - 1;
        }
        m35282a(this.f26817g[0] ^ a3, bArr2, i2);
        m35282a(this.f26817g[1] ^ a4, bArr2, i2 + 4);
        m35282a(this.f26817g[2] ^ a, bArr2, i2 + 8);
        m35282a(this.f26817g[3] ^ a2, bArr2, i2 + 12);
    }

    /* renamed from: a */
    private int m35280a(int i, int[] iArr) {
        int f = m35290f(i);
        int g = m35291g(i);
        int h = m35292h(i);
        i = m35293i(i);
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[2];
        iArr = iArr[3];
        switch (3 & this.f26819i) {
            case 0:
                f = (f26811a[1][f] & JfifUtil.MARKER_FIRST_BYTE) ^ m35290f(iArr);
                g = (f26811a[0][g] & JfifUtil.MARKER_FIRST_BYTE) ^ m35291g(iArr);
                h = (f26811a[0][h] & JfifUtil.MARKER_FIRST_BYTE) ^ m35292h(iArr);
                i = (f26811a[1][i] & JfifUtil.MARKER_FIRST_BYTE) ^ m35293i(iArr);
                break;
            case 1:
                return ((this.f26813c[(f26811a[0][f] & JfifUtil.MARKER_FIRST_BYTE) ^ m35290f(i2)] ^ this.f26814d[(f26811a[0][g] & JfifUtil.MARKER_FIRST_BYTE) ^ m35291g(i2)]) ^ this.f26815e[(f26811a[1][h] & JfifUtil.MARKER_FIRST_BYTE) ^ m35292h(i2)]) ^ this.f26816f[(f26811a[1][i] & JfifUtil.MARKER_FIRST_BYTE) ^ m35293i(i2)];
            case 2:
                break;
            case 3:
                break;
            default:
                return 0;
        }
        f = m35290f(i4) ^ (f26811a[1][f] & JfifUtil.MARKER_FIRST_BYTE);
        g = m35291g(i4) ^ (f26811a[1][g] & JfifUtil.MARKER_FIRST_BYTE);
        h = m35292h(i4) ^ (f26811a[0][h] & JfifUtil.MARKER_FIRST_BYTE);
        i = (f26811a[0][i] & JfifUtil.MARKER_FIRST_BYTE) ^ m35293i(i4);
        return ((this.f26813c[(f26811a[0][(f26811a[0][f] & JfifUtil.MARKER_FIRST_BYTE) ^ m35290f(i3)] & JfifUtil.MARKER_FIRST_BYTE) ^ m35290f(i2)] ^ this.f26814d[(f26811a[0][(f26811a[1][g] & JfifUtil.MARKER_FIRST_BYTE) ^ m35291g(i3)] & JfifUtil.MARKER_FIRST_BYTE) ^ m35291g(i2)]) ^ this.f26815e[(f26811a[1][(f26811a[0][h] & JfifUtil.MARKER_FIRST_BYTE) ^ m35292h(i3)] & JfifUtil.MARKER_FIRST_BYTE) ^ m35292h(i2)]) ^ this.f26816f[(f26811a[1][(f26811a[1][i] & JfifUtil.MARKER_FIRST_BYTE) ^ m35293i(i3)] & JfifUtil.MARKER_FIRST_BYTE) ^ m35293i(i2)];
    }

    /* renamed from: a */
    private int m35279a(int i, int i2) {
        int i3 = i2;
        for (i2 = 0; i2 < 4; i2++) {
            i3 = m35278a(i3);
        }
        i ^= i3;
        for (int i4 = 0; i4 < 4; i4++) {
            i = m35278a(i);
        }
        return i;
    }

    /* renamed from: d */
    private int m35288d(int i) {
        return i ^ m35286c(i);
    }

    /* renamed from: e */
    private int m35289e(int i) {
        return m35286c(i) ^ (m35284b(i) ^ i);
    }

    /* renamed from: j */
    private int m35294j(int i) {
        return this.f26818h[(((i >>> 24) & JfifUtil.MARKER_FIRST_BYTE) * 2) + 513] ^ ((this.f26818h[((i & JfifUtil.MARKER_FIRST_BYTE) * 2) + 0] ^ this.f26818h[(((i >>> 8) & JfifUtil.MARKER_FIRST_BYTE) * 2) + 1]) ^ this.f26818h[(((i >>> 16) & JfifUtil.MARKER_FIRST_BYTE) * 2) + 512]);
    }

    /* renamed from: k */
    private int m35295k(int i) {
        return this.f26818h[(((i >>> 16) & JfifUtil.MARKER_FIRST_BYTE) * 2) + 513] ^ ((this.f26818h[(((i >>> 24) & JfifUtil.MARKER_FIRST_BYTE) * 2) + 0] ^ this.f26818h[((i & JfifUtil.MARKER_FIRST_BYTE) * 2) + 1]) ^ this.f26818h[(((i >>> 8) & JfifUtil.MARKER_FIRST_BYTE) * 2) + 512]);
    }

    /* renamed from: a */
    private int m35281a(byte[] bArr, int i) {
        return ((bArr[i + 3] & JfifUtil.MARKER_FIRST_BYTE) << 24) | (((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) | ((bArr[i + 1] & JfifUtil.MARKER_FIRST_BYTE) << 8)) | ((bArr[i + 2] & JfifUtil.MARKER_FIRST_BYTE) << 16));
    }

    /* renamed from: a */
    private void m35282a(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >> 8);
        bArr[i2 + 2] = (byte) (i >> 16);
        bArr[i2 + 3] = (byte) (i >> 24);
    }
}
