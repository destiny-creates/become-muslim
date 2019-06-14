package org.spongycastle.jcajce.provider.asymmetric;

import org.spongycastle.asn1.ua.UAObjectIdentifiers;
import org.spongycastle.jcajce.provider.asymmetric.dstu.KeyFactorySpi;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

public class DSTU4145 {

    public static class Mappings extends AsymmetricAlgorithmProvider {
        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            configurableProvider.mo5883a("KeyFactory.DSTU4145", "org.spongycastle.jcajce.provider.asymmetric.dstu.KeyFactorySpi");
            configurableProvider.mo5883a("Alg.Alias.KeyFactory.DSTU-4145-2002", "DSTU4145");
            configurableProvider.mo5883a("Alg.Alias.KeyFactory.DSTU4145-3410", "DSTU4145");
            m36125a(configurableProvider, UAObjectIdentifiers.f22013b, "DSTU4145", new KeyFactorySpi());
            m36124a(configurableProvider, UAObjectIdentifiers.f22013b, "DSTU4145");
            m36125a(configurableProvider, UAObjectIdentifiers.f22014c, "DSTU4145", new KeyFactorySpi());
            m36124a(configurableProvider, UAObjectIdentifiers.f22014c, "DSTU4145");
            configurableProvider.mo5883a("KeyPairGenerator.DSTU4145", "org.spongycastle.jcajce.provider.asymmetric.dstu.KeyPairGeneratorSpi");
            configurableProvider.mo5883a("Alg.Alias.KeyPairGenerator.DSTU-4145", "DSTU4145");
            configurableProvider.mo5883a("Alg.Alias.KeyPairGenerator.DSTU-4145-2002", "DSTU4145");
            configurableProvider.mo5883a("Signature.DSTU4145", "org.spongycastle.jcajce.provider.asymmetric.dstu.SignatureSpi");
            configurableProvider.mo5883a("Alg.Alias.Signature.DSTU-4145", "DSTU4145");
            configurableProvider.mo5883a("Alg.Alias.Signature.DSTU-4145-2002", "DSTU4145");
            m36123a(configurableProvider, "GOST3411", "DSTU4145LE", "org.spongycastle.jcajce.provider.asymmetric.dstu.SignatureSpiLe", UAObjectIdentifiers.f22013b);
            m36123a(configurableProvider, "GOST3411", "DSTU4145", "org.spongycastle.jcajce.provider.asymmetric.dstu.SignatureSpi", UAObjectIdentifiers.f22014c);
        }
    }
}
