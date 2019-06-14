package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.engines.DESEngine;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.paddings.BlockCipherPadding;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

public class ISO9797Alg3Mac implements Mac {
    /* renamed from: a */
    private byte[] f26908a;
    /* renamed from: b */
    private byte[] f26909b;
    /* renamed from: c */
    private int f26910c;
    /* renamed from: d */
    private BlockCipher f26911d;
    /* renamed from: e */
    private BlockCipherPadding f26912e;
    /* renamed from: f */
    private int f26913f;
    /* renamed from: g */
    private KeyParameter f26914g;
    /* renamed from: h */
    private KeyParameter f26915h;

    /* renamed from: a */
    public String mo5762a() {
        return "ISO9797Alg3";
    }

    public ISO9797Alg3Mac(BlockCipher blockCipher) {
        this(blockCipher, blockCipher.mo5743b() * 8, null);
    }

    public ISO9797Alg3Mac(BlockCipher blockCipher, BlockCipherPadding blockCipherPadding) {
        this(blockCipher, blockCipher.mo5743b() * 8, blockCipherPadding);
    }

    public ISO9797Alg3Mac(BlockCipher blockCipher, int i, BlockCipherPadding blockCipherPadding) {
        if (i % 8 != 0) {
            throw new IllegalArgumentException("MAC size must be multiple of 8");
        } else if (blockCipher instanceof DESEngine) {
            this.f26911d = new CBCBlockCipher(blockCipher);
            this.f26912e = blockCipherPadding;
            this.f26913f = i / 8;
            this.f26908a = new byte[blockCipher.mo5743b()];
            this.f26909b = new byte[blockCipher.mo5743b()];
            this.f26910c = null;
        } else {
            throw new IllegalArgumentException("cipher must be instance of DESEngine");
        }
    }

    /* renamed from: a */
    public void mo5764a(CipherParameters cipherParameters) {
        KeyParameter keyParameter;
        CipherParameters keyParameter2;
        mo5767c();
        boolean z = cipherParameters instanceof KeyParameter;
        if (!z) {
            if (!(cipherParameters instanceof ParametersWithIV)) {
                throw new IllegalArgumentException("params must be an instance of KeyParameter or ParametersWithIV");
            }
        }
        if (z) {
            keyParameter = (KeyParameter) cipherParameters;
        } else {
            keyParameter = (KeyParameter) ((ParametersWithIV) cipherParameters).m35696b();
        }
        byte[] a = keyParameter.m35685a();
        if (a.length == 16) {
            keyParameter2 = new KeyParameter(a, 0, 8);
            this.f26914g = new KeyParameter(a, 8, 8);
            this.f26915h = keyParameter2;
        } else if (a.length == 24) {
            keyParameter2 = new KeyParameter(a, 0, 8);
            this.f26914g = new KeyParameter(a, 8, 8);
            this.f26915h = new KeyParameter(a, 16, 8);
        } else {
            throw new IllegalArgumentException("Key must be either 112 or 168 bit long");
        }
        if (cipherParameters instanceof ParametersWithIV) {
            this.f26911d.mo5742a(true, new ParametersWithIV(keyParameter2, ((ParametersWithIV) cipherParameters).m35695a()));
        } else {
            this.f26911d.mo5742a(true, keyParameter2);
        }
    }

    /* renamed from: b */
    public int mo5766b() {
        return this.f26913f;
    }

    /* renamed from: a */
    public void mo5763a(byte b) {
        if (this.f26910c == this.f26909b.length) {
            this.f26911d.mo5740a(this.f26909b, 0, this.f26908a, 0);
            this.f26910c = 0;
        }
        byte[] bArr = this.f26909b;
        int i = this.f26910c;
        this.f26910c = i + 1;
        bArr[i] = b;
    }

    /* renamed from: a */
    public void mo5765a(byte[] bArr, int i, int i2) {
        if (i2 >= 0) {
            int b = this.f26911d.mo5743b();
            int i3 = b - this.f26910c;
            if (i2 > i3) {
                System.arraycopy(bArr, i, this.f26909b, this.f26910c, i3);
                this.f26911d.mo5740a(this.f26909b, 0, this.f26908a, 0);
                this.f26910c = 0;
                i2 -= i3;
                i += i3;
                while (i2 > b) {
                    this.f26911d.mo5740a(bArr, i, this.f26908a, 0);
                    i2 -= b;
                    i += b;
                }
            }
            System.arraycopy(bArr, i, this.f26909b, this.f26910c, i2);
            this.f26910c += i2;
            return;
        }
        throw new IllegalArgumentException("Can't have a negative input length!");
    }

    /* renamed from: a */
    public int mo5761a(byte[] bArr, int i) {
        int b = this.f26911d.mo5743b();
        if (this.f26912e == null) {
            while (this.f26910c < b) {
                this.f26909b[this.f26910c] = (byte) 0;
                this.f26910c++;
            }
        } else {
            if (this.f26910c == b) {
                this.f26911d.mo5740a(this.f26909b, 0, this.f26908a, 0);
                this.f26910c = 0;
            }
            this.f26912e.mo5784a(this.f26909b, this.f26910c);
        }
        this.f26911d.mo5740a(this.f26909b, 0, this.f26908a, 0);
        DESEngine dESEngine = new DESEngine();
        dESEngine.mo5742a(false, this.f26914g);
        dESEngine.mo5740a(this.f26908a, 0, this.f26908a, 0);
        dESEngine.mo5742a(true, this.f26915h);
        dESEngine.mo5740a(this.f26908a, 0, this.f26908a, 0);
        System.arraycopy(this.f26908a, 0, bArr, i, this.f26913f);
        mo5767c();
        return this.f26913f;
    }

    /* renamed from: c */
    public void mo5767c() {
        for (int i = 0; i < this.f26909b.length; i++) {
            this.f26909b[i] = (byte) 0;
        }
        this.f26910c = 0;
        this.f26911d.mo5744c();
    }
}
