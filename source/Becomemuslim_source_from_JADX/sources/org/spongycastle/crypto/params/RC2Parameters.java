package org.spongycastle.crypto.params;

public class RC2Parameters extends KeyParameter {
    /* renamed from: a */
    private int f31757a;

    public RC2Parameters(byte[] bArr, int i) {
        super(bArr);
        this.f31757a = i;
    }

    /* renamed from: b */
    public int m40799b() {
        return this.f31757a;
    }
}
