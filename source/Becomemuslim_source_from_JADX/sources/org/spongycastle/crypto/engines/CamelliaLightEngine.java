package org.spongycastle.crypto.engines;

import com.facebook.imageutils.JfifUtil;
import com.facebook.stetho.dumpapp.Framer;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;

public class CamelliaLightEngine implements BlockCipher {
    /* renamed from: g */
    private static final int[] f26591g = new int[]{-1600231809, 1003262091, -1233459112, 1286239154, -957401297, -380665154, 1426019237, -237801700, 283453434, -563598051, -1336506174, -1276722691};
    /* renamed from: h */
    private static final byte[] f26592h = new byte[]{(byte) 112, (byte) -126, (byte) 44, (byte) -20, (byte) -77, (byte) 39, (byte) -64, (byte) -27, (byte) -28, (byte) -123, (byte) 87, (byte) 53, (byte) -22, (byte) 12, (byte) -82, (byte) 65, (byte) 35, (byte) -17, (byte) 107, (byte) -109, (byte) 69, (byte) 25, (byte) -91, Framer.ENTER_FRAME_PREFIX, (byte) -19, (byte) 14, (byte) 79, (byte) 78, (byte) 29, (byte) 101, (byte) -110, (byte) -67, (byte) -122, (byte) -72, (byte) -81, (byte) -113, (byte) 124, (byte) -21, (byte) 31, (byte) -50, (byte) 62, (byte) 48, (byte) -36, Framer.STDIN_REQUEST_FRAME_PREFIX, (byte) 94, (byte) -59, (byte) 11, (byte) 26, (byte) -90, (byte) -31, (byte) 57, (byte) -54, (byte) -43, (byte) 71, (byte) 93, (byte) 61, (byte) -39, (byte) 1, (byte) 90, (byte) -42, (byte) 81, (byte) 86, (byte) 108, (byte) 77, (byte) -117, (byte) 13, (byte) -102, (byte) 102, (byte) -5, (byte) -52, (byte) -80, Framer.STDIN_FRAME_PREFIX, (byte) 116, (byte) 18, (byte) 43, (byte) 32, (byte) -16, (byte) -79, (byte) -124, (byte) -103, (byte) -33, (byte) 76, (byte) -53, (byte) -62, (byte) 52, (byte) 126, (byte) 118, (byte) 5, (byte) 109, (byte) -73, (byte) -87, Framer.STDOUT_FRAME_PREFIX, (byte) -47, (byte) 23, (byte) 4, (byte) -41, (byte) 20, (byte) 88, (byte) 58, (byte) 97, (byte) -34, (byte) 27, (byte) 17, (byte) 28, Framer.STDERR_FRAME_PREFIX, (byte) 15, (byte) -100, (byte) 22, (byte) 83, (byte) 24, (byte) -14, (byte) 34, (byte) -2, (byte) 68, (byte) -49, (byte) -78, (byte) -61, (byte) -75, (byte) 122, (byte) -111, (byte) 36, (byte) 8, (byte) -24, (byte) -88, (byte) 96, (byte) -4, (byte) 105, (byte) 80, (byte) -86, (byte) -48, (byte) -96, (byte) 125, (byte) -95, (byte) -119, (byte) 98, (byte) -105, (byte) 84, (byte) 91, (byte) 30, (byte) -107, (byte) -32, (byte) -1, (byte) 100, (byte) -46, (byte) 16, (byte) -60, (byte) 0, (byte) 72, (byte) -93, (byte) -9, (byte) 117, (byte) -37, (byte) -118, (byte) 3, (byte) -26, (byte) -38, (byte) 9, (byte) 63, (byte) -35, (byte) -108, (byte) -121, (byte) 92, (byte) -125, (byte) 2, (byte) -51, (byte) 74, (byte) -112, (byte) 51, (byte) 115, (byte) 103, (byte) -10, (byte) -13, (byte) -99, Byte.MAX_VALUE, (byte) -65, (byte) -30, (byte) 82, (byte) -101, (byte) -40, (byte) 38, (byte) -56, (byte) 55, (byte) -58, (byte) 59, (byte) -127, (byte) -106, (byte) 111, (byte) 75, (byte) 19, (byte) -66, (byte) 99, (byte) 46, (byte) -23, (byte) 121, (byte) -89, (byte) -116, (byte) -97, (byte) 110, (byte) -68, (byte) -114, (byte) 41, (byte) -11, (byte) -7, (byte) -74, (byte) 47, (byte) -3, (byte) -76, (byte) 89, Framer.EXIT_FRAME_PREFIX, (byte) -104, (byte) 6, (byte) 106, (byte) -25, (byte) 70, (byte) 113, (byte) -70, (byte) -44, (byte) 37, (byte) -85, (byte) 66, (byte) -120, (byte) -94, (byte) -115, (byte) -6, (byte) 114, (byte) 7, (byte) -71, (byte) 85, (byte) -8, (byte) -18, (byte) -84, (byte) 10, (byte) 54, (byte) 73, (byte) 42, (byte) 104, (byte) 60, (byte) 56, (byte) -15, (byte) -92, (byte) 64, (byte) 40, (byte) -45, (byte) 123, (byte) -69, (byte) -55, (byte) 67, (byte) -63, (byte) 21, (byte) -29, (byte) -83, (byte) -12, (byte) 119, (byte) -57, Byte.MIN_VALUE, (byte) -98};
    /* renamed from: a */
    private boolean f26593a;
    /* renamed from: b */
    private boolean f26594b;
    /* renamed from: c */
    private int[] f26595c = new int[96];
    /* renamed from: d */
    private int[] f26596d = new int[8];
    /* renamed from: e */
    private int[] f26597e = new int[12];
    /* renamed from: f */
    private int[] f26598f = new int[4];

    /* renamed from: a */
    private byte m34899a(byte b, int i) {
        return (byte) (((b & JfifUtil.MARKER_FIRST_BYTE) >>> (8 - i)) | (b << i));
    }

    /* renamed from: a */
    private static int m34901a(int i, int i2) {
        return (i >>> i2) + (i << (32 - i2));
    }

    /* renamed from: b */
    private static int m34908b(int i, int i2) {
        return (i << i2) + (i >>> (32 - i2));
    }

    /* renamed from: a */
    public String mo5741a() {
        return "Camellia";
    }

    /* renamed from: b */
    public int mo5743b() {
        return 16;
    }

    /* renamed from: c */
    public void mo5744c() {
    }

    /* renamed from: a */
    private static void m34904a(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        int i4 = i3 + 0;
        int i5 = i2 + 0;
        int i6 = i2 + 1;
        int i7 = 32 - i;
        iArr2[i4] = (iArr[i5] << i) | (iArr[i6] >>> i7);
        int i8 = i3 + 1;
        int i9 = i2 + 2;
        iArr2[i8] = (iArr[i6] << i) | (iArr[i9] >>> i7);
        int i10 = i3 + 2;
        i2 += 3;
        iArr2[i10] = (iArr[i9] << i) | (iArr[i2] >>> i7);
        i3 += 3;
        iArr2[i3] = (iArr[i2] << i) | (iArr[i5] >>> i7);
        iArr[i5] = iArr2[i4];
        iArr[i6] = iArr2[i8];
        iArr[i9] = iArr2[i10];
        iArr[i2] = iArr2[i3];
    }

    /* renamed from: b */
    private static void m34910b(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        int i4 = i3 + 2;
        int i5 = i2 + 0;
        int i6 = i2 + 1;
        int i7 = 32 - i;
        iArr2[i4] = (iArr[i5] << i) | (iArr[i6] >>> i7);
        int i8 = i3 + 3;
        int i9 = i2 + 2;
        iArr2[i8] = (iArr[i6] << i) | (iArr[i9] >>> i7);
        int i10 = i3 + 0;
        i2 += 3;
        iArr2[i10] = (iArr[i9] << i) | (iArr[i2] >>> i7);
        i3++;
        iArr2[i3] = (iArr[i2] << i) | (iArr[i5] >>> i7);
        iArr[i5] = iArr2[i4];
        iArr[i6] = iArr2[i8];
        iArr[i9] = iArr2[i10];
        iArr[i2] = iArr2[i3];
    }

    /* renamed from: c */
    private static void m34914c(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        int i4 = i3 + 0;
        int i5 = i2 + 1;
        int i6 = i - 32;
        int i7 = i2 + 2;
        i = 64 - i;
        iArr2[i4] = (iArr[i5] << i6) | (iArr[i7] >>> i);
        int i8 = i3 + 1;
        int i9 = i2 + 3;
        iArr2[i8] = (iArr[i7] << i6) | (iArr[i9] >>> i);
        int i10 = i3 + 2;
        i2 += 0;
        iArr2[i10] = (iArr[i9] << i6) | (iArr[i2] >>> i);
        i3 += 3;
        iArr2[i3] = (iArr[i5] >>> i) | (iArr[i2] << i6);
        iArr[i2] = iArr2[i4];
        iArr[i5] = iArr2[i8];
        iArr[i7] = iArr2[i10];
        iArr[i9] = iArr2[i3];
    }

    /* renamed from: d */
    private static void m34915d(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        int i4 = i3 + 2;
        int i5 = i2 + 1;
        int i6 = i - 32;
        int i7 = i2 + 2;
        i = 64 - i;
        iArr2[i4] = (iArr[i5] << i6) | (iArr[i7] >>> i);
        int i8 = i3 + 3;
        int i9 = i2 + 3;
        iArr2[i8] = (iArr[i7] << i6) | (iArr[i9] >>> i);
        int i10 = i3 + 0;
        i2 += 0;
        iArr2[i10] = (iArr[i9] << i6) | (iArr[i2] >>> i);
        i3++;
        iArr2[i3] = (iArr[i5] >>> i) | (iArr[i2] << i6);
        iArr[i2] = iArr2[i4];
        iArr[i5] = iArr2[i8];
        iArr[i7] = iArr2[i10];
        iArr[i9] = iArr2[i3];
    }

    /* renamed from: a */
    private int m34902a(byte[] bArr, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            i2 = (i2 << 8) + (bArr[i3 + i] & JfifUtil.MARKER_FIRST_BYTE);
        }
        return i2;
    }

    /* renamed from: a */
    private void m34903a(int i, byte[] bArr, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            bArr[(3 - i3) + i2] = (byte) i;
            i >>>= 8;
        }
    }

    /* renamed from: a */
    private int m34900a(int i) {
        return m34899a(f26592h[i], 1) & JfifUtil.MARKER_FIRST_BYTE;
    }

    /* renamed from: b */
    private int m34907b(int i) {
        return m34899a(f26592h[i], 7) & JfifUtil.MARKER_FIRST_BYTE;
    }

    /* renamed from: c */
    private int m34912c(int i) {
        return f26592h[m34899a((byte) i, 1) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE;
    }

    /* renamed from: a */
    private void m34906a(int[] iArr, int[] iArr2, int i) {
        int i2 = iArr[0] ^ iArr2[i + 0];
        i2 = ((f26592h[(i2 >>> 24) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 24) | ((m34912c(i2 & JfifUtil.MARKER_FIRST_BYTE) | (m34907b((i2 >>> 8) & JfifUtil.MARKER_FIRST_BYTE) << 8)) | (m34900a((i2 >>> 16) & JfifUtil.MARKER_FIRST_BYTE) << 16));
        int i3 = iArr[1] ^ iArr2[i + 1];
        i3 = m34908b((m34900a((i3 >>> 24) & JfifUtil.MARKER_FIRST_BYTE) << 24) | (((f26592h[i3 & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) | (m34912c((i3 >>> 8) & JfifUtil.MARKER_FIRST_BYTE) << 8)) | (m34907b((i3 >>> 16) & JfifUtil.MARKER_FIRST_BYTE) << 16)), 8);
        i2 ^= i3;
        i3 = m34908b(i3, 8) ^ i2;
        i2 = m34901a(i2, 8) ^ i3;
        iArr[2] = (m34908b(i3, 16) ^ i2) ^ iArr[2];
        iArr[3] = m34908b(i2, 8) ^ iArr[3];
        i2 = iArr[2] ^ iArr2[i + 2];
        i2 = ((f26592h[(i2 >>> 24) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 24) | ((m34912c(i2 & JfifUtil.MARKER_FIRST_BYTE) | (m34907b((i2 >>> 8) & JfifUtil.MARKER_FIRST_BYTE) << 8)) | (m34900a((i2 >>> 16) & JfifUtil.MARKER_FIRST_BYTE) << 16));
        iArr2 = iArr2[i + 3] ^ iArr[3];
        iArr2 = m34908b((m34900a((iArr2 >>> 24) & JfifUtil.MARKER_FIRST_BYTE) << 24) | (((f26592h[iArr2 & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) | (m34912c((iArr2 >>> 8) & JfifUtil.MARKER_FIRST_BYTE) << 8)) | (m34907b((iArr2 >>> 16) & JfifUtil.MARKER_FIRST_BYTE) << 16)), 8);
        i = i2 ^ iArr2;
        iArr2 = m34908b(iArr2, 8) ^ i;
        i = m34901a(i, 8) ^ iArr2;
        iArr[0] = (m34908b(iArr2, 16) ^ i) ^ iArr[0];
        iArr[1] = iArr[1] ^ m34908b(i, 8);
    }

    /* renamed from: b */
    private void m34911b(int[] iArr, int[] iArr2, int i) {
        iArr[1] = iArr[1] ^ m34908b(iArr[0] & iArr2[i + 0], 1);
        iArr[0] = iArr[0] ^ (iArr2[i + 1] | iArr[1]);
        iArr[2] = iArr[2] ^ (iArr2[i + 3] | iArr[3]);
        iArr[3] = m34908b(iArr2[i + 2] & iArr[2], 1) ^ iArr[3];
    }

    /* renamed from: a */
    private void m34905a(boolean z, byte[] bArr) {
        int i;
        CamelliaLightEngine camelliaLightEngine = this;
        byte[] bArr2 = bArr;
        int[] iArr = new int[8];
        int[] iArr2 = new int[4];
        int[] iArr3 = new int[4];
        int[] iArr4 = new int[4];
        int length = bArr2.length;
        if (length == 16) {
            camelliaLightEngine.f26594b = true;
            iArr[0] = m34902a(bArr2, 0);
            iArr[1] = m34902a(bArr2, 4);
            iArr[2] = m34902a(bArr2, 8);
            iArr[3] = m34902a(bArr2, 12);
            iArr[7] = 0;
            iArr[6] = 0;
            iArr[5] = 0;
            iArr[4] = 0;
        } else if (length == 24) {
            iArr[0] = m34902a(bArr2, 0);
            iArr[1] = m34902a(bArr2, 4);
            iArr[2] = m34902a(bArr2, 8);
            iArr[3] = m34902a(bArr2, 12);
            iArr[4] = m34902a(bArr2, 16);
            iArr[5] = m34902a(bArr2, 20);
            iArr[6] = ~iArr[4];
            iArr[7] = ~iArr[5];
            camelliaLightEngine.f26594b = false;
        } else if (length == 32) {
            iArr[0] = m34902a(bArr2, 0);
            iArr[1] = m34902a(bArr2, 4);
            iArr[2] = m34902a(bArr2, 8);
            iArr[3] = m34902a(bArr2, 12);
            iArr[4] = m34902a(bArr2, 16);
            iArr[5] = m34902a(bArr2, 20);
            iArr[6] = m34902a(bArr2, 24);
            iArr[7] = m34902a(bArr2, 28);
            camelliaLightEngine.f26594b = false;
        } else {
            throw new IllegalArgumentException("key sizes are only 16/24/32 bytes.");
        }
        for (i = 0; i < 4; i++) {
            iArr2[i] = iArr[i] ^ iArr[i + 4];
        }
        m34906a(iArr2, f26591g, 0);
        for (i = 0; i < 4; i++) {
            iArr2[i] = iArr2[i] ^ iArr[i];
        }
        m34906a(iArr2, f26591g, 4);
        if (!camelliaLightEngine.f26594b) {
            for (i = 0; i < 4; i++) {
                iArr3[i] = iArr2[i] ^ iArr[i + 4];
            }
            m34906a(iArr3, f26591g, 8);
            if (z) {
                camelliaLightEngine.f26596d[0] = iArr[0];
                camelliaLightEngine.f26596d[1] = iArr[1];
                camelliaLightEngine.f26596d[2] = iArr[2];
                camelliaLightEngine.f26596d[3] = iArr[3];
                m34914c(45, iArr, 0, camelliaLightEngine.f26595c, 16);
                m34904a(15, iArr, 0, camelliaLightEngine.f26597e, 4);
                m34904a(17, iArr, 0, camelliaLightEngine.f26595c, 32);
                m34914c(34, iArr, 0, camelliaLightEngine.f26595c, 44);
                m34904a(15, iArr, 4, camelliaLightEngine.f26595c, 4);
                m34904a(15, iArr, 4, camelliaLightEngine.f26597e, 0);
                m34904a(30, iArr, 4, camelliaLightEngine.f26595c, 24);
                m34914c(34, iArr, 4, camelliaLightEngine.f26595c, 36);
                m34904a(15, iArr2, 0, camelliaLightEngine.f26595c, 8);
                m34904a(30, iArr2, 0, camelliaLightEngine.f26595c, 20);
                camelliaLightEngine.f26597e[8] = iArr2[1];
                camelliaLightEngine.f26597e[9] = iArr2[2];
                camelliaLightEngine.f26597e[10] = iArr2[3];
                camelliaLightEngine.f26597e[11] = iArr2[0];
                m34914c(49, iArr2, 0, camelliaLightEngine.f26595c, 40);
                camelliaLightEngine.f26595c[0] = iArr3[0];
                camelliaLightEngine.f26595c[1] = iArr3[1];
                camelliaLightEngine.f26595c[2] = iArr3[2];
                camelliaLightEngine.f26595c[3] = iArr3[3];
                m34904a(30, iArr3, 0, camelliaLightEngine.f26595c, 12);
                m34904a(30, iArr3, 0, camelliaLightEngine.f26595c, 28);
                m34914c(51, iArr3, 0, camelliaLightEngine.f26596d, 4);
                return;
            }
            camelliaLightEngine.f26596d[4] = iArr[0];
            camelliaLightEngine.f26596d[5] = iArr[1];
            camelliaLightEngine.f26596d[6] = iArr[2];
            camelliaLightEngine.f26596d[7] = iArr[3];
            m34915d(45, iArr, 0, camelliaLightEngine.f26595c, 28);
            m34910b(15, iArr, 0, camelliaLightEngine.f26597e, 4);
            m34910b(17, iArr, 0, camelliaLightEngine.f26595c, 12);
            m34915d(34, iArr, 0, camelliaLightEngine.f26595c, 0);
            m34910b(15, iArr, 4, camelliaLightEngine.f26595c, 40);
            m34910b(15, iArr, 4, camelliaLightEngine.f26597e, 8);
            m34910b(30, iArr, 4, camelliaLightEngine.f26595c, 20);
            m34915d(34, iArr, 4, camelliaLightEngine.f26595c, 8);
            m34910b(15, iArr2, 0, camelliaLightEngine.f26595c, 36);
            m34910b(30, iArr2, 0, camelliaLightEngine.f26595c, 24);
            camelliaLightEngine.f26597e[2] = iArr2[1];
            camelliaLightEngine.f26597e[3] = iArr2[2];
            camelliaLightEngine.f26597e[0] = iArr2[3];
            camelliaLightEngine.f26597e[1] = iArr2[0];
            m34915d(49, iArr2, 0, camelliaLightEngine.f26595c, 4);
            camelliaLightEngine.f26595c[46] = iArr3[0];
            camelliaLightEngine.f26595c[47] = iArr3[1];
            camelliaLightEngine.f26595c[44] = iArr3[2];
            camelliaLightEngine.f26595c[45] = iArr3[3];
            m34910b(30, iArr3, 0, camelliaLightEngine.f26595c, 32);
            m34910b(30, iArr3, 0, camelliaLightEngine.f26595c, 16);
            m34914c(51, iArr3, 0, camelliaLightEngine.f26596d, 0);
        } else if (z) {
            camelliaLightEngine.f26596d[0] = iArr[0];
            camelliaLightEngine.f26596d[1] = iArr[1];
            camelliaLightEngine.f26596d[2] = iArr[2];
            camelliaLightEngine.f26596d[3] = iArr[3];
            m34904a(15, iArr, 0, camelliaLightEngine.f26595c, 4);
            m34904a(30, iArr, 0, camelliaLightEngine.f26595c, 12);
            m34904a(15, iArr, 0, iArr4, 0);
            camelliaLightEngine.f26595c[18] = iArr4[2];
            camelliaLightEngine.f26595c[19] = iArr4[3];
            m34904a(17, iArr, 0, camelliaLightEngine.f26597e, 4);
            m34904a(17, iArr, 0, camelliaLightEngine.f26595c, 24);
            m34904a(17, iArr, 0, camelliaLightEngine.f26595c, 32);
            camelliaLightEngine.f26595c[0] = iArr2[0];
            camelliaLightEngine.f26595c[1] = iArr2[1];
            camelliaLightEngine.f26595c[2] = iArr2[2];
            camelliaLightEngine.f26595c[3] = iArr2[3];
            m34904a(15, iArr2, 0, camelliaLightEngine.f26595c, 8);
            m34904a(15, iArr2, 0, camelliaLightEngine.f26597e, 0);
            m34904a(15, iArr2, 0, iArr4, 0);
            camelliaLightEngine.f26595c[16] = iArr4[0];
            camelliaLightEngine.f26595c[17] = iArr4[1];
            m34904a(15, iArr2, 0, camelliaLightEngine.f26595c, 20);
            m34914c(34, iArr2, 0, camelliaLightEngine.f26595c, 28);
            m34904a(17, iArr2, 0, camelliaLightEngine.f26596d, 4);
        } else {
            camelliaLightEngine.f26596d[4] = iArr[0];
            camelliaLightEngine.f26596d[5] = iArr[1];
            camelliaLightEngine.f26596d[6] = iArr[2];
            camelliaLightEngine.f26596d[7] = iArr[3];
            m34910b(15, iArr, 0, camelliaLightEngine.f26595c, 28);
            m34910b(30, iArr, 0, camelliaLightEngine.f26595c, 20);
            m34910b(15, iArr, 0, iArr4, 0);
            camelliaLightEngine.f26595c[16] = iArr4[0];
            camelliaLightEngine.f26595c[17] = iArr4[1];
            m34910b(17, iArr, 0, camelliaLightEngine.f26597e, 0);
            m34910b(17, iArr, 0, camelliaLightEngine.f26595c, 8);
            m34910b(17, iArr, 0, camelliaLightEngine.f26595c, 0);
            camelliaLightEngine.f26595c[34] = iArr2[0];
            camelliaLightEngine.f26595c[35] = iArr2[1];
            camelliaLightEngine.f26595c[32] = iArr2[2];
            camelliaLightEngine.f26595c[33] = iArr2[3];
            m34910b(15, iArr2, 0, camelliaLightEngine.f26595c, 24);
            m34910b(15, iArr2, 0, camelliaLightEngine.f26597e, 4);
            m34910b(15, iArr2, 0, iArr4, 0);
            camelliaLightEngine.f26595c[18] = iArr4[2];
            camelliaLightEngine.f26595c[19] = iArr4[3];
            m34910b(15, iArr2, 0, camelliaLightEngine.f26595c, 12);
            m34915d(34, iArr2, 0, camelliaLightEngine.f26595c, 4);
            m34904a(17, iArr2, 0, camelliaLightEngine.f26596d, 0);
        }
    }

    /* renamed from: b */
    private int m34909b(byte[] bArr, int i, byte[] bArr2, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            this.f26598f[i3] = m34902a(bArr, (i3 * 4) + i);
            int[] iArr = this.f26598f;
            iArr[i3] = iArr[i3] ^ this.f26596d[i3];
        }
        m34906a(this.f26598f, this.f26595c, 0);
        m34906a(this.f26598f, this.f26595c, 4);
        m34906a(this.f26598f, this.f26595c, 8);
        m34911b(this.f26598f, this.f26597e, 0);
        m34906a(this.f26598f, this.f26595c, 12);
        m34906a(this.f26598f, this.f26595c, 16);
        m34906a(this.f26598f, this.f26595c, 20);
        m34911b(this.f26598f, this.f26597e, 4);
        m34906a(this.f26598f, this.f26595c, 24);
        m34906a(this.f26598f, this.f26595c, 28);
        m34906a(this.f26598f, this.f26595c, 32);
        bArr = this.f26598f;
        bArr[2] = this.f26596d[4] ^ bArr[2];
        bArr = this.f26598f;
        bArr[3] = bArr[3] ^ this.f26596d[5];
        bArr = this.f26598f;
        bArr[0] = bArr[0] ^ this.f26596d[6];
        bArr = this.f26598f;
        bArr[1] = bArr[1] ^ this.f26596d[7];
        m34903a(this.f26598f[2], bArr2, i2);
        m34903a(this.f26598f[3], bArr2, i2 + 4);
        m34903a(this.f26598f[0], bArr2, i2 + 8);
        m34903a(this.f26598f[1], bArr2, i2 + 12);
        return 16;
    }

    /* renamed from: c */
    private int m34913c(byte[] bArr, int i, byte[] bArr2, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            this.f26598f[i3] = m34902a(bArr, (i3 * 4) + i);
            int[] iArr = this.f26598f;
            iArr[i3] = iArr[i3] ^ this.f26596d[i3];
        }
        m34906a(this.f26598f, this.f26595c, 0);
        m34906a(this.f26598f, this.f26595c, 4);
        m34906a(this.f26598f, this.f26595c, 8);
        m34911b(this.f26598f, this.f26597e, 0);
        m34906a(this.f26598f, this.f26595c, 12);
        m34906a(this.f26598f, this.f26595c, 16);
        m34906a(this.f26598f, this.f26595c, 20);
        m34911b(this.f26598f, this.f26597e, 4);
        m34906a(this.f26598f, this.f26595c, 24);
        m34906a(this.f26598f, this.f26595c, 28);
        m34906a(this.f26598f, this.f26595c, 32);
        m34911b(this.f26598f, this.f26597e, 8);
        m34906a(this.f26598f, this.f26595c, 36);
        m34906a(this.f26598f, this.f26595c, 40);
        m34906a(this.f26598f, this.f26595c, 44);
        bArr = this.f26598f;
        bArr[2] = bArr[2] ^ this.f26596d[4];
        bArr = this.f26598f;
        bArr[3] = bArr[3] ^ this.f26596d[5];
        bArr = this.f26598f;
        bArr[0] = bArr[0] ^ this.f26596d[6];
        bArr = this.f26598f;
        bArr[1] = bArr[1] ^ this.f26596d[7];
        m34903a(this.f26598f[2], bArr2, i2);
        m34903a(this.f26598f[3], bArr2, i2 + 4);
        m34903a(this.f26598f[0], bArr2, i2 + 8);
        m34903a(this.f26598f[1], bArr2, i2 + 12);
        return 16;
    }

    /* renamed from: a */
    public void mo5742a(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            m34905a(z, ((KeyParameter) cipherParameters).m35685a());
            this.f26593a = true;
            return;
        }
        throw new IllegalArgumentException("only simple KeyParameter expected.");
    }

    /* renamed from: a */
    public int mo5740a(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (!this.f26593a) {
            throw new IllegalStateException("Camellia is not initialized");
        } else if (i + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 16 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        } else if (this.f26594b) {
            return m34909b(bArr, i, bArr2, i2);
        } else {
            return m34913c(bArr, i, bArr2, i2);
        }
    }
}
