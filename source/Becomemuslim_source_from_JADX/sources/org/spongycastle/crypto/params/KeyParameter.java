package org.spongycastle.crypto.params;

import org.spongycastle.crypto.CipherParameters;

public class KeyParameter implements CipherParameters {
    /* renamed from: a */
    private byte[] f27123a;

    public KeyParameter(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public KeyParameter(byte[] bArr, int i, int i2) {
        this.f27123a = new byte[i2];
        System.arraycopy(bArr, i, this.f27123a, 0, i2);
    }

    /* renamed from: a */
    public byte[] m35685a() {
        return this.f27123a;
    }
}
