package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.DSAPublicKeyParameters;
import org.spongycastle.crypto.signers.DSASigner;
import org.spongycastle.crypto.signers.HMacDSAKCalculator;

public class TlsDSSSigner extends TlsDSASigner {
    /* renamed from: a */
    protected short mo6821a() {
        return (short) 2;
    }

    /* renamed from: a */
    public boolean mo6497a(AsymmetricKeyParameter asymmetricKeyParameter) {
        return asymmetricKeyParameter instanceof DSAPublicKeyParameters;
    }

    /* renamed from: a */
    protected DSA mo6820a(short s) {
        return new DSASigner(new HMacDSAKCalculator(TlsUtils.m27855c(s)));
    }
}
