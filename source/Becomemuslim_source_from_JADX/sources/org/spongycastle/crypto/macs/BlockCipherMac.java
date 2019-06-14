package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Mac;

public class BlockCipherMac implements Mac {
    /* renamed from: a */
    private byte[] f26864a;
    /* renamed from: b */
    private byte[] f26865b;
    /* renamed from: c */
    private int f26866c;
    /* renamed from: d */
    private BlockCipher f26867d;
    /* renamed from: e */
    private int f26868e;

    /* renamed from: a */
    public String mo5762a() {
        return this.f26867d.mo5741a();
    }

    /* renamed from: a */
    public void mo5764a(CipherParameters cipherParameters) {
        mo5767c();
        this.f26867d.mo5742a(true, cipherParameters);
    }

    /* renamed from: b */
    public int mo5766b() {
        return this.f26868e;
    }

    /* renamed from: a */
    public void mo5763a(byte b) {
        if (this.f26866c == this.f26865b.length) {
            this.f26867d.mo5740a(this.f26865b, 0, this.f26864a, 0);
            this.f26866c = 0;
        }
        byte[] bArr = this.f26865b;
        int i = this.f26866c;
        this.f26866c = i + 1;
        bArr[i] = b;
    }

    /* renamed from: a */
    public void mo5765a(byte[] bArr, int i, int i2) {
        if (i2 >= 0) {
            int b = this.f26867d.mo5743b();
            int i3 = b - this.f26866c;
            if (i2 > i3) {
                System.arraycopy(bArr, i, this.f26865b, this.f26866c, i3);
                this.f26867d.mo5740a(this.f26865b, 0, this.f26864a, 0);
                this.f26866c = 0;
                i2 -= i3;
                i += i3;
                while (i2 > b) {
                    this.f26867d.mo5740a(bArr, i, this.f26864a, 0);
                    i2 -= b;
                    i += b;
                }
            }
            System.arraycopy(bArr, i, this.f26865b, this.f26866c, i2);
            this.f26866c += i2;
            return;
        }
        throw new IllegalArgumentException("Can't have a negative input length!");
    }

    /* renamed from: a */
    public int mo5761a(byte[] bArr, int i) {
        int b = this.f26867d.mo5743b();
        while (this.f26866c < b) {
            this.f26865b[this.f26866c] = (byte) 0;
            this.f26866c++;
        }
        this.f26867d.mo5740a(this.f26865b, 0, this.f26864a, 0);
        System.arraycopy(this.f26864a, 0, bArr, i, this.f26868e);
        mo5767c();
        return this.f26868e;
    }

    /* renamed from: c */
    public void mo5767c() {
        for (int i = 0; i < this.f26865b.length; i++) {
            this.f26865b[i] = (byte) 0;
        }
        this.f26866c = 0;
        this.f26867d.mo5744c();
    }
}
