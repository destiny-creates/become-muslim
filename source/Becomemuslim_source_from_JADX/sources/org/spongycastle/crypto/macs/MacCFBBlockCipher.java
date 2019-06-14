package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.params.ParametersWithIV;

/* compiled from: CFBBlockCipherMac */
class MacCFBBlockCipher {
    /* renamed from: a */
    private byte[] f22405a;
    /* renamed from: b */
    private byte[] f22406b;
    /* renamed from: c */
    private byte[] f22407c;
    /* renamed from: d */
    private int f22408d;
    /* renamed from: e */
    private BlockCipher f22409e = null;

    public MacCFBBlockCipher(BlockCipher blockCipher, int i) {
        this.f22409e = blockCipher;
        this.f22408d = i / 8;
        this.f22405a = new byte[blockCipher.mo5743b()];
        this.f22406b = new byte[blockCipher.mo5743b()];
        this.f22407c = new byte[blockCipher.mo5743b()];
    }

    /* renamed from: a */
    public void m27462a(CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            Object a = parametersWithIV.m35695a();
            if (a.length < this.f22405a.length) {
                System.arraycopy(a, 0, this.f22405a, this.f22405a.length - a.length, a.length);
            } else {
                System.arraycopy(a, 0, this.f22405a, 0, this.f22405a.length);
            }
            m27465c();
            this.f22409e.mo5742a(true, parametersWithIV.m35696b());
            return;
        }
        m27465c();
        this.f22409e.mo5742a(true, cipherParameters);
    }

    /* renamed from: a */
    public String m27461a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f22409e.mo5741a());
        stringBuilder.append("/CFB");
        stringBuilder.append(this.f22408d * 8);
        return stringBuilder.toString();
    }

    /* renamed from: b */
    public int m27464b() {
        return this.f22408d;
    }

    /* renamed from: a */
    public int m27460a(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.f22408d + i > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (this.f22408d + i2 <= bArr2.length) {
            this.f22409e.mo5740a(this.f22406b, 0, this.f22407c, 0);
            for (int i3 = 0; i3 < this.f22408d; i3++) {
                bArr2[i2 + i3] = (byte) (this.f22407c[i3] ^ bArr[i + i3]);
            }
            System.arraycopy(this.f22406b, this.f22408d, this.f22406b, 0, this.f22406b.length - this.f22408d);
            System.arraycopy(bArr2, i2, this.f22406b, this.f22406b.length - this.f22408d, this.f22408d);
            return this.f22408d;
        } else {
            throw new DataLengthException("output buffer too short");
        }
    }

    /* renamed from: c */
    public void m27465c() {
        System.arraycopy(this.f22405a, 0, this.f22406b, 0, this.f22405a.length);
        this.f22409e.mo5744c();
    }

    /* renamed from: a */
    void m27463a(byte[] bArr) {
        this.f22409e.mo5740a(this.f22406b, 0, bArr, 0);
    }
}
