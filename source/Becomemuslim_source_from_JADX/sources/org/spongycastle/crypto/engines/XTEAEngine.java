package org.spongycastle.crypto.engines;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;

public class XTEAEngine implements BlockCipher {
    /* renamed from: a */
    private int[] f26826a = new int[4];
    /* renamed from: b */
    private int[] f26827b = new int[32];
    /* renamed from: c */
    private int[] f26828c = new int[32];
    /* renamed from: d */
    private boolean f26829d = false;
    /* renamed from: e */
    private boolean f26830e;

    /* renamed from: a */
    public String mo5741a() {
        return "XTEA";
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
            this.f26830e = z;
            this.f26829d = true;
            m35309a(((KeyParameter) cipherParameters).m35685a());
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("invalid parameter passed to TEA init - ");
        stringBuilder.append(cipherParameters.getClass().getName());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public int mo5740a(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (!this.f26829d) {
            i = new StringBuilder();
            i.append(mo5741a());
            i.append(" not initialised");
            throw new IllegalStateException(i.toString());
        } else if (i + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 8 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        } else if (this.f26830e) {
            return m35310b(bArr, i, bArr2, i2);
        } else {
            return m35311c(bArr, i, bArr2, i2);
        }
    }

    /* renamed from: a */
    private void m35309a(byte[] bArr) {
        if (bArr.length == 16) {
            int i = 0;
            int i2 = 0;
            while (i < 4) {
                this.f26826a[i] = m35307a(bArr, i2);
                i++;
                i2 += 4;
            }
            bArr = null;
            for (int i3 = 0; i3 < 32; i3++) {
                this.f26827b[i3] = this.f26826a[bArr & 3] + bArr;
                bArr -= 1640531527;
                this.f26828c[i3] = this.f26826a[(bArr >>> 11) & 3] + bArr;
            }
            return;
        }
        throw new IllegalArgumentException("Key size must be 128 bits.");
    }

    /* renamed from: b */
    private int m35310b(byte[] bArr, int i, byte[] bArr2, int i2) {
        int a = m35307a(bArr, i);
        bArr = m35307a(bArr, i + 4);
        for (i = 0; i < 32; i++) {
            a += (((bArr << 4) ^ (bArr >>> 5)) + bArr) ^ this.f26827b[i];
            bArr += (((a << 4) ^ (a >>> 5)) + a) ^ this.f26828c[i];
        }
        m35308a(a, bArr2, i2);
        m35308a(bArr, bArr2, i2 + 4);
        return 8;
    }

    /* renamed from: c */
    private int m35311c(byte[] bArr, int i, byte[] bArr2, int i2) {
        int a = m35307a(bArr, i);
        bArr = m35307a(bArr, i + 4);
        for (i = 31; i >= 0; i--) {
            bArr -= (((a << 4) ^ (a >>> 5)) + a) ^ this.f26828c[i];
            a -= (((bArr << 4) ^ (bArr >>> 5)) + bArr) ^ this.f26827b[i];
        }
        m35308a(a, bArr2, i2);
        m35308a(bArr, bArr2, i2 + 4);
        return 8;
    }

    /* renamed from: a */
    private int m35307a(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        i = (bArr[i] << 24) | ((bArr[i2] & JfifUtil.MARKER_FIRST_BYTE) << 16);
        return (bArr[i3 + 1] & JfifUtil.MARKER_FIRST_BYTE) | (i | ((bArr[i3] & JfifUtil.MARKER_FIRST_BYTE) << 8));
    }

    /* renamed from: a */
    private void m35308a(int i, byte[] bArr, int i2) {
        int i3 = i2 + 1;
        bArr[i2] = (byte) (i >>> 24);
        i2 = i3 + 1;
        bArr[i3] = (byte) (i >>> 16);
        i3 = i2 + 1;
        bArr[i2] = (byte) (i >>> 8);
        bArr[i3] = (byte) i;
    }
}
