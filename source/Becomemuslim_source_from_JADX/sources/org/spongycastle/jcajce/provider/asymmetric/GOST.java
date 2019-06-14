package org.spongycastle.jcajce.provider.asymmetric;

import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.jcajce.provider.asymmetric.gost.KeyFactorySpi;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

public class GOST {

    public static class Mappings extends AsymmetricAlgorithmProvider {
        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            configurableProvider.mo5883a("KeyPairGenerator.GOST3410", "org.spongycastle.jcajce.provider.asymmetric.gost.KeyPairGeneratorSpi");
            configurableProvider.mo5883a("Alg.Alias.KeyPairGenerator.GOST-3410", "GOST3410");
            configurableProvider.mo5883a("Alg.Alias.KeyPairGenerator.GOST-3410-94", "GOST3410");
            configurableProvider.mo5883a("KeyFactory.GOST3410", "org.spongycastle.jcajce.provider.asymmetric.gost.KeyFactorySpi");
            configurableProvider.mo5883a("Alg.Alias.KeyFactory.GOST-3410", "GOST3410");
            configurableProvider.mo5883a("Alg.Alias.KeyFactory.GOST-3410-94", "GOST3410");
            configurableProvider.mo5883a("AlgorithmParameters.GOST3410", "org.spongycastle.jcajce.provider.asymmetric.gost.AlgorithmParametersSpi");
            configurableProvider.mo5883a("AlgorithmParameterGenerator.GOST3410", "org.spongycastle.jcajce.provider.asymmetric.gost.AlgorithmParameterGeneratorSpi");
            m36125a(configurableProvider, CryptoProObjectIdentifiers.f21563i, "GOST3410", new KeyFactorySpi());
            m36124a(configurableProvider, CryptoProObjectIdentifiers.f21563i, "GOST3410");
            configurableProvider.mo5883a("Signature.GOST3410", "org.spongycastle.jcajce.provider.asymmetric.gost.SignatureSpi");
            configurableProvider.mo5883a("Alg.Alias.Signature.GOST-3410", "GOST3410");
            configurableProvider.mo5883a("Alg.Alias.Signature.GOST-3410-94", "GOST3410");
            configurableProvider.mo5883a("Alg.Alias.Signature.GOST3411withGOST3410", "GOST3410");
            configurableProvider.mo5883a("Alg.Alias.Signature.GOST3411WITHGOST3410", "GOST3410");
            configurableProvider.mo5883a("Alg.Alias.Signature.GOST3411WithGOST3410", "GOST3410");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Alg.Alias.Signature.");
            stringBuilder.append(CryptoProObjectIdentifiers.f21565k);
            configurableProvider.mo5883a(stringBuilder.toString(), "GOST3410");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameterGenerator.GOST-3410", "GOST3410");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.GOST-3410", "GOST3410");
        }
    }
}
