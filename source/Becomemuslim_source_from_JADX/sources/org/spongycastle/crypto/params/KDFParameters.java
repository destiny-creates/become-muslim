package org.spongycastle.crypto.params;

import org.spongycastle.crypto.DerivationParameters;

public class KDFParameters implements DerivationParameters {
    /* renamed from: a */
    byte[] f27121a;
    /* renamed from: b */
    byte[] f27122b;

    public KDFParameters(byte[] bArr, byte[] bArr2) {
        this.f27122b = bArr;
        this.f27121a = bArr2;
    }

    /* renamed from: a */
    public byte[] m35683a() {
        return this.f27122b;
    }

    /* renamed from: b */
    public byte[] m35684b() {
        return this.f27121a;
    }
}
