package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.signers.ECDSASigner;
import org.spongycastle.crypto.signers.HMacDSAKCalculator;

public class TlsECDSASigner extends TlsDSASigner {
    /* renamed from: a */
    protected short mo6821a() {
        return (short) 3;
    }

    /* renamed from: a */
    public boolean mo6497a(AsymmetricKeyParameter asymmetricKeyParameter) {
        return asymmetricKeyParameter instanceof ECPublicKeyParameters;
    }

    /* renamed from: a */
    protected DSA mo6820a(short s) {
        return new ECDSASigner(new HMacDSAKCalculator(TlsUtils.m27855c(s)));
    }
}
