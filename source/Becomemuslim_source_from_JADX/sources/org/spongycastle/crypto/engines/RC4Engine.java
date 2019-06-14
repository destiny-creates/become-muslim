package org.spongycastle.crypto.engines;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.params.KeyParameter;

public class RC4Engine implements StreamCipher {
    /* renamed from: a */
    private byte[] f26711a = null;
    /* renamed from: b */
    private int f26712b = 0;
    /* renamed from: c */
    private int f26713c = 0;
    /* renamed from: d */
    private byte[] f26714d = null;

    /* renamed from: a */
    public String mo5749a() {
        return "RC4";
    }

    /* renamed from: a */
    public void mo5750a(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.f26714d = ((KeyParameter) cipherParameters).m35685a();
            m35069a(this.f26714d);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("invalid parameter passed to RC4 init - ");
        stringBuilder.append(cipherParameters.getClass().getName());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public byte mo5721a(byte b) {
        this.f26712b = (this.f26712b + 1) & JfifUtil.MARKER_FIRST_BYTE;
        this.f26713c = (this.f26711a[this.f26712b] + this.f26713c) & JfifUtil.MARKER_FIRST_BYTE;
        byte b2 = this.f26711a[this.f26712b];
        this.f26711a[this.f26712b] = this.f26711a[this.f26713c];
        this.f26711a[this.f26713c] = b2;
        return (byte) (b ^ this.f26711a[(this.f26711a[this.f26712b] + this.f26711a[this.f26713c]) & JfifUtil.MARKER_FIRST_BYTE]);
    }

    /* renamed from: a */
    public int mo5722a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (i + i2 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i3 + i2 <= bArr2.length) {
            for (int i4 = 0; i4 < i2; i4++) {
                this.f26712b = (this.f26712b + 1) & JfifUtil.MARKER_FIRST_BYTE;
                this.f26713c = (this.f26711a[this.f26712b] + this.f26713c) & JfifUtil.MARKER_FIRST_BYTE;
                byte b = this.f26711a[this.f26712b];
                this.f26711a[this.f26712b] = this.f26711a[this.f26713c];
                this.f26711a[this.f26713c] = b;
                bArr2[i4 + i3] = (byte) (bArr[i4 + i] ^ this.f26711a[(this.f26711a[this.f26712b] + this.f26711a[this.f26713c]) & JfifUtil.MARKER_FIRST_BYTE]);
            }
            return i2;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    /* renamed from: c */
    public void mo5751c() {
        m35069a(this.f26714d);
    }

    /* renamed from: a */
    private void m35069a(byte[] bArr) {
        int i;
        this.f26714d = bArr;
        int i2 = 0;
        this.f26712b = 0;
        this.f26713c = 0;
        if (this.f26711a == null) {
            this.f26711a = new byte[256];
        }
        for (i = 0; i < 256; i++) {
            this.f26711a[i] = (byte) i;
        }
        i = 0;
        int i3 = 0;
        while (i2 < 256) {
            i3 = (((bArr[i] & JfifUtil.MARKER_FIRST_BYTE) + this.f26711a[i2]) + i3) & JfifUtil.MARKER_FIRST_BYTE;
            byte b = this.f26711a[i2];
            this.f26711a[i2] = this.f26711a[i3];
            this.f26711a[i3] = b;
            i = (i + 1) % bArr.length;
            i2++;
        }
    }
}
