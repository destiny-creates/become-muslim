package org.spongycastle.crypto.engines;

import com.facebook.imageutils.JfifUtil;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

public class VMPCEngine implements StreamCipher {
    /* renamed from: a */
    protected byte f26821a = (byte) 0;
    /* renamed from: b */
    protected byte[] f26822b = null;
    /* renamed from: c */
    protected byte f26823c = (byte) 0;
    /* renamed from: d */
    protected byte[] f26824d;
    /* renamed from: e */
    protected byte[] f26825e;

    /* renamed from: a */
    public String mo5749a() {
        return "VMPC";
    }

    /* renamed from: a */
    public void mo5750a(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            if (parametersWithIV.m35696b() instanceof KeyParameter) {
                KeyParameter keyParameter = (KeyParameter) parametersWithIV.m35696b();
                this.f26824d = parametersWithIV.m35695a();
                if (this.f26824d == null || this.f26824d.length < 1 || this.f26824d.length > 768) {
                    throw new IllegalArgumentException("VMPC requires 1 to 768 bytes of IV");
                }
                this.f26825e = keyParameter.m35685a();
                mo6452a(this.f26825e, this.f26824d);
                return;
            }
            throw new IllegalArgumentException("VMPC init parameters must include a key");
        }
        throw new IllegalArgumentException("VMPC init parameters must include an IV");
    }

    /* renamed from: a */
    protected void mo6452a(byte[] bArr, byte[] bArr2) {
        this.f26823c = (byte) 0;
        this.f26822b = new byte[256];
        for (int i = 0; i < 256; i++) {
            this.f26822b[i] = (byte) i;
        }
        for (int i2 = 0; i2 < 768; i2++) {
            int i3 = i2 & JfifUtil.MARKER_FIRST_BYTE;
            this.f26823c = this.f26822b[((this.f26823c + this.f26822b[i3]) + bArr[i2 % bArr.length]) & JfifUtil.MARKER_FIRST_BYTE];
            byte b = this.f26822b[i3];
            this.f26822b[i3] = this.f26822b[this.f26823c & JfifUtil.MARKER_FIRST_BYTE];
            this.f26822b[this.f26823c & JfifUtil.MARKER_FIRST_BYTE] = b;
        }
        for (bArr = null; bArr < 768; bArr++) {
            i3 = bArr & JfifUtil.MARKER_FIRST_BYTE;
            this.f26823c = this.f26822b[((this.f26823c + this.f26822b[i3]) + bArr2[bArr % bArr2.length]) & JfifUtil.MARKER_FIRST_BYTE];
            byte b2 = this.f26822b[i3];
            this.f26822b[i3] = this.f26822b[this.f26823c & JfifUtil.MARKER_FIRST_BYTE];
            this.f26822b[this.f26823c & JfifUtil.MARKER_FIRST_BYTE] = b2;
        }
        this.f26821a = (byte) 0;
    }

    /* renamed from: a */
    public int mo5722a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (i + i2 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i3 + i2 <= bArr2.length) {
            for (int i4 = 0; i4 < i2; i4++) {
                this.f26823c = this.f26822b[(this.f26823c + this.f26822b[this.f26821a & JfifUtil.MARKER_FIRST_BYTE]) & JfifUtil.MARKER_FIRST_BYTE];
                byte b = this.f26822b[(this.f26822b[this.f26822b[this.f26823c & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE] + 1) & JfifUtil.MARKER_FIRST_BYTE];
                byte b2 = this.f26822b[this.f26821a & JfifUtil.MARKER_FIRST_BYTE];
                this.f26822b[this.f26821a & JfifUtil.MARKER_FIRST_BYTE] = this.f26822b[this.f26823c & JfifUtil.MARKER_FIRST_BYTE];
                this.f26822b[this.f26823c & JfifUtil.MARKER_FIRST_BYTE] = b2;
                this.f26821a = (byte) ((this.f26821a + 1) & JfifUtil.MARKER_FIRST_BYTE);
                bArr2[i4 + i3] = (byte) (b ^ bArr[i4 + i]);
            }
            return i2;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    /* renamed from: c */
    public void mo5751c() {
        mo6452a(this.f26825e, this.f26824d);
    }

    /* renamed from: a */
    public byte mo5721a(byte b) {
        this.f26823c = this.f26822b[(this.f26823c + this.f26822b[this.f26821a & JfifUtil.MARKER_FIRST_BYTE]) & JfifUtil.MARKER_FIRST_BYTE];
        byte b2 = this.f26822b[(this.f26822b[this.f26822b[this.f26823c & JfifUtil.MARKER_FIRST_BYTE] & JfifUtil.MARKER_FIRST_BYTE] + 1) & JfifUtil.MARKER_FIRST_BYTE];
        byte b3 = this.f26822b[this.f26821a & JfifUtil.MARKER_FIRST_BYTE];
        this.f26822b[this.f26821a & JfifUtil.MARKER_FIRST_BYTE] = this.f26822b[this.f26823c & JfifUtil.MARKER_FIRST_BYTE];
        this.f26822b[this.f26823c & JfifUtil.MARKER_FIRST_BYTE] = b3;
        this.f26821a = (byte) ((this.f26821a + 1) & JfifUtil.MARKER_FIRST_BYTE);
        return (byte) (b ^ b2);
    }
}
