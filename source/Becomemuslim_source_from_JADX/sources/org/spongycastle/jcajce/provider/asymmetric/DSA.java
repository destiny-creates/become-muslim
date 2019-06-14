package org.spongycastle.jcajce.provider.asymmetric;

import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.jcajce.provider.asymmetric.dsa.DSAUtil;
import org.spongycastle.jcajce.provider.asymmetric.dsa.KeyFactorySpi;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;

public class DSA {

    public static class Mappings extends AsymmetricAlgorithmProvider {
        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            configurableProvider.mo5883a("AlgorithmParameters.DSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.AlgorithmParametersSpi");
            configurableProvider.mo5883a("AlgorithmParameterGenerator.DSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.AlgorithmParameterGeneratorSpi");
            configurableProvider.mo5883a("KeyPairGenerator.DSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.KeyPairGeneratorSpi");
            configurableProvider.mo5883a("KeyFactory.DSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.KeyFactorySpi");
            configurableProvider.mo5883a("Signature.DSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$stdDSA");
            configurableProvider.mo5883a("Signature.NONEWITHDSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$noneDSA");
            configurableProvider.mo5883a("Alg.Alias.Signature.RAWDSA", "NONEWITHDSA");
            configurableProvider.mo5883a("Signature.DETDSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA");
            configurableProvider.mo5883a("Signature.SHA1WITHDETDSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA");
            configurableProvider.mo5883a("Signature.SHA224WITHDETDSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA224");
            configurableProvider.mo5883a("Signature.SHA256WITHDETDSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA256");
            configurableProvider.mo5883a("Signature.SHA384WITHDETDSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA384");
            configurableProvider.mo5883a("Signature.SHA512WITHDETDSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA512");
            m36123a(configurableProvider, "SHA224", "DSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsa224", NISTObjectIdentifiers.f21776L);
            m36123a(configurableProvider, "SHA256", "DSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsa256", NISTObjectIdentifiers.f21777M);
            m36123a(configurableProvider, "SHA384", "DSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsa384", NISTObjectIdentifiers.f21778N);
            m36123a(configurableProvider, "SHA512", "DSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsa512", NISTObjectIdentifiers.f21779O);
            configurableProvider.mo5883a("Alg.Alias.Signature.SHA/DSA", "DSA");
            configurableProvider.mo5883a("Alg.Alias.Signature.SHA1withDSA", "DSA");
            configurableProvider.mo5883a("Alg.Alias.Signature.SHA1WITHDSA", "DSA");
            configurableProvider.mo5883a("Alg.Alias.Signature.1.3.14.3.2.26with1.2.840.10040.4.1", "DSA");
            configurableProvider.mo5883a("Alg.Alias.Signature.1.3.14.3.2.26with1.2.840.10040.4.3", "DSA");
            configurableProvider.mo5883a("Alg.Alias.Signature.DSAwithSHA1", "DSA");
            configurableProvider.mo5883a("Alg.Alias.Signature.DSAWITHSHA1", "DSA");
            configurableProvider.mo5883a("Alg.Alias.Signature.SHA1WithDSA", "DSA");
            configurableProvider.mo5883a("Alg.Alias.Signature.DSAWithSHA1", "DSA");
            configurableProvider.mo5883a("Alg.Alias.Signature.1.2.840.10040.4.3", "DSA");
            AsymmetricKeyInfoConverter keyFactorySpi = new KeyFactorySpi();
            for (int i = 0; i != DSAUtil.f22734a.length; i++) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Alg.Alias.Signature.");
                stringBuilder.append(DSAUtil.f22734a[i]);
                configurableProvider.mo5883a(stringBuilder.toString(), "DSA");
                m36125a(configurableProvider, DSAUtil.f22734a[i], "DSA", keyFactorySpi);
                m36124a(configurableProvider, DSAUtil.f22734a[i], "DSA");
            }
        }
    }
}
