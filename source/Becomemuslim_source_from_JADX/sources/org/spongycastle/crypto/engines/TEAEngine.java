package org.spongycastle.crypto.engines;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;

public class TEAEngine implements BlockCipher {
    /* renamed from: a */
    private int f26794a;
    /* renamed from: b */
    private int f26795b;
    /* renamed from: c */
    private int f26796c;
    /* renamed from: d */
    private int f26797d;
    /* renamed from: e */
    private boolean f26798e = false;
    /* renamed from: f */
    private boolean f26799f;

    /* renamed from: a */
    public String mo5741a() {
        return "TEA";
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
            this.f26799f = z;
            this.f26798e = true;
            m35247a(((KeyParameter) cipherParameters).m35685a());
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("invalid parameter passed to TEA init - ");
        stringBuilder.append(cipherParameters.getClass().getName());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public int mo5740a(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (!this.f26798e) {
            i = new StringBuilder();
            i.append(mo5741a());
            i.append(" not initialised");
            throw new IllegalStateException(i.toString());
        } else if (i + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 8 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        } else if (this.f26799f) {
            return m35248b(bArr, i, bArr2, i2);
        } else {
            return m35249c(bArr, i, bArr2, i2);
        }
    }

    /* renamed from: a */
    private void m35247a(byte[] bArr) {
        if (bArr.length == 16) {
            this.f26794a = m35245a(bArr, 0);
            this.f26795b = m35245a(bArr, 4);
            this.f26796c = m35245a(bArr, 8);
            this.f26797d = m35245a(bArr, 12);
            return;
        }
        throw new IllegalArgumentException("Key size must be 128 bits.");
    }

    /* renamed from: b */
    private int m35248b(byte[] bArr, int i, byte[] bArr2, int i2) {
        int a = m35245a(bArr, i);
        bArr = m35245a(bArr, i + 4);
        int i3 = bArr;
        bArr = null;
        for (i = 0; i != 32; i++) {
            bArr -= 1640531527;
            a += (((i3 << 4) + this.f26794a) ^ (i3 + bArr)) ^ ((i3 >>> 5) + this.f26795b);
            i3 += (((a << 4) + this.f26796c) ^ (a + bArr)) ^ ((a >>> 5) + this.f26797d);
        }
        m35246a(a, bArr2, i2);
        m35246a(i3, bArr2, i2 + 4);
        return 8;
    }

    /* renamed from: c */
    private int m35249c(byte[] bArr, int i, byte[] bArr2, int i2) {
        int a = m35245a(bArr, i);
        bArr = m35245a(bArr, i + 4);
        i = -957401312;
        for (int i3 = 0; i3 != 32; i3++) {
            bArr -= (((a << 4) + this.f26796c) ^ (a + i)) ^ ((a >>> 5) + this.f26797d);
            a -= (((bArr << 4) + this.f26794a) ^ (bArr + i)) ^ ((bArr >>> 5) + this.f26795b);
            i += 1640531527;
        }
        m35246a(a, bArr2, i2);
        m35246a(bArr, bArr2, i2 + 4);
        return 8;
    }

    /* renamed from: a */
    private int m35245a(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        i = (bArr[i] << 24) | ((bArr[i2] & JfifUtil.MARKER_FIRST_BYTE) << 16);
        return (bArr[i3 + 1] & JfifUtil.MARKER_FIRST_BYTE) | (i | ((bArr[i3] & JfifUtil.MARKER_FIRST_BYTE) << 8));
    }

    /* renamed from: a */
    private void m35246a(int i, byte[] bArr, int i2) {
        int i3 = i2 + 1;
        bArr[i2] = (byte) (i >>> 24);
        i2 = i3 + 1;
        bArr[i3] = (byte) (i >>> 16);
        i3 = i2 + 1;
        bArr[i2] = (byte) (i >>> 8);
        bArr[i3] = (byte) i;
    }
}
