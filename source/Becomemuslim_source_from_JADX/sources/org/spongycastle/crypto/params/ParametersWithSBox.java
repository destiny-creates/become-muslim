package org.spongycastle.crypto.params;

import org.spongycastle.crypto.CipherParameters;

public class ParametersWithSBox implements CipherParameters {
    /* renamed from: a */
    private CipherParameters f27137a;
    /* renamed from: b */
    private byte[] f27138b;

    public ParametersWithSBox(CipherParameters cipherParameters, byte[] bArr) {
        this.f27137a = cipherParameters;
        this.f27138b = bArr;
    }

    /* renamed from: a */
    public byte[] m35699a() {
        return this.f27138b;
    }

    /* renamed from: b */
    public CipherParameters m35700b() {
        return this.f27137a;
    }
}
