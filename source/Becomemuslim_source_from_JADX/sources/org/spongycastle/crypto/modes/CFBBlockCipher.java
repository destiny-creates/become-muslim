package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.StreamBlockCipher;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;

public class CFBBlockCipher extends StreamBlockCipher {
    /* renamed from: a */
    private byte[] f31711a;
    /* renamed from: b */
    private byte[] f31712b;
    /* renamed from: c */
    private byte[] f31713c;
    /* renamed from: d */
    private byte[] f31714d;
    /* renamed from: e */
    private int f31715e;
    /* renamed from: f */
    private BlockCipher f31716f = null;
    /* renamed from: g */
    private boolean f31717g;
    /* renamed from: h */
    private int f31718h;

    public CFBBlockCipher(BlockCipher blockCipher, int i) {
        super(blockCipher);
        this.f31716f = blockCipher;
        this.f31715e = i / 8;
        this.f31711a = new byte[blockCipher.mo5743b()];
        this.f31712b = new byte[blockCipher.mo5743b()];
        this.f31713c = new byte[blockCipher.mo5743b()];
        this.f31714d = new byte[this.f31715e];
    }

    /* renamed from: a */
    public void mo5742a(boolean z, CipherParameters cipherParameters) {
        this.f31717g = z;
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            z = parametersWithIV.m35695a();
            if (z.length < this.f31711a.length) {
                System.arraycopy(z, 0, this.f31711a, this.f31711a.length - z.length, z.length);
                for (int i = 0; i < this.f31711a.length - z.length; i++) {
                    this.f31711a[i] = (byte) 0;
                }
            } else {
                System.arraycopy(z, 0, this.f31711a, 0, this.f31711a.length);
            }
            mo5744c();
            if (parametersWithIV.m35696b()) {
                this.f31716f.mo5742a(true, parametersWithIV.m35696b());
                return;
            }
            return;
        }
        mo5744c();
        if (cipherParameters != null) {
            this.f31716f.mo5742a(true, cipherParameters);
        }
    }

    /* renamed from: a */
    public String mo5749a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f31716f.mo5741a());
        stringBuilder.append("/CFB");
        stringBuilder.append(this.f31715e * 8);
        return stringBuilder.toString();
    }

    /* renamed from: b */
    protected byte mo6454b(byte b) {
        return this.f31717g ? m40743c(b) : m40744d(b);
    }

    /* renamed from: c */
    private byte m40743c(byte b) {
        if (this.f31718h == 0) {
            this.f31716f.mo5740a(this.f31712b, 0, this.f31713c, 0);
        }
        b = (byte) (b ^ this.f31713c[this.f31718h]);
        byte[] bArr = this.f31714d;
        int i = this.f31718h;
        this.f31718h = i + 1;
        bArr[i] = b;
        if (this.f31718h == this.f31715e) {
            this.f31718h = 0;
            System.arraycopy(this.f31712b, this.f31715e, this.f31712b, 0, this.f31712b.length - this.f31715e);
            System.arraycopy(this.f31714d, 0, this.f31712b, this.f31712b.length - this.f31715e, this.f31715e);
        }
        return b;
    }

    /* renamed from: d */
    private byte m40744d(byte b) {
        if (this.f31718h == 0) {
            this.f31716f.mo5740a(this.f31712b, 0, this.f31713c, 0);
        }
        this.f31714d[this.f31718h] = b;
        byte[] bArr = this.f31713c;
        int i = this.f31718h;
        this.f31718h = i + 1;
        b = (byte) (b ^ bArr[i]);
        if (this.f31718h == this.f31715e) {
            this.f31718h = 0;
            System.arraycopy(this.f31712b, this.f31715e, this.f31712b, 0, this.f31712b.length - this.f31715e);
            System.arraycopy(this.f31714d, 0, this.f31712b, this.f31712b.length - this.f31715e, this.f31715e);
        }
        return b;
    }

    /* renamed from: b */
    public int mo5743b() {
        return this.f31715e;
    }

    /* renamed from: a */
    public int mo5740a(byte[] bArr, int i, byte[] bArr2, int i2) {
        mo5722a(bArr, i, this.f31715e, bArr2, i2);
        return this.f31715e;
    }

    /* renamed from: d */
    public byte[] m40751d() {
        return Arrays.m29373b(this.f31712b);
    }

    /* renamed from: c */
    public void mo5744c() {
        System.arraycopy(this.f31711a, 0, this.f31712b, 0, this.f31711a.length);
        Arrays.m29351a(this.f31714d, (byte) 0);
        this.f31718h = 0;
        this.f31716f.mo5744c();
    }
}
