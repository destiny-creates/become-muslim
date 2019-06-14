package org.spongycastle.jcajce.provider.asymmetric;

import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

public class X509 {

    public static class Mappings extends AsymmetricAlgorithmProvider {
        /* renamed from: a */
        public void mo5864a(ConfigurableProvider configurableProvider) {
            configurableProvider.mo5883a("KeyFactory.X.509", "org.spongycastle.jcajce.provider.asymmetric.x509.KeyFactory");
            configurableProvider.mo5883a("Alg.Alias.KeyFactory.X509", "X.509");
            configurableProvider.mo5883a("CertificateFactory.X.509", "org.spongycastle.jcajce.provider.asymmetric.x509.CertificateFactory");
            configurableProvider.mo5883a("Alg.Alias.CertificateFactory.X509", "X.509");
        }
    }
}
