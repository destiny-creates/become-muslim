package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.StreamBlockCipher;
import org.spongycastle.crypto.params.ParametersWithIV;

public class OFBBlockCipher extends StreamBlockCipher {
    /* renamed from: a */
    private int f31733a;
    /* renamed from: b */
    private byte[] f31734b;
    /* renamed from: c */
    private byte[] f31735c;
    /* renamed from: d */
    private byte[] f31736d;
    /* renamed from: e */
    private final int f31737e;
    /* renamed from: f */
    private final BlockCipher f31738f;

    public OFBBlockCipher(BlockCipher blockCipher, int i) {
        super(blockCipher);
        this.f31738f = blockCipher;
        this.f31737e = i / 8;
        this.f31734b = new byte[blockCipher.mo5743b()];
        this.f31735c = new byte[blockCipher.mo5743b()];
        this.f31736d = new byte[blockCipher.mo5743b()];
    }

    /* renamed from: a */
    public void mo5742a(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            z = parametersWithIV.m35695a();
            if (z.length < this.f31734b.length) {
                System.arraycopy(z, 0, this.f31734b, this.f31734b.length - z.length, z.length);
                for (int i = 0; i < this.f31734b.length - z.length; i++) {
                    this.f31734b[i] = (byte) 0;
                }
            } else {
                System.arraycopy(z, 0, this.f31734b, 0, this.f31734b.length);
            }
            mo5744c();
            if (parametersWithIV.m35696b()) {
                this.f31738f.mo5742a(true, parametersWithIV.m35696b());
                return;
            }
            return;
        }
        mo5744c();
        if (cipherParameters != null) {
            this.f31738f.mo5742a(true, cipherParameters);
        }
    }

    /* renamed from: a */
    public String mo5749a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f31738f.mo5741a());
        stringBuilder.append("/OFB");
        stringBuilder.append(this.f31737e * 8);
        return stringBuilder.toString();
    }

    /* renamed from: b */
    public int mo5743b() {
        return this.f31737e;
    }

    /* renamed from: a */
    public int mo5740a(byte[] bArr, int i, byte[] bArr2, int i2) {
        mo5722a(bArr, i, this.f31737e, bArr2, i2);
        return this.f31737e;
    }

    /* renamed from: c */
    public void mo5744c() {
        System.arraycopy(this.f31734b, 0, this.f31735c, 0, this.f31734b.length);
        this.f31733a = 0;
        this.f31738f.mo5744c();
    }

    /* renamed from: b */
    protected byte mo6454b(byte b) {
        if (this.f31733a == 0) {
            this.f31738f.mo5740a(this.f31735c, 0, this.f31736d, 0);
        }
        byte[] bArr = this.f31736d;
        int i = this.f31733a;
        this.f31733a = i + 1;
        b = (byte) (b ^ bArr[i]);
        if (this.f31733a == this.f31737e) {
            this.f31733a = 0;
            System.arraycopy(this.f31735c, this.f31737e, this.f31735c, 0, this.f31735c.length - this.f31737e);
            System.arraycopy(this.f31736d, 0, this.f31735c, this.f31735c.length - this.f31737e, this.f31737e);
        }
        return b;
    }
}
