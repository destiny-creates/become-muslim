package org.spongycastle.pqc.jcajce.provider.util;

import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;

public abstract class AsymmetricBlockCipher extends CipherSpiExt {
    /* renamed from: a */
    protected ByteArrayOutputStream f27859a = new ByteArrayOutputStream();
    /* renamed from: c */
    protected int f27860c;
    protected int x_;

    /* renamed from: a */
    protected final void mo5920a(String str) {
    }

    /* renamed from: a */
    protected abstract void mo6586a(Key key, AlgorithmParameterSpec algorithmParameterSpec);

    /* renamed from: a */
    protected abstract void mo6587a(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom);

    /* renamed from: a */
    protected abstract byte[] mo6588a(byte[] bArr);

    /* renamed from: b */
    protected final void mo5923b(String str) {
    }

    /* renamed from: b */
    public final byte[] mo5926b() {
        return null;
    }

    /* renamed from: b */
    protected abstract byte[] mo6589b(byte[] bArr);

    /* renamed from: a */
    public final int mo5918a() {
        return this.w_ == 1 ? this.x_ : this.f27860c;
    }

    public final int b_(int i) {
        i += this.f27859a.size();
        int a = mo5918a();
        return i > a ? 0 : a;
    }

    /* renamed from: b */
    public final void mo5925b(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        this.w_ = 1;
        mo6587a(key, algorithmParameterSpec, secureRandom);
    }

    /* renamed from: b */
    public final void mo5924b(Key key, AlgorithmParameterSpec algorithmParameterSpec) {
        this.w_ = 2;
        mo6586a(key, algorithmParameterSpec);
    }

    /* renamed from: a */
    public final byte[] mo5921a(byte[] bArr, int i, int i2) {
        if (i2 != 0) {
            this.f27859a.write(bArr, i, i2);
        }
        return new byte[null];
    }

    /* renamed from: a */
    public final int mo5919a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        mo5921a(bArr, i, i2);
        return null;
    }

    /* renamed from: b */
    public final byte[] mo5927b(byte[] bArr, int i, int i2) {
        m36478b(i2);
        mo5921a(bArr, i, i2);
        bArr = this.f27859a.toByteArray();
        this.f27859a.reset();
        switch (this.w_) {
            case 1:
                return mo6588a(bArr);
            case 2:
                return mo6589b(bArr);
            default:
                return null;
        }
    }

    /* renamed from: b */
    public final int mo5922b(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (bArr2.length >= b_(i2)) {
            bArr = mo5927b(bArr, i, i2);
            System.arraycopy(bArr, 0, bArr2, i3, bArr.length);
            return bArr.length;
        }
        throw new ShortBufferException("Output buffer too short.");
    }

    /* renamed from: b */
    protected void m36478b(int i) {
        i += this.f27859a.size();
        StringBuilder stringBuilder;
        if (this.w_ == 1) {
            if (i > this.x_) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("The length of the plaintext (");
                stringBuilder.append(i);
                stringBuilder.append(" bytes) is not supported by ");
                stringBuilder.append("the cipher (max. ");
                stringBuilder.append(this.x_);
                stringBuilder.append(" bytes).");
                throw new IllegalBlockSizeException(stringBuilder.toString());
            }
        } else if (this.w_ != 2) {
        } else {
            if (i != this.f27860c) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Illegal ciphertext length (expected ");
                stringBuilder.append(this.f27860c);
                stringBuilder.append(" bytes, was ");
                stringBuilder.append(i);
                stringBuilder.append(" bytes).");
                throw new IllegalBlockSizeException(stringBuilder.toString());
            }
        }
    }
}
