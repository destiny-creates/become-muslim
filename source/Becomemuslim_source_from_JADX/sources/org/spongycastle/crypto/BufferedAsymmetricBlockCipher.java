package org.spongycastle.crypto;

public class BufferedAsymmetricBlockCipher {
    /* renamed from: a */
    protected byte[] f22188a;
    /* renamed from: b */
    protected int f22189b;
    /* renamed from: c */
    private final AsymmetricBlockCipher f22190c;

    public BufferedAsymmetricBlockCipher(AsymmetricBlockCipher asymmetricBlockCipher) {
        this.f22190c = asymmetricBlockCipher;
    }

    /* renamed from: a */
    public void m27293a(boolean z, CipherParameters cipherParameters) {
        m27297d();
        this.f22190c.mo5737a(z, cipherParameters);
        this.f22188a = new byte[(this.f22190c.mo5736a() + z)];
        this.f22189b = false;
    }

    /* renamed from: a */
    public int m27292a() {
        return this.f22190c.mo5736a();
    }

    /* renamed from: b */
    public int m27295b() {
        return this.f22190c.mo5739b();
    }

    /* renamed from: a */
    public void m27294a(byte[] bArr, int i, int i2) {
        if (i2 != 0) {
            if (i2 < 0) {
                throw new IllegalArgumentException("Can't have a negative input length!");
            } else if (this.f22189b + i2 <= this.f22188a.length) {
                System.arraycopy(bArr, i, this.f22188a, this.f22189b, i2);
                this.f22189b += i2;
            } else {
                throw new DataLengthException("attempt to process message too long for cipher");
            }
        }
    }

    /* renamed from: c */
    public byte[] m27296c() {
        byte[] a = this.f22190c.mo5738a(this.f22188a, 0, this.f22189b);
        m27297d();
        return a;
    }

    /* renamed from: d */
    public void m27297d() {
        if (this.f22188a != null) {
            for (int i = 0; i < this.f22188a.length; i++) {
                this.f22188a[i] = (byte) 0;
            }
        }
        this.f22189b = 0;
    }
}
