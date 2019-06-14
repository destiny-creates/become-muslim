package org.spongycastle.crypto.generators;

import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;

public class DSTU4145KeyPairGenerator extends ECKeyPairGenerator {
    /* renamed from: a */
    public AsymmetricCipherKeyPair mo5755a() {
        AsymmetricCipherKeyPair a = super.mo5755a();
        ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) a.m27281a();
        return new AsymmetricCipherKeyPair(new ECPublicKeyParameters(eCPublicKeyParameters.m43370c().mo6572t(), eCPublicKeyParameters.m40792b()), (ECPrivateKeyParameters) a.m27282b());
    }
}
