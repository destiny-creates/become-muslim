package org.spongycastle.crypto.params;

public class DSAKeyParameters extends AsymmetricKeyParameter {
    /* renamed from: b */
    private DSAParameters f31748b;

    public DSAKeyParameters(boolean z, DSAParameters dSAParameters) {
        super(z);
        this.f31748b = dSAParameters;
    }

    /* renamed from: b */
    public DSAParameters m40791b() {
        return this.f31748b;
    }
}
