package org.spongycastle.jcajce;

import org.spongycastle.crypto.PBEParametersGenerator;

public class PKCS12Key implements PBKDFKey {
    /* renamed from: a */
    private final char[] f27363a;
    /* renamed from: b */
    private final boolean f27364b;

    public String getAlgorithm() {
        return "PKCS12";
    }

    public String getFormat() {
        return "PKCS12";
    }

    public PKCS12Key(char[] cArr, boolean z) {
        this.f27363a = new char[cArr.length];
        this.f27364b = z;
        System.arraycopy(cArr, 0, this.f27363a, 0, cArr.length);
    }

    public char[] getPassword() {
        return this.f27363a;
    }

    public byte[] getEncoded() {
        if (this.f27364b && this.f27363a.length == 0) {
            return new byte[2];
        }
        return PBEParametersGenerator.m27336c(this.f27363a);
    }
}
