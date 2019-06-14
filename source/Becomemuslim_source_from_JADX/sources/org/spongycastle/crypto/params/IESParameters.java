package org.spongycastle.crypto.params;

import org.spongycastle.crypto.CipherParameters;

public class IESParameters implements CipherParameters {
    /* renamed from: a */
    private byte[] f27104a;
    /* renamed from: b */
    private byte[] f27105b;
    /* renamed from: c */
    private int f27106c;

    public IESParameters(byte[] bArr, byte[] bArr2, int i) {
        this.f27104a = bArr;
        this.f27105b = bArr2;
        this.f27106c = i;
    }

    /* renamed from: a */
    public byte[] m35666a() {
        return this.f27104a;
    }

    /* renamed from: b */
    public byte[] m35667b() {
        return this.f27105b;
    }

    /* renamed from: c */
    public int m35668c() {
        return this.f27106c;
    }
}
