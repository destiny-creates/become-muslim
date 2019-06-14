package org.spongycastle.crypto;

public class BufferedBlockCipher {
    /* renamed from: a */
    protected byte[] f22191a;
    /* renamed from: b */
    protected int f22192b;
    /* renamed from: c */
    protected boolean f22193c;
    /* renamed from: d */
    protected BlockCipher f22194d;
    /* renamed from: e */
    protected boolean f22195e;
    /* renamed from: f */
    protected boolean f22196f;

    protected BufferedBlockCipher() {
    }

    public BufferedBlockCipher(BlockCipher blockCipher) {
        this.f22194d = blockCipher;
        this.f22191a = new byte[blockCipher.mo5743b()];
        boolean z = false;
        this.f22192b = 0;
        String a = blockCipher.mo5741a();
        int indexOf = a.indexOf(47) + 1;
        boolean z2 = indexOf > 0 && a.startsWith("PGP", indexOf);
        this.f22196f = z2;
        if (!this.f22196f) {
            if ((blockCipher instanceof StreamCipher) == null) {
                if (indexOf > 0 && a.startsWith("OpenPGP", indexOf) != null) {
                    z = true;
                }
                this.f22195e = z;
                return;
            }
        }
        this.f22195e = true;
    }

    /* renamed from: a */
    public BlockCipher m27301a() {
        return this.f22194d;
    }

    /* renamed from: a */
    public void mo5786a(boolean z, CipherParameters cipherParameters) {
        this.f22193c = z;
        m27305c();
        this.f22194d.mo5742a(z, cipherParameters);
    }

    /* renamed from: b */
    public int m27303b() {
        return this.f22194d.mo5743b();
    }

    /* renamed from: a */
    public int mo5775a(int i) {
        int length;
        i += this.f22192b;
        if (!this.f22196f) {
            length = i % this.f22191a.length;
        } else if (this.f22193c) {
            length = (i % this.f22191a.length) - (this.f22194d.mo5743b() + 2);
        } else {
            length = i % this.f22191a.length;
        }
        return i - length;
    }

    /* renamed from: b */
    public int mo5778b(int i) {
        return i + this.f22192b;
    }

    /* renamed from: a */
    public int mo5777a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (i2 >= 0) {
            int a;
            int b = m27303b();
            int a2 = mo5775a(i2);
            if (a2 > 0) {
                if (a2 + i3 > bArr2.length) {
                    throw new OutputLengthException("output buffer too short");
                }
            }
            a2 = this.f22191a.length - this.f22192b;
            if (i2 > a2) {
                System.arraycopy(bArr, i, this.f22191a, this.f22192b, a2);
                a = this.f22194d.mo5740a(this.f22191a, 0, bArr2, i3) + 0;
                this.f22192b = 0;
                i2 -= a2;
                i += a2;
                while (i2 > this.f22191a.length) {
                    a += this.f22194d.mo5740a(bArr, i, bArr2, i3 + a);
                    i2 -= b;
                    i += b;
                }
            } else {
                a = 0;
            }
            System.arraycopy(bArr, i, this.f22191a, this.f22192b, i2);
            this.f22192b += i2;
            if (this.f22192b != this.f22191a.length) {
                return a;
            }
            a += this.f22194d.mo5740a(this.f22191a, 0, bArr2, i3 + a);
            this.f22192b = 0;
            return a;
        }
        throw new IllegalArgumentException("Can't have a negative input length!");
    }

    /* renamed from: a */
    public int mo5776a(byte[] bArr, int i) {
        try {
            if (this.f22192b + i <= bArr.length) {
                int i2;
                if (this.f22192b == 0) {
                    i2 = 0;
                } else if (this.f22195e) {
                    this.f22194d.mo5740a(this.f22191a, 0, this.f22191a, 0);
                    i2 = this.f22192b;
                    this.f22192b = 0;
                    System.arraycopy(this.f22191a, 0, bArr, i, i2);
                } else {
                    throw new DataLengthException("data not block size aligned");
                }
                m27305c();
                return i2;
            }
            throw new OutputLengthException("output buffer too short for doFinal()");
        } catch (Throwable th) {
            m27305c();
        }
    }

    /* renamed from: c */
    public void m27305c() {
        for (int i = 0; i < this.f22191a.length; i++) {
            this.f22191a[i] = (byte) 0;
        }
        this.f22192b = 0;
        this.f22194d.mo5744c();
    }
}
