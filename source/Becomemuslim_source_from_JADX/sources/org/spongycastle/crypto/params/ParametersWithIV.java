package org.spongycastle.crypto.params;

import org.spongycastle.crypto.CipherParameters;

public class ParametersWithIV implements CipherParameters {
    /* renamed from: a */
    private byte[] f27133a;
    /* renamed from: b */
    private CipherParameters f27134b;

    public ParametersWithIV(CipherParameters cipherParameters, byte[] bArr) {
        this(cipherParameters, bArr, 0, bArr.length);
    }

    public ParametersWithIV(CipherParameters cipherParameters, byte[] bArr, int i, int i2) {
        this.f27133a = new byte[i2];
        this.f27134b = cipherParameters;
        System.arraycopy(bArr, i, this.f27133a, 0, i2);
    }

    /* renamed from: a */
    public byte[] m35695a() {
        return this.f27133a;
    }

    /* renamed from: b */
    public CipherParameters m35696b() {
        return this.f27134b;
    }
}
