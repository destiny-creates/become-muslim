package org.spongycastle.crypto.params;

public class IESWithCipherParameters extends IESParameters {
    /* renamed from: a */
    private int f31753a;

    public IESWithCipherParameters(byte[] bArr, byte[] bArr2, int i, int i2) {
        super(bArr, bArr2, i);
        this.f31753a = i2;
    }

    /* renamed from: d */
    public int m40795d() {
        return this.f31753a;
    }
}
