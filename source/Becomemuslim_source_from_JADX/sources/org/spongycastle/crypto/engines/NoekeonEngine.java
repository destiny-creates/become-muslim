package org.spongycastle.crypto.engines;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;

public class NoekeonEngine implements BlockCipher {
    /* renamed from: a */
    private static final int[] f26690a = new int[]{0, 0, 0, 0};
    /* renamed from: b */
    private static final int[] f26691b = new int[]{128, 27, 54, 108, JfifUtil.MARKER_SOI, 171, 77, 154, 47, 94, 188, 99, 198, 151, 53, 106, 212};
    /* renamed from: c */
    private int[] f26692c = new int[4];
    /* renamed from: d */
    private int[] f26693d = new int[4];
    /* renamed from: e */
    private int[] f26694e = new int[4];
    /* renamed from: f */
    private boolean f26695f = false;
    /* renamed from: g */
    private boolean f26696g;

    /* renamed from: a */
    private int m35033a(int i, int i2) {
        return (i >>> (32 - i2)) | (i << i2);
    }

    /* renamed from: a */
    public String mo5741a() {
        return "Noekeon";
    }

    /* renamed from: b */
    public int mo5743b() {
        return 16;
    }

    /* renamed from: c */
    public void mo5744c() {
    }

    /* renamed from: a */
    public void mo5742a(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.f26696g = z;
            this.f26695f = true;
            m35036a(((KeyParameter) cipherParameters).m35685a());
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("invalid parameter passed to Noekeon init - ");
        stringBuilder.append(cipherParameters.getClass().getName());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public int mo5740a(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (!this.f26695f) {
            i = new StringBuilder();
            i.append(mo5741a());
            i.append(" not initialised");
            throw new IllegalStateException(i.toString());
        } else if (i + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 16 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        } else if (this.f26696g) {
            return m35039b(bArr, i, bArr2, i2);
        } else {
            return m35041c(bArr, i, bArr2, i2);
        }
    }

    /* renamed from: a */
    private void m35036a(byte[] bArr) {
        this.f26693d[0] = m35034a(bArr, 0);
        this.f26693d[1] = m35034a(bArr, 4);
        this.f26693d[2] = m35034a(bArr, 8);
        this.f26693d[3] = m35034a(bArr, 12);
    }

    /* renamed from: b */
    private int m35039b(byte[] bArr, int i, byte[] bArr2, int i2) {
        this.f26692c[0] = m35034a(bArr, i);
        this.f26692c[1] = m35034a(bArr, i + 4);
        this.f26692c[2] = m35034a(bArr, i + 8);
        this.f26692c[3] = m35034a(bArr, i + 12);
        bArr = null;
        while (bArr < 16) {
            int[] iArr = this.f26692c;
            iArr[0] = iArr[0] ^ f26691b[bArr];
            m35038a(this.f26692c, this.f26693d);
            m35040b(this.f26692c);
            m35037a(this.f26692c);
            m35042c(this.f26692c);
            bArr++;
        }
        int[] iArr2 = this.f26692c;
        iArr2[0] = f26691b[bArr] ^ iArr2[0];
        m35038a(this.f26692c, this.f26693d);
        m35035a(this.f26692c[0], bArr2, i2);
        m35035a(this.f26692c[1], bArr2, i2 + 4);
        m35035a(this.f26692c[2], bArr2, i2 + 8);
        m35035a(this.f26692c[3], bArr2, i2 + 12);
        return 16;
    }

    /* renamed from: c */
    private int m35041c(byte[] bArr, int i, byte[] bArr2, int i2) {
        int[] iArr;
        this.f26692c[0] = m35034a(bArr, i);
        this.f26692c[1] = m35034a(bArr, i + 4);
        this.f26692c[2] = m35034a(bArr, i + 8);
        this.f26692c[3] = m35034a(bArr, i + 12);
        System.arraycopy(this.f26693d, 0, this.f26694e, 0, this.f26693d.length);
        m35038a(this.f26694e, f26690a);
        int i3 = 16;
        while (i3 > 0) {
            m35038a(this.f26692c, this.f26694e);
            iArr = this.f26692c;
            iArr[0] = iArr[0] ^ f26691b[i3];
            m35040b(this.f26692c);
            m35037a(this.f26692c);
            m35042c(this.f26692c);
            i3--;
        }
        m35038a(this.f26692c, this.f26694e);
        iArr = this.f26692c;
        iArr[0] = f26691b[i3] ^ iArr[0];
        m35035a(this.f26692c[0], bArr2, i2);
        m35035a(this.f26692c[1], bArr2, i2 + 4);
        m35035a(this.f26692c[2], bArr2, i2 + 8);
        m35035a(this.f26692c[3], bArr2, i2 + 12);
        return 16;
    }

    /* renamed from: a */
    private void m35037a(int[] iArr) {
        iArr[1] = iArr[1] ^ ((~iArr[3]) & (~iArr[2]));
        iArr[0] = iArr[0] ^ (iArr[2] & iArr[1]);
        int i = iArr[3];
        iArr[3] = iArr[0];
        iArr[0] = i;
        iArr[2] = iArr[2] ^ ((iArr[0] ^ iArr[1]) ^ iArr[3]);
        iArr[1] = ((~iArr[3]) & (~iArr[2])) ^ iArr[1];
        iArr[0] = (iArr[1] & iArr[2]) ^ iArr[0];
    }

    /* renamed from: a */
    private void m35038a(int[] iArr, int[] iArr2) {
        int i = iArr[0] ^ iArr[2];
        i ^= m35033a(i, 8) ^ m35033a(i, 24);
        iArr[1] = iArr[1] ^ i;
        iArr[3] = i ^ iArr[3];
        for (i = 0; i < 4; i++) {
            iArr[i] = iArr[i] ^ iArr2[i];
        }
        int i2 = iArr[1] ^ iArr[3];
        iArr2 = i2 ^ (m35033a(i2, 8) ^ m35033a(i2, 24));
        iArr[0] = iArr[0] ^ iArr2;
        iArr[2] = iArr2 ^ iArr[2];
    }

    /* renamed from: b */
    private void m35040b(int[] iArr) {
        iArr[1] = m35033a(iArr[1], 1);
        iArr[2] = m35033a(iArr[2], 5);
        iArr[3] = m35033a(iArr[3], 2);
    }

    /* renamed from: c */
    private void m35042c(int[] iArr) {
        iArr[1] = m35033a(iArr[1], 31);
        iArr[2] = m35033a(iArr[2], 27);
        iArr[3] = m35033a(iArr[3], 30);
    }

    /* renamed from: a */
    private int m35034a(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        i = (bArr[i] << 24) | ((bArr[i2] & JfifUtil.MARKER_FIRST_BYTE) << 16);
        return (bArr[i3 + 1] & JfifUtil.MARKER_FIRST_BYTE) | (i | ((bArr[i3] & JfifUtil.MARKER_FIRST_BYTE) << 8));
    }

    /* renamed from: a */
    private void m35035a(int i, byte[] bArr, int i2) {
        int i3 = i2 + 1;
        bArr[i2] = (byte) (i >>> 24);
        i2 = i3 + 1;
        bArr[i3] = (byte) (i >>> 16);
        i3 = i2 + 1;
        bArr[i2] = (byte) (i >>> 8);
        bArr[i3] = (byte) i;
    }
}
