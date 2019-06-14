package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.paddings.BlockCipherPadding;

public class CBCBlockCipherMac implements Mac {
    /* renamed from: a */
    private byte[] f26869a;
    /* renamed from: b */
    private byte[] f26870b;
    /* renamed from: c */
    private int f26871c;
    /* renamed from: d */
    private BlockCipher f26872d;
    /* renamed from: e */
    private BlockCipherPadding f26873e;
    /* renamed from: f */
    private int f26874f;

    public CBCBlockCipherMac(BlockCipher blockCipher) {
        this(blockCipher, (blockCipher.mo5743b() * 8) / 2, null);
    }

    public CBCBlockCipherMac(BlockCipher blockCipher, int i) {
        this(blockCipher, i, null);
    }

    public CBCBlockCipherMac(BlockCipher blockCipher, int i, BlockCipherPadding blockCipherPadding) {
        if (i % 8 == 0) {
            this.f26872d = new CBCBlockCipher(blockCipher);
            this.f26873e = blockCipherPadding;
            this.f26874f = i / 8;
            this.f26869a = new byte[blockCipher.mo5743b()];
            this.f26870b = new byte[blockCipher.mo5743b()];
            this.f26871c = null;
            return;
        }
        throw new IllegalArgumentException("MAC size must be multiple of 8");
    }

    /* renamed from: a */
    public String mo5762a() {
        return this.f26872d.mo5741a();
    }

    /* renamed from: a */
    public void mo5764a(CipherParameters cipherParameters) {
        mo5767c();
        this.f26872d.mo5742a(true, cipherParameters);
    }

    /* renamed from: b */
    public int mo5766b() {
        return this.f26874f;
    }

    /* renamed from: a */
    public void mo5763a(byte b) {
        if (this.f26871c == this.f26870b.length) {
            this.f26872d.mo5740a(this.f26870b, 0, this.f26869a, 0);
            this.f26871c = 0;
        }
        byte[] bArr = this.f26870b;
        int i = this.f26871c;
        this.f26871c = i + 1;
        bArr[i] = b;
    }

    /* renamed from: a */
    public void mo5765a(byte[] bArr, int i, int i2) {
        if (i2 >= 0) {
            int b = this.f26872d.mo5743b();
            int i3 = b - this.f26871c;
            if (i2 > i3) {
                System.arraycopy(bArr, i, this.f26870b, this.f26871c, i3);
                this.f26872d.mo5740a(this.f26870b, 0, this.f26869a, 0);
                this.f26871c = 0;
                i2 -= i3;
                i += i3;
                while (i2 > b) {
                    this.f26872d.mo5740a(bArr, i, this.f26869a, 0);
                    i2 -= b;
                    i += b;
                }
            }
            System.arraycopy(bArr, i, this.f26870b, this.f26871c, i2);
            this.f26871c += i2;
            return;
        }
        throw new IllegalArgumentException("Can't have a negative input length!");
    }

    /* renamed from: a */
    public int mo5761a(byte[] bArr, int i) {
        int b = this.f26872d.mo5743b();
        if (this.f26873e == null) {
            while (this.f26871c < b) {
                this.f26870b[this.f26871c] = (byte) 0;
                this.f26871c++;
            }
        } else {
            if (this.f26871c == b) {
                this.f26872d.mo5740a(this.f26870b, 0, this.f26869a, 0);
                this.f26871c = 0;
            }
            this.f26873e.mo5784a(this.f26870b, this.f26871c);
        }
        this.f26872d.mo5740a(this.f26870b, 0, this.f26869a, 0);
        System.arraycopy(this.f26869a, 0, bArr, i, this.f26874f);
        mo5767c();
        return this.f26874f;
    }

    /* renamed from: c */
    public void mo5767c() {
        for (int i = 0; i < this.f26870b.length; i++) {
            this.f26870b[i] = (byte) 0;
        }
        this.f26871c = 0;
        this.f26872d.mo5744c();
    }
}
