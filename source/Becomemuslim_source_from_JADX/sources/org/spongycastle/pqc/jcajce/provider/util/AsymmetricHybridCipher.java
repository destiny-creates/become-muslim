package org.spongycastle.pqc.jcajce.provider.util;

import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.ShortBufferException;

public abstract class AsymmetricHybridCipher extends CipherSpiExt {
    /* renamed from: a */
    public final int mo5918a() {
        return 0;
    }

    /* renamed from: a */
    protected abstract int mo6581a(int i);

    /* renamed from: a */
    protected final void mo5920a(String str) {
    }

    /* renamed from: a */
    protected abstract void mo6583a(Key key, AlgorithmParameterSpec algorithmParameterSpec);

    /* renamed from: a */
    protected abstract void mo6584a(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom);

    /* renamed from: a */
    public abstract byte[] mo5921a(byte[] bArr, int i, int i2);

    /* renamed from: b */
    protected abstract int mo6585b(int i);

    /* renamed from: b */
    protected final void mo5923b(String str) {
    }

    /* renamed from: b */
    public final byte[] mo5926b() {
        return null;
    }

    /* renamed from: b */
    public abstract byte[] mo5927b(byte[] bArr, int i, int i2);

    public final int b_(int i) {
        if (this.w_ == 1) {
            return mo6581a(i);
        }
        return mo6585b(i);
    }

    /* renamed from: b */
    public final void mo5925b(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        this.w_ = 1;
        mo6584a(key, algorithmParameterSpec, secureRandom);
    }

    /* renamed from: b */
    public final void mo5924b(Key key, AlgorithmParameterSpec algorithmParameterSpec) {
        this.w_ = 2;
        mo6583a(key, algorithmParameterSpec);
    }

    /* renamed from: a */
    public final int mo5919a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (bArr2.length >= b_(i2)) {
            bArr = mo5921a(bArr, i, i2);
            System.arraycopy(bArr, 0, bArr2, i3, bArr.length);
            return bArr.length;
        }
        throw new ShortBufferException("output");
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
}
