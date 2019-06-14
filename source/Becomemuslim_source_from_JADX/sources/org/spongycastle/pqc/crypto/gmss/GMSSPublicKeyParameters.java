package org.spongycastle.pqc.crypto.gmss;

public class GMSSPublicKeyParameters extends GMSSKeyParameters {
    /* renamed from: b */
    private byte[] f32708b;

    public GMSSPublicKeyParameters(byte[] bArr, GMSSParameters gMSSParameters) {
        super(false, gMSSParameters);
        this.f32708b = bArr;
    }

    /* renamed from: c */
    public byte[] m43442c() {
        return this.f32708b;
    }
}
