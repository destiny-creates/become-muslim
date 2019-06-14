package org.spongycastle.crypto.params;

public class ECKeyParameters extends AsymmetricKeyParameter {
    /* renamed from: b */
    ECDomainParameters f31749b;

    protected ECKeyParameters(boolean z, ECDomainParameters eCDomainParameters) {
        super(z);
        this.f31749b = eCDomainParameters;
    }

    /* renamed from: b */
    public ECDomainParameters m40792b() {
        return this.f31749b;
    }
}
