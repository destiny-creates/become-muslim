package org.spongycastle.pqc.jcajce.provider.util;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.CipherSpi;

public abstract class CipherSpiExt extends CipherSpi {
    protected int w_;

    /* renamed from: a */
    public abstract int mo5918a();

    /* renamed from: a */
    public abstract int mo6582a(Key key);

    /* renamed from: a */
    public abstract int mo5919a(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

    /* renamed from: a */
    protected abstract void mo5920a(String str);

    /* renamed from: a */
    public abstract byte[] mo5921a(byte[] bArr, int i, int i2);

    /* renamed from: b */
    public abstract int mo5922b(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

    /* renamed from: b */
    protected abstract void mo5923b(String str);

    /* renamed from: b */
    public abstract void mo5924b(Key key, AlgorithmParameterSpec algorithmParameterSpec);

    /* renamed from: b */
    public abstract void mo5925b(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom);

    /* renamed from: b */
    public abstract byte[] mo5926b();

    /* renamed from: b */
    public abstract byte[] mo5927b(byte[] bArr, int i, int i2);

    public abstract int b_(int i);

    protected final AlgorithmParameters engineGetParameters() {
        return null;
    }

    protected final void engineInit(int i, Key key, SecureRandom secureRandom) {
        try {
            engineInit(i, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (int i2) {
            throw new InvalidParameterException(i2.getMessage());
        }
    }

    protected final void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) {
        if (algorithmParameters == null) {
            engineInit(i, key, secureRandom);
        } else {
            engineInit(i, key, (AlgorithmParameterSpec) null, secureRandom);
        }
    }

    protected void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        if (algorithmParameterSpec != null) {
            if (!(algorithmParameterSpec instanceof AlgorithmParameterSpec)) {
                throw new InvalidAlgorithmParameterException();
            }
        }
        if (key == null || !(key instanceof Key)) {
            throw new InvalidKeyException();
        }
        this.w_ = i;
        if (i == 1) {
            mo5925b(key, algorithmParameterSpec, secureRandom);
        } else if (i == 2) {
            mo5924b(key, algorithmParameterSpec);
        }
    }

    protected final byte[] engineDoFinal(byte[] bArr, int i, int i2) {
        return mo5927b(bArr, i, i2);
    }

    protected final int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        return mo5922b(bArr, i, i2, bArr2, i3);
    }

    protected final int engineGetBlockSize() {
        return mo5918a();
    }

    protected final int engineGetKeySize(Key key) {
        if (key instanceof Key) {
            return mo6582a(key);
        }
        throw new InvalidKeyException("Unsupported key.");
    }

    protected final byte[] engineGetIV() {
        return mo5926b();
    }

    protected final int engineGetOutputSize(int i) {
        return b_(i);
    }

    protected final void engineSetMode(String str) {
        mo5920a(str);
    }

    protected final void engineSetPadding(String str) {
        mo5923b(str);
    }

    protected final byte[] engineUpdate(byte[] bArr, int i, int i2) {
        return mo5921a(bArr, i, i2);
    }

    protected final int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        return mo5919a(bArr, i, i2, bArr2, i3);
    }
}
