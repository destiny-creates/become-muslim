package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.macs.CMac;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;

public class EAXBlockCipher implements AEADBlockCipher {
    /* renamed from: a */
    private SICBlockCipher f26982a;
    /* renamed from: b */
    private boolean f26983b;
    /* renamed from: c */
    private int f26984c;
    /* renamed from: d */
    private Mac f26985d;
    /* renamed from: e */
    private byte[] f26986e = new byte[this.f26985d.mo5766b()];
    /* renamed from: f */
    private byte[] f26987f = new byte[this.f26985d.mo5766b()];
    /* renamed from: g */
    private byte[] f26988g = new byte[this.f26984c];
    /* renamed from: h */
    private int f26989h;
    /* renamed from: i */
    private byte[] f26990i;
    /* renamed from: j */
    private int f26991j;
    /* renamed from: k */
    private boolean f26992k;
    /* renamed from: l */
    private byte[] f26993l;

    public EAXBlockCipher(BlockCipher blockCipher) {
        this.f26984c = blockCipher.mo5743b();
        this.f26985d = new CMac(blockCipher);
        this.f26982a = new SICBlockCipher(blockCipher);
    }

    /* renamed from: a */
    public BlockCipher mo5771a() {
        return this.f26982a.m34701e();
    }

    /* renamed from: a */
    public void mo5772a(boolean z, CipherParameters cipherParameters) {
        byte[] d;
        this.f26983b = z;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            d = aEADParameters.m35629d();
            this.f26993l = aEADParameters.m35628c();
            this.f26989h = aEADParameters.m35627b() / 8;
            cipherParameters = aEADParameters.m35626a();
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            d = parametersWithIV.m35695a();
            this.f26993l = null;
            this.f26989h = this.f26985d.mo5766b() / 2;
            cipherParameters = parametersWithIV.m35696b();
        } else {
            throw new IllegalArgumentException("invalid parameters passed to EAX");
        }
        this.f26990i = new byte[(z ? this.f26984c : this.f26984c + this.f26989h)];
        z = new byte[this.f26984c];
        this.f26985d.mo5764a(cipherParameters);
        z[this.f26984c - 1] = null;
        this.f26985d.mo5765a(z, 0, this.f26984c);
        this.f26985d.mo5765a(d, 0, d.length);
        this.f26985d.mo5761a(this.f26986e, 0);
        this.f26982a.mo5742a(true, new ParametersWithIV(null, this.f26986e));
        m35524b();
    }

    /* renamed from: c */
    private void m35515c() {
        if (!this.f26992k) {
            this.f26992k = true;
            this.f26985d.mo5761a(this.f26987f, 0);
            byte[] bArr = new byte[this.f26984c];
            bArr[this.f26984c - 1] = (byte) 2;
            this.f26985d.mo5765a(bArr, 0, this.f26984c);
        }
    }

    /* renamed from: d */
    private void m35516d() {
        byte[] bArr = new byte[this.f26984c];
        int i = 0;
        this.f26985d.mo5761a(bArr, 0);
        while (i < this.f26988g.length) {
            this.f26988g[i] = (byte) ((this.f26986e[i] ^ this.f26987f[i]) ^ bArr[i]);
            i++;
        }
    }

    /* renamed from: b */
    public void m35524b() {
        m35513a(true);
    }

    /* renamed from: a */
    private void m35513a(boolean z) {
        this.f26982a.mo5744c();
        this.f26985d.mo5767c();
        this.f26991j = 0;
        Arrays.m29351a(this.f26990i, (byte) 0);
        if (z) {
            Arrays.m29351a(this.f26988g, (byte) 0);
        }
        z = new byte[this.f26984c];
        z[this.f26984c - 1] = 1;
        this.f26985d.mo5765a(z, 0, this.f26984c);
        this.f26992k = false;
        if (this.f26993l) {
            mo5773a(this.f26993l, 0, this.f26993l.length);
        }
    }

    /* renamed from: a */
    public void mo5773a(byte[] bArr, int i, int i2) {
        if (this.f26992k) {
            throw new IllegalStateException("AAD data cannot be added after encryption/decryption processing has begun.");
        }
        this.f26985d.mo5765a(bArr, i, i2);
    }

    /* renamed from: a */
    public int mo5770a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        m35515c();
        if (bArr.length >= i + i2) {
            int i4 = 0;
            for (int i5 = 0; i5 != i2; i5++) {
                i4 += m35512a(bArr[i + i5], bArr2, i3 + i4);
            }
            return i4;
        }
        throw new DataLengthException("Input buffer too short");
    }

    /* renamed from: a */
    public int mo5769a(byte[] bArr, int i) {
        m35515c();
        int i2 = this.f26991j;
        Object obj = new byte[this.f26990i.length];
        this.f26991j = 0;
        if (this.f26983b) {
            int i3 = i + i2;
            if (bArr.length >= this.f26989h + i3) {
                this.f26982a.mo5740a(this.f26990i, 0, obj, 0);
                System.arraycopy(obj, 0, bArr, i, i2);
                this.f26985d.mo5765a(obj, 0, i2);
                m35516d();
                System.arraycopy(this.f26988g, 0, bArr, i3, this.f26989h);
                m35513a(false);
                return i2 + this.f26989h;
            }
            throw new OutputLengthException("Output buffer too short");
        } else if (i2 < this.f26989h) {
            throw new InvalidCipherTextException("data too short");
        } else if (bArr.length >= (i + i2) - this.f26989h) {
            if (i2 > this.f26989h) {
                this.f26985d.mo5765a(this.f26990i, 0, i2 - this.f26989h);
                this.f26982a.mo5740a(this.f26990i, 0, obj, 0);
                System.arraycopy(obj, 0, bArr, i, i2 - this.f26989h);
            }
            m35516d();
            if (m35514b(this.f26990i, i2 - this.f26989h) != null) {
                m35513a(false);
                return i2 - this.f26989h;
            }
            throw new InvalidCipherTextException("mac check in EAX failed");
        } else {
            throw new OutputLengthException("Output buffer too short");
        }
    }

    /* renamed from: a */
    public int mo5768a(int i) {
        i += this.f26991j;
        if (!this.f26983b) {
            if (i < this.f26989h) {
                return 0;
            }
            i -= this.f26989h;
        }
        return i - (i % this.f26984c);
    }

    /* renamed from: b */
    public int mo5774b(int i) {
        i += this.f26991j;
        if (this.f26983b) {
            return i + this.f26989h;
        }
        return i < this.f26989h ? 0 : i - this.f26989h;
    }

    /* renamed from: a */
    private int m35512a(byte b, byte[] bArr, int i) {
        byte[] bArr2 = this.f26990i;
        int i2 = this.f26991j;
        this.f26991j = i2 + 1;
        bArr2[i2] = b;
        if (this.f26991j != this.f26990i.length) {
            return 0;
        }
        if (bArr.length >= this.f26984c + i) {
            if (this.f26983b != (byte) 0) {
                b = this.f26982a.mo5740a(this.f26990i, 0, bArr, i);
                this.f26985d.mo5765a(bArr, i, this.f26984c);
            } else {
                this.f26985d.mo5765a(this.f26990i, 0, this.f26984c);
                b = this.f26982a.mo5740a(this.f26990i, 0, bArr, i);
            }
            this.f26991j = 0;
            if (this.f26983b == null) {
                System.arraycopy(this.f26990i, this.f26984c, this.f26990i, 0, this.f26989h);
                this.f26991j = this.f26989h;
            }
            return b;
        }
        throw new OutputLengthException("Output buffer is too short");
    }

    /* renamed from: b */
    private boolean m35514b(byte[] bArr, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f26989h; i3++) {
            i2 |= this.f26988g[i3] ^ bArr[i + i3];
        }
        if (i2 == 0) {
            return true;
        }
        return false;
    }
}
