package org.spongycastle.jcajce.provider.asymmetric;

import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.jcajce.provider.asymmetric.dh.KeyFactorySpi;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

public class DH {

    public static class Mappings extends AsymmetricAlgorithmProvider {
        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            configurableProvider.mo5883a("KeyPairGenerator.DH", "org.spongycastle.jcajce.provider.asymmetric.dh.KeyPairGeneratorSpi");
            configurableProvider.mo5883a("Alg.Alias.KeyPairGenerator.DIFFIEHELLMAN", "DH");
            configurableProvider.mo5883a("KeyAgreement.DH", "org.spongycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi");
            configurableProvider.mo5883a("Alg.Alias.KeyAgreement.DIFFIEHELLMAN", "DH");
            configurableProvider.mo5883a("KeyFactory.DH", "org.spongycastle.jcajce.provider.asymmetric.dh.KeyFactorySpi");
            configurableProvider.mo5883a("Alg.Alias.KeyFactory.DIFFIEHELLMAN", "DH");
            configurableProvider.mo5883a("AlgorithmParameters.DH", "org.spongycastle.jcajce.provider.asymmetric.dh.AlgorithmParametersSpi");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameters.DIFFIEHELLMAN", "DH");
            configurableProvider.mo5883a("Alg.Alias.AlgorithmParameterGenerator.DIFFIEHELLMAN", "DH");
            configurableProvider.mo5883a("AlgorithmParameterGenerator.DH", "org.spongycastle.jcajce.provider.asymmetric.dh.AlgorithmParameterGeneratorSpi");
            configurableProvider.mo5883a("Cipher.DHIES", "org.spongycastle.jcajce.provider.asymmetric.dh.IESCipher$IES");
            configurableProvider.mo5883a("Cipher.DHIESwithAES", "org.spongycastle.jcajce.provider.asymmetric.dh.IESCipher$IESwithAES");
            configurableProvider.mo5883a("Cipher.DHIESWITHAES", "org.spongycastle.jcajce.provider.asymmetric.dh.IESCipher$IESwithAES");
            configurableProvider.mo5883a("Cipher.DHIESWITHDESEDE", "org.spongycastle.jcajce.provider.asymmetric.dh.IESCipher$IESwithDESede");
            configurableProvider.mo5883a("Cipher.OLDDHIES", "org.spongycastle.jcajce.provider.asymmetric.dh.IESCipher$OldIES");
            configurableProvider.mo5883a("Cipher.OLDDHIESwithAES", "org.spongycastle.jcajce.provider.asymmetric.dh.IESCipher$OldIESwithAES");
            configurableProvider.mo5883a("Cipher.OLDDHIESWITHAES", "org.spongycastle.jcajce.provider.asymmetric.dh.IESCipher$OldIESwithAES");
            configurableProvider.mo5883a("Cipher.OLDDHIESWITHDESEDE", "org.spongycastle.jcajce.provider.asymmetric.dh.IESCipher$OldIESwithDESede");
            m36125a(configurableProvider, PKCSObjectIdentifiers.f21865q, "DH", new KeyFactorySpi());
            m36125a(configurableProvider, X9ObjectIdentifiers.ab, "DH", new KeyFactorySpi());
        }
    }
}
