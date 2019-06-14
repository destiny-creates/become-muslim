package org.spongycastle.crypto.engines;

import com.facebook.imageutils.JfifUtil;
import com.facebook.stetho.dumpapp.Framer;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Pack;

public class SM4Engine implements BlockCipher {
    /* renamed from: a */
    private static final byte[] f26774a = new byte[]{(byte) -42, (byte) -112, (byte) -23, (byte) -2, (byte) -52, (byte) -31, (byte) 61, (byte) -73, (byte) 22, (byte) -74, (byte) 20, (byte) -62, (byte) 40, (byte) -5, (byte) 44, (byte) 5, (byte) 43, (byte) 103, (byte) -102, (byte) 118, (byte) 42, (byte) -66, (byte) 4, (byte) -61, (byte) -86, (byte) 68, (byte) 19, (byte) 38, (byte) 73, (byte) -122, (byte) 6, (byte) -103, (byte) -100, (byte) 66, (byte) 80, (byte) -12, (byte) -111, (byte) -17, (byte) -104, (byte) 122, (byte) 51, (byte) 84, (byte) 11, (byte) 67, (byte) -19, (byte) -49, (byte) -84, (byte) 98, (byte) -28, (byte) -77, (byte) 28, (byte) -87, (byte) -55, (byte) 8, (byte) -24, (byte) -107, Byte.MIN_VALUE, (byte) -33, (byte) -108, (byte) -6, (byte) 117, (byte) -113, (byte) 63, (byte) -90, (byte) 71, (byte) 7, (byte) -89, (byte) -4, (byte) -13, (byte) 115, (byte) 23, (byte) -70, (byte) -125, (byte) 89, (byte) 60, (byte) 25, (byte) -26, (byte) -123, (byte) 79, (byte) -88, (byte) 104, (byte) 107, (byte) -127, (byte) -78, (byte) 113, (byte) 100, (byte) -38, (byte) -117, (byte) -8, (byte) -21, (byte) 15, (byte) 75, (byte) 112, (byte) 86, (byte) -99, (byte) 53, (byte) 30, (byte) 36, (byte) 14, (byte) 94, (byte) 99, (byte) 88, (byte) -47, (byte) -94, (byte) 37, (byte) 34, (byte) 124, (byte) 59, (byte) 1, Framer.ENTER_FRAME_PREFIX, Framer.EXIT_FRAME_PREFIX, (byte) -121, (byte) -44, (byte) 0, (byte) 70, (byte) 87, (byte) -97, (byte) -45, (byte) 39, (byte) 82, (byte) 76, (byte) 54, (byte) 2, (byte) -25, (byte) -96, (byte) -60, (byte) -56, (byte) -98, (byte) -22, (byte) -65, (byte) -118, (byte) -46, (byte) 64, (byte) -57, (byte) 56, (byte) -75, (byte) -93, (byte) -9, (byte) -14, (byte) -50, (byte) -7, (byte) 97, (byte) 21, (byte) -95, (byte) -32, (byte) -82, (byte) 93, (byte) -92, (byte) -101, (byte) 52, (byte) 26, (byte) 85, (byte) -83, (byte) -109, Framer.STDERR_FRAME_PREFIX, (byte) 48, (byte) -11, (byte) -116, (byte) -79, (byte) -29, (byte) 29, (byte) -10, (byte) -30, (byte) 46, (byte) -126, (byte) 102, (byte) -54, (byte) 96, (byte) -64, (byte) 41, (byte) 35, (byte) -85, (byte) 13, (byte) 83, (byte) 78, (byte) 111, (byte) -43, (byte) -37, (byte) 55, (byte) 69, (byte) -34, (byte) -3, (byte) -114, (byte) 47, (byte) 3, (byte) -1, (byte) 106, (byte) 114, (byte) 109, (byte) 108, (byte) 91, (byte) 81, (byte) -115, (byte) 27, (byte) -81, (byte) -110, (byte) -69, (byte) -35, (byte) -68, Byte.MAX_VALUE, (byte) 17, (byte) -39, (byte) 92, (byte) 65, (byte) 31, (byte) 16, (byte) 90, (byte) -40, (byte) 10, (byte) -63, Framer.STDOUT_FRAME_PREFIX, (byte) -120, (byte) -91, (byte) -51, (byte) 123, (byte) -67, Framer.STDIN_FRAME_PREFIX, (byte) 116, (byte) -48, (byte) 18, (byte) -72, (byte) -27, (byte) -76, (byte) -80, (byte) -119, (byte) 105, (byte) -105, (byte) 74, (byte) 12, (byte) -106, (byte) 119, (byte) 126, (byte) 101, (byte) -71, (byte) -15, (byte) 9, (byte) -59, (byte) 110, (byte) -58, (byte) -124, (byte) 24, (byte) -16, (byte) 125, (byte) -20, (byte) 58, (byte) -36, (byte) 77, (byte) 32, (byte) 121, (byte) -18, Framer.STDIN_REQUEST_FRAME_PREFIX, (byte) 62, (byte) -41, (byte) -53, (byte) 57, (byte) 72};
    /* renamed from: b */
    private static final int[] f26775b = new int[]{462357, 472066609, 943670861, 1415275113, 1886879365, -1936483679, -1464879427, -993275175, -521670923, -66909679, 404694573, 876298825, 1347903077, 1819507329, -2003855715, -1532251463, -1060647211, -589042959, -117504499, 337322537, 808926789, 1280531041, 1752135293, -2071227751, -1599623499, -1128019247, -656414995, -184876535, 269950501, 741554753, 1213159005, 1684763257};
    /* renamed from: c */
    private static final int[] f26776c = new int[]{-1548633402, 1453994832, 1736282519, -1301273892};
    /* renamed from: d */
    private final int[] f26777d = new int[4];
    /* renamed from: e */
    private int[] f26778e;

    /* renamed from: a */
    private int m35179a(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }

    /* renamed from: a */
    public String mo5741a() {
        return "SM4";
    }

    /* renamed from: b */
    public int mo5743b() {
        return 16;
    }

    /* renamed from: c */
    public void mo5744c() {
    }

    /* renamed from: a */
    private int m35178a(int i) {
        return (f26774a[i & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) | ((((f26774a[(i >> 24) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 24) | ((f26774a[(i >> 16) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 16)) | ((f26774a[(i >> 8) & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE) << 8));
    }

    /* renamed from: b */
    private int m35182b(int i) {
        return m35179a(i, 23) ^ (m35179a(i, 13) ^ i);
    }

    /* renamed from: c */
    private int m35184c(int i) {
        return m35182b(m35178a(i));
    }

    /* renamed from: a */
    private int[] m35181a(boolean z, byte[] bArr) {
        int[] iArr = new int[32];
        int i = 4;
        int[] iArr2 = new int[]{Pack.m29399a(bArr, 0), Pack.m29399a(bArr, 4), Pack.m29399a(bArr, 8), Pack.m29399a(bArr, 12)};
        bArr = new int[]{iArr2[0] ^ f26776c[0], iArr2[1] ^ f26776c[1], iArr2[2] ^ f26776c[2], iArr2[3] ^ f26776c[3]};
        if (z) {
            iArr[0] = bArr[0] ^ m35184c(((bArr[1] ^ bArr[2]) ^ bArr[3]) ^ f26775b[0]);
            iArr[1] = bArr[1] ^ m35184c(((bArr[2] ^ bArr[3]) ^ iArr[0]) ^ f26775b[1]);
            iArr[2] = bArr[2] ^ m35184c(((bArr[3] ^ iArr[0]) ^ iArr[1]) ^ f26775b[2]);
            iArr[3] = bArr[3] ^ m35184c(((iArr[0] ^ iArr[1]) ^ iArr[2]) ^ f26775b[3]);
            while (i < 32) {
                iArr[i] = iArr[i - 4] ^ m35184c(((iArr[i - 3] ^ iArr[i - 2]) ^ iArr[i - 1]) ^ f26775b[i]);
                i++;
            }
        } else {
            iArr[31] = bArr[0] ^ m35184c(((bArr[1] ^ bArr[2]) ^ bArr[3]) ^ f26775b[0]);
            iArr[30] = bArr[1] ^ m35184c(((bArr[2] ^ bArr[3]) ^ iArr[31]) ^ f26775b[1]);
            iArr[29] = bArr[2] ^ m35184c(((bArr[3] ^ iArr[31]) ^ iArr[30]) ^ f26775b[2]);
            iArr[true] = bArr[3] ^ m35184c(((iArr[30] ^ iArr[31]) ^ iArr[29]) ^ f26775b[3]);
            for (z = true; z < false; z--) {
                iArr[z] = iArr[z + 4] ^ m35184c(((iArr[z + 3] ^ iArr[z + 2]) ^ iArr[z + 1]) ^ f26775b[31 - z]);
            }
        }
        return iArr;
    }

    /* renamed from: d */
    private int m35186d(int i) {
        return m35179a(i, 24) ^ (((m35179a(i, 2) ^ i) ^ m35179a(i, 10)) ^ m35179a(i, 18));
    }

    /* renamed from: e */
    private int m35188e(int i) {
        return m35186d(m35178a(i));
    }

    /* renamed from: a */
    private void m35180a(int[] iArr, int i) {
        int i2 = i + 1;
        int i3 = i + 2;
        int i4 = i + 3;
        iArr[i] = iArr[i] ^ iArr[i4];
        iArr[i4] = iArr[i] ^ iArr[i4];
        iArr[i] = iArr[i4] ^ iArr[i];
        iArr[i2] = iArr[i2] ^ iArr[i3];
        iArr[i3] = iArr[i2] ^ iArr[i3];
        iArr[i2] = iArr[i2] ^ iArr[i3];
    }

    /* renamed from: b */
    private int m35183b(int[] iArr, int i) {
        return m35188e((iArr[3] ^ (iArr[1] ^ iArr[2])) ^ i) ^ iArr[0];
    }

    /* renamed from: c */
    private int m35185c(int[] iArr, int i) {
        return m35188e((iArr[0] ^ (iArr[2] ^ iArr[3])) ^ i) ^ iArr[1];
    }

    /* renamed from: d */
    private int m35187d(int[] iArr, int i) {
        return m35188e((iArr[1] ^ (iArr[3] ^ iArr[0])) ^ i) ^ iArr[2];
    }

    /* renamed from: e */
    private int m35189e(int[] iArr, int i) {
        return m35188e((iArr[2] ^ (iArr[0] ^ iArr[1])) ^ i) ^ iArr[3];
    }

    /* renamed from: a */
    public void mo5742a(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            byte[] a = ((KeyParameter) cipherParameters).m35685a();
            if (a.length == 16) {
                this.f26778e = m35181a(z, a);
                return;
            }
            throw new IllegalArgumentException("SM4 requires a 128 bit key");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("invalid parameter passed to SM4 init - ");
        stringBuilder.append(cipherParameters.getClass().getName());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public int mo5740a(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.f26778e == null) {
            throw new IllegalStateException("SM4 not initialised");
        } else if (i + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 16 <= bArr2.length) {
            this.f26777d[0] = Pack.m29399a(bArr, i);
            this.f26777d[1] = Pack.m29399a(bArr, i + 4);
            this.f26777d[2] = Pack.m29399a(bArr, i + 8);
            this.f26777d[3] = Pack.m29399a(bArr, i + 12);
            for (bArr = null; bArr < 32; bArr += 4) {
                this.f26777d[0] = m35183b(this.f26777d, this.f26778e[bArr]);
                this.f26777d[1] = m35185c(this.f26777d, this.f26778e[bArr + 1]);
                this.f26777d[2] = m35187d(this.f26777d, this.f26778e[bArr + 2]);
                this.f26777d[3] = m35189e(this.f26777d, this.f26778e[bArr + 3]);
            }
            m35180a(this.f26777d, 0);
            Pack.m29400a(this.f26777d[0], bArr2, i2);
            Pack.m29400a(this.f26777d[1], bArr2, i2 + 4);
            Pack.m29400a(this.f26777d[2], bArr2, i2 + 8);
            Pack.m29400a(this.f26777d[3], bArr2, i2 + 12);
            return 16;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }
}
