package org.spongycastle.crypto.paddings;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.ParametersWithRandom;

public class PaddedBufferedBlockCipher extends BufferedBlockCipher {
    /* renamed from: g */
    BlockCipherPadding f27062g;

    public PaddedBufferedBlockCipher(BlockCipher blockCipher, BlockCipherPadding blockCipherPadding) {
        this.d = blockCipher;
        this.f27062g = blockCipherPadding;
        this.a = new byte[blockCipher.mo5743b()];
        this.b = null;
    }

    public PaddedBufferedBlockCipher(BlockCipher blockCipher) {
        this(blockCipher, new PKCS7Padding());
    }

    /* renamed from: a */
    public void mo5786a(boolean z, CipherParameters cipherParameters) {
        this.c = z;
        m27305c();
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.f27062g.mo5785a(parametersWithRandom.m35697a());
            this.d.mo5742a(z, parametersWithRandom.m35698b());
            return;
        }
        this.f27062g.mo5785a(null);
        this.d.mo5742a(z, cipherParameters);
    }

    /* renamed from: b */
    public int mo5778b(int i) {
        i += this.b;
        int length = i % this.a.length;
        if (length == 0) {
            return this.c ? i + this.a.length : i;
        } else {
            return (i - length) + this.a.length;
        }
    }

    /* renamed from: a */
    public int mo5775a(int i) {
        i += this.b;
        int length = i % this.a.length;
        return length == 0 ? Math.max(0, i - this.a.length) : i - length;
    }

    /* renamed from: a */
    public int mo5777a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (i2 >= 0) {
            int b = m27303b();
            int a = mo5775a(i2);
            if (a > 0) {
                if (a + i3 > bArr2.length) {
                    throw new OutputLengthException("output buffer too short");
                }
            }
            a = this.a.length - this.b;
            int i4 = 0;
            if (i2 > a) {
                System.arraycopy(bArr, i, this.a, this.b, a);
                int a2 = this.d.mo5740a(this.a, 0, bArr2, i3) + 0;
                this.b = 0;
                i2 -= a;
                i += a;
                i4 = a2;
                while (i2 > this.a.length) {
                    i4 += this.d.mo5740a(bArr, i, bArr2, i3 + i4);
                    i2 -= b;
                    i += b;
                }
            }
            System.arraycopy(bArr, i, this.a, this.b, i2);
            this.b += i2;
            return i4;
        }
        throw new IllegalArgumentException("Can't have a negative input length!");
    }

    /* renamed from: a */
    public int mo5776a(byte[] bArr, int i) {
        int b = this.d.mo5743b();
        if (this.c) {
            if (this.b != b) {
                b = 0;
            } else if ((b * 2) + i <= bArr.length) {
                b = this.d.mo5740a(this.a, 0, bArr, i);
                this.b = 0;
            } else {
                m27305c();
                throw new OutputLengthException("output buffer too short");
            }
            this.f27062g.mo5784a(this.a, this.b);
            b += this.d.mo5740a(this.a, 0, bArr, i + b);
            m27305c();
            return b;
        } else if (this.b == b) {
            b = this.d.mo5740a(this.a, 0, this.a, 0);
            this.b = 0;
            try {
                b -= this.f27062g.mo5783a(this.a);
                System.arraycopy(this.a, 0, bArr, i, b);
                return b;
            } finally {
                m27305c();
            }
        } else {
            m27305c();
            throw new DataLengthException("last block incomplete in decryption");
        }
    }
}
