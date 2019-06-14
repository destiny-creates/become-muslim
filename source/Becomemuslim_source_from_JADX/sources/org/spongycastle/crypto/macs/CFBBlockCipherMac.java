package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.paddings.BlockCipherPadding;

public class CFBBlockCipherMac implements Mac {
    /* renamed from: a */
    private byte[] f26875a;
    /* renamed from: b */
    private byte[] f26876b;
    /* renamed from: c */
    private int f26877c;
    /* renamed from: d */
    private MacCFBBlockCipher f26878d;
    /* renamed from: e */
    private BlockCipherPadding f26879e;
    /* renamed from: f */
    private int f26880f;

    public CFBBlockCipherMac(BlockCipher blockCipher) {
        this(blockCipher, 8, (blockCipher.mo5743b() * 8) / 2, null);
    }

    public CFBBlockCipherMac(BlockCipher blockCipher, int i, int i2, BlockCipherPadding blockCipherPadding) {
        this.f26879e = null;
        if (i2 % 8 == 0) {
            this.f26875a = new byte[blockCipher.mo5743b()];
            this.f26878d = new MacCFBBlockCipher(blockCipher, i);
            this.f26879e = blockCipherPadding;
            this.f26880f = i2 / 8;
            this.f26876b = new byte[this.f26878d.m27464b()];
            this.f26877c = null;
            return;
        }
        throw new IllegalArgumentException("MAC size must be multiple of 8");
    }

    /* renamed from: a */
    public String mo5762a() {
        return this.f26878d.m27461a();
    }

    /* renamed from: a */
    public void mo5764a(CipherParameters cipherParameters) {
        mo5767c();
        this.f26878d.m27462a(cipherParameters);
    }

    /* renamed from: b */
    public int mo5766b() {
        return this.f26880f;
    }

    /* renamed from: a */
    public void mo5763a(byte b) {
        if (this.f26877c == this.f26876b.length) {
            this.f26878d.m27460a(this.f26876b, 0, this.f26875a, 0);
            this.f26877c = 0;
        }
        byte[] bArr = this.f26876b;
        int i = this.f26877c;
        this.f26877c = i + 1;
        bArr[i] = b;
    }

    /* renamed from: a */
    public void mo5765a(byte[] bArr, int i, int i2) {
        if (i2 >= 0) {
            int b = this.f26878d.m27464b();
            int i3 = b - this.f26877c;
            if (i2 > i3) {
                System.arraycopy(bArr, i, this.f26876b, this.f26877c, i3);
                this.f26878d.m27460a(this.f26876b, 0, this.f26875a, 0);
                this.f26877c = 0;
                i2 -= i3;
                i += i3;
                while (i2 > b) {
                    this.f26878d.m27460a(bArr, i, this.f26875a, 0);
                    i2 -= b;
                    i += b;
                }
            }
            System.arraycopy(bArr, i, this.f26876b, this.f26877c, i2);
            this.f26877c += i2;
            return;
        }
        throw new IllegalArgumentException("Can't have a negative input length!");
    }

    /* renamed from: a */
    public int mo5761a(byte[] bArr, int i) {
        int b = this.f26878d.m27464b();
        if (this.f26879e == null) {
            while (this.f26877c < b) {
                this.f26876b[this.f26877c] = (byte) 0;
                this.f26877c++;
            }
        } else {
            this.f26879e.mo5784a(this.f26876b, this.f26877c);
        }
        this.f26878d.m27460a(this.f26876b, 0, this.f26875a, 0);
        this.f26878d.m27463a(this.f26875a);
        System.arraycopy(this.f26875a, 0, bArr, i, this.f26880f);
        mo5767c();
        return this.f26880f;
    }

    /* renamed from: c */
    public void mo5767c() {
        for (int i = 0; i < this.f26876b.length; i++) {
            this.f26876b[i] = (byte) 0;
        }
        this.f26877c = 0;
        this.f26878d.m27465c();
    }
}
