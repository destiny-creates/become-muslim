package org.spongycastle.pqc.jcajce.provider;

import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;
import org.spongycastle.pqc.jcajce.provider.rainbow.RainbowKeyFactorySpi;

public class Rainbow {

    public static class Mappings extends AsymmetricAlgorithmProvider {
        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            configurableProvider.mo5883a("KeyFactory.Rainbow", "org.spongycastle.pqc.jcajce.provider.rainbow.RainbowKeyFactorySpi");
            configurableProvider.mo5883a("KeyPairGenerator.Rainbow", "org.spongycastle.pqc.jcajce.provider.rainbow.RainbowKeyPairGeneratorSpi");
            m36123a(configurableProvider, "SHA224", "Rainbow", "org.spongycastle.pqc.jcajce.provider.rainbow.SignatureSpi$withSha224", PQCObjectIdentifiers.f23166c);
            m36123a(configurableProvider, "SHA256", "Rainbow", "org.spongycastle.pqc.jcajce.provider.rainbow.SignatureSpi$withSha256", PQCObjectIdentifiers.f23167d);
            m36123a(configurableProvider, "SHA384", "Rainbow", "org.spongycastle.pqc.jcajce.provider.rainbow.SignatureSpi$withSha384", PQCObjectIdentifiers.f23168e);
            m36123a(configurableProvider, "SHA512", "Rainbow", "org.spongycastle.pqc.jcajce.provider.rainbow.SignatureSpi$withSha512", PQCObjectIdentifiers.f23169f);
            m36125a(configurableProvider, PQCObjectIdentifiers.f23164a, "Rainbow", new RainbowKeyFactorySpi());
            m36124a(configurableProvider, PQCObjectIdentifiers.f23164a, "Rainbow");
        }
    }
}
