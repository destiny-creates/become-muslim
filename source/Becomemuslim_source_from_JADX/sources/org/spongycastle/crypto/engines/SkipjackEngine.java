package org.spongycastle.crypto.engines;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;

public class SkipjackEngine implements BlockCipher {
    /* renamed from: a */
    static short[] f26788a = new short[]{(short) 163, (short) 215, (short) 9, (short) 131, (short) 248, (short) 72, (short) 246, (short) 244, (short) 179, (short) 33, (short) 21, (short) 120, (short) 153, (short) 177, (short) 175, (short) 249, (short) 231, (short) 45, (short) 77, (short) 138, (short) 206, (short) 76, (short) 202, (short) 46, (short) 82, (short) 149, (short) 217, (short) 30, (short) 78, (short) 56, (short) 68, (short) 40, (short) 10, (short) 223, (short) 2, (short) 160, (short) 23, (short) 241, (short) 96, (short) 104, (short) 18, (short) 183, (short) 122, (short) 195, (short) 233, (short) 250, (short) 61, (short) 83, (short) 150, (short) 132, (short) 107, (short) 186, (short) 242, (short) 99, (short) 154, (short) 25, (short) 124, (short) 174, (short) 229, (short) 245, (short) 247, (short) 22, (short) 106, (short) 162, (short) 57, (short) 182, (short) 123, (short) 15, (short) 193, (short) 147, (short) 129, (short) 27, (short) 238, (short) 180, (short) 26, (short) 234, (short) 208, (short) 145, (short) 47, (short) 184, (short) 85, (short) 185, (short) 218, (short) 133, (short) 63, (short) 65, (short) 191, (short) 224, (short) 90, (short) 88, (short) 128, (short) 95, (short) 102, (short) 11, (short) 216, (short) 144, (short) 53, (short) 213, (short) 192, (short) 167, (short) 51, (short) 6, (short) 101, (short) 105, (short) 69, (short) 0, (short) 148, (short) 86, (short) 109, (short) 152, (short) 155, (short) 118, (short) 151, (short) 252, (short) 178, (short) 194, (short) 176, (short) 254, (short) 219, (short) 32, (short) 225, (short) 235, (short) 214, (short) 228, (short) 221, (short) 71, (short) 74, (short) 29, (short) 66, (short) 237, (short) 158, (short) 110, (short) 73, (short) 60, (short) 205, (short) 67, (short) 39, (short) 210, (short) 7, (short) 212, (short) 222, (short) 199, (short) 103, (short) 24, (short) 137, (short) 203, (short) 48, (short) 31, (short) 141, (short) 198, (short) 143, (short) 170, (short) 200, (short) 116, (short) 220, (short) 201, (short) 93, (short) 92, (short) 49, (short) 164, (short) 112, (short) 136, (short) 97, (short) 44, (short) 159, (short) 13, (short) 43, (short) 135, (short) 80, (short) 130, (short) 84, (short) 100, (short) 38, (short) 125, (short) 3, (short) 64, (short) 52, (short) 75, (short) 28, (short) 115, (short) 209, (short) 196, (short) 253, (short) 59, (short) 204, (short) 251, (short) 127, (short) 171, (short) 230, (short) 62, (short) 91, (short) 165, (short) 173, (short) 4, (short) 35, (short) 156, (short) 20, (short) 81, (short) 34, (short) 240, (short) 41, (short) 121, (short) 113, (short) 126, (short) 255, (short) 140, (short) 14, (short) 226, (short) 12, (short) 239, (short) 188, (short) 114, (short) 117, (short) 111, (short) 55, (short) 161, (short) 236, (short) 211, (short) 142, (short) 98, (short) 139, (short) 134, (short) 16, (short) 232, (short) 8, (short) 119, (short) 17, (short) 190, (short) 146, (short) 79, (short) 36, (short) 197, (short) 50, (short) 54, (short) 157, (short) 207, (short) 243, (short) 166, (short) 187, (short) 172, (short) 94, (short) 108, (short) 169, (short) 19, (short) 87, (short) 37, (short) 181, (short) 227, (short) 189, (short) 168, (short) 58, (short) 1, (short) 5, (short) 89, (short) 42, (short) 70};
    /* renamed from: b */
    private int[] f26789b;
    /* renamed from: c */
    private int[] f26790c;
    /* renamed from: d */
    private int[] f26791d;
    /* renamed from: e */
    private int[] f26792e;
    /* renamed from: f */
    private boolean f26793f;

    /* renamed from: a */
    public String mo5741a() {
        return "SKIPJACK";
    }

    /* renamed from: b */
    public int mo5743b() {
        return 8;
    }

    /* renamed from: c */
    public void mo5744c() {
    }

    /* renamed from: a */
    public void mo5742a(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            cipherParameters = ((KeyParameter) cipherParameters).m35685a();
            this.f26793f = z;
            this.f26789b = new int[32];
            this.f26790c = new int[32];
            this.f26791d = new int[32];
            this.f26792e = new int[32];
            for (int i = 0; i < 32; i++) {
                int i2 = i * 4;
                this.f26789b[i] = cipherParameters[i2 % 10] & JfifUtil.MARKER_FIRST_BYTE;
                this.f26790c[i] = cipherParameters[(i2 + 1) % 10] & JfifUtil.MARKER_FIRST_BYTE;
                this.f26791d[i] = cipherParameters[(i2 + 2) % 10] & JfifUtil.MARKER_FIRST_BYTE;
                this.f26792e[i] = cipherParameters[(i2 + 3) % 10] & JfifUtil.MARKER_FIRST_BYTE;
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("invalid parameter passed to SKIPJACK init - ");
        stringBuilder.append(cipherParameters.getClass().getName());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public int mo5740a(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.f26790c == null) {
            throw new IllegalStateException("SKIPJACK engine not initialised");
        } else if (i + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 8 <= bArr2.length) {
            if (this.f26793f) {
                m35242b(bArr, i, bArr2, i2);
            } else {
                m35243c(bArr, i, bArr2, i2);
            }
            return 8;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    /* renamed from: a */
    private int m35236a(int i, int i2) {
        i2 &= JfifUtil.MARKER_FIRST_BYTE;
        int i3 = ((i2 >> 8) & JfifUtil.MARKER_FIRST_BYTE) ^ f26788a[this.f26789b[i] ^ i2];
        i2 ^= f26788a[this.f26790c[i] ^ i3];
        i3 ^= f26788a[this.f26791d[i] ^ i2];
        return (i3 << 8) + (f26788a[this.f26792e[i] ^ i3] ^ i2);
    }

    /* renamed from: b */
    public int m35242b(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = (bArr[i + 0] << 8) + (bArr[i + 1] & JfifUtil.MARKER_FIRST_BYTE);
        int i4 = (bArr[i + 2] << 8) + (bArr[i + 3] & JfifUtil.MARKER_FIRST_BYTE);
        int i5 = (bArr[i + 4] << 8) + (bArr[i + 5] & JfifUtil.MARKER_FIRST_BYTE);
        int i6 = (bArr[i + 6] << 8) + (bArr[i + 7] & JfifUtil.MARKER_FIRST_BYTE);
        i = 0;
        int i7 = 0;
        while (i < 2) {
            int i8 = i3;
            i3 = 0;
            while (i3 < 8) {
                i8 = m35236a(i7, i8);
                i7++;
                i3++;
                int i9 = i5;
                i5 = i4;
                i4 = i8;
                i8 = (i6 ^ i8) ^ i7;
                i6 = i9;
            }
            i3 = 0;
            while (i3 < 8) {
                int i10 = i7 + 1;
                i4 = (i4 ^ i8) ^ i10;
                i7 = m35236a(i7, i8);
                i3++;
                i8 = i6;
                i6 = i5;
                i5 = i4;
                i4 = i7;
                i7 = i10;
            }
            i++;
            i3 = i8;
        }
        bArr2[i2 + 0] = (byte) (i3 >> 8);
        bArr2[i2 + 1] = (byte) i3;
        bArr2[i2 + 2] = (byte) (i4 >> 8);
        bArr2[i2 + 3] = (byte) i4;
        bArr2[i2 + 4] = (byte) (i5 >> 8);
        bArr2[i2 + 5] = (byte) i5;
        bArr2[i2 + 6] = (byte) (i6 >> 8);
        bArr2[i2 + 7] = (byte) i6;
        return 8;
    }

    /* renamed from: b */
    private int m35237b(int i, int i2) {
        int i3 = i2 & JfifUtil.MARKER_FIRST_BYTE;
        i2 = (i2 >> 8) & JfifUtil.MARKER_FIRST_BYTE;
        i3 ^= f26788a[this.f26792e[i] ^ i2];
        i2 ^= f26788a[this.f26791d[i] ^ i3];
        i3 ^= f26788a[this.f26790c[i] ^ i2];
        return ((f26788a[this.f26789b[i] ^ i3] ^ i2) << 8) + i3;
    }

    /* renamed from: c */
    public int m35243c(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = (bArr[i + 0] << 8) + (bArr[i + 1] & JfifUtil.MARKER_FIRST_BYTE);
        int i4 = (bArr[i + 2] << 8) + (bArr[i + 3] & JfifUtil.MARKER_FIRST_BYTE);
        int i5 = (bArr[i + 4] << 8) + (bArr[i + 5] & JfifUtil.MARKER_FIRST_BYTE);
        int i6 = (bArr[i + 6] << 8) + (bArr[i + 7] & JfifUtil.MARKER_FIRST_BYTE);
        i = 0;
        int i7 = 31;
        while (i < 2) {
            int i8;
            int i9 = i4;
            i4 = i3;
            i3 = 0;
            while (i3 < 8) {
                i9 = m35237b(i7, i9);
                i7--;
                i3++;
                i8 = i6;
                i6 = i4;
                i4 = i9;
                i9 = (i5 ^ i9) ^ (i7 + 1);
                i5 = i8;
            }
            i3 = 0;
            i8 = i7;
            i7 = i4;
            i4 = i9;
            i9 = i8;
            while (i3 < 8) {
                i7 = (i7 ^ i4) ^ (i9 + 1);
                i4 = m35237b(i9, i4);
                i9--;
                i3++;
                i8 = i7;
                i7 = i4;
                i4 = i5;
                i5 = i6;
                i6 = i8;
            }
            i++;
            i3 = i7;
            i7 = i9;
        }
        bArr2[i2 + 0] = (byte) (i3 >> 8);
        bArr2[i2 + 1] = (byte) i3;
        bArr2[i2 + 2] = (byte) (i4 >> 8);
        bArr2[i2 + 3] = (byte) i4;
        bArr2[i2 + 4] = (byte) (i5 >> 8);
        bArr2[i2 + 5] = (byte) i5;
        bArr2[i2 + 6] = (byte) (i6 >> 8);
        bArr2[i2 + 7] = (byte) i6;
        return 8;
    }
}
