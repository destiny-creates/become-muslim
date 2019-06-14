package org.spongycastle.crypto.params;

public class GOST3410KeyParameters extends AsymmetricKeyParameter {
    /* renamed from: b */
    private GOST3410Parameters f31752b;

    public GOST3410KeyParameters(boolean z, GOST3410Parameters gOST3410Parameters) {
        super(z);
        this.f31752b = gOST3410Parameters;
    }

    /* renamed from: b */
    public GOST3410Parameters m40794b() {
        return this.f31752b;
    }
}
