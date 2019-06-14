package org.spongycastle.jcajce.provider.asymmetric;

import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.jcajce.provider.asymmetric.elgamal.KeyFactorySpi;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

public class ElGamal {

    public static class Mappings extends AsymmetricAlgorithmProvider {
        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            configurableProvider.mo5883a("AlgorithmParameterGenerator.ELGAMAL", "org.spongycastle.jcajce.provider.asymmetric.elgamal.AlgorithmParameterGeneratorSpi");
            configurableProvider.mo5883a("AlgorithmParameterGenerator.ElGamal", "org.spongycastle.jcajce.provider.asymmetric.elgamal.AlgorithmParameterGeneratorSpi");
            configurableProvider.mo5883a("AlgorithmParameters.ELGAMAL", "org.spongycastle.jcajce.provider.asymmetric.elgamal.AlgorithmParametersSpi");
            configurableProvider.mo5883a("AlgorithmParameters.ElGamal", "org.spongycastle.jcajce.provider.asymmetric.elgamal.AlgorithmParametersSpi");
            configurableProvider.mo5883a("Cipher.ELGAMAL", "org.spongycastle.jcajce.provider.asymmetric.elgamal.CipherSpi$NoPadding");
            configurableProvider.mo5883a("Cipher.ElGamal", "org.spongycastle.jcajce.provider.asymmetric.elgamal.CipherSpi$NoPadding");
            configurableProvider.mo5883a("Alg.Alias.Cipher.ELGAMAL/ECB/PKCS1PADDING", "ELGAMAL/PKCS1");
            configurableProvider.mo5883a("Alg.Alias.Cipher.ELGAMAL/NONE/PKCS1PADDING", "ELGAMAL/PKCS1");
            configurableProvider.mo5883a("Alg.Alias.Cipher.ELGAMAL/NONE/NOPADDING", "ELGAMAL");
            configurableProvider.mo5883a("Cipher.ELGAMAL/PKCS1", "org.spongycastle.jcajce.provider.asymmetric.elgamal.CipherSpi$PKCS1v1_5Padding");
            configurableProvider.mo5883a("KeyFactory.ELGAMAL", "org.spongycastle.jcajce.provider.asymmetric.elgamal.KeyFactorySpi");
            configurableProvider.mo5883a("KeyFactory.ElGamal", "org.spongycastle.jcajce.provider.asymmetric.elgamal.KeyFactorySpi");
            configurableProvider.mo5883a("KeyPairGenerator.ELGAMAL", "org.spongycastle.jcajce.provider.asymmetric.elgamal.KeyPairGeneratorSpi");
            configurableProvider.mo5883a("KeyPairGenerator.ElGamal", "org.spongycastle.jcajce.provider.asymmetric.elgamal.KeyPairGeneratorSpi");
            m36125a(configurableProvider, OIWObjectIdentifiers.f21833l, "ELGAMAL", new KeyFactorySpi());
            m36124a(configurableProvider, OIWObjectIdentifiers.f21833l, "ELGAMAL");
        }
    }
}
