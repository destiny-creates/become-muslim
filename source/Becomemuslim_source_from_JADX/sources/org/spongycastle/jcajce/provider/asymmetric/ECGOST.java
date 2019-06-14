package org.spongycastle.jcajce.provider.asymmetric;

import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.jcajce.provider.asymmetric.ecgost.KeyFactorySpi;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

public class ECGOST {

    public static class Mappings extends AsymmetricAlgorithmProvider {
        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            configurableProvider.mo5883a("KeyFactory.ECGOST3410", "org.spongycastle.jcajce.provider.asymmetric.ecgost.KeyFactorySpi");
            configurableProvider.mo5883a("Alg.Alias.KeyFactory.GOST-3410-2001", "ECGOST3410");
            configurableProvider.mo5883a("Alg.Alias.KeyFactory.ECGOST-3410", "ECGOST3410");
            m36125a(configurableProvider, CryptoProObjectIdentifiers.f21564j, "ECGOST3410", new KeyFactorySpi());
            m36124a(configurableProvider, CryptoProObjectIdentifiers.f21564j, "ECGOST3410");
            configurableProvider.mo5883a("KeyPairGenerator.ECGOST3410", "org.spongycastle.jcajce.provider.asymmetric.ecgost.KeyPairGeneratorSpi");
            configurableProvider.mo5883a("Alg.Alias.KeyPairGenerator.ECGOST-3410", "ECGOST3410");
            configurableProvider.mo5883a("Alg.Alias.KeyPairGenerator.GOST-3410-2001", "ECGOST3410");
            configurableProvider.mo5883a("Signature.ECGOST3410", "org.spongycastle.jcajce.provider.asymmetric.ecgost.SignatureSpi");
            configurableProvider.mo5883a("Alg.Alias.Signature.ECGOST-3410", "ECGOST3410");
            configurableProvider.mo5883a("Alg.Alias.Signature.GOST-3410-2001", "ECGOST3410");
            m36123a(configurableProvider, "GOST3411", "ECGOST3410", "org.spongycastle.jcajce.provider.asymmetric.ecgost.SignatureSpi", CryptoProObjectIdentifiers.f21566l);
        }
    }
}
