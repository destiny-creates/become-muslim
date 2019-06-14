package org.spongycastle.crypto.engines;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;

public class Shacal2Engine implements BlockCipher {
    /* renamed from: a */
    private static final int[] f26785a = new int[]{1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};
    /* renamed from: b */
    private boolean f26786b = false;
    /* renamed from: c */
    private int[] f26787c = null;

    /* renamed from: a */
    public String mo5741a() {
        return "Shacal2";
    }

    /* renamed from: b */
    public int mo5743b() {
        return 32;
    }

    /* renamed from: c */
    public void mo5744c() {
    }

    /* renamed from: a */
    public void mo5742a(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.f26786b = z;
            this.f26787c = new int[true];
            m35233a(((KeyParameter) cipherParameters).m35685a());
            return;
        }
        throw new IllegalArgumentException("only simple KeyParameter expected.");
    }

    /* renamed from: a */
    public void m35233a(byte[] bArr) {
        if (bArr.length != 0 && bArr.length <= 64) {
            int i = 16;
            if (bArr.length >= 16 && bArr.length % 8 == 0) {
                m35228b(bArr, this.f26787c, 0, 0);
                while (i < 64) {
                    int i2 = i - 2;
                    int i3 = i - 15;
                    this.f26787c[i] = ((((((this.f26787c[i2] >>> 17) | (this.f26787c[i2] << -17)) ^ ((this.f26787c[i2] >>> 19) | (this.f26787c[i2] << -19))) ^ (this.f26787c[i2] >>> 10)) + this.f26787c[i - 7]) + ((((this.f26787c[i3] >>> 7) | (this.f26787c[i3] << -7)) ^ ((this.f26787c[i3] >>> 18) | (this.f26787c[i3] << -18))) ^ (this.f26787c[i3] >>> 3))) + this.f26787c[i - 16];
                    i++;
                }
                return;
            }
        }
        throw new IllegalArgumentException("Shacal2-key must be 16 - 64 bytes and multiple of 8");
    }

    /* renamed from: b */
    private void m35227b(byte[] bArr, int i, byte[] bArr2, int i2) {
        int[] iArr = new int[8];
        m35225a(bArr, iArr, i, 0);
        for (bArr = null; bArr < 64; bArr++) {
            int i3 = (((((((iArr[4] >>> 6) | (iArr[4] << -6)) ^ ((iArr[4] >>> 11) | (iArr[4] << -11))) ^ ((iArr[4] >>> 25) | (iArr[4] << -25))) + ((iArr[4] & iArr[5]) ^ ((~iArr[4]) & iArr[6]))) + iArr[7]) + f26785a[bArr]) + this.f26787c[bArr];
            iArr[7] = iArr[6];
            iArr[6] = iArr[5];
            iArr[5] = iArr[4];
            iArr[4] = iArr[3] + i3;
            iArr[3] = iArr[2];
            iArr[2] = iArr[1];
            iArr[1] = iArr[0];
            iArr[0] = (i3 + ((((iArr[0] >>> 2) | (iArr[0] << -2)) ^ ((iArr[0] >>> 13) | (iArr[0] << -13))) ^ ((iArr[0] >>> 22) | (iArr[0] << -22)))) + ((iArr[2] & iArr[3]) ^ ((iArr[0] & iArr[2]) ^ (iArr[0] & iArr[3])));
        }
        m35226a(iArr, bArr2, i2);
    }

    /* renamed from: c */
    private void m35229c(byte[] bArr, int i, byte[] bArr2, int i2) {
        int[] iArr = new int[8];
        m35225a(bArr, iArr, i, 0);
        for (bArr = 63; bArr > -1; bArr--) {
            i = (iArr[0] - ((((iArr[1] >>> 2) | (iArr[1] << -2)) ^ ((iArr[1] >>> 13) | (iArr[1] << -13))) ^ ((iArr[1] >>> 22) | (iArr[1] << -22)))) - (((iArr[1] & iArr[2]) ^ (iArr[1] & iArr[3])) ^ (iArr[2] & iArr[3]));
            iArr[0] = iArr[1];
            iArr[1] = iArr[2];
            iArr[2] = iArr[3];
            iArr[3] = iArr[4] - i;
            iArr[4] = iArr[5];
            iArr[5] = iArr[6];
            iArr[6] = iArr[7];
            iArr[7] = (((i - f26785a[bArr]) - this.f26787c[bArr]) - ((((iArr[4] >>> 6) | (iArr[4] << -6)) ^ ((iArr[4] >>> 11) | (iArr[4] << -11))) ^ ((iArr[4] >>> 25) | (iArr[4] << -25)))) - (((~iArr[4]) & iArr[6]) ^ (iArr[5] & iArr[4]));
        }
        m35226a(iArr, bArr2, i2);
    }

    /* renamed from: a */
    public int mo5740a(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.f26787c == null) {
            throw new IllegalStateException("Shacal2 not initialised");
        } else if (i + 32 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 32 <= bArr2.length) {
            if (this.f26786b) {
                m35227b(bArr, i, bArr2, i2);
            } else {
                m35229c(bArr, i, bArr2, i2);
            }
            return 32;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    /* renamed from: a */
    private void m35225a(byte[] bArr, int[] iArr, int i, int i2) {
        while (i2 < 8) {
            int i3 = i + 1;
            int i4 = i3 + 1;
            i = ((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) << 24) | ((bArr[i3] & JfifUtil.MARKER_FIRST_BYTE) << 16);
            i3 = i4 + 1;
            int i5 = i3 + 1;
            iArr[i2] = (i | ((bArr[i4] & JfifUtil.MARKER_FIRST_BYTE) << 8)) | (bArr[i3] & JfifUtil.MARKER_FIRST_BYTE);
            i2++;
            i = i5;
        }
    }

    /* renamed from: b */
    private void m35228b(byte[] bArr, int[] iArr, int i, int i2) {
        while (i2 < bArr.length / 4) {
            int i3 = i + 1;
            int i4 = i3 + 1;
            i = ((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) << 24) | ((bArr[i3] & JfifUtil.MARKER_FIRST_BYTE) << 16);
            i3 = i4 + 1;
            i |= (bArr[i4] & JfifUtil.MARKER_FIRST_BYTE) << 8;
            i4 = i3 + 1;
            iArr[i2] = i | (bArr[i3] & JfifUtil.MARKER_FIRST_BYTE);
            i2++;
            i = i4;
        }
    }

    /* renamed from: a */
    private void m35226a(int[] iArr, byte[] bArr, int i) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int i3 = i + 1;
            bArr[i] = (byte) (iArr[i2] >>> 24);
            i = i3 + 1;
            bArr[i3] = (byte) (iArr[i2] >>> 16);
            i3 = i + 1;
            bArr[i] = (byte) (iArr[i2] >>> 8);
            i = i3 + 1;
            bArr[i3] = (byte) iArr[i2];
        }
    }
}
